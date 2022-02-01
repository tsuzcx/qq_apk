package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;

class ExtendFriendNewFragment$2
  extends ExtendFriendObserver
{
  ExtendFriendNewFragment$2(ExtendFriendNewFragment paramExtendFriendNewFragment) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    MatchChatMsgUtil.a(ExtendFriendNewFragment.a(this.a), ExtendFriendNewFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment.2
 * JD-Core Version:    0.7.0.1
 */