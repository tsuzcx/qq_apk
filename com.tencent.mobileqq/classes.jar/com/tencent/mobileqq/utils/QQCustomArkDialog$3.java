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
    Activity localActivity;
    if (QQCustomArkDialog.c(this.this$0) != null) {
      localActivity = (Activity)QQCustomArkDialog.c(this.this$0).get();
    } else {
      localActivity = null;
    }
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      QQCustomArkDialog.a(this.this$0, this.a);
      return;
    }
    QLog.e("QQCustomArkDialog", 1, "init bundle activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.3
 * JD-Core Version:    0.7.0.1
 */