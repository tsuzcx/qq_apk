package com.tencent.mobileqq.utils;

import android.app.Activity;
import bdjq;
import bdjs;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$2$2
  implements Runnable
{
  public QQCustomArkDialog$2$2(bdjs parambdjs) {}
  
  public void run()
  {
    if (bdjq.a(this.a.a) != null) {}
    for (Activity localActivity = (Activity)bdjq.a(this.a.a).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
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