package com.tencent.mobileqq.datareportviewer;

import android.animation.Animator;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class DataReportViewer$10
  extends D8SafeAnimatorListener
{
  DataReportViewer$10(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
    paramAnimator = new AlphaAnimation(0.0F, 1.0F);
    paramAnimator.setFillAfter(true);
    paramAnimator.setDuration(200L);
    this.a.a.startAnimation(paramAnimator);
    paramAnimator.setAnimationListener(new DataReportViewer.10.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.10
 * JD-Core Version:    0.7.0.1
 */