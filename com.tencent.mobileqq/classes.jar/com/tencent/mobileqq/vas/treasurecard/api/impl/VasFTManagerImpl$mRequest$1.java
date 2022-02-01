package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfRequest;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignRequest;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeReply;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.bean.UserInfoReq;
import com.tencent.treasurecard.bean.UserInfoRsp;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/treasurecard/api/impl/VasFTManagerImpl$mRequest$1", "Lcom/tencent/treasurecard/net/INetRequest;", "activeInfoRequest", "", "isMobileOptr", "", "limitReq", "pcIdRequest", "url", "", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "signRequest", "userInfoRequest", "pcId", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasFTManagerImpl$mRequest$1
  implements INetRequest
{
  public void a(@Nullable INetCallBack paramINetCallBack)
  {
    UserInfoReq localUserInfoReq = VasFTManagerImpl.b(this.a);
    MobileOrderServer.GetIfSignRequest localGetIfSignRequest = new MobileOrderServer.GetIfSignRequest();
    localGetIfSignRequest.appid.set(10001);
    localGetIfSignRequest.signContent.set(localUserInfoReq.a());
    VasUtil.a().getPbRequest().request("trpc.qqva.mobile_order_server.orderManage.GetIfSign", (MessageMicro)localGetIfSignRequest, MobileOrderServer.GetIfSignReply.class, (BusinessObserver)new VasFTManagerImpl.mRequest.1.signRequest.1(localUserInfoReq, paramINetCallBack));
  }
  
  public void a(@NotNull String paramString, @Nullable INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    ThreadManagerV2.getSubThread();
    paramString = VasFTManagerImpl.a(this.a, paramString);
    UserInfoRsp localUserInfoRsp = new UserInfoRsp().a(paramString);
    try
    {
      localObject = localUserInfoRsp.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "userInfo.resultcode");
      i = Integer.parseInt((String)localObject);
    }
    catch (Exception localException)
    {
      Object localObject;
      int i;
      label55:
      break label55;
    }
    i = 1003;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request-pcId_end ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" ; ");
    ((StringBuilder)localObject).append(localUserInfoRsp.h);
    ((StringBuilder)localObject).append(" ; ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("treasureCard", 2, ((StringBuilder)localObject).toString());
    ThreadManagerV2.getUIHandlerV2();
    if (paramINetCallBack != null) {
      paramINetCallBack.a(i, localUserInfoRsp.h);
    }
  }
  
  public boolean a()
  {
    if (TreasureCardProcessor.e().d != 1) {
      return true;
    }
    return TreasureUtil.a.c(TreasureCardProcessor.e().c) ^ true;
  }
  
  public void b(@NotNull String paramString, @Nullable INetCallBack paramINetCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pcId");
    MobileOrderServer.GetSubscribeRequest localGetSubscribeRequest = new MobileOrderServer.GetSubscribeRequest();
    localGetSubscribeRequest.appid.set(10001);
    localGetSubscribeRequest.UserCode.set(paramString);
    VasUtil.a().getPbRequest().request("trpc.qqva.mobile_order_server.orderManage.GetMobileSubscribe", (MessageMicro)localGetSubscribeRequest, MobileOrderServer.GetSubscribeReply.class, (BusinessObserver)new VasFTManagerImpl.mRequest.1.userInfoRequest.1(this, paramString, paramINetCallBack));
  }
  
  public boolean b()
  {
    return VasFTManagerImpl.a(this.a);
  }
  
  public void c()
  {
    int i = this.a.obtainCardState("");
    MobileOrderServer.GetFlowConfRequest localGetFlowConfRequest = VasFTManagerImpl.a(this.a, i);
    if (VasFTManagerImpl.b(this.a, i)) {
      return;
    }
    VasUtil.a().getPbRequest().request("trpc.qqva.mobile_order_server.orderManage.GetFlowConf", (MessageMicro)localGetFlowConfRequest, MobileOrderServer.GetFlowConfReply.class, (BusinessObserver)VasFTManagerImpl.mRequest.1.activeInfoRequest.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1
 * JD-Core Version:    0.7.0.1
 */