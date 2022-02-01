package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.ITrtcCheckResult;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;

class YoloRoomManager$6
  implements TimiGameQQTrtcUtil.ITrtcCheckResult
{
  YoloRoomManager$6(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener) {}
  
  public void a()
  {
    YoloRoomManager.a(this.b, false);
    boolean bool = this.b.v();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkMediaTrtcEnv requestQQAudioEnv onSuccess, isInRoom = ");
    ((StringBuilder)localObject).append(bool);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (bool)
    {
      YoloRoomManager.c(this.b);
      localObject = this.a;
      if (localObject != null) {
        ((IResultListener)localObject).a(YoloRoomManager.d(this.b));
      }
      YoloRoomManager.e(this.b).a(true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    YoloRoomManager.a(this.b, false);
    boolean bool = this.b.v();
    int i = this.b.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkMediaTrtcEnv requestQQAudioEnv onError - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", isInRoom = ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(this.b.w());
    Logger.c("YoloRoomManager", ((StringBuilder)localObject).toString());
    if (bool)
    {
      ThreadPool.a(new YoloRoomManager.6.1(this, paramInt, i, paramString));
      localObject = this.a;
      if (localObject != null) {
        ((IResultListener)localObject).a(paramInt, paramString);
      }
      YoloRoomManager.e(this.b).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.6
 * JD-Core Version:    0.7.0.1
 */