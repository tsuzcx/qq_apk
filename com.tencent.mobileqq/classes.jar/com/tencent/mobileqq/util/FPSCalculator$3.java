package com.tencent.mobileqq.util;

import android.os.Handler;
import baxc;
import baxe;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(baxc parambaxc) {}
  
  public void run()
  {
    Object localObject1 = baxc.a(this.this$0);
    int i = 0;
    try
    {
      while (i < baxc.a(this.this$0).size())
      {
        baxe localbaxe = (baxe)baxc.a(this.this$0).get(i);
        baxc.a(this.this$0, System.currentTimeMillis());
        localbaxe.onInfo(baxc.a(this.this$0), 60.0D);
        i += 1;
      }
      baxc.a(this.this$0).postDelayed(baxc.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */