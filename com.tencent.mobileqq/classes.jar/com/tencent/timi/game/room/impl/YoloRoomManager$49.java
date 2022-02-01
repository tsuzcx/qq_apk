package com.tencent.timi.game.room.impl;

import androidx.lifecycle.LiveData;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic;

class YoloRoomManager$49
  implements IRoomAudioService
{
  YoloRoomManager$49(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(boolean paramBoolean)
  {
    YoloRoomManager.a(this.a, new YoloRoomManager.49.2(this, paramBoolean));
  }
  
  public boolean a()
  {
    return this.a.A();
  }
  
  public boolean b()
  {
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.a.B();
    if (localYoloRoomMediaLogic != null) {
      return localYoloRoomMediaLogic.c();
    }
    return false;
  }
  
  public LiveData<Boolean> c()
  {
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.a.B();
    if (localYoloRoomMediaLogic != null) {
      return localYoloRoomMediaLogic.e();
    }
    return null;
  }
  
  public LiveData<Boolean> d()
  {
    YoloRoomMediaLogic localYoloRoomMediaLogic = this.a.B();
    if (localYoloRoomMediaLogic != null) {
      return localYoloRoomMediaLogic.f();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.49
 * JD-Core Version:    0.7.0.1
 */