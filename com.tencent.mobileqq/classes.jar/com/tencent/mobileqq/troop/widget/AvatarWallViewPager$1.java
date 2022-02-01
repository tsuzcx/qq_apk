package com.tencent.mobileqq.troop.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AvatarWallViewPager$1
  extends Handler
{
  AvatarWallViewPager$1(AvatarWallViewPager paramAvatarWallViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((AvatarWallViewPager.a(this.a)) || (!AvatarWallViewPager.b(this.a))) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount() <= 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.b += 1;
    this.a.b %= this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.a.b, true);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager.1
 * JD-Core Version:    0.7.0.1
 */