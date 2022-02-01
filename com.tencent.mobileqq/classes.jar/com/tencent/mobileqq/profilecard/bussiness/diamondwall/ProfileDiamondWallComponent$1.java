package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import QQService.PrivilegeInfo;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileDiamondWallComponent$1
  implements View.OnClickListener
{
  ProfileDiamondWallComponent$1(ProfileDiamondWallComponent paramProfileDiamondWallComponent) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof DataTag))
    {
      localObject1 = (DataTag)localObject1;
      switch (((DataTag)localObject1).jdField_a_of_type_Int)
      {
      }
    }
    Object localObject2;
    label295:
    label334:
    int i;
    PrivilegeInfo localPrivilegeInfo;
    label585:
    label632:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = ((ProfileCardInfo)ProfileDiamondWallComponent.access$000(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataCard.privilegeJumpUrl;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (((ProfileCardInfo)ProfileDiamondWallComponent.access$100(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label295;
          }
        }
        for (localObject1 = "https://mc.vip.qq.com/privilegelist/index";; localObject1 = "https://mc.vip.qq.com/privilegelist/other?friend=" + ((ProfileCardInfo)ProfileDiamondWallComponent.access$200(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)
        {
          localObject2 = new Intent(ProfileDiamondWallComponent.access$300(this.this$0), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_operation_bar", true);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          ProfileDiamondWallComponent.access$400(this.this$0).startActivity((Intent)localObject2);
          ReportController.b(ProfileDiamondWallComponent.access$500(this.this$0), "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
          if (((ProfileCardInfo)ProfileDiamondWallComponent.access$600(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label334;
          }
          ReportController.b(ProfileDiamondWallComponent.access$700(this.this$0), "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          ReportController.b(ProfileDiamondWallComponent.access$800(this.this$0), "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
          break;
        }
        ReportController.b(ProfileDiamondWallComponent.access$900(this.this$0), "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
        i = VipInfoHandler.a(ProfileDiamondWallComponent.access$1000(this.this$0), ProfileDiamondWallComponent.access$1100(this.this$0).getCurrentUin(), false);
        ReportController.b(ProfileDiamondWallComponent.access$1200(this.this$0), "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(i), "", "", "");
        continue;
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof PrivilegeInfo)) {
          break;
        }
        QLog.e("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + ((DataTag)localObject1).jdField_a_of_type_JavaLangObject);
      }
      localPrivilegeInfo = (PrivilegeInfo)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = localPrivilegeInfo.strJumpUrl;
      localObject2 = new Intent(ProfileDiamondWallComponent.access$1300(this.this$0), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ProfileDiamondWallComponent.access$1400(this.this$0).startActivity((Intent)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND click");
      }
      if (((ProfileCardInfo)ProfileDiamondWallComponent.access$1500(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      i = 1;
      switch (localPrivilegeInfo.iType)
      {
      default: 
        if (i == 0) {
          break label840;
        }
        localObject1 = "0X800A137";
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    label659:
    int j;
    String str;
    if (localPrivilegeInfo.iIsBig == 1) {
      if (localPrivilegeInfo.isOpen)
      {
        i = 1;
        localObject2 = "";
        if (localPrivilegeInfo.iType == 1)
        {
          j = VipInfoHandler.a(ProfileDiamondWallComponent.access$1600(this.this$0), ProfileDiamondWallComponent.access$1700(this.this$0).getCurrentUin(), false);
          str = String.valueOf(j);
          if ((!AnimatorHandler.playing) || (!ProfileDiamondWallComponent.access$1800(this.this$0, localPrivilegeInfo.iRemindTime, localPrivilegeInfo.iType))) {
            break label870;
          }
          ProfileDiamondWallComponent.access$1900(this.this$0, "0X800B27E", j);
          localObject2 = str;
        }
      }
    }
    for (;;)
    {
      ReportController.b(ProfileDiamondWallComponent.access$2000(this.this$0), "dc00898", "", "", "qvip", (String)localObject1, i, 0, (String)localObject2, "", "", "");
      break;
      i = 0;
      break label585;
      if (i != 0) {}
      for (localObject1 = "0X800A133";; localObject1 = "0X800A12B") {
        break;
      }
      if (i != 0) {}
      for (localObject1 = "0X800A135";; localObject1 = "0X800A12D") {
        break;
      }
      if (i != 0) {}
      for (localObject1 = "0X800A131";; localObject1 = "0X800A129") {
        break;
      }
      label840:
      localObject1 = "0X800A12F";
      break label632;
      i = 2;
      break label659;
      if (localPrivilegeInfo.isOpen)
      {
        i = 3;
        break label659;
      }
      i = 4;
      break label659;
      label870:
      localObject2 = str;
      if (AnimatorHandler.playing)
      {
        ProfileDiamondWallComponent.access$1900(this.this$0, "0X800B27C", j);
        localObject2 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent.1
 * JD-Core Version:    0.7.0.1
 */