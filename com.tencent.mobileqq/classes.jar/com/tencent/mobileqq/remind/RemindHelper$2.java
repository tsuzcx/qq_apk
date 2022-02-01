package com.tencent.mobileqq.remind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class RemindHelper$2
  implements DialogInterface.OnDismissListener
{
  RemindHelper$2(IosTimepicker paramIosTimepicker, JsBridgeListener paramJsBridgeListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (this.b != null))
    {
      long l2 = paramDialogInterface.getSetcetTimeInMillis() / 1000L;
      long l1 = l2;
      if (Build.MODEL.equals("Coolpad 5890"))
      {
        long l3 = new Date().getTime() / 1000L;
        l1 = l2;
        if (l2 < l3) {
          l1 = l3;
        }
      }
      if (QLog.isColorLevel())
      {
        paramDialogInterface = RemindHelper.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDismiss Time :");
        localStringBuilder.append(TimeHelper.d(1000L * l1));
        QLog.d(paramDialogInterface, 2, localStringBuilder.toString());
      }
      this.a.setOnTimePickerSelectListener(null);
      this.b.a(Long.valueOf(l1));
      RemindHelper.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper.2
 * JD-Core Version:    0.7.0.1
 */