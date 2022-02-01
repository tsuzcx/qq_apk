package com.tencent.timi.game.userinfo.api;

import com.tencent.timi.game.IViewCreator;
import com.tencent.timi.game.databasecore.impl.livedata.IDbLiveData;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/api/IUserInfoService;", "Lcom/tencent/timi/game/router/IService;", "Lcom/tencent/timi/game/IViewCreator;", "convertToUserInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "qqUserInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "createCommunityUerId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "guildId", "createPCDDUerId", "getUserInfoAndUpdate", "Lcom/tencent/timi/game/databasecore/impl/livedata/IDbLiveData;", "uid", "getUserInfoFromDB", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "getUserInfoFromDBOrNet", "getUserInfoFromNet", "getUserInfoFromNetWithRsp", "Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "getUserInfoOrUpdate", "getUserInfoWrapper", "Lcom/tencent/timi/game/userinfo/api/view/UserInfoViewWrapper;", "iUserInfoView", "Lcom/tencent/timi/game/userinfo/api/view/IUserInfoView;", "initRegisterDatabaseModelClass", "onTGDestroy", "updateQQUserInfoToDB", "info", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserInfoService
  extends IViewCreator, IService
{
  @NotNull
  public abstract IDbLiveData<? extends IUserInfo> a(long paramLong);
  
  @NotNull
  public abstract IUserInfo a(@NotNull UserProxyCmdOuterClass.QQUserInfo paramQQUserInfo);
  
  @NotNull
  public abstract UserInfoViewWrapper a(@NotNull IUserInfoView paramIUserInfoView);
  
  @NotNull
  public abstract CommonOuterClass.QQUserId a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener);
  
  @NotNull
  public abstract CommonOuterClass.QQUserId b(long paramLong);
  
  public abstract void b();
  
  public abstract void b(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener);
  
  public abstract void b(@NotNull UserProxyCmdOuterClass.QQUserInfo paramQQUserInfo);
  
  public abstract void c();
  
  public abstract void c(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener);
  
  public abstract void d(long paramLong, @Nullable IResultListener<NetRspUserData> paramIResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.api.IUserInfoService
 * JD-Core Version:    0.7.0.1
 */