package com.tencent.timi.game.liveroom.impl.view.head;

import android.widget.TextView;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView$mRoomAudienceInfoListener$1", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "onAudienceEnterRoom", "", "audienceInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "onRecAudienceInfo", "info", "Lcom/tencent/mobileqq/qqlive/data/room/RoomAudienceInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView$mRoomAudienceInfoListener$1
  implements RoomAudienceInfoListener
{
  public void a(@NotNull LiveMessageData.SpeakerInfo paramSpeakerInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramSpeakerInfo, "audienceInfo");
  }
  
  public void a(@NotNull RoomAudienceInfo paramRoomAudienceInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRoomAudienceInfo, "info");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecAudienceInfo fakeTotalPeople=");
    ((StringBuilder)localObject).append(paramRoomAudienceInfo.fakeTotalPeople);
    ((StringBuilder)localObject).append(" userCount=");
    ((StringBuilder)localObject).append(paramRoomAudienceInfo.userCount);
    QLog.d("AnchorTopHeadView_", 1, ((StringBuilder)localObject).toString());
    localObject = (TextView)this.a.a(2131428831);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "audienceNumTxv");
    ((TextView)localObject).setText((CharSequence)String.valueOf(paramRoomAudienceInfo.userCount));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.mRoomAudienceInfoListener.1
 * JD-Core Version:    0.7.0.1
 */