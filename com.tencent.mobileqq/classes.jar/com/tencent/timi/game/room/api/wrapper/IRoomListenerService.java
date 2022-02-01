package com.tencent.timi.game.room.api.wrapper;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;

public abstract interface IRoomListenerService
{
  public abstract void a(YoloRoomInterface.YoloRoomAudioListener paramYoloRoomAudioListener);
  
  public abstract void a(YoloRoomInterface.YoloRoomCommonListener paramYoloRoomCommonListener);
  
  public abstract void a(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener);
  
  public abstract void a(YoloRoomInterface.YoloRoomMediaEnvCheckCallback paramYoloRoomMediaEnvCheckCallback);
  
  public abstract void b(YoloRoomInterface.YoloRoomAudioListener paramYoloRoomAudioListener);
  
  public abstract void b(YoloRoomInterface.YoloRoomCommonListener paramYoloRoomCommonListener);
  
  public abstract void b(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.wrapper.IRoomListenerService
 * JD-Core Version:    0.7.0.1
 */