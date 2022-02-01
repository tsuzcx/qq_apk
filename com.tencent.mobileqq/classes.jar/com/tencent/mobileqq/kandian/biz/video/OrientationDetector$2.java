package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;

class OrientationDetector$2
  implements Runnable
{
  OrientationDetector$2(OrientationDetector paramOrientationDetector, Activity paramActivity) {}
  
  public void run()
  {
    OrientationDetector.a(this.this$0, this.a.getRequestedOrientation());
    OrientationDetector localOrientationDetector = this.this$0;
    OrientationDetector.a(localOrientationDetector, new OrientationDetector.RotationObserver(localOrientationDetector, new Handler(Looper.getMainLooper())));
    OrientationDetector.a(this.this$0).a();
    OrientationDetector.a(this.this$0, ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).isSystemAutoRotateOpen(this.a));
    localOrientationDetector = this.this$0;
    localOrientationDetector.a(OrientationDetector.a(localOrientationDetector));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */