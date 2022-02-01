package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import ayqi;
import ayqs;
import ayqt;
import ayqu;
import ayrj;

public class LocationBaseStateDetector$1
  implements Runnable
{
  public LocationBaseStateDetector$1(ayqt paramayqt) {}
  
  public void run()
  {
    if (ayqi.b) {
      ayqt.a(this.this$0).a(ayqt.a(this.this$0).a(), ayqt.a(this.this$0).a());
    }
    for (;;)
    {
      ayqt.a(this.this$0).postDelayed(this, ayqi.h);
      return;
      ayqt.a(this.this$0).a(ayqt.a(this.this$0).a(), ayqt.a(this.this$0).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */