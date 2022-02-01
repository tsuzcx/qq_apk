package com.tencent.rlottie.decoder;

import java.util.HashMap;
import java.util.LinkedList;

class DispatchQueuePool$2$1
  implements Runnable
{
  DispatchQueuePool$2$1(DispatchQueuePool.2 param2) {}
  
  public void run()
  {
    DispatchQueuePool.d(this.a.this$0);
    int i = ((Integer)DispatchQueuePool.e(this.a.this$0).get(this.a.b)).intValue() - 1;
    if (i == 0)
    {
      DispatchQueuePool.e(this.a.this$0).remove(this.a.b);
      DispatchQueuePool.c(this.a.this$0).remove(this.a.b);
      DispatchQueuePool.a(this.a.this$0).add(this.a.b);
      return;
    }
    DispatchQueuePool.e(this.a.this$0).put(this.a.b, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.DispatchQueuePool.2.1
 * JD-Core Version:    0.7.0.1
 */