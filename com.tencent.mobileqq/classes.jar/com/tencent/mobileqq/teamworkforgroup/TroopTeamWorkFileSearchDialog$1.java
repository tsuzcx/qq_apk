package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopTeamWorkFileSearchDialog$1
  implements View.OnClickListener
{
  TroopTeamWorkFileSearchDialog$1(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */