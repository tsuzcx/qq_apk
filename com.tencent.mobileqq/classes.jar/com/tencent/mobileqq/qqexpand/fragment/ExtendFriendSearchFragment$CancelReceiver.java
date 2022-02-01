package com.tencent.mobileqq.qqexpand.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;

public class ExtendFriendSearchFragment$CancelReceiver
  extends BroadcastReceiver
{
  public ExtendFriendSearchFragment$CancelReceiver(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction()))
    {
      if (this.a.h != null) {
        this.a.h.finish();
      }
    }
    else if (("com.tencent.mobileqq.search.finish".equals(paramIntent.getAction())) && (this.a.h != null)) {
      this.a.h.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.CancelReceiver
 * JD-Core Version:    0.7.0.1
 */