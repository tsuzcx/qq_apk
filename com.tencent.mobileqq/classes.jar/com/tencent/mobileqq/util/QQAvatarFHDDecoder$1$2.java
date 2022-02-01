package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

class QQAvatarFHDDecoder$1$2
  implements Runnable
{
  QQAvatarFHDDecoder$1$2(QQAvatarFHDDecoder.1 param1, String paramString) {}
  
  public void run()
  {
    if (QQAvatarFHDDecoder.b(this.b.a)) {
      return;
    }
    Setting localSetting = QQAvatarFHDDecoder.c(this.b.a).getQQHeadSettingFromDB(this.a);
    this.b.a.a(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2
 * JD-Core Version:    0.7.0.1
 */