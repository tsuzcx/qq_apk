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
    ((IPhoneContactService)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).deleteContactMatch(((ContactMatchMessage)this.this$0.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */