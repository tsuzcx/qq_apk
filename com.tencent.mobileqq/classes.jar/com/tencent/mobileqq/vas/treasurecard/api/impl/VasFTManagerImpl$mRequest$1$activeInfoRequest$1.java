package com.tencent.mobileqq.vas.treasurecard.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class VasFTManagerImpl$mRequest$1$activeInfoRequest$1
  implements BusinessObserver
{
  public static final 1 a = new 1();
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof MobileOrderServer.GetFlowConfReply))
    {
      Object localObject = (MobileOrderServer.GetFlowConfReply)paramObject;
      if (((MobileOrderServer.GetFlowConfReply)localObject).RetCode.get() != 0) {
        return;
      }
      paramObject = TreasureUtil.a;
      String str = ((MobileOrderServer.GetFlowConfReply)localObject).JumpUrl.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "data.JumpUrl.get()");
      localObject = ((MobileOrderServer.GetFlowConfReply)localObject).Tips.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "data.Tips.get()");
      paramObject.a(str, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl.mRequest.1.activeInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */