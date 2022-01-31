package com.tencent.mobileqq.music;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQPlayerService$2
  implements Runnable
{
  QQPlayerService$2(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("qqplayer_exit_action");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(QQPlayerService.a(this.this$0), localIntentFilter);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          QQPlayerService.a(this.this$0);
          return;
          localException = localException;
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onCreate registerReceiver exception ");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQPlayerService", 2, "initMediaPlayer", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.2
 * JD-Core Version:    0.7.0.1
 */