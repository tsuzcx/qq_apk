package com.tencent.mobileqq.newfriend.ui.adapter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class NewFriendMoreSysMsgAdapter$12
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$12(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((IPhoneContactService)this.this$0.a.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(((PhoneContactAddMessage)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.12
 * JD-Core Version:    0.7.0.1
 */