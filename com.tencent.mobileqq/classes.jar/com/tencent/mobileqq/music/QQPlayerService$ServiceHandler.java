package com.tencent.mobileqq.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class QQPlayerService$ServiceHandler
  extends Handler
{
  public QQPlayerService$ServiceHandler(QQPlayerService paramQQPlayerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1)
    {
      QQPlayerService.a(this.a, (Intent)paramMessage.obj);
      return;
    }
    try
    {
      MobileQQ.getContext().unregisterReceiver(QQPlayerService.a(this.a));
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onDestroy unregisterReceiver exception ");
    }
    paramMessage = (QQPlayerService.ReleaseObject)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "release player");
    }
    if (paramMessage.a != null)
    {
      paramMessage.a.release();
      if (QQPlayerService.r() == paramMessage.a) {
        QQPlayerService.a(null);
      }
    }
    if (paramMessage.b != null) {
      paramMessage.b.quit();
    }
    if (QQPlayerService.s() == paramMessage.c) {
      QQPlayerService.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.ServiceHandler
 * JD-Core Version:    0.7.0.1
 */