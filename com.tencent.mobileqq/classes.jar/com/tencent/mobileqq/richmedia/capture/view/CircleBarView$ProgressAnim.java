package com.tencent.mobileqq.richmedia.capture.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class CircleBarView$ProgressAnim
  extends Animation
{
  public CircleBarView$ProgressAnim(CircleBarView paramCircleBarView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.a;
    CircleBarView.a(paramTransformation, CircleBarView.a(paramTransformation) * paramFloat * CircleBarView.b(this.a) / CircleBarView.c(this.a));
    CircleBarView.b(this.a, 30.0F);
    if (CircleBarView.a(this.a) != null)
    {
      if (CircleBarView.a(this.a) != null) {
        CircleBarView.a(this.a).setText(CircleBarView.a(this.a).a(paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a)));
      }
      CircleBarView.a(this.a).a(CircleBarView.a(this.a), paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a));
    }
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView.ProgressAnim
 * JD-Core Version:    0.7.0.1
 */