package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class YoloRoomManager$3
  implements IResultListener<YoloRoomMediaLogic>
{
  YoloRoomManager$3(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.v())
    {
      long l = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
      paramString = this.a.b(l);
      if ((paramString != null) && (paramString.voice_switch.get() == 1))
      {
        Logger.c("YoloRoomManager", "init checkMediaTrtcEnv onError, close self mic!");
        this.a.a(l, 2, new YoloRoomManager.3.1(this));
      }
    }
  }
  
  public void a(YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.3
 * JD-Core Version:    0.7.0.1
 */