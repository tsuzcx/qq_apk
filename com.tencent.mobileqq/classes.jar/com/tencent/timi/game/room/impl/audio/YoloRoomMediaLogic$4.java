package com.tencent.timi.game.room.impl.audio;

import androidx.lifecycle.Observer;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class YoloRoomMediaLogic$4
  implements Observer<ConcurrentHashMap<String, Integer>>
{
  YoloRoomMediaLogic$4(YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
  
  public void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap != null)
    {
      Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          if (YoloRoomMediaLogic.e(this.a).equals(localEntry.getKey()))
          {
            if (((Integer)localEntry.getValue()).intValue() <= 10) {
              break;
            }
            IRoomDoOpService localIRoomDoOpService = ((IRoomService)ServiceCenter.a(IRoomService.class)).b(YoloRoomMediaLogic.b(this.a));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("LogIgnore mic level update ");
            localStringBuilder.append(localEntry.getValue());
            localIRoomDoOpService.a(localStringBuilder.toString());
          }
        }
        catch (Exception localException)
        {
          Logger.a("YoloRoomAudioLogic", localException.toString(), localException);
        }
      }
    }
    if (YoloRoomMediaLogic.d(this.a) != null) {
      YoloRoomMediaLogic.d(this.a).a(paramConcurrentHashMap);
    }
    if ((paramConcurrentHashMap != null) && (paramConcurrentHashMap.size() > 0)) {
      YoloRoomMediaLogic.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.4
 * JD-Core Version:    0.7.0.1
 */