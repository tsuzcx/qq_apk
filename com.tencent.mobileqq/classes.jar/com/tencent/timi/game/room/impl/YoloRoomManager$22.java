package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameCmdRsp;

class YoloRoomManager$22
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$22(YoloRoomManager paramYoloRoomManager, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.b);
    }
    if (paramYoloRoomCmdRsp != null) {
      paramYoloRoomCmdRsp = paramYoloRoomCmdRsp.yolo_room_join_game_cmd_rsp;
    } else {
      paramYoloRoomCmdRsp = null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("joinGame onSuccess - ");
    ((StringBuilder)localObject).append(paramYoloRoomCmdRsp);
    Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
    if ((paramYoloRoomCmdRsp != null) && (paramYoloRoomCmdRsp.room_info.has()))
    {
      YoloRoomManager.a(this.b, null, paramYoloRoomCmdRsp.room_info, 0);
      localObject = this.b;
      YoloRoomManager.a((YoloRoomManager)localObject, YoloRoomManager.g((YoloRoomManager)localObject), true);
    }
    localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.22
 * JD-Core Version:    0.7.0.1
 */