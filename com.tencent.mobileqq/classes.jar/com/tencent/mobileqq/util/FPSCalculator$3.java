package com.tencent.mobileqq.util;

import android.os.Handler;
import bdat;
import bdav;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bdat parambdat) {}
  
  public void run()
  {
    Object localObject1 = bdat.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bdat.a(this.this$0).size())
      {
        bdav localbdav = (bdav)bdat.a(this.this$0).get(i);
        bdat.a(this.this$0, System.currentTimeMillis());
        localbdav.onInfo(bdat.a(this.this$0), 60.0D);
        i += 1;
      }
      bdat.a(this.this$0).postDelayed(bdat.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */