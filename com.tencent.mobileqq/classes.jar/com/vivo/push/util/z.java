package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class z
{
  private static String[] a = { "com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService" };
  private static String[] b = { "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS" };
  private static Boolean c;
  private static String[] d = { "com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService" };
  private static String[] e = { "com.vivo.push.sdk.RegistrationReceiver" };
  private static String[] f = new String[0];
  private static Map<String, Bundle> g = new ConcurrentHashMap();
  
  public static long a(Context paramContext, String paramString)
  {
    Object localObject2 = b(paramContext, paramString, "com.vivo.push.sdk_version");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(paramContext, paramString, "sdk_version");
    }
    if (localObject1 != null) {
      try
      {
        long l = Long.parseLong(localObject1.toString());
        return l;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        o.a("Utility", "getSdkVersionCode error ", paramContext);
        return -1L;
      }
    }
    o.a("Utility", "getSdkVersionCode sdk version is null");
    return -1L;
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getField(paramString2).get(paramString1);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    String str1 = s.b(paramContext);
    String str2 = paramIntent.getStringExtra("client_pkgname");
    if (TextUtils.isEmpty(str1))
    {
      o.a("Utility", "illegality abe adapter : push pkg is null");
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      o.a("Utility", "illegality abe adapter : src pkg is null");
      return;
    }
    if (str1.equals(paramContext.getPackageName()))
    {
      o.a("Utility", "illegality abe adapter : abe is not pushservice");
      return;
    }
    if (!str1.equals(str2))
    {
      StringBuilder localStringBuilder = new StringBuilder("proxy to core : intent pkg : ");
      localStringBuilder.append(paramIntent.getPackage());
      localStringBuilder.append(" ; src pkg : ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ; push pkg : ");
      localStringBuilder.append(str1);
      o.d("Utility", localStringBuilder.toString());
      paramIntent.setPackage(str1);
      paramIntent.setClassName(str1, "com.vivo.push.sdk.service.PushService");
      paramContext.startService(paramIntent);
      return;
    }
    paramContext = new StringBuilder("illegality abe adapter : pushPkg = ");
    paramContext.append(str1);
    paramContext.append(" ; srcPkg = ");
    paramContext.append(str2);
    o.a("Utility", paramContext.toString());
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new Intent(paramString1);
    paramString1.setPackage(paramContext.getPackageName());
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        if (paramBoolean)
        {
          paramContext = paramContext.queryBroadcastReceivers(paramString1, 576);
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext()) {
              if (paramString2.equals(((ResolveInfo)paramContext.next()).activityInfo.name)) {
                return;
              }
            }
            paramContext = new StringBuilder();
            paramContext.append(paramString2);
            paramContext.append(" is missing");
            throw new VivoPushException(paramContext.toString());
          }
          paramContext = new StringBuilder("checkModule ");
          paramContext.append(paramString1);
          paramContext.append(" has no receivers");
          throw new VivoPushException(paramContext.toString());
        }
        paramContext = paramContext.queryIntentServices(paramString1, 576);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramString1 = paramContext.iterator();
          while (paramString1.hasNext())
          {
            paramContext = (ResolveInfo)paramString1.next();
            if (paramString2.equals(paramContext.serviceInfo.name))
            {
              if (paramContext.serviceInfo.exported) {
                return;
              }
              paramString1 = new StringBuilder();
              paramString1.append(paramContext.serviceInfo.name);
              paramString1.append(" exported is false");
              throw new VivoPushException(paramString1.toString());
            }
          }
          paramContext = new StringBuilder();
          paramContext.append(paramString2);
          paramContext.append(" is missing");
          throw new VivoPushException(paramContext.toString());
        }
        paramContext = new StringBuilder("checkModule ");
        paramContext.append(paramString1);
        paramContext.append(" has no services");
        throw new VivoPushException(paramContext.toString());
      }
      throw new VivoPushException("localPackageManager is null");
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder("error  ");
      paramString1.append(paramContext.getMessage());
      o.a("Utility", paramString1.toString());
      paramString1 = new StringBuilder("checkModule error");
      paramString1.append(paramContext.getMessage());
      paramContext = new VivoPushException(paramString1.toString());
    }
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private static void a(ComponentInfo paramComponentInfo, String paramString)
  {
    if (paramComponentInfo.applicationInfo.packageName.equals(paramString)) {
      return;
    }
    paramString = a;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if ((paramString[i].equals(paramComponentInfo.name)) && (!paramComponentInfo.processName.contains(":pushservice")))
      {
        paramString = new StringBuilder("module : ");
        paramString.append(paramComponentInfo.name);
        paramString.append(" process :");
        paramString.append(paramComponentInfo.processName);
        paramString.append("  check process fail");
        throw new VivoPushException(paramString.toString());
      }
      i += 1;
    }
  }
  
  private static void a(String paramString1, ComponentInfo[] paramArrayOfComponentInfo, String paramString2)
  {
    int j = paramArrayOfComponentInfo.length;
    int i = 0;
    while (i < j)
    {
      ComponentInfo localComponentInfo = paramArrayOfComponentInfo[i];
      if (paramString1.equals(localComponentInfo.name))
      {
        if (localComponentInfo.enabled)
        {
          a(localComponentInfo, paramString2);
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append(localComponentInfo.name);
        paramString1.append(" module Push-SDK need is illegitmacy !");
        throw new VivoPushException(paramString1.toString());
      }
      i += 1;
    }
    paramArrayOfComponentInfo = new StringBuilder();
    paramArrayOfComponentInfo.append(paramString1);
    paramArrayOfComponentInfo.append(" module Push-SDK need is not exist");
    paramString1 = new VivoPushException(paramArrayOfComponentInfo.toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject1 = c;
    if (localObject1 != null) {
      return ((Boolean)localObject1).booleanValue();
    }
    if (paramContext == null)
    {
      o.d("Utility", "isPushProcess context is null");
      return false;
    }
    localObject1 = s.b(paramContext);
    if ((paramContext != null) && (paramContext.getPackageName() != null) && (paramContext.getPackageName().equals(localObject1)))
    {
      paramContext = Boolean.TRUE;
      c = paramContext;
      return paramContext.booleanValue();
    }
    int i = Process.myPid();
    Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
    localObject1 = null;
    paramContext = (Context)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        if (((List)localObject2).size() == 0)
        {
          paramContext = (Context)localObject1;
        }
        else
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            paramContext = (Context)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          } while (paramContext.pid != i);
          paramContext = paramContext.processName;
        }
      }
    }
    if (TextUtils.isEmpty(paramContext)) {
      return false;
    }
    paramContext = Boolean.valueOf(paramContext.contains(":pushservice"));
    c = paramContext;
    return paramContext.booleanValue();
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnonnull +14 -> 21
    //   10: ldc 96
    //   12: ldc_w 364
    //   15: invokestatic 110	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 368	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: getstatic 373	com/vivo/push/p:c	Landroid/net/Uri;
    //   28: aconst_null
    //   29: ldc_w 375
    //   32: iconst_3
    //   33: anewarray 19	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_2
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc_w 377
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 383	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnonnull +43 -> 99
    //   59: aload_0
    //   60: astore 4
    //   62: aload_0
    //   63: astore 5
    //   65: ldc 96
    //   67: ldc_w 385
    //   70: invokestatic 110	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: aload_0
    //   75: ifnull +22 -> 97
    //   78: aload_0
    //   79: invokeinterface 390 1 0
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_0
    //   87: ldc 96
    //   89: ldc_w 391
    //   92: aload_0
    //   93: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: astore 4
    //   102: aload_0
    //   103: astore 5
    //   105: aload_0
    //   106: invokeinterface 394 1 0
    //   111: ifeq +53 -> 164
    //   114: aload_0
    //   115: astore 4
    //   117: aload_0
    //   118: astore 5
    //   120: aload_0
    //   121: aload_0
    //   122: ldc_w 396
    //   125: invokeinterface 400 2 0
    //   130: invokeinterface 404 2 0
    //   135: invokestatic 408	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   138: istore_3
    //   139: aload_0
    //   140: ifnull +22 -> 162
    //   143: aload_0
    //   144: invokeinterface 390 1 0
    //   149: iload_3
    //   150: ireturn
    //   151: astore_0
    //   152: ldc 96
    //   154: ldc_w 391
    //   157: aload_0
    //   158: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   161: pop
    //   162: iload_3
    //   163: ireturn
    //   164: aload_0
    //   165: ifnull +55 -> 220
    //   168: aload_0
    //   169: invokeinterface 390 1 0
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: goto +45 -> 222
    //   180: astore_0
    //   181: aload 5
    //   183: astore 4
    //   185: ldc 96
    //   187: ldc_w 410
    //   190: aload_0
    //   191: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   194: pop
    //   195: aload 5
    //   197: ifnull +23 -> 220
    //   200: aload 5
    //   202: invokeinterface 390 1 0
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_0
    //   210: ldc 96
    //   212: ldc_w 391
    //   215: aload_0
    //   216: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   219: pop
    //   220: iconst_0
    //   221: ireturn
    //   222: aload 4
    //   224: ifnull +24 -> 248
    //   227: aload 4
    //   229: invokeinterface 390 1 0
    //   234: goto +14 -> 248
    //   237: astore_1
    //   238: ldc 96
    //   240: ldc_w 391
    //   243: aload_1
    //   244: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   247: pop
    //   248: aload_0
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramContext	Context
    //   0	250	1	paramString1	String
    //   0	250	2	paramString2	String
    //   138	25	3	bool	boolean
    //   4	224	4	localContext1	Context
    //   1	200	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   78	84	86	java/lang/Exception
    //   143	149	151	java/lang/Exception
    //   10	19	176	finally
    //   21	55	176	finally
    //   65	74	176	finally
    //   105	114	176	finally
    //   120	139	176	finally
    //   185	195	176	finally
    //   10	19	180	java/lang/Exception
    //   21	55	180	java/lang/Exception
    //   65	74	180	java/lang/Exception
    //   105	114	180	java/lang/Exception
    //   120	139	180	java/lang/Exception
    //   168	174	209	java/lang/Exception
    //   200	207	209	java/lang/Exception
    //   227	234	237	java/lang/Exception
  }
  
  public static long b(Context paramContext)
  {
    String str = s.b(paramContext);
    if (TextUtils.isEmpty(str))
    {
      o.a("Utility", "systemPushPkgName is null");
      return -1L;
    }
    return a(paramContext, str);
  }
  
  /* Error */
  private static Object b(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +172 -> 178
    //   9: aload_1
    //   10: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: getstatic 70	com/vivo/push/util/z:g	Ljava/util/Map;
    //   21: ifnull +47 -> 68
    //   24: getstatic 70	com/vivo/push/util/z:g	Ljava/util/Map;
    //   27: invokeinterface 418 1 0
    //   32: ifle +36 -> 68
    //   35: getstatic 70	com/vivo/push/util/z:g	Ljava/util/Map;
    //   38: aload_1
    //   39: invokeinterface 419 2 0
    //   44: checkcast 421	android/os/Bundle
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +17 -> 68
    //   54: aload 5
    //   56: aload_2
    //   57: invokevirtual 423	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   60: astore 5
    //   62: aload 5
    //   64: astore_3
    //   65: goto +5 -> 70
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +5 -> 76
    //   74: aload_3
    //   75: areturn
    //   76: aload_0
    //   77: invokevirtual 205	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   80: aload_1
    //   81: sipush 128
    //   84: invokevirtual 427	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull +9 -> 98
    //   92: aload_0
    //   93: getfield 431	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnull +13 -> 113
    //   103: aload 4
    //   105: aload_2
    //   106: invokevirtual 423	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: astore_0
    //   110: goto +5 -> 115
    //   113: aload_3
    //   114: astore_0
    //   115: aload_0
    //   116: astore_2
    //   117: getstatic 70	com/vivo/push/util/z:g	Ljava/util/Map;
    //   120: invokeinterface 418 1 0
    //   125: sipush 300
    //   128: if_icmpgt +48 -> 176
    //   131: getstatic 70	com/vivo/push/util/z:g	Ljava/util/Map;
    //   134: aload_1
    //   135: aload 4
    //   137: invokeinterface 435 3 0
    //   142: pop
    //   143: aload_0
    //   144: areturn
    //   145: astore_1
    //   146: goto +12 -> 158
    //   149: astore_1
    //   150: aload_3
    //   151: astore_0
    //   152: goto +6 -> 158
    //   155: astore_1
    //   156: aload_3
    //   157: astore_0
    //   158: ldc 96
    //   160: ldc_w 437
    //   163: aload_1
    //   164: invokestatic 440	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 443	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokestatic 110	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: aload_0
    //   175: astore_2
    //   176: aload_2
    //   177: areturn
    //   178: aconst_null
    //   179: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramContext	Context
    //   0	180	1	paramString1	String
    //   0	180	2	paramString2	String
    //   1	156	3	localObject1	Object
    //   3	133	4	localBundle	Bundle
    //   47	16	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   117	143	145	java/lang/Exception
    //   76	88	149	java/lang/Exception
    //   92	98	149	java/lang/Exception
    //   103	110	149	java/lang/Exception
    //   18	49	155	java/lang/Exception
    //   54	62	155	java/lang/Exception
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject = b(paramContext, paramString, "com.vivo.push.app_id");
    if (localObject != null) {
      return localObject.toString();
    }
    paramContext = b(paramContext, paramString, "app_id");
    if (paramContext != null) {
      return paramContext.toString();
    }
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString1 });
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = paramString2;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = paramString2;
    }
    return str;
  }
  
  public static void c(Context paramContext)
  {
    o.d("Utility", "check PushService AndroidManifest declearation !");
    Object localObject1 = s.b(paramContext);
    boolean bool1 = s.d(paramContext, paramContext.getPackageName());
    boolean bool2 = s.e(paramContext, paramContext.getPackageName());
    boolean bool3 = s.c(paramContext, paramContext.getPackageName());
    if (bool2)
    {
      a = new String[] { "com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService" };
      b = new String[] { "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS" };
      d = new String[] { "com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService" };
      e = new String[] { "com.vivo.push.sdk.RegistrationReceiver" };
    }
    else
    {
      if ((!bool3) && (!bool1)) {
        throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
      }
      if (bool3) {
        d = new String[] { "com.vivo.push.sdk.service.CommandClientService" };
      } else {
        d = new String[] { "com.vivo.push.sdk.service.CommandService" };
      }
      e = new String[0];
      a = new String[0];
      if (bool1) {
        b = new String[] { "android.permission.INTERNET", "android.permission.WRITE_SETTINGS" };
      } else {
        b = new String[] { "android.permission.INTERNET" };
      }
    }
    long l1;
    if ((bool1) || (bool2))
    {
      long l2 = a(paramContext, paramContext.getPackageName());
      l1 = 800L;
      if (paramContext.getPackageName().equals(localObject1)) {
        l1 = 1800L;
      }
      if (l2 == -1L) {
        break label727;
      }
      if (l2 != l1) {
        break label708;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = paramContext.getPackageManager();
        if (localObject2 != null)
        {
          localObject2 = ((PackageManager)localObject2).getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
          if (localObject2 != null)
          {
            String[] arrayOfString = b;
            int k = arrayOfString.length;
            i = 0;
            int j = 0;
            if (i < k)
            {
              String str = arrayOfString[i];
              int m = localObject2.length;
              if (j < m)
              {
                if (str.equals(localObject2[j])) {
                  break label746;
                }
                j += 1;
                continue;
              }
              paramContext = new StringBuilder("permission : ");
              paramContext.append(str);
              paramContext.append("  check fail : ");
              paramContext.append(Arrays.toString((Object[])localObject2));
              throw new VivoPushException(paramContext.toString());
            }
            e(paramContext, (String)localObject1);
            c(paramContext, (String)localObject1);
            d(paramContext, (String)localObject1);
            localObject1 = paramContext.getPackageName();
            localObject2 = b(paramContext, (String)localObject1, "com.vivo.push.api_key");
            if (localObject2 != null)
            {
              localObject1 = localObject2.toString();
            }
            else
            {
              localObject1 = b(paramContext, (String)localObject1, "api_key");
              if (localObject1 != null) {
                localObject1 = localObject1.toString();
              } else {
                localObject1 = "";
              }
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (!TextUtils.isEmpty(b(paramContext, paramContext.getPackageName())))
              {
                if (((!bool1) && (!bool2)) || (a(paramContext, paramContext.getPackageName()) != -1L))
                {
                  if (bool2)
                  {
                    a(paramContext, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                    a(paramContext, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                  }
                  return;
                }
                throw new VivoPushException("sdkversion is null");
              }
              throw new VivoPushException("com.vivo.push.app_id is null");
            }
            throw new VivoPushException("com.vivo.push.api_key is null");
          }
          throw new VivoPushException("Permissions is null!");
        }
        throw new VivoPushException("localPackageManager is null");
      }
      catch (Exception paramContext)
      {
        throw new VivoPushException(paramContext.getMessage());
      }
      label708:
      throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(l1)));
      label727:
      paramContext = new VivoPushException("AndroidManifest.xml中未配置sdk_version");
      for (;;)
      {
        throw paramContext;
      }
      label746:
      i += 1;
    }
  }
  
  private static void c(Context paramContext, String paramString)
  {
    try
    {
      if (paramContext.getPackageManager() != null)
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4).services;
        if (paramContext != null)
        {
          String[] arrayOfString = d;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            a(arrayOfString[i], paramContext, paramString);
            i += 1;
          }
        }
        throw new VivoPushException("serviceInfos is null");
      }
      throw new VivoPushException("localPackageManager is null");
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder("error ");
      paramString.append(paramContext.getMessage());
      paramContext = new VivoPushException(paramString.toString());
      for (;;)
      {
        throw paramContext;
      }
    }
  }
  
  /* Error */
  public static java.security.PublicKey d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 368	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 550	com/vivo/push/p:a	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 383	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: invokeinterface 553 1 0
    //   27: ifeq +72 -> 99
    //   30: ldc_w 555
    //   33: aload_0
    //   34: aload_0
    //   35: ldc_w 556
    //   38: invokeinterface 400 2 0
    //   43: invokeinterface 404 2 0
    //   48: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifeq -30 -> 21
    //   54: aload_0
    //   55: aload_0
    //   56: ldc_w 558
    //   59: invokeinterface 400 2 0
    //   64: invokeinterface 404 2 0
    //   69: astore_1
    //   70: ldc 96
    //   72: ldc_w 560
    //   75: aload_1
    //   76: invokestatic 440	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 443	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokestatic 183	com/vivo/push/util/o:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_1
    //   87: invokestatic 565	com/vivo/push/util/t:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   90: astore_1
    //   91: aload_0
    //   92: invokeinterface 390 1 0
    //   97: aload_1
    //   98: areturn
    //   99: aload_0
    //   100: invokeinterface 390 1 0
    //   105: aconst_null
    //   106: areturn
    //   107: astore_1
    //   108: goto +11 -> 119
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   116: goto -17 -> 99
    //   119: aload_0
    //   120: invokeinterface 390 1 0
    //   125: goto +5 -> 130
    //   128: aload_1
    //   129: athrow
    //   130: goto -2 -> 128
    //   133: astore_0
    //   134: aload_1
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -15 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   69	29	1	localObject1	Object
    //   107	1	1	localObject2	Object
    //   111	24	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   21	91	107	finally
    //   112	116	107	finally
    //   21	91	111	java/lang/Exception
    //   91	97	133	java/lang/Exception
    //   99	105	136	java/lang/Exception
    //   119	125	139	java/lang/Exception
  }
  
  private static void d(Context paramContext, String paramString)
  {
    if (f.length <= 0) {
      return;
    }
    try
    {
      if (paramContext.getPackageManager() != null)
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1).activities;
        if (paramContext != null)
        {
          String[] arrayOfString = f;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            a(arrayOfString[i], paramContext, paramString);
            i += 1;
          }
        }
        throw new VivoPushException("activityInfos is null");
      }
      throw new VivoPushException("localPackageManager is null");
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder("error ");
      paramString.append(paramContext.getMessage());
      paramContext = new VivoPushException(paramString.toString());
      for (;;)
      {
        throw paramContext;
      }
    }
  }
  
  private static void e(Context paramContext, String paramString)
  {
    try
    {
      if (paramContext.getPackageManager() != null)
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 2).receivers;
        if (paramContext != null)
        {
          String[] arrayOfString = e;
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            a(arrayOfString[i], paramContext, paramString);
            i += 1;
          }
        }
        throw new VivoPushException("receivers is null");
      }
      throw new VivoPushException("localPackageManager is null");
    }
    catch (Exception paramContext)
    {
      paramContext = new VivoPushException(paramContext.getMessage());
      for (;;)
      {
        throw paramContext;
      }
    }
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnonnull +20 -> 27
    //   10: aload 4
    //   12: astore_2
    //   13: aload 5
    //   15: astore_3
    //   16: ldc 96
    //   18: ldc_w 364
    //   21: invokestatic 110	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: iconst_0
    //   26: ireturn
    //   27: aload 4
    //   29: astore_2
    //   30: aload 5
    //   32: astore_3
    //   33: aload_0
    //   34: invokevirtual 156	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: astore 6
    //   39: aload 4
    //   41: astore_2
    //   42: aload 5
    //   44: astore_3
    //   45: aload_0
    //   46: invokevirtual 205	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   49: aload 6
    //   51: iconst_0
    //   52: invokevirtual 489	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   55: getfield 579	android/content/pm/PackageInfo:versionCode	I
    //   58: istore_1
    //   59: aload 4
    //   61: astore_2
    //   62: aload 5
    //   64: astore_3
    //   65: aload_0
    //   66: invokevirtual 368	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   69: getstatic 581	com/vivo/push/p:b	Landroid/net/Uri;
    //   72: aconst_null
    //   73: ldc_w 583
    //   76: iconst_3
    //   77: anewarray 19	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: ldc_w 377
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload 6
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: iload_1
    //   94: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   97: aastore
    //   98: aconst_null
    //   99: invokevirtual 383	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_0
    //   103: aload_0
    //   104: ifnonnull +41 -> 145
    //   107: aload_0
    //   108: astore_2
    //   109: aload_0
    //   110: astore_3
    //   111: ldc 96
    //   113: ldc_w 385
    //   116: invokestatic 110	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_0
    //   121: ifnull +22 -> 143
    //   124: aload_0
    //   125: invokeinterface 390 1 0
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_0
    //   133: ldc 96
    //   135: ldc_w 391
    //   138: aload_0
    //   139: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: iconst_0
    //   144: ireturn
    //   145: aload_0
    //   146: astore_2
    //   147: aload_0
    //   148: astore_3
    //   149: aload_0
    //   150: invokeinterface 394 1 0
    //   155: ifeq +54 -> 209
    //   158: aload_0
    //   159: astore_2
    //   160: aload_0
    //   161: astore_3
    //   162: aload_0
    //   163: aload_0
    //   164: ldc_w 587
    //   167: invokeinterface 400 2 0
    //   172: invokeinterface 591 2 0
    //   177: istore_1
    //   178: iload_1
    //   179: iconst_1
    //   180: iand
    //   181: ifeq +28 -> 209
    //   184: aload_0
    //   185: ifnull +22 -> 207
    //   188: aload_0
    //   189: invokeinterface 390 1 0
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_0
    //   197: ldc 96
    //   199: ldc_w 391
    //   202: aload_0
    //   203: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   206: pop
    //   207: iconst_1
    //   208: ireturn
    //   209: aload_0
    //   210: ifnull +51 -> 261
    //   213: aload_0
    //   214: invokeinterface 390 1 0
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_0
    //   222: goto +41 -> 263
    //   225: astore_0
    //   226: aload_3
    //   227: astore_2
    //   228: ldc 96
    //   230: ldc_w 593
    //   233: aload_0
    //   234: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: aload_3
    //   239: ifnull +22 -> 261
    //   242: aload_3
    //   243: invokeinterface 390 1 0
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_0
    //   251: ldc 96
    //   253: ldc_w 391
    //   256: aload_0
    //   257: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   260: pop
    //   261: iconst_0
    //   262: ireturn
    //   263: aload_2
    //   264: ifnull +23 -> 287
    //   267: aload_2
    //   268: invokeinterface 390 1 0
    //   273: goto +14 -> 287
    //   276: astore_2
    //   277: ldc 96
    //   279: ldc_w 391
    //   282: aload_2
    //   283: invokestatic 103	com/vivo/push/util/o:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   286: pop
    //   287: aload_0
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	Context
    //   58	123	1	i	int
    //   12	256	2	localObject1	Object
    //   276	7	2	localException	Exception
    //   15	228	3	localObject2	Object
    //   4	56	4	localObject3	Object
    //   1	62	5	localObject4	Object
    //   37	52	6	str	String
    // Exception table:
    //   from	to	target	type
    //   124	130	132	java/lang/Exception
    //   188	194	196	java/lang/Exception
    //   16	25	221	finally
    //   33	39	221	finally
    //   45	59	221	finally
    //   65	103	221	finally
    //   111	120	221	finally
    //   149	158	221	finally
    //   162	178	221	finally
    //   228	238	221	finally
    //   16	25	225	java/lang/Exception
    //   33	39	225	java/lang/Exception
    //   45	59	225	java/lang/Exception
    //   65	103	225	java/lang/Exception
    //   111	120	225	java/lang/Exception
    //   149	158	225	java/lang/Exception
    //   162	178	225	java/lang/Exception
    //   213	219	250	java/lang/Exception
    //   242	248	250	java/lang/Exception
    //   267	273	276	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.z
 * JD-Core Version:    0.7.0.1
 */