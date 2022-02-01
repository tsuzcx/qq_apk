package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge;", "", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;)V", "debugMessageListener", "com/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1", "Lcom/tencent/mobileqq/triton/internal/script/InspectorBridge$debugMessageListener$1;", "mProxy", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "nativeInstance", "", "nativeCreate", "sendMessageToDebugger", "", "message", "", "setProxy", "proxy", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
@NativeProxy(allFields=false, allMethods=false, namespace="triton::jni")
public final class InspectorBridge
{
  public static final InspectorBridge.Companion Companion = new InspectorBridge.Companion(null);
  private static final String TAG = "InspectorBridge";
  private final InspectorBridge.debugMessageListener.1 debugMessageListener;
  private final LifeCycleOwner lifeCycleOwner;
  private InspectorAgent mProxy;
  @NativeFieldProxy(setter=false)
  private final long nativeInstance;
  
  public InspectorBridge(@NotNull LifeCycleOwner paramLifeCycleOwner)
  {
    this.lifeCycleOwner = paramLifeCycleOwner;
    try
    {
      l = nativeCreate();
    }
    catch (UnsatisfiedLinkError paramLifeCycleOwner)
    {
      long l;
      label23:
      break label23;
    }
    l = nativeCreate();
    this.nativeInstance = l;
    this.debugMessageListener = new InspectorBridge.debugMessageListener.1(this);
  }
  
  private final native long nativeCreate();
  
  @NativeMethodProxy
  private final void sendMessageToDebugger(String paramString)
  {
    try
    {
      localObject = this.mProxy;
      if (localObject != null)
      {
        ((InspectorAgent)localObject).sendMessageToDebugger(paramString);
        localObject = Unit.INSTANCE;
        return;
      }
    }
    catch (Throwable paramString)
    {
      break label46;
      Object localObject = this.mProxy;
      if (localObject != null)
      {
        ((InspectorAgent)localObject).sendMessageToDebugger(paramString);
        paramString = Unit.INSTANCE;
        return;
        Logger.e("InspectorBridge", "sendMessageToDebugger", paramString);
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label25:
      label46:
      break label25;
    }
  }
  
  @JvmStatic
  private static final native void sendMessageToEngine(long paramLong, String paramString);
  
  public final void setProxy(@NotNull InspectorAgent paramInspectorAgent)
  {
    Intrinsics.checkParameterIsNotNull(paramInspectorAgent, "proxy");
    this.mProxy = paramInspectorAgent;
    paramInspectorAgent.setOnDebuggerMessageListener((InspectorAgent.DebuggerMessageListener)this.debugMessageListener);
    this.lifeCycleOwner.observeLifeCycle((LifeCycle)new InspectorBridge.setProxy.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.InspectorBridge
 * JD-Core Version:    0.7.0.1
 */