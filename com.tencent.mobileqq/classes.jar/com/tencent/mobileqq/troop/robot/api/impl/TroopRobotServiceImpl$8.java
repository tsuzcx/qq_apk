package com.tencent.mobileqq.troop.robot.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.Callback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class TroopRobotServiceImpl$8
  extends ProtoUtils.TroopProtocolObserver
{
  TroopRobotServiceImpl$8(TroopRobotServiceImpl paramTroopRobotServiceImpl, ITroopRobotService.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new cmd0x934.RspBody();
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotServiceImpl", 2, QLog.getStackTraceString(paramArrayOfByte));
        }
      }
    }
    this.a.a(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */