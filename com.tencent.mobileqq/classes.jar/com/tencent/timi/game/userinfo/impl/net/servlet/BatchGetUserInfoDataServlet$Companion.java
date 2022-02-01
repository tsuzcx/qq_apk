package com.tencent.timi.game.userinfo.impl.net.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.BatchGetUserInfoReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/net/servlet/BatchGetUserInfoDataServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "userIdList", "", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetUserInfoDataServlet$Companion
{
  @Nullable
  public final NewIntent a(@NotNull List<Long> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "userIdList");
    UserProxyCmdOuterClass.BatchGetUserInfoReq localBatchGetUserInfoReq = new UserProxyCmdOuterClass.BatchGetUserInfoReq();
    localBatchGetUserInfoReq.uid_list.set(paramList);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localBatchGetUserInfoReq, BatchGetUserInfoDataServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.servlet.BatchGetUserInfoDataServlet.Companion
 * JD-Core Version:    0.7.0.1
 */