package com.tencent.plato.mqq.module;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.mqq.network.ProgressListener;

class NetworkingModule$2$1
  implements ProgressListener
{
  long last = System.nanoTime();
  
  NetworkingModule$2$1(NetworkingModule.2 param2) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = System.nanoTime();
    if ((!paramBoolean) && (!NetworkingModule.access$000(l, this.last))) {
      return;
    }
    this.this$1.val$receivedProgress.invokeAlive(new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.last = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule.2.1
 * JD-Core Version:    0.7.0.1
 */