package com.tencent.mobileqq.microapp.b;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class a$a
  implements X509TrustManager
{
  X509TrustManager a;
  
  /* Error */
  a$a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 14	java/lang/Object:<init>	()V
    //   4: ldc 16
    //   6: invokestatic 22	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   9: astore 5
    //   11: iconst_0
    //   12: anewarray 24	javax/net/ssl/TrustManager
    //   15: astore_2
    //   16: aload 5
    //   18: ifnull +222 -> 240
    //   21: new 26	java/io/FileInputStream
    //   24: dup
    //   25: ldc 28
    //   27: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 5
    //   37: aload 4
    //   39: ldc 33
    //   41: invokevirtual 39	java/lang/String:toCharArray	()[C
    //   44: invokevirtual 43	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   47: aload 4
    //   49: astore_3
    //   50: ldc 45
    //   52: ldc 47
    //   54: invokestatic 52	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   57: astore 6
    //   59: aload 4
    //   61: astore_3
    //   62: aload 6
    //   64: aload 5
    //   66: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   69: aload 4
    //   71: astore_3
    //   72: aload 6
    //   74: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   77: astore 5
    //   79: aload 5
    //   81: astore_2
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 63	java/io/FileInputStream:close	()V
    //   90: aload_2
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokevirtual 63	java/io/FileInputStream:close	()V
    //   102: aload_2
    //   103: astore_3
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: aload_3
    //   108: arraylength
    //   109: if_icmpge +161 -> 270
    //   112: aload_3
    //   113: iload_1
    //   114: aaload
    //   115: instanceof 6
    //   118: ifeq +145 -> 263
    //   121: aload_0
    //   122: aload_3
    //   123: iload_1
    //   124: aaload
    //   125: checkcast 6	javax/net/ssl/X509TrustManager
    //   128: putfield 65	com/tencent/mobileqq/microapp/b/a$a:a	Ljavax/net/ssl/X509TrustManager;
    //   131: return
    //   132: astore_2
    //   133: ldc 67
    //   135: iconst_1
    //   136: new 69	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: ldc 72
    //   145: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aconst_null
    //   162: astore 5
    //   164: goto -153 -> 11
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 4
    //   174: astore_3
    //   175: ldc 67
    //   177: iconst_1
    //   178: new 69	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   185: ldc 89
    //   187: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 5
    //   192: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_2
    //   205: astore_3
    //   206: aload 4
    //   208: ifnull -104 -> 104
    //   211: aload 4
    //   213: invokevirtual 63	java/io/FileInputStream:close	()V
    //   216: aload_2
    //   217: astore_3
    //   218: goto -114 -> 104
    //   221: astore_3
    //   222: aload_2
    //   223: astore_3
    //   224: goto -120 -> 104
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 63	java/io/FileInputStream:close	()V
    //   238: aload_2
    //   239: athrow
    //   240: invokestatic 92	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   243: invokestatic 95	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   246: astore_2
    //   247: aload_2
    //   248: aconst_null
    //   249: checkcast 18	java/security/KeyStore
    //   252: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   255: aload_2
    //   256: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   259: astore_3
    //   260: goto -156 -> 104
    //   263: iload_1
    //   264: iconst_1
    //   265: iadd
    //   266: istore_1
    //   267: goto -161 -> 106
    //   270: new 12	java/lang/Exception
    //   273: dup
    //   274: ldc 97
    //   276: invokespecial 98	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   279: athrow
    //   280: astore_3
    //   281: aload_2
    //   282: astore_3
    //   283: goto -179 -> 104
    //   286: astore_3
    //   287: goto -49 -> 238
    //   290: astore_2
    //   291: goto -61 -> 230
    //   294: astore 5
    //   296: goto -124 -> 172
    //   299: astore 5
    //   301: goto -129 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	a
    //   105	162	1	i	int
    //   15	88	2	localObject1	Object
    //   132	91	2	localException1	java.lang.Exception
    //   227	12	2	localObject2	Object
    //   246	36	2	localTrustManagerFactory1	javax.net.ssl.TrustManagerFactory
    //   290	1	2	localObject3	Object
    //   34	184	3	localObject4	Object
    //   221	1	3	localException2	java.lang.Exception
    //   223	37	3	localObject5	Object
    //   280	1	3	localException3	java.lang.Exception
    //   282	1	3	localTrustManagerFactory2	javax.net.ssl.TrustManagerFactory
    //   286	1	3	localException4	java.lang.Exception
    //   30	182	4	localFileInputStream	java.io.FileInputStream
    //   9	154	5	localObject6	Object
    //   167	24	5	localException5	java.lang.Exception
    //   294	1	5	localException6	java.lang.Exception
    //   299	1	5	localException7	java.lang.Exception
    //   57	16	6	localTrustManagerFactory3	javax.net.ssl.TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   4	11	132	java/lang/Exception
    //   21	32	167	java/lang/Exception
    //   211	216	221	java/lang/Exception
    //   21	32	227	finally
    //   97	102	280	java/lang/Exception
    //   234	238	286	java/lang/Exception
    //   35	47	290	finally
    //   50	59	290	finally
    //   62	69	290	finally
    //   72	79	290	finally
    //   85	90	290	finally
    //   175	204	290	finally
    //   35	47	294	java/lang/Exception
    //   50	59	294	java/lang/Exception
    //   62	69	294	java/lang/Exception
    //   72	79	294	java/lang/Exception
    //   85	90	299	java/lang/Exception
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.a.a
 * JD-Core Version:    0.7.0.1
 */