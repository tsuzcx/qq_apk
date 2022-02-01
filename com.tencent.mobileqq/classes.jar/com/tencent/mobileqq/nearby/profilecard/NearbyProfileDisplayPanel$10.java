package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$10
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$10(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportTask localReportTask = new ReportTask(this.b.e.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(String.valueOf(this.b.f.tinyId));
    if (this.b.f.gender == 0) {
      paramView = "1";
    } else if (this.b.f.gender == 1) {
      paramView = "2";
    } else {
      paramView = "0";
    }
    localReportTask.a(new String[] { paramView }).a();
    if (this.a.startsWith("mqqapi:"))
    {
      paramView = JumpParser.a(this.b.e.app, this.b.b, this.a);
      if (paramView != null)
      {
        paramView.a();
        return;
      }
      paramView = new StringBuilder();
      paramView.append("ja==null, jumpUrl=");
      paramView.append(this.a);
      QLog.i("NearbyProfileDisplayPanel", 1, paramView.toString());
      return;
    }
    paramView = new Intent(this.b.e, QQBrowserActivity.class);
    paramView.putExtra("url", this.a);
    this.b.e.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.10
 * JD-Core Version:    0.7.0.1
 */