package com.tencent.mobileqq.utils;

import android.app.Activity;
import bbfx;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$4
  implements Runnable
{
  public QQCustomArkDialog$4(bbfx parambbfx) {}
  
  public void run()
  {
    if (!bbfx.b(this.this$0))
    {
      bbfx.a(this.this$0, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "overtime,show dialog right now");
      }
      if (bbfx.a(this.this$0) == null) {
        break label76;
      }
    }
    label76:
    for (Activity localActivity = (Activity)bbfx.a(this.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      this.this$0.show();
      return;
    }
    QLog.d("QQCustomArkDialog", 1, "overtime,show dialog right now activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.4
 * JD-Core Version:    0.7.0.1
 */