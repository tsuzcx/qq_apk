package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class ForwardBaseOption$1
  implements DialogInterface.OnClickListener
{
  ForwardBaseOption$1(ForwardBaseOption paramForwardBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->qbShowShareResultDialog--stay");
      }
      this.a.s.finish();
      paramDialogInterface = new Intent(this.a.s, SplashActivity.class);
      paramDialogInterface.addFlags(335544320);
      this.a.s.startActivity(paramDialogInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "qbShowShareResultDialog back");
    }
    if (!this.a.s.isFinishing()) {
      ForwardBaseOption.a(this.a).dismiss();
    }
    this.a.s.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.1
 * JD-Core Version:    0.7.0.1
 */