package com.tencent.timi.game.team.impl;

import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.team.impl.team.TeamContainerView;
import com.tencent.timi.game.team.impl.team.TeamContainerView.OnDragChangeListener;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;

class TeamActivity$4
  implements TeamContainerView.OnDragChangeListener
{
  TeamActivity$4(TeamActivity paramTeamActivity) {}
  
  public void a()
  {
    this.a.finish();
    Logger.a("TeamActivity", "drag event : onCollect");
  }
  
  public void a(float paramFloat)
  {
    TeamActivity.a(TeamActivity.f(this.a), 1.0F - paramFloat);
  }
  
  public boolean b()
  {
    if (!FloatingPermission.a(this.a))
    {
      TeamUtil.b(TimiGameActivityManager.a(), TeamActivity.e(this.a).getRoomId());
      TeamActivity.e(this.a).a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.4
 * JD-Core Version:    0.7.0.1
 */