package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import java.util.List;

class SayHelloMsgListActivity$2
  implements Runnable
{
  SayHelloMsgListActivity$2(SayHelloMsgListActivity paramSayHelloMsgListActivity, List paramList) {}
  
  public void run()
  {
    ((NearbyRelevantHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity.2
 * JD-Core Version:    0.7.0.1
 */