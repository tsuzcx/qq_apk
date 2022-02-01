package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideofeedsUserGuideController$5
  extends Handler
{
  VideofeedsUserGuideController$5(VideofeedsUserGuideController paramVideofeedsUserGuideController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUIHandler handleMessage() msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("Q.pubaccount.video.feedsVideofeedsUserGuideController", 2, localStringBuilder.toString());
    }
    if (paramMessage.what != 1) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideofeedsUserGuideController.5
 * JD-Core Version:    0.7.0.1
 */