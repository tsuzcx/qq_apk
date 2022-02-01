package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.UniCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;

class AuthRequest$1
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AuthRequest.AuthListener localAuthListener;
    if (this.a != null)
    {
      if (!(paramObject instanceof UniCheckRsp)) {
        break label50;
      }
      localAuthListener = this.a;
      if (((UniCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAuthListener.a(paramBoolean, (UniCheckRsp)paramObject);
      return;
    }
    label50:
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.AuthRequest.1
 * JD-Core Version:    0.7.0.1
 */