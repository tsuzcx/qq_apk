package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class ProfileHeaderBaseComponent$3
  extends ProfileHeaderBaseComponent.ActionSheetItem
{
  ProfileHeaderBaseComponent$3(ProfileHeaderBaseComponent paramProfileHeaderBaseComponent, int paramInt)
  {
    super(paramInt);
  }
  
  public void onClick()
  {
    ProfileCardUtil.a(ProfileHeaderBaseComponent.access$1200(this.this$0), ProfileHeaderBaseComponent.access$1300(this.this$0).getCurrentAccountUin(), "inside.myCardButton", 1, 3, 1, "", true);
    ReportController.b(ProfileHeaderBaseComponent.access$1400(this.this$0), "CliOper", "", "", "card_mall", "0X8004DBF", 0, 0, "", "", "", "");
    VasWebviewUtil.a(ProfileHeaderBaseComponent.access$1500(this.this$0).getCurrentAccountUin(), "defaultcard", "click_card_mine", "", 1, 0, 0, "", "", "");
    ProfileHeaderBaseComponent.access$1100(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.3
 * JD-Core Version:    0.7.0.1
 */