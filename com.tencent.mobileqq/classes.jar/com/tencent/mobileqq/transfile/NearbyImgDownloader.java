package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.LooperGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;

public class NearbyImgDownloader
  extends AbsDownloader
{
  public static URL a(String paramString)
  {
    paramString = new URL(paramString);
    return new URL("nearbyimage", paramString.getAuthority(), paramString.getFile());
  }
  
  public static URL a(URL paramURL)
  {
    Object localObject = paramURL;
    String str;
    boolean bool;
    if (paramURL != null)
    {
      long l = SystemClock.elapsedRealtime();
      str = paramURL.getHost();
      localObject = InnerDns.a().a(str, 1001);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("convertURL urlStr: ").append(paramURL.toString()).append(" kenny convert cost: ").append(SystemClock.elapsedRealtime() - l).append(" ok: ");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label187;
        }
        bool = true;
        QLog.i("NearbyImgDownloader", 2, bool);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label442;
      }
      if (!"p.qpic.cn".equals(str)) {
        break label192;
      }
      localObject = PicIPManager.a(2);
    }
    label442:
    for (;;)
    {
      label124:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        localObject = new URL("http", (String)localObject, paramURL.getFile());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "convertURL urlStr end: " + ((URL)localObject).toString());
        }
        return localObject;
        label187:
        bool = false;
        break;
        label192:
        if ("p.qlogo.cn".equals(str))
        {
          localObject = PicIPManager.a(1);
          break label124;
        }
        if ("ugc.qpic.cn".equals(str))
        {
          localObject = PicIPManager.b(8);
          break label124;
        }
        if (b(str))
        {
          localObject = PicIPManager.a(0);
          break label124;
        }
        if ("i.gtimg.cn".equals(str))
        {
          localObject = PicIPManager.b();
          break label124;
        }
        if ("imgcache.qq.com".equals(str))
        {
          localObject = PicIPManager.a();
          break label124;
        }
        if (c(str))
        {
          localObject = PicIPManager.b(9);
          break label124;
        }
        if (d(str))
        {
          localObject = PicIPManager.b(11);
          break label124;
        }
        if (e(str))
        {
          localObject = PicIPManager.b(10);
          break label124;
        }
        if ("pgdt.gtimg.cn".equals(str))
        {
          localObject = PicIPManager.a(3);
          break label124;
        }
        if ("sqimg.qq.com".equals(str))
        {
          localObject = PicIPManager.a(4);
          break label124;
        }
        if ("download.wegame.qq.com".equals(str))
        {
          localObject = PicIPManager.a(5);
          break label124;
        }
        if ("wfqqreader.3g.qq.com".equals(str))
        {
          localObject = PicIPManager.a(6);
          break label124;
        }
        if (!"buluo.qq.com".equals(str)) {
          break label442;
        }
        localObject = PicIPManager.a(7);
        break label124;
        localObject = str;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyImgDownloader", 2, "download img start url: " + paramString + " time: " + SystemClock.elapsedRealtime());
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
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
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 163	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 164
    //   7: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 13
    //   12: ldc 164
    //   14: newarray byte
    //   16: astore 14
    //   18: new 169	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: getfield 174	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 4
    //   33: lconst_0
    //   34: lstore 8
    //   36: aload 4
    //   38: astore_1
    //   39: aload 13
    //   41: aload 14
    //   43: invokevirtual 183	java/io/InputStream:read	([B)I
    //   46: istore 6
    //   48: iload 6
    //   50: iconst_m1
    //   51: if_icmpeq +151 -> 202
    //   54: aload 4
    //   56: astore_1
    //   57: aload 4
    //   59: aload 14
    //   61: iconst_0
    //   62: iload 6
    //   64: invokevirtual 187	java/io/FileOutputStream:write	([BII)V
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
    //   84: ldc 188
    //   86: fmul
    //   87: f2i
    //   88: istore 7
    //   90: aload 4
    //   92: astore_1
    //   93: aload 5
    //   95: iload 7
    //   97: invokeinterface 194 2 0
    //   102: lload 10
    //   104: lstore 8
    //   106: aload 4
    //   108: astore_1
    //   109: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -76 -> 36
    //   115: aload 4
    //   117: astore_1
    //   118: ldc 79
    //   120: iconst_2
    //   121: new 54	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   128: ldc 196
    //   130: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 7
    //   135: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 201
    //   140: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 6
    //   145: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: lload 10
    //   156: lstore 8
    //   158: goto -122 -> 36
    //   161: astore 5
    //   163: aload 4
    //   165: astore_1
    //   166: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +17 -> 186
    //   172: aload 4
    //   174: astore_1
    //   175: ldc 79
    //   177: iconst_2
    //   178: aload 5
    //   180: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 153	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iconst_0
    //   187: istore 12
    //   189: aload 13
    //   191: invokevirtual 205	java/io/InputStream:close	()V
    //   194: aload 4
    //   196: invokevirtual 206	java/io/FileOutputStream:close	()V
    //   199: iload 12
    //   201: ireturn
    //   202: aload 4
    //   204: astore_1
    //   205: aload 4
    //   207: invokevirtual 209	java/io/FileOutputStream:flush	()V
    //   210: iconst_1
    //   211: istore 12
    //   213: aload 13
    //   215: invokevirtual 205	java/io/InputStream:close	()V
    //   218: aload 4
    //   220: invokevirtual 206	java/io/FileOutputStream:close	()V
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_1
    //   226: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -30 -> 199
    //   232: ldc 79
    //   234: iconst_2
    //   235: aload_1
    //   236: invokevirtual 210	java/lang/Exception:toString	()Ljava/lang/String;
    //   239: invokestatic 153	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_1
    //   245: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -49 -> 199
    //   251: ldc 79
    //   253: iconst_2
    //   254: aload_1
    //   255: invokevirtual 210	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokestatic 153	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_1
    //   267: aload 13
    //   269: invokevirtual 205	java/io/InputStream:close	()V
    //   272: aload_1
    //   273: invokevirtual 206	java/io/FileOutputStream:close	()V
    //   276: aload 4
    //   278: athrow
    //   279: astore_1
    //   280: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq -7 -> 276
    //   286: ldc 79
    //   288: iconst_2
    //   289: aload_1
    //   290: invokevirtual 210	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokestatic 153	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: goto -20 -> 276
    //   299: astore 4
    //   301: goto -34 -> 267
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: goto -146 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	NearbyImgDownloader
    //   0	312	1	paramInputStream	java.io.InputStream
    //   0	312	2	paramLong	long
    //   0	312	4	paramEditor	DiskCache.Editor
    //   0	312	5	paramURLDrawableHandler	URLDrawableHandler
    //   46	98	6	i	int
    //   88	46	7	j	int
    //   34	123	8	l1	long
    //   73	82	10	l2	long
    //   187	25	12	bool	boolean
    //   10	258	13	localBufferedInputStream	java.io.BufferedInputStream
    //   16	44	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	48	161	java/io/IOException
    //   57	67	161	java/io/IOException
    //   78	90	161	java/io/IOException
    //   93	102	161	java/io/IOException
    //   109	115	161	java/io/IOException
    //   118	154	161	java/io/IOException
    //   205	210	161	java/io/IOException
    //   213	223	225	java/lang/Exception
    //   189	199	244	java/lang/Exception
    //   12	33	263	finally
    //   267	276	279	java/lang/Exception
    //   39	48	299	finally
    //   57	67	299	finally
    //   78	90	299	finally
    //   93	102	299	finally
    //   109	115	299	finally
    //   118	154	299	finally
    //   166	172	299	finally
    //   175	186	299	finally
    //   205	210	299	finally
    //   12	33	304	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^q\\d?.qlogo.cn$").matcher(paramString).find();
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("a[0-9].qpic.cn").matcher(paramString).find();
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzs.qq.com").matcher(paramString).find();
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzonestyle.gtimg.cn").matcher(paramString).find();
  }
  
  /* Error */
  public File a(DiskCache.Editor paramEditor, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   5: invokespecial 248	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: invokeinterface 251 1 0
    //   14: aload_2
    //   15: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   18: ldc 253
    //   20: invokevirtual 256	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +222 -> 245
    //   26: aload_2
    //   27: aload_2
    //   28: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   31: ldc 253
    //   33: ldc_w 258
    //   36: invokevirtual 262	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: putfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   42: new 264	java/io/File
    //   45: dup
    //   46: aload_2
    //   47: getfield 268	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   50: invokevirtual 25	java/net/URL:getFile	()Ljava/lang/String;
    //   53: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 6
    //   58: aload 6
    //   60: invokevirtual 272	java/io/File:exists	()Z
    //   63: ifeq +161 -> 224
    //   66: aload 6
    //   68: invokevirtual 275	java/io/File:isFile	()Z
    //   71: ifeq +153 -> 224
    //   74: new 163	java/io/BufferedInputStream
    //   77: dup
    //   78: new 277	java/io/FileInputStream
    //   81: dup
    //   82: aload 6
    //   84: invokespecial 280	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 283	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore 7
    //   92: iconst_0
    //   93: istore 4
    //   95: aload_0
    //   96: aload 7
    //   98: aload 6
    //   100: invokevirtual 286	java/io/File:length	()J
    //   103: aload_1
    //   104: aload_3
    //   105: invokespecial 157	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/io/InputStream;JLcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;)Z
    //   108: ifeq +30 -> 138
    //   111: aload_3
    //   112: aload 6
    //   114: invokevirtual 286	java/io/File:length	()J
    //   117: invokeinterface 290 3 0
    //   122: aload_0
    //   123: aload_2
    //   124: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   127: iconst_1
    //   128: aload 6
    //   130: invokevirtual 286	java/io/File:length	()J
    //   133: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   136: aconst_null
    //   137: areturn
    //   138: iload 4
    //   140: iconst_4
    //   141: if_icmpne +24 -> 165
    //   144: aload_3
    //   145: iconst_4
    //   146: invokeinterface 295 2 0
    //   151: aload_0
    //   152: aload_2
    //   153: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   156: iconst_0
    //   157: ldc2_w 296
    //   160: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   163: aconst_null
    //   164: areturn
    //   165: ldc2_w 298
    //   168: invokestatic 304	java/lang/Thread:sleep	(J)V
    //   171: iload 4
    //   173: iconst_1
    //   174: iadd
    //   175: istore 4
    //   177: iload 4
    //   179: iconst_4
    //   180: if_icmple +440 -> 620
    //   183: aload_3
    //   184: iconst_4
    //   185: invokeinterface 295 2 0
    //   190: aload_0
    //   191: aload_2
    //   192: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   195: iconst_0
    //   196: ldc2_w 296
    //   199: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_1
    //   205: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -25 -> 183
    //   211: ldc 79
    //   213: iconst_2
    //   214: aload_1
    //   215: invokevirtual 305	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   218: invokestatic 153	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto -38 -> 183
    //   224: aload_3
    //   225: iconst_4
    //   226: invokeinterface 295 2 0
    //   231: aload_0
    //   232: aload_2
    //   233: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   236: iconst_0
    //   237: ldc2_w 296
    //   240: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   243: aconst_null
    //   244: areturn
    //   245: new 307	java/util/ArrayList
    //   248: dup
    //   249: invokespecial 308	java/util/ArrayList:<init>	()V
    //   252: astore 9
    //   254: new 13	java/net/URL
    //   257: dup
    //   258: aload_2
    //   259: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   262: invokespecial 16	java/net/URL:<init>	(Ljava/lang/String;)V
    //   265: astore 6
    //   267: aload 6
    //   269: invokevirtual 38	java/net/URL:getHost	()Ljava/lang/String;
    //   272: astore 10
    //   274: aload 9
    //   276: new 310	org/apache/http/message/BasicHeader
    //   279: dup
    //   280: ldc_w 312
    //   283: aload 10
    //   285: invokespecial 315	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: invokeinterface 320 2 0
    //   293: pop
    //   294: aload 6
    //   296: invokestatic 322	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/net/URL;)Ljava/net/URL;
    //   299: astore 6
    //   301: aload_2
    //   302: aload 6
    //   304: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   307: putfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   310: iconst_0
    //   311: istore 4
    //   313: iload 4
    //   315: iconst_1
    //   316: iadd
    //   317: istore 5
    //   319: new 324	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener
    //   322: dup
    //   323: aload_0
    //   324: aload_1
    //   325: aload_3
    //   326: aload_2
    //   327: invokespecial 327	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener:<init>	(Lcom/tencent/mobileqq/transfile/NearbyImgDownloader;Lcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;Lcom/tencent/image/DownloadParams;)V
    //   330: astore 7
    //   332: aload_2
    //   333: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   336: aload 7
    //   338: aload 9
    //   340: iconst_3
    //   341: iconst_0
    //   342: invokestatic 332	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZ)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   345: astore 7
    //   347: aload 7
    //   349: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   352: ifne +90 -> 442
    //   355: aload_3
    //   356: aload 7
    //   358: getfield 339	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   361: i2l
    //   362: invokeinterface 290 3 0
    //   367: aload_0
    //   368: aload_2
    //   369: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   372: iconst_1
    //   373: aload 7
    //   375: getfield 339	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   378: i2l
    //   379: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   382: aconst_null
    //   383: areturn
    //   384: astore_1
    //   385: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +32 -> 420
    //   391: ldc 79
    //   393: iconst_2
    //   394: new 54	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 341
    //   404: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_1
    //   408: invokevirtual 344	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   411: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_3
    //   421: bipush 13
    //   423: invokeinterface 295 2 0
    //   428: aload_0
    //   429: aload_2
    //   430: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   433: iconst_0
    //   434: ldc2_w 345
    //   437: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   440: aconst_null
    //   441: areturn
    //   442: iload 5
    //   444: iconst_2
    //   445: if_icmpne +31 -> 476
    //   448: aload_3
    //   449: aload 7
    //   451: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   454: invokeinterface 295 2 0
    //   459: aload_0
    //   460: aload_2
    //   461: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   464: iconst_0
    //   465: aload 7
    //   467: getfield 337	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   470: i2l
    //   471: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   474: aconst_null
    //   475: areturn
    //   476: aload 6
    //   478: astore 7
    //   480: iload 5
    //   482: iconst_1
    //   483: if_icmpne +46 -> 529
    //   486: invokestatic 43	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   489: aload 10
    //   491: aload 6
    //   493: invokevirtual 38	java/net/URL:getHost	()Ljava/lang/String;
    //   496: sipush 1001
    //   499: invokevirtual 349	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   502: new 13	java/net/URL
    //   505: dup
    //   506: ldc 102
    //   508: aload 10
    //   510: aload 6
    //   512: invokevirtual 25	java/net/URL:getFile	()Ljava/lang/String;
    //   515: invokespecial 28	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   518: astore 7
    //   520: aload_2
    //   521: aload 7
    //   523: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   526: putfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   529: iload 5
    //   531: istore 4
    //   533: aload 7
    //   535: astore 6
    //   537: iload 5
    //   539: iconst_2
    //   540: if_icmple -227 -> 313
    //   543: aload_0
    //   544: aload_2
    //   545: getfield 246	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   548: iconst_0
    //   549: ldc2_w 350
    //   552: invokespecial 292	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   555: aconst_null
    //   556: areturn
    //   557: astore 7
    //   559: aload 7
    //   561: astore 8
    //   563: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +33 -> 599
    //   569: ldc 79
    //   571: iconst_2
    //   572: new 54	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 353
    //   582: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 8
    //   587: invokevirtual 344	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   590: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload 6
    //   601: astore 7
    //   603: goto -74 -> 529
    //   606: astore 8
    //   608: goto -437 -> 171
    //   611: astore 8
    //   613: aload 7
    //   615: astore 6
    //   617: goto -54 -> 563
    //   620: goto -525 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	NearbyImgDownloader
    //   0	623	1	paramEditor	DiskCache.Editor
    //   0	623	2	paramDownloadParams	DownloadParams
    //   0	623	3	paramURLDrawableHandler	URLDrawableHandler
    //   93	439	4	i	int
    //   317	224	5	j	int
    //   56	560	6	localObject1	Object
    //   90	444	7	localObject2	Object
    //   557	3	7	localMalformedURLException1	java.net.MalformedURLException
    //   601	13	7	localObject3	Object
    //   561	25	8	localMalformedURLException2	java.net.MalformedURLException
    //   606	1	8	localInterruptedException	java.lang.InterruptedException
    //   611	1	8	localMalformedURLException3	java.net.MalformedURLException
    //   252	87	9	localArrayList	java.util.ArrayList
    //   272	237	10	str	String
    // Exception table:
    //   from	to	target	type
    //   74	92	204	java/io/FileNotFoundException
    //   95	136	204	java/io/FileNotFoundException
    //   144	163	204	java/io/FileNotFoundException
    //   165	171	204	java/io/FileNotFoundException
    //   254	310	384	java/net/MalformedURLException
    //   502	520	557	java/net/MalformedURLException
    //   165	171	606	java/lang/InterruptedException
    //   520	529	611	java/net/MalformedURLException
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  public boolean a()
  {
    return true;
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
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    Object localObject = a(str);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "loadImageFile file exist: " + ((File)localObject).getAbsolutePath());
      }
      return localObject;
    }
    localObject = c(str);
    localObject = InitUrlDrawable.a.a((String)localObject);
    try
    {
      a((DiskCache.Editor)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = a(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "loadImageFile f exist:" + paramDownloadParams.getAbsolutePath());
        }
        ((DiskCache.Editor)localObject).a.delete();
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((DiskCache.Editor)localObject).a(false);
      }
      throw paramDownloadParams;
    }
    paramDownloadParams = ((DiskCache.Editor)localObject).a();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader
 * JD-Core Version:    0.7.0.1
 */