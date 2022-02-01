package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.os.Handler;
import android.os.Message;

class RIJDataManager$CheckingHandler
  extends Handler
{
  RIJDataManager a;
  
  public void a(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
    {
      paramMessage = this.a;
      if (paramMessage != null) {
        RIJDataManager.a(paramMessage);
      }
      sendEmptyMessageDelayed(1, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.CheckingHandler
 * JD-Core Version:    0.7.0.1
 */