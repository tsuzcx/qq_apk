package com.tencent.mobileqq.newfriend.ui.fragment;

import android.os.Message;
import mqq.os.MqqHandler;

class NewFriendVerifyBlockedListFragment$1
  extends MqqHandler
{
  NewFriendVerifyBlockedListFragment$1(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    NewFriendVerifyBlockedListFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.1
 * JD-Core Version:    0.7.0.1
 */