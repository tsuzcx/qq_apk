package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import avdh;
import avdi;
import bglp;
import bgpa;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$10
  implements Runnable
{
  public PresenceInterfaceImpl$10(avdh paramavdh, String paramString) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.this$0.a, 232, null, this.a, new avdi(this), null);
    try
    {
      localbgpa.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PresenceInterfaceImpl", 2, "show dialog fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.10
 * JD-Core Version:    0.7.0.1
 */