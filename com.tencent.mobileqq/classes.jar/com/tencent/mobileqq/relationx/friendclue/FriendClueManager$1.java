package com.tencent.mobileqq.relationx.friendclue;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;

class FriendClueManager$1
  implements Runnable
{
  FriendClueManager$1(FriendClueManager paramFriendClueManager) {}
  
  public void run()
  {
    String str = FriendClueManager.a(this.this$0).getResources().getString(2131916775);
    QQToast.makeText(FriendClueManager.a(this.this$0), 1, str, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueManager.1
 * JD-Core Version:    0.7.0.1
 */