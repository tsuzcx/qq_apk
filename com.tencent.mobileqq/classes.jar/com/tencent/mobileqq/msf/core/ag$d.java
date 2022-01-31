package com.tencent.mobileqq.msf.core;

import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

class ag$d
  implements Runnable
{
  int a = 0;
  
  public ag$d(ag paramag, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/com.tencent.mobileqq_logcat_" + this.a + "_" + QLog.getLogFileFormatter().format(Long.valueOf(l)) + ".log";
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "start to store logcat " + (String)localObject);
      }
      localObject = "logcat -b main -b system -b radio -b events -v time -f " + (String)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "start to execute command " + (String)localObject);
      }
      localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject).getErrorStream()));
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        QLog.d("MSF.C.NetConnTag", 1, "logcat storage error:" + str);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to store logcat ", localException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag.d
 * JD-Core Version:    0.7.0.1
 */