package com.tencent.widget;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ReboundVLayout$ProgressAnimation
  extends Animation
{
  private float endProgress = 1.0F;
  private float startProgress = 0.0F;
  
  private ReboundVLayout$ProgressAnimation(ReboundVLayout paramReboundVLayout)
  {
    ReboundVLayout.access$102(paramReboundVLayout, true);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.endProgress;
    float f2 = this.startProgress;
    paramFloat = (f1 - f2) * paramFloat + f2;
    paramTransformation = this.this$0;
    paramTransformation.scrollBy(0, (int)((1000 - paramTransformation.getScrollY()) * paramFloat));
    if (paramFloat == 1.0F) {
      ReboundVLayout.access$102(this.this$0, false);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    setDuration(260L);
    setInterpolator(new AccelerateInterpolator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ReboundVLayout.ProgressAnimation
 * JD-Core Version:    0.7.0.1
 */