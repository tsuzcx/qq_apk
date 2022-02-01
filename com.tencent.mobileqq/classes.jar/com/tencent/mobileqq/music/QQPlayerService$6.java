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
    if (QQPlayerService.t() == 5) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("===========> timeout retry to check playState:");
      localStringBuilder.append(QQPlayerService.d(QQPlayerService.t()));
      localStringBuilder.append(",needRetryPlay:");
      localStringBuilder.append(bool);
      QLog.e("QQPlayerService", 2, localStringBuilder.toString());
    }
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "QmusicHlsMaxRetryTimes", 3);
    if ((bool) && (QQPlayerService.s() != null) && (!TextUtils.isEmpty(QQPlayerService.s().d)) && (QQPlayerService.u() < i))
    {
      QQPlayerService.v();
      QQPlayerService.a(this.this$0, QQPlayerService.s().d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.6
 * JD-Core Version:    0.7.0.1
 */