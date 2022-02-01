package com.tencent.timi.game.userinfo.impl.net;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.BatchGetGameDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/net/BatchGetGameDefaultRoleRequest$batchGemeDefaultRole$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$BatchGetGameDefaultRoleRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetGameDefaultRoleRequest$batchGemeDefaultRole$1
  implements RequestListener<GameDataServerOuterClass.BatchGetGameDefaultRoleRsp>
{
  BatchGetGameDefaultRoleRequest$batchGemeDefaultRole$1(List paramList, IResultListener paramIResultListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.BatchGetGameDefaultRoleRsp paramBatchGetGameDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("BatchGetGameDefaultRoleRequest", "batchGemeDefaultRole - onSuccess");
    BatchGetGameDefaultRoleRequest.a(BatchGetGameDefaultRoleRequest.a, this.a, paramBatchGetGameDefaultRoleRsp);
    if ((paramBatchGetGameDefaultRoleRsp instanceof GameDataServerOuterClass.BatchGetGameDefaultRoleRsp))
    {
      paramFromServiceMsg = UserInfoDbUtil.a;
      List localList = paramBatchGetGameDefaultRoleRsp.role_list.get();
      Intrinsics.checkExpressionValueIsNotNull(localList, "response.role_list.get()");
      paramFromServiceMsg.b(localList);
      paramFromServiceMsg = this.b;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(paramBatchGetGameDefaultRoleRsp.role_list.get());
      }
    }
    else
    {
      paramBatchGetGameDefaultRoleRsp = this.b;
      if (paramBatchGetGameDefaultRoleRsp != null) {
        paramBatchGetGameDefaultRoleRsp.a((List)new ArrayList());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.BatchGetGameDefaultRoleRsp paramBatchGetGameDefaultRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramBatchGetGameDefaultRoleRsp = new StringBuilder();
    paramBatchGetGameDefaultRoleRsp.append("batchGemeDefaultRole - onError ");
    paramBatchGetGameDefaultRoleRsp.append(paramBoolean);
    paramBatchGetGameDefaultRoleRsp.append("-");
    paramBatchGetGameDefaultRoleRsp.append(paramInt1);
    paramBatchGetGameDefaultRoleRsp.append(" -- ");
    paramBatchGetGameDefaultRoleRsp.append(paramInt2);
    paramBatchGetGameDefaultRoleRsp.append("-");
    paramBatchGetGameDefaultRoleRsp.append(paramString1);
    paramBatchGetGameDefaultRoleRsp.append("-");
    paramBatchGetGameDefaultRoleRsp.append(paramString2);
    Logger.c("BatchGetGameDefaultRoleRequest", paramBatchGetGameDefaultRoleRsp.toString());
    paramString2 = this.b;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.BatchGetGameDefaultRoleRequest.batchGemeDefaultRole.1
 * JD-Core Version:    0.7.0.1
 */