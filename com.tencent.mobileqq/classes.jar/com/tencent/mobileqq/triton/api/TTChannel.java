package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/api/TTChannel;", "", "mDebugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "(Lcom/tencent/mobileqq/triton/model/DebugConfig;)V", "onRenderErrorCallback", "Lkotlin/Function0;", "", "getOnRenderErrorCallback", "()Lkotlin/jvm/functions/Function0;", "setOnRenderErrorCallback", "(Lkotlin/jvm/functions/Function0;)V", "onScriptErrorCallback", "Lkotlin/Function1;", "", "getOnScriptErrorCallback", "()Lkotlin/jvm/functions/Function1;", "setOnScriptErrorCallback", "(Lkotlin/jvm/functions/Function1;)V", "g_frameNoChangeLimit", "", "g_noPresentDurationLimit", "g_noPresentTouchLimit", "g_onErrorDialog", "g_presentDetectInterval", "handleJavaScriptException", "bytes", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@TritonKeep
public final class TTChannel
{
  public static final TTChannel.Companion Companion = new TTChannel.Companion(null);
  @NotNull
  public static final String NAME = "TTChannel";
  private final DebugConfig mDebugConfig;
  @Nullable
  private Function0<Unit> onRenderErrorCallback;
  @Nullable
  private Function1<? super byte[], Unit> onScriptErrorCallback;
  
  public TTChannel(@NotNull DebugConfig paramDebugConfig)
  {
    this.mDebugConfig = paramDebugConfig;
  }
  
  @TritonKeep
  public final int g_frameNoChangeLimit()
  {
    return this.mDebugConfig.getFrameNoChangeToCheckLimit();
  }
  
  @TritonKeep
  public final int g_noPresentDurationLimit()
  {
    return (int)this.mDebugConfig.getNoPresentDurationToCheckLimitMillis();
  }
  
  @TritonKeep
  public final int g_noPresentTouchLimit()
  {
    return this.mDebugConfig.getNoPresentTouchLimit();
  }
  
  @TritonKeep
  public final void g_onErrorDialog()
  {
    Object localObject = this.onRenderErrorCallback;
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
  }
  
  @TritonKeep
  public final int g_presentDetectInterval()
  {
    return (int)this.mDebugConfig.getPresentDetectIntervalMillis();
  }
  
  @Nullable
  public final Function0<Unit> getOnRenderErrorCallback()
  {
    return this.onRenderErrorCallback;
  }
  
  @Nullable
  public final Function1<byte[], Unit> getOnScriptErrorCallback()
  {
    return this.onScriptErrorCallback;
  }
  
  @TritonKeep
  public final void handleJavaScriptException(@Nullable byte[] paramArrayOfByte)
  {
    Function1 localFunction1 = this.onScriptErrorCallback;
    if (localFunction1 != null) {
      paramArrayOfByte = (Unit)localFunction1.invoke(paramArrayOfByte);
    }
  }
  
  public final void setOnRenderErrorCallback(@Nullable Function0<Unit> paramFunction0)
  {
    this.onRenderErrorCallback = paramFunction0;
  }
  
  public final void setOnScriptErrorCallback(@Nullable Function1<? super byte[], Unit> paramFunction1)
  {
    this.onScriptErrorCallback = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.TTChannel
 * JD-Core Version:    0.7.0.1
 */