package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qcircle.weseevideo.composition.filter.MotionBlurFilter;
import com.tencent.qcircle.weseevideo.composition.filter.VignettingFilter2;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import java.util.HashMap;

public class EnhancedAEAdjust
  extends AEAdjust
{
  private boolean mHasMotionBlur;
  private MotionBlurFilter mMotionBlurFilter = new MotionBlurFilter();
  private VignettingFilter2 mVignettingFilter2 = new VignettingFilter2();
  
  private float parseFloat(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap = (String)paramHashMap.get(paramString);
    if (paramHashMap == null) {
      return 0.0F;
    }
    return Float.parseFloat(paramHashMap);
  }
  
  private int parseInteger(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap = (String)paramHashMap.get(paramString);
    if (paramHashMap == null) {
      return 0;
    }
    return Integer.parseInt(paramHashMap);
  }
  
  private void setMotionBlurLevel(HashMap<String, String> paramHashMap)
  {
    this.mHasMotionBlur = false;
    this.mMotionBlurFilter.resetParameters();
    if ((paramHashMap != null) && (parseFloat(paramHashMap, "motionBlurSize") > 0.0F))
    {
      this.mHasMotionBlur = true;
      this.mMotionBlurFilter.setParameters(parseFloat(paramHashMap, "motionBlurSize"), parseFloat(paramHashMap, "motionBlurAreaCenterX"), parseFloat(paramHashMap, "motionBlurAreaCenterY"), parseFloat(paramHashMap, "motionBlurAreaHorizontalAxis"), parseFloat(paramHashMap, "motionBlurAreaVerticalAxis"), parseInteger(paramHashMap, "motionBlurNumSamples"), parseFloat(paramHashMap, "motionBlurAreaGradientRatio"), parseInteger(paramHashMap, "motionBlurAngle"));
    }
  }
  
  private void setVignettingLevel(HashMap<String, String> paramHashMap)
  {
    VignettingFilter2 localVignettingFilter2 = this.mVignettingFilter2;
    if (localVignettingFilter2 != null)
    {
      localVignettingFilter2.setAlpha(0.0F);
      if (paramHashMap != null)
      {
        float f = parseFloat(paramHashMap, "vignettingValue");
        if (f > 0.0F) {
          this.mVignettingFilter2.setAlpha(f / 100.0F);
        }
      }
    }
  }
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      Object localObject = this.mVignettingFilter2;
      if (localObject != null) {
        ((VignettingFilter2)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mMotionBlurFilter;
      if (localObject != null) {
        ((MotionBlurFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
    }
    super.apply();
  }
  
  public void clear()
  {
    Object localObject = this.mVignettingFilter2;
    if (localObject != null)
    {
      ((VignettingFilter2)localObject).clearGLSLSelf();
      this.mVignettingFilter2 = null;
    }
    localObject = this.mMotionBlurFilter;
    if (localObject != null)
    {
      ((MotionBlurFilter)localObject).clearGLSLSelf();
      this.mMotionBlurFilter = null;
    }
    super.clear();
  }
  
  public Frame render(Frame paramFrame)
  {
    Frame localFrame = super.render(paramFrame);
    if (getAlpha() == 0.0F) {
      return localFrame;
    }
    paramFrame = this.mVignettingFilter2.render(localFrame);
    if (localFrame != paramFrame) {
      localFrame.unlock();
    }
    if (!this.mHasMotionBlur) {
      return paramFrame;
    }
    localFrame = this.mMotionBlurFilter.render(paramFrame);
    if (paramFrame != localFrame) {
      paramFrame.unlock();
    }
    return localFrame;
  }
  
  public void setAdjustParams(HashMap<String, String> paramHashMap)
  {
    AdjustRealConfig.TYPE[] arrayOfTYPE = AdjustRealConfig.TYPE.values();
    int j = arrayOfTYPE.length;
    int i = 0;
    while (i < j)
    {
      setAdjustLevel(arrayOfTYPE[i], 0);
      i += 1;
    }
    super.setAdjustParams(paramHashMap);
    setVignettingLevel(paramHashMap);
    setMotionBlurLevel(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.EnhancedAEAdjust
 * JD-Core Version:    0.7.0.1
 */