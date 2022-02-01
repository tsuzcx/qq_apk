package com.tencent.mobileqq.kandian.biz.follow;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUnfollowTask$1
  implements Runnable
{
  PublicAccountUnfollowTask$1(PublicAccountUnfollowTask paramPublicAccountUnfollowTask) {}
  
  public void run()
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a().request0x978(PublicAccountUnfollowTask.a(this.this$0).getAccount(), PublicAccountUnfollowTask.a(this.this$0), false, "", this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask.1
 * JD-Core Version:    0.7.0.1
 */