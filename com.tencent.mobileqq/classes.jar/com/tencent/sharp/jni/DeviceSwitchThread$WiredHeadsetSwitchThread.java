package com.tencent.sharp.jni;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

class DeviceSwitchThread$WiredHeadsetSwitchThread
  extends DeviceSwitchThread
{
  DeviceSwitchThread$WiredHeadsetSwitchThread(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public void e()
  {
    a(false);
    b(true);
    d();
    int i = 0;
    while (this.b)
    {
      if (TraeUtils.a()) {
        a(false);
      }
      long l;
      if (i < 5) {
        l = 1000L;
      } else {
        l = 4000L;
      }
      try
      {
        Thread.sleep(l);
      }
      catch (InterruptedException localInterruptedException)
      {
        if (QLog.isColorLevel())
        {
          String str = DeviceSwitchThread.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("WiredHeadsetSwitchThread InterruptedException[");
          localStringBuilder.append(localInterruptedException.getMessage());
          localStringBuilder.append("]");
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread.WiredHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */