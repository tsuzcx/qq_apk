package com.tencent.mobileqq.qassistant.core;

import android.app.Instrumentation;
import com.tencent.qphone.base.util.QLog;

class VoiceMainPresenter$2
  implements Runnable
{
  VoiceMainPresenter$2(VoiceMainPresenter paramVoiceMainPresenter) {}
  
  public void run()
  {
    try
    {
      if (VoiceMainPresenter.c(this.this$0) == null) {
        VoiceMainPresenter.a(this.this$0, new Instrumentation());
      }
      VoiceMainPresenter.c(this.this$0).sendKeyDownUpSync(4);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBack exception = ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("VoiceMainPresenter", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.2
 * JD-Core Version:    0.7.0.1
 */