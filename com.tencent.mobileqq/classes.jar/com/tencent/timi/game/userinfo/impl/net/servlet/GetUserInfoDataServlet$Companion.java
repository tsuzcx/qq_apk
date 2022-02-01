package com.tencent.timi.game.userinfo.impl.net.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserInfoReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/net/servlet/GetUserInfoDataServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "userId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetUserInfoDataServlet$Companion
{
  @Nullable
  public final NewIntent a(long paramLong)
  {
    UserProxyCmdOuterClass.GetUserInfoReq localGetUserInfoReq = new UserProxyCmdOuterClass.GetUserInfoReq();
    localGetUserInfoReq.uid.set(paramLong);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localGetUserInfoReq, GetUserInfoDataServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.servlet.GetUserInfoDataServlet.Companion
 * JD-Core Version:    0.7.0.1
 */