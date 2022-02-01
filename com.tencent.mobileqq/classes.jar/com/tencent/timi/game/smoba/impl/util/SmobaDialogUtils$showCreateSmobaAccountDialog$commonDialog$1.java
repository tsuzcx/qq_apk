package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaDialogUtils$showCreateSmobaAccountDialog$commonDialog$1
  implements DialogInterface.OnClickListener
{
  public static final 1 a = new 1();
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ISmobaService)ServiceCenter.a(ISmobaService.class)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showCreateSmobaAccountDialog.commonDialog.1
 * JD-Core Version:    0.7.0.1
 */