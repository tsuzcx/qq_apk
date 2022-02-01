package com.tencent.mobileqq.wink.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class QQWinkUtil
{
  public static void a(Context paramContext)
  {
    a(paramContext, null, null);
  }
  
  public static void a(Context paramContext, Runnable paramRunnable, String paramString)
  {
    ThreadManager.excute(new QQWinkUtil.1(paramContext), 64, null, false);
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      boolean bool;
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        bool = "com.tencent.mobileqq:peak".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
      } while (!bool);
      return true;
    }
    catch (Exception paramContext)
    {
      label51:
      break label51;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQWinkUtil", 2, "get process info fail.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.QQWinkUtil
 * JD-Core Version:    0.7.0.1
 */