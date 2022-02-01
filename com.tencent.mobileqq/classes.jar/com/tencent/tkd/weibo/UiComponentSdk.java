package com.tencent.tkd.weibo;

import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.TLog;
import com.tencent.tkd.weibo.framework.color.DarkColorStrategy;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import com.tencent.tkd.weibo.framework.color.LightColorStrategy;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/UiComponentSdk;", "", "()V", "colorStrategy", "Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;", "getColorStrategy$tkd_weibo_component_release", "()Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;", "setColorStrategy$tkd_weibo_component_release", "(Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;)V", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "value", "", "isNightMode", "()Z", "setNightMode", "(Z)V", "mSdkConfig", "Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "sdkConfig", "getSdkConfig", "()Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "initial", "", "config", "release", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class UiComponentSdk
{
  public static final UiComponentSdk.Companion a = new UiComponentSdk.Companion(null);
  private static final UiComponentSdk f = new UiComponentSdk();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private UiComponentSdkConfig c;
  @NotNull
  private IComponentColorStrategy d = (IComponentColorStrategy)new LightColorStrategy();
  private boolean e;
  
  @NotNull
  public final UiComponentSdkConfig a()
  {
    UiComponentSdkConfig localUiComponentSdkConfig = this.c;
    if (localUiComponentSdkConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSdkConfig");
    }
    return localUiComponentSdkConfig;
  }
  
  public final void a(@NotNull UiComponentSdkConfig paramUiComponentSdkConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramUiComponentSdkConfig, "config");
    if (this.b.getAndSet(true))
    {
      System.out.println("UiSDK::initial 不允许重复调用");
      return;
    }
    this.c = paramUiComponentSdkConfig;
    DataTransferManager.a.a(paramUiComponentSdkConfig.c());
    TLog.a.a(paramUiComponentSdkConfig.d());
    RichTextBridge.a.a().a(paramUiComponentSdkConfig.e(), paramUiComponentSdkConfig.d());
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    Object localObject;
    if (!this.e) {
      localObject = new LightColorStrategy();
    } else {
      localObject = new DarkColorStrategy();
    }
    this.d = ((IComponentColorStrategy)localObject);
  }
  
  @NotNull
  public final IComponentColorStrategy b()
  {
    return this.d;
  }
  
  public final boolean c()
  {
    return this.e;
  }
  
  public final void d()
  {
    a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.UiComponentSdk
 * JD-Core Version:    0.7.0.1
 */