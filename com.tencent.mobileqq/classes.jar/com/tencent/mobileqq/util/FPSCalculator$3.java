package com.tencent.mobileqq.util;

import android.os.Handler;
import azvy;
import azwa;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(azvy paramazvy) {}
  
  public void run()
  {
    Object localObject1 = azvy.a(this.this$0);
    int i = 0;
    try
    {
      while (i < azvy.a(this.this$0).size())
      {
        azwa localazwa = (azwa)azvy.a(this.this$0).get(i);
        azvy.a(this.this$0, System.currentTimeMillis());
        localazwa.onInfo(azvy.a(this.this$0), 60.0D);
        i += 1;
      }
      azvy.a(this.this$0).postDelayed(azvy.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */