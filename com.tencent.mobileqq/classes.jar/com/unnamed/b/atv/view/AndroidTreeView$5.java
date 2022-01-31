package com.unnamed.b.atv.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class AndroidTreeView$5
  extends Animation
{
  AndroidTreeView$5(View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat == 1.0F)
    {
      this.val$v.setVisibility(8);
      return;
    }
    this.val$v.getLayoutParams().height = (this.val$initialHeight - (int)(this.val$initialHeight * paramFloat));
    this.val$v.requestLayout();
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.unnamed.b.atv.view.AndroidTreeView.5
 * JD-Core Version:    0.7.0.1
 */