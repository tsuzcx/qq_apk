package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class UinSearcher$1$1
  implements ActionSheet.OnButtonClickListener
{
  UinSearcher$1$1(UinSearcher.1 param1, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem2, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem3, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362327: 
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, "1110436437", this.c[0].o, null, null, null, 2111, null);
      if (this.c[0].m.equals("#808080")) {
        paramView = "0X800B0C1";
      } else {
        paramView = "0X800B0C2";
      }
      String str1;
      if (this.c[0].m.equals("#808080")) {
        str1 = this.c[0].k;
      } else {
        str1 = "";
      }
      String str2;
      if (this.c[0].m.equals("#808080")) {
        str2 = this.c[0].jdField_l_of_type_JavaLangString;
      } else {
        str2 = "";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clickEvent TValue r4 r5: ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(", ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", ");
        localStringBuilder.append(str2);
        QLog.d("UinSearcher", 2, localStringBuilder.toString());
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, UinSearcher.a(UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a)), 0, "", "", str1, str2);
      break;
    case 2131362326: 
      paramView = new Intent();
      paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString).troopcode);
      paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
      TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    case 2131362325: 
      paramView = new AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      paramView.profileEntryType = 124;
      ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(this.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.b[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
      break;
    case 2131362324: 
      if (this.b[0].jdField_p_of_type_Int == 3)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693510, 0).a();
      }
      else if (this.b[0].jdField_q_of_type_Int == 1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693509, 0).a();
      }
      else
      {
        paramView = TroopInfoUIUtil.a(this.b[0].b, this.b[0].jdField_q_of_type_JavaLangString, 105);
        TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
      break;
    case 2131362323: 
      TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      break;
    case 2131362322: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      break;
    case 2131362321: 
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      paramView.putExtra("big_brother_source_key", UinSearcher.c(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      break;
    case 2131362320: 
      ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), UinSearcher.d(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      break;
    case 2131362319: 
      LinkSpan.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      break;
    case 2131362318: 
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_p_of_type_Int == 2)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689610, 0).a();
      }
      else
      {
        paramView = new SearchResultItem();
        paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].b);
      }
      break;
    }
    try
    {
      if ((!QidianManager.b(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_l_of_type_Int)) && (!QidianManager.c(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_l_of_type_Int))) {
        break label1132;
      }
      paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_p_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      label1123:
      label1132:
      break label1123;
    }
    QLog.i("UinSearcher", 1, "qidian corp jump error");
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].c;
    AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.b[0] == null) {
      paramInt = 1;
    } else {
      paramInt = 3;
    }
    ReportController.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.1
 * JD-Core Version:    0.7.0.1
 */