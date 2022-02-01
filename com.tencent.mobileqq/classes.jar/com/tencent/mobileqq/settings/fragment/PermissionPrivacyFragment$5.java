package com.tencent.mobileqq.settings.fragment;

import android.app.Activity;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;

class PermissionPrivacyFragment$5
  implements Runnable
{
  PermissionPrivacyFragment$5(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void run()
  {
    int i = FriendIntimateRelationshipHelper.a(PermissionPrivacyFragment.b(this.this$0));
    Activity localActivity = PermissionPrivacyFragment.c(this.this$0);
    if (localActivity == null) {
      return;
    }
    localActivity.runOnUiThread(new PermissionPrivacyFragment.5.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.5
 * JD-Core Version:    0.7.0.1
 */