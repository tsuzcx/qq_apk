package com.tencent.mobileqq.music;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
      MobileQQ.getContext().registerReceiver(QQPlayerService.a(this.this$0), localIntentFilter);
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate registerReceiver exception ");
    }
    try
    {
      QQPlayerService.b(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "initMediaPlayer", localThrowable);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.2
 * JD-Core Version:    0.7.0.1
 */