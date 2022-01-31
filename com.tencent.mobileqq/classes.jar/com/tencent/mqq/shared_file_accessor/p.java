package com.tencent.mqq.shared_file_accessor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class p
{
  static boolean a = false;
  private static final Uri b = Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save");
  private static String c = "";
  
  static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)Class.forName("com.tencent.common.app.QFixApplicationImpl").getMethod("getSystemSharedPreferences", new Class[] { String.class, Integer.TYPE }).invoke(paramContext.getApplicationContext(), new Object[] { paramString, Integer.valueOf(paramInt) });
      paramContext = localSharedPreferences;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      do
      {
        a(localClassNotFoundException);
        if (0 != 0) {
          break label121;
        }
        paramString = paramContext.getSharedPreferences(paramString, paramInt);
        if ((paramString instanceof n)) {
          break;
        }
        paramContext = paramString;
      } while (!(paramString instanceof l));
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        a(localNoSuchMethodException);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a(localIllegalArgumentException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        a(localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        a(localInvocationTargetException);
      }
    }
    return paramContext;
    label121:
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((c != null) && (c.length() != 0)) {}
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
          c = localRunningAppProcessInfo.processName;
        }
      }
      a = "com.tencent.mobileqq".equals(c);
      return;
    }
    Log.e("SpLib", "getRunningProcesses fail");
  }
  
  private static final void a(Exception paramException)
  {
    paramException.printStackTrace();
    if (SharedPreferencesProxyManager.sSystemSpExceptionMsg == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append(paramException.getMessage());
      localStringBuilder.append(Log.getStackTraceString(paramException));
      SharedPreferencesProxyManager.sSystemSpExceptionMsg = localStringBuilder.toString();
    }
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.getContentResolver().update(b, new ContentValues(0), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.p
 * JD-Core Version:    0.7.0.1
 */