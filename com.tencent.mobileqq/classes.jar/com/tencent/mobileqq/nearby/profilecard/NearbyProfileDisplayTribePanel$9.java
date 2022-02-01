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
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a, QQBrowserActivity.class);
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_JavaLangString);
    paramView.append("&type");
    paramView.append(NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender);
    ((Intent)localObject).putExtra("url", paramView.toString());
    paramView = HardCodeUtil.a(2131707283);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.mMode != 2)
    {
      if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender == 0) {
        paramView = HardCodeUtil.a(2131707352);
      } else {
        paramView = HardCodeUtil.a(2131707386);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getCurrentAccountUin(), Integer.valueOf(1));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView);
    localStringBuilder.append(HardCodeUtil.a(2131707403));
    ((Intent)localObject).putExtra("title", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.startActivity((Intent)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.mMode == 2) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.9
 * JD-Core Version:    0.7.0.1
 */