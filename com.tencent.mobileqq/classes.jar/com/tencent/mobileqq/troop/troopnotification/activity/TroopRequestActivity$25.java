package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRequestActivity$25
  implements View.OnClickListener
{
  TroopRequestActivity$25(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    TroopRequestActivity.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, "close warning tips");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.25
 * JD-Core Version:    0.7.0.1
 */