package com.tencent.mobileqq.dating;

import axpy;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class SayHelloMsgListActivity$2
  implements Runnable
{
  SayHelloMsgListActivity$2(SayHelloMsgListActivity paramSayHelloMsgListActivity, List paramList) {}
  
  public void run()
  {
    ((axpy)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity.2
 * JD-Core Version:    0.7.0.1
 */