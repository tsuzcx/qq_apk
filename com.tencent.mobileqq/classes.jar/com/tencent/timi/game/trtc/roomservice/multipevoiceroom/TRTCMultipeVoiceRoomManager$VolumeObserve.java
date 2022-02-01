package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.ConcurrentHashMap;

class TRTCMultipeVoiceRoomManager$VolumeObserve
  implements Observer<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>>
{
  TRTCMultipeVoiceRoomManager$VolumeObserve(TRTCMultipeVoiceRoomManager paramTRTCMultipeVoiceRoomManager) {}
  
  public void a(ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> paramConcurrentHashMap)
  {
    if (this.a.b.hasObservers())
    {
      TRTCMultipeVoiceRoomManager.a(this.a).putAll(paramConcurrentHashMap);
      this.a.b.setValue(TRTCMultipeVoiceRoomManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager.VolumeObserve
 * JD-Core Version:    0.7.0.1
 */