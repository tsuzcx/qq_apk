package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager.Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$notifyDbChangedList$1
  implements Runnable
{
  UserInfoDbUtil$notifyDbChangedList$1(List paramList) {}
  
  public final void run()
  {
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      IUserInfo localIUserInfo = (IUserInfo)localIterator.next();
      UserInfoDbNotifyManager.a.a().a(localIUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.notifyDbChangedList.1
 * JD-Core Version:    0.7.0.1
 */