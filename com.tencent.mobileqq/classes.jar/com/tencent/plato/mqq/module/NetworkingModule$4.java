package com.tencent.plato.mqq.module;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.plato.utils.FuncUtil;

class NetworkingModule$4
  implements ProgressListener
{
  long last = System.nanoTime();
  
  NetworkingModule$4(NetworkingModule paramNetworkingModule, IFunction paramIFunction) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = System.nanoTime();
    if ((paramBoolean) || (NetworkingModule.access$000(l, this.last)))
    {
      FuncUtil.invokeAlive(this.val$sendProgress, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      this.last = l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule.4
 * JD-Core Version:    0.7.0.1
 */