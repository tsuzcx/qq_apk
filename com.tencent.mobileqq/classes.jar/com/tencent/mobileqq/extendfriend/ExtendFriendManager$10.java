package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.ExtendFriendLocationInfo;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendGetLocationListener;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendManager$10
  implements ExtendFriendGetLocationListener
{
  ExtendFriendManager$10(ExtendFriendManager paramExtendFriendManager) {}
  
  public void a(boolean paramBoolean, ExtendFriendLocationInfo paramExtendFriendLocationInfo)
  {
    if (ExtendFriendManager.a(this.a) == null)
    {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo NOT suc");
    }
    int i = ExtendFriendLimitChatManager.a(ExtendFriendManager.a(this.a));
    ((ExtendFriendHandler)ExtendFriendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(i, paramExtendFriendLocationInfo);
    QLog.i("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo  suc:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.10
 * JD-Core Version:    0.7.0.1
 */