package com.tencent.mobileqq.phonecontact.api.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class PhoneContactServiceImpl$4
  implements Runnable
{
  PhoneContactServiceImpl$4(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void run()
  {
    if (PhoneContactServiceImpl.access$400(this.this$0)) {
      return;
    }
    long l1 = PhoneContactServiceImpl.access$200(this.this$0).getLong("key_req_last_login_time", 0L);
    long l2 = PhoneContactServiceImpl.access$200(this.this$0).getLong("key_req_login_interval", 86400000L);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("checkLastLogin, lastReqTime = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", current = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(", interval = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", isRequesting = ");
      ((StringBuilder)localObject).append(PhoneContactServiceImpl.access$2900(this.this$0));
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((!PhoneContactServiceImpl.access$2900(this.this$0)) && (this.this$0.isBindContactOk()))
    {
      if (Math.abs(System.currentTimeMillis() - l1) < l2) {
        return;
      }
      PhoneContactServiceImpl.access$2902(this.this$0, true);
      localObject = new NewIntent(PhoneContactServiceImpl.access$300(this.this$0).getApplication(), ContactBindServlet.class);
      ((NewIntent)localObject).putExtra("req_type", 32);
      l1 = PhoneContactServiceImpl.access$200(this.this$0).getLong("key_login_info_timestamp", 0L);
      ((NewIntent)localObject).putExtra("next_flag", 0);
      ((NewIntent)localObject).putExtra("time_stamp", l1);
      ((NewIntent)localObject).putExtra("unique_phone_no", this.this$0.getUNIQUE_NO());
      PhoneContactServiceImpl.access$300(this.this$0).startServlet((NewIntent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */