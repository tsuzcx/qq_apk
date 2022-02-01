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
    ((IPhoneContactService)this.this$0.d.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(((PhoneContactAddMessage)this.this$0.g).a);
    this.this$0.d.runOnUiThread(new PhoneContactAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */