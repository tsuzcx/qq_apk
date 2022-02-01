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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 32	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   14: getfield 37	com/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig:dexUrl	Ljava/lang/String;
    //   17: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 46	java/net/HttpURLConnection
    //   26: astore_2
    //   27: aload_2
    //   28: sipush 10000
    //   31: invokevirtual 50	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   34: aload_2
    //   35: ldc 52
    //   37: invokevirtual 55	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokevirtual 59	java/net/HttpURLConnection:getResponseCode	()I
    //   44: istore_1
    //   45: iload_1
    //   46: sipush 200
    //   49: if_icmpeq +34 -> 83
    //   52: new 61	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc 64
    //   63: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_2
    //   68: iload_1
    //   69: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 73
    //   75: aload_2
    //   76: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 83	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: return
    //   83: aload_2
    //   84: invokevirtual 87	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   87: astore_3
    //   88: new 89	java/io/File
    //   91: dup
    //   92: aload_0
    //   93: getfield 21	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexPath	Ljava/lang/String;
    //   96: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore_2
    //   100: aload_2
    //   101: invokevirtual 94	java/io/File:exists	()Z
    //   104: ifeq +8 -> 112
    //   107: aload_2
    //   108: invokevirtual 97	java/io/File:delete	()Z
    //   111: pop
    //   112: aload_2
    //   113: invokevirtual 101	java/io/File:getParentFile	()Ljava/io/File;
    //   116: invokevirtual 94	java/io/File:exists	()Z
    //   119: ifne +11 -> 130
    //   122: aload_2
    //   123: invokevirtual 101	java/io/File:getParentFile	()Ljava/io/File;
    //   126: invokevirtual 104	java/io/File:mkdirs	()Z
    //   129: pop
    //   130: aload_2
    //   131: invokevirtual 107	java/io/File:createNewFile	()Z
    //   134: pop
    //   135: new 109	java/io/FileOutputStream
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 112	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore 4
    //   145: sipush 8192
    //   148: newarray byte
    //   150: astore_2
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual 118	java/io/InputStream:read	([B)I
    //   156: istore_1
    //   157: iload_1
    //   158: iconst_m1
    //   159: if_icmpeq +14 -> 173
    //   162: aload 4
    //   164: aload_2
    //   165: iconst_0
    //   166: iload_1
    //   167: invokevirtual 124	java/io/OutputStream:write	([BII)V
    //   170: goto -19 -> 151
    //   173: ldc 73
    //   175: ldc 126
    //   177: invokestatic 129	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 135	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   183: invokevirtual 139	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getProxyManager	()Lcom/tencent/qqmini/sdk/launcher/core/IProxyManager;
    //   186: ifnull +23 -> 209
    //   189: invokestatic 135	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   192: invokevirtual 139	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getProxyManager	()Lcom/tencent/qqmini/sdk/launcher/core/IProxyManager;
    //   195: ldc 141
    //   197: invokeinterface 147 2 0
    //   202: checkcast 141	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy
    //   205: astore_2
    //   206: goto +5 -> 211
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +326 -> 538
    //   215: aload_2
    //   216: ldc 149
    //   218: ldc 151
    //   220: invokevirtual 155	com/tencent/qqmini/sdk/launcher/core/proxy/WnsConfigProxy:getConfig	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_2
    //   224: goto +3 -> 227
    //   227: new 61	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   234: astore 6
    //   236: aload 6
    //   238: ldc 157
    //   240: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 6
    //   246: aload_2
    //   247: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 73
    //   253: aload 6
    //   255: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 129	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: ldc 159
    //   263: aload_2
    //   264: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq +98 -> 365
    //   270: invokestatic 135	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   273: invokevirtual 169	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   276: astore 7
    //   278: aload_0
    //   279: getfield 21	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexPath	Ljava/lang/String;
    //   282: astore 6
    //   284: aload 5
    //   286: astore_2
    //   287: aload 7
    //   289: ifnull +12 -> 301
    //   292: aload 7
    //   294: invokevirtual 175	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   297: getfield 180	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   300: astore_2
    //   301: new 182	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader
    //   304: dup
    //   305: aload 6
    //   307: aload_2
    //   308: aload_0
    //   309: invokevirtual 186	java/lang/Object:getClass	()Ljava/lang/Class;
    //   312: invokevirtual 192	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   315: invokespecial 195	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   318: astore_2
    //   319: new 61	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   326: astore 5
    //   328: aload 5
    //   330: ldc 197
    //   332: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 5
    //   338: aload_2
    //   339: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: ldc 73
    //   345: aload 5
    //   347: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 129	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: goto +12 -> 365
    //   356: astore_2
    //   357: ldc 73
    //   359: ldc 202
    //   361: aload_2
    //   362: invokestatic 205	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload_0
    //   366: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   369: aload_0
    //   370: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   373: invokestatic 211	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$000	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;)Ljava/lang/String;
    //   376: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   379: ifeq +18 -> 397
    //   382: aload_0
    //   383: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   386: aload_0
    //   387: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   390: aload_0
    //   391: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   394: invokestatic 215	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;)V
    //   397: aload 4
    //   399: astore_2
    //   400: aload_3
    //   401: ifnull +10 -> 411
    //   404: aload_3
    //   405: invokevirtual 218	java/io/InputStream:close	()V
    //   408: aload 4
    //   410: astore_2
    //   411: aload_2
    //   412: invokevirtual 219	java/io/OutputStream:close	()V
    //   415: return
    //   416: astore_2
    //   417: aload_3
    //   418: astore 5
    //   420: aload 4
    //   422: astore_3
    //   423: goto +83 -> 506
    //   426: astore 5
    //   428: aload 4
    //   430: astore_2
    //   431: goto +40 -> 471
    //   434: astore_2
    //   435: aconst_null
    //   436: astore 4
    //   438: aload_3
    //   439: astore 5
    //   441: aload 4
    //   443: astore_3
    //   444: goto +62 -> 506
    //   447: astore 5
    //   449: aconst_null
    //   450: astore_2
    //   451: goto +20 -> 471
    //   454: astore_2
    //   455: aconst_null
    //   456: astore 5
    //   458: aload 5
    //   460: astore_3
    //   461: goto +45 -> 506
    //   464: astore 5
    //   466: aconst_null
    //   467: astore_2
    //   468: aload 4
    //   470: astore_3
    //   471: ldc 73
    //   473: ldc 221
    //   475: aload 5
    //   477: invokestatic 205	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 218	java/io/InputStream:close	()V
    //   488: aload_2
    //   489: ifnull +6 -> 495
    //   492: goto -81 -> 411
    //   495: return
    //   496: astore 4
    //   498: aload_3
    //   499: astore 5
    //   501: aload_2
    //   502: astore_3
    //   503: aload 4
    //   505: astore_2
    //   506: aload 5
    //   508: ifnull +8 -> 516
    //   511: aload 5
    //   513: invokevirtual 218	java/io/InputStream:close	()V
    //   516: aload_3
    //   517: ifnull +7 -> 524
    //   520: aload_3
    //   521: invokevirtual 219	java/io/OutputStream:close	()V
    //   524: goto +5 -> 529
    //   527: aload_2
    //   528: athrow
    //   529: goto -2 -> 527
    //   532: astore_2
    //   533: return
    //   534: astore_3
    //   535: goto -11 -> 524
    //   538: ldc 159
    //   540: astore_2
    //   541: goto -314 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	1
    //   44	123	1	i	int
    //   26	313	2	localObject1	Object
    //   356	6	2	localThrowable1	java.lang.Throwable
    //   399	13	2	localFileOutputStream1	java.io.FileOutputStream
    //   416	1	2	localObject2	Object
    //   430	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   434	1	2	localObject3	Object
    //   450	1	2	localObject4	Object
    //   454	1	2	localObject5	Object
    //   467	61	2	localObject6	Object
    //   532	1	2	localThrowable2	java.lang.Throwable
    //   540	1	2	str	String
    //   87	434	3	localObject7	Object
    //   534	1	3	localThrowable3	java.lang.Throwable
    //   1	468	4	localFileOutputStream3	java.io.FileOutputStream
    //   496	8	4	localObject8	Object
    //   4	415	5	localObject9	Object
    //   426	1	5	localThrowable4	java.lang.Throwable
    //   439	1	5	localObject10	Object
    //   447	1	5	localThrowable5	java.lang.Throwable
    //   456	3	5	localObject11	Object
    //   464	12	5	localThrowable6	java.lang.Throwable
    //   499	13	5	localObject12	Object
    //   234	72	6	localObject13	Object
    //   276	17	7	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   180	206	356	java/lang/Throwable
    //   215	224	356	java/lang/Throwable
    //   227	284	356	java/lang/Throwable
    //   292	301	356	java/lang/Throwable
    //   301	353	356	java/lang/Throwable
    //   145	151	416	finally
    //   151	157	416	finally
    //   162	170	416	finally
    //   173	180	416	finally
    //   180	206	416	finally
    //   215	224	416	finally
    //   227	284	416	finally
    //   292	301	416	finally
    //   301	353	416	finally
    //   357	365	416	finally
    //   365	397	416	finally
    //   145	151	426	java/lang/Throwable
    //   151	157	426	java/lang/Throwable
    //   162	170	426	java/lang/Throwable
    //   173	180	426	java/lang/Throwable
    //   357	365	426	java/lang/Throwable
    //   365	397	426	java/lang/Throwable
    //   88	112	434	finally
    //   112	130	434	finally
    //   130	145	434	finally
    //   88	112	447	java/lang/Throwable
    //   112	130	447	java/lang/Throwable
    //   130	145	447	java/lang/Throwable
    //   6	45	454	finally
    //   52	82	454	finally
    //   83	88	454	finally
    //   6	45	464	java/lang/Throwable
    //   52	82	464	java/lang/Throwable
    //   83	88	464	java/lang/Throwable
    //   471	480	496	finally
    //   404	408	532	java/lang/Throwable
    //   411	415	532	java/lang/Throwable
    //   484	488	532	java/lang/Throwable
    //   511	516	534	java/lang/Throwable
    //   520	524	534	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager.1
 * JD-Core Version:    0.7.0.1
 */