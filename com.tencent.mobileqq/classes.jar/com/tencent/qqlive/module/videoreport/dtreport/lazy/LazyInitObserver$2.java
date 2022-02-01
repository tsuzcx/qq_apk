package com.tencent.qqlive.module.videoreport.dtreport.lazy;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;

class LazyInitObserver$2
  implements ViewTreeObserver.OnPreDrawListener
{
  LazyInitObserver$2(LazyInitObserver paramLazyInitObserver, Activity paramActivity) {}
  
  public boolean onPreDraw()
  {
    this.val$activity.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
    LazyInitObserver.access$200(this.this$0, 70L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitObserver.2
 * JD-Core Version:    0.7.0.1
 */