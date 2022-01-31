package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import asrp;
import asrq;
import bdcd;
import bdfq;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$10
  implements Runnable
{
  public PresenceInterfaceImpl$10(asrp paramasrp, String paramString) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.this$0.a, 232, null, this.a, new asrq(this), null);
    try
    {
      localbdfq.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PresenceInterfaceImpl", 2, "show dialog fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.10
 * JD-Core Version:    0.7.0.1
 */