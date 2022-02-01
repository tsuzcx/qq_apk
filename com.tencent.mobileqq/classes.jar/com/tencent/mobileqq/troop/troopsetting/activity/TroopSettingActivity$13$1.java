package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.widget.XListView;

class TroopSettingActivity$13$1
  implements MessageQueue.IdleHandler
{
  TroopSettingActivity$13$1(TroopSettingActivity.13 param13) {}
  
  public boolean queueIdle()
  {
    View localView = this.a.a.h[40];
    int i = localView.getTop();
    int j = (this.a.a.U.getHeight() - localView.getHeight()) / 2;
    this.a.a.U.smoothScrollBy(i - j, 1000);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.13.1
 * JD-Core Version:    0.7.0.1
 */