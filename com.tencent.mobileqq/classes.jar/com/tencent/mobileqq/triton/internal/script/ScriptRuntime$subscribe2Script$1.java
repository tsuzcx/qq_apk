package com.tencent.mobileqq.triton.internal.script;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ScriptRuntime$subscribe2Script$1
  implements Runnable
{
  ScriptRuntime$subscribe2Script$1(ScriptRuntime paramScriptRuntime, String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      ScriptRuntime.Companion.access$nativeSubscribe2Script(ScriptRuntime.Companion, ScriptRuntime.access$getNativeHandle$p(this.this$0), "WeixinJSBridge.subscribeHandler", this.$eventName, this.$params);
      localUnit = Unit.INSTANCE;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Unit localUnit;
      label28:
      break label28;
    }
    ScriptRuntime.Companion.access$nativeSubscribe2Script(ScriptRuntime.Companion, ScriptRuntime.access$getNativeHandle$p(this.this$0), "WeixinJSBridge.subscribeHandler", this.$eventName, this.$params);
    localUnit = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.subscribe2Script.1
 * JD-Core Version:    0.7.0.1
 */