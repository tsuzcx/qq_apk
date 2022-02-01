package com.tencent.mobileqq.extendfriend.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.qphone.base.util.QLog;

final class ExtendFriendLabelUtils$2
  implements Runnable
{
  ExtendFriendLabelUtils$2(AppInterface paramAppInterface) {}
  
  public void run()
  {
    String str = this.a.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      QLog.d("expand.ExtendFriendLabelUtils", 1, "checkABTestPassTime uin is empty");
    }
    while (ExpandSharePreUtils.b(str)) {
      return;
    }
    ExpandSharePreUtils.a(str, System.currentTimeMillis());
    new ExpandConfigManager((QQAppInterface)this.a).a(new ExtendFriendLabelUtils.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils.2
 * JD-Core Version:    0.7.0.1
 */