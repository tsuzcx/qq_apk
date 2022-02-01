package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class TTEngine$1
  implements Function1<byte[], Unit>
{
  TTEngine$1(TTEngine paramTTEngine, EngineContext paramEngineContext) {}
  
  public Unit invoke(byte[] paramArrayOfByte)
  {
    ErrorCallback localErrorCallback = (ErrorCallback)this.val$engineContext.getStatisticsManager().getErrorCallback().getValue();
    if (localErrorCallback != null)
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = new String(paramArrayOfByte);
      } else {
        paramArrayOfByte = "unknown error";
      }
      localErrorCallback.onScriptError(paramArrayOfByte, "");
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.1
 * JD-Core Version:    0.7.0.1
 */