package com.tencent.mobileqq.util;

import android.text.TextUtils;
import azyp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class QQAvatarFHDDecoder$2
  implements Runnable
{
  public void run()
  {
    if (azyp.a(this.this$0)) {
      return;
    }
    Setting localSetting = azyp.a(this.this$0).c(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Boolean) || (localSetting == null) || (TextUtils.isEmpty(localSetting.url)) || (System.currentTimeMillis() - localSetting.updateTimestamp > 86400000L))
    {
      azyp.a(this.this$0).c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.this$0.a(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.2
 * JD-Core Version:    0.7.0.1
 */