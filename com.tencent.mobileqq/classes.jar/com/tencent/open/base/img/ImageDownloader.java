package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ImageDownloader
{
  protected static int a;
  protected static String a;
  protected static int b = 1048576;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ImageDownloader";
    jdField_a_of_type_Int = 2048;
  }
  
  protected static long a(HttpURLConnection paramHttpURLConnection)
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
  
  protected static HttpURLConnection a(ImageInfo paramImageInfo)
  {
    for (;;)
    {
      try
      {
        localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.jdField_b_of_type_JavaLangString);
        if (APNUtil.a(CommonDataAdapter.a().a()))
        {
          i = "http://".length();
          localObject3 = APNUtil.c(CommonDataAdapter.a().a());
          String str = APNUtil.d(CommonDataAdapter.a().a());
          j = ((String)localObject1).indexOf('/', i);
          if (j < 0)
          {
            localObject2 = ((String)localObject1).substring(i);
            localObject1 = "";
            LogUtility.c(jdField_a_of_type_JavaLangString, "http://" + (String)localObject3 + ":" + str + (String)localObject1);
            localObject3 = (HttpURLConnection)new URL("http://" + (String)localObject3 + ":" + str + (String)localObject1).openConnection();
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception paramImageInfo)
      {
        int j;
        Object localObject2;
        localObject3 = null;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- Exception!!!", paramImageInfo);
        a((HttpURLConnection)localObject3);
        return null;
      }
      try
      {
        ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
        localObject1 = localObject3;
        localObject3 = localObject1;
      }
      catch (Exception paramImageInfo)
      {
        localObject3 = localObject1;
        continue;
      }
      try
      {
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setConnectTimeout(60000);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setReadTimeout(120000);
        localObject3 = localObject1;
        if (paramImageInfo.jdField_c_of_type_Long > 0L)
        {
          localObject3 = localObject1;
          localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
          localObject3 = localObject1;
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(paramImageInfo.jdField_c_of_type_Long)));
        }
        localObject3 = localObject1;
        i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- reponseCode=" + i);
        if ((i == 302) || (i == 301))
        {
          localObject3 = localObject1;
          paramImageInfo = ((HttpURLConnection)localObject1).getHeaderField("Location");
          localObject3 = localObject1;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- loc=" + paramImageInfo);
          localObject3 = localObject1;
          a((HttpURLConnection)localObject1);
          paramImageInfo = null;
          localObject1 = paramImageInfo;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- uc=" + paramImageInfo);
          return paramImageInfo;
          localObject2 = ((String)localObject1).substring(i, j);
          localObject1 = ((String)localObject1).substring(j);
          continue;
          localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
          continue;
        }
        if ((i != 200) && (i != 206)) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = ((HttpURLConnection)localObject1).getContentType();
        if (localObject2 != null) {
          continue;
        }
        localObject2 = "";
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text/vnd.wap.wml") != -1) {
          break label743;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
          break label743;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text") == -1) {
          break label748;
        }
      }
      catch (Exception paramImageInfo)
      {
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      localObject2 = localObject1;
      if (i != 0)
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject2) * 1000L);
        localObject3 = localObject2;
        if (paramImageInfo.jdField_a_of_type_Long == 0L)
        {
          localObject3 = localObject2;
          paramImageInfo.jdField_a_of_type_Long = 86400000L;
        }
      }
      localObject3 = localObject2;
      paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      paramImageInfo = (ImageInfo)localObject2;
      continue;
      localObject3 = localObject1;
      localObject2 = ((String)localObject2).toLowerCase();
      continue;
      if (i == 304)
      {
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getimg-- " + paramImageInfo.jdField_b_of_type_JavaLangString + " not modified");
        localObject3 = localObject1;
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject1) * 1000L);
        localObject3 = localObject1;
        paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
      else
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
    }
  }
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
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
  
  /* Error */
  public static boolean a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: invokestatic 275	com/tencent/open/base/img/ImageDownloader:a	(Lcom/tencent/open/base/img/ImageInfo;)Ljava/net/HttpURLConnection;
    //   13: astore 7
    //   15: aload 7
    //   17: ifnonnull +88 -> 105
    //   20: getstatic 14	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: new 117	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 277
    //   33: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 75	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 279
    //   46: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 132	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 281	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 281	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: iload 4
    //   81: istore_3
    //   82: aload 7
    //   84: ifnull +11 -> 95
    //   87: aload 7
    //   89: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   92: iload 4
    //   94: istore_3
    //   95: iload_3
    //   96: ireturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   102: goto -23 -> 79
    //   105: aload 7
    //   107: invokevirtual 288	java/net/HttpURLConnection:getContentLength	()I
    //   110: i2l
    //   111: lstore 5
    //   113: invokestatic 292	com/tencent/open/appcommon/Common:a	()J
    //   116: lload 5
    //   118: lcmp
    //   119: ifge +85 -> 204
    //   122: getstatic 14	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   125: new 117	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 277
    //   135: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 75	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   142: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 294
    //   148: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 132	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iconst_0
    //   158: ifeq +11 -> 169
    //   161: new 281	java/lang/NullPointerException
    //   164: dup
    //   165: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   168: athrow
    //   169: iconst_0
    //   170: ifeq +11 -> 181
    //   173: new 281	java/lang/NullPointerException
    //   176: dup
    //   177: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   180: athrow
    //   181: iload 4
    //   183: istore_3
    //   184: aload 7
    //   186: ifnull -91 -> 95
    //   189: aload 7
    //   191: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   201: goto -20 -> 181
    //   204: aload 7
    //   206: invokevirtual 298	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   209: astore 8
    //   211: lconst_0
    //   212: lstore 5
    //   214: getstatic 16	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   217: newarray byte
    //   219: astore 9
    //   221: new 300	java/io/ByteArrayOutputStream
    //   224: dup
    //   225: invokespecial 301	java/io/ByteArrayOutputStream:<init>	()V
    //   228: astore 13
    //   230: aload 8
    //   232: aload 9
    //   234: iconst_0
    //   235: getstatic 16	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   238: invokevirtual 307	java/io/InputStream:read	([BII)I
    //   241: istore_2
    //   242: iload_2
    //   243: ifle +79 -> 322
    //   246: getstatic 19	com/tencent/open/base/img/ImageDownloader:b	I
    //   249: istore_1
    //   250: lload 5
    //   252: iload_1
    //   253: i2l
    //   254: lcmp
    //   255: iflt +48 -> 303
    //   258: iconst_0
    //   259: ifeq +11 -> 270
    //   262: new 281	java/lang/NullPointerException
    //   265: dup
    //   266: invokespecial 282	java/lang/NullPointerException:<init>	()V
    //   269: athrow
    //   270: aload 8
    //   272: ifnull +8 -> 280
    //   275: aload 8
    //   277: invokevirtual 310	java/io/InputStream:close	()V
    //   280: iload 4
    //   282: istore_3
    //   283: aload 7
    //   285: ifnull -190 -> 95
    //   288: aload 7
    //   290: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_0
    //   296: aload_0
    //   297: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   300: goto -20 -> 280
    //   303: aload 13
    //   305: aload 9
    //   307: iconst_0
    //   308: iload_2
    //   309: invokevirtual 314	java/io/ByteArrayOutputStream:write	([BII)V
    //   312: lload 5
    //   314: iload_2
    //   315: i2l
    //   316: ladd
    //   317: lstore 5
    //   319: goto -89 -> 230
    //   322: new 117	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   329: invokestatic 316	com/tencent/open/appcommon/Common:d	()Ljava/lang/String;
    //   332: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: getstatic 319	com/tencent/open/base/img/ImageCache:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   338: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 321	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   345: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: getstatic 326	java/io/File:separator	Ljava/lang/String;
    //   351: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 75	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   358: invokestatic 330	com/tencent/open/base/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 14
    //   369: new 323	java/io/File
    //   372: dup
    //   373: new 117	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   380: aload 14
    //   382: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc_w 332
    //   388: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: astore 10
    //   399: aload 10
    //   401: invokevirtual 336	java/io/File:getParent	()Ljava/lang/String;
    //   404: ifnull +23 -> 427
    //   407: aload 10
    //   409: invokevirtual 340	java/io/File:getParentFile	()Ljava/io/File;
    //   412: invokevirtual 344	java/io/File:exists	()Z
    //   415: ifne +12 -> 427
    //   418: aload 10
    //   420: invokevirtual 340	java/io/File:getParentFile	()Ljava/io/File;
    //   423: invokevirtual 347	java/io/File:mkdirs	()Z
    //   426: pop
    //   427: aload 10
    //   429: invokevirtual 344	java/io/File:exists	()Z
    //   432: ifeq +9 -> 441
    //   435: aload 10
    //   437: invokevirtual 350	java/io/File:delete	()Z
    //   440: pop
    //   441: aload 10
    //   443: invokevirtual 353	java/io/File:createNewFile	()Z
    //   446: pop
    //   447: new 355	java/io/FileOutputStream
    //   450: dup
    //   451: new 117	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   458: aload 14
    //   460: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc_w 332
    //   466: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokespecial 356	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   475: astore 9
    //   477: aload 9
    //   479: aload 13
    //   481: invokevirtual 360	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   484: invokevirtual 363	java/io/FileOutputStream:write	([B)V
    //   487: aload 9
    //   489: invokevirtual 366	java/io/FileOutputStream:flush	()V
    //   492: new 323	java/io/File
    //   495: dup
    //   496: aload 14
    //   498: invokespecial 333	java/io/File:<init>	(Ljava/lang/String;)V
    //   501: astore 12
    //   503: aload 12
    //   505: invokevirtual 344	java/io/File:exists	()Z
    //   508: ifeq +9 -> 517
    //   511: aload 12
    //   513: invokevirtual 350	java/io/File:delete	()Z
    //   516: pop
    //   517: aload 10
    //   519: aload 12
    //   521: invokevirtual 370	java/io/File:renameTo	(Ljava/io/File;)Z
    //   524: pop
    //   525: ldc_w 372
    //   528: aload_0
    //   529: getfield 373	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   532: invokestatic 132	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: aload 7
    //   538: invokevirtual 376	java/net/HttpURLConnection:getLastModified	()J
    //   541: putfield 170	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   544: iconst_1
    //   545: istore_3
    //   546: aload 9
    //   548: ifnull +8 -> 556
    //   551: aload 9
    //   553: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   556: aload 8
    //   558: ifnull +8 -> 566
    //   561: aload 8
    //   563: invokevirtual 310	java/io/InputStream:close	()V
    //   566: aload 7
    //   568: ifnull -473 -> 95
    //   571: aload 7
    //   573: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   576: iconst_1
    //   577: ireturn
    //   578: astore_0
    //   579: aload_0
    //   580: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   583: goto -17 -> 566
    //   586: astore 9
    //   588: aconst_null
    //   589: astore 10
    //   591: aconst_null
    //   592: astore_0
    //   593: aconst_null
    //   594: astore 7
    //   596: aconst_null
    //   597: astore 8
    //   599: getstatic 14	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   602: ldc_w 379
    //   605: aload 9
    //   607: invokestatic 269	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   610: aload 10
    //   612: ifnull +17 -> 629
    //   615: aload 10
    //   617: invokevirtual 344	java/io/File:exists	()Z
    //   620: ifeq +9 -> 629
    //   623: aload 10
    //   625: invokevirtual 350	java/io/File:delete	()Z
    //   628: pop
    //   629: aload 11
    //   631: ifnull +17 -> 648
    //   634: aload 11
    //   636: invokevirtual 344	java/io/File:exists	()Z
    //   639: ifeq +9 -> 648
    //   642: aload 11
    //   644: invokevirtual 350	java/io/File:delete	()Z
    //   647: pop
    //   648: aload_0
    //   649: ifnull +7 -> 656
    //   652: aload_0
    //   653: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   656: aload 7
    //   658: ifnull +8 -> 666
    //   661: aload 7
    //   663: invokevirtual 310	java/io/InputStream:close	()V
    //   666: iload 4
    //   668: istore_3
    //   669: aload 8
    //   671: ifnull -576 -> 95
    //   674: aload 8
    //   676: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   679: iconst_0
    //   680: ireturn
    //   681: astore_0
    //   682: aload_0
    //   683: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   686: goto -20 -> 666
    //   689: astore_0
    //   690: aconst_null
    //   691: astore 8
    //   693: aconst_null
    //   694: astore 7
    //   696: aload 12
    //   698: astore 9
    //   700: aload 9
    //   702: ifnull +8 -> 710
    //   705: aload 9
    //   707: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   710: aload 8
    //   712: ifnull +8 -> 720
    //   715: aload 8
    //   717: invokevirtual 310	java/io/InputStream:close	()V
    //   720: aload 7
    //   722: ifnull +8 -> 730
    //   725: aload 7
    //   727: invokevirtual 272	java/net/HttpURLConnection:disconnect	()V
    //   730: aload_0
    //   731: athrow
    //   732: astore 8
    //   734: aload 8
    //   736: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   739: goto -19 -> 720
    //   742: astore_0
    //   743: aconst_null
    //   744: astore 8
    //   746: aload 12
    //   748: astore 9
    //   750: goto -50 -> 700
    //   753: astore_0
    //   754: aload 12
    //   756: astore 9
    //   758: goto -58 -> 700
    //   761: astore_0
    //   762: goto -62 -> 700
    //   765: astore 11
    //   767: aload_0
    //   768: astore 9
    //   770: aload 8
    //   772: astore 10
    //   774: aload 11
    //   776: astore_0
    //   777: aload 7
    //   779: astore 8
    //   781: aload 10
    //   783: astore 7
    //   785: goto -85 -> 700
    //   788: astore 9
    //   790: aconst_null
    //   791: astore 10
    //   793: aconst_null
    //   794: astore_0
    //   795: aconst_null
    //   796: astore 12
    //   798: aload 7
    //   800: astore 8
    //   802: aload 12
    //   804: astore 7
    //   806: goto -207 -> 599
    //   809: astore 9
    //   811: aconst_null
    //   812: astore 10
    //   814: aconst_null
    //   815: astore_0
    //   816: aload 7
    //   818: astore 12
    //   820: aload 8
    //   822: astore 7
    //   824: aload 12
    //   826: astore 8
    //   828: goto -229 -> 599
    //   831: astore 9
    //   833: aload 8
    //   835: astore 12
    //   837: aconst_null
    //   838: astore_0
    //   839: aload 7
    //   841: astore 8
    //   843: aload 12
    //   845: astore 7
    //   847: goto -248 -> 599
    //   850: astore 13
    //   852: aload 9
    //   854: astore_0
    //   855: aload 7
    //   857: astore 12
    //   859: aload 13
    //   861: astore 9
    //   863: aload 8
    //   865: astore 7
    //   867: aload 12
    //   869: astore 8
    //   871: goto -272 -> 599
    //   874: astore 13
    //   876: aload 12
    //   878: astore 11
    //   880: aload 9
    //   882: astore_0
    //   883: aload 7
    //   885: astore 12
    //   887: aload 13
    //   889: astore 9
    //   891: aload 8
    //   893: astore 7
    //   895: aload 12
    //   897: astore 8
    //   899: goto -300 -> 599
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	paramImageInfo	ImageInfo
    //   249	4	1	i	int
    //   241	74	2	j	int
    //   81	588	3	bool1	boolean
    //   7	660	4	bool2	boolean
    //   111	207	5	l	long
    //   13	881	7	localObject1	Object
    //   209	507	8	localInputStream	java.io.InputStream
    //   732	3	8	localException1	Exception
    //   744	154	8	localObject2	Object
    //   219	333	9	localObject3	Object
    //   586	20	9	localException2	Exception
    //   698	71	9	localObject4	Object
    //   788	1	9	localException3	Exception
    //   809	1	9	localException4	Exception
    //   831	22	9	localException5	Exception
    //   861	29	9	localObject5	Object
    //   397	416	10	localObject6	Object
    //   4	639	11	localObject7	Object
    //   765	10	11	localObject8	Object
    //   878	1	11	localObject9	Object
    //   1	895	12	localObject10	Object
    //   228	252	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   850	10	13	localException6	Exception
    //   874	14	13	localException7	Exception
    //   367	130	14	str	String
    // Exception table:
    //   from	to	target	type
    //   59	67	97	java/lang/Exception
    //   71	79	97	java/lang/Exception
    //   161	169	196	java/lang/Exception
    //   173	181	196	java/lang/Exception
    //   262	270	295	java/lang/Exception
    //   275	280	295	java/lang/Exception
    //   551	556	578	java/lang/Exception
    //   561	566	578	java/lang/Exception
    //   9	15	586	java/lang/Exception
    //   652	656	681	java/lang/Exception
    //   661	666	681	java/lang/Exception
    //   9	15	689	finally
    //   705	710	732	java/lang/Exception
    //   715	720	732	java/lang/Exception
    //   20	55	742	finally
    //   105	157	742	finally
    //   204	211	742	finally
    //   214	230	753	finally
    //   230	242	753	finally
    //   246	250	753	finally
    //   303	312	753	finally
    //   322	399	753	finally
    //   399	427	753	finally
    //   427	441	753	finally
    //   441	477	753	finally
    //   477	503	761	finally
    //   503	517	761	finally
    //   517	544	761	finally
    //   599	610	765	finally
    //   615	629	765	finally
    //   634	648	765	finally
    //   20	55	788	java/lang/Exception
    //   105	157	788	java/lang/Exception
    //   204	211	788	java/lang/Exception
    //   214	230	809	java/lang/Exception
    //   230	242	809	java/lang/Exception
    //   246	250	809	java/lang/Exception
    //   303	312	809	java/lang/Exception
    //   322	399	809	java/lang/Exception
    //   399	427	831	java/lang/Exception
    //   427	441	831	java/lang/Exception
    //   441	477	831	java/lang/Exception
    //   477	503	850	java/lang/Exception
    //   503	517	874	java/lang/Exception
    //   517	544	874	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */