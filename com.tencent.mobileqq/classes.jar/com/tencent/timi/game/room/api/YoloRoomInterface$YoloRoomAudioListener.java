package com.tencent.timi.game.room.api;

import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface YoloRoomInterface$YoloRoomAudioListener
{
  public abstract void a(RoomState paramRoomState);
  
  public abstract void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap);
  
  public abstract void b(RoomState paramRoomState);
  
  public abstract void b(ConcurrentHashMap<String, Integer> paramConcurrentHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener
 * JD-Core Version:    0.7.0.1
 */