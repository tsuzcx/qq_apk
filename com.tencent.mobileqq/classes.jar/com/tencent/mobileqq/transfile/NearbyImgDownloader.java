package com.tencent.mobileqq.transfile;

import amtk;
import android.os.SystemClock;
import android.text.TextUtils;
import aptw;
import bgfa;
import com.tencent.image.DownloadParams;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
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
    int i = 28;
    ArrayList localArrayList = new ArrayList();
    int k;
    Object localObject;
    int j;
    if (paramString != null)
    {
      long l = SystemClock.elapsedRealtime();
      boolean bool = amtk.a().a();
      k = NetConnInfoCenter.getActiveNetIpFamily(true);
      if (k != 3) {
        break label348;
      }
      localObject = InnerDns.getInstance();
      if (!bool) {
        break label343;
      }
      j = 28;
      localObject = ((InnerDns)localObject).reqDnsForIpList(paramString, 1001, true, j);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localArrayList.add(((ArrayList)localObject).get(0));
      }
      localObject = InnerDns.getInstance();
      if (bool) {
        i = 1;
      }
      localObject = ((InnerDns)localObject).reqDnsForIpList(paramString, 1001, true, i);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localArrayList.add(((ArrayList)localObject).get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL: " + paramString.toString() + " ip_zhitongche cost: " + (SystemClock.elapsedRealtime() - l) + " ipType=" + k + " bPrefIpv6=" + bool + " ips=" + Arrays.toString(localArrayList.toArray()));
      }
      if ((localArrayList.size() == 0) && (k != 2))
      {
        localObject = null;
        if (!"p.qpic.cn".equals(paramString)) {
          break label417;
        }
        localObject = aptw.a(2);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localArrayList.add(localObject);
      }
      if (localArrayList.size() < 2) {
        localArrayList.add(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL urlStr end: ips=" + Arrays.toString(localArrayList.toArray()));
      }
      return localArrayList;
      label343:
      j = 1;
      break;
      label348:
      if (k == 2)
      {
        j = 1;
        label355:
        localObject = InnerDns.getInstance();
        if (j == 0) {
          break label412;
        }
      }
      for (;;)
      {
        localObject = ((InnerDns)localObject).reqDnsForIpList(paramString, 1001, true, i);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        localArrayList.add(((ArrayList)localObject).get(0));
        break;
        j = 0;
        break label355;
        label412:
        i = 1;
      }
      label417:
      if ("p.qlogo.cn".equals(paramString)) {
        localObject = aptw.a(1);
      } else if ("ugc.qpic.cn".equals(paramString)) {
        localObject = aptw.b(8);
      } else if (isQQHeadHost(paramString)) {
        localObject = aptw.a(0);
      } else if ("i.gtimg.cn".equals(paramString)) {
        localObject = aptw.b();
      } else if ("imgcache.qq.com".equals(paramString)) {
        localObject = aptw.a();
      } else if (isAQpicCn(paramString)) {
        localObject = aptw.b(9);
      } else if (isQzsQqCom(paramString)) {
        localObject = aptw.b(11);
      } else if (isQzoneStyleGtimgCn(paramString)) {
        localObject = aptw.b(10);
      } else if ("pgdt.gtimg.cn".equals(paramString)) {
        localObject = aptw.a(3);
      } else if ("sqimg.qq.com".equals(paramString)) {
        localObject = aptw.a(4);
      } else if ("download.wegame.qq.com".equals(paramString)) {
        localObject = aptw.a(5);
      } else if ("wfqqreader.3g.qq.com".equals(paramString)) {
        localObject = aptw.a(6);
      } else if ("buluo.qq.com".equals(paramString)) {
        localObject = aptw.a(7);
      }
    }
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
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
      }
      return;
    }
    QLog.w("NearbyImgDownloader", 1, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
  }
  
  private void logDownloadStart(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyImgDownloader", 2, "download img start url: " + paramString + " time: " + SystemClock.elapsedRealtime());
    }
  }
  
  /* Error */
  private boolean writeToFile(java.io.InputStream paramInputStream, long paramLong, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 262	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 7
    //   7: invokespecial 265	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 13
    //   12: ldc 7
    //   14: newarray byte
    //   16: astore 14
    //   18: new 267	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: getfield 273	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 4
    //   33: lconst_0
    //   34: lstore 8
    //   36: aload 4
    //   38: astore_1
    //   39: aload 13
    //   41: aload 14
    //   43: invokevirtual 282	java/io/InputStream:read	([B)I
    //   46: istore 6
    //   48: iload 6
    //   50: iconst_m1
    //   51: if_icmpeq +154 -> 205
    //   54: aload 4
    //   56: astore_1
    //   57: aload 4
    //   59: aload 14
    //   61: iconst_0
    //   62: iload 6
    //   64: invokevirtual 286	java/io/FileOutputStream:write	([BII)V
    //   67: lload 8
    //   69: iload 6
    //   71: i2l
    //   72: ladd
    //   73: lstore 10
    //   75: aload 4
    //   77: astore_1
    //   78: lload 10
    //   80: l2f
    //   81: lload_2
    //   82: l2f
    //   83: fdiv
    //   84: ldc_w 287
    //   87: fmul
    //   88: f2i
    //   89: istore 7
    //   91: aload 4
    //   93: astore_1
    //   94: aload 5
    //   96: iload 7
    //   98: invokeinterface 292 2 0
    //   103: lload 10
    //   105: lstore 8
    //   107: aload 4
    //   109: astore_1
    //   110: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq -77 -> 36
    //   116: aload 4
    //   118: astore_1
    //   119: ldc 19
    //   121: iconst_2
    //   122: new 117	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 294
    //   132: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload 7
    //   137: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc_w 296
    //   143: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload 6
    //   148: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: lload 10
    //   159: lstore 8
    //   161: goto -125 -> 36
    //   164: astore 5
    //   166: aload 4
    //   168: astore_1
    //   169: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +17 -> 189
    //   175: aload 4
    //   177: astore_1
    //   178: ldc 19
    //   180: iconst_2
    //   181: aload 5
    //   183: invokevirtual 297	java/io/IOException:toString	()Ljava/lang/String;
    //   186: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iconst_0
    //   190: istore 12
    //   192: aload 13
    //   194: invokevirtual 300	java/io/InputStream:close	()V
    //   197: aload 4
    //   199: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   202: iload 12
    //   204: ireturn
    //   205: aload 4
    //   207: astore_1
    //   208: aload 4
    //   210: invokevirtual 304	java/io/FileOutputStream:flush	()V
    //   213: iconst_1
    //   214: istore 12
    //   216: aload 13
    //   218: invokevirtual 300	java/io/InputStream:close	()V
    //   221: aload 4
    //   223: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   226: iconst_1
    //   227: ireturn
    //   228: astore_1
    //   229: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -30 -> 202
    //   235: ldc 19
    //   237: iconst_2
    //   238: aload_1
    //   239: invokevirtual 305	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_1
    //   248: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -49 -> 202
    //   254: ldc 19
    //   256: iconst_2
    //   257: aload_1
    //   258: invokevirtual 305	java/lang/Exception:toString	()Ljava/lang/String;
    //   261: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_1
    //   270: aload 13
    //   272: invokevirtual 300	java/io/InputStream:close	()V
    //   275: aload_1
    //   276: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   279: aload 4
    //   281: athrow
    //   282: astore_1
    //   283: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -7 -> 279
    //   289: ldc 19
    //   291: iconst_2
    //   292: aload_1
    //   293: invokevirtual 305	java/lang/Exception:toString	()Ljava/lang/String;
    //   296: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: goto -20 -> 279
    //   302: astore 4
    //   304: goto -34 -> 270
    //   307: astore 5
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -146 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	NearbyImgDownloader
    //   0	315	1	paramInputStream	java.io.InputStream
    //   0	315	2	paramLong	long
    //   0	315	4	paramEditor	DiskCache.Editor
    //   0	315	5	paramURLDrawableHandler	URLDrawableHandler
    //   46	101	6	i	int
    //   89	47	7	j	int
    //   34	126	8	l1	long
    //   73	85	10	l2	long
    //   190	25	12	bool	boolean
    //   10	261	13	localBufferedInputStream	java.io.BufferedInputStream
    //   16	44	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	48	164	java/io/IOException
    //   57	67	164	java/io/IOException
    //   78	91	164	java/io/IOException
    //   94	103	164	java/io/IOException
    //   110	116	164	java/io/IOException
    //   119	157	164	java/io/IOException
    //   208	213	164	java/io/IOException
    //   216	226	228	java/lang/Exception
    //   192	202	247	java/lang/Exception
    //   12	33	266	finally
    //   270	279	282	java/lang/Exception
    //   39	48	302	finally
    //   57	67	302	finally
    //   78	91	302	finally
    //   94	103	302	finally
    //   110	116	302	finally
    //   119	157	302	finally
    //   169	175	302	finally
    //   178	189	302	finally
    //   208	213	302	finally
    //   12	33	307	java/io/IOException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("gif_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (paramURLDrawableHandler.equals("1"))) {
        return new bgfa(paramFile, true, f, 1);
      }
    }
    return null;
  }
  
  /* Error */
  public File downloadImage(DiskCache.Editor paramEditor, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   5: invokespecial 340	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadStart	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: invokeinterface 343 1 0
    //   14: aload_2
    //   15: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   18: ldc_w 345
    //   21: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifeq +223 -> 247
    //   27: aload_2
    //   28: aload_2
    //   29: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   32: ldc_w 345
    //   35: ldc_w 350
    //   38: invokevirtual 354	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   44: new 356	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: getfield 360	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   52: invokevirtual 57	java/net/URL:getFile	()Ljava/lang/String;
    //   55: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 8
    //   60: aload 8
    //   62: invokevirtual 364	java/io/File:exists	()Z
    //   65: ifeq +161 -> 226
    //   68: aload 8
    //   70: invokevirtual 367	java/io/File:isFile	()Z
    //   73: ifeq +153 -> 226
    //   76: new 262	java/io/BufferedInputStream
    //   79: dup
    //   80: new 369	java/io/FileInputStream
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 372	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 375	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 9
    //   94: iconst_0
    //   95: istore 4
    //   97: aload_0
    //   98: aload 9
    //   100: aload 8
    //   102: invokevirtual 378	java/io/File:length	()J
    //   105: aload_1
    //   106: aload_3
    //   107: invokespecial 41	com/tencent/mobileqq/transfile/NearbyImgDownloader:writeToFile	(Ljava/io/InputStream;JLcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;)Z
    //   110: ifeq +30 -> 140
    //   113: aload_3
    //   114: aload 8
    //   116: invokevirtual 378	java/io/File:length	()J
    //   119: invokeinterface 382 3 0
    //   124: aload_0
    //   125: aload_2
    //   126: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   129: iconst_1
    //   130: aload 8
    //   132: invokevirtual 378	java/io/File:length	()J
    //   135: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   138: aconst_null
    //   139: areturn
    //   140: iload 4
    //   142: iconst_3
    //   143: if_icmpne +24 -> 167
    //   146: aload_3
    //   147: iconst_4
    //   148: invokeinterface 387 2 0
    //   153: aload_0
    //   154: aload_2
    //   155: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   158: iconst_0
    //   159: ldc2_w 388
    //   162: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   165: aconst_null
    //   166: areturn
    //   167: ldc2_w 390
    //   170: invokestatic 396	java/lang/Thread:sleep	(J)V
    //   173: iload 4
    //   175: iconst_1
    //   176: iadd
    //   177: istore 4
    //   179: iload 4
    //   181: iconst_3
    //   182: if_icmple +538 -> 720
    //   185: aload_3
    //   186: iconst_4
    //   187: invokeinterface 387 2 0
    //   192: aload_0
    //   193: aload_2
    //   194: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   197: iconst_0
    //   198: ldc2_w 388
    //   201: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -25 -> 185
    //   213: ldc 19
    //   215: iconst_2
    //   216: aload_1
    //   217: invokevirtual 397	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   220: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: goto -38 -> 185
    //   226: aload_3
    //   227: iconst_4
    //   228: invokeinterface 387 2 0
    //   233: aload_0
    //   234: aload_2
    //   235: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   238: iconst_0
    //   239: ldc2_w 388
    //   242: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   245: aconst_null
    //   246: areturn
    //   247: new 64	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 65	java/util/ArrayList:<init>	()V
    //   254: astore 9
    //   256: new 64	java/util/ArrayList
    //   259: dup
    //   260: invokespecial 65	java/util/ArrayList:<init>	()V
    //   263: astore 10
    //   265: new 45	java/net/URL
    //   268: dup
    //   269: aload_2
    //   270: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   273: invokespecial 48	java/net/URL:<init>	(Ljava/lang/String;)V
    //   276: astore 11
    //   278: aload 11
    //   280: invokevirtual 400	java/net/URL:getHost	()Ljava/lang/String;
    //   283: astore 12
    //   285: aload 10
    //   287: new 402	org/apache/http/message/BasicHeader
    //   290: dup
    //   291: ldc_w 404
    //   294: aload 12
    //   296: invokespecial 407	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: invokeinterface 110 2 0
    //   304: pop
    //   305: aload 9
    //   307: aload 12
    //   309: invokestatic 409	com/tencent/mobileqq/transfile/NearbyImgDownloader:getHostIps	(Ljava/lang/String;)Ljava/util/List;
    //   312: invokeinterface 413 2 0
    //   317: pop
    //   318: iconst_0
    //   319: istore 4
    //   321: invokestatic 416	android/os/SystemClock:uptimeMillis	()J
    //   324: lstore 6
    //   326: iload 4
    //   328: iconst_1
    //   329: iadd
    //   330: istore 5
    //   332: aload 9
    //   334: invokeinterface 161 1 0
    //   339: iload 5
    //   341: if_icmplt +121 -> 462
    //   344: iload 5
    //   346: iconst_1
    //   347: isub
    //   348: istore 4
    //   350: new 45	java/net/URL
    //   353: dup
    //   354: ldc_w 418
    //   357: aload 9
    //   359: iload 4
    //   361: invokeinterface 419 2 0
    //   366: checkcast 126	java/lang/String
    //   369: aload 11
    //   371: invokevirtual 57	java/net/URL:getFile	()Ljava/lang/String;
    //   374: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   377: astore 8
    //   379: aload 8
    //   381: ifnonnull +116 -> 497
    //   384: iload 5
    //   386: iconst_2
    //   387: if_icmple +326 -> 713
    //   390: aload_0
    //   391: aload_2
    //   392: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   395: iconst_0
    //   396: ldc2_w 420
    //   399: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   402: aconst_null
    //   403: areturn
    //   404: astore_1
    //   405: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +32 -> 440
    //   411: ldc 19
    //   413: iconst_2
    //   414: new 117	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 423
    //   424: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 426	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_3
    //   441: bipush 13
    //   443: invokeinterface 387 2 0
    //   448: aload_0
    //   449: aload_2
    //   450: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   453: iconst_0
    //   454: ldc2_w 427
    //   457: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   460: aconst_null
    //   461: areturn
    //   462: aload 9
    //   464: invokeinterface 161 1 0
    //   469: iconst_1
    //   470: isub
    //   471: istore 4
    //   473: goto -123 -> 350
    //   476: astore 8
    //   478: ldc 19
    //   480: iconst_1
    //   481: aload 8
    //   483: invokevirtual 426	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   486: aload 8
    //   488: invokestatic 432	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   491: aconst_null
    //   492: astore 8
    //   494: goto -115 -> 379
    //   497: aload_2
    //   498: aload 8
    //   500: invokevirtual 433	java/net/URL:toString	()Ljava/lang/String;
    //   503: putfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   506: new 435	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener
    //   509: dup
    //   510: aload_0
    //   511: aload_1
    //   512: aload_3
    //   513: aload_2
    //   514: invokespecial 438	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener:<init>	(Lcom/tencent/mobileqq/transfile/NearbyImgDownloader;Lcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;Lcom/tencent/image/DownloadParams;)V
    //   517: astore 8
    //   519: aload_2
    //   520: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   523: aload 8
    //   525: aload 10
    //   527: iconst_1
    //   528: iconst_0
    //   529: sipush 10000
    //   532: sipush 20000
    //   535: invokestatic 444	com/tencent/mobileqq/utils/HttpDownloadUtil:queryDownloadInfo	(Ljava/lang/String;Lbfvl;Ljava/util/List;IZII)Lardx;
    //   538: astore 8
    //   540: aload 8
    //   542: getfield 448	ardx:b	I
    //   545: ifne +32 -> 577
    //   548: aload_3
    //   549: aload 8
    //   551: getfield 451	ardx:e	I
    //   554: i2l
    //   555: invokeinterface 382 3 0
    //   560: aload_0
    //   561: aload_2
    //   562: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   565: iconst_1
    //   566: aload 8
    //   568: getfield 451	ardx:e	I
    //   571: i2l
    //   572: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   575: aconst_null
    //   576: areturn
    //   577: invokestatic 416	android/os/SystemClock:uptimeMillis	()J
    //   580: lload 6
    //   582: lsub
    //   583: ldc2_w 452
    //   586: lcmp
    //   587: iflt +62 -> 649
    //   590: ldc 19
    //   592: iconst_1
    //   593: new 117	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 455
    //   603: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokestatic 416	android/os/SystemClock:uptimeMillis	()J
    //   609: lload 6
    //   611: lsub
    //   612: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   615: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: aload_3
    //   622: aload 8
    //   624: getfield 448	ardx:b	I
    //   627: invokeinterface 387 2 0
    //   632: aload_0
    //   633: aload_2
    //   634: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   637: iconst_0
    //   638: aload 8
    //   640: getfield 448	ardx:b	I
    //   643: i2l
    //   644: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   647: aconst_null
    //   648: areturn
    //   649: iload 5
    //   651: iconst_2
    //   652: if_icmpne +31 -> 683
    //   655: aload_3
    //   656: aload 8
    //   658: getfield 448	ardx:b	I
    //   661: invokeinterface 387 2 0
    //   666: aload_0
    //   667: aload_2
    //   668: getfield 338	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   671: iconst_0
    //   672: aload 8
    //   674: getfield 448	ardx:b	I
    //   677: i2l
    //   678: invokespecial 384	com/tencent/mobileqq/transfile/NearbyImgDownloader:logDownloadEnd	(Ljava/lang/String;ZJ)V
    //   681: aconst_null
    //   682: areturn
    //   683: iload 5
    //   685: iconst_1
    //   686: if_icmpne -302 -> 384
    //   689: invokestatic 92	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   692: aload 12
    //   694: aload 11
    //   696: invokevirtual 400	java/net/URL:getHost	()Ljava/lang/String;
    //   699: sipush 1001
    //   702: invokevirtual 459	com/tencent/mobileqq/transfile/dns/InnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   705: goto -321 -> 384
    //   708: astore 10
    //   710: goto -537 -> 173
    //   713: iload 5
    //   715: istore 4
    //   717: goto -391 -> 326
    //   720: goto -623 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	NearbyImgDownloader
    //   0	723	1	paramEditor	DiskCache.Editor
    //   0	723	2	paramDownloadParams	DownloadParams
    //   0	723	3	paramURLDrawableHandler	URLDrawableHandler
    //   95	621	4	i	int
    //   330	384	5	j	int
    //   324	286	6	l	long
    //   58	322	8	localObject1	Object
    //   476	11	8	localMalformedURLException	java.net.MalformedURLException
    //   492	181	8	localObject2	Object
    //   92	371	9	localObject3	Object
    //   263	263	10	localArrayList	ArrayList
    //   708	1	10	localInterruptedException	java.lang.InterruptedException
    //   276	419	11	localURL	URL
    //   283	410	12	str	String
    // Exception table:
    //   from	to	target	type
    //   76	94	206	java/io/FileNotFoundException
    //   97	138	206	java/io/FileNotFoundException
    //   146	165	206	java/io/FileNotFoundException
    //   167	173	206	java/io/FileNotFoundException
    //   265	318	404	java/net/MalformedURLException
    //   350	379	476	java/net/MalformedURLException
    //   167	173	708	java/lang/InterruptedException
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
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "loadImageFile file exist: " + ((File)localObject).getAbsolutePath());
      }
      return localObject;
    }
    localObject = getFileName(str);
    localObject = InitUrlDrawable.a.edit((String)localObject);
    try
    {
      downloadImage((DiskCache.Editor)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = getFile(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "loadImageFile f exist:" + paramDownloadParams.getAbsolutePath());
        }
        ((DiskCache.Editor)localObject).dirtyFile.delete();
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((DiskCache.Editor)localObject).abort(false);
      }
      throw paramDownloadParams;
    }
    paramDownloadParams = ((DiskCache.Editor)localObject).commit();
    return paramDownloadParams;
  }
  
  public boolean useDiskCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader
 * JD-Core Version:    0.7.0.1
 */