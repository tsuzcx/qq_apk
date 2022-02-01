package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "invoke", "com/tencent/mobileqq/triton/internal/engine/init/EngineInit$initEngine$1$1$1"}, k=3, mv={1, 1, 16})
final class EngineInit$initEngine$$inlined$withLock$lambda$1$1
  extends Lambda
  implements Function0<ScriptPlugin>
{
  EngineInit$initEngine$$inlined$withLock$lambda$1$1(EngineInit.initEngine..inlined.withLock.lambda.1 param1)
  {
    super(0);
  }
  
  @NotNull
  public final ScriptPlugin invoke()
  {
    return EngineInit.access$getPlatformConfig$p(this.this$0.this$0).getScriptPluginFactory().create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.initEngine..inlined.withLock.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */