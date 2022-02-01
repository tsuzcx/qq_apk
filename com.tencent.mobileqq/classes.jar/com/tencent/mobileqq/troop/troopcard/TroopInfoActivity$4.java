package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopInfoActivity$4
  implements View.OnClickListener
{
  TroopInfoActivity$4(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    TroopInfoActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.4
 * JD-Core Version:    0.7.0.1
 */