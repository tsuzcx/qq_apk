package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyProfileDisplayTribePanel$11
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$11(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.e, QQBrowserActivity.class);
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.a.e.startActivity(paramView);
    ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.11
 * JD-Core Version:    0.7.0.1
 */