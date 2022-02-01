package com.tencent.mobileqq.phonecontact.handler;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class ContactBindServlet$1
  implements Runnable
{
  ContactBindServlet$1(ContactBindServlet paramContactBindServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.ContactBindServlet", 2, "handleQueryContactV3 run in Threadmanager");
    }
    try
    {
      ContactBindServlet.a(this.this$0, this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("IMCore.PhoneContact.ContactBindServlet", 1, "handleQueryContactV3 fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.handler.ContactBindServlet.1
 * JD-Core Version:    0.7.0.1
 */