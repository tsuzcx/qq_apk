package com.tencent.qqmini.sdk.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class DeviceUtil
{
  public static final int BUFFER_SIZE = 1024;
  public static final String TAG = "DeviceUtil";
  private static long cachedTotalMemory = 0L;
  private static long initial_rate;
  protected static String location;
  public static int sCpuCoreNum = -1;
  private static long sCpuMaxFreq = 0L;
  
  /* Error */
  public static long getCpuFrequency()
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +7 -> 12
    //   8: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: invokestatic 41	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   17: istore_1
    //   18: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifgt +126 -> 149
    //   26: iload_0
    //   27: iload_1
    //   28: if_icmpge +121 -> 149
    //   31: aconst_null
    //   32: astore_3
    //   33: new 43	java/io/BufferedReader
    //   36: dup
    //   37: new 45	java/io/FileReader
    //   40: dup
    //   41: new 47	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   48: ldc 50
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_0
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 59
    //   59: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   68: sipush 1024
    //   71: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +20 -> 101
    //   84: aload_3
    //   85: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: putstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   91: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   94: ldc2_w 79
    //   97: ldiv
    //   98: putstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 83	java/io/BufferedReader:close	()V
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: istore_0
    //   113: goto -95 -> 18
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull -9 -> 109
    //   121: aload_2
    //   122: invokevirtual 83	java/io/BufferedReader:close	()V
    //   125: goto -16 -> 109
    //   128: astore_2
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 83	java/io/BufferedReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: ldc 11
    //   151: new 47	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   158: ldc 85
    //   160: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   166: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc 90
    //   171: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: iconst_1
    //   176: isub
    //   177: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 96	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: getstatic 37	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   189: lreturn
    //   190: astore_2
    //   191: goto -82 -> 109
    //   194: astore_3
    //   195: goto -48 -> 147
    //   198: astore_2
    //   199: goto -60 -> 139
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -88 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	164	0	i	int
    //   17	12	1	j	int
    //   74	48	2	localBufferedReader	java.io.BufferedReader
    //   128	7	2	localIOException1	java.io.IOException
    //   138	10	2	localObject1	Object
    //   190	1	2	localIOException2	java.io.IOException
    //   198	1	2	localObject2	Object
    //   202	1	2	localException1	Exception
    //   204	1	2	localObject3	Object
    //   32	53	3	str	String
    //   116	1	3	localException2	Exception
    //   135	9	3	localObject4	Object
    //   194	1	3	localIOException3	java.io.IOException
    //   132	5	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	80	116	java/lang/Exception
    //   84	101	116	java/lang/Exception
    //   121	125	128	java/io/IOException
    //   75	80	132	finally
    //   84	101	132	finally
    //   105	109	190	java/io/IOException
    //   143	147	194	java/io/IOException
    //   33	75	198	finally
    //   33	75	202	java/lang/Exception
  }
  
  public static long getCpuMaxFreq()
  {
    if (sCpuMaxFreq == 0L) {
      initCpuMaxFreq();
    }
    return sCpuMaxFreq;
  }
  
  public static int getCpuNumber()
  {
    return getNumberOfCores();
  }
  
  public static int getDeviceBenchmarkLevel()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        return 0;
      }
      int k = getCpuNumber();
      if (k <= 0) {
        return -1;
      }
      int m = (int)(getCpuMaxFreq() / 100000L);
      if (m <= 0) {
        return -1;
      }
      int n = (int)(getSystemTotalMemory() / 1048576L);
      if (n <= 0) {
        return -1;
      }
      int j = (k * 200 + m * m * 10 + n / 1024 * (n / 1024) * 100) / 400;
      int i = j;
      if (j > 50) {
        i = 50;
      }
      QMLog.d("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel coreNum:" + k + " cpuFreq:" + m + " ramSize:" + n + " score:" + i);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel error", localThrowable);
    }
    return -1;
  }
  
  public static String getLocation()
  {
    if (!TextUtils.isEmpty(location)) {
      return location;
    }
    Object localObject1 = AppLoaderFactory.g().getContext();
    if (localObject1 == null) {
      return "";
    }
    try
    {
      localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
      Object localObject2 = new Criteria();
      ((Criteria)localObject2).setCostAllowed(false);
      ((Criteria)localObject2).setAccuracy(2);
      localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
        if (localObject1 == null) {
          return "";
        }
        double d1 = ((Location)localObject1).getLatitude();
        double d2 = ((Location)localObject1).getLongitude();
        localObject1 = d1 + "*" + d2;
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("getLocation", "getLocation>>>", localException);
    }
    return "";
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (sCpuCoreNum = Runtime.getRuntime().availableProcessors();; sCpuCoreNum = getNumCoresOldPhones()) {
      return sCpuCoreNum;
    }
  }
  
  /* Error */
  public static long getSystemTotalMemory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +138 -> 147
    //   12: new 45	java/io/FileReader
    //   15: dup
    //   16: ldc 231
    //   18: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 43	java/io/BufferedReader
    //   25: dup
    //   26: aload_1
    //   27: sipush 1024
    //   30: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +24 -> 64
    //   43: aload_2
    //   44: ldc 233
    //   46: invokevirtual 239	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: invokestatic 243	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   54: invokevirtual 246	java/lang/Long:longValue	()J
    //   57: ldc2_w 79
    //   60: lmul
    //   61: putstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 83	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 247	java/io/FileReader:close	()V
    //   80: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifne +62 -> 147
    //   88: ldc2_w 248
    //   91: lreturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: lconst_0
    //   100: putstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 83	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: ifnull -32 -> 80
    //   115: aload_1
    //   116: invokevirtual 247	java/io/FileReader:close	()V
    //   119: goto -39 -> 80
    //   122: astore_0
    //   123: goto -43 -> 80
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 83	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 247	java/io/FileReader:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: getstatic 25	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   150: lreturn
    //   151: astore_1
    //   152: goto -7 -> 145
    //   155: astore_0
    //   156: goto -27 -> 129
    //   159: astore_3
    //   160: aload_0
    //   161: astore_2
    //   162: aload_3
    //   163: astore_0
    //   164: goto -35 -> 129
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: aload_3
    //   171: astore_0
    //   172: goto -43 -> 129
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -79 -> 99
    //   181: astore_2
    //   182: goto -83 -> 99
    //   185: astore_0
    //   186: goto -106 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	105	0	localObject1	Object
    //   122	1	0	localException1	Exception
    //   126	20	0	localObject2	Object
    //   155	6	0	localObject3	Object
    //   163	9	0	localObject4	Object
    //   175	1	0	localException2	Exception
    //   177	1	0	localObject5	Object
    //   185	1	0	localException3	Exception
    //   21	56	1	localFileReader	java.io.FileReader
    //   92	1	1	localException4	Exception
    //   96	46	1	localObject6	Object
    //   151	1	1	localException5	Exception
    //   1	169	2	localObject7	Object
    //   181	1	2	localException6	Exception
    //   159	4	3	localObject8	Object
    //   167	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	92	java/lang/Exception
    //   107	111	122	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   12	22	126	finally
    //   133	137	151	java/lang/Exception
    //   141	145	151	java/lang/Exception
    //   22	34	155	finally
    //   34	39	159	finally
    //   43	64	159	finally
    //   99	103	167	finally
    //   22	34	175	java/lang/Exception
    //   34	39	181	java/lang/Exception
    //   43	64	181	java/lang/Exception
    //   68	72	185	java/lang/Exception
    //   76	80	185	java/lang/Exception
  }
  
  /* Error */
  private static void initCpuFreq(String paramString)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_1
    //   7: iload_2
    //   8: if_icmpge +313 -> 321
    //   11: new 45	java/io/FileReader
    //   14: dup
    //   15: new 47	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   22: ldc 50
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_1
    //   28: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 252
    //   33: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 66	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: new 43	java/io/BufferedReader
    //   51: dup
    //   52: aload 6
    //   54: sipush 1024
    //   57: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore 5
    //   62: aload 5
    //   64: astore 7
    //   66: aload 6
    //   68: astore 9
    //   70: aload 5
    //   72: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: aload 8
    //   79: ifnull +112 -> 191
    //   82: aload 5
    //   84: astore 7
    //   86: aload 6
    //   88: astore 9
    //   90: aload 8
    //   92: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload 5
    //   98: astore 7
    //   100: aload 6
    //   102: astore 9
    //   104: getstatic 23	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   107: lload_3
    //   108: lcmp
    //   109: ifge +15 -> 124
    //   112: aload 5
    //   114: astore 7
    //   116: aload 6
    //   118: astore 9
    //   120: lload_3
    //   121: putstatic 23	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   124: aload 5
    //   126: astore 7
    //   128: aload 6
    //   130: astore 9
    //   132: ldc 121
    //   134: invokestatic 258	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   137: ldc_w 260
    //   140: iconst_2
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: iload_1
    //   147: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: lload_3
    //   154: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   157: aastore
    //   158: invokestatic 272	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokestatic 96	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 83	java/io/BufferedReader:close	()V
    //   174: aload 6
    //   176: ifnull +8 -> 184
    //   179: aload 6
    //   181: invokevirtual 247	java/io/FileReader:close	()V
    //   184: iload_1
    //   185: iconst_1
    //   186: iadd
    //   187: istore_1
    //   188: goto -182 -> 6
    //   191: lconst_0
    //   192: lstore_3
    //   193: goto -97 -> 96
    //   196: astore 5
    //   198: aload 5
    //   200: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   203: goto -29 -> 174
    //   206: astore 5
    //   208: aload 5
    //   210: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   213: goto -29 -> 184
    //   216: astore 8
    //   218: aload 5
    //   220: astore 7
    //   222: aload 6
    //   224: astore 9
    //   226: aload 8
    //   228: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   231: aload 5
    //   233: ifnull +8 -> 241
    //   236: aload 5
    //   238: invokevirtual 83	java/io/BufferedReader:close	()V
    //   241: aload 6
    //   243: ifnull -59 -> 184
    //   246: aload 6
    //   248: invokevirtual 247	java/io/FileReader:close	()V
    //   251: goto -67 -> 184
    //   254: astore 5
    //   256: aload 5
    //   258: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   261: goto -77 -> 184
    //   264: astore 5
    //   266: aload 5
    //   268: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   271: goto -30 -> 241
    //   274: astore_0
    //   275: aload 9
    //   277: astore 6
    //   279: aload 7
    //   281: ifnull +8 -> 289
    //   284: aload 7
    //   286: invokevirtual 83	java/io/BufferedReader:close	()V
    //   289: aload 6
    //   291: ifnull +8 -> 299
    //   294: aload 6
    //   296: invokevirtual 247	java/io/FileReader:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore 5
    //   303: aload 5
    //   305: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   308: goto -19 -> 289
    //   311: astore 5
    //   313: aload 5
    //   315: invokevirtual 275	java/lang/Exception:printStackTrace	()V
    //   318: goto -19 -> 299
    //   321: return
    //   322: astore_0
    //   323: aconst_null
    //   324: astore 7
    //   326: aconst_null
    //   327: astore 6
    //   329: goto -50 -> 279
    //   332: astore_0
    //   333: aconst_null
    //   334: astore 7
    //   336: goto -57 -> 279
    //   339: astore 8
    //   341: aconst_null
    //   342: astore 5
    //   344: aconst_null
    //   345: astore 6
    //   347: goto -129 -> 218
    //   350: astore 8
    //   352: aconst_null
    //   353: astore 5
    //   355: goto -137 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramString	String
    //   5	183	1	i	int
    //   3	6	2	j	int
    //   95	98	3	l	long
    //   60	110	5	localBufferedReader	java.io.BufferedReader
    //   196	3	5	localException1	Exception
    //   206	31	5	localException2	Exception
    //   254	3	5	localException3	Exception
    //   264	3	5	localException4	Exception
    //   301	3	5	localException5	Exception
    //   311	3	5	localException6	Exception
    //   342	12	5	localObject1	Object
    //   46	300	6	localObject2	Object
    //   64	271	7	localObject3	Object
    //   75	16	8	str	String
    //   216	11	8	localException7	Exception
    //   339	1	8	localException8	Exception
    //   350	1	8	localException9	Exception
    //   68	208	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   169	174	196	java/lang/Exception
    //   179	184	206	java/lang/Exception
    //   70	77	216	java/lang/Exception
    //   90	96	216	java/lang/Exception
    //   104	112	216	java/lang/Exception
    //   120	124	216	java/lang/Exception
    //   132	164	216	java/lang/Exception
    //   246	251	254	java/lang/Exception
    //   236	241	264	java/lang/Exception
    //   70	77	274	finally
    //   90	96	274	finally
    //   104	112	274	finally
    //   120	124	274	finally
    //   132	164	274	finally
    //   226	231	274	finally
    //   284	289	301	java/lang/Exception
    //   294	299	311	java/lang/Exception
    //   11	48	322	finally
    //   48	62	332	finally
    //   11	48	339	java/lang/Exception
    //   48	62	350	java/lang/Exception
  }
  
  private static void initCpuMaxFreq()
  {
    initCpuFreq("cpuinfo_max_freq");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */