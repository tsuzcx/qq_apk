package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import azjb;
import azjl;
import azjm;
import azjn;
import azkc;

public class LocationBaseStateDetector$1
  implements Runnable
{
  public LocationBaseStateDetector$1(azjm paramazjm) {}
  
  public void run()
  {
    if (azjb.b) {
      azjm.a(this.this$0).a(azjm.a(this.this$0).a(), azjm.a(this.this$0).a());
    }
    for (;;)
    {
      azjm.a(this.this$0).postDelayed(this, azjb.h);
      return;
      azjm.a(this.this$0).a(azjm.a(this.this$0).a(), azjm.a(this.this$0).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */