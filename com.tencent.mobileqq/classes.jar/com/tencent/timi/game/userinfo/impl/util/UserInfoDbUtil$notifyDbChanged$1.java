package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$notifyDbChanged$1
  implements Runnable
{
  UserInfoDbUtil$notifyDbChanged$1(IUserInfo paramIUserInfo) {}
  
  public final void run()
  {
    UserInfoDbNotifyManager.a.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.notifyDbChanged.1
 * JD-Core Version:    0.7.0.1
 */