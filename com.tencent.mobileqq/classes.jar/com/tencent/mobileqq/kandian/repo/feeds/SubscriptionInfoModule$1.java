package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;

class SubscriptionInfoModule$1
  implements Runnable
{
  SubscriptionInfoModule$1(SubscriptionInfoModule paramSubscriptionInfoModule) {}
  
  public void run()
  {
    ((IPublicAccountDataManager)((QQAppInterface)SubscriptionInfoModule.a(this.this$0)).getRuntimeService(IPublicAccountDataManager.class, "all")).initPublicAccountDataManager();
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    localTroopBarAssistantManager.c((QQAppInterface)SubscriptionInfoModule.b(this.this$0));
    if (localTroopBarAssistantManager.a((QQAppInterface)SubscriptionInfoModule.c(this.this$0))) {
      localTroopBarAssistantManager.a(SubscriptionInfoModule.a(this.this$0), (QQAppInterface)SubscriptionInfoModule.d(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */