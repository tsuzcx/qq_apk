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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/UiComponentSdk;", "", "()V", "colorStrategy", "Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;", "getColorStrategy$tkd_weibo_component_release", "()Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;", "setColorStrategy$tkd_weibo_component_release", "(Lcom/tencent/tkd/weibo/framework/color/IComponentColorStrategy;)V", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "value", "", "isNightMode", "()Z", "setNightMode", "(Z)V", "mSdkConfig", "Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "sdkConfig", "getSdkConfig", "()Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "initial", "", "config", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class UiComponentSdk
{
  public static final UiComponentSdk.Companion a;
  private static final UiComponentSdk jdField_a_of_type_ComTencentTkdWeiboUiComponentSdk = new UiComponentSdk();
  private UiComponentSdkConfig jdField_a_of_type_ComTencentTkdWeiboUiComponentSdkConfig;
  @NotNull
  private IComponentColorStrategy jdField_a_of_type_ComTencentTkdWeiboFrameworkColorIComponentColorStrategy = (IComponentColorStrategy)new LightColorStrategy();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboUiComponentSdk$Companion = new UiComponentSdk.Companion(null);
  }
  
  @NotNull
  public final UiComponentSdkConfig a()
  {
    UiComponentSdkConfig localUiComponentSdkConfig = this.jdField_a_of_type_ComTencentTkdWeiboUiComponentSdkConfig;
    if (localUiComponentSdkConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSdkConfig");
    }
    return localUiComponentSdkConfig;
  }
  
  @NotNull
  public final IComponentColorStrategy a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkColorIComponentColorStrategy;
  }
  
  public final void a(@NotNull UiComponentSdkConfig paramUiComponentSdkConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramUiComponentSdkConfig, "config");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      System.out.println("UiSDK::initial 不允许重复调用");
      return;
    }
    this.jdField_a_of_type_ComTencentTkdWeiboUiComponentSdkConfig = paramUiComponentSdkConfig;
    DataTransferManager.a.a(paramUiComponentSdkConfig.a());
    TLog.a.a(paramUiComponentSdkConfig.a());
    RichTextBridge.a.a().a(paramUiComponentSdkConfig.a(), paramUiComponentSdkConfig.a());
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {}
    for (IComponentColorStrategy localIComponentColorStrategy = (IComponentColorStrategy)new LightColorStrategy();; localIComponentColorStrategy = (IComponentColorStrategy)new DarkColorStrategy())
    {
      this.jdField_a_of_type_ComTencentTkdWeiboFrameworkColorIComponentColorStrategy = localIComponentColorStrategy;
      return;
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.UiComponentSdk
 * JD-Core Version:    0.7.0.1
 */