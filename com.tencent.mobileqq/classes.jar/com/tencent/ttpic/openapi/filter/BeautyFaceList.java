package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.EyeLightenAndPounchFilter;
import com.tencent.ttpic.filter.FaceFeatureFilter;
import com.tencent.ttpic.filter.WrinklesRemoveFilter2;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;

public class BeautyFaceList
{
  public static final String TAG = "com.tencent.ttpic.openapi.filter.BeautyFaceList";
  private List<BeautyFaceList.ColorParam> colorParams = new ArrayList();
  private float[] faceVertices = new float[1380];
  private int height;
  private BlurRealFilter mBlurFilter1 = new BlurRealFilter(3.0F);
  private Frame mBlurFrame1 = new Frame();
  private ContrastFilter mContrastFilter = new ContrastFilter();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  byte[] mData = null;
  private EyeLightenAndPounchFilter mEyeLightenFilter = new EyeLightenAndPounchFilter();
  private double mFaceDetScale;
  private FaceFeatureFilter mFaceFeatureFilter = new FaceFeatureFilter();
  private boolean mNeedRenderFaceFeature = true;
  private int mRenderIndex = 0;
  private WrinklesRemoveFilter2 mWrinklesRemoveFilter2 = new WrinklesRemoveFilter2();
  private int width;
  
