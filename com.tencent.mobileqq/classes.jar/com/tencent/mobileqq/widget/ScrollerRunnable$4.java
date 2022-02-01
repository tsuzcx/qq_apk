package com.tencent.mobileqq.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import bhja;
import bhjb;

public class ScrollerRunnable$4
  implements Runnable
{
  ScrollerRunnable$4(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofInt(this.a, "backgroundColor", new int[] { 11580351, 867218367 });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setEvaluator(new ArgbEvaluator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(this.a, "backgroundColor", new int[] { 867218367, 11580351 });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator2.setEvaluator(new ArgbEvaluator());
    localObjectAnimator1.addListener(new bhja(this, localObjectAnimator2));
    localObjectAnimator2.addListener(new bhjb(this));
    localObjectAnimator1.start();
    ScrollerRunnable.a(this.this$0, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.4
 * JD-Core Version:    0.7.0.1
 */