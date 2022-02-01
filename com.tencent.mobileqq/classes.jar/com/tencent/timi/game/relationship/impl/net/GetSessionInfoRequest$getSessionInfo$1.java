package com.tencent.timi.game.relationship.impl.net;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.GetSessionInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/relationship/impl/net/GetSessionInfoRequest$getSessionInfo$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetSessionInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetSessionInfoRequest$getSessionInfo$1
  implements RequestListener<UserProxyCmdOuterClass.GetSessionInfoRsp>
{
  GetSessionInfoRequest$getSessionInfo$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable UserProxyCmdOuterClass.GetSessionInfoRsp paramGetSessionInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("GetSessionInfoRequest", "getSessionInfo - success ");
    if ((paramGetSessionInfoRsp instanceof UserProxyCmdOuterClass.GetSessionInfoRsp))
    {
      paramGetSessionInfoRsp = paramGetSessionInfoRsp.bytes_sig.get().toByteArray();
      this.a.a(paramGetSessionInfoRsp);
      return;
    }
    this.a.a(0, "data error");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable UserProxyCmdOuterClass.GetSessionInfoRsp paramGetSessionInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramGetSessionInfoRsp = new StringBuilder();
    paramGetSessionInfoRsp.append("getSessionInfo - onError ");
    paramGetSessionInfoRsp.append(paramBoolean);
    paramGetSessionInfoRsp.append("-");
    paramGetSessionInfoRsp.append(paramInt1);
    paramGetSessionInfoRsp.append(" -- ");
    paramGetSessionInfoRsp.append(paramInt2);
    paramGetSessionInfoRsp.append("-");
    paramGetSessionInfoRsp.append(paramString1);
    paramGetSessionInfoRsp.append("-");
    paramGetSessionInfoRsp.append(paramString2);
    Logger.c("GetSessionInfoRequest", paramGetSessionInfoRsp.toString());
    this.a.a(paramInt2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.net.GetSessionInfoRequest.getSessionInfo.1
 * JD-Core Version:    0.7.0.1
 */