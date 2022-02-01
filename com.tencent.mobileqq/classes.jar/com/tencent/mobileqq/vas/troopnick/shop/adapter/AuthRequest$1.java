package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.UniCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class AuthRequest$1
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AuthRequest.AuthListener localAuthListener = this.a;
    if (localAuthListener != null)
    {
      boolean bool = paramObject instanceof UniCheckRsp;
      paramBoolean = false;
      if (bool)
      {
        paramObject = (UniCheckRsp)paramObject;
        if (paramObject.ret == 0) {
          paramBoolean = true;
        }
        localAuthListener.a(paramBoolean, paramObject);
        return;
      }
      localAuthListener.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.AuthRequest.1
 * JD-Core Version:    0.7.0.1
 */