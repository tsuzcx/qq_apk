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
    View localView = this.a.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    int i = localView.getTop();
    int j = (this.a.a.jdField_a_of_type_ComTencentWidgetXListView.getHeight() - localView.getHeight()) / 2;
    this.a.a.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(i - j, 1000);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.13.1
 * JD-Core Version:    0.7.0.1
 */