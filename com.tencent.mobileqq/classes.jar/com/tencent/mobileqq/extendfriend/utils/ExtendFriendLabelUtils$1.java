package com.tencent.mobileqq.extendfriend.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.proxyinner.plugin.loader.ShadowPluginsProcessService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class ExtendFriendLabelUtils$1
  implements Runnable
{
  ExtendFriendLabelUtils$1(AppInterface paramAppInterface) {}
  
  public void run()
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if ((localExtendFriendManager.f()) && (localExtendFriendManager.g())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("expand.ExtendFriendLabelUtils", 2, "preloadProcessIfPlugin " + bool);
      }
      if (bool) {
        ShadowPluginsProcessService.a(MobileQQ.sMobileQQ);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils.1
 * JD-Core Version:    0.7.0.1
 */