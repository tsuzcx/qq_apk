package com.tencent.mobileqq.troop.filemanager.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileItem$1
  implements View.OnClickListener
{
  TroopFileItem$1(TroopFileItem paramTroopFileItem) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileItem.1
 * JD-Core Version:    0.7.0.1
 */