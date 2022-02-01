package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLState;
import com.tencent.image.Utils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vfs.VFSSourcePathConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class AbsDownloader
  extends ProtocolDownloader.Adapter
  implements ProtocolDownloaderConstants
{
  public static final String CHAT_IMAGE_ROOT;
  public static final String PROTOCOL_PUB_ACCOUNT = "pubaccountimage";
  protected static final String TAG = "AbsDownloader";
  public static DiskCache sDiskCache;
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));; localFile = MobileQQ.sMobileQQ.getCacheDir())
    {
      sDiskCache = new DiskCache(new File(localFile, "diskcache"));
      CHAT_IMAGE_ROOT = VFSSourcePathConfig.a;
      return;
    }
  }
  
  private void asynCommitBitmapFile(DiskCache.Editor paramEditor, File paramFile)
  {
    ThreadManager.getFileThreadHandler().post(new AbsDownloader.1(this, paramEditor));
  }
  
  public static String covertUrlForAioImage(String paramString)
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
  
  public static String generateChatImgPath(String paramString1, String paramString2)
  {
    String str = paramString2.substring(paramString2.length() - 3);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(CHAT_IMAGE_ROOT);
    localStringBuffer.append(paramString1);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(str);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(paramString2);
    return RmVFSUtils.getVFSPath(localStringBuffer.toString());
  }
  
  public static String getDisplayFilePath(String paramString)
  {
    return getFilePath(paramString) + "_dp";
  }
  
  public static final File getFile(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(getFilePath(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final String getFileName(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("pubaccountimage")) {
        str = paramString.replace("pubaccountimage:", "");
      }
    }
    return "Cache_" + Utils.Crc64String(str);
  }
  
  public static final String getFilePath(String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    if (paramString == null) {}
    for (;;)
    {
      return localObject2;
      String str = getFileName(paramString);
      Object localObject1 = sDiskCache.getDirectory() + File.separator + str;
      try
      {
        localObject2 = new URL(paramString);
        if (localObject2 != null) {
          localObject4 = ((URL)localObject2).getProtocol();
        }
        if ("chatthumb".equals(localObject4))
        {
          localObject2 = generateChatImgPath((String)localObject4, str);
          if (new File((String)localObject2 + "_hd").exists())
          {
            localObject2 = (String)localObject2 + "_hd";
            i = 0;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (i == 0) {
              continue;
            }
            migrateChatImage(paramString, (String)localObject4, (String)localObject1);
            return localObject1;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          int i;
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
          continue;
          if (new File((String)localObject1 + "_hd").exists())
          {
            localObject4 = (String)localObject1 + "_hd";
            localObject1 = (String)localObject3 + "_hd";
            i = 1;
          }
          else
          {
            if (new File((String)localObject1).exists())
            {
              localObject4 = localObject1;
              i = 1;
              localObject1 = localObject3;
              continue;
              if ("chatimg".equals(localObject4))
              {
                localObject4 = generateChatImgPath((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                migrateChatImage(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              if ("chatraw".equals(localObject4))
              {
                localObject4 = generateChatImgPath((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                migrateChatImage(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              return localObject1;
            }
            localObject4 = localObject1;
            i = 0;
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public static final File getFlashPicFile(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(getFilePath(paramString) + "_fp");
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final VFSFile getVFSFile(String paramString)
  {
    if (paramString != null)
    {
      paramString = new VFSFile(getFilePath(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static final boolean hasFile(String paramString)
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
          paramString = covertUrlForAioImage(paramString);
          if (paramString != null) {
            return getFile(paramString) != null;
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
  
  public static void migrateChatImage(String paramString1, String paramString2, String paramString3)
  {
    int i = FileUtils.a(paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ChatImageMigrate", 2, "migrate:" + paramString1 + " from:" + paramString2 + " to:" + paramString3 + " status:" + i);
    }
  }
  
  protected int calculateSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return URLState.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  public abstract File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!useDiskCache()) {
      return false;
    }
    return hasFile(paramDownloadParams.urlStr);
  }
  
  protected boolean isCommitBimapFileAsyn(File paramFile)
  {
    return false;
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 8
    //   8: aload_0
    //   9: invokevirtual 294	com/tencent/mobileqq/transfile/AbsDownloader:useDiskCache	()Z
    //   12: ifeq +379 -> 391
    //   15: aload_1
    //   16: getfield 299	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   19: astore 7
    //   21: aload 7
    //   23: invokestatic 262	com/tencent/mobileqq/transfile/AbsDownloader:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +53 -> 83
    //   33: ldc 14
    //   35: ldc_w 308
    //   38: new 119	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 310
    //   48: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 6
    //   53: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 319	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaDebug	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +14 -> 80
    //   69: aload_2
    //   70: aload 6
    //   72: invokevirtual 322	java/io/File:length	()J
    //   75: invokeinterface 328 3 0
    //   80: aload 6
    //   82: areturn
    //   83: aload_1
    //   84: getfield 332	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   87: ifnull +14 -> 101
    //   90: aload_0
    //   91: aconst_null
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 334	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   97: pop
    //   98: aload 6
    //   100: areturn
    //   101: aload 7
    //   103: invokestatic 200	com/tencent/mobileqq/transfile/AbsDownloader:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 10
    //   108: getstatic 61	com/tencent/mobileqq/transfile/AbsDownloader:sDiskCache	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   111: aload 10
    //   113: invokevirtual 338	com/tencent/mobileqq/transfile/DiskCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   116: astore 11
    //   118: aload_0
    //   119: invokevirtual 341	com/tencent/mobileqq/transfile/AbsDownloader:supportBreakpointContinuingly	()Z
    //   122: istore 4
    //   124: iload 4
    //   126: ifeq +330 -> 456
    //   129: aload_1
    //   130: aload 11
    //   132: getfield 347	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   135: invokevirtual 322	java/io/File:length	()J
    //   138: putfield 351	com/tencent/image/DownloadParams:downloaded	J
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 354	com/tencent/mobileqq/transfile/AbsDownloader:needRestart	(Lcom/tencent/image/DownloadParams;)Z
    //   146: istore 5
    //   148: iload 5
    //   150: ifne +5 -> 155
    //   153: iconst_1
    //   154: istore_3
    //   155: iload 4
    //   157: iload_3
    //   158: iand
    //   159: istore 4
    //   161: new 356	java/io/FileOutputStream
    //   164: dup
    //   165: aload 11
    //   167: getfield 347	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   170: iload 4
    //   172: invokespecial 359	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   175: astore 6
    //   177: aload_0
    //   178: aload 6
    //   180: aload_1
    //   181: aload_2
    //   182: invokevirtual 334	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   185: astore_2
    //   186: aload 7
    //   188: ldc_w 361
    //   191: invokevirtual 364	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   194: ifeq +256 -> 450
    //   197: aload 7
    //   199: iconst_0
    //   200: aload 7
    //   202: ldc_w 361
    //   205: invokevirtual 368	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   208: invokevirtual 113	java/lang/String:substring	(II)Ljava/lang/String;
    //   211: astore_1
    //   212: aload_1
    //   213: invokestatic 262	com/tencent/mobileqq/transfile/AbsDownloader:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   216: astore 7
    //   218: aload 7
    //   220: ifnull +54 -> 274
    //   223: ldc 14
    //   225: ldc_w 308
    //   228: new 119	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 370
    //   238: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 7
    //   243: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 319	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaDebug	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 11
    //   257: getfield 347	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   260: invokevirtual 373	java/io/File:delete	()Z
    //   263: pop
    //   264: aload_0
    //   265: aload 6
    //   267: aload_2
    //   268: invokevirtual 377	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   271: aload 7
    //   273: areturn
    //   274: aload_0
    //   275: aload_2
    //   276: invokevirtual 379	com/tencent/mobileqq/transfile/AbsDownloader:isCommitBimapFileAsyn	(Ljava/io/File;)Z
    //   279: ifeq +19 -> 298
    //   282: aload_0
    //   283: aload 11
    //   285: aload_2
    //   286: invokespecial 381	com/tencent/mobileqq/transfile/AbsDownloader:asynCommitBitmapFile	(Lcom/tencent/mobileqq/transfile/DiskCache$Editor;Ljava/io/File;)V
    //   289: aload_0
    //   290: aload 6
    //   292: aload_2
    //   293: invokevirtual 377	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   296: aload_2
    //   297: areturn
    //   298: aload 11
    //   300: invokevirtual 384	com/tencent/mobileqq/transfile/DiskCache$Editor:commit	()Ljava/io/File;
    //   303: astore 7
    //   305: aload_0
    //   306: aload 6
    //   308: aload_2
    //   309: invokevirtual 377	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   312: aload 7
    //   314: areturn
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_2
    //   318: aload 8
    //   320: astore 6
    //   322: aload 11
    //   324: ifnull +10 -> 334
    //   327: aload 11
    //   329: iload 4
    //   331: invokevirtual 388	com/tencent/mobileqq/transfile/DiskCache$Editor:abort	(Z)V
    //   334: ldc_w 390
    //   337: ldc_w 308
    //   340: new 119	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 392
    //   350: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 10
    //   355: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 394
    //   361: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 7
    //   366: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 397	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaError	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_1
    //   376: invokevirtual 398	java/lang/Exception:printStackTrace	()V
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: aload_0
    //   383: aload 6
    //   385: aload_2
    //   386: invokevirtual 377	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   389: aload_1
    //   390: athrow
    //   391: aload_0
    //   392: aconst_null
    //   393: aload_1
    //   394: aload_2
    //   395: invokevirtual 334	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   398: areturn
    //   399: astore_1
    //   400: aconst_null
    //   401: astore_2
    //   402: aload 9
    //   404: astore 6
    //   406: goto -24 -> 382
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_2
    //   412: goto -30 -> 382
    //   415: astore_1
    //   416: goto -34 -> 382
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_2
    //   422: aload 8
    //   424: astore 6
    //   426: goto -104 -> 322
    //   429: astore_1
    //   430: aconst_null
    //   431: astore_2
    //   432: goto -110 -> 322
    //   435: astore_1
    //   436: goto -114 -> 322
    //   439: astore 8
    //   441: aload_1
    //   442: astore 7
    //   444: aload 8
    //   446: astore_1
    //   447: goto -125 -> 322
    //   450: aload 7
    //   452: astore_1
    //   453: goto -241 -> 212
    //   456: goto -295 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	AbsDownloader
    //   0	459	1	paramDownloadParams	DownloadParams
    //   0	459	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	158	3	bool1	boolean
    //   122	208	4	bool2	boolean
    //   146	3	5	bool3	boolean
    //   26	399	6	localObject1	Object
    //   19	432	7	localObject2	Object
    //   6	417	8	localObject3	Object
    //   439	6	8	localException	java.lang.Exception
    //   3	400	9	localObject4	Object
    //   106	248	10	str	String
    //   116	212	11	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   129	148	315	java/lang/Exception
    //   327	334	381	finally
    //   334	381	381	finally
    //   129	148	399	finally
    //   161	177	399	finally
    //   177	186	409	finally
    //   186	212	415	finally
    //   212	218	415	finally
    //   223	264	415	finally
    //   274	289	415	finally
    //   298	305	415	finally
    //   161	177	419	java/lang/Exception
    //   177	186	429	java/lang/Exception
    //   186	212	435	java/lang/Exception
    //   212	218	439	java/lang/Exception
    //   223	264	439	java/lang/Exception
    //   274	289	439	java/lang/Exception
    //   298	305	439	java/lang/Exception
  }
  
  public boolean needRestart(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  protected void releaseStream(OutputStream paramOutputStream, File paramFile)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  public boolean supportBreakpointContinuingly()
  {
    return false;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */