package com.tencent.timi.game.teamlist.presenter;

import com.tencent.timi.game.utils.Logger;
import java.util.TimerTask;
import mqq.util.WeakReference;

class TeamListPresenter$TimerHelper$1
  extends TimerTask
{
  TeamListPresenter$TimerHelper$1(TeamListPresenter.TimerHelper paramTimerHelper) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAutoUpdate limit:");
    ((StringBuilder)localObject).append(TeamListPresenter.TimerHelper.a(this.this$0));
    Logger.a("TeamListPresenter", ((StringBuilder)localObject).toString());
    if (TeamListPresenter.TimerHelper.b(this.this$0) == null) {
      return;
    }
    localObject = (TeamListPresenter)TeamListPresenter.TimerHelper.b(this.this$0).get();
    if (localObject != null) {
      ((TeamListPresenter)localObject).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListPresenter.TimerHelper.1
 * JD-Core Version:    0.7.0.1
 */