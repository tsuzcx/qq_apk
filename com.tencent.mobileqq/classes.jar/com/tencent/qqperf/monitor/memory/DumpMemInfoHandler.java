package com.tencent.qqperf.monitor.memory;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

class DumpMemInfoHandler
{
  private static String a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    String str = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (!str.endsWith("/")) {
        localObject = str + "/";
      }
      jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath((String)localObject + "/Tencent/MobileQQ/log/");
      localObject = new File(jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List<DumpMemInfoHandler.StatFields> paramList, List<Map<String, Integer>> paramList1)
  {
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    int k = 0;
    long l1 = 0L;
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      if (new File(paramString).exists()) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          return 0;
        }
        try
        {
          Thread.sleep(500L);
          if (i >= 10)
          {
            i = 0;
            continue;
            BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
            Object localObject2 = null;
            try
            {
              paramString = localBufferedReader.readLine();
              if (paramString != null) {
                break label1040;
              }
              localBufferedReader.close();
              return 0;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                paramString = (String)localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "readMapinfo", localIOException);
                  paramString = (String)localObject2;
                }
              }
            }
            while (i2 == 0)
            {
              int i3 = 0;
              if (((String)localObject2).length() < 1)
              {
                i = 11;
              }
              else
              {
                long l3;
                if ((((String)localObject2).length() > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
                {
                  paramString = ((String)localObject2).split(" ");
                  localObject2 = paramString[0].split("-");
                  l3 = Long.parseLong(localObject2[0], 16);
                  long l2 = Long.parseLong(localObject2[1], 16);
                  n = 5;
                  while ((n < paramString.length) && (paramString[n].equals(""))) {
                    n += 1;
                  }
                  if (n < paramString.length)
                  {
                    paramString = paramString[n];
                    label264:
                    n = paramString.length();
                    if (!paramString.equals("[heap]")) {
                      break label469;
                    }
                    i = 0;
                    label281:
                    l1 = l2;
                    n = i;
                    i = m;
                    label291:
                    localObject2 = localBufferedReader.readLine();
                    if (localObject2 != null) {
                      break label644;
                    }
                    i2 = 1;
                    label306:
                    if (i3 != 0) {
                      break label1010;
                    }
                    localObject1 = (Map)paramList1.get(n);
                    if (!((Map)localObject1).containsKey(paramString)) {
                      break label971;
                    }
                    ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + j));
                  }
                }
                for (;;)
                {
                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(n);
                  ((DumpMemInfoHandler.StatFields)localObject1).a += j;
                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(n);
                  ((DumpMemInfoHandler.StatFields)localObject1).b += i;
                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(n);
                  ((DumpMemInfoHandler.StatFields)localObject1).c += k;
                  i1 += j;
                  localObject1 = paramString;
                  m = i;
                  i = n;
                  break;
                  paramString = "";
                  break label264;
                  label469:
                  if (paramString.startsWith("/dev/ashmem/dalvik-"))
                  {
                    i = 1;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                  {
                    i = 2;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/ashmem/"))
                  {
                    i = 3;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/"))
                  {
                    i = 4;
                    break label281;
                  }
                  if (paramString.endsWith(".so"))
                  {
                    i = 5;
                    break label281;
                  }
                  if (paramString.endsWith(".jar"))
                  {
                    i = 6;
                    break label281;
                  }
                  if (paramString.endsWith(".apk"))
                  {
                    i = 7;
                    break label281;
                  }
                  if (paramString.endsWith(".ttf"))
                  {
                    i = 8;
                    break label281;
                  }
                  if (paramString.endsWith(".dex"))
                  {
                    i = 9;
                    break label281;
                  }
                  if (n > 0)
                  {
                    i = 10;
                    break label281;
                  }
                  if ((l3 != l1) || (i != 5)) {
                    break label1034;
                  }
                  i = 5;
                  paramString = (String)localObject1;
                  break label281;
                  i = m;
                  i3 = 1;
                  n = 11;
                  break label291;
                  label644:
                  String[] arrayOfString = ((String)localObject2).split(" ");
                  Object localObject3 = arrayOfString[0];
                  i4 = 0;
                  m = 1;
                  try
                  {
                    while ((m < arrayOfString.length) && (arrayOfString[m].equals(""))) {
                      m += 1;
                    }
                    if (m >= arrayOfString.length) {
                      break label750;
                    }
                    m = Integer.parseInt(arrayOfString[m]);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      label713:
                      m = i4;
                    }
                  }
                  if (localObject3.equals("Size:"))
                  {
                    m = k;
                    k = j;
                    j = m;
                  }
                  for (;;)
                  {
                    m = k;
                    k = j;
                    j = m;
                    break;
                    label750:
                    m = 0;
                    break label713;
                    if (localObject3.equals("Rss:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Pss:"))
                    {
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Shared_Clean:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Shared_Dirty:"))
                    {
                      k = j;
                      j = m;
                    }
                    else if (localObject3.equals("Private_Clean:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Private_Dirty:"))
                    {
                      i4 = j;
                      i = m;
                      j = k;
                      k = i4;
                    }
                    else
                    {
                      if (!localObject3.equals("Referenced:")) {
                        break label926;
                      }
                      m = j;
                      j = k;
                      k = m;
                    }
                  }
                  label926:
                  if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
                    break label1019;
                  }
                  System.out.println((String)localObject2);
                  break label306;
                  label971:
                  ((Map)localObject1).put(paramString, Integer.valueOf(j));
                }
              }
            }
            localBufferedReader.close();
            return i1;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            int n;
            int i4;
            continue;
            label1010:
            int m = i;
            i = n;
            continue;
            label1019:
            m = j;
            j = k;
            k = m;
            continue;
            label1034:
            i = 11;
            continue;
            label1040:
            i = 11;
            m = 0;
            String str = paramString;
            paramString = "";
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   3: ldc_w 270
    //   6: invokestatic 273	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 275
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 277
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 280	java/lang/Thread:activeCount	()I
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +8 -> 57
    //   52: ldc 11
    //   54: astore_3
    //   55: aload_3
    //   56: areturn
    //   57: new 282	java/io/BufferedWriter
    //   60: dup
    //   61: new 284	java/io/FileWriter
    //   64: dup
    //   65: aload 6
    //   67: iconst_0
    //   68: invokespecial 287	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   71: invokespecial 290	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: iload_2
    //   80: anewarray 111	java/lang/Thread
    //   83: astore 5
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokestatic 294	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: new 67	java/lang/StringBuilder
    //   100: dup
    //   101: iload_2
    //   102: sipush 1024
    //   105: imul
    //   106: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   109: astore 7
    //   111: iconst_0
    //   112: istore_0
    //   113: goto +306 -> 419
    //   116: aload 4
    //   118: astore_3
    //   119: aload 8
    //   121: invokevirtual 300	java/lang/Thread:isAlive	()Z
    //   124: ifeq +115 -> 239
    //   127: aload 4
    //   129: astore_3
    //   130: aload 7
    //   132: ldc_w 302
    //   135: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_3
    //   142: aload 7
    //   144: aload 8
    //   146: invokevirtual 305	java/lang/Thread:getName	()Ljava/lang/String;
    //   149: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 4
    //   155: astore_3
    //   156: aload 7
    //   158: ldc_w 307
    //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: astore_3
    //   168: aload 8
    //   170: invokevirtual 311	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +62 -> 239
    //   180: iconst_0
    //   181: istore_1
    //   182: aload 4
    //   184: astore_3
    //   185: iload_1
    //   186: aload 8
    //   188: arraylength
    //   189: if_icmpge +50 -> 239
    //   192: aload 4
    //   194: astore_3
    //   195: aload 7
    //   197: ldc_w 313
    //   200: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: astore_3
    //   207: aload 7
    //   209: aload 8
    //   211: iload_1
    //   212: aaload
    //   213: invokevirtual 316	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   216: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: astore_3
    //   223: aload 7
    //   225: ldc_w 307
    //   228: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: goto -54 -> 182
    //   239: aload 4
    //   241: astore_3
    //   242: aload 7
    //   244: ldc_w 307
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_3
    //   254: aload 4
    //   256: aload 7
    //   258: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 319	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: astore_3
    //   267: aload 4
    //   269: invokevirtual 322	java/io/BufferedWriter:flush	()V
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: iconst_0
    //   278: invokevirtual 325	java/lang/StringBuilder:setLength	(I)V
    //   281: goto +154 -> 435
    //   284: astore 5
    //   286: aload 4
    //   288: astore_3
    //   289: aload 5
    //   291: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   294: aload 6
    //   296: astore_3
    //   297: aload 4
    //   299: ifnull -244 -> 55
    //   302: aload 4
    //   304: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   307: aload 6
    //   309: areturn
    //   310: astore_3
    //   311: aload 6
    //   313: areturn
    //   314: aload 6
    //   316: astore_3
    //   317: aload 4
    //   319: ifnull -264 -> 55
    //   322: aload 4
    //   324: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   327: aload 6
    //   329: areturn
    //   330: astore_3
    //   331: aload 6
    //   333: areturn
    //   334: astore 5
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: astore_3
    //   342: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +17 -> 362
    //   348: aload 4
    //   350: astore_3
    //   351: ldc 136
    //   353: iconst_2
    //   354: ldc_w 331
    //   357: aload 5
    //   359: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 6
    //   364: astore_3
    //   365: aload 4
    //   367: ifnull -312 -> 55
    //   370: aload 4
    //   372: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   375: aload 6
    //   377: areturn
    //   378: astore_3
    //   379: aload 6
    //   381: areturn
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +7 -> 394
    //   390: aload_3
    //   391: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   394: aload 4
    //   396: athrow
    //   397: astore_3
    //   398: goto -4 -> 394
    //   401: astore 4
    //   403: goto -17 -> 386
    //   406: astore 5
    //   408: goto -69 -> 339
    //   411: astore 5
    //   413: aconst_null
    //   414: astore 4
    //   416: goto -130 -> 286
    //   419: iload_0
    //   420: iload_2
    //   421: if_icmpge -107 -> 314
    //   424: aload 5
    //   426: iload_0
    //   427: aaload
    //   428: astore 8
    //   430: aload 8
    //   432: ifnonnull -316 -> 116
    //   435: iload_0
    //   436: iconst_1
    //   437: iadd
    //   438: istore_0
    //   439: goto -20 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   112	327	0	i	int
    //   181	55	1	j	int
    //   47	375	2	k	int
    //   9	288	3	localObject1	Object
    //   310	1	3	localIOException1	IOException
    //   316	1	3	localObject2	Object
    //   330	1	3	localIOException2	IOException
    //   341	24	3	localObject3	Object
    //   378	1	3	localIOException3	IOException
    //   385	6	3	localObject4	Object
    //   397	1	3	localIOException4	IOException
    //   74	297	4	localBufferedWriter	java.io.BufferedWriter
    //   382	13	4	localObject5	Object
    //   401	1	4	localObject6	Object
    //   414	1	4	localObject7	Object
    //   83	6	5	arrayOfThread	Thread[]
    //   284	6	5	localIOException5	IOException
    //   334	24	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   406	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   411	14	5	localIOException6	IOException
    //   42	338	6	str	String
    //   109	167	7	localStringBuilder	java.lang.StringBuilder
    //   119	312	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   79	85	284	java/io/IOException
    //   88	94	284	java/io/IOException
    //   97	111	284	java/io/IOException
    //   119	127	284	java/io/IOException
    //   130	139	284	java/io/IOException
    //   142	153	284	java/io/IOException
    //   156	165	284	java/io/IOException
    //   168	175	284	java/io/IOException
    //   185	192	284	java/io/IOException
    //   195	204	284	java/io/IOException
    //   207	220	284	java/io/IOException
    //   223	232	284	java/io/IOException
    //   242	251	284	java/io/IOException
    //   254	264	284	java/io/IOException
    //   267	272	284	java/io/IOException
    //   275	281	284	java/io/IOException
    //   302	307	310	java/io/IOException
    //   322	327	330	java/io/IOException
    //   57	76	334	java/lang/OutOfMemoryError
    //   370	375	378	java/io/IOException
    //   57	76	382	finally
    //   390	394	397	java/io/IOException
    //   79	85	401	finally
    //   88	94	401	finally
    //   97	111	401	finally
    //   119	127	401	finally
    //   130	139	401	finally
    //   142	153	401	finally
    //   156	165	401	finally
    //   168	175	401	finally
    //   185	192	401	finally
    //   195	204	401	finally
    //   207	220	401	finally
    //   223	232	401	finally
    //   242	251	401	finally
    //   254	264	401	finally
    //   267	272	401	finally
    //   275	281	401	finally
    //   289	294	401	finally
    //   342	348	401	finally
    //   351	362	401	finally
    //   79	85	406	java/lang/OutOfMemoryError
    //   88	94	406	java/lang/OutOfMemoryError
    //   97	111	406	java/lang/OutOfMemoryError
    //   119	127	406	java/lang/OutOfMemoryError
    //   130	139	406	java/lang/OutOfMemoryError
    //   142	153	406	java/lang/OutOfMemoryError
    //   156	165	406	java/lang/OutOfMemoryError
    //   168	175	406	java/lang/OutOfMemoryError
    //   185	192	406	java/lang/OutOfMemoryError
    //   195	204	406	java/lang/OutOfMemoryError
    //   207	220	406	java/lang/OutOfMemoryError
    //   223	232	406	java/lang/OutOfMemoryError
    //   242	251	406	java/lang/OutOfMemoryError
    //   254	264	406	java/lang/OutOfMemoryError
    //   267	272	406	java/lang/OutOfMemoryError
    //   275	281	406	java/lang/OutOfMemoryError
    //   57	76	411	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    String str1 = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + MobileQQ.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(MobileQQ.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  private static String a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    try
    {
      String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
      ArrayList localArrayList1 = new ArrayList(12);
      ArrayList localArrayList2 = new ArrayList(12);
      int i = 0;
      while (i < 12)
      {
        DumpMemInfoHandler.StatFields localStatFields = new DumpMemInfoHandler.StatFields();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localStatFields);
        localArrayList2.add(localHashMap);
        i += 1;
      }
      i = a(str, localArrayList1, localArrayList2);
      if (i > 0) {
        return a(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
      }
      return "";
    }
    catch (Throwable paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateDetailMemory", paramRunningAppProcessInfo);
      }
    }
    return null;
  }
  
  private static String a(String paramString)
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
  
  /* Error */
  public static String a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 11
    //   2: astore_3
    //   3: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 136
    //   11: iconst_2
    //   12: new 67	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 432
    //   22: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 435	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   38: ldc_w 270
    //   41: invokestatic 273	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   44: astore 5
    //   46: ldc_w 437
    //   49: invokestatic 440	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   52: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +678 -> 733
    //   58: new 49	java/io/File
    //   61: dup
    //   62: new 67	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   69: invokestatic 47	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   72: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   75: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 79
    //   80: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 85	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore_3
    //   93: aload_3
    //   94: invokevirtual 92	java/io/File:exists	()Z
    //   97: ifne +8 -> 105
    //   100: aload_3
    //   101: invokevirtual 98	java/io/File:mkdirs	()Z
    //   104: pop
    //   105: aload_3
    //   106: invokevirtual 443	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: ldc 61
    //   118: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   121: ifne +24 -> 145
    //   124: new 67	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   131: aload 4
    //   133: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 61
    //   138: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_3
    //   145: new 67	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   152: aload_3
    //   153: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 445
    //   159: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 378
    //   169: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 447
    //   180: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 5
    //   188: new 449	java/io/FileOutputStream
    //   191: dup
    //   192: aload 5
    //   194: invokespecial 450	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   197: astore_3
    //   198: aload_3
    //   199: astore_0
    //   200: new 67	java/lang/StringBuilder
    //   203: dup
    //   204: sipush 1024
    //   207: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   210: astore 6
    //   212: aload_3
    //   213: astore_0
    //   214: aload 6
    //   216: ldc_w 452
    //   219: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_3
    //   224: astore_0
    //   225: getstatic 456	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   228: aconst_null
    //   229: invokevirtual 460	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   232: invokevirtual 465	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   235: ifnonnull +500 -> 735
    //   238: ldc_w 467
    //   241: astore 4
    //   243: aload_3
    //   244: astore_0
    //   245: aload 6
    //   247: aload 4
    //   249: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: astore_0
    //   255: aload 6
    //   257: ldc_w 469
    //   260: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_3
    //   265: astore_0
    //   266: aload 6
    //   268: ldc_w 471
    //   271: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_3
    //   276: astore_0
    //   277: aload 6
    //   279: getstatic 476	android/os/Build:MODEL	Ljava/lang/String;
    //   282: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_3
    //   287: astore_0
    //   288: aload 6
    //   290: ldc_w 469
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_3
    //   298: astore_0
    //   299: aload 6
    //   301: ldc_w 478
    //   304: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_3
    //   309: astore_0
    //   310: aload 6
    //   312: getstatic 483	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   315: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: astore_0
    //   321: aload 6
    //   323: ldc_w 469
    //   326: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: astore_0
    //   332: aload 6
    //   334: ldc_w 485
    //   337: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_3
    //   342: astore_0
    //   343: aload 6
    //   345: bipush 100
    //   347: invokestatic 490	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   350: invokevirtual 493	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryConfigs;
    //   353: getfield 497	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:a	I
    //   356: isub
    //   357: i2l
    //   358: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   361: invokevirtual 506	java/lang/Runtime:maxMemory	()J
    //   364: lmul
    //   365: ldc2_w 507
    //   368: ldiv
    //   369: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_3
    //   374: astore_0
    //   375: aload 6
    //   377: ldc_w 469
    //   380: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_3
    //   385: astore_0
    //   386: aload 6
    //   388: ldc_w 513
    //   391: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_3
    //   396: astore_0
    //   397: aload 6
    //   399: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   402: invokevirtual 516	java/lang/Runtime:totalMemory	()J
    //   405: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   408: invokevirtual 519	java/lang/Runtime:freeMemory	()J
    //   411: lsub
    //   412: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_3
    //   417: astore_0
    //   418: aload 6
    //   420: ldc_w 469
    //   423: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_3
    //   428: astore_0
    //   429: aload 6
    //   431: ldc_w 521
    //   434: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_3
    //   439: astore_0
    //   440: aload 6
    //   442: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   445: invokevirtual 516	java/lang/Runtime:totalMemory	()J
    //   448: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_3
    //   453: astore_0
    //   454: aload 6
    //   456: ldc_w 469
    //   459: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_3
    //   464: astore_0
    //   465: aload 6
    //   467: ldc_w 523
    //   470: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload_3
    //   475: astore_0
    //   476: aload 6
    //   478: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   481: invokevirtual 519	java/lang/Runtime:freeMemory	()J
    //   484: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload_3
    //   489: astore_0
    //   490: aload 6
    //   492: ldc_w 469
    //   495: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload_3
    //   500: astore_0
    //   501: aload 6
    //   503: ldc_w 525
    //   506: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_3
    //   511: astore_0
    //   512: aload 6
    //   514: invokestatic 503	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   517: invokevirtual 506	java/lang/Runtime:maxMemory	()J
    //   520: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_3
    //   525: astore_0
    //   526: aload 6
    //   528: ldc_w 469
    //   531: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_3
    //   536: astore_0
    //   537: aload 6
    //   539: ldc_w 527
    //   542: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_3
    //   547: astore_0
    //   548: aload 6
    //   550: getstatic 532	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   553: invokevirtual 537	android/support/v4/util/MQLruCache:size	()I
    //   556: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_3
    //   561: astore_0
    //   562: aload 6
    //   564: ldc_w 469
    //   567: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_3
    //   572: astore_0
    //   573: aload 6
    //   575: ldc_w 539
    //   578: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_3
    //   583: astore_0
    //   584: aload 6
    //   586: invokestatic 544	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryClearManager;
    //   589: getfield 546	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:d	I
    //   592: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload_3
    //   597: astore_0
    //   598: aload 6
    //   600: ldc_w 469
    //   603: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_3
    //   608: astore_0
    //   609: aload 6
    //   611: ldc_w 548
    //   614: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload_3
    //   619: astore_0
    //   620: aload 6
    //   622: ldc_w 550
    //   625: invokestatic 556	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   628: checkcast 550	com/tencent/mobileqq/qqperf/api/IPerfApi
    //   631: invokeinterface 559 1 0
    //   636: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_3
    //   641: astore_0
    //   642: aload 6
    //   644: ldc_w 469
    //   647: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_3
    //   652: astore_0
    //   653: aload 6
    //   655: ldc_w 561
    //   658: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload_3
    //   663: astore_0
    //   664: aload 6
    //   666: lload_1
    //   667: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_3
    //   672: astore_0
    //   673: aload_3
    //   674: aload 6
    //   676: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokevirtual 565	java/lang/String:getBytes	()[B
    //   682: invokevirtual 568	java/io/FileOutputStream:write	([B)V
    //   685: aload_3
    //   686: astore_0
    //   687: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +32 -> 722
    //   693: aload_3
    //   694: astore_0
    //   695: ldc 136
    //   697: iconst_2
    //   698: new 67	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   705: ldc_w 570
    //   708: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 5
    //   713: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 435	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: aload_3
    //   723: ifnull +111 -> 834
    //   726: aload_3
    //   727: invokevirtual 571	java/io/FileOutputStream:close	()V
    //   730: aload 5
    //   732: astore_3
    //   733: aload_3
    //   734: areturn
    //   735: aload_3
    //   736: astore_0
    //   737: getstatic 456	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   740: aconst_null
    //   741: invokevirtual 460	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   744: invokevirtual 465	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   747: astore 4
    //   749: goto -506 -> 243
    //   752: astore_0
    //   753: aload_0
    //   754: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   757: aload 5
    //   759: areturn
    //   760: astore 4
    //   762: aconst_null
    //   763: astore_3
    //   764: aload_3
    //   765: astore_0
    //   766: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +16 -> 785
    //   772: aload_3
    //   773: astore_0
    //   774: ldc 136
    //   776: iconst_2
    //   777: ldc_w 573
    //   780: aload 4
    //   782: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   785: aload_3
    //   786: ifnull +48 -> 834
    //   789: aload_3
    //   790: invokevirtual 571	java/io/FileOutputStream:close	()V
    //   793: aload 5
    //   795: areturn
    //   796: astore_0
    //   797: aload_0
    //   798: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   801: aload 5
    //   803: areturn
    //   804: astore_3
    //   805: aconst_null
    //   806: astore_0
    //   807: aload_0
    //   808: ifnull +7 -> 815
    //   811: aload_0
    //   812: invokevirtual 571	java/io/FileOutputStream:close	()V
    //   815: aload_3
    //   816: athrow
    //   817: astore_0
    //   818: aload_0
    //   819: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   822: goto -7 -> 815
    //   825: astore_3
    //   826: goto -19 -> 807
    //   829: astore 4
    //   831: goto -67 -> 764
    //   834: aload 5
    //   836: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	paramString	String
    //   0	837	1	paramLong	long
    //   2	788	3	localObject1	Object
    //   804	12	3	localObject2	Object
    //   825	1	3	localObject3	Object
    //   109	639	4	str1	String
    //   760	21	4	localIOException1	IOException
    //   829	1	4	localIOException2	IOException
    //   44	791	5	str2	String
    //   210	465	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   726	730	752	java/io/IOException
    //   188	198	760	java/io/IOException
    //   789	793	796	java/io/IOException
    //   188	198	804	finally
    //   811	815	817	java/io/IOException
    //   200	212	825	finally
    //   214	223	825	finally
    //   225	238	825	finally
    //   245	253	825	finally
    //   255	264	825	finally
    //   266	275	825	finally
    //   277	286	825	finally
    //   288	297	825	finally
    //   299	308	825	finally
    //   310	319	825	finally
    //   321	330	825	finally
    //   332	341	825	finally
    //   343	373	825	finally
    //   375	384	825	finally
    //   386	395	825	finally
    //   397	416	825	finally
    //   418	427	825	finally
    //   429	438	825	finally
    //   440	452	825	finally
    //   454	463	825	finally
    //   465	474	825	finally
    //   476	488	825	finally
    //   490	499	825	finally
    //   501	510	825	finally
    //   512	524	825	finally
    //   526	535	825	finally
    //   537	546	825	finally
    //   548	560	825	finally
    //   562	571	825	finally
    //   573	582	825	finally
    //   584	596	825	finally
    //   598	607	825	finally
    //   609	618	825	finally
    //   620	640	825	finally
    //   642	651	825	finally
    //   653	662	825	finally
    //   664	671	825	finally
    //   673	685	825	finally
    //   687	693	825	finally
    //   695	722	825	finally
    //   737	749	825	finally
    //   766	772	825	finally
    //   774	785	825	finally
    //   200	212	829	java/io/IOException
    //   214	223	829	java/io/IOException
    //   225	238	829	java/io/IOException
    //   245	253	829	java/io/IOException
    //   255	264	829	java/io/IOException
    //   266	275	829	java/io/IOException
    //   277	286	829	java/io/IOException
    //   288	297	829	java/io/IOException
    //   299	308	829	java/io/IOException
    //   310	319	829	java/io/IOException
    //   321	330	829	java/io/IOException
    //   332	341	829	java/io/IOException
    //   343	373	829	java/io/IOException
    //   375	384	829	java/io/IOException
    //   386	395	829	java/io/IOException
    //   397	416	829	java/io/IOException
    //   418	427	829	java/io/IOException
    //   429	438	829	java/io/IOException
    //   440	452	829	java/io/IOException
    //   454	463	829	java/io/IOException
    //   465	474	829	java/io/IOException
    //   476	488	829	java/io/IOException
    //   490	499	829	java/io/IOException
    //   501	510	829	java/io/IOException
    //   512	524	829	java/io/IOException
    //   526	535	829	java/io/IOException
    //   537	546	829	java/io/IOException
    //   548	560	829	java/io/IOException
    //   562	571	829	java/io/IOException
    //   573	582	829	java/io/IOException
    //   584	596	829	java/io/IOException
    //   598	607	829	java/io/IOException
    //   609	618	829	java/io/IOException
    //   620	640	829	java/io/IOException
    //   642	651	829	java/io/IOException
    //   653	662	829	java/io/IOException
    //   664	671	829	java/io/IOException
    //   673	685	829	java/io/IOException
    //   687	693	829	java/io/IOException
    //   695	722	829	java/io/IOException
    //   737	749	829	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, List<DumpMemInfoHandler.StatFields> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 575	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 576	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 578
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 152
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 580
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 585
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_3
    //   63: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 588	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_1
    //   78: invokeinterface 589 1 0
    //   83: if_icmpge +148 -> 231
    //   86: aload 6
    //   88: ldc_w 591
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 41	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   100: iload_3
    //   101: aaload
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: iload_3
    //   107: invokeinterface 176 2 0
    //   112: checkcast 199	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler$StatFields
    //   115: getfield 202	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler$StatFields:a	J
    //   118: invokestatic 594	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 588	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload_2
    //   130: iload_3
    //   131: invokeinterface 176 2 0
    //   136: checkcast 178	java/util/Map
    //   139: invokeinterface 595 1 0
    //   144: ifle +80 -> 224
    //   147: aload_2
    //   148: iload_3
    //   149: invokeinterface 176 2 0
    //   154: checkcast 178	java/util/Map
    //   157: invokestatic 598	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   160: astore 7
    //   162: iconst_0
    //   163: istore 5
    //   165: iload 5
    //   167: aload 7
    //   169: arraylength
    //   170: if_icmpge +54 -> 224
    //   173: aload 6
    //   175: ldc_w 600
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: iload 5
    //   188: aaload
    //   189: invokeinterface 606 1 0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: iload 5
    //   201: aaload
    //   202: invokeinterface 609 1 0
    //   207: aastore
    //   208: invokestatic 588	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: iload 5
    //   217: iconst_1
    //   218: iadd
    //   219: istore 5
    //   221: goto -56 -> 165
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: goto -152 -> 76
    //   231: aload 6
    //   233: new 67	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 578
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 611
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 6
    //   265: invokevirtual 612	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   268: astore_2
    //   269: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +10 -> 282
    //   275: ldc 136
    //   277: iconst_2
    //   278: aload_2
    //   279: invokestatic 615	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: new 67	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   289: getstatic 13	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   292: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 445
    //   298: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: invokestatic 617	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc_w 378
    //   311: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 4
    //   316: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 619
    //   322: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 4
    //   330: new 284	java/io/FileWriter
    //   333: dup
    //   334: aload 4
    //   336: invokespecial 620	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   339: astore_0
    //   340: new 282	java/io/BufferedWriter
    //   343: dup
    //   344: aload_0
    //   345: invokespecial 290	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_2
    //   351: invokevirtual 319	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   362: aload_0
    //   363: ifnull +7 -> 370
    //   366: aload_0
    //   367: invokevirtual 621	java/io/FileWriter:close	()V
    //   370: aload 4
    //   372: areturn
    //   373: astore_0
    //   374: aconst_null
    //   375: astore_2
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_1
    //   379: ifnull +7 -> 386
    //   382: aload_1
    //   383: invokevirtual 329	java/io/BufferedWriter:close	()V
    //   386: aload_2
    //   387: ifnull +7 -> 394
    //   390: aload_2
    //   391: invokevirtual 621	java/io/FileWriter:close	()V
    //   394: aload_0
    //   395: athrow
    //   396: astore 4
    //   398: aconst_null
    //   399: astore_1
    //   400: aload_0
    //   401: astore_2
    //   402: aload 4
    //   404: astore_0
    //   405: goto -27 -> 378
    //   408: astore 4
    //   410: aload_0
    //   411: astore_2
    //   412: aload 4
    //   414: astore_0
    //   415: goto -37 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString1	String
    //   0	418	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	418	2	paramList1	List<Map<String, Integer>>
    //   0	418	3	paramInt	int
    //   0	418	4	paramString2	String
    //   163	57	5	i	int
    //   7	257	6	localStringBuffer	StringBuffer
    //   160	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   330	340	373	finally
    //   340	349	396	finally
    //   349	354	408	finally
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(10);
    String str1 = a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    Iterator localIterator = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).processName.startsWith("com.tencent.mobileqq"))
      {
        String str2 = a((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
        localObject = b((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(FileUtils.a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPMDumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  private static Map.Entry[] a(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new DumpMemInfoHandler.1());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int i = 0;
    for (int j = 0;; j = k)
    {
      if ((i >= 3) || (j != 0)) {
        break label139;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        k = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateTraces", localIOException);
            k = j;
          }
        }
      }
      i += 1;
    }
    label139:
    if (j != 0)
    {
      i = 0;
      boolean bool = false;
      for (;;)
      {
        if ((i < 3) && (!bool))
        {
          String str2 = FileUtils.a(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = FileUtils.a(jdField_a_of_type_JavaLangString, str1, str2);
          }
          if (!bool) {}
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "InterruptedException", localInterruptedException);
              }
            }
          }
        }
      }
    }
    return jdField_a_of_type_JavaLangString + str1;
  }
  
  private static String b(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    String str1 = jdField_a_of_type_JavaLangString + a(paramRunningAppProcessInfo.processName) + paramString + ".meminfo";
    try
    {
      if (MobileQQ.getContext().checkPermission("android.permission.DUMP", paramRunningAppProcessInfo.pid, paramRunningAppProcessInfo.uid) == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          String str2 = "dumpsys meminfo " + paramRunningAppProcessInfo.processName + " > " + str1;
          Runtime.getRuntime().exec(str2);
          a(paramRunningAppProcessInfo.processName, str1, paramString);
        }
        return str1;
      }
      return "";
    }
    catch (IOException paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateMemInfo", paramRunningAppProcessInfo);
      }
    }
  }
  
  public static List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(a(l));
    localArrayList.add(a(l - 3600000L));
    localArrayList.add(AppConstants.LOG_PATH_SDCARD + "log.txt");
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */