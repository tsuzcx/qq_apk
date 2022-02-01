package com.tencent.mobileqq.troop.troopcreate.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CateListAdapter$ViewHolder$1
  implements View.OnClickListener
{
  CateListAdapter$ViewHolder$1(CateListAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    TroopCateListProvider.TroopCateInfo localTroopCateInfo = (TroopCateListProvider.TroopCateInfo)paramView.getTag();
    int i = localTroopCateInfo.b;
    String str1 = "";
    if (i == 1)
    {
      this.a.a.a.a(localTroopCateInfo.a, null);
      if (localTroopCateInfo.a != null) {
        str1 = localTroopCateInfo.a;
      }
      ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str1, "", "", "");
    }
    else
    {
      this.a.a.a.a(localTroopCateInfo.d, localTroopCateInfo.a);
      String str2;
      if (localTroopCateInfo.d == null) {
        str2 = "";
      } else {
        str2 = localTroopCateInfo.d;
      }
      if (localTroopCateInfo.a != null) {
        str1 = localTroopCateInfo.a;
      }
      ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str2, str1, "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.CateListAdapter.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */