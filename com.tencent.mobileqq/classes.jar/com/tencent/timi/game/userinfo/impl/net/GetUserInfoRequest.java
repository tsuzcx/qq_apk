package com.tencent.timi.game.userinfo.impl.net;

import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.NetRspUserData;
import com.tencent.timi.game.userinfo.impl.net.servlet.GetUserInfoDataServlet;
import com.tencent.timi.game.userinfo.impl.net.servlet.GetUserInfoDataServlet.Companion;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/net/GetUserInfoRequest;", "", "()V", "TAG", "", "requestUserInfo", "", "userId", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "rspCallBack", "Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetUserInfoRequest
{
  public static final GetUserInfoRequest a = new GetUserInfoRequest();
  
  public final void a(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener)
  {
    a(paramLong, paramIResultListener, null);
  }
  
  public final void a(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener, @Nullable IResultListener<NetRspUserData> paramIResultListener1)
  {
    String str = Logger.b(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetUserInfoRequest - ");
    localStringBuilder.append(str);
    Logger.a("GetUserInfoRequest", localStringBuilder.toString());
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetUserInfoDataServlet.a.a(paramLong), UserProxyCmdOuterClass.GetUserInfoRsp.class, (RequestListener)new GetUserInfoRequest.requestUserInfo.1(str, paramIResultListener, paramIResultListener1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.GetUserInfoRequest
 * JD-Core Version:    0.7.0.1
 */