package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.FaceOffNoseOcclusionFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.List;

public class StyleChildTransformFilter
  extends VideoFilterBase
{
  private static String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D dstRGB;\nuniform sampler2D warpTex;\nuniform sampler2D maskTex;\n\nuniform float dstWidth;\nuniform float dstHeight;\nuniform float oriWidth;\nuniform float oriHeight;\nuniform float transform[6];\nvoid main()\n{\n    //vec4 warp1 = texture2D(warpTex, textureCoordinate / 2.0);\n    //vec4 warp2 = texture2D(warpTex, textureCoordinate / 2.0 + 0.5);\n    vec4 warp = texture2D(warpTex, textureCoordinate); \n    float warp1 = (warp.x * 255.0 -128.0)/2500.0; \n    float warp2 = (warp.y * 255.0 -128.0)/2500.0; \n    vec4 mask = texture2D(maskTex, textureCoordinate);\n    vec2 nPos = vec2(textureCoordinate.x + warp1 * 0.5 * mask.a, textureCoordinate.y + warp2 * 0.5 * mask.a); // 归一化的坐标\n\n    vec2 oriCoord; // 坐标乘以矩阵，换算到原图坐标\n    vec2 dstCoord = vec2(nPos.x * dstWidth, nPos.y * dstHeight); // 在warp图中绝对坐标\n    oriCoord.x = dstCoord.x * transform[0] + dstCoord.y * transform[1] + transform[2];\n    oriCoord.y = dstCoord.x * transform[3] + dstCoord.y * transform[4] + transform[5];\n    vec4 oriColor = texture2D(inputImageTexture, oriCoord/vec2(oriWidth, oriHeight));//oriTex.sample(qsampler, oriCoord/float2(oriWidth, oriHeight));\n\n    gl_FragColor = oriColor;\n}";
  private static String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform sampler2D moveRegion;\nuniform float sin_t;\nuniform float cos_t;\nuniform float downLevel;\nuniform float mouthScale;\nuniform vec2 lipsCenter;\n\nvec2 getNewPosition(vec2 pos) {\n  //face down\n  vec2 displacedPoint = pos;\n  vec4 diffWeight = texture2D(moveRegion, pos);\n  vec2 faceLiftingVector = vec2(0.0, downLevel);\n  faceLiftingVector = vec2(dot(faceLiftingVector, vec2(cos_t, -sin_t)), dot(faceLiftingVector, vec2(sin_t, cos_t)));\n  displacedPoint = mix(displacedPoint, displacedPoint + faceLiftingVector, diffWeight.r);\n  \n  //mouth xscale\n  vec2 mouthVector = displacedPoint - lipsCenter;\n  float mouthLifting = dot(mouthVector, vec2(cos_t, sin_t)) * (mouthScale - 1.0);\n  displacedPoint = mix(displacedPoint, vec2(cos_t, -sin_t) * mouthLifting + displacedPoint, diffWeight.g);\n  \n  return displacedPoint;\n}\n\nvoid main()\n{\n  vec2 newPos = getNewPosition(position.xy);\n  textureCoordinate = inputTextureCoordinate;\n  gl_Position = vec4(newPos.x * 2.0 - 1.0, newPos.y * 2.0 -1.0,position.zw);\n}";
  private int XCOORD_NUM = 32;
  private int YCOORD_NUM = 32;
  private float faceParam = 0.0F;
  FaceOffNoseOcclusionFilter mFace = new FaceOffNoseOcclusionFilter();
  private float[] mFullscreenVerticesPortrait;
  private float[] mInitTextureCoordinatesPortrait;
  public boolean needCalFaceMoveDownParam = true;
  private int[] tex = new int[3];
  private ReshapeType useMeshType = ReshapeType.NORMAL;
  
  public StyleChildTransformFilter(int paramInt1, int paramInt2, String paramString)
  {
    super(FRAGMENT_SHADER);
    File localFile = new File(paramString);
    if ((localFile.isFile()) && (localFile.exists())) {}
    for (;;)
    {
      if ((GLCapabilities.supportVTF()) && (i != 0))
      {
        updateFilterShader(VERTEX_SHADER, FRAGMENT_SHADER);
        this.useMeshType = ReshapeType.VTF;
        setInitMesh(VideoMaterialUtil.toFlatArray(VideoMaterialUtil.genFullScreenVertices(this.XCOORD_NUM, this.YCOORD_NUM, 0.0F, 1.0F, 0.0F, 1.0F)), VideoMaterialUtil.toFlatArray(VideoMaterialUtil.genFullScreenVertices(this.XCOORD_NUM, this.YCOORD_NUM, 0.0F, 1.0F, 0.0F, 1.0F)));
        this.mFace.loadFaceTex(paramString);
      }
      this.width = paramInt1;
      this.height = paramInt2;
      initParams(paramInt1, paramInt2);
      return;
      i = 0;
    }
  }
  
  private void loadWarpTex(int paramInt, float[] paramArrayOfFloat)
  {
    BenchUtil.benchStart("[child] loadWarpTex");
    GlUtil.loadFloatTexture(paramInt, FloatBuffer.wrap(paramArrayOfFloat), this.width, this.height);
    BenchUtil.benchEnd("[child] loadWarpTex");
  }
  
  public static void setFragmentShader(String paramString) {}
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    this.mFace.ApplyGLSLFilter();
  }
  
  public void calFaceParam(List<PointF> paramList)
  {
    float f;
    if (this.needCalFaceMoveDownParam)
    {
      f = AlgoUtils.getDistance((PointF)paramList.get(84), (PointF)paramList.get(9)) / AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(18));
      if (f >= 0.9F) {
        break label78;
      }
      f = 0.0F;
    }
    for (;;)
    {
      this.faceParam = f;
      this.needCalFaceMoveDownParam = false;
      return;
      label78:
      if (f > 1.0F)
      {
        f = 1.0F;
      }
      else
      {
        f = (f - 0.9F) / (1.0F - 0.9F);
        f = (3.0F - f * 2.0F) * (f * f);
      }
    }
  }
  
  public void calMoveDownParam(List<PointF> paramList, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f1 = (float)Math.atan2(((PointF)paramList.get(53)).y - ((PointF)paramList.get(43)).y, ((PointF)paramList.get(53)).x - ((PointF)paramList.get(43)).x);
    addParam(new UniformParam.FloatParam("sin_t", (float)Math.sin(f1)));
    addParam(new UniformParam.FloatParam("cos_t", (float)Math.cos(f1)));
    addParam(new UniformParam.FloatParam("downLevel", AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(18)) * (16.0F * paramFloat2 / 480.0F) / paramFloat1 / paramInt2));
    paramFloat2 = ((PointF)paramList.get(75)).x;
    f1 = ((PointF)paramList.get(79)).x;
    float f2 = ((PointF)paramList.get(67)).x;
    paramFloat2 = (((PointF)paramList.get(71)).x + (paramFloat2 + f1 + f2)) / 4.0F;
    f1 = ((PointF)paramList.get(75)).y;
    f2 = ((PointF)paramList.get(79)).y;
    float f3 = ((PointF)paramList.get(67)).y;
    f1 = (((PointF)paramList.get(71)).y + (f1 + f2 + f3)) / 4.0F;
    paramList = new float[2];
    paramList[0] = (paramFloat2 / paramFloat1 / paramInt1);
    paramList[1] = (f1 / paramFloat1 / paramInt2);
    addParam(new UniformParam.Float2fParam("lipsCenter", paramList[0], paramList[1]));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    this.mFace.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    if (this.useMeshType == ReshapeType.VTF)
    {
      setPositions(this.mFullscreenVerticesPortrait, false);
      setTexCords(this.mInitTextureCoordinatesPortrait, false);
      setCoordNum((this.YCOORD_NUM * 2 + 1) * this.XCOORD_NUM + 1);
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    }
  }
  
  public void initParams(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.TextureParam("dstRGB", 0, 33986));
    addParam(new UniformParam.TextureParam("warpTex", 0, 33987));
    addParam(new UniformParam.TextureParam("maskTex", 0, 33988));
    addParam(new UniformParam.FloatParam("dstWidth", paramInt1));
    addParam(new UniformParam.FloatParam("dstHeight", paramInt2));
    addParam(new UniformParam.FloatParam("oriWidth", 0.0F));
    addParam(new UniformParam.FloatParam("oriHeight", 0.0F));
    addParam(new UniformParam.Float1sParam("transform", new float[0]));
    if (this.useMeshType == ReshapeType.VTF)
    {
      addParam(new UniformParam.TextureParam("moveRegion", 0, 33988));
      addParam(new UniformParam.FloatParam("sin_t", 0.0F));
      addParam(new UniformParam.FloatParam("cos_t", 0.0F));
      addParam(new UniformParam.FloatParam("downLevel", 0.0F));
      addParam(new UniformParam.FloatParam("mouthScale", 0.94F));
      addParam(new UniformParam.Float2fParam("lipsCenter", 0.0F, 0.0F));
    }
  }
  
  public void render(Frame paramFrame1, Frame paramFrame2)
  {
    BenchUtil.benchStart("[child] render");
    Frame localFrame = FrameBufferCache.getInstance().get(paramFrame1.width, paramFrame1.height);
    if (this.useMeshType == ReshapeType.VTF)
    {
      FrameUtil.clearFrame(localFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame1.width, paramFrame1.height);
      this.mFace.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, localFrame);
      addParam(new UniformParam.TextureParam("moveRegion", localFrame.getTextureId(), 33988));
    }
    addParam(new UniformParam.FloatParam("oriWidth", paramFrame1.width));
    addParam(new UniformParam.FloatParam("oriHeight", paramFrame1.height));
    paramFrame2.bindFrame(-1, paramFrame2.width, paramFrame2.height, 0.0D);
    OnDrawFrameGLSL();
    renderTexture(paramFrame1.getTextureId(), this.width, this.height);
    localFrame.unlock();
    BenchUtil.benchEnd("[child] render");
  }
  
  public void setInitMesh(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.mFullscreenVerticesPortrait = paramArrayOfFloat1;
    this.mInitTextureCoordinatesPortrait = paramArrayOfFloat2;
  }
  
  public void updateMoveDownParam(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    PTDetectInfo localPTDetectInfo = new PTDetectInfo.Builder().facePoints(paramList).build();
    this.mFace.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mFace.updatePreview(localPTDetectInfo);
    calFaceParam(paramList);
    calMoveDownParam(paramList, paramInt1, paramInt2, (float)paramDouble, this.faceParam);
  }
  
  public void updateParams(Bitmap paramBitmap1, Bitmap paramBitmap2, Frame paramFrame, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    GlUtil.loadTexture(this.tex[0], paramBitmap1);
    GlUtil.loadTexture(this.tex[1], paramBitmap2);
    addParam(new UniformParam.TextureParam("dstRGB", this.tex[0], 33986));
    addParam(new UniformParam.TextureParam("warpTex", this.tex[1], 33987));
    addParam(new UniformParam.TextureParam("maskTex", paramFrame.getTextureId(), 33988));
    addParam(new UniformParam.Float1sParam("transform", paramArrayOfFloat1));
    if (this.useMeshType == ReshapeType.VTF)
    {
      int i = 0;
      while (i < this.mInitTextureCoordinatesPortrait.length / 2)
      {
        float f1 = this.mInitTextureCoordinatesPortrait[(i * 2)] * this.width;
        float f2 = this.mInitTextureCoordinatesPortrait[(i * 2 + 1)] * this.height;
        this.mFullscreenVerticesPortrait[(i * 2)] = ((paramArrayOfFloat1[0] * f1 + paramArrayOfFloat1[1] * f2 + paramArrayOfFloat1[2]) / paramInt1);
        this.mFullscreenVerticesPortrait[(i * 2 + 1)] = ((f1 * paramArrayOfFloat1[3] + f2 * paramArrayOfFloat1[4] + paramArrayOfFloat1[5]) / paramInt2);
        i += 1;
      }
      setPositions(this.mFullscreenVerticesPortrait, false);
      updateMoveDownParam(paramList, paramInt1, paramInt2, paramDouble);
      return;
    }
    setPositions(paramArrayOfFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildTransformFilter
 * JD-Core Version:    0.7.0.1
 */