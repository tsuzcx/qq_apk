package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;

class TeamActionBtnView$5
  implements View.OnClickListener
{
  TeamActionBtnView$5(TeamActionBtnView paramTeamActionBtnView, boolean paramBoolean, YoloBattleSmobaOuterClass.YoloSmobaOneSchema paramYoloSmobaOneSchema) {}
  
  public void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a()) {
      if (!this.a)
      {
        TeamActionBtnView localTeamActionBtnView = this.c;
        if (!TeamActionBtnView.a(localTeamActionBtnView, localTeamActionBtnView.getContext())) {}
      }
      else
      {
        TeamActionBtnView.a(this.c, this.b);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.5
 * JD-Core Version:    0.7.0.1
 */