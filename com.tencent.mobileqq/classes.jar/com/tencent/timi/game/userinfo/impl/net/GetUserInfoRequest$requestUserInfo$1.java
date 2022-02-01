package com.tencent.timi.game.userinfo.impl.net;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.NetRspUserData;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserInfoRsp;
import trpc.yes.common.UserProxyCmdOuterClass.MiniInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/net/GetUserInfoRequest$requestUserInfo$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetUserInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetUserInfoRequest$requestUserInfo$1
  implements RequestListener<UserProxyCmdOuterClass.GetUserInfoRsp>
{
  GetUserInfoRequest$requestUserInfo$1(String paramString, IResultListener paramIResultListener1, IResultListener paramIResultListener2) {}
  
  public void a(@Nullable UserProxyCmdOuterClass.GetUserInfoRsp paramGetUserInfoRsp, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "originalMsfRsp");
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("requestUserInfo - success ");
    paramFromServiceMsg.append(this.a);
    Logger.a("GetUserInfoRequest", paramFromServiceMsg.toString());
    Object localObject2 = null;
    if (paramGetUserInfoRsp != null)
    {
      paramFromServiceMsg = paramGetUserInfoRsp.user_info;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = (UserProxyCmdOuterClass.QQUserInfo)paramFromServiceMsg.get();
        break label68;
      }
    }
    paramFromServiceMsg = null;
    label68:
    if (paramGetUserInfoRsp != null)
    {
      localObject1 = paramGetUserInfoRsp.user_info;
      if (localObject1 != null)
      {
        localObject1 = ((UserProxyCmdOuterClass.QQUserInfo)localObject1).mini_info;
        if (localObject1 != null)
        {
          localObject1 = ((UserProxyCmdOuterClass.MiniInfo)localObject1).avatar;
          if (localObject1 != null)
          {
            localObject1 = ((PBStringField)localObject1).get();
            break label109;
          }
        }
      }
    }
    Object localObject1 = null;
    label109:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("requestUserInfo - avatarUrl error ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(' ');
      ((StringBuilder)localObject3).append(this.a);
      Logger.c("GetUserInfoRequest", ((StringBuilder)localObject3).toString());
    }
    localObject1 = (IUserInfo)null;
    if ((paramFromServiceMsg instanceof UserProxyCmdOuterClass.QQUserInfo))
    {
      paramFromServiceMsg = UserInfoUtil.a.a(paramFromServiceMsg);
      UserInfoDbUtil.a.a(paramFromServiceMsg);
      localObject1 = UserInfoDbUtil.a.b(paramFromServiceMsg);
      localObject3 = this.b;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      if (localObject3 != null)
      {
        ((IResultListener)localObject3).a(localObject1);
        paramFromServiceMsg = (FromServiceMsg)localObject1;
      }
    }
    else
    {
      localObject3 = this.b;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      if (localObject3 != null)
      {
        ((IResultListener)localObject3).a(0, "data error");
        paramFromServiceMsg = (FromServiceMsg)localObject1;
      }
    }
    Object localObject3 = this.c;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (paramGetUserInfoRsp != null)
      {
        paramGetUserInfoRsp = paramGetUserInfoRsp.route_list;
        localObject1 = localObject2;
        if (paramGetUserInfoRsp != null) {
          localObject1 = (CommonOuterClass.OnlineRouteInfoList)paramGetUserInfoRsp.get();
        }
      }
      ((IResultListener)localObject3).a(new NetRspUserData(paramFromServiceMsg, (CommonOuterClass.OnlineRouteInfoList)localObject1));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable UserProxyCmdOuterClass.GetUserInfoRsp paramGetUserInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramGetUserInfoRsp = this.b;
    if (paramGetUserInfoRsp != null) {
      paramGetUserInfoRsp.a(paramInt2, paramString1);
    }
    paramGetUserInfoRsp = this.c;
    if (paramGetUserInfoRsp != null) {
      paramGetUserInfoRsp.a(paramInt2, paramString1);
    }
    paramGetUserInfoRsp = new StringBuilder();
    paramGetUserInfoRsp.append("requestUserInfo - onError -");
    paramGetUserInfoRsp.append(paramString1);
    paramGetUserInfoRsp.append('-');
    paramGetUserInfoRsp.append(paramString2);
    paramGetUserInfoRsp.append(' ');
    paramGetUserInfoRsp.append(this.a);
    Logger.c("GetUserInfoRequest", paramGetUserInfoRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.GetUserInfoRequest.requestUserInfo.1
 * JD-Core Version:    0.7.0.1
 */