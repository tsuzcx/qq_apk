package com.tencent.timi.game.userinfo.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "", "userInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onlineRouteInfoList", "Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "(Lcom/tencent/timi/game/userinfo/api/IUserInfo;Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "getOnlineRouteInfoList", "()Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "setOnlineRouteInfoList", "(Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "getUserInfo", "()Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "setUserInfo", "(Lcom/tencent/timi/game/userinfo/api/IUserInfo;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class NetRspUserData
{
  @Nullable
  private IUserInfo a;
  @Nullable
  private CommonOuterClass.OnlineRouteInfoList b;
  
  public NetRspUserData(@Nullable IUserInfo paramIUserInfo, @Nullable CommonOuterClass.OnlineRouteInfoList paramOnlineRouteInfoList)
  {
    this.a = paramIUserInfo;
    this.b = paramOnlineRouteInfoList;
  }
  
  @Nullable
  public final IUserInfo a()
  {
    return this.a;
  }
  
  @Nullable
  public final CommonOuterClass.OnlineRouteInfoList b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.api.NetRspUserData
 * JD-Core Version:    0.7.0.1
 */