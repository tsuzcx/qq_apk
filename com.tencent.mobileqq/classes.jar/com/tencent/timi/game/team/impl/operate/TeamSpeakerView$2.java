package com.tencent.timi.game.team.impl.operate;

import androidx.lifecycle.Observer;
import com.tencent.timi.game.utils.Logger;

class TeamSpeakerView$2
  implements Observer<Boolean>
{
  TeamSpeakerView$2(TeamSpeakerView paramTeamSpeakerView) {}
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("speakerLdObserver, onChanged - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("GangupSpeakerView", localStringBuilder.toString());
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamSpeakerView.2
 * JD-Core Version:    0.7.0.1
 */