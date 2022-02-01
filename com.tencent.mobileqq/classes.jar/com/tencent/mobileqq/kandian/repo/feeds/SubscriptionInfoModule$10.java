package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = TroopBarAssistantManager.a().b((QQAppInterface)SubscriptionInfoModule.m(this.this$0)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscriptionFeed localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
      if (localSubscriptionFeed.a != null)
      {
        localSubscriptionFeed.b = 0;
        int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)SubscriptionInfoModule.n(this.this$0), localSubscriptionFeed.a);
        RecentUtil.b((QQAppInterface)SubscriptionInfoModule.o(this.this$0), localSubscriptionFeed.a, i);
        ((QQAppInterface)SubscriptionInfoModule.p(this.this$0)).getMessageFacade().a(localSubscriptionFeed.a, 1008);
      }
    }
    localObject = RIJSPUtils.a(SubscriptionInfoModule.q(this.this$0), true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    SubscriptionInfoModule.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */