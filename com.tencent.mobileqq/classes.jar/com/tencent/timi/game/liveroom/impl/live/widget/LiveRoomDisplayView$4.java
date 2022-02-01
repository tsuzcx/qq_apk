package com.tencent.timi.game.liveroom.impl.live.widget;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class LiveRoomDisplayView$4<T>
  implements Observer<Boolean>
{
  LiveRoomDisplayView$4(LiveRoomDisplayView paramLiveRoomDisplayView) {}
  
  public final void a(Boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)this.a.a(2131449984);
    int i;
    if (Intrinsics.areEqual(paramBoolean, Boolean.valueOf(true))) {
      i = 2130853138;
    } else {
      i = 2130853139;
    }
    localImageView.setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.4
 * JD-Core Version:    0.7.0.1
 */