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
      if (VoiceMainPresenter.a(this.this$0) == null) {
        VoiceMainPresenter.a(this.this$0, new Instrumentation());
      }
      VoiceMainPresenter.a(this.this$0).sendKeyDownUpSync(4);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VoiceMainPresenter", 2, "onBack exception = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.2
 * JD-Core Version:    0.7.0.1
 */