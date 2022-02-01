package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.emoticonview.LooperGifImage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;

public class NearbyImgDownloader
  extends AbsDownloader
{
  private static final int BUFFER_SIZE = 32768;
  public static final int DOWNLOAD_MAX_RETRY_TIME = 2;
  public static final String GIF_TYPE = "gif_type";
  public static final String ONESHOT_GIF = "1";
  public static final String TAG = "NearbyImgDownloader";
  public static final int WRITE_MAX_RETRY_TIME = 3;
  private JobQueue mQueue = new JobQueue(4);
  
  public static URL convertURL(String paramString)
  {
    paramString = new URL(paramString);
    return new URL("nearbyimage", paramString.getAuthority(), paramString.getFile());
  }
  
  public static List<String> getHostIps(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null)
    {
      long l = SystemClock.elapsedRealtime();
      boolean bool = HeadDpcCfg.a().a();
      int k = NetConnInfoCenter.getActiveNetIpFamily(true);
      int i = 28;
      Object localObject;
      int j;
      if (k == 3)
      {
        localObject = InnerDns.getInstance();
        if (bool) {
          j = 28;
        } else {
          j = 1;
        }
        localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1001, true, j);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
          localArrayList.add(((ArrayList)localObject).get(0));
        }
        localObject = InnerDns.getInstance();
        if (bool) {
          i = 1;
        }
        localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1001, true, i);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
          localArrayList.add(((ArrayList)localObject).get(0));
        }
      }
      else
      {
        if (k == 2) {
          j = 1;
        } else {
          j = 0;
        }
        localObject = InnerDns.getInstance();
        if (j == 0) {
          i = 1;
        }
        localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1001, true, i);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
          localArrayList.add(((ArrayList)localObject).get(0));
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convertURL: ");
        ((StringBuilder)localObject).append(paramString.toString());
        ((StringBuilder)localObject).append(" ip_zhitongche cost: ");
        ((StringBuilder)localObject).append(SystemClock.elapsedRealtime() - l);
        ((StringBuilder)localObject).append(" ipType=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" bPrefIpv6=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" ips=");
        ((StringBuilder)localObject).append(Arrays.toString(localArrayList.toArray()));
        QLog.i("NearbyImgDownloader", 2, ((StringBuilder)localObject).toString());
      }
      if ((localArrayList.size() == 0) && (k != 2))
      {
        localObject = getTmp(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() < 2) {
        localArrayList.add(paramString);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("convertURL urlStr end: ips=");
        paramString.append(Arrays.toString(localArrayList.toArray()));
        QLog.i("NearbyImgDownloader", 2, paramString.toString());
      }
    }
    return localArrayList;
  }
  
  private static String getTmp(String paramString)
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadDirectIP");
    if ("p.qpic.cn".equals(paramString)) {
      return PicIPManager.a(2);
    }
    if ("p.qlogo.cn".equals(paramString)) {
      return PicIPManager.a(1);
    }
    if ("ugc.qpic.cn".equals(paramString)) {
      return PicIPManager.a(8, str);
    }
    if (isQQHeadHost(paramString)) {
      return PicIPManager.a(0);
    }
    if ("i.gtimg.cn".equals(paramString)) {
      return PicIPManager.b(FMTSrvAddrProvider.getInstance().getAllIpList(14));
    }
    if ("imgcache.qq.com".equals(paramString)) {
      return PicIPManager.a(FMTSrvAddrProvider.getInstance().getAllIpList(12));
    }
    if (isAQpicCn(paramString)) {
      return PicIPManager.a(9, str);
    }
    if (isQzsQqCom(paramString)) {
      return PicIPManager.a(11, str);
    }
    if (isQzoneStyleGtimgCn(paramString)) {
      return PicIPManager.a(10, str);
    }
    if ("pgdt.gtimg.cn".equals(paramString)) {
      return PicIPManager.a(3);
    }
    if ("sqimg.qq.com".equals(paramString)) {
      return PicIPManager.a(4);
    }
    if ("download.wegame.qq.com".equals(paramString)) {
      return PicIPManager.a(5);
    }
    if ("wfqqreader.3g.qq.com".equals(paramString)) {
      return PicIPManager.a(6);
    }
    if ("buluo.qq.com".equals(paramString)) {
      return PicIPManager.a(7);
    }
    return null;
  }
  
  public static boolean isAQpicCn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("a[0-9].qpic.cn").matcher(paramString).find();
  }
  
  public static boolean isQQHeadHost(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^q\\d?.qlogo.cn$").matcher(paramString).find();
  }
  
  public static boolean isQzoneStyleGtimgCn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzonestyle.gtimg.cn").matcher(paramString).find();
  }
  
  public static boolean isQzsQqCom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzs.qq.com").matcher(paramString).find();
  }
  
  private void logDownloadEnd(String paramString, boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download img end url: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramLong);
        QLog.i("NearbyImgDownloader", 2, localStringBuilder.toString());
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download img end url: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLong);
      QLog.w("NearbyImgDownloader", 1, localStringBuilder.toString());
    }
  }
  
  private void logDownloadStart(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download img start url: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" time: ");
      localStringBuilder.append(SystemClock.elapsedRealtime());
      QLog.i("NearbyImgDownloader", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  private boolean writeToFile(java.io.InputStream paramInputStream, long paramLong, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 292	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 7
    //   7: invokespecial 295	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 16
    //   12: iconst_0
    //   13: istore 12
    //   15: iconst_0
    //   16: istore 13
    //   18: aconst_null
    //   19: astore 14
    //   21: aconst_null
    //   22: astore 15
    //   24: aload 15
    //   26: astore_1
    //   27: ldc 7
    //   29: newarray byte
    //   31: astore 17
    //   33: lconst_0
    //   34: lstore 8
    //   36: aload 15
    //   38: astore_1
    //   39: new 297	java/io/FileOutputStream
    //   42: dup
    //   43: aload 4
    //   45: getfield 303	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   48: iconst_0
    //   49: invokespecial 306	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   52: astore 4
    //   54: aload 16
    //   56: aload 17
    //   58: invokevirtual 312	java/io/InputStream:read	([B)I
    //   61: istore 6
    //   63: iload 6
    //   65: iconst_m1
    //   66: if_icmpeq +108 -> 174
    //   69: aload 4
    //   71: aload 17
    //   73: iconst_0
    //   74: iload 6
    //   76: invokevirtual 316	java/io/FileOutputStream:write	([BII)V
    //   79: lload 8
    //   81: iload 6
    //   83: i2l
    //   84: ladd
    //   85: lstore 10
    //   87: lload 10
    //   89: l2f
    //   90: lload_2
    //   91: l2f
    //   92: fdiv
    //   93: ldc_w 317
    //   96: fmul
    //   97: f2i
    //   98: istore 7
    //   100: aload 5
    //   102: iload 7
    //   104: invokeinterface 322 2 0
    //   109: lload 10
    //   111: lstore 8
    //   113: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq -62 -> 54
    //   119: new 119	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc_w 324
    //   131: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: iload 7
    //   138: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: ldc_w 326
    //   146: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: iload 6
    //   153: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 19
    //   159: iconst_2
    //   160: aload_1
    //   161: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: lload 10
    //   169: lstore 8
    //   171: goto -117 -> 54
    //   174: aload 4
    //   176: invokevirtual 329	java/io/FileOutputStream:flush	()V
    //   179: iconst_1
    //   180: istore 12
    //   182: iconst_1
    //   183: istore 13
    //   185: aload 16
    //   187: invokevirtual 332	java/io/InputStream:close	()V
    //   190: aload 4
    //   192: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_1
    //   198: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +95 -> 296
    //   204: iload 13
    //   206: istore 12
    //   208: ldc 19
    //   210: iconst_2
    //   211: aload_1
    //   212: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   215: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: iload 12
    //   220: ireturn
    //   221: astore_1
    //   222: goto +77 -> 299
    //   225: astore 5
    //   227: goto +20 -> 247
    //   230: astore 5
    //   232: aload_1
    //   233: astore 4
    //   235: aload 5
    //   237: astore_1
    //   238: goto +61 -> 299
    //   241: astore 5
    //   243: aload 14
    //   245: astore 4
    //   247: aload 4
    //   249: astore_1
    //   250: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +17 -> 270
    //   256: aload 4
    //   258: astore_1
    //   259: ldc 19
    //   261: iconst_2
    //   262: aload 5
    //   264: invokevirtual 335	java/io/IOException:toString	()Ljava/lang/String;
    //   267: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload 16
    //   272: invokevirtual 332	java/io/InputStream:close	()V
    //   275: aload 4
    //   277: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   280: iconst_0
    //   281: ireturn
    //   282: astore_1
    //   283: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +10 -> 296
    //   289: iload 13
    //   291: istore 12
    //   293: goto -85 -> 208
    //   296: iload 12
    //   298: ireturn
    //   299: aload 16
    //   301: invokevirtual 332	java/io/InputStream:close	()V
    //   304: aload 4
    //   306: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   309: goto +22 -> 331
    //   312: astore 4
    //   314: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +14 -> 331
    //   320: ldc 19
    //   322: iconst_2
    //   323: aload 4
    //   325: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   328: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: goto +5 -> 336
    //   334: aload_1
    //   335: athrow
    //   336: goto -2 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	NearbyImgDownloader
    //   0	339	1	paramInputStream	java.io.InputStream
    //   0	339	2	paramLong	long
    //   0	339	4	paramEditor	DiskCache.Editor
    //   0	339	5	paramURLDrawableHandler	URLDrawableHandler
    //   61	91	6	i	int
    //   98	39	7	j	int
    //   34	136	8	l1	long
    //   85	83	10	l2	long
    //   13	284	12	bool1	boolean
    //   16	274	13	bool2	boolean
    //   19	225	14	localObject1	Object
    //   22	15	15	localObject2	Object
    //   10	290	16	localBufferedInputStream	java.io.BufferedInputStream
    //   31	41	17	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   185	195	197	java/lang/Exception
    //   54	63	221	finally
    //   69	79	221	finally
    //   87	109	221	finally
    //   113	167	221	finally
    //   174	179	221	finally
    //   54	63	225	java/io/IOException
    //   69	79	225	java/io/IOException
    //   87	109	225	java/io/IOException
    //   113	167	225	java/io/IOException
    //   174	179	225	java/io/IOException
    //   27	33	230	finally
    //   39	54	230	finally
    //   250	256	230	finally
    //   259	270	230	finally
    //   27	33	241	java/io/IOException
    //   39	54	241	java/io/IOException
    //   270	280	282	java/lang/Exception
    //   299	309	312	java/lang/Exception
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("gif_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (paramURLDrawableHandler.equals("1"))) {
        return new LooperGifImage(paramFile, true, f, 1);
      }
    }
    return null;
  }
  
  public File downloadImage(DiskCache.Editor paramEditor, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    return this.mQueue;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    Object localObject = getFile(str);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("loadImageFile file exist: ");
        paramDownloadParams.append(((File)localObject).getAbsolutePath());
        QLog.i("NearbyImgDownloader", 2, paramDownloadParams.toString());
      }
      return localObject;
    }
    localObject = getFileName(str);
    localObject = sDiskCache.edit((String)localObject);
    try
    {
      downloadImage((DiskCache.Editor)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = getFile(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel())
        {
          paramURLDrawableHandler = new StringBuilder();
          paramURLDrawableHandler.append("loadImageFile f exist:");
          paramURLDrawableHandler.append(paramDownloadParams.getAbsolutePath());
          QLog.i("NearbyImgDownloader", 2, paramURLDrawableHandler.toString());
        }
        ((DiskCache.Editor)localObject).dirtyFile.delete();
        return paramDownloadParams;
      }
      paramDownloadParams = ((DiskCache.Editor)localObject).commit();
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((DiskCache.Editor)localObject).abort(false);
      }
      throw paramDownloadParams;
    }
  }
  
  public boolean useDiskCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader
 * JD-Core Version:    0.7.0.1
 */