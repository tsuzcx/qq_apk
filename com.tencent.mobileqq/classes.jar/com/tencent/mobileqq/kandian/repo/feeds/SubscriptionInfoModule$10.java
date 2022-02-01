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
    Object localObject = TroopBarAssistantManager.a().i((QQAppInterface)SubscriptionInfoModule.p(this.this$0)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscriptionFeed localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
      if (localSubscriptionFeed.c != null)
      {
        localSubscriptionFeed.b = 0;
        int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType((QQAppInterface)SubscriptionInfoModule.q(this.this$0), localSubscriptionFeed.c);
        RecentUtil.b((QQAppInterface)SubscriptionInfoModule.r(this.this$0), localSubscriptionFeed.c, i);
        ((QQAppInterface)SubscriptionInfoModule.s(this.this$0)).getMessageFacade().a(localSubscriptionFeed.c, 1008);
      }
    }
    localObject = RIJSPUtils.a(SubscriptionInfoModule.t(this.this$0), true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    SubscriptionInfoModule.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */