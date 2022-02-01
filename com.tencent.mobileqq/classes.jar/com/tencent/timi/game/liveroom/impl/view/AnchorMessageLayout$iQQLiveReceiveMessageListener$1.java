package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "messageData", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "kotlin.jvm.PlatformType", "onMessageReceive"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$iQQLiveReceiveMessageListener$1
  implements IQQLiveReceiveMessageListener
{
  AnchorMessageLayout$iQQLiveReceiveMessageListener$1(AnchorMessageLayout paramAnchorMessageLayout) {}
  
  public final void a(LiveMessageData paramLiveMessageData)
  {
    AnchorMessageLayout localAnchorMessageLayout = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramLiveMessageData, "messageData");
    localAnchorMessageLayout.a(new AnchorLiveMsg(paramLiveMessageData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.iQQLiveReceiveMessageListener.1
 * JD-Core Version:    0.7.0.1
 */