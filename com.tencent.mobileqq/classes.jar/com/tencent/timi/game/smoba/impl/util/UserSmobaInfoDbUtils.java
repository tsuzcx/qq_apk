package com.tencent.timi.game.smoba.impl.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoEntity;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoEntity.Companion;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/util/UserSmobaInfoDbUtils;", "", "()V", "TAG", "", "getAuthDescInfoFromDB", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "", "callback", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "getUserDefaultAccountFromDB", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "getUserSmobaRoleListRspFromDB", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "loadUserSmobaInfoFromDB", "Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoEntity;", "saveAccountList", "rsp", "saveAccountListInner", "roleListRsp", "", "saveAuthInfo", "saveAuthListInner", "authInfo", "saveDefaultAccount", "saveDefaultAccountInner", "defaultRole", "saveUserSmobaInfoToDB", "entity", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoDbUtils
{
  public static final UserSmobaInfoDbUtils a = new UserSmobaInfoDbUtils();
  
  private final void a(UserSmobaInfoEntity paramUserSmobaInfoEntity)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveUserSmobaInfoToDB entity:");
        localStringBuilder.append(paramUserSmobaInfoEntity);
        Logger.a("UserSmobaInfoImpl_", localStringBuilder.toString());
        if (((CharSequence)paramUserSmobaInfoEntity.uin).length() == 0)
        {
          i = 1;
          if (i != 0)
          {
            Logger.a("UserSmobaInfoImpl_", "saveUserSmobaInfoToDB bad uin!");
            return;
          }
          boolean bool = YesDataBaseHelper.a().a((Entity)paramUserSmobaInfoEntity);
          paramUserSmobaInfoEntity = new StringBuilder();
          paramUserSmobaInfoEntity.append("saveUserSmobaInfoToDB insertOrUpdateEntity:");
          paramUserSmobaInfoEntity.append(bool);
          Logger.a("UserSmobaInfoImpl_", paramUserSmobaInfoEntity.toString());
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    try
    {
      UserSmobaInfoEntity localUserSmobaInfoEntity2 = d();
      UserSmobaInfoEntity localUserSmobaInfoEntity1 = localUserSmobaInfoEntity2;
      if (localUserSmobaInfoEntity2 == null) {
        localUserSmobaInfoEntity1 = UserSmobaInfoEntity.Companion.a();
      }
      localUserSmobaInfoEntity1.authDescInfo = paramArrayOfByte;
      a(localUserSmobaInfoEntity1);
      return;
    }
    finally {}
  }
  
  private final void b(byte[] paramArrayOfByte)
  {
    try
    {
      UserSmobaInfoEntity localUserSmobaInfoEntity2 = d();
      UserSmobaInfoEntity localUserSmobaInfoEntity1 = localUserSmobaInfoEntity2;
      if (localUserSmobaInfoEntity2 == null) {
        localUserSmobaInfoEntity1 = UserSmobaInfoEntity.Companion.a();
      }
      localUserSmobaInfoEntity1.accountListInfo = paramArrayOfByte;
      a(localUserSmobaInfoEntity1);
      return;
    }
    finally {}
  }
  
  private final void c(byte[] paramArrayOfByte)
  {
    try
    {
      UserSmobaInfoEntity localUserSmobaInfoEntity2 = d();
      UserSmobaInfoEntity localUserSmobaInfoEntity1 = localUserSmobaInfoEntity2;
      if (localUserSmobaInfoEntity2 == null) {
        localUserSmobaInfoEntity1 = UserSmobaInfoEntity.Companion.a();
      }
      localUserSmobaInfoEntity1.defaultAccountInfo = paramArrayOfByte;
      a(localUserSmobaInfoEntity1);
      return;
    }
    finally {}
  }
  
  private final UserSmobaInfoEntity d()
  {
    try
    {
      Object localObject1 = ServiceCenter.a(ILoginCoreService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
      localObject1 = ((ILoginCoreService)localObject1).b();
      Object localObject3 = YesDataBaseHelper.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "uin");
      List localList = ((YesDataBaseHelper)localObject3).a(UserSmobaInfoEntity.class, true, "uin=? ", new String[] { localObject1 }, null, null, null, null);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadUserSmobaInfoFromDB entityList:");
      ((StringBuilder)localObject1).append(localList);
      Logger.a("UserSmobaInfoImpl_", ((StringBuilder)localObject1).toString());
      localObject3 = (UserSmobaInfoEntity)null;
      localObject1 = localObject3;
      if (localList != null)
      {
        localObject1 = localObject3;
        if ((((Collection)localList).isEmpty() ^ true)) {
          localObject1 = (UserSmobaInfoEntity)localList.get(0);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  @Nullable
  public final GameDataServerOuterClass.GetUserSmobaRoleListRsp a()
  {
    Object localObject2 = d();
    if (localObject2 != null) {
      localObject1 = ((UserSmobaInfoEntity)localObject2).accountListInfo;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      Logger.a("UserSmobaInfoDbUtils_", "getUserSmobaRoleListRspFromDB null.");
      return null;
    }
    Object localObject1 = new GameDataServerOuterClass.GetUserSmobaRoleListRsp();
    try
    {
      localObject2 = (GameDataServerOuterClass.GetUserSmobaRoleListRsp)((GameDataServerOuterClass.GetUserSmobaRoleListRsp)localObject1).mergeFrom(((UserSmobaInfoEntity)localObject2).accountListInfo);
    }
    catch (Exception localException)
    {
      localObject1 = (GameDataServerOuterClass.GetUserSmobaRoleListRsp)null;
      Logger.a("UserSmobaInfoDbUtils_", "getUserSmobaRoleListRspFromDB failed!", (Throwable)localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserSmobaRoleListRspFromDB rsp:");
    localStringBuilder.append(localObject1);
    Logger.a("UserSmobaInfoDbUtils_", localStringBuilder.toString());
    return localObject1;
  }
  
  public final void a(@Nullable IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp> paramCallback)
  {
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoDbUtils.getUserDefaultAccountFromDB.1(paramCallback), 32, null, true);
  }
  
  public final void a(@NotNull GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaAuthInfoRsp, "rsp");
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoDbUtils.saveAuthInfo.1(paramGetSmobaAuthInfoRsp), 32, null, true);
  }
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoDbUtils.saveDefaultAccount.1(paramGetSmobaDefaultRoleRsp), 32, null, true);
  }
  
  public final void a(@Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    ThreadManagerV2.excute((Runnable)new UserSmobaInfoDbUtils.saveAccountList.1(paramGetUserSmobaRoleListRsp), 32, null, true);
  }
  
  @Nullable
  public final GameDataServerOuterClass.GetSmobaDefaultRoleRsp b()
  {
    Object localObject2 = d();
    if (localObject2 != null) {
      localObject1 = ((UserSmobaInfoEntity)localObject2).defaultAccountInfo;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      Logger.a("UserSmobaInfoDbUtils_", "getUserDefaultAccountFromDB null.");
      return null;
    }
    Object localObject1 = new GameDataServerOuterClass.GetSmobaDefaultRoleRsp();
    try
    {
      localObject2 = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)localObject1).mergeFrom(((UserSmobaInfoEntity)localObject2).defaultAccountInfo);
    }
    catch (Exception localException)
    {
      localObject1 = (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)null;
      Logger.a("UserSmobaInfoDbUtils_", "getUserDefaultAccountFromDB failed!", (Throwable)localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUserDefaultAccountFromDB rsp:");
    localStringBuilder.append(localObject1);
    Logger.a("UserSmobaInfoDbUtils_", localStringBuilder.toString());
    return localObject1;
  }
  
  @Nullable
  public final GameDataServerOuterClass.GetSmobaAuthInfoRsp c()
  {
    Object localObject2 = d();
    if (localObject2 != null) {
      localObject1 = ((UserSmobaInfoEntity)localObject2).authDescInfo;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      Logger.a("UserSmobaInfoDbUtils_", "getAuthDescInfoFromDB null.");
      return null;
    }
    Object localObject1 = new GameDataServerOuterClass.GetSmobaAuthInfoRsp();
    try
    {
      localObject2 = (GameDataServerOuterClass.GetSmobaAuthInfoRsp)((GameDataServerOuterClass.GetSmobaAuthInfoRsp)localObject1).mergeFrom(((UserSmobaInfoEntity)localObject2).authDescInfo);
    }
    catch (Exception localException)
    {
      localObject1 = (GameDataServerOuterClass.GetSmobaAuthInfoRsp)null;
      Logger.a("UserSmobaInfoDbUtils_", "getAuthDescInfoFromDB failed!", (Throwable)localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAuthDescInfoFromDB rsp:");
    localStringBuilder.append(localObject1);
    Logger.a("UserSmobaInfoDbUtils_", localStringBuilder.toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils
 * JD-Core Version:    0.7.0.1
 */