package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.style.LinkSpan;
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
    label228:
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131362366: 
    case 2131362367: 
    case 2131362362: 
    case 2131362368: 
    case 2131362365: 
    case 2131362363: 
    case 2131362371: 
    case 2131362364: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
        continue;
        TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_p_of_type_Int == 2)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131689578, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.b[0] != null) {
            break label386;
          }
        }
        for (paramInt = 1;; paramInt = 3)
        {
          ReportController.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
          break;
          paramView = new SearchResultItem();
          paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].b);
          try
          {
            if ((QidianManager.b(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_l_of_type_Int)) || (QidianManager.c(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_l_of_type_Int))) {
              paramView.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].jdField_p_of_type_JavaLangString);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
          }
          paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0].c;
          AddFriendActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, 1);
          break label228;
        }
        if (this.b[0].jdField_p_of_type_Int == 3)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693555, 0).a();
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] != null) {
            break label529;
          }
        }
        for (paramInt = 1;; paramInt = 3)
        {
          ReportController.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
          break;
          if (this.b[0].jdField_q_of_type_Int == 1)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131693554, 0).a();
            break label419;
          }
          paramView = TroopInfoActivity.a(this.b[0].b, this.b[0].jdField_q_of_type_JavaLangString, 105);
          TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, 2);
          break label419;
        }
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", UinSearcher.c(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
        continue;
        LinkSpan.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
        continue;
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, "1110436437", this.c[0].o, null, null, null, 2111, null);
        if (this.c[0].m.equals("#808080"))
        {
          paramView = "0X800B0C1";
          if (!this.c[0].m.equals("#808080")) {
            break label893;
          }
          localObject = this.c[0].k;
          if (!this.c[0].m.equals("#808080")) {
            break label899;
          }
        }
        for (String str = this.c[0].jdField_l_of_type_JavaLangString;; str = "")
        {
          if (QLog.isColorLevel()) {
            QLog.d("UinSearcher", 2, "clickEvent TValue r4 r5: " + paramView + ", " + (String)localObject + ", " + str);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, UinSearcher.a(UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a)), 0, "", "", (String)localObject, str);
          break;
          paramView = "0X800B0C2";
          break label739;
          localObject = "";
          break label766;
        }
        ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), UinSearcher.d(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", UinSearcher.b(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), 0, "", "", "", "");
      }
    case 2131362369: 
      label386:
      label419:
      label739:
      label766:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileCardActivity.class);
      label529:
      label893:
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      label899:
      ((ProfileActivity.AllInOne)localObject).h = 124;
      paramView.putExtra("AllInOne", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.b[0] == null) {}
      for (paramInt = 1;; paramInt = 3)
      {
        ReportController.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
        break;
      }
    }
    paramView = new Intent();
    paramView.putExtra("troop_code", ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString).troopcode);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView.getExtras(), 1);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] == null) {}
    for (paramInt = 1;; paramInt = 3)
    {
      ReportController.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.1
 * JD-Core Version:    0.7.0.1
 */