package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfRequest;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignRequest;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeRequest;
import com.tencent.treasurecard.bean.UserInfoReq;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl$mRequest$1", "Lcom/tencent/treasurecard/net/INetRequest;", "activeInfoRequest", "", "limitReq", "", "pcIdRequest", "url", "", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "signRequest", "userInfoRequest", "pcId", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasFTManagerImpl$mRequest$1
  implements INetRequest
{
  public void a()
  {
    MobileOrderServer.GetFlowConfRequest localGetFlowConfRequest = VasFTManagerImpl.a(this.a);
    ((IPbProtocol)QRoute.api(IPbProtocol.class)).request("trpc.qqva.mobile_order_server.orderManage.GetIfSign", (MessageMicro)localGetFlowConfRequest, MobileOrderServer.GetFlowConfReply.class, (BusinessObserver)VasFTManagerImpl.mRequest.1.activeInfoRequest.1.a);
  }
  
  public void a(@Nullable INetCallBack paramINetCallBack)
  {
    UserInfoReq localUserInfoReq = VasFTManagerImpl.a(this.a);
    MobileOrderServer.GetIfSignRequest localGetIfSignRequest = new MobileOrderServer.GetIfSignRequest();
    localGetIfSignRequest.appid.set(10001);
    localGetIfSignRequest.signContent.set(localUserInfoReq.a());
    ((IPbProtocol)QRoute.api(IPbProtocol.class)).request("trpc.qqva.mobile_order_server.orderManage.GetIfSign", (MessageMicro)localGetIfSignRequest, MobileOrderServer.GetIfSignReply.class, (BusinessObserver)new VasFTManagerImpl.mRequest.1.signRequest.1(localUserInfoReq, paramINetCallBack));
  }
  
  public void a(@NotNull String paramString, @Nullable INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    ThreadManagerV2.getSubThread();
    paramString = VasFTManagerImpl.a(this.a, paramString);
    int i;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      i = -1;
    } else {
      i = 0;
    }
    if (paramINetCallBack != null) {
      paramINetCallBack.a(i, paramString);
    }
  }
  
  public boolean a()
  {
    if (TreasureUtil.a.a() == -1) {
      return false;
    }
    return TreasureUtil.a.a() ^ true;
  }
  
  public void b(@NotNull String paramString, @Nullable INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pcId");
    MobileOrderServer.GetSubscribeRequest localGetSubscribeRequest = new MobileOrderServer.GetSubscribeRequest();
    localGetSubscribeRequest.appid.set(10001);
    localGetSubscribeRequest.UserCode.set(paramString);
    ((IPbProtocol)QRoute.api(IPbProtocol.class)).request("trpc.qqva.mobile_order_server.orderManage.GetIfSign", (MessageMicro)localGetSubscribeRequest, MobileOrderServer.GetSubscribeReply.class, (BusinessObserver)new VasFTManagerImpl.mRequest.1.userInfoRequest.1(paramINetCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1
 * JD-Core Version:    0.7.0.1
 */