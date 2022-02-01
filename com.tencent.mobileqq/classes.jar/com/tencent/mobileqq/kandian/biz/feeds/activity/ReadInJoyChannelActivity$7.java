package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadInJoyChannelActivity$7
  implements Runnable
{
  ReadInJoyChannelActivity$7(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    if (this.this$0.app != null)
    {
      QQMessageFacade localQQMessageFacade = this.this$0.app.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        int i = localQQMessageFacade.w();
        ReadInJoyChannelActivity.a(this.this$0, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity.7
 * JD-Core Version:    0.7.0.1
 */