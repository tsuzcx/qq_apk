package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.FriendListObserver;

class BaseMsgBoxActivity$2
  extends FriendListObserver
{
  BaseMsgBoxActivity$2(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!this.a.a) {
      return;
    }
    this.a.runOnUiThread(new BaseMsgBoxActivity.2.1(this, paramBoolean, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.2
 * JD-Core Version:    0.7.0.1
 */