package com.tencent.qapmsdk.memory;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.memory.memorydump.IHeapDumper;
import java.io.File;
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
  private static final String[] HEAP_NAME;
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
    HEAP_NAME = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
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
  
  public static Object[] generateHprof(String paramString, IHeapDumper paramIHeapDumper)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    Object localObject = "";
    boolean bool2;
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
        paramString = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";
        bool2 = bool3;
      }
      try
      {
        long l = System.currentTimeMillis();
        bool1 = bool4;
        if (paramIHeapDumper != null)
        {
          bool2 = bool3;
          bool1 = paramIHeapDumper.dump(paramString);
        }
        bool2 = bool1;
        Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "dump used ", String.valueOf(System.currentTimeMillis() - l), " ms" });
        localObject = paramString;
      }
      catch (Throwable paramIHeapDumper)
      {
        for (;;)
        {
          Logger.INSTANCE.exception("QAPM_memory_DumpMemInfoHandler", paramIHeapDumper);
          localObject = paramString;
          bool1 = bool2;
        }
      }
      return new Object[] { Boolean.valueOf(bool1), localObject };
    }
    finally {}
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
    //   22: ldc 225
    //   24: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 227
    //   33: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 233	java/lang/Thread:activeCount	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +6 -> 52
    //   49: ldc 142
    //   51: areturn
    //   52: iload_2
    //   53: anewarray 229	java/lang/Thread
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 237	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   61: pop
    //   62: new 42	java/lang/StringBuilder
    //   65: dup
    //   66: iload_2
    //   67: sipush 1024
    //   70: imul
    //   71: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
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
    //   102: invokevirtual 241	java/lang/Thread:isAlive	()Z
    //   105: ifeq +87 -> 192
    //   108: aload 5
    //   110: ldc 243
    //   112: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: aload 4
    //   120: invokevirtual 246	java/lang/Thread:getName	()Ljava/lang/String;
    //   123: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: ldc 248
    //   131: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: invokevirtual 252	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
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
    //   158: ldc 254
    //   160: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload 4
    //   168: iload_1
    //   169: aaload
    //   170: invokevirtual 257	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   173: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: ldc 248
    //   181: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -40 -> 149
    //   192: aload 5
    //   194: ldc 248
    //   196: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -107 -> 93
    //   203: new 259	java/io/FileWriter
    //   206: dup
    //   207: aload 6
    //   209: iconst_0
    //   210: invokespecial 262	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: aload 4
    //   220: aload 5
    //   222: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 265	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   228: aload 4
    //   230: astore_3
    //   231: aload 4
    //   233: invokevirtual 268	java/io/FileWriter:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 268	java/io/FileWriter:close	()V
    //   246: aload 6
    //   248: areturn
    //   249: astore_3
    //   250: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   253: ldc 34
    //   255: aload_3
    //   256: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -13 -> 246
    //   262: astore 5
    //   264: aconst_null
    //   265: astore 4
    //   267: aload 4
    //   269: astore_3
    //   270: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   273: ldc 34
    //   275: aload 5
    //   277: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: aload 4
    //   282: ifnull -36 -> 246
    //   285: aload 4
    //   287: invokevirtual 268	java/io/FileWriter:close	()V
    //   290: goto -44 -> 246
    //   293: astore_3
    //   294: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   297: ldc 34
    //   299: aload_3
    //   300: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: goto -57 -> 246
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 268	java/io/FileWriter:close	()V
    //   318: aload 4
    //   320: athrow
    //   321: astore_3
    //   322: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   325: ldc 34
    //   327: aload_3
    //   328: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   262	14	5	localIOException1	java.io.IOException
    //   339	1	5	localIOException2	java.io.IOException
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
    //   32: ifne +39 -> 71
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: ireturn
    //   39: ldc2_w 335
    //   42: invokestatic 339	java/lang/Thread:sleep	(J)V
    //   45: iload_3
    //   46: bipush 10
    //   48: if_icmplt +1093 -> 1141
    //   51: iconst_0
    //   52: istore_3
    //   53: goto -22 -> 31
    //   56: astore 19
    //   58: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   61: ldc 34
    //   63: aload 19
    //   65: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: goto -23 -> 45
    //   71: new 341	java/io/BufferedReader
    //   74: dup
    //   75: new 343	java/io/FileReader
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 344	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 347	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore 20
    //   88: aload 20
    //   90: invokevirtual 350	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore 19
    //   95: bipush 11
    //   97: istore 6
    //   99: ldc 142
    //   101: astore_0
    //   102: lconst_0
    //   103: lstore 12
    //   105: iconst_0
    //   106: istore 4
    //   108: iconst_0
    //   109: istore 5
    //   111: goto +1037 -> 1148
    //   114: aload 19
    //   116: invokevirtual 353	java/lang/String:length	()I
    //   119: iconst_1
    //   120: if_icmpge +10 -> 130
    //   123: bipush 11
    //   125: istore 6
    //   127: goto +1021 -> 1148
    //   130: aload 19
    //   132: invokevirtual 353	java/lang/String:length	()I
    //   135: bipush 30
    //   137: if_icmple +1124 -> 1261
    //   140: aload 19
    //   142: bipush 8
    //   144: invokevirtual 357	java/lang/String:charAt	(I)C
    //   147: bipush 45
    //   149: if_icmpne +1112 -> 1261
    //   152: aload 19
    //   154: bipush 17
    //   156: invokevirtual 357	java/lang/String:charAt	(I)C
    //   159: bipush 32
    //   161: if_icmpne +1100 -> 1261
    //   164: aload 19
    //   166: ldc_w 359
    //   169: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: astore_0
    //   173: aload_0
    //   174: iconst_0
    //   175: aaload
    //   176: ldc_w 361
    //   179: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   182: astore 19
    //   184: aload 19
    //   186: iconst_0
    //   187: aaload
    //   188: bipush 16
    //   190: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   193: lstore 16
    //   195: aload 19
    //   197: iconst_1
    //   198: aaload
    //   199: bipush 16
    //   201: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   204: lstore 14
    //   206: iconst_5
    //   207: istore_3
    //   208: iload_3
    //   209: aload_0
    //   210: arraylength
    //   211: if_icmpge +21 -> 232
    //   214: aload_0
    //   215: iload_3
    //   216: aaload
    //   217: ldc 142
    //   219: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: ifeq +10 -> 232
    //   225: iload_3
    //   226: iconst_1
    //   227: iadd
    //   228: istore_3
    //   229: goto -21 -> 208
    //   232: iload_3
    //   233: aload_0
    //   234: arraylength
    //   235: if_icmpge +972 -> 1207
    //   238: aload_0
    //   239: iload_3
    //   240: aaload
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 353	java/lang/String:length	()I
    //   246: istore_3
    //   247: aload_0
    //   248: ldc_w 369
    //   251: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifeq +187 -> 441
    //   257: iconst_0
    //   258: istore_3
    //   259: aload_0
    //   260: astore 19
    //   262: goto +910 -> 1172
    //   265: aload 20
    //   267: invokevirtual 350	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   270: astore 19
    //   272: aload 19
    //   274: ifnonnull +333 -> 607
    //   277: iconst_1
    //   278: istore 8
    //   280: iload 10
    //   282: ifne +832 -> 1114
    //   285: aload_2
    //   286: iload 7
    //   288: invokeinterface 373 2 0
    //   293: checkcast 304	java/util/Map
    //   296: astore 18
    //   298: aload 18
    //   300: aload_0
    //   301: invokeinterface 376 2 0
    //   306: ifeq +685 -> 991
    //   309: aload 18
    //   311: aload_0
    //   312: aload 18
    //   314: aload_0
    //   315: invokeinterface 379 2 0
    //   320: checkcast 381	java/lang/Integer
    //   323: invokevirtual 384	java/lang/Integer:intValue	()I
    //   326: iload_3
    //   327: iadd
    //   328: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: invokeinterface 391 3 0
    //   336: pop
    //   337: aload_1
    //   338: iload 7
    //   340: invokeinterface 373 2 0
    //   345: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   348: astore 18
    //   350: aload 18
    //   352: aload 18
    //   354: invokestatic 395	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   357: iload_3
    //   358: i2l
    //   359: ladd
    //   360: invokestatic 399	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$102	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;J)J
    //   363: pop2
    //   364: aload_1
    //   365: iload 7
    //   367: invokeinterface 373 2 0
    //   372: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   375: astore 18
    //   377: aload 18
    //   379: aload 18
    //   381: getfield 403	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   384: iload 5
    //   386: i2l
    //   387: ladd
    //   388: putfield 403	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   391: aload_1
    //   392: iload 7
    //   394: invokeinterface 373 2 0
    //   399: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   402: astore 18
    //   404: aload 18
    //   406: aload 18
    //   408: getfield 406	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   411: iload 4
    //   413: i2l
    //   414: ladd
    //   415: putfield 406	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   418: iload 9
    //   420: iload_3
    //   421: iadd
    //   422: istore 9
    //   424: aload_0
    //   425: astore 18
    //   427: iload 7
    //   429: istore 6
    //   431: iload 5
    //   433: istore 7
    //   435: iload_3
    //   436: istore 5
    //   438: goto +710 -> 1148
    //   441: aload_0
    //   442: ldc_w 408
    //   445: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   448: ifeq +11 -> 459
    //   451: iconst_1
    //   452: istore_3
    //   453: aload_0
    //   454: astore 19
    //   456: goto +716 -> 1172
    //   459: aload_0
    //   460: ldc_w 413
    //   463: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   466: ifeq +11 -> 477
    //   469: iconst_2
    //   470: istore_3
    //   471: aload_0
    //   472: astore 19
    //   474: goto +698 -> 1172
    //   477: aload_0
    //   478: ldc_w 415
    //   481: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   484: ifeq +11 -> 495
    //   487: iconst_3
    //   488: istore_3
    //   489: aload_0
    //   490: astore 19
    //   492: goto +680 -> 1172
    //   495: aload_0
    //   496: ldc_w 417
    //   499: invokevirtual 411	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   502: ifeq +11 -> 513
    //   505: iconst_4
    //   506: istore_3
    //   507: aload_0
    //   508: astore 19
    //   510: goto +662 -> 1172
    //   513: aload_0
    //   514: ldc_w 419
    //   517: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   520: ifeq +11 -> 531
    //   523: iconst_5
    //   524: istore_3
    //   525: aload_0
    //   526: astore 19
    //   528: goto +644 -> 1172
    //   531: aload_0
    //   532: ldc_w 421
    //   535: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   538: ifeq +12 -> 550
    //   541: bipush 6
    //   543: istore_3
    //   544: aload_0
    //   545: astore 19
    //   547: goto +625 -> 1172
    //   550: aload_0
    //   551: ldc_w 423
    //   554: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   557: ifeq +12 -> 569
    //   560: bipush 7
    //   562: istore_3
    //   563: aload_0
    //   564: astore 19
    //   566: goto +606 -> 1172
    //   569: aload_0
    //   570: ldc_w 425
    //   573: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   576: ifeq +12 -> 588
    //   579: bipush 8
    //   581: istore_3
    //   582: aload_0
    //   583: astore 19
    //   585: goto +587 -> 1172
    //   588: aload_0
    //   589: ldc_w 427
    //   592: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   595: ifeq +618 -> 1213
    //   598: bipush 9
    //   600: istore_3
    //   601: aload_0
    //   602: astore 19
    //   604: goto +568 -> 1172
    //   607: aload 19
    //   609: ldc_w 359
    //   612: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   615: astore 22
    //   617: aload 22
    //   619: iconst_0
    //   620: aaload
    //   621: astore 21
    //   623: iconst_1
    //   624: istore 6
    //   626: iload 6
    //   628: aload 22
    //   630: arraylength
    //   631: if_icmpge +25 -> 656
    //   634: aload 22
    //   636: iload 6
    //   638: aaload
    //   639: ldc 142
    //   641: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +12 -> 656
    //   647: iload 6
    //   649: iconst_1
    //   650: iadd
    //   651: istore 6
    //   653: goto -27 -> 626
    //   656: iload 6
    //   658: aload 22
    //   660: arraylength
    //   661: if_icmpge +634 -> 1295
    //   664: aload 22
    //   666: iload 6
    //   668: aaload
    //   669: invokestatic 431	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   672: istore 6
    //   674: aload 21
    //   676: ldc_w 433
    //   679: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   682: ifeq +53 -> 735
    //   685: iload_3
    //   686: istore 6
    //   688: iload 5
    //   690: istore_3
    //   691: iload 6
    //   693: istore 5
    //   695: goto +587 -> 1282
    //   698: astore 22
    //   700: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   703: iconst_3
    //   704: anewarray 64	java/lang/String
    //   707: dup
    //   708: iconst_0
    //   709: ldc 34
    //   711: aastore
    //   712: dup
    //   713: iconst_1
    //   714: ldc_w 435
    //   717: aastore
    //   718: dup
    //   719: iconst_2
    //   720: aload 22
    //   722: invokevirtual 438	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   725: aastore
    //   726: invokevirtual 441	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   729: iconst_0
    //   730: istore 6
    //   732: goto -58 -> 674
    //   735: aload 21
    //   737: ldc_w 443
    //   740: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   743: ifeq +16 -> 759
    //   746: iload_3
    //   747: istore 6
    //   749: iload 5
    //   751: istore_3
    //   752: iload 6
    //   754: istore 5
    //   756: goto +526 -> 1282
    //   759: aload 21
    //   761: ldc_w 445
    //   764: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   767: ifeq +13 -> 780
    //   770: iload 5
    //   772: istore_3
    //   773: iload 6
    //   775: istore 5
    //   777: goto +505 -> 1282
    //   780: aload 21
    //   782: ldc_w 447
    //   785: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq +16 -> 804
    //   791: iload_3
    //   792: istore 6
    //   794: iload 5
    //   796: istore_3
    //   797: iload 6
    //   799: istore 5
    //   801: goto +481 -> 1282
    //   804: aload 21
    //   806: ldc_w 449
    //   809: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   812: ifeq +20 -> 832
    //   815: iload 6
    //   817: istore 4
    //   819: iload 5
    //   821: istore 6
    //   823: iload_3
    //   824: istore 5
    //   826: iload 6
    //   828: istore_3
    //   829: goto +453 -> 1282
    //   832: aload 21
    //   834: ldc_w 451
    //   837: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   840: ifeq +16 -> 856
    //   843: iload_3
    //   844: istore 6
    //   846: iload 5
    //   848: istore_3
    //   849: iload 6
    //   851: istore 5
    //   853: goto +429 -> 1282
    //   856: aload 21
    //   858: ldc_w 453
    //   861: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   864: ifeq +12 -> 876
    //   867: iload_3
    //   868: istore 5
    //   870: iload 6
    //   872: istore_3
    //   873: goto +409 -> 1282
    //   876: aload 21
    //   878: ldc_w 455
    //   881: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   884: ifeq +16 -> 900
    //   887: iload_3
    //   888: istore 6
    //   890: iload 5
    //   892: istore_3
    //   893: iload 6
    //   895: istore 5
    //   897: goto +385 -> 1282
    //   900: aload 19
    //   902: invokevirtual 353	java/lang/String:length	()I
    //   905: bipush 30
    //   907: if_icmple +221 -> 1128
    //   910: aload 19
    //   912: bipush 8
    //   914: invokevirtual 357	java/lang/String:charAt	(I)C
    //   917: bipush 45
    //   919: if_icmpne +209 -> 1128
    //   922: aload 19
    //   924: bipush 17
    //   926: invokevirtual 357	java/lang/String:charAt	(I)C
    //   929: bipush 32
    //   931: if_icmpne +197 -> 1128
    //   934: getstatic 459	java/lang/System:out	Ljava/io/PrintStream;
    //   937: aload 19
    //   939: invokevirtual 464	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   942: goto -662 -> 280
    //   945: astore_0
    //   946: iconst_m1
    //   947: istore_3
    //   948: aload 20
    //   950: ifnull -913 -> 37
    //   953: aload 20
    //   955: invokevirtual 465	java/io/BufferedReader:close	()V
    //   958: iconst_m1
    //   959: ireturn
    //   960: astore_0
    //   961: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   964: iconst_3
    //   965: anewarray 64	java/lang/String
    //   968: dup
    //   969: iconst_0
    //   970: ldc 34
    //   972: aastore
    //   973: dup
    //   974: iconst_1
    //   975: ldc_w 467
    //   978: aastore
    //   979: dup
    //   980: iconst_2
    //   981: aload_0
    //   982: invokevirtual 438	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   985: aastore
    //   986: invokevirtual 441	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   989: iconst_m1
    //   990: ireturn
    //   991: aload 18
    //   993: aload_0
    //   994: iload_3
    //   995: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   998: invokeinterface 391 3 0
    //   1003: pop
    //   1004: goto -667 -> 337
    //   1007: astore_0
    //   1008: aload 20
    //   1010: ifnull +8 -> 1018
    //   1013: aload 20
    //   1015: invokevirtual 465	java/io/BufferedReader:close	()V
    //   1018: aload_0
    //   1019: athrow
    //   1020: aload 20
    //   1022: ifnull +89 -> 1111
    //   1025: aload 20
    //   1027: invokevirtual 465	java/io/BufferedReader:close	()V
    //   1030: iload 9
    //   1032: ireturn
    //   1033: astore_0
    //   1034: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1037: iconst_3
    //   1038: anewarray 64	java/lang/String
    //   1041: dup
    //   1042: iconst_0
    //   1043: ldc 34
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_1
    //   1048: ldc_w 467
    //   1051: aastore
    //   1052: dup
    //   1053: iconst_2
    //   1054: aload_0
    //   1055: invokevirtual 438	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1058: aastore
    //   1059: invokevirtual 441	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1062: iload 9
    //   1064: ireturn
    //   1065: astore_1
    //   1066: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1069: iconst_3
    //   1070: anewarray 64	java/lang/String
    //   1073: dup
    //   1074: iconst_0
    //   1075: ldc 34
    //   1077: aastore
    //   1078: dup
    //   1079: iconst_1
    //   1080: ldc_w 467
    //   1083: aastore
    //   1084: dup
    //   1085: iconst_2
    //   1086: aload_1
    //   1087: invokevirtual 438	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1090: aastore
    //   1091: invokevirtual 441	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1094: goto -76 -> 1018
    //   1097: astore_0
    //   1098: aconst_null
    //   1099: astore 20
    //   1101: goto -93 -> 1008
    //   1104: astore_0
    //   1105: aconst_null
    //   1106: astore 20
    //   1108: goto -162 -> 946
    //   1111: iload 9
    //   1113: ireturn
    //   1114: iload 7
    //   1116: istore 6
    //   1118: iload 5
    //   1120: istore 7
    //   1122: iload_3
    //   1123: istore 5
    //   1125: goto +23 -> 1148
    //   1128: iload_3
    //   1129: istore 6
    //   1131: iload 5
    //   1133: istore_3
    //   1134: iload 6
    //   1136: istore 5
    //   1138: goto +144 -> 1282
    //   1141: iload_3
    //   1142: iconst_1
    //   1143: iadd
    //   1144: istore_3
    //   1145: goto -1130 -> 15
    //   1148: iload 8
    //   1150: ifne -130 -> 1020
    //   1153: bipush 11
    //   1155: istore 10
    //   1157: aload 19
    //   1159: ifnonnull -1045 -> 114
    //   1162: iconst_1
    //   1163: istore 8
    //   1165: bipush 11
    //   1167: istore 6
    //   1169: goto -21 -> 1148
    //   1172: aload 19
    //   1174: astore_0
    //   1175: iconst_0
    //   1176: istore 11
    //   1178: iload 5
    //   1180: istore 6
    //   1182: lload 14
    //   1184: lstore 12
    //   1186: iload_3
    //   1187: istore 10
    //   1189: iload 7
    //   1191: istore 5
    //   1193: iload 6
    //   1195: istore_3
    //   1196: iload 10
    //   1198: istore 7
    //   1200: iload 11
    //   1202: istore 10
    //   1204: goto -939 -> 265
    //   1207: ldc 142
    //   1209: astore_0
    //   1210: goto -968 -> 242
    //   1213: iload_3
    //   1214: ifle +12 -> 1226
    //   1217: bipush 10
    //   1219: istore_3
    //   1220: aload_0
    //   1221: astore 19
    //   1223: goto -51 -> 1172
    //   1226: iload 10
    //   1228: istore_3
    //   1229: aload_0
    //   1230: astore 19
    //   1232: lload 16
    //   1234: lload 12
    //   1236: lcmp
    //   1237: ifne -65 -> 1172
    //   1240: iload 10
    //   1242: istore_3
    //   1243: aload_0
    //   1244: astore 19
    //   1246: iload 6
    //   1248: iconst_5
    //   1249: if_icmpne -77 -> 1172
    //   1252: iconst_5
    //   1253: istore_3
    //   1254: aload 18
    //   1256: astore 19
    //   1258: goto -86 -> 1172
    //   1261: iload 5
    //   1263: istore_3
    //   1264: iconst_1
    //   1265: istore 10
    //   1267: bipush 11
    //   1269: istore 6
    //   1271: iload 7
    //   1273: istore 5
    //   1275: iload 6
    //   1277: istore 7
    //   1279: goto -1014 -> 265
    //   1282: iload 5
    //   1284: istore 6
    //   1286: iload_3
    //   1287: istore 5
    //   1289: iload 6
    //   1291: istore_3
    //   1292: goto -1027 -> 265
    //   1295: iconst_0
    //   1296: istore 6
    //   1298: goto -624 -> 674
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1301	0	paramString	String
    //   0	1301	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	1301	2	paramList1	List<Map<String, java.lang.Integer>>
    //   14	1278	3	i	int
    //   106	712	4	j	int
    //   109	1179	5	k	int
    //   97	1200	6	m	int
    //   7	1271	7	n	int
    //   4	1160	8	i1	int
    //   1	1111	9	i2	int
    //   280	986	10	i3	int
    //   1176	25	11	i4	int
    //   103	1132	12	l1	long
    //   204	979	14	l2	long
    //   193	1040	16	l3	long
    //   11	1244	18	localObject1	Object
    //   56	8	19	localInterruptedException	java.lang.InterruptedException
    //   93	1164	19	localObject2	Object
    //   86	1021	20	localBufferedReader	java.io.BufferedReader
    //   621	256	21	str	String
    //   615	50	22	arrayOfString	String[]
    //   698	23	22	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   39	45	56	java/lang/InterruptedException
    //   626	647	698	java/lang/Exception
    //   656	674	698	java/lang/Exception
    //   88	95	945	java/lang/Exception
    //   114	123	945	java/lang/Exception
    //   130	206	945	java/lang/Exception
    //   208	225	945	java/lang/Exception
    //   232	238	945	java/lang/Exception
    //   242	257	945	java/lang/Exception
    //   265	272	945	java/lang/Exception
    //   285	337	945	java/lang/Exception
    //   337	418	945	java/lang/Exception
    //   441	451	945	java/lang/Exception
    //   459	469	945	java/lang/Exception
    //   477	487	945	java/lang/Exception
    //   495	505	945	java/lang/Exception
    //   513	523	945	java/lang/Exception
    //   531	541	945	java/lang/Exception
    //   550	560	945	java/lang/Exception
    //   569	579	945	java/lang/Exception
    //   588	598	945	java/lang/Exception
    //   607	617	945	java/lang/Exception
    //   674	685	945	java/lang/Exception
    //   700	729	945	java/lang/Exception
    //   735	746	945	java/lang/Exception
    //   759	770	945	java/lang/Exception
    //   780	791	945	java/lang/Exception
    //   804	815	945	java/lang/Exception
    //   832	843	945	java/lang/Exception
    //   856	867	945	java/lang/Exception
    //   876	887	945	java/lang/Exception
    //   900	942	945	java/lang/Exception
    //   991	1004	945	java/lang/Exception
    //   953	958	960	java/lang/Exception
    //   88	95	1007	finally
    //   114	123	1007	finally
    //   130	206	1007	finally
    //   208	225	1007	finally
    //   232	238	1007	finally
    //   242	257	1007	finally
    //   265	272	1007	finally
    //   285	337	1007	finally
    //   337	418	1007	finally
    //   441	451	1007	finally
    //   459	469	1007	finally
    //   477	487	1007	finally
    //   495	505	1007	finally
    //   513	523	1007	finally
    //   531	541	1007	finally
    //   550	560	1007	finally
    //   569	579	1007	finally
    //   588	598	1007	finally
    //   607	617	1007	finally
    //   626	647	1007	finally
    //   656	674	1007	finally
    //   674	685	1007	finally
    //   700	729	1007	finally
    //   735	746	1007	finally
    //   759	770	1007	finally
    //   780	791	1007	finally
    //   804	815	1007	finally
    //   832	843	1007	finally
    //   856	867	1007	finally
    //   876	887	1007	finally
    //   900	942	1007	finally
    //   991	1004	1007	finally
    //   1025	1030	1033	java/lang/Exception
    //   1013	1018	1065	java/lang/Exception
    //   71	88	1097	finally
    //   71	88	1104	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String writeMapinfoToLog(String paramString1, List<DumpMemInfoHandler.StatFields> paramList, @NonNull List<Map<String, java.lang.Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 470	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 471	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 42	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 473
    //   21: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 359
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 475
    //   42: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 6
    //   54: ldc_w 480
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_3
    //   64: invokestatic 387	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   74: pop
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: aload_1
    //   79: invokeinterface 484 1 0
    //   84: if_icmpge +148 -> 232
    //   87: aload 6
    //   89: ldc_w 486
    //   92: iconst_2
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: getstatic 78	com/tencent/qapmsdk/memory/DumpMemInfoHandler:HEAP_NAME	[Ljava/lang/String;
    //   101: iload_3
    //   102: aaload
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: iload_3
    //   108: invokeinterface 373 2 0
    //   113: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   116: invokestatic 395	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   119: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: aload_2
    //   131: iload_3
    //   132: invokeinterface 373 2 0
    //   137: checkcast 304	java/util/Map
    //   140: invokeinterface 490 1 0
    //   145: ifle +80 -> 225
    //   148: aload_2
    //   149: iload_3
    //   150: invokeinterface 373 2 0
    //   155: checkcast 304	java/util/Map
    //   158: invokestatic 492	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getSortedHashtableByValue	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   161: astore 7
    //   163: iconst_0
    //   164: istore 5
    //   166: iload 5
    //   168: aload 7
    //   170: arraylength
    //   171: if_icmpge +54 -> 225
    //   174: aload 6
    //   176: ldc_w 494
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 7
    //   187: iload 5
    //   189: aaload
    //   190: invokeinterface 498 1 0
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 7
    //   200: iload 5
    //   202: aaload
    //   203: invokeinterface 501 1 0
    //   208: aastore
    //   209: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   241: ldc_w 473
    //   244: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 503
    //   254: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: pop
    //   264: aload 6
    //   266: invokevirtual 504	java/lang/StringBuffer:toString	()Ljava/lang/String;
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
    //   288: invokevirtual 507	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   291: new 42	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   298: getstatic 62	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   301: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 192
    //   306: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokestatic 509	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getProcFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   313: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 194
    //   318: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 4
    //   323: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 511
    //   329: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_0
    //   338: aconst_null
    //   339: astore 4
    //   341: new 513	java/io/BufferedWriter
    //   344: dup
    //   345: new 259	java/io/FileWriter
    //   348: dup
    //   349: aload_2
    //   350: invokespecial 514	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   353: invokespecial 517	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   356: astore_1
    //   357: aload_1
    //   358: aload 6
    //   360: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   367: aload_2
    //   368: astore_0
    //   369: aload_1
    //   370: ifnull +9 -> 379
    //   373: aload_1
    //   374: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   377: aload_2
    //   378: astore_0
    //   379: aload_0
    //   380: areturn
    //   381: astore_0
    //   382: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   385: ldc 34
    //   387: aload_0
    //   388: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   408: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload 4
    //   413: astore_0
    //   414: aload_1
    //   415: ifnull -36 -> 379
    //   418: aload_1
    //   419: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   428: ldc 34
    //   430: aload_0
    //   431: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   446: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   449: aload_0
    //   450: athrow
    //   451: astore_1
    //   452: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   455: ldc 34
    //   457: aload_1
    //   458: invokevirtual 218	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    return new Object[] { Boolean.valueOf(FileUtil.zipFiles(paramList, paramString, false)), paramString };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */