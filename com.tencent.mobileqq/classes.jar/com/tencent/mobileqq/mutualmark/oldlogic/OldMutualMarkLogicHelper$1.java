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
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    boolean bool2 = false;
    if (((FriendsManager)localObject1).a((String)localObject2, false) == null) {
      return;
    }
    if (((FriendsManager)localObject1).a(false)) {
      return;
    }
    localObject1 = MutualMarkDataCenter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 7L, false);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((MutualMarkForDisplayInfo)localObject1).b > 0L)
      {
        bool1 = bool2;
        if (((MutualMarkForDisplayInfo)localObject1).a()) {
          bool1 = true;
        }
      }
    }
    ((FriendChatPie)localObject2).F = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.F) {
      OldMutualMarkLogicHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */