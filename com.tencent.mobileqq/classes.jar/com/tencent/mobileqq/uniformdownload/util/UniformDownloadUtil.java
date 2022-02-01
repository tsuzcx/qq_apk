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
                  break label263;
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
      label263:
      paramHttpURLConnection = (HttpURLConnection)localObject2;
    }
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
  
  public static int b(String paramString1, String paramString2)
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
  
  /* Error */
  public static UniformDownloadUtil.FileInfo b(String paramString)
  {
    // Byte code:
    //   0: ldc_w 326
    //   3: astore 14
    //   5: lconst_0
    //   6: lstore_1
    //   7: aload_0
    //   8: ifnull +750 -> 758
    //   11: aload_0
    //   12: invokevirtual 207	java/lang/String:length	()I
    //   15: iconst_1
    //   16: if_icmpge +6 -> 22
    //   19: goto +739 -> 758
    //   22: new 328	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 329	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 333	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 175	java/net/HttpURLConnection
    //   36: astore 13
    //   38: lload_1
    //   39: lstore_3
    //   40: lload_1
    //   41: lstore 5
    //   43: lload_1
    //   44: lstore 7
    //   46: aload 13
    //   48: astore 12
    //   50: aload 13
    //   52: ldc_w 335
    //   55: ldc 187
    //   57: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: lload_1
    //   61: lstore_3
    //   62: lload_1
    //   63: lstore 5
    //   65: lload_1
    //   66: lstore 7
    //   68: aload 13
    //   70: astore 12
    //   72: aload 13
    //   74: ldc_w 340
    //   77: ldc 187
    //   79: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: lload_1
    //   83: lstore_3
    //   84: lload_1
    //   85: lstore 5
    //   87: lload_1
    //   88: lstore 7
    //   90: aload 13
    //   92: astore 12
    //   94: aload 13
    //   96: ldc_w 335
    //   99: ldc 187
    //   101: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: lload_1
    //   105: lstore_3
    //   106: lload_1
    //   107: lstore 5
    //   109: lload_1
    //   110: lstore 7
    //   112: aload 13
    //   114: astore 12
    //   116: aload 13
    //   118: ldc_w 340
    //   121: ldc 187
    //   123: invokevirtual 338	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: lload_1
    //   127: lstore_3
    //   128: lload_1
    //   129: lstore 5
    //   131: lload_1
    //   132: lstore 7
    //   134: aload 13
    //   136: astore 12
    //   138: aload 13
    //   140: invokevirtual 343	java/net/HttpURLConnection:connect	()V
    //   143: lload_1
    //   144: lstore_3
    //   145: lload_1
    //   146: lstore 5
    //   148: lload_1
    //   149: lstore 7
    //   151: aload 13
    //   153: astore 12
    //   155: aload 13
    //   157: invokevirtual 346	java/net/HttpURLConnection:getResponseCode	()I
    //   160: pop
    //   161: lload_1
    //   162: lstore_3
    //   163: lload_1
    //   164: lstore 5
    //   166: lload_1
    //   167: lstore 7
    //   169: aload 13
    //   171: astore 12
    //   173: aload 13
    //   175: invokevirtual 350	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   178: astore 10
    //   180: lload_1
    //   181: lstore_3
    //   182: lload_1
    //   183: lstore 5
    //   185: lload_1
    //   186: lstore 7
    //   188: aload 13
    //   190: astore 12
    //   192: new 276	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   199: astore 11
    //   201: lload_1
    //   202: lstore_3
    //   203: lload_1
    //   204: lstore 5
    //   206: lload_1
    //   207: lstore 7
    //   209: aload 13
    //   211: astore 12
    //   213: aload 11
    //   215: ldc_w 352
    //   218: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: lload_1
    //   223: lstore_3
    //   224: lload_1
    //   225: lstore 5
    //   227: lload_1
    //   228: lstore 7
    //   230: aload 13
    //   232: astore 12
    //   234: aload 11
    //   236: aload 10
    //   238: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: lload_1
    //   243: lstore_3
    //   244: lload_1
    //   245: lstore 5
    //   247: lload_1
    //   248: lstore 7
    //   250: aload 13
    //   252: astore 12
    //   254: ldc_w 357
    //   257: iconst_1
    //   258: aload 11
    //   260: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: lload_1
    //   267: lstore_3
    //   268: lload_1
    //   269: lstore 5
    //   271: lload_1
    //   272: lstore 7
    //   274: aload 13
    //   276: astore 12
    //   278: aload 13
    //   280: invokevirtual 360	java/net/HttpURLConnection:getContentLength	()I
    //   283: i2l
    //   284: lstore_1
    //   285: lload_1
    //   286: lstore_3
    //   287: lload_1
    //   288: lstore 5
    //   290: lload_1
    //   291: lstore 7
    //   293: aload 13
    //   295: astore 12
    //   297: aload 13
    //   299: invokestatic 362	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   302: astore 11
    //   304: aload 13
    //   306: astore 12
    //   308: aload 11
    //   310: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +22 -> 335
    //   316: aload 10
    //   318: ifnull +17 -> 335
    //   321: aload 13
    //   323: astore 12
    //   325: aload 10
    //   327: invokevirtual 365	java/net/URL:getFile	()Ljava/lang/String;
    //   330: astore 10
    //   332: goto +7 -> 339
    //   335: aload 11
    //   337: astore 10
    //   339: aload 10
    //   341: astore 11
    //   343: aload 10
    //   345: ifnull +92 -> 437
    //   348: aload 13
    //   350: astore 12
    //   352: aload 10
    //   354: ldc_w 367
    //   357: invokevirtual 370	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifne +26 -> 386
    //   363: aload 13
    //   365: astore 12
    //   367: aload 10
    //   369: ldc_w 372
    //   372: invokevirtual 370	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   375: istore 9
    //   377: aload 10
    //   379: astore 11
    //   381: iload 9
    //   383: ifeq +54 -> 437
    //   386: aconst_null
    //   387: astore 11
    //   389: goto +48 -> 437
    //   392: astore 12
    //   394: aload 10
    //   396: astore 11
    //   398: aload 12
    //   400: astore 10
    //   402: lload_1
    //   403: lstore_3
    //   404: goto +126 -> 530
    //   407: astore 12
    //   409: aload 10
    //   411: astore 11
    //   413: aload 12
    //   415: astore 10
    //   417: lload_1
    //   418: lstore_3
    //   419: goto +157 -> 576
    //   422: astore 12
    //   424: aload 10
    //   426: astore 11
    //   428: aload 12
    //   430: astore 10
    //   432: lload_1
    //   433: lstore_3
    //   434: goto +171 -> 605
    //   437: aload 13
    //   439: ifnull +8 -> 447
    //   442: aload 13
    //   444: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   447: aload 11
    //   449: astore 10
    //   451: goto +183 -> 634
    //   454: astore 10
    //   456: lload_1
    //   457: lstore_3
    //   458: goto +72 -> 530
    //   461: astore 10
    //   463: lload_1
    //   464: lstore_3
    //   465: goto +111 -> 576
    //   468: astore 10
    //   470: lload_1
    //   471: lstore_3
    //   472: goto +133 -> 605
    //   475: astore 10
    //   477: ldc_w 326
    //   480: astore 11
    //   482: goto +48 -> 530
    //   485: astore 10
    //   487: ldc_w 326
    //   490: astore 11
    //   492: lload 5
    //   494: lstore_3
    //   495: goto +81 -> 576
    //   498: astore 10
    //   500: ldc_w 326
    //   503: astore 11
    //   505: lload 7
    //   507: lstore_3
    //   508: goto +97 -> 605
    //   511: astore_0
    //   512: aconst_null
    //   513: astore 12
    //   515: goto +231 -> 746
    //   518: astore 10
    //   520: ldc_w 326
    //   523: astore 11
    //   525: aconst_null
    //   526: astore 13
    //   528: lload_1
    //   529: lstore_3
    //   530: aload 13
    //   532: astore 12
    //   534: aload 10
    //   536: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   539: aload 11
    //   541: astore 10
    //   543: lload_3
    //   544: lstore_1
    //   545: aload 13
    //   547: ifnull +87 -> 634
    //   550: lload_3
    //   551: lstore_1
    //   552: aload 11
    //   554: astore 10
    //   556: aload 13
    //   558: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   561: goto +73 -> 634
    //   564: astore 10
    //   566: ldc_w 326
    //   569: astore 11
    //   571: aconst_null
    //   572: astore 13
    //   574: lload_1
    //   575: lstore_3
    //   576: aload 13
    //   578: astore 12
    //   580: aload 10
    //   582: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   585: aload 11
    //   587: astore 10
    //   589: lload_3
    //   590: lstore_1
    //   591: aload 13
    //   593: ifnull +41 -> 634
    //   596: aload 11
    //   598: astore 10
    //   600: lload_3
    //   601: lstore_1
    //   602: goto -46 -> 556
    //   605: aload 13
    //   607: astore 12
    //   609: aload 10
    //   611: invokevirtual 377	java/net/MalformedURLException:printStackTrace	()V
    //   614: aload 11
    //   616: astore 10
    //   618: lload_3
    //   619: lstore_1
    //   620: aload 13
    //   622: ifnull +12 -> 634
    //   625: aload 11
    //   627: astore 10
    //   629: lload_3
    //   630: lstore_1
    //   631: goto -75 -> 556
    //   634: aload 14
    //   636: astore 11
    //   638: aload_0
    //   639: invokestatic 383	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   642: astore 12
    //   644: aload 14
    //   646: astore_0
    //   647: aload 12
    //   649: ifnull +72 -> 721
    //   652: aload 14
    //   654: astore 11
    //   656: aload 12
    //   658: invokevirtual 386	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   661: astore 12
    //   663: aload 12
    //   665: astore_0
    //   666: aload 12
    //   668: ifnull +53 -> 721
    //   671: aload 12
    //   673: astore 11
    //   675: aload 12
    //   677: ldc_w 367
    //   680: invokevirtual 370	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   683: ifne +25 -> 708
    //   686: aload 12
    //   688: astore 11
    //   690: aload 12
    //   692: ldc_w 372
    //   695: invokevirtual 370	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   698: istore 9
    //   700: aload 12
    //   702: astore_0
    //   703: iload 9
    //   705: ifeq +16 -> 721
    //   708: aconst_null
    //   709: astore_0
    //   710: goto +11 -> 721
    //   713: astore_0
    //   714: aload_0
    //   715: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   718: aload 11
    //   720: astore_0
    //   721: aload 10
    //   723: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   726: ifne +9 -> 735
    //   729: aload 10
    //   731: astore_0
    //   732: goto +3 -> 735
    //   735: new 388	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   738: dup
    //   739: aload_0
    //   740: lload_1
    //   741: invokespecial 391	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   744: areturn
    //   745: astore_0
    //   746: aload 12
    //   748: ifnull +8 -> 756
    //   751: aload 12
    //   753: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   756: aload_0
    //   757: athrow
    //   758: new 388	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo
    //   761: dup
    //   762: aconst_null
    //   763: lconst_0
    //   764: invokespecial 391	com/tencent/mobileqq/uniformdownload/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   767: areturn
    //   768: astore 10
    //   770: ldc_w 326
    //   773: astore 11
    //   775: aconst_null
    //   776: astore 13
    //   778: lload_1
    //   779: lstore_3
    //   780: goto -175 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	paramString	String
    //   6	773	1	l1	long
    //   39	741	3	l2	long
    //   41	452	5	l3	long
    //   44	462	7	l4	long
    //   375	329	9	bool	boolean
    //   178	272	10	localObject1	Object
    //   454	1	10	localException1	Exception
    //   461	1	10	localIOException1	java.io.IOException
    //   468	1	10	localMalformedURLException1	java.net.MalformedURLException
    //   475	1	10	localException2	Exception
    //   485	1	10	localIOException2	java.io.IOException
    //   498	1	10	localMalformedURLException2	java.net.MalformedURLException
    //   518	17	10	localException3	Exception
    //   541	14	10	localObject2	Object
    //   564	17	10	localIOException3	java.io.IOException
    //   587	143	10	localObject3	Object
    //   768	1	10	localMalformedURLException3	java.net.MalformedURLException
    //   199	575	11	localObject4	Object
    //   48	318	12	localHttpURLConnection1	HttpURLConnection
    //   392	7	12	localException4	Exception
    //   407	7	12	localIOException4	java.io.IOException
    //   422	7	12	localMalformedURLException4	java.net.MalformedURLException
    //   513	239	12	localObject5	Object
    //   36	741	13	localHttpURLConnection2	HttpURLConnection
    //   3	650	14	str	String
    // Exception table:
    //   from	to	target	type
    //   352	363	392	java/lang/Exception
    //   367	377	392	java/lang/Exception
    //   352	363	407	java/io/IOException
    //   367	377	407	java/io/IOException
    //   352	363	422	java/net/MalformedURLException
    //   367	377	422	java/net/MalformedURLException
    //   308	316	454	java/lang/Exception
    //   325	332	454	java/lang/Exception
    //   308	316	461	java/io/IOException
    //   325	332	461	java/io/IOException
    //   308	316	468	java/net/MalformedURLException
    //   325	332	468	java/net/MalformedURLException
    //   50	60	475	java/lang/Exception
    //   72	82	475	java/lang/Exception
    //   94	104	475	java/lang/Exception
    //   116	126	475	java/lang/Exception
    //   138	143	475	java/lang/Exception
    //   155	161	475	java/lang/Exception
    //   173	180	475	java/lang/Exception
    //   192	201	475	java/lang/Exception
    //   213	222	475	java/lang/Exception
    //   234	242	475	java/lang/Exception
    //   254	266	475	java/lang/Exception
    //   278	285	475	java/lang/Exception
    //   297	304	475	java/lang/Exception
    //   50	60	485	java/io/IOException
    //   72	82	485	java/io/IOException
    //   94	104	485	java/io/IOException
    //   116	126	485	java/io/IOException
    //   138	143	485	java/io/IOException
    //   155	161	485	java/io/IOException
    //   173	180	485	java/io/IOException
    //   192	201	485	java/io/IOException
    //   213	222	485	java/io/IOException
    //   234	242	485	java/io/IOException
    //   254	266	485	java/io/IOException
    //   278	285	485	java/io/IOException
    //   297	304	485	java/io/IOException
    //   50	60	498	java/net/MalformedURLException
    //   72	82	498	java/net/MalformedURLException
    //   94	104	498	java/net/MalformedURLException
    //   116	126	498	java/net/MalformedURLException
    //   138	143	498	java/net/MalformedURLException
    //   155	161	498	java/net/MalformedURLException
    //   173	180	498	java/net/MalformedURLException
    //   192	201	498	java/net/MalformedURLException
    //   213	222	498	java/net/MalformedURLException
    //   234	242	498	java/net/MalformedURLException
    //   254	266	498	java/net/MalformedURLException
    //   278	285	498	java/net/MalformedURLException
    //   297	304	498	java/net/MalformedURLException
    //   22	38	511	finally
    //   22	38	518	java/lang/Exception
    //   22	38	564	java/io/IOException
    //   638	644	713	java/lang/Exception
    //   656	663	713	java/lang/Exception
    //   675	686	713	java/lang/Exception
    //   690	700	713	java/lang/Exception
    //   50	60	745	finally
    //   72	82	745	finally
    //   94	104	745	finally
    //   116	126	745	finally
    //   138	143	745	finally
    //   155	161	745	finally
    //   173	180	745	finally
    //   192	201	745	finally
    //   213	222	745	finally
    //   234	242	745	finally
    //   254	266	745	finally
    //   278	285	745	finally
    //   297	304	745	finally
    //   308	316	745	finally
    //   325	332	745	finally
    //   352	363	745	finally
    //   367	377	745	finally
    //   534	539	745	finally
    //   580	585	745	finally
    //   609	614	745	finally
    //   22	38	768	java/net/MalformedURLException
  }
  
  public static String c(String paramString)
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
  
  public static void c(String paramString1, String paramString2)
  {
    a(paramString1, new UniformDownloadUtil.4(paramString1, paramString2));
  }
  
  public static void d(String paramString)
  {
    a(paramString, null);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] >>>openFileWithOtherApp. localPath:");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("UniformDownloadUtil", 1, ((StringBuilder)localObject).toString());
    BaseApplication localBaseApplication;
    Intent localIntent;
    if ((paramString1 != null) && (FileUtil.d(paramString1)))
    {
      localBaseApplication = BaseApplication.getContext();
      if (paramString1.endsWith(".apk")) {
        localObject = AppSetting.o();
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
      label133:
      break label133;
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
  
  public static int e(String paramString)
  {
    return b(paramString, null);
  }
  
  public static boolean f(String paramString)
  {
    return (paramString != null) && (FileUtil.a(paramString).equalsIgnoreCase(".apk"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil
 * JD-Core Version:    0.7.0.1
 */