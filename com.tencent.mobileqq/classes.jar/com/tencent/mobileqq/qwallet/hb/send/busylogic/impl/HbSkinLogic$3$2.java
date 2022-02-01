package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import cooperation.qwallet.QwUtils;

class HbSkinLogic$3$2
  implements DialogInterface.OnClickListener
{
  HbSkinLogic$3$2(HbSkinLogic.3 param3, HbSkinInfo paramHbSkinInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.f.pop_dialog.right_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      QwUtils.a(HbSkinLogic.e(this.b.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.3.2
 * JD-Core Version:    0.7.0.1
 */