package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import com.tencent.mobileqq.onlinestatus.auto.Constant;

class LocationBaseStateDetector$1
  implements Runnable
{
  LocationBaseStateDetector$1(LocationBaseStateDetector paramLocationBaseStateDetector) {}
  
  public void run()
  {
    if (Constant.b) {
      LocationBaseStateDetector.a(this.this$0).a(LocationBaseStateDetector.a(this.this$0).a(), LocationBaseStateDetector.a(this.this$0).a());
    }
    for (;;)
    {
      LocationBaseStateDetector.a(this.this$0).postDelayed(this, Constant.h);
      return;
      LocationBaseStateDetector.a(this.this$0).a(LocationBaseStateDetector.a(this.this$0).a(), LocationBaseStateDetector.a(this.this$0).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */