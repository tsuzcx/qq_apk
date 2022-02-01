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
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.uniformdownload.filemanager.FileUtil;
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
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. file is not exsited. PH:" + paramString1);
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
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static UniformDownloadUtil.FileInfo a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aconst_null
    //   3: astore 12
    //   5: ldc 228
    //   7: astore 10
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: invokevirtual 231	java/lang/String:length	()I
    //   17: iconst_1
    //   18: if_icmpge +13 -> 31
    //   21: new 233	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   24: dup
    //   25: aconst_null
    //   26: lconst_0
    //   27: invokespecial 236	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   30: areturn
    //   31: new 238	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 239	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 243	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 245	java/net/HttpURLConnection
    //   45: astore 11
    //   47: lload_1
    //   48: lstore_3
    //   49: aload 10
    //   51: astore 12
    //   53: lload_1
    //   54: lstore 5
    //   56: aload 10
    //   58: astore 13
    //   60: lload_1
    //   61: lstore 7
    //   63: aload 10
    //   65: astore 14
    //   67: aload 11
    //   69: ldc 247
    //   71: ldc 249
    //   73: invokevirtual 253	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_1
    //   77: lstore_3
    //   78: aload 10
    //   80: astore 12
    //   82: lload_1
    //   83: lstore 5
    //   85: aload 10
    //   87: astore 13
    //   89: lload_1
    //   90: lstore 7
    //   92: aload 10
    //   94: astore 14
    //   96: aload 11
    //   98: ldc 255
    //   100: ldc 249
    //   102: invokevirtual 253	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: lload_1
    //   106: lstore_3
    //   107: aload 10
    //   109: astore 12
    //   111: lload_1
    //   112: lstore 5
    //   114: aload 10
    //   116: astore 13
    //   118: lload_1
    //   119: lstore 7
    //   121: aload 10
    //   123: astore 14
    //   125: aload 11
    //   127: ldc 247
    //   129: ldc 249
    //   131: invokevirtual 253	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: lload_1
    //   135: lstore_3
    //   136: aload 10
    //   138: astore 12
    //   140: lload_1
    //   141: lstore 5
    //   143: aload 10
    //   145: astore 13
    //   147: lload_1
    //   148: lstore 7
    //   150: aload 10
    //   152: astore 14
    //   154: aload 11
    //   156: ldc 255
    //   158: ldc 249
    //   160: invokevirtual 253	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: lload_1
    //   164: lstore_3
    //   165: aload 10
    //   167: astore 12
    //   169: lload_1
    //   170: lstore 5
    //   172: aload 10
    //   174: astore 13
    //   176: lload_1
    //   177: lstore 7
    //   179: aload 10
    //   181: astore 14
    //   183: aload 11
    //   185: invokevirtual 258	java/net/HttpURLConnection:connect	()V
    //   188: lload_1
    //   189: lstore_3
    //   190: aload 10
    //   192: astore 12
    //   194: lload_1
    //   195: lstore 5
    //   197: aload 10
    //   199: astore 13
    //   201: lload_1
    //   202: lstore 7
    //   204: aload 10
    //   206: astore 14
    //   208: aload 11
    //   210: invokevirtual 261	java/net/HttpURLConnection:getResponseCode	()I
    //   213: pop
    //   214: lload_1
    //   215: lstore_3
    //   216: aload 10
    //   218: astore 12
    //   220: lload_1
    //   221: lstore 5
    //   223: aload 10
    //   225: astore 13
    //   227: lload_1
    //   228: lstore 7
    //   230: aload 10
    //   232: astore 14
    //   234: aload 11
    //   236: invokevirtual 265	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   239: astore 16
    //   241: lload_1
    //   242: lstore_3
    //   243: aload 10
    //   245: astore 12
    //   247: lload_1
    //   248: lstore 5
    //   250: aload 10
    //   252: astore 13
    //   254: lload_1
    //   255: lstore 7
    //   257: aload 10
    //   259: astore 14
    //   261: ldc_w 267
    //   264: iconst_1
    //   265: new 29	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 269
    //   275: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 16
    //   280: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: lload_1
    //   290: lstore_3
    //   291: aload 10
    //   293: astore 12
    //   295: lload_1
    //   296: lstore 5
    //   298: aload 10
    //   300: astore 13
    //   302: lload_1
    //   303: lstore 7
    //   305: aload 10
    //   307: astore 14
    //   309: aload 11
    //   311: invokevirtual 275	java/net/HttpURLConnection:getContentLength	()I
    //   314: i2l
    //   315: lstore_1
    //   316: lload_1
    //   317: lstore_3
    //   318: aload 10
    //   320: astore 12
    //   322: lload_1
    //   323: lstore 5
    //   325: aload 10
    //   327: astore 13
    //   329: lload_1
    //   330: lstore 7
    //   332: aload 10
    //   334: astore 14
    //   336: aload 11
    //   338: invokestatic 278	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   341: astore 15
    //   343: aload 15
    //   345: astore 10
    //   347: lload_1
    //   348: lstore_3
    //   349: aload 15
    //   351: astore 12
    //   353: lload_1
    //   354: lstore 5
    //   356: aload 15
    //   358: astore 13
    //   360: lload_1
    //   361: lstore 7
    //   363: aload 15
    //   365: astore 14
    //   367: aload 15
    //   369: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +39 -> 411
    //   375: aload 15
    //   377: astore 10
    //   379: aload 16
    //   381: ifnull +30 -> 411
    //   384: lload_1
    //   385: lstore_3
    //   386: aload 15
    //   388: astore 12
    //   390: lload_1
    //   391: lstore 5
    //   393: aload 15
    //   395: astore 13
    //   397: lload_1
    //   398: lstore 7
    //   400: aload 15
    //   402: astore 14
    //   404: aload 16
    //   406: invokevirtual 287	java/net/URL:getFile	()Ljava/lang/String;
    //   409: astore 10
    //   411: aload 10
    //   413: ifnull +418 -> 831
    //   416: lload_1
    //   417: lstore_3
    //   418: aload 10
    //   420: astore 12
    //   422: lload_1
    //   423: lstore 5
    //   425: aload 10
    //   427: astore 13
    //   429: lload_1
    //   430: lstore 7
    //   432: aload 10
    //   434: astore 14
    //   436: aload 10
    //   438: ldc_w 289
    //   441: invokevirtual 292	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   444: ifne +38 -> 482
    //   447: lload_1
    //   448: lstore_3
    //   449: aload 10
    //   451: astore 12
    //   453: lload_1
    //   454: lstore 5
    //   456: aload 10
    //   458: astore 13
    //   460: lload_1
    //   461: lstore 7
    //   463: aload 10
    //   465: astore 14
    //   467: aload 10
    //   469: ldc_w 294
    //   472: invokevirtual 292	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   475: istore 9
    //   477: iload 9
    //   479: ifeq +352 -> 831
    //   482: aconst_null
    //   483: astore 10
    //   485: aload 11
    //   487: ifnull +341 -> 828
    //   490: aload 11
    //   492: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   495: ldc 228
    //   497: astore 12
    //   499: aload 12
    //   501: astore 11
    //   503: aload_0
    //   504: invokestatic 303	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   507: astore 13
    //   509: aload 12
    //   511: astore_0
    //   512: aload 13
    //   514: ifnull +61 -> 575
    //   517: aload 12
    //   519: astore 11
    //   521: aload 13
    //   523: invokevirtual 306	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   526: astore 12
    //   528: aload 12
    //   530: astore_0
    //   531: aload 12
    //   533: ifnull +42 -> 575
    //   536: aload 12
    //   538: astore 11
    //   540: aload 12
    //   542: ldc_w 289
    //   545: invokevirtual 292	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   548: ifne +25 -> 573
    //   551: aload 12
    //   553: astore 11
    //   555: aload 12
    //   557: ldc_w 294
    //   560: invokevirtual 292	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   563: istore 9
    //   565: aload 12
    //   567: astore_0
    //   568: iload 9
    //   570: ifeq +5 -> 575
    //   573: aconst_null
    //   574: astore_0
    //   575: aload 10
    //   577: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   580: ifne +177 -> 757
    //   583: new 233	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   586: dup
    //   587: aload 10
    //   589: lload_1
    //   590: invokespecial 236	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   593: areturn
    //   594: astore 13
    //   596: lconst_0
    //   597: lstore_3
    //   598: ldc 228
    //   600: astore 11
    //   602: aconst_null
    //   603: astore 12
    //   605: aload 12
    //   607: astore 10
    //   609: aload 13
    //   611: invokevirtual 307	java/net/MalformedURLException:printStackTrace	()V
    //   614: lload_3
    //   615: lstore_1
    //   616: aload 11
    //   618: astore 10
    //   620: aload 12
    //   622: ifnull -127 -> 495
    //   625: aload 12
    //   627: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   630: lload_3
    //   631: lstore_1
    //   632: aload 11
    //   634: astore 10
    //   636: goto -141 -> 495
    //   639: astore 13
    //   641: lconst_0
    //   642: lstore_3
    //   643: ldc 228
    //   645: astore 11
    //   647: aconst_null
    //   648: astore 12
    //   650: aload 12
    //   652: astore 10
    //   654: aload 13
    //   656: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   659: lload_3
    //   660: lstore_1
    //   661: aload 11
    //   663: astore 10
    //   665: aload 12
    //   667: ifnull -172 -> 495
    //   670: aload 12
    //   672: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   675: lload_3
    //   676: lstore_1
    //   677: aload 11
    //   679: astore 10
    //   681: goto -186 -> 495
    //   684: astore 13
    //   686: lconst_0
    //   687: lstore_3
    //   688: ldc 228
    //   690: astore 11
    //   692: aconst_null
    //   693: astore 12
    //   695: aload 12
    //   697: astore 10
    //   699: aload 13
    //   701: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   704: lload_3
    //   705: lstore_1
    //   706: aload 11
    //   708: astore 10
    //   710: aload 12
    //   712: ifnull -217 -> 495
    //   715: aload 12
    //   717: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   720: lload_3
    //   721: lstore_1
    //   722: aload 11
    //   724: astore 10
    //   726: goto -231 -> 495
    //   729: astore_0
    //   730: aload 12
    //   732: astore 10
    //   734: aload 10
    //   736: ifnull +8 -> 744
    //   739: aload 10
    //   741: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   744: aload_0
    //   745: athrow
    //   746: astore_0
    //   747: aload_0
    //   748: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   751: aload 11
    //   753: astore_0
    //   754: goto -179 -> 575
    //   757: aload_0
    //   758: astore 10
    //   760: goto -177 -> 583
    //   763: astore_0
    //   764: aload 11
    //   766: astore 10
    //   768: goto -34 -> 734
    //   771: astore_0
    //   772: goto -38 -> 734
    //   775: astore 13
    //   777: aload 12
    //   779: astore 10
    //   781: aload 11
    //   783: astore 12
    //   785: aload 10
    //   787: astore 11
    //   789: goto -94 -> 695
    //   792: astore 10
    //   794: lload 5
    //   796: lstore_3
    //   797: aload 11
    //   799: astore 12
    //   801: aload 13
    //   803: astore 11
    //   805: aload 10
    //   807: astore 13
    //   809: goto -159 -> 650
    //   812: astore 13
    //   814: lload 7
    //   816: lstore_3
    //   817: aload 11
    //   819: astore 12
    //   821: aload 14
    //   823: astore 11
    //   825: goto -220 -> 605
    //   828: goto -333 -> 495
    //   831: goto -346 -> 485
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	834	0	paramString	String
    //   1	721	1	l1	long
    //   48	769	3	l2	long
    //   54	741	5	l3	long
    //   61	754	7	l4	long
    //   475	94	9	bool	boolean
    //   7	779	10	localObject1	Object
    //   792	14	10	localIOException1	java.io.IOException
    //   45	779	11	localObject2	Object
    //   3	817	12	localObject3	Object
    //   58	464	13	localObject4	Object
    //   594	16	13	localMalformedURLException1	java.net.MalformedURLException
    //   639	16	13	localIOException2	java.io.IOException
    //   684	16	13	localException1	Exception
    //   775	27	13	localException2	Exception
    //   807	1	13	localIOException3	java.io.IOException
    //   812	1	13	localMalformedURLException2	java.net.MalformedURLException
    //   65	757	14	localObject5	Object
    //   341	60	15	str	String
    //   239	166	16	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   31	47	594	java/net/MalformedURLException
    //   31	47	639	java/io/IOException
    //   31	47	684	java/lang/Exception
    //   31	47	729	finally
    //   503	509	746	java/lang/Exception
    //   521	528	746	java/lang/Exception
    //   540	551	746	java/lang/Exception
    //   555	565	746	java/lang/Exception
    //   67	76	763	finally
    //   96	105	763	finally
    //   125	134	763	finally
    //   154	163	763	finally
    //   183	188	763	finally
    //   208	214	763	finally
    //   234	241	763	finally
    //   261	289	763	finally
    //   309	316	763	finally
    //   336	343	763	finally
    //   367	375	763	finally
    //   404	411	763	finally
    //   436	447	763	finally
    //   467	477	763	finally
    //   609	614	771	finally
    //   654	659	771	finally
    //   699	704	771	finally
    //   67	76	775	java/lang/Exception
    //   96	105	775	java/lang/Exception
    //   125	134	775	java/lang/Exception
    //   154	163	775	java/lang/Exception
    //   183	188	775	java/lang/Exception
    //   208	214	775	java/lang/Exception
    //   234	241	775	java/lang/Exception
    //   261	289	775	java/lang/Exception
    //   309	316	775	java/lang/Exception
    //   336	343	775	java/lang/Exception
    //   367	375	775	java/lang/Exception
    //   404	411	775	java/lang/Exception
    //   436	447	775	java/lang/Exception
    //   467	477	775	java/lang/Exception
    //   67	76	792	java/io/IOException
    //   96	105	792	java/io/IOException
    //   125	134	792	java/io/IOException
    //   154	163	792	java/io/IOException
    //   183	188	792	java/io/IOException
    //   208	214	792	java/io/IOException
    //   234	241	792	java/io/IOException
    //   261	289	792	java/io/IOException
    //   309	316	792	java/io/IOException
    //   336	343	792	java/io/IOException
    //   367	375	792	java/io/IOException
    //   404	411	792	java/io/IOException
    //   436	447	792	java/io/IOException
    //   467	477	792	java/io/IOException
    //   67	76	812	java/net/MalformedURLException
    //   96	105	812	java/net/MalformedURLException
    //   125	134	812	java/net/MalformedURLException
    //   154	163	812	java/net/MalformedURLException
    //   183	188	812	java/net/MalformedURLException
    //   208	214	812	java/net/MalformedURLException
    //   234	241	812	java/net/MalformedURLException
    //   261	289	812	java/net/MalformedURLException
    //   309	316	812	java/net/MalformedURLException
    //   336	343	812	java/net/MalformedURLException
    //   367	375	812	java/net/MalformedURLException
    //   404	411	812	java/net/MalformedURLException
    //   436	447	812	java/net/MalformedURLException
    //   467	477	812	java/net/MalformedURLException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (localObject == null) {
          break label89;
        }
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
        if (localObject != null) {
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
        paramString.printStackTrace();
        return null;
      }
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + paramString);
      return null;
      label89:
      Object localObject = null;
    }
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject4;
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
              localObject2 = str.substring(i + "filename=".length(), str.length());
              paramHttpURLConnection = localObject3;
              if (localObject2 != null)
              {
                localObject1 = localObject4;
                i = ((String)localObject2).indexOf(";");
                if (-1 == i) {
                  continue;
                }
                localObject1 = localObject4;
                paramHttpURLConnection = ((String)localObject2).substring(0, i - 1);
              }
            }
            localObject2 = paramHttpURLConnection;
            localObject1 = paramHttpURLConnection;
            if (!TextUtils.isEmpty(paramHttpURLConnection))
            {
              localObject1 = paramHttpURLConnection;
              i = paramHttpURLConnection.indexOf("\"");
              localObject1 = paramHttpURLConnection;
              j = paramHttpURLConnection.lastIndexOf("\"");
              localObject2 = paramHttpURLConnection;
              if (i == 0)
              {
                localObject2 = paramHttpURLConnection;
                localObject1 = paramHttpURLConnection;
                if (j + 1 == paramHttpURLConnection.length())
                {
                  localObject1 = paramHttpURLConnection;
                  paramHttpURLConnection = paramHttpURLConnection.substring(1);
                }
              }
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramHttpURLConnection) {}
      try
      {
        localObject2 = paramHttpURLConnection.substring(0, paramHttpURLConnection.length() - 1);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localObject1 = paramHttpURLConnection;
          paramHttpURLConnection = localUnsupportedEncodingException;
        }
      }
      paramHttpURLConnection = (HttpURLConnection)localObject2;
    }
    paramHttpURLConnection.printStackTrace();
    return localObject1;
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
    FileManagerUtil.FileExecutor.a().execute(new UniformDownloadUtil.2(paramString, paramGetApkNameCallback));
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
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString1);
    if ((paramString1 == null) || (!FileUtil.a(paramString1)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString1);
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = "";
    if (paramString1.endsWith(".apk")) {
      str = AppSetting.h();
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramString2);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString1)), str);
    try
    {
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil
 * JD-Core Version:    0.7.0.1
 */