package com.tencent.mobileqq.troop.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecommendTroopAdapter$2
  implements View.OnClickListener
{
  RecommendTroopAdapter$2(RecommendTroopAdapter paramRecommendTroopAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).openRecommendTroop(RecommendTroopAdapter.a(this.a), localRecommendTroopItem, this.a.b(), this.a.c());
    this.a.a(localRecommendTroopItem);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter.2
 * JD-Core Version:    0.7.0.1
 */