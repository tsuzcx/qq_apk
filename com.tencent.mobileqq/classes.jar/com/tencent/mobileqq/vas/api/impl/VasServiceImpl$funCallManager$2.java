package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$funCallManager$2
  extends Lambda
  implements Function0<IVipFunCallManager>
{
  VasServiceImpl$funCallManager$2(VasServiceImpl paramVasServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final IVipFunCallManager invoke()
  {
    return (IVipFunCallManager)VasServiceImpl.access$dynamicCall(this.this$0, new VipFunCallManagerImpl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.funCallManager.2
 * JD-Core Version:    0.7.0.1
 */