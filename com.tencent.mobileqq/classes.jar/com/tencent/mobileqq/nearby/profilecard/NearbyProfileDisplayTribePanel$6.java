package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyProfileDisplayTribePanel$6
  implements OnTagClickListener
{
  NearbyProfileDisplayTribePanel$6(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo.tagJumpUrl.equals("icon_more_url"))
    {
      paramView = new Intent(this.b.e, QQBrowserActivity.class);
      paramView.putExtra("url", this.a);
      this.b.e.startActivity(paramView);
      paramInterestTagInfo = this.b.e.app;
      if (this.b.e.mMode == 2) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      ReportController.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_more_tribe", 0, 0, paramView, "", "", "");
      return;
    }
    paramView = new Intent(this.b.e, QQBrowserActivity.class);
    paramView.putExtra("url", paramInterestTagInfo.tagJumpUrl);
    this.b.e.startActivity(paramView);
    paramInterestTagInfo = this.b.e.app;
    if (this.b.e.mMode == 2) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_tribe", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.6
 * JD-Core Version:    0.7.0.1
 */