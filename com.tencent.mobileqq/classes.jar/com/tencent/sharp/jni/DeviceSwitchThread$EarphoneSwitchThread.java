package com.tencent.sharp.jni;

import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DeviceSwitchThread$EarphoneSwitchThread
  extends DeviceSwitchThread
{
  DeviceSwitchThread$EarphoneSwitchThread(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private boolean g()
  {
    boolean bool2 = this.f;
    boolean bool1 = true;
    if (!bool2) {
      return true;
    }
    SessionInfo localSessionInfo = VideoController.f().k();
    int i;
    if ((localSessionInfo != null) && ((localSessionInfo.g == 1) || (localSessionInfo.g == 2))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!VideoController.f().g()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void e()
  {
    a(false);
    d();
    int i = 0;
    while (this.g)
    {
      if ((TraeUtils.a()) && (g())) {
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
          String str = DeviceSwitchThread.f();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("EarphoneSwitchThread InterruptedException[");
          localStringBuilder.append(localInterruptedException.getMessage());
          localStringBuilder.append("]");
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread.EarphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */