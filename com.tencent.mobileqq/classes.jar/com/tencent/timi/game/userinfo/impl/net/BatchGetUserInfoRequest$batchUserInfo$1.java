package com.tencent.timi.game.userinfo.impl.net;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.BatchGetUserInfoRsp;
import trpc.yes.common.UserProxyCmdOuterClass.MiniInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass.RetQQUserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/net/BatchGetUserInfoRequest$batchUserInfo$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$BatchGetUserInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetUserInfoRequest$batchUserInfo$1
  implements RequestListener<UserProxyCmdOuterClass.BatchGetUserInfoRsp>
{
  BatchGetUserInfoRequest$batchUserInfo$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable UserProxyCmdOuterClass.BatchGetUserInfoRsp paramBatchGetUserInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("BatchGetUserInfoRequest", "batchUserInfo - success ");
    if ((paramBatchGetUserInfoRsp instanceof UserProxyCmdOuterClass.BatchGetUserInfoRsp))
    {
      List localList = (List)new ArrayList();
      paramFromServiceMsg = (List)new ArrayList();
      paramBatchGetUserInfoRsp = paramBatchGetUserInfoRsp.ret_user_info_list;
      if (paramBatchGetUserInfoRsp != null)
      {
        paramBatchGetUserInfoRsp = paramBatchGetUserInfoRsp.get();
        if (paramBatchGetUserInfoRsp != null)
        {
          paramBatchGetUserInfoRsp = ((Iterable)paramBatchGetUserInfoRsp).iterator();
          while (paramBatchGetUserInfoRsp.hasNext())
          {
            Object localObject1 = (UserProxyCmdOuterClass.RetQQUserInfo)paramBatchGetUserInfoRsp.next();
            Object localObject2;
            if (TextUtils.isEmpty((CharSequence)((UserProxyCmdOuterClass.RetQQUserInfo)localObject1).user_info.mini_info.avatar.get()))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("batchUserInfo - error ");
              ((StringBuilder)localObject2).append(Logger.b(((UserProxyCmdOuterClass.RetQQUserInfo)localObject1).user_info.uid.get()));
              Logger.c("BatchGetUserInfoRequest", ((StringBuilder)localObject2).toString());
            }
            if (((UserProxyCmdOuterClass.RetQQUserInfo)localObject1).user_info != null)
            {
              localObject2 = UserInfoUtil.a;
              localObject1 = ((UserProxyCmdOuterClass.RetQQUserInfo)localObject1).user_info;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.user_info");
              localObject1 = ((UserInfoUtil)localObject2).a((UserProxyCmdOuterClass.QQUserInfo)localObject1);
              if (((UserInfoEntity)localObject1).uid != 0L)
              {
                localList.add(localObject1);
                paramFromServiceMsg.add(UserInfoDbUtil.a.b((UserInfoEntity)localObject1));
              }
            }
          }
        }
      }
      UserInfoDbUtil.a.a(localList);
      paramBatchGetUserInfoRsp = this.a;
      if (paramBatchGetUserInfoRsp != null) {
        paramBatchGetUserInfoRsp.a(paramFromServiceMsg);
      }
    }
    else
    {
      paramBatchGetUserInfoRsp = this.a;
      if (paramBatchGetUserInfoRsp != null) {
        paramBatchGetUserInfoRsp.a((List)new ArrayList());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable UserProxyCmdOuterClass.BatchGetUserInfoRsp paramBatchGetUserInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramBatchGetUserInfoRsp = new StringBuilder();
    paramBatchGetUserInfoRsp.append("batchUserInfo - onError ");
    paramBatchGetUserInfoRsp.append(paramBoolean);
    paramBatchGetUserInfoRsp.append("-");
    paramBatchGetUserInfoRsp.append(paramInt1);
    paramBatchGetUserInfoRsp.append(" -- ");
    paramBatchGetUserInfoRsp.append(paramInt2);
    paramBatchGetUserInfoRsp.append("-");
    paramBatchGetUserInfoRsp.append(paramString1);
    paramBatchGetUserInfoRsp.append("-");
    paramBatchGetUserInfoRsp.append(paramString2);
    Logger.c("BatchGetUserInfoRequest", paramBatchGetUserInfoRsp.toString());
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.BatchGetUserInfoRequest.batchUserInfo.1
 * JD-Core Version:    0.7.0.1
 */