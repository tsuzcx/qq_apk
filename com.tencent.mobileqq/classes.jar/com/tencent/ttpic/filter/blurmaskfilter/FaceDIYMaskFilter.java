package com.tencent.ttpic.filter.blurmaskfilter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.model.FaceMaskItem;
import com.tencent.ttpic.model.FaceMaskItem.FACE_MASK_TYPE;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.view.RendererUtils;
import java.util.Iterator;
import java.util.List;

public class FaceDIYMaskFilter
  extends VideoFilterBase
  implements BlurMaskFilter.IBlurMaskFactory
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }";
  private static final String TAG = FaceDIYMaskFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n";
  private float[] faceVertices = new float[12];
  private BaseFilter mCopyFilter;
  Bitmap mGrayBitmap;
  private boolean mIsNeedWhiteBg = false;
  private float mMaskBlurStrength = 0.0F;
  private Frame mMaskFrame;
  private String mMaskPath;
  private float mMaskSizeValue = 1.0F;
  private int mOutHeight;
  private int mOutWidth;
  private float[] mVertexs = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float[] sumXy = new float[2];
  
  public FaceDIYMaskFilter()
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }");
    initParams();
  }
  
  public FaceDIYMaskFilter(FaceMaskItem paramFaceMaskItem)
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }");
    if ((paramFaceMaskItem != null) && (paramFaceMaskItem.isValid))
    {
      if ((paramFaceMaskItem.faceMaskType == FaceMaskItem.FACE_MASK_TYPE.SINGLE_MASK.value) && (paramFaceMaskItem.faceMaskImgPath != null)) {
        this.mMaskPath = (paramFaceMaskItem.faceMaskImgPath + "0.png");
      }
      this.mMaskBlurStrength = ((float)paramFaceMaskItem.featherStrength);
      this.mMaskSizeValue = ((float)paramFaceMaskItem.faceMaskSize);
    }
    initParams();
  }
  
  public FaceDIYMaskFilter(String paramString)
  {
    super("attribute vec4 position;\n\nattribute vec4 inputGrayTextureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvoid main() {\n    gl_Position = position;\n    grayTextureCoordinate  = inputGrayTextureCoordinate.xy;\n}\n", " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }");
    this.mMaskPath = paramString;
    initParams();
  }
  
  private Bitmap featherBitmap(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Frame localFrame1 = new Frame(0, RendererUtils.createTexture(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
    localFrame1.width = paramBitmap.getWidth();
    localFrame1.height = paramBitmap.getHeight();
    Object localObject = new GaussinNoMaskFilter(paramFloat);
    ((GaussinNoMaskFilter)localObject).applyFilterChain(false, localFrame1.width, localFrame1.height);
    ((GaussinNoMaskFilter)localObject).updateVideoSize(localFrame1.width, localFrame1.height);
    Frame localFrame2 = new Frame();
    Frame localFrame3 = ((GaussinNoMaskFilter)localObject).RenderProcess(localFrame1, localFrame2);
    ((GaussinNoMaskFilter)localObject).clear();
    localObject = RendererUtils.saveTexture(localFrame3.getTextureId(), paramBitmap.getWidth(), paramBitmap.getHeight());
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    localFrame1.clear();
    RendererUtils.clearTexture(localFrame1.getTextureId());
    localFrame2.clear();
    localFrame3.clear();
    return localObject;
  }
  
  private void normolizedPoints(int paramInt1, int paramInt2)
  {
    int j = this.faceVertices.length / 2;
    int i = 0;
    while (i < j)
    {
      this.faceVertices[(i * 2)] = (this.faceVertices[(i * 2)] / paramInt1 * 2.0F - 1.0F);
      this.faceVertices[(i * 2 + 1)] = (this.faceVertices[(i * 2 + 1)] / paramInt2 * 2.0F - 1.0F);
      i += 1;
    }
  }
  
  private void resizePoints(float paramFloat1, float paramFloat2)
  {
    if ((this.mMaskSizeValue < 0.9D) || (this.mMaskSizeValue > 1.1D))
    {
      int j = this.faceVertices.length / 2;
      int i = 0;
      while (i < j)
      {
        this.faceVertices[(i * 2)] = ((this.faceVertices[(i * 2)] - paramFloat1) * this.mMaskSizeValue + paramFloat1);
        this.faceVertices[(i * 2 + 1)] = ((this.faceVertices[(i * 2 + 1)] - paramFloat2) * this.mMaskSizeValue + paramFloat2);
        i += 1;
      }
    }
  }
  
  private void updateFacePoints(List<PointF> paramList)
  {
    Object localObject = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 3.0F);
    paramList = (PointF)((List)localObject).get(99);
    float f5 = paramList.x;
    float f1 = paramList.y;
    PointF localPointF1 = (PointF)((List)localObject).get(101);
    float f6 = localPointF1.x;
    float f2 = localPointF1.y;
    PointF localPointF2 = (PointF)((List)localObject).get(103);
    float f7 = localPointF2.x;
    float f3 = localPointF2.y;
    localObject = (PointF)((List)localObject).get(105);
    float f8 = ((PointF)localObject).x;
    float f4 = ((PointF)localObject).y;
    f5 = (f6 + (0.0F + f5) + f7 + f8) / 4.0F;
    f1 = (0.0F + f1 + f2 + f3 + f4) / 4.0F;
    this.faceVertices[0] = localPointF2.x;
    this.faceVertices[1] = localPointF2.y;
    this.faceVertices[2] = ((PointF)localObject).x;
    this.faceVertices[3] = ((PointF)localObject).y;
    this.faceVertices[4] = paramList.x;
    this.faceVertices[5] = paramList.y;
    this.faceVertices[6] = localPointF2.x;
    this.faceVertices[7] = localPointF2.y;
    this.faceVertices[8] = paramList.x;
    this.faceVertices[9] = paramList.y;
    this.faceVertices[10] = localPointF1.x;
    this.faceVertices[11] = localPointF1.y;
    resizePoints(f5, f1);
    normolizedPoints((int)(this.mOutWidth * this.mFaceDetScale), (int)(this.mOutHeight * this.mFaceDetScale));
    setPositions(this.faceVertices);
    setCoordNum(6);
  }
  
  private void updateFacePoints2(List<PointF> paramList)
  {
    Object localObject1 = (PointF)paramList.get(0);
    Object localObject2 = (PointF)paramList.get(18);
    float f3 = ((PointF)localObject2).x - ((PointF)localObject1).x;
    float f4 = ((PointF)localObject2).y - ((PointF)localObject1).y;
    if ((f3 < -1.0F) || (f3 > 1.0F))
    {
      int j = (int)(this.mOutWidth * this.mFaceDetScale);
      int k = (int)(this.mOutHeight * this.mFaceDetScale);
      float f2 = (float)Math.sqrt(f3 * f3 + f4 * f4) / 0.6F;
      float f1 = 1.33F * f2 * this.mMaskSizeValue / 2.0F;
      f2 = f2 * this.mMaskSizeValue / 2.0F;
      f3 = (float)Math.atan2(f4, f3);
      f4 = ((PointF)paramList.get(83)).x;
      float f5 = ((PointF)paramList.get(83)).y;
      float f6 = f4 + f2;
      float f7 = f5 + f1;
      this.faceVertices[0] = f6;
      this.faceVertices[1] = f7;
      this.faceVertices[6] = f6;
      this.faceVertices[7] = f7;
      this.faceVertices[2] = (f4 + f2);
      this.faceVertices[3] = (f5 - f1);
      f6 = f4 - f2;
      f7 = f5 - f1;
      this.faceVertices[4] = f6;
      this.faceVertices[5] = f7;
      this.faceVertices[8] = f6;
      this.faceVertices[9] = f7;
      this.faceVertices[10] = (f4 - f2);
      this.faceVertices[11] = (f1 + f5);
      paramList = new Matrix();
      paramList.reset();
      paramList.postTranslate(-f4, -f5);
      paramList.postRotate((float)Math.toDegrees(f3));
      paramList.postTranslate(f4, f5);
      localObject1 = new float[2];
      localObject2 = new float[2];
      i = 0;
      while (i < this.faceVertices.length / 2)
      {
        localObject1[0] = this.faceVertices[(i * 2)];
        localObject1[1] = this.faceVertices[(i * 2 + 1)];
        paramList.mapPoints((float[])localObject2, (float[])localObject1);
        this.faceVertices[(i * 2)] = (localObject2[0] / j * 2.0F - 1.0F);
        this.faceVertices[(i * 2 + 1)] = (localObject2[1] / k * 2.0F - 1.0F);
        i += 1;
      }
      setPositions(this.faceVertices);
      setCoordNum(6);
      return;
    }
    int i = 0;
    while (i < this.faceVertices.length)
    {
      this.faceVertices[i] = 0.0F;
      i += 1;
    }
    setPositions(this.faceVertices);
    setCoordNum(6);
  }
  
  public void apply()
  {
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(6);
    this.mMaskFrame = new Frame();
    this.mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mCopyFilter.apply();
  }
  
  public void clear()
  {
    clearGLSLSelf();
    if (this.mMaskFrame != null) {
      this.mMaskFrame.clear();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.ClearGLSL();
    }
    if ((this.mGrayBitmap != null) && (!this.mGrayBitmap.isRecycled())) {
      this.mGrayBitmap.recycle();
    }
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    addAttribParam("inputGrayTextureCoordinate", this.mVertexs);
  }
  
  public void initParams()
  {
    this.mGrayBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP);
    if (this.mGrayBitmap != null)
    {
      if (this.mMaskPath != null)
      {
        Bitmap localBitmap = loadImg(this.mMaskPath);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          this.mGrayBitmap.recycle();
          this.mGrayBitmap = localBitmap;
        }
      }
      if (this.mMaskBlurStrength > 1.0F) {
        this.mGrayBitmap = featherBitmap(this.mGrayBitmap, this.mMaskBlurStrength);
      }
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.mGrayBitmap, 33986, true));
    }
  }
  
  public Bitmap loadImg(String paramString)
  {
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 2147483647, 2147483647);
  }
  
  public void pause() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mIsNeedWhiteBg)
    {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glClear(16384);
    }
    GLES20.glLineWidth(3.0F);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
  }
  
  public Frame renderMask(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr)
  {
    this.mCopyFilter.RenderProcess(-1, this.width, this.height, -1, 0.0D, this.mMaskFrame);
    if (paramPTFaceAttr == null) {
      return this.mMaskFrame;
    }
    paramPTSegAttr = paramPTFaceAttr.getAllFacePoints().iterator();
    while (paramPTSegAttr.hasNext())
    {
      updateFacePoints2((List)paramPTSegAttr.next());
      updateVideoSize(this.mOutWidth, this.mOutHeight, paramPTFaceAttr.getFaceDetectScale());
      render(this.mMaskFrame.getTextureId(), this.mOutWidth, this.mOutHeight);
    }
    return this.mMaskFrame;
  }
  
  public void resume() {}
  
  public void setMaskSize(float paramFloat)
  {
    this.mMaskSizeValue = paramFloat;
  }
  
  public void setWhiteBg(boolean paramBoolean)
  {
    this.mIsNeedWhiteBg = paramBoolean;
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    updateFacePoints((List)paramList.get(0));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mOutHeight = paramInt2;
    this.mOutWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.FaceDIYMaskFilter
 * JD-Core Version:    0.7.0.1
 */