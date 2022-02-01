package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;

class FriendListInnerFrame$1
  extends Handler
{
  FriendListInnerFrame$1(FriendListInnerFrame paramFriendListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.a.c.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.c.setPadding(0, 0, 40, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendListInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */