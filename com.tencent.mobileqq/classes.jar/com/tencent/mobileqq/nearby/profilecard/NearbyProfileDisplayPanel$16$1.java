package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileDisplayPanel$16$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileDisplayPanel$16$1(NearbyProfileDisplayPanel.16 param16, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
    if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).nowUserType == 1)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new NearbyProfileDisplayPanel.16.1.1(this), 500L);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.f = true;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject1;
    if (StringUtil.a((String)localObject1))
    {
      paramView = (View)localObject1;
      if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null) {
        paramView = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).uin;
      }
    }
    if (StringUtil.a(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_Long == 0L) {
        if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null)
        {
          l = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).tinyId;
          label203:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app.getHotChatMng(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt, "", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null) && (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).iIsGodFlag == 1))
          {
            if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).gender != 0) {
              break label673;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "dc00899", "grp_lbs", NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a), "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label203;
        l = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.jdField_a_of_type_Long;
        break label203;
        label673:
        if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).gender == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.16.1
 * JD-Core Version:    0.7.0.1
 */