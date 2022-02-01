package cooperation.qzone.sim;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class DeviceInfoUtil
{
  public static final int BUFFER_SIZE = 1024;
  public static final String TAG = "UniKingCardHelper/DeviceInfoUtil";
  private static final String TOP_COMMADN_CPU_PROCESS = "top -n 1 -m 10";
  private static final String TOP_COMMADN_CPU_THREAD = "top -n 1 -m 10 -t";
  private static String appVersionWithCode;
  private static String channelName;
  public static float density = 1.0F;
  public static int densityDpi = 0;
  private static String deviceId = "";
  private static String imsi;
  private static String localMacAddress;
  private static boolean mRegisterHandler = false;
  private static int orientation;
  private static long screenHeight;
  private static long screenWidth;
  
  public static String getAppMetaValue(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        String str = paramContext.getPackageName();
        paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.getString(paramString, "");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label18:
      break label18;
    }
    return "getVersionException";
  }
  
  public static String getAppVersionWithCode(Context paramContext)
  {
    if (!TextUtils.isEmpty(appVersionWithCode)) {
      return appVersionWithCode;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.versionName);
        localStringBuilder.append(".");
        localStringBuilder.append(paramContext.versionCode);
        appVersionWithCode = localStringBuilder.toString();
        paramContext = appVersionWithCode;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return appVersionWithCode;
  }
  
  /* Error */
  public static long getCpuFrequency()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: new 124	java/io/FileReader
    //   6: dup
    //   7: ldc 126
    //   9: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 7
    //   14: lload 4
    //   16: lstore_2
    //   17: aload 7
    //   19: astore 6
    //   21: new 131	java/io/BufferedReader
    //   24: dup
    //   25: aload 7
    //   27: sipush 1024
    //   30: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore 8
    //   35: lload 4
    //   37: lstore_2
    //   38: aload 7
    //   40: astore 6
    //   42: aload 8
    //   44: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 9
    //   49: lload 4
    //   51: lstore_0
    //   52: aload 9
    //   54: ifnull +20 -> 74
    //   57: lload 4
    //   59: lstore_2
    //   60: aload 7
    //   62: astore 6
    //   64: aload 9
    //   66: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: ldc2_w 144
    //   72: ldiv
    //   73: lstore_0
    //   74: lload_0
    //   75: lstore_2
    //   76: aload 7
    //   78: astore 6
    //   80: aload 8
    //   82: invokevirtual 148	java/io/BufferedReader:close	()V
    //   85: lload_0
    //   86: lstore 4
    //   88: aload 7
    //   90: invokevirtual 149	java/io/FileReader:close	()V
    //   93: lload_0
    //   94: lreturn
    //   95: astore 6
    //   97: aload 6
    //   99: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   102: lload 4
    //   104: lreturn
    //   105: astore 8
    //   107: goto +19 -> 126
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 7
    //   115: goto +45 -> 160
    //   118: astore 8
    //   120: aconst_null
    //   121: astore 7
    //   123: lload 4
    //   125: lstore_2
    //   126: aload 7
    //   128: astore 6
    //   130: aload 8
    //   132: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   135: aload 7
    //   137: ifnull +11 -> 148
    //   140: lload_2
    //   141: lstore 4
    //   143: aload 7
    //   145: invokevirtual 149	java/io/FileReader:close	()V
    //   148: lload_2
    //   149: lreturn
    //   150: astore 8
    //   152: aload 6
    //   154: astore 7
    //   156: aload 8
    //   158: astore 6
    //   160: aload 7
    //   162: ifnull +18 -> 180
    //   165: aload 7
    //   167: invokevirtual 149	java/io/FileReader:close	()V
    //   170: goto +10 -> 180
    //   173: astore 7
    //   175: aload 7
    //   177: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   180: aload 6
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	43	0	l1	long
    //   16	133	2	l2	long
    //   1	141	4	l3	long
    //   19	60	6	localObject1	Object
    //   95	3	6	localException1	Exception
    //   110	1	6	localObject2	Object
    //   128	53	6	localObject3	Object
    //   12	154	7	localObject4	Object
    //   173	3	7	localException2	Exception
    //   33	48	8	localBufferedReader	java.io.BufferedReader
    //   105	1	8	localException3	Exception
    //   118	13	8	localException4	Exception
    //   150	7	8	localObject5	Object
    //   47	18	9	str	String
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/lang/Exception
    //   143	148	95	java/lang/Exception
    //   21	35	105	java/lang/Exception
    //   42	49	105	java/lang/Exception
    //   64	74	105	java/lang/Exception
    //   80	85	105	java/lang/Exception
    //   3	14	110	finally
    //   3	14	118	java/lang/Exception
    //   21	35	150	finally
    //   42	49	150	finally
    //   64	74	150	finally
    //   80	85	150	finally
    //   130	135	150	finally
    //   165	170	173	java/lang/Exception
  }
  
  public static int getCpuNumber()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceInfoUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 1;
  }
  
  /* Error */
  public static String getCpuType()
  {
    // Byte code:
    //   0: ldc 27
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_3
    //   5: new 124	java/io/FileReader
    //   8: dup
    //   9: ldc 166
    //   11: invokespecial 129	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload_1
    //   17: astore_2
    //   18: new 131	java/io/BufferedReader
    //   21: dup
    //   22: aload 4
    //   24: sipush 8192
    //   27: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: astore 5
    //   32: ldc 168
    //   34: astore 8
    //   36: aload 8
    //   38: astore_2
    //   39: aload_2
    //   40: astore_3
    //   41: aload_3
    //   42: astore 6
    //   44: ldc 27
    //   46: astore 12
    //   48: aload_2
    //   49: astore 7
    //   51: aload 12
    //   53: ifnull +272 -> 325
    //   56: aload_1
    //   57: astore_2
    //   58: aload 5
    //   60: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 13
    //   65: aload 13
    //   67: ifnonnull +6 -> 73
    //   70: goto +255 -> 325
    //   73: aload_1
    //   74: astore_2
    //   75: aload 13
    //   77: ldc 170
    //   79: invokevirtual 176	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   82: astore 14
    //   84: aload 13
    //   86: astore 12
    //   88: aload 14
    //   90: ifnull -39 -> 51
    //   93: aload_1
    //   94: astore_2
    //   95: aload 14
    //   97: arraylength
    //   98: iconst_3
    //   99: if_icmpge +10 -> 109
    //   102: aload 13
    //   104: astore 12
    //   106: goto -55 -> 51
    //   109: aload_1
    //   110: astore_2
    //   111: aload 14
    //   113: iconst_0
    //   114: aaload
    //   115: invokevirtual 179	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   118: astore 12
    //   120: aload_1
    //   121: astore_2
    //   122: aload 12
    //   124: ldc 181
    //   126: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: istore_0
    //   130: aload 8
    //   132: astore 9
    //   134: iload_0
    //   135: ifeq +57 -> 192
    //   138: aload_1
    //   139: astore_2
    //   140: new 104	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   147: astore 9
    //   149: aload_1
    //   150: astore_2
    //   151: aload 9
    //   153: aload 8
    //   155: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: astore_2
    //   161: aload 9
    //   163: aload 14
    //   165: iconst_2
    //   166: aload 14
    //   168: arraylength
    //   169: invokestatic 188	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   172: ldc 190
    //   174: ldc 192
    //   176: invokevirtual 195	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   179: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore_2
    //   185: aload 9
    //   187: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: aload 7
    //   194: astore 10
    //   196: aload_1
    //   197: astore_2
    //   198: aload 12
    //   200: ldc 197
    //   202: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   205: ifeq +23 -> 228
    //   208: aload_1
    //   209: astore_2
    //   210: aload 14
    //   212: iconst_2
    //   213: aload 14
    //   215: arraylength
    //   216: invokestatic 188	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   219: ldc 190
    //   221: ldc 192
    //   223: invokevirtual 195	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 10
    //   228: aload_3
    //   229: astore 11
    //   231: aload_1
    //   232: astore_2
    //   233: aload 12
    //   235: ldc 199
    //   237: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   240: ifeq +23 -> 263
    //   243: aload_1
    //   244: astore_2
    //   245: aload 14
    //   247: iconst_2
    //   248: aload 14
    //   250: arraylength
    //   251: invokestatic 188	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   254: ldc 190
    //   256: ldc 192
    //   258: invokevirtual 195	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   261: astore 11
    //   263: aload 13
    //   265: astore 12
    //   267: aload 9
    //   269: astore 8
    //   271: aload 10
    //   273: astore 7
    //   275: aload 11
    //   277: astore_3
    //   278: aload_1
    //   279: astore_2
    //   280: aload 14
    //   282: iconst_1
    //   283: aaload
    //   284: invokevirtual 179	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   287: ldc 201
    //   289: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   292: ifeq -241 -> 51
    //   295: aload_1
    //   296: astore_2
    //   297: aload 14
    //   299: aload 14
    //   301: arraylength
    //   302: iconst_1
    //   303: isub
    //   304: aaload
    //   305: astore 6
    //   307: aload 13
    //   309: astore 12
    //   311: aload 9
    //   313: astore 8
    //   315: aload 10
    //   317: astore 7
    //   319: aload 11
    //   321: astore_3
    //   322: goto -271 -> 51
    //   325: aload_1
    //   326: astore_2
    //   327: new 104	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   334: astore 9
    //   336: aload_1
    //   337: astore_2
    //   338: aload 9
    //   340: aload 8
    //   342: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_1
    //   347: astore_2
    //   348: aload 9
    //   350: ldc 203
    //   352: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: astore_2
    //   358: aload 9
    //   360: aload 7
    //   362: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: astore_2
    //   368: aload 9
    //   370: ldc 203
    //   372: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: astore_2
    //   378: aload 9
    //   380: aload_3
    //   381: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_1
    //   386: astore_2
    //   387: aload 9
    //   389: ldc 203
    //   391: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: astore_2
    //   397: aload 9
    //   399: aload 6
    //   401: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: astore_2
    //   407: aload 9
    //   409: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: astore_1
    //   413: aload_1
    //   414: astore_2
    //   415: aload 5
    //   417: invokevirtual 148	java/io/BufferedReader:close	()V
    //   420: aload_1
    //   421: astore_2
    //   422: aload 4
    //   424: invokevirtual 149	java/io/FileReader:close	()V
    //   427: aload_1
    //   428: areturn
    //   429: astore_1
    //   430: aload 5
    //   432: astore_2
    //   433: aload 4
    //   435: astore_3
    //   436: goto +83 -> 519
    //   439: astore_3
    //   440: aload 5
    //   442: astore_1
    //   443: goto +15 -> 458
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_2
    //   449: aload 4
    //   451: astore_3
    //   452: goto +67 -> 519
    //   455: astore_3
    //   456: aconst_null
    //   457: astore_1
    //   458: aload 4
    //   460: astore 5
    //   462: aload_2
    //   463: astore 4
    //   465: aload_3
    //   466: astore 6
    //   468: aload_1
    //   469: astore_2
    //   470: aload 5
    //   472: astore_3
    //   473: goto +18 -> 491
    //   476: astore_1
    //   477: aconst_null
    //   478: astore_2
    //   479: aload_2
    //   480: astore_3
    //   481: goto +38 -> 519
    //   484: astore 6
    //   486: aconst_null
    //   487: astore_2
    //   488: aload_1
    //   489: astore 4
    //   491: aload 6
    //   493: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   496: aload_3
    //   497: ifnull +10 -> 507
    //   500: aload_3
    //   501: invokevirtual 149	java/io/FileReader:close	()V
    //   504: goto +3 -> 507
    //   507: aload_2
    //   508: ifnull +7 -> 515
    //   511: aload_2
    //   512: invokevirtual 148	java/io/BufferedReader:close	()V
    //   515: aload 4
    //   517: areturn
    //   518: astore_1
    //   519: aload_3
    //   520: ifnull +10 -> 530
    //   523: aload_3
    //   524: invokevirtual 149	java/io/FileReader:close	()V
    //   527: goto +3 -> 530
    //   530: aload_2
    //   531: ifnull +7 -> 538
    //   534: aload_2
    //   535: invokevirtual 148	java/io/BufferedReader:close	()V
    //   538: goto +5 -> 543
    //   541: aload_1
    //   542: athrow
    //   543: goto -2 -> 541
    //   546: astore_1
    //   547: goto -40 -> 507
    //   550: astore_1
    //   551: aload 4
    //   553: areturn
    //   554: astore_3
    //   555: goto -25 -> 530
    //   558: astore_2
    //   559: goto -21 -> 538
    // Local variable table:
    //   start	length	slot	name	signature
    //   129	6	0	bool	boolean
    //   2	426	1	str1	String
    //   429	1	1	localObject1	Object
    //   442	1	1	localObject2	Object
    //   446	1	1	localObject3	Object
    //   457	12	1	localObject4	Object
    //   476	13	1	localObject5	Object
    //   518	24	1	localObject6	Object
    //   546	1	1	localException1	Exception
    //   550	1	1	localException2	Exception
    //   17	518	2	localObject7	Object
    //   558	1	2	localException3	Exception
    //   4	432	3	localObject8	Object
    //   439	1	3	localException4	Exception
    //   451	1	3	localObject9	Object
    //   455	11	3	localException5	Exception
    //   472	52	3	localObject10	Object
    //   554	1	3	localException6	Exception
    //   14	538	4	localObject11	Object
    //   30	441	5	localObject12	Object
    //   42	425	6	localObject13	Object
    //   484	8	6	localException7	Exception
    //   49	312	7	localObject14	Object
    //   34	307	8	localObject15	Object
    //   132	276	9	localObject16	Object
    //   194	122	10	localObject17	Object
    //   229	91	11	localObject18	Object
    //   46	264	12	localObject19	Object
    //   63	245	13	str2	String
    //   82	218	14	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   58	65	429	finally
    //   75	84	429	finally
    //   95	102	429	finally
    //   111	120	429	finally
    //   122	130	429	finally
    //   140	149	429	finally
    //   151	159	429	finally
    //   161	183	429	finally
    //   185	192	429	finally
    //   198	208	429	finally
    //   210	228	429	finally
    //   233	243	429	finally
    //   245	263	429	finally
    //   280	295	429	finally
    //   297	307	429	finally
    //   327	336	429	finally
    //   338	346	429	finally
    //   348	356	429	finally
    //   358	366	429	finally
    //   368	376	429	finally
    //   378	385	429	finally
    //   387	395	429	finally
    //   397	405	429	finally
    //   407	413	429	finally
    //   415	420	429	finally
    //   58	65	439	java/lang/Exception
    //   75	84	439	java/lang/Exception
    //   95	102	439	java/lang/Exception
    //   111	120	439	java/lang/Exception
    //   122	130	439	java/lang/Exception
    //   140	149	439	java/lang/Exception
    //   151	159	439	java/lang/Exception
    //   161	183	439	java/lang/Exception
    //   185	192	439	java/lang/Exception
    //   198	208	439	java/lang/Exception
    //   210	228	439	java/lang/Exception
    //   233	243	439	java/lang/Exception
    //   245	263	439	java/lang/Exception
    //   280	295	439	java/lang/Exception
    //   297	307	439	java/lang/Exception
    //   327	336	439	java/lang/Exception
    //   338	346	439	java/lang/Exception
    //   348	356	439	java/lang/Exception
    //   358	366	439	java/lang/Exception
    //   368	376	439	java/lang/Exception
    //   378	385	439	java/lang/Exception
    //   387	395	439	java/lang/Exception
    //   397	405	439	java/lang/Exception
    //   407	413	439	java/lang/Exception
    //   415	420	439	java/lang/Exception
    //   18	32	446	finally
    //   422	427	446	finally
    //   18	32	455	java/lang/Exception
    //   422	427	455	java/lang/Exception
    //   5	16	476	finally
    //   5	16	484	java/lang/Exception
    //   491	496	518	finally
    //   500	504	546	java/lang/Exception
    //   511	515	550	java/lang/Exception
    //   523	527	554	java/lang/Exception
    //   534	538	558	java/lang/Exception
  }
  
  public static SimInfo getDataSimInfo(Context paramContext)
  {
    SimManager localSimManager = SimManager.getInstance(Build.MODEL, Build.VERSION.SDK_INT);
    localSimManager.initAllInfo(paramContext);
    return localSimManager.getDataSimInfo();
  }
  
  public static String getDeviceBrand()
  {
    String str2 = Build.BRAND;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getDeviceModel()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getDeviceOSVersion()
  {
    String str2 = Build.VERSION.RELEASE;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getIMEI(Context paramContext)
  {
    paramContext = deviceId;
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return deviceId;
    }
    deviceId = PlatformInfor.g().getIMEI();
    if (deviceId == null) {
      deviceId = "";
    }
    return deviceId;
  }
  
  public static String getIMSI(Context paramContext)
  {
    if (!mRegisterHandler)
    {
      NetworkState.addListener(new DeviceInfoUtil.1());
      mRegisterHandler = true;
    }
    Object localObject1 = imsi;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
      imsi = ((TelephonyManager)localObject1).getSubscriberId();
      if (TextUtils.isEmpty(imsi)) {
        imsi = ((TelephonyManager)localObject1).getSimOperator();
      }
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Integer localInteger = new Integer(1);
      boolean bool = TextUtils.isEmpty(imsi);
      if (bool) {
        try
        {
          Method localMethod = localObject1.getClass().getDeclaredMethod("getSubscriberIdGemini", arrayOfClass);
          localMethod.setAccessible(true);
          imsi = (String)localMethod.invoke(localObject1, new Object[] { localInteger });
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get MTK imsi error:");
          localStringBuilder.append(localThrowable.getMessage());
          QZLog.e("UniKingCardHelper/DeviceInfoUtil", localStringBuilder.toString());
          imsi = "";
        }
      }
      bool = TextUtils.isEmpty(imsi);
      if (bool) {
        try
        {
          localObject2 = Class.forName("com.android.internal.telephony.PhoneFactory");
          imsi = ((TelephonyManager)paramContext.getSystemService((String)((Class)localObject2).getMethod("getServiceName", new Class[] { String.class, Integer.TYPE }).invoke(localObject2, new Object[] { "phone", Integer.valueOf(1) }))).getSubscriberId();
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get Zhanxun imsi error:");
          ((StringBuilder)localObject2).append(paramContext.getMessage());
          QZLog.e("UniKingCardHelper/DeviceInfoUtil", ((StringBuilder)localObject2).toString());
          imsi = "";
        }
      }
      bool = TextUtils.isEmpty(imsi);
      if (bool) {
        try
        {
          paramContext = localObject1.getClass().getDeclaredMethod("getSimSerialNumber", arrayOfClass);
          paramContext.setAccessible(true);
          imsi = (String)paramContext.invoke(localObject1, new Object[] { localInteger });
        }
        catch (Throwable paramContext)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("get GaoTong imsi error:");
          ((StringBuilder)localObject1).append(paramContext.getMessage());
          QZLog.e("UniKingCardHelper/DeviceInfoUtil", ((StringBuilder)localObject1).toString());
          paramContext.printStackTrace();
          imsi = "";
        }
      }
      if (TextUtils.isEmpty(imsi)) {
        imsi = "";
      }
      paramContext = imsi;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label437:
      break label437;
    }
    imsi = "";
    return "";
  }
  
  public static int getOsVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String getPhoneNum(Context paramContext)
  {
    return "";
  }
  
  public static String getProcessName(Context paramContext)
  {
    int i = Process.myPid();
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i)
            {
              paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
              return paramContext;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception happened!");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QZLog.e("UniKingCardHelper/DeviceInfoUtil", ((StringBuilder)localObject).toString());
      }
    }
    return "";
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVersionCode error:");
      localStringBuilder.append(paramContext.getMessage());
      QZLog.e("AppSetting", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int getVersionCode(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getVersionCode error:");
      paramString.append(paramContext.getMessage());
      QZLog.e("AppSetting", paramString.toString());
    }
    return 0;
  }
  
  private static String subStrings2String(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramArrayOfString == null) {
      return "";
    }
    Object localObject = str;
    if (paramInt1 >= 0)
    {
      if (paramArrayOfString.length < paramInt2) {
        return "";
      }
      paramInt1 = 2;
      for (;;)
      {
        localObject = str;
        if (paramInt1 >= paramArrayOfString.length) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramArrayOfString[paramInt1]);
        ((StringBuilder)localObject).append(" ");
        str = ((StringBuilder)localObject).toString();
        paramInt1 += 1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.sim.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */