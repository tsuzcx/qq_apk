package com.tencent.timi.game.liveroom.api.message;

import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/api/message/ILiveMsg;", "", "content", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "id", "", "message", "sender", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "type", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ILiveMsg
{
  @NotNull
  public abstract String a();
  
  @NotNull
  public abstract LiveMessageData.SpeakerInfo b();
  
  @NotNull
  public abstract String c();
  
  @Nullable
  public abstract MessageOuterClass.TimMsgBody d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.api.message.ILiveMsg
 * JD-Core Version:    0.7.0.1
 */