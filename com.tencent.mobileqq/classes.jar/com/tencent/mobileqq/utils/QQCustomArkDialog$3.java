package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.os.Bundle;
import bdjq;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$3
  implements Runnable
{
  public QQCustomArkDialog$3(bdjq parambdjq, Bundle paramBundle) {}
  
  public void run()
  {
    if (bdjq.a(this.this$0) != null) {}
    for (Activity localActivity = (Activity)bdjq.a(this.this$0).get(); (localActivity != null) && (!localActivity.isFinishing()); localActivity = null)
    {
      bdjq.a(this.this$0, this.a);
      return;
    }
    QLog.e("QQCustomArkDialog", 1, "init bundle activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.3
 * JD-Core Version:    0.7.0.1
 */