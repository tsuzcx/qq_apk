package com.tencent.mobileqq.troop.createNewTroop;

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
    Object localObject = (TroopCateListProvider.TroopCateInfo)paramView.getTag();
    String str;
    if (((TroopCateListProvider.TroopCateInfo)localObject).b == 1)
    {
      this.a.a.a.a(((TroopCateListProvider.TroopCateInfo)localObject).a, null);
      if (((TroopCateListProvider.TroopCateInfo)localObject).a == null) {}
      for (str = "";; str = ((TroopCateListProvider.TroopCateInfo)localObject).a)
      {
        ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.a(((TroopCateListProvider.TroopCateInfo)localObject).d, ((TroopCateListProvider.TroopCateInfo)localObject).a);
    if (((TroopCateListProvider.TroopCateInfo)localObject).d == null)
    {
      str = "";
      label114:
      if (((TroopCateListProvider.TroopCateInfo)localObject).a != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((TroopCateListProvider.TroopCateInfo)localObject).a)
    {
      ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((TroopCateListProvider.TroopCateInfo)localObject).d;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */