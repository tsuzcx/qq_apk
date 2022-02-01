package com.tencent.mobileqq.flashshow.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.qphone.base.util.QLog;

final class FSBindPhoneNumberHelper$3
  implements DialogInterface.OnClickListener
{
  FSBindPhoneNumberHelper$3(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FSBindPhoneNumberHelper.b(false);
    if (paramInt == 1)
    {
      paramDialogInterface = FSConfig.p();
      FSNativeLauncher.a(this.a, paramDialogInterface, null, -1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBindPhoneNumber  dialog click confirm ==> url : ");
      localStringBuilder.append(paramDialogInterface);
      QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("QCircleBindPhoneNumberHelper", 1, "handleBindPhoneNumber  dialog click cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper.3
 * JD-Core Version:    0.7.0.1
 */