package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class MatchChatMsgListFragment$7
  extends FriendListObserver
{
  MatchChatMsgListFragment$7(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateFriendInfo uin =");
        localStringBuilder.append(paramString);
        QLog.d("MatchChatMsgListFragment", 2, localStringBuilder.toString());
      }
      if (this.a.a(paramString)) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.7
 * JD-Core Version:    0.7.0.1
 */