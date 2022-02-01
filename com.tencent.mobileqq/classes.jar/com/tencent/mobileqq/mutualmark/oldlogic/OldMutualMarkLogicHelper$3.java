package com.tencent.mobileqq.mutualmark.oldlogic;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;

final class OldMutualMarkLogicHelper$3
  implements Runnable
{
  OldMutualMarkLogicHelper$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      HashSet localHashSet = HotReactiveHelper.a();
      if ((localHashSet != null) && (localHashSet.size() > 0))
      {
        localFriendsManager.b(new ArrayList(localHashSet));
        localHashSet.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.3
 * JD-Core Version:    0.7.0.1
 */