package com.tencent.mobileqq.uniformdownload.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.util.Random;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class UniformDownloadUtil
{
  public static int a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    try
    {
      if (!new File(paramString1).exists())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[UniformDL] openApk. file is not exsited. PH:");
        paramString2.append(paramString1);
        QLog.e("UniformDownloadUtil", 1, paramString2.toString());
        return -2;
      }
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).hookAM4Install();
      paramString1 = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), paramString1);
      paramString1.putExtra("big_brother_source_key", paramString2);
      BaseApplication.getContext().startActivity(paramString1);
      return 0;
    }
    catch (Exception paramString1)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. Exception 2");
      paramString1.printStackTrace();
    }
    return -3;
  }
  
  public static long a()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject3 = new DisplayMetrics();
      ((DisplayMetrics)localObject3).setToDefaults();
      localObject1 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE }).invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
      localObject1 = (ApplicationInfo)localObject1.getClass().getDeclaredField("applicationInfo").get(localObject1);
      localObject3 = Class.forName("android.content.res.AssetManager");
      localObject2 = ((Class)localObject3).newInstance();
      ((Class)localObject3).getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = BaseApplication.getContext().getResources();
      paramString = (Resources)Resources.class.getConstructor(new Class[] { localObject2.getClass(), paramString.getDisplayMetrics().getClass(), paramString.getConfiguration().getClass() }).newInstance(new Object[] { localObject2, paramString.getDisplayMetrics(), paramString.getConfiguration() });
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).icon != 0))
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static UniformDownloadUtil.FileInfo a(String paramString)
  {
    // Byte code:
    //   0: ldc 228
    //   2: astore 14
    //   4: lconst_0
    //   5: lstore_1
    //   6: aload_0
    //   7: ifnull +741 -> 748
    //   10: aload_0
    //   11: invokevirtual 231	java/lang/String:length	()I
    //   14: iconst_1
    //   15: if_icmpge +6 -> 21
    //   18: goto +730 -> 748
    //   21: new 233	java/net/URL
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 234	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 238	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 240	java/net/HttpURLConnection
    //   35: astore 13
    //   37: lload_1
    //   38: lstore_3
    //   39: lload_1
    //   40: lstore 5
    //   42: lload_1
    //   43: lstore 7
    //   45: aload 13
    //   47: astore 12
    //   49: aload 13
    //   51: ldc 242
    //   53: ldc 244
    //   55: invokevirtual 248	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: lload_1
    //   59: lstore_3
    //   60: lload_1
    //   61: lstore 5
    //   63: lload_1
    //   64: lstore 7
    //   66: aload 13
    //   68: astore 12
    //   70: aload 13
    //   72: ldc 250
    //   74: ldc 244
    //   76: invokevirtual 248	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: lload_1
    //   80: lstore_3
    //   81: lload_1
    //   82: lstore 5
    //   84: lload_1
    //   85: lstore 7
    //   87: aload 13
    //   89: astore 12
    //   91: aload 13
    //   93: ldc 242
    //   95: ldc 244
    //   97: invokevirtual 248	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: lload_1
    //   101: lstore_3
    //   102: lload_1
    //   103: lstore 5
    //   105: lload_1
    //   106: lstore 7
    //   108: aload 13
    //   110: astore 12
    //   112: aload 13
    //   114: ldc 250
    //   116: ldc 244
    //   118: invokevirtual 248	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: lload_1
    //   122: lstore_3
    //   123: lload_1
    //   124: lstore 5
    //   126: lload_1
    //   127: lstore 7
    //   129: aload 13
    //   131: astore 12
    //   133: aload 13
    //   135: invokevirtual 253	java/net/HttpURLConnection:connect	()V
    //   138: lload_1
    //   139: lstore_3
    //   140: lload_1
    //   141: lstore 5
    //   143: lload_1
    //   144: lstore 7
    //   146: aload 13
    //   148: astore 12
    //   150: aload 13
    //   152: invokevirtual 256	java/net/HttpURLConnection:getResponseCode	()I
    //   155: pop
    //   156: lload_1
    //   157: lstore_3
    //   158: lload_1
    //   159: lstore 5
    //   161: lload_1
    //   162: lstore 7
    //   164: aload 13
    //   166: astore 12
    //   168: aload 13
    //   170: invokevirtual 260	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   173: astore 10
    //   175: lload_1
    //   176: lstore_3
    //   177: lload_1
    //   178: lstore 5
    //   180: lload_1
    //   181: lstore 7
    //   183: aload 13
    //   185: astore 12
    //   187: new 27	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   194: astore 11
    //   196: lload_1
    //   197: lstore_3
    //   198: lload_1
    //   199: lstore 5
    //   201: lload_1
    //   202: lstore 7
    //   204: aload 13
    //   206: astore 12
    //   208: aload 11
    //   210: ldc_w 262
    //   213: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: lload_1
    //   218: lstore_3
    //   219: lload_1
    //   220: lstore 5
    //   222: lload_1
    //   223: lstore 7
    //   225: aload 13
    //   227: astore 12
    //   229: aload 11
    //   231: aload 10
    //   233: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: lload_1
    //   238: lstore_3
    //   239: lload_1
    //   240: lstore 5
    //   242: lload_1
    //   243: lstore 7
    //   245: aload 13
    //   247: astore 12
    //   249: ldc_w 267
    //   252: iconst_1
    //   253: aload 11
    //   255: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: lload_1
    //   262: lstore_3
    //   263: lload_1
    //   264: lstore 5
    //   266: lload_1
    //   267: lstore 7
    //   269: aload 13
    //   271: astore 12
    //   273: aload 13
    //   275: invokevirtual 270	java/net/HttpURLConnection:getContentLength	()I
    //   278: i2l
    //   279: lstore_1
    //   280: lload_1
    //   281: lstore_3
    //   282: lload_1
    //   283: lstore 5
    //   285: lload_1
    //   286: lstore 7
    //   288: aload 13
    //   290: astore 12
    //   292: aload 13
    //   294: invokestatic 273	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   297: astore 11
    //   299: aload 13
    //   301: astore 12
    //   303: aload 11
    //   305: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +22 -> 330
    //   311: aload 10
    //   313: ifnull +17 -> 330
    //   316: aload 13
    //   318: astore 12
    //   320: aload 10
    //   322: invokevirtual 282	java/net/URL:getFile	()Ljava/lang/String;
    //   325: astore 10
    //   327: goto +7 -> 334
    //   330: aload 11
    //   332: astore 10
    //   334: aload 10
    //   336: astore 11
    //   338: aload 10
    //   340: ifnull +92 -> 432
    //   343: aload 13
    //   345: astore 12
    //   347: aload 10
    //   349: ldc_w 284
    //   352: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   355: ifne +26 -> 381
    //   358: aload 13
    //   360: astore 12
    //   362: aload 10
    //   364: ldc_w 289
    //   367: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   370: istore 9
    //   372: aload 10
    //   374: astore 11
    //   376: iload 9
    //   378: ifeq +54 -> 432
    //   381: aconst_null
    //   382: astore 11
    //   384: goto +48 -> 432
    //   387: astore 12
    //   389: aload 10
    //   391: astore 11
    //   393: aload 12
    //   395: astore 10
    //   397: lload_1
    //   398: lstore_3
    //   399: goto +122 -> 521
    //   402: astore 12
    //   404: aload 10
    //   406: astore 11
    //   408: aload 12
    //   410: astore 10
    //   412: lload_1
    //   413: lstore_3
    //   414: goto +152 -> 566
    //   417: astore 12
    //   419: aload 10
    //   421: astore 11
    //   423: aload 12
    //   425: astore 10
    //   427: lload_1
    //   428: lstore_3
    //   429: goto +166 -> 595
    //   432: aload 13
    //   434: ifnull +8 -> 442
    //   437: aload 13
    //   439: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   442: aload 11
    //   444: astore 10
    //   446: goto +178 -> 624
    //   449: astore 10
    //   451: lload_1
    //   452: lstore_3
    //   453: goto +68 -> 521
    //   456: astore 10
    //   458: lload_1
    //   459: lstore_3
    //   460: goto +106 -> 566
    //   463: astore 10
    //   465: lload_1
    //   466: lstore_3
    //   467: goto +128 -> 595
    //   470: astore 10
    //   472: ldc 228
    //   474: astore 11
    //   476: goto +45 -> 521
    //   479: astore 10
    //   481: ldc 228
    //   483: astore 11
    //   485: lload 5
    //   487: lstore_3
    //   488: goto +78 -> 566
    //   491: astore 10
    //   493: ldc 228
    //   495: astore 11
    //   497: lload 7
    //   499: lstore_3
    //   500: goto +95 -> 595
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 12
    //   507: goto +229 -> 736
    //   510: astore 10
    //   512: ldc 228
    //   514: astore 11
    //   516: aconst_null
    //   517: astore 13
    //   519: lload_1
    //   520: lstore_3
    //   521: aload 13
    //   523: astore 12
    //   525: aload 10
    //   527: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   530: aload 11
    //   532: astore 10
    //   534: lload_3
    //   535: lstore_1
    //   536: aload 13
    //   538: ifnull +86 -> 624
    //   541: lload_3
    //   542: lstore_1
    //   543: aload 11
    //   545: astore 10
    //   547: aload 13
    //   549: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   552: goto +72 -> 624
    //   555: astore 10
    //   557: ldc 228
    //   559: astore 11
    //   561: aconst_null
    //   562: astore 13
    //   564: lload_1
    //   565: lstore_3
    //   566: aload 13
    //   568: astore 12
    //   570: aload 10
    //   572: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   575: aload 11
    //   577: astore 10
    //   579: lload_3
    //   580: lstore_1
    //   581: aload 13
    //   583: ifnull +41 -> 624
    //   586: aload 11
    //   588: astore 10
    //   590: lload_3
    //   591: lstore_1
    //   592: goto -45 -> 547
    //   595: aload 13
    //   597: astore 12
    //   599: aload 10
    //   601: invokevirtual 294	java/net/MalformedURLException:printStackTrace	()V
    //   604: aload 11
    //   606: astore 10
    //   608: lload_3
    //   609: lstore_1
    //   610: aload 13
    //   612: ifnull +12 -> 624
    //   615: aload 11
    //   617: astore 10
    //   619: lload_3
    //   620: lstore_1
    //   621: goto -74 -> 547
    //   624: aload 14
    //   626: astore 11
    //   628: aload_0
    //   629: invokestatic 300	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   632: astore 12
    //   634: aload 14
    //   636: astore_0
    //   637: aload 12
    //   639: ifnull +72 -> 711
    //   642: aload 14
    //   644: astore 11
    //   646: aload 12
    //   648: invokevirtual 303	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   651: astore 12
    //   653: aload 12
    //   655: astore_0
    //   656: aload 12
    //   658: ifnull +53 -> 711
    //   661: aload 12
    //   663: astore 11
    //   665: aload 12
    //   667: ldc_w 284
    //   670: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   673: ifne +25 -> 698
    //   676: aload 12
    //   678: astore 11
    //   680: aload 12
    //   682: ldc_w 289
    //   685: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   688: istore 9
    //   690: aload 12
    //   692: astore_0
    //   693: iload 9
    //   695: ifeq +16 -> 711
    //   698: aconst_null
    //   699: astore_0
    //   700: goto +11 -> 711
    //   703: astore_0
    //   704: aload_0
    //   705: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   708: aload 11
    //   710: astore_0
    //   711: aload 10
    //   713: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   716: ifne +9 -> 725
    //   719: aload 10
    //   721: astore_0
    //   722: goto +3 -> 725
    //   725: new 305	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   728: dup
    //   729: aload_0
    //   730: lload_1
    //   731: invokespecial 308	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   734: areturn
    //   735: astore_0
    //   736: aload 12
    //   738: ifnull +8 -> 746
    //   741: aload 12
    //   743: invokevirtual 292	java/net/HttpURLConnection:disconnect	()V
    //   746: aload_0
    //   747: athrow
    //   748: new 305	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   751: dup
    //   752: aconst_null
    //   753: lconst_0
    //   754: invokespecial 308	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   757: areturn
    //   758: astore 10
    //   760: ldc 228
    //   762: astore 11
    //   764: aconst_null
    //   765: astore 13
    //   767: lload_1
    //   768: lstore_3
    //   769: goto -174 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	772	0	paramString	String
    //   5	763	1	l1	long
    //   38	731	3	l2	long
    //   40	446	5	l3	long
    //   43	455	7	l4	long
    //   370	324	9	bool	boolean
    //   173	272	10	localObject1	Object
    //   449	1	10	localException1	Exception
    //   456	1	10	localIOException1	java.io.IOException
    //   463	1	10	localMalformedURLException1	java.net.MalformedURLException
    //   470	1	10	localException2	Exception
    //   479	1	10	localIOException2	java.io.IOException
    //   491	1	10	localMalformedURLException2	java.net.MalformedURLException
    //   510	16	10	localException3	Exception
    //   532	14	10	localObject2	Object
    //   555	16	10	localIOException3	java.io.IOException
    //   577	143	10	localObject3	Object
    //   758	1	10	localMalformedURLException3	java.net.MalformedURLException
    //   194	569	11	localObject4	Object
    //   47	314	12	localHttpURLConnection1	HttpURLConnection
    //   387	7	12	localException4	Exception
    //   402	7	12	localIOException4	java.io.IOException
    //   417	7	12	localMalformedURLException4	java.net.MalformedURLException
    //   505	237	12	localObject5	Object
    //   35	731	13	localHttpURLConnection2	HttpURLConnection
    //   2	641	14	str	String
    // Exception table:
    //   from	to	target	type
    //   347	358	387	java/lang/Exception
    //   362	372	387	java/lang/Exception
    //   347	358	402	java/io/IOException
    //   362	372	402	java/io/IOException
    //   347	358	417	java/net/MalformedURLException
    //   362	372	417	java/net/MalformedURLException
    //   303	311	449	java/lang/Exception
    //   320	327	449	java/lang/Exception
    //   303	311	456	java/io/IOException
    //   320	327	456	java/io/IOException
    //   303	311	463	java/net/MalformedURLException
    //   320	327	463	java/net/MalformedURLException
    //   49	58	470	java/lang/Exception
    //   70	79	470	java/lang/Exception
    //   91	100	470	java/lang/Exception
    //   112	121	470	java/lang/Exception
    //   133	138	470	java/lang/Exception
    //   150	156	470	java/lang/Exception
    //   168	175	470	java/lang/Exception
    //   187	196	470	java/lang/Exception
    //   208	217	470	java/lang/Exception
    //   229	237	470	java/lang/Exception
    //   249	261	470	java/lang/Exception
    //   273	280	470	java/lang/Exception
    //   292	299	470	java/lang/Exception
    //   49	58	479	java/io/IOException
    //   70	79	479	java/io/IOException
    //   91	100	479	java/io/IOException
    //   112	121	479	java/io/IOException
    //   133	138	479	java/io/IOException
    //   150	156	479	java/io/IOException
    //   168	175	479	java/io/IOException
    //   187	196	479	java/io/IOException
    //   208	217	479	java/io/IOException
    //   229	237	479	java/io/IOException
    //   249	261	479	java/io/IOException
    //   273	280	479	java/io/IOException
    //   292	299	479	java/io/IOException
    //   49	58	491	java/net/MalformedURLException
    //   70	79	491	java/net/MalformedURLException
    //   91	100	491	java/net/MalformedURLException
    //   112	121	491	java/net/MalformedURLException
    //   133	138	491	java/net/MalformedURLException
    //   150	156	491	java/net/MalformedURLException
    //   168	175	491	java/net/MalformedURLException
    //   187	196	491	java/net/MalformedURLException
    //   208	217	491	java/net/MalformedURLException
    //   229	237	491	java/net/MalformedURLException
    //   249	261	491	java/net/MalformedURLException
    //   273	280	491	java/net/MalformedURLException
    //   292	299	491	java/net/MalformedURLException
    //   21	37	503	finally
    //   21	37	510	java/lang/Exception
    //   21	37	555	java/io/IOException
    //   628	634	703	java/lang/Exception
    //   646	653	703	java/lang/Exception
    //   665	676	703	java/lang/Exception
    //   680	690	703	java/lang/Exception
    //   49	58	735	finally
    //   70	79	735	finally
    //   91	100	735	finally
    //   112	121	735	finally
    //   133	138	735	finally
    //   150	156	735	finally
    //   168	175	735	finally
    //   187	196	735	finally
    //   208	217	735	finally
    //   229	237	735	finally
    //   249	261	735	finally
    //   273	280	735	finally
    //   292	299	735	finally
    //   303	311	735	finally
    //   320	327	735	finally
    //   347	358	735	finally
    //   362	372	735	finally
    //   525	530	735	finally
    //   570	575	735	finally
    //   599	604	735	finally
    //   21	37	758	java/net/MalformedURLException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    try
    {
      Object localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null) {
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
      } else {
        localObject = null;
      }
      if (localObject != null) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] isApk. get package failed.  PH:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("UniformDownloadUtil", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = localObject4;
    for (;;)
    {
      Object localObject2;
      try
      {
        paramHttpURLConnection = URLDecoder.decode(new String(paramHttpURLConnection.getHeaderField("Content-Disposition").getBytes("ISO-8859-1"), "utf-8"), "utf-8");
        localObject2 = localObject5;
        if (paramHttpURLConnection != null)
        {
          localObject1 = localObject4;
          String str = URLDecoder.decode(new String(paramHttpURLConnection.getBytes("ISO-8859-1"), "utf-8"), "utf-8");
          localObject2 = localObject5;
          if (str != null)
          {
            localObject1 = localObject4;
            int j = str.indexOf("filename=");
            int i = j;
            if (-1 == j)
            {
              localObject1 = localObject4;
              i = str.indexOf("FileName=");
            }
            paramHttpURLConnection = localObject3;
            if (-1 != i)
            {
              localObject1 = localObject4;
              localObject2 = str.substring(i + 9, str.length());
              paramHttpURLConnection = localObject3;
              if (localObject2 != null)
              {
                localObject1 = localObject4;
                i = ((String)localObject2).indexOf(";");
                if (-1 == i) {
                  break label271;
                }
                localObject1 = localObject4;
                paramHttpURLConnection = ((String)localObject2).substring(0, i - 1);
              }
            }
            localObject1 = paramHttpURLConnection;
            localObject2 = paramHttpURLConnection;
            if (!TextUtils.isEmpty(paramHttpURLConnection))
            {
              localObject1 = paramHttpURLConnection;
              i = paramHttpURLConnection.indexOf("\"");
              localObject1 = paramHttpURLConnection;
              j = paramHttpURLConnection.lastIndexOf("\"");
              localObject2 = paramHttpURLConnection;
              if (i == 0)
              {
                localObject1 = paramHttpURLConnection;
                localObject2 = paramHttpURLConnection;
                if (j + 1 == paramHttpURLConnection.length())
                {
                  localObject1 = paramHttpURLConnection;
                  paramHttpURLConnection = paramHttpURLConnection.substring(1);
                  localObject1 = paramHttpURLConnection;
                  paramHttpURLConnection = paramHttpURLConnection.substring(0, paramHttpURLConnection.length() - 1);
                  return paramHttpURLConnection;
                }
              }
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        localObject2 = localObject1;
      }
      return localObject2;
      label271:
      paramHttpURLConnection = (HttpURLConnection)localObject2;
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, null);
  }
  
  public static void a(String paramString, IGetFileInfoCallBack paramIGetFileInfoCallBack)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadUtil.1(paramString, paramIGetFileInfoCallBack));
  }
  
  public static void a(String paramString, UniformDownloadUtil.GetApkNameCallback paramGetApkNameCallback)
  {
    QQFileManagerUtil.FileExecutor.a().execute(new UniformDownloadUtil.2(paramString, paramGetApkNameCallback));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, new UniformDownloadUtil.3(paramString1, paramString2));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (FileUtil.a(paramString).equalsIgnoreCase(".apk"));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, new UniformDownloadUtil.4(paramString1, paramString2));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] >>>openFileWithOtherApp. localPath:");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("UniformDownloadUtil", 1, ((StringBuilder)localObject).toString());
    BaseApplication localBaseApplication;
    Intent localIntent;
    if ((paramString1 != null) && (FileUtil.b(paramString1)))
    {
      localBaseApplication = BaseApplication.getContext();
      if (paramString1.endsWith(".apk")) {
        localObject = AppSetting.h();
      } else {
        localObject = "";
      }
      localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("big_brother_source_key", paramString2);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString1)), (String)localObject);
    }
    try
    {
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      label131:
      break label131;
    }
    paramString2 = new StringBuilder();
    paramString2.append("[UniformDL] openFileWithOtherApp. no useful app. localPath:");
    paramString2.append(paramString1);
    QLog.w("UniformDownloadUtil", 1, paramString2.toString());
    return;
    paramString2 = new StringBuilder();
    paramString2.append("[UniformDL] openFileWithOtherApp. file is not existed. localPath:");
    paramString2.append(paramString1);
    QLog.e("UniformDownloadUtil", 1, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil
 * JD-Core Version:    0.7.0.1
 */