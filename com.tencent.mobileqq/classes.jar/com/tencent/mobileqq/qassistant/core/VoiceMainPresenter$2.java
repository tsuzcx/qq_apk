package com.tencent.mobileqq.qassistant.core;

import android.app.Instrumentation;
import bakz;
import com.tencent.qphone.base.util.QLog;

public class VoiceMainPresenter$2
  implements Runnable
{
  public VoiceMainPresenter$2(bakz parambakz) {}
  
  public void run()
  {
    try
    {
      new Instrumentation().sendKeyDownUpSync(4);
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