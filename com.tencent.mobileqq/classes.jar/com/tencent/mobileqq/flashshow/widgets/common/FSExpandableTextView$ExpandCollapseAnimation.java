package com.tencent.mobileqq.flashshow.widgets.common;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class FSExpandableTextView$ExpandCollapseAnimation
  extends Animation
{
  int a = 0;
  int b = 0;
  
  private FSExpandableTextView$ExpandCollapseAnimation(FSExpandableTextView paramFSExpandableTextView, int paramInt1, int paramInt2)
  {
    setDuration(paramFSExpandableTextView.d);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    int i = this.b;
    int j = this.a;
    i = (int)((i - j) * paramFloat + j);
    this.c.a.setMaxHeight(i - this.c.k);
    this.c.getLayoutParams().height = i;
    this.c.requestLayout();
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSExpandableTextView.ExpandCollapseAnimation
 * JD-Core Version:    0.7.0.1
 */