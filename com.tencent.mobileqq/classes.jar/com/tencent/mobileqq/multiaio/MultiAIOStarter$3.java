package com.tencent.mobileqq.multiaio;

import android.os.Vibrator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

final class MultiAIOStarter$3
  implements Runnable
{
  public void run()
  {
    try
    {
      ((Vibrator)this.a.getSystemService("vibrator")).vibrate(20L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOStarter", 2, "viratorExecute Vibrator exception.");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter.3
 * JD-Core Version:    0.7.0.1
 */