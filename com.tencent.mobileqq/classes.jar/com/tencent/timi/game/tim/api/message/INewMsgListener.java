package com.tencent.timi.game.tim.api.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/message/INewMsgListener;", "", "onGroupMemberInfoChange", "", "groupId", "", "uids", "", "onGroupMsgNotify", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "onNewMsg", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface INewMsgListener
{
  public abstract void a(long paramLong, @NotNull MessageOuterClass.TimMsgBody paramTimMsgBody);
  
  public abstract void a(@NotNull IMsg paramIMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.message.INewMsgListener
 * JD-Core Version:    0.7.0.1
 */