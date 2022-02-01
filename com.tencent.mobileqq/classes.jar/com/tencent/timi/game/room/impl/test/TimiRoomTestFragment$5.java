package com.tencent.timi.game.room.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.utils.Logger;

class TimiRoomTestFragment$5
  implements View.OnClickListener
{
  TimiRoomTestFragment$5(TimiRoomTestFragment paramTimiRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    Logger.a("TimiRoomTestFragment", "debug TGPA stop ");
    TGPAUtil.a(this.a.getActivity());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.5
 * JD-Core Version:    0.7.0.1
 */