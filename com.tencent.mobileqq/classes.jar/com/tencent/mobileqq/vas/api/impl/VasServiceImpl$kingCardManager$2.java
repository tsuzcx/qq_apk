package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.kingcard.KingCardManagerImpl;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$kingCardManager$2
  extends Lambda
  implements Function0<IKingCardManager>
{
  VasServiceImpl$kingCardManager$2(VasServiceImpl paramVasServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final IKingCardManager invoke()
  {
    return (IKingCardManager)VasServiceImpl.access$dynamicCall(this.this$0, new KingCardManagerImpl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.kingCardManager.2
 * JD-Core Version:    0.7.0.1
 */