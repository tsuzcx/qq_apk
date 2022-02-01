package com.tencent.mobileqq.kandian.biz.message.activity;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class ReadinjoySubscriptManagerActivity$2
  implements Runnable
{
  ReadinjoySubscriptManagerActivity$2(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public void run()
  {
    Object localObject = TroopBarAssistantManager.a().j(this.this$0.app);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        ReadinjoySubscriptManagerActivity.SubscribeFeedData localSubscribeFeedData = new ReadinjoySubscriptManagerActivity.SubscribeFeedData(this.this$0, null);
        ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(localSubscribeFeedData, localPublicAccountInfo.getUin());
        ReadinjoySubscriptManagerActivity.SubscribeFeedData.b(localSubscribeFeedData, localPublicAccountInfo.name);
        ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData, ChnToSpell.b(ReadinjoySubscriptManagerActivity.SubscribeFeedData.b(localSubscribeFeedData), 2));
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccount(this.this$0.app, localPublicAccountInfo.getUin())) {
          localArrayList2.add(localSubscribeFeedData);
        } else {
          localArrayList1.add(localSubscribeFeedData);
        }
      }
    }
    Collections.sort(localArrayList1, ReadinjoySubscriptManagerActivity.a(this.this$0));
    Collections.sort(localArrayList2, ReadinjoySubscriptManagerActivity.a(this.this$0));
    localArrayList2.addAll(localArrayList1);
    ThreadManager.getUIHandler().post(new ReadinjoySubscriptManagerActivity.2.1(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */