package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class TroopInteractGiftAnimationController$1$1$7
  extends TroopGiftCallback
{
  TroopInteractGiftAnimationController$1$1$7(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("startInteract: errorCode = ");
      paramRspBody.append(paramInt);
      QLog.d("TroopInteractGiftAnimationController", 2, paramRspBody.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.7
 * JD-Core Version:    0.7.0.1
 */