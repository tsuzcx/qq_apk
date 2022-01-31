package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import asvy;
import asvz;
import bdgm;
import bdjz;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$10
  implements Runnable
{
  public PresenceInterfaceImpl$10(asvy paramasvy, String paramString) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.this$0.a, 232, null, this.a, new asvz(this), null);
    try
    {
      localbdjz.show();
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