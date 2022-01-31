package com.unnamed.b.atv.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class AndroidTreeView$4
  extends Animation
{
  AndroidTreeView$4(View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.val$v.getLayoutParams();
    if (paramFloat == 1.0F) {}
    for (int i = -2;; i = (int)(this.val$targetHeight * paramFloat))
    {
      paramTransformation.height = i;
      this.val$v.requestLayout();
      return;
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.unnamed.b.atv.view.AndroidTreeView.4
 * JD-Core Version:    0.7.0.1
 */