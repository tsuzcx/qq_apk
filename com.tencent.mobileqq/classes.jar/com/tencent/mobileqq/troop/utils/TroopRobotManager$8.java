package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

class TroopRobotManager$8
  extends ProtoUtils.TroopProtocolObserver
{
  TroopRobotManager$8(TroopRobotManager paramTroopRobotManager, TroopRobotManager.Callback paramCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new cmd0x934.RspBody();
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager$Callback.a(paramInt, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(paramArrayOfByte));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.8
 * JD-Core Version:    0.7.0.1
 */