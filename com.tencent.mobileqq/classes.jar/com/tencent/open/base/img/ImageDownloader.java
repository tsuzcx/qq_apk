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
  protected static int a = 2048;
  protected static String a = "ImageDownloader";
  protected static int b = 1048576;
  
  protected static long a(HttpURLConnection paramHttpURLConnection)
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
  
  protected static HttpURLConnection a(ImageInfo paramImageInfo)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      int i;
      try
      {
        localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.jdField_b_of_type_JavaLangString);
        boolean bool = APNUtil.a(CommonDataAdapter.a().a());
        Object localObject4 = "";
        Object localObject5;
        Object localObject2;
        if (bool)
        {
          localObject3 = APNUtil.c(CommonDataAdapter.a().a());
          localObject5 = APNUtil.d(CommonDataAdapter.a().a());
          i = ((String)localObject1).indexOf('/', 7);
          if (i < 0)
          {
            localObject2 = ((String)localObject1).substring(7);
            localObject1 = "";
          }
          else
          {
            localObject2 = ((String)localObject1).substring(7, i);
            localObject1 = ((String)localObject1).substring(i);
          }
          Object localObject6 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localObject5);
          localStringBuilder.append((String)localObject1);
          LogUtility.c((String)localObject6, localStringBuilder.toString());
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("http://");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).append(":");
          ((StringBuilder)localObject6).append((String)localObject5);
          ((StringBuilder)localObject6).append((String)localObject1);
          localObject3 = (HttpURLConnection)new URL(((StringBuilder)localObject6).toString()).openConnection();
          localObject1 = localObject3;
        }
        try
        {
          ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
          localObject2 = localObject3;
          continue;
          localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setRequestMethod("GET");
          int j = 1;
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setDoInput(true);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setAllowUserInteraction(true);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setConnectTimeout(60000);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setReadTimeout(120000);
          localObject1 = localObject2;
          if (paramImageInfo.jdField_c_of_type_Long > 0L)
          {
            localObject1 = localObject2;
            localObject3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            localObject1 = localObject2;
            ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT"));
            localObject1 = localObject2;
            ((HttpURLConnection)localObject2).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject3).format(new Date(paramImageInfo.jdField_c_of_type_Long)));
          }
          localObject1 = localObject2;
          i = ((HttpURLConnection)localObject2).getResponseCode();
          localObject1 = localObject2;
          localObject3 = jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          localObject5 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append("--getHttpConnection-- reponseCode=");
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append(i);
          localObject1 = localObject2;
          LogUtility.c((String)localObject3, ((StringBuilder)localObject5).toString());
          if (i != 302)
          {
            if (i != 301) {
              break label953;
            }
            continue;
            if (i == 304)
            {
              localObject1 = localObject2;
              localObject3 = jdField_a_of_type_JavaLangString;
              localObject1 = localObject2;
              localObject4 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append("--getimg-- ");
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append(paramImageInfo.jdField_b_of_type_JavaLangString);
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append(" not modified");
              localObject1 = localObject2;
              LogUtility.c((String)localObject3, ((StringBuilder)localObject4).toString());
              localObject1 = localObject2;
              paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject2) * 1000L);
              localObject1 = localObject2;
              paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
              localObject1 = localObject2;
              a((HttpURLConnection)localObject2);
              break label970;
            }
            localObject1 = localObject2;
            a((HttpURLConnection)localObject2);
            break label970;
            localObject1 = localObject2;
            localObject3 = ((HttpURLConnection)localObject2).getContentType();
            if (localObject3 == null)
            {
              localObject3 = localObject4;
            }
            else
            {
              localObject1 = localObject2;
              localObject3 = ((String)localObject3).toLowerCase();
            }
            i = j;
            localObject1 = localObject2;
            if (((String)localObject3).indexOf("text/vnd.wap.wml") == -1)
            {
              i = j;
              localObject1 = localObject2;
              if (((String)localObject3).indexOf("application/vnd.wap.wmlc") == -1)
              {
                localObject1 = localObject2;
                if (((String)localObject3).indexOf("text") == -1) {
                  break label976;
                }
                i = j;
              }
            }
            localObject3 = localObject2;
            if (i != 0)
            {
              localObject1 = localObject2;
              a((HttpURLConnection)localObject2);
              localObject3 = null;
            }
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject3) * 1000L);
              localObject1 = localObject3;
              if (paramImageInfo.jdField_a_of_type_Long == 0L)
              {
                localObject1 = localObject3;
                paramImageInfo.jdField_a_of_type_Long = 86400000L;
              }
            }
            localObject1 = localObject3;
            paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
            continue;
          }
          localObject1 = localObject2;
          paramImageInfo = ((HttpURLConnection)localObject2).getHeaderField("Location");
          localObject1 = localObject2;
          localObject3 = jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          localObject4 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject4).append("--getHttpConnection-- loc=");
          localObject1 = localObject2;
          ((StringBuilder)localObject4).append(paramImageInfo);
          localObject1 = localObject2;
          LogUtility.c((String)localObject3, ((StringBuilder)localObject4).toString());
          localObject1 = localObject2;
          a((HttpURLConnection)localObject2);
          break label970;
          localObject1 = localObject3;
          paramImageInfo = jdField_a_of_type_JavaLangString;
          localObject1 = localObject3;
          localObject2 = new StringBuilder();
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append("--getHttpConnection-- uc=");
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append(localObject3);
          localObject1 = localObject3;
          LogUtility.c(paramImageInfo, ((StringBuilder)localObject2).toString());
          return localObject3;
        }
        catch (Exception paramImageInfo) {}
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- Exception!!!", paramImageInfo);
      }
      catch (Exception paramImageInfo)
      {
        localObject1 = null;
      }
      a((HttpURLConnection)localObject1);
      return null;
      label953:
      if (i != 200) {
        if (i == 206)
        {
          continue;
          label970:
          localObject3 = null;
          continue;
          label976:
          i = 0;
        }
      }
    }
  }
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
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
  
  /* Error */
  public static boolean a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 12
    //   6: aload_0
    //   7: invokestatic 271	com/tencent/open/base/img/ImageDownloader:a	(Lcom/tencent/open/base/img/ImageInfo;)Ljava/net/HttpURLConnection;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnonnull +67 -> 81
    //   17: getstatic 109	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: astore 6
    //   22: new 111	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   29: astore 7
    //   31: aload 7
    //   33: ldc_w 273
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 7
    //   42: aload_0
    //   43: getfield 70	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 7
    //   52: ldc_w 275
    //   55: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 6
    //   61: aload 7
    //   63: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 128	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 5
    //   71: ifnull +8 -> 79
    //   74: aload 5
    //   76: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload 5
    //   83: invokevirtual 278	java/net/HttpURLConnection:getContentLength	()I
    //   86: i2l
    //   87: lstore_3
    //   88: invokestatic 282	com/tencent/open/appcommon/Common:a	()J
    //   91: lload_3
    //   92: lcmp
    //   93: ifge +67 -> 160
    //   96: getstatic 109	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: astore 6
    //   101: new 111	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   108: astore 7
    //   110: aload 7
    //   112: ldc_w 273
    //   115: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 7
    //   121: aload_0
    //   122: getfield 70	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   125: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 7
    //   131: ldc_w 284
    //   134: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 6
    //   140: aload 7
    //   142: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 128	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 5
    //   162: invokevirtual 288	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   165: astore 7
    //   167: lconst_0
    //   168: lstore_3
    //   169: getstatic 290	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   172: newarray byte
    //   174: astore 6
    //   176: new 292	java/io/ByteArrayOutputStream
    //   179: dup
    //   180: invokespecial 293	java/io/ByteArrayOutputStream:<init>	()V
    //   183: astore 13
    //   185: aload 7
    //   187: aload 6
    //   189: iconst_0
    //   190: getstatic 290	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   193: invokevirtual 299	java/io/InputStream:read	([BII)I
    //   196: istore_1
    //   197: iload_1
    //   198: ifle +61 -> 259
    //   201: getstatic 301	com/tencent/open/base/img/ImageDownloader:b	I
    //   204: istore_2
    //   205: lload_3
    //   206: iload_2
    //   207: i2l
    //   208: lcmp
    //   209: iflt +33 -> 242
    //   212: aload 7
    //   214: ifnull +16 -> 230
    //   217: aload 7
    //   219: invokevirtual 304	java/io/InputStream:close	()V
    //   222: goto +8 -> 230
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 307	java/lang/Exception:printStackTrace	()V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: aload 13
    //   244: aload 6
    //   246: iconst_0
    //   247: iload_1
    //   248: invokevirtual 311	java/io/ByteArrayOutputStream:write	([BII)V
    //   251: lload_3
    //   252: iload_1
    //   253: i2l
    //   254: ladd
    //   255: lstore_3
    //   256: goto -71 -> 185
    //   259: new 111	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   266: astore 6
    //   268: aload 6
    //   270: invokestatic 314	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   273: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 6
    //   279: getstatic 317	com/tencent/open/base/img/ImageCache:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   282: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: aload_0
    //   289: getfield 319	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   292: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 6
    //   298: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   301: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 6
    //   307: aload_0
    //   308: getfield 70	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   311: invokestatic 328	com/tencent/open/base/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 6
    //   320: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore 14
    //   325: new 111	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   332: astore 6
    //   334: aload 6
    //   336: aload 14
    //   338: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 6
    //   344: ldc_w 330
    //   347: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: new 321	java/io/File
    //   354: dup
    //   355: aload 6
    //   357: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: astore 11
    //   365: aload 11
    //   367: invokevirtual 334	java/io/File:getParent	()Ljava/lang/String;
    //   370: ifnull +23 -> 393
    //   373: aload 11
    //   375: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   378: invokevirtual 342	java/io/File:exists	()Z
    //   381: ifne +12 -> 393
    //   384: aload 11
    //   386: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   389: invokevirtual 345	java/io/File:mkdirs	()Z
    //   392: pop
    //   393: aload 11
    //   395: invokevirtual 342	java/io/File:exists	()Z
    //   398: ifeq +9 -> 407
    //   401: aload 11
    //   403: invokevirtual 348	java/io/File:delete	()Z
    //   406: pop
    //   407: aload 11
    //   409: invokevirtual 351	java/io/File:createNewFile	()Z
    //   412: pop
    //   413: new 111	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   420: astore 6
    //   422: aload 6
    //   424: aload 14
    //   426: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 6
    //   432: ldc_w 330
    //   435: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: new 353	java/io/FileOutputStream
    //   442: dup
    //   443: aload 6
    //   445: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 354	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   451: astore 10
    //   453: aload 5
    //   455: astore 6
    //   457: aload 7
    //   459: astore 8
    //   461: aload 10
    //   463: astore 9
    //   465: aload 10
    //   467: aload 13
    //   469: invokevirtual 358	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   472: invokevirtual 361	java/io/FileOutputStream:write	([B)V
    //   475: aload 5
    //   477: astore 6
    //   479: aload 7
    //   481: astore 8
    //   483: aload 10
    //   485: astore 9
    //   487: aload 10
    //   489: invokevirtual 364	java/io/FileOutputStream:flush	()V
    //   492: aload 5
    //   494: astore 6
    //   496: aload 7
    //   498: astore 8
    //   500: aload 10
    //   502: astore 9
    //   504: new 321	java/io/File
    //   507: dup
    //   508: aload 14
    //   510: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: astore 12
    //   515: aload 5
    //   517: astore 6
    //   519: aload 7
    //   521: astore 8
    //   523: aload 10
    //   525: astore 9
    //   527: aload 12
    //   529: invokevirtual 342	java/io/File:exists	()Z
    //   532: ifeq +21 -> 553
    //   535: aload 5
    //   537: astore 6
    //   539: aload 7
    //   541: astore 8
    //   543: aload 10
    //   545: astore 9
    //   547: aload 12
    //   549: invokevirtual 348	java/io/File:delete	()Z
    //   552: pop
    //   553: aload 5
    //   555: astore 6
    //   557: aload 7
    //   559: astore 8
    //   561: aload 10
    //   563: astore 9
    //   565: aload 11
    //   567: aload 12
    //   569: invokevirtual 368	java/io/File:renameTo	(Ljava/io/File;)Z
    //   572: pop
    //   573: aload 5
    //   575: astore 6
    //   577: aload 7
    //   579: astore 8
    //   581: aload 10
    //   583: astore 9
    //   585: ldc_w 370
    //   588: aload_0
    //   589: getfield 371	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   592: invokestatic 128	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 5
    //   597: astore 6
    //   599: aload 7
    //   601: astore 8
    //   603: aload 10
    //   605: astore 9
    //   607: aload_0
    //   608: aload 5
    //   610: invokevirtual 374	java/net/HttpURLConnection:getLastModified	()J
    //   613: putfield 168	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   616: aload 10
    //   618: invokevirtual 375	java/io/FileOutputStream:close	()V
    //   621: aload 7
    //   623: ifnull +16 -> 639
    //   626: aload 7
    //   628: invokevirtual 304	java/io/InputStream:close	()V
    //   631: goto +8 -> 639
    //   634: astore_0
    //   635: aload_0
    //   636: invokevirtual 307	java/lang/Exception:printStackTrace	()V
    //   639: aload 5
    //   641: ifnull +8 -> 649
    //   644: aload 5
    //   646: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   649: iconst_1
    //   650: ireturn
    //   651: astore 6
    //   653: aload 12
    //   655: astore_0
    //   656: aload 10
    //   658: astore 8
    //   660: goto +21 -> 681
    //   663: astore 6
    //   665: aconst_null
    //   666: astore_0
    //   667: aload 10
    //   669: astore 8
    //   671: goto +10 -> 681
    //   674: astore 6
    //   676: aconst_null
    //   677: astore_0
    //   678: aload_0
    //   679: astore 8
    //   681: aload 11
    //   683: astore 12
    //   685: aload_0
    //   686: astore 10
    //   688: aload 8
    //   690: astore_0
    //   691: aload 6
    //   693: astore 11
    //   695: goto +74 -> 769
    //   698: astore 9
    //   700: aload 5
    //   702: astore 6
    //   704: aload 7
    //   706: astore_0
    //   707: aload 9
    //   709: astore 5
    //   711: goto +211 -> 922
    //   714: astore 11
    //   716: aconst_null
    //   717: astore 10
    //   719: aload 10
    //   721: astore_0
    //   722: goto +47 -> 769
    //   725: astore 7
    //   727: aconst_null
    //   728: astore_0
    //   729: aload 5
    //   731: astore 6
    //   733: aload 7
    //   735: astore 5
    //   737: goto +185 -> 922
    //   740: astore 11
    //   742: goto +19 -> 761
    //   745: astore 5
    //   747: aconst_null
    //   748: astore 6
    //   750: aload 6
    //   752: astore_0
    //   753: goto +169 -> 922
    //   756: astore 11
    //   758: aconst_null
    //   759: astore 5
    //   761: aconst_null
    //   762: astore 7
    //   764: aconst_null
    //   765: astore 10
    //   767: aconst_null
    //   768: astore_0
    //   769: aload 5
    //   771: astore 6
    //   773: aload 7
    //   775: astore 8
    //   777: aload_0
    //   778: astore 9
    //   780: getstatic 109	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   783: ldc_w 377
    //   786: aload 11
    //   788: invokestatic 265	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   791: aload 12
    //   793: ifnull +39 -> 832
    //   796: aload 5
    //   798: astore 6
    //   800: aload 7
    //   802: astore 8
    //   804: aload_0
    //   805: astore 9
    //   807: aload 12
    //   809: invokevirtual 342	java/io/File:exists	()Z
    //   812: ifeq +20 -> 832
    //   815: aload 5
    //   817: astore 6
    //   819: aload 7
    //   821: astore 8
    //   823: aload_0
    //   824: astore 9
    //   826: aload 12
    //   828: invokevirtual 348	java/io/File:delete	()Z
    //   831: pop
    //   832: aload 10
    //   834: ifnull +39 -> 873
    //   837: aload 5
    //   839: astore 6
    //   841: aload 7
    //   843: astore 8
    //   845: aload_0
    //   846: astore 9
    //   848: aload 10
    //   850: invokevirtual 342	java/io/File:exists	()Z
    //   853: ifeq +20 -> 873
    //   856: aload 5
    //   858: astore 6
    //   860: aload 7
    //   862: astore 8
    //   864: aload_0
    //   865: astore 9
    //   867: aload 10
    //   869: invokevirtual 348	java/io/File:delete	()Z
    //   872: pop
    //   873: aload_0
    //   874: ifnull +10 -> 884
    //   877: aload_0
    //   878: invokevirtual 375	java/io/FileOutputStream:close	()V
    //   881: goto +3 -> 884
    //   884: aload 7
    //   886: ifnull +15 -> 901
    //   889: aload 7
    //   891: invokevirtual 304	java/io/InputStream:close	()V
    //   894: goto +7 -> 901
    //   897: aload_0
    //   898: invokevirtual 307	java/lang/Exception:printStackTrace	()V
    //   901: aload 5
    //   903: ifnull +8 -> 911
    //   906: aload 5
    //   908: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   911: iconst_0
    //   912: ireturn
    //   913: astore 5
    //   915: aload 8
    //   917: astore_0
    //   918: aload 9
    //   920: astore 8
    //   922: aload 8
    //   924: ifnull +11 -> 935
    //   927: aload 8
    //   929: invokevirtual 375	java/io/FileOutputStream:close	()V
    //   932: goto +3 -> 935
    //   935: aload_0
    //   936: ifnull +14 -> 950
    //   939: aload_0
    //   940: invokevirtual 304	java/io/InputStream:close	()V
    //   943: goto +7 -> 950
    //   946: aload_0
    //   947: invokevirtual 307	java/lang/Exception:printStackTrace	()V
    //   950: aload 6
    //   952: ifnull +8 -> 960
    //   955: aload 6
    //   957: invokevirtual 268	java/net/HttpURLConnection:disconnect	()V
    //   960: goto +6 -> 966
    //   963: aload 5
    //   965: athrow
    //   966: goto -3 -> 963
    //   969: astore_0
    //   970: goto -73 -> 897
    //   973: astore_0
    //   974: goto -28 -> 946
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	977	0	paramImageInfo	ImageInfo
    //   196	57	1	i	int
    //   204	3	2	j	int
    //   87	169	3	l	long
    //   10	726	5	localObject1	Object
    //   745	1	5	localObject2	Object
    //   759	148	5	localObject3	Object
    //   913	51	5	localObject4	Object
    //   20	578	6	localObject5	Object
    //   651	1	6	localException1	Exception
    //   663	1	6	localException2	Exception
    //   674	18	6	localException3	Exception
    //   702	254	6	localObject6	Object
    //   29	676	7	localObject7	Object
    //   725	9	7	localObject8	Object
    //   762	128	7	localObject9	Object
    //   1	927	8	localObject10	Object
    //   463	143	9	localObject11	Object
    //   698	10	9	localObject12	Object
    //   778	141	9	localImageInfo	ImageInfo
    //   451	417	10	localObject13	Object
    //   363	331	11	localObject14	Object
    //   714	1	11	localException4	Exception
    //   740	1	11	localException5	Exception
    //   756	31	11	localException6	Exception
    //   4	823	12	localObject15	Object
    //   183	285	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   323	186	14	str	String
    // Exception table:
    //   from	to	target	type
    //   217	222	225	java/lang/Exception
    //   616	621	634	java/lang/Exception
    //   626	631	634	java/lang/Exception
    //   527	535	651	java/lang/Exception
    //   547	553	651	java/lang/Exception
    //   565	573	651	java/lang/Exception
    //   585	595	651	java/lang/Exception
    //   607	616	651	java/lang/Exception
    //   465	475	663	java/lang/Exception
    //   487	492	663	java/lang/Exception
    //   504	515	663	java/lang/Exception
    //   365	393	674	java/lang/Exception
    //   393	407	674	java/lang/Exception
    //   407	453	674	java/lang/Exception
    //   169	185	698	finally
    //   185	197	698	finally
    //   201	205	698	finally
    //   242	251	698	finally
    //   259	365	698	finally
    //   365	393	698	finally
    //   393	407	698	finally
    //   407	453	698	finally
    //   169	185	714	java/lang/Exception
    //   185	197	714	java/lang/Exception
    //   201	205	714	java/lang/Exception
    //   242	251	714	java/lang/Exception
    //   259	365	714	java/lang/Exception
    //   17	69	725	finally
    //   81	148	725	finally
    //   160	167	725	finally
    //   17	69	740	java/lang/Exception
    //   81	148	740	java/lang/Exception
    //   160	167	740	java/lang/Exception
    //   6	12	745	finally
    //   6	12	756	java/lang/Exception
    //   465	475	913	finally
    //   487	492	913	finally
    //   504	515	913	finally
    //   527	535	913	finally
    //   547	553	913	finally
    //   565	573	913	finally
    //   585	595	913	finally
    //   607	616	913	finally
    //   780	791	913	finally
    //   807	815	913	finally
    //   826	832	913	finally
    //   848	856	913	finally
    //   867	873	913	finally
    //   877	881	969	java/lang/Exception
    //   889	894	969	java/lang/Exception
    //   927	932	973	java/lang/Exception
    //   939	943	973	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */