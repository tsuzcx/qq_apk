package com.tencent.mobileqq.troop.associations;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssociationsAdapter$2
  implements View.OnClickListener
{
  TroopAssociationsAdapter$2(TroopAssociationsAdapter paramTroopAssociationsAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (AssociatedTroopItem)paramView.getTag();
    TroopAssociationsUtil.b(TroopAssociationsAdapter.a(this.a), (AssociatedTroopItem)localObject);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AssociatedTroopItem)localObject).uin)
    {
      ReportController.b(null, "dc00898", "", (String)localObject, "0X800B4B1", "0X800B4B1", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.TroopAssociationsAdapter.2
 * JD-Core Version:    0.7.0.1
 */