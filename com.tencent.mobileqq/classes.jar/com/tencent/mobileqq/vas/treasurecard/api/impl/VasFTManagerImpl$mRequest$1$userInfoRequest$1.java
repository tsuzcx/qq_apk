package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeReply;
import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mRequest$1$userInfoRequest$1
  implements BusinessObserver
{
  VasFTManagerImpl$mRequest$1$userInfoRequest$1(VasFTManagerImpl.mRequest.1 param1, String paramString, INetCallBack paramINetCallBack) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof MobileOrderServer.GetSubscribeReply)) {
      return;
    }
    int i = -1;
    paramObject = (MobileOrderServer.GetSubscribeReply)paramObject;
    int j = paramObject.RetCode.get();
    paramInt = i;
    if (j == 0)
    {
      paramInt = i;
      if (VasFTManagerImpl.a(this.a.a))
      {
        paramInt = paramObject.IsFlowFree.get();
        TreasureUtil.a.a(paramObject.NextReqTime.get());
        localObject = TreasureUtil.a;
        i = paramObject.FlowThreshold.get();
        String str = paramObject.FlowThresholdText.get();
        Intrinsics.checkExpressionValueIsNotNull(str, "data.FlowThresholdText.get()");
        ((TreasureUtil)localObject).a(i, str);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request-userInfo_end code:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" ; cardState:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ;  pcId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" ; NextReqTime:");
    ((StringBuilder)localObject).append(paramObject.NextReqTime.get());
    QLog.d("treasureCard", 2, ((StringBuilder)localObject).toString());
    paramObject = this.c;
    if (paramObject != null) {
      paramObject.a(j, Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1.userInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */