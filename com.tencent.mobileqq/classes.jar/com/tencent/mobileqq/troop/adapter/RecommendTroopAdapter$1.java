package com.tencent.mobileqq.troop.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecommendTroopAdapter$1
  implements View.OnClickListener
{
  RecommendTroopAdapter$1(RecommendTroopAdapter paramRecommendTroopAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).joinRecommendTroop(RecommendTroopAdapter.a(this.a), localRecommendTroopItem, this.a.a());
    this.a.b(localRecommendTroopItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter.1
 * JD-Core Version:    0.7.0.1
 */