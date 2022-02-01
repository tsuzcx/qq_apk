package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignReply;
import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.bean.UserInfoReq;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mRequest$1$signRequest$1
  implements BusinessObserver
{
  VasFTManagerImpl$mRequest$1$signRequest$1(UserInfoReq paramUserInfoReq, INetCallBack paramINetCallBack) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof MobileOrderServer.GetIfSignReply)) {
      return;
    }
    Object localObject = (MobileOrderServer.GetIfSignReply)paramObject;
    paramInt = ((MobileOrderServer.GetIfSignReply)localObject).RetCode.get();
    if (paramInt == 0) {
      paramObject = this.a.a(((MobileOrderServer.GetIfSignReply)localObject).sign.get()).b("http://wap.cmpassport.com/openapi/wabpGetUseInfo");
    } else {
      paramObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request-sign_end ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ; ");
    localStringBuilder.append(((MobileOrderServer.GetIfSignReply)localObject).sign.get());
    localStringBuilder.append(" ; ");
    localStringBuilder.append(this.a.a());
    QLog.d("treasureCard", 2, localStringBuilder.toString());
    localObject = this.b;
    if (localObject != null) {
      ((INetCallBack)localObject).a(paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1.signRequest.1
 * JD-Core Version:    0.7.0.1
 */