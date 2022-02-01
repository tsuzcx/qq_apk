package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$10
  extends LBSObserver
{
  PermissionPrivacyFragment$10(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPrivacyFragment", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPrivacyFragment", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131719116, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.10
 * JD-Core Version:    0.7.0.1
 */