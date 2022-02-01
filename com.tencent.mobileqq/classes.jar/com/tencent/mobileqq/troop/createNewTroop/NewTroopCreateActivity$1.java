package com.tencent.mobileqq.troop.createNewTroop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewTroopCreateActivity$1
  implements View.OnClickListener
{
  NewTroopCreateActivity$1(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity.1
 * JD-Core Version:    0.7.0.1
 */