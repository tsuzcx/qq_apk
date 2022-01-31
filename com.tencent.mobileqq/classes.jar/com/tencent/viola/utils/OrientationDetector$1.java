package com.tencent.viola.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

class OrientationDetector$1
  implements Runnable
{
  OrientationDetector$1(OrientationDetector paramOrientationDetector, Activity paramActivity) {}
  
  public void run()
  {
    if (this.val$activity != null) {
      OrientationDetector.access$102(this.this$0, this.val$activity.getRequestedOrientation());
    }
    OrientationDetector.access$202(this.this$0, new OrientationDetector.RotationObserver(this.this$0, new Handler(Looper.getMainLooper())));
    OrientationDetector.access$200(this.this$0).registerObserver();
    OrientationDetector.access$002(this.this$0, ViolaUtils.isSystemAutoRotateOpen(this.this$0.getContext()));
    this.this$0.enable(OrientationDetector.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.1
 * JD-Core Version:    0.7.0.1
 */