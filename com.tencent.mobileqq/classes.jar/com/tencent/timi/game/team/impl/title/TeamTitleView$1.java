package com.tencent.timi.game.team.impl.title;

import android.view.View.OnClickListener;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.team.impl.setting.TeamClosePopupView.OnActionClickListener;

class TeamTitleView$1
  implements TeamClosePopupView.OnActionClickListener
{
  TeamTitleView$1(TeamTitleView paramTeamTitleView) {}
  
  public void a()
  {
    if (TeamTitleView.a(this.a) != null) {
      TeamTitleView.a(this.a).onClick(this.a);
    }
  }
  
  public void b()
  {
    TeamUtil.a(TimiGameActivityManager.a(), TeamTitleView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.title.TeamTitleView.1
 * JD-Core Version:    0.7.0.1
 */