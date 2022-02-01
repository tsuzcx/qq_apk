package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.router.ServiceCenter;

class TeamSpeakerView$1
  implements View.OnClickListener
{
  TeamSpeakerView$1(TeamSpeakerView paramTeamSpeakerView) {}
  
  public void onClick(View paramView)
  {
    TeamSpeakerView localTeamSpeakerView = this.a;
    TeamSpeakerView.a(localTeamSpeakerView, TeamSpeakerView.a(localTeamSpeakerView));
    boolean bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(TeamSpeakerView.a(this.a)).b();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).d(TeamSpeakerView.a(this.a)).a(bool ^ true);
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamSpeakerView.1
 * JD-Core Version:    0.7.0.1
 */