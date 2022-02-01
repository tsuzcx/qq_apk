package com.tencent.mobileqq.onlinestatus.auto.location;

import android.os.Handler;
import azcv;
import azdf;
import azdg;
import azdh;
import azdw;

public class LocationBaseStateDetector$1
  implements Runnable
{
  public LocationBaseStateDetector$1(azdg paramazdg) {}
  
  public void run()
  {
    if (azcv.b) {
      azdg.a(this.this$0).a(azdg.a(this.this$0).a(), azdg.a(this.this$0).a());
    }
    for (;;)
    {
      azdg.a(this.this$0).postDelayed(this, azcv.h);
      return;
      azdg.a(this.this$0).a(azdg.a(this.this$0).a(), azdg.a(this.this$0).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector.1
 * JD-Core Version:    0.7.0.1
 */