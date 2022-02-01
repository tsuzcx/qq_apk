package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.Context;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptionInfoModule$5
  implements Runnable
{
  SubscriptionInfoModule$5(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString, Context paramContext) {}
  
  public void run()
  {
    TroopBarAssistantManager.a().a(this.a, (QQAppInterface)SubscriptionInfoModule.h(this.this$0), this.b, SubscriptionInfoModule.i(this.this$0));
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)SubscriptionInfoModule.j(this.this$0), this.a);
    RecentUtil.b((QQAppInterface)SubscriptionInfoModule.k(this.this$0), this.a, i);
    ((QQAppInterface)SubscriptionInfoModule.l(this.this$0)).getMessageFacade().a(this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.5
 * JD-Core Version:    0.7.0.1
 */