import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class spt
  implements ActionSheet.OnButtonClickListener
{
  spt(spp paramspp, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      ReportController.b(this.jdField_a_of_type_Spp.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(this.jdField_a_of_type_Spp.a.app, this.jdField_a_of_type_Spp.a.app.getCurrentAccountUin()));
      if ((this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.j) || (this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId));
      }
      if ((this.jdField_a_of_type_Spp.a.d == 160L) || (this.jdField_a_of_type_Spp.a.d == 1600L) || ((ProfileCardUtil.d(this.jdField_a_of_type_Spp.a.jdField_a_of_type_JavaUtilArrayList)) && (this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.cardType != 2)) || (this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.h) || ((this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)))
      {
        Toast.makeText(this.jdField_a_of_type_Spp.a.getApplicationContext(), 2131436755, 0).show();
      }
      else if ((!TextUtils.isEmpty(this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.diyText)) && (this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.diyTextFontId != 0))
      {
        this.jdField_a_of_type_Spp.a.o();
      }
      else
      {
        this.jdField_a_of_type_Spp.a.a(this.jdField_a_of_type_Spp.a.c, this.jdField_a_of_type_Spp.a.d, this.jdField_a_of_type_Spp.a.e, this.jdField_a_of_type_Spp.a.b);
        continue;
        ReportController.b(this.jdField_a_of_type_Spp.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(this.jdField_a_of_type_Spp.a.app, this.jdField_a_of_type_Spp.a.app.getCurrentAccountUin()));
        if ((this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.j) || (this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId == ProfileCardTemplate.i)) {
          VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.a(), String.valueOf(this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentBgId), String.valueOf(this.jdField_a_of_type_Spp.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.lCurrentStyleId));
        }
        String str1 = "";
        Object localObject = this.jdField_a_of_type_Spp.a.b();
        paramView = str1;
        if (localObject != null)
        {
          paramView = str1;
          if (((String)localObject).equals("CustomCover")) {
            paramView = "oldCustom=1";
          }
        }
        localObject = this.jdField_a_of_type_Spp.a;
        String str2 = this.jdField_a_of_type_Spp.a.app.getCurrentAccountUin();
        if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
        for (str1 = "inside.friendCardBackground";; str1 = "inside.blackBar")
        {
          ProfileCardUtil.a((Activity)localObject, str2, str1, 1, 1, 1, paramView, false);
          break;
        }
        ReportController.b(this.jdField_a_of_type_Spp.a.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(this.jdField_a_of_type_Spp.a.app, this.jdField_a_of_type_Spp.a.app.getCurrentAccountUin()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spt
 * JD-Core Version:    0.7.0.1
 */