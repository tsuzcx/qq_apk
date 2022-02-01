package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class ExpandableTextView$ExpandCollapseAnimation
  extends Animation
{
  private final View b;
  private final int c;
  private final int d;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = this.d;
    int j = this.c;
    i = (int)((i - j) * paramFloat + j);
    this.a.a.setMaxHeight(i - ExpandableTextView.a(this.a));
    if (Float.compare(ExpandableTextView.b(this.a), 1.0F) != 0) {
      ExpandableTextView.a(this.a.a, ExpandableTextView.b(this.a) + paramFloat * (1.0F - ExpandableTextView.b(this.a)));
    }
    this.b.getLayoutParams().height = i;
    this.b.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView.ExpandCollapseAnimation
 * JD-Core Version:    0.7.0.1
 */