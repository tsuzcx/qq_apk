package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import axwj;
import axwt;
import axwu;
import axwv;
import axxk;

public class LocationBaseStateDetector$1
  implements Runnable
{
  public LocationBaseStateDetector$1(axwu paramaxwu) {}
  
  public void run()
  {
    if (axwj.b) {
      axwu.a(this.this$0).a(axwu.a(this.this$0).a(), axwu.a(this.this$0).a());
    }
    for (;;)
    {
      axwu.a(this.this$0).postDelayed(this, axwj.h);
      return;
      axwu.a(this.this$0).a(axwu.a(this.this$0).a(), axwu.a(this.this$0).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */