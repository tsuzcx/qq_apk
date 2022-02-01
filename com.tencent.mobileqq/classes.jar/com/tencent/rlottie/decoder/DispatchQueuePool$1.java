package com.tencent.rlottie.decoder;

import android.os.SystemClock;
import java.util.LinkedList;

class DispatchQueuePool$1
  implements Runnable
{
  DispatchQueuePool$1(DispatchQueuePool paramDispatchQueuePool) {}
  
  public void run()
  {
    if (!DispatchQueuePool.a(this.this$0).isEmpty())
    {
      long l = SystemClock.elapsedRealtime();
      int j = DispatchQueuePool.a(this.this$0).size();
      int i = 0;
      while (i < j)
      {
        DispatchQueue localDispatchQueue = (DispatchQueue)DispatchQueuePool.a(this.this$0).get(i);
        int m = i;
        int k = j;
        if (localDispatchQueue.a() < l - 30000L)
        {
          localDispatchQueue.b();
          DispatchQueuePool.a(this.this$0).remove(i);
          DispatchQueuePool.b(this.this$0);
          m = i - 1;
          k = j - 1;
        }
        i = m + 1;
        j = k;
      }
    }
    if ((DispatchQueuePool.a(this.this$0).isEmpty()) && (DispatchQueuePool.c(this.this$0).isEmpty()))
    {
      DispatchQueuePool.a(this.this$0, false);
      return;
    }
    DispatchQueue.a(this, 30000L);
    DispatchQueuePool.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.DispatchQueuePool.1
 * JD-Core Version:    0.7.0.1
 */