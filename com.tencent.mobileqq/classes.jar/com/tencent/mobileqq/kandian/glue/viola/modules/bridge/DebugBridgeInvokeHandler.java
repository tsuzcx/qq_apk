package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/DebugBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DebugBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final DebugBridgeInvokeHandler.Companion a = new DebugBridgeInvokeHandler.Companion(null);
  
  public DebugBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "debug";
  }
  
  public void a()
  {
    a("detailLog", (Function2)new DebugBridgeInvokeHandler.register.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.DebugBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */