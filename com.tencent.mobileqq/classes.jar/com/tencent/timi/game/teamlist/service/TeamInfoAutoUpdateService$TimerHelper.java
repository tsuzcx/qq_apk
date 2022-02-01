package com.tencent.timi.game.teamlist.service;

import com.tencent.timi.game.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

class TeamInfoAutoUpdateService$TimerHelper
{
  TimerTask a;
  private int c = 1000;
  private boolean d = false;
  private Timer e;
  
  private TeamInfoAutoUpdateService$TimerHelper(TeamInfoAutoUpdateService paramTeamInfoAutoUpdateService) {}
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAutoRefreshLimit");
    localStringBuilder.append(paramInt);
    Logger.b("TeamInfoAutoUpdateService", localStringBuilder.toString());
    if (paramInt < 1000)
    {
      c();
      return;
    }
    if (paramInt != this.c)
    {
      this.c = paramInt;
      c();
      b();
    }
  }
  
  void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTimer limit:");
    localStringBuilder.append(this.c);
    Logger.b("TeamInfoAutoUpdateService", localStringBuilder.toString());
    c();
    this.e = new Timer();
    this.a = new TeamInfoAutoUpdateService.TimerHelper.1(this);
    this.e.schedule(this.a, 0L, this.c);
    this.d = true;
  }
  
  void c()
  {
    try
    {
      if ((this.e == null) && (this.a == null)) {
        return;
      }
      this.a.cancel();
      this.e.cancel();
      this.a = null;
      this.e = null;
      this.d = false;
      TeamInfoAutoUpdateService.a(this.b, false);
      return;
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    Logger.c("TeamInfoAutoUpdateService", "AutoUpdateCancelErr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.TimerHelper
 * JD-Core Version:    0.7.0.1
 */