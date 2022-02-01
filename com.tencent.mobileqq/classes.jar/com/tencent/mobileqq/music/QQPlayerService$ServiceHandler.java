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
    if (paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      if (QQPlayerService.a() == paramMessage.jdField_a_of_type_AndroidMediaMediaPlayer) {
        QQPlayerService.a(null);
      }
    }
    if (paramMessage.jdField_a_of_type_AndroidOsLooper != null) {
      paramMessage.jdField_a_of_type_AndroidOsLooper.quit();
    }
    if (QQPlayerService.e() == paramMessage.jdField_a_of_type_ComTencentMobileqqMusicSongInfo) {
      QQPlayerService.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.ServiceHandler
 * JD-Core Version:    0.7.0.1
 */