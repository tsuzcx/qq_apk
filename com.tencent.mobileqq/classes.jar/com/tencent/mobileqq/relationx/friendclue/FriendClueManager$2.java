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
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueManager", 2, String.format("the result of onCardDownload is:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    FriendClueManager.a(this.a).removeMessages(1);
    FriendClueManager.a(this.a).removeObserver(this.a.a);
    if (paramBoolean)
    {
      Card localCard = null;
      if ((paramObject instanceof Card)) {
        localCard = (Card)paramObject;
      }
      if (localCard != null)
      {
        paramObject = new Message();
        paramObject.obj = localCard;
        paramObject.what = 2;
        FriendClueManager.a(this.a).sendMessage(paramObject);
      }
    }
    else
    {
      FriendClueManager.a(this.a).post(new FriendClueManager.2.1(this));
      QLog.e("FriendClueManager", 1, "get intimateInfo failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueManager.2
 * JD-Core Version:    0.7.0.1
 */