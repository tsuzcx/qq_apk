package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class TTEngine$2
  implements Function0<Unit>
{
  TTEngine$2(TTEngine paramTTEngine, EngineContext paramEngineContext) {}
  
  public Unit invoke()
  {
    ErrorCallback localErrorCallback = (ErrorCallback)this.val$engineContext.getStatisticsManager().getErrorCallback().getValue();
    if (localErrorCallback != null) {
      localErrorCallback.onError("black screen detected", new TritonException("black screen detected", ErrorCodes.RENDER_BLACK_SCREEN));
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.2
 * JD-Core Version:    0.7.0.1
 */