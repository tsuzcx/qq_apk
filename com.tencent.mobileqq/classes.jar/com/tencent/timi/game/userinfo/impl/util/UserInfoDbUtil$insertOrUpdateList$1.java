package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$insertOrUpdateList$1
  implements Runnable
{
  UserInfoDbUtil$insertOrUpdateList$1(List paramList) {}
  
  public final void run()
  {
    YesDataBaseHelper localYesDataBaseHelper = YesDataBaseHelper.a();
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (UserInfoEntity)localIterator.next();
      Object localObject2 = UserInfoDbUtil.a;
      long l = ((UserInfoEntity)localObject1).uid;
      Intrinsics.checkExpressionValueIsNotNull(localYesDataBaseHelper, "yesDataBaseHelper");
      localObject2 = UserInfoDbUtil.a((UserInfoDbUtil)localObject2, l, localYesDataBaseHelper);
      localObject1 = UserInfoDbUtil.a(UserInfoDbUtil.a, (UserInfoEntity)localObject1, (UserInfoEntity)localObject2);
      localYesDataBaseHelper.a((Entity)localObject1);
      localObject1 = UserInfoDbUtil.a.b((UserInfoEntity)localObject1);
      localObject2 = UserInfoCacheManager.a.a();
      Long localLong = ((IUserInfo)localObject1).a();
      Intrinsics.checkExpressionValueIsNotNull(localLong, "userInfo.uid()");
      ((UserInfoCacheManager)localObject2).a(localLong.longValue(), (IUserInfo)localObject1);
      localList.add(localObject1);
    }
    UserInfoDbUtil.a(UserInfoDbUtil.a, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.insertOrUpdateList.1
 * JD-Core Version:    0.7.0.1
 */