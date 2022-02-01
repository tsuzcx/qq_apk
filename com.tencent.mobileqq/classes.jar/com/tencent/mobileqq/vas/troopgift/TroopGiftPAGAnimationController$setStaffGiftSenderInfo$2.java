package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$setStaffGiftSenderInfo$2
  extends Lambda
  implements Function1<PAGView, String>
{
  TroopGiftPAGAnimationController$setStaffGiftSenderInfo$2(TroopGiftPAGAnimationController paramTroopGiftPAGAnimationController, TroopGiftData paramTroopGiftData)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "<anonymous parameter 0>");
    paramPAGView = this.this$0;
    Object localObject = this.$giftData.giftData.dataForClient.troopUin;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "giftData.giftData.dataForClient.troopUin");
    localObject = paramPAGView.a((String)localObject, String.valueOf(this.$giftData.getSenderUin()));
    paramPAGView = (PAGView)localObject;
    if (((String)localObject).length() > 10)
    {
      paramPAGView = new StringBuilder();
      paramPAGView.append(StringsKt.take((String)localObject, 10));
      paramPAGView.append("...");
      paramPAGView = paramPAGView.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramPAGView);
    ((StringBuilder)localObject).append("送你一个礼物");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.setStaffGiftSenderInfo.2
 * JD-Core Version:    0.7.0.1
 */