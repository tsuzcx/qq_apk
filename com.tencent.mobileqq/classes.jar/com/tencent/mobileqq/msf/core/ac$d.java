package com.tencent.mobileqq.msf.core;

import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

class ac$d
  implements Runnable
{
  int a = 0;
  
  public ac$d(ac paramac, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject1).append("/tencent/msflogs/com/tencent/mobileqq/com.tencent.mobileqq_logcat_");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(QLog.getLogFileFormatter().format(Long.valueOf(l)));
      ((StringBuilder)localObject1).append(".log");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start to store logcat ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logcat -b main -b system -b radio -b events -v time -f ");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start to execute command ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject1).getErrorStream()));
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("logcat storage error:");
        localStringBuilder.append((String)localObject2);
        QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
      }
      ((BufferedReader)localObject1).close();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to store logcat ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac.d
 * JD-Core Version:    0.7.0.1
 */