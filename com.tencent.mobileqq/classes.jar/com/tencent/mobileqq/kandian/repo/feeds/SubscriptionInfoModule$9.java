package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class SubscriptionInfoModule$9
  extends Handler
{
  SubscriptionInfoModule$9(SubscriptionInfoModule paramSubscriptionInfoModule, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10002) {
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.9
 * JD-Core Version:    0.7.0.1
 */