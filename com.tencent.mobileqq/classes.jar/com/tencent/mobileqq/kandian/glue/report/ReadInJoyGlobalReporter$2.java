package com.tencent.mobileqq.kandian.glue.report;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyGlobalReporter$2
  implements Runnable
{
  ReadInJoyGlobalReporter$2(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void run()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (ReadInJoyGlobalReporter.b(this.this$0) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.this$0.j, localIntentFilter);
        ReadInJoyGlobalReporter.a(this.this$0, 1);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyGlobalReporter", 2, "registerScreenListener");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerScreenListener:");
        localStringBuilder.append(localException.toString());
        QLog.e("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter.2
 * JD-Core Version:    0.7.0.1
 */