package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeFieldProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent;", "", "nativeInstancePointer", "", "gameThreadExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "jankTraceLevelHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getTraceInfoHolder", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "(JLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "getTraceInfo", "", "callback", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
@NativeProxy(allFields=false, allMethods=false, namespace="triton::jni")
public final class JankCanaryAgent
{
  public static final JankCanaryAgent.Companion Companion = new JankCanaryAgent.Companion(null);
  private final Executor gameThreadExecutor;
  private final Executor mainThreadExecutor;
  @NativeFieldProxy(setter=false)
  private final long nativeInstancePointer;
  
  public JankCanaryAgent(long paramLong, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull ValueHolder<JankTraceLevel> paramValueHolder, @NotNull ValueHolder<GetTraceInfoCallback> paramValueHolder1)
  {
    this.nativeInstancePointer = paramLong;
    this.gameThreadExecutor = paramExecutor1;
    this.mainThreadExecutor = paramExecutor2;
    if (this.nativeInstancePointer != 0L)
    {
      paramValueHolder.observe((Function1)new JankCanaryAgent.1(this));
      paramValueHolder1.observe((Function1)new JankCanaryAgent.2(this, paramValueHolder1));
      return;
    }
    paramExecutor1 = new StringBuilder();
    paramExecutor1.append("pointer ");
    paramExecutor1.append("JankCanaryAgent::nativeInstancePointer");
    paramExecutor1.append(" is nullptr");
    throw ((Throwable)new TritonInitException(paramExecutor1.toString(), ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null));
  }
  
  private final void getTraceInfo(GetTraceInfoCallback paramGetTraceInfoCallback)
  {
    this.gameThreadExecutor.execute((Runnable)new JankCanaryAgent.getTraceInfo.1(this, paramGetTraceInfoCallback));
  }
  
  @JvmStatic
  private static final native Object[] nativeGetBriefTraceInfo(long paramLong, Class<Object> paramClass);
  
  @JvmStatic
  private static final native void nativeSetJankTraceLevel(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent
 * JD-Core Version:    0.7.0.1
 */