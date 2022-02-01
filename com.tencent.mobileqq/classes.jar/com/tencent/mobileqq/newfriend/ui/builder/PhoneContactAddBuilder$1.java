package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class PhoneContactAddBuilder$1
  implements Runnable
{
  PhoneContactAddBuilder$1(PhoneContactAddBuilder paramPhoneContactAddBuilder) {}
  
  public void run()
  {
    ((IPhoneContactService)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(((PhoneContactAddMessage)this.this$0.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a);
    this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new PhoneContactAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */