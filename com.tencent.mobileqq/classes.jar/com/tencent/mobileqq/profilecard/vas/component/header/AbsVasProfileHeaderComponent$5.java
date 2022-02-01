package com.tencent.mobileqq.profilecard.vas.component.header;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AbsVasProfileHeaderComponent$5
  implements ActionSheet.OnButtonClickListener
{
  AbsVasProfileHeaderComponent$5(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent, ActionSheet paramActionSheet, String paramString) {}
  
  private void enterPersonalityCardMall()
  {
    if (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5200(this.this$0)).b) {
      VasWebviewUtil.reportCommercialDrainage(AbsVasProfileHeaderComponent.access$5300(this.this$0).getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5400(this.this$0)).a.lCurrentStyleId == ProfileCardTemplate.j) || (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5500(this.this$0)).a.lCurrentStyleId == ProfileCardTemplate.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5600(this.this$0)).a.lCurrentBgId), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5700(this.this$0)).a.lCurrentStyleId));
    }
    String str2 = "";
    Object localObject = AbsVasProfileHeaderComponent.access$5800(this.this$0);
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((String)localObject).equals("CustomCover")) {
        str1 = "oldCustom=1";
      }
    }
    localObject = AbsVasProfileHeaderComponent.access$5900(this.this$0);
    String str3 = AbsVasProfileHeaderComponent.access$6000(this.this$0).getCurrentAccountUin();
    if (this.val$action.equals("CLICK_HEADER_BG")) {}
    for (str2 = "inside.friendCardBackground";; str2 = "inside.blackBar")
    {
      ProfileCardUtil.a((Activity)localObject, str3, str2, 1, 1, 1, str1, false);
      return;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AbsVasProfileHeaderComponent.access$1500(this.this$0) == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      ReportController.b(AbsVasProfileHeaderComponent.access$1600(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$1700(this.this$0), AbsVasProfileHeaderComponent.access$1800(this.this$0).getCurrentAccountUin()));
      if (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$1900(this.this$0)).b) {
        VasWebviewUtil.reportCommercialDrainage(AbsVasProfileHeaderComponent.access$2000(this.this$0).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2100(this.this$0)).a.lCurrentStyleId == ProfileCardTemplate.j) || (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2200(this.this$0)).a.lCurrentStyleId == ProfileCardTemplate.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2300(this.this$0)).a.lCurrentBgId), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2400(this.this$0)).a.lCurrentStyleId));
      }
      if ((((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2500(this.this$0)).a.lCurrentBgId == 160L) || (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2600(this.this$0)).a.lCurrentBgId == 1600L) || ((ProfileCardUtil.e(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2700(this.this$0)).a.getBgTypeArray())) && (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2800(this.this$0)).a.cardType != 2) && (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2900(this.this$0)).a.dynamicCardFlag != 1)))
      {
        Toast.makeText(AbsVasProfileHeaderComponent.access$3000(this.this$0), 2131695140, 0).show();
      }
      else if (ProfileCardTemplate.a(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3100(this.this$0)).a.lCurrentStyleId))
      {
        QVipUtils.a(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3200(this.this$0)).a, AbsVasProfileHeaderComponent.access$3300(this.this$0), AbsVasProfileHeaderComponent.access$3400(this.this$0));
        ReportController.b(AbsVasProfileHeaderComponent.access$3500(this.this$0), "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3600(this.this$0)).a.diyText)) && (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3700(this.this$0)).a.diyTextFontId != 0))
      {
        if ((this.this$0 instanceof VasProfileHeaderSimpleComponent)) {
          ((VasProfileHeaderSimpleComponent)this.this$0).goToDiyCardEditPage();
        }
      }
      else
      {
        AbsVasProfileHeaderComponent.access$4200(this.this$0, ((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3800(this.this$0)).a.lCurrentStyleId, ((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3900(this.this$0)).a.lCurrentBgId, ((ProfileCardInfo)AbsVasProfileHeaderComponent.access$4000(this.this$0)).a.backgroundColor, ((ProfileCardInfo)AbsVasProfileHeaderComponent.access$4100(this.this$0)).a.strExtInfo);
        ReportController.b(AbsVasProfileHeaderComponent.access$4300(this.this$0), "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        ReportController.b(AbsVasProfileHeaderComponent.access$4400(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$4500(this.this$0), AbsVasProfileHeaderComponent.access$4600(this.this$0).getCurrentAccountUin()));
        enterPersonalityCardMall();
        continue;
        ReportController.b(AbsVasProfileHeaderComponent.access$4700(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$4800(this.this$0), AbsVasProfileHeaderComponent.access$4900(this.this$0).getCurrentAccountUin()));
        if (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$5000(this.this$0)).b) {
          VasWebviewUtil.reportCommercialDrainage(AbsVasProfileHeaderComponent.access$5100(this.this$0).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.5
 * JD-Core Version:    0.7.0.1
 */