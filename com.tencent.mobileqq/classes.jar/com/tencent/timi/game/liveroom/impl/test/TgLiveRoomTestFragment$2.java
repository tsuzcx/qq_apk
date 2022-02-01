package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TgLiveRoomTestFragment$2
  implements View.OnClickListener
{
  TgLiveRoomTestFragment$2(TgLiveRoomTestFragment paramTgLiveRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    TgLiveRoomTestFragment.a(this.a, QQLiveAnchorStreamRecordType.SCREEN);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.2
 * JD-Core Version:    0.7.0.1
 */