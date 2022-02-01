package com.tencent.mobileqq.phonecontact.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

class PhoneContactServiceImpl$2$2
  implements Runnable
{
  PhoneContactServiceImpl$2$2(PhoneContactServiceImpl.2 param2) {}
  
  public void run()
  {
    try
    {
      PhoneContactServiceImpl.access$200(this.a.a).edit().putLong("contact_last_query_list_time", PhoneContactServiceImpl.access$700(this.a.a)).apply();
      if (QLog.isColorLevel())
      {
        QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("save last query time: %s", new Object[] { Long.valueOf(PhoneContactServiceImpl.access$700(this.a.a)) }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.2.2
 * JD-Core Version:    0.7.0.1
 */