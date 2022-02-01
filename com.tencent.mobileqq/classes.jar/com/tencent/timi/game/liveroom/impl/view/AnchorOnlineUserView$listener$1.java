package com.tencent.timi.game.liveroom.impl.view;

import android.widget.TextView;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorOnlineUserView$listener$1", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "onlineNumChanged", "", "onlineNum", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOnlineUserView$listener$1
  extends SimpleYoloRoomCommonListener
{
  public void a(int paramInt)
  {
    TextView localTextView = (TextView)this.a.a(2131447786);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "totalOnlineNum");
    localTextView.setText((CharSequence)String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorOnlineUserView.listener.1
 * JD-Core Version:    0.7.0.1
 */