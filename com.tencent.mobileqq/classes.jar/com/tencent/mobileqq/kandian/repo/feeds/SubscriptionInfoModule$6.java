package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptionInfoModule$6
  implements Runnable
{
  SubscriptionInfoModule$6(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString) {}
  
  public void run()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)SubscriptionInfoModule.m(this.this$0), this.a);
    RecentUtil.b((QQAppInterface)SubscriptionInfoModule.n(this.this$0), this.a, i);
    ((QQAppInterface)SubscriptionInfoModule.o(this.this$0)).getMessageFacade().a(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */