package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ProfileTitleContainer$8
  implements ActionSheet.OnButtonClickListener
{
  ProfileTitleContainer$8(ProfileTitleContainer paramProfileTitleContainer, IPhoneContactService paramIPhoneContactService, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ProfileTitleContainer.access$2100(this.this$0, this.val$mPhoneContactService, this.val$isHiden);
      }
    }
    else {
      ProfileTitleContainer.access$2000(this.this$0);
    }
    this.val$actionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.8
 * JD-Core Version:    0.7.0.1
 */