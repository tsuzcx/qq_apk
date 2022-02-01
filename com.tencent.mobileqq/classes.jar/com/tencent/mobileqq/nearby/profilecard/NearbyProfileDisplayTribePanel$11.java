package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayTribePanel$11
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$11(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.a.a.startActivity(localIntent);
    ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.11
 * JD-Core Version:    0.7.0.1
 */