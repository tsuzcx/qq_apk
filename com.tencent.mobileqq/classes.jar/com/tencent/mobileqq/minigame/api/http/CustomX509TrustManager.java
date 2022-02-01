package com.tencent.mobileqq.minigame.api.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class CustomX509TrustManager
  implements X509TrustManager
{
  public static final String MINIGAME_TAG = "[minigame] CustomX509TrustManager";
  X509TrustManager sunJSSEX509TrustManager;
  
  /* Error */
  CustomX509TrustManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 18	java/lang/Object:<init>	()V
    //   4: ldc 20
    //   6: invokestatic 26	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   9: astore 5
    //   11: goto +52 -> 63
    //   14: astore_3
    //   15: invokestatic 31	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   18: astore 4
    //   20: new 33	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   27: astore 5
    //   29: aload 5
    //   31: ldc 36
    //   33: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: aload_3
    //   40: invokevirtual 44	java/lang/Exception:toString	()Ljava/lang/String;
    //   43: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc 10
    //   51: aload 5
    //   53: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 49	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: aconst_null
    //   61: astore 5
    //   63: iconst_0
    //   64: istore_2
    //   65: iconst_0
    //   66: anewarray 51	javax/net/ssl/TrustManager
    //   69: astore 6
    //   71: aload 5
    //   73: ifnull +366 -> 439
    //   76: new 53	java/io/FileInputStream
    //   79: dup
    //   80: ldc 55
    //   82: invokespecial 58	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   85: astore 7
    //   87: aload 6
    //   89: astore_3
    //   90: aload 7
    //   92: astore 4
    //   94: aload 5
    //   96: aload 7
    //   98: ldc 60
    //   100: invokevirtual 66	java/lang/String:toCharArray	()[C
    //   103: invokevirtual 70	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   106: aload 6
    //   108: astore_3
    //   109: aload 7
    //   111: astore 4
    //   113: ldc 72
    //   115: ldc 74
    //   117: invokestatic 79	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   120: astore 8
    //   122: aload 6
    //   124: astore_3
    //   125: aload 7
    //   127: astore 4
    //   129: aload 8
    //   131: aload 5
    //   133: invokevirtual 83	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   136: aload 6
    //   138: astore_3
    //   139: aload 7
    //   141: astore 4
    //   143: aload 8
    //   145: invokevirtual 87	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   148: astore 5
    //   150: aload 5
    //   152: astore_3
    //   153: aload 7
    //   155: astore 4
    //   157: aload 7
    //   159: invokevirtual 90	java/io/FileInputStream:close	()V
    //   162: aload 7
    //   164: invokevirtual 90	java/io/FileInputStream:close	()V
    //   167: iload_2
    //   168: istore_1
    //   169: aload 5
    //   171: astore 4
    //   173: goto +289 -> 462
    //   176: astore 4
    //   178: invokestatic 31	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   181: astore 7
    //   183: new 33	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   190: astore 6
    //   192: aload 5
    //   194: astore_3
    //   195: aload 7
    //   197: astore 5
    //   199: aload 6
    //   201: ldc 92
    //   203: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 6
    //   209: aload 4
    //   211: invokevirtual 44	java/lang/Exception:toString	()Ljava/lang/String;
    //   214: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 5
    //   220: ldc 10
    //   222: aload 6
    //   224: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 49	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: iload_2
    //   232: istore_1
    //   233: aload_3
    //   234: astore 4
    //   236: goto +226 -> 462
    //   239: astore 6
    //   241: aload 7
    //   243: astore 5
    //   245: goto +22 -> 267
    //   248: astore_3
    //   249: aconst_null
    //   250: astore 4
    //   252: goto +124 -> 376
    //   255: astore 4
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 6
    //   262: astore_3
    //   263: aload 4
    //   265: astore 6
    //   267: aload 5
    //   269: astore 4
    //   271: invokestatic 31	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   274: astore 7
    //   276: aload 5
    //   278: astore 4
    //   280: new 33	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   287: astore 8
    //   289: aload 5
    //   291: astore 4
    //   293: aload 8
    //   295: ldc 94
    //   297: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 5
    //   303: astore 4
    //   305: aload 8
    //   307: aload 6
    //   309: invokevirtual 44	java/lang/Exception:toString	()Ljava/lang/String;
    //   312: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 5
    //   318: astore 4
    //   320: aload 7
    //   322: ldc 10
    //   324: aload 8
    //   326: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokevirtual 49	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   332: pop
    //   333: iload_2
    //   334: istore_1
    //   335: aload_3
    //   336: astore 4
    //   338: aload 5
    //   340: ifnull +122 -> 462
    //   343: aload 5
    //   345: invokevirtual 90	java/io/FileInputStream:close	()V
    //   348: iload_2
    //   349: istore_1
    //   350: aload_3
    //   351: astore 4
    //   353: goto +109 -> 462
    //   356: astore 4
    //   358: invokestatic 31	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   361: astore 5
    //   363: new 33	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   370: astore 6
    //   372: goto -173 -> 199
    //   375: astore_3
    //   376: aload 4
    //   378: ifnull +59 -> 437
    //   381: aload 4
    //   383: invokevirtual 90	java/io/FileInputStream:close	()V
    //   386: goto +51 -> 437
    //   389: astore 4
    //   391: invokestatic 31	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   394: astore 5
    //   396: new 33	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   403: astore 6
    //   405: aload 6
    //   407: ldc 92
    //   409: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 6
    //   415: aload 4
    //   417: invokevirtual 44	java/lang/Exception:toString	()Ljava/lang/String;
    //   420: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 5
    //   426: ldc 10
    //   428: aload 6
    //   430: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokevirtual 49	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   436: pop
    //   437: aload_3
    //   438: athrow
    //   439: invokestatic 97	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   442: invokestatic 100	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   445: astore_3
    //   446: aload_3
    //   447: aconst_null
    //   448: checkcast 22	java/security/KeyStore
    //   451: invokevirtual 83	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   454: aload_3
    //   455: invokevirtual 87	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   458: astore 4
    //   460: iload_2
    //   461: istore_1
    //   462: iload_1
    //   463: aload 4
    //   465: arraylength
    //   466: if_icmpge +32 -> 498
    //   469: aload 4
    //   471: iload_1
    //   472: aaload
    //   473: instanceof 6
    //   476: ifeq +15 -> 491
    //   479: aload_0
    //   480: aload 4
    //   482: iload_1
    //   483: aaload
    //   484: checkcast 6	javax/net/ssl/X509TrustManager
    //   487: putfield 102	com/tencent/mobileqq/minigame/api/http/CustomX509TrustManager:sunJSSEX509TrustManager	Ljavax/net/ssl/X509TrustManager;
    //   490: return
    //   491: iload_1
    //   492: iconst_1
    //   493: iadd
    //   494: istore_1
    //   495: goto -33 -> 462
    //   498: new 16	java/lang/Exception
    //   501: dup
    //   502: ldc 104
    //   504: invokespecial 105	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   507: astore_3
    //   508: goto +5 -> 513
    //   511: aload_3
    //   512: athrow
    //   513: goto -2 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	CustomX509TrustManager
    //   168	327	1	i	int
    //   64	397	2	j	int
    //   14	26	3	localException1	java.lang.Exception
    //   89	145	3	localObject1	Object
    //   248	1	3	localObject2	Object
    //   262	89	3	localObject3	Object
    //   375	63	3	localObject4	Object
    //   445	67	3	localObject5	Object
    //   18	154	4	localObject6	Object
    //   176	34	4	localException2	java.lang.Exception
    //   234	17	4	localObject7	Object
    //   255	9	4	localException3	java.lang.Exception
    //   269	83	4	localObject8	Object
    //   356	26	4	localException4	java.lang.Exception
    //   389	27	4	localException5	java.lang.Exception
    //   458	23	4	arrayOfTrustManager	javax.net.ssl.TrustManager[]
    //   9	416	5	localObject9	Object
    //   69	154	6	localObject10	Object
    //   239	22	6	localException6	java.lang.Exception
    //   265	164	6	localObject11	Object
    //   85	236	7	localObject12	Object
    //   120	205	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	14	java/lang/Exception
    //   162	167	176	java/lang/Exception
    //   94	106	239	java/lang/Exception
    //   113	122	239	java/lang/Exception
    //   129	136	239	java/lang/Exception
    //   143	150	239	java/lang/Exception
    //   157	162	239	java/lang/Exception
    //   76	87	248	finally
    //   76	87	255	java/lang/Exception
    //   343	348	356	java/lang/Exception
    //   94	106	375	finally
    //   113	122	375	finally
    //   129	136	375	finally
    //   143	150	375	finally
    //   157	162	375	finally
    //   271	276	375	finally
    //   280	289	375	finally
    //   293	301	375	finally
    //   305	316	375	finally
    //   320	333	375	finally
    //   381	386	389	java/lang/Exception
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.sunJSSEX509TrustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.sunJSSEX509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.sunJSSEX509TrustManager.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.http.CustomX509TrustManager
 * JD-Core Version:    0.7.0.1
 */