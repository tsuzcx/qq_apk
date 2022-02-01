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
      if (this.a.d.getCount() > 1)
      {
        paramMessage = this.a;
        paramMessage.j += 1;
        paramMessage = this.a;
        paramMessage.j %= this.a.d.getCount();
        this.a.b.setCurrentItem(this.a.j, true);
        this.a.l.sendMessageDelayed(this.a.l.obtainMessage(), 4000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner.1
 * JD-Core Version:    0.7.0.1
 */