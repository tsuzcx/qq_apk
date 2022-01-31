package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public class UpdateArkSo
  extends Step
{
  private static int a(String paramString)
  {
    if (paramString.equals("ark-armeabi-v7a")) {
      return ark.arkGetPlatformBuildNumber();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getPlatformBuildNumber();
    }
    return 0;
  }
  
  private static long a(String paramString)
  {
    if (paramString.equals("ark-armeabi-v7a")) {
      return ark.arkGetARMv7LibCRC32();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibCRC32();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibCRC32();
    }
    return -1L;
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkEngineExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return paramContext.getParent() + "/txlib/";
  }
  
  private static String a(String paramString)
  {
    return String.format("lib%s.so", new Object[] { paramString });
  }
  
  private static String a(String paramString, int paramInt)
  {
    return String.format(Locale.CHINA, "lib%s-%d.so", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private static void a(String paramString1, String paramString2)
  {
    paramString2 = String.format("lib%s", new Object[] { paramString2 });
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkEngineExtract", 2, "path.listFiles return null!!");
      }
    }
    for (;;)
    {
      return;
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        String str = localObject.getName();
        if (str.startsWith(paramString2))
        {
          localObject.delete();
          if (QLog.isColorLevel()) {
            QLog.d("ArkEngineExtract", 2, new Object[] { "remove previous so: ", str });
          }
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 62
    //   11: iconst_2
    //   12: new 72	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   19: ldc 152
    //   21: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 72	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   41: aload_0
    //   42: invokestatic 154	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   45: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokestatic 156	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 7
    //   60: aload_1
    //   61: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateArkSo:b	(Ljava/lang/String;)I
    //   64: istore_2
    //   65: aload_1
    //   66: invokestatic 161	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)J
    //   69: lstore_3
    //   70: new 75	java/io/File
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: aload 8
    //   83: invokevirtual 164	java/io/File:exists	()Z
    //   86: ifeq +93 -> 179
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +14 -> 105
    //   94: iload_2
    //   95: i2l
    //   96: aload 8
    //   98: invokevirtual 167	java/io/File:length	()J
    //   101: lcmp
    //   102: ifne +77 -> 179
    //   105: lload_3
    //   106: ldc2_w 46
    //   109: lcmp
    //   110: ifeq +17 -> 127
    //   113: aload 8
    //   115: invokestatic 173	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   118: lstore 5
    //   120: lload_3
    //   121: lload 5
    //   123: lcmp
    //   124: ifne +55 -> 179
    //   127: aload 7
    //   129: invokestatic 178	java/lang/System:load	(Ljava/lang/String;)V
    //   132: ldc 2
    //   134: monitorexit
    //   135: iconst_1
    //   136: ireturn
    //   137: astore 9
    //   139: new 72	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   146: ldc 180
    //   148: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 9
    //   160: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +11 -> 174
    //   166: ldc 62
    //   168: iconst_2
    //   169: aload 9
    //   171: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload 9
    //   176: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   179: aload 8
    //   181: invokevirtual 140	java/io/File:delete	()Z
    //   184: pop
    //   185: aload_0
    //   186: aload_1
    //   187: invokestatic 187	com/tencent/mobileqq/startup/step/UpdateArkSo:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   190: ifeq +103 -> 293
    //   193: aload 7
    //   195: invokestatic 178	java/lang/System:load	(Ljava/lang/String;)V
    //   198: goto -66 -> 132
    //   201: astore_0
    //   202: new 72	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   209: ldc 189
    //   211: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore_0
    //   222: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +10 -> 235
    //   228: ldc 62
    //   230: iconst_2
    //   231: aload_0
    //   232: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   239: goto -107 -> 132
    //   242: astore_0
    //   243: ldc 2
    //   245: monitorexit
    //   246: aload_0
    //   247: athrow
    //   248: astore 9
    //   250: new 72	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   257: ldc 191
    //   259: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_1
    //   263: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore 9
    //   271: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +11 -> 285
    //   277: ldc 62
    //   279: iconst_2
    //   280: aload 9
    //   282: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload 9
    //   287: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   290: goto -111 -> 179
    //   293: new 72	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   300: ldc 193
    //   302: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore_0
    //   313: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +10 -> 326
    //   319: ldc 62
    //   321: iconst_2
    //   322: aload_0
    //   323: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aload_0
    //   327: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   330: goto -198 -> 132
    //   333: astore_0
    //   334: new 72	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   341: ldc 195
    //   343: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_1
    //   347: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: astore_0
    //   354: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +10 -> 367
    //   360: ldc 62
    //   362: iconst_2
    //   363: aload_0
    //   364: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   371: goto -239 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramContext	Context
    //   0	374	1	paramString	String
    //   64	31	2	i	int
    //   69	52	3	l1	long
    //   118	4	5	l2	long
    //   58	136	7	str1	String
    //   79	101	8	localFile	File
    //   137	1	9	localSecurityException	java.lang.SecurityException
    //   158	17	9	str2	String
    //   248	1	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   269	17	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   127	132	137	java/lang/SecurityException
    //   185	198	201	java/lang/SecurityException
    //   293	326	201	java/lang/SecurityException
    //   326	330	201	java/lang/SecurityException
    //   3	34	242	finally
    //   34	89	242	finally
    //   94	105	242	finally
    //   113	120	242	finally
    //   127	132	242	finally
    //   139	174	242	finally
    //   174	179	242	finally
    //   179	185	242	finally
    //   185	198	242	finally
    //   202	235	242	finally
    //   235	239	242	finally
    //   250	285	242	finally
    //   285	290	242	finally
    //   293	326	242	finally
    //   326	330	242	finally
    //   334	367	242	finally
    //   367	371	242	finally
    //   127	132	248	java/lang/UnsatisfiedLinkError
    //   185	198	333	java/lang/UnsatisfiedLinkError
    //   293	326	333	java/lang/UnsatisfiedLinkError
    //   326	330	333	java/lang/UnsatisfiedLinkError
  }
  
  private static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      Object localObject;
      File localFile1;
      int i;
      int k;
      try
      {
        j = a(paramString);
        if (j != 0)
        {
          String str;
          if (paramBoolean)
          {
            break label564;
            paramBoolean = false;
            localObject = null;
            localFile1 = null;
            long l1 = SystemClock.uptimeMillis();
            str = a(paramContext);
            if (TextUtils.isEmpty(str))
            {
              paramContext = "arkso.getTxlibPath.return.null";
              paramString = localFile1;
              l2 = SystemClock.uptimeMillis();
              if (QLog.isColorLevel())
              {
                if (!paramBoolean) {
                  continue;
                }
                QLog.d("ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
              }
              if (paramContext != null) {
                ArkAppDataReport.a(paramContext);
              }
              return paramBoolean;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          File localFile2 = new File(str);
          if ((!localFile2.exists()) && (!localFile2.mkdir()))
          {
            paramContext = "arkso.getTxlibPath.mkdir.fail";
            paramString = localFile1;
            continue;
          }
          int m = b(paramString);
          long l2 = a(paramString);
          localFile1 = new File(str + a(paramString, j));
          if (localFile1.exists())
          {
            if ((m == -1) || (m == localFile1.length())) {
              break label589;
            }
            j = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label595;
            }
            k = 1;
            j = k | j;
            if ((j == 0) || (!QLog.isColorLevel())) {
              break label569;
            }
            QLog.d("ArkEngineExtract", 2, new Object[] { "arkso.corrupt.", localFile1.getName() });
            break label569;
            localFile1.delete();
          }
          localFile2 = new File(str + a(paramString));
          localFile2.delete();
          a(str, paramString);
          if ((localFile2.exists()) || (localFile1.exists()))
          {
            if (localFile2.exists())
            {
              paramContext = localFile2.getName();
              paramContext = String.format("arkso.delete.%s.fail!!", new Object[] { paramContext });
              paramString = localFile1;
              continue;
            }
            paramContext = localFile1.getName();
            continue;
          }
          if (SoLoadUtil.a(paramContext, str, "txlib", a(paramString)) != 0)
          {
            localFile2.delete();
            paramContext = "arkso.extract.fail!!";
            paramString = localFile1;
            continue;
          }
          if (!localFile2.exists())
          {
            paramContext = "arkso.file.not.exist!!";
            paramString = localFile1;
            continue;
          }
          if ((m != -1) && (m != localFile2.length()))
          {
            localFile2.delete();
            paramContext = "arkso.size.mismatch!!";
            paramString = localFile1;
            continue;
          }
          if ((l2 != -1L) && (l2 != IOUtil.getCRC32Value(localFile2)))
          {
            localFile2.delete();
            paramContext = "arkso.crc32.mismatch!!";
            paramString = localFile1;
            continue;
          }
          localFile2.renameTo(localFile1);
          paramBoolean = true;
          paramString = localFile1;
          paramContext = localObject;
          continue;
          if (paramContext == null) {
            continue;
          }
          QLog.d("ArkEngineExtract", 2, paramContext);
          continue;
        }
        i = 1;
      }
      finally {}
      label564:
      continue;
      label569:
      if ((i == 0) && (j == 0))
      {
        paramBoolean = true;
        paramString = localFile1;
        paramContext = localObject;
        continue;
        label589:
        j = 0;
        continue;
        label595:
        k = 0;
      }
    }
  }
  
  private static int b(String paramString)
  {
    if (paramString.equals("ark-armeabi-v7a")) {
      return ark.arkGetARMv7LibSize();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibSize();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibSize();
    }
    return -1;
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_1
    //   5: invokestatic 198	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)I
    //   8: invokestatic 227	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   11: astore 10
    //   13: new 72	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokestatic 154	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload 10
    //   29: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 11
    //   37: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +30 -> 70
    //   43: ldc 62
    //   45: iconst_2
    //   46: new 72	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 263
    //   56: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 10
    //   61: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_1
    //   71: invokestatic 159	com/tencent/mobileqq/startup/step/UpdateArkSo:b	(Ljava/lang/String;)I
    //   74: istore_2
    //   75: aload_1
    //   76: invokestatic 161	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)J
    //   79: lstore_3
    //   80: new 75	java/io/File
    //   83: dup
    //   84: aload 11
    //   86: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 12
    //   91: aload 12
    //   93: invokevirtual 164	java/io/File:exists	()Z
    //   96: ifeq +209 -> 305
    //   99: aload 12
    //   101: invokevirtual 167	java/io/File:length	()J
    //   104: lstore 5
    //   106: aload 12
    //   108: invokestatic 173	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   111: lstore 7
    //   113: iload_2
    //   114: iconst_m1
    //   115: if_icmpeq +11 -> 126
    //   118: iload_2
    //   119: i2l
    //   120: lload 5
    //   122: lcmp
    //   123: ifne +239 -> 362
    //   126: lload_3
    //   127: ldc2_w 46
    //   130: lcmp
    //   131: ifeq +10 -> 141
    //   134: lload_3
    //   135: lload 7
    //   137: lcmp
    //   138: ifne +224 -> 362
    //   141: aload 11
    //   143: invokestatic 178	java/lang/System:load	(Ljava/lang/String;)V
    //   146: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +57 -> 206
    //   152: ldc 62
    //   154: iconst_2
    //   155: getstatic 104	java/util/Locale:CHINA	Ljava/util/Locale;
    //   158: ldc_w 265
    //   161: iconst_5
    //   162: anewarray 93	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: iload_2
    //   168: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: lload 5
    //   176: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: dup
    //   181: iconst_2
    //   182: lload_3
    //   183: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_3
    //   189: lload 7
    //   191: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: dup
    //   196: iconst_4
    //   197: aload 11
    //   199: aastore
    //   200: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iconst_1
    //   207: istore 9
    //   209: ldc 2
    //   211: monitorexit
    //   212: iload 9
    //   214: ireturn
    //   215: astore_0
    //   216: new 72	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 267
    //   226: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 10
    //   231: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore_0
    //   238: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +10 -> 251
    //   244: ldc 62
    //   246: iconst_2
    //   247: aload_0
    //   248: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   255: iconst_0
    //   256: istore 9
    //   258: goto -49 -> 209
    //   261: astore 12
    //   263: new 72	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 269
    //   273: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 10
    //   278: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 12
    //   286: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +11 -> 300
    //   292: ldc 62
    //   294: iconst_2
    //   295: aload 12
    //   297: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 12
    //   302: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   305: aload_0
    //   306: aload_1
    //   307: iconst_1
    //   308: invokestatic 271	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   311: ifeq +120 -> 431
    //   314: aload 11
    //   316: invokestatic 178	java/lang/System:load	(Ljava/lang/String;)V
    //   319: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +34 -> 356
    //   325: ldc 62
    //   327: iconst_2
    //   328: getstatic 104	java/util/Locale:CHINA	Ljava/util/Locale;
    //   331: ldc_w 273
    //   334: iconst_2
    //   335: anewarray 93	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: iload_2
    //   341: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: aload 11
    //   349: aastore
    //   350: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   353: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: iconst_1
    //   357: istore 9
    //   359: goto -150 -> 209
    //   362: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -60 -> 305
    //   368: ldc 62
    //   370: iconst_2
    //   371: getstatic 104	java/util/Locale:CHINA	Ljava/util/Locale;
    //   374: ldc_w 275
    //   377: iconst_5
    //   378: anewarray 93	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: iload_2
    //   384: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: lload 5
    //   392: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   395: aastore
    //   396: dup
    //   397: iconst_2
    //   398: lload_3
    //   399: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   402: aastore
    //   403: dup
    //   404: iconst_3
    //   405: lload 7
    //   407: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: aastore
    //   411: dup
    //   412: iconst_4
    //   413: aload 11
    //   415: aastore
    //   416: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   419: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: goto -117 -> 305
    //   425: astore_0
    //   426: ldc 2
    //   428: monitorexit
    //   429: aload_0
    //   430: athrow
    //   431: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +12 -> 446
    //   437: ldc 62
    //   439: iconst_2
    //   440: ldc_w 277
    //   443: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: ldc_w 277
    //   449: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   452: iconst_0
    //   453: istore 9
    //   455: goto -246 -> 209
    //   458: astore_0
    //   459: new 72	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 279
    //   469: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 10
    //   474: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: astore_0
    //   481: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +10 -> 494
    //   487: ldc 62
    //   489: iconst_2
    //   490: aload_0
    //   491: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload_0
    //   495: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   498: goto -46 -> 452
    //   501: astore_0
    //   502: new 72	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 281
    //   512: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 10
    //   517: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: astore_0
    //   524: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +10 -> 537
    //   530: ldc 62
    //   532: iconst_2
    //   533: aload_0
    //   534: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: aload_0
    //   538: invokestatic 184	com/tencent/mobileqq/ark/ArkAppDataReport:a	(Ljava/lang/String;)V
    //   541: goto -89 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramContext	Context
    //   0	544	1	paramString	String
    //   74	310	2	i	int
    //   79	320	3	l1	long
    //   104	287	5	l2	long
    //   111	295	7	l3	long
    //   207	247	9	bool	boolean
    //   11	505	10	str1	String
    //   35	379	11	str2	String
    //   89	18	12	localFile	File
    //   261	1	12	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   284	17	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   141	206	215	java/lang/SecurityException
    //   141	206	261	java/lang/UnsatisfiedLinkError
    //   3	70	425	finally
    //   70	113	425	finally
    //   141	206	425	finally
    //   216	251	425	finally
    //   251	255	425	finally
    //   263	300	425	finally
    //   300	305	425	finally
    //   305	356	425	finally
    //   362	422	425	finally
    //   431	446	425	finally
    //   446	452	425	finally
    //   459	494	425	finally
    //   494	498	425	finally
    //   502	537	425	finally
    //   537	541	425	finally
    //   305	356	458	java/lang/SecurityException
    //   431	446	458	java/lang/SecurityException
    //   446	452	458	java/lang/SecurityException
    //   305	356	501	java/lang/UnsatisfiedLinkError
    //   431	446	501	java/lang/UnsatisfiedLinkError
    //   446	452	501	java/lang/UnsatisfiedLinkError
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject;
      File localFile1;
      int i;
      label214:
      int j;
      try
      {
        long l1 = SystemClock.uptimeMillis();
        bool = false;
        localObject = null;
        localFile1 = null;
        String str = a(paramContext);
        long l2;
        if (TextUtils.isEmpty(str))
        {
          paramContext = "arkso.old.getTxlibPath.return.null";
          paramString = localFile1;
          l2 = SystemClock.uptimeMillis();
          if (QLog.isColorLevel())
          {
            if (bool) {
              QLog.d("ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
            }
          }
          else
          {
            if (paramContext != null) {
              ArkAppDataReport.a(paramContext);
            }
            return bool;
          }
        }
        else
        {
          File localFile2 = new File(str);
          if ((!localFile2.exists()) && (!localFile2.mkdir()))
          {
            paramContext = "arkso.old.mkdir.fail";
            paramString = localFile1;
            continue;
          }
          int k = b(paramString);
          l2 = a(paramString);
          localFile1 = new File(str + a(paramString));
          if (localFile1.exists())
          {
            if ((k == -1) || (k == localFile1.length())) {
              break label435;
            }
            i = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label440;
            }
            j = 1;
            break label417;
          }
          localFile1.delete();
          if (localFile1.exists())
          {
            paramContext = String.format("arkso.old.delete.%s.fail!!", new Object[] { localFile1.getName() });
            paramString = localFile1;
            continue;
          }
          if (SoLoadUtil.a(paramContext, str, "txlib", a(paramString)) != 0)
          {
            localFile1.delete();
            paramContext = "arkso.old.extract.fail!!";
            paramString = localFile1;
            continue;
          }
          if (!localFile1.exists())
          {
            paramContext = "arkso.old.file.not.exist!!";
            paramString = localFile1;
            continue;
          }
          if ((k != -1) && (k != localFile1.length()))
          {
            localFile1.delete();
            paramContext = "arkso.old.size.mismatch!!";
            paramString = localFile1;
            continue;
          }
          if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
            break label445;
          }
          localFile1.delete();
          paramContext = "arkso.old.crc32.mismatch!!";
          paramString = localFile1;
          continue;
        }
        if (paramContext == null) {
          continue;
        }
        QLog.d("ArkEngineExtract", 2, paramContext);
        continue;
        if ((j | i) != 0) {
          continue;
        }
      }
      finally {}
      for (;;)
      {
        label417:
        bool = true;
        paramString = localFile1;
        paramContext = localObject;
        break;
        label435:
        i = 0;
        break label214;
        label440:
        j = 0;
      }
      label445:
      boolean bool = true;
      paramString = localFile1;
      paramContext = localObject;
    }
  }
  
  protected boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    c(localBaseApplicationImpl, "png-armeabi-v7a");
    a(localBaseApplicationImpl, "ark-armeabi-v7a", false);
    a(localBaseApplicationImpl, "WordSegment", false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateArkSo
 * JD-Core Version:    0.7.0.1
 */