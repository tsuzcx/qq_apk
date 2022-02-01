package com.tencent.timi.game.room.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.utils.Logger;

class TimiRoomTestFragment$4
  implements View.OnClickListener
{
  TimiRoomTestFragment$4(TimiRoomTestFragment paramTimiRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("debug TGPA start, XID = ");
    localStringBuilder.append("一期暂无");
    Logger.a("TimiRoomTestFragment", localStringBuilder.toString());
    ((ISmobaService)ServiceCenter.a(ISmobaService.class)).a();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1L, "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.4
 * JD-Core Version:    0.7.0.1
 */