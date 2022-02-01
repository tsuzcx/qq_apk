package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;

class TgLiveAudienceTestFragment$1
  implements View.OnClickListener
{
  TgLiveAudienceTestFragment$1(TgLiveAudienceTestFragment paramTgLiveAudienceTestFragment) {}
  
  public void onClick(View paramView)
  {
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).a(0L, new TgLiveAudienceTestFragment.1.1(this));
    this.a.getQBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveAudienceTestFragment.1
 * JD-Core Version:    0.7.0.1
 */