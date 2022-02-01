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
  private static final String LOG_PATH;
  private static final int NATIVE = 0;
  private static final int OTHER_DEV = 4;
  private static final int OTHER_MMAP = 10;
  private static final int SO_MMAP = 5;
  private static final String TAG = "QAPM_memory_DumpMemInfoHandler";
  private static final int TTF_MMAP = 8;
  private static final int UNKNOWN = 11;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileUtil.getRootPath());
    ((StringBuilder)localObject).append("/Log/");
    LOG_PATH = ((StringBuilder)localObject).toString();
    HEAP_NAME = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    localObject = new File(LOG_PATH);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      ((File)localObject).mkdirs();
    }
  }
  
  public static String generateDetailMemory(@NonNull ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/proc/");
    ((StringBuilder)localObject).append(paramRunningAppProcessInfo.pid);
    ((StringBuilder)localObject).append("/smaps");
    localObject = ((StringBuilder)localObject).toString();
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
    i = readMapinfo((String)localObject, localArrayList1, localArrayList2);
    if (i > 0) {
      return writeMapinfoToLog(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
    }
    if (i < 0) {
      return null;
    }
    return "";
  }
  
  public static Object[] generateHprof(String paramString, IHeapDumper paramIHeapDumper)
  {
    try
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "ReportLog dumpHprof: ", paramString });
      String str = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
      boolean bool;
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        Object localObject1 = new File(LOG_PATH);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        Object localObject2 = ((File)localObject1).getAbsolutePath();
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("/");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("dump_");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".hprof");
        localObject1 = ((StringBuilder)localObject2).toString();
        try
        {
          long l = System.currentTimeMillis();
          if (paramIHeapDumper != null) {
            bool = paramIHeapDumper.dump((String)localObject1);
          } else {
            bool = false;
          }
          try
          {
            Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "dump used ", String.valueOf(System.currentTimeMillis() - l), " ms" });
            paramString = (String)localObject1;
          }
          catch (Throwable paramString) {}
          Logger.INSTANCE.exception("QAPM_memory_DumpMemInfoHandler", paramString);
        }
        catch (Throwable paramString)
        {
          bool = false;
        }
        paramString = (String)localObject1;
      }
      else
      {
        paramString = "";
        bool = false;
      }
      return new Object[] { Boolean.valueOf(bool), paramString };
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
    //   16: astore 4
    //   18: aload 4
    //   20: getstatic 62	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   23: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: ldc 225
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_3
    //   38: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: ldc 227
    //   46: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 6
    //   57: invokestatic 233	java/lang/Thread:activeCount	()I
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +6 -> 68
    //   65: ldc 142
    //   67: areturn
    //   68: iload_2
    //   69: anewarray 229	java/lang/Thread
    //   72: astore_3
    //   73: aload_3
    //   74: invokestatic 237	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   77: pop
    //   78: new 42	java/lang/StringBuilder
    //   81: dup
    //   82: iload_2
    //   83: sipush 1024
    //   86: imul
    //   87: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   90: astore 5
    //   92: iconst_0
    //   93: istore_0
    //   94: iload_0
    //   95: iload_2
    //   96: if_icmpge +123 -> 219
    //   99: aload_3
    //   100: iload_0
    //   101: aaload
    //   102: astore 4
    //   104: aload 4
    //   106: ifnonnull +6 -> 112
    //   109: goto +103 -> 212
    //   112: aload 4
    //   114: invokevirtual 241	java/lang/Thread:isAlive	()Z
    //   117: ifeq +87 -> 204
    //   120: aload 5
    //   122: ldc 243
    //   124: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: aload 4
    //   132: invokevirtual 246	java/lang/Thread:getName	()Ljava/lang/String;
    //   135: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 5
    //   141: ldc 248
    //   143: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: invokevirtual 252	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   152: astore 4
    //   154: aload 4
    //   156: ifnull +48 -> 204
    //   159: iconst_0
    //   160: istore_1
    //   161: iload_1
    //   162: aload 4
    //   164: arraylength
    //   165: if_icmpge +39 -> 204
    //   168: aload 5
    //   170: ldc 254
    //   172: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: aload 4
    //   180: iload_1
    //   181: aaload
    //   182: invokevirtual 257	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   185: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: ldc 248
    //   193: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: iload_1
    //   198: iconst_1
    //   199: iadd
    //   200: istore_1
    //   201: goto -40 -> 161
    //   204: aload 5
    //   206: ldc 248
    //   208: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: iload_0
    //   213: iconst_1
    //   214: iadd
    //   215: istore_0
    //   216: goto -122 -> 94
    //   219: new 259	java/io/FileWriter
    //   222: dup
    //   223: aload 6
    //   225: iconst_0
    //   226: invokespecial 262	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   229: astore 4
    //   231: aload 4
    //   233: astore_3
    //   234: aload 4
    //   236: aload 5
    //   238: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 265	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   244: aload 4
    //   246: astore_3
    //   247: aload 4
    //   249: invokevirtual 268	java/io/FileWriter:close	()V
    //   252: aload 4
    //   254: invokevirtual 268	java/io/FileWriter:close	()V
    //   257: aload 6
    //   259: areturn
    //   260: astore 5
    //   262: goto +15 -> 277
    //   265: astore_3
    //   266: aconst_null
    //   267: astore 4
    //   269: goto +55 -> 324
    //   272: astore 5
    //   274: aconst_null
    //   275: astore 4
    //   277: aload 4
    //   279: astore_3
    //   280: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   283: ldc 34
    //   285: aload 5
    //   287: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: aload 4
    //   292: ifnull +21 -> 313
    //   295: aload 4
    //   297: invokevirtual 268	java/io/FileWriter:close	()V
    //   300: aload 6
    //   302: areturn
    //   303: astore_3
    //   304: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   307: ldc 34
    //   309: aload_3
    //   310: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload 6
    //   315: areturn
    //   316: astore 5
    //   318: aload_3
    //   319: astore 4
    //   321: aload 5
    //   323: astore_3
    //   324: aload 4
    //   326: ifnull +23 -> 349
    //   329: aload 4
    //   331: invokevirtual 268	java/io/FileWriter:close	()V
    //   334: goto +15 -> 349
    //   337: astore 4
    //   339: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   342: ldc 34
    //   344: aload 4
    //   346: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: goto +5 -> 354
    //   352: aload_3
    //   353: athrow
    //   354: goto -2 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   93	123	0	i	int
    //   160	41	1	j	int
    //   60	37	2	k	int
    //   8	239	3	localObject1	Object
    //   265	1	3	localObject2	Object
    //   279	1	3	localObject3	Object
    //   303	16	3	localException1	java.lang.Exception
    //   323	30	3	localObject4	Object
    //   16	314	4	localObject5	Object
    //   337	8	4	localException2	java.lang.Exception
    //   90	147	5	localStringBuilder	StringBuilder
    //   260	1	5	localIOException1	java.io.IOException
    //   272	14	5	localIOException2	java.io.IOException
    //   316	6	5	localObject6	Object
    //   55	259	6	str	String
    // Exception table:
    //   from	to	target	type
    //   234	244	260	java/io/IOException
    //   247	252	260	java/io/IOException
    //   219	231	265	finally
    //   219	231	272	java/io/IOException
    //   252	257	303	java/lang/Exception
    //   295	300	303	java/lang/Exception
    //   234	244	316	finally
    //   247	252	316	finally
    //   280	290	316	finally
    //   329	334	337	java/lang/Exception
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
      return "";
    }
    String[] arrayOfString = paramString.split(":");
    paramString = arrayOfString[0].split("\\.");
    String str = paramString[(paramString.length - 1)];
    paramString = str;
    if (arrayOfString.length > 1)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("_");
      paramString.append(arrayOfString[1]);
      paramString = paramString.toString();
    }
    return paramString;
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
    //   1: istore_3
    //   2: new 80	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 87	java/io/File:exists	()Z
    //   13: ifeq +8 -> 21
    //   16: iconst_1
    //   17: istore_3
    //   18: goto +32 -> 50
    //   21: ldc2_w 335
    //   24: invokestatic 339	java/lang/Thread:sleep	(J)V
    //   27: goto +15 -> 42
    //   30: astore 18
    //   32: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   35: ldc 34
    //   37: aload 18
    //   39: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: iload_3
    //   43: bipush 10
    //   45: if_icmplt +1056 -> 1101
    //   48: iconst_0
    //   49: istore_3
    //   50: iload_3
    //   51: ifne +5 -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: aconst_null
    //   57: astore 18
    //   59: new 341	java/io/BufferedReader
    //   62: dup
    //   63: new 343	java/io/FileReader
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 344	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 347	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   74: astore 20
    //   76: aload 20
    //   78: invokevirtual 350	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 21
    //   83: ldc 142
    //   85: astore_0
    //   86: ldc 142
    //   88: astore 18
    //   90: aload 18
    //   92: astore 19
    //   94: lconst_0
    //   95: lstore 12
    //   97: bipush 11
    //   99: istore_3
    //   100: iconst_0
    //   101: istore 4
    //   103: iconst_0
    //   104: istore 9
    //   106: iconst_0
    //   107: istore 5
    //   109: iconst_0
    //   110: istore 6
    //   112: iconst_0
    //   113: istore 8
    //   115: iload 4
    //   117: ifne +842 -> 959
    //   120: aload 21
    //   122: ifnonnull +12 -> 134
    //   125: bipush 11
    //   127: istore_3
    //   128: iconst_1
    //   129: istore 4
    //   131: goto -16 -> 115
    //   134: aload 21
    //   136: invokevirtual 353	java/lang/String:length	()I
    //   139: iconst_1
    //   140: if_icmpge +9 -> 149
    //   143: bipush 11
    //   145: istore_3
    //   146: goto -31 -> 115
    //   149: aload 21
    //   151: invokevirtual 353	java/lang/String:length	()I
    //   154: istore 7
    //   156: ldc_w 355
    //   159: astore 22
    //   161: iload 7
    //   163: bipush 30
    //   165: if_icmple +1009 -> 1174
    //   168: aload 21
    //   170: bipush 8
    //   172: invokevirtual 359	java/lang/String:charAt	(I)C
    //   175: bipush 45
    //   177: if_icmpne +997 -> 1174
    //   180: aload 21
    //   182: bipush 17
    //   184: invokevirtual 359	java/lang/String:charAt	(I)C
    //   187: bipush 32
    //   189: if_icmpne +985 -> 1174
    //   192: aload 21
    //   194: ldc_w 355
    //   197: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   200: astore 18
    //   202: aload 18
    //   204: iconst_0
    //   205: aaload
    //   206: ldc_w 361
    //   209: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   212: astore 21
    //   214: aload 21
    //   216: iconst_0
    //   217: aaload
    //   218: bipush 16
    //   220: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   223: lstore 16
    //   225: aload 21
    //   227: iconst_1
    //   228: aaload
    //   229: bipush 16
    //   231: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   234: lstore 14
    //   236: iconst_5
    //   237: istore 7
    //   239: iload 7
    //   241: aload 18
    //   243: arraylength
    //   244: if_icmpge +24 -> 268
    //   247: aload 18
    //   249: iload 7
    //   251: aaload
    //   252: aload_0
    //   253: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifeq +12 -> 268
    //   259: iload 7
    //   261: iconst_1
    //   262: iadd
    //   263: istore 7
    //   265: goto -26 -> 239
    //   268: iload 7
    //   270: aload 18
    //   272: arraylength
    //   273: if_icmpge +843 -> 1116
    //   276: aload 18
    //   278: iload 7
    //   280: aaload
    //   281: astore 18
    //   283: goto +3 -> 286
    //   286: aload 18
    //   288: invokevirtual 353	java/lang/String:length	()I
    //   291: istore 7
    //   293: aload 18
    //   295: ldc_w 369
    //   298: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq +8 -> 309
    //   304: iconst_0
    //   305: istore_3
    //   306: goto +855 -> 1161
    //   309: aload 18
    //   311: ldc_w 371
    //   314: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   317: ifeq +8 -> 325
    //   320: iconst_1
    //   321: istore_3
    //   322: goto +839 -> 1161
    //   325: aload 18
    //   327: ldc_w 376
    //   330: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +8 -> 341
    //   336: iconst_2
    //   337: istore_3
    //   338: goto +823 -> 1161
    //   341: aload 18
    //   343: ldc_w 378
    //   346: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   349: ifeq +8 -> 357
    //   352: iconst_3
    //   353: istore_3
    //   354: goto +807 -> 1161
    //   357: aload 18
    //   359: ldc_w 380
    //   362: invokevirtual 374	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   365: ifeq +8 -> 373
    //   368: iconst_4
    //   369: istore_3
    //   370: goto +791 -> 1161
    //   373: aload 18
    //   375: ldc_w 382
    //   378: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   381: ifeq +6 -> 387
    //   384: goto +738 -> 1122
    //   387: aload 18
    //   389: ldc_w 384
    //   392: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   395: ifeq +9 -> 404
    //   398: bipush 6
    //   400: istore_3
    //   401: goto +760 -> 1161
    //   404: aload 18
    //   406: ldc_w 386
    //   409: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   412: ifeq +9 -> 421
    //   415: bipush 7
    //   417: istore_3
    //   418: goto +743 -> 1161
    //   421: aload 18
    //   423: ldc_w 388
    //   426: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   429: ifeq +9 -> 438
    //   432: bipush 8
    //   434: istore_3
    //   435: goto +726 -> 1161
    //   438: aload 18
    //   440: ldc_w 390
    //   443: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   446: ifeq +681 -> 1127
    //   449: bipush 9
    //   451: istore_3
    //   452: goto +709 -> 1161
    //   455: aload 20
    //   457: invokevirtual 350	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   460: astore 22
    //   462: aload 22
    //   464: ifnonnull +9 -> 473
    //   467: iconst_1
    //   468: istore 6
    //   470: goto +280 -> 750
    //   473: aload 22
    //   475: aload 21
    //   477: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   480: astore 24
    //   482: aload 24
    //   484: iconst_0
    //   485: aaload
    //   486: astore 23
    //   488: iconst_1
    //   489: istore 6
    //   491: iload 6
    //   493: aload 24
    //   495: arraylength
    //   496: if_icmpge +24 -> 520
    //   499: aload 24
    //   501: iload 6
    //   503: aaload
    //   504: aload_0
    //   505: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifeq +12 -> 520
    //   511: iload 6
    //   513: iconst_1
    //   514: iadd
    //   515: istore 6
    //   517: goto -26 -> 491
    //   520: iload 6
    //   522: aload 24
    //   524: arraylength
    //   525: if_icmpge +16 -> 541
    //   528: aload 24
    //   530: iload 6
    //   532: aaload
    //   533: invokestatic 396	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   536: istore 6
    //   538: goto +6 -> 544
    //   541: iconst_0
    //   542: istore 6
    //   544: goto +37 -> 581
    //   547: astore 24
    //   549: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   552: iconst_3
    //   553: anewarray 64	java/lang/String
    //   556: dup
    //   557: iconst_0
    //   558: ldc 34
    //   560: aastore
    //   561: dup
    //   562: iconst_1
    //   563: ldc_w 398
    //   566: aastore
    //   567: dup
    //   568: iconst_2
    //   569: aload 24
    //   571: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   574: aastore
    //   575: invokevirtual 404	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   578: iconst_0
    //   579: istore 6
    //   581: aload 23
    //   583: ldc_w 406
    //   586: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   589: ifeq +6 -> 595
    //   592: goto +615 -> 1207
    //   595: aload 23
    //   597: ldc_w 408
    //   600: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   603: ifeq +6 -> 609
    //   606: goto +601 -> 1207
    //   609: aload 23
    //   611: ldc_w 410
    //   614: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   617: ifeq +9 -> 626
    //   620: iload 6
    //   622: istore_3
    //   623: goto +584 -> 1207
    //   626: aload 23
    //   628: ldc_w 412
    //   631: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +6 -> 640
    //   637: goto +570 -> 1207
    //   640: aload 23
    //   642: ldc_w 414
    //   645: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq +10 -> 658
    //   651: iload 6
    //   653: istore 4
    //   655: goto +552 -> 1207
    //   658: aload 23
    //   660: ldc_w 416
    //   663: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +6 -> 672
    //   669: goto +538 -> 1207
    //   672: aload 23
    //   674: ldc_w 418
    //   677: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +10 -> 690
    //   683: iload 6
    //   685: istore 5
    //   687: goto +520 -> 1207
    //   690: aload 23
    //   692: ldc_w 420
    //   695: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   698: ifeq +6 -> 704
    //   701: goto +506 -> 1207
    //   704: aload 22
    //   706: invokevirtual 353	java/lang/String:length	()I
    //   709: bipush 30
    //   711: if_icmple +496 -> 1207
    //   714: aload 22
    //   716: bipush 8
    //   718: invokevirtual 359	java/lang/String:charAt	(I)C
    //   721: bipush 45
    //   723: if_icmpne +230 -> 953
    //   726: aload 22
    //   728: bipush 17
    //   730: invokevirtual 359	java/lang/String:charAt	(I)C
    //   733: bipush 32
    //   735: if_icmpne +215 -> 950
    //   738: getstatic 424	java/lang/System:out	Ljava/io/PrintStream;
    //   741: aload 22
    //   743: invokevirtual 429	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   746: iload 8
    //   748: istore 6
    //   750: iload 10
    //   752: ifne +169 -> 921
    //   755: aload_2
    //   756: iload 7
    //   758: invokeinterface 433 2 0
    //   763: checkcast 304	java/util/Map
    //   766: astore 19
    //   768: aload 19
    //   770: aload 18
    //   772: invokeinterface 436 2 0
    //   777: ifeq +36 -> 813
    //   780: aload 19
    //   782: aload 18
    //   784: aload 19
    //   786: aload 18
    //   788: invokeinterface 439 2 0
    //   793: checkcast 392	java/lang/Integer
    //   796: invokevirtual 442	java/lang/Integer:intValue	()I
    //   799: iload_3
    //   800: iadd
    //   801: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   804: invokeinterface 449 3 0
    //   809: pop
    //   810: goto +17 -> 827
    //   813: aload 19
    //   815: aload 18
    //   817: iload_3
    //   818: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: invokeinterface 449 3 0
    //   826: pop
    //   827: aload_1
    //   828: iload 7
    //   830: invokeinterface 433 2 0
    //   835: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   838: astore 19
    //   840: aload 19
    //   842: aload 19
    //   844: invokestatic 453	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   847: iload_3
    //   848: i2l
    //   849: ladd
    //   850: invokestatic 457	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$102	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;J)J
    //   853: pop2
    //   854: aload_1
    //   855: iload 7
    //   857: invokeinterface 433 2 0
    //   862: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   865: astore 19
    //   867: aload 19
    //   869: aload 19
    //   871: getfield 461	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   874: iload 5
    //   876: i2l
    //   877: ladd
    //   878: putfield 461	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   881: aload_1
    //   882: iload 7
    //   884: invokeinterface 433 2 0
    //   889: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   892: astore 19
    //   894: aload 19
    //   896: aload 19
    //   898: getfield 464	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   901: iload 4
    //   903: i2l
    //   904: ladd
    //   905: putfield 464	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   908: iload 9
    //   910: iload_3
    //   911: iadd
    //   912: istore 9
    //   914: aload 18
    //   916: astore 19
    //   918: goto +3 -> 921
    //   921: iload 5
    //   923: istore 8
    //   925: iload 4
    //   927: istore 10
    //   929: iload_3
    //   930: istore 5
    //   932: aload 22
    //   934: astore 21
    //   936: iload 6
    //   938: istore 4
    //   940: iload 7
    //   942: istore_3
    //   943: iload 10
    //   945: istore 6
    //   947: goto -832 -> 115
    //   950: goto +6 -> 956
    //   953: goto +254 -> 1207
    //   956: goto -501 -> 455
    //   959: aload 20
    //   961: invokevirtual 465	java/io/BufferedReader:close	()V
    //   964: iload 9
    //   966: ireturn
    //   967: astore_0
    //   968: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   971: iconst_3
    //   972: anewarray 64	java/lang/String
    //   975: dup
    //   976: iconst_0
    //   977: ldc 34
    //   979: aastore
    //   980: dup
    //   981: iconst_1
    //   982: ldc_w 467
    //   985: aastore
    //   986: dup
    //   987: iconst_2
    //   988: aload_0
    //   989: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   992: aastore
    //   993: invokevirtual 404	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   996: iload 9
    //   998: ireturn
    //   999: astore_0
    //   1000: goto +11 -> 1011
    //   1003: goto +55 -> 1058
    //   1006: astore_0
    //   1007: aload 18
    //   1009: astore 20
    //   1011: aload 20
    //   1013: ifnull +40 -> 1053
    //   1016: aload 20
    //   1018: invokevirtual 465	java/io/BufferedReader:close	()V
    //   1021: goto +32 -> 1053
    //   1024: astore_1
    //   1025: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1028: iconst_3
    //   1029: anewarray 64	java/lang/String
    //   1032: dup
    //   1033: iconst_0
    //   1034: ldc 34
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_1
    //   1039: ldc_w 467
    //   1042: aastore
    //   1043: dup
    //   1044: iconst_2
    //   1045: aload_1
    //   1046: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1049: aastore
    //   1050: invokevirtual 404	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1053: aload_0
    //   1054: athrow
    //   1055: aconst_null
    //   1056: astore 20
    //   1058: aload 20
    //   1060: ifnull +39 -> 1099
    //   1063: aload 20
    //   1065: invokevirtual 465	java/io/BufferedReader:close	()V
    //   1068: iconst_m1
    //   1069: ireturn
    //   1070: astore_0
    //   1071: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1074: iconst_3
    //   1075: anewarray 64	java/lang/String
    //   1078: dup
    //   1079: iconst_0
    //   1080: ldc 34
    //   1082: aastore
    //   1083: dup
    //   1084: iconst_1
    //   1085: ldc_w 467
    //   1088: aastore
    //   1089: dup
    //   1090: iconst_2
    //   1091: aload_0
    //   1092: invokevirtual 401	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1095: aastore
    //   1096: invokevirtual 404	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1099: iconst_m1
    //   1100: ireturn
    //   1101: iload_3
    //   1102: iconst_1
    //   1103: iadd
    //   1104: istore_3
    //   1105: goto -1103 -> 2
    //   1108: astore_0
    //   1109: goto -54 -> 1055
    //   1112: astore_0
    //   1113: goto -110 -> 1003
    //   1116: aload_0
    //   1117: astore 18
    //   1119: goto -833 -> 286
    //   1122: iconst_5
    //   1123: istore_3
    //   1124: goto +37 -> 1161
    //   1127: iload 7
    //   1129: ifle +9 -> 1138
    //   1132: bipush 10
    //   1134: istore_3
    //   1135: goto +26 -> 1161
    //   1138: lload 16
    //   1140: lload 12
    //   1142: lcmp
    //   1143: ifne +15 -> 1158
    //   1146: iload_3
    //   1147: iconst_5
    //   1148: if_icmpne +10 -> 1158
    //   1151: aload 19
    //   1153: astore 18
    //   1155: goto -33 -> 1122
    //   1158: bipush 11
    //   1160: istore_3
    //   1161: lload 14
    //   1163: lstore 12
    //   1165: iconst_0
    //   1166: istore 10
    //   1168: iload_3
    //   1169: istore 7
    //   1171: goto +10 -> 1181
    //   1174: bipush 11
    //   1176: istore 7
    //   1178: iconst_1
    //   1179: istore 10
    //   1181: iload 8
    //   1183: istore 11
    //   1185: iload 5
    //   1187: istore_3
    //   1188: iload 4
    //   1190: istore 8
    //   1192: iload 6
    //   1194: istore 4
    //   1196: aload 22
    //   1198: astore 21
    //   1200: iload 11
    //   1202: istore 5
    //   1204: goto -749 -> 455
    //   1207: goto -251 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1210	0	paramString	String
    //   0	1210	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	1210	2	paramList1	List<Map<String, java.lang.Integer>>
    //   1	1187	3	i	int
    //   101	1094	4	j	int
    //   107	1096	5	k	int
    //   110	1083	6	m	int
    //   154	1023	7	n	int
    //   113	1078	8	i1	int
    //   104	893	9	i2	int
    //   750	430	10	i3	int
    //   1183	18	11	i4	int
    //   95	1069	12	l1	long
    //   234	928	14	l2	long
    //   223	916	16	l3	long
    //   30	8	18	localInterruptedException	java.lang.InterruptedException
    //   57	1097	18	localObject1	Object
    //   92	1060	19	localObject2	Object
    //   74	990	20	localObject3	Object
    //   81	1118	21	localObject4	Object
    //   159	1038	22	str1	String
    //   486	205	23	str2	String
    //   480	49	24	arrayOfString	String[]
    //   547	23	24	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	27	30	java/lang/InterruptedException
    //   491	511	547	java/lang/Exception
    //   520	538	547	java/lang/Exception
    //   959	964	967	java/lang/Exception
    //   76	83	999	finally
    //   134	143	999	finally
    //   149	156	999	finally
    //   168	236	999	finally
    //   239	259	999	finally
    //   268	276	999	finally
    //   286	304	999	finally
    //   309	320	999	finally
    //   325	336	999	finally
    //   341	352	999	finally
    //   357	368	999	finally
    //   373	384	999	finally
    //   387	398	999	finally
    //   404	415	999	finally
    //   421	432	999	finally
    //   438	449	999	finally
    //   455	462	999	finally
    //   473	482	999	finally
    //   491	511	999	finally
    //   520	538	999	finally
    //   549	578	999	finally
    //   581	592	999	finally
    //   595	606	999	finally
    //   609	620	999	finally
    //   626	637	999	finally
    //   640	651	999	finally
    //   658	669	999	finally
    //   672	683	999	finally
    //   690	701	999	finally
    //   704	746	999	finally
    //   755	810	999	finally
    //   813	827	999	finally
    //   827	908	999	finally
    //   59	76	1006	finally
    //   1016	1021	1024	java/lang/Exception
    //   1063	1068	1070	java/lang/Exception
    //   59	76	1108	java/lang/Exception
    //   76	83	1112	java/lang/Exception
    //   134	143	1112	java/lang/Exception
    //   149	156	1112	java/lang/Exception
    //   168	236	1112	java/lang/Exception
    //   239	259	1112	java/lang/Exception
    //   268	276	1112	java/lang/Exception
    //   286	304	1112	java/lang/Exception
    //   309	320	1112	java/lang/Exception
    //   325	336	1112	java/lang/Exception
    //   341	352	1112	java/lang/Exception
    //   357	368	1112	java/lang/Exception
    //   373	384	1112	java/lang/Exception
    //   387	398	1112	java/lang/Exception
    //   404	415	1112	java/lang/Exception
    //   421	432	1112	java/lang/Exception
    //   438	449	1112	java/lang/Exception
    //   455	462	1112	java/lang/Exception
    //   473	482	1112	java/lang/Exception
    //   549	578	1112	java/lang/Exception
    //   581	592	1112	java/lang/Exception
    //   595	606	1112	java/lang/Exception
    //   609	620	1112	java/lang/Exception
    //   626	637	1112	java/lang/Exception
    //   640	651	1112	java/lang/Exception
    //   658	669	1112	java/lang/Exception
    //   672	683	1112	java/lang/Exception
    //   690	701	1112	java/lang/Exception
    //   704	746	1112	java/lang/Exception
    //   755	810	1112	java/lang/Exception
    //   813	827	1112	java/lang/Exception
    //   827	908	1112	java/lang/Exception
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
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   16: astore 7
    //   18: aload 7
    //   20: ldc_w 473
    //   23: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: aload_0
    //   30: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc_w 355
    //   39: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: aload 4
    //   47: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: ldc_w 475
    //   56: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 6
    //   62: aload 7
    //   64: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   70: pop
    //   71: aload 6
    //   73: ldc_w 480
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: iload_3
    //   83: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   93: pop
    //   94: iconst_0
    //   95: istore_3
    //   96: iload_3
    //   97: aload_1
    //   98: invokeinterface 484 1 0
    //   103: if_icmpge +148 -> 251
    //   106: aload 6
    //   108: ldc_w 486
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: getstatic 78	com/tencent/qapmsdk/memory/DumpMemInfoHandler:HEAP_NAME	[Ljava/lang/String;
    //   120: iload_3
    //   121: aaload
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_1
    //   126: iload_3
    //   127: invokeinterface 433 2 0
    //   132: checkcast 117	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   135: invokestatic 453	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   138: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aastore
    //   142: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   148: pop
    //   149: aload_2
    //   150: iload_3
    //   151: invokeinterface 433 2 0
    //   156: checkcast 304	java/util/Map
    //   159: invokeinterface 490 1 0
    //   164: ifle +80 -> 244
    //   167: aload_2
    //   168: iload_3
    //   169: invokeinterface 433 2 0
    //   174: checkcast 304	java/util/Map
    //   177: invokestatic 492	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getSortedHashtableByValue	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   180: astore 7
    //   182: iconst_0
    //   183: istore 5
    //   185: iload 5
    //   187: aload 7
    //   189: arraylength
    //   190: if_icmpge +54 -> 244
    //   193: aload 6
    //   195: ldc_w 494
    //   198: iconst_2
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 7
    //   206: iload 5
    //   208: aaload
    //   209: invokeinterface 498 1 0
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload 7
    //   219: iload 5
    //   221: aaload
    //   222: invokeinterface 501 1 0
    //   227: aastore
    //   228: invokestatic 483	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   234: pop
    //   235: iload 5
    //   237: iconst_1
    //   238: iadd
    //   239: istore 5
    //   241: goto -56 -> 185
    //   244: iload_3
    //   245: iconst_1
    //   246: iadd
    //   247: istore_3
    //   248: goto -152 -> 96
    //   251: new 42	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   258: astore_1
    //   259: aload_1
    //   260: ldc_w 473
    //   263: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: aload_0
    //   269: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_1
    //   274: ldc_w 503
    //   277: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 6
    //   283: aload_1
    //   284: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 478	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: aload 6
    //   293: invokevirtual 504	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   296: astore 6
    //   298: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   301: iconst_2
    //   302: anewarray 64	java/lang/String
    //   305: dup
    //   306: iconst_0
    //   307: ldc 34
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: aload 6
    //   314: aastore
    //   315: invokevirtual 507	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   318: new 42	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   325: astore_1
    //   326: aload_1
    //   327: getstatic 62	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   330: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: ldc 192
    //   337: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: aload_0
    //   343: invokestatic 509	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getProcFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_1
    //   351: ldc 194
    //   353: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_1
    //   358: aload 4
    //   360: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_1
    //   365: ldc_w 511
    //   368: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_1
    //   373: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: astore 4
    //   378: aconst_null
    //   379: astore_2
    //   380: new 513	java/io/BufferedWriter
    //   383: dup
    //   384: new 259	java/io/FileWriter
    //   387: dup
    //   388: aload 4
    //   390: invokespecial 514	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   393: invokespecial 517	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   396: astore_1
    //   397: aload_1
    //   398: astore_0
    //   399: aload_1
    //   400: aload 6
    //   402: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   405: aload_1
    //   406: astore_0
    //   407: aload_1
    //   408: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   411: aload_1
    //   412: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   415: aload 4
    //   417: areturn
    //   418: astore_0
    //   419: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   422: ldc 34
    //   424: aload_0
    //   425: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload 4
    //   430: areturn
    //   431: astore_2
    //   432: goto +12 -> 444
    //   435: astore_0
    //   436: aload_2
    //   437: astore_1
    //   438: goto +45 -> 483
    //   441: astore_2
    //   442: aconst_null
    //   443: astore_1
    //   444: aload_1
    //   445: astore_0
    //   446: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   449: ldc 34
    //   451: aload_2
    //   452: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   455: aload_1
    //   456: ifnull +20 -> 476
    //   459: aload_1
    //   460: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   463: goto +13 -> 476
    //   466: astore_0
    //   467: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   470: ldc 34
    //   472: aload_0
    //   473: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   476: aconst_null
    //   477: areturn
    //   478: astore_2
    //   479: aload_0
    //   480: astore_1
    //   481: aload_2
    //   482: astore_0
    //   483: aload_1
    //   484: ifnull +20 -> 504
    //   487: aload_1
    //   488: invokevirtual 519	java/io/BufferedWriter:close	()V
    //   491: goto +13 -> 504
    //   494: astore_1
    //   495: getstatic 153	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   498: ldc 34
    //   500: aload_1
    //   501: invokevirtual 213	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   504: goto +5 -> 509
    //   507: aload_0
    //   508: athrow
    //   509: goto -2 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	paramString1	String
    //   0	512	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	512	2	paramList1	List<Map<String, java.lang.Integer>>
    //   0	512	3	paramInt	int
    //   0	512	4	paramString2	String
    //   183	57	5	i	int
    //   7	394	6	localObject1	Object
    //   16	202	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   411	415	418	java/io/IOException
    //   399	405	431	java/io/IOException
    //   407	411	431	java/io/IOException
    //   380	397	435	finally
    //   380	397	441	java/io/IOException
    //   459	463	466	java/io/IOException
    //   399	405	478	finally
    //   407	411	478	finally
    //   446	455	478	finally
    //   487	491	494	java/io/IOException
  }
  
  public static Object[] zipFiles(@NonNull List<String> paramList, String paramString)
  {
    String str = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LOG_PATH);
    localStringBuilder.append("dump_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append(".zip");
    paramString = localStringBuilder.toString();
    return new Object[] { Boolean.valueOf(FileUtil.zipFiles(paramList, paramString, false)), paramString };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */