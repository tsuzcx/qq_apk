package com.tencent.timi.game.room.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.accusation.api.TimiGameAccusationApi;

class TimiRoomTestFragment$6
  implements View.OnClickListener
{
  TimiRoomTestFragment$6(TimiRoomTestFragment paramTimiRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    TimiGameAccusationApi.a("9350101", "1989", "1127");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.6
 * JD-Core Version:    0.7.0.1
 */