package com.tencent.mobileqq.extendfriend.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class ExtendFriendSearchFragment$CancelReceiver
  extends BroadcastReceiver
{
  public ExtendFriendSearchFragment$CancelReceiver(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
      if (this.a.a != null) {
        this.a.a.finish();
      }
    }
    while ((!"com.tencent.mobileqq.search.finish".equals(paramIntent.getAction())) || (this.a.a == null)) {
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.CancelReceiver
 * JD-Core Version:    0.7.0.1
 */