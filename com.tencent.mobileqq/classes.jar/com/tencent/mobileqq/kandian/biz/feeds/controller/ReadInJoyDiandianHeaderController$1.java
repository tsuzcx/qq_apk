package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;

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
    if (ReadInJoyDiandianHeaderController.b(this.a).getCount() > 1)
    {
      paramMessage = this.a;
      paramMessage.b += 1;
      paramMessage = this.a;
      paramMessage.b %= ReadInJoyDiandianHeaderController.b(this.a).getCount();
      ReadInJoyDiandianHeaderController.c(this.a).setCurrentItem(this.a.b, true);
      PublicAccountReportUtils.a(null, "", "0X8009827", "0X8009827", 0, 0, "", "", "", "", false);
      this.a.e.sendMessageDelayed(this.a.e.obtainMessage(), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.1
 * JD-Core Version:    0.7.0.1
 */