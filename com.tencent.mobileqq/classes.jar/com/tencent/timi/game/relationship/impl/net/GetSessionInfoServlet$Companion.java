package com.tencent.timi.game.relationship.impl.net;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.GetSessionInfoReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/impl/net/GetSessionInfoServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "fromUin", "", "toUin", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetSessionInfoServlet$Companion
{
  @Nullable
  public final NewIntent a(long paramLong1, long paramLong2)
  {
    UserProxyCmdOuterClass.GetSessionInfoReq localGetSessionInfoReq = new UserProxyCmdOuterClass.GetSessionInfoReq();
    localGetSessionInfoReq.from_uin.set(paramLong1);
    localGetSessionInfoReq.to_uin.set(paramLong2);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localGetSessionInfoReq, GetSessionInfoServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.net.GetSessionInfoServlet.Companion
 * JD-Core Version:    0.7.0.1
 */