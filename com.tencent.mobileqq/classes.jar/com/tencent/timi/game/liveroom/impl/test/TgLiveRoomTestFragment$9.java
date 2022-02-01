package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreDialog;
import com.tencent.timi.game.router.ServiceCenter;

class TgLiveRoomTestFragment$9
  implements View.OnClickListener
{
  TgLiveRoomTestFragment$9(TgLiveRoomTestFragment paramTgLiveRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    long l = 0L;
    localObject = ((ITgLiveRoomService)localObject).h(0L);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localObject != null) {
      l = ((BaseRoomInfo)localObject).getRoomId();
    }
    AnchorMoreDialog.a(localFragmentActivity, l, 0, true, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.9
 * JD-Core Version:    0.7.0.1
 */