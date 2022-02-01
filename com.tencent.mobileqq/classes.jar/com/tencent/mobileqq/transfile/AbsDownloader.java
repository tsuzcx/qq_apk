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
  public static final String CHAT_IMAGE_ROOT = VFSSourcePathConfig.c;
  public static final String PROTOCAL_FAVORITE_IMAGE = "favimage";
  public static final String PROTOCOL_PUB_ACCOUNT = "pubaccountimage";
  protected static final String TAG = "AbsDownloader";
  public static DiskCache sDiskCache;
  
  static
  {
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
    } else {
      localFile = MobileQQ.sMobileQQ.getCacheDir();
    }
    sDiskCache = new DiskCache(new File(localFile, "diskcache"));
  }
  
  private void asynCommitBitmapFile(DiskCache.Editor paramEditor, File paramFile)
  {
    ThreadManager.getFileThreadHandler().post(new AbsDownloader.1(this, paramEditor));
  }
  
  public static String covertUrlForAioImage(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.substring(0, 8).equalsIgnoreCase("aiothumb"))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("chatthumb");
          ((StringBuilder)localObject).append(paramString.substring(8));
          localObject = ((StringBuilder)localObject).toString();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getUrlStringForDisk newUrl = ");
            localStringBuilder.append((String)localObject);
            QLog.d("AbsDownloader", 2, localStringBuilder.toString());
          }
          return localObject;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getUrlStringForDisk IndexOutOfBoundsException");
          localStringBuilder.append(localIndexOutOfBoundsException);
          QLog.d("AbsDownloader", 2, localStringBuilder.toString());
        }
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getFilePath(paramString));
    localStringBuilder.append("_dp");
    return localStringBuilder.toString();
  }
  
  public static final File getFile(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      paramString = new File(getFilePath(paramString));
      localObject1 = localObject2;
      if (paramString.exists()) {
        localObject1 = paramString;
      }
    }
    return localObject1;
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
    paramString = new StringBuilder();
    paramString.append("Cache_");
    paramString.append(Utils.Crc64String(str));
    return paramString.toString();
  }
  
  public static final String getFilePath(String paramString)
  {
    Object localObject3 = null;
    if (paramString == null) {
      return null;
    }
    Object localObject4 = getFileName(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(sDiskCache.getDirectory());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append((String)localObject4);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2;
    try
    {
      localObject1 = new URL(paramString);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      localObject2 = null;
    }
    if (localObject2 != null) {
      localObject3 = ((URL)localObject2).getProtocol();
    }
    if ("chatthumb".equals(localObject3))
    {
      localObject3 = generateChatImgPath((String)localObject3, (String)localObject4);
      int i = 0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append("_hd");
      if (new File(((StringBuilder)localObject2).toString()).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("_hd");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject4 = str;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("_hd");
        if (new File(((StringBuilder)localObject2).toString()).exists())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("_hd");
          str = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append("_hd");
        }
        for (localObject2 = ((StringBuilder)localObject2).toString();; localObject2 = localObject3)
        {
          i = 1;
          localObject4 = str;
          break;
          localObject2 = localObject3;
          localObject4 = str;
          if (!new File(str).exists()) {
            break;
          }
        }
      }
      localObject3 = localObject2;
      if (i != 0)
      {
        migrateChatImage(paramString, (String)localObject4, (String)localObject2);
        return localObject2;
      }
    }
    else if ("chatimg".equals(localObject3))
    {
      localObject2 = generateChatImgPath((String)localObject3, (String)localObject4);
      localObject3 = localObject2;
      if (new File(str).exists())
      {
        migrateChatImage(paramString, str, (String)localObject2);
        return localObject2;
      }
    }
    else if ("chatraw".equals(localObject3))
    {
      localObject2 = generateChatImgPath((String)localObject3, (String)localObject4);
      localObject3 = localObject2;
      if (new File(str).exists())
      {
        migrateChatImage(paramString, str, (String)localObject2);
        return localObject2;
      }
    }
    else
    {
      localObject3 = str;
    }
    return localObject3;
  }
  
  public static final File getFlashPicFile(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getFilePath(paramString));
      ((StringBuilder)localObject1).append("_fp");
      paramString = new File(((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (paramString.exists()) {
        localObject1 = paramString;
      }
    }
    return localObject1;
  }
  
  public static final VFSFile getVFSFile(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      paramString = new VFSFile(getFilePath(paramString));
      localObject1 = localObject2;
      if (paramString.exists()) {
        localObject1 = paramString;
      }
    }
    return localObject1;
  }
  
  public static final boolean hasFile(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if (paramString != null)
    {
      bool1 = paramString.startsWith("regionalthumb");
      localObject3 = null;
      localObject2 = null;
      if (bool1) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, 14).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring(14);
      }
      bool1 = bool2;
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        bool1 = bool2;
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      try
      {
        if (paramString.substring(0, 5).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring(5);
        }
        bool1 = bool2;
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = covertUrlForAioImage(paramString);
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (getFile(paramString) != null) {
              bool1 = true;
            }
          }
        }
        return bool1;
        paramString = paramString;
        localObject1 = localObject2;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public static void migrateChatImage(String paramString1, String paramString2, String paramString3)
  {
    int i = FileUtils.quickMove(paramString2, paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("migrate:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" from:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" to:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" status:");
      localStringBuilder.append(i);
      QLog.d("ChatImageMigrate", 2, localStringBuilder.toString());
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
    //   0: aload_0
    //   1: invokevirtual 298	com/tencent/mobileqq/transfile/AbsDownloader:useDiskCache	()Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 11
    //   17: iload_3
    //   18: ifeq +576 -> 594
    //   21: aload_1
    //   22: getfield 303	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: invokestatic 265	com/tencent/mobileqq/transfile/AbsDownloader:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   32: astore 10
    //   34: aload 10
    //   36: ifnull +59 -> 95
    //   39: new 118	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: ldc_w 313
    //   51: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: aload 10
    //   58: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 17
    //   67: ldc_w 317
    //   70: aload_1
    //   71: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 323	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaDebug	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_2
    //   78: ifnull +14 -> 92
    //   81: aload_2
    //   82: aload 10
    //   84: invokevirtual 326	java/io/File:length	()J
    //   87: invokeinterface 332 3 0
    //   92: aload 10
    //   94: areturn
    //   95: aload_1
    //   96: getfield 336	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   99: ifnull +14 -> 113
    //   102: aload_0
    //   103: aconst_null
    //   104: aload_1
    //   105: aload_2
    //   106: invokevirtual 338	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   109: pop
    //   110: aload 10
    //   112: areturn
    //   113: aload 6
    //   115: invokestatic 203	com/tencent/mobileqq/transfile/AbsDownloader:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 12
    //   120: getstatic 74	com/tencent/mobileqq/transfile/AbsDownloader:sDiskCache	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   123: aload 12
    //   125: invokevirtual 342	com/tencent/mobileqq/transfile/DiskCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   128: astore 13
    //   130: aload_0
    //   131: invokevirtual 345	com/tencent/mobileqq/transfile/AbsDownloader:supportBreakpointContinuingly	()Z
    //   134: istore 5
    //   136: iload 5
    //   138: istore_3
    //   139: iload 5
    //   141: ifeq +34 -> 175
    //   144: iload 5
    //   146: istore 4
    //   148: aload_1
    //   149: aload 13
    //   151: getfield 351	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   154: invokevirtual 326	java/io/File:length	()J
    //   157: putfield 355	com/tencent/image/DownloadParams:downloaded	J
    //   160: iload 5
    //   162: istore 4
    //   164: iload 5
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual 358	com/tencent/mobileqq/transfile/AbsDownloader:needRestart	(Lcom/tencent/image/DownloadParams;)Z
    //   171: iconst_1
    //   172: ixor
    //   173: iand
    //   174: istore_3
    //   175: iload_3
    //   176: istore 4
    //   178: new 360	java/io/FileOutputStream
    //   181: dup
    //   182: aload 13
    //   184: getfield 351	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   187: iload_3
    //   188: invokespecial 363	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   191: astore 10
    //   193: aload 11
    //   195: astore 8
    //   197: aload 6
    //   199: astore 7
    //   201: aload_0
    //   202: aload 10
    //   204: aload_1
    //   205: aload_2
    //   206: invokevirtual 338	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   209: astore_2
    //   210: aload 6
    //   212: astore_1
    //   213: aload_2
    //   214: astore 8
    //   216: aload 6
    //   218: astore 7
    //   220: aload_2
    //   221: astore 9
    //   223: aload 6
    //   225: ldc_w 365
    //   228: invokevirtual 368	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   231: ifeq +28 -> 259
    //   234: aload_2
    //   235: astore 8
    //   237: aload 6
    //   239: astore 7
    //   241: aload_2
    //   242: astore 9
    //   244: aload 6
    //   246: iconst_0
    //   247: aload 6
    //   249: ldc_w 365
    //   252: invokevirtual 372	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   255: invokevirtual 110	java/lang/String:substring	(II)Ljava/lang/String;
    //   258: astore_1
    //   259: aload_2
    //   260: astore 8
    //   262: aload_1
    //   263: astore 7
    //   265: aload_2
    //   266: astore 9
    //   268: aload_1
    //   269: invokestatic 265	com/tencent/mobileqq/transfile/AbsDownloader:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   272: astore 6
    //   274: aload 6
    //   276: ifnull +109 -> 385
    //   279: aload_2
    //   280: astore 8
    //   282: aload_1
    //   283: astore 7
    //   285: aload_2
    //   286: astore 9
    //   288: new 118	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   295: astore 11
    //   297: aload_2
    //   298: astore 8
    //   300: aload_1
    //   301: astore 7
    //   303: aload_2
    //   304: astore 9
    //   306: aload 11
    //   308: ldc_w 374
    //   311: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: astore 8
    //   318: aload_1
    //   319: astore 7
    //   321: aload_2
    //   322: astore 9
    //   324: aload 11
    //   326: aload 6
    //   328: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   331: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_2
    //   336: astore 8
    //   338: aload_1
    //   339: astore 7
    //   341: aload_2
    //   342: astore 9
    //   344: ldc 17
    //   346: ldc_w 317
    //   349: aload 11
    //   351: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 323	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaDebug	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_2
    //   358: astore 8
    //   360: aload_1
    //   361: astore 7
    //   363: aload_2
    //   364: astore 9
    //   366: aload 13
    //   368: getfield 351	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   371: invokevirtual 377	java/io/File:delete	()Z
    //   374: pop
    //   375: aload_0
    //   376: aload 10
    //   378: aload_2
    //   379: invokevirtual 381	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   382: aload 6
    //   384: areturn
    //   385: aload_2
    //   386: astore 8
    //   388: aload_1
    //   389: astore 7
    //   391: aload_2
    //   392: astore 9
    //   394: aload_0
    //   395: aload_2
    //   396: invokevirtual 383	com/tencent/mobileqq/transfile/AbsDownloader:isCommitBimapFileAsyn	(Ljava/io/File;)Z
    //   399: ifeq +28 -> 427
    //   402: aload_2
    //   403: astore 8
    //   405: aload_1
    //   406: astore 7
    //   408: aload_2
    //   409: astore 9
    //   411: aload_0
    //   412: aload 13
    //   414: aload_2
    //   415: invokespecial 385	com/tencent/mobileqq/transfile/AbsDownloader:asynCommitBitmapFile	(Lcom/tencent/mobileqq/transfile/DiskCache$Editor;Ljava/io/File;)V
    //   418: aload_0
    //   419: aload 10
    //   421: aload_2
    //   422: invokevirtual 381	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   425: aload_2
    //   426: areturn
    //   427: aload_2
    //   428: astore 8
    //   430: aload_1
    //   431: astore 7
    //   433: aload_2
    //   434: astore 9
    //   436: aload 13
    //   438: invokevirtual 388	com/tencent/mobileqq/transfile/DiskCache$Editor:commit	()Ljava/io/File;
    //   441: astore_1
    //   442: aload_0
    //   443: aload 10
    //   445: aload_2
    //   446: invokevirtual 381	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   449: aload_1
    //   450: areturn
    //   451: astore_2
    //   452: aload 8
    //   454: astore 6
    //   456: aload 10
    //   458: astore_1
    //   459: goto +126 -> 585
    //   462: astore 8
    //   464: aload 9
    //   466: astore_2
    //   467: aload 10
    //   469: astore_1
    //   470: aload 7
    //   472: astore 6
    //   474: aload 8
    //   476: astore 7
    //   478: goto +23 -> 501
    //   481: astore_2
    //   482: aconst_null
    //   483: astore 6
    //   485: aload 7
    //   487: astore_1
    //   488: goto +97 -> 585
    //   491: astore 7
    //   493: aconst_null
    //   494: astore_2
    //   495: iload 4
    //   497: istore_3
    //   498: aload 8
    //   500: astore_1
    //   501: aload 13
    //   503: ifnull +9 -> 512
    //   506: aload 13
    //   508: iload_3
    //   509: invokevirtual 392	com/tencent/mobileqq/transfile/DiskCache$Editor:abort	(Z)V
    //   512: new 118	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   519: astore 8
    //   521: aload 8
    //   523: ldc_w 394
    //   526: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 8
    //   532: aload 12
    //   534: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 8
    //   540: ldc_w 396
    //   543: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 8
    //   549: aload 6
    //   551: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: ldc_w 398
    //   558: ldc_w 317
    //   561: aload 8
    //   563: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 401	com/tencent/mobileqq/transfile/TransFileUtil:printRichMediaError	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload 7
    //   571: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   574: aload 7
    //   576: athrow
    //   577: astore 7
    //   579: aload_2
    //   580: astore 6
    //   582: aload 7
    //   584: astore_2
    //   585: aload_0
    //   586: aload_1
    //   587: aload 6
    //   589: invokevirtual 381	com/tencent/mobileqq/transfile/AbsDownloader:releaseStream	(Ljava/io/OutputStream;Ljava/io/File;)V
    //   592: aload_2
    //   593: athrow
    //   594: aload_0
    //   595: aconst_null
    //   596: aload_1
    //   597: aload_2
    //   598: invokevirtual 338	com/tencent/mobileqq/transfile/AbsDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   601: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	AbsDownloader
    //   0	602	1	paramDownloadParams	DownloadParams
    //   0	602	2	paramURLDrawableHandler	URLDrawableHandler
    //   4	505	3	bool1	boolean
    //   146	350	4	bool2	boolean
    //   134	40	5	bool3	boolean
    //   25	563	6	localObject1	Object
    //   12	474	7	localObject2	Object
    //   491	84	7	localException1	java.lang.Exception
    //   577	6	7	localObject3	Object
    //   9	444	8	localObject4	Object
    //   462	37	8	localException2	java.lang.Exception
    //   519	43	8	localStringBuilder1	StringBuilder
    //   6	459	9	localURLDrawableHandler	URLDrawableHandler
    //   32	436	10	localObject5	Object
    //   15	335	11	localStringBuilder2	StringBuilder
    //   118	415	12	str	String
    //   128	379	13	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   201	210	451	finally
    //   223	234	451	finally
    //   244	259	451	finally
    //   268	274	451	finally
    //   288	297	451	finally
    //   306	315	451	finally
    //   324	335	451	finally
    //   344	357	451	finally
    //   366	375	451	finally
    //   394	402	451	finally
    //   411	418	451	finally
    //   436	442	451	finally
    //   201	210	462	java/lang/Exception
    //   223	234	462	java/lang/Exception
    //   244	259	462	java/lang/Exception
    //   268	274	462	java/lang/Exception
    //   288	297	462	java/lang/Exception
    //   306	315	462	java/lang/Exception
    //   324	335	462	java/lang/Exception
    //   344	357	462	java/lang/Exception
    //   366	375	462	java/lang/Exception
    //   394	402	462	java/lang/Exception
    //   411	418	462	java/lang/Exception
    //   436	442	462	java/lang/Exception
    //   148	160	481	finally
    //   164	175	481	finally
    //   178	193	481	finally
    //   148	160	491	java/lang/Exception
    //   164	175	491	java/lang/Exception
    //   178	193	491	java/lang/Exception
    //   506	512	577	finally
    //   512	577	577	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */