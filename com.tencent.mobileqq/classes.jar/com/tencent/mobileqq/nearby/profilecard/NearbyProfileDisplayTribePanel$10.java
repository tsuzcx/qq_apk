package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayTribePanel$10
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$10(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.a.a.startActivity(localIntent);
    NearbyProfileDisplayTribePanel.a(this.a, null);
    ThreadManager.post(new NearbyProfileDisplayTribePanel.10.1(this), 5, null, false);
    ReportController.b(this.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.10
 * JD-Core Version:    0.7.0.1
 */