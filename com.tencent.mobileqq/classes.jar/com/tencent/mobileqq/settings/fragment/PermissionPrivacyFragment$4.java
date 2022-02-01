package com.tencent.mobileqq.settings.fragment;

import android.app.Activity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;

class PermissionPrivacyFragment$4
  implements Runnable
{
  PermissionPrivacyFragment$4(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void run()
  {
    if (PermissionPrivacyFragment.a(this.this$0) == null) {
      return;
    }
    Object localObject = (FriendsManager)PermissionPrivacyFragment.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).e();
      if (localObject != null)
      {
        int i = ((List)localObject).size();
        localObject = PermissionPrivacyFragment.a(this.this$0);
        if (localObject == null) {
          return;
        }
        ((Activity)localObject).runOnUiThread(new PermissionPrivacyFragment.4.1(this, i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.4
 * JD-Core Version:    0.7.0.1
 */