package com.tencent.mobileqq.vas.troopgift;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "curState", "onLoadingStateChanged"}, k=3, mv={1, 1, 16})
final class AbsTroopGiftController$getSenderDrawable$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  AbsTroopGiftController$getSenderDrawable$1(AbsTroopGiftController paramAbsTroopGiftController, TroopGiftData paramTroopGiftData, Drawable paramDrawable) {}
  
  public final void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      Object localObject1 = (AppInterface)this.a.m().app;
      Object localObject2 = this.b.giftData.dataForClient.sendUin;
      Drawable localDrawable = this.c;
      localObject2 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, (String)localObject2, 3, localDrawable, localDrawable);
      localObject1 = this.a.f().getRuleManager();
      localObject2 = TroopUtils.a((Drawable)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "TroopUtils.headDrawableToBitamp(senderDrawable)");
      ((IPublicRuleManager)localObject1).registerRuleLine("$GIFT_SEND_AVATAR", localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController.getSenderDrawable.1
 * JD-Core Version:    0.7.0.1
 */