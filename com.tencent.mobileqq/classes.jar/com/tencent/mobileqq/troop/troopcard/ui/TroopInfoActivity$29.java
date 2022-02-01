package com.tencent.mobileqq.troop.troopcard.ui;

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
    this.a.removeHeaderView(this.b.T);
    this.b.T = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.29
 * JD-Core Version:    0.7.0.1
 */