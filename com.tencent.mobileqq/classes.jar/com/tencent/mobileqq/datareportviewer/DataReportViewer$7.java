package com.tencent.mobileqq.datareportviewer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DataReportViewer$7
  implements ValueAnimator.AnimatorUpdateListener
{
  DataReportViewer$7(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.7
 * JD-Core Version:    0.7.0.1
 */