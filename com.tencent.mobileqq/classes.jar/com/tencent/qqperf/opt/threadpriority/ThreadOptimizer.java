package com.tencent.qqperf.opt.threadpriority;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ThreadOptimizer
{
  private static ThreadOptimizer a;
  private Context b = MobileQQ.getContext();
  private int c = -2;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  public static ThreadOptimizer a()
  {
    try
    {
      if (a == null) {
        a = new ThreadOptimizer();
      }
      ThreadOptimizer localThreadOptimizer = a;
      return localThreadOptimizer;
    }
    finally {}
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 7)
    {
      SharedPreferences localSharedPreferences = this.b.getSharedPreferences("mobileQQ", 4);
      boolean bool1 = localSharedPreferences.getBoolean("enableUpdateIconStep", false);
      boolean bool2 = "1".equals(paramArrayOfString[7]);
      if (bool1 != bool2) {
        localSharedPreferences.edit().putBoolean("enableUpdateIconStep", bool2).commit();
      }
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 6)
    {
      if ("1".equals(paramArrayOfString[6]))
      {
        com.tencent.common.config.AppSetting.g = true;
        return;
      }
      com.tencent.common.config.AppSetting.g = false;
    }
  }
  
  private void c(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 5)
    {
      File localFile = new File(this.b.getFilesDir(), "disableSmallLock");
      if ("1".equals(paramArrayOfString[5]))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      else {
        localFile.createNewFile();
      }
    }
  }
  
  private void d(String[] paramArrayOfString)
  {
    float f1 = Float.parseFloat(paramArrayOfString[1]);
    if (((IDPCApi)QRoute.api(IDPCApi.class)).getAbRamdom() * 1.0F / ((IDPCApi)QRoute.api(IDPCApi.class)).getMaxAbRamdom() < f1)
    {
      this.c = Integer.valueOf(paramArrayOfString[0]).intValue();
      this.d = "1".equals(paramArrayOfString[2]);
      this.e = "1".equals(paramArrayOfString[3]);
      this.f = "1".equals(paramArrayOfString[4]);
      return;
    }
    this.c = 0;
  }
  
  private void g()
  {
    if ((this.e) || (this.f)) {}
    for (;;)
    {
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        int j = arrayOfThread.length;
        int i = 0;
        if (i < j)
        {
          Thread localThread = arrayOfThread[i];
          if (localThread != null)
          {
            if (localThread.getName() == null) {
              break label223;
            }
            localObject = localThread.getName();
            if ((this.e) && ("MSF-Receiver".equals(localObject))) {
              localThread.setPriority(1);
            } else if ((this.f) && (("logWriteThread".equals(localObject)) || (((String)localObject).startsWith("GlobalPool")) || (((String)localObject).startsWith("Face")) || (((String)localObject).startsWith("um-stack")) || (((String)localObject).startsWith("QQ_FTS")) || (((String)localObject).startsWith("httpcomm")))) {
              localThread.setPriority(1);
            }
          }
          i += 1;
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.Optimizer", 2, "", localException);
        }
        if (this.f)
        {
          ThreadManager.getSubThread().setPriority(1);
          ThreadManager.getFileThread().setPriority(1);
          ThreadManager.getRecentThreadLooper().getThread().setPriority(1);
        }
      }
      label223:
      String str = "";
    }
  }
  
  public void b()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_thread_config.name());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("config = ");
      localStringBuilder.append((String)localObject);
      QLog.d("ThreadManager.Optimizer", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 5) {
        return;
      }
      d((String[])localObject);
      c((String[])localObject);
      b((String[])localObject);
      a((String[])localObject);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.Optimizer", 2, "", localException);
      }
    }
    g();
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadOptimizer
 * JD-Core Version:    0.7.0.1
 */