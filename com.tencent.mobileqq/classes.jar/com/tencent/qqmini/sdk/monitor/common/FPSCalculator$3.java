package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import bhbe;
import bhbg;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bhbe parambhbe) {}
  
  public void run()
  {
    Object localObject1 = bhbe.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bhbe.a(this.this$0).size())
      {
        bhbg localbhbg = (bhbg)bhbe.a(this.this$0).get(i);
        bhbe.a(this.this$0, System.currentTimeMillis());
        localbhbg.a(bhbe.a(this.this$0), 60.0D);
        i += 1;
      }
      bhbe.a(this.this$0).postDelayed(bhbe.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */