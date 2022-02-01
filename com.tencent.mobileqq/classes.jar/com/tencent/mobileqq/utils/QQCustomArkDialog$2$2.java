package com.tencent.mobileqq.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQCustomArkDialog$2$2
  implements Runnable
{
  QQCustomArkDialog$2$2(QQCustomArkDialog.2 param2) {}
  
  public void run()
  {
    Activity localActivity;
    if (QQCustomArkDialog.a(this.a.a) != null) {
      localActivity = (Activity)QQCustomArkDialog.a(this.a.a).get();
    } else {
      localActivity = null;
    }
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      this.a.a.show();
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog onloadcallback activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.2
 * JD-Core Version:    0.7.0.1
 */