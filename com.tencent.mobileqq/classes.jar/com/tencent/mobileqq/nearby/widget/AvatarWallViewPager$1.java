package com.tencent.mobileqq.nearby.widget;

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
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a() > 1)
    {
      paramMessage = this.a;
      paramMessage.f += 1;
      paramMessage = this.a;
      paramMessage.f %= this.a.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.a.f, true);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), this.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.1
 * JD-Core Version:    0.7.0.1
 */