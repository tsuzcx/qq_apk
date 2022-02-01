package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class VsAppInfo
{
  public static int PID;
  public static int SPMODE;
  private static Boolean isReadLog;
  private static Boolean isReadPhoneState;
  private static Boolean isWriteSdcard;
  private static String mAPPVersion;
  private static String mAppProcessName;
  
  public static String getAPPVersion(Context paramContext)
  {
    if (mAPPVersion == null) {
      mAPPVersion = getVersionName(paramContext);
    }
    return mAPPVersion;
  }
  
  public static String getCurrentProcess(Context paramContext)
  {
    Object localObject = mAppProcessName;
    if (localObject != null) {
      return localObject;
    }
    try
    {
      if (PID == 0) {
        PID = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == PID)
        {
          mAppProcessName = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          paramContext = mAppProcessName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      VsLog.printStackTrace(paramContext);
    }
    return "";
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    String str = paramContext.getPackageName();
    paramContext = str;
    if (VsAppInfo.VsStringUtil.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  protected static String getVersionName(Context paramContext)
  {
    for (;;)
    {
      try
      {
        str = getPackageName(paramContext);
      }
      finally
      {
        String str;
        int m;
        int i;
        int k;
        continue;
        throw paramContext;
        continue;
        i += 1;
        int j = k;
        continue;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
        str = paramContext.versionName;
        m = paramContext.versionCode;
        if ((str != null) && (str.trim().length() > 0))
        {
          str = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
          paramContext = str.toCharArray();
          i = 0;
          j = 0;
          if (i < paramContext.length)
          {
            k = j;
            if (paramContext[i] == '.') {
              k = j + 1;
            }
          }
          else
          {
            paramContext = str;
            if (j < 3)
            {
              VsLog.debug("[core] add versionCode: %s", new Object[] { Integer.valueOf(m) });
              paramContext = new StringBuilder();
              paramContext.append(str);
              paramContext.append(".");
              paramContext.append(m);
              paramContext = paramContext.toString();
            }
            VsLog.debug("[core] final Version: %s", new Object[] { paramContext });
            return paramContext;
          }
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          paramContext.append(m);
          paramContext = paramContext.toString();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        VsLog.printStackTrace(paramContext);
        VsLog.error(paramContext.toString(), new Object[0]);
        return "";
      }
    }
  }
  
  /* Error */
  public static boolean isContainPermission(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +149 -> 150
    //   4: aload_1
    //   5: ifnull +145 -> 150
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 40	android/os/Process:myPid	()I
    //   13: invokestatic 179	android/os/Process:myUid	()I
    //   16: invokevirtual 183	android/content/Context:checkPermission	(Ljava/lang/String;II)I
    //   19: ifne +9 -> 28
    //   22: iconst_1
    //   23: istore 4
    //   25: goto +6 -> 31
    //   28: iconst_0
    //   29: istore 4
    //   31: iload 4
    //   33: ifne +114 -> 147
    //   36: aload_0
    //   37: invokevirtual 104	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   40: aload_0
    //   41: invokevirtual 90	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: sipush 4096
    //   47: invokevirtual 110	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   50: getfield 187	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   53: astore_0
    //   54: iload 4
    //   56: istore 5
    //   58: aload_0
    //   59: ifnull +44 -> 103
    //   62: aload_0
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore_2
    //   67: iload 4
    //   69: istore 5
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +30 -> 103
    //   76: aload_1
    //   77: aload_0
    //   78: iload_2
    //   79: aaload
    //   80: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: istore 5
    //   85: iload 5
    //   87: ifeq +9 -> 96
    //   90: iconst_1
    //   91: istore 5
    //   93: goto +10 -> 103
    //   96: iload_2
    //   97: iconst_1
    //   98: iadd
    //   99: istore_2
    //   100: goto -33 -> 67
    //   103: ldc 193
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 153	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: iload 5
    //   114: ireturn
    //   115: astore_0
    //   116: goto +20 -> 136
    //   119: astore_0
    //   120: aload_0
    //   121: invokestatic 84	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsLog:printStackTrace	(Ljava/lang/Throwable;)V
    //   124: ldc 193
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 153	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: iload 4
    //   135: ireturn
    //   136: ldc 193
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 153	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: athrow
    //   147: iload 4
    //   149: ireturn
    //   150: ldc 195
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 174	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: iconst_0
    //   160: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramString	String
    //   66	34	2	i	int
    //   64	10	3	j	int
    //   23	125	4	bool1	boolean
    //   56	57	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   36	54	115	finally
    //   62	65	115	finally
    //   76	85	115	finally
    //   120	124	115	finally
    //   36	54	119	java/lang/Throwable
    //   62	65	119	java/lang/Throwable
    //   76	85	119	java/lang/Throwable
  }
  
  public static boolean isContainReadPhoneStatePermission(Context paramContext)
  {
    try
    {
      if (isReadPhoneState == null) {
        isReadPhoneState = Boolean.valueOf(isContainPermission(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      paramContext = new StringBuilder();
      paramContext.append("[core] Read phone state permission: ");
      paramContext.append(isReadPhoneState);
      VsLog.debug(paramContext.toString(), new Object[0]);
      boolean bool = isReadPhoneState.booleanValue();
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppInfo
 * JD-Core Version:    0.7.0.1
 */