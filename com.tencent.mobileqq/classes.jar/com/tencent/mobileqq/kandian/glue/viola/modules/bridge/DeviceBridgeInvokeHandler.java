package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/DeviceBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DeviceBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final DeviceBridgeInvokeHandler.Companion a = new DeviceBridgeInvokeHandler.Companion(null);
  
  public DeviceBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "device";
  }
  
  public void a()
  {
    a("getDeviceInfo", (Function2)new DeviceBridgeInvokeHandler.register.1(this));
    a("getNetworkInfo", (Function2)new DeviceBridgeInvokeHandler.register.2(this));
    a("getNetType", (Function2)new DeviceBridgeInvokeHandler.register.3(this));
    a("getClientInfo", (Function2)new DeviceBridgeInvokeHandler.register.4(this));
    a("getCUKingStatus", (Function2)new DeviceBridgeInvokeHandler.register.5(this));
    a("getGdtInfo", (Function2)new DeviceBridgeInvokeHandler.register.6(this));
    a("getRecommendFlag", (Function2)new DeviceBridgeInvokeHandler.register.7(this));
    a("isMobileQQ", (Function2)new DeviceBridgeInvokeHandler.register.8(this));
    a("getNetworkType", (Function2)new DeviceBridgeInvokeHandler.register.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.DeviceBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */