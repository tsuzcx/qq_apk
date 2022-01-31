package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import bdrp;
import bdrr;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bdrp parambdrp) {}
  
  public void run()
  {
    Object localObject1 = bdrp.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bdrp.a(this.this$0).size())
      {
        bdrr localbdrr = (bdrr)bdrp.a(this.this$0).get(i);
        bdrp.a(this.this$0, System.currentTimeMillis());
        localbdrr.a(bdrp.a(this.this$0), 60.0D);
        i += 1;
      }
      bdrp.a(this.this$0).postDelayed(bdrp.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */