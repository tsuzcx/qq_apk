package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class ForwardShareByServerHelper$2
  implements DialogInterface.OnClickListener
{
  ForwardShareByServerHelper$2(long paramLong, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->qbShowShareResultDialog--stay");
    }
    ForwardShareByServerHelper.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.2
 * JD-Core Version:    0.7.0.1
 */