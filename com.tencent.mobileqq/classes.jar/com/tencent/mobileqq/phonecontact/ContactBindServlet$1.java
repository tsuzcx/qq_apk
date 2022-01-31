package com.tencent.mobileqq.phonecontact;

import android.content.Intent;
import atoi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ContactBindServlet$1
  implements Runnable
{
  public ContactBindServlet$1(atoi paramatoi, Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Servlet", 2, "handleQueryContactV3 run in Threadmanager");
    }
    try
    {
      atoi.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Servlet", 1, "handleQueryContactV3 fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindServlet.1
 * JD-Core Version:    0.7.0.1
 */