package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.GiftConfigManager.TextEntryItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyProfileFragment$5
  implements View.OnClickListener
{
  NearbyProfileFragment$5(NearbyProfileFragment paramNearbyProfileFragment, GiftConfigManager.TextEntryItem paramTextEntryItem) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView = paramView.b;
    } else {
      paramView = "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501";
    }
    Intent localIntent = new Intent(this.b.c, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    localIntent.putExtra("url", paramView);
    this.b.c.startActivity(localIntent);
    ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.5
 * JD-Core Version:    0.7.0.1
 */