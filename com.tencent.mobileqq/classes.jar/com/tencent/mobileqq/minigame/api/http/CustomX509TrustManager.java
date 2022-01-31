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
    //   11: iconst_0
    //   12: anewarray 28	javax/net/ssl/TrustManager
    //   15: astore_2
    //   16: aload 5
    //   18: ifnull +331 -> 349
    //   21: new 30	java/io/FileInputStream
    //   24: dup
    //   25: ldc 32
    //   27: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 5
    //   37: aload 4
    //   39: ldc 37
    //   41: invokevirtual 43	java/lang/String:toCharArray	()[C
    //   44: invokevirtual 47	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   47: aload 4
    //   49: astore_3
    //   50: ldc 49
    //   52: ldc 51
    //   54: invokestatic 56	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   57: astore 6
    //   59: aload 4
    //   61: astore_3
    //   62: aload 6
    //   64: aload 5
    //   66: invokevirtual 60	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 64	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   77: astore 5
    //   79: aload 5
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 67	java/io/FileInputStream:close	()V
    //   90: aload_2
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokevirtual 67	java/io/FileInputStream:close	()V
    //   102: aload_2
    //   103: astore_3
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: aload_3
    //   108: arraylength
    //   109: if_icmpge +270 -> 379
    //   112: aload_3
    //   113: iload_1
    //   114: aaload
    //   115: instanceof 6
    //   118: ifeq +254 -> 372
    //   121: aload_0
    //   122: aload_3
    //   123: iload_1
    //   124: aaload
    //   125: checkcast 6	javax/net/ssl/X509TrustManager
    //   128: putfield 69	com/tencent/mobileqq/minigame/api/http/CustomX509TrustManager:sunJSSEX509TrustManager	Ljavax/net/ssl/X509TrustManager;
    //   131: return
    //   132: astore_2
    //   133: invokestatic 74	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   136: ldc 10
    //   138: new 76	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   145: ldc 79
    //   147: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 92	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: aconst_null
    //   165: astore 5
    //   167: goto -156 -> 11
    //   170: astore_3
    //   171: invokestatic 74	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   174: ldc 10
    //   176: new 76	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   183: ldc 94
    //   185: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   192: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 92	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   201: pop
    //   202: aload_2
    //   203: astore_3
    //   204: goto -100 -> 104
    //   207: astore 5
    //   209: aconst_null
    //   210: astore 4
    //   212: aload 4
    //   214: astore_3
    //   215: invokestatic 74	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   218: ldc 10
    //   220: new 76	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   227: ldc 96
    //   229: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 5
    //   234: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokevirtual 92	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload_2
    //   248: astore_3
    //   249: aload 4
    //   251: ifnull -147 -> 104
    //   254: aload 4
    //   256: invokevirtual 67	java/io/FileInputStream:close	()V
    //   259: aload_2
    //   260: astore_3
    //   261: goto -157 -> 104
    //   264: astore_3
    //   265: invokestatic 74	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   268: ldc 10
    //   270: new 76	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   277: ldc 94
    //   279: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_3
    //   283: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   286: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 92	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   295: pop
    //   296: aload_2
    //   297: astore_3
    //   298: goto -194 -> 104
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_3
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 67	java/io/FileInputStream:close	()V
    //   312: aload_2
    //   313: athrow
    //   314: astore_3
    //   315: invokestatic 74	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   318: ldc 10
    //   320: new 76	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   327: ldc 94
    //   329: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_3
    //   333: invokevirtual 87	java/lang/Exception:toString	()Ljava/lang/String;
    //   336: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokevirtual 92	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   345: pop
    //   346: goto -34 -> 312
    //   349: invokestatic 99	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   352: invokestatic 102	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   355: astore_2
    //   356: aload_2
    //   357: aconst_null
    //   358: checkcast 22	java/security/KeyStore
    //   361: invokevirtual 60	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   364: aload_2
    //   365: invokevirtual 64	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   368: astore_3
    //   369: goto -265 -> 104
    //   372: iload_1
    //   373: iconst_1
    //   374: iadd
    //   375: istore_1
    //   376: goto -270 -> 106
    //   379: new 16	java/lang/Exception
    //   382: dup
    //   383: ldc 104
    //   385: invokespecial 105	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   388: athrow
    //   389: astore_2
    //   390: goto -86 -> 304
    //   393: astore 5
    //   395: goto -183 -> 212
    //   398: astore 5
    //   400: goto -188 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	CustomX509TrustManager
    //   105	271	1	i	int
    //   15	88	2	localObject1	Object
    //   132	165	2	localException1	java.lang.Exception
    //   301	12	2	localObject2	Object
    //   355	10	2	localTrustManagerFactory1	javax.net.ssl.TrustManagerFactory
    //   389	1	2	localObject3	Object
    //   34	89	3	localObject4	Object
    //   170	19	3	localException2	java.lang.Exception
    //   203	58	3	localObject5	Object
    //   264	19	3	localException3	java.lang.Exception
    //   297	12	3	localException4	java.lang.Exception
    //   314	19	3	localException5	java.lang.Exception
    //   368	1	3	arrayOfTrustManager	javax.net.ssl.TrustManager[]
    //   30	225	4	localFileInputStream	java.io.FileInputStream
    //   9	157	5	localObject6	Object
    //   207	26	5	localException6	java.lang.Exception
    //   393	1	5	localException7	java.lang.Exception
    //   398	1	5	localException8	java.lang.Exception
    //   57	16	6	localTrustManagerFactory2	javax.net.ssl.TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   4	11	132	java/lang/Exception
    //   97	102	170	java/lang/Exception
    //   21	32	207	java/lang/Exception
    //   254	259	264	java/lang/Exception
    //   21	32	301	finally
    //   308	312	314	java/lang/Exception
    //   35	47	389	finally
    //   50	59	389	finally
    //   62	69	389	finally
    //   72	79	389	finally
    //   85	90	389	finally
    //   215	247	389	finally
    //   35	47	393	java/lang/Exception
    //   50	59	393	java/lang/Exception
    //   62	69	393	java/lang/Exception
    //   72	79	393	java/lang/Exception
    //   85	90	398	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.http.CustomX509TrustManager
 * JD-Core Version:    0.7.0.1
 */