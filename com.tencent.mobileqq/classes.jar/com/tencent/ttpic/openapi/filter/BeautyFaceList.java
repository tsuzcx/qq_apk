package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.EyeLightenAndPounchFilter;
import com.tencent.ttpic.filter.FaceFeatureFilter;
import com.tencent.ttpic.filter.WrinklesRemoveFilter2;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;

public class BeautyFaceList
{
  public static final String TAG = BeautyFaceList.class.getName();
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
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.clearGLSLSelf();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.clearGLSLSelf();
    }
    if (this.mWrinklesRemoveFilter2 != null) {
      this.mWrinklesRemoveFilter2.clearGLSLSelf();
    }
    if (this.mBlurFilter1 != null) {
      this.mBlurFilter1.clearGLSL();
    }
    this.mCopyFilter.clearGLSL();
    this.mContrastFilter.clearGLSL();
    this.mBlurFrame1.clear();
  }
  
  void getAvgColor(Frame paramFrame, float paramFloat1, List<PointF> paramList, float paramFloat2, BeautyFaceList.ColorParam paramColorParam)
  {
    float f1 = ((PointF)paramList.get(35)).x;
    f1 = (((PointF)paramList.get(39)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(35)).y;
    Object localObject = new PointF(f1, (((PointF)paramList.get(39)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(45)).x;
    f1 = (((PointF)paramList.get(49)).x + f1) / 2.0F;
    f2 = ((PointF)paramList.get(45)).y;
    PointF localPointF = new PointF(f1, (((PointF)paramList.get(49)).y + f2) / 2.0F);
    f1 = ((PointF)localObject).x / paramFloat2 * paramFloat1;
    float f4 = ((PointF)localObject).y / paramFloat2 * paramFloat1;
    float f5 = localPointF.x / paramFloat2 * paramFloat1;
    f2 = localPointF.y / paramFloat2 * paramFloat1;
    float f3 = (float)Math.sqrt((f1 - f5) * (f1 - f5) + (f4 - f2) * (f4 - f2));
    double d = Math.atan2(f2 - f4, f5 - f1);
    f1 = (float)(f1 - f3 * Math.sin(0.157D + d) / 2.0D);
    f4 = (float)(f4 + f3 * Math.cos(0.157D + d) / 2.0D);
    float f7 = (float)(f5 - f3 * Math.sin(d - 0.157D) / 2.0D);
    float f8 = (float)(f2 + f3 * Math.cos(d - 0.157D) / 2.0D);
    int m = paramFrame.width;
    int k = paramFrame.height;
    f2 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39)) / paramFloat2 * paramFloat1 / 2.0F;
    int i = (int)Math.min(m - 1, Math.max(0.0F, f1 - 0.5F * f2));
    int j = (int)Math.min(m - 1, Math.max(0.0F, 0.9F * f2 + f1));
    int n = (int)Math.min(k - 1, Math.max(0.0F, f4 - 1.2F * f2));
    int i1 = (int)Math.min(k - 1, Math.max(0.0F, f2 * 1.2F + f4));
    initData(j - i, i1 - n);
    GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, n, j - i, i1 - n, this.mData, paramFrame.getFBO());
    paramColorParam.mCgCrLeft[0] = 114.0F;
    paramColorParam.mCgCrLeft[1] = 112.0F;
    localObject = new int[3];
    n = (j - i) * (i1 - n);
    f1 = 0.0F;
    f2 = 0.0F;
    i = 0;
    f4 = 0.0F;
    j = 0;
    float f6 = 0.0F;
    f3 = 0.0F;
    f5 = 0.0F;
    if (i < n)
    {
      localObject[0] = (this.mData[i] & 0xFF);
      localObject[1] = (this.mData[(i + 1)] & 0xFF);
      localObject[2] = (this.mData[(i + 2)] & 0xFF);
      f6 += localObject[0];
      f5 += localObject[1];
      f4 += localObject[2];
      if (AlgoUtils.is_skin(localObject[0], localObject[1], localObject[2]) != 1) {}
      for (;;)
      {
        i += 4;
        break;
        f3 += localObject[0];
        f2 += localObject[1];
        f1 += localObject[2];
        j += 1;
      }
    }
    if (j > 0) {
      if ((paramColorParam.mLastRGBLeft[0] <= 0.0001D) || (isFirstFewFrames()))
      {
        paramColorParam.mRGBLeft[0] = (f3 / j);
        if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
          break label1412;
        }
        paramColorParam.mRGBLeft[1] = (f2 / j);
        label826:
        if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
          break label1442;
        }
        paramColorParam.mRGBLeft[2] = (f1 / j);
        label861:
        paramColorParam.mLastRGBLeft[0] = (f3 / j / 255.0F);
        paramColorParam.mLastRGBLeft[1] = (f2 / j / 255.0F);
        paramColorParam.mLastRGBLeft[2] = (f1 / j / 255.0F);
        label909:
        paramColorParam.mCgCrLeft[0] = ((-81085.0F * paramColorParam.mRGBLeft[0] + 112000.0F * paramColorParam.mRGBLeft[1] - 30915.0F * paramColorParam.mRGBLeft[2]) / 256000.0F + 128.0F);
        paramColorParam.mCgCrLeft[1] = ((-37797.0F * paramColorParam.mRGBLeft[0] - 74203.0F * paramColorParam.mRGBLeft[1] + 112000.0F * paramColorParam.mRGBLeft[2]) / 256000.0F + 128.0F);
        paramColorParam.mRGBLeft[0] /= 255.0F;
        paramColorParam.mRGBLeft[1] /= 255.0F;
        paramColorParam.mRGBLeft[2] /= 255.0F;
        paramFloat1 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49)) / paramFloat2 * paramFloat1 / 2.0F;
        i = (int)Math.min(m - 1, Math.max(0.0F, f7 - 0.9F * paramFloat1));
        j = (int)Math.min(m - 1, Math.max(0.0F, 0.5F * paramFloat1 + f7));
        m = (int)Math.min(k - 1, Math.max(0.0F, f8 - 1.2F * paramFloat1));
        k = (int)Math.min(k - 1, Math.max(0.0F, paramFloat1 * 1.2F + f8));
        initData(j - i, k - m);
        GlUtil.saveTextureToRgbaBuffer(paramFrame.getTextureId(), i, m, j - i, k - m, this.mData, paramFrame.getFBO());
        paramColorParam.mCgCrRight[0] = 114.0F;
        paramColorParam.mCgCrRight[1] = 112.0F;
        f2 = 0.0F;
        k = (j - i) * (k - m);
        paramFloat1 = 0.0F;
        paramFloat2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        i = 0;
        j = 0;
        f1 = 0.0F;
        label1268:
        if (i >= k) {
          break label1811;
        }
        localObject[0] = (this.mData[i] & 0xFF);
        localObject[1] = (this.mData[(i + 1)] & 0xFF);
        localObject[2] = (this.mData[(i + 2)] & 0xFF);
        f4 += localObject[0];
        f3 += localObject[1];
        f2 += localObject[2];
        if (AlgoUtils.is_skin(localObject[0], localObject[1], localObject[2]) == 1) {
          break label1774;
        }
      }
    }
    for (;;)
    {
      i += 4;
      break label1268;
      paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f3 / j) * 0.5F);
      break;
      label1412:
      paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f2 / j) * 0.5F);
      break label826;
      label1442:
      paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f1 / j) * 0.5F);
      break label861;
      if (n > 0)
      {
        if ((paramColorParam.mLastRGBLeft[0] <= 0.0001D) || (isFirstFewFrames()))
        {
          paramColorParam.mRGBLeft[0] = (f6 / n);
          label1512:
          if ((paramColorParam.mLastRGBLeft[1] > 0.0001D) && (!isFirstFewFrames())) {
            break label1663;
          }
          paramColorParam.mRGBLeft[1] = (f5 / n);
          label1547:
          if ((paramColorParam.mLastRGBLeft[2] > 0.0001D) && (!isFirstFewFrames())) {
            break label1693;
          }
          paramColorParam.mRGBLeft[2] = (f4 / n);
        }
        for (;;)
        {
          paramColorParam.mLastRGBLeft[0] = (f6 / n / 255.0F);
          paramColorParam.mLastRGBLeft[1] = (f5 / n / 255.0F);
          paramColorParam.mLastRGBLeft[2] = (f4 / n / 255.0F);
          break;
          paramColorParam.mRGBLeft[0] = ((paramColorParam.mLastRGBLeft[0] * 255.0F + f6 / n) * 0.5F);
          break label1512;
          label1663:
          paramColorParam.mRGBLeft[1] = ((paramColorParam.mLastRGBLeft[1] * 255.0F + f5 / n) * 0.5F);
          break label1547;
          label1693:
          paramColorParam.mRGBLeft[2] = ((paramColorParam.mLastRGBLeft[2] * 255.0F + f4 / n) * 0.5F);
        }
      }
      paramColorParam.mRGBLeft[0] = 0.0F;
      paramColorParam.mRGBLeft[1] = 0.0F;
      paramColorParam.mRGBLeft[2] = 0.0F;
      paramColorParam.mLastRGBLeft[0] = 0.0F;
      paramColorParam.mLastRGBLeft[1] = 0.0F;
      paramColorParam.mLastRGBLeft[2] = 0.0F;
      break label909;
      label1774:
      f1 += localObject[0];
      paramFloat2 += localObject[1];
      paramFloat1 += localObject[2];
      j += 1;
    }
    label1811:
    if (j > 0) {
      if ((paramColorParam.mLastRGBRight[0] <= 0.0001D) || (isFirstFewFrames()))
      {
        paramColorParam.mRGBRight[0] = (f1 / j);
        if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
          break label2139;
        }
        paramColorParam.mRGBRight[1] = (paramFloat2 / j);
        label1886:
        if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
          break label2169;
        }
        paramColorParam.mRGBRight[2] = (paramFloat1 / j);
        paramColorParam.mLastRGBRight[0] = (f1 / j / 255.0F);
        paramColorParam.mLastRGBRight[1] = (paramFloat2 / j / 255.0F);
        paramColorParam.mLastRGBRight[2] = (paramFloat1 / j / 255.0F);
      }
    }
    for (;;)
    {
      label1920:
      paramColorParam.mCgCrRight[0] = ((-81085.0F * paramColorParam.mRGBRight[0] + 112000.0F * paramColorParam.mRGBRight[1] - 30915.0F * paramColorParam.mRGBRight[2]) / 256000.0F + 128.0F);
      paramColorParam.mCgCrRight[1] = ((-37797.0F * paramColorParam.mRGBRight[0] - 74203.0F * paramColorParam.mRGBRight[1] + 112000.0F * paramColorParam.mRGBRight[2]) / 256000.0F + 128.0F);
      paramColorParam.mRGBRight[0] /= 255.0F;
      paramColorParam.mRGBRight[1] /= 255.0F;
      paramColorParam.mRGBRight[2] /= 255.0F;
      return;
      paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f1 / j) * 0.5F);
      break;
      label2139:
      paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + paramFloat2 / j) * 0.5F);
      break label1886;
      label2169:
      paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + paramFloat1 / j) * 0.5F);
      break label1920;
      if (k > 0)
      {
        if ((paramColorParam.mLastRGBRight[0] <= 0.0001D) || (isFirstFewFrames()))
        {
          paramColorParam.mRGBRight[0] = (f4 / k);
          label2238:
          if ((paramColorParam.mLastRGBRight[1] > 0.0001D) && (!isFirstFewFrames())) {
            break label2389;
          }
          paramColorParam.mRGBRight[1] = (f3 / k);
          label2273:
          if ((paramColorParam.mLastRGBRight[2] > 0.0001D) && (!isFirstFewFrames())) {
            break label2419;
          }
          paramColorParam.mRGBRight[2] = (f2 / k);
        }
        for (;;)
        {
          paramColorParam.mLastRGBRight[0] = (f4 / k / 255.0F);
          paramColorParam.mLastRGBRight[1] = (f3 / k / 255.0F);
          paramColorParam.mLastRGBRight[2] = (f2 / k / 255.0F);
          break;
          paramColorParam.mRGBRight[0] = ((paramColorParam.mLastRGBRight[0] * 255.0F + f4 / k) * 0.5F);
          break label2238;
          label2389:
          paramColorParam.mRGBRight[1] = ((paramColorParam.mLastRGBRight[1] * 255.0F + f3 / k) * 0.5F);
          break label2273;
          label2419:
          paramColorParam.mRGBRight[2] = ((paramColorParam.mLastRGBRight[2] * 255.0F + f2 / k) * 0.5F);
        }
      }
      paramColorParam.mRGBRight[0] = 0.0F;
      paramColorParam.mRGBRight[1] = 0.0F;
      paramColorParam.mRGBRight[2] = 0.0F;
      paramColorParam.mLastRGBRight[0] = 0.0F;
      paramColorParam.mLastRGBRight[1] = 0.0F;
      paramColorParam.mLastRGBRight[2] = 0.0F;
    }
  }
  
  public void initial()
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.ApplyGLSLFilter();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.ApplyGLSLFilter();
    }
    if (this.mWrinklesRemoveFilter2 != null) {
      this.mWrinklesRemoveFilter2.ApplyGLSLFilter();
    }
    if (this.mBlurFilter1 != null) {
      this.mBlurFilter1.applyFilterChain(true, 360.0F, 640.0F);
    }
    this.mContrastFilter.apply();
    this.mCopyFilter.apply();
  }
  
  public Frame render(Frame paramFrame, List<List<PointF>> paramList, boolean paramBoolean)
  {
    if (this.colorParams.size() != paramList.size())
    {
      this.colorParams.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.colorParams.add(new BeautyFaceList.ColorParam(this));
        i += 1;
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = 0;
      while (j < paramList.size())
      {
        List localList = VideoMaterialUtil.copyList((List)paramList.get(j));
        FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(localList, 2.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices);
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        Object localObject1 = paramFrame;
        if (!paramBoolean)
        {
          localObject1 = paramFrame;
          if (this.mFaceFeatureFilter != null)
          {
            localObject1 = paramFrame;
            if (this.mFaceFeatureFilter.needRender())
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
        paramFrame = (Frame)localObject1;
        if (this.mWrinklesRemoveFilter2 != null)
        {
          paramFrame = (Frame)localObject1;
          if (this.mWrinklesRemoveFilter2.needRender())
          {
            paramFrame = this.mCopyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
            this.mWrinklesRemoveFilter2.updateParam(localList, this.faceVertices);
            this.mWrinklesRemoveFilter2.OnDrawFrameGLSL();
            this.mWrinklesRemoveFilter2.renderTexture(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
            ((Frame)localObject1).unlock();
          }
        }
        BenchUtil.benchEnd("mBeautyFaceList mWrinklesRemoveFilter2");
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        localObject1 = paramFrame;
        if (this.mEyeLightenFilter != null)
        {
          localObject1 = paramFrame;
          if (this.mEyeLightenFilter.needRender())
          {
            localObject1 = new Frame();
            new Frame();
            Object localObject2 = (BeautyFaceList.ColorParam)this.colorParams.get(j);
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
            localObject1 = localObject2;
          }
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        j += 1;
        paramFrame = (Frame)localObject1;
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
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setAlphaValue(paramFloat);
    }
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setFaceFeatureParam(paramFaceFeatureParam);
    }
  }
  
  public void setNeedRenderFaceFeature(boolean paramBoolean)
  {
    this.mNeedRenderFaceFeature = paramBoolean;
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setNormalAlphaFactor(paramFloat);
    }
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setSmoothOpacity(1.2F * paramFloat);
    }
  }
  
  public void setRemoveWrinklesAlpha(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setWrinklesAlpha(paramFloat);
    }
  }
  
  public void setRemoveWrinklesAlpha2(float paramFloat)
  {
    if (this.mWrinklesRemoveFilter2 != null) {
      this.mWrinklesRemoveFilter2.setWrinklesAlpha(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setRenderMode(paramInt);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setRenderMode(paramInt);
    }
    if (this.mWrinklesRemoveFilter2 != null) {
      this.mWrinklesRemoveFilter2.setRenderMode(paramInt);
    }
    if (this.mContrastFilter != null) {
      this.mContrastFilter.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void setToothWhitenAlpha(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setToothWhitenAlpha(paramFloat);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mWrinklesRemoveFilter2 != null) {
      this.mWrinklesRemoveFilter2.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
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