package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "engineLock", "Ljava/util/concurrent/locks/Lock;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Ljava/util/concurrent/locks/Lock;)V", "accumulatedDrawCalls", "", "getAccumulatedDrawCalls", "()J", "accumulatedDrawCallsHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "getAccumulatedDrawCallsHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "accumulatedFrames", "getAccumulatedFrames", "accumulatedFramesHolder", "getAccumulatedFramesHolder", "currentDrawCalls", "getCurrentDrawCalls", "currentDrawCallsHolder", "getCurrentDrawCallsHolder", "currentFPS", "", "getCurrentFPS", "()F", "currentFPSHolder", "getCurrentFPSHolder", "errorCallback", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "getErrorCallback", "frameCallbackHolder", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "getFrameCallbackHolder", "<set-?>", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "jankTraceLevel", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "setJankTraceLevel", "(Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;)V", "jankTraceLevel$delegate", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "jankTraceLevelHolder", "getJankTraceLevelHolder", "lastBlackScreenTimeMillis", "getLastBlackScreenTimeMillis", "lastBlackScreenTimeMillisHolder", "getLastBlackScreenTimeMillisHolder", "lastClickInfo", "", "getLastClickInfo", "()Ljava/lang/String;", "lastClickInfoHolder", "Lkotlin/Function1;", "", "getLastClickInfoHolder", "lastClicks", "getLastClicks", "lastClicksHolder", "getLastClicksHolder", "subpackageLoadStatisticsCallback", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "getSubpackageLoadStatisticsCallback", "targetFPS", "getTargetFPS", "targetFPSHolder", "getTargetFPSHolder", "traceInfoCallbackHolder", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "getTraceInfoCallbackHolder", "getTraceInfo", "callback", "setErrorCallback", "setFrameCallback", "frameCallback", "setSubpackageLoadStatisticsCallback", "Triton_release"}, k=1, mv={1, 1, 16})
public final class StatisticsManagerImpl
  implements StatisticsManager
{
  @NotNull
  private final ValueHolder<Long> accumulatedDrawCallsHolder;
  @NotNull
  private final ValueHolder<Long> accumulatedFramesHolder;
  @NotNull
  private final ValueHolder<Long> currentDrawCallsHolder;
  @NotNull
  private final ValueHolder<Float> currentFPSHolder;
  @NotNull
  private final ValueHolder<ErrorCallback> errorCallback;
  @NotNull
  private final ValueHolder<FrameCallback> frameCallbackHolder;
  @NotNull
  private final ValueHolder jankTraceLevel$delegate;
  @NotNull
  private final ValueHolder<JankTraceLevel> jankTraceLevelHolder;
  @NotNull
  private final ValueHolder<Long> lastBlackScreenTimeMillisHolder;
  @NotNull
  private final ValueHolder<Function1<String, Unit>> lastClickInfoHolder;
  @NotNull
  private final ValueHolder<Function1<String, Unit>> lastClicksHolder;
  @NotNull
  private final ValueHolder<SubpackageLoadStatisticsCallback> subpackageLoadStatisticsCallback;
  @NotNull
  private final ValueHolder<Float> targetFPSHolder;
  @NotNull
  private final ValueHolder<GetTraceInfoCallback> traceInfoCallbackHolder;
  
  public StatisticsManagerImpl(@NotNull LifeCycleOwner paramLifeCycleOwner, @NotNull Lock paramLock)
  {
    this.accumulatedDrawCallsHolder = new ValueHolder(Long.valueOf(0L), paramLifeCycleOwner, paramLock);
    this.currentDrawCallsHolder = new ValueHolder(Long.valueOf(0L), paramLifeCycleOwner, paramLock);
    this.accumulatedFramesHolder = new ValueHolder(Long.valueOf(0L), paramLifeCycleOwner, paramLock);
    this.currentFPSHolder = new ValueHolder(Float.valueOf(0.0F), paramLifeCycleOwner, paramLock);
    this.targetFPSHolder = new ValueHolder(Float.valueOf(0.0F), paramLifeCycleOwner, paramLock);
    this.jankTraceLevelHolder = new ValueHolder(JankTraceLevel.NONE, paramLifeCycleOwner, paramLock);
    this.jankTraceLevel$delegate = this.jankTraceLevelHolder;
    this.traceInfoCallbackHolder = new ValueHolder(null, paramLifeCycleOwner, paramLock);
    this.lastBlackScreenTimeMillisHolder = new ValueHolder(Long.valueOf(0L), paramLifeCycleOwner, paramLock);
    this.lastClicksHolder = new ValueHolder(null, paramLifeCycleOwner, paramLock);
    this.lastClickInfoHolder = new ValueHolder(null, paramLifeCycleOwner, paramLock);
    this.frameCallbackHolder = new ValueHolder(null, paramLifeCycleOwner, paramLock);
    this.errorCallback = new ValueHolder(null, paramLifeCycleOwner, paramLock);
    this.subpackageLoadStatisticsCallback = new ValueHolder(null, paramLifeCycleOwner, paramLock);
  }
  
  public long getAccumulatedDrawCalls()
  {
    return ((Number)this.accumulatedDrawCallsHolder.getValue()).longValue();
  }
  
  @NotNull
  public final ValueHolder<Long> getAccumulatedDrawCallsHolder()
  {
    return this.accumulatedDrawCallsHolder;
  }
  
  public long getAccumulatedFrames()
  {
    return ((Number)this.accumulatedFramesHolder.getValue()).longValue();
  }
  
  @NotNull
  public final ValueHolder<Long> getAccumulatedFramesHolder()
  {
    return this.accumulatedFramesHolder;
  }
  
  public long getCurrentDrawCalls()
  {
    return ((Number)this.currentDrawCallsHolder.getValue()).longValue();
  }
  
  @NotNull
  public final ValueHolder<Long> getCurrentDrawCallsHolder()
  {
    return this.currentDrawCallsHolder;
  }
  
  public float getCurrentFPS()
  {
    return ((Number)this.currentFPSHolder.getValue()).floatValue();
  }
  
  @NotNull
  public final ValueHolder<Float> getCurrentFPSHolder()
  {
    return this.currentFPSHolder;
  }
  
  @NotNull
  public final ValueHolder<ErrorCallback> getErrorCallback()
  {
    return this.errorCallback;
  }
  
  @NotNull
  public final ValueHolder<FrameCallback> getFrameCallbackHolder()
  {
    return this.frameCallbackHolder;
  }
  
  @NotNull
  public JankTraceLevel getJankTraceLevel()
  {
    return (JankTraceLevel)this.jankTraceLevel$delegate.getValue();
  }
  
  @NotNull
  public final ValueHolder<JankTraceLevel> getJankTraceLevelHolder()
  {
    return this.jankTraceLevelHolder;
  }
  
  public long getLastBlackScreenTimeMillis()
  {
    return ((Number)this.lastBlackScreenTimeMillisHolder.getValue()).longValue();
  }
  
  @NotNull
  public final ValueHolder<Long> getLastBlackScreenTimeMillisHolder()
  {
    return this.lastBlackScreenTimeMillisHolder;
  }
  
  @NotNull
  public String getLastClickInfo()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = "";
    this.lastClickInfoHolder.setValue(new StatisticsManagerImpl.lastClickInfo.1(localObjectRef));
    return (String)localObjectRef.element;
  }
  
  @NotNull
  public final ValueHolder<Function1<String, Unit>> getLastClickInfoHolder()
  {
    return this.lastClickInfoHolder;
  }
  
  @NotNull
  public String getLastClicks()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = "";
    this.lastClicksHolder.setValue(new StatisticsManagerImpl.lastClicks.1(localObjectRef));
    return (String)localObjectRef.element;
  }
  
  @NotNull
  public final ValueHolder<Function1<String, Unit>> getLastClicksHolder()
  {
    return this.lastClicksHolder;
  }
  
  @NotNull
  public final ValueHolder<SubpackageLoadStatisticsCallback> getSubpackageLoadStatisticsCallback()
  {
    return this.subpackageLoadStatisticsCallback;
  }
  
  public float getTargetFPS()
  {
    return ((Number)this.targetFPSHolder.getValue()).floatValue();
  }
  
  @NotNull
  public final ValueHolder<Float> getTargetFPSHolder()
  {
    return this.targetFPSHolder;
  }
  
  public void getTraceInfo(@NotNull GetTraceInfoCallback paramGetTraceInfoCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGetTraceInfoCallback, "callback");
    this.traceInfoCallbackHolder.setValue(paramGetTraceInfoCallback);
  }
  
  @NotNull
  public final ValueHolder<GetTraceInfoCallback> getTraceInfoCallbackHolder()
  {
    return this.traceInfoCallbackHolder;
  }
  
  public void setErrorCallback(@Nullable ErrorCallback paramErrorCallback)
  {
    this.errorCallback.setValue(paramErrorCallback);
  }
  
  public void setFrameCallback(@Nullable FrameCallback paramFrameCallback)
  {
    this.frameCallbackHolder.setValue(paramFrameCallback);
  }
  
  public void setJankTraceLevel(@NotNull JankTraceLevel paramJankTraceLevel)
  {
    Intrinsics.checkParameterIsNotNull(paramJankTraceLevel, "<set-?>");
    this.jankTraceLevel$delegate.setValue(paramJankTraceLevel);
  }
  
  public void setSubpackageLoadStatisticsCallback(@NotNull SubpackageLoadStatisticsCallback paramSubpackageLoadStatisticsCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramSubpackageLoadStatisticsCallback, "callback");
    this.subpackageLoadStatisticsCallback.setValue(paramSubpackageLoadStatisticsCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl
 * JD-Core Version:    0.7.0.1
 */