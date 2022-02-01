package com.tencent.mobileqq.litelivesdk.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ProcessUtil
{
  public static boolean a()
  {
    return a("com.tencent.mobileqq:tool");
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("process ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("exist");
          QLog.i("ProcessUtil", 1, ((StringBuilder)localObject).toString());
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */