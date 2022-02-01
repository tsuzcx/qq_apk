package cooperation.qqcircle.picload;

import android.text.TextUtils;
import bjko;
import bjln;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class QCircleHttpUrlDW
  extends AbsPicDW
{
  protected static int dataBlockLength = 2048;
  protected static int max_length = 2097152;
  
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
      bjko.c("", "", paramHttpURLConnection);
    }
  }
  
  protected static HttpURLConnection getHttpConnection(bjln parambjln, Option paramOption)
  {
    HttpURLConnection localHttpURLConnection1 = null;
    if ((parambjln == null) || (paramOption == null)) {
      return null;
    }
    Object localObject1 = localHttpURLConnection1;
    for (;;)
    {
      try
      {
        Object localObject3 = MsfSdkUtils.insertMtype("yingyongbao", parambjln.jdField_b_of_type_JavaLangString);
        localObject1 = localHttpURLConnection1;
        localObject2 = QCircleCommonUtil.getUrlHost((String)localObject3);
        localObject1 = localHttpURLConnection1;
        String str = QCircleCommonUtil.convertDomainToIp("PhotoSvrList", "DownloadPhotoHttps", (String)localObject3, (String)localObject2);
        localObject1 = localHttpURLConnection1;
        localHttpURLConnection1 = (HttpURLConnection)new URL(str).openConnection();
        localObject1 = localHttpURLConnection1;
        try
        {
          QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "after convert :origin:" + (String)localObject3 + "\nconvert:" + str + "\nhost:" + (String)localObject2);
          localObject1 = localHttpURLConnection1;
          if ((localHttpURLConnection1 instanceof HttpsURLConnection))
          {
            localObject1 = localHttpURLConnection1;
            if (!str.equals(localObject3))
            {
              localObject1 = localHttpURLConnection1;
              localObject3 = new QCircleHttpUrlDW.1(paramOption);
              localObject1 = localHttpURLConnection1;
              ((HttpsURLConnection)localHttpURLConnection1).setSSLSocketFactory(new SniSSLSocketFactory((String)localObject2, (HostnameVerifier)localObject3));
              localObject1 = localHttpURLConnection1;
              ((HttpsURLConnection)localHttpURLConnection1).setHostnameVerifier((HostnameVerifier)localObject3);
            }
          }
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setRequestProperty("Host", (String)localObject2);
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setRequestMethod("GET");
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setRequestProperty("Connection", "Keep-Alive");
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setDoInput(true);
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setAllowUserInteraction(true);
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setConnectTimeout(60000);
          localObject1 = localHttpURLConnection1;
          localHttpURLConnection1.setReadTimeout(120000);
          localObject1 = localHttpURLConnection1;
          if (parambjln.jdField_c_of_type_Long > 0L)
          {
            localObject1 = localHttpURLConnection1;
            localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            localObject1 = localHttpURLConnection1;
            ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
            localObject1 = localHttpURLConnection1;
            localHttpURLConnection1.setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(parambjln.jdField_c_of_type_Long)));
          }
          localObject1 = localHttpURLConnection1;
          i = localHttpURLConnection1.getResponseCode();
          localObject1 = localHttpURLConnection1;
          QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " reponseCode=" + i);
          if ((i != 302) && (i != 301)) {
            continue;
          }
          localObject1 = localHttpURLConnection1;
          localObject2 = localHttpURLConnection1.getHeaderField("Location");
          localObject1 = localHttpURLConnection1;
          QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " loc=" + (String)localObject2);
          localObject1 = localHttpURLConnection1;
          disConnect(localHttpURLConnection1);
          localHttpURLConnection1 = null;
          localObject1 = localHttpURLConnection1;
          QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " uc=" + localHttpURLConnection1);
          return localHttpURLConnection1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        Object localObject2;
        HttpURLConnection localHttpURLConnection2;
        continue;
        continue;
        int i = 1;
        continue;
        i = 0;
        continue;
      }
      QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " Exception!!!", localException1);
      disConnect((HttpURLConnection)localObject1);
      return null;
      if ((i == 200) || (i == 206))
      {
        localObject1 = localException1;
        localObject2 = localException1.getContentType();
        if (localObject2 == null)
        {
          localObject2 = "";
          localObject1 = localException1;
          if (((String)localObject2).indexOf("text/vnd.wap.wml") != -1) {
            continue;
          }
          localObject1 = localException1;
          if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
            continue;
          }
          localObject1 = localException1;
          if (((String)localObject2).indexOf("text") == -1) {
            continue;
          }
          continue;
          if (i == 0) {
            continue;
          }
          localObject1 = localException1;
          disConnect(localException1);
          localHttpURLConnection2 = null;
          if (localHttpURLConnection2 != null)
          {
            localObject1 = localHttpURLConnection2;
            parambjln.jdField_a_of_type_Long = (getMaxAge(localHttpURLConnection2) * 1000L);
            localObject1 = localHttpURLConnection2;
            if (parambjln.jdField_a_of_type_Long == 0L)
            {
              localObject1 = localHttpURLConnection2;
              parambjln.jdField_a_of_type_Long = 86400000L;
            }
          }
          localObject1 = localHttpURLConnection2;
          parambjln.jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = localHttpURLConnection2;
          QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " contentType=" + (String)localObject2);
        }
        else
        {
          localObject1 = localHttpURLConnection2;
          localObject2 = ((String)localObject2).toLowerCase();
        }
      }
      else if (i == 304)
      {
        localObject1 = localHttpURLConnection2;
        QLog.i(TAG, 1, "seq = " + paramOption.getSeq() + "--getHttpConnection-- cacheKey = " + parambjln.jdField_a_of_type_JavaLangString + " --getimg-- " + parambjln.jdField_b_of_type_JavaLangString + " not modified");
        localObject1 = localHttpURLConnection2;
        parambjln.jdField_a_of_type_Long = (getMaxAge(localHttpURLConnection2) * 1000L);
        localObject1 = localHttpURLConnection2;
        parambjln.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject1 = localHttpURLConnection2;
        disConnect(localHttpURLConnection2);
        localHttpURLConnection2 = null;
      }
      else
      {
        localObject1 = localHttpURLConnection2;
        disConnect(localHttpURLConnection2);
        localHttpURLConnection2 = null;
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
  
  /* Error */
  public boolean downloadByHttpURl(bjln parambjln, Option paramOption)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 19
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 17
    //   15: aconst_null
    //   16: astore 16
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic 313	cooperation/qqcircle/picload/QCircleHttpUrlDW:getHttpConnection	(Lbjln;Lcooperation/qqcircle/picload/Option;)Ljava/net/HttpURLConnection;
    //   23: astore 10
    //   25: aload 10
    //   27: astore 9
    //   29: aload 9
    //   31: ifnonnull +120 -> 151
    //   34: getstatic 77	cooperation/qqcircle/picload/QCircleHttpUrlDW:TAG	Ljava/lang/String;
    //   37: iconst_1
    //   38: new 79	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   45: ldc 82
    //   47: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 92	cooperation/qqcircle/picload/Option:getSeq	()I
    //   54: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 315
    //   60: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 215	bjln:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 317
    //   73: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 45	bjln:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 319
    //   86: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iconst_0
    //   96: istore 6
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 321	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 322	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 321	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 322	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: iload 6
    //   124: istore 5
    //   126: aload 9
    //   128: ifnull +12 -> 140
    //   131: aload 9
    //   133: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   136: iload 6
    //   138: istore 5
    //   140: iload 5
    //   142: ireturn
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   148: goto -26 -> 122
    //   151: aload 9
    //   153: invokevirtual 328	java/net/HttpURLConnection:getContentLength	()I
    //   156: i2l
    //   157: lstore 7
    //   159: invokestatic 332	bjht:a	()J
    //   162: lload 7
    //   164: lcmp
    //   165: ifge +111 -> 276
    //   168: getstatic 77	cooperation/qqcircle/picload/QCircleHttpUrlDW:TAG	Ljava/lang/String;
    //   171: iconst_1
    //   172: new 79	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   179: ldc 82
    //   181: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 92	cooperation/qqcircle/picload/Option:getSeq	()I
    //   188: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc_w 334
    //   194: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: getfield 215	bjln:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 317
    //   207: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: getfield 45	bjln:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   214: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 336
    //   220: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iconst_0
    //   230: istore 5
    //   232: iconst_0
    //   233: ifeq +11 -> 244
    //   236: new 321	java/lang/NullPointerException
    //   239: dup
    //   240: invokespecial 322	java/lang/NullPointerException:<init>	()V
    //   243: athrow
    //   244: iconst_0
    //   245: ifeq +11 -> 256
    //   248: new 321	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 322	java/lang/NullPointerException:<init>	()V
    //   255: athrow
    //   256: aload 9
    //   258: ifnull -118 -> 140
    //   261: aload 9
    //   263: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   273: goto -17 -> 256
    //   276: aload 9
    //   278: invokevirtual 340	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   281: astore 10
    //   283: lconst_0
    //   284: lstore 7
    //   286: aload 19
    //   288: astore 14
    //   290: aload 10
    //   292: astore 13
    //   294: aload 9
    //   296: astore 12
    //   298: getstatic 11	cooperation/qqcircle/picload/QCircleHttpUrlDW:dataBlockLength	I
    //   301: newarray byte
    //   303: astore 11
    //   305: aload 19
    //   307: astore 14
    //   309: aload 10
    //   311: astore 13
    //   313: aload 9
    //   315: astore 12
    //   317: new 342	java/io/ByteArrayOutputStream
    //   320: dup
    //   321: invokespecial 343	java/io/ByteArrayOutputStream:<init>	()V
    //   324: astore 20
    //   326: aload 19
    //   328: astore 14
    //   330: aload 10
    //   332: astore 13
    //   334: aload 9
    //   336: astore 12
    //   338: aload 10
    //   340: aload 11
    //   342: iconst_0
    //   343: getstatic 11	cooperation/qqcircle/picload/QCircleHttpUrlDW:dataBlockLength	I
    //   346: invokevirtual 349	java/io/InputStream:read	([BII)I
    //   349: istore_3
    //   350: iload_3
    //   351: ifle +105 -> 456
    //   354: aload 19
    //   356: astore 14
    //   358: aload 10
    //   360: astore 13
    //   362: aload 9
    //   364: astore 12
    //   366: getstatic 14	cooperation/qqcircle/picload/QCircleHttpUrlDW:max_length	I
    //   369: istore 4
    //   371: lload 7
    //   373: iload 4
    //   375: i2l
    //   376: lcmp
    //   377: iflt +48 -> 425
    //   380: iconst_0
    //   381: istore 5
    //   383: iconst_0
    //   384: ifeq +11 -> 395
    //   387: new 321	java/lang/NullPointerException
    //   390: dup
    //   391: invokespecial 322	java/lang/NullPointerException:<init>	()V
    //   394: athrow
    //   395: aload 10
    //   397: ifnull +8 -> 405
    //   400: aload 10
    //   402: invokevirtual 352	java/io/InputStream:close	()V
    //   405: aload 9
    //   407: ifnull -267 -> 140
    //   410: aload 9
    //   412: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   415: iconst_0
    //   416: ireturn
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   422: goto -17 -> 405
    //   425: aload 19
    //   427: astore 14
    //   429: aload 10
    //   431: astore 13
    //   433: aload 9
    //   435: astore 12
    //   437: aload 20
    //   439: aload 11
    //   441: iconst_0
    //   442: iload_3
    //   443: invokevirtual 356	java/io/ByteArrayOutputStream:write	([BII)V
    //   446: lload 7
    //   448: iload_3
    //   449: i2l
    //   450: ladd
    //   451: lstore 7
    //   453: goto -127 -> 326
    //   456: aload 19
    //   458: astore 14
    //   460: aload 10
    //   462: astore 13
    //   464: aload 9
    //   466: astore 12
    //   468: aload_1
    //   469: getfield 358	bjln:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   472: astore 21
    //   474: aload 19
    //   476: astore 14
    //   478: aload 10
    //   480: astore 13
    //   482: aload 9
    //   484: astore 12
    //   486: new 360	java/io/File
    //   489: dup
    //   490: new 79	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   497: aload 21
    //   499: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 362
    //   505: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: astore 15
    //   516: aload 19
    //   518: astore 14
    //   520: aload 10
    //   522: astore 13
    //   524: aload 9
    //   526: astore 12
    //   528: aload 15
    //   530: invokevirtual 366	java/io/File:getParent	()Ljava/lang/String;
    //   533: ifnull +47 -> 580
    //   536: aload 19
    //   538: astore 14
    //   540: aload 10
    //   542: astore 13
    //   544: aload 9
    //   546: astore 12
    //   548: aload 15
    //   550: invokevirtual 370	java/io/File:getParentFile	()Ljava/io/File;
    //   553: invokevirtual 374	java/io/File:exists	()Z
    //   556: ifne +24 -> 580
    //   559: aload 19
    //   561: astore 14
    //   563: aload 10
    //   565: astore 13
    //   567: aload 9
    //   569: astore 12
    //   571: aload 15
    //   573: invokevirtual 370	java/io/File:getParentFile	()Ljava/io/File;
    //   576: invokevirtual 377	java/io/File:mkdirs	()Z
    //   579: pop
    //   580: aload 19
    //   582: astore 14
    //   584: aload 10
    //   586: astore 13
    //   588: aload 9
    //   590: astore 12
    //   592: aload 15
    //   594: invokevirtual 374	java/io/File:exists	()Z
    //   597: ifeq +21 -> 618
    //   600: aload 19
    //   602: astore 14
    //   604: aload 10
    //   606: astore 13
    //   608: aload 9
    //   610: astore 12
    //   612: aload 15
    //   614: invokevirtual 380	java/io/File:delete	()Z
    //   617: pop
    //   618: aload 19
    //   620: astore 14
    //   622: aload 10
    //   624: astore 13
    //   626: aload 9
    //   628: astore 12
    //   630: aload 15
    //   632: invokevirtual 383	java/io/File:createNewFile	()Z
    //   635: pop
    //   636: aload 19
    //   638: astore 14
    //   640: aload 10
    //   642: astore 13
    //   644: aload 9
    //   646: astore 12
    //   648: new 385	java/io/FileOutputStream
    //   651: dup
    //   652: new 79	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   659: aload 21
    //   661: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 362
    //   667: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokespecial 386	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   676: astore 11
    //   678: aload 11
    //   680: aload 20
    //   682: invokevirtual 390	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   685: invokevirtual 393	java/io/FileOutputStream:write	([B)V
    //   688: aload 11
    //   690: invokevirtual 396	java/io/FileOutputStream:flush	()V
    //   693: new 360	java/io/File
    //   696: dup
    //   697: aload 21
    //   699: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   702: astore 14
    //   704: aload 14
    //   706: invokevirtual 374	java/io/File:exists	()Z
    //   709: ifeq +9 -> 718
    //   712: aload 14
    //   714: invokevirtual 380	java/io/File:delete	()Z
    //   717: pop
    //   718: aload 15
    //   720: aload 14
    //   722: invokevirtual 400	java/io/File:renameTo	(Ljava/io/File;)Z
    //   725: pop
    //   726: getstatic 77	cooperation/qqcircle/picload/QCircleHttpUrlDW:TAG	Ljava/lang/String;
    //   729: iconst_1
    //   730: new 79	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   737: ldc 82
    //   739: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_2
    //   743: invokevirtual 92	cooperation/qqcircle/picload/Option:getSeq	()I
    //   746: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   749: ldc_w 402
    //   752: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_1
    //   756: getfield 215	bjln:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   759: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: ldc_w 317
    //   765: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_1
    //   769: getfield 45	bjln:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   772: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: aload_1
    //   782: aload 9
    //   784: invokevirtual 405	java/net/HttpURLConnection:getLastModified	()J
    //   787: putfield 171	bjln:jdField_c_of_type_Long	J
    //   790: iconst_1
    //   791: istore 5
    //   793: aload 11
    //   795: ifnull +8 -> 803
    //   798: aload 11
    //   800: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   803: aload 10
    //   805: ifnull +8 -> 813
    //   808: aload 10
    //   810: invokevirtual 352	java/io/InputStream:close	()V
    //   813: aload 9
    //   815: ifnull -675 -> 140
    //   818: aload 9
    //   820: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   823: iconst_1
    //   824: ireturn
    //   825: astore_1
    //   826: aload_1
    //   827: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   830: goto -17 -> 813
    //   833: astore 12
    //   835: aconst_null
    //   836: astore 10
    //   838: aconst_null
    //   839: astore 13
    //   841: aload 9
    //   843: astore 11
    //   845: aload 13
    //   847: astore 9
    //   849: aload 17
    //   851: astore 13
    //   853: aload 16
    //   855: astore 14
    //   857: getstatic 77	cooperation/qqcircle/picload/QCircleHttpUrlDW:TAG	Ljava/lang/String;
    //   860: iconst_1
    //   861: new 79	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   868: ldc 82
    //   870: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_2
    //   874: invokevirtual 92	cooperation/qqcircle/picload/Option:getSeq	()I
    //   877: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: ldc_w 408
    //   883: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_1
    //   887: getfield 215	bjln:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   890: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: ldc_w 410
    //   896: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload 12
    //   901: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 413	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: aload 13
    //   912: ifnull +17 -> 929
    //   915: aload 13
    //   917: invokevirtual 374	java/io/File:exists	()Z
    //   920: ifeq +9 -> 929
    //   923: aload 13
    //   925: invokevirtual 380	java/io/File:delete	()Z
    //   928: pop
    //   929: aload 14
    //   931: ifnull +17 -> 948
    //   934: aload 14
    //   936: invokevirtual 374	java/io/File:exists	()Z
    //   939: ifeq +9 -> 948
    //   942: aload 14
    //   944: invokevirtual 380	java/io/File:delete	()Z
    //   947: pop
    //   948: aload 9
    //   950: ifnull +8 -> 958
    //   953: aload 9
    //   955: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   958: aload 10
    //   960: ifnull +8 -> 968
    //   963: aload 10
    //   965: invokevirtual 352	java/io/InputStream:close	()V
    //   968: aload 11
    //   970: ifnull +8 -> 978
    //   973: aload 11
    //   975: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   978: iconst_0
    //   979: ireturn
    //   980: astore_1
    //   981: aload_1
    //   982: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   985: goto -17 -> 968
    //   988: astore 11
    //   990: aconst_null
    //   991: astore 10
    //   993: aconst_null
    //   994: astore 9
    //   996: aload 18
    //   998: astore 15
    //   1000: aload 15
    //   1002: astore 14
    //   1004: aload 10
    //   1006: astore 13
    //   1008: aload 9
    //   1010: astore 12
    //   1012: getstatic 77	cooperation/qqcircle/picload/QCircleHttpUrlDW:TAG	Ljava/lang/String;
    //   1015: iconst_1
    //   1016: new 79	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1023: ldc 82
    //   1025: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload_2
    //   1029: invokevirtual 92	cooperation/qqcircle/picload/Option:getSeq	()I
    //   1032: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1035: ldc_w 408
    //   1038: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload_1
    //   1042: getfield 215	bjln:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1045: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: ldc_w 415
    //   1051: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload 11
    //   1056: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 413	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: iconst_0
    //   1066: istore 5
    //   1068: aload 15
    //   1070: ifnull +8 -> 1078
    //   1073: aload 15
    //   1075: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   1078: aload 10
    //   1080: ifnull +8 -> 1088
    //   1083: aload 10
    //   1085: invokevirtual 352	java/io/InputStream:close	()V
    //   1088: aload 9
    //   1090: ifnull -950 -> 140
    //   1093: aload 9
    //   1095: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   1098: iconst_0
    //   1099: ireturn
    //   1100: astore_1
    //   1101: aload_1
    //   1102: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   1105: goto -17 -> 1088
    //   1108: astore_1
    //   1109: aconst_null
    //   1110: astore 10
    //   1112: aconst_null
    //   1113: astore 9
    //   1115: aload 11
    //   1117: astore_2
    //   1118: aload_2
    //   1119: ifnull +7 -> 1126
    //   1122: aload_2
    //   1123: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   1126: aload 10
    //   1128: ifnull +8 -> 1136
    //   1131: aload 10
    //   1133: invokevirtual 352	java/io/InputStream:close	()V
    //   1136: aload 9
    //   1138: ifnull +8 -> 1146
    //   1141: aload 9
    //   1143: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   1146: aload_1
    //   1147: athrow
    //   1148: astore_2
    //   1149: aload_2
    //   1150: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   1153: goto -17 -> 1136
    //   1156: astore_1
    //   1157: aconst_null
    //   1158: astore 10
    //   1160: aload 11
    //   1162: astore_2
    //   1163: goto -45 -> 1118
    //   1166: astore_1
    //   1167: aload 14
    //   1169: astore_2
    //   1170: aload 13
    //   1172: astore 10
    //   1174: aload 12
    //   1176: astore 9
    //   1178: goto -60 -> 1118
    //   1181: astore_1
    //   1182: aload 11
    //   1184: astore_2
    //   1185: goto -67 -> 1118
    //   1188: astore_1
    //   1189: aload 9
    //   1191: astore_2
    //   1192: aload 11
    //   1194: astore 9
    //   1196: goto -78 -> 1118
    //   1199: astore 11
    //   1201: aconst_null
    //   1202: astore 10
    //   1204: aload 18
    //   1206: astore 15
    //   1208: goto -208 -> 1000
    //   1211: astore 11
    //   1213: aload 18
    //   1215: astore 15
    //   1217: goto -217 -> 1000
    //   1220: astore 12
    //   1222: aload 11
    //   1224: astore 15
    //   1226: aload 12
    //   1228: astore 11
    //   1230: goto -230 -> 1000
    //   1233: astore 12
    //   1235: aload 9
    //   1237: astore 11
    //   1239: aconst_null
    //   1240: astore 9
    //   1242: aconst_null
    //   1243: astore 10
    //   1245: aload 16
    //   1247: astore 14
    //   1249: aload 17
    //   1251: astore 13
    //   1253: goto -396 -> 857
    //   1256: astore 12
    //   1258: aconst_null
    //   1259: astore 15
    //   1261: aload 9
    //   1263: astore 11
    //   1265: aload 16
    //   1267: astore 14
    //   1269: aload 17
    //   1271: astore 13
    //   1273: aload 15
    //   1275: astore 9
    //   1277: goto -420 -> 857
    //   1280: astore 12
    //   1282: aload 15
    //   1284: astore 13
    //   1286: aload 9
    //   1288: astore 11
    //   1290: aconst_null
    //   1291: astore 9
    //   1293: aload 16
    //   1295: astore 14
    //   1297: goto -440 -> 857
    //   1300: astore 12
    //   1302: aload 15
    //   1304: astore 13
    //   1306: aload 11
    //   1308: astore 15
    //   1310: aload 9
    //   1312: astore 11
    //   1314: aload 16
    //   1316: astore 14
    //   1318: aload 15
    //   1320: astore 9
    //   1322: goto -465 -> 857
    //   1325: astore 12
    //   1327: aload 15
    //   1329: astore 13
    //   1331: aload 11
    //   1333: astore 15
    //   1335: aload 9
    //   1337: astore 11
    //   1339: aload 15
    //   1341: astore 9
    //   1343: goto -486 -> 857
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1346	0	this	QCircleHttpUrlDW
    //   0	1346	1	parambjln	bjln
    //   0	1346	2	paramOption	Option
    //   349	100	3	i	int
    //   369	5	4	j	int
    //   124	943	5	bool1	boolean
    //   96	41	6	bool2	boolean
    //   157	295	7	l	long
    //   1	1341	9	localObject1	Object
    //   23	1221	10	localObject2	Object
    //   4	970	11	localObject3	Object
    //   988	205	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1199	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1211	12	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1228	110	11	localObject4	Object
    //   296	351	12	localObject5	Object
    //   833	67	12	localException1	Exception
    //   1010	165	12	localObject6	Object
    //   1220	7	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1233	1	12	localException2	Exception
    //   1256	1	12	localException3	Exception
    //   1280	1	12	localException4	Exception
    //   1300	1	12	localException5	Exception
    //   1325	1	12	localException6	Exception
    //   292	1038	13	localObject7	Object
    //   288	1029	14	localObject8	Object
    //   514	826	15	localObject9	Object
    //   16	1299	16	localObject10	Object
    //   13	1257	17	localObject11	Object
    //   10	1204	18	localObject12	Object
    //   7	630	19	localObject13	Object
    //   324	357	20	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   472	226	21	str	String
    // Exception table:
    //   from	to	target	type
    //   102	110	143	java/lang/Exception
    //   114	122	143	java/lang/Exception
    //   236	244	268	java/lang/Exception
    //   248	256	268	java/lang/Exception
    //   387	395	417	java/lang/Exception
    //   400	405	417	java/lang/Exception
    //   798	803	825	java/lang/Exception
    //   808	813	825	java/lang/Exception
    //   18	25	833	java/lang/Exception
    //   953	958	980	java/lang/Exception
    //   963	968	980	java/lang/Exception
    //   18	25	988	java/lang/OutOfMemoryError
    //   1073	1078	1100	java/lang/Exception
    //   1083	1088	1100	java/lang/Exception
    //   18	25	1108	finally
    //   1122	1126	1148	java/lang/Exception
    //   1131	1136	1148	java/lang/Exception
    //   34	95	1156	finally
    //   151	229	1156	finally
    //   276	283	1156	finally
    //   298	305	1166	finally
    //   317	326	1166	finally
    //   338	350	1166	finally
    //   366	371	1166	finally
    //   437	446	1166	finally
    //   468	474	1166	finally
    //   486	516	1166	finally
    //   528	536	1166	finally
    //   548	559	1166	finally
    //   571	580	1166	finally
    //   592	600	1166	finally
    //   612	618	1166	finally
    //   630	636	1166	finally
    //   648	678	1166	finally
    //   1012	1065	1166	finally
    //   678	704	1181	finally
    //   704	718	1181	finally
    //   718	790	1181	finally
    //   857	910	1188	finally
    //   915	929	1188	finally
    //   934	948	1188	finally
    //   34	95	1199	java/lang/OutOfMemoryError
    //   151	229	1199	java/lang/OutOfMemoryError
    //   276	283	1199	java/lang/OutOfMemoryError
    //   298	305	1211	java/lang/OutOfMemoryError
    //   317	326	1211	java/lang/OutOfMemoryError
    //   338	350	1211	java/lang/OutOfMemoryError
    //   366	371	1211	java/lang/OutOfMemoryError
    //   437	446	1211	java/lang/OutOfMemoryError
    //   468	474	1211	java/lang/OutOfMemoryError
    //   486	516	1211	java/lang/OutOfMemoryError
    //   528	536	1211	java/lang/OutOfMemoryError
    //   548	559	1211	java/lang/OutOfMemoryError
    //   571	580	1211	java/lang/OutOfMemoryError
    //   592	600	1211	java/lang/OutOfMemoryError
    //   612	618	1211	java/lang/OutOfMemoryError
    //   630	636	1211	java/lang/OutOfMemoryError
    //   648	678	1211	java/lang/OutOfMemoryError
    //   678	704	1220	java/lang/OutOfMemoryError
    //   704	718	1220	java/lang/OutOfMemoryError
    //   718	790	1220	java/lang/OutOfMemoryError
    //   34	95	1233	java/lang/Exception
    //   151	229	1233	java/lang/Exception
    //   276	283	1233	java/lang/Exception
    //   298	305	1256	java/lang/Exception
    //   317	326	1256	java/lang/Exception
    //   338	350	1256	java/lang/Exception
    //   366	371	1256	java/lang/Exception
    //   437	446	1256	java/lang/Exception
    //   468	474	1256	java/lang/Exception
    //   486	516	1256	java/lang/Exception
    //   528	536	1280	java/lang/Exception
    //   548	559	1280	java/lang/Exception
    //   571	580	1280	java/lang/Exception
    //   592	600	1280	java/lang/Exception
    //   612	618	1280	java/lang/Exception
    //   630	636	1280	java/lang/Exception
    //   648	678	1280	java/lang/Exception
    //   678	704	1300	java/lang/Exception
    //   704	718	1325	java/lang/Exception
    //   718	790	1325	java/lang/Exception
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    bjln localbjln = new bjln();
    localbjln.jdField_c_of_type_JavaLangString = paramOption.getLocalPath();
    localbjln.jdField_c_of_type_Long = 0L;
    localbjln.jdField_a_of_type_JavaLangString = paramOption.getCacheKey();
    localbjln.jdField_b_of_type_JavaLangString = paramOption.getUrl();
    if (downloadByHttpURl(localbjln, paramOption)) {
      paramICallBackListener.callBack(paramOption, true, 0);
    }
    while (getNextDw() == null) {
      return;
    }
    getNextDw().handlerDownLoad(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpUrlDW
 * JD-Core Version:    0.7.0.1
 */