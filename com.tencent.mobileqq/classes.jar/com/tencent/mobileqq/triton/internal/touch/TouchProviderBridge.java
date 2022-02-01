package com.tencent.mobileqq.triton.internal.touch;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.touch.TTTouchEvents;
import com.tencent.mobileqq.triton.view.GameView;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "", "jankCanaryAgent", "Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent;", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "lastClicksCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lkotlin/Function1;", "", "", "lastClickInfoCallbackHolder", "(Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent;Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "manager", "Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager;", "nativeInstance", "", "attachView", "view", "Lcom/tencent/mobileqq/triton/view/GameView;", "density", "", "flushTouchEvents", "getLastClicks", "getTheLastClickInfo", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
@NativeProxy(allFields=false, allMethods=false, namespace="triton::jni")
public final class TouchProviderBridge
{
  public static final TouchProviderBridge.Companion Companion = new TouchProviderBridge.Companion(null);
  private final ValueHolder<Function1<String, Unit>> lastClickInfoCallbackHolder;
  private final ValueHolder<Function1<String, Unit>> lastClicksCallbackHolder;
  private final LifeCycleOwner lifeCycleOwner;
  private TouchEventManager manager;
  @NativeFieldProxy(setter=false)
  private final long nativeInstance;
  
  public TouchProviderBridge(@NotNull JankCanaryAgent paramJankCanaryAgent, @NotNull LifeCycleOwner paramLifeCycleOwner, @NotNull ValueHolder<Function1<String, Unit>> paramValueHolder1, @NotNull ValueHolder<Function1<String, Unit>> paramValueHolder2)
  {
    this.lifeCycleOwner = paramLifeCycleOwner;
    this.lastClicksCallbackHolder = paramValueHolder1;
    this.lastClickInfoCallbackHolder = paramValueHolder2;
    try
    {
      l = TouchProviderBridge.Companion.access$nativeCreate(Companion, paramJankCanaryAgent);
    }
    catch (UnsatisfiedLinkError paramLifeCycleOwner)
    {
      long l;
      label57:
      break label57;
    }
    l = TouchProviderBridge.Companion.access$nativeCreate(Companion, paramJankCanaryAgent);
    this.nativeInstance = l;
    if (this.nativeInstance != 0L)
    {
      this.lastClicksCallbackHolder.observe((Function1)new TouchProviderBridge.1(this));
      this.lastClickInfoCallbackHolder.observe((Function1)new TouchProviderBridge.2(this));
      return;
    }
    paramJankCanaryAgent = new StringBuilder();
    paramJankCanaryAgent.append("pointer ");
    paramJankCanaryAgent.append("TouchProviderBridge::nativeInstance");
    paramJankCanaryAgent.append(" is nullptr");
    throw ((Throwable)new TritonInitException(paramJankCanaryAgent.toString(), ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null));
  }
  
  private final String getLastClicks()
  {
    Object localObject = this.manager;
    if (localObject != null)
    {
      localObject = ((TouchEventManager)localObject).getLastClicks();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  private final String getTheLastClickInfo()
  {
    Object localObject = this.manager;
    if (localObject != null)
    {
      localObject = ((TouchEventManager)localObject).getTheLastClickInfo();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @JvmStatic
  private static final native long nativeCreate(JankCanaryAgent paramJankCanaryAgent);
  
  @JvmStatic
  private static final native void nativeOnTouchEvent(long paramLong, ArrayList<TTTouchEvents> paramArrayList);
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void attachView(@NotNull GameView paramGameView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramGameView, "view");
    this.manager = new TouchEventManager(paramFloat, (Function1)new TouchProviderBridge.attachView.1(this));
    paramGameView.setGameOnTouchListener((Function1)new TouchProviderBridge.attachView.2(this));
  }
  
  public final void flushTouchEvents()
  {
    TouchEventManager localTouchEventManager = this.manager;
    if (localTouchEventManager != null) {
      localTouchEventManager.flushTouchEvents();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge
 * JD-Core Version:    0.7.0.1
 */