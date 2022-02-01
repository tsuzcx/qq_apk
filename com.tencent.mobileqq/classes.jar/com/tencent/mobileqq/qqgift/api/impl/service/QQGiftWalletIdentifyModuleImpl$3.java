package com.tencent.mobileqq.qqgift.api.impl.service;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule.QQGiftWalletIdentifyCallback;

class QQGiftWalletIdentifyModuleImpl$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQGiftWalletIdentifyModuleImpl.a(this.b, null);
    this.a.identifyFinish(false, -2, "取消认证");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftWalletIdentifyModuleImpl.3
 * JD-Core Version:    0.7.0.1
 */