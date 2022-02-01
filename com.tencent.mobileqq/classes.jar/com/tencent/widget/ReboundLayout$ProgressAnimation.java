package com.tencent.widget;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ReboundLayout$ProgressAnimation
  extends Animation
{
  private float endProgress = 1.0F;
  private float startProgress = 0.0F;
  
  private ReboundLayout$ProgressAnimation(ReboundLayout paramReboundLayout)
  {
    ReboundLayout.access$102(paramReboundLayout, true);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.endProgress;
    float f2 = this.startProgress;
    paramFloat = (f1 - f2) * paramFloat + f2;
    paramTransformation = this.this$0;
    paramTransformation.scrollBy((int)((400 - paramTransformation.getScrollX()) * paramFloat), 0);
    if (paramFloat == 1.0F) {
      ReboundLayout.access$102(this.this$0, false);
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    setDuration(260L);
    setInterpolator(new AccelerateInterpolator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ReboundLayout.ProgressAnimation
 * JD-Core Version:    0.7.0.1
 */