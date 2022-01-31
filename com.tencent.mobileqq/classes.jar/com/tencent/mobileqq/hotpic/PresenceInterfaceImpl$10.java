package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import araz;
import arba;
import bbcv;
import bbgg;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$10
  implements Runnable
{
  public PresenceInterfaceImpl$10(araz paramaraz, String paramString) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(this.this$0.a, 232, null, this.a, new arba(this), null);
    try
    {
      localbbgg.show();
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