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
  private static ThreadOptimizer jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadOptimizer = null;
  private int jdField_a_of_type_Int = -2;
  private Context jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  public static ThreadOptimizer a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadOptimizer == null) {
        jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadOptimizer = new ThreadOptimizer();
      }
      ThreadOptimizer localThreadOptimizer = jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadOptimizer;
      return localThreadOptimizer;
    }
    finally {}
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 7)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      boolean bool1 = localSharedPreferences.getBoolean("enableUpdateIconStep", false);
      boolean bool2 = "1".equals(paramArrayOfString[7]);
      if (bool1 != bool2) {
        localSharedPreferences.edit().putBoolean("enableUpdateIconStep", bool2).commit();
      }
    }
  }
  
  private void b()
  {
    if ((this.b) || (this.c)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        int j = arrayOfThread.length;
        i = 0;
        if (i < j)
        {
          Thread localThread = arrayOfThread[i];
          if (localThread == null) {
            break label216;
          }
          if (localThread.getName() == null) {
            break label223;
          }
          localObject = localThread.getName();
          if ((this.b) && ("MSF-Receiver".equals(localObject))) {
            localThread.setPriority(1);
          } else if ((this.c) && (("logWriteThread".equals(localObject)) || (((String)localObject).startsWith("GlobalPool")) || (((String)localObject).startsWith("Face")) || (((String)localObject).startsWith("um-stack")) || (((String)localObject).startsWith("QQ_FTS")) || (((String)localObject).startsWith("httpcomm")))) {
            localThread.setPriority(1);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.Optimizer", 2, "", localException);
        }
        if (this.c)
        {
          ThreadManager.getSubThread().setPriority(1);
          ThreadManager.getFileThread().setPriority(1);
          ThreadManager.getRecentThreadLooper().getThread().setPriority(1);
        }
      }
      return;
      label216:
      i += 1;
      continue;
      label223:
      String str = "";
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 6)
    {
      if ("1".equals(paramArrayOfString[6])) {
        com.tencent.common.config.AppSetting.f = true;
      }
    }
    else {
      return;
    }
    com.tencent.common.config.AppSetting.f = false;
  }
  
  private void c(String[] paramArrayOfString)
  {
    File localFile;
    if (paramArrayOfString.length > 5)
    {
      localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "disableSmallLock");
      if (!"1".equals(paramArrayOfString[5])) {
        break label47;
      }
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    return;
    label47:
    localFile.createNewFile();
  }
  
  private void d(String[] paramArrayOfString)
  {
    float f = Float.parseFloat(paramArrayOfString[1]);
    if (1.0F * ((IDPCApi)QRoute.api(IDPCApi.class)).getAbRamdom() / ((IDPCApi)QRoute.api(IDPCApi.class)).getMaxAbRamdom() < f)
    {
      this.jdField_a_of_type_Int = Integer.valueOf(paramArrayOfString[0]).intValue();
      this.jdField_a_of_type_Boolean = "1".equals(paramArrayOfString[2]);
      this.b = "1".equals(paramArrayOfString[3]);
      this.c = "1".equals(paramArrayOfString[4]);
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_thread_config.name());
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager.Optimizer", 2, "config = " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {
          continue;
        }
        d((String[])localObject);
        c((String[])localObject);
        b((String[])localObject);
        a((String[])localObject);
        b();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThreadManager.Optimizer", 2, "", localException);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadOptimizer
 * JD-Core Version:    0.7.0.1
 */