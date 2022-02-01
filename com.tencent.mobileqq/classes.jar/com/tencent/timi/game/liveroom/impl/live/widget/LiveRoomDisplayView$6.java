package com.tencent.timi.game.liveroom.impl.live.widget;

import android.os.Handler;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.timi.game.live.api.IGameLiveView;
import com.tencent.timi.game.live.api.LivePlayStatus;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$6", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "onError", "", "errorCode", "", "msg", "", "onFirstFrameCome", "onPause", "onPlay", "onPlayCompleted", "onResume", "onStartBuffer", "onStopBuffer", "onVideoSizeChanged", "width", "height", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveRoomDisplayView$6
  implements AudienceRoomPlayerListener
{
  public void onError(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c("LiveRoomDisplayView", localStringBuilder.toString());
    ((LiveTipsView)this.a.a(2131437351)).c();
    ((LiveTipsView)this.a.a(2131437351)).b();
  }
  
  public void onFirstFrameCome()
  {
    Logger.a("LiveRoomDisplayView", "onFirstFrameCome");
    Object localObject = this.a;
    boolean bool2 = true;
    LiveRoomDisplayView.c((LiveRoomDisplayView)localObject, true);
    LiveRoomDisplayView.p(this.a).setStatus(LivePlayStatus.e);
    LiveRoomDisplayView.p(this.a).setLiveVolume(100);
    localObject = LiveRoomDisplayView.p(this.a);
    boolean bool1 = bool2;
    if (!LiveRoomDisplayView.n(this.a)) {
      if (LiveRoomDisplayView.u(this.a)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    ((IGameLiveView)localObject).b(bool1);
    LiveRoomDisplayView.p(this.a).a(LiveRoomDisplayView.v(this.a));
    localObject = LiveRoomDisplayView.b(this.a);
    if (localObject != null) {
      ((LiveRoomDisplayView.LiveViewListener)localObject).a();
    }
    ((LiveTipsView)this.a.a(2131437351)).b();
    ((LiveTipsView)this.a.a(2131437351)).d();
    LiveRoomDisplayView.i(this.a).removeCallbacks(LiveRoomDisplayView.r(this.a));
  }
  
  public void onPause() {}
  
  public void onPlay()
  {
    ((LiveTipsView)this.a.a(2131437351)).b();
    ((LiveTipsView)this.a.a(2131437351)).d();
    LiveRoomDisplayView.i(this.a).removeCallbacks(LiveRoomDisplayView.r(this.a));
  }
  
  public void onPlayCompleted() {}
  
  public void onResume()
  {
    ((LiveTipsView)this.a.a(2131437351)).b();
    ((LiveTipsView)this.a.a(2131437351)).d();
  }
  
  public void onStartBuffer()
  {
    ((LiveTipsView)this.a.a(2131437351)).a();
    ((LiveTipsView)this.a.a(2131437351)).d();
  }
  
  public void onStopBuffer()
  {
    ((LiveTipsView)this.a.a(2131437351)).b();
    ((LiveTipsView)this.a.a(2131437351)).d();
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.6
 * JD-Core Version:    0.7.0.1
 */