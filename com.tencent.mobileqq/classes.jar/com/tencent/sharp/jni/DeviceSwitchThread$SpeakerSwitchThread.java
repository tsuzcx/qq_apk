package com.tencent.sharp.jni;

import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DeviceSwitchThread$SpeakerSwitchThread
  extends DeviceSwitchThread
{
  DeviceSwitchThread$SpeakerSwitchThread(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public void e()
  {
    a(true);
    d();
    int i = 0;
    while (this.b)
    {
      String str;
      StringBuilder localStringBuilder;
      if (!TraeUtils.a())
      {
        if ((this.a) && (i > 4))
        {
          SessionInfo localSessionInfo = VideoController.a().a();
          if (!localSessionInfo.E)
          {
            str = DeviceSwitchThread.a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("SpeakerSwitchThread, 不需要打开扬声器, sessionInfo[");
            localStringBuilder.append(localSessionInfo);
            localStringBuilder.append("]");
            QLog.w(str, 1, localStringBuilder.toString());
            return;
          }
        }
        a(true);
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
          str = DeviceSwitchThread.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SpeakerSwitchThread InterruptedException[");
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
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread.SpeakerSwitchThread
 * JD-Core Version:    0.7.0.1
 */