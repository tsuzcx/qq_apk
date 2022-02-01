package com.tencent.mobileqq.webview.swift.utils;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.util.LRULinkedHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class SwiftOfflineDataUtils
{
  private static final LRULinkedHashMap<String, SwiftOfflineDataUtils.OfflineData> a = new LRULinkedHashMap(4);
  private static WeakReference<OfflineWebResManager> b = null;
  
  private static OfflineWebResManager a(OfflineWebResManager paramOfflineWebResManager)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (MobileQQ.sProcessId == 7)
    {
      localAppRuntime = localAppRuntime.getAppRuntime("modular_web");
      if ((localAppRuntime instanceof AppInterface)) {
        return new OfflineWebResManager((AppInterface)localAppRuntime);
      }
    }
    else if ((localAppRuntime instanceof AppInterface))
    {
      paramOfflineWebResManager = new OfflineWebResManager((AppInterface)localAppRuntime);
    }
    return paramOfflineWebResManager;
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: getstatic 66	com/tencent/common/config/AppSetting:h	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: invokestatic 69	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils$OfflineData;
    //   12: ifnull +19 -> 31
    //   15: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 77
    //   23: iconst_2
    //   24: ldc 79
    //   26: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +11 -> 45
    //   37: ldc 77
    //   39: iconst_2
    //   40: ldc 85
    //   42: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: invokestatic 91	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   49: ldc 93
    //   51: invokevirtual 97	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 11
    //   56: aload 11
    //   58: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifeq +5 -> 66
    //   64: iconst_0
    //   65: ireturn
    //   66: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   69: lstore_2
    //   70: aload 11
    //   72: invokestatic 112	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 11
    //   77: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   80: lstore 4
    //   82: aload 11
    //   84: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +5 -> 92
    //   90: iconst_0
    //   91: ireturn
    //   92: new 114	org/json/JSONObject
    //   95: dup
    //   96: aload 11
    //   98: invokespecial 117	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   101: astore 11
    //   103: aload_0
    //   104: invokestatic 122	com/tencent/biz/common/offline/HtmlOffline:g	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 13
    //   109: aload 13
    //   111: ifnonnull +5 -> 116
    //   114: iconst_0
    //   115: ireturn
    //   116: aload 11
    //   118: aload 13
    //   120: invokevirtual 125	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore 12
    //   125: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   128: lstore 6
    //   130: getstatic 22	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:b	Lmqq/util/WeakReference;
    //   133: ifnull +29 -> 162
    //   136: getstatic 22	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:b	Lmqq/util/WeakReference;
    //   139: invokevirtual 131	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   142: ifnonnull +6 -> 148
    //   145: goto +17 -> 162
    //   148: getstatic 22	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:b	Lmqq/util/WeakReference;
    //   151: invokevirtual 131	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   154: checkcast 52	com/tencent/biz/webviewplugin/OfflineWebResManager
    //   157: astore 11
    //   159: goto +429 -> 588
    //   162: aconst_null
    //   163: invokestatic 133	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:a	(Lcom/tencent/biz/webviewplugin/OfflineWebResManager;)Lcom/tencent/biz/webviewplugin/OfflineWebResManager;
    //   166: astore 11
    //   168: new 127	mqq/util/WeakReference
    //   171: dup
    //   172: aload 11
    //   174: invokespecial 136	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   177: putstatic 22	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:b	Lmqq/util/WeakReference;
    //   180: goto +408 -> 588
    //   183: aload 11
    //   185: aload 12
    //   187: invokevirtual 139	com/tencent/biz/webviewplugin/OfflineWebResManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   190: astore 11
    //   192: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   195: lstore 8
    //   197: aload 11
    //   199: ifnonnull +5 -> 204
    //   202: iconst_0
    //   203: ireturn
    //   204: new 141	java/io/File
    //   207: dup
    //   208: invokestatic 147	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   211: invokevirtual 151	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   214: ldc 153
    //   216: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   219: astore 12
    //   221: aload 12
    //   223: invokevirtual 159	java/io/File:exists	()Z
    //   226: ifne +5 -> 231
    //   229: iconst_0
    //   230: ireturn
    //   231: new 141	java/io/File
    //   234: dup
    //   235: aload 12
    //   237: aload 11
    //   239: getfield 165	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   242: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   245: astore 11
    //   247: aload 11
    //   249: invokevirtual 159	java/io/File:exists	()Z
    //   252: ifne +5 -> 257
    //   255: iconst_0
    //   256: ireturn
    //   257: aload 13
    //   259: invokestatic 167	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 14
    //   264: new 169	java/io/FileInputStream
    //   267: dup
    //   268: aload 11
    //   270: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   273: astore 11
    //   275: aload 11
    //   277: astore 12
    //   279: aload 11
    //   281: invokevirtual 178	java/io/InputStream:available	()I
    //   284: istore_1
    //   285: iload_1
    //   286: ifne +10 -> 296
    //   289: aload 11
    //   291: invokevirtual 181	java/io/InputStream:close	()V
    //   294: iconst_0
    //   295: ireturn
    //   296: aload 11
    //   298: astore 12
    //   300: iload_1
    //   301: newarray byte
    //   303: astore 15
    //   305: aload 11
    //   307: astore 12
    //   309: iload_1
    //   310: aload 11
    //   312: aload 15
    //   314: invokevirtual 185	java/io/InputStream:read	([B)I
    //   317: if_icmpne +52 -> 369
    //   320: aload 11
    //   322: astore 12
    //   324: new 187	java/lang/String
    //   327: dup
    //   328: aload 15
    //   330: ldc 189
    //   332: invokespecial 192	java/lang/String:<init>	([BLjava/lang/String;)V
    //   335: astore 15
    //   337: aload 11
    //   339: astore 12
    //   341: getstatic 20	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils:a	Lcom/tencent/util/LRULinkedHashMap;
    //   344: aload 13
    //   346: new 194	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils$OfflineData
    //   349: dup
    //   350: aload 14
    //   352: aload 15
    //   354: ldc 189
    //   356: invokespecial 197	com/tencent/mobileqq/webview/swift/utils/SwiftOfflineDataUtils$OfflineData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   359: invokevirtual 201	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: iconst_1
    //   364: istore 10
    //   366: goto +6 -> 372
    //   369: iconst_0
    //   370: istore 10
    //   372: aload 11
    //   374: invokevirtual 181	java/io/InputStream:close	()V
    //   377: goto +67 -> 444
    //   380: astore_0
    //   381: goto +51 -> 432
    //   384: astore 13
    //   386: goto +18 -> 404
    //   389: goto +209 -> 598
    //   392: astore_0
    //   393: aconst_null
    //   394: astore 12
    //   396: goto +36 -> 432
    //   399: astore 13
    //   401: aconst_null
    //   402: astore 11
    //   404: aload 11
    //   406: astore 12
    //   408: ldc 77
    //   410: iconst_1
    //   411: aload 13
    //   413: invokevirtual 205	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   416: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 11
    //   421: ifnull +185 -> 606
    //   424: aload 11
    //   426: invokevirtual 181	java/io/InputStream:close	()V
    //   429: goto +177 -> 606
    //   432: aload 12
    //   434: ifnull +8 -> 442
    //   437: aload 12
    //   439: invokevirtual 181	java/io/InputStream:close	()V
    //   442: aload_0
    //   443: athrow
    //   444: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +116 -> 563
    //   450: new 210	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   457: astore 11
    //   459: aload 11
    //   461: ldc 213
    //   463: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 11
    //   469: lload 4
    //   471: lload_2
    //   472: lsub
    //   473: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 11
    //   479: ldc 222
    //   481: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 11
    //   487: lload 6
    //   489: lload 4
    //   491: lsub
    //   492: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 11
    //   498: ldc 224
    //   500: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 11
    //   506: lload 8
    //   508: lload 6
    //   510: lsub
    //   511: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 11
    //   517: ldc 226
    //   519: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 11
    //   525: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   528: lload_2
    //   529: lsub
    //   530: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 11
    //   536: ldc 228
    //   538: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 11
    //   544: aload_0
    //   545: invokestatic 122	com/tencent/biz/common/offline/HtmlOffline:g	(Ljava/lang/String;)Ljava/lang/String;
    //   548: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: ldc 77
    //   554: iconst_2
    //   555: aload 11
    //   557: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: iload 10
    //   565: ireturn
    //   566: astore_0
    //   567: ldc 77
    //   569: iconst_1
    //   570: ldc 233
    //   572: aload_0
    //   573: invokestatic 236	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   576: iconst_0
    //   577: ireturn
    //   578: astore 11
    //   580: goto +15 -> 595
    //   583: astore 12
    //   585: goto -196 -> 389
    //   588: aload 11
    //   590: ifnonnull -407 -> 183
    //   593: iconst_0
    //   594: ireturn
    //   595: aconst_null
    //   596: astore 11
    //   598: aload 11
    //   600: ifnull +6 -> 606
    //   603: goto -179 -> 424
    //   606: iconst_0
    //   607: istore 10
    //   609: goto -165 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramString	String
    //   284	34	1	i	int
    //   69	460	2	l1	long
    //   80	410	4	l2	long
    //   128	381	6	l3	long
    //   195	312	8	l4	long
    //   364	244	10	bool	boolean
    //   54	502	11	localObject1	Object
    //   578	11	11	localException1	java.lang.Exception
    //   596	3	11	localObject2	Object
    //   123	315	12	localObject3	Object
    //   583	1	12	localException2	java.lang.Exception
    //   107	238	13	str1	String
    //   384	1	13	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   399	13	13	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   262	89	14	str2	String
    //   303	50	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   279	285	380	finally
    //   300	305	380	finally
    //   309	320	380	finally
    //   324	337	380	finally
    //   341	363	380	finally
    //   408	419	380	finally
    //   279	285	384	java/lang/OutOfMemoryError
    //   300	305	384	java/lang/OutOfMemoryError
    //   309	320	384	java/lang/OutOfMemoryError
    //   324	337	384	java/lang/OutOfMemoryError
    //   341	363	384	java/lang/OutOfMemoryError
    //   264	275	392	finally
    //   264	275	399	java/lang/OutOfMemoryError
    //   31	45	566	java/lang/Exception
    //   45	64	566	java/lang/Exception
    //   66	90	566	java/lang/Exception
    //   92	109	566	java/lang/Exception
    //   116	145	566	java/lang/Exception
    //   148	159	566	java/lang/Exception
    //   162	180	566	java/lang/Exception
    //   183	197	566	java/lang/Exception
    //   204	229	566	java/lang/Exception
    //   231	255	566	java/lang/Exception
    //   257	264	566	java/lang/Exception
    //   289	294	566	java/lang/Exception
    //   372	377	566	java/lang/Exception
    //   424	429	566	java/lang/Exception
    //   437	442	566	java/lang/Exception
    //   442	444	566	java/lang/Exception
    //   444	563	566	java/lang/Exception
    //   264	275	578	java/lang/Exception
    //   279	285	583	java/lang/Exception
    //   300	305	583	java/lang/Exception
    //   309	320	583	java/lang/Exception
    //   324	337	583	java/lang/Exception
    //   341	363	583	java/lang/Exception
  }
  
  public static SwiftOfflineDataUtils.OfflineData b(String paramString)
  {
    if (AppSetting.h) {
      return null;
    }
    paramString = HtmlOffline.g(paramString);
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    } else {
      paramString = (SwiftOfflineDataUtils.OfflineData)a.get(paramString);
    }
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.a()) {}
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: getstatic 244	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: astore_1
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_1
    //   7: ifnull +24 -> 31
    //   10: getstatic 244	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_0
    //   14: invokevirtual 250	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +14 -> 31
    //   20: getstatic 244	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_0
    //   24: invokevirtual 251	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 187	java/lang/String
    //   30: areturn
    //   31: new 210	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: aload_0
    //   41: invokestatic 255	com/tencent/biz/common/offline/OfflineEnvHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: ldc_w 257
    //   58: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore_1
    //   67: new 141	java/io/File
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 159	java/io/File:exists	()Z
    //   78: ifne +5 -> 83
    //   81: aconst_null
    //   82: areturn
    //   83: new 260	java/io/BufferedInputStream
    //   86: dup
    //   87: new 169	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 261	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   95: invokespecial 264	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 269	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   103: astore_2
    //   104: getstatic 244	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   107: aload_0
    //   108: aload_2
    //   109: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_1
    //   114: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   117: aload_2
    //   118: areturn
    //   119: astore_2
    //   120: aload_1
    //   121: astore_0
    //   122: aload_2
    //   123: astore_1
    //   124: goto +9 -> 133
    //   127: goto +18 -> 145
    //   130: astore_1
    //   131: aload_2
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 271	java/io/BufferedInputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: goto -13 -> 143
    //   159: astore_0
    //   160: goto -33 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString	String
    //   3	121	1	localObject1	Object
    //   130	12	1	localObject2	Object
    //   144	6	1	localObject3	Object
    //   5	113	2	str	String
    //   119	13	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   99	113	119	finally
    //   83	99	130	finally
    //   83	99	155	java/lang/Exception
    //   99	113	159	java/lang/Exception
  }
  
  private static String d(String paramString)
  {
    if (paramString.endsWith(".css")) {
      return "text/css";
    }
    if (paramString.endsWith(".js")) {
      return "application/x-javascript";
    }
    if ((!paramString.endsWith(".jpg")) && (!paramString.endsWith(".gif")) && (!paramString.endsWith(".png")) && (!paramString.endsWith(".jpeg"))) {
      return "text/html";
    }
    return "image/*";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils
 * JD-Core Version:    0.7.0.1
 */