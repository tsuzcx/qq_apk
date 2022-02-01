package com.tencent.mobileqq.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQCustomArkDialog$4
  implements Runnable
{
  QQCustomArkDialog$4(QQCustomArkDialog paramQQCustomArkDialog) {}
  
  public void run()
  {
    if (!QQCustomArkDialog.b(this.this$0))
    {
      QQCustomArkDialog.a(this.this$0, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "overtime,show dialog right now");
      }
      if (QQCustomArkDialog.a(this.this$0) == null) {
        break label76;
      }
    }
    label76:
    for (Activity localActivity = (Activity)QQCustomArkDialog.a(this.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      this.this$0.show();
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog right now activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.4
 * JD-Core Version:    0.7.0.1
 */