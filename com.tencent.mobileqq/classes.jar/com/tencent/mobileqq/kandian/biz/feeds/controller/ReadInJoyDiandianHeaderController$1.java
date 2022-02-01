package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyDiandianHeaderController$1
  extends Handler
{
  ReadInJoyDiandianHeaderController$1(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ReadInJoyDiandianHeaderController.a(this.a)) {
      return;
    }
    if (ReadInJoyDiandianHeaderController.a(this.a).getCount() > 1)
    {
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int += 1;
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int %= ReadInJoyDiandianHeaderController.a(this.a).getCount();
      ReadInJoyDiandianHeaderController.a(this.a).setCurrentItem(this.a.jdField_a_of_type_Int, true);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009827", "0X8009827", 0, 0, "", "", "", "", false);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.1
 * JD-Core Version:    0.7.0.1
 */