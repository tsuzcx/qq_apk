package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness.Config;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class TroopNickAdapter$1
  implements EIPCResultCallback
{
  TroopNickAdapter$1(TroopNickAdapter paramTroopNickAdapter) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getBoolean("status")))
    {
      TroopNickAdapter.a(this.a, paramEIPCResult.data.getString("filepath"));
      paramEIPCResult = TroopNickNameBusiness.a(TroopNickAdapter.a(this.a));
      if (paramEIPCResult != null)
      {
        this.a.a = paramEIPCResult.fontId;
        this.a.b = paramEIPCResult.fontType;
        this.a.a(TroopNickAdapter.a(this.a), paramEIPCResult.delay, paramEIPCResult.repeatCount);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.1
 * JD-Core Version:    0.7.0.1
 */