package com.tencent.mobileqq.util;

import android.os.Handler;
import bgyu;
import bgyw;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bgyu parambgyu) {}
  
  public void run()
  {
    Object localObject1 = bgyu.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bgyu.a(this.this$0).size())
      {
        bgyw localbgyw = (bgyw)bgyu.a(this.this$0).get(i);
        bgyu.a(this.this$0, System.currentTimeMillis());
        localbgyw.onInfo(bgyu.a(this.this$0), 60.0D);
        i += 1;
      }
      bgyu.a(this.this$0).postDelayed(bgyu.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */