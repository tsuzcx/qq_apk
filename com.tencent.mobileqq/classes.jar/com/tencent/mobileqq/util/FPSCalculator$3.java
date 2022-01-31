package com.tencent.mobileqq.util;

import android.os.Handler;
import bcwk;
import bcwm;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bcwk parambcwk) {}
  
  public void run()
  {
    Object localObject1 = bcwk.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bcwk.a(this.this$0).size())
      {
        bcwm localbcwm = (bcwm)bcwk.a(this.this$0).get(i);
        bcwk.a(this.this$0, System.currentTimeMillis());
        localbcwm.onInfo(bcwk.a(this.this$0), 60.0D);
        i += 1;
      }
      bcwk.a(this.this$0).postDelayed(bcwk.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */