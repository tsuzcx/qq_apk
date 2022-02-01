package com.tencent.mobileqq.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class HotChatFragment$1
  extends BroadcastReceiver
{
  HotChatFragment$1(HotChatFragment paramHotChatFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.refresh_hot_chat_list".equals(paramIntent.getAction())) && (this.a.b != null) && (this.a.b.mWebview != null)) {
      this.a.b.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment.1
 * JD-Core Version:    0.7.0.1
 */