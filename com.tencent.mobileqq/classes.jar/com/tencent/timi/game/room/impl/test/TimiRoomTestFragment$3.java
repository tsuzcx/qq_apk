package com.tencent.timi.game.room.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TimiRoomTestFragment$3
  implements View.OnClickListener
{
  TimiRoomTestFragment$3(TimiRoomTestFragment paramTimiRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    YoloRoomOuterClass.YoloRoomInfo localYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
    if (localYoloRoomInfo == null) {
      CustomToastView.a("未在开黑车队内！");
    } else {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(localYoloRoomInfo.room_id.get(), true, 0, new TimiRoomTestFragment.3.1(this), true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.3
 * JD-Core Version:    0.7.0.1
 */