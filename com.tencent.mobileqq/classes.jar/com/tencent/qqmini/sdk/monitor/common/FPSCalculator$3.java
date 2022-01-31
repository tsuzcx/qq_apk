package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import bgwx;
import bgwz;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bgwx parambgwx) {}
  
  public void run()
  {
    Object localObject1 = bgwx.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bgwx.a(this.this$0).size())
      {
        bgwz localbgwz = (bgwz)bgwx.a(this.this$0).get(i);
        bgwx.a(this.this$0, System.currentTimeMillis());
        localbgwz.a(bgwx.a(this.this$0), 60.0D);
        i += 1;
      }
      bgwx.a(this.this$0).postDelayed(bgwx.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */