package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import java.util.List;

class SayHelloMsgListActivity$2
  implements Runnable
{
  SayHelloMsgListActivity$2(SayHelloMsgListActivity paramSayHelloMsgListActivity, List paramList) {}
  
  public void run()
  {
    ((INearbyRelevantHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity.2
 * JD-Core Version:    0.7.0.1
 */