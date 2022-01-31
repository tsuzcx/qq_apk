package com.tencent.mobileqq.startup.step;

import altd;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public class UpdateArkSo
  extends Step
{
  private static final String a;
  
  static
  {
    if (AppSetting.b) {}
    for (String str = "png-arm64-v8a";; str = "png-armeabi-v7a")
    {
      a = str;
      return;
    }
  }
  
  private static int a(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetPlatformBuildNumber();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getPlatformBuildNumber();
    }
    return 0;
  }
  
  private static long a(String paramString)
  {
    long l2 = -1L;
    long l1;
    if (AppSetting.b) {
      if (paramString.equals("ark")) {
        l1 = ark.getArkSOArm64CRC();
      }
    }
    do
    {
      do
      {
        do
        {
          return l1;
          l1 = l2;
        } while (paramString.equals("WordSegment"));
        l1 = l2;
      } while (!paramString.equals(a));
      return ark.getPngArm64CRC();
      if (paramString.equals("ark")) {
        return ark.arkGetARMv7LibCRC32();
      }
      if (paramString.equals("WordSegment")) {
        return WordSegment.getARMv7LibCRC32();
      }
      l1 = l2;
    } while (!paramString.equals(a));
    return ark.arkGetPngARMv7LibCRC32();
  }
  
  public static String a()
  {
    return a;
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.ArkEngineExtract", 2, "getFilesDir is null");
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
    String str2 = String.format(Locale.CHINA, "%07x.so", new Object[] { Integer.valueOf(paramInt) });
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() > 6) {
        str1 = str2.substring(0, 6);
      }
    }
    return String.format(Locale.CHINA, "lib%s-%s.so", new Object[] { paramString, str1 });
  }
  
  private static void a(String paramString1, String paramString2)
  {
    paramString2 = String.format("lib%s", new Object[] { paramString2 });
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkEngineExtract", 2, "path.listFiles return null!!");
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
            QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "remove previous so: ", str });
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
    //   3: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 81
    //   11: iconst_2
    //   12: new 91	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   19: ldc 185
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 91	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   41: aload_0
    //   42: invokestatic 187	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   45: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokestatic 189	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 7
    //   60: aload_1
    //   61: invokestatic 191	com/tencent/mobileqq/startup/step/UpdateArkSo:b	(Ljava/lang/String;)I
    //   64: istore_2
    //   65: aload_1
    //   66: invokestatic 193	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)J
    //   69: lstore_3
    //   70: new 94	java/io/File
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: aload 8
    //   83: invokevirtual 196	java/io/File:exists	()Z
    //   86: ifeq +94 -> 180
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +14 -> 105
    //   94: iload_2
    //   95: i2l
    //   96: aload 8
    //   98: invokevirtual 198	java/io/File:length	()J
    //   101: lcmp
    //   102: ifne +78 -> 180
    //   105: lload_3
    //   106: ldc2_w 48
    //   109: lcmp
    //   110: ifeq +17 -> 127
    //   113: aload 8
    //   115: invokestatic 204	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   118: lstore 5
    //   120: lload_3
    //   121: lload 5
    //   123: lcmp
    //   124: ifne +56 -> 180
    //   127: ldc 206
    //   129: invokestatic 211	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   132: aload 7
    //   134: invokestatic 214	java/lang/System:load	(Ljava/lang/String;)V
    //   137: ldc 2
    //   139: monitorexit
    //   140: iconst_1
    //   141: ireturn
    //   142: astore 9
    //   144: new 91	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   151: ldc 216
    //   153: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 10
    //   165: ldc 81
    //   167: iconst_1
    //   168: aload 10
    //   170: aload 9
    //   172: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload 10
    //   177: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   180: aload 8
    //   182: invokevirtual 173	java/io/File:delete	()Z
    //   185: pop
    //   186: aload_0
    //   187: aload_1
    //   188: invokestatic 226	com/tencent/mobileqq/startup/step/UpdateArkSo:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   191: ifeq +99 -> 290
    //   194: ldc 206
    //   196: invokestatic 211	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   199: aload 7
    //   201: invokestatic 214	java/lang/System:load	(Ljava/lang/String;)V
    //   204: goto -67 -> 137
    //   207: astore_0
    //   208: new 91	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   215: ldc 228
    //   217: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore_1
    //   228: ldc 81
    //   230: iconst_1
    //   231: aload_1
    //   232: aload_0
    //   233: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   240: goto -103 -> 137
    //   243: astore_0
    //   244: ldc 2
    //   246: monitorexit
    //   247: aload_0
    //   248: athrow
    //   249: astore 9
    //   251: new 91	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   258: ldc 230
    //   260: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore 10
    //   272: ldc 81
    //   274: iconst_1
    //   275: aload 10
    //   277: aload 9
    //   279: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 10
    //   284: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   287: goto -107 -> 180
    //   290: new 91	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   297: ldc 232
    //   299: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore_0
    //   310: ldc 81
    //   312: iconst_1
    //   313: aload_0
    //   314: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_0
    //   318: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   321: goto -184 -> 137
    //   324: astore_0
    //   325: new 91	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   332: ldc 234
    //   334: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore_1
    //   345: ldc 81
    //   347: iconst_1
    //   348: aload_1
    //   349: aload_0
    //   350: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   357: goto -220 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   0	360	1	paramString	String
    //   64	31	2	i	int
    //   69	52	3	l1	long
    //   118	4	5	l2	long
    //   58	142	7	str1	String
    //   79	102	8	localFile	File
    //   142	29	9	localSecurityException	java.lang.SecurityException
    //   249	29	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   163	120	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   127	137	142	java/lang/SecurityException
    //   186	204	207	java/lang/SecurityException
    //   290	321	207	java/lang/SecurityException
    //   3	34	243	finally
    //   34	89	243	finally
    //   94	105	243	finally
    //   113	120	243	finally
    //   127	137	243	finally
    //   144	180	243	finally
    //   180	186	243	finally
    //   186	204	243	finally
    //   208	240	243	finally
    //   251	287	243	finally
    //   290	321	243	finally
    //   325	357	243	finally
    //   127	137	249	java/lang/UnsatisfiedLinkError
    //   186	204	324	java/lang/UnsatisfiedLinkError
    //   290	321	324	java/lang/UnsatisfiedLinkError
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
            break label580;
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
                QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
              }
              if (paramContext != null) {
                altd.a(paramContext);
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
              break label605;
            }
            j = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label611;
            }
            k = 1;
            j = k | j;
            if ((j == 0) || (!QLog.isColorLevel())) {
              break label585;
            }
            QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "arkso.corrupt.", localFile1.getName() });
            break label585;
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
          long l3 = localFile2.length();
          if ((m != -1) && (m != l3))
          {
            localFile2.delete();
            paramContext = "arkso.size.mismatch!!";
            paramString = localFile1;
            continue;
          }
          l3 = IOUtil.getCRC32Value(localFile2);
          if ((l2 != -1L) && (l2 != l3))
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
          QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
          continue;
        }
        i = 1;
      }
      finally {}
      label580:
      continue;
      label585:
      if ((i == 0) && (j == 0))
      {
        paramBoolean = true;
        paramString = localFile1;
        paramContext = localObject;
        continue;
        label605:
        j = 0;
        continue;
        label611:
        k = 0;
      }
    }
  }
  
  private static int b(String paramString)
  {
    int j = -1;
    int i;
    if (AppSetting.b) {
      if (paramString.equals("ark")) {
        i = ark.getArkSOArm64Size();
      }
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramString.equals("WordSegment"));
        i = j;
      } while (!paramString.equals(a));
      return ark.getPngArm64Size();
      if (paramString.equals("ark")) {
        return ark.arkGetARMv7LibSize();
      }
      if (paramString.equals("WordSegment")) {
        return WordSegment.getARMv7LibSize();
      }
      i = j;
    } while (!paramString.equals(a));
    return ark.arkGetPngARMv7LibSize();
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_1
    //   5: invokestatic 237	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)I
    //   8: invokestatic 260	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   11: astore 10
    //   13: new 91	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokestatic 187	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   24: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload 10
    //   29: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 11
    //   37: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +30 -> 70
    //   43: ldc 81
    //   45: iconst_2
    //   46: new 91	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 302
    //   56: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 10
    //   61: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_1
    //   71: invokestatic 191	com/tencent/mobileqq/startup/step/UpdateArkSo:b	(Ljava/lang/String;)I
    //   74: istore_2
    //   75: aload_1
    //   76: invokestatic 193	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Ljava/lang/String;)J
    //   79: lstore_3
    //   80: new 94	java/io/File
    //   83: dup
    //   84: aload 11
    //   86: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 12
    //   91: aload 12
    //   93: invokevirtual 196	java/io/File:exists	()Z
    //   96: ifeq +205 -> 301
    //   99: aload 12
    //   101: invokevirtual 198	java/io/File:length	()J
    //   104: lstore 5
    //   106: aload 12
    //   108: invokestatic 204	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   111: lstore 7
    //   113: iload_2
    //   114: iconst_m1
    //   115: if_icmpeq +11 -> 126
    //   118: iload_2
    //   119: i2l
    //   120: lload 5
    //   122: lcmp
    //   123: ifne +240 -> 363
    //   126: lload_3
    //   127: ldc2_w 48
    //   130: lcmp
    //   131: ifeq +10 -> 141
    //   134: lload_3
    //   135: lload 7
    //   137: lcmp
    //   138: ifne +225 -> 363
    //   141: ldc 206
    //   143: invokestatic 211	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   146: aload 11
    //   148: invokestatic 214	java/lang/System:load	(Ljava/lang/String;)V
    //   151: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +57 -> 211
    //   157: ldc 81
    //   159: iconst_2
    //   160: getstatic 122	java/util/Locale:CHINA	Ljava/util/Locale;
    //   163: ldc_w 304
    //   166: iconst_5
    //   167: anewarray 111	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: iload_2
    //   173: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: lload 5
    //   181: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: lload_3
    //   188: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: lload 7
    //   196: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   199: aastore
    //   200: dup
    //   201: iconst_4
    //   202: aload 11
    //   204: aastore
    //   205: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iconst_1
    //   212: istore 9
    //   214: ldc 2
    //   216: monitorexit
    //   217: iload 9
    //   219: ireturn
    //   220: astore_0
    //   221: new 91	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 306
    //   231: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 10
    //   236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_1
    //   243: ldc 81
    //   245: iconst_1
    //   246: aload_1
    //   247: aload_0
    //   248: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   255: iconst_0
    //   256: istore 9
    //   258: goto -44 -> 214
    //   261: astore 12
    //   263: new 91	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 308
    //   273: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 10
    //   278: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 13
    //   286: ldc 81
    //   288: iconst_1
    //   289: aload 13
    //   291: aload 12
    //   293: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload 13
    //   298: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   301: aload_0
    //   302: aload_1
    //   303: iconst_1
    //   304: invokestatic 310	com/tencent/mobileqq/startup/step/UpdateArkSo:a	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   307: ifeq +125 -> 432
    //   310: ldc 206
    //   312: invokestatic 211	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   315: aload 11
    //   317: invokestatic 214	java/lang/System:load	(Ljava/lang/String;)V
    //   320: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +34 -> 357
    //   326: ldc 81
    //   328: iconst_2
    //   329: getstatic 122	java/util/Locale:CHINA	Ljava/util/Locale;
    //   332: ldc_w 312
    //   335: iconst_2
    //   336: anewarray 111	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: iload_2
    //   342: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload 11
    //   350: aastore
    //   351: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   354: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: iconst_1
    //   358: istore 9
    //   360: goto -146 -> 214
    //   363: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -65 -> 301
    //   369: ldc 81
    //   371: iconst_2
    //   372: getstatic 122	java/util/Locale:CHINA	Ljava/util/Locale;
    //   375: ldc_w 314
    //   378: iconst_5
    //   379: anewarray 111	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: iload_2
    //   385: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: lload 5
    //   393: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   396: aastore
    //   397: dup
    //   398: iconst_2
    //   399: lload_3
    //   400: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aastore
    //   404: dup
    //   405: iconst_3
    //   406: lload 7
    //   408: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: dup
    //   413: iconst_4
    //   414: aload 11
    //   416: aastore
    //   417: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   420: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -122 -> 301
    //   426: astore_0
    //   427: ldc 2
    //   429: monitorexit
    //   430: aload_0
    //   431: athrow
    //   432: ldc 81
    //   434: iconst_1
    //   435: ldc_w 316
    //   438: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: ldc_w 316
    //   444: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   447: iconst_0
    //   448: istore 9
    //   450: goto -236 -> 214
    //   453: astore_0
    //   454: new 91	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 318
    //   464: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 10
    //   469: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: astore_1
    //   476: ldc 81
    //   478: iconst_1
    //   479: aload_1
    //   480: aload_0
    //   481: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   484: aload_1
    //   485: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   488: goto -41 -> 447
    //   491: astore_0
    //   492: new 91	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 320
    //   502: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 10
    //   507: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: astore_1
    //   514: ldc 81
    //   516: iconst_1
    //   517: aload_1
    //   518: aload_0
    //   519: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   522: aload_1
    //   523: invokestatic 223	altd:a	(Ljava/lang/String;)V
    //   526: goto -79 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramContext	Context
    //   0	529	1	paramString	String
    //   74	311	2	i	int
    //   79	321	3	l1	long
    //   104	288	5	l2	long
    //   111	296	7	l3	long
    //   212	237	9	bool	boolean
    //   11	495	10	str1	String
    //   35	380	11	str2	String
    //   89	18	12	localFile	File
    //   261	31	12	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   284	13	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   141	211	220	java/lang/SecurityException
    //   141	211	261	java/lang/UnsatisfiedLinkError
    //   3	70	426	finally
    //   70	113	426	finally
    //   141	211	426	finally
    //   221	255	426	finally
    //   263	301	426	finally
    //   301	357	426	finally
    //   363	423	426	finally
    //   432	447	426	finally
    //   454	488	426	finally
    //   492	526	426	finally
    //   301	357	453	java/lang/SecurityException
    //   432	447	453	java/lang/SecurityException
    //   301	357	491	java/lang/UnsatisfiedLinkError
    //   432	447	491	java/lang/UnsatisfiedLinkError
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
              QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
            }
          }
          else
          {
            if (paramContext != null) {
              altd.a(paramContext);
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
              break label436;
            }
            i = 1;
            if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value(localFile1))) {
              break label441;
            }
            j = 1;
            break label418;
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
            break label446;
          }
          localFile1.delete();
          paramContext = "arkso.old.crc32.mismatch!!";
          paramString = localFile1;
          continue;
        }
        if (paramContext == null) {
          continue;
        }
        QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
        continue;
        if ((j | i) != 0) {
          continue;
        }
      }
      finally {}
      for (;;)
      {
        label418:
        bool = true;
        paramString = localFile1;
        paramContext = localObject;
        break;
        label436:
        i = 0;
        break label214;
        label441:
        j = 0;
      }
      label446:
      boolean bool = true;
      paramString = localFile1;
      paramContext = localObject;
    }
  }
  
  protected boolean doStep()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    c(localBaseApplicationImpl, a);
    a(localBaseApplicationImpl, "ark", false);
    a(localBaseApplicationImpl, "WordSegment", false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateArkSo
 * JD-Core Version:    0.7.0.1
 */