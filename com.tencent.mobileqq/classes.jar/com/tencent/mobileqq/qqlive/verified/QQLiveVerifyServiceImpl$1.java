package com.tencent.mobileqq.qqlive.verified;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqlive.callback.verified.QQLiveVerifyCallback;

class QQLiveVerifyServiceImpl$1
  implements DialogInterface.OnClickListener
{
  QQLiveVerifyServiceImpl$1(QQLiveVerifyServiceImpl paramQQLiveVerifyServiceImpl, QQLiveVerifyCallback paramQQLiveVerifyCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQLiveVerifyServiceImpl.a(this.b, this.a);
    paramDialogInterface.dismiss();
    QQLiveVerifyServiceImpl.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.QQLiveVerifyServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */