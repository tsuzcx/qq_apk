package com.tencent.timi.game.room.impl.audio;

import android.text.TextUtils;
import com.tencent.timi.game.room.api.IRoomEventListener;
import com.tencent.trtc.TRTCCloudListener;
import java.util.Iterator;
import java.util.List;

class YoloRoomMediaLogic$2
  extends TRTCCloudListener
{
  YoloRoomMediaLogic$2(YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = YoloRoomMediaLogic.c(this.a).iterator();
      while (localIterator.hasNext())
      {
        IRoomEventListener localIRoomEventListener = (IRoomEventListener)localIterator.next();
        if (localIRoomEventListener != null) {
          localIRoomEventListener.a(paramString);
        }
      }
    }
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserVideoAvailable(paramString, paramBoolean);
    Iterator localIterator = YoloRoomMediaLogic.c(this.a).iterator();
    while (localIterator.hasNext())
    {
      IRoomEventListener localIRoomEventListener = (IRoomEventListener)localIterator.next();
      if (localIRoomEventListener != null) {
        localIRoomEventListener.a(paramString, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.2
 * JD-Core Version:    0.7.0.1
 */