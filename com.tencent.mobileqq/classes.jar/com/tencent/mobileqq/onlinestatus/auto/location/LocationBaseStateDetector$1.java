package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import com.tencent.mobileqq.onlinestatus.auto.Constant;

class LocationBaseStateDetector$1
  implements Runnable
{
  LocationBaseStateDetector$1(LocationBaseStateDetector paramLocationBaseStateDetector) {}
  
  public void run()
  {
    if (Constant.P) {
      LocationBaseStateDetector.b(this.this$0).a(LocationBaseStateDetector.a(this.this$0).f(), LocationBaseStateDetector.a(this.this$0).g());
    } else {
      LocationBaseStateDetector.b(this.this$0).a(LocationBaseStateDetector.c(this.this$0).f(), LocationBaseStateDetector.c(this.this$0).h());
    }
    LocationBaseStateDetector.d(this.this$0).postDelayed(this, Constant.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */