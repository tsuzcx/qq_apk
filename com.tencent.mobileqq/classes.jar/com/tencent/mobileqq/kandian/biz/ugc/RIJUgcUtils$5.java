package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

final class RIJUgcUtils$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      try
      {
        paramDialogInterface.dismiss();
      }
      catch (Throwable paramDialogInterface)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "showCantUploadTips error", paramDialogInterface);
      }
    }
    ThreadManager.executeOnSubThread(new RIJUgcUtils.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.5
 * JD-Core Version:    0.7.0.1
 */