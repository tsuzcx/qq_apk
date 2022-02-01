package com.tencent.mobileqq.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;

class QQAvatarFHDDecoder$2
  implements Runnable
{
  QQAvatarFHDDecoder$2(QQAvatarFHDDecoder paramQQAvatarFHDDecoder, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (QQAvatarFHDDecoder.b(this.this$0)) {
      return;
    }
    Setting localSetting = QQAvatarFHDDecoder.c(this.this$0).getQQHeadSettingFromDB(this.a);
    if ((!this.b) && (localSetting != null) && (!TextUtils.isEmpty(localSetting.url)) && (System.currentTimeMillis() - localSetting.updateTimestamp <= 86400000L))
    {
      this.this$0.a(localSetting);
      return;
    }
    ((IQQAvatarHandlerService)QQAvatarFHDDecoder.c(this.this$0).getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.2
 * JD-Core Version:    0.7.0.1
 */