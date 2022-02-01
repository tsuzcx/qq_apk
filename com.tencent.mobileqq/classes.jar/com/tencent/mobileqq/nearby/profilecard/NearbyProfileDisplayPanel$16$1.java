package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
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
    if (paramInt == 0)
    {
      if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).nowUserType == 1)
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new NearbyProfileDisplayPanel.16.1.1(this), 500L);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.f = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.uin;
      paramView = (View)localObject;
      if (StringUtil.a((String)localObject))
      {
        paramView = (View)localObject;
        if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null) {
          paramView = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).uin;
        }
      }
      if (StringUtil.a(paramView)) {
        paramView = "0";
      }
      long l;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.mTinyId == 0L)
      {
        if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null) {
          l = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).tinyId;
        } else {
          l = 0L;
        }
      }
      else {
        l = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.mTinyId;
      }
      if ((!"0".equals(paramView)) || (l != 0L))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app != null) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app.getHotChatMng(false);
        } else {
          localObject = null;
        }
        if (((localObject == null) || (!((HotChatManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.troopUin))) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.profileEntryType != 33) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.profileEntryType != 4) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.profileEntryType != 31))
        {
          localObject = null;
          paramInt = 20003;
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.troopUin;
          paramInt = 20012;
        }
        NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.mTinyId, paramView, (String)localObject, paramInt, "", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.reportExtra);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
      if ((NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a) != null) && (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).iIsGodFlag == 1)) {
        if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).gender == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
        } else if (NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a).gender == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "dc00899", "grp_lbs", NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a), "data_card", "clk_report", 0, 0, "", "", "", "");
      if (ProfileEntryUtils.isFromHotChat(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.allinone.profileEntryType)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$16.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
      }
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.16.1
 * JD-Core Version:    0.7.0.1
 */