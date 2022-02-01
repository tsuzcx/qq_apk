package com.tencent.mobileqq.settings.fragment;

import android.app.Activity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

class PermissionPrivacyFragment$3
  implements Runnable
{
  PermissionPrivacyFragment$3(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void run()
  {
    Object localObject = ((FriendsManager)PermissionPrivacyFragment.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {}
    for (int i = 0;; i = ((ArrayList)localObject).size())
    {
      PermissionPrivacyFragment.a(this.this$0, i);
      localObject = PermissionPrivacyFragment.a(this.this$0);
      if (localObject != null) {
        break;
      }
      return;
    }
    ((Activity)localObject).runOnUiThread(new PermissionPrivacyFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.3
 * JD-Core Version:    0.7.0.1
 */