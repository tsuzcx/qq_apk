package com.tencent.mobileqq.troop.robot.api.impl;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.qphone.base.util.QLog;

class TroopRobotServiceImpl$1
  implements Runnable
{
  TroopRobotServiceImpl$1(TroopRobotServiceImpl paramTroopRobotServiceImpl) {}
  
  public void run()
  {
    oidb_0x496.Robot localRobot = new oidb_0x496.Robot();
    byte[] arrayOfByte = this.this$0.readRobotConfig();
    if (arrayOfByte != null) {}
    try
    {
      localRobot.mergeFrom(arrayOfByte);
      this.this$0.setRobotConfig(localRobot);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label37:
      break label37;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotServiceImpl", 2, "file data error");
    }
    TroopRobotServiceImpl.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */