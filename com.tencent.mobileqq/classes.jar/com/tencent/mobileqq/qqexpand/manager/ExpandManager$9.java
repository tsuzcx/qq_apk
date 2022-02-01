package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.utils.ExtendFriendGetLocationListener;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$9
  implements ExtendFriendGetLocationListener
{
  ExpandManager$9(ExpandManager paramExpandManager) {}
  
  public void a(boolean paramBoolean, ExtendFriendLocationInfo paramExtendFriendLocationInfo)
  {
    if (ExpandManager.a(this.a) == null)
    {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc");
    }
    if (this.a.k())
    {
      ((ExpandHandlerImpl)ExpandManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramExtendFriendLocationInfo);
      paramExtendFriendLocationInfo = new StringBuilder();
      paramExtendFriendLocationInfo.append("enterExtendFriend onGetLocationInfo NOT suc:");
      paramExtendFriendLocationInfo.append(paramBoolean);
      QLog.i("ExtendFriendManager", 2, paramExtendFriendLocationInfo.toString());
      return;
    }
    QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT In extendfriend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.9
 * JD-Core Version:    0.7.0.1
 */