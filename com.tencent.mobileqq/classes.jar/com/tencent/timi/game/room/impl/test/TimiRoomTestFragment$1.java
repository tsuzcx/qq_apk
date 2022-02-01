package com.tencent.timi.game.room.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;

class TimiRoomTestFragment$1
  implements View.OnClickListener
{
  TimiRoomTestFragment$1(TimiRoomTestFragment paramTimiRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    ((ITeamService)ServiceCenter.a(ITeamService.class)).a(this.a.getActivity(), 1, 1, 888L, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.1
 * JD-Core Version:    0.7.0.1
 */