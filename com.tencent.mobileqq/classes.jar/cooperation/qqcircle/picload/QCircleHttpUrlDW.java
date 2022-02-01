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
    Object localObject = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.jdField_b_of_type_JavaLangString);
    String str1 = QCircleCommonUtil.getUrlHost((String)localObject);
    String str2 = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", (String)localObject, str1);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str2).openConnection();
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("after convert :origin:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\nconvert:");
    localStringBuilder.append(str2);
    localStringBuilder.append("\nhost:");
    localStringBuilder.append(str1);
    RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
    if (((localHttpURLConnection instanceof HttpsURLConnection)) && (!str2.equals(localObject)))
    {
      paramOption = new QCircleHttpUrlDW.1(paramOption);
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
  
  protected static HttpURLConnection getHttpConnection(ImageInfo paramImageInfo, Option paramOption)
  {
    if (paramImageInfo != null) {
      if (paramOption == null) {
        return null;
      }
    }
    for (;;)
    {
      HttpURLConnection localHttpURLConnection2;
      int i;
      try
      {
        HttpURLConnection localHttpURLConnection1 = createHttpConnection(paramImageInfo, paramOption);
        localHttpURLConnection2 = localHttpURLConnection1;
        try
        {
          i = localHttpURLConnection1.getResponseCode();
          localHttpURLConnection2 = localHttpURLConnection1;
          int j = RFLog.USR;
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder = new StringBuilder();
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("seq = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramOption.getSeq());
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("--getHttpConnection-- cacheKey = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramImageInfo.jdField_a_of_type_JavaLangString);
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(" reponseCode=");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(i);
          localHttpURLConnection2 = localHttpURLConnection1;
          RFLog.i("QCircleFeedPicLoader", j, localStringBuilder.toString());
          if (i != 302)
          {
            if (i != 301) {
              break label432;
            }
            continue;
            if (i == 304)
            {
              localHttpURLConnection2 = localHttpURLConnection1;
              localHttpURLConnection1 = responseModified(localHttpURLConnection1, paramOption, paramImageInfo);
              continue;
            }
            localHttpURLConnection2 = localHttpURLConnection1;
            disConnect(localHttpURLConnection1);
            localHttpURLConnection1 = null;
            continue;
            localHttpURLConnection2 = localHttpURLConnection1;
            localHttpURLConnection1 = responseSuccess(localHttpURLConnection1, paramOption, paramImageInfo);
            continue;
          }
          localHttpURLConnection2 = localHttpURLConnection1;
          localHttpURLConnection1 = responseTemp(localHttpURLConnection1, paramOption, paramImageInfo);
          localHttpURLConnection2 = localHttpURLConnection1;
          i = RFLog.USR;
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder = new StringBuilder();
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("seq = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramOption.getSeq());
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append("--getHttpConnection-- cacheKey = ");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(paramImageInfo.jdField_a_of_type_JavaLangString);
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(" uc=");
          localHttpURLConnection2 = localHttpURLConnection1;
          localStringBuilder.append(localHttpURLConnection1);
          localHttpURLConnection2 = localHttpURLConnection1;
          RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
          return localHttpURLConnection1;
        }
        catch (Exception localException1) {}
        i = RFLog.USR;
      }
      catch (Exception localException2)
      {
        localHttpURLConnection2 = null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramOption.getSeq());
      localStringBuilder.append("--getHttpConnection-- cacheKey = ");
      localStringBuilder.append(paramImageInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" Exception!!!");
      localStringBuilder.append(localException2);
      RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
      disConnect(localHttpURLConnection2);
      return null;
      label432:
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
        break label52;
      }
      return "/mnt/sdcard-ext";
    }
    catch (Exception localException)
    {
      label41:
      label52:
      break label41;
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "getSDCardPath() failed");
    return ".";
  }
  
  private static HttpURLConnection responseModified(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("--getHttpConnection-- cacheKey = ");
    localStringBuilder.append(paramImageInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" --getimg-- ");
    localStringBuilder.append(paramImageInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" not modified");
    RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
    paramImageInfo.jdField_a_of_type_Long = (((float)getMaxAge(paramHttpURLConnection) * 1000.0F));
    paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  private static HttpURLConnection responseSuccess(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    String str = paramHttpURLConnection.getContentType();
    if (str == null) {
      str = "";
    } else {
      str = str.toLowerCase();
    }
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
      paramImageInfo.jdField_a_of_type_Long = (getMaxAge(localHttpURLConnection) * 1000L);
      if (paramImageInfo.jdField_a_of_type_Long == 0L) {
        paramImageInfo.jdField_a_of_type_Long = 86400000L;
      }
    }
    paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
    int i = RFLog.USR;
    paramHttpURLConnection = new StringBuilder();
    paramHttpURLConnection.append("seq = ");
    paramHttpURLConnection.append(paramOption.getSeq());
    paramHttpURLConnection.append("--getHttpConnection-- cacheKey = ");
    paramHttpURLConnection.append(paramImageInfo.jdField_a_of_type_JavaLangString);
    paramHttpURLConnection.append(" contentType=");
    paramHttpURLConnection.append(str);
    RFLog.i("QCircleFeedPicLoader", i, paramHttpURLConnection.toString());
    return localHttpURLConnection;
  }
  
  private static HttpURLConnection responseTemp(HttpURLConnection paramHttpURLConnection, Option paramOption, ImageInfo paramImageInfo)
  {
    String str = paramHttpURLConnection.getHeaderField("Location");
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq = ");
    localStringBuilder.append(paramOption.getSeq());
    localStringBuilder.append("--getHttpConnection-- cacheKey = ");
    localStringBuilder.append(paramImageInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" loc=");
    localStringBuilder.append(str);
    RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
    disConnect(paramHttpURLConnection);
    return null;
  }
  
  /* Error */
  public boolean downloadByHttpURl(ImageInfo paramImageInfo, Option paramOption)
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
    //   14: invokestatic 378	cooperation/qqcircle/picload/QCircleHttpUrlDW:getHttpConnection	(Lpicload/ImageInfo;Lcom/tencent/mobileqq/qcircle/api/data/Option;)Ljava/net/HttpURLConnection;
    //   17: astore 9
    //   19: aload 9
    //   21: ifnonnull +152 -> 173
    //   24: getstatic 65	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   27: istore_3
    //   28: new 67	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   35: astore 11
    //   37: aload 11
    //   39: ldc 70
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 11
    //   47: aload_2
    //   48: invokevirtual 80	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   51: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 11
    //   57: ldc_w 380
    //   60: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 11
    //   66: aload_1
    //   67: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 11
    //   76: ldc_w 382
    //   79: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 11
    //   85: aload_1
    //   86: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 11
    //   95: ldc_w 384
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 91
    //   104: iload_3
    //   105: aload 11
    //   107: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: aconst_null
    //   115: aconst_null
    //   116: aload 9
    //   118: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 11
    //   127: aload 10
    //   129: astore_2
    //   130: aload 11
    //   132: astore 10
    //   134: goto +1330 -> 1464
    //   137: astore 11
    //   139: aconst_null
    //   140: astore 10
    //   142: aload 16
    //   144: astore 12
    //   146: goto +854 -> 1000
    //   149: astore 11
    //   151: aconst_null
    //   152: astore 10
    //   154: aload 10
    //   156: astore 18
    //   158: aload 18
    //   160: astore 13
    //   162: aload 9
    //   164: astore 16
    //   166: aload 13
    //   168: astore 9
    //   170: goto +1064 -> 1234
    //   173: aload 9
    //   175: invokevirtual 389	java/net/HttpURLConnection:getContentLength	()I
    //   178: i2l
    //   179: lstore 4
    //   181: invokestatic 391	cooperation/qqcircle/picload/QCircleHttpUrlDW:getSDCardAvailableCount	()J
    //   184: lstore 6
    //   186: lload 6
    //   188: lload 4
    //   190: lcmp
    //   191: ifge +102 -> 293
    //   194: getstatic 65	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   197: istore_3
    //   198: new 67	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   205: astore 11
    //   207: aload 11
    //   209: ldc 70
    //   211: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 11
    //   217: aload_2
    //   218: invokevirtual 80	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   221: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 11
    //   227: ldc_w 393
    //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 11
    //   236: aload_1
    //   237: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 11
    //   246: ldc_w 382
    //   249: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 11
    //   255: aload_1
    //   256: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   259: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 11
    //   265: ldc_w 395
    //   268: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 91
    //   274: iload_3
    //   275: aload 11
    //   277: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: aconst_null
    //   285: aconst_null
    //   286: aload 9
    //   288: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   291: iconst_0
    //   292: ireturn
    //   293: aload 9
    //   295: invokevirtual 399	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   298: astore 10
    //   300: aload_1
    //   301: getfield 401	picload/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   304: astore 19
    //   306: new 67	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   313: astore 13
    //   315: aload 13
    //   317: aload 19
    //   319: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 13
    //   325: ldc_w 403
    //   328: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: new 198	java/io/File
    //   335: dup
    //   336: aload 13
    //   338: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: astore 18
    //   346: aload 18
    //   348: invokevirtual 406	java/io/File:getParent	()Ljava/lang/String;
    //   351: astore 13
    //   353: aload 13
    //   355: ifnull +75 -> 430
    //   358: aload 11
    //   360: astore 15
    //   362: aload 9
    //   364: astore 14
    //   366: aload 10
    //   368: astore 13
    //   370: aload 18
    //   372: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   375: invokevirtual 202	java/io/File:exists	()Z
    //   378: ifne +52 -> 430
    //   381: aload 11
    //   383: astore 15
    //   385: aload 9
    //   387: astore 14
    //   389: aload 10
    //   391: astore 13
    //   393: aload 18
    //   395: invokevirtual 409	java/io/File:getParentFile	()Ljava/io/File;
    //   398: invokevirtual 412	java/io/File:mkdirs	()Z
    //   401: pop
    //   402: goto +28 -> 430
    //   405: astore 11
    //   407: aload 16
    //   409: astore 12
    //   411: goto +589 -> 1000
    //   414: astore 11
    //   416: aconst_null
    //   417: astore 13
    //   419: aload 9
    //   421: astore 16
    //   423: aload 13
    //   425: astore 9
    //   427: goto +807 -> 1234
    //   430: aload 18
    //   432: invokevirtual 202	java/io/File:exists	()Z
    //   435: istore 8
    //   437: iload 8
    //   439: ifeq +21 -> 460
    //   442: aload 11
    //   444: astore 15
    //   446: aload 9
    //   448: astore 14
    //   450: aload 10
    //   452: astore 13
    //   454: aload 18
    //   456: invokevirtual 205	java/io/File:delete	()Z
    //   459: pop
    //   460: aload 18
    //   462: invokevirtual 415	java/io/File:createNewFile	()Z
    //   465: pop
    //   466: new 67	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   473: astore 11
    //   475: aload 11
    //   477: aload 19
    //   479: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 11
    //   485: ldc_w 403
    //   488: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: new 223	java/io/FileOutputStream
    //   495: dup
    //   496: aload 11
    //   498: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: iconst_1
    //   502: invokespecial 418	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   505: astore 14
    //   507: aload 9
    //   509: astore 13
    //   511: aload 10
    //   513: astore 15
    //   515: aload 14
    //   517: astore 17
    //   519: sipush 8192
    //   522: newarray byte
    //   524: astore 11
    //   526: aload 9
    //   528: astore 13
    //   530: aload 10
    //   532: astore 15
    //   534: aload 14
    //   536: astore 17
    //   538: aload 10
    //   540: aload 11
    //   542: iconst_0
    //   543: sipush 8192
    //   546: invokevirtual 422	java/io/InputStream:read	([BII)I
    //   549: istore_3
    //   550: iload_3
    //   551: ifle +27 -> 578
    //   554: aload 9
    //   556: astore 13
    //   558: aload 10
    //   560: astore 15
    //   562: aload 14
    //   564: astore 17
    //   566: aload 14
    //   568: aload 11
    //   570: iconst_0
    //   571: iload_3
    //   572: invokevirtual 426	java/io/FileOutputStream:write	([BII)V
    //   575: goto -49 -> 526
    //   578: aload 9
    //   580: astore 13
    //   582: aload 10
    //   584: astore 15
    //   586: aload 14
    //   588: astore 17
    //   590: aload 14
    //   592: invokevirtual 429	java/io/FileOutputStream:flush	()V
    //   595: aload 9
    //   597: astore 13
    //   599: aload 10
    //   601: astore 15
    //   603: aload 14
    //   605: astore 17
    //   607: new 198	java/io/File
    //   610: dup
    //   611: aload 19
    //   613: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   616: astore 12
    //   618: aload 9
    //   620: astore 13
    //   622: aload 10
    //   624: astore 15
    //   626: aload 14
    //   628: astore 17
    //   630: aload 12
    //   632: invokevirtual 202	java/io/File:exists	()Z
    //   635: ifeq +21 -> 656
    //   638: aload 9
    //   640: astore 13
    //   642: aload 10
    //   644: astore 15
    //   646: aload 14
    //   648: astore 17
    //   650: aload 12
    //   652: invokevirtual 205	java/io/File:delete	()Z
    //   655: pop
    //   656: aload 9
    //   658: astore 13
    //   660: aload 10
    //   662: astore 15
    //   664: aload 14
    //   666: astore 17
    //   668: aload 18
    //   670: aload 12
    //   672: invokevirtual 433	java/io/File:renameTo	(Ljava/io/File;)Z
    //   675: pop
    //   676: aload 9
    //   678: astore 13
    //   680: aload 10
    //   682: astore 15
    //   684: aload 14
    //   686: astore 17
    //   688: getstatic 65	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   691: istore_3
    //   692: aload 9
    //   694: astore 13
    //   696: aload 10
    //   698: astore 15
    //   700: aload 14
    //   702: astore 17
    //   704: new 67	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   711: astore 11
    //   713: aload 9
    //   715: astore 13
    //   717: aload 10
    //   719: astore 15
    //   721: aload 14
    //   723: astore 17
    //   725: aload 11
    //   727: ldc 70
    //   729: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload 9
    //   735: astore 13
    //   737: aload 10
    //   739: astore 15
    //   741: aload 14
    //   743: astore 17
    //   745: aload 11
    //   747: aload_2
    //   748: invokevirtual 80	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   751: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload 9
    //   757: astore 13
    //   759: aload 10
    //   761: astore 15
    //   763: aload 14
    //   765: astore 17
    //   767: aload 11
    //   769: ldc_w 435
    //   772: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 9
    //   778: astore 13
    //   780: aload 10
    //   782: astore 15
    //   784: aload 14
    //   786: astore 17
    //   788: aload 11
    //   790: aload_1
    //   791: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 9
    //   800: astore 13
    //   802: aload 10
    //   804: astore 15
    //   806: aload 14
    //   808: astore 17
    //   810: aload 11
    //   812: ldc_w 382
    //   815: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 9
    //   821: astore 13
    //   823: aload 10
    //   825: astore 15
    //   827: aload 14
    //   829: astore 17
    //   831: aload 11
    //   833: aload_1
    //   834: getfield 29	picload/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   837: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload 9
    //   843: astore 13
    //   845: aload 10
    //   847: astore 15
    //   849: aload 14
    //   851: astore 17
    //   853: ldc 91
    //   855: iload_3
    //   856: aload 11
    //   858: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokestatic 99	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   864: aload 9
    //   866: astore 13
    //   868: aload 10
    //   870: astore 15
    //   872: aload 14
    //   874: astore 17
    //   876: aload_1
    //   877: aload 9
    //   879: invokevirtual 438	java/net/HttpURLConnection:getLastModified	()J
    //   882: putfield 158	picload/ImageInfo:jdField_c_of_type_Long	J
    //   885: aload_0
    //   886: aload 14
    //   888: aload 10
    //   890: aload 9
    //   892: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   895: iconst_1
    //   896: ireturn
    //   897: astore 11
    //   899: aload 9
    //   901: astore 16
    //   903: aload 14
    //   905: astore 9
    //   907: goto +327 -> 1234
    //   910: astore 11
    //   912: aload 14
    //   914: astore 12
    //   916: goto +84 -> 1000
    //   919: astore 11
    //   921: aconst_null
    //   922: astore 12
    //   924: aload 9
    //   926: astore 16
    //   928: aload 14
    //   930: astore 9
    //   932: goto +302 -> 1234
    //   935: astore 11
    //   937: aload 9
    //   939: astore 16
    //   941: goto +287 -> 1228
    //   944: astore_1
    //   945: aconst_null
    //   946: astore_2
    //   947: goto +517 -> 1464
    //   950: astore 11
    //   952: aconst_null
    //   953: astore 12
    //   955: goto +45 -> 1000
    //   958: astore 11
    //   960: goto +261 -> 1221
    //   963: astore_1
    //   964: goto +17 -> 981
    //   967: astore 11
    //   969: goto +25 -> 994
    //   972: astore 11
    //   974: goto +244 -> 1218
    //   977: astore_1
    //   978: aconst_null
    //   979: astore 9
    //   981: aconst_null
    //   982: astore_2
    //   983: aconst_null
    //   984: astore 10
    //   986: goto +478 -> 1464
    //   989: astore 11
    //   991: aconst_null
    //   992: astore 9
    //   994: aconst_null
    //   995: astore 12
    //   997: aconst_null
    //   998: astore 10
    //   1000: aload 12
    //   1002: astore 15
    //   1004: aload 9
    //   1006: astore 14
    //   1008: aload 10
    //   1010: astore 13
    //   1012: getstatic 65	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   1015: istore_3
    //   1016: aload 12
    //   1018: astore 15
    //   1020: aload 9
    //   1022: astore 14
    //   1024: aload 10
    //   1026: astore 13
    //   1028: new 67	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1035: astore 16
    //   1037: aload 12
    //   1039: astore 15
    //   1041: aload 9
    //   1043: astore 14
    //   1045: aload 10
    //   1047: astore 13
    //   1049: aload 16
    //   1051: ldc 70
    //   1053: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 12
    //   1059: astore 15
    //   1061: aload 9
    //   1063: astore 14
    //   1065: aload 10
    //   1067: astore 13
    //   1069: aload 16
    //   1071: aload_2
    //   1072: invokevirtual 80	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   1075: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: pop
    //   1079: aload 12
    //   1081: astore 15
    //   1083: aload 9
    //   1085: astore 14
    //   1087: aload 10
    //   1089: astore 13
    //   1091: aload 16
    //   1093: ldc_w 440
    //   1096: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: pop
    //   1100: aload 12
    //   1102: astore 15
    //   1104: aload 9
    //   1106: astore 14
    //   1108: aload 10
    //   1110: astore 13
    //   1112: aload 16
    //   1114: aload_1
    //   1115: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1118: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: pop
    //   1122: aload 12
    //   1124: astore 15
    //   1126: aload 9
    //   1128: astore 14
    //   1130: aload 10
    //   1132: astore 13
    //   1134: aload 16
    //   1136: ldc_w 442
    //   1139: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 12
    //   1145: astore 15
    //   1147: aload 9
    //   1149: astore 14
    //   1151: aload 10
    //   1153: astore 13
    //   1155: aload 16
    //   1157: aload 11
    //   1159: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload 12
    //   1165: astore 15
    //   1167: aload 9
    //   1169: astore 14
    //   1171: aload 10
    //   1173: astore 13
    //   1175: ldc 91
    //   1177: iload_3
    //   1178: aload 16
    //   1180: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: invokestatic 445	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1186: aload_0
    //   1187: aload 12
    //   1189: aload 10
    //   1191: aload 9
    //   1193: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1196: iconst_0
    //   1197: ireturn
    //   1198: astore_1
    //   1199: aload 15
    //   1201: astore_2
    //   1202: aload 14
    //   1204: astore 9
    //   1206: aload 13
    //   1208: astore 10
    //   1210: goto +254 -> 1464
    //   1213: astore 11
    //   1215: aconst_null
    //   1216: astore 9
    //   1218: aconst_null
    //   1219: astore 10
    //   1221: aconst_null
    //   1222: astore 18
    //   1224: aload 9
    //   1226: astore 16
    //   1228: aconst_null
    //   1229: astore 12
    //   1231: aconst_null
    //   1232: astore 9
    //   1234: aload 16
    //   1236: astore 13
    //   1238: aload 10
    //   1240: astore 15
    //   1242: aload 9
    //   1244: astore 17
    //   1246: getstatic 65	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   1249: istore_3
    //   1250: aload 16
    //   1252: astore 13
    //   1254: aload 10
    //   1256: astore 15
    //   1258: aload 9
    //   1260: astore 17
    //   1262: new 67	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1269: astore 14
    //   1271: aload 16
    //   1273: astore 13
    //   1275: aload 10
    //   1277: astore 15
    //   1279: aload 9
    //   1281: astore 17
    //   1283: aload 14
    //   1285: ldc 70
    //   1287: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 16
    //   1293: astore 13
    //   1295: aload 10
    //   1297: astore 15
    //   1299: aload 9
    //   1301: astore 17
    //   1303: aload 14
    //   1305: aload_2
    //   1306: invokevirtual 80	com/tencent/mobileqq/qcircle/api/data/Option:getSeq	()I
    //   1309: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: aload 16
    //   1315: astore 13
    //   1317: aload 10
    //   1319: astore 15
    //   1321: aload 9
    //   1323: astore 17
    //   1325: aload 14
    //   1327: ldc_w 440
    //   1330: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 16
    //   1336: astore 13
    //   1338: aload 10
    //   1340: astore 15
    //   1342: aload 9
    //   1344: astore 17
    //   1346: aload 14
    //   1348: aload_1
    //   1349: getfield 243	picload/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1352: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload 16
    //   1358: astore 13
    //   1360: aload 10
    //   1362: astore 15
    //   1364: aload 9
    //   1366: astore 17
    //   1368: aload 14
    //   1370: ldc_w 447
    //   1373: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload 16
    //   1379: astore 13
    //   1381: aload 10
    //   1383: astore 15
    //   1385: aload 9
    //   1387: astore 17
    //   1389: aload 14
    //   1391: aload 11
    //   1393: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 16
    //   1399: astore 13
    //   1401: aload 10
    //   1403: astore 15
    //   1405: aload 9
    //   1407: astore 17
    //   1409: ldc 91
    //   1411: iload_3
    //   1412: aload 14
    //   1414: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokestatic 445	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1420: aload 16
    //   1422: astore 13
    //   1424: aload 10
    //   1426: astore 15
    //   1428: aload 9
    //   1430: astore 17
    //   1432: aload_0
    //   1433: aload 18
    //   1435: aload 12
    //   1437: invokespecial 449	cooperation/qqcircle/picload/QCircleHttpUrlDW:dealException	(Ljava/io/File;Ljava/io/File;)V
    //   1440: aload_0
    //   1441: aload 9
    //   1443: aload 10
    //   1445: aload 16
    //   1447: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1450: iconst_0
    //   1451: ireturn
    //   1452: astore_1
    //   1453: aload 17
    //   1455: astore_2
    //   1456: aload 15
    //   1458: astore 10
    //   1460: aload 13
    //   1462: astore 9
    //   1464: aload_0
    //   1465: aload_2
    //   1466: aload 10
    //   1468: aload 9
    //   1470: invokespecial 386	cooperation/qqcircle/picload/QCircleHttpUrlDW:finallyRelease	(Ljava/io/FileOutputStream;Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V
    //   1473: goto +5 -> 1478
    //   1476: aload_1
    //   1477: athrow
    //   1478: goto -2 -> 1476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1481	0	this	QCircleHttpUrlDW
    //   0	1481	1	paramImageInfo	ImageInfo
    //   0	1481	2	paramOption	Option
    //   27	1385	3	i	int
    //   179	10	4	l1	long
    //   184	3	6	l2	long
    //   435	3	8	bool	boolean
    //   17	1452	9	localObject1	Object
    //   7	1460	10	localObject2	Object
    //   1	130	11	localStringBuilder1	StringBuilder
    //   137	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   149	1	11	localException1	Exception
    //   205	177	11	localStringBuilder2	StringBuilder
    //   405	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   414	29	11	localException2	Exception
    //   473	384	11	localObject3	Object
    //   897	1	11	localException3	Exception
    //   910	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   919	1	11	localException4	Exception
    //   935	1	11	localException5	Exception
    //   950	1	11	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   958	1	11	localException6	Exception
    //   967	1	11	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   972	1	11	localException7	Exception
    //   989	169	11	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1213	179	11	localException8	Exception
    //   4	1432	12	localObject4	Object
    //   160	1301	13	localObject5	Object
    //   364	1049	14	localObject6	Object
    //   360	1097	15	localObject7	Object
    //   10	1436	16	localObject8	Object
    //   517	937	17	localObject9	Object
    //   156	1278	18	localObject10	Object
    //   304	308	19	str	String
    // Exception table:
    //   from	to	target	type
    //   24	113	123	finally
    //   194	283	123	finally
    //   24	113	137	java/lang/OutOfMemoryError
    //   194	283	137	java/lang/OutOfMemoryError
    //   24	113	149	java/lang/Exception
    //   194	283	149	java/lang/Exception
    //   370	381	405	java/lang/OutOfMemoryError
    //   393	402	405	java/lang/OutOfMemoryError
    //   454	460	405	java/lang/OutOfMemoryError
    //   370	381	414	java/lang/Exception
    //   393	402	414	java/lang/Exception
    //   454	460	414	java/lang/Exception
    //   630	638	897	java/lang/Exception
    //   650	656	897	java/lang/Exception
    //   668	676	897	java/lang/Exception
    //   688	692	897	java/lang/Exception
    //   704	713	897	java/lang/Exception
    //   725	733	897	java/lang/Exception
    //   745	755	897	java/lang/Exception
    //   767	776	897	java/lang/Exception
    //   788	798	897	java/lang/Exception
    //   810	819	897	java/lang/Exception
    //   831	841	897	java/lang/Exception
    //   853	864	897	java/lang/Exception
    //   876	885	897	java/lang/Exception
    //   519	526	910	java/lang/OutOfMemoryError
    //   538	550	910	java/lang/OutOfMemoryError
    //   566	575	910	java/lang/OutOfMemoryError
    //   590	595	910	java/lang/OutOfMemoryError
    //   607	618	910	java/lang/OutOfMemoryError
    //   630	638	910	java/lang/OutOfMemoryError
    //   650	656	910	java/lang/OutOfMemoryError
    //   668	676	910	java/lang/OutOfMemoryError
    //   688	692	910	java/lang/OutOfMemoryError
    //   704	713	910	java/lang/OutOfMemoryError
    //   725	733	910	java/lang/OutOfMemoryError
    //   745	755	910	java/lang/OutOfMemoryError
    //   767	776	910	java/lang/OutOfMemoryError
    //   788	798	910	java/lang/OutOfMemoryError
    //   810	819	910	java/lang/OutOfMemoryError
    //   831	841	910	java/lang/OutOfMemoryError
    //   853	864	910	java/lang/OutOfMemoryError
    //   876	885	910	java/lang/OutOfMemoryError
    //   519	526	919	java/lang/Exception
    //   538	550	919	java/lang/Exception
    //   566	575	919	java/lang/Exception
    //   590	595	919	java/lang/Exception
    //   607	618	919	java/lang/Exception
    //   346	353	935	java/lang/Exception
    //   430	437	935	java/lang/Exception
    //   460	507	935	java/lang/Exception
    //   300	346	944	finally
    //   346	353	944	finally
    //   430	437	944	finally
    //   460	507	944	finally
    //   300	346	950	java/lang/OutOfMemoryError
    //   346	353	950	java/lang/OutOfMemoryError
    //   430	437	950	java/lang/OutOfMemoryError
    //   460	507	950	java/lang/OutOfMemoryError
    //   300	346	958	java/lang/Exception
    //   173	186	963	finally
    //   293	300	963	finally
    //   173	186	967	java/lang/OutOfMemoryError
    //   293	300	967	java/lang/OutOfMemoryError
    //   173	186	972	java/lang/Exception
    //   293	300	972	java/lang/Exception
    //   12	19	977	finally
    //   12	19	989	java/lang/OutOfMemoryError
    //   370	381	1198	finally
    //   393	402	1198	finally
    //   454	460	1198	finally
    //   1012	1016	1198	finally
    //   1028	1037	1198	finally
    //   1049	1057	1198	finally
    //   1069	1079	1198	finally
    //   1091	1100	1198	finally
    //   1112	1122	1198	finally
    //   1134	1143	1198	finally
    //   1155	1163	1198	finally
    //   1175	1186	1198	finally
    //   12	19	1213	java/lang/Exception
    //   519	526	1452	finally
    //   538	550	1452	finally
    //   566	575	1452	finally
    //   590	595	1452	finally
    //   607	618	1452	finally
    //   630	638	1452	finally
    //   650	656	1452	finally
    //   668	676	1452	finally
    //   688	692	1452	finally
    //   704	713	1452	finally
    //   725	733	1452	finally
    //   745	755	1452	finally
    //   767	776	1452	finally
    //   788	798	1452	finally
    //   810	819	1452	finally
    //   831	841	1452	finally
    //   853	864	1452	finally
    //   876	885	1452	finally
    //   1246	1250	1452	finally
    //   1262	1271	1452	finally
    //   1283	1291	1452	finally
    //   1303	1313	1452	finally
    //   1325	1334	1452	finally
    //   1346	1356	1452	finally
    //   1368	1377	1452	finally
    //   1389	1397	1452	finally
    //   1409	1420	1452	finally
    //   1432	1440	1452	finally
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.jdField_c_of_type_JavaLangString = paramOption.getLocalPath();
    localImageInfo.jdField_a_of_type_JavaLangString = paramOption.getCacheKey();
    localImageInfo.jdField_b_of_type_JavaLangString = paramOption.getUrl();
    if (downloadByHttpURl(localImageInfo, paramOption))
    {
      paramICallBackListener.callBack(paramOption, true, 0);
      return;
    }
    if (getNextDw() != null) {
      getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpUrlDW
 * JD-Core Version:    0.7.0.1
 */