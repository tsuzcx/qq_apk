package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class u
  extends Thread
{
  u(n paramn, String paramString) {}
  
  void a(int paramInt, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start pingServer:");
        ((StringBuilder)localObject1).append(this.a);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-c ");
      ((StringBuilder)localObject1).append(paramInt);
      paramString = new ProcessBuilder(new String[0]).command(new String[] { "/system/bin/ping", ((StringBuilder)localObject1).toString(), paramString }).redirectErrorStream(true).start();
      try
      {
        paramString.getInputStream();
        paramString.getOutputStream();
        new String();
        new String();
        localObject1 = new BufferedReader(new InputStreamReader(paramString.getInputStream()));
        new String();
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("pingServer:");
            localStringBuilder2.append(this.a);
            localStringBuilder2.append(" out:");
            localStringBuilder2.append(str);
            QLog.d("MSF.C.NetConnTag", 2, localStringBuilder2.toString());
          }
        }
        return;
      }
      finally
      {
        paramString.destroy();
      }
      StringBuilder localStringBuilder1;
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("pingServer:");
        localStringBuilder1.append(this.a);
        localStringBuilder1.append(" readLine Exception");
        localStringBuilder1.append(paramString);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder1.toString());
      }
    }
  }
  
  public void run()
  {
    a(5, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.u
 * JD-Core Version:    0.7.0.1
 */