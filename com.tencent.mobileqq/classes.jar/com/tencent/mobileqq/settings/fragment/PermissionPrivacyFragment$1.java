package com.tencent.mobileqq.settings.fragment;

import android.os.Handler;
import android.os.Message;

class PermissionPrivacyFragment$1
  extends Handler
{
  PermissionPrivacyFragment$1(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 2) {
      return;
    }
    PermissionPrivacyFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.1
 * JD-Core Version:    0.7.0.1
 */