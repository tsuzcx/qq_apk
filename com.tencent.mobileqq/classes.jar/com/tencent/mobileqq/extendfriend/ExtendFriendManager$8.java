package com.tencent.mobileqq.extendfriend;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.LimitChatRes;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ExtendFriendManager$8
  implements Runnable
{
  ExtendFriendManager$8(ExtendFriendManager paramExtendFriendManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
    }
    if (!ExtendFriendManager.a(this.this$0).a()) {
      QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
    }
    if (!ExtendFriendLimitChatResourceUtil.a())
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no！");
      if (ExtendFriendManager.a(this.this$0).a() == null) {
        QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
      }
    }
    else
    {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = ExtendFriendManager.a(this.this$0);
    if ((!NetworkUtil.h(BaseApplicationImpl.getContext())) && (l1 - l2 < 1200000L) && (ExtendFriendManager.a(this.this$0) > 2))
    {
      QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + l1 + " lastDownloadTime " + ExtendFriendManager.a(this.this$0) + " downloadTimes" + ExtendFriendManager.a(this.this$0));
      return;
    }
    Object localObject = ExtendFriendLimitChatResourceUtil.a();
    if ((ExtendFriendManager.a(this.this$0) != null) && (ExtendFriendManager.a(this.this$0).a().a != null))
    {
      localObject = (ExpandConfigManager.LimitChatRes)ExtendFriendManager.a(this.this$0).a().a.get(localObject);
      ExtendFriendManager.a(this.this$0).a((ExpandConfigManager.LimitChatRes)localObject);
      ExtendFriendManager.a(this.this$0, l1);
      ExtendFriendManager.b(this.this$0);
      return;
    }
    QLog.d("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.8
 * JD-Core Version:    0.7.0.1
 */