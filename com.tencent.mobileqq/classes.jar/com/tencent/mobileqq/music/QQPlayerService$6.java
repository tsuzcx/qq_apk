package com.tencent.mobileqq.music;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class QQPlayerService$6
  implements Runnable
{
  QQPlayerService$6(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    boolean bool;
    if (QQPlayerService.h() == 5) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("===========> timeout retry to check playState:");
      localStringBuilder.append(QQPlayerService.b(QQPlayerService.h()));
      localStringBuilder.append(",needRetryPlay:");
      localStringBuilder.append(bool);
      QLog.e("QQPlayerService", 2, localStringBuilder.toString());
    }
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "QmusicHlsMaxRetryTimes", 3);
    if ((bool) && (QQPlayerService.e() != null) && (!TextUtils.isEmpty(QQPlayerService.e().b)) && (QQPlayerService.i() < i))
    {
      QQPlayerService.j();
      QQPlayerService.a(this.this$0, QQPlayerService.e().b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.6
 * JD-Core Version:    0.7.0.1
 */