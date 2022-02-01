package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.sdk.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static int a(Context paramContext)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
        {
          paramContext = localConnectivityManager.getActiveNetworkInfo();
          if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {
            continue;
          }
          int j = paramContext.getType();
          if (j != 0)
          {
            if (j == 1) {
              break label152;
            }
            continue;
          }
        }
        switch (paramContext.getSubtype())
        {
        case 1: 
          f.b("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
          return 0;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        i = 0;
        return i;
      }
      label152:
      return 3;
    }
    return 4;
    return 2;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: getstatic 65	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   3: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +7 -> 13
    //   9: getstatic 65	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   12: areturn
    //   13: aconst_null
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore 5
    //   20: new 73	java/io/InputStreamReader
    //   23: dup
    //   24: invokestatic 79	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   27: ldc 81
    //   29: invokevirtual 85	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   32: invokevirtual 91	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: invokespecial 95	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   38: astore_0
    //   39: aload_0
    //   40: astore_2
    //   41: new 97	java/io/BufferedReader
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: aload_3
    //   51: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: ldc 105
    //   56: invokevirtual 110	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +12 -> 71
    //   62: ldc 112
    //   64: invokestatic 115	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore_1
    //   68: goto +12 -> 80
    //   71: ldc 117
    //   73: invokestatic 122	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 115	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 125	java/io/BufferedReader:close	()V
    //   84: goto +8 -> 92
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   92: aload_1
    //   93: astore_2
    //   94: aload_0
    //   95: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   98: aload_1
    //   99: areturn
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   105: aload_2
    //   106: areturn
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: goto +89 -> 199
    //   113: astore 4
    //   115: goto +24 -> 139
    //   118: astore 4
    //   120: aload 5
    //   122: astore_3
    //   123: goto +16 -> 139
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: goto +70 -> 199
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_0
    //   136: aload 5
    //   138: astore_3
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: astore_2
    //   143: ldc 117
    //   145: invokestatic 122	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 115	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore 5
    //   153: aload_3
    //   154: astore_1
    //   155: aload_0
    //   156: astore_2
    //   157: aload 4
    //   159: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   162: aload_3
    //   163: ifnull +15 -> 178
    //   166: aload_3
    //   167: invokevirtual 125	java/io/BufferedReader:close	()V
    //   170: goto +8 -> 178
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   178: aload_0
    //   179: ifnull +10 -> 189
    //   182: aload 5
    //   184: astore_2
    //   185: aload_0
    //   186: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   189: aload 5
    //   191: areturn
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: aload_1
    //   196: astore_2
    //   197: aload_3
    //   198: astore_1
    //   199: aload_2
    //   200: ifnull +15 -> 215
    //   203: aload_2
    //   204: invokevirtual 125	java/io/BufferedReader:close	()V
    //   207: goto +8 -> 215
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   215: aload_0
    //   216: ifnull +15 -> 231
    //   219: aload_0
    //   220: invokevirtual 127	java/io/InputStreamReader:close	()V
    //   223: goto +8 -> 231
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	57	0	localInputStreamReader	java.io.InputStreamReader
    //   100	2	0	localIOException1	java.io.IOException
    //   128	92	0	localObject1	Object
    //   226	2	0	localIOException2	java.io.IOException
    //   14	85	1	str1	String
    //   107	1	1	localObject2	Object
    //   126	1	1	localObject3	Object
    //   140	15	1	localObject4	Object
    //   173	23	1	localIOException3	java.io.IOException
    //   198	34	1	localObject5	Object
    //   16	25	2	localObject6	Object
    //   87	2	2	localIOException4	java.io.IOException
    //   93	111	2	localObject7	Object
    //   210	2	2	localIOException5	java.io.IOException
    //   49	118	3	localObject8	Object
    //   192	6	3	localObject9	Object
    //   113	1	4	localThrowable1	Throwable
    //   118	1	4	localThrowable2	Throwable
    //   132	26	4	localThrowable3	Throwable
    //   18	172	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   80	84	87	java/io/IOException
    //   94	98	100	java/io/IOException
    //   185	189	100	java/io/IOException
    //   50	68	107	finally
    //   71	80	107	finally
    //   50	68	113	java/lang/Throwable
    //   71	80	113	java/lang/Throwable
    //   41	50	118	java/lang/Throwable
    //   20	39	126	finally
    //   20	39	132	java/lang/Throwable
    //   166	170	173	java/io/IOException
    //   41	50	192	finally
    //   143	153	192	finally
    //   157	162	192	finally
    //   203	207	210	java/io/IOException
    //   219	223	226	java/io/IOException
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static String b()
  {
    try
    {
      String str = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      return str;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      f.c("Get app version name exception!", new Object[] { paramContext });
    }
    return null;
  }
  
  public static int c(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = BuildConfig.COMPONENT_SDK_VERSIONS;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        localStringBuilder.append(((Map)localObject).get(str));
        localStringBuilder.append(";");
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label85:
      break label85;
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    String str = e(paramContext);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    paramContext = f(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    return "unknown";
  }
  
  public static String e(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
        return localTelephonyManager.getDeviceId();
      }
      f.b("Require \"READ_PHONE_STATE\" permission for reading imei!", new Object[0]);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String f(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    try
    {
      c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.c
 * JD-Core Version:    0.7.0.1
 */