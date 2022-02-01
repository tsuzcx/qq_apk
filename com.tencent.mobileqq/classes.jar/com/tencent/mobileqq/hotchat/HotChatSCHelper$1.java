package com.tencent.mobileqq.hotchat;

import android.os.Handler;

class HotChatSCHelper$1
  implements Runnable
{
  HotChatSCHelper$1(HotChatSCHelper paramHotChatSCHelper, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (!this.this$0.mStarting) {
      return;
    }
    this.this$0.mMang.initCache();
    long l1 = System.currentTimeMillis();
    long l2 = this.a - Math.abs(l1 - this.b);
    if (l2 < 0L)
    {
      l1 = 100L;
    }
    else
    {
      long l3 = this.a;
      l1 = l2;
      if (l2 > l3) {
        l1 = l3;
      }
    }
    this.this$0.mHandler.removeMessages(0);
    this.this$0.mHandler.sendEmptyMessageDelayed(0, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCHelper.1
 * JD-Core Version:    0.7.0.1
 */