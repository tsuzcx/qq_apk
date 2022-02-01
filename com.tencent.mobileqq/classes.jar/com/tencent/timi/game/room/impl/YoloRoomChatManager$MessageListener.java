package com.tencent.timi.game.room.impl;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomNewDataPushMsg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/YoloRoomChatManager$MessageListener;", "", "onNewDataPush", "", "action", "Ltrpc/yes/common/MessageOuterClass$YoloRoomNewDataPushMsg;", "groupId", "", "onYoloActionMsg", "msgId", "", "Ltrpc/yes/common/MessageOuterClass$YoloRoomActionMsg;", "onYoloActionMsgFromGroupNotifyMsg", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface YoloRoomChatManager$MessageListener
{
  public abstract void a(@NotNull String paramString, @NotNull MessageOuterClass.YoloRoomActionMsg paramYoloRoomActionMsg, long paramLong);
  
  public abstract void a(@NotNull MessageOuterClass.YoloRoomActionMsg paramYoloRoomActionMsg, long paramLong);
  
  public abstract void a(@NotNull MessageOuterClass.YoloRoomNewDataPushMsg paramYoloRoomNewDataPushMsg, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomChatManager.MessageListener
 * JD-Core Version:    0.7.0.1
 */