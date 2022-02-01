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
    Object localObject = this.val$activity;
    if (localObject != null) {
      OrientationDetector.access$102(this.this$0, ((Activity)localObject).getRequestedOrientation());
    }
    localObject = this.this$0;
    OrientationDetector.access$202((OrientationDetector)localObject, new OrientationDetector.RotationObserver((OrientationDetector)localObject, new Handler(Looper.getMainLooper())));
    OrientationDetector.access$200(this.this$0).registerObserver();
    localObject = this.this$0;
    OrientationDetector.access$002((OrientationDetector)localObject, ViolaUtils.isSystemAutoRotateOpen(((OrientationDetector)localObject).getContext()));
    localObject = this.this$0;
    ((OrientationDetector)localObject).enable(OrientationDetector.access$000((OrientationDetector)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.1
 * JD-Core Version:    0.7.0.1
 */