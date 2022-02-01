package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomNewDataPushMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class YoloRoomManager$2
  implements YoloRoomChatManager.MessageListener
{
  YoloRoomManager$2(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(String paramString, @NotNull MessageOuterClass.YoloRoomActionMsg paramYoloRoomActionMsg, long paramLong)
  {
    if ((YoloRoomManager.a(this.a) != null) && (YoloRoomManager.a(this.a).tim_group_id.get() == paramLong)) {
      YoloRoomManager.a(this.a, paramString, paramYoloRoomActionMsg.yolo_room_action);
    }
  }
  
  public void a(@NotNull MessageOuterClass.YoloRoomActionMsg paramYoloRoomActionMsg, long paramLong)
  {
    if ((YoloRoomManager.a(this.a) != null) && (YoloRoomManager.a(this.a).tim_group_id.get() == paramLong)) {
      YoloRoomManager.a(this.a, paramYoloRoomActionMsg.yolo_room_action);
    }
  }
  
  public void a(@NotNull MessageOuterClass.YoloRoomNewDataPushMsg paramYoloRoomNewDataPushMsg, long paramLong)
  {
    if ((YoloRoomManager.a(this.a) != null) && (YoloRoomManager.a(this.a).tim_group_id.get() == paramLong)) {
      this.a.a(paramYoloRoomNewDataPushMsg.new_data_time_ms.get(), "FromImGroupNotifyMsg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.2
 * JD-Core Version:    0.7.0.1
 */