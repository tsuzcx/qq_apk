package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class NearbyProfileDisplayTribePanel$13$1$1
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$13$1$1(NearbyProfileDisplayTribePanel.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(NearbyProfileDisplayTribePanel.j(this.a.b.this$0).strGodJumpUrl)) {
      return;
    }
    paramView = new Intent(this.a.b.this$0.e, QQBrowserActivity.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NearbyProfileDisplayTribePanel.j(this.a.b.this$0).strGodJumpUrl);
    ((StringBuilder)localObject).append("&gender=");
    int i;
    if (this.a.a == null) {
      i = 0;
    } else {
      i = this.a.a.shGender + 1;
    }
    ((StringBuilder)localObject).append(i);
    paramView.putExtra("url", ((StringBuilder)localObject).toString());
    this.a.b.this$0.e.startActivity(paramView);
    localObject = this.a.b.this$0.e.app;
    if (this.a.b.this$0.e.mMode == 2) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13.1.1
 * JD-Core Version:    0.7.0.1
 */