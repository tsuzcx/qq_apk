package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static boolean b = false;
  private static TVK_SDKMgr.OnLogListener c = null;
  
  public static String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i]);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte[8192];
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
      paramFile = a(localMessageDigest.digest());
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    paramString3 = c;
    if (paramString3 != null)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              paramString3.e(paramString2, paramString1);
              return;
            }
            paramString3.w(paramString2, paramString1);
            return;
          }
          paramString3.i(paramString2, paramString1);
          return;
        }
        paramString3.d(paramString2, paramString1);
        return;
      }
      paramString3.v(paramString2, paramString1);
      return;
    }
    if (b)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              Log.e(paramString2, paramString1);
              return;
            }
            Log.w(paramString2, paramString1);
            return;
          }
          Log.i(paramString2, paramString1);
          return;
        }
        Log.d(paramString2, paramString1);
        return;
      }
      Log.v(paramString2, paramString1);
    }
  }
  
  public static void a(TVK_SDKMgr.OnLogListener paramOnLogListener)
  {
    c = paramOnLogListener;
  }
  
  public static void a(File paramFile, int paramInt)
  {
    a(paramFile, paramInt, false);
  }
  
  public static void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printDir,  dirFile:");
        localStringBuilder.append(paramFile.getAbsolutePath());
        a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", localStringBuilder.toString());
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          paramFile = arrayOfFile[i];
          if (paramFile != null) {
            if (paramBoolean)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("printDir, file.name :");
              localStringBuilder.append(paramFile.getName());
              localStringBuilder.append(" , file.size :");
              localStringBuilder.append(paramFile.length());
              localStringBuilder.append(", md5:");
              localStringBuilder.append(a(paramFile));
              a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", localStringBuilder.toString());
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("printDir, file.name :");
              localStringBuilder.append(paramFile.getName());
              localStringBuilder.append(" , file.size :");
              localStringBuilder.append(paramFile.length());
              a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", localStringBuilder.toString());
            }
          }
          i += 1;
        }
        return;
      }
      a(5, "UpdateUtils.java", "MediaPlayerMgr", "printDir, childFiles is null or length 0 ");
      return;
    }
    a(5, "UpdateUtils.java", "MediaPlayerMgr", "printDir, dirFile is null");
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 186	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 189	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aload 8
    //   12: invokevirtual 193	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore 9
    //   17: aconst_null
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_0
    //   22: astore 4
    //   24: aload_3
    //   25: astore 5
    //   27: aload_0
    //   28: astore 6
    //   30: aload 9
    //   32: invokeinterface 198 1 0
    //   37: ifeq +429 -> 466
    //   40: aload_0
    //   41: astore 4
    //   43: aload_3
    //   44: astore 5
    //   46: aload_0
    //   47: astore 6
    //   49: aload 9
    //   51: invokeinterface 202 1 0
    //   56: checkcast 204	java/util/zip/ZipEntry
    //   59: astore 7
    //   61: aload_0
    //   62: astore 4
    //   64: aload_3
    //   65: astore 5
    //   67: aload_0
    //   68: astore 6
    //   70: aload 8
    //   72: aload 7
    //   74: invokevirtual 208	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   77: astore_0
    //   78: aload_0
    //   79: astore 4
    //   81: aload_3
    //   82: astore 5
    //   84: aload_0
    //   85: astore 6
    //   87: aload 7
    //   89: invokevirtual 209	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   92: astore 10
    //   94: aload_0
    //   95: astore 4
    //   97: aload_3
    //   98: astore 5
    //   100: aload_0
    //   101: astore 6
    //   103: aload 10
    //   105: ldc 211
    //   107: invokevirtual 217	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +6 -> 116
    //   113: goto -92 -> 21
    //   116: aload_0
    //   117: astore 4
    //   119: aload_3
    //   120: astore 5
    //   122: aload_0
    //   123: astore 6
    //   125: aload 7
    //   127: invokevirtual 218	java/util/zip/ZipEntry:isDirectory	()Z
    //   130: ifeq +124 -> 254
    //   133: aload_0
    //   134: astore 4
    //   136: aload_3
    //   137: astore 5
    //   139: aload_0
    //   140: astore 6
    //   142: aload 10
    //   144: iconst_0
    //   145: aload 10
    //   147: invokevirtual 221	java/lang/String:length	()I
    //   150: iconst_1
    //   151: isub
    //   152: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
    //   155: astore 7
    //   157: aload_0
    //   158: astore 4
    //   160: aload_3
    //   161: astore 5
    //   163: aload_0
    //   164: astore 6
    //   166: new 48	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   173: astore 10
    //   175: aload_0
    //   176: astore 4
    //   178: aload_3
    //   179: astore 5
    //   181: aload_0
    //   182: astore 6
    //   184: aload 10
    //   186: aload_1
    //   187: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_0
    //   192: astore 4
    //   194: aload_3
    //   195: astore 5
    //   197: aload_0
    //   198: astore 6
    //   200: aload 10
    //   202: getstatic 229	java/io/File:separator	Ljava/lang/String;
    //   205: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_0
    //   210: astore 4
    //   212: aload_3
    //   213: astore 5
    //   215: aload_0
    //   216: astore 6
    //   218: aload 10
    //   220: aload 7
    //   222: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_0
    //   227: astore 4
    //   229: aload_3
    //   230: astore 5
    //   232: aload_0
    //   233: astore 6
    //   235: new 142	java/io/File
    //   238: dup
    //   239: aload 10
    //   241: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: invokevirtual 233	java/io/File:mkdirs	()Z
    //   250: pop
    //   251: goto -230 -> 21
    //   254: aload_0
    //   255: astore 4
    //   257: aload_3
    //   258: astore 5
    //   260: aload_0
    //   261: astore 6
    //   263: new 48	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   270: astore 7
    //   272: aload_0
    //   273: astore 4
    //   275: aload_3
    //   276: astore 5
    //   278: aload_0
    //   279: astore 6
    //   281: aload 7
    //   283: aload_1
    //   284: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_0
    //   289: astore 4
    //   291: aload_3
    //   292: astore 5
    //   294: aload_0
    //   295: astore 6
    //   297: aload 7
    //   299: getstatic 229	java/io/File:separator	Ljava/lang/String;
    //   302: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_0
    //   307: astore 4
    //   309: aload_3
    //   310: astore 5
    //   312: aload_0
    //   313: astore 6
    //   315: aload 7
    //   317: aload 10
    //   319: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_0
    //   324: astore 4
    //   326: aload_3
    //   327: astore 5
    //   329: aload_0
    //   330: astore 6
    //   332: new 142	java/io/File
    //   335: dup
    //   336: aload 7
    //   338: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: astore 7
    //   346: aload_0
    //   347: astore 4
    //   349: aload_3
    //   350: astore 5
    //   352: aload_0
    //   353: astore 6
    //   355: aload 7
    //   357: invokevirtual 237	java/io/File:getParentFile	()Ljava/io/File;
    //   360: invokevirtual 240	java/io/File:exists	()Z
    //   363: ifne +21 -> 384
    //   366: aload_0
    //   367: astore 4
    //   369: aload_3
    //   370: astore 5
    //   372: aload_0
    //   373: astore 6
    //   375: aload 7
    //   377: invokevirtual 237	java/io/File:getParentFile	()Ljava/io/File;
    //   380: invokevirtual 233	java/io/File:mkdirs	()Z
    //   383: pop
    //   384: aload_0
    //   385: astore 4
    //   387: aload_3
    //   388: astore 5
    //   390: aload_0
    //   391: astore 6
    //   393: new 242	java/io/FileOutputStream
    //   396: dup
    //   397: aload 7
    //   399: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   402: astore 7
    //   404: sipush 8192
    //   407: newarray byte
    //   409: astore_3
    //   410: aload_0
    //   411: aload_3
    //   412: iconst_0
    //   413: aload_3
    //   414: arraylength
    //   415: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   418: istore_2
    //   419: iload_2
    //   420: iconst_m1
    //   421: if_icmpeq +19 -> 440
    //   424: aload 7
    //   426: aload_3
    //   427: iconst_0
    //   428: iload_2
    //   429: invokevirtual 249	java/io/FileOutputStream:write	([BII)V
    //   432: aload 7
    //   434: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   437: goto -27 -> 410
    //   440: aload 7
    //   442: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   445: aload 7
    //   447: astore_3
    //   448: goto -427 -> 21
    //   451: astore_1
    //   452: aload 7
    //   454: astore 5
    //   456: goto +54 -> 510
    //   459: astore_1
    //   460: aload 7
    //   462: astore_3
    //   463: goto +39 -> 502
    //   466: aload 8
    //   468: invokevirtual 254	java/util/zip/ZipFile:close	()V
    //   471: aload_0
    //   472: ifnull +7 -> 479
    //   475: aload_0
    //   476: invokevirtual 92	java/io/InputStream:close	()V
    //   479: aload_3
    //   480: ifnull +7 -> 487
    //   483: aload_3
    //   484: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   487: return
    //   488: astore_0
    //   489: aload_0
    //   490: athrow
    //   491: astore_1
    //   492: aload 4
    //   494: astore_0
    //   495: goto +15 -> 510
    //   498: astore_1
    //   499: aload 6
    //   501: astore_0
    //   502: aload_0
    //   503: astore 4
    //   505: aload_3
    //   506: astore 5
    //   508: aload_1
    //   509: athrow
    //   510: aload 8
    //   512: invokevirtual 254	java/util/zip/ZipFile:close	()V
    //   515: aload_0
    //   516: ifnull +7 -> 523
    //   519: aload_0
    //   520: invokevirtual 92	java/io/InputStream:close	()V
    //   523: aload 5
    //   525: ifnull +8 -> 533
    //   528: aload 5
    //   530: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   533: aload_1
    //   534: athrow
    //   535: astore_0
    //   536: goto +5 -> 541
    //   539: aload_0
    //   540: athrow
    //   541: goto -2 -> 539
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramString1	String
    //   0	544	1	paramString2	String
    //   418	11	2	i	int
    //   20	486	3	localObject1	Object
    //   22	482	4	str1	String
    //   25	504	5	localObject2	Object
    //   28	472	6	str2	String
    //   59	402	7	localObject3	Object
    //   8	503	8	localZipFile	java.util.zip.ZipFile
    //   15	35	9	localEnumeration	java.util.Enumeration
    //   92	226	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   404	410	451	finally
    //   410	419	451	finally
    //   424	437	451	finally
    //   440	445	451	finally
    //   404	410	459	java/lang/Exception
    //   410	419	459	java/lang/Exception
    //   424	437	459	java/lang/Exception
    //   440	445	459	java/lang/Exception
    //   466	471	488	java/lang/Exception
    //   475	479	488	java/lang/Exception
    //   483	487	488	java/lang/Exception
    //   30	40	491	finally
    //   49	61	491	finally
    //   70	78	491	finally
    //   87	94	491	finally
    //   103	113	491	finally
    //   125	133	491	finally
    //   142	157	491	finally
    //   166	175	491	finally
    //   184	191	491	finally
    //   200	209	491	finally
    //   218	226	491	finally
    //   235	251	491	finally
    //   263	272	491	finally
    //   281	288	491	finally
    //   297	306	491	finally
    //   315	323	491	finally
    //   332	346	491	finally
    //   355	366	491	finally
    //   375	384	491	finally
    //   393	404	491	finally
    //   508	510	491	finally
    //   30	40	498	java/lang/Exception
    //   49	61	498	java/lang/Exception
    //   70	78	498	java/lang/Exception
    //   87	94	498	java/lang/Exception
    //   103	113	498	java/lang/Exception
    //   125	133	498	java/lang/Exception
    //   142	157	498	java/lang/Exception
    //   166	175	498	java/lang/Exception
    //   184	191	498	java/lang/Exception
    //   200	209	498	java/lang/Exception
    //   218	226	498	java/lang/Exception
    //   235	251	498	java/lang/Exception
    //   263	272	498	java/lang/Exception
    //   281	288	498	java/lang/Exception
    //   297	306	498	java/lang/Exception
    //   315	323	498	java/lang/Exception
    //   332	346	498	java/lang/Exception
    //   355	366	498	java/lang/Exception
    //   375	384	498	java/lang/Exception
    //   393	404	498	java/lang/Exception
    //   510	515	535	java/lang/Exception
    //   519	523	535	java/lang/Exception
    //   528	533	535	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte, 0, 8192);
        if (i <= -1) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile2.flush();
      paramFile2.close();
      paramFile1.close();
      return true;
    }
    catch (Exception paramFile1) {}
    return false;
  }
  
  public static void b(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          b(arrayOfFile[i]);
          i += 1;
        }
        paramFile.delete();
        return;
      }
      paramFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.d
 * JD-Core Version:    0.7.0.1
 */