package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass.BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQGroupProInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/util/UserInfoEntityUtil;", "", "()V", "convertToBaseInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "entity", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "convertToQQGroupProInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "convertToSmobaGameRoleExtInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleInfo;", "convertToUserGameOpenid", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "convertToUserRoomList", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserRoomList;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoEntityUtil
{
  public static final UserInfoEntityUtil a = new UserInfoEntityUtil();
  
  @Nullable
  public final UserProxyCmdOuterClass.BaseInfo a(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    byte[] arrayOfByte = null;
    UserProxyCmdOuterClass.BaseInfo localBaseInfo = (UserProxyCmdOuterClass.BaseInfo)null;
    if (paramUserInfoEntity != null) {
      arrayOfByte = paramUserInfoEntity.qqBaseInfo;
    }
    paramUserInfoEntity = localBaseInfo;
    if ((arrayOfByte instanceof byte[])) {
      paramUserInfoEntity = new UserProxyCmdOuterClass.BaseInfo();
    }
    try
    {
      paramUserInfoEntity.mergeFrom(arrayOfByte);
      return paramUserInfoEntity;
    }
    catch (Exception localException) {}
    return paramUserInfoEntity;
  }
  
  @Nullable
  public final UserProxyCmdOuterClass.UserGameOpenid b(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    if (paramUserInfoEntity != null) {
      paramUserInfoEntity = paramUserInfoEntity.userGameOpenid;
    } else {
      paramUserInfoEntity = null;
    }
    UserProxyCmdOuterClass.UserGameOpenid localUserGameOpenid = (UserProxyCmdOuterClass.UserGameOpenid)null;
    if ((paramUserInfoEntity instanceof byte[])) {
      localUserGameOpenid = new UserProxyCmdOuterClass.UserGameOpenid();
    }
    try
    {
      localUserGameOpenid.mergeFrom(paramUserInfoEntity);
      return localUserGameOpenid;
    }
    catch (Exception paramUserInfoEntity) {}
    return localUserGameOpenid;
  }
  
  @Nullable
  public final UserProxyCmdOuterClass.QQGroupProInfo c(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    if (paramUserInfoEntity != null) {
      paramUserInfoEntity = paramUserInfoEntity.groupProInfo;
    } else {
      paramUserInfoEntity = null;
    }
    UserProxyCmdOuterClass.QQGroupProInfo localQQGroupProInfo = (UserProxyCmdOuterClass.QQGroupProInfo)null;
    if ((paramUserInfoEntity instanceof byte[])) {
      localQQGroupProInfo = new UserProxyCmdOuterClass.QQGroupProInfo();
    }
    try
    {
      localQQGroupProInfo.mergeFrom(paramUserInfoEntity);
      return localQQGroupProInfo;
    }
    catch (Exception paramUserInfoEntity) {}
    return localQQGroupProInfo;
  }
  
  @Nullable
  public final GameDataServerOuterClass.SmobaGameRoleInfo d(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    byte[] arrayOfByte = null;
    GameDataServerOuterClass.SmobaGameRoleInfo localSmobaGameRoleInfo = (GameDataServerOuterClass.SmobaGameRoleInfo)null;
    if (paramUserInfoEntity != null) {
      arrayOfByte = paramUserInfoEntity.defaultSmobaRoleExtInfo;
    }
    paramUserInfoEntity = localSmobaGameRoleInfo;
    if ((arrayOfByte instanceof byte[])) {
      paramUserInfoEntity = new GameDataServerOuterClass.SmobaGameRoleInfo();
    }
    try
    {
      paramUserInfoEntity.mergeFrom(arrayOfByte);
      return paramUserInfoEntity;
    }
    catch (Exception localException) {}
    return paramUserInfoEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoEntityUtil
 * JD-Core Version:    0.7.0.1
 */