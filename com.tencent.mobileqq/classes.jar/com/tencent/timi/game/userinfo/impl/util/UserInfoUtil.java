package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoDbNotifyManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass.BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass.MiniInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQGroupProInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid;
import trpc.yes.common.UserProxyCmdOuterClass.UserRoomList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/util/UserInfoUtil;", "", "()V", "acquireRunTime", "Lmqq/app/AppRuntime;", "bindListener", "", "listener", "Lcom/tencent/timi/game/databasecore/impl/notify/DbNotifyListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "convertRetQQUserInfo", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "info", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "convertToQQUserInfo", "entity", "removeBindListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoUtil
{
  public static final UserInfoUtil a = new UserInfoUtil();
  
  @NotNull
  public final UserInfoEntity a(@NotNull UserProxyCmdOuterClass.QQUserInfo paramQQUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserInfo, "info");
    UserInfoEntity localUserInfoEntity = new UserInfoEntity();
    Object localObject1 = paramQQUserInfo.mini_info;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((UserProxyCmdOuterClass.MiniInfo)localObject1).base_info;
      if (localObject1 != null)
      {
        localObject1 = ((UserProxyCmdOuterClass.BaseInfo)localObject1).toByteArray();
        break label54;
      }
    }
    localObject1 = null;
    label54:
    localUserInfoEntity.qqBaseInfo = ((byte[])localObject1);
    localObject1 = paramQQUserInfo.game_openid;
    if (localObject1 != null) {
      localObject1 = ((UserProxyCmdOuterClass.UserGameOpenid)localObject1).toByteArray();
    } else {
      localObject1 = null;
    }
    localUserInfoEntity.userGameOpenid = ((byte[])localObject1);
    localObject1 = paramQQUserInfo.mini_info;
    if (localObject1 != null)
    {
      localObject1 = ((UserProxyCmdOuterClass.MiniInfo)localObject1).avatar;
      if (localObject1 != null)
      {
        localObject1 = ((PBStringField)localObject1).get();
        break label128;
      }
    }
    localObject1 = null;
    label128:
    localUserInfoEntity.extensionAvatar = ((String)localObject1);
    localObject1 = paramQQUserInfo.mini_info;
    if (localObject1 != null)
    {
      localObject1 = ((UserProxyCmdOuterClass.MiniInfo)localObject1).long_nick;
      if (localObject1 != null)
      {
        localObject1 = ((PBStringField)localObject1).get();
        break label171;
      }
    }
    localObject1 = null;
    label171:
    localUserInfoEntity.extensionNick = ((String)localObject1);
    localObject1 = paramQQUserInfo.uid;
    long l;
    if (localObject1 != null) {
      l = ((PBUInt64Field)localObject1).get();
    } else {
      l = 0L;
    }
    localUserInfoEntity.uid = l;
    localObject1 = paramQQUserInfo.group_pro_info;
    if (localObject1 != null) {
      localObject1 = ((UserProxyCmdOuterClass.QQGroupProInfo)localObject1).toByteArray();
    } else {
      localObject1 = null;
    }
    localUserInfoEntity.groupProInfo = ((byte[])localObject1);
    localObject1 = paramQQUserInfo.auth_status;
    int i;
    if (localObject1 != null) {
      i = ((PBInt32Field)localObject1).get();
    } else {
      i = 0;
    }
    localUserInfoEntity.authStatus = i;
    localObject1 = paramQQUserInfo.defaul_smoba_role;
    if (localObject1 != null) {
      localObject1 = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).toByteArray();
    } else {
      localObject1 = null;
    }
    localUserInfoEntity.defaultSmobaRoleExtInfo = ((byte[])localObject1);
    localObject1 = paramQQUserInfo.user_room_list;
    paramQQUserInfo = localObject2;
    if (localObject1 != null) {
      paramQQUserInfo = ((UserProxyCmdOuterClass.UserRoomList)localObject1).toByteArray();
    }
    localUserInfoEntity.userRoomList = paramQQUserInfo;
    return localUserInfoEntity;
  }
  
  @Nullable
  public final UserProxyCmdOuterClass.QQUserInfo a(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    if (paramUserInfoEntity == null) {
      return null;
    }
    UserProxyCmdOuterClass.QQUserInfo localQQUserInfo = new UserProxyCmdOuterClass.QQUserInfo();
    localQQUserInfo.uid.set(paramUserInfoEntity.uid);
    UserProxyCmdOuterClass.MiniInfo localMiniInfo = new UserProxyCmdOuterClass.MiniInfo();
    localMiniInfo.avatar.set(paramUserInfoEntity.extensionAvatar);
    localMiniInfo.long_nick.set(paramUserInfoEntity.extensionNick);
    localMiniInfo.base_info.set((MessageMicro)UserInfoEntityUtil.a.a(paramUserInfoEntity));
    localQQUserInfo.mini_info.set((MessageMicro)localMiniInfo);
    localQQUserInfo.group_pro_info.set((MessageMicro)UserInfoEntityUtil.a.c(paramUserInfoEntity));
    localQQUserInfo.defaul_smoba_role.set((MessageMicro)UserInfoEntityUtil.a.d(paramUserInfoEntity));
    return localQQUserInfo;
  }
  
  public final void a(@NotNull DbNotifyListener<IUserInfo> paramDbNotifyListener)
  {
    Intrinsics.checkParameterIsNotNull(paramDbNotifyListener, "listener");
    UserInfoDbNotifyManager.a.a().a(paramDbNotifyListener);
  }
  
  public final void b(@NotNull DbNotifyListener<IUserInfo> paramDbNotifyListener)
  {
    Intrinsics.checkParameterIsNotNull(paramDbNotifyListener, "listener");
    UserInfoDbNotifyManager.a.a().b(paramDbNotifyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoUtil
 * JD-Core Version:    0.7.0.1
 */