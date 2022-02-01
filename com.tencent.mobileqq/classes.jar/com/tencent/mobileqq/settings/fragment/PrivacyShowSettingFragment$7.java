package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class PrivacyShowSettingFragment$7
  extends FriendListObserver
{
  PrivacyShowSettingFragment$7(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      PrivacyShowSettingFragment localPrivacyShowSettingFragment = this.a;
      PrivacyShowSettingFragment.a(localPrivacyShowSettingFragment, PrivacyShowSettingFragment.c(localPrivacyShowSettingFragment).a(), paramBoolean2);
    }
  }
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131718834, 1);
    }
    PrivacyShowSettingFragment localPrivacyShowSettingFragment = this.a;
    PrivacyShowSettingFragment.a(localPrivacyShowSettingFragment, PrivacyShowSettingFragment.c(localPrivacyShowSettingFragment).a(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */