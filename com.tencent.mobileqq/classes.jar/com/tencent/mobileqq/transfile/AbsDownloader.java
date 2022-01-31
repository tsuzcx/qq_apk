package com.tencent.mobileqq.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.Locale;

public abstract class AbsDownloader
  extends ProtocolDownloader.Adapter
  implements ProtocolDownloaderConstants
{
  public static final File a(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.startsWith("regionalthumb")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring("regionalthumb:".length());
      }
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
      try
      {
        if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring("file:".length());
        }
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = b(paramString);
          if (paramString != null) {
            return a(paramString) != null;
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static final File b(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString) + "_sp");
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d("AbsDownloader", 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static final String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("pubaccountimage"))
      {
        int i = paramString.lastIndexOf("?busiType");
        str = paramString;
        if (i != -1) {
          str = paramString.substring(0, i);
        }
      }
    }
    return "Cache_" + Utils.Crc64String(str);
  }
  
  public static final String d(String paramString)
  {
    String str2 = URLDrawableHelper.a + "/" + c(paramString);
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.startsWith("chatthumb"))
      {
        if (!new File(str2 + "_hd").exists()) {
          break label100;
        }
        str1 = str2 + "_hd";
      }
    }
    label100:
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (new File(str2).exists());
        str1 = str2;
      } while (!GeneralConfigUtils.a());
      paramString = str2 + "_big400";
      str1 = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("big_thumb", 2, "getFilePath==" + paramString);
    return paramString;
  }
  
  public static String e(String paramString)
  {
    return d(paramString) + "_dp";
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!a()) {
      return false;
    }
    return a(paramDownloadParams.urlStr);
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokevirtual 155	com/tencent/mobileqq/transfile/AbsDownloader:a	()Z
    //   6: ifeq +381 -> 387
    //   9: aload_1
    //   10: getfield 161	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   13: astore 6
    //   15: aload 6
    //   17: invokestatic 77	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   20: astore 7
    //   22: aload 7
    //   24: ifnull +38 -> 62
    //   27: ldc 101
    //   29: ldc 170
    //   31: new 79	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   38: ldc 172
    //   40: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 7
    //   45: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 180	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 7
    //   59: astore_1
    //   60: aload_1
    //   61: areturn
    //   62: aload_1
    //   63: getfield 184	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   66: ifnull +14 -> 80
    //   69: aload_0
    //   70: aconst_null
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 186	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   76: pop
    //   77: aload 7
    //   79: areturn
    //   80: aload 6
    //   82: invokestatic 136	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 9
    //   87: getstatic 191	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   90: aload 9
    //   92: invokevirtual 196	com/tencent/mobileqq/transfile/DiskCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   95: astore 10
    //   97: aload_0
    //   98: invokevirtual 198	com/tencent/mobileqq/transfile/AbsDownloader:b	()Z
    //   101: istore 4
    //   103: iload 4
    //   105: ifeq +332 -> 437
    //   108: aload_1
    //   109: aload 10
    //   111: getfield 201	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   114: invokevirtual 204	java/io/File:length	()J
    //   117: putfield 208	com/tencent/image/DownloadParams:downloaded	J
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 210	com/tencent/mobileqq/transfile/AbsDownloader:a	(Lcom/tencent/image/DownloadParams;)Z
    //   125: istore 5
    //   127: iload 5
    //   129: ifne +5 -> 134
    //   132: iconst_1
    //   133: istore_3
    //   134: iload 4
    //   136: iload_3
    //   137: iand
    //   138: istore 4
    //   140: new 212	java/io/FileOutputStream
    //   143: dup
    //   144: aload 10
    //   146: getfield 201	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   149: iload 4
    //   151: invokespecial 215	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   154: astore 8
    //   156: aload 8
    //   158: astore 7
    //   160: aload_0
    //   161: aload 8
    //   163: aload_1
    //   164: aload_2
    //   165: invokevirtual 186	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   168: pop
    //   169: aload 8
    //   171: astore 7
    //   173: aload 6
    //   175: ldc 217
    //   177: invokevirtual 220	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   180: ifeq +251 -> 431
    //   183: aload 8
    //   185: astore 7
    //   187: aload 6
    //   189: iconst_0
    //   190: aload 6
    //   192: ldc 217
    //   194: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   197: invokevirtual 46	java/lang/String:substring	(II)Ljava/lang/String;
    //   200: astore_1
    //   201: aload 8
    //   203: astore 7
    //   205: aload_1
    //   206: invokestatic 77	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull +66 -> 277
    //   214: aload 8
    //   216: astore 7
    //   218: ldc 101
    //   220: ldc 170
    //   222: new 79	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   229: ldc 225
    //   231: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   238: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 180	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 8
    //   249: astore 7
    //   251: aload 10
    //   253: getfield 201	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   256: invokevirtual 228	java/io/File:delete	()Z
    //   259: pop
    //   260: aload_2
    //   261: astore_1
    //   262: aload 8
    //   264: ifnull -204 -> 60
    //   267: aload 8
    //   269: invokevirtual 233	java/io/OutputStream:close	()V
    //   272: aload_2
    //   273: areturn
    //   274: astore_1
    //   275: aload_2
    //   276: areturn
    //   277: aload 8
    //   279: astore 7
    //   281: aload 10
    //   283: invokevirtual 236	com/tencent/mobileqq/transfile/DiskCache$Editor:a	()Ljava/io/File;
    //   286: astore_2
    //   287: aload_2
    //   288: astore_1
    //   289: aload 8
    //   291: ifnull -231 -> 60
    //   294: aload 8
    //   296: invokevirtual 233	java/io/OutputStream:close	()V
    //   299: aload_2
    //   300: areturn
    //   301: astore_1
    //   302: aload_2
    //   303: areturn
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_2
    //   307: aload 10
    //   309: ifnull +13 -> 322
    //   312: aload_2
    //   313: astore 7
    //   315: aload 10
    //   317: iload 4
    //   319: invokevirtual 239	com/tencent/mobileqq/transfile/DiskCache$Editor:a	(Z)V
    //   322: aload_2
    //   323: astore 7
    //   325: ldc 241
    //   327: ldc 170
    //   329: new 79	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   336: ldc 243
    //   338: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 9
    //   343: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 245
    //   348: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 6
    //   353: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 247	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_2
    //   363: astore 7
    //   365: aload_1
    //   366: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   369: aload_2
    //   370: astore 7
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: aload 7
    //   377: ifnull +8 -> 385
    //   380: aload 7
    //   382: invokevirtual 233	java/io/OutputStream:close	()V
    //   385: aload_1
    //   386: athrow
    //   387: aload_0
    //   388: aconst_null
    //   389: aload_1
    //   390: aload_2
    //   391: invokevirtual 186	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   394: areturn
    //   395: astore_2
    //   396: goto -11 -> 385
    //   399: astore_1
    //   400: aconst_null
    //   401: astore 7
    //   403: goto -28 -> 375
    //   406: astore_1
    //   407: aconst_null
    //   408: astore_2
    //   409: goto -102 -> 307
    //   412: astore_1
    //   413: aload 8
    //   415: astore_2
    //   416: goto -109 -> 307
    //   419: astore_2
    //   420: aload_1
    //   421: astore 6
    //   423: aload_2
    //   424: astore_1
    //   425: aload 8
    //   427: astore_2
    //   428: goto -121 -> 307
    //   431: aload 6
    //   433: astore_1
    //   434: goto -233 -> 201
    //   437: goto -297 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	AbsDownloader
    //   0	440	1	paramDownloadParams	DownloadParams
    //   0	440	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	137	3	bool1	boolean
    //   101	217	4	bool2	boolean
    //   125	3	5	bool3	boolean
    //   13	419	6	localObject1	Object
    //   20	382	7	localObject2	Object
    //   154	272	8	localFileOutputStream	java.io.FileOutputStream
    //   85	257	9	str	String
    //   95	221	10	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   267	272	274	java/io/IOException
    //   294	299	301	java/io/IOException
    //   108	127	304	java/lang/Exception
    //   160	169	374	finally
    //   173	183	374	finally
    //   187	201	374	finally
    //   205	210	374	finally
    //   218	247	374	finally
    //   251	260	374	finally
    //   281	287	374	finally
    //   315	322	374	finally
    //   325	362	374	finally
    //   365	369	374	finally
    //   372	374	374	finally
    //   380	385	395	java/io/IOException
    //   108	127	399	finally
    //   140	156	399	finally
    //   140	156	406	java/lang/Exception
    //   160	169	412	java/lang/Exception
    //   173	183	412	java/lang/Exception
    //   187	201	412	java/lang/Exception
    //   205	210	419	java/lang/Exception
    //   218	247	419	java/lang/Exception
    //   251	260	419	java/lang/Exception
    //   281	287	419	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */