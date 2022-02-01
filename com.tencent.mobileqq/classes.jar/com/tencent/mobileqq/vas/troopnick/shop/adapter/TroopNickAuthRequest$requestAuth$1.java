package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.UniBusinessCheckItem;
import QC.UniCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class TroopNickAuthRequest$requestAuth$1
  implements BusinessObserver
{
  TroopNickAuthRequest$requestAuth$1(AuthRequest.AuthListener paramAuthListener) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.a != null)
    {
      boolean bool = paramObject instanceof UniCheckRsp;
      paramBoolean = false;
      if (bool)
      {
        paramObject = (UniCheckRsp)paramObject;
        Object localObject = (Collection)paramObject.uniBusinessItemList;
        if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        if (paramInt == 0)
        {
          localObject = this.a;
          if (((UniBusinessCheckItem)paramObject.uniBusinessItemList.get(0)).ret == 0) {
            paramBoolean = true;
          }
          ((AuthRequest.AuthListener)localObject).a(paramBoolean, paramObject);
          return;
        }
      }
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest.requestAuth.1
 * JD-Core Version:    0.7.0.1
 */