package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager;
import com.tencent.qphone.base.util.QLog;

class FrameworkHandler$6
  implements Runnable
{
  FrameworkHandler$6(FrameworkHandler paramFrameworkHandler) {}
  
  public void run()
  {
    if (ReadInJoyChannelGuidingManager.a(this.this$0.a()))
    {
      this.this$0.a(true, 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = ");
      localStringBuilder.append(this.this$0.a());
      QLog.i("FrameworkHandler", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.6
 * JD-Core Version:    0.7.0.1
 */