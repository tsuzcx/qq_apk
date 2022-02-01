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
  public static final String[] a = { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
  private static String b = "";
  
  static
  {
    Object localObject2 = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject1 = localObject2;
      if (!((String)localObject2).endsWith("/"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("/");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/Tencent/MobileQQ/log/");
      b = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject2).toString());
      localObject1 = new File(b);
      if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
        ((File)localObject1).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List<DumpMemInfoHandler.StatFields> paramList, List<Map<String, Integer>> paramList1)
  {
    int i = 0;
    for (;;)
    {
      if (new File(paramString).exists()) {
        i = 1;
      }
      try
      {
        Thread.sleep(500L);
        label27:
        if (i >= 10)
        {
          i = 0;
          if (i == 0) {
            return 0;
          }
          BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
          String str1 = null;
          try
          {
            paramString = localBufferedReader.readLine();
          }
          catch (IOException localIOException)
          {
            paramString = str1;
            if (QLog.isColorLevel())
            {
              QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "readMapinfo", localIOException);
              paramString = str1;
            }
          }
          if (paramString == null)
          {
            localBufferedReader.close();
            return 0;
          }
          str1 = "";
          Object localObject2 = paramString;
          paramString = "";
          Object localObject1 = paramString;
          long l1 = 0L;
          int n = 0;
          int i2 = 0;
          int i1 = 11;
          int m = 0;
          int k = 0;
          int j = 0;
          while (n == 0) {
            if (((String)localObject2).length() < 1)
            {
              i1 = 11;
            }
            else
            {
              i = ((String)localObject2).length();
              String str2 = " ";
              int i3;
              if ((i > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
              {
                paramString = ((String)localObject2).split(" ");
                localObject2 = paramString[0].split("-");
                long l3 = Long.parseLong(localObject2[0], 16);
                long l2 = Long.parseLong(localObject2[1], 16);
                i3 = 5;
                i = 5;
                while ((i < paramString.length) && (paramString[i].equals(str1))) {
                  i += 1;
                }
                if (i < paramString.length) {
                  paramString = paramString[i];
                } else {
                  paramString = str1;
                }
                i = paramString.length();
                if (paramString.equals("[heap]"))
                {
                  i = 0;
                }
                else if (paramString.startsWith("/dev/ashmem/dalvik-"))
                {
                  i = 1;
                }
                else if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                {
                  i = 2;
                }
                else if (paramString.startsWith("/dev/ashmem/"))
                {
                  i = 3;
                }
                else if (paramString.startsWith("/dev/"))
                {
                  i = 4;
                }
                else if (paramString.endsWith(".so"))
                {
                  i = i3;
                }
                else if (paramString.endsWith(".jar"))
                {
                  i = 6;
                }
                else if (paramString.endsWith(".apk"))
                {
                  i = 7;
                }
                else if (paramString.endsWith(".ttf"))
                {
                  i = 8;
                }
                else if (paramString.endsWith(".dex"))
                {
                  i = 9;
                }
                else if (i > 0)
                {
                  i = 10;
                }
                else if ((l3 == l1) && (i1 == 5))
                {
                  paramString = (String)localObject1;
                  i = i3;
                }
                else
                {
                  i = 11;
                }
                i1 = i;
                i = j;
                l1 = l2;
                i3 = 0;
                localObject2 = str2;
              }
              else
              {
                i = j;
                i3 = 1;
                i1 = 11;
                localObject2 = str2;
              }
              label938:
              label940:
              for (;;)
              {
                str2 = localBufferedReader.readLine();
                String[] arrayOfString;
                String str3;
                if (str2 == null)
                {
                  n = 1;
                }
                else
                {
                  arrayOfString = str2.split((String)localObject2);
                  str3 = arrayOfString[0];
                  j = 1;
                }
                try
                {
                  while ((j < arrayOfString.length) && (arrayOfString[j].equals(str1))) {
                    j += 1;
                  }
                  if (j < arrayOfString.length) {
                    j = Integer.parseInt(arrayOfString[j]);
                  }
                }
                catch (Exception localException)
                {
                  label593:
                  label605:
                  label606:
                  break label593;
                }
                j = 0;
                break label606;
                break label606;
                if (!str3.equals("Size:")) {}
                for (;;)
                {
                  if (!str3.equals("Rss:"))
                  {
                    if (str3.equals("Pss:")) {
                      m = j;
                    }
                    for (;;)
                    {
                      break label940;
                      if (str3.equals("Shared_Clean:")) {
                        break label938;
                      }
                      if (str3.equals("Shared_Dirty:"))
                      {
                        k = j;
                      }
                      else
                      {
                        if (str3.equals("Private_Clean:")) {
                          break label605;
                        }
                        if (str3.equals("Private_Dirty:"))
                        {
                          i = j;
                        }
                        else
                        {
                          if (str3.equals("Referenced:")) {
                            break label605;
                          }
                          if (str2.length() > 30)
                          {
                            if (str2.charAt(8) == '-')
                            {
                              if (str2.charAt(17) == ' ')
                              {
                                System.out.println(str2);
                                if (i3 == 0)
                                {
                                  localObject1 = (Map)paramList1.get(i1);
                                  if (((Map)localObject1).containsKey(paramString)) {
                                    ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + m));
                                  } else {
                                    ((Map)localObject1).put(paramString, Integer.valueOf(m));
                                  }
                                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(i1);
                                  ((DumpMemInfoHandler.StatFields)localObject1).a += m;
                                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(i1);
                                  ((DumpMemInfoHandler.StatFields)localObject1).b += i;
                                  localObject1 = (DumpMemInfoHandler.StatFields)paramList.get(i1);
                                  ((DumpMemInfoHandler.StatFields)localObject1).c += k;
                                  i2 += m;
                                  localObject1 = paramString;
                                }
                                localObject2 = str2;
                                j = i;
                                break;
                              }
                              break label940;
                            }
                            break label940;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          localBufferedReader.close();
          return i2;
        }
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label27;
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject1).append("/tencent/msflogs/");
    ((StringBuilder)localObject1).append(MobileQQ.getContext().getPackageName().replace(".", "/"));
    ((StringBuilder)localObject1).append("/");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(paramLong);
    localObject2 = a(((Calendar)localObject2).getTimeInMillis(), "yy.MM.dd.HH");
    String str = MsfSdkUtils.getProcessName(MobileQQ.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str.replace(":", "_"));
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
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
        DumpMemInfoHandler.StatFields localStatFields = new DumpMemInfoHandler.StatFields();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localStatFields);
        localArrayList2.add(localHashMap);
        i += 1;
      }
      i = a((String)localObject, localArrayList1, localArrayList2);
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
  
  /* Error */
  public static String a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +35 -> 38
    //   6: new 66	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 366
    //   18: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_0
    //   24: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 134
    //   30: iconst_2
    //   31: aload_3
    //   32: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   41: ldc_w 374
    //   44: invokestatic 300	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   47: astore 5
    //   49: ldc_w 376
    //   52: invokestatic 379	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   55: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq +736 -> 794
    //   61: new 66	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   68: astore_3
    //   69: aload_3
    //   70: invokestatic 46	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   73: invokevirtual 52	java/io/File:getPath	()Ljava/lang/String;
    //   76: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: ldc 78
    //   83: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 48	java/io/File
    //   90: dup
    //   91: aload_3
    //   92: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 84	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 93	java/io/File:exists	()Z
    //   106: ifne +8 -> 114
    //   109: aload_3
    //   110: invokevirtual 99	java/io/File:mkdirs	()Z
    //   113: pop
    //   114: aload_3
    //   115: invokevirtual 382	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   118: astore 4
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: ldc 60
    //   127: invokevirtual 64	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   130: ifne +30 -> 160
    //   133: new 66	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   140: astore_3
    //   141: aload_3
    //   142: aload 4
    //   144: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: ldc 60
    //   151: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore_3
    //   160: new 66	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   167: astore 4
    //   169: aload 4
    //   171: aload_3
    //   172: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: ldc_w 384
    //   181: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 4
    //   187: aload_0
    //   188: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: ldc_w 310
    //   197: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: aload 5
    //   205: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 4
    //   211: ldc_w 386
    //   214: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 4
    //   220: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore 5
    //   225: aconst_null
    //   226: astore 6
    //   228: aconst_null
    //   229: astore_0
    //   230: new 388	java/io/FileOutputStream
    //   233: dup
    //   234: aload 5
    //   236: invokespecial 389	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   239: astore_3
    //   240: new 66	java/lang/StringBuilder
    //   243: dup
    //   244: sipush 1024
    //   247: invokespecial 390	java/lang/StringBuilder:<init>	(I)V
    //   250: astore 4
    //   252: aload 4
    //   254: ldc_w 392
    //   257: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: getstatic 396	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   264: aconst_null
    //   265: invokevirtual 400	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   268: invokevirtual 405	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   271: ifnonnull +10 -> 281
    //   274: ldc_w 407
    //   277: astore_0
    //   278: goto +14 -> 292
    //   281: getstatic 396	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   284: aconst_null
    //   285: invokevirtual 400	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   288: invokevirtual 405	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   291: astore_0
    //   292: aload 4
    //   294: aload_0
    //   295: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 4
    //   301: ldc_w 409
    //   304: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 4
    //   310: ldc_w 411
    //   313: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 4
    //   319: getstatic 416	android/os/Build:MODEL	Ljava/lang/String;
    //   322: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 4
    //   328: ldc_w 409
    //   331: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 4
    //   337: ldc_w 418
    //   340: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 4
    //   346: getstatic 423	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   349: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 4
    //   355: ldc_w 409
    //   358: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 4
    //   364: ldc_w 425
    //   367: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 4
    //   373: bipush 100
    //   375: invokestatic 430	com/tencent/qqperf/MagnifierSDK:b	()Lcom/tencent/qqperf/MagnifierSDK;
    //   378: invokevirtual 434	com/tencent/qqperf/MagnifierSDK:j	()Lcom/tencent/qqperf/opt/clearmemory/MemoryConfigs;
    //   381: getfield 438	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:d	I
    //   384: isub
    //   385: i2l
    //   386: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   389: invokevirtual 447	java/lang/Runtime:maxMemory	()J
    //   392: lmul
    //   393: ldc2_w 448
    //   396: ldiv
    //   397: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 4
    //   403: ldc_w 409
    //   406: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 4
    //   412: ldc_w 454
    //   415: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   424: invokevirtual 457	java/lang/Runtime:totalMemory	()J
    //   427: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   430: invokevirtual 460	java/lang/Runtime:freeMemory	()J
    //   433: lsub
    //   434: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 4
    //   440: ldc_w 409
    //   443: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 4
    //   449: ldc_w 462
    //   452: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 4
    //   458: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   461: invokevirtual 457	java/lang/Runtime:totalMemory	()J
    //   464: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 4
    //   470: ldc_w 409
    //   473: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 4
    //   479: ldc_w 464
    //   482: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 4
    //   488: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   491: invokevirtual 460	java/lang/Runtime:freeMemory	()J
    //   494: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 4
    //   500: ldc_w 409
    //   503: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 4
    //   509: ldc_w 466
    //   512: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 4
    //   518: invokestatic 444	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   521: invokevirtual 447	java/lang/Runtime:maxMemory	()J
    //   524: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 4
    //   530: ldc_w 409
    //   533: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 4
    //   539: ldc_w 468
    //   542: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 4
    //   548: getstatic 473	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   551: invokevirtual 478	android/support/v4/util/MQLruCache:size	()I
    //   554: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: ldc_w 409
    //   563: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 4
    //   569: ldc_w 480
    //   572: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 4
    //   578: invokestatic 485	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:b	()Lcom/tencent/qqperf/opt/clearmemory/MemoryClearManager;
    //   581: getfield 488	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:m	I
    //   584: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 4
    //   590: ldc_w 409
    //   593: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 4
    //   599: ldc_w 490
    //   602: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 4
    //   608: ldc_w 492
    //   611: invokestatic 498	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   614: checkcast 492	com/tencent/mobileqq/qqperf/api/IPerfApi
    //   617: invokeinterface 501 1 0
    //   622: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 4
    //   628: ldc_w 409
    //   631: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 4
    //   637: ldc_w 503
    //   640: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 4
    //   646: lload_1
    //   647: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_3
    //   652: aload 4
    //   654: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokevirtual 507	java/lang/String:getBytes	()[B
    //   660: invokevirtual 511	java/io/FileOutputStream:write	([B)V
    //   663: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +36 -> 702
    //   669: new 66	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   676: astore_0
    //   677: aload_0
    //   678: ldc_w 513
    //   681: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload_0
    //   686: aload 5
    //   688: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: ldc 134
    //   694: iconst_2
    //   695: aload_0
    //   696: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload_3
    //   703: invokevirtual 514	java/io/FileOutputStream:close	()V
    //   706: aload 5
    //   708: areturn
    //   709: astore_0
    //   710: goto +66 -> 776
    //   713: astore 4
    //   715: goto +18 -> 733
    //   718: astore 4
    //   720: aload_0
    //   721: astore_3
    //   722: aload 4
    //   724: astore_0
    //   725: goto +51 -> 776
    //   728: astore 4
    //   730: aload 6
    //   732: astore_3
    //   733: aload_3
    //   734: astore_0
    //   735: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +16 -> 754
    //   741: aload_3
    //   742: astore_0
    //   743: ldc 134
    //   745: iconst_2
    //   746: ldc_w 516
    //   749: aload 4
    //   751: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: aload 5
    //   756: astore_0
    //   757: aload_3
    //   758: ifnull +39 -> 797
    //   761: aload_3
    //   762: invokevirtual 514	java/io/FileOutputStream:close	()V
    //   765: aload 5
    //   767: areturn
    //   768: astore_0
    //   769: aload_0
    //   770: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   773: aload 5
    //   775: areturn
    //   776: aload_3
    //   777: ifnull +15 -> 792
    //   780: aload_3
    //   781: invokevirtual 514	java/io/FileOutputStream:close	()V
    //   784: goto +8 -> 792
    //   787: astore_3
    //   788: aload_3
    //   789: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   792: aload_0
    //   793: athrow
    //   794: ldc 10
    //   796: astore_0
    //   797: aload_0
    //   798: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	paramString	String
    //   0	799	1	paramLong	long
    //   13	768	3	localObject1	Object
    //   787	2	3	localIOException1	IOException
    //   118	535	4	localObject2	Object
    //   713	1	4	localIOException2	IOException
    //   718	5	4	localObject3	Object
    //   728	22	4	localIOException3	IOException
    //   47	727	5	str	String
    //   226	505	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   240	274	709	finally
    //   281	292	709	finally
    //   292	702	709	finally
    //   240	274	713	java/io/IOException
    //   281	292	713	java/io/IOException
    //   292	702	713	java/io/IOException
    //   230	240	718	finally
    //   735	741	718	finally
    //   743	754	718	finally
    //   230	240	728	java/io/IOException
    //   702	706	768	java/io/IOException
    //   761	765	768	java/io/IOException
    //   780	784	787	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, List<DumpMemInfoHandler.StatFields> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 524	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 525	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: new 66	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   16: astore 7
    //   18: aload 7
    //   20: ldc_w 527
    //   23: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: aload_0
    //   30: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: ldc 149
    //   38: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 7
    //   44: aload 4
    //   46: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 7
    //   52: ldc_w 529
    //   55: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 6
    //   61: aload 7
    //   63: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 532	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   69: pop
    //   70: aload 6
    //   72: ldc_w 534
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iload_3
    //   82: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 537	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokevirtual 532	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: iconst_0
    //   94: istore_3
    //   95: iload_3
    //   96: aload_1
    //   97: invokeinterface 538 1 0
    //   102: if_icmpge +148 -> 250
    //   105: aload 6
    //   107: ldc_w 540
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: getstatic 40	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	[Ljava/lang/String;
    //   119: iload_3
    //   120: aaload
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_1
    //   125: iload_3
    //   126: invokeinterface 231 2 0
    //   131: checkcast 252	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler$StatFields
    //   134: getfield 255	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler$StatFields:a	J
    //   137: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: aastore
    //   141: invokestatic 537	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 532	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload_2
    //   149: iload_3
    //   150: invokeinterface 231 2 0
    //   155: checkcast 233	java/util/Map
    //   158: invokeinterface 544 1 0
    //   163: ifle +80 -> 243
    //   166: aload_2
    //   167: iload_3
    //   168: invokeinterface 231 2 0
    //   173: checkcast 233	java/util/Map
    //   176: invokestatic 547	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   179: astore 7
    //   181: iconst_0
    //   182: istore 5
    //   184: iload 5
    //   186: aload 7
    //   188: arraylength
    //   189: if_icmpge +54 -> 243
    //   192: aload 6
    //   194: ldc_w 549
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload 7
    //   205: iload 5
    //   207: aaload
    //   208: invokeinterface 555 1 0
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload 7
    //   218: iload 5
    //   220: aaload
    //   221: invokeinterface 558 1 0
    //   226: aastore
    //   227: invokestatic 537	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokevirtual 532	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   233: pop
    //   234: iload 5
    //   236: iconst_1
    //   237: iadd
    //   238: istore 5
    //   240: goto -56 -> 184
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -152 -> 95
    //   250: new 66	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   257: astore_1
    //   258: aload_1
    //   259: ldc_w 527
    //   262: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_1
    //   267: aload_0
    //   268: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_1
    //   273: ldc_w 560
    //   276: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 6
    //   282: aload_1
    //   283: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokevirtual 532	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   289: pop
    //   290: aload 6
    //   292: invokevirtual 561	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   295: astore 6
    //   297: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +11 -> 311
    //   303: ldc 134
    //   305: iconst_2
    //   306: aload 6
    //   308: invokestatic 564	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: new 66	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   318: astore_1
    //   319: aload_1
    //   320: getstatic 86	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:b	Ljava/lang/String;
    //   323: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: ldc_w 384
    //   331: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: aload_0
    //   337: invokestatic 566	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: ldc_w 310
    //   348: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_1
    //   353: aload 4
    //   355: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_1
    //   360: ldc_w 568
    //   363: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload_1
    //   368: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: astore 4
    //   373: aconst_null
    //   374: astore_1
    //   375: new 570	java/io/FileWriter
    //   378: dup
    //   379: aload 4
    //   381: invokespecial 571	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   384: astore_2
    //   385: new 573	java/io/BufferedWriter
    //   388: dup
    //   389: aload_2
    //   390: invokespecial 576	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   393: astore_0
    //   394: aload_0
    //   395: aload 6
    //   397: invokevirtual 578	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: invokevirtual 579	java/io/BufferedWriter:close	()V
    //   404: aload_2
    //   405: invokevirtual 580	java/io/FileWriter:close	()V
    //   408: aload 4
    //   410: areturn
    //   411: astore 4
    //   413: aload_0
    //   414: astore_1
    //   415: aload 4
    //   417: astore_0
    //   418: goto +10 -> 428
    //   421: astore_0
    //   422: goto +6 -> 428
    //   425: astore_0
    //   426: aconst_null
    //   427: astore_2
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 579	java/io/BufferedWriter:close	()V
    //   436: aload_2
    //   437: ifnull +7 -> 444
    //   440: aload_2
    //   441: invokevirtual 580	java/io/FileWriter:close	()V
    //   444: goto +5 -> 449
    //   447: aload_0
    //   448: athrow
    //   449: goto -2 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramString1	String
    //   0	452	1	paramList	List<DumpMemInfoHandler.StatFields>
    //   0	452	2	paramList1	List<Map<String, Integer>>
    //   0	452	3	paramInt	int
    //   0	452	4	paramString2	String
    //   182	57	5	i	int
    //   7	389	6	localObject1	Object
    //   16	201	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   394	400	411	finally
    //   385	394	421	finally
    //   375	385	425	finally
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n====== [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" meminfo begin] =======\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(FileUtils.readFileContent(new File(paramString2)));
    paramString2 = new StringBuilder();
    paramString2.append("\n====== [");
    paramString2.append(paramString1);
    paramString2.append(" meminfo end] =======\n");
    localStringBuffer.append(paramString2.toString());
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
  
  private static String b(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b);
    ((StringBuilder)localObject1).append(a(paramRunningAppProcessInfo.processName));
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".meminfo");
    localObject1 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      try
      {
        if (MobileQQ.getContext().checkPermission("android.permission.DUMP", paramRunningAppProcessInfo.pid, paramRunningAppProcessInfo.uid) == 0)
        {
          i = 1;
          if (i != 0)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("dumpsys meminfo ");
            ((StringBuilder)localObject2).append(paramRunningAppProcessInfo.processName);
            ((StringBuilder)localObject2).append(" > ");
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject2 = ((StringBuilder)localObject2).toString();
            Runtime.getRuntime().exec((String)localObject2);
            a(paramRunningAppProcessInfo.processName, (String)localObject1, paramString);
          }
          return localObject1;
        }
      }
      catch (IOException paramRunningAppProcessInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateMemInfo", paramRunningAppProcessInfo);
        }
        return "";
      }
      int i = 0;
    }
  }
  
  public static List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(a(l));
    localArrayList.add(a(l - 3600000L));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.LOG_PATH_SDCARD);
    localStringBuilder.append("log.txt");
    localArrayList.add(localStringBuilder.toString());
    return localArrayList;
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   3: ldc_w 374
    //   6: invokestatic 300	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   9: astore 4
    //   11: new 66	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   18: astore 5
    //   20: aload 5
    //   22: getstatic 86	com/tencent/qqperf/monitor/memory/DumpMemInfoHandler:b	Ljava/lang/String;
    //   25: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: ldc_w 684
    //   34: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 5
    //   40: aload 4
    //   42: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: ldc_w 686
    //   51: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 5
    //   57: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 8
    //   62: invokestatic 689	java/lang/Thread:activeCount	()I
    //   65: istore_2
    //   66: iload_2
    //   67: ifne +6 -> 73
    //   70: ldc 10
    //   72: areturn
    //   73: aconst_null
    //   74: astore 6
    //   76: aconst_null
    //   77: astore 7
    //   79: aconst_null
    //   80: astore 4
    //   82: new 573	java/io/BufferedWriter
    //   85: dup
    //   86: new 570	java/io/FileWriter
    //   89: dup
    //   90: aload 8
    //   92: iconst_0
    //   93: invokespecial 692	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   96: invokespecial 576	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   99: astore 5
    //   101: iload_2
    //   102: anewarray 112	java/lang/Thread
    //   105: astore 4
    //   107: aload 4
    //   109: invokestatic 696	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   112: pop
    //   113: new 66	java/lang/StringBuilder
    //   116: dup
    //   117: iload_2
    //   118: sipush 1024
    //   121: imul
    //   122: invokespecial 390	java/lang/StringBuilder:<init>	(I)V
    //   125: astore 6
    //   127: iconst_0
    //   128: istore_0
    //   129: goto +277 -> 406
    //   132: aload 7
    //   134: invokevirtual 699	java/lang/Thread:isAlive	()Z
    //   137: istore_3
    //   138: iload_3
    //   139: ifeq +91 -> 230
    //   142: aload 6
    //   144: ldc_w 701
    //   147: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: aload 7
    //   155: invokevirtual 704	java/lang/Thread:getName	()Ljava/lang/String;
    //   158: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: ldc_w 706
    //   167: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 7
    //   173: invokevirtual 710	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   176: astore 7
    //   178: aload 7
    //   180: ifnull +50 -> 230
    //   183: iconst_0
    //   184: istore_1
    //   185: iload_1
    //   186: aload 7
    //   188: arraylength
    //   189: if_icmpge +41 -> 230
    //   192: aload 6
    //   194: ldc_w 712
    //   197: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 6
    //   203: aload 7
    //   205: iload_1
    //   206: aaload
    //   207: invokevirtual 715	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   210: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 6
    //   216: ldc_w 706
    //   219: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iload_1
    //   224: iconst_1
    //   225: iadd
    //   226: istore_1
    //   227: goto -42 -> 185
    //   230: aload 6
    //   232: ldc_w 706
    //   235: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 5
    //   241: aload 6
    //   243: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 578	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   249: aload 5
    //   251: invokevirtual 718	java/io/BufferedWriter:flush	()V
    //   254: aload 6
    //   256: iconst_0
    //   257: invokevirtual 721	java/lang/StringBuilder:setLength	(I)V
    //   260: iload_0
    //   261: iconst_1
    //   262: iadd
    //   263: istore_0
    //   264: goto +142 -> 406
    //   267: aload 5
    //   269: invokevirtual 579	java/io/BufferedWriter:close	()V
    //   272: aload 8
    //   274: areturn
    //   275: astore 4
    //   277: goto +100 -> 377
    //   280: astore 6
    //   282: goto +31 -> 313
    //   285: astore 6
    //   287: goto +70 -> 357
    //   290: astore 6
    //   292: aload 4
    //   294: astore 5
    //   296: aload 6
    //   298: astore 4
    //   300: goto +77 -> 377
    //   303: astore 4
    //   305: aload 6
    //   307: astore 5
    //   309: aload 4
    //   311: astore 6
    //   313: aload 5
    //   315: astore 4
    //   317: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +18 -> 338
    //   323: aload 5
    //   325: astore 4
    //   327: ldc 134
    //   329: iconst_2
    //   330: ldc_w 723
    //   333: aload 6
    //   335: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: aload 5
    //   340: ifnull +34 -> 374
    //   343: aload 5
    //   345: invokevirtual 579	java/io/BufferedWriter:close	()V
    //   348: aload 8
    //   350: areturn
    //   351: astore 6
    //   353: aload 7
    //   355: astore 5
    //   357: aload 5
    //   359: astore 4
    //   361: aload 6
    //   363: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   366: aload 5
    //   368: ifnull +6 -> 374
    //   371: goto -28 -> 343
    //   374: aload 8
    //   376: areturn
    //   377: aload 5
    //   379: ifnull +8 -> 387
    //   382: aload 5
    //   384: invokevirtual 579	java/io/BufferedWriter:close	()V
    //   387: goto +6 -> 393
    //   390: aload 4
    //   392: athrow
    //   393: goto -3 -> 390
    //   396: astore 4
    //   398: aload 8
    //   400: areturn
    //   401: astore 5
    //   403: goto -16 -> 387
    //   406: iload_0
    //   407: iload_2
    //   408: if_icmpge -141 -> 267
    //   411: aload 4
    //   413: iload_0
    //   414: aaload
    //   415: astore 7
    //   417: aload 7
    //   419: ifnonnull -287 -> 132
    //   422: goto -162 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   128	286	0	i	int
    //   184	43	1	j	int
    //   65	344	2	k	int
    //   137	2	3	bool	boolean
    //   9	99	4	localObject1	Object
    //   275	18	4	localObject2	Object
    //   298	1	4	localObject3	Object
    //   303	7	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   315	76	4	localObject4	Object
    //   396	16	4	localIOException1	IOException
    //   18	365	5	localObject5	Object
    //   401	1	5	localIOException2	IOException
    //   74	181	6	localStringBuilder	StringBuilder
    //   280	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   285	1	6	localIOException3	IOException
    //   290	16	6	localObject6	Object
    //   311	23	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   351	11	6	localIOException4	IOException
    //   77	341	7	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   60	339	8	str	String
    // Exception table:
    //   from	to	target	type
    //   101	127	275	finally
    //   132	138	275	finally
    //   142	178	275	finally
    //   185	223	275	finally
    //   230	260	275	finally
    //   101	127	280	java/lang/OutOfMemoryError
    //   132	138	280	java/lang/OutOfMemoryError
    //   142	178	280	java/lang/OutOfMemoryError
    //   185	223	280	java/lang/OutOfMemoryError
    //   230	260	280	java/lang/OutOfMemoryError
    //   101	127	285	java/io/IOException
    //   132	138	285	java/io/IOException
    //   142	178	285	java/io/IOException
    //   185	223	285	java/io/IOException
    //   230	260	285	java/io/IOException
    //   82	101	290	finally
    //   317	323	290	finally
    //   327	338	290	finally
    //   361	366	290	finally
    //   82	101	303	java/lang/OutOfMemoryError
    //   82	101	351	java/io/IOException
    //   267	272	396	java/io/IOException
    //   343	348	396	java/io/IOException
    //   382	387	401	java/io/IOException
  }
  
  public static String d()
  {
    String str1 = a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("trace_mobileqq");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(".trace");
    str1 = ((StringBuilder)localObject).toString();
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0; (i < 3) && (j == 0); j = k)
    {
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        localObject = Runtime.getRuntime();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("kill -3 ");
        localStringBuilder2.append(Process.myPid());
        ((Runtime)localObject).exec(localStringBuilder2.toString());
        k = 1;
      }
      catch (IOException localIOException)
      {
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateTraces", localIOException);
          k = j;
        }
      }
      i += 1;
    }
    if (j != 0)
    {
      boolean bool = false;
      i = m;
      while ((i < 3) && (!bool))
      {
        String str2 = FileUtils.readFileContent(new File("/data/anr/traces.txt"));
        if (str2 != null) {
          bool = FileUtils.writeFile(b, str1, str2);
        }
        if (!bool) {
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "InterruptedException", localInterruptedException);
            }
          }
        }
        i += 1;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(b);
    localStringBuilder1.append(str1);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */