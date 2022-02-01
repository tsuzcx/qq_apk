package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/EventBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class EventBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final EventBridgeInvokeHandler.Companion a = new EventBridgeInvokeHandler.Companion(null);
  
  public EventBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  public void a()
  {
    a("addEventListener", (Function2)new EventBridgeInvokeHandler.register.1(this));
    a("removeEventListener", (Function2)new EventBridgeInvokeHandler.register.2(this));
    a("dispatchEvent", (Function2)new EventBridgeInvokeHandler.register.3(this));
  }
  
  @NotNull
  public String b()
  {
    return "event";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.EventBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */