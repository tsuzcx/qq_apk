package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyProfileDisplayTribePanel$10
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$10(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.e, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.a.e.startActivity(paramView);
    NearbyProfileDisplayTribePanel.a(this.a, null);
    ThreadManager.post(new NearbyProfileDisplayTribePanel.10.1(this), 5, null, false);
    ReportController.b(this.a.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.10
 * JD-Core Version:    0.7.0.1
 */