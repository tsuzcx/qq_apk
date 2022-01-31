package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import beyc;
import beye;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(beyc parambeyc) {}
  
  public void run()
  {
    Object localObject1 = beyc.a(this.this$0);
    int i = 0;
    try
    {
      while (i < beyc.a(this.this$0).size())
      {
        beye localbeye = (beye)beyc.a(this.this$0).get(i);
        beyc.a(this.this$0, System.currentTimeMillis());
        localbeye.a(beyc.a(this.this$0), 60.0D);
        i += 1;
      }
      beyc.a(this.this$0).postDelayed(beyc.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */