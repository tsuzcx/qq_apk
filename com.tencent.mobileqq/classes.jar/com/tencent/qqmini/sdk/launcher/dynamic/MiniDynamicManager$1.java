package com.tencent.qqmini.sdk.launcher.dynamic;

class MiniDynamicManager$1
  implements Runnable
{
  MiniDynamicManager$1(MiniDynamicManager paramMiniDynamicManager, MiniDexConfig paramMiniDexConfig, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 32	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   13: getfield 37	com/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig:dexUrl	Ljava/lang/String;
    //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 46	java/net/HttpURLConnection
    //   25: astore_2
    //   26: aload_2
    //   27: sipush 10000
    //   30: invokevirtual 50	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload_2
    //   34: ldc 52
    //   36: invokevirtual 55	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: invokevirtual 59	java/net/HttpURLConnection:getResponseCode	()I
    //   43: istore_1
    //   44: iload_1
    //   45: sipush 200
    //   48: if_icmpeq +52 -> 100
    //   51: ldc 61
    //   53: new 63	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   60: ldc 66
    //   62: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_1
    //   66: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 83	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iconst_0
    //   76: ifeq +11 -> 87
    //   79: new 85	java/lang/NullPointerException
    //   82: dup
    //   83: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   86: athrow
    //   87: iconst_0
    //   88: ifeq +11 -> 99
    //   91: new 85	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: return
    //   100: aload_2
    //   101: invokevirtual 90	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   104: astore_2
    //   105: new 92	java/io/File
    //   108: dup
    //   109: aload_0
    //   110: getfield 21	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexPath	Ljava/lang/String;
    //   113: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore 4
    //   118: aload 4
    //   120: invokevirtual 97	java/io/File:exists	()Z
    //   123: ifeq +9 -> 132
    //   126: aload 4
    //   128: invokevirtual 100	java/io/File:delete	()Z
    //   131: pop
    //   132: aload 4
    //   134: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   137: invokevirtual 97	java/io/File:exists	()Z
    //   140: ifne +12 -> 152
    //   143: aload 4
    //   145: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   148: invokevirtual 107	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: aload 4
    //   154: invokevirtual 110	java/io/File:createNewFile	()Z
    //   157: pop
    //   158: new 112	java/io/FileOutputStream
    //   161: dup
    //   162: aload 4
    //   164: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore 4
    //   169: sipush 8192
    //   172: newarray byte
    //   174: astore_3
    //   175: aload_2
    //   176: aload_3
    //   177: invokevirtual 121	java/io/InputStream:read	([B)I
    //   180: istore_1
    //   181: iload_1
    //   182: iconst_m1
    //   183: if_icmpeq +51 -> 234
    //   186: aload 4
    //   188: aload_3
    //   189: iconst_0
    //   190: iload_1
    //   191: invokevirtual 127	java/io/OutputStream:write	([BII)V
    //   194: goto -19 -> 175
    //   197: astore 5
    //   199: aload 4
    //   201: astore_3
    //   202: aload 5
    //   204: astore 4
    //   206: ldc 61
    //   208: ldc 129
    //   210: aload 4
    //   212: invokestatic 132	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 135	java/io/InputStream:close	()V
    //   223: aload_3
    //   224: ifnull -125 -> 99
    //   227: aload_3
    //   228: invokevirtual 136	java/io/OutputStream:close	()V
    //   231: return
    //   232: astore_2
    //   233: return
    //   234: ldc 61
    //   236: ldc 138
    //   238: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: invokestatic 147	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   244: invokevirtual 151	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getProxyManager	()Lcom/tencent/qqmini/sdk/launcher/core/IProxyManager;
    //   247: ifnull +192 -> 439
    //   250: invokestatic 147	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   253: invokevirtual 151	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getProxyManager	()Lcom/tencent/qqmini/sdk/launcher/core/IProxyManager;
    //   256: ldc 153
    //   258: invokeinterface 159 2 0
    //   263: checkcast 153	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy
    //   266: astore_3
    //   267: aload_3
    //   268: ifnull +176 -> 444
    //   271: aload_3
    //   272: ldc 161
    //   274: ldc 163
    //   276: invokevirtual 167	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   279: astore_3
    //   280: ldc 61
    //   282: new 63	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   289: ldc 169
    //   291: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_3
    //   295: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: ldc 171
    //   306: aload_3
    //   307: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +76 -> 386
    //   313: invokestatic 147	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   316: invokevirtual 181	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   319: astore 7
    //   321: aload_0
    //   322: getfield 21	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexPath	Ljava/lang/String;
    //   325: astore 6
    //   327: aload 5
    //   329: astore_3
    //   330: aload 7
    //   332: ifnull +12 -> 344
    //   335: aload 7
    //   337: invokevirtual 187	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   340: getfield 192	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   343: astore_3
    //   344: new 194	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader
    //   347: dup
    //   348: aload 6
    //   350: aload_3
    //   351: aload_0
    //   352: invokevirtual 198	java/lang/Object:getClass	()Ljava/lang/Class;
    //   355: invokevirtual 204	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   358: invokespecial 207	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   361: astore_3
    //   362: ldc 61
    //   364: new 63	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   371: ldc 209
    //   373: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_3
    //   377: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload_0
    //   387: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   390: aload_0
    //   391: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   394: invokestatic 218	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$000	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;)Ljava/lang/String;
    //   397: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   400: ifeq +18 -> 418
    //   403: aload_0
    //   404: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   407: aload_0
    //   408: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   411: aload_0
    //   412: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   415: invokestatic 222	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;)V
    //   418: aload_2
    //   419: ifnull +7 -> 426
    //   422: aload_2
    //   423: invokevirtual 135	java/io/InputStream:close	()V
    //   426: aload 4
    //   428: ifnull -329 -> 99
    //   431: aload 4
    //   433: invokevirtual 136	java/io/OutputStream:close	()V
    //   436: return
    //   437: astore_2
    //   438: return
    //   439: aconst_null
    //   440: astore_3
    //   441: goto -174 -> 267
    //   444: ldc 171
    //   446: astore_3
    //   447: goto -167 -> 280
    //   450: astore_3
    //   451: ldc 61
    //   453: ldc 224
    //   455: aload_3
    //   456: invokestatic 132	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -73 -> 386
    //   462: astore_3
    //   463: aload_2
    //   464: ifnull +7 -> 471
    //   467: aload_2
    //   468: invokevirtual 135	java/io/InputStream:close	()V
    //   471: aload 4
    //   473: ifnull +8 -> 481
    //   476: aload 4
    //   478: invokevirtual 136	java/io/OutputStream:close	()V
    //   481: aload_3
    //   482: athrow
    //   483: astore_2
    //   484: goto -3 -> 481
    //   487: astore_3
    //   488: aconst_null
    //   489: astore 4
    //   491: aconst_null
    //   492: astore_2
    //   493: goto -30 -> 463
    //   496: astore_3
    //   497: aconst_null
    //   498: astore 4
    //   500: goto -37 -> 463
    //   503: astore 5
    //   505: aload_3
    //   506: astore 4
    //   508: aload 5
    //   510: astore_3
    //   511: goto -48 -> 463
    //   514: astore 4
    //   516: aconst_null
    //   517: astore_2
    //   518: goto -312 -> 206
    //   521: astore 4
    //   523: goto -317 -> 206
    //   526: astore_2
    //   527: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	1
    //   43	148	1	i	int
    //   25	195	2	localObject1	Object
    //   232	191	2	localThrowable1	java.lang.Throwable
    //   437	31	2	localThrowable2	java.lang.Throwable
    //   483	1	2	localThrowable3	java.lang.Throwable
    //   492	26	2	localObject2	Object
    //   526	1	2	localThrowable4	java.lang.Throwable
    //   4	443	3	localObject3	Object
    //   450	6	3	localThrowable5	java.lang.Throwable
    //   462	20	3	localObject4	Object
    //   487	1	3	localObject5	Object
    //   496	10	3	localObject6	Object
    //   510	1	3	localObject7	Object
    //   116	391	4	localObject8	Object
    //   514	1	4	localThrowable6	java.lang.Throwable
    //   521	1	4	localThrowable7	java.lang.Throwable
    //   1	1	5	localObject9	Object
    //   197	131	5	localThrowable8	java.lang.Throwable
    //   503	6	5	localObject10	Object
    //   325	24	6	str	String
    //   319	17	7	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   169	175	197	java/lang/Throwable
    //   175	181	197	java/lang/Throwable
    //   186	194	197	java/lang/Throwable
    //   234	241	197	java/lang/Throwable
    //   386	418	197	java/lang/Throwable
    //   451	459	197	java/lang/Throwable
    //   219	223	232	java/lang/Throwable
    //   227	231	232	java/lang/Throwable
    //   422	426	437	java/lang/Throwable
    //   431	436	437	java/lang/Throwable
    //   241	267	450	java/lang/Throwable
    //   271	280	450	java/lang/Throwable
    //   280	327	450	java/lang/Throwable
    //   335	344	450	java/lang/Throwable
    //   344	386	450	java/lang/Throwable
    //   169	175	462	finally
    //   175	181	462	finally
    //   186	194	462	finally
    //   234	241	462	finally
    //   241	267	462	finally
    //   271	280	462	finally
    //   280	327	462	finally
    //   335	344	462	finally
    //   344	386	462	finally
    //   386	418	462	finally
    //   451	459	462	finally
    //   467	471	483	java/lang/Throwable
    //   476	481	483	java/lang/Throwable
    //   5	44	487	finally
    //   51	75	487	finally
    //   100	105	487	finally
    //   105	132	496	finally
    //   132	152	496	finally
    //   152	169	496	finally
    //   206	215	503	finally
    //   5	44	514	java/lang/Throwable
    //   51	75	514	java/lang/Throwable
    //   100	105	514	java/lang/Throwable
    //   105	132	521	java/lang/Throwable
    //   132	152	521	java/lang/Throwable
    //   152	169	521	java/lang/Throwable
    //   79	87	526	java/lang/Throwable
    //   91	99	526	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager.1
 * JD-Core Version:    0.7.0.1
 */