package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TgLiveRoomTestFragment$1
  implements View.OnClickListener
{
  TgLiveRoomTestFragment$1(TgLiveRoomTestFragment paramTgLiveRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c();
    CustomToastView.a("已退出房间并释放全部资源");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.1
 * JD-Core Version:    0.7.0.1
 */