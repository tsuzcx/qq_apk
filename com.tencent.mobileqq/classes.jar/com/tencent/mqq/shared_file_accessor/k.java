package com.tencent.mqq.shared_file_accessor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.tencent.common.app.QFixApplicationImpl;
import java.util.Iterator;
import java.util.List;

public final class k
{
  static String a = "";
  static boolean b = false;
  
  static
  {
    Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save");
  }
  
  static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    return ((QFixApplicationImpl)paramContext.getApplicationContext()).getSystemSharedPreferences(paramString, 0);
  }
  
  static l a()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    Object localObject1 = "";
    Object localObject2 = "";
    int i1 = arrayOfStackTraceElement.length;
    int k = 0;
    int m;
    for (int j = 0; k < i1; j = m)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
      String str = localStackTraceElement.getClassName();
      int n = i;
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      m = j;
      if (!str.contains("SPStatInspector"))
      {
        n = i;
        localObject4 = localObject2;
        localObject3 = localObject1;
        m = j;
        if (!str.startsWith("com.tencent.mqq.shared_file_accessor."))
        {
          n = i;
          localObject4 = localObject2;
          localObject3 = localObject1;
          m = j;
          if (!str.startsWith("android."))
          {
            n = i;
            localObject4 = localObject2;
            localObject3 = localObject1;
            m = j;
            if (!str.startsWith("java."))
            {
              n = i;
              localObject4 = localObject2;
              localObject3 = localObject1;
              m = j;
              if (!str.startsWith("com.android."))
              {
                n = i;
                localObject4 = localObject2;
                localObject3 = localObject1;
                m = j;
                if (!str.startsWith("org.chromium."))
                {
                  n = i;
                  localObject4 = localObject2;
                  localObject3 = localObject1;
                  m = j;
                  if (!str.startsWith("dalvik."))
                  {
                    m = j + 1;
                    if (m >= 8) {
                      break;
                    }
                    j = i;
                    if (i == 0)
                    {
                      j = 1;
                      localObject1 = localStackTraceElement.getClassName();
                      localObject2 = localStackTraceElement.getMethodName();
                    }
                    localStringBuilder.append(localStackTraceElement.toString()).append(",");
                    localStringBuilder.append("\n");
                    localObject3 = localObject1;
                    localObject4 = localObject2;
                    n = j;
                  }
                }
              }
            }
          }
        }
      }
      k += 1;
      i = n;
      localObject2 = localObject4;
      localObject1 = localObject3;
    }
    return new l((String)localObject1, (String)localObject2, localStringBuilder.toString());
  }
  
  public static void a(Context paramContext)
  {
    if ((a != null) && (a.length() != 0)) {}
    while (paramContext == null) {
      return;
    }
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i) {
          a = localRunningAppProcessInfo.processName;
        }
      }
      b = "com.tencent.mobileqq".equals(a);
      return;
    }
    Log.e("SpLib", "getRunningProcesses fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.k
 * JD-Core Version:    0.7.0.1
 */