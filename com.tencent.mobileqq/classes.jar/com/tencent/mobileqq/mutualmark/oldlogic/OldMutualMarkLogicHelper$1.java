package com.tencent.mobileqq.mutualmark.oldlogic;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;

final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false) == null) {
      break label29;
    }
    label29:
    while (((FriendsManager)localObject).a(false)) {
      return;
    }
    localObject = MutualMarkDataCenter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 7L, false);
    FriendChatPie localFriendChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie;
    if ((localObject != null) && (((MutualMarkForDisplayInfo)localObject).b > 0L) && (((MutualMarkForDisplayInfo)localObject).a())) {}
    for (boolean bool = true;; bool = false)
    {
      localFriendChatPie.P = bool;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.P) {
        break;
      }
      OldMutualMarkLogicHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */