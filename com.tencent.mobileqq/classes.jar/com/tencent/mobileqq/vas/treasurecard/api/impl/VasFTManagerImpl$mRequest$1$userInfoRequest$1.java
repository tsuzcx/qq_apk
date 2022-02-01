package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeReply;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mRequest$1$userInfoRequest$1
  implements BusinessObserver
{
  VasFTManagerImpl$mRequest$1$userInfoRequest$1(INetCallBack paramINetCallBack) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof MobileOrderServer.GetSubscribeReply)) {
      return;
    }
    paramInt = -1;
    paramObject = (MobileOrderServer.GetSubscribeReply)paramObject;
    int j = paramObject.RetCode.get();
    int i = paramInt;
    if (j == 0)
    {
      if (paramObject.IsFlowFree.has()) {
        paramInt = paramObject.IsFlowFree.get();
      }
      TreasureUtil.a.a(paramObject.NextReqTime.get());
      i = paramInt;
    }
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.a(j, Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1.userInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */