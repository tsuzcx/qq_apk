package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;

class SubscriptionInfoModule$2
  implements Runnable
{
  SubscriptionInfoModule$2(SubscriptionInfoModule paramSubscriptionInfoModule) {}
  
  public void run()
  {
    Object localObject = TroopBarAssistantManager.a();
    SubscriptionInfoModule localSubscriptionInfoModule = this.this$0;
    SubscriptionInfoModule.a(localSubscriptionInfoModule, ((TroopBarAssistantManager)localObject).b((QQAppInterface)SubscriptionInfoModule.e(localSubscriptionInfoModule)));
    localObject = this.this$0;
    ((SubscriptionInfoModule)localObject).a(SubscriptionInfoModule.a((SubscriptionInfoModule)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.2
 * JD-Core Version:    0.7.0.1
 */