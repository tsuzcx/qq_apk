package com.tencent.mobileqq.teamwork;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class CustomX509TrustManager
  implements X509TrustManager
{
  X509TrustManager a;
  
  /* Error */
  public CustomX509TrustManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 14	java/lang/Object:<init>	()V
    //   4: ldc 16
    //   6: invokestatic 22	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   9: astore 7
    //   11: goto +45 -> 56
    //   14: astore_3
    //   15: new 24	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   22: astore 4
    //   24: aload 4
    //   26: ldc 27
    //   28: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload_3
    //   35: invokevirtual 35	java/lang/Exception:toString	()Ljava/lang/String;
    //   38: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 37
    //   44: iconst_1
    //   45: aload 4
    //   47: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aconst_null
    //   54: astore 7
    //   56: iconst_0
    //   57: istore_2
    //   58: iconst_0
    //   59: anewarray 46	javax/net/ssl/TrustManager
    //   62: astore 6
    //   64: aload 7
    //   66: ifnull +204 -> 270
    //   69: new 48	java/io/FileInputStream
    //   72: dup
    //   73: ldc 50
    //   75: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: aload_3
    //   84: astore 5
    //   86: aload 7
    //   88: aload_3
    //   89: ldc 55
    //   91: invokevirtual 61	java/lang/String:toCharArray	()[C
    //   94: invokevirtual 65	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   97: aload 6
    //   99: astore 4
    //   101: aload_3
    //   102: astore 5
    //   104: ldc 67
    //   106: ldc 69
    //   108: invokestatic 74	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   111: astore 8
    //   113: aload 6
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: aload 8
    //   122: aload 7
    //   124: invokevirtual 78	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   127: aload 6
    //   129: astore 4
    //   131: aload_3
    //   132: astore 5
    //   134: aload 8
    //   136: invokevirtual 82	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   139: astore 6
    //   141: aload 6
    //   143: astore 4
    //   145: aload_3
    //   146: astore 5
    //   148: aload_3
    //   149: invokevirtual 85	java/io/FileInputStream:close	()V
    //   152: aload 6
    //   154: astore 4
    //   156: aload_3
    //   157: invokevirtual 85	java/io/FileInputStream:close	()V
    //   160: iload_2
    //   161: istore_1
    //   162: aload 4
    //   164: astore 5
    //   166: goto +127 -> 293
    //   169: astore 6
    //   171: goto +22 -> 193
    //   174: astore_3
    //   175: aconst_null
    //   176: astore 5
    //   178: goto +80 -> 258
    //   181: astore 5
    //   183: aconst_null
    //   184: astore_3
    //   185: aload 6
    //   187: astore 4
    //   189: aload 5
    //   191: astore 6
    //   193: aload_3
    //   194: astore 5
    //   196: new 24	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   203: astore 7
    //   205: aload_3
    //   206: astore 5
    //   208: aload 7
    //   210: ldc 87
    //   212: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_3
    //   217: astore 5
    //   219: aload 7
    //   221: aload 6
    //   223: invokevirtual 35	java/lang/Exception:toString	()Ljava/lang/String;
    //   226: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_3
    //   231: astore 5
    //   233: ldc 37
    //   235: iconst_1
    //   236: aload 7
    //   238: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iload_2
    //   245: istore_1
    //   246: aload 4
    //   248: astore 5
    //   250: aload_3
    //   251: ifnull +42 -> 293
    //   254: goto -98 -> 156
    //   257: astore_3
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 85	java/io/FileInputStream:close	()V
    //   268: aload_3
    //   269: athrow
    //   270: invokestatic 90	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   273: invokestatic 93	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   276: astore_3
    //   277: aload_3
    //   278: aconst_null
    //   279: checkcast 18	java/security/KeyStore
    //   282: invokevirtual 78	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   285: aload_3
    //   286: invokevirtual 82	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   289: astore 5
    //   291: iload_2
    //   292: istore_1
    //   293: iload_1
    //   294: aload 5
    //   296: arraylength
    //   297: if_icmpge +32 -> 329
    //   300: aload 5
    //   302: iload_1
    //   303: aaload
    //   304: instanceof 6
    //   307: ifeq +15 -> 322
    //   310: aload_0
    //   311: aload 5
    //   313: iload_1
    //   314: aaload
    //   315: checkcast 6	javax/net/ssl/X509TrustManager
    //   318: putfield 95	com/tencent/mobileqq/teamwork/CustomX509TrustManager:a	Ljavax/net/ssl/X509TrustManager;
    //   321: return
    //   322: iload_1
    //   323: iconst_1
    //   324: iadd
    //   325: istore_1
    //   326: goto -33 -> 293
    //   329: new 12	java/lang/Exception
    //   332: dup
    //   333: ldc 97
    //   335: invokespecial 98	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   338: astore_3
    //   339: goto +5 -> 344
    //   342: aload_3
    //   343: athrow
    //   344: goto -2 -> 342
    //   347: astore_3
    //   348: iload_2
    //   349: istore_1
    //   350: aload 4
    //   352: astore 5
    //   354: goto -61 -> 293
    //   357: astore 4
    //   359: goto -91 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	CustomX509TrustManager
    //   161	189	1	i	int
    //   57	292	2	j	int
    //   14	21	3	localException1	java.lang.Exception
    //   78	79	3	localFileInputStream	java.io.FileInputStream
    //   174	1	3	localObject1	Object
    //   184	67	3	localObject2	Object
    //   257	12	3	localObject3	Object
    //   276	67	3	localObject4	Object
    //   347	1	3	localException2	java.lang.Exception
    //   22	329	4	localObject5	Object
    //   357	1	4	localException3	java.lang.Exception
    //   84	93	5	localObject6	Object
    //   181	9	5	localException4	java.lang.Exception
    //   194	159	5	localObject7	Object
    //   62	91	6	arrayOfTrustManager	javax.net.ssl.TrustManager[]
    //   169	17	6	localException5	java.lang.Exception
    //   191	31	6	localObject8	Object
    //   9	228	7	localObject9	Object
    //   111	24	8	localTrustManagerFactory	javax.net.ssl.TrustManagerFactory
    // Exception table:
    //   from	to	target	type
    //   4	11	14	java/lang/Exception
    //   86	97	169	java/lang/Exception
    //   104	113	169	java/lang/Exception
    //   120	127	169	java/lang/Exception
    //   134	141	169	java/lang/Exception
    //   148	152	169	java/lang/Exception
    //   69	79	174	finally
    //   69	79	181	java/lang/Exception
    //   86	97	257	finally
    //   104	113	257	finally
    //   120	127	257	finally
    //   134	141	257	finally
    //   148	152	257	finally
    //   196	205	257	finally
    //   208	216	257	finally
    //   219	230	257	finally
    //   233	244	257	finally
    //   156	160	347	java/lang/Exception
    //   263	268	357	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.CustomX509TrustManager
 * JD-Core Version:    0.7.0.1
 */