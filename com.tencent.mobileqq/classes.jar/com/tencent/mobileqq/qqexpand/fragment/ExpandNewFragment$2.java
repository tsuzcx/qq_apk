package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;

class ExpandNewFragment$2
  extends ExpandObserver
{
  ExpandNewFragment$2(ExpandNewFragment paramExpandNewFragment) {}
  
  protected void a(int paramInt)
  {
    MatchChatMsgUtil.a(ExpandNewFragment.a(this.a), ExpandNewFragment.a(this.a));
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment.2
 * JD-Core Version:    0.7.0.1
 */