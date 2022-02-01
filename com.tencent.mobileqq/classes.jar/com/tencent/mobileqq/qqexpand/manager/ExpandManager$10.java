package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.utils.ExtendFriendGetLocationListener;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$10
  implements ExtendFriendGetLocationListener
{
  public void a(boolean paramBoolean, ExtendFriendLocationInfo paramExtendFriendLocationInfo)
  {
    if (ExpandManager.a(this.a) == null)
    {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "getLocationAndOpenSignal onGetLocationInfo NOT suc");
    }
    int i = ExtendFriendLimitChatManager.a(ExpandManager.a(this.a));
    ((ExpandHandlerImpl)ExpandManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(i, paramExtendFriendLocationInfo);
    paramExtendFriendLocationInfo = new StringBuilder();
    paramExtendFriendLocationInfo.append("getLocationAndOpenSignal onGetLocationInfo  suc:");
    paramExtendFriendLocationInfo.append(paramBoolean);
    QLog.i("ExtendFriendManager", 2, paramExtendFriendLocationInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.10
 * JD-Core Version:    0.7.0.1
 */