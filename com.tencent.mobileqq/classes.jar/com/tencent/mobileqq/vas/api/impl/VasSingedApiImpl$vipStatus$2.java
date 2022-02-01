package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.vip.VipStatusManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "invoke"}, k=3, mv={1, 1, 16})
final class VasSingedApiImpl$vipStatus$2
  extends Lambda
  implements Function0<IVipStatusManager>
{
  VasSingedApiImpl$vipStatus$2(VasSingedApiImpl paramVasSingedApiImpl)
  {
    super(0);
  }
  
  @NotNull
  public final IVipStatusManager invoke()
  {
    return (IVipStatusManager)VasSingedApiImpl.access$dynamicCall(this.this$0, new VipStatusManagerImpl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasSingedApiImpl.vipStatus.2
 * JD-Core Version:    0.7.0.1
 */