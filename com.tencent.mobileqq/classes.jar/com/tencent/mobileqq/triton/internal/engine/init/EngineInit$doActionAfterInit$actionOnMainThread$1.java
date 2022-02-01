package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EngineInit$doActionAfterInit$actionOnMainThread$1
  extends Lambda
  implements Function0<Unit>
{
  EngineInit$doActionAfterInit$actionOnMainThread$1(EngineInit paramEngineInit, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Executor localExecutor = EngineInit.access$getPlatformConfig$p(this.this$0).getMainThreadExecutor();
    Object localObject = this.$action;
    if (localObject != null) {
      localObject = new EngineInit.sam.java_lang_Runnable.0((Function0)localObject);
    }
    for (;;)
    {
      localExecutor.execute((Runnable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.doActionAfterInit.actionOnMainThread.1
 * JD-Core Version:    0.7.0.1
 */