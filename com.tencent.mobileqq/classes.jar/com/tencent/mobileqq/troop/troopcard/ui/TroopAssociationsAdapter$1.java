package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssociationsAdapter$1
  implements View.OnClickListener
{
  TroopAssociationsAdapter$1(TroopAssociationsAdapter paramTroopAssociationsAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (AssociatedTroopItem)paramView.getTag();
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).jionTroopFromTroopAssociation(TroopAssociationsAdapter.a(this.a), localObject);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((AssociatedTroopItem)localObject).uin;
    }
    ReportController.b(null, "dc00898", "", (String)localObject, "0X800B4B2", "0X800B4B2", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopAssociationsAdapter.1
 * JD-Core Version:    0.7.0.1
 */