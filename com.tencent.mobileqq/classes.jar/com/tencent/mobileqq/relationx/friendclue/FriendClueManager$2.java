package com.tencent.mobileqq.relationx.friendclue;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class FriendClueManager$2
  extends ProfileCardObserver
{
  FriendClueManager$2(FriendClueManager paramFriendClueManager) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueManager", 2, String.format("the result of onCardDownload is:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    FriendClueManager.a(this.a).removeMessages(1);
    FriendClueManager.a(this.a).removeObserver(this.a.a);
    if (paramBoolean) {
      if (!(paramObject instanceof Card)) {
        break label135;
      }
    }
    label135:
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if (paramObject != null)
      {
        Message localMessage = new Message();
        localMessage.obj = paramObject;
        localMessage.what = 2;
        FriendClueManager.a(this.a).sendMessage(localMessage);
      }
      return;
      FriendClueManager.a(this.a).post(new FriendClueManager.2.1(this));
      QLog.e("FriendClueManager", 1, "get intimateInfo failed");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueManager.2
 * JD-Core Version:    0.7.0.1
 */