package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/GDTBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class GDTBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final GDTBridgeInvokeHandler.Companion a = new GDTBridgeInvokeHandler.Companion(null);
  
  public GDTBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "gdt";
  }
  
  public void a()
  {
    a("getDeviceInfo", (Function2)new GDTBridgeInvokeHandler.register.1(this));
    a("handleClick", (Function2)new GDTBridgeInvokeHandler.register.2(this));
    a("c2sReport", (Function2)new GDTBridgeInvokeHandler.register.3(this));
    a("dwellTimeMillisReport", (Function2)new GDTBridgeInvokeHandler.register.4(this));
    a("getMotiveAd", (Function2)new GDTBridgeInvokeHandler.register.5(this));
    a("showMotiveAd", (Function2)new GDTBridgeInvokeHandler.register.6(this));
    a("openMiniApp", (Function2)new GDTBridgeInvokeHandler.register.7(this));
    a("adFreshFlushSceneAds", (Function2)new GDTBridgeInvokeHandler.register.8(this));
    a("adFreshGetRequestAdIds", (Function2)new GDTBridgeInvokeHandler.register.9(this));
    a("adFreshAddAdId", (Function2)new GDTBridgeInvokeHandler.register.10(this));
    a("adFreshGetExposeRate", (Function2)new GDTBridgeInvokeHandler.register.11(this));
    a("adFreshRemoveAdId", (Function2)new GDTBridgeInvokeHandler.register.12(this));
    a("preLoadAfterAdLoaded", (Function2)new GDTBridgeInvokeHandler.register.13(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.GDTBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */