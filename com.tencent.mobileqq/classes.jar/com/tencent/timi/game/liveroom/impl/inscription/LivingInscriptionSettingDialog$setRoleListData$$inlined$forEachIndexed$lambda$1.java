package com.tencent.timi.game.liveroom.impl.inscription;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$setRoleListData$1$1"}, k=3, mv={1, 1, 16})
final class LivingInscriptionSettingDialog$setRoleListData$$inlined$forEachIndexed$lambda$1
  implements View.OnClickListener
{
  LivingInscriptionSettingDialog$setRoleListData$$inlined$forEachIndexed$lambda$1(int paramInt1, LivingInscriptionSettingDialog paramLivingInscriptionSettingDialog, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    LivingInscriptionSettingDialog.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog.setRoleListData..inlined.forEachIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */