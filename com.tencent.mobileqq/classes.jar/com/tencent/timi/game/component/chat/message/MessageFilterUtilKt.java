package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isMessageSupport", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class MessageFilterUtilKt
{
  public static final boolean a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramIMsg.c() == 49)
    {
      if (((YoloRoomOuterClass.YoloRoomAction)((MessageOuterClass.YoloRoomActionMsg)paramIMsg.g().yolo_room_action_msg.get()).yolo_room_action.get()).action_type.get() == 29) {
        return false;
      }
    }
    else if (paramIMsg.c() == 80) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageFilterUtilKt
 * JD-Core Version:    0.7.0.1
 */