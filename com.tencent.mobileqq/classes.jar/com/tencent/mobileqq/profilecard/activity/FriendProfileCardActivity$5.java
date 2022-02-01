package com.tencent.mobileqq.profilecard.activity;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$5
  implements Handler.Callback
{
  FriendProfileCardActivity$5(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      QLog.d("FriendProfileCardActivity", 2, String.format("handleMessage UI msg=%s", new Object[] { paramMessage }));
    }
    int i = paramMessage.what;
    Object localObject = null;
    switch (i)
    {
    default: 
      return true;
    case 103: 
      if (FriendProfileCardActivity.access$500(this.this$0).card != null)
      {
        FriendProfileCardActivity.access$500(this.this$0).isTimeOut = true;
        FriendProfileCardActivity.access$500(this.this$0).card.lCurrentStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
        FriendProfileCardActivity.access$500(this.this$0).card.templateRet = 0;
        FriendProfileCardActivity.access$500(this.this$0).currentTemplate = null;
        paramMessage = this.this$0;
        FriendProfileCardActivity.access$800(paramMessage, FriendProfileCardActivity.access$500(paramMessage).card, false);
        return true;
      }
      break;
    case 102: 
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      if ((paramMessage.obj instanceof Card))
      {
        paramMessage = (Card)paramMessage.obj;
        FriendProfileCardActivity.access$500(this.this$0).card = paramMessage;
        FriendProfileCardActivity.access$800(this.this$0, paramMessage, bool1);
        return true;
      }
      break;
    case 101: 
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      if ((paramMessage.obj instanceof ContactCard))
      {
        paramMessage = (ContactCard)paramMessage.obj;
        FriendProfileCardActivity.access$900(this.this$0, paramMessage, bool1);
        return true;
      }
      break;
    case 100: 
      String str;
      if ((paramMessage.obj instanceof Card))
      {
        paramMessage = (Card)paramMessage.obj;
        str = paramMessage.uin;
      }
      else
      {
        str = null;
        paramMessage = localObject;
      }
      if ((str != null) && (str.length() > 0)) {
        FriendProfileCardActivity.access$700(this.this$0, paramMessage, str);
      }
      break;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.5
 * JD-Core Version:    0.7.0.1
 */