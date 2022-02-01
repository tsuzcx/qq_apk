package com.tencent.mobileqq.matchchat;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import mqq.os.MqqHandler;

class MatchChatMsgListFragment$7
  extends AvatarObserver
{
  MatchChatMsgListFragment$7(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.a.getCurrentAccountUin())) && (this.a.isAdded()) && (this.a.b != null))
    {
      this.a.b.removeMessages(1);
      this.a.b.sendEmptyMessage(1);
    }
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.7
 * JD-Core Version:    0.7.0.1
 */