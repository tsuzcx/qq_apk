package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchFaceFilter
  extends VideoFilterBase
{
  private float[] faceVertices = new float[276];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[276];
  private List<List<PointF>> mFaceLists;
  private int mFaceTex;
  private float[] texVertices = new float[276];
  
  public SwitchFaceFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACE_SWITCH));
    initParams();
    this.mFaceLists = new ArrayList();
    this.mFaceTex = -1;
  }
  
  float distanceFrom(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  List<PointF> faceSwapFacePoint(List<PointF> paramList)
  {
    if (paramList.size() != 97) {
      return null;
    }
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    PointF localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(41), (PointF)paramList.get(51));
    double d = 3.141592653589793D + Math.atan2(f1 - f2, f3 + f4);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 19)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    localArrayList.add(paramList.get(90));
    localArrayList.add(paramList.get(91));
    localArrayList.add(paramList.get(92));
    localArrayList.add(paramList.get(93));
    localArrayList.add(paramList.get(94));
    localArrayList.add(paramList.get(95));
    localArrayList.add(paramList.get(96));
    PointF localPointF2 = midBetween((PointF)paramList.get(56), (PointF)paramList.get(62));
    PointF localPointF3 = new PointF();
    f1 = distanceFrom((PointF)paramList.get(9), localPointF2);
    localPointF3.x = (((PointF)paramList.get(9)).x + 2.0F * f1 / 8.0F * (float)Math.sin(0.0F));
    localPointF3.y = (((PointF)paramList.get(9)).y - 2.0F * f1 / 8.0F * (float)Math.cos(0.0F));
    localArrayList.add(localPointF3);
    i = 1;
    while (i < 6)
    {
      localPointF3 = new PointF();
      localPointF3.x = (((PointF)paramList.get(9)).x + (i + 2) * f1 / 8.0F * (float)Math.sin(0.0F));
      localPointF3.y = (((PointF)paramList.get(9)).y - (i + 2) * f1 / 8.0F * (float)Math.cos(0.0F));
      localArrayList.add(localPointF3);
      i += 1;
    }
    localArrayList.add(localPointF2);
    localArrayList.add(paramList.get(83));
    localArrayList.add(paramList.get(84));
    localArrayList.add(midBetween((PointF)paramList.get(89), (PointF)paramList.get(84)));
    localArrayList.add(paramList.get(89));
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    return AlgoUtils.mapPoints(localArrayList, localMatrix);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputGrayTextureCoordinate", SwitchFaceUtil.initMaterialFaceTexCoords(faceSwapFacePoint(SwitchFaceUtil.getFullCoords(SwitchFaceUtil.getGrayCoords(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY))), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(138);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = SwitchFaceUtil.getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY);
    if (!BitmapUtils.isLegal(localBitmap)) {
      return;
    }
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture3", localBitmap, 33987, true));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", 1.0F));
  }
  
  PointF midBetween(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public void renderProcess(Set<Integer> paramSet)
  {
    if ((!paramSet.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value))) || (this.mFaceLists.size() < 2))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      OnDrawFrameGLSL();
      renderTexture(this.mFaceTex, this.width, this.height);
    }
    for (;;)
    {
      return;
      int i;
      List localList;
      if ((this.mFaceLists.size() & 0x1) == 0)
      {
        i = 0;
        while (i < this.mFaceLists.size() / 2)
        {
          localList = SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get(i * 2)));
          paramSet = SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get(i * 2 + 1)));
          localList = faceSwapFacePoint(localList);
          paramSet = faceSwapFacePoint(paramSet);
          VideoMaterial.flipYPoints(localList, (int)(this.height * this.mFaceDetScale));
          VideoMaterial.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(localList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
          setPositions(SwitchFaceUtil.initFacePositions(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          setPositions(SwitchFaceUtil.initFacePositions(localList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          i += 1;
        }
      }
      else
      {
        i = 0;
        while (i < this.mFaceLists.size())
        {
          localList = SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get(i % this.mFaceLists.size())));
          paramSet = SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get((i + 1) % this.mFaceLists.size())));
          localList = faceSwapFacePoint(localList);
          paramSet = faceSwapFacePoint(paramSet);
          VideoMaterial.flipYPoints(localList, (int)(this.height * this.mFaceDetScale));
          VideoMaterial.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(localList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
          setPositions(SwitchFaceUtil.initFacePositions(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          i += 1;
        }
      }
    }
  }
  
  public void setFaceParams(List<List<PointF>> paramList, int paramInt)
  {
    this.mFaceLists = paramList;
    this.mFaceTex = paramInt;
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SwitchFaceFilter
 * JD-Core Version:    0.7.0.1
 */