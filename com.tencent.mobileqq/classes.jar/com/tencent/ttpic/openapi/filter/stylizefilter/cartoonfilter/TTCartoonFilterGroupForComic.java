package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import android.util.Log;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter;
import com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.ArrayList;
import java.util.Map;

public class TTCartoonFilterGroupForComic
  extends AEChainI
  implements AEFilterI, IStlylizeFilterIniter
{
  private TTCartoonFilter mCartoonFilter;
  private TTLookupFilter mCartoonLUTFilter;
  private OptimGaussianMaskFilter mGaussianMaskFilter1;
  private OptimGaussianMaskFilter mGaussianMaskFilter2;
  private TTRevertFilter mRevertFilter;
  private float mScaleValue;
  private TTSobelFilter mSobelFilter;
  private TTStylizationFilter mStylizationFilter;
  private TTYellowBlurFilter mYellowBlurFilter;
  private TTYellowFilter mYellowFilter;
  ArrayList<String> names;
  ArrayList<Long> times;
  
  public TTCartoonFilterGroupForComic()
  {
    float f;
    if (AEOfflineConfig.getPhonePerfLevel() <= 3) {
      f = 2.0F;
    } else {
      f = 1.0F;
    }
    this.mScaleValue = f;
    this.names = new ArrayList();
    this.times = new ArrayList();
    this.mSobelFilter = new TTSobelFilter();
    this.mRevertFilter = new TTRevertFilter();
    this.mYellowFilter = new TTYellowFilter();
    this.mYellowBlurFilter = new TTYellowBlurFilter();
    this.mStylizationFilter = new TTStylizationFilter();
    this.mCartoonFilter = new TTCartoonFilter();
    this.mCartoonLUTFilter = new TTLookupFilter();
  }
  
  private void addPerforData(String paramString) {}
  
  private OptimGaussianMaskFilter getGaussianFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return null;
      }
      if (this.mGaussianMaskFilter2 == null)
      {
        this.mGaussianMaskFilter2 = new OptimGaussianMaskFilter(false, 2.0F, false);
        this.mGaussianMaskFilter2.applyFilterChain(false, paramInt2, paramInt3);
      }
      return this.mGaussianMaskFilter2;
    }
    if (this.mGaussianMaskFilter1 == null)
    {
      this.mGaussianMaskFilter1 = new OptimGaussianMaskFilter(false, 1.01F, false);
      this.mGaussianMaskFilter1.applyFilterChain(false, paramInt2, paramInt3);
    }
    return this.mGaussianMaskFilter1;
  }
  
  private void printLog()
  {
    int i = 1;
    String str = "LOG:";
    while (i < this.names.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" - ");
      localStringBuilder.append((String)this.names.get(i));
      localStringBuilder.append(":");
      localStringBuilder.append(((Long)this.times.get(i)).longValue() - ((Long)this.times.get(i - 1)).longValue());
      str = localStringBuilder.toString();
      i += 1;
    }
    Log.i("TTCartoonFilterGroup", str);
    resetPerform();
  }
  
  private Frame rendGaussianFilter(Frame paramFrame, int paramInt)
  {
    Object localObject = getGaussianFilter(paramInt, paramFrame.width, paramFrame.height);
    if (localObject == null) {
      return paramFrame;
    }
    Frame localFrame = FrameBufferCache.getInstance().get(paramFrame.width, paramFrame.height);
    localObject = ((OptimGaussianMaskFilter)localObject).RenderProcess(paramFrame, localFrame);
    if (localObject != paramFrame) {
      paramFrame.unlock();
    }
    if (localObject != localFrame) {
      localFrame.unlock();
    }
    return localObject;
  }
  
  private void resetPerform()
  {
    this.names.clear();
    this.times.clear();
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void apply()
  {
    this.mSobelFilter.apply();
    this.mRevertFilter.apply();
    this.mYellowFilter.apply();
    this.mYellowBlurFilter.apply();
    this.mStylizationFilter.apply();
    this.mCartoonFilter.apply();
    this.mCartoonLUTFilter.apply();
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    this.mSobelFilter.clearGLSLSelf();
    this.mRevertFilter.clearGLSLSelf();
    this.mYellowFilter.clearGLSLSelf();
    this.mYellowBlurFilter.clearGLSLSelf();
    this.mStylizationFilter.clearGLSLSelf();
    this.mCartoonFilter.clearGLSLSelf();
    this.mCartoonLUTFilter.clearGLSLSelf();
    this.mIsApplied = false;
    OptimGaussianMaskFilter localOptimGaussianMaskFilter = this.mGaussianMaskFilter1;
    if (localOptimGaussianMaskFilter != null) {
      localOptimGaussianMaskFilter.clear();
    }
    localOptimGaussianMaskFilter = this.mGaussianMaskFilter2;
    if (localOptimGaussianMaskFilter != null) {
      localOptimGaussianMaskFilter.clear();
    }
  }
  
  public Frame render(Frame paramFrame)
  {
    this.mYellowFilter.updateFrameSize(paramFrame.width, paramFrame.height);
    this.mYellowBlurFilter.updateFrameSize(paramFrame.width, paramFrame.height);
    addPerforData("startRender");
    addPerforData("origin");
    paramFrame.setCanUnlock(false);
    Frame localFrame1 = FrameBufferCache.getInstance().get((int)(paramFrame.width / this.mScaleValue), (int)(paramFrame.height / this.mScaleValue));
    this.mSobelFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, localFrame1.width, localFrame1.height, -1, 0.0D, localFrame1);
    addPerforData("sobel");
    localFrame1 = rendGaussianFilter(localFrame1, 0);
    addPerforData("gaussian");
    Frame localFrame2 = this.mRevertFilter.RenderProcess(localFrame1);
    if (localFrame2 != localFrame1) {
      localFrame1.unlock();
    }
    addPerforData("revert");
    localFrame1 = rendGaussianFilter(localFrame2, 1);
    addPerforData("gauss2");
    localFrame1.setCanUnlock(false);
    if (localFrame1 != localFrame2) {
      localFrame2.unlock();
    }
    this.mYellowFilter.setTexture2(paramFrame.getTextureId());
    Frame localFrame3 = this.mYellowFilter.RenderProcess(localFrame1);
    addPerforData("yelloFilter");
    this.mYellowBlurFilter.setTexture2(localFrame1.getTextureId());
    localFrame2 = this.mYellowBlurFilter.RenderProcess(localFrame3);
    addPerforData("yellowBlur");
    localFrame1.setCanUnlock(true);
    if (localFrame2 != localFrame1) {
      localFrame1.unlock();
    }
    if (localFrame2 != localFrame3) {
      localFrame3.unlock();
    }
    localFrame1 = this.mStylizationFilter.RenderProcess(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, paramFrame.width, paramFrame.height);
    addPerforData("styliza");
    if (localFrame1 != localFrame2) {
      localFrame2.unlock();
    }
    this.mCartoonFilter.setTexture2(localFrame1.getTextureId());
    this.mCartoonFilter.setUseHSVQuantization(true);
    localFrame2 = this.mCartoonFilter.RenderProcess(paramFrame);
    addPerforData("cartoon");
    if (localFrame1 != localFrame2) {
      localFrame1.unlock();
    }
    paramFrame.setCanUnlock(true);
    if (localFrame1 != paramFrame) {
      paramFrame.unlock();
    }
    paramFrame = this.mCartoonLUTFilter.RenderProcess(localFrame2);
    addPerforData("cartoonLUT");
    if (paramFrame != localFrame2) {
      localFrame2.unlock();
    }
    return paramFrame;
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    this.mCartoonLUTFilter.updateLutPaths(paramMap);
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap) {}
  
  public void updatePreview(Object paramObject) {}
  
  public void updateScaleValue(float paramFloat)
  {
    if ((paramFloat != 0.0F) && (paramFloat != 1.0F)) {
      this.mScaleValue = (1.0F / paramFloat);
    }
  }
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTCartoonFilterGroupForComic
 * JD-Core Version:    0.7.0.1
 */