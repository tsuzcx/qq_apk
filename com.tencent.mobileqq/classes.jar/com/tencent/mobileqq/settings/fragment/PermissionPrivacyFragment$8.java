package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;

class PermissionPrivacyFragment$8
  implements IStatusListener
{
  PermissionPrivacyFragment$8(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      PermissionPrivacyFragment.b(this.a, 2131916364);
    }
    PermissionPrivacyFragment localPermissionPrivacyFragment = this.a;
    PermissionPrivacyFragment.a(localPermissionPrivacyFragment, localPermissionPrivacyFragment.b.getSwitch(), PermissionPrivacyFragment.f(this.a).d());
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    PermissionPrivacyFragment localPermissionPrivacyFragment = this.a;
    PermissionPrivacyFragment.a(localPermissionPrivacyFragment, localPermissionPrivacyFragment.b.getSwitch(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.8
 * JD-Core Version:    0.7.0.1
 */