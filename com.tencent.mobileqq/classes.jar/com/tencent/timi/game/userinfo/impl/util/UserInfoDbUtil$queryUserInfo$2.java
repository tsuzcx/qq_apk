package com.tencent.timi.game.userinfo.impl.util;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$queryUserInfo$2
  implements Runnable
{
  UserInfoDbUtil$queryUserInfo$2(long paramLong, WeakReference paramWeakReference) {}
  
  public final void run()
  {
    Object localObject1 = YesDataBaseHelper.a();
    Object localObject2 = UserInfoDbUtil.a;
    long l = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "yesDataBaseHelper");
    localObject1 = UserInfoDbUtil.a((UserInfoDbUtil)localObject2, l, (YesDataBaseHelper)localObject1);
    if (localObject1 != null)
    {
      localObject1 = UserInfoDbUtil.a.b((UserInfoEntity)localObject1);
      localObject2 = UserInfoCacheManager.a.a();
      Long localLong = ((IUserInfo)localObject1).a();
      Intrinsics.checkExpressionValueIsNotNull(localLong, "userInfo.uid()");
      ((UserInfoCacheManager)localObject2).b(localLong.longValue(), (IUserInfo)localObject1);
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserInfoDbUtil.queryUserInfo.2.1(this, (IUserInfo)localObject1));
      return;
    }
    UserInfoDbUtil.a(UserInfoDbUtil.a, this.b, 1, "data not found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.queryUserInfo.2
 * JD-Core Version:    0.7.0.1
 */