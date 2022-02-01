package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignReply;
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
    paramObject = (MobileOrderServer.GetIfSignReply)paramObject;
    paramInt = paramObject.RetCode.get();
    if (paramInt == 0) {
      paramObject = this.jdField_a_of_type_ComTencentTreasurecardBeanUserInfoReq.b(paramObject.sign.get()).a("http://120.197.235.102/wabp/wabpGetUseInfo");
    } else {
      paramObject = "";
    }
    INetCallBack localINetCallBack = this.jdField_a_of_type_ComTencentTreasurecardNetINetCallBack;
    if (localINetCallBack != null) {
      localINetCallBack.a(paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1.signRequest.1
 * JD-Core Version:    0.7.0.1
 */