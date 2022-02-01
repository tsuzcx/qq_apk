package com.tencent.timi.game.team.impl.operate;

import androidx.lifecycle.LiveData;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.router.ServiceCenter;

class TeamSpeakerView$3
  implements YoloRoomInterface.YoloRoomMediaEnvCheckCallback
{
  TeamSpeakerView$3(TeamSpeakerView paramTeamSpeakerView) {}
  
  public void a(boolean paramBoolean)
  {
    LiveData localLiveData = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(TeamSpeakerView.a(this.a)).d();
    if (localLiveData != null)
    {
      localLiveData.removeObserver(TeamSpeakerView.b(this.a));
      localLiveData.observeForever(TeamSpeakerView.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamSpeakerView.3
 * JD-Core Version:    0.7.0.1
 */