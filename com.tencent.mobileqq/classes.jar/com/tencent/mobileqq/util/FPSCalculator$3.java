package com.tencent.mobileqq.util;

import android.os.Handler;
import bhgt;
import bhgv;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bhgt parambhgt) {}
  
  public void run()
  {
    Object localObject1 = bhgt.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bhgt.a(this.this$0).size())
      {
        bhgv localbhgv = (bhgv)bhgt.a(this.this$0).get(i);
        bhgt.a(this.this$0, System.currentTimeMillis());
        localbhgv.onInfo(bhgt.a(this.this$0), 60.0D);
        i += 1;
      }
      bhgt.a(this.this$0).postDelayed(bhgt.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */