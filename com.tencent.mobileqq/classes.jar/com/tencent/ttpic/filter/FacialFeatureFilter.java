package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.filter.TransformFilter;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FacialFeatureFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 maskCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nvoid main(void) {\n    vec4 userColor  = texture2D(inputImageTexture, textureCoordinate);\n    vec4 grayColor  = texture2D(inputImageTexture2, maskCoordinate);\n    gl_FragColor = userColor * grayColor.r;\n    //gl_FragColor = grayColor;\n}";
  private static int FRAME_EDGE = 640;
  public static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputTextureCoordinate2;\nvarying vec2 textureCoordinate;\nvarying vec2 maskCoordinate;\n\nuniform mat4 posMatRotate;\n\n\nvoid main(){\n    gl_Position = position * posMatRotate;\n    textureCoordinate = inputTextureCoordinate;\n    maskCoordinate = inputTextureCoordinate2;\n}";
  private float[] faceVertices = new float[1380];
  List<PointF> fullPositions;
  private float[] grayVertices = new float[1380];
  private FaceFeatureItem mFaceFeatureItem;
  private FaceItem mFaceItem;
  Frame mFrame = new Frame();
  private boolean mIsFirstRender = true;
  Frame mResultFrame;
  private List<NormalVideoFilter> mStickerFilters;
  Frame mTFrame = new Frame();
  TransformFilter mTransformFilter;
  private float[] mt4 = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float[] texVertices = new float[1380];
  
  public FacialFeatureFilter(FaceItem paramFaceItem, List<DistortionItem> paramList, FaceFeatureItem paramFaceFeatureItem)
  {
    super(BaseFilter.nativeDecrypt("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputTextureCoordinate2;\nvarying vec2 textureCoordinate;\nvarying vec2 maskCoordinate;\n\nuniform mat4 posMatRotate;\n\n\nvoid main(){\n    gl_Position = position * posMatRotate;\n    textureCoordinate = inputTextureCoordinate;\n    maskCoordinate = inputTextureCoordinate2;\n}"), BaseFilter.nativeDecrypt("precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 maskCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nvoid main(void) {\n    vec4 userColor  = texture2D(inputImageTexture, textureCoordinate);\n    vec4 grayColor  = texture2D(inputImageTexture2, maskCoordinate);\n    gl_FragColor = userColor * grayColor.r;\n    //gl_FragColor = grayColor;\n}"));
    if (paramList != null) {
      this.mTransformFilter = new TransformFilter(paramList, null);
    }
    this.mFaceFeatureItem = paramFaceFeatureItem;
    this.mFaceItem = paramFaceItem;
    initParams();
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext()))
    {
      FRAME_EDGE = 1024;
      return;
    }
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext()))
    {
      FRAME_EDGE = 640;
      return;
    }
    FRAME_EDGE = 512;
  }
  
  private void updateFacePoints(List<PointF> paramList, float paramFloat)
  {
    float f1 = ((PointF)paramList.get(64)).x;
    float f2 = ((PointF)paramList.get(64)).y;
    Object localObject = paramList.iterator();
    PointF localPointF;
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      localPointF.x -= f1;
      localPointF.y -= f2;
    }
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = ((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    f2 = (float)Math.atan2(f1 - f2, f3 - f4);
    f1 = (float)Math.cos(f2);
    f2 = (float)Math.sin(f2);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      f3 = localPointF.x;
      f4 = localPointF.y;
      localPointF.x = (f3 * f1 - f4 * f2);
      localPointF.y = (f3 * f2 + f4 * f1);
    }
    f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      localPointF.x = (localPointF.x * paramFloat / f1);
      localPointF.y = (localPointF.y * paramFloat / f1);
    }
    paramFloat /= 2.0F;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (PointF)paramList.next();
      ((PointF)localObject).x += paramFloat;
      ((PointF)localObject).y += paramFloat;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.mTransformFilter != null) {
      this.mTransformFilter.ApplyGLSLFilter();
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    this.mFrame.bindFrame(-1, FRAME_EDGE, FRAME_EDGE, paramDouble);
    if (this.mIsFirstRender)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    this.mIsFirstRender = false;
    OnDrawFrameGLSL();
    renderTexture(paramInt1, FRAME_EDGE, FRAME_EDGE);
    this.mResultFrame = this.mFrame;
    if (this.mTransformFilter != null)
    {
      this.mTransformFilter.RenderProcess(this.mFrame.getTextureId(), FRAME_EDGE, FRAME_EDGE, -1, paramDouble, this.mTFrame);
      this.mResultFrame = this.mTFrame;
    }
  }
  
  public void clearGLSLSelf()
  {
    if (this.mTransformFilter != null) {
      this.mTransformFilter.clearGLSLSelf();
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).clearGLSLSelf();
    }
    this.mFrame.clear();
    this.mTFrame.clear();
    super.clearGLSLSelf();
  }
  
  public Frame getFrame()
  {
    return this.mFrame;
  }
  
  public List<NormalVideoFilter> getStickerFilters()
  {
    return this.mStickerFilters;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.mFaceItem.facePoints), 2.0F), this.mFaceItem.width, this.mFaceItem.height, this.grayVertices));
    if (this.mTransformFilter != null) {
      this.mTransformFilter.initAttribParams();
    }
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", FaceOffUtil.getFaceBitmap(this.mFaceFeatureItem.getDataPath() + File.separator + this.mFaceItem.faceExchangeImage), 33987, true));
    addParam(new UniformParam.Mat4Param("posMatRotate", this.mt4));
    if (this.mTransformFilter != null) {
      this.mTransformFilter.initParams();
    }
  }
  
  public void reset()
  {
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    if (this.mTransformFilter != null) {
      this.mTransformFilter.reset();
    }
  }
  
  public boolean setRenderMode(int paramInt)
  {
    super.setRenderMode(paramInt);
    if (this.mTransformFilter != null) {
      this.mTransformFilter.setRenderMode(paramInt);
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).setRenderMode(paramInt);
    }
    return true;
  }
  
  public void setStickerFilters(List<NormalVideoFilter> paramList)
  {
    this.mStickerFilters = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((NormalVideoFilter)paramList.next()).item.support3D = 0;
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.fullPositions = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramObject.facePoints), 2.0F);
      addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(this.fullPositions, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
      updateFacePoints(this.fullPositions, FRAME_EDGE);
      setPositions(FaceOffUtil.initFacePositions(this.fullPositions, FRAME_EDGE, FRAME_EDGE, this.faceVertices));
      setCoordNum(690);
      if (this.mTransformFilter != null)
      {
        paramObject = new PTDetectInfo.Builder().facePoints(this.fullPositions).faceAngles(paramObject.faceAngles).faceActionCounter(paramObject.faceActionCounter).handPoints(paramObject.handPoints).handActionCounter(paramObject.handActionCounter).triggeredExpression(paramObject.triggeredExpression).phoneAngle(paramObject.phoneAngle).timestamp(paramObject.timestamp).build();
        this.mTransformFilter.updatePreview(paramObject);
      }
    }
  }
  
  public void updateStickerFilterList(List<PointF> paramList, float[] paramArrayOfFloat, Frame paramFrame)
  {
    updatePreview(new PTDetectInfo.Builder().facePoints(paramList).faceAngles(paramArrayOfFloat).build());
    RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramFrame.getTextureId(), 0.0D, paramFrame);
    paramList = this.mStickerFilters.iterator();
    while (paramList.hasNext())
    {
      paramArrayOfFloat = (NormalVideoFilter)paramList.next();
      if (!paramArrayOfFloat.needLoadImage())
      {
        float f2 = AlgoUtils.getDistance((PointF)this.fullPositions.get(paramArrayOfFloat.item.scalePivots[0]), (PointF)this.fullPositions.get(paramArrayOfFloat.item.scalePivots[1]));
        float f1 = paramArrayOfFloat.item.dx * f2 / paramArrayOfFloat.item.originalScaleFactor;
        float f3 = paramArrayOfFloat.item.dy * f2 / paramArrayOfFloat.item.originalScaleFactor;
        if ((paramArrayOfFloat.item.anchorPoint != null) && (paramArrayOfFloat.item.anchorPoint.length >= 2))
        {
          paramArrayOfFloat.item.anchorPoint[0] = ((int)(((PointF)this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).x + f1));
          paramArrayOfFloat.item.anchorPoint[1] = ((int)(((PointF)this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).y + f3));
        }
        paramArrayOfFloat.item.width = FRAME_EDGE;
        paramArrayOfFloat.item.height = FRAME_EDGE;
        paramFrame = paramArrayOfFloat.item;
        if (paramArrayOfFloat.item.scale <= 0.0F) {}
        for (f1 = 1.0F;; f1 = paramArrayOfFloat.item.scale)
        {
          paramFrame.scaleFactor = ((int)(f2 / f1));
          paramArrayOfFloat.updateTextureParam(this.mResultFrame.getTextureId());
          break;
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.mTransformFilter != null) {
      this.mTransformFilter.updateVideoSize(FRAME_EDGE, FRAME_EDGE, 1.0D);
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FacialFeatureFilter
 * JD-Core Version:    0.7.0.1
 */