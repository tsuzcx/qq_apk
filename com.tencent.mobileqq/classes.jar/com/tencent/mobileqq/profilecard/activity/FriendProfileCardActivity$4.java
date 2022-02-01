package com.tencent.mobileqq.profilecard.activity;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$4
  implements Handler.Callback
{
  FriendProfileCardActivity$4(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("handleMessage Sub msg=%s", new Object[] { paramMessage }));
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        if ((paramMessage.obj instanceof Card)) {
          paramMessage = (Card)paramMessage.obj;
        } else {
          paramMessage = FriendProfileCardActivity.access$500(this.this$0).card;
        }
        FriendProfileCardActivity.access$600(this.this$0, paramMessage, true, 3);
        return true;
      }
      FriendProfileCardActivity.access$400(this.this$0);
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    FriendProfileCardActivity.access$300(this.this$0, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.4
 * JD-Core Version:    0.7.0.1
 */