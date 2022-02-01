package com.tencent.mobileqq.qqlive.verified;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqlive.callback.verified.QQLiveVerifyCallback;

class QQLiveVerifyServiceImpl$2
  implements DialogInterface.OnClickListener
{
  QQLiveVerifyServiceImpl$2(QQLiveVerifyServiceImpl paramQQLiveVerifyServiceImpl, QQLiveVerifyCallback paramQQLiveVerifyCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQLiveVerifyServiceImpl.a(this.b, null);
    this.a.a(999, "取消认证");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.QQLiveVerifyServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */