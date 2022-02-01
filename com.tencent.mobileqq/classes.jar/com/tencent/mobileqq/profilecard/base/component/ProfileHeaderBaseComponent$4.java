package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class ProfileHeaderBaseComponent$4
  extends ProfileHeaderBaseComponent.ActionSheetItem
{
  ProfileHeaderBaseComponent$4(ProfileHeaderBaseComponent paramProfileHeaderBaseComponent, int paramInt)
  {
    super(paramInt);
  }
  
  public void onClick()
  {
    this.this$0.enterCustomCover();
    VasWebviewUtil.reportCommercialDrainage(ProfileHeaderBaseComponent.access$1600(this.this$0).getCurrentAccountUin(), "defaultcard", "click_customized", "", 1, 0, 0, "", "", "");
    ProfileHeaderBaseComponent.access$1100(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.4
 * JD-Core Version:    0.7.0.1
 */