package com.tencent.mobileqq.music;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class QQPlayerService$9
  implements Runnable
{
  QQPlayerService$9(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.h() == 5) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.b(QQPlayerService.h()) + ",needRetryPlay:" + bool);
      }
      int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "QmusicHlsMaxRetryTimes", 3);
      if ((bool) && (QQPlayerService.d() != null) && (!TextUtils.isEmpty(QQPlayerService.d().b)) && (QQPlayerService.i() < i))
      {
        QQPlayerService.j();
        QQPlayerService.a(this.this$0, QQPlayerService.d().b);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.9
 * JD-Core Version:    0.7.0.1
 */