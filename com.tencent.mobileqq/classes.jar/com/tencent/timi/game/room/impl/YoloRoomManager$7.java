package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

class YoloRoomManager$7
  implements IResultListener<Boolean>
{
  YoloRoomManager$7(YoloRoomManager paramYoloRoomManager, boolean paramBoolean1, int paramInt, IResultListener paramIResultListener, boolean paramBoolean2) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("leaveRoom - exitRoomCheck onError - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("YoloRoomManager", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leaveRoom - exitRoomCheck onSuccess - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomManager", localStringBuilder.toString());
    if (paramBoolean.booleanValue())
    {
      YoloRoomManager.a(this.e, this.a, this.b, this.c, this.d);
      return;
    }
    paramBoolean = this.c;
    if (paramBoolean != null) {
      paramBoolean.a(-10000, "exitRoomCheck false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.7
 * JD-Core Version:    0.7.0.1
 */