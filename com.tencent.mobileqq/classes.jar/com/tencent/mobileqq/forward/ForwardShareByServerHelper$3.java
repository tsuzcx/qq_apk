package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

final class ForwardShareByServerHelper$3
  implements DialogInterface.OnClickListener
{
  ForwardShareByServerHelper$3(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog back");
    }
    ForwardShareByServerHelper.a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.3
 * JD-Core Version:    0.7.0.1
 */