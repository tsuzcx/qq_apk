package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.model.WMElement;
import java.util.List;

public class WMFadeInAndOffAnimationFilter
  extends WMAnimationFilterBase
{
  private static final int ANIMATION_DURATION = 1000;
  private static final int MESC = 1000;
  private static final String TAG = WMFadeInAndOffAnimationFilter.class.getSimpleName();
  private int FADE_IN_END_TIME = -1;
  private float FADE_IN_RATIO = 1.0F;
  private int FADE_IN_TIME = -1;
  private int FADE_OFF_END_TIME = -1;
  private float FADE_OFF_RATIO = 1.0F;
  private int FADE_OFF_TIME = -1;
  
  public WMFadeInAndOffAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    super(paramWMElement, paramInt1, paramInt2, 1000);
  }
  
  protected void initAnimationTimePoints()
  {
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 0L, 0.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 1000L, 1.0F));
  }
  
  protected void setAnimationParams(long paramLong)
  {
    if (paramLong - getStartTime() <= this.FADE_IN_END_TIME)
    {
      this.mStartDelay = this.FADE_IN_TIME;
      this.mRatio = this.FADE_IN_RATIO;
      addParam(new UniformParam.FloatParam("texAlpha", getAnimationValue(paramLong)));
      return;
    }
    if ((this.FADE_OFF_TIME == -1) || (paramLong - getStartTime() <= this.FADE_OFF_TIME))
    {
      addParam(new UniformParam.FloatParam("texAlpha", 1.0F));
      return;
    }
    if ((this.FADE_OFF_TIME > -1) && (paramLong - getStartTime() <= this.FADE_OFF_END_TIME))
    {
      this.mStartDelay = this.FADE_OFF_TIME;
      this.mRatio = this.FADE_OFF_RATIO;
      addParam(new UniformParam.FloatParam("texAlpha", 1.0F - getAnimationValue(paramLong)));
      return;
    }
    addParam(new UniformParam.FloatParam("texAlpha", 0.0F));
  }
  
  public void updateParams(WMElement paramWMElement, int paramInt1, int paramInt2, long paramLong)
  {
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new UniformParam.Float2fParam("texAnchor", (paramWMElement.finalContentRect.left + paramWMElement.finalContentRect.right) / 2.0F - paramInt1 / 2, (paramWMElement.finalContentRect.top + paramWMElement.finalContentRect.bottom) / 2.0F - paramInt2 / 2));
    if (paramWMElement.animateAlphaStart0 == -1.0D)
    {
      paramInt1 = -1;
      this.FADE_IN_TIME = paramInt1;
      if (paramWMElement.animateAlphaStart1 != -1.0D) {
        break label205;
      }
      paramInt1 = -1;
      label109:
      this.FADE_IN_END_TIME = paramInt1;
      if (paramWMElement.animateAlphaEnd1 != -1.0D) {
        break label217;
      }
      paramInt1 = -1;
      label128:
      this.FADE_OFF_TIME = paramInt1;
      if (paramWMElement.animateAlphaEnd0 != -1.0D) {
        break label229;
      }
      paramInt1 = -1;
      label147:
      this.FADE_OFF_END_TIME = paramInt1;
      if (this.FADE_IN_TIME != -1) {
        break label241;
      }
      f = 1.0F;
      label163:
      this.FADE_IN_RATIO = f;
      if (this.FADE_OFF_TIME != -1) {
        break label255;
      }
    }
    label205:
    label217:
    label229:
    label241:
    label255:
    for (float f = 1.0F;; f = paramWMElement.animateAlphaEnd0 - paramWMElement.animateAlphaEnd1)
    {
      this.FADE_OFF_RATIO = f;
      setAnimationParams(paramLong);
      return;
      paramInt1 = (int)(paramWMElement.animateAlphaStart0 * 1000.0F);
      break;
      paramInt1 = (int)(paramWMElement.animateAlphaStart1 * 1000.0F);
      break label109;
      paramInt1 = (int)(paramWMElement.animateAlphaEnd1 * 1000.0F);
      break label128;
      paramInt1 = (int)(paramWMElement.animateAlphaEnd0 * 1000.0F);
      break label147;
      f = paramWMElement.animateAlphaStart1 - paramWMElement.animateAlphaStart0;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMFadeInAndOffAnimationFilter
 * JD-Core Version:    0.7.0.1
 */