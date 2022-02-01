package dov.com.qq.im.ae.download.old;

import android.os.Build;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AEOldQuicResProcess
{
  private static final ReentrantLock a = new ReentrantLock();
  
  public static int a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    if (paramSVConfigItem.versionCode >= 3) {}
    for (int i = 0;; i = -1)
    {
      VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[checkResourceLowLimitVersion]limitVer=3 downVer=" + paramSVConfigItem.versionCode + " errCode=" + i, null);
      return i;
    }
  }
  
  private static void a()
  {
    File localFile = new File(AEOldQuicResDownload.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(AEOldQuicResDownload.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if ((localObject.isFile()) && (localObject.exists()))
        {
          String str = localObject.getName();
          boolean bool = localObject.delete();
          VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[cleanDirector] delete filename=" + str + " ret=" + bool, null);
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    int i = 1;
    boolean bool1 = false;
    int j = AEOldQuicResDownload.a();
    String str1 = AEOldQuicResDownload.c();
    String str2 = Build.CPU_ABI;
    if ((str2 != null) && (str2.contains("armeabi-v7a"))) {
      if (j < paramSVConfigItem.versionCode) {}
    }
    for (;;)
    {
      try
      {
        if (!a.tryLock(3000L, TimeUnit.MILLISECONDS)) {
          continue;
        }
        boolean bool2 = a(paramAppInterface, str1, paramSVConfigItem.versionCode);
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[userCheckNeedDownload][checkUncompressedResourceIsOK]Before Uncompresses checkOK=" + bool2, null);
        if (!bool2) {
          continue;
        }
      }
      catch (Exception paramAppInterface)
      {
        i = 4;
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "userCheckNeedDownload " + paramAppInterface.getMessage(), paramAppInterface);
        continue;
      }
      VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "userCheckNeedDownload arm_url=" + paramSVConfigItem.arm_url + " " + paramSVConfigItem.armv7a_url + " reason=" + i + " needDownload=" + bool1, null);
      return bool1;
      bool1 = true;
      i = 2;
      continue;
      i = 3;
      continue;
      bool1 = true;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  /* Error */
  private static boolean a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 52	java/io/File
    //   3: dup
    //   4: new 28	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   11: aload_1
    //   12: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 150
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 63	java/io/File:exists	()Z
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: new 152	java/util/Properties
    //   39: dup
    //   40: invokespecial 153	java/util/Properties:<init>	()V
    //   43: astore 7
    //   45: new 155	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore 6
    //   55: aload 6
    //   57: astore_0
    //   58: aload 7
    //   60: aload 6
    //   62: invokevirtual 162	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload 6
    //   67: invokevirtual 165	java/io/FileInputStream:close	()V
    //   70: aload 7
    //   72: ldc 167
    //   74: invokevirtual 171	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: checkcast 108	java/lang/String
    //   80: invokestatic 177	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   83: istore_3
    //   84: aload 7
    //   86: ldc 179
    //   88: invokevirtual 171	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 108	java/lang/String
    //   94: invokestatic 177	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore 4
    //   99: new 28	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 179
    //   112: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: aload 7
    //   121: ldc 181
    //   123: invokevirtual 171	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 108	java/lang/String
    //   129: invokestatic 177	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   132: istore 5
    //   134: new 28	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 181
    //   147: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_1
    //   154: iload_3
    //   155: iload_2
    //   156: if_icmpge +72 -> 228
    //   159: ldc 26
    //   161: new 28	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   168: ldc 183
    //   170: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_3
    //   174: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: ldc 192
    //   182: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_2
    //   186: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aconst_null
    //   193: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore 7
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: astore_0
    //   204: ldc 26
    //   206: ldc 194
    //   208: aload 7
    //   210: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: invokevirtual 165	java/io/FileInputStream:close	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 165	java/io/FileInputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: iload 4
    //   230: ifle +82 -> 312
    //   233: new 52	java/io/File
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 63	java/io/File:exists	()Z
    //   246: ifeq +14 -> 260
    //   249: aload_0
    //   250: invokevirtual 198	java/io/File:length	()J
    //   253: iload 4
    //   255: i2l
    //   256: lcmp
    //   257: ifeq +55 -> 312
    //   260: ldc 26
    //   262: new 28	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   269: ldc 200
    //   271: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload 4
    //   276: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc 202
    //   281: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: invokevirtual 198	java/io/File:length	()J
    //   288: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: ldc 207
    //   293: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aconst_null
    //   307: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: iconst_0
    //   311: ireturn
    //   312: iload 5
    //   314: ifle +113 -> 427
    //   317: new 52	java/io/File
    //   320: dup
    //   321: aload_1
    //   322: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore_0
    //   326: aload_0
    //   327: invokevirtual 63	java/io/File:exists	()Z
    //   330: ifeq +14 -> 344
    //   333: aload_0
    //   334: invokevirtual 198	java/io/File:length	()J
    //   337: iload 5
    //   339: i2l
    //   340: lcmp
    //   341: ifeq +86 -> 427
    //   344: ldc 26
    //   346: new 28	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   353: ldc 200
    //   355: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 5
    //   360: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: ldc 202
    //   365: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_0
    //   369: invokevirtual 198	java/io/File:length	()J
    //   372: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: ldc 207
    //   377: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: invokevirtual 210	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   384: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: aconst_null
    //   391: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   394: iconst_0
    //   395: ireturn
    //   396: astore_0
    //   397: ldc 26
    //   399: new 28	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   406: ldc 212
    //   408: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload_0
    //   422: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   425: iconst_0
    //   426: ireturn
    //   427: iconst_1
    //   428: ireturn
    //   429: astore_0
    //   430: goto -360 -> 70
    //   433: astore_0
    //   434: goto -217 -> 217
    //   437: astore_0
    //   438: goto -212 -> 226
    //   441: astore_1
    //   442: goto -220 -> 222
    //   445: astore 7
    //   447: aload 6
    //   449: astore_1
    //   450: goto -248 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramAppInterface	AppInterface
    //   0	453	1	paramString	String
    //   0	453	2	paramInt	int
    //   83	91	3	i	int
    //   97	178	4	j	int
    //   132	227	5	k	int
    //   53	395	6	localFileInputStream	java.io.FileInputStream
    //   43	77	7	localProperties	java.util.Properties
    //   198	11	7	localException1	Exception
    //   445	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   45	55	198	java/lang/Exception
    //   45	55	219	finally
    //   70	154	396	java/lang/Exception
    //   159	196	396	java/lang/Exception
    //   233	260	396	java/lang/Exception
    //   260	310	396	java/lang/Exception
    //   317	344	396	java/lang/Exception
    //   344	394	396	java/lang/Exception
    //   65	70	429	java/lang/Exception
    //   213	217	433	java/lang/Exception
    //   222	226	437	java/lang/Exception
    //   58	65	441	finally
    //   204	213	441	finally
    //   58	65	445	java/lang/Exception
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    int i = AEOldQuicResDownload.a();
    VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "isFilterSoExist confVer=" + i, null);
    return i >= 3;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    int i = AEOldQuicResDownload.a();
    String str = AEOldQuicResDownload.c();
    paramString1 = "";
    if (str.equals(AEOldQuicResDownload.a())) {
      paramString1 = AEOldQuicResDownload.b();
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[uncompressResource]loadDir=" + str + " destDir=" + paramString1 + " confVer=" + i + " zipVer=" + paramInt, null);
      if (paramInt > i) {
        break;
      }
      return false;
      if (str.equals(AEOldQuicResDownload.b())) {
        paramString1 = AEOldQuicResDownload.a();
      }
    }
    if (a.tryLock()) {}
    for (;;)
    {
      try
      {
        a();
        bool = a(paramQQAppInterface, paramString1, paramInt);
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[uncompressResource][checkUncompressedResourceIsOK]Before Uncompresses checkOK=" + bool, null);
        if (bool) {
          return false;
        }
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[uncompressResource]clean director=" + paramString1, null);
        a(paramString1);
        FileUtils.a(paramString2, paramString1, false);
        bool = a(paramQQAppInterface, paramString1, paramInt);
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "[uncompressResource][checkUncompressedResourceIsOK]After Uncompresses checkOK=" + bool, null);
        if (!bool) {
          continue;
        }
        AEOldQuicResDownload.a(paramString1, paramInt);
        a(str);
        a.unlock();
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", "exp=", paramQQAppInterface);
        bool = true;
        a.unlock();
        continue;
      }
      finally
      {
        a.unlock();
      }
      return bool;
      a(paramString1);
      continue;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldQuicResProcess
 * JD-Core Version:    0.7.0.1
 */