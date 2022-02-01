package com.tencent.mobileqq.troop.filemanager.data;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileItem$3
  implements View.OnClickListener
{
  TroopFileItem$3(TroopFileItem paramTroopFileItem) {}
  
  public void onClick(View paramView)
  {
    this.a.b(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileItem.3
 * JD-Core Version:    0.7.0.1
 */