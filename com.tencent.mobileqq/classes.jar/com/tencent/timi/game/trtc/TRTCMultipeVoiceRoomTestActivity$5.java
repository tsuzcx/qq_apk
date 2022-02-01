package com.tencent.timi.game.trtc;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoom;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class TRTCMultipeVoiceRoomTestActivity$5
  implements Observer<ConcurrentHashMap<String, TRTCMultipeVoiceRoom>>
{
  TRTCMultipeVoiceRoomTestActivity$5(TRTCMultipeVoiceRoomTestActivity paramTRTCMultipeVoiceRoomTestActivity) {}
  
  public void a(ConcurrentHashMap<String, TRTCMultipeVoiceRoom> paramConcurrentHashMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("房间\n");
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      TRTCMultipeVoiceRoom localTRTCMultipeVoiceRoom = (TRTCMultipeVoiceRoom)paramConcurrentHashMap.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localTRTCMultipeVoiceRoom.toString());
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    TRTCMultipeVoiceRoomTestActivity.d(this.a).setText(localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.5
 * JD-Core Version:    0.7.0.1
 */