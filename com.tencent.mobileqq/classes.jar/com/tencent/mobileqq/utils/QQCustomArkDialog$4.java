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
      Activity localActivity;
      if (QQCustomArkDialog.a(this.this$0) != null) {
        localActivity = (Activity)QQCustomArkDialog.a(this.this$0).get();
      } else {
        localActivity = null;
      }
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        this.this$0.show();
        return;
      }
      QLog.d("QQCustomArkDialog", 1, "overtime,show dialog right now activity is null or finished");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.4
 * JD-Core Version:    0.7.0.1
 */