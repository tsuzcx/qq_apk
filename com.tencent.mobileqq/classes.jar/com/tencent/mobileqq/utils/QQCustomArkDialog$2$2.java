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
    if (QQCustomArkDialog.access$400(this.this$1.this$0) != null) {}
    for (Activity localActivity = (Activity)QQCustomArkDialog.access$400(this.this$1.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      this.this$1.this$0.show();
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog onloadcallback activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.2
 * JD-Core Version:    0.7.0.1
 */