package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

class NearbyProfileDisplayTribePanel$9
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$9(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.b.e, QQBrowserActivity.class);
    paramView = new StringBuilder();
    paramView.append(this.a);
    paramView.append("&type");
    paramView.append(NearbyProfileDisplayTribePanel.j(this.b).gender);
    ((Intent)localObject).putExtra("url", paramView.toString());
    paramView = HardCodeUtil.a(2131905109);
    if (this.b.e.mMode != 2)
    {
      if (NearbyProfileDisplayTribePanel.j(this.b).gender == 0) {
        paramView = HardCodeUtil.a(2131905173);
      } else {
        paramView = HardCodeUtil.a(2131905204);
      }
    }
    else
    {
      if (this.b.e.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((INearbyCardManager)this.b.e.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(this.b.e.app.getCurrentAccountUin(), Integer.valueOf(1));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView);
    localStringBuilder.append(HardCodeUtil.a(2131905221));
    ((Intent)localObject).putExtra("title", localStringBuilder.toString());
    this.b.e.startActivity((Intent)localObject);
    localObject = this.b.e.app;
    if (this.b.e.mMode == 2) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.9
 * JD-Core Version:    0.7.0.1
 */