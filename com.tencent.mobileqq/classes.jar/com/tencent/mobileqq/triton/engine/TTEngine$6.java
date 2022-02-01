package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;

class TTEngine$6
  implements Runnable
{
  TTEngine$6(TTEngine paramTTEngine, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.val$runnable.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      String str;
      ErrorCallback localErrorCallback;
      do
      {
        str = "postRunnableToMessageQueue run failed " + this.val$runnable;
        Logger.e(TTEngine.access$000(this.this$0), str, localThrowable);
        localErrorCallback = (ErrorCallback)this.this$0.getEngineContext().getStatisticsManager().getErrorCallback().getValue();
      } while (localErrorCallback == null);
      localErrorCallback.onError(str, new TritonException(str, ErrorCodes.UNKNOWN, localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.6
 * JD-Core Version:    0.7.0.1
 */