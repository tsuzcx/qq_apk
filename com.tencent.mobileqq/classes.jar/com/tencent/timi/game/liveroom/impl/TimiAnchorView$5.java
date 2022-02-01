package com.tencent.timi.game.liveroom.impl;

import android.widget.TextView;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView;
import com.tencent.timi.game.liveroom.impl.live.AnchorLivePrivacyStateHolder;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreDialog;
import com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView;
import com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView;
import com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView.IAnchorOperationBarViewListener;
import com.tencent.timi.game.utils.Logger;

class TimiAnchorView$5
  implements AnchorOperationBarView.IAnchorOperationBarViewListener
{
  TimiAnchorView$5(TimiAnchorView paramTimiAnchorView) {}
  
  public void a()
  {
    TimiAnchorView.c(this.a).h();
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrivacyClick: ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TimiAnchorView", localStringBuilder.toString());
    if ((TimiAnchorView.h(this.a) instanceof IQQLiveAnchorTRTCRoom))
    {
      if (paramBoolean)
      {
        ((IQQLiveAnchorTRTCRoom)TimiAnchorView.h(this.a)).resumePublishStream();
        TimiAnchorView.i(this.a).setText("直播开始啦，手机画面已同步到直播间");
      }
      else
      {
        TimiAnchorView.i(this.a).setText("主播暂时离开，千万别走开马上回来");
        ((IQQLiveAnchorTRTCRoom)TimiAnchorView.h(this.a)).pausePublishStream(TimiAnchorView.j(this.a), 10);
        TimiAnchorView.i(this.a).setText("直播画面已暂停\n尽快恢复别让观众等太久哦");
      }
      TimiAnchorView.k(this.a).setPrivacyOn(paramBoolean ^ true);
      AnchorLivePrivacyStateHolder.a.a(paramBoolean ^ true);
    }
  }
  
  public void b()
  {
    AnchorMoreDialog.a(TimiAnchorView.d(this.a), TimiAnchorView.e(this.a), TimiAnchorView.f(this.a), TimiAnchorView.a(this.a).getSettingEntranceShowFlag(), TimiAnchorView.g(this.a));
  }
  
  public void b(boolean paramBoolean)
  {
    if ((TimiAnchorView.h(this.a) instanceof IQQLiveAnchorMediaControl))
    {
      TimiAnchorView.k(this.a).setMicOn(paramBoolean ^ true);
      if (paramBoolean)
      {
        ((IQQLiveAnchorMediaControl)TimiAnchorView.h(this.a)).stopAudioRecord();
        return;
      }
      ((IQQLiveAnchorMediaControl)TimiAnchorView.h(this.a)).startAudioRecord();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.5
 * JD-Core Version:    0.7.0.1
 */