package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$10
  extends LBSObserver
{
  PermissionPrivacyFragment$10(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateGetSwitch| isSuc = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", userType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", curSwitch = ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("PermissionPrivacyFragment", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateSetShareStatus| isSuc = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", beShare = ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("PermissionPrivacyFragment", 2, localStringBuilder.toString());
    }
    if (!paramBoolean1) {
      this.a.a(2131718834, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.10
 * JD-Core Version:    0.7.0.1
 */