package com.tencent.timi.game.teamlist.presenter;

import com.tencent.timi.game.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;

class TeamListPresenter$TimerHelper
{
  TimerTask a;
  private int b = 5000;
  private boolean c = false;
  private WeakReference<TeamListPresenter> d;
  private Timer e;
  
  public TeamListPresenter$TimerHelper(TeamListPresenter paramTeamListPresenter)
  {
    this.d = new WeakReference(paramTeamListPresenter);
  }
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTimer limit:");
    localStringBuilder.append(this.b);
    Logger.a("TeamListPresenter", localStringBuilder.toString());
    b();
    this.e = new Timer();
    this.a = new TeamListPresenter.TimerHelper.1(this);
    this.e.schedule(this.a, 0L, this.b);
    this.c = true;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.b))
    {
      this.b = paramInt;
      b();
      a();
    }
  }
  
  void b()
  {
    try
    {
      if ((this.a == null) && (this.e == null)) {
        return;
      }
      this.a.cancel();
      this.e.cancel();
      this.a = null;
      this.e = null;
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    Logger.c("TeamListPresenter", "AutoUpdateCancelErr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListPresenter.TimerHelper
 * JD-Core Version:    0.7.0.1
 */