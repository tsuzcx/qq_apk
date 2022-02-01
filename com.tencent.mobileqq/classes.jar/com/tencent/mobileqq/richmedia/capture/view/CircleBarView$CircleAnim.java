package com.tencent.mobileqq.richmedia.capture.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class CircleBarView$CircleAnim
  extends Animation
{
  public CircleBarView$CircleAnim(CircleBarView paramCircleBarView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.a;
    CircleBarView.a(paramTransformation, CircleBarView.a(paramTransformation) * paramFloat * CircleBarView.b(this.a) / CircleBarView.c(this.a));
    CircleBarView.b(this.a, 30.0F);
    if (CircleBarView.d(this.a) != null)
    {
      if (CircleBarView.e(this.a) != null) {
        CircleBarView.e(this.a).setText(CircleBarView.d(this.a).a(paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a)));
      }
      CircleBarView.d(this.a).a(CircleBarView.f(this.a), paramFloat, CircleBarView.b(this.a), CircleBarView.c(this.a));
    }
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView.CircleAnim
 * JD-Core Version:    0.7.0.1
 */