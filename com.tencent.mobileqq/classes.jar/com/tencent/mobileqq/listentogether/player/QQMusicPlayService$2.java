package com.tencent.mobileqq.listentogether.player;

import android.content.IntentFilter;
import awon;
import bhnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQMusicPlayService$2
  implements Runnable
{
  QQMusicPlayService$2(QQMusicPlayService paramQQMusicPlayService) {}
  
  public void run()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("QQMusicPlay_exit_action");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(QQMusicPlayService.a(this.this$0), localIntentFilter);
      QQMusicPlayService.a(bhnv.g(this.this$0.getApplicationContext()));
      QQMusicPlayService.a(this.this$0, new awon(this.this$0));
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), QQMusicPlayService.a(this.this$0));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          QQMusicPlayService.a(this.this$0);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.e("QQMusicPlay.QQMusicPlayService", 1, "initMediaPlayer exception===>", localThrowable);
        }
        localException = localException;
        localException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, "onCreate registerReceiver exception===>", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.2
 * JD-Core Version:    0.7.0.1
 */