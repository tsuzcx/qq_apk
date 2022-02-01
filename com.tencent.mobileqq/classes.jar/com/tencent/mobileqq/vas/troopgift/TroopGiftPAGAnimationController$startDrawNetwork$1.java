package com.tencent.mobileqq.vas.troopgift;

import android.os.Handler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class TroopGiftPAGAnimationController$startDrawNetwork$1
  implements BusinessObserver
{
  TroopGiftPAGAnimationController$startDrawNetwork$1(TroopGiftPAGAnimationController paramTroopGiftPAGAnimationController, String paramString, Function1 paramFunction1) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof StaffGiftDrawBean.DrawRsp)))
    {
      String str = TroopGiftPAGAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController, paramBoolean, (StaffGiftDrawBean.DrawRsp)paramObject);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new TroopGiftPAGAnimationController.startDrawNetwork.1.1(this, paramObject, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftPAGAnimationController.startDrawNetwork.1
 * JD-Core Version:    0.7.0.1
 */