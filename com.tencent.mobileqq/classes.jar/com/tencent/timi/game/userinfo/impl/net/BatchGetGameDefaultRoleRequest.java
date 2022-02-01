package com.tencent.timi.game.userinfo.impl.net;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader.Companion;
import com.tencent.timi.game.userinfo.impl.net.servlet.BatchGetGameDefaultRoleServlet;
import com.tencent.timi.game.userinfo.impl.net.servlet.BatchGetGameDefaultRoleServlet.Companion;
import com.tencent.timi.game.userinfo.impl.util.UserInfoNetUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.BatchGetGameDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.GameDataServerOuterClass.UserDefaultRole;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/net/BatchGetGameDefaultRoleRequest;", "", "()V", "TAG", "", "addToNoRoleInfoUserSet", "", "userIdList", "", "", "response", "Ltrpc/yes/common/GameDataServerOuterClass$BatchGetGameDefaultRoleRsp;", "batchGemeDefaultRole", "userIdListParam", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetGameDefaultRoleRequest
{
  public static final BatchGetGameDefaultRoleRequest a = new BatchGetGameDefaultRoleRequest();
  
  private final void a(List<Long> paramList, GameDataServerOuterClass.BatchGetGameDefaultRoleRsp paramBatchGetGameDefaultRoleRsp)
  {
    if (paramBatchGetGameDefaultRoleRsp == null)
    {
      paramBatchGetGameDefaultRoleRsp = new StringBuilder();
      paramBatchGetGameDefaultRoleRsp.append("batchGemeDefaultRole - addToNoRoleInfoUserSet ");
      paramBatchGetGameDefaultRoleRsp.append(paramList.size());
      Logger.a("BatchGetGameDefaultRoleRequest", paramBatchGetGameDefaultRoleRsp.toString());
      UserRoleInfoAutoLoader.a.a().b().addAll((Collection)paramList);
      return;
    }
    List localList = (List)new ArrayList();
    localList.addAll((Collection)paramList);
    paramList = (List)new ArrayList();
    paramBatchGetGameDefaultRoleRsp = paramBatchGetGameDefaultRoleRsp.role_list.get();
    Intrinsics.checkExpressionValueIsNotNull(paramBatchGetGameDefaultRoleRsp, "response.role_list.get()");
    paramBatchGetGameDefaultRoleRsp = ((Iterable)paramBatchGetGameDefaultRoleRsp).iterator();
    while (paramBatchGetGameDefaultRoleRsp.hasNext())
    {
      GameDataServerOuterClass.UserDefaultRole localUserDefaultRole = (GameDataServerOuterClass.UserDefaultRole)paramBatchGetGameDefaultRoleRsp.next();
      if (!TextUtils.isEmpty((CharSequence)localUserDefaultRole.role_info.role_name.get())) {
        paramList.add(Long.valueOf(localUserDefaultRole.uid.get()));
      }
    }
    localList.removeAll((Collection)paramList);
    paramList = new StringBuilder();
    paramList.append("batchGemeDefaultRole - addToNoRoleInfoUserSet ");
    paramList.append(localList.size());
    Logger.a("BatchGetGameDefaultRoleRequest", paramList.toString());
    UserRoleInfoAutoLoader.a.a().b().addAll((Collection)localList);
  }
  
  public final void a(@NotNull List<Long> paramList, @Nullable IResultListener<List<GameDataServerOuterClass.UserDefaultRole>> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "userIdListParam");
    paramList = UserInfoNetUtil.a.a(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchGemeDefaultRole - start ");
    localStringBuilder.append(paramList.size());
    Logger.a("BatchGetGameDefaultRoleRequest", localStringBuilder.toString());
    ((NetApi)ServiceCenter.a(NetApi.class)).a(BatchGetGameDefaultRoleServlet.a.a(paramList, 101), GameDataServerOuterClass.BatchGetGameDefaultRoleRsp.class, (RequestListener)new BatchGetGameDefaultRoleRequest.batchGemeDefaultRole.1(paramList, paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.net.BatchGetGameDefaultRoleRequest
 * JD-Core Version:    0.7.0.1
 */