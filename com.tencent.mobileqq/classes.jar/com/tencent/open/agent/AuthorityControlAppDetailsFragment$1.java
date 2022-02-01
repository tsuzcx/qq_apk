package com.tencent.open.agent;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$1
  extends BroadcastReceiver
{
  AuthorityControlAppDetailsFragment$1(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("appId", 0L);
    long l2 = paramIntent.getLongExtra("launchTime", 0L);
    if ((l1 > 0L) && (AuthorityControlAppDetailsFragment.a(this.a) == l1) && (AuthorityControlAppDetailsFragment.b(this.a) < l2))
    {
      QLog.d("AuthorityControlAppDetailsActivity", 1, "mLaunchReceiver.onReceive: finish self");
      AuthorityControlAppDetailsFragment.a(this.a, true);
      AuthorityControlAppDetailsFragment.c(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.1
 * JD-Core Version:    0.7.0.1
 */