package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyProfileDisplayTribePanel$7
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$7(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.e, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("&from=");
    if (NearbyProfileCardUtils.a(this.b.e.from)) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    localStringBuilder.append(paramView);
    localIntent.putExtra("url", localStringBuilder.toString());
    this.b.e.startActivity(localIntent);
    ReportController.b(this.b.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_fans", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.7
 * JD-Core Version:    0.7.0.1
 */