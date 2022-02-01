package com.tencent.qqlive.module.videoreport.dtreport.lazy;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;

class LazyInitObserver$3
  implements Runnable
{
  LazyInitObserver$3(LazyInitObserver paramLazyInitObserver, Activity paramActivity, ViewTreeObserver.OnDrawListener paramOnDrawListener) {}
  
  public void run()
  {
    if ((this.val$activity.getWindow().getDecorView() != null) && (this.val$activity.getWindow().getDecorView().getViewTreeObserver() != null)) {
      this.val$activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this.val$listener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitObserver.3
 * JD-Core Version:    0.7.0.1
 */