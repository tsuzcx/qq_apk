package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azos;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public final class ProcessInfoUtil$1
  implements Runnable
{
  public ProcessInfoUtil$1(String paramString) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = azos.a();
    int i;
    if (localSharedPreferences != null)
    {
      i = azos.a(BaseApplicationImpl.getContext(), this.a);
      if (i != -1) {
        break label27;
      }
    }
    label27:
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      localSharedPreferences.edit().putInt("pid" + this.a, i);
      localSharedPreferences.edit().putLong("start_time" + this.a, l).apply();
    } while (!QLog.isColorLevel());
    QLog.d("ProcessUtils", 2, "recordProcessStart - " + this.a + ":" + i + "|" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.ProcessInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */