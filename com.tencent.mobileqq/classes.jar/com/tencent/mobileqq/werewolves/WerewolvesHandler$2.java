package com.tencent.mobileqq.werewolves;

import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class WerewolvesHandler$2
  implements WerewolvesHandler.Callback<oidb_0x8ed.RspBody>
{
  WerewolvesHandler$2(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("startAnotherRound, quitFailed: errorCode :");
      paramRspBody.append(paramInt);
      QLog.d("WerewolvesHandler", 2, paramRspBody.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.2
 * JD-Core Version:    0.7.0.1
 */