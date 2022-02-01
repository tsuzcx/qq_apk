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
  
  public void onClick(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131427927: 
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.a, "1110436437", this.f[0].F, null, null, null, 2111, null);
      if (this.f[0].D.equals("#808080")) {
        paramView = "0X800B0C1";
      } else {
        paramView = "0X800B0C2";
      }
      String str1;
      if (this.f[0].D.equals("#808080")) {
        str1 = this.f[0].A;
      } else {
        str1 = "";
      }
      String str2;
      if (this.f[0].D.equals("#808080")) {
        str2 = this.f[0].B;
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
      ReportController.b(this.c, "dc00898", "", "", paramView, paramView, UinSearcher.a(UinSearcher.f(this.h.a)), 0, "", "", str1, str2);
      break;
    case 2131427926: 
      paramView = new Intent();
      paramView.putExtra("troop_code", ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.b).troopcode);
      paramView.putExtra("troop_uin", this.b);
      TroopUtils.a(this.a, paramView.getExtras(), 1);
      paramView = this.c;
      if (this.d[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800AA6A", "0X800AA6A", paramInt, 0, "", "", "", "");
      break;
    case 2131427925: 
      paramView = new AllInOne(this.b, 1);
      paramView.profileEntryType = 124;
      ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(this.a, paramView);
      paramView = this.c;
      if (this.e[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800AA69", "0X800AA69", paramInt, 0, "", "", "", "");
      break;
    case 2131427924: 
      if (this.e[0].Z == 3)
      {
        QQToast.makeText(this.a, 0, 2131891064, 0).show();
      }
      else if (this.e[0].aa == 1)
      {
        QQToast.makeText(this.a, 0, 2131891063, 0).show();
      }
      else
      {
        paramView = TroopInfoUIUtil.a(this.e[0].b, this.e[0].T, 105);
        TroopUtils.a(this.a, paramView, 2);
      }
      paramView = this.c;
      if (this.d[0] == null) {
        paramInt = 1;
      } else {
        paramInt = 3;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800A929", "0X800A929", paramInt, 0, "", "", "", "");
      break;
    case 2131427923: 
      TextItemBuilder.a(this.c, (Activity)this.a, UinSearcher.j(this.h.a), UinSearcher.e(this.h.a));
      ReportController.b(this.c, "dc00898", "", "", "0X800A927", "0X800A927", UinSearcher.i(this.h.a), 0, "", "", "", "");
      break;
    case 2131427922: 
      ((ClipboardManager)this.a.getSystemService("clipboard")).setText(this.b);
      ReportController.b(this.c, "dc00898", "", "", "0X800A926", "0X800A926", UinSearcher.i(this.h.a), 0, "", "", "", "");
      break;
    case 2131427921: 
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.b);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      paramView.putExtra("big_brother_source_key", UinSearcher.k(this.h.a));
      this.a.startActivity(paramView);
      ReportController.b(this.c, "dc00898", "", "", "0X800A92A", "0X800A92A", UinSearcher.i(this.h.a), 0, "", "", "", "");
      break;
    case 2131427920: 
      ProfileCardUtil.a((Activity)this.a, this.c.getCurrentUin(), UinSearcher.l(this.h.a), UinSearcher.f(this.h.a), this.b);
      ReportController.b(this.c, "dc00898", "", "", "0X800A92C", "0X800A92C", UinSearcher.i(this.h.a), 0, "", "", "", "");
      break;
    case 2131427919: 
      LinkSpan.a(this.a, this.b);
      ReportController.b(this.c, "dc00898", "", "", "0X800A92B", "0X800A92B", UinSearcher.i(this.h.a), 0, "", "", "", "");
      break;
    case 2131427918: 
      if (this.d[0].Z == 2)
      {
        QQToast.makeText(this.a, 0, 2131886221, 0).show();
      }
      else
      {
        paramView = new SearchResultItem();
        paramView.a = Long.parseLong(this.d[0].b);
      }
      break;
    }
    try
    {
      if ((!QidianManager.b(this.d[0].O)) && (!QidianManager.c(this.d[0].O))) {
        break label1132;
      }
      paramView.a = Long.parseLong(this.d[0].P);
    }
    catch (Exception localException)
    {
      label1123:
      label1132:
      break label1123;
    }
    QLog.i("UinSearcher", 1, "qidian corp jump error");
    paramView.c = this.d[0].c;
    AddFriendActivity.startProfileCardActivity((Activity)this.a, paramView, this.c, false, 1);
    paramView = this.c;
    if (this.e[0] == null) {
      paramInt = 1;
    } else {
      paramInt = 3;
    }
    ReportController.b(paramView, "dc00898", "", "", "0X800A928", "0X800A928", paramInt, 0, "", "", "", "");
    this.g.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.1
 * JD-Core Version:    0.7.0.1
 */