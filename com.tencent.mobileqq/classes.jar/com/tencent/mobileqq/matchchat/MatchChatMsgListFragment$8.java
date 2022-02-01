package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class MatchChatMsgListFragment$8
  extends FriendListObserver
{
  MatchChatMsgListFragment$8(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, "onUpdateFriendInfo uin =" + paramString);
      }
      int i = 0;
      if (this.a.a(paramString)) {
        i = 1;
      }
      if (i != 0) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.8
 * JD-Core Version:    0.7.0.1
 */