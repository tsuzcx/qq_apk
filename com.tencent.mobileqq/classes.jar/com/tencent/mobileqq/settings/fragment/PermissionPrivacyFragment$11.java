package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$11
  extends IntimateInfoObserver
{
  PermissionPrivacyFragment$11(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPrivacyFragment", 2, "onBandIntimateRelationship");
    }
    PermissionPrivacyFragment.g(this.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramString, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPrivacyFragment", 2, "onDisbandIntimateRelationship");
    }
    PermissionPrivacyFragment.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.11
 * JD-Core Version:    0.7.0.1
 */