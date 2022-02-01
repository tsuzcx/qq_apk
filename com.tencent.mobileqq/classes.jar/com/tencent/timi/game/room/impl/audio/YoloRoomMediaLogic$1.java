package com.tencent.timi.game.room.impl.audio;

import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCCustomCmdHandlerListener;
import com.tencent.timi.game.utils.Logger;

class YoloRoomMediaLogic$1
  implements TRTCCustomCmdHandlerListener
{
  YoloRoomMediaLogic$1(YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString.equals(YoloRoomMediaLogic.a(this.a)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfMicAutoChanged ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" - ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" - changeVoiceSwitch");
      Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
      paramString = ((IRoomService)ServiceCenter.a(IRoomService.class)).b(YoloRoomMediaLogic.b(this.a));
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      paramString.a(0L, i, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.1
 * JD-Core Version:    0.7.0.1
 */