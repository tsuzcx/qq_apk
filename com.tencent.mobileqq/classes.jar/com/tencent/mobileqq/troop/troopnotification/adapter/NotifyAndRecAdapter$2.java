package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyAndRecAdapter$2
  implements View.OnClickListener
{
  NotifyAndRecAdapter$2(NotifyAndRecAdapter paramNotifyAndRecAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).joinRecommendTroop(NotifyAndRecAdapter.b(this.a), localRecommendTroopItem, 10001);
    TroopReportor.a("Grp_contacts_news", "notice", "recom_clk_add", 0, 0, new String[] { localRecommendTroopItem.uin, localRecommendTroopItem.recomAlgol });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.2
 * JD-Core Version:    0.7.0.1
 */