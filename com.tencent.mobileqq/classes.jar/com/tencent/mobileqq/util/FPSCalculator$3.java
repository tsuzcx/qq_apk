package com.tencent.mobileqq.util;

import android.os.Handler;
import bfqd;
import bfqf;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bfqd parambfqd) {}
  
  public void run()
  {
    Object localObject1 = bfqd.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bfqd.a(this.this$0).size())
      {
        bfqf localbfqf = (bfqf)bfqd.a(this.this$0).get(i);
        bfqd.a(this.this$0, System.currentTimeMillis());
        localbfqf.onInfo(bfqd.a(this.this$0), 60.0D);
        i += 1;
      }
      bfqd.a(this.this$0).postDelayed(bfqd.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */