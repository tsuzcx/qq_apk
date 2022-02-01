package cooperation.qqcircle.picload;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.open.base.LogUtility;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.HttpsURLConnection;
import picload.ImageInfo;

public class QCircleHttpUrlDW
  extends AbsPicDW
{
  private static final String EXT_SDCARD_PATH = "/mnt/sdcard-ext";
  private static final long ONE_DAY = 86400000L;
  private static final int ONE_MINUTES = 60000;
  
  private static HttpURLConnection createHttpConnection(ImageInfo paramImageInfo, Option paramOption)
  {
    String str2 = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.jdField_b_of_type_JavaLangString);
    String str1 = QCircleCommonUtil.getUrlHost(str2);
    String str3 = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", str2, str1);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str3).openConnection();
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "after convert :origin:" + str2 + "\nconvert:" + str3 + "\nhost:" + str1);
    if (((localHttpURLConnection instanceof HttpsURLConnection)) && (!str3.equals(str2)))
    {
      paramOption = new QCircleHttpUrlDW.1(paramOption);
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(new SniSSLSocketFactory(str1, paramOption));
      ((HttpsURLConnection)localHttpURLConnection).setHostnameVerifier(paramOption);
    }
    localHttpURLConnection.setRequestProperty("Host", str1);
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setAllowUserInteraction(true);
    localHttpURLConnection.setConnectTimeout(60000);
    localHttpURLConnection.setReadTimeout(120000);
    if (paramImageInfo.jdField_c_of_type_Long > 0L)
    {
      paramOption = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      paramOption.setTimeZone(TimeZone.getTimeZone("GMT"));
      localHttpURLConnection.setRequestProperty("If-Modified-Since", paramOption.format(new Date(paramImageInfo.jdField_c_of_type_Long)));
    }
    return localHttpURLConnection;
  }
  
  private void dealException(File paramFile1, File paramFile2)
  {
    if ((paramFile1 != null) && (paramFile1.exists())) {
      paramFile1.delete();
    }
    if ((paramFile2 != null) && (paramFile2.exists())) {
      paramFile2.delete();
    }
  }
  
  protected static void disConnect(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      LogUtility.c("", "", paramHttpURLConnection);
    }
  }
  
  private void finallyRelease(FileOutputStream paramFileOutputStream, InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      if (paramInputStream != null) {
        paramInputStream.close();
      }
    }
    catch (Exception paramFileOutputStream)
    {
      for (;;)
      {
        paramFileOutputStream.printStackTrace();
      }
    }
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  protected static HttpURLConnection getHttpConnection(ImageInfo paramImageInfo, Option paramOption)
  {
    if ((paramImageInfo == null) || (paramOption == null)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = createHttpConnection(paramImageInfo, paramOption);
      }
      catch (Exception localException1)
      {
        int i;
        Object localObject1;
        Object localObject2 = null;
        continue;
      }
      try
      {
        i = ((HttpURLConnection)localObject2).getResponseCode();
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " reponseCode=" + i);
        if ((i != 302) && (i != 301)) {
          continue;
        }
        localObject1 = responseTemp((HttpURLConnection)localObject2, paramOption, paramImageInfo);
        try
        {
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " uc=" + localObject1);
          return localObject1;
        }
        catch (Exception localException3)
        {
          localObject2 = localObject1;
          localObject1 = localException3;
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " Exception!!!" + localObject1);
      disConnect((HttpURLConnection)localObject2);
      return null;
      if ((i == 200) || (i == 206))
      {
        localObject1 = responseSuccess((HttpURLConnection)localObject2, paramOption, paramImageInfo);
      }
      else if (i == 304)
      {
        localObject1 = responseModified((HttpURLConnection)localObject2, paramOption, paramImageInfo);
      }
      else
      {
        disConnect((HttpURLConnection)localObject2);
        localObject1 = null;
      }
    }
  }
  
  protected static long getMaxAge(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (paramHttpURLConnection == null) {
      return 0L;
    }
    paramHttpURLConnection = TextUtils.split(paramHttpURLConnection, ",");
    int i = 0;
    if (i < paramHttpURLConnection.length) {
      if (!paramHttpURLConnection[i].contains("max-age")) {}
    }
    for (long l = Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));; l = 0L)
    {
      return l;
      i += 1;
      break;
    }
  }
  
  public static long getSDCardAvailableCount()
  {
    StatFs localStatFs = new StatFs(getSDCardPath());
    long l = localStatFs.getAvailableBlocks();
    return localStatFs.getBlockSize() * l;
  }
  
  public static String getSDCardPath()
  {
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState())) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      if (new File("/mnt/sdcard-ext").isDirectory()) {
        return "/mnt/sdcard-ext";
      }
    }
    catch (Exception localException)
    {
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "getSDCardPath() failed");
    }
    return ".";
  }
  
  private static HttpURLConnection responseModified(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " --getimg-- " + paramImageInfo.jdField_b_of_type_JavaLangString + " not modified");
    paramImageInfo.jdField_a_of_type_Long = (((float)getMaxAge(paramHttpURLConnection) * 1000.0F));
    paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  private static HttpURLConnection responseSuccess(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    String str = paramHttpURLConnection.getContentType();
    if (str == null)
    {
      str = "";
      if ((!str.contains("text/vnd.wap.wml")) && (!str.contains("application/vnd.wap.wmlc")) && (!str.contains("text"))) {
        break label171;
      }
    }
    label171:
    for (int i = 1;; i = 0)
    {
      HttpURLConnection localHttpURLConnection = paramHttpURLConnection;
      if (i != 0)
      {
        disConnect(paramHttpURLConnection);
        localHttpURLConnection = null;
      }
      if (localHttpURLConnection != null)
      {
        paramImageInfo.jdField_a_of_type_Long = (getMaxAge(localHttpURLConnection) * 1000L);
        if (paramImageInfo.jdField_a_of_type_Long == 0L) {
          paramImageInfo.jdField_a_of_type_Long = 86400000L;
        }
      }
      paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " contentType=" + str);
      return localHttpURLConnection;
      str = str.toLowerCase();
      break;
    }
  }
  
  private static HttpURLConnection responseTemp(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    String str = paramHttpURLConnection.getHeaderField("Location");
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + paramImageInfo.jdField_a_of_type_JavaLangString + " loc=" + str);
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  /* Error */
  public boolean downloadByHttpURl(ImageInfo paramImageInfo, Option paramOption)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 13
    //   12: aload_1
    //   13: aload_2
    //   14: invokestatic 378	cooperation/qqcircle/picload/QCircleHttpUrlDW:getHttpConnection	(Lpicload/ImageInfo;Lcom/tencent/mobileqq/qcircle/api/data/Option;)Ljava/net/HttpURLConnection;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +75 -> 96
    //   24: ldc 62
    //   26: getstatic 67	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   29: new 69	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   36: ldc 72
    //   38: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual 82	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   45: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 380
    //   51: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 382
    //   64: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 384
    //   77: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_0
    //   87: aconst_null
    //   88: aconst_null
    //   89: aload 6
    //   91: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 6
    //   98: invokevirtual 389	java/net/HttpURLConnection:getContentLength	()I
    //   101: i2l
    //   102: lstore 4
    //   104: invokestatic 391	cooperation/qqcircle/picload/QCircleHttpUrlDW:getSDCardAvailableCount	()J
    //   107: lload 4
    //   109: lcmp
    //   110: ifge +75 -> 185
    //   113: ldc 62
    //   115: getstatic 67	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   118: new 69	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   125: ldc 72
    //   127: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: invokevirtual 82	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   134: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc_w 393
    //   140: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 382
    //   153: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   160: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 395
    //   166: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_0
    //   176: aconst_null
    //   177: aconst_null
    //   178: aload 6
    //   180: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: aload 6
    //   187: invokevirtual 399	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   190: astore 7
    //   192: aload 15
    //   194: astore 12
    //   196: aload 7
    //   198: astore 10
    //   200: aload 6
    //   202: astore 9
    //   204: aload_1
    //   205: getfield 401	picload/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   208: astore 16
    //   210: aload 15
    //   212: astore 12
    //   214: aload 7
    //   216: astore 10
    //   218: aload 6
    //   220: astore 9
    //   222: new 198	java/io/File
    //   225: dup
    //   226: new 69	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   233: aload 16
    //   235: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 403
    //   241: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore 11
    //   252: aload 15
    //   254: astore 12
    //   256: aload 7
    //   258: astore 10
    //   260: aload 6
    //   262: astore 9
    //   264: aload 11
    //   266: invokevirtual 406	java/io/File:getParent	()Ljava/lang/String;
    //   269: ifnull +47 -> 316
    //   272: aload 15
    //   274: astore 12
    //   276: aload 7
    //   278: astore 10
    //   280: aload 6
    //   282: astore 9
    //   284: aload 11
    //   286: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   289: invokevirtual 202	java/io/File:exists	()Z
    //   292: ifne +24 -> 316
    //   295: aload 15
    //   297: astore 12
    //   299: aload 7
    //   301: astore 10
    //   303: aload 6
    //   305: astore 9
    //   307: aload 11
    //   309: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   312: invokevirtual 412	java/io/File:mkdirs	()Z
    //   315: pop
    //   316: aload 15
    //   318: astore 12
    //   320: aload 7
    //   322: astore 10
    //   324: aload 6
    //   326: astore 9
    //   328: aload 11
    //   330: invokevirtual 202	java/io/File:exists	()Z
    //   333: ifeq +21 -> 354
    //   336: aload 15
    //   338: astore 12
    //   340: aload 7
    //   342: astore 10
    //   344: aload 6
    //   346: astore 9
    //   348: aload 11
    //   350: invokevirtual 205	java/io/File:delete	()Z
    //   353: pop
    //   354: aload 15
    //   356: astore 12
    //   358: aload 7
    //   360: astore 10
    //   362: aload 6
    //   364: astore 9
    //   366: aload 11
    //   368: invokevirtual 415	java/io/File:createNewFile	()Z
    //   371: pop
    //   372: aload 15
    //   374: astore 12
    //   376: aload 7
    //   378: astore 10
    //   380: aload 6
    //   382: astore 9
    //   384: new 223	java/io/FileOutputStream
    //   387: dup
    //   388: new 69	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   395: aload 16
    //   397: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 403
    //   403: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: iconst_1
    //   410: invokespecial 418	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   413: astore 8
    //   415: sipush 8192
    //   418: newarray byte
    //   420: astore 9
    //   422: aload 7
    //   424: aload 9
    //   426: iconst_0
    //   427: sipush 8192
    //   430: invokevirtual 422	java/io/InputStream:read	([BII)I
    //   433: istore_3
    //   434: iload_3
    //   435: ifle +115 -> 550
    //   438: aload 8
    //   440: aload 9
    //   442: iconst_0
    //   443: iload_3
    //   444: invokevirtual 426	java/io/FileOutputStream:write	([BII)V
    //   447: goto -25 -> 422
    //   450: astore 12
    //   452: aload 11
    //   454: astore 10
    //   456: aload 8
    //   458: astore 9
    //   460: aload 6
    //   462: astore 8
    //   464: aload 9
    //   466: astore 6
    //   468: aload 13
    //   470: astore 11
    //   472: aload 12
    //   474: astore 9
    //   476: ldc 62
    //   478: getstatic 67	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   481: new 69	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   488: ldc 72
    //   490: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_2
    //   494: invokevirtual 82	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   497: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: ldc_w 428
    //   503: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_1
    //   507: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   510: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 430
    //   516: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 9
    //   521: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 433	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: aload_0
    //   531: aload 10
    //   533: aload 11
    //   535: invokespecial 435	cooperation/qqcircle/picload/QCircleHttpUrlDW:dealException	(Ljava/io/File;Ljava/io/File;)V
    //   538: aload_0
    //   539: aload 6
    //   541: aload 7
    //   543: aload 8
    //   545: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   548: iconst_0
    //   549: ireturn
    //   550: aload 8
    //   552: invokevirtual 438	java/io/FileOutputStream:flush	()V
    //   555: new 198	java/io/File
    //   558: dup
    //   559: aload 16
    //   561: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   564: astore 10
    //   566: aload 10
    //   568: invokevirtual 202	java/io/File:exists	()Z
    //   571: ifeq +9 -> 580
    //   574: aload 10
    //   576: invokevirtual 205	java/io/File:delete	()Z
    //   579: pop
    //   580: aload 11
    //   582: aload 10
    //   584: invokevirtual 442	java/io/File:renameTo	(Ljava/io/File;)Z
    //   587: pop
    //   588: ldc 62
    //   590: getstatic 67	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   593: new 69	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   600: ldc 72
    //   602: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_2
    //   606: invokevirtual 82	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   609: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: ldc_w 444
    //   615: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 382
    //   628: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_1
    //   632: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   635: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_1
    //   645: aload 6
    //   647: invokevirtual 447	java/net/HttpURLConnection:getLastModified	()J
    //   650: putfield 158	picload/ImageInfo:jdField_c_of_type_Long	J
    //   653: aload_0
    //   654: aload 8
    //   656: aload 7
    //   658: aload 6
    //   660: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   663: iconst_1
    //   664: ireturn
    //   665: astore 8
    //   667: aconst_null
    //   668: astore 7
    //   670: aconst_null
    //   671: astore 6
    //   673: aload 14
    //   675: astore 11
    //   677: aload 11
    //   679: astore 12
    //   681: aload 7
    //   683: astore 10
    //   685: aload 6
    //   687: astore 9
    //   689: ldc 62
    //   691: getstatic 67	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   694: new 69	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   701: ldc 72
    //   703: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_2
    //   707: invokevirtual 82	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   710: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 428
    //   716: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_1
    //   720: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   723: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 449
    //   729: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 8
    //   734: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 433	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: aload_0
    //   744: aload 11
    //   746: aload 7
    //   748: aload 6
    //   750: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   753: iconst_0
    //   754: ireturn
    //   755: astore_1
    //   756: aconst_null
    //   757: astore 7
    //   759: aconst_null
    //   760: astore 6
    //   762: aload 8
    //   764: astore_2
    //   765: aload_0
    //   766: aload_2
    //   767: aload 7
    //   769: aload 6
    //   771: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   774: aload_1
    //   775: athrow
    //   776: astore_1
    //   777: aconst_null
    //   778: astore 7
    //   780: aload 8
    //   782: astore_2
    //   783: goto -18 -> 765
    //   786: astore_1
    //   787: aload 12
    //   789: astore_2
    //   790: aload 10
    //   792: astore 7
    //   794: aload 9
    //   796: astore 6
    //   798: goto -33 -> 765
    //   801: astore_1
    //   802: aload 8
    //   804: astore_2
    //   805: goto -40 -> 765
    //   808: astore_1
    //   809: aload 6
    //   811: astore_2
    //   812: aload 8
    //   814: astore 6
    //   816: goto -51 -> 765
    //   819: astore 8
    //   821: aconst_null
    //   822: astore 7
    //   824: aload 14
    //   826: astore 11
    //   828: goto -151 -> 677
    //   831: astore 8
    //   833: aload 14
    //   835: astore 11
    //   837: goto -160 -> 677
    //   840: astore 9
    //   842: aload 8
    //   844: astore 11
    //   846: aload 9
    //   848: astore 8
    //   850: goto -173 -> 677
    //   853: astore 9
    //   855: aconst_null
    //   856: astore 10
    //   858: aconst_null
    //   859: astore 6
    //   861: aconst_null
    //   862: astore 7
    //   864: aconst_null
    //   865: astore 8
    //   867: aload 13
    //   869: astore 11
    //   871: goto -395 -> 476
    //   874: astore 9
    //   876: aconst_null
    //   877: astore 10
    //   879: aconst_null
    //   880: astore 12
    //   882: aconst_null
    //   883: astore 7
    //   885: aload 6
    //   887: astore 8
    //   889: aload 13
    //   891: astore 11
    //   893: aload 12
    //   895: astore 6
    //   897: goto -421 -> 476
    //   900: astore 9
    //   902: aconst_null
    //   903: astore 10
    //   905: aconst_null
    //   906: astore 12
    //   908: aload 6
    //   910: astore 8
    //   912: aload 13
    //   914: astore 11
    //   916: aload 12
    //   918: astore 6
    //   920: goto -444 -> 476
    //   923: astore 9
    //   925: aload 11
    //   927: astore 10
    //   929: aconst_null
    //   930: astore 12
    //   932: aload 6
    //   934: astore 8
    //   936: aload 13
    //   938: astore 11
    //   940: aload 12
    //   942: astore 6
    //   944: goto -468 -> 476
    //   947: astore 9
    //   949: aload 11
    //   951: astore 12
    //   953: aload 6
    //   955: astore 13
    //   957: aload 10
    //   959: astore 11
    //   961: aload 12
    //   963: astore 10
    //   965: aload 8
    //   967: astore 6
    //   969: aload 13
    //   971: astore 8
    //   973: goto -497 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	976	0	this	QCircleHttpUrlDW
    //   0	976	1	paramImageInfo	ImageInfo
    //   0	976	2	paramOption	Option
    //   433	11	3	i	int
    //   102	6	4	l	long
    //   17	951	6	localObject1	Object
    //   190	694	7	localObject2	Object
    //   4	651	8	localObject3	Object
    //   665	148	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   819	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   831	12	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   848	124	8	localObject4	Object
    //   202	593	9	localObject5	Object
    //   840	7	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   853	1	9	localException1	Exception
    //   874	1	9	localException2	Exception
    //   900	1	9	localException3	Exception
    //   923	1	9	localException4	Exception
    //   947	1	9	localException5	Exception
    //   198	766	10	localObject6	Object
    //   250	710	11	localObject7	Object
    //   194	181	12	localObject8	Object
    //   450	23	12	localException6	Exception
    //   679	283	12	localObject9	Object
    //   10	960	13	localObject10	Object
    //   1	833	14	localObject11	Object
    //   7	366	15	localObject12	Object
    //   208	352	16	str	String
    // Exception table:
    //   from	to	target	type
    //   415	422	450	java/lang/Exception
    //   422	434	450	java/lang/Exception
    //   438	447	450	java/lang/Exception
    //   550	566	450	java/lang/Exception
    //   12	19	665	java/lang/OutOfMemoryError
    //   12	19	755	finally
    //   24	86	776	finally
    //   96	175	776	finally
    //   185	192	776	finally
    //   204	210	786	finally
    //   222	252	786	finally
    //   264	272	786	finally
    //   284	295	786	finally
    //   307	316	786	finally
    //   328	336	786	finally
    //   348	354	786	finally
    //   366	372	786	finally
    //   384	415	786	finally
    //   689	743	786	finally
    //   415	422	801	finally
    //   422	434	801	finally
    //   438	447	801	finally
    //   550	566	801	finally
    //   566	580	801	finally
    //   580	653	801	finally
    //   476	538	808	finally
    //   24	86	819	java/lang/OutOfMemoryError
    //   96	175	819	java/lang/OutOfMemoryError
    //   185	192	819	java/lang/OutOfMemoryError
    //   204	210	831	java/lang/OutOfMemoryError
    //   222	252	831	java/lang/OutOfMemoryError
    //   264	272	831	java/lang/OutOfMemoryError
    //   284	295	831	java/lang/OutOfMemoryError
    //   307	316	831	java/lang/OutOfMemoryError
    //   328	336	831	java/lang/OutOfMemoryError
    //   348	354	831	java/lang/OutOfMemoryError
    //   366	372	831	java/lang/OutOfMemoryError
    //   384	415	831	java/lang/OutOfMemoryError
    //   415	422	840	java/lang/OutOfMemoryError
    //   422	434	840	java/lang/OutOfMemoryError
    //   438	447	840	java/lang/OutOfMemoryError
    //   550	566	840	java/lang/OutOfMemoryError
    //   566	580	840	java/lang/OutOfMemoryError
    //   580	653	840	java/lang/OutOfMemoryError
    //   12	19	853	java/lang/Exception
    //   24	86	874	java/lang/Exception
    //   96	175	874	java/lang/Exception
    //   185	192	874	java/lang/Exception
    //   204	210	900	java/lang/Exception
    //   222	252	900	java/lang/Exception
    //   264	272	923	java/lang/Exception
    //   284	295	923	java/lang/Exception
    //   307	316	923	java/lang/Exception
    //   328	336	923	java/lang/Exception
    //   348	354	923	java/lang/Exception
    //   366	372	923	java/lang/Exception
    //   384	415	923	java/lang/Exception
    //   566	580	947	java/lang/Exception
    //   580	653	947	java/lang/Exception
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.jdField_c_of_type_JavaLangString = paramOption.getLocalPath();
    localImageInfo.jdField_a_of_type_JavaLangString = paramOption.getCacheKey();
    localImageInfo.jdField_b_of_type_JavaLangString = paramOption.getUrl();
    if (downloadByHttpURl(localImageInfo, paramOption)) {
      paramICallBackListener.callBack(paramOption, true, 0);
    }
    while (getNextDw() == null) {
      return;
    }
    getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpUrlDW
 * JD-Core Version:    0.7.0.1
 */