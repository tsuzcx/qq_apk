package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EngineInit$performLaunchGame$2
  extends Lambda
  implements Function0<Unit>
{
  EngineInit$performLaunchGame$2(EngineInit paramEngineInit)
  {
    super(0);
  }
  
  public final void invoke()
  {
    EngineInit.access$getEngineContextImpl$p(this.this$0).getScriptPluginWrapper().onCreate((TritonEngine)EngineInit.access$getEngine$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.performLaunchGame.2
 * JD-Core Version:    0.7.0.1
 */