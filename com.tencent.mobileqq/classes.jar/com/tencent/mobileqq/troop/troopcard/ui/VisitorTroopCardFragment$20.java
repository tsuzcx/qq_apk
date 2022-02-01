package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VisitorTroopCardFragment$20
  implements View.OnClickListener
{
  VisitorTroopCardFragment$20(VisitorTroopCardFragment paramVisitorTroopCardFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.20
 * JD-Core Version:    0.7.0.1
 */