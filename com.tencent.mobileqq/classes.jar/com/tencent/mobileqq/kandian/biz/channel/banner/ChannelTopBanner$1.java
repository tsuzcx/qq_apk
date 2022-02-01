package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ChannelTopBanner$1
  extends Handler
{
  ChannelTopBanner$1(ChannelTopBanner paramChannelTopBanner, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!ChannelTopBanner.a(this.a))
    {
      if (!ChannelTopBanner.b(this.a)) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.getCount() > 1)
      {
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Int += 1;
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Int %= this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.getCount();
        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setCurrentItem(this.a.jdField_a_of_type_Int, true);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner.1
 * JD-Core Version:    0.7.0.1
 */