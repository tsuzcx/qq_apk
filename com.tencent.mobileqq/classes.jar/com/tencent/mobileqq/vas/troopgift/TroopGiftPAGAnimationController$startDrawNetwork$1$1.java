package com.tencent.mobileqq.vas.troopgift;

import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$startDrawNetwork$1$1
  implements Runnable
{
  TroopGiftPAGAnimationController$startDrawNetwork$1$1(TroopGiftPAGAnimationController.startDrawNetwork.1 param1, Object paramObject, String paramString) {}
  
  public final void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a(this.this$0.jdField_a_of_type_JavaLangString, ((StaffGiftDrawBean.DrawRsp)this.jdField_a_of_type_JavaLangObject).isWin(), this.jdField_a_of_type_JavaLangString);
    if (((StaffGiftDrawBean.DrawRsp)this.jdField_a_of_type_JavaLangObject).isWin())
    {
      TroopGiftPAGAnimationController.a(this.this$0.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController, true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a().getRuleManager().registerRuleLine("$SUCCESS_TEXT", new TroopGiftPAGAnimationController.startDrawNetwork.1.1.1(this));
      this.this$0.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke("show");
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController.a().getRuleManager().registerRuleLine("$FAIL_TEXT", new TroopGiftPAGAnimationController.startDrawNetwork.1.1.2(this));
    this.this$0.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke("hide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.startDrawNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */