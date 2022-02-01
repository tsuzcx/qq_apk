package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;

class TroopRobotManager$2
  extends FriendObserver
{
  TroopRobotManager$2(TroopRobotManager paramTroopRobotManager) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!((ITroopRobotService)this.a.g.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString)) {
      return;
    }
    if (paramBoolean1) {
      TroopRobotManager.a(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.2
 * JD-Core Version:    0.7.0.1
 */