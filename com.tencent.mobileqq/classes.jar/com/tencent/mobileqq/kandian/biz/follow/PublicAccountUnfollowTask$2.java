package com.tencent.mobileqq.kandian.biz.follow;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;

class PublicAccountUnfollowTask$2
  implements Runnable
{
  PublicAccountUnfollowTask$2(PublicAccountUnfollowTask paramPublicAccountUnfollowTask) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().c().request0x978(PublicAccountUnfollowTask.a(this.this$0).getAccount(), PublicAccountUnfollowTask.b(this.this$0), false, "", this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask.2
 * JD-Core Version:    0.7.0.1
 */