package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

class NearbyProfileDisplayTribePanel$9
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$9(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender);
    String str = HardCodeUtil.a(2131707258);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.e != 2) {
      if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender == 0)
      {
        str = HardCodeUtil.a(2131707327);
        ((Intent)localObject).putExtra("title", str + HardCodeUtil.a(2131707378));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.e != 2) {
          break label276;
        }
      }
    }
    label276:
    for (str = "1";; str = "2")
    {
      ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = HardCodeUtil.a(2131707361);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.9
 * JD-Core Version:    0.7.0.1
 */