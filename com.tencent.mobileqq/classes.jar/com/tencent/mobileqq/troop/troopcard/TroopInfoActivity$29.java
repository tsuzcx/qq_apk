package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

class TroopInfoActivity$29
  implements View.OnClickListener
{
  TroopInfoActivity$29(TroopInfoActivity paramTroopInfoActivity, XListView paramXListView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.b = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.29
 * JD-Core Version:    0.7.0.1
 */