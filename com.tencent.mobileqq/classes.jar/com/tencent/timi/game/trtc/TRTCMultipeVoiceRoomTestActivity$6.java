package com.tencent.timi.game.trtc;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TRTCMultipeVoiceRoomTestActivity$6
  implements Observer<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>>
{
  TRTCMultipeVoiceRoomTestActivity$6(TRTCMultipeVoiceRoomTestActivity paramTRTCMultipeVoiceRoomTestActivity) {}
  
  public void a(ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> paramConcurrentHashMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramConcurrentHashMap.next();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("【房间】");
      ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
      ((StringBuilder)localObject2).append("\n");
      localStringBuilder1.append(((StringBuilder)localObject2).toString());
      localObject1 = ((ConcurrentHashMap)((Map.Entry)localObject1).getValue()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("User:");
        localStringBuilder2.append((String)((Map.Entry)localObject2).getKey());
        localStringBuilder2.append(" Volume:");
        localStringBuilder2.append(((Map.Entry)localObject2).getValue());
        localStringBuilder2.append("\n");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    TRTCMultipeVoiceRoomTestActivity.e(this.a).setText(localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.6
 * JD-Core Version:    0.7.0.1
 */