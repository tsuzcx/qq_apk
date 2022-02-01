package com.tencent.mobileqq.triton.internal.script;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ScriptRuntime$callback2Script$1
  implements Runnable
{
  ScriptRuntime$callback2Script$1(ScriptRuntime paramScriptRuntime, int paramInt, String paramString) {}
  
  public final void run()
  {
    try
    {
      ScriptRuntime.Companion.access$nativeCallback2Script(ScriptRuntime.Companion, ScriptRuntime.access$getNativeHandle$p(this.this$0), this.$callbackId, "WeixinJSBridge.invokeCallbackHandler", this.$result);
      localUnit = Unit.INSTANCE;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Unit localUnit;
      label28:
      break label28;
    }
    ScriptRuntime.Companion.access$nativeCallback2Script(ScriptRuntime.Companion, ScriptRuntime.access$getNativeHandle$p(this.this$0), this.$callbackId, "WeixinJSBridge.invokeCallbackHandler", this.$result);
    localUnit = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.callback2Script.1
 * JD-Core Version:    0.7.0.1
 */