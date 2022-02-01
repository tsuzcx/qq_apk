package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$insertOrUpdate$1
  implements Runnable
{
  UserInfoDbUtil$insertOrUpdate$1(UserInfoEntity paramUserInfoEntity) {}
  
  public final void run()
  {
    YesDataBaseHelper.a().a((Entity)this.a);
    IUserInfo localIUserInfo = UserInfoDbUtil.a.b(this.a);
    UserInfoDbUtil.a(UserInfoDbUtil.a, localIUserInfo);
    UserInfoCacheManager localUserInfoCacheManager = UserInfoCacheManager.a.a();
    Long localLong = localIUserInfo.a();
    Intrinsics.checkExpressionValueIsNotNull(localLong, "userInfo.uid()");
    localUserInfoCacheManager.a(localLong.longValue(), localIUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.insertOrUpdate.1
 * JD-Core Version:    0.7.0.1
 */