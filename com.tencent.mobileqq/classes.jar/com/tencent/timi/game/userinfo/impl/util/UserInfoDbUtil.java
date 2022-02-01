package com.tencent.timi.game.userinfo.impl.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.AllUserInfoModel;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.UserDefaultRole;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/util/UserInfoDbUtil;", "", "()V", "TAG", "", "convertToUserInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "entity", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "insertOrUpdate", "", "insertOrUpdateList", "entityList", "", "notifyDbChanged", "info", "notifyDbChangedList", "infoList", "onResultError", "weakReference", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/utils/IResultListener;", "errorCode", "", "errorString", "onResultSuccess", "queryUserInfo", "uid", "", "listener", "queryUserInfoSync", "yesDataBaseHelper", "Lcom/tencent/timi/game/databasecore/impl/YesDataBaseHelper;", "updateBaseInfoByDBEntity", "dbEntity", "updateUserSmobaInfo", "roleList", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoDbUtil
{
  public static final UserInfoDbUtil a = new UserInfoDbUtil();
  private static final String b = "UserInfoDbUtil";
  
  private final UserInfoEntity a(long paramLong, YesDataBaseHelper paramYesDataBaseHelper)
  {
    paramYesDataBaseHelper = paramYesDataBaseHelper.a(UserInfoEntity.class, false, "uid=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if ((paramYesDataBaseHelper != null) && (paramYesDataBaseHelper.size() > 0))
    {
      paramYesDataBaseHelper = (Entity)paramYesDataBaseHelper.get(0);
      if ((paramYesDataBaseHelper instanceof UserInfoEntity)) {
        return (UserInfoEntity)paramYesDataBaseHelper;
      }
    }
    Logger.c(b, "queryUserInfoSync not find ");
    return null;
  }
  
  private final UserInfoEntity a(UserInfoEntity paramUserInfoEntity1, UserInfoEntity paramUserInfoEntity2)
  {
    if (paramUserInfoEntity2 != null)
    {
      paramUserInfoEntity2.extensionAvatar = paramUserInfoEntity1.extensionAvatar;
      paramUserInfoEntity2.extensionNick = paramUserInfoEntity1.extensionNick;
      paramUserInfoEntity2.qqBaseInfo = paramUserInfoEntity1.qqBaseInfo;
      paramUserInfoEntity2.groupProInfo = paramUserInfoEntity1.groupProInfo;
      return paramUserInfoEntity2;
    }
    return paramUserInfoEntity1;
  }
  
  private final void a(IUserInfo paramIUserInfo)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserInfoDbUtil.notifyDbChanged.1(paramIUserInfo));
  }
  
  private final void a(WeakReference<IResultListener<IUserInfo>> paramWeakReference, int paramInt, String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserInfoDbUtil.onResultError.1(paramWeakReference, paramInt, paramString));
  }
  
  private final void c(List<? extends IUserInfo> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserInfoDbUtil.notifyDbChangedList.1(paramList));
  }
  
  public final void a(long paramLong, @NotNull IResultListener<IUserInfo> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIResultListener, "listener");
    IUserInfo localIUserInfo = UserInfoCacheManager.a.a().a(paramLong);
    WeakReference localWeakReference = new WeakReference(paramIResultListener);
    if (localIUserInfo != null)
    {
      if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
      {
        paramIResultListener.a(localIUserInfo);
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserInfoDbUtil.queryUserInfo.1(localWeakReference, localIUserInfo));
      return;
    }
    ThreadManagerV2.excute((Runnable)new UserInfoDbUtil.queryUserInfo.2(paramLong, localWeakReference), 32, null, true);
  }
  
  public final void a(@NotNull UserInfoEntity paramUserInfoEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramUserInfoEntity, "entity");
    ThreadManagerV2.excute((Runnable)new UserInfoDbUtil.insertOrUpdate.1(paramUserInfoEntity), 32, null, true);
  }
  
  public final void a(@NotNull List<? extends UserInfoEntity> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "entityList");
    ThreadManagerV2.excute((Runnable)new UserInfoDbUtil.insertOrUpdateList.1(paramList), 32, null, true);
  }
  
  @NotNull
  public final IUserInfo b(@NotNull UserInfoEntity paramUserInfoEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramUserInfoEntity, "entity");
    return (IUserInfo)new AllUserInfoModel(paramUserInfoEntity);
  }
  
  public final void b(@NotNull List<GameDataServerOuterClass.UserDefaultRole> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "roleList");
    ThreadManagerV2.excute((Runnable)new UserInfoDbUtil.updateUserSmobaInfo.1(paramList), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil
 * JD-Core Version:    0.7.0.1
 */