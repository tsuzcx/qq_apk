package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.model.WMElement;
import java.util.List;

public class WMScaleAnimationFilter
  extends WMAnimationFilterBase
{
  private static final int ANIMATION_DURATION = 1000;
  private static final int ANIMATION_FRAMES = 16;
  private static final int FRAME_DURATION = 62;
  private static final String TAG = WMScaleAnimationFilter.class.getSimpleName();
  
  public WMScaleAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    super(paramWMElement, paramInt1, paramInt2, 1000);
  }
  
  protected void initAnimationTimePoints()
  {
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 0L, 1.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 124L, 1.03F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 248L, 0.97F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 372L, 1.03F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 496L, 0.97F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 620L, 1.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 992L, 1.0F));
  }
  
  protected void setAnimationParams(long paramLong)
  {
    addParam(new UniformParam.FloatParam("texScale", getAnimationValue(paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMScaleAnimationFilter
 * JD-Core Version:    0.7.0.1
 */