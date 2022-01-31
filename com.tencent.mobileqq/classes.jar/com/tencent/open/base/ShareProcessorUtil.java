package com.tencent.open.base;

import android.content.Context;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class ShareProcessorUtil
{
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      String str2 = new URL(paramString).getHost();
      String str1 = InnerDns.a().a(str2, paramInt);
      localObject = paramString;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (!str1.contains(":")) {
          localObject = str1 + ":80";
        }
        localObject = paramString.replaceFirst(str2, (String)localObject);
      }
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    return paramString;
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|oldCache=" + paramString1 + ",oldUrl=" + paramString2 + ",newUrl=" + paramString3);
    }
    if (paramString1 != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if ((paramString1.equals(paramString3)) || (BaseApplicationImpl.sImageCache == null)) {
          break label193;
        }
        paramString1 = BaseApplicationImpl.sImageCache.get(paramString1);
        if (paramString1 == null) {
          break label193;
        }
        BaseApplicationImpl.sImageCache.put(paramString3, paramString1);
        bool = true;
      }
      catch (Exception paramString1)
      {
        String str;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      str = AbsDownloader.d(paramString3);
      if ((paramString2 != null) && (!paramString2.equals(paramString3)))
      {
        paramBoolean = FileUtils.d(paramString1, str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|cache=" + bool + ",file=" + paramBoolean);
        return;
        paramString1 = AbsDownloader.d(paramString2);
        continue;
        QLog.d("Q.share.ShareProcessorUtil", 2, paramString1, new Object[0]);
      }
      else
      {
        paramBoolean = false;
        continue;
        label193:
        bool = false;
        if (paramBoolean) {
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static Object[] a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|targetUrl=" + paramString1);
    }
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Integer.valueOf(-1);
    arrayOfObject1[1] = null;
    arrayOfObject1[2] = null;
    arrayOfObject1[3] = null;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return arrayOfObject1;
    }
    for (;;)
    {
      try
      {
        paramContext = HttpUtil.a(paramContext, String.format("http://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { paramString2, URLEncoder.encode(paramString1) }), null, "GET", null, null, 5000, 5000);
        if (paramContext == null) {
          break;
        }
        i = paramContext.getStatusLine().getStatusCode();
        if (i == 200)
        {
          paramContext = HttpUtil.a(paramContext);
          if (QLog.isColorLevel()) {
            QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|result=" + paramContext);
          }
          if (TextUtils.isEmpty(paramContext)) {
            break label382;
          }
          paramString2 = new JSONObject(paramContext);
          if (!paramString2.has("ret")) {
            break label377;
          }
          i = paramString2.getInt("ret");
          if (!paramString2.has("title")) {
            break label372;
          }
          paramContext = paramString2.getString("title");
          if (!paramString2.has("abstract")) {
            break label367;
          }
          paramString1 = paramString2.getString("abstract");
          if (!paramString2.has("thumbUrl")) {
            break label362;
          }
          paramString2 = paramString2.getString("thumbUrl");
          if (i != 0) {
            QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|ret=" + i);
          }
          Object[] arrayOfObject2 = new Object[4];
          arrayOfObject2[0] = Integer.valueOf(i);
          arrayOfObject2[1] = paramContext;
          arrayOfObject2[2] = paramString1;
          arrayOfObject2[3] = paramString2;
          return arrayOfObject2;
        }
        QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|httpCode=" + i);
        return arrayOfObject1;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.share.ShareProcessorUtil", 2, paramContext, new Object[0]);
      return arrayOfObject1;
      label362:
      paramString2 = null;
      continue;
      label367:
      paramString1 = null;
      continue;
      label372:
      paramContext = null;
      continue;
      label377:
      int i = -1;
    }
    label382:
    paramContext = arrayOfObject1;
    return paramContext;
  }
  
  /* Error */
  public static Object[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 202	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9: ifeq +28 -> 37
    //   12: ldc 72
    //   14: iconst_4
    //   15: new 44	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   22: ldc 204
    //   24: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 207	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: new 21	java/net/URL
    //   40: dup
    //   41: ldc 209
    //   43: iconst_3
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: ldc 211
    //   52: invokestatic 213	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: iconst_0
    //   59: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_1
    //   66: aastore
    //   67: invokestatic 142	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: sipush 1007
    //   73: invokestatic 214	com/tencent/open/base/ShareProcessorUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   76: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
    //   79: invokevirtual 218	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   82: checkcast 220	java/net/HttpURLConnection
    //   85: astore_1
    //   86: aload_1
    //   87: sipush 5000
    //   90: invokevirtual 224	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   93: aload_1
    //   94: sipush 30000
    //   97: invokevirtual 227	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   100: aload_1
    //   101: ldc 144
    //   103: invokevirtual 230	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc 232
    //   109: new 44	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 234
    //   115: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: ldc 237
    //   120: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 243	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   126: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 237
    //   131: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: getstatic 248	android/os/Build:DEVICE	Ljava/lang/String;
    //   137: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 237
    //   142: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 251	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   148: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 237
    //   153: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 253
    //   158: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokevirtual 257	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_1
    //   168: ldc_w 259
    //   171: ldc_w 261
    //   174: invokevirtual 257	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_1
    //   178: invokevirtual 264	java/net/HttpURLConnection:getResponseCode	()I
    //   181: istore_2
    //   182: iload_2
    //   183: sipush 200
    //   186: if_icmpeq +66 -> 252
    //   189: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +29 -> 221
    //   195: ldc 72
    //   197: iconst_2
    //   198: new 44	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 266
    //   208: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload_2
    //   212: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 269	java/net/HttpURLConnection:disconnect	()V
    //   229: iconst_3
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: iconst_m1
    //   236: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: iconst_0
    //   243: invokestatic 274	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aconst_null
    //   250: aastore
    //   251: areturn
    //   252: new 44	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   259: astore_0
    //   260: new 276	java/io/BufferedReader
    //   263: dup
    //   264: new 278	java/io/InputStreamReader
    //   267: dup
    //   268: aload_1
    //   269: invokevirtual 282	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   272: invokespecial 285	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   275: invokespecial 288	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   278: astore 7
    //   280: aload 7
    //   282: invokevirtual 291	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   285: astore 8
    //   287: aload 8
    //   289: ifnull +113 -> 402
    //   292: aload_0
    //   293: aload 8
    //   295: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 293
    //   301: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: goto -25 -> 280
    //   308: astore 7
    //   310: aload_1
    //   311: astore_0
    //   312: iconst_0
    //   313: istore 4
    //   315: iconst_m1
    //   316: istore_2
    //   317: aload 7
    //   319: astore_1
    //   320: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +29 -> 352
    //   326: ldc 72
    //   328: iconst_2
    //   329: new 44	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 295
    //   339: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_1
    //   343: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: iload 4
    //   354: istore 5
    //   356: iload_2
    //   357: istore_3
    //   358: aload 6
    //   360: astore_1
    //   361: aload_0
    //   362: ifnull +16 -> 378
    //   365: aload_0
    //   366: invokevirtual 269	java/net/HttpURLConnection:disconnect	()V
    //   369: aload 6
    //   371: astore_1
    //   372: iload_2
    //   373: istore_3
    //   374: iload 4
    //   376: istore 5
    //   378: iconst_3
    //   379: anewarray 4	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: iload_3
    //   385: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: iload 5
    //   393: invokestatic 274	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   396: aastore
    //   397: dup
    //   398: iconst_2
    //   399: aload_1
    //   400: aastore
    //   401: areturn
    //   402: aload 7
    //   404: invokevirtual 304	java/io/BufferedReader:close	()V
    //   407: aload_0
    //   408: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: astore 7
    //   413: aload 7
    //   415: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   418: ifne +241 -> 659
    //   421: new 168	org/json/JSONObject
    //   424: dup
    //   425: aload 7
    //   427: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   430: astore_0
    //   431: aload_0
    //   432: ldc_w 306
    //   435: invokevirtual 175	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   438: ifeq +216 -> 654
    //   441: aload_0
    //   442: ldc_w 306
    //   445: invokevirtual 179	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   448: istore_2
    //   449: aload_0
    //   450: ldc_w 308
    //   453: invokevirtual 175	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   456: ifeq +192 -> 648
    //   459: aload_0
    //   460: ldc_w 308
    //   463: invokevirtual 179	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   466: istore_3
    //   467: iload_3
    //   468: iconst_1
    //   469: if_icmpne +76 -> 545
    //   472: iconst_1
    //   473: istore 4
    //   475: aload_0
    //   476: ldc_w 310
    //   479: invokevirtual 175	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   482: ifeq +161 -> 643
    //   485: aload_0
    //   486: ldc_w 310
    //   489: invokevirtual 184	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   492: astore_0
    //   493: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +30 -> 526
    //   499: ldc 72
    //   501: iconst_2
    //   502: new 44	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 312
    //   512: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 7
    //   517: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: aload_1
    //   527: ifnull +105 -> 632
    //   530: aload_1
    //   531: invokevirtual 269	java/net/HttpURLConnection:disconnect	()V
    //   534: iload 4
    //   536: istore 5
    //   538: iload_2
    //   539: istore_3
    //   540: aload_0
    //   541: astore_1
    //   542: goto -164 -> 378
    //   545: iconst_0
    //   546: istore 4
    //   548: goto -73 -> 475
    //   551: astore_0
    //   552: aload 7
    //   554: astore_1
    //   555: aload_1
    //   556: ifnull +7 -> 563
    //   559: aload_1
    //   560: invokevirtual 269	java/net/HttpURLConnection:disconnect	()V
    //   563: aload_0
    //   564: athrow
    //   565: astore_0
    //   566: goto -11 -> 555
    //   569: astore 6
    //   571: aload_0
    //   572: astore_1
    //   573: aload 6
    //   575: astore_0
    //   576: goto -21 -> 555
    //   579: astore_1
    //   580: aconst_null
    //   581: astore_0
    //   582: iconst_m1
    //   583: istore_2
    //   584: iconst_0
    //   585: istore 4
    //   587: goto -267 -> 320
    //   590: astore_0
    //   591: aload_1
    //   592: astore 7
    //   594: iconst_0
    //   595: istore 4
    //   597: aload_0
    //   598: astore_1
    //   599: aload 7
    //   601: astore_0
    //   602: goto -282 -> 320
    //   605: astore 7
    //   607: aload_1
    //   608: astore_0
    //   609: aload 7
    //   611: astore_1
    //   612: goto -292 -> 320
    //   615: astore 6
    //   617: aload_1
    //   618: astore 7
    //   620: aload 6
    //   622: astore_1
    //   623: aload_0
    //   624: astore 6
    //   626: aload 7
    //   628: astore_0
    //   629: goto -309 -> 320
    //   632: iload 4
    //   634: istore 5
    //   636: iload_2
    //   637: istore_3
    //   638: aload_0
    //   639: astore_1
    //   640: goto -262 -> 378
    //   643: aconst_null
    //   644: astore_0
    //   645: goto -152 -> 493
    //   648: iconst_0
    //   649: istore 4
    //   651: goto -176 -> 475
    //   654: iconst_m1
    //   655: istore_2
    //   656: goto -207 -> 449
    //   659: iconst_0
    //   660: istore 4
    //   662: aconst_null
    //   663: astore_0
    //   664: iconst_m1
    //   665: istore_2
    //   666: goto -173 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	paramString1	String
    //   0	669	1	paramString2	String
    //   181	485	2	i	int
    //   357	281	3	j	int
    //   313	348	4	bool1	boolean
    //   354	281	5	bool2	boolean
    //   4	366	6	localObject1	Object
    //   569	5	6	localObject2	Object
    //   615	6	6	localException1	Exception
    //   624	1	6	str1	String
    //   1	280	7	localBufferedReader	java.io.BufferedReader
    //   308	95	7	localException2	Exception
    //   411	189	7	str2	String
    //   605	5	7	localException3	Exception
    //   618	9	7	str3	String
    //   285	9	8	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	182	308	java/lang/Exception
    //   189	221	308	java/lang/Exception
    //   252	280	308	java/lang/Exception
    //   280	287	308	java/lang/Exception
    //   292	305	308	java/lang/Exception
    //   402	449	308	java/lang/Exception
    //   37	86	551	finally
    //   86	182	565	finally
    //   189	221	565	finally
    //   252	280	565	finally
    //   280	287	565	finally
    //   292	305	565	finally
    //   402	449	565	finally
    //   449	467	565	finally
    //   475	493	565	finally
    //   493	526	565	finally
    //   320	352	569	finally
    //   37	86	579	java/lang/Exception
    //   449	467	590	java/lang/Exception
    //   475	493	605	java/lang/Exception
    //   493	526	615	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.ShareProcessorUtil
 * JD-Core Version:    0.7.0.1
 */