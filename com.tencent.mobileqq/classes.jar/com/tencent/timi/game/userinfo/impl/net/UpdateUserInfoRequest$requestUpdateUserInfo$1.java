package com.tencent.timi.game.userinfo.impl.net;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UpdateUserInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/net/UpdateUserInfoRequest$requestUpdateUserInfo$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$UpdateUserInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UpdateUserInfoRequest$requestUpdateUserInfo$1
  implements RequestListener<UserProxyCmdOuterClass.UpdateUserInfoRsp>
{
  public void a(@Nullable UserProxyCmdOuterClass.UpdateUserInfoRsp paramUpdateUserInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("UpdateUserInfoRequest", "requestUpdateUserInfo - success ");
    if (paramUpdateUserInfoRsp != null)
    {
      paramUpdateUserInfoRsp = paramUpdateUserInfoRsp.user_info;
      if (paramUpdateUserInfoRsp != null)
      {
        paramUpdateUserInfoRsp = (UserProxyCmdOuterClass.QQUserInfo)paramUpdateUserInfoRsp.get();
        break label33;
      }
    }
    paramUpdateUserInfoRsp = null;
    label33:
    if ((paramUpdateUserInfoRsp instanceof UserProxyCmdOuterClass.QQUserInfo))
    {
      paramUpdateUserInfoRsp = UserInfoUtil.a.a(paramUpdateUserInfoRsp);
      UserInfoDbUtil.a.a(paramUpdateUserInfoRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable UserProxyCmdOuterClass.UpdateUserInfoRsp paramUpdateUserInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramUpdateUserInfoRsp = new StringBuilder();
    paramUpdateUserInfoRsp.append("requestUpdateUserInfo - onError ");
    paramUpdateUserInfoRsp.append(paramBoolean);
    paramUpdateUserInfoRsp.append("-");
    paramUpdateUserInfoRsp.append(paramInt1);
    paramUpdateUserInfoRsp.append(" -- ");
    paramUpdateUserInfoRsp.append(paramInt2);
    paramUpdateUserInfoRsp.append("-");
    paramUpdateUserInfoRsp.append(paramString1);
    paramUpdateUserInfoRsp.append("-");
    paramUpdateUserInfoRsp.append(paramString2);
    Logger.c("UpdateUserInfoRequest", paramUpdateUserInfoRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.UpdateUserInfoRequest.requestUpdateUserInfo.1
 * JD-Core Version:    0.7.0.1
 */