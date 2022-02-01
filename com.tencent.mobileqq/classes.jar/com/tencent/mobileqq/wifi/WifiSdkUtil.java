package com.tencent.mobileqq.wifi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.List;

public class WifiSdkUtil
{
  public static int a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      if (paramContext.getSimState() == 1) {
        return 3;
      }
      paramContext = paramContext.getNetworkOperator();
      if ((!paramContext.equals("46000")) && (!paramContext.equals("46002")) && (!paramContext.equals("46007")))
      {
        if (paramContext.equals("46001")) {
          return 1;
        }
        if (paramContext.equals("46003")) {
          return 2;
        }
        return 3;
      }
      return 0;
    }
    return 3;
  }
  
  public static String a()
  {
    Object localObject1 = "";
    Object localObject2;
    try
    {
      String str = QQDeviceInfo.getMAC("f5cc92");
      localObject1 = str;
      boolean bool = TextUtils.isEmpty(str);
      if (!bool)
      {
        localObject1 = str;
        localObject2 = str;
        if (!"02:00:00:00:00:00".equals(str)) {}
      }
      else
      {
        localObject1 = str;
        localObject2 = a("wifi.interface");
        Object localObject3 = localObject2;
        localObject1 = str;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = "wlan0";
        }
        localObject1 = str;
        str = c((String)localObject3);
        localObject1 = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = str;
          localObject2 = str;
          if (!"02:00:00:00:00:00".equals(str)) {}
        }
        else
        {
          localObject1 = str;
          localObject2 = d((String)localObject3);
          return localObject2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getMac exception: ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public static String a(long paramLong)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)(paramLong >> 24 & 0xFF));
    arrayOfInt[1] = ((int)(paramLong >> 16 & 0xFF));
    arrayOfInt[2] = ((int)(paramLong >> 8 & 0xFF));
    arrayOfInt[3] = ((int)(paramLong & 0xFF));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(arrayOfInt[3]));
    localStringBuilder.append(".");
    localStringBuilder.append(Integer.toString(arrayOfInt[2]));
    localStringBuilder.append(".");
    localStringBuilder.append(Integer.toString(arrayOfInt[1]));
    localStringBuilder.append(".");
    localStringBuilder.append(Integer.toString(arrayOfInt[0]));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      paramString = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      if (paramString == null) {
        return "";
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSysPropByReflect exception: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.i("WifiSdk", 2, ((StringBuilder)localObject).toString());
      }
    }
    return "";
  }
  
  /* Error */
  public static List<String> a(File paramFile)
  {
    // Byte code:
    //   0: new 143	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 144	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore 4
    //   14: new 146	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: new 151	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore 4
    //   33: new 156	java/io/BufferedReader
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 159	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 162	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +15 -> 64
    //   52: aload 5
    //   54: aload_1
    //   55: invokeinterface 167 2 0
    //   60: pop
    //   61: goto -18 -> 43
    //   64: aload_0
    //   65: invokevirtual 170	java/io/FileInputStream:close	()V
    //   68: aload 4
    //   70: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   73: aload_2
    //   74: invokevirtual 172	java/io/BufferedReader:close	()V
    //   77: aload 5
    //   79: areturn
    //   80: astore_1
    //   81: aload_2
    //   82: astore_3
    //   83: goto +10 -> 93
    //   86: astore_3
    //   87: goto +21 -> 108
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_0
    //   94: astore_2
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: aload 4
    //   101: astore_2
    //   102: goto +142 -> 244
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload 4
    //   110: astore_1
    //   111: goto +41 -> 152
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_0
    //   119: astore_1
    //   120: aload_3
    //   121: astore_2
    //   122: aload 4
    //   124: astore_0
    //   125: goto +119 -> 244
    //   128: astore_3
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: goto +19 -> 152
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_3
    //   141: goto +103 -> 244
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: astore_2
    //   149: aload 4
    //   151: astore_0
    //   152: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +41 -> 196
    //   158: new 85	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   165: astore 4
    //   167: aload 4
    //   169: ldc 174
    //   171: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 95	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 97
    //   187: iconst_2
    //   188: aload 4
    //   190: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: ifnull +10 -> 207
    //   200: aload_0
    //   201: invokevirtual 170	java/io/FileInputStream:close	()V
    //   204: goto +3 -> 207
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   215: aload_2
    //   216: ifnull +14 -> 230
    //   219: aload_2
    //   220: invokevirtual 172	java/io/BufferedReader:close	()V
    //   223: aload 5
    //   225: areturn
    //   226: aload_0
    //   227: invokevirtual 177	java/lang/Throwable:printStackTrace	()V
    //   230: aload 5
    //   232: areturn
    //   233: astore 4
    //   235: aload_2
    //   236: astore_3
    //   237: aload_1
    //   238: astore_2
    //   239: aload_0
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: aload_1
    //   245: ifnull +10 -> 255
    //   248: aload_1
    //   249: invokevirtual 170	java/io/FileInputStream:close	()V
    //   252: goto +3 -> 255
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 171	java/io/InputStreamReader:close	()V
    //   263: aload_3
    //   264: ifnull +14 -> 278
    //   267: aload_3
    //   268: invokevirtual 172	java/io/BufferedReader:close	()V
    //   271: goto +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 177	java/lang/Throwable:printStackTrace	()V
    //   278: goto +5 -> 283
    //   281: aload_0
    //   282: athrow
    //   283: goto -2 -> 281
    //   286: astore_0
    //   287: goto -61 -> 226
    //   290: astore_1
    //   291: goto -17 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramFile	File
    //   10	45	1	str	String
    //   80	1	1	localObject1	Object
    //   90	6	1	localObject2	Object
    //   98	177	1	localObject3	Object
    //   290	1	1	localThrowable1	Throwable
    //   42	218	2	localObject4	Object
    //   82	1	3	localObject5	Object
    //   86	1	3	localThrowable2	Throwable
    //   92	1	3	localObject6	Object
    //   105	1	3	localThrowable3	Throwable
    //   117	4	3	localObject7	Object
    //   128	1	3	localThrowable4	Throwable
    //   140	1	3	localObject8	Object
    //   144	34	3	localThrowable5	Throwable
    //   236	32	3	localObject9	Object
    //   12	97	4	localInputStreamReader	java.io.InputStreamReader
    //   114	36	4	localObject10	Object
    //   165	24	4	localStringBuilder	StringBuilder
    //   233	9	4	localObject11	Object
    //   7	224	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   43	48	80	finally
    //   52	61	80	finally
    //   43	48	86	java/lang/Throwable
    //   52	61	86	java/lang/Throwable
    //   33	43	90	finally
    //   33	43	105	java/lang/Throwable
    //   23	33	114	finally
    //   23	33	128	java/lang/Throwable
    //   14	23	136	finally
    //   14	23	144	java/lang/Throwable
    //   152	196	233	finally
    //   64	77	286	java/lang/Throwable
    //   200	204	286	java/lang/Throwable
    //   211	215	286	java/lang/Throwable
    //   219	223	286	java/lang/Throwable
    //   248	252	290	java/lang/Throwable
    //   259	263	290	java/lang/Throwable
    //   267	271	290	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
      return bool;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: new 192	java/io/BufferedInputStream
    //   3: dup
    //   4: new 146	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 193	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: new 195	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore 6
    //   25: aload_0
    //   26: astore_2
    //   27: aload 6
    //   29: astore 4
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload 6
    //   41: astore 4
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 200	java/io/BufferedInputStream:read	([B)I
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_m1
    //   51: if_icmpeq +20 -> 71
    //   54: aload_0
    //   55: astore_2
    //   56: aload 6
    //   58: astore 4
    //   60: aload 6
    //   62: aload_3
    //   63: iconst_0
    //   64: iload_1
    //   65: invokevirtual 204	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -31 -> 37
    //   71: aload_0
    //   72: astore_2
    //   73: aload 6
    //   75: astore 4
    //   77: aload 6
    //   79: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   82: astore_3
    //   83: aload 6
    //   85: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   88: goto +8 -> 96
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   96: aload_0
    //   97: invokevirtual 211	java/io/BufferedInputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore 5
    //   111: aload_0
    //   112: astore_3
    //   113: aload 6
    //   115: astore_0
    //   116: goto +36 -> 152
    //   119: astore_2
    //   120: aconst_null
    //   121: astore 4
    //   123: goto +137 -> 260
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_0
    //   131: astore_3
    //   132: aload_2
    //   133: astore_0
    //   134: goto +18 -> 152
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore 4
    //   143: goto +117 -> 260
    //   146: astore 5
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: astore_3
    //   152: aload_3
    //   153: astore_2
    //   154: aload_0
    //   155: astore 4
    //   157: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +62 -> 222
    //   163: aload_3
    //   164: astore_2
    //   165: aload_0
    //   166: astore 4
    //   168: new 85	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   175: astore 6
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: astore 4
    //   182: aload 6
    //   184: ldc 213
    //   186: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_3
    //   191: astore_2
    //   192: aload_0
    //   193: astore 4
    //   195: aload 6
    //   197: aload 5
    //   199: invokevirtual 95	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: astore_2
    //   208: aload_0
    //   209: astore 4
    //   211: ldc 97
    //   213: iconst_2
    //   214: aload 6
    //   216: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: ifnull +15 -> 238
    //   226: aload_0
    //   227: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   230: goto +8 -> 238
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   238: aload_3
    //   239: ifnull +14 -> 253
    //   242: aload_3
    //   243: invokevirtual 211	java/io/BufferedInputStream:close	()V
    //   246: aconst_null
    //   247: areturn
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_3
    //   256: aload_2
    //   257: astore_0
    //   258: aload_3
    //   259: astore_2
    //   260: aload 4
    //   262: ifnull +16 -> 278
    //   265: aload 4
    //   267: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   270: goto +8 -> 278
    //   273: astore_3
    //   274: aload_3
    //   275: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   278: aload_0
    //   279: ifnull +15 -> 294
    //   282: aload_0
    //   283: invokevirtual 211	java/io/BufferedInputStream:close	()V
    //   286: goto +8 -> 294
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   294: goto +5 -> 299
    //   297: aload_2
    //   298: athrow
    //   299: goto -2 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramFile	File
    //   48	17	1	i	int
    //   26	47	2	localFile	File
    //   91	2	2	localIOException1	java.io.IOException
    //   119	1	2	localObject1	Object
    //   129	4	2	localObject2	Object
    //   137	1	2	localObject3	Object
    //   153	145	2	localObject4	Object
    //   36	207	3	localObject5	Object
    //   255	4	3	localObject6	Object
    //   273	2	3	localIOException2	java.io.IOException
    //   29	237	4	localObject7	Object
    //   109	1	5	localThrowable1	Throwable
    //   126	1	5	localThrowable2	Throwable
    //   146	52	5	localThrowable3	Throwable
    //   23	192	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   83	88	91	java/io/IOException
    //   96	100	102	java/io/IOException
    //   31	37	109	java/lang/Throwable
    //   43	49	109	java/lang/Throwable
    //   60	68	109	java/lang/Throwable
    //   77	83	109	java/lang/Throwable
    //   16	25	119	finally
    //   16	25	126	java/lang/Throwable
    //   0	16	137	finally
    //   0	16	146	java/lang/Throwable
    //   226	230	233	java/io/IOException
    //   242	246	248	java/io/IOException
    //   31	37	255	finally
    //   43	49	255	finally
    //   60	68	255	finally
    //   77	83	255	finally
    //   157	163	255	finally
    //   168	177	255	finally
    //   182	190	255	finally
    //   195	206	255	finally
    //   211	222	255	finally
    //   265	270	273	java/io/IOException
    //   282	286	289	java/io/IOException
  }
  
  public static int b(Context paramContext)
  {
    if (!NetworkUtil.isNetworkAvailable(paramContext)) {
      return 0;
    }
    int i = NetUtil.a(paramContext);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return 5;
            }
            return 4;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static String b()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append("/DCIM/.tmfs/sk_v.dat");
      localObject = a(new File(((StringBuilder)localObject).toString()));
      if (localObject != null)
      {
        localObject = b(new String((byte[])localObject));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getVidInSD exception: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.i("WifiSdk", 2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = XxteaCryptor.a(Base64.a(paramString, 0), XxteaCryptor.a());
      if (paramString != null)
      {
        paramString = new String(paramString, "gbk");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDecodeString exception: ");
        localStringBuilder.append(paramString.getMessage());
        QLog.i("WifiSdk", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return true;
    }
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext.getPackageName()) != 0)
      {
        int i = localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", paramContext.getPackageName());
        return i == 0;
      }
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = NetworkInterface.getByName(paramString).getHardwareAddress();
      if (paramString == null) {
        return "";
      }
      localStringBuilder = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(paramString[i]) }));
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMacByAPI exception: ");
        localStringBuilder.append(paramString.getMessage());
        QLog.i("WifiSdk", 2, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  @TargetApi(19)
  public static boolean c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    boolean bool = false;
    try
    {
      int i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static String d(String paramString)
  {
    Object localObject1 = "";
    Object localObject2;
    try
    {
      paramString = a(new File(String.format("/sys/class/net/%s/address", new Object[] { paramString })));
      localObject2 = localObject1;
      if (paramString == null) {
        return localObject2;
      }
      localObject2 = localObject1;
      if (paramString.size() != 1) {
        return localObject2;
      }
      paramString = (String)paramString.get(0);
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString.trim();
          return localObject1;
        }
        return paramString;
      }
      catch (Throwable localThrowable1) {}
      localObject2 = paramString;
    }
    catch (Throwable localThrowable2)
    {
      paramString = (String)localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getMacFromFile exception: ");
      ((StringBuilder)localObject1).append(localThrowable2.getMessage());
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
      localObject2 = paramString;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.WifiSdkUtil
 * JD-Core Version:    0.7.0.1
 */