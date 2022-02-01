package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class RobotProcessor$1
  extends TroopRobotObserver
{
  RobotProcessor$1(RobotProcessor paramRobotProcessor) {}
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      ThreadManager.getFileThreadHandler().post(new RobotProcessor.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.RobotProcessor.1
 * JD-Core Version:    0.7.0.1
 */