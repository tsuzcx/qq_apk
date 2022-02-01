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
    Object localObject1 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = this.b.b;
    boolean bool2 = false;
    if (((FriendsManager)localObject1).d((String)localObject2, false) == null) {
      return;
    }
    if (((FriendsManager)localObject1).a(false)) {
      return;
    }
    localObject1 = MutualMarkDataCenter.a(this.a, this.b.b, 7L, false);
    localObject2 = this.c;
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
    ((FriendChatPie)localObject2).bo = bool1;
    if (this.c.bo) {
      OldMutualMarkLogicHelper.b(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */