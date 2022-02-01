package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.widget.QQToast;

class ProfileTitleContainer$3
  extends ContactBindObserver
{
  ProfileTitleContainer$3(ProfileTitleContainer paramProfileTitleContainer) {}
  
  protected void onHideContact(boolean paramBoolean)
  {
    ProfileTitleContainer.access$900(this.this$0);
    if (!paramBoolean)
    {
      String str = HardCodeUtil.a(2131902912);
      QQToast.makeText(ProfileTitleContainer.access$1000(this.this$0), 1, str, 1000).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.3
 * JD-Core Version:    0.7.0.1
 */