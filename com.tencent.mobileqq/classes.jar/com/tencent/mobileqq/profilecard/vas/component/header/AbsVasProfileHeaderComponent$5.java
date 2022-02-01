package com.tencent.mobileqq.profilecard.vas.component.header;

import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AbsVasProfileHeaderComponent$5
  implements ActionSheet.OnButtonClickListener
{
  AbsVasProfileHeaderComponent$5(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AbsVasProfileHeaderComponent.access$1500(this.this$0) == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          ReportController.b(AbsVasProfileHeaderComponent.access$3000(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$3100(this.this$0), AbsVasProfileHeaderComponent.access$3200(this.this$0).getCurrentAccountUin()));
          if (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$3300(this.this$0)).isTroopMemberCard) {
            VasWebviewUtil.a(AbsVasProfileHeaderComponent.access$3400(this.this$0).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
      else
      {
        ReportController.b(AbsVasProfileHeaderComponent.access$2600(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$2700(this.this$0), AbsVasProfileHeaderComponent.access$2800(this.this$0).getCurrentAccountUin()));
        AbsVasProfileHeaderComponent.access$2900(this.this$0, this.val$action);
      }
    }
    else
    {
      ReportController.b(AbsVasProfileHeaderComponent.access$1600(this.this$0), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(AbsVasProfileHeaderComponent.access$1700(this.this$0), AbsVasProfileHeaderComponent.access$1800(this.this$0).getCurrentAccountUin()));
      if (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$1900(this.this$0)).isTroopMemberCard) {
        VasWebviewUtil.a(AbsVasProfileHeaderComponent.access$2000(this.this$0).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2100(this.this$0)).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2200(this.this$0)).card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC)) {
        VasWebviewUtil.a("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2300(this.this$0)).card.lCurrentBgId), String.valueOf(((ProfileCardInfo)AbsVasProfileHeaderComponent.access$2400(this.this$0)).card.lCurrentStyleId));
      }
      AbsVasProfileHeaderComponent.access$2500(this.this$0);
    }
    this.val$actionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.5
 * JD-Core Version:    0.7.0.1
 */