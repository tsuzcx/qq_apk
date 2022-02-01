package com.tencent.timi.game.liveroom.impl.inscription;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class LivingInscriptionSettingDialog$showSelectDialog$2
  implements DialogInterface.OnClickListener
{
  LivingInscriptionSettingDialog$showSelectDialog$2(LivingInscriptionSettingDialog paramLivingInscriptionSettingDialog, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NoDoubleClickUtils.a())
    {
      LivingInscriptionSettingDialog.b(this.a, this.b);
      LivingInscriptionSettingDialog.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog.showSelectDialog.2
 * JD-Core Version:    0.7.0.1
 */