package com.tencent.qqmini.sdk.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class DeviceUtil
{
  public static final int BUFFER_SIZE = 1024;
  public static final String TAG = "DeviceUtil";
  private static long cachedTotalMemory = 0L;
  private static long initial_rate = 0L;
  protected static String location;
  public static int sCpuCoreNum = -1;
  private static long sCpuMaxFreq;
  
  /* Error */
  public static long getCpuFrequency()
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   3: lstore_2
    //   4: lload_2
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +5 -> 12
    //   10: lload_2
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: invokestatic 38	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   17: istore_1
    //   18: getstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifgt +156 -> 179
    //   26: iload_0
    //   27: iload_1
    //   28: if_icmpge +151 -> 179
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 5
    //   37: new 40	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   44: astore 4
    //   46: aload 4
    //   48: ldc 43
    //   50: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 4
    //   56: iload_0
    //   57: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 4
    //   63: ldc 52
    //   65: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: new 54	java/io/BufferedReader
    //   72: dup
    //   73: new 56	java/io/FileReader
    //   76: dup
    //   77: aload 4
    //   79: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 63	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   85: sipush 1024
    //   88: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   91: astore 4
    //   93: aload 4
    //   95: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 5
    //   100: aload 5
    //   102: ifnull +21 -> 123
    //   105: aload 5
    //   107: invokestatic 75	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   110: putstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   113: getstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   116: ldc2_w 76
    //   119: ldiv
    //   120: putstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   123: aload 4
    //   125: invokevirtual 80	java/io/BufferedReader:close	()V
    //   128: goto +44 -> 172
    //   131: astore 6
    //   133: aload 4
    //   135: astore 5
    //   137: aload 6
    //   139: astore 4
    //   141: goto +8 -> 149
    //   144: goto +18 -> 162
    //   147: astore 4
    //   149: aload 5
    //   151: ifnull +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 80	java/io/BufferedReader:close	()V
    //   159: aload 4
    //   161: athrow
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 80	java/io/BufferedReader:close	()V
    //   172: iload_0
    //   173: iconst_1
    //   174: iadd
    //   175: istore_0
    //   176: goto -158 -> 18
    //   179: new 40	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: ldc 82
    //   192: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: getstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   201: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: ldc 87
    //   209: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: iload_0
    //   216: iconst_1
    //   217: isub
    //   218: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 11
    //   224: aload 4
    //   226: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 93	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: getstatic 34	com/tencent/qqmini/sdk/core/utils/DeviceUtil:initial_rate	J
    //   235: lreturn
    //   236: astore 4
    //   238: aload 6
    //   240: astore 4
    //   242: goto -80 -> 162
    //   245: astore 5
    //   247: goto -103 -> 144
    //   250: astore 4
    //   252: goto -80 -> 172
    //   255: astore 5
    //   257: goto -98 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	205	0	i	int
    //   17	12	1	j	int
    //   3	8	2	l	long
    //   44	96	4	localObject1	Object
    //   147	21	4	localObject2	Object
    //   186	39	4	localStringBuilder	StringBuilder
    //   236	1	4	localException1	Exception
    //   240	1	4	localObject3	Object
    //   250	1	4	localIOException1	java.io.IOException
    //   35	120	5	localObject4	Object
    //   245	1	5	localException2	Exception
    //   255	1	5	localIOException2	java.io.IOException
    //   32	1	6	localObject5	Object
    //   131	108	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   93	100	131	finally
    //   105	123	131	finally
    //   37	93	147	finally
    //   37	93	236	java/lang/Exception
    //   93	100	245	java/lang/Exception
    //   105	123	245	java/lang/Exception
    //   123	128	250	java/io/IOException
    //   167	172	250	java/io/IOException
    //   154	159	255	java/io/IOException
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDeviceBenchmarkLevel coreNum:");
      localStringBuilder.append(k);
      localStringBuilder.append(" cpuFreq:");
      localStringBuilder.append(m);
      localStringBuilder.append(" ramSize:");
      localStringBuilder.append(n);
      localStringBuilder.append(" score:");
      localStringBuilder.append(i);
      QMLog.d("getDeviceBenchmarkLevel", localStringBuilder.toString());
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
    Context localContext = AppLoaderFactory.g().getContext();
    if (localContext == null) {
      return "";
    }
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(localContext);
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT >= 17) {
        sCpuCoreNum = Runtime.getRuntime().availableProcessors();
      } else {
        sCpuCoreNum = getNumCoresOldPhones();
      }
    }
    return sCpuCoreNum;
  }
  
  /* Error */
  public static long getSystemTotalMemory()
  {
    // Byte code:
    //   0: getstatic 198	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifne +162 -> 167
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: new 56	java/io/FileReader
    //   16: dup
    //   17: ldc 200
    //   19: invokespecial 63	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: astore_1
    //   25: new 54	java/io/BufferedReader
    //   28: dup
    //   29: aload_0
    //   30: sipush 1024
    //   33: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +24 -> 67
    //   46: aload_1
    //   47: ldc 202
    //   49: invokevirtual 208	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: iconst_1
    //   53: aaload
    //   54: invokestatic 212	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   57: invokevirtual 215	java/lang/Long:longValue	()J
    //   60: ldc2_w 76
    //   63: lmul
    //   64: putstatic 198	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   67: aload_3
    //   68: invokevirtual 80	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 216	java/io/FileReader:close	()V
    //   75: goto +51 -> 126
    //   78: goto +48 -> 126
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: goto +65 -> 149
    //   87: goto +16 -> 103
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_1
    //   95: goto +54 -> 149
    //   98: aconst_null
    //   99: astore_0
    //   100: aload 4
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: aload_0
    //   106: astore_1
    //   107: lconst_0
    //   108: putstatic 198	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 80	java/io/BufferedReader:close	()V
    //   119: aload_0
    //   120: ifnull +6 -> 126
    //   123: goto -52 -> 71
    //   126: getstatic 198	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   129: lconst_0
    //   130: lcmp
    //   131: ifne +36 -> 167
    //   134: ldc2_w 217
    //   137: lreturn
    //   138: astore_3
    //   139: aload_2
    //   140: astore 4
    //   142: aload_1
    //   143: astore_0
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 80	java/io/BufferedReader:close	()V
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 216	java/io/FileReader:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: getstatic 198	com/tencent/qqmini/sdk/core/utils/DeviceUtil:cachedTotalMemory	J
    //   170: lreturn
    //   171: astore_0
    //   172: goto -74 -> 98
    //   175: astore_1
    //   176: aload 4
    //   178: astore_3
    //   179: goto -76 -> 103
    //   182: astore_1
    //   183: goto -96 -> 87
    //   186: astore_0
    //   187: goto -109 -> 78
    //   190: astore_0
    //   191: goto -26 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	140	0	localObject1	Object
    //   171	1	0	localException1	Exception
    //   186	1	0	localException2	Exception
    //   190	1	0	localException3	Exception
    //   24	130	1	localObject2	Object
    //   175	1	1	localException4	Exception
    //   182	1	1	localException5	Exception
    //   9	1	2	localObject3	Object
    //   81	1	2	localObject4	Object
    //   90	1	2	localObject5	Object
    //   104	62	2	localObject6	Object
    //   36	80	3	localObject7	Object
    //   138	7	3	localObject8	Object
    //   178	1	3	localObject9	Object
    //   11	166	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	81	finally
    //   46	67	81	finally
    //   13	23	90	finally
    //   25	37	138	finally
    //   107	111	138	finally
    //   13	23	171	java/lang/Exception
    //   25	37	175	java/lang/Exception
    //   37	42	182	java/lang/Exception
    //   46	67	182	java/lang/Exception
    //   67	71	186	java/lang/Exception
    //   71	75	186	java/lang/Exception
    //   115	119	186	java/lang/Exception
    //   153	157	190	java/lang/Exception
    //   161	165	190	java/lang/Exception
  }
  
  /* Error */
  private static void initCpuFreq(String paramString)
  {
    // Byte code:
    //   0: invokestatic 38	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getCpuNumber	()I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_1
    //   7: iload_2
    //   8: if_icmpge +360 -> 368
    //   11: new 40	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   18: astore 5
    //   20: aload 5
    //   22: ldc 43
    //   24: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: iload_1
    //   31: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 5
    //   37: ldc 221
    //   39: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: aload_0
    //   46: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: new 56	java/io/FileReader
    //   53: dup
    //   54: aload 5
    //   56: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 63	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: new 54	java/io/BufferedReader
    //   67: dup
    //   68: aload 5
    //   70: sipush 1024
    //   73: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   76: astore 10
    //   78: aload 5
    //   80: astore 6
    //   82: aload 10
    //   84: astore 7
    //   86: aload 10
    //   88: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: astore 8
    //   93: aload 8
    //   95: ifnull +274 -> 369
    //   98: aload 5
    //   100: astore 6
    //   102: aload 10
    //   104: astore 7
    //   106: aload 8
    //   108: invokestatic 75	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   111: lstore_3
    //   112: goto +3 -> 115
    //   115: aload 5
    //   117: astore 6
    //   119: aload 10
    //   121: astore 7
    //   123: getstatic 96	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   126: lload_3
    //   127: lcmp
    //   128: ifge +15 -> 143
    //   131: aload 5
    //   133: astore 6
    //   135: aload 10
    //   137: astore 7
    //   139: lload_3
    //   140: putstatic 96	com/tencent/qqmini/sdk/core/utils/DeviceUtil:sCpuMaxFreq	J
    //   143: aload 5
    //   145: astore 6
    //   147: aload 10
    //   149: astore 7
    //   151: ldc 128
    //   153: invokestatic 227	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   156: ldc 229
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: iload_1
    //   165: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: lload_3
    //   172: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   175: aastore
    //   176: invokestatic 241	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   179: invokestatic 93	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 10
    //   184: invokevirtual 80	java/io/BufferedReader:close	()V
    //   187: goto +10 -> 197
    //   190: astore 6
    //   192: aload 6
    //   194: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   197: aload 5
    //   199: invokevirtual 216	java/io/FileReader:close	()V
    //   202: goto +112 -> 314
    //   205: astore 9
    //   207: aload 5
    //   209: astore 8
    //   211: aload 10
    //   213: astore 5
    //   215: goto +46 -> 261
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 7
    //   222: goto +104 -> 326
    //   225: astore 9
    //   227: aconst_null
    //   228: astore 6
    //   230: aload 5
    //   232: astore 8
    //   234: aload 6
    //   236: astore 5
    //   238: goto +23 -> 261
    //   241: astore_0
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 5
    //   247: astore 7
    //   249: goto +77 -> 326
    //   252: astore 9
    //   254: aconst_null
    //   255: astore 5
    //   257: aload 5
    //   259: astore 8
    //   261: aload 8
    //   263: astore 6
    //   265: aload 5
    //   267: astore 7
    //   269: aload 9
    //   271: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   274: aload 5
    //   276: ifnull +18 -> 294
    //   279: aload 5
    //   281: invokevirtual 80	java/io/BufferedReader:close	()V
    //   284: goto +10 -> 294
    //   287: astore 5
    //   289: aload 5
    //   291: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   294: aload 8
    //   296: ifnull +18 -> 314
    //   299: aload 8
    //   301: invokevirtual 216	java/io/FileReader:close	()V
    //   304: goto +10 -> 314
    //   307: astore 5
    //   309: aload 5
    //   311: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   314: iload_1
    //   315: iconst_1
    //   316: iadd
    //   317: istore_1
    //   318: goto -312 -> 6
    //   321: astore_0
    //   322: aload 6
    //   324: astore 5
    //   326: aload 7
    //   328: ifnull +18 -> 346
    //   331: aload 7
    //   333: invokevirtual 80	java/io/BufferedReader:close	()V
    //   336: goto +10 -> 346
    //   339: astore 6
    //   341: aload 6
    //   343: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   346: aload 5
    //   348: ifnull +18 -> 366
    //   351: aload 5
    //   353: invokevirtual 216	java/io/FileReader:close	()V
    //   356: goto +10 -> 366
    //   359: astore 5
    //   361: aload 5
    //   363: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   366: aload_0
    //   367: athrow
    //   368: return
    //   369: lconst_0
    //   370: lstore_3
    //   371: goto -256 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString	String
    //   5	313	1	i	int
    //   3	6	2	j	int
    //   111	260	3	l	long
    //   18	262	5	localObject1	Object
    //   287	3	5	localException1	Exception
    //   307	3	5	localException2	Exception
    //   324	28	5	localObject2	Object
    //   359	3	5	localException3	Exception
    //   80	66	6	localObject3	Object
    //   190	3	6	localException4	Exception
    //   228	95	6	localObject4	Object
    //   339	3	6	localException5	Exception
    //   84	248	7	localObject5	Object
    //   91	209	8	localObject6	Object
    //   205	1	9	localException6	Exception
    //   225	1	9	localException7	Exception
    //   252	18	9	localException8	Exception
    //   76	136	10	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   182	187	190	java/lang/Exception
    //   86	93	205	java/lang/Exception
    //   106	112	205	java/lang/Exception
    //   123	131	205	java/lang/Exception
    //   139	143	205	java/lang/Exception
    //   151	182	205	java/lang/Exception
    //   64	78	218	finally
    //   64	78	225	java/lang/Exception
    //   11	64	241	finally
    //   11	64	252	java/lang/Exception
    //   279	284	287	java/lang/Exception
    //   197	202	307	java/lang/Exception
    //   299	304	307	java/lang/Exception
    //   86	93	321	finally
    //   106	112	321	finally
    //   123	131	321	finally
    //   139	143	321	finally
    //   151	182	321	finally
    //   269	274	321	finally
    //   331	336	339	java/lang/Exception
    //   351	356	359	java/lang/Exception
  }
  
  private static void initCpuMaxFreq()
  {
    initCpuFreq("cpuinfo_max_freq");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */