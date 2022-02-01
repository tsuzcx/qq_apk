package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class MetaballView$MoveAnimation
  extends Animation
{
  private MetaballView$MoveAnimation(MetaballView paramMetaballView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    MetaballView.a(this.a, paramFloat);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.MetaballView.MoveAnimation
 * JD-Core Version:    0.7.0.1
 */