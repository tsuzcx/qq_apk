package com.tencent.timi.game.userinfo.impl.net;

import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.net.servlet.BatchGetUserInfoDataServlet;
import com.tencent.timi.game.userinfo.impl.net.servlet.BatchGetUserInfoDataServlet.Companion;
import com.tencent.timi.game.userinfo.impl.util.UserInfoNetUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.BatchGetUserInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/net/BatchGetUserInfoRequest;", "", "()V", "TAG", "", "batchUserInfo", "", "userIdListParam", "", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetUserInfoRequest
{
  public static final BatchGetUserInfoRequest a = new BatchGetUserInfoRequest();
  
  public final void a(@NotNull List<Long> paramList, @Nullable IResultListener<List<IUserInfo>> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "userIdListParam");
    paramList = UserInfoNetUtil.a.a(paramList);
    Logger.a("BatchGetUserInfoRequest", "batchUserInfo ");
    ((NetApi)ServiceCenter.a(NetApi.class)).a(BatchGetUserInfoDataServlet.a.a(paramList), UserProxyCmdOuterClass.BatchGetUserInfoRsp.class, (RequestListener)new BatchGetUserInfoRequest.batchUserInfo.1(paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.BatchGetUserInfoRequest
 * JD-Core Version:    0.7.0.1
 */