  private void initData(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mData == null) || (this.mData.length < paramInt1 * paramInt2 * 4)) {
        this.mData = new byte[paramInt1 * paramInt2 * 4];
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private boolean isFirstFewFrames()
  {
    return this.mRenderIndex < 20;
  }
  
  public void clear()
  {
    Object localObject = this.mEyeLightenFilter;
    if (localObject != null) {
      ((EyeLightenAndPounchFilter)localObject).clearGLSLSelf();
    }
    localObject = this.mFaceFeatureFilter;
    if (localObject != null) {
      ((FaceFeatureFilter)localObject).clearGLSLSelf();
    }
    localObject = this.mWrinklesRemoveFilter2;
    if (localObject != null) {
      ((WrinklesRemoveFilter2)localObject).clearGLSLSelf();
    }
    localObject = this.mBlurFilter1;
    if (localObject != null) {
      ((BlurRealFilter)localObject).clearGLSL();
    }
    this.mCopyFilter.clearGLSL();
    this.mContrastFilter.clearGLSL();
    this.mBlurFrame1.clear();
  }
  
  void getAvgColor(Frame paramFrame, float paramFloat1, List<PointF> paramList, float paramFloat2, BeautyFaceList.ColorParam paramColorParam)
  {
    Object localObject1 = new PointF((((PointF)paramList.get(35)).x + ((PointF)paramList.get(39)).x) / 2.0F, (((PointF)paramList.get(35)).y + ((PointF)paramList.get(39)).y) / 2.0F);
    Object localObject2 = new PointF((((PointF)paramList.get(45)).x + ((PointF)paramList.get(49)).x) / 2.0F, (((PointF)paramList.get(45)).y + ((PointF)paramList.get(49)).y) / 2.0F);
    float f4 = ((PointF)localObject1).x / paramFloat2 * paramFloat1;
    float f2 = ((PointF)localObject1).y / paramFloat2 * paramFloat1;
    float f3 = ((PointF)localObject2).x / paramFloat2 * paramFloat1;
    float f1 = ((PointF)localObject2).y / paramFloat2 * paramFloat1;
    float f5 = f4 - f3;
    float f6 = f2 - f1;
    f5 = (float)Math.sqrt(f5 * f5 + f6 * f6);
    double d2 = Math.atan2(f1 - f2, f3 - f4);
    double d4 = f4;
    double d1 = f5;
    double d3 = d2 + 0.157D;
    double d5 = Math.sin(d3);
    Double.isNaN(d1);
    d5 = d5 * d1 / 2.0D;
    Double.isNaN(d4);
    f4 = (float)(d4 - d5);
    d4 = f2;
    d3 = Math.cos(d3);
    Double.isNaN(d1);
    d3 = d3 * d1 / 2.0D;
    Double.isNaN(d4);
    f2 = (float)(d4 + d3);
    d3 = f3;
    d2 -= 0.157D;
    d4 = Math.sin(d2);
    Double.isNaN(d1);
    d4 = d4 * d1 / 2.0D;
    Double.isNaN(d3);
    float f8 = (float)(d3 - d4);
    d3 = f1;
    d2 = Math.cos(d2);
    Double.isNaN(d1);
    d1 = d1 * d2 / 2.0D;
    Double.isNaN(d3);
    float f9 = (float)(d3 + d1);
    int i = paramFrame.width;
    int j = paramFrame.height;
    f1 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39)) / paramFloat2 * paramFloat1 / 2.0F;
    float f7 = i - 1;
    i = (int)Math.min(f7, Math.max(0.0F, f4 - f1 * 0.5F));
    int k = (int)Math.min(f7, Math.max(0.0F, f4 + 0.9F * f1));
    float f10 = j - 1;
    f1 *= 1.2F;
    j = (int)Math.min(f10, Math.max(0.0F, f2 - f1));
    int m = (int)Math.min(f10, Math.max(0.0F, f2 + f1));
    k -= i;
    m -= j;
    initData(k, m);
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, j, k, m, this.mData, paramFrame.getFBO());
    paramColorParam.mCgCrLeft[0] = 114.0F;
    paramColorParam.mCgCrLeft[1] = 112.0F;
    localObject1 = new int[3];
    k *= m;
    i = 0;
    j = 0;
    f6 = 0.0F;
    f5 = 0.0F;
    f4 = 0.0F;
    f3 = 0.0F;
    f2 = 0.0F;
    f1 = 0.0F;
    while (i < k)
    {
      localObject2 = this.mData;
      localObject1[0] = (localObject2[i] & 0xFF);
      localObject1[1] = (localObject2[(i + 1)] & 0xFF);
      localObject1[2] = (localObject2[(i + 2)] & 0xFF);
      f6 += localObject1[0];
      f5 += localObject1[1];
      f4 += localObject1[2];
      if (AlgoUtils.is_skin(localObject1[0], localObject1[1], localObject1[2]) == 1)
      {
        f3 += localObject1[0];
        f2 += localObject1[1];
        f1 += localObject1[2];
        j += 1;
      }
      i += 4;
    }
    if (j > 0)
    {
      if ((paramColorParam.mLastRGBLeft[0] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f3 / j) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[0] = (f3 / j);
      }
      if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f2 / j) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[1] = (f2 / j);
      }
      if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f1 / j) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[2] = (f1 / j);
      }
      localObject2 = paramColorParam.mLastRGBLeft;
      f4 = j;
      localObject2[0] = (f3 / f4 / 255.0F);
      paramColorParam.mLastRGBLeft[1] = (f2 / f4 / 255.0F);
      paramColorParam.mLastRGBLeft[2] = (f1 / f4 / 255.0F);
    }
    else if (k > 0)
    {
      if ((paramColorParam.mLastRGBLeft[0] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f6 / k) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[0] = (f6 / k);
      }
      if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f5 / k) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[1] = (f5 / k);
      }
      if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f4 / k) * 0.5F);
      } else {
        paramColorParam.mRGBLeft[2] = (f4 / k);
      }
      localObject2 = paramColorParam.mLastRGBLeft;
      f1 = k;
      localObject2[0] = (f6 / f1 / 255.0F);
      paramColorParam.mLastRGBLeft[1] = (f5 / f1 / 255.0F);
      paramColorParam.mLastRGBLeft[2] = (f4 / f1 / 255.0F);
    }
    else
    {
      paramColorParam.mRGBLeft[0] = 0.0F;
      paramColorParam.mRGBLeft[1] = 0.0F;
      paramColorParam.mRGBLeft[2] = 0.0F;
      paramColorParam.mLastRGBLeft[0] = 0.0F;
      paramColorParam.mLastRGBLeft[1] = 0.0F;
      paramColorParam.mLastRGBLeft[2] = 0.0F;
    }
    paramColorParam.mCgCrLeft[0] = ((paramColorParam.mRGBLeft[0] * -81085.0F + paramColorParam.mRGBLeft[1] * 112000.0F - paramColorParam.mRGBLeft[2] * 30915.0F) / 256000.0F + 128.0F);
    paramColorParam.mCgCrLeft[1] = ((paramColorParam.mRGBLeft[0] * -37797.0F - paramColorParam.mRGBLeft[1] * 74203.0F + paramColorParam.mRGBLeft[2] * 112000.0F) / 256000.0F + 128.0F);
    paramColorParam.mRGBLeft[0] /= 255.0F;
    paramColorParam.mRGBLeft[1] /= 255.0F;
    paramColorParam.mRGBLeft[2] /= 255.0F;
    paramFloat1 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49)) / paramFloat2 * paramFloat1 / 2.0F;
    i = (int)Math.min(f7, Math.max(0.0F, f8 - 0.9F * paramFloat1));
    m = (int)Math.min(f7, Math.max(0.0F, f8 + paramFloat1 * 0.5F));
    paramFloat1 *= 1.2F;
    j = (int)Math.min(f10, Math.max(0.0F, f9 - paramFloat1));
    k = (int)Math.min(f10, Math.max(0.0F, f9 + paramFloat1));
    m -= i;
    k -= j;
    initData(m, k);
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, j, m, k, this.mData, paramFrame.getFBO());
    paramColorParam.mCgCrRight[0] = 114.0F;
    paramColorParam.mCgCrRight[1] = 112.0F;
    k = m * k;
    i = 0;
    j = 0;
    f4 = 0.0F;
    f3 = 0.0F;
    f2 = 0.0F;
    f1 = 0.0F;
    paramFloat2 = 0.0F;
    paramFloat1 = 0.0F;
    while (i < k)
    {
      paramFrame = this.mData;
      localObject1[0] = (paramFrame[i] & 0xFF);
      localObject1[1] = (paramFrame[(i + 1)] & 0xFF);
      localObject1[2] = (paramFrame[(i + 2)] & 0xFF);
      f4 += localObject1[0];
      f3 += localObject1[1];
      f2 += localObject1[2];
      if (AlgoUtils.is_skin(localObject1[0], localObject1[1], localObject1[2]) == 1)
      {
        f1 += localObject1[0];
        paramFloat2 += localObject1[1];
        paramFloat1 += localObject1[2];
        j += 1;
      }
      i += 4;
    }
    if (j > 0)
    {
      if ((paramColorParam.mLastRGBRight[0] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f1 / j) * 0.5F);
      } else {
        paramColorParam.mRGBRight[0] = (f1 / j);
      }
      if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + paramFloat2 / j) * 0.5F);
      } else {
        paramColorParam.mRGBRight[1] = (paramFloat2 / j);
      }
      if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + paramFloat1 / j) * 0.5F);
      } else {
        paramColorParam.mRGBRight[2] = (paramFloat1 / j);
      }
      paramFrame = paramColorParam.mLastRGBRight;
      f2 = j;
      paramFrame[0] = (f1 / f2 / 255.0F);
      paramColorParam.mLastRGBRight[1] = (paramFloat2 / f2 / 255.0F);
      paramColorParam.mLastRGBRight[2] = (paramFloat1 / f2 / 255.0F);
    }
    else if (k > 0)
    {
      if ((paramColorParam.mLastRGBRight[0] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f4 / k) * 0.5F);
      } else {
        paramColorParam.mRGBRight[0] = (f4 / k);
      }
      if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + f3 / k) * 0.5F);
      } else {
        paramColorParam.mRGBRight[1] = (f3 / k);
      }
      if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
        paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + f2 / k) * 0.5F);
      } else {
        paramColorParam.mRGBRight[2] = (f2 / k);
      }
      paramFrame = paramColorParam.mLastRGBRight;
      paramFloat1 = k;
      paramFrame[0] = (f4 / paramFloat1 / 255.0F);
      paramColorParam.mLastRGBRight[1] = (f3 / paramFloat1 / 255.0F);
      paramColorParam.mLastRGBRight[2] = (f2 / paramFloat1 / 255.0F);
    }
    else
    {
      paramColorParam.mRGBRight[0] = 0.0F;
      paramColorParam.mRGBRight[1] = 0.0F;
      paramColorParam.mRGBRight[2] = 0.0F;
      paramColorParam.mLastRGBRight[0] = 0.0F;
      paramColorParam.mLastRGBRight[1] = 0.0F;
      paramColorParam.mLastRGBRight[2] = 0.0F;
    }
    paramColorParam.mCgCrRight[0] = ((paramColorParam.mRGBRight[0] * -81085.0F + paramColorParam.mRGBRight[1] * 112000.0F - paramColorParam.mRGBRight[2] * 30915.0F) / 256000.0F + 128.0F);
    paramColorParam.mCgCrRight[1] = ((paramColorParam.mRGBRight[0] * -37797.0F - paramColorParam.mRGBRight[1] * 74203.0F + paramColorParam.mRGBRight[2] * 112000.0F) / 256000.0F + 128.0F);
    paramColorParam.mRGBRight[0] /= 255.0F;
    paramColorParam.mRGBRight[1] /= 255.0F;
    paramColorParam.mRGBRight[2] /= 255.0F;
  }
  
  public void initial()
  {
    Object localObject = this.mEyeLightenFilter;
    if (localObject != null) {
      ((EyeLightenAndPounchFilter)localObject).ApplyGLSLFilter();
    }
    localObject = this.mFaceFeatureFilter;
    if (localObject != null) {
      ((FaceFeatureFilter)localObject).ApplyGLSLFilter();
    }
    localObject = this.mWrinklesRemoveFilter2;
    if (localObject != null) {
      ((WrinklesRemoveFilter2)localObject).ApplyGLSLFilter();
    }
    localObject = this.mBlurFilter1;
    if (localObject != null) {
      ((BlurRealFilter)localObject).applyFilterChain(true, 360.0F, 640.0F);
    }
    this.mContrastFilter.apply();
    this.mCopyFilter.apply();
  }
  
  public Frame render(Frame paramFrame, List<List<PointF>> paramList, boolean paramBoolean)
  {
    int i;
    if (this.colorParams.size() != paramList.size())
    {
      this.colorParams.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.colorParams.add(new BeautyFaceList.ColorParam(this));
        i += 1;
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = 0;
    while (j < paramList.size())
    {
      List localList = VideoMaterial.copyList((List)paramList.get(j));
      Object localObject1 = FaceOffUtil.getFullCoords(localList, 2.0F);
      double d2 = this.width;
      double d1 = this.mFaceDetScale;
      Double.isNaN(d2);
      int k = (int)(d2 * d1);
      d2 = this.height;
      Double.isNaN(d2);
      FaceOffUtil.initFacePositions((List)localObject1, k, (int)(d2 * d1), this.faceVertices);
      BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
      localObject1 = paramFrame;
      Object localObject2;
      if (!paramBoolean)
      {
        localObject2 = this.mFaceFeatureFilter;
        localObject1 = paramFrame;
        if (localObject2 != null)
        {
          localObject1 = paramFrame;
          if (((FaceFeatureFilter)localObject2).needRender())
          {
            localObject1 = paramFrame;
            if (this.mNeedRenderFaceFeature)
            {
              localObject1 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
              this.mFaceFeatureFilter.updateParam(this.faceVertices);
              this.mFaceFeatureFilter.OnDrawFrameGLSL();
              this.mFaceFeatureFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
              paramFrame.unlock();
            }
          }
        }
      }
      BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
      BenchUtil.benchStart("mBeautyFaceList mWrinklesRemoveFilter2");
      paramFrame = this.mWrinklesRemoveFilter2;
      if ((paramFrame != null) && (paramFrame.needRender()))
      {
        paramFrame = this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
        this.mWrinklesRemoveFilter2.updateParam(localList, this.faceVertices);
        this.mWrinklesRemoveFilter2.OnDrawFrameGLSL();
        this.mWrinklesRemoveFilter2.renderTexture(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
        ((Frame)localObject1).unlock();
      }
      else
      {
        paramFrame = (Frame)localObject1;
      }
      BenchUtil.benchEnd("mBeautyFaceList mWrinklesRemoveFilter2");
      BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
      localObject1 = this.mEyeLightenFilter;
      if ((localObject1 != null) && (((EyeLightenAndPounchFilter)localObject1).needRender()))
      {
        localObject1 = new Frame();
        new Frame();
        localObject2 = (BeautyFaceList.ColorParam)this.colorParams.get(j);
        if (this.mEyeLightenFilter.getSmoothOpacity() > 0.0F)
        {
          Frame localFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width / 2, paramFrame.height / 2);
          localObject1 = this.mBlurFilter1.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height);
          if ((isFirstFewFrames()) || (i != 0) || (this.mRenderIndex % 2 == 0)) {
            getAvgColor(localFrame, 0.5F, localList, (float)this.mFaceDetScale, (BeautyFaceList.ColorParam)localObject2);
          }
          localFrame.unlock();
        }
        this.mEyeLightenFilter.setEyePouchSmoothImage(((Frame)localObject1).getLastRenderTextureId(), ((BeautyFaceList.ColorParam)localObject2).mRGBLeft, ((BeautyFaceList.ColorParam)localObject2).mRGBRight, ((BeautyFaceList.ColorParam)localObject2).mCgCrLeft, ((BeautyFaceList.ColorParam)localObject2).mCgCrRight);
        localObject2 = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        this.mEyeLightenFilter.updateParam(localList, this.faceVertices);
        this.mEyeLightenFilter.OnDrawFrameGLSL();
        this.mEyeLightenFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        ((Frame)localObject1).unlock();
        paramFrame = (Frame)localObject2;
      }
      BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
      j += 1;
    }
    paramList = paramFrame;
    if (this.mContrastFilter.needRender())
    {
      paramList = this.mContrastFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramFrame.unlock();
    }
    this.mRenderIndex += 1;
    return paramList;
  }
  
  public void resetEyeBagColors()
  {
    this.colorParams.clear();
    this.mRenderIndex = 0;
  }
  
  public void setContrastLevel(int paramInt)
  {
    this.mContrastFilter.setContrastLevel(paramInt);
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    EyeLightenAndPounchFilter localEyeLightenAndPounchFilter = this.mEyeLightenFilter;
    if (localEyeLightenAndPounchFilter != null) {
      localEyeLightenAndPounchFilter.setAlphaValue(paramFloat);
    }
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    FaceFeatureFilter localFaceFeatureFilter = this.mFaceFeatureFilter;
    if (localFaceFeatureFilter != null) {
      localFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
    }
  }
  
  public void setNeedRenderFaceFeature(boolean paramBoolean)
  {
    this.mNeedRenderFaceFeature = paramBoolean;
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    FaceFeatureFilter localFaceFeatureFilter = this.mFaceFeatureFilter;
    if (localFaceFeatureFilter != null) {
      localFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
    }
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    EyeLightenAndPounchFilter localEyeLightenAndPounchFilter = this.mEyeLightenFilter;
    if (localEyeLightenAndPounchFilter != null) {
      localEyeLightenAndPounchFilter.setSmoothOpacity(paramFloat * 1.2F);
    }
  }
  
  public void setRemoveWrinklesAlpha(float paramFloat)
  {
    EyeLightenAndPounchFilter localEyeLightenAndPounchFilter = this.mEyeLightenFilter;
    if (localEyeLightenAndPounchFilter != null) {
      localEyeLightenAndPounchFilter.setWrinklesAlpha(paramFloat);
    }
  }
  
  public void setRemoveWrinklesAlpha2(float paramFloat)
  {
    WrinklesRemoveFilter2 localWrinklesRemoveFilter2 = this.mWrinklesRemoveFilter2;
    if (localWrinklesRemoveFilter2 != null) {
      localWrinklesRemoveFilter2.setWrinklesAlpha(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    Object localObject = this.mEyeLightenFilter;
    if (localObject != null) {
      ((EyeLightenAndPounchFilter)localObject).setRenderMode(paramInt);
    }
    localObject = this.mFaceFeatureFilter;
    if (localObject != null) {
      ((FaceFeatureFilter)localObject).setRenderMode(paramInt);
    }
    localObject = this.mWrinklesRemoveFilter2;
    if (localObject != null) {
      ((WrinklesRemoveFilter2)localObject).setRenderMode(paramInt);
    }
    localObject = this.mContrastFilter;
    if (localObject != null) {
      ((ContrastFilter)localObject).setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    EyeLightenAndPounchFilter localEyeLightenAndPounchFilter = this.mEyeLightenFilter;
    if (localEyeLightenAndPounchFilter != null) {
      localEyeLightenAndPounchFilter.setToothWhitenAlpha(paramFloat);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject = this.mEyeLightenFilter;
    if (localObject != null) {
      ((EyeLightenAndPounchFilter)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localObject = this.mWrinklesRemoveFilter2;
    if (localObject != null) {
      ((WrinklesRemoveFilter2)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localObject = this.mFaceFeatureFilter;
    if (localObject != null) {
      ((FaceFeatureFilter)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyFaceList
 * JD-Core Version:    0.7.0.1
 */