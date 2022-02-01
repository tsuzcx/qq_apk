package com.tencent.timi.game.liveroom.impl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView.LiveViewListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;

class TimiAudienceFragment$1
  implements BaseGameLiveAudienceView.LiveViewListener
{
  TimiAudienceFragment$1(TimiAudienceFragment paramTimiAudienceFragment) {}
  
  public void a(QQLiveSwitchRoom paramQQLiveSwitchRoom) {}
  
  public void a(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null)
    {
      if (paramBoolean)
      {
        localFragmentActivity.setRequestedOrientation(0);
        TimiAudienceFragment.a(this.a).a(true);
        return;
      }
      localFragmentActivity.setRequestedOrientation(1);
      TimiAudienceFragment.a(this.a).a(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(TimiAudienceFragment.b(this.a), null);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceFragment.1
 * JD-Core Version:    0.7.0.1
 */