package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopBarPublishActivity$19
  implements View.OnClickListener
{
  TroopBarPublishActivity$19(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    QQToast.a(this.a.a, HardCodeUtil.a(2131715082), 0).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.19
 * JD-Core Version:    0.7.0.1
 */