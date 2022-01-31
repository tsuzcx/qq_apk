package com.tencent.qapmsdk.memory;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DumpMemInfoHandler
{
  private static final int APK_MMAP = 7;
  private static final int ASHMEM = 3;
  private static final int COUNT = 12;
  private static final int CURSOR = 2;
  private static final int DALVIK = 1;
  private static final int DEX_MMAP = 9;
  private static final String[] HeapName;
  private static final int JAR_MMAP = 6;
  private static final String LOG_PATH = FileUtil.getRootPath() + "/Log/";
  private static final int NATIVE = 0;
  private static final int OTHER_DEV = 4;
  private static final int OTHER_MMAP = 10;
  private static final int SO_MMAP = 5;
  private static final String TAG = "QAPM_memory_DumpMemInfoHandler";
  private static final int TTF_MMAP = 8;
  private static final int UNKNOWN = 11;
  
  static
  {
    HeapName = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    File localFile = new File(LOG_PATH);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
  }
  
  public static String generateDetailMemory(@NonNull ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    Object localObject = null;
    String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
    ArrayList localArrayList1 = new ArrayList(12);
    ArrayList localArrayList2 = new ArrayList(12);
    int i = 0;
    while (i < 12)
    {
      DumpMemInfoHandler.StatFields localStatFields = new DumpMemInfoHandler.StatFields(null);
      HashMap localHashMap = new HashMap();
      localArrayList1.add(localStatFields);
      localArrayList2.add(localHashMap);
      i += 1;
    }
    i = readMapinfo(str, localArrayList1, localArrayList2);
    if (i > 0) {
      paramRunningAppProcessInfo = writeMapinfoToLog(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
    }
    do
    {
      return paramRunningAppProcessInfo;
      paramRunningAppProcessInfo = localObject;
    } while (i < 0);
    return "";
  }
  
  public static Object[] generateHprof(String paramString)
  {
    boolean bool = true;
    Object localObject = "";
    for (;;)
    {
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "ReportLog dumpHprof: ", paramString });
        String str2 = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localObject = new File(LOG_PATH);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          String str1 = ((File)localObject).getAbsolutePath();
          localObject = str1;
          if (!str1.endsWith("/")) {
            localObject = str1 + "/";
          }
          localObject = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";
          try
          {
            Debug.dumpHprofData((String)localObject);
            return new Object[] { Boolean.valueOf(bool), localObject };
          }
          catch (Throwable paramString)
          {
            Logger.INSTANCE.exception("QAPM_memory_DumpMemInfoHandler", paramString);
          }
        }
        bool = false;
      }
      finally {}
    }
  }
  
  /* Error */
  @NonNull
  public static String generateThreadTrace()
  {
    // Byte code:
    //   0: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   3: ldc 167
    //   5: invokestatic 171	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 62	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   19: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 218
    //   24: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 220
    //   33: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 226	java/lang/Thread:activeCount	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +6 -> 52
    //   49: ldc 142
    //   51: areturn
    //   52: iload_2
    //   53: anewarray 222	java/lang/Thread
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 230	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   61: pop
    //   62: new 42	java/lang/StringBuilder
    //   65: dup
    //   66: iload_2
    //   67: sipush 1024
    //   70: imul
    //   71: invokespecial 231	java/lang/StringBuilder:<init>	(I)V
    //   74: astore 5
    //   76: iconst_0
    //   77: istore_0
    //   78: iload_0
    //   79: iload_2
    //   80: if_icmpge +123 -> 203
    //   83: aload_3
    //   84: iload_0
    //   85: aaload
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +10 -> 100
    //   93: iload_0
    //   94: iconst_1
    //   95: iadd
    //   96: istore_0
    //   97: goto -19 -> 78
    //   100: aload 4
    //   102: invokevirtual 234	java/lang/Thread:isAlive	()Z
    //   105: ifeq +87 -> 192
    //   108: aload 5
    //   110: ldc 236
    //   112: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: aload 4
    //   120: invokevirtual 239	java/lang/Thread:getName	()Ljava/lang/String;
    //   123: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: ldc 241
    //   131: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: invokevirtual 245	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   140: astore 4
    //   142: aload 4
    //   144: ifnull +48 -> 192
    //   147: iconst_0
    //   148: istore_1
    //   149: iload_1
    //   150: aload 4
    //   152: arraylength
    //   153: if_icmpge +39 -> 192
    //   156: aload 5
    //   158: ldc 247
    //   160: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload 4
    //   168: iload_1
    //   169: aaload
    //   170: invokevirtual 250	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   173: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: ldc 241
    //   181: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -40 -> 149
    //   192: aload 5
    //   194: ldc 241
    //   196: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -107 -> 93
    //   203: new 252	java/io/FileWriter
    //   206: dup
    //   207: aload 6
    //   209: iconst_0
    //   210: invokespecial 255	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: aload 4
    //   220: aload 5
    //   222: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 258	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   228: aload 4
    //   230: astore_3
    //   231: aload 4
    //   233: invokevirtual 261	java/io/FileWriter:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 261	java/io/FileWriter:close	()V
    //   246: aload 6
    //   248: areturn
    //   249: astore_3
    //   250: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   253: ldc 34
    //   255: aload_3
    //   256: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -13 -> 246
    //   262: astore 5
    //   264: aconst_null
    //   265: astore 4
    //   267: aload 4
    //   269: astore_3
    //   270: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   273: ldc 34
    //   275: aload 5
    //   277: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: aload 4
    //   282: ifnull -36 -> 246
    //   285: aload 4
    //   287: invokevirtual 261	java/io/FileWriter:close	()V
    //   290: goto -44 -> 246
    //   293: astore_3
    //   294: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   297: ldc 34
    //   299: aload_3
    //   300: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: goto -57 -> 246
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 261	java/io/FileWriter:close	()V
    //   318: aload 4
    //   320: athrow
    //   321: astore_3
    //   322: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   325: ldc 34
    //   327: aload_3
    //   328: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: goto -13 -> 318
    //   334: astore 4
    //   336: goto -26 -> 310
    //   339: astore 5
    //   341: goto -74 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	20	0	i	int
    //   148	41	1	j	int
    //   44	37	2	k	int
    //   8	223	3	localObject1	Object
    //   249	7	3	localException1	java.lang.Exception
    //   269	1	3	localObject2	Object
    //   293	7	3	localException2	java.lang.Exception
    //   309	6	3	localObject3	Object
    //   321	7	3	localException3	java.lang.Exception
    //   86	200	4	localObject4	Object
    //   306	13	4	localObject5	Object
    //   334	1	4	localObject6	Object
    //   74	147	5	localStringBuilder	java.lang.StringBuilder
    //   262	14	5	localIOException1	IOException
    //   339	1	5	localIOException2	IOException
    //   39	208	6	str	String
    // Exception table:
    //   from	to	target	type
    //   241	246	249	java/lang/Exception
    //   203	215	262	java/io/IOException
    //   285	290	293	java/lang/Exception
    //   203	215	306	finally
    //   314	318	321	java/lang/Exception
    //   218	228	334	finally
    //   231	236	334	finally
    //   270	280	334	finally
    //   218	228	339	java/io/IOException
    //   231	236	339	java/io/IOException
  }
  
  public static String generateTraces()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((i >= 3) || (j != 0)) {
        break label103;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        j = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_DumpMemInfoHandler", "generateTraces exception: ", localIOException.toString() });
        }
      }
      i += 1;
    }
    label103:
    return "/data/anr/traces.txt";
  }
  
  private static String getFormatTime(long paramLong, @NonNull String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString, Locale.US).format(localDate);
  }
  
  private static String getProcFileName(@Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String[] arrayOfString;
    String str;
    do
    {
      return paramString;
      arrayOfString = paramString.split(":");
      paramString = arrayOfString[0].split("\\.");
      str = paramString[(paramString.length - 1)];
      paramString = str;
    } while (arrayOfString.length <= 1);
    return str + "_" + arrayOfString[1];
  }
  
  @NonNull
  private static Map.Entry<?, ?>[] getSortedHashtableByValue(Map<?, ?> paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new DumpMemInfoHandler.1());
    return paramMap;
  }
  
  /* Error */
  private static int readMapinfo(@NonNull String paramString, @NonNull List<DumpMemInfoHandler.StatFields> paramList, @NonNull List<Map<String, java.lang.Integer>> paramList1)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 7
    //   9: ldc 142
    //   11: astore 18
    //   13: iconst_0
    //   14: istore_3
    //   15: new 80	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 87	java/io/File:exists	()Z
    //   26: ifeq +13 -> 39
    //   29: iconst_1
    //   30: istore_3
    //   31: iload_3
    //   32: ifne +24 -> 56
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: ireturn
    //   39: ldc2_w 358
    //   42: invokestatic 362	java/lang/Thread:sleep	(J)V
    //   45: iload_3
    //   46: bipush 10
    //   48: if_icmplt +1083 -> 1131
    //   51: iconst_0
    //   52: istore_3
    //   53: goto -22 -> 31
    //   56: new 364	java/io/BufferedReader
    //   59: dup
    //   60: new 366	java/io/FileReader
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 367	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   68: invokespecial 370	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore 20
    //   73: aload 20
    //   75: invokevirtual 373	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore 19
    //   80: bipush 11
    //   82: istore 6
    //   84: ldc 142
    //   86: astore_0
    //   87: lconst_0
    //   88: lstore 12
    //   90: iconst_0
    //   91: istore 4
    //   93: iconst_0
    //   94: istore 5
    //   96: goto +1042 -> 1138
    //   99: aload 19
    //   101: invokevirtual 376	java/lang/String:length	()I
    //   104: iconst_1
    //   105: if_icmpge +10 -> 115
    //   108: bipush 11
    //   110: istore 6
    //   112: goto +1026 -> 1138
    //   115: aload 19
    //   117: invokevirtual 376	java/lang/String:length	()I
    //   120: bipush 30
    //   122: if_icmple +1129 -> 1251
    //   125: aload 19
    //   127: bipush 8
    //   129: invokevirtual 380	java/lang/String:charAt	(I)C
    //   132: bipush 45
    //   134: if_icmpne +1117 -> 1251
    //   137: aload 19
    //   139: bipush 17
    //   141: invokevirtual 380	java/lang/String:charAt	(I)C
    //   144: bipush 32
    //   146: if_icmpne +1105 -> 1251
    //   149: aload 19
    //   151: ldc_w 382
    //   154: invokevirtual 321	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   157: astore_0
    //   158: aload_0
    //   159: iconst_0
    //   160: aaload
    //   161: ldc_w 384
    //   164: invokevirtual 321	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   167: astore 19
    //   169: aload 19
    //   171: iconst_0
    //   172: aaload
    //   173: bipush 16
    //   175: invokestatic 390	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   178: lstore 16
    //   180: aload 19
    //   182: iconst_1
    //   183: aaload
    //   184: bipush 16
    //   186: invokestatic 390	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   189: lstore 14
    //   191: iconst_5
    //   192: istore_3
    //   193: iload_3
    //   194: aload_0
    //   195: arraylength
    //   196: if_icmpge +21 -> 217
    //   199: aload_0
    //   200: iload_3
    //   201: aaload
    //   202: ldc 142
    //   204: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifeq +10 -> 217
    //   210: iload_3
    //   211: iconst_1
    //   212: iadd
    //   213: istore_3
    //   214: goto -21 -> 193
    //   217: iload_3
    //   218: aload_0
    //   219: arraylength
    //   220: if_icmpge +977 -> 1197
    //   223: aload_0
    //   224: iload_3
    //   225: aaload
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 376	java/lang/String:length	()I
    //   231: istore_3
    //   232: aload_0
    //   233: ldc_w 392
    //   236: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +187 -> 426
    //   242: iconst_0
    //   243: istore_3
    //   244: aload_0
    //   245: astore 19
    //   247: goto +915 -> 1162
    //   250: aload 20
    //   252: invokevirtual 373	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore 19
    //   257: aload 19
    //   259: ifnonnull +333 -> 592
    //   262: iconst_1
    //   263: istore 8
    //   265: iload 10
    //   267: ifne +837 -> 1104
    //   270: aload_2
    //   271: iload 7
    //   273: invokeinterface 396 2 0
    //   278: checkcast 327	java/util/Map
    //   281: astore 18
    //   283: aload 18
    //   285: aload_0
    //   286: invokeinterface 399 2 0
    //   291: ifeq +685 -> 976
    //   294: aload 18
    //   296: aload_0
    //   297: aload 18
    //   299: aload_0
    //   300: invokeinterface 402 2 0
    //   305: checkcast 404	java/lang/Integer
    //   308: invokevirtual 407	java/lang/Integer:intValue	()I
    //   311: iload_3
    //   312: iadd
    //   313: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: invokeinterface 414 3 0
    //   321: pop
    //   322: aload_1
    //   323: iload 7
    //   325: invokeinterface 396 2 0
    //   330: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   333: astore 18
    //   335: aload 18
    //   337: aload 18
    //   339: invokestatic 418	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   342: iload_3
    //   343: i2l
    //   344: ladd
    //   345: invokestatic 422	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$102	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;J)J
    //   348: pop2
    //   349: aload_1
    //   350: iload 7
    //   352: invokeinterface 396 2 0
    //   357: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   360: astore 18
    //   362: aload 18
    //   364: aload 18
    //   366: getfield 426	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   369: iload 5
    //   371: i2l
    //   372: ladd
    //   373: putfield 426	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   376: aload_1
    //   377: iload 7
    //   379: invokeinterface 396 2 0
    //   384: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   387: astore 18
    //   389: aload 18
    //   391: aload 18
    //   393: getfield 429	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   396: iload 4
    //   398: i2l
    //   399: ladd
    //   400: putfield 429	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   403: iload 9
    //   405: iload_3
    //   406: iadd
    //   407: istore 9
    //   409: aload_0
    //   410: astore 18
    //   412: iload 7
    //   414: istore 6
    //   416: iload 5
    //   418: istore 7
    //   420: iload_3
    //   421: istore 5
    //   423: goto +715 -> 1138
    //   426: aload_0
    //   427: ldc_w 431
    //   430: invokevirtual 434	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   433: ifeq +11 -> 444
    //   436: iconst_1
    //   437: istore_3
    //   438: aload_0
    //   439: astore 19
    //   441: goto +721 -> 1162
    //   444: aload_0
    //   445: ldc_w 436
    //   448: invokevirtual 434	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   451: ifeq +11 -> 462
    //   454: iconst_2
    //   455: istore_3
    //   456: aload_0
    //   457: astore 19
    //   459: goto +703 -> 1162
    //   462: aload_0
    //   463: ldc_w 438
    //   466: invokevirtual 434	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   469: ifeq +11 -> 480
    //   472: iconst_3
    //   473: istore_3
    //   474: aload_0
    //   475: astore 19
    //   477: goto +685 -> 1162
    //   480: aload_0
    //   481: ldc_w 440
    //   484: invokevirtual 434	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   487: ifeq +11 -> 498
    //   490: iconst_4
    //   491: istore_3
    //   492: aload_0
    //   493: astore 19
    //   495: goto +667 -> 1162
    //   498: aload_0
    //   499: ldc_w 442
    //   502: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   505: ifeq +11 -> 516
    //   508: iconst_5
    //   509: istore_3
    //   510: aload_0
    //   511: astore 19
    //   513: goto +649 -> 1162
    //   516: aload_0
    //   517: ldc_w 444
    //   520: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   523: ifeq +12 -> 535
    //   526: bipush 6
    //   528: istore_3
    //   529: aload_0
    //   530: astore 19
    //   532: goto +630 -> 1162
    //   535: aload_0
    //   536: ldc_w 446
    //   539: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   542: ifeq +12 -> 554
    //   545: bipush 7
    //   547: istore_3
    //   548: aload_0
    //   549: astore 19
    //   551: goto +611 -> 1162
    //   554: aload_0
    //   555: ldc_w 448
    //   558: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   561: ifeq +12 -> 573
    //   564: bipush 8
    //   566: istore_3
    //   567: aload_0
    //   568: astore 19
    //   570: goto +592 -> 1162
    //   573: aload_0
    //   574: ldc_w 450
    //   577: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   580: ifeq +623 -> 1203
    //   583: bipush 9
    //   585: istore_3
    //   586: aload_0
    //   587: astore 19
    //   589: goto +573 -> 1162
    //   592: aload 19
    //   594: ldc_w 382
    //   597: invokevirtual 321	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   600: astore 22
    //   602: aload 22
    //   604: iconst_0
    //   605: aaload
    //   606: astore 21
    //   608: iconst_1
    //   609: istore 6
    //   611: iload 6
    //   613: aload 22
    //   615: arraylength
    //   616: if_icmpge +25 -> 641
    //   619: aload 22
    //   621: iload 6
    //   623: aaload
    //   624: ldc 142
    //   626: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   629: ifeq +12 -> 641
    //   632: iload 6
    //   634: iconst_1
    //   635: iadd
    //   636: istore 6
    //   638: goto -27 -> 611
    //   641: iload 6
    //   643: aload 22
    //   645: arraylength
    //   646: if_icmpge +639 -> 1285
    //   649: aload 22
    //   651: iload 6
    //   653: aaload
    //   654: invokestatic 454	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   657: istore 6
    //   659: aload 21
    //   661: ldc_w 456
    //   664: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   667: ifeq +53 -> 720
    //   670: iload_3
    //   671: istore 6
    //   673: iload 5
    //   675: istore_3
    //   676: iload 6
    //   678: istore 5
    //   680: goto +592 -> 1272
    //   683: astore 22
    //   685: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   688: iconst_3
    //   689: anewarray 64	java/lang/String
    //   692: dup
    //   693: iconst_0
    //   694: ldc 34
    //   696: aastore
    //   697: dup
    //   698: iconst_1
    //   699: ldc_w 458
    //   702: aastore
    //   703: dup
    //   704: iconst_2
    //   705: aload 22
    //   707: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   710: aastore
    //   711: invokevirtual 464	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   714: iconst_0
    //   715: istore 6
    //   717: goto -58 -> 659
    //   720: aload 21
    //   722: ldc_w 466
    //   725: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   728: ifeq +16 -> 744
    //   731: iload_3
    //   732: istore 6
    //   734: iload 5
    //   736: istore_3
    //   737: iload 6
    //   739: istore 5
    //   741: goto +531 -> 1272
    //   744: aload 21
    //   746: ldc_w 468
    //   749: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   752: ifeq +13 -> 765
    //   755: iload 5
    //   757: istore_3
    //   758: iload 6
    //   760: istore 5
    //   762: goto +510 -> 1272
    //   765: aload 21
    //   767: ldc_w 470
    //   770: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifeq +16 -> 789
    //   776: iload_3
    //   777: istore 6
    //   779: iload 5
    //   781: istore_3
    //   782: iload 6
    //   784: istore 5
    //   786: goto +486 -> 1272
    //   789: aload 21
    //   791: ldc_w 472
    //   794: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   797: ifeq +20 -> 817
    //   800: iload 6
    //   802: istore 4
    //   804: iload 5
    //   806: istore 6
    //   808: iload_3
    //   809: istore 5
    //   811: iload 6
    //   813: istore_3
    //   814: goto +458 -> 1272
    //   817: aload 21
    //   819: ldc_w 474
    //   822: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   825: ifeq +16 -> 841
    //   828: iload_3
    //   829: istore 6
    //   831: iload 5
    //   833: istore_3
    //   834: iload 6
    //   836: istore 5
    //   838: goto +434 -> 1272
    //   841: aload 21
    //   843: ldc_w 476
    //   846: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   849: ifeq +12 -> 861
    //   852: iload_3
    //   853: istore 5
    //   855: iload 6
    //   857: istore_3
    //   858: goto +414 -> 1272
    //   861: aload 21
    //   863: ldc_w 478
    //   866: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   869: ifeq +16 -> 885
    //   872: iload_3
    //   873: istore 6
    //   875: iload 5
    //   877: istore_3
    //   878: iload 6
    //   880: istore 5
    //   882: goto +390 -> 1272
    //   885: aload 19
    //   887: invokevirtual 376	java/lang/String:length	()I
    //   890: bipush 30
    //   892: if_icmple +226 -> 1118
    //   895: aload 19
    //   897: bipush 8
    //   899: invokevirtual 380	java/lang/String:charAt	(I)C
    //   902: bipush 45
    //   904: if_icmpne +214 -> 1118
    //   907: aload 19
    //   909: bipush 17
    //   911: invokevirtual 380	java/lang/String:charAt	(I)C
    //   914: bipush 32
    //   916: if_icmpne +202 -> 1118
    //   919: getstatic 482	java/lang/System:out	Ljava/io/PrintStream;
    //   922: aload 19
    //   924: invokevirtual 487	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   927: goto -662 -> 265
    //   930: astore_0
    //   931: iconst_m1
    //   932: istore_3
    //   933: aload 20
    //   935: ifnull -898 -> 37
    //   938: aload 20
    //   940: invokevirtual 488	java/io/BufferedReader:close	()V
    //   943: iconst_m1
    //   944: ireturn
    //   945: astore_0
    //   946: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   949: iconst_3
    //   950: anewarray 64	java/lang/String
    //   953: dup
    //   954: iconst_0
    //   955: ldc 34
    //   957: aastore
    //   958: dup
    //   959: iconst_1
    //   960: ldc_w 490
    //   963: aastore
    //   964: dup
    //   965: iconst_2
    //   966: aload_0
    //   967: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   970: aastore
    //   971: invokevirtual 464	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   974: iconst_m1
    //   975: ireturn
    //   976: aload 18
    //   978: aload_0
    //   979: iload_3
    //   980: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   983: invokeinterface 414 3 0
    //   988: pop
    //   989: goto -667 -> 322
    //   992: astore_0
    //   993: aload 20
    //   995: ifnull +8 -> 1003
    //   998: aload 20
    //   1000: invokevirtual 488	java/io/BufferedReader:close	()V
    //   1003: aload_0
    //   1004: athrow
    //   1005: aload 20
    //   1007: ifnull +94 -> 1101
    //   1010: aload 20
    //   1012: invokevirtual 488	java/io/BufferedReader:close	()V
    //   1015: iload 9
    //   1017: ireturn
    //   1018: astore_0
    //   1019: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1022: iconst_3
    //   1023: anewarray 64	java/lang/String
    //   1026: dup
    //   1027: iconst_0
    //   1028: ldc 34
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_1
    //   1033: ldc_w 490
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_2
    //   1039: aload_0
    //   1040: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1043: aastore
    //   1044: invokevirtual 464	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1047: iload 9
    //   1049: ireturn
    //   1050: astore_1
    //   1051: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1054: iconst_3
    //   1055: anewarray 64	java/lang/String
    //   1058: dup
    //   1059: iconst_0
    //   1060: ldc 34
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_1
    //   1065: ldc_w 490
    //   1068: aastore
    //   1069: dup
    //   1070: iconst_2
    //   1071: aload_1
    //   1072: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1075: aastore
    //   1076: invokevirtual 464	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1079: goto -76 -> 1003
    //   1082: astore 19
    //   1084: goto -1039 -> 45
    //   1087: astore_0
    //   1088: aconst_null
    //   1089: astore 20
    //   1091: goto -98 -> 993
    //   1094: astore_0
    //   1095: aconst_null
    //   1096: astore 20
    //   1098: goto -167 -> 931
    //   1101: iload 9
    //   1103: ireturn
    //   1104: iload 7
    //   1106: istore 6
    //   1108: iload 5
    //   1110: istore 7
    //   1112: iload_3
    //   1113: istore 5
    //   1115: goto +23 -> 1138
    //   1118: iload_3
    //   1119: istore 6
    //   1121: iload 5
    //   1123: istore_3
    //   1124: iload 6
    //   1126: istore 5
    //   1128: goto +144 -> 1272
    //   1131: iload_3
    //   1132: iconst_1
    //   1133: iadd
    //   1134: istore_3
    //   1135: goto -1120 -> 15
    //   1138: iload 8
    //   1140: ifne -135 -> 1005
    //   1143: bipush 11
    //   1145: istore 10
    //   1147: aload 19
    //   1149: ifnonnull -1050 -> 99
    //   1152: iconst_1
    //   1153: istore 8
    //   1155: bipush 11
    //   1157: istore 6
    //   1159: goto -21 -> 1138
    //   1162: aload 19
    //   1164: astore_0
    //   1165: iconst_0
    //   1166: istore 11
    //   1168: iload 5
    //   1170: istore 6
    //   1172: lload 14
    //   1174: lstore 12
    //   1176: iload_3
    //   1177: istore 10
    //   1179: iload 7
    //   1181: istore 5
    //   1183: iload 6
    //   1185: istore_3
    //   1186: iload 10
    //   1188: istore 7
    //   1190: iload 11
    //   1192: istore 10
    //   1194: goto -944 -> 250
    //   1197: ldc 142
    //   1199: astore_0
    //   1200: goto -973 -> 227
    //   1203: iload_3
    //   1204: ifle +12 -> 1216
    //   1207: bipush 10
    //   1209: istore_3
    //   1210: aload_0
    //   1211: astore 19
    //   1213: goto -51 -> 1162
    //   1216: iload 10
    //   1218: istore_3
    //   1219: aload_0
    //   1220: astore 19
    //   1222: lload 16
    //   1224: lload 12
    //   1226: lcmp
    //   1227: ifne -65 -> 1162
    //   1230: iload 10
    //   1232: istore_3
    //   1233: aload_0
    //   1234: astore 19
    //   1236: iload 6
    //   1238: iconst_5
    //   1239: if_icmpne -77 -> 1162
    //   1242: iconst_5
    //   1243: istore_3
    //   1244: aload 18
    //   1246: astore 19
    //   1248: goto -86 -> 1162
    //   1251: iload 5
    //   1253: istore_3
    //   1254: iconst_1
    //   1255: istore 10
    //   1257: bipush 11
    //   1259: istore 6
    //   1261: iload 7
    //   1263: istore 5
    //   1265: iload 6
    //   1267: istore 7
    //   1269: goto -1019 -> 250
    //   1272: iload 5
    //   1274: istore 6
    //   1276: iload_3
    //   1277: istore 5
    //   1279: iload 6
    //   1281: istore_3
    //   1282: goto -1032 -> 250
    //   1285: iconst_0
    //   1286: istore 6
    //   1288: goto -629 -> 659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1291	0	paramString	String
    //   0	1291	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	1291	2	paramList1	List<Map<String, java.lang.Integer>>
    //   14	1268	3	i	int
    //   91	712	4	j	int
    //   94	1184	5	k	int
    //   82	1205	6	m	int
    //   7	1261	7	n	int
    //   4	1150	8	i1	int
    //   1	1101	9	i2	int
    //   265	991	10	i3	int
    //   1166	25	11	i4	int
    //   88	1137	12	l1	long
    //   189	984	14	l2	long
    //   178	1045	16	l3	long
    //   11	1234	18	localObject1	Object
    //   78	845	19	localObject2	Object
    //   1082	81	19	localInterruptedException	java.lang.InterruptedException
    //   1211	36	19	localObject3	Object
    //   71	1026	20	localBufferedReader	java.io.BufferedReader
    //   606	256	21	str	String
    //   600	50	22	arrayOfString	String[]
    //   683	23	22	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   611	632	683	java/lang/Exception
    //   641	659	683	java/lang/Exception
    //   73	80	930	java/lang/Exception
    //   99	108	930	java/lang/Exception
    //   115	191	930	java/lang/Exception
    //   193	210	930	java/lang/Exception
    //   217	223	930	java/lang/Exception
    //   227	242	930	java/lang/Exception
    //   250	257	930	java/lang/Exception
    //   270	322	930	java/lang/Exception
    //   322	403	930	java/lang/Exception
    //   426	436	930	java/lang/Exception
    //   444	454	930	java/lang/Exception
    //   462	472	930	java/lang/Exception
    //   480	490	930	java/lang/Exception
    //   498	508	930	java/lang/Exception
    //   516	526	930	java/lang/Exception
    //   535	545	930	java/lang/Exception
    //   554	564	930	java/lang/Exception
    //   573	583	930	java/lang/Exception
    //   592	602	930	java/lang/Exception
    //   659	670	930	java/lang/Exception
    //   685	714	930	java/lang/Exception
    //   720	731	930	java/lang/Exception
    //   744	755	930	java/lang/Exception
    //   765	776	930	java/lang/Exception
    //   789	800	930	java/lang/Exception
    //   817	828	930	java/lang/Exception
    //   841	852	930	java/lang/Exception
    //   861	872	930	java/lang/Exception
    //   885	927	930	java/lang/Exception
    //   976	989	930	java/lang/Exception
    //   938	943	945	java/lang/Exception
    //   73	80	992	finally
    //   99	108	992	finally
    //   115	191	992	finally
    //   193	210	992	finally
    //   217	223	992	finally
    //   227	242	992	finally
    //   250	257	992	finally
    //   270	322	992	finally
    //   322	403	992	finally
    //   426	436	992	finally
    //   444	454	992	finally
    //   462	472	992	finally
    //   480	490	992	finally
    //   498	508	992	finally
    //   516	526	992	finally
    //   535	545	992	finally
    //   554	564	992	finally
    //   573	583	992	finally
    //   592	602	992	finally
    //   611	632	992	finally
    //   641	659	992	finally
    //   659	670	992	finally
    //   685	714	992	finally
    //   720	731	992	finally
    //   744	755	992	finally
    //   765	776	992	finally
    //   789	800	992	finally
    //   817	828	992	finally
    //   841	852	992	finally
    //   861	872	992	finally
    //   885	927	992	finally
    //   976	989	992	finally
    //   1010	1015	1018	java/lang/Exception
    //   998	1003	1050	java/lang/Exception
    //   39	45	1082	java/lang/InterruptedException
    //   56	73	1087	finally
    //   56	73	1094	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String writeMapinfoToLog(String paramString1, List<DumpMemInfoHandler.StatFields> paramList, @NonNull List<Map<String, java.lang.Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 493	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 494	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 42	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 496
    //   21: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 382
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 498
    //   42: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 501	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 6
    //   54: ldc_w 503
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_3
    //   64: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 506	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 501	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   74: pop
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: aload_1
    //   79: invokeinterface 507 1 0
    //   84: if_icmpge +148 -> 232
    //   87: aload 6
    //   89: ldc_w 509
    //   92: iconst_2
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: getstatic 78	com/tencent/qapmsdk/memory/DumpMemInfoHandler:HeapName	[Ljava/lang/String;
    //   101: iload_3
    //   102: aaload
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: iload_3
    //   108: invokeinterface 396 2 0
    //   113: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   116: invokestatic 418	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   119: invokestatic 512	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: invokestatic 506	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 501	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: aload_2
    //   131: iload_3
    //   132: invokeinterface 396 2 0
    //   137: checkcast 327	java/util/Map
    //   140: invokeinterface 513 1 0
    //   145: ifle +80 -> 225
    //   148: aload_2
    //   149: iload_3
    //   150: invokeinterface 396 2 0
    //   155: checkcast 327	java/util/Map
    //   158: invokestatic 515	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getSortedHashtableByValue	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   161: astore 7
    //   163: iconst_0
    //   164: istore 5
    //   166: iload 5
    //   168: aload 7
    //   170: arraylength
    //   171: if_icmpge +54 -> 225
    //   174: aload 6
    //   176: ldc_w 517
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 7
    //   187: iload 5
    //   189: aaload
    //   190: invokeinterface 521 1 0
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 7
    //   200: iload 5
    //   202: aaload
    //   203: invokeinterface 524 1 0
    //   208: aastore
    //   209: invokestatic 506	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokevirtual 501	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: iload 5
    //   218: iconst_1
    //   219: iadd
    //   220: istore 5
    //   222: goto -56 -> 166
    //   225: iload_3
    //   226: iconst_1
    //   227: iadd
    //   228: istore_3
    //   229: goto -152 -> 77
    //   232: aload 6
    //   234: new 42	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 496
    //   244: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 526
    //   254: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 501	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: pop
    //   264: aload 6
    //   266: invokevirtual 527	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   269: astore 6
    //   271: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   274: iconst_2
    //   275: anewarray 64	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc 34
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: aload 6
    //   287: aastore
    //   288: invokevirtual 530	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   291: new 42	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   298: getstatic 62	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   301: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 192
    //   306: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokestatic 532	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getProcFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   313: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 194
    //   318: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 4
    //   323: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 534
    //   329: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_0
    //   338: aconst_null
    //   339: astore 4
    //   341: new 536	java/io/BufferedWriter
    //   344: dup
    //   345: new 252	java/io/FileWriter
    //   348: dup
    //   349: aload_2
    //   350: invokespecial 537	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   353: invokespecial 540	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   356: astore_1
    //   357: aload_1
    //   358: aload 6
    //   360: invokevirtual 541	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 542	java/io/BufferedWriter:close	()V
    //   367: aload_2
    //   368: astore_0
    //   369: aload_1
    //   370: ifnull +9 -> 379
    //   373: aload_1
    //   374: invokevirtual 542	java/io/BufferedWriter:close	()V
    //   377: aload_2
    //   378: astore_0
    //   379: aload_0
    //   380: areturn
    //   381: astore_0
    //   382: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   385: ldc 34
    //   387: aload_0
    //   388: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_2
    //   392: areturn
    //   393: astore_2
    //   394: aload 4
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 4
    //   400: aload_1
    //   401: astore_0
    //   402: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   405: ldc 34
    //   407: aload_2
    //   408: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload 4
    //   413: astore_0
    //   414: aload_1
    //   415: ifnull -36 -> 379
    //   418: aload_1
    //   419: invokevirtual 542	java/io/BufferedWriter:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   428: ldc 34
    //   430: aload_0
    //   431: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   434: aconst_null
    //   435: areturn
    //   436: astore_2
    //   437: aload_0
    //   438: astore_1
    //   439: aload_2
    //   440: astore_0
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 542	java/io/BufferedWriter:close	()V
    //   449: aload_0
    //   450: athrow
    //   451: astore_1
    //   452: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   455: ldc 34
    //   457: aload_1
    //   458: invokevirtual 211	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   461: goto -12 -> 449
    //   464: astore_0
    //   465: goto -24 -> 441
    //   468: astore_2
    //   469: goto -72 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramString1	String
    //   0	472	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	472	2	paramList1	List<Map<String, java.lang.Integer>>
    //   0	472	3	paramInt	int
    //   0	472	4	paramString2	String
    //   164	57	5	i	int
    //   7	352	6	localObject	Object
    //   161	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   373	377	381	java/io/IOException
    //   341	357	393	java/io/IOException
    //   418	422	424	java/io/IOException
    //   341	357	436	finally
    //   402	411	436	finally
    //   445	449	451	java/io/IOException
    //   357	367	464	finally
    //   357	367	468	java/io/IOException
  }
  
  public static Object[] zipFiles(@NonNull List<String> paramList, String paramString)
  {
    String str = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    paramString = LOG_PATH + "dump_" + paramString + "_" + str + ".zip";
    return new Object[] { Boolean.valueOf(FileUtil.zipFiles(paramList, paramString)), paramString };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */