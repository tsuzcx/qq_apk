package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/OfflineBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class OfflineBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final OfflineBridgeInvokeHandler.Companion a = new OfflineBridgeInvokeHandler.Companion(null);
  
  public OfflineBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "offline";
  }
  
  public void a()
  {
    a("updateIfNeed", (Function2)new OfflineBridgeInvokeHandler.register.1(this));
    a("batchCheckUpdate", (Function2)new OfflineBridgeInvokeHandler.register.2(this));
    a("isCached", (Function2)new OfflineBridgeInvokeHandler.register.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.OfflineBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */