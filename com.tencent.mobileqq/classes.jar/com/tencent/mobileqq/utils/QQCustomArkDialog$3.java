package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQCustomArkDialog$3
  implements Runnable
{
  QQCustomArkDialog$3(QQCustomArkDialog paramQQCustomArkDialog, Bundle paramBundle) {}
  
  public void run()
  {
    if (QQCustomArkDialog.a(this.this$0) != null) {}
    for (Activity localActivity = (Activity)QQCustomArkDialog.a(this.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      QQCustomArkDialog.a(this.this$0, this.a);
      return;
    }
    QLog.e("QQCustomArkDialog", 1, "init bundle activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.3
 * JD-Core Version:    0.7.0.1
 */