package com.tencent.mobileqq.vas.troopgift;

import android.view.View;
import com.tencent.xaction.openapi.api.IStatusNotify;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$playStaffGift$notify$1", "Lcom/tencent/xaction/openapi/api/IStatusNotify;", "notify", "", "status", "", "view", "Landroid/view/View;", "callback", "Lkotlin/Function1;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftPAGAnimationController$playStaffGift$notify$1
  implements IStatusNotify
{
  TroopGiftPAGAnimationController$playStaffGift$notify$1(String paramString) {}
  
  public void notify(@NotNull String paramString, @NotNull View paramView, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    if (Intrinsics.areEqual(paramString, "click"))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController;
      paramView = this.jdField_a_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "orderId");
      paramString.a(paramView, paramFunction1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.playStaffGift.notify.1
 * JD-Core Version:    0.7.0.1
 */