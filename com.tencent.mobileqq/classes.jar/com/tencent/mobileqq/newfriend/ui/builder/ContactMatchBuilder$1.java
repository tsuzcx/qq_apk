package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import mqq.os.MqqHandler;

class ContactMatchBuilder$1
  implements Runnable
{
  ContactMatchBuilder$1(ContactMatchBuilder paramContactMatchBuilder) {}
  
  public void run()
  {
    ((IPhoneContactService)this.this$0.d.getRuntimeService(IPhoneContactService.class, "")).deleteContactMatch(((ContactMatchMessage)this.this$0.g).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */