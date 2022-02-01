package cooperation.qqcircle.picload;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.open.base.LogUtility;
import com.tencent.qcircle.cooperation.config.QCircleUrlUtil;
import com.tencent.qphone.base.util.QLog;
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

public class RFWHttpUrlDW
  extends RFWAbsPicDW
{
  private static final String EXT_SDCARD_PATH = "/mnt/sdcard-ext";
  private static final long ONE_DAY = 86400000L;
  private static final int ONE_MINUTES = 60000;
  
  private static HttpURLConnection createHttpConnection(RFWImageInfo paramRFWImageInfo, Option paramOption)
  {
    Object localObject = MsfSdkUtils.insertMtype("yingyongbao", paramRFWImageInfo.url);
    String str1 = QCircleUrlUtil.a((String)localObject);
    String str2 = QCircleUrlUtil.a("PhotoSvrList", "DownloadPhotoHttps", (String)localObject, str1);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str2).openConnection();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("after convert :origin:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\nconvert:");
    localStringBuilder.append(str2);
    localStringBuilder.append("\nhost:");
    localStringBuilder.append(str1);
    QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
    if (((localHttpURLConnection instanceof HttpsURLConnection)) && (!str2.equals(localObject)))
    {
      paramOption = new RFWHttpUrlDW.1(paramOption);
      localObject = (HttpsURLConnection)localHttpURLConnection;
      ((HttpsURLConnection)localObject).setSSLSocketFactory(new SniSSLSocketFactory(str1, paramOption));
      ((HttpsURLConnection)localObject).setHostnameVerifier(paramOption);
    }
    localHttpURLConnection.setRequestProperty("Host", str1);
    localHttpURLConnection.setRequestMethod("GET");
    localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setAllowUserInteraction(true);
    localHttpURLConnection.setConnectTimeout(60000);
    localHttpURLConnection.setReadTimeout(120000);
    if (paramRFWImageInfo.modified > 0L)
    {
      paramOption = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      paramOption.setTimeZone(TimeZone.getTimeZone("GMT"));
      localHttpURLConnection.setRequestProperty("If-Modified-Since", paramOption.format(new Date(paramRFWImageInfo.modified)));
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
    if (paramHttpURLConnection != null) {
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
  }
  
  private void finallyRelease(FileOutputStream paramFileOutputStream, InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      if (paramInputStream == null) {
        break label26;
      }
      paramInputStream.close();
    }
    catch (Exception paramFileOutputStream)
    {
      label22:
      break label22;
    }
    paramFileOutputStream.printStackTrace();
    label26:
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  protected static HttpURLConnection getHttpConnection(RFWImageInfo paramRFWImageInfo, Option paramOption)
  {
    if (paramRFWImageInfo != null) {
      if (paramOption == null) {
        return null;
      }
    }
    for (;;)
    {
      HttpURLConnection localHttpURLConnection2;
      int i;
      StringBuilder localStringBuilder;
      try
      {
        HttpURLConnection localHttpURLConnection1 = createHttpConnection(paramRFWImageInfo, paramOption);
        localHttpURLConnection2 = localHttpURLConnection1;
        try
        {
          i = localHttpURLConnection1.getResponseCode();
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder = new StringBuilder();
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("seq = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramOption.getSeq());
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("--getHttpConnection-- cacheKey = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramRFWImageInfo.key);
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(" reponseCode=");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(i);
          localHttpURLConnection2 = localHttpURLConnection1;
          QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
          if (i != 302)
          {
            if (i != 301) {
              break label376;
            }
            continue;
            if (i == 304)
            {
              localHttpURLConnection2 = localHttpURLConnection1;
              localHttpURLConnection1 = responseModified(localHttpURLConnection1, paramOption, paramRFWImageInfo);
              continue;
            }
            localHttpURLConnection2 = localHttpURLConnection1;
            disConnect(localHttpURLConnection1);
            localHttpURLConnection1 = null;
            continue;
            localHttpURLConnection2 = localHttpURLConnection1;
            localHttpURLConnection1 = responseSuccess(localHttpURLConnection1, paramOption, paramRFWImageInfo);
            continue;
          }
          localHttpURLConnection2 = localHttpURLConnection1;
          localHttpURLConnection1 = responseTemp(localHttpURLConnection1, paramOption, paramRFWImageInfo);
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder = new StringBuilder();
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("seq = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramOption.getSeq());
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("--getHttpConnection-- cacheKey = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramRFWImageInfo.key);
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(" uc=");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(localHttpURLConnection1);
          localHttpURLConnection2 = localHttpURLConnection1;
          QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
          return localHttpURLConnection1;
        }
        catch (Exception localException1) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Exception localException2)
      {
        localHttpURLConnection2 = null;
      }
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("--getHttpConnection-- cacheKey = ");
      localStringBuilder.append(paramRFWImageInfo.key);
      localStringBuilder.append(" Exception!!!");
      localStringBuilder.append(localException2);
      QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
      disConnect(localHttpURLConnection2);
      return null;
      label376:
      if (i != 200) {
        if (i != 206) {}
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
    while (i < paramHttpURLConnection.length)
    {
      if (paramHttpURLConnection[i].contains("max-age")) {
        return Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));
      }
      i += 1;
    }
    return 0L;
  }
  
  public static long getSDCardAvailableCount()
  {
    StatFs localStatFs = new StatFs(getSDCardPath());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  public static String getSDCardPath()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      if (bool) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      bool = new File("/mnt/sdcard-ext").isDirectory();
      if (!bool) {
        break label50;
      }
      return "/mnt/sdcard-ext";
    }
    catch (Exception localException)
    {
      label41:
      label50:
      break label41;
    }
    QLog.i("QCircleFeedPicLoader", 1, "getSDCardPath() failed");
    return ".";
  }
  
  private static HttpURLConnection responseModified(HttpURLConnection paramHttpURLConnection, Option paramOption, RFWImageInfo paramRFWImageInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("--getHttpConnection-- cacheKey = ");
    localStringBuilder.append(paramRFWImageInfo.key);
    localStringBuilder.append(" --getimg-- ");
    localStringBuilder.append(paramRFWImageInfo.url);
    localStringBuilder.append(" not modified");
    QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
    paramRFWImageInfo.maxage = (((float)getMaxAge(paramHttpURLConnection) * 1000.0F));
    paramRFWImageInfo.updatetime = System.currentTimeMillis();
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  private static HttpURLConnection responseSuccess(HttpURLConnection paramHttpURLConnection, Option paramOption, RFWImageInfo paramRFWImageInfo)
  {
    String str = paramHttpURLConnection.getContentType();
    if (str == null) {
      str = "";
    } else {
      str = str.toLowerCase();
    }
    int i;
    if ((!str.contains("text/vnd.wap.wml")) && (!str.contains("application/vnd.wap.wmlc")) && (!str.contains("text"))) {
      i = 0;
    } else {
      i = 1;
    }
    HttpURLConnection localHttpURLConnection = paramHttpURLConnection;
    if (i != 0)
    {
      disConnect(paramHttpURLConnection);
      localHttpURLConnection = null;
    }
    if (localHttpURLConnection != null)
    {
      paramRFWImageInfo.maxage = (getMaxAge(localHttpURLConnection) * 1000L);
      if (paramRFWImageInfo.maxage == 0L) {
        paramRFWImageInfo.maxage = 86400000L;
      }
    }
    paramRFWImageInfo.updatetime = System.currentTimeMillis();
    paramHttpURLConnection = new StringBuilder();
    paramHttpURLConnection.append("seq = ");
    paramHttpURLConnection.append(paramOption.getSeq());
    paramHttpURLConnection.append("--getHttpConnection-- cacheKey = ");
    paramHttpURLConnection.append(paramRFWImageInfo.key);
    paramHttpURLConnection.append(" contentType=");
    paramHttpURLConnection.append(str);
    QLog.i("QCircleFeedPicLoader", 1, paramHttpURLConnection.toString());
    return localHttpURLConnection;
  }
  
  private static HttpURLConnection responseTemp(HttpURLConnection paramHttpURLConnection, Option paramOption, RFWImageInfo paramRFWImageInfo)
  {
    String str = paramHttpURLConnection.getHeaderField("Location");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("--getHttpConnection-- cacheKey = ");
    localStringBuilder.append(paramRFWImageInfo.key);
    localStringBuilder.append(" loc=");
    localStringBuilder.append(str);
    QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  /* Error */
  public boolean downloadByHttpURl(RFWImageInfo paramRFWImageInfo, Option paramOption)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 16
    //   12: aload_1
    //   13: aload_2
    //   14: invokestatic 377	cooperation/qqcircle/picload/RFWHttpUrlDW:getHttpConnection	(Lcooperation/qqcircle/picload/RFWImageInfo;Lcom/tencent/mobileqq/qcircle/api/data/Option;)Ljava/net/HttpURLConnection;
    //   17: astore 9
    //   19: aload 9
    //   21: ifnonnull +148 -> 169
    //   24: new 61	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   31: astore 11
    //   33: aload 11
    //   35: ldc 64
    //   37: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 11
    //   43: aload_2
    //   44: invokevirtual 74	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   47: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 11
    //   53: ldc_w 379
    //   56: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 11
    //   62: aload_1
    //   63: getfield 240	cooperation/qqcircle/picload/RFWImageInfo:key	Ljava/lang/String;
    //   66: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 11
    //   72: ldc_w 381
    //   75: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 11
    //   81: aload_1
    //   82: getfield 29	cooperation/qqcircle/picload/RFWImageInfo:url	Ljava/lang/String;
    //   85: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 11
    //   91: ldc_w 383
    //   94: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 85
    //   100: iconst_1
    //   101: aload 11
    //   103: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: aconst_null
    //   111: aconst_null
    //   112: aload 9
    //   114: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_1
    //   120: aconst_null
    //   121: astore 11
    //   123: aload 10
    //   125: astore_2
    //   126: aload 11
    //   128: astore 10
    //   130: goto +1278 -> 1408
    //   133: astore 11
    //   135: aconst_null
    //   136: astore 10
    //   138: aload 16
    //   140: astore 12
    //   142: goto +834 -> 976
    //   145: astore 11
    //   147: aconst_null
    //   148: astore 10
    //   150: aload 10
    //   152: astore 18
    //   154: aload 18
    //   156: astore 13
    //   158: aload 9
    //   160: astore 16
    //   162: aload 13
    //   164: astore 9
    //   166: goto +1028 -> 1194
    //   169: aload 9
    //   171: invokevirtual 388	java/net/HttpURLConnection:getContentLength	()I
    //   174: i2l
    //   175: lstore 4
    //   177: invokestatic 390	cooperation/qqcircle/picload/RFWHttpUrlDW:getSDCardAvailableCount	()J
    //   180: lstore 6
    //   182: lload 6
    //   184: lload 4
    //   186: lcmp
    //   187: ifge +98 -> 285
    //   190: new 61	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   197: astore 11
    //   199: aload 11
    //   201: ldc 64
    //   203: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 11
    //   209: aload_2
    //   210: invokevirtual 74	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   213: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 11
    //   219: ldc_w 392
    //   222: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 11
    //   228: aload_1
    //   229: getfield 240	cooperation/qqcircle/picload/RFWImageInfo:key	Ljava/lang/String;
    //   232: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 11
    //   238: ldc_w 381
    //   241: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 11
    //   247: aload_1
    //   248: getfield 29	cooperation/qqcircle/picload/RFWImageInfo:url	Ljava/lang/String;
    //   251: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 11
    //   257: ldc_w 394
    //   260: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 85
    //   266: iconst_1
    //   267: aload 11
    //   269: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_0
    //   276: aconst_null
    //   277: aconst_null
    //   278: aload 9
    //   280: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   283: iconst_0
    //   284: ireturn
    //   285: aload 9
    //   287: invokevirtual 398	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   290: astore 10
    //   292: aload_1
    //   293: getfield 401	cooperation/qqcircle/picload/RFWImageInfo:local	Ljava/lang/String;
    //   296: astore 19
    //   298: new 61	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   305: astore 13
    //   307: aload 13
    //   309: aload 19
    //   311: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 13
    //   317: ldc_w 403
    //   320: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: new 194	java/io/File
    //   327: dup
    //   328: aload 13
    //   330: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   336: astore 18
    //   338: aload 18
    //   340: invokevirtual 406	java/io/File:getParent	()Ljava/lang/String;
    //   343: astore 13
    //   345: aload 13
    //   347: ifnull +75 -> 422
    //   350: aload 11
    //   352: astore 15
    //   354: aload 9
    //   356: astore 14
    //   358: aload 10
    //   360: astore 13
    //   362: aload 18
    //   364: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   367: invokevirtual 198	java/io/File:exists	()Z
    //   370: ifne +52 -> 422
    //   373: aload 11
    //   375: astore 15
    //   377: aload 9
    //   379: astore 14
    //   381: aload 10
    //   383: astore 13
    //   385: aload 18
    //   387: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   390: invokevirtual 412	java/io/File:mkdirs	()Z
    //   393: pop
    //   394: goto +28 -> 422
    //   397: astore 11
    //   399: aload 16
    //   401: astore 12
    //   403: goto +573 -> 976
    //   406: astore 11
    //   408: aconst_null
    //   409: astore 13
    //   411: aload 9
    //   413: astore 16
    //   415: aload 13
    //   417: astore 9
    //   419: goto +775 -> 1194
    //   422: aload 18
    //   424: invokevirtual 198	java/io/File:exists	()Z
    //   427: istore 8
    //   429: iload 8
    //   431: ifeq +21 -> 452
    //   434: aload 11
    //   436: astore 15
    //   438: aload 9
    //   440: astore 14
    //   442: aload 10
    //   444: astore 13
    //   446: aload 18
    //   448: invokevirtual 201	java/io/File:delete	()Z
    //   451: pop
    //   452: aload 18
    //   454: invokevirtual 415	java/io/File:createNewFile	()Z
    //   457: pop
    //   458: new 61	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   465: astore 11
    //   467: aload 11
    //   469: aload 19
    //   471: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 11
    //   477: ldc_w 403
    //   480: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: new 220	java/io/FileOutputStream
    //   487: dup
    //   488: aload 11
    //   490: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: iconst_1
    //   494: invokespecial 418	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   497: astore 14
    //   499: aload 9
    //   501: astore 13
    //   503: aload 10
    //   505: astore 15
    //   507: aload 14
    //   509: astore 17
    //   511: sipush 8192
    //   514: newarray byte
    //   516: astore 11
    //   518: aload 9
    //   520: astore 13
    //   522: aload 10
    //   524: astore 15
    //   526: aload 14
    //   528: astore 17
    //   530: aload 10
    //   532: aload 11
    //   534: iconst_0
    //   535: sipush 8192
    //   538: invokevirtual 422	java/io/InputStream:read	([BII)I
    //   541: istore_3
    //   542: iload_3
    //   543: ifle +27 -> 570
    //   546: aload 9
    //   548: astore 13
    //   550: aload 10
    //   552: astore 15
    //   554: aload 14
    //   556: astore 17
    //   558: aload 14
    //   560: aload 11
    //   562: iconst_0
    //   563: iload_3
    //   564: invokevirtual 426	java/io/FileOutputStream:write	([BII)V
    //   567: goto -49 -> 518
    //   570: aload 9
    //   572: astore 13
    //   574: aload 10
    //   576: astore 15
    //   578: aload 14
    //   580: astore 17
    //   582: aload 14
    //   584: invokevirtual 429	java/io/FileOutputStream:flush	()V
    //   587: aload 9
    //   589: astore 13
    //   591: aload 10
    //   593: astore 15
    //   595: aload 14
    //   597: astore 17
    //   599: new 194	java/io/File
    //   602: dup
    //   603: aload 19
    //   605: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   608: astore 12
    //   610: aload 9
    //   612: astore 13
    //   614: aload 10
    //   616: astore 15
    //   618: aload 14
    //   620: astore 17
    //   622: aload 12
    //   624: invokevirtual 198	java/io/File:exists	()Z
    //   627: ifeq +21 -> 648
    //   630: aload 9
    //   632: astore 13
    //   634: aload 10
    //   636: astore 15
    //   638: aload 14
    //   640: astore 17
    //   642: aload 12
    //   644: invokevirtual 201	java/io/File:delete	()Z
    //   647: pop
    //   648: aload 9
    //   650: astore 13
    //   652: aload 10
    //   654: astore 15
    //   656: aload 14
    //   658: astore 17
    //   660: aload 18
    //   662: aload 12
    //   664: invokevirtual 433	java/io/File:renameTo	(Ljava/io/File;)Z
    //   667: pop
    //   668: aload 9
    //   670: astore 13
    //   672: aload 10
    //   674: astore 15
    //   676: aload 14
    //   678: astore 17
    //   680: new 61	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   687: astore 11
    //   689: aload 9
    //   691: astore 13
    //   693: aload 10
    //   695: astore 15
    //   697: aload 14
    //   699: astore 17
    //   701: aload 11
    //   703: ldc 64
    //   705: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 9
    //   711: astore 13
    //   713: aload 10
    //   715: astore 15
    //   717: aload 14
    //   719: astore 17
    //   721: aload 11
    //   723: aload_2
    //   724: invokevirtual 74	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   727: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 9
    //   733: astore 13
    //   735: aload 10
    //   737: astore 15
    //   739: aload 14
    //   741: astore 17
    //   743: aload 11
    //   745: ldc_w 435
    //   748: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 9
    //   754: astore 13
    //   756: aload 10
    //   758: astore 15
    //   760: aload 14
    //   762: astore 17
    //   764: aload 11
    //   766: aload_1
    //   767: getfield 240	cooperation/qqcircle/picload/RFWImageInfo:key	Ljava/lang/String;
    //   770: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 9
    //   776: astore 13
    //   778: aload 10
    //   780: astore 15
    //   782: aload 14
    //   784: astore 17
    //   786: aload 11
    //   788: ldc_w 381
    //   791: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 9
    //   797: astore 13
    //   799: aload 10
    //   801: astore 15
    //   803: aload 14
    //   805: astore 17
    //   807: aload 11
    //   809: aload_1
    //   810: getfield 29	cooperation/qqcircle/picload/RFWImageInfo:url	Ljava/lang/String;
    //   813: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 9
    //   819: astore 13
    //   821: aload 10
    //   823: astore 15
    //   825: aload 14
    //   827: astore 17
    //   829: ldc 85
    //   831: iconst_1
    //   832: aload 11
    //   834: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: aload 9
    //   842: astore 13
    //   844: aload 10
    //   846: astore 15
    //   848: aload 14
    //   850: astore 17
    //   852: aload_1
    //   853: aload 9
    //   855: invokevirtual 438	java/net/HttpURLConnection:getLastModified	()J
    //   858: putfield 154	cooperation/qqcircle/picload/RFWImageInfo:modified	J
    //   861: aload_0
    //   862: aload 14
    //   864: aload 10
    //   866: aload 9
    //   868: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   871: iconst_1
    //   872: ireturn
    //   873: astore 11
    //   875: aload 9
    //   877: astore 16
    //   879: aload 14
    //   881: astore 9
    //   883: goto +311 -> 1194
    //   886: astore 11
    //   888: aload 14
    //   890: astore 12
    //   892: goto +84 -> 976
    //   895: astore 11
    //   897: aconst_null
    //   898: astore 12
    //   900: aload 9
    //   902: astore 16
    //   904: aload 14
    //   906: astore 9
    //   908: goto +286 -> 1194
    //   911: astore 11
    //   913: aload 9
    //   915: astore 16
    //   917: goto +271 -> 1188
    //   920: astore_1
    //   921: aconst_null
    //   922: astore_2
    //   923: goto +485 -> 1408
    //   926: astore 11
    //   928: aconst_null
    //   929: astore 12
    //   931: goto +45 -> 976
    //   934: astore 11
    //   936: goto +245 -> 1181
    //   939: astore_1
    //   940: goto +17 -> 957
    //   943: astore 11
    //   945: goto +25 -> 970
    //   948: astore 11
    //   950: goto +228 -> 1178
    //   953: astore_1
    //   954: aconst_null
    //   955: astore 9
    //   957: aconst_null
    //   958: astore_2
    //   959: aconst_null
    //   960: astore 10
    //   962: goto +446 -> 1408
    //   965: astore 11
    //   967: aconst_null
    //   968: astore 9
    //   970: aconst_null
    //   971: astore 12
    //   973: aconst_null
    //   974: astore 10
    //   976: aload 12
    //   978: astore 15
    //   980: aload 9
    //   982: astore 14
    //   984: aload 10
    //   986: astore 13
    //   988: new 61	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   995: astore 16
    //   997: aload 12
    //   999: astore 15
    //   1001: aload 9
    //   1003: astore 14
    //   1005: aload 10
    //   1007: astore 13
    //   1009: aload 16
    //   1011: ldc 64
    //   1013: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 12
    //   1019: astore 15
    //   1021: aload 9
    //   1023: astore 14
    //   1025: aload 10
    //   1027: astore 13
    //   1029: aload 16
    //   1031: aload_2
    //   1032: invokevirtual 74	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   1035: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 12
    //   1041: astore 15
    //   1043: aload 9
    //   1045: astore 14
    //   1047: aload 10
    //   1049: astore 13
    //   1051: aload 16
    //   1053: ldc_w 440
    //   1056: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 12
    //   1062: astore 15
    //   1064: aload 9
    //   1066: astore 14
    //   1068: aload 10
    //   1070: astore 13
    //   1072: aload 16
    //   1074: aload_1
    //   1075: getfield 240	cooperation/qqcircle/picload/RFWImageInfo:key	Ljava/lang/String;
    //   1078: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload 12
    //   1084: astore 15
    //   1086: aload 9
    //   1088: astore 14
    //   1090: aload 10
    //   1092: astore 13
    //   1094: aload 16
    //   1096: ldc_w 442
    //   1099: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload 12
    //   1105: astore 15
    //   1107: aload 9
    //   1109: astore 14
    //   1111: aload 10
    //   1113: astore 13
    //   1115: aload 16
    //   1117: aload 11
    //   1119: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: aload 12
    //   1125: astore 15
    //   1127: aload 9
    //   1129: astore 14
    //   1131: aload 10
    //   1133: astore 13
    //   1135: ldc 85
    //   1137: iconst_1
    //   1138: aload 16
    //   1140: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_0
    //   1147: aload 12
    //   1149: aload 10
    //   1151: aload 9
    //   1153: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1156: iconst_0
    //   1157: ireturn
    //   1158: astore_1
    //   1159: aload 15
    //   1161: astore_2
    //   1162: aload 14
    //   1164: astore 9
    //   1166: aload 13
    //   1168: astore 10
    //   1170: goto +238 -> 1408
    //   1173: astore 11
    //   1175: aconst_null
    //   1176: astore 9
    //   1178: aconst_null
    //   1179: astore 10
    //   1181: aconst_null
    //   1182: astore 18
    //   1184: aload 9
    //   1186: astore 16
    //   1188: aconst_null
    //   1189: astore 12
    //   1191: aconst_null
    //   1192: astore 9
    //   1194: aload 16
    //   1196: astore 13
    //   1198: aload 10
    //   1200: astore 15
    //   1202: aload 9
    //   1204: astore 17
    //   1206: new 61	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1213: astore 14
    //   1215: aload 16
    //   1217: astore 13
    //   1219: aload 10
    //   1221: astore 15
    //   1223: aload 9
    //   1225: astore 17
    //   1227: aload 14
    //   1229: ldc 64
    //   1231: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload 16
    //   1237: astore 13
    //   1239: aload 10
    //   1241: astore 15
    //   1243: aload 9
    //   1245: astore 17
    //   1247: aload 14
    //   1249: aload_2
    //   1250: invokevirtual 74	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   1253: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 16
    //   1259: astore 13
    //   1261: aload 10
    //   1263: astore 15
    //   1265: aload 9
    //   1267: astore 17
    //   1269: aload 14
    //   1271: ldc_w 440
    //   1274: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 16
    //   1280: astore 13
    //   1282: aload 10
    //   1284: astore 15
    //   1286: aload 9
    //   1288: astore 17
    //   1290: aload 14
    //   1292: aload_1
    //   1293: getfield 240	cooperation/qqcircle/picload/RFWImageInfo:key	Ljava/lang/String;
    //   1296: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload 16
    //   1302: astore 13
    //   1304: aload 10
    //   1306: astore 15
    //   1308: aload 9
    //   1310: astore 17
    //   1312: aload 14
    //   1314: ldc_w 447
    //   1317: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload 16
    //   1323: astore 13
    //   1325: aload 10
    //   1327: astore 15
    //   1329: aload 9
    //   1331: astore 17
    //   1333: aload 14
    //   1335: aload 11
    //   1337: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload 16
    //   1343: astore 13
    //   1345: aload 10
    //   1347: astore 15
    //   1349: aload 9
    //   1351: astore 17
    //   1353: ldc 85
    //   1355: iconst_1
    //   1356: aload 14
    //   1358: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: invokestatic 445	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1364: aload 16
    //   1366: astore 13
    //   1368: aload 10
    //   1370: astore 15
    //   1372: aload 9
    //   1374: astore 17
    //   1376: aload_0
    //   1377: aload 18
    //   1379: aload 12
    //   1381: invokespecial 449	cooperation/qqcircle/picload/RFWHttpUrlDW:dealException	(Ljava/io/File;Ljava/io/File;)V
    //   1384: aload_0
    //   1385: aload 9
    //   1387: aload 10
    //   1389: aload 16
    //   1391: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1394: iconst_0
    //   1395: ireturn
    //   1396: astore_1
    //   1397: aload 17
    //   1399: astore_2
    //   1400: aload 15
    //   1402: astore 10
    //   1404: aload 13
    //   1406: astore 9
    //   1408: aload_0
    //   1409: aload_2
    //   1410: aload 10
    //   1412: aload 9
    //   1414: invokespecial 385	cooperation/qqcircle/picload/RFWHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1417: goto +5 -> 1422
    //   1420: aload_1
    //   1421: athrow
    //   1422: goto -2 -> 1420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1425	0	this	RFWHttpUrlDW
    //   0	1425	1	paramRFWImageInfo	RFWImageInfo
    //   0	1425	2	paramOption	Option
    //   541	23	3	i	int
    //   175	10	4	l1	long
    //   180	3	6	l2	long
    //   427	3	8	bool	boolean
    //   17	1396	9	localObject1	Object
    //   7	1404	10	localObject2	Object
    //   1	126	11	localStringBuilder1	StringBuilder
    //   133	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   145	1	11	localException1	Exception
    //   197	177	11	localStringBuilder2	StringBuilder
    //   397	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   406	29	11	localException2	Exception
    //   465	368	11	localObject3	Object
    //   873	1	11	localException3	Exception
    //   886	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   895	1	11	localException4	Exception
    //   911	1	11	localException5	Exception
    //   926	1	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   934	1	11	localException6	Exception
    //   943	1	11	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   948	1	11	localException7	Exception
    //   965	153	11	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1173	163	11	localException8	Exception
    //   4	1376	12	localObject4	Object
    //   156	1249	13	localObject5	Object
    //   356	1001	14	localObject6	Object
    //   352	1049	15	localObject7	Object
    //   10	1380	16	localObject8	Object
    //   509	889	17	localObject9	Object
    //   152	1226	18	localObject10	Object
    //   296	308	19	str	String
    // Exception table:
    //   from	to	target	type
    //   24	109	119	finally
    //   190	275	119	finally
    //   24	109	133	java/lang/OutOfMemoryError
    //   190	275	133	java/lang/OutOfMemoryError
    //   24	109	145	java/lang/Exception
    //   190	275	145	java/lang/Exception
    //   362	373	397	java/lang/OutOfMemoryError
    //   385	394	397	java/lang/OutOfMemoryError
    //   446	452	397	java/lang/OutOfMemoryError
    //   362	373	406	java/lang/Exception
    //   385	394	406	java/lang/Exception
    //   446	452	406	java/lang/Exception
    //   622	630	873	java/lang/Exception
    //   642	648	873	java/lang/Exception
    //   660	668	873	java/lang/Exception
    //   680	689	873	java/lang/Exception
    //   701	709	873	java/lang/Exception
    //   721	731	873	java/lang/Exception
    //   743	752	873	java/lang/Exception
    //   764	774	873	java/lang/Exception
    //   786	795	873	java/lang/Exception
    //   807	817	873	java/lang/Exception
    //   829	840	873	java/lang/Exception
    //   852	861	873	java/lang/Exception
    //   511	518	886	java/lang/OutOfMemoryError
    //   530	542	886	java/lang/OutOfMemoryError
    //   558	567	886	java/lang/OutOfMemoryError
    //   582	587	886	java/lang/OutOfMemoryError
    //   599	610	886	java/lang/OutOfMemoryError
    //   622	630	886	java/lang/OutOfMemoryError
    //   642	648	886	java/lang/OutOfMemoryError
    //   660	668	886	java/lang/OutOfMemoryError
    //   680	689	886	java/lang/OutOfMemoryError
    //   701	709	886	java/lang/OutOfMemoryError
    //   721	731	886	java/lang/OutOfMemoryError
    //   743	752	886	java/lang/OutOfMemoryError
    //   764	774	886	java/lang/OutOfMemoryError
    //   786	795	886	java/lang/OutOfMemoryError
    //   807	817	886	java/lang/OutOfMemoryError
    //   829	840	886	java/lang/OutOfMemoryError
    //   852	861	886	java/lang/OutOfMemoryError
    //   511	518	895	java/lang/Exception
    //   530	542	895	java/lang/Exception
    //   558	567	895	java/lang/Exception
    //   582	587	895	java/lang/Exception
    //   599	610	895	java/lang/Exception
    //   338	345	911	java/lang/Exception
    //   422	429	911	java/lang/Exception
    //   452	499	911	java/lang/Exception
    //   292	338	920	finally
    //   338	345	920	finally
    //   422	429	920	finally
    //   452	499	920	finally
    //   292	338	926	java/lang/OutOfMemoryError
    //   338	345	926	java/lang/OutOfMemoryError
    //   422	429	926	java/lang/OutOfMemoryError
    //   452	499	926	java/lang/OutOfMemoryError
    //   292	338	934	java/lang/Exception
    //   169	182	939	finally
    //   285	292	939	finally
    //   169	182	943	java/lang/OutOfMemoryError
    //   285	292	943	java/lang/OutOfMemoryError
    //   169	182	948	java/lang/Exception
    //   285	292	948	java/lang/Exception
    //   12	19	953	finally
    //   12	19	965	java/lang/OutOfMemoryError
    //   362	373	1158	finally
    //   385	394	1158	finally
    //   446	452	1158	finally
    //   988	997	1158	finally
    //   1009	1017	1158	finally
    //   1029	1039	1158	finally
    //   1051	1060	1158	finally
    //   1072	1082	1158	finally
    //   1094	1103	1158	finally
    //   1115	1123	1158	finally
    //   1135	1146	1158	finally
    //   12	19	1173	java/lang/Exception
    //   511	518	1396	finally
    //   530	542	1396	finally
    //   558	567	1396	finally
    //   582	587	1396	finally
    //   599	610	1396	finally
    //   622	630	1396	finally
    //   642	648	1396	finally
    //   660	668	1396	finally
    //   680	689	1396	finally
    //   701	709	1396	finally
    //   721	731	1396	finally
    //   743	752	1396	finally
    //   764	774	1396	finally
    //   786	795	1396	finally
    //   807	817	1396	finally
    //   829	840	1396	finally
    //   852	861	1396	finally
    //   1206	1215	1396	finally
    //   1227	1235	1396	finally
    //   1247	1257	1396	finally
    //   1269	1278	1396	finally
    //   1290	1300	1396	finally
    //   1312	1321	1396	finally
    //   1333	1341	1396	finally
    //   1353	1364	1396	finally
    //   1376	1384	1396	finally
  }
  
  public void handlerDownLoad(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    RFWImageInfo localRFWImageInfo = new RFWImageInfo();
    localRFWImageInfo.local = paramOption.getLocalPath();
    localRFWImageInfo.key = paramOption.getCacheKey();
    localRFWImageInfo.url = paramOption.getUrl();
    if (downloadByHttpURl(localRFWImageInfo, paramOption))
    {
      paramICallBackListener.callBack(paramOption, true, 0);
      return;
    }
    if (getNextDw() != null) {
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWHttpUrlDW
 * JD-Core Version:    0.7.0.1
 */