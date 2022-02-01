package com.tencent.mobileqq.emosm.favroaming;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.BaseApplication;

final class EmoAddedAuthCallback$3
  implements DialogInterface.OnClickListener
{
  EmoAddedAuthCallback$3(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      VasH5PayUtil.a(this.a, "mvip.n.a.bqsc_aio", 3, "1450000516", "CJCLUBT", this.b.getApp().getString(2131897800), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.3
 * JD-Core Version:    0.7.0.1
 */