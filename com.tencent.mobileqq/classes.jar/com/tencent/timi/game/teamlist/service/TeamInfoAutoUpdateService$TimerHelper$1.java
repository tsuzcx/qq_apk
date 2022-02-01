package com.tencent.timi.game.teamlist.service;

import com.tencent.timi.game.utils.Logger;
import java.util.TimerTask;

class TeamInfoAutoUpdateService$TimerHelper$1
  extends TimerTask
{
  TeamInfoAutoUpdateService$TimerHelper$1(TeamInfoAutoUpdateService.TimerHelper paramTimerHelper) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAutoUpdate:");
    localStringBuilder.append(TeamInfoAutoUpdateService.TimerHelper.a(this.a));
    Logger.b("TeamInfoAutoUpdateService", localStringBuilder.toString());
    TeamInfoAutoUpdateService.d(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.TimerHelper.1
 * JD-Core Version:    0.7.0.1
 */