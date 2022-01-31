package com.tencent.mobileqq.teamwork;

public class TeamWorkHttpUtils
{
  /* Error */
  public static final java.lang.String a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 15	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 22	java/io/File:exists	()Z
    //   18: ifeq +113 -> 131
    //   21: ldc 24
    //   23: invokestatic 30	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore 5
    //   28: new 32	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: astore_0
    //   41: sipush 1024
    //   44: newarray byte
    //   46: astore 7
    //   48: aload 4
    //   50: astore_0
    //   51: aload 4
    //   53: aload 7
    //   55: invokevirtual 37	java/io/FileInputStream:read	([B)I
    //   58: istore_1
    //   59: iload_1
    //   60: iconst_m1
    //   61: if_icmpeq +73 -> 134
    //   64: aload 4
    //   66: astore_0
    //   67: aload 5
    //   69: aload 7
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 41	java/security/MessageDigest:update	([BII)V
    //   76: goto -28 -> 48
    //   79: astore 5
    //   81: aload 4
    //   83: astore_0
    //   84: ldc 43
    //   86: iconst_1
    //   87: new 45	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   94: ldc 48
    //   96: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 5
    //   101: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 6
    //   115: astore 5
    //   117: aload 4
    //   119: ifnull +12 -> 131
    //   122: aload 4
    //   124: invokevirtual 66	java/io/FileInputStream:close	()V
    //   127: aload 6
    //   129: astore 5
    //   131: aload 5
    //   133: areturn
    //   134: aload 4
    //   136: astore_0
    //   137: aload 4
    //   139: invokevirtual 66	java/io/FileInputStream:close	()V
    //   142: aload 4
    //   144: astore_0
    //   145: new 45	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   152: astore 7
    //   154: aload 4
    //   156: astore_0
    //   157: aload 5
    //   159: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   162: astore 8
    //   164: aload 4
    //   166: astore_0
    //   167: aload 8
    //   169: arraylength
    //   170: istore_2
    //   171: iconst_0
    //   172: istore_1
    //   173: goto +189 -> 362
    //   176: aload 4
    //   178: astore_0
    //   179: aload 7
    //   181: aload 5
    //   183: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 4
    //   189: astore_0
    //   190: aload 7
    //   192: iload_3
    //   193: invokestatic 76	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   196: invokevirtual 81	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   199: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: iload_1
    //   204: iconst_1
    //   205: iadd
    //   206: istore_1
    //   207: goto +155 -> 362
    //   210: aload 4
    //   212: astore_0
    //   213: aload 7
    //   215: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore 5
    //   220: aload 5
    //   222: astore_0
    //   223: aload_0
    //   224: astore 5
    //   226: aload 4
    //   228: ifnull -97 -> 131
    //   231: aload 4
    //   233: invokevirtual 66	java/io/FileInputStream:close	()V
    //   236: aload_0
    //   237: areturn
    //   238: astore 4
    //   240: ldc 43
    //   242: iconst_1
    //   243: new 45	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   250: ldc 83
    //   252: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 4
    //   257: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   260: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_0
    //   270: areturn
    //   271: astore_0
    //   272: ldc 43
    //   274: iconst_1
    //   275: new 45	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   282: ldc 83
    //   284: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   291: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aconst_null
    //   301: areturn
    //   302: astore 4
    //   304: aconst_null
    //   305: astore_0
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 66	java/io/FileInputStream:close	()V
    //   314: aload 4
    //   316: athrow
    //   317: astore_0
    //   318: ldc 43
    //   320: iconst_1
    //   321: new 45	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   328: ldc 83
    //   330: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   337: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: goto -32 -> 314
    //   349: astore 4
    //   351: goto -45 -> 306
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 4
    //   359: goto -278 -> 81
    //   362: iload_1
    //   363: iload_2
    //   364: if_icmpge -154 -> 210
    //   367: aload 8
    //   369: iload_1
    //   370: baload
    //   371: sipush 255
    //   374: iand
    //   375: istore_3
    //   376: iload_3
    //   377: bipush 16
    //   379: if_icmpge +10 -> 389
    //   382: ldc 85
    //   384: astore 5
    //   386: goto -210 -> 176
    //   389: ldc 87
    //   391: astore 5
    //   393: goto -217 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramString	java.lang.String
    //   58	312	1	i	int
    //   170	195	2	j	int
    //   192	188	3	k	int
    //   36	196	4	localFileInputStream	java.io.FileInputStream
    //   238	18	4	localException1	java.lang.Exception
    //   302	13	4	localObject1	Object
    //   349	1	4	localObject2	Object
    //   357	1	4	localObject3	Object
    //   5	63	5	localObject4	Object
    //   79	21	5	localException2	java.lang.Exception
    //   115	110	5	localObject5	Object
    //   354	1	5	localException3	java.lang.Exception
    //   384	8	5	str	java.lang.String
    //   1	127	6	localObject6	Object
    //   46	168	7	localObject7	Object
    //   162	206	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   41	48	79	java/lang/Exception
    //   51	59	79	java/lang/Exception
    //   67	76	79	java/lang/Exception
    //   137	142	79	java/lang/Exception
    //   145	154	79	java/lang/Exception
    //   157	164	79	java/lang/Exception
    //   167	171	79	java/lang/Exception
    //   179	187	79	java/lang/Exception
    //   190	203	79	java/lang/Exception
    //   213	220	79	java/lang/Exception
    //   231	236	238	java/lang/Exception
    //   122	127	271	java/lang/Exception
    //   21	38	302	finally
    //   310	314	317	java/lang/Exception
    //   41	48	349	finally
    //   51	59	349	finally
    //   67	76	349	finally
    //   84	113	349	finally
    //   137	142	349	finally
    //   145	154	349	finally
    //   157	164	349	finally
    //   167	171	349	finally
    //   179	187	349	finally
    //   190	203	349	finally
    //   213	220	349	finally
    //   21	38	354	java/lang/Exception
  }
  
  /* Error */
  public static final java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +15 -> 32
    //   20: ldc 98
    //   22: iconst_1
    //   23: ldc 100
    //   25: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_3
    //   31: areturn
    //   32: new 45	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: new 15	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 7
    //   50: aload 7
    //   52: ifnull +598 -> 650
    //   55: aload 7
    //   57: invokevirtual 22	java/io/File:exists	()Z
    //   60: ifeq +590 -> 650
    //   63: aload_3
    //   64: ldc 102
    //   66: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 104
    //   75: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokestatic 106	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 108
    //   87: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 7
    //   92: invokevirtual 111	java/io/File:getName	()Ljava/lang/String;
    //   95: ldc 113
    //   97: invokestatic 118	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 120
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 122
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 8
    //   120: aload 6
    //   122: astore 4
    //   124: new 124	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   127: dup
    //   128: invokespecial 125	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   131: astore_3
    //   132: aload 6
    //   134: astore 4
    //   136: ldc 127
    //   138: invokestatic 132	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   141: astore 9
    //   143: aload 6
    //   145: astore 4
    //   147: aload 9
    //   149: aconst_null
    //   150: iconst_1
    //   151: anewarray 134	javax/net/ssl/TrustManager
    //   154: dup
    //   155: iconst_0
    //   156: aload_3
    //   157: aastore
    //   158: aconst_null
    //   159: invokevirtual 138	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   162: aload 6
    //   164: astore 4
    //   166: new 140	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   169: dup
    //   170: aload 9
    //   172: invokevirtual 144	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   175: invokespecial 147	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   178: astore 9
    //   180: aload 6
    //   182: astore 4
    //   184: aload 9
    //   186: invokestatic 152	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   189: aload 6
    //   191: astore 4
    //   193: new 154	java/net/URL
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   202: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   205: checkcast 149	javax/net/ssl/HttpsURLConnection
    //   208: astore_3
    //   209: aload_3
    //   210: aload 9
    //   212: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   215: aload_3
    //   216: sipush 5000
    //   219: invokevirtual 166	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   222: aload_3
    //   223: sipush 30000
    //   226: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   229: aload_3
    //   230: iconst_1
    //   231: invokevirtual 173	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   234: aload_3
    //   235: iconst_1
    //   236: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   239: aload_3
    //   240: iconst_0
    //   241: invokevirtual 179	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   244: aload_3
    //   245: ldc 181
    //   247: invokevirtual 184	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   250: aload_3
    //   251: ldc 186
    //   253: ldc 188
    //   255: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_3
    //   259: ldc 194
    //   261: new 45	java/lang/StringBuilder
    //   264: dup
    //   265: ldc 196
    //   267: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: ldc 199
    //   272: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: getstatic 205	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   278: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 199
    //   283: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: getstatic 210	android/os/Build:DEVICE	Ljava/lang/String;
    //   289: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc 199
    //   294: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: getstatic 213	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   300: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc 199
    //   305: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 215
    //   310: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 199
    //   315: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 217
    //   320: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc 219
    //   325: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_3
    //   335: ldc 221
    //   337: ldc 223
    //   339: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_3
    //   343: ldc 225
    //   345: new 45	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   352: ldc 227
    //   354: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc 229
    //   359: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: new 231	java/util/HashMap
    //   371: dup
    //   372: invokespecial 232	java/util/HashMap:<init>	()V
    //   375: astore 9
    //   377: aload 9
    //   379: ldc 186
    //   381: ldc 234
    //   383: invokeinterface 240 3 0
    //   388: pop
    //   389: aload 9
    //   391: ldc 242
    //   393: aload 8
    //   395: invokeinterface 240 3 0
    //   400: pop
    //   401: invokestatic 248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   404: invokevirtual 252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   407: iconst_2
    //   408: invokevirtual 258	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   411: checkcast 260	mqq/manager/TicketManager
    //   414: astore 4
    //   416: aload 4
    //   418: aload_1
    //   419: invokeinterface 263 2 0
    //   424: astore 10
    //   426: aload 8
    //   428: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   431: ifne +800 -> 1231
    //   434: aload 4
    //   436: aload_1
    //   437: ldc_w 265
    //   440: invokeinterface 268 3 0
    //   445: astore 4
    //   447: aload 7
    //   449: ifnull +777 -> 1226
    //   452: aload 7
    //   454: invokevirtual 22	java/io/File:exists	()Z
    //   457: ifeq +769 -> 1226
    //   460: aload_0
    //   461: invokestatic 106	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   464: astore_0
    //   465: aload 4
    //   467: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifeq +191 -> 661
    //   473: ldc 98
    //   475: iconst_1
    //   476: ldc_w 270
    //   479: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: invokestatic 275	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   485: astore_0
    //   486: aload_0
    //   487: ifnull +20 -> 507
    //   490: aload 9
    //   492: ldc_w 277
    //   495: aload_0
    //   496: aload 8
    //   498: invokevirtual 280	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   501: invokeinterface 240 3 0
    //   506: pop
    //   507: aload 9
    //   509: invokeinterface 284 1 0
    //   514: invokeinterface 290 1 0
    //   519: astore_1
    //   520: aload_1
    //   521: invokeinterface 295 1 0
    //   526: ifeq +248 -> 774
    //   529: aload_1
    //   530: invokeinterface 299 1 0
    //   535: checkcast 301	java/util/Map$Entry
    //   538: astore_0
    //   539: aload_3
    //   540: aload_0
    //   541: invokeinterface 304 1 0
    //   546: checkcast 78	java/lang/String
    //   549: aload_0
    //   550: invokeinterface 307 1 0
    //   555: checkcast 78	java/lang/String
    //   558: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -41 -> 520
    //   564: astore 4
    //   566: aconst_null
    //   567: astore_0
    //   568: aload_3
    //   569: astore_1
    //   570: aload 4
    //   572: astore_3
    //   573: aload_1
    //   574: astore 4
    //   576: ldc_w 309
    //   579: iconst_1
    //   580: new 45	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 311
    //   590: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_3
    //   594: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   597: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload_0
    //   607: astore_3
    //   608: aload_1
    //   609: ifnull -579 -> 30
    //   612: aload_1
    //   613: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   616: aload_0
    //   617: areturn
    //   618: astore_0
    //   619: ldc 98
    //   621: iconst_1
    //   622: new 45	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 319
    //   632: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_0
    //   636: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   639: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aconst_null
    //   649: areturn
    //   650: ldc 98
    //   652: iconst_1
    //   653: ldc_w 321
    //   656: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aconst_null
    //   660: areturn
    //   661: new 45	java/lang/StringBuilder
    //   664: dup
    //   665: new 45	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 323
    //   675: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 4
    //   680: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 325
    //   686: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_1
    //   690: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 327
    //   696: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 10
    //   701: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   710: astore_1
    //   711: aload_0
    //   712: ifnull +28 -> 740
    //   715: aload_1
    //   716: new 45	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 329
    //   726: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_0
    //   730: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 9
    //   742: ldc_w 277
    //   745: aload_1
    //   746: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokeinterface 240 3 0
    //   754: pop
    //   755: goto -248 -> 507
    //   758: astore_0
    //   759: aload_3
    //   760: astore 4
    //   762: aload 4
    //   764: ifnull +8 -> 772
    //   767: aload 4
    //   769: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   772: aload_0
    //   773: athrow
    //   774: new 331	java/io/DataOutputStream
    //   777: dup
    //   778: aload_3
    //   779: invokevirtual 335	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   782: invokespecial 338	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   785: astore_1
    //   786: new 340	java/lang/StringBuffer
    //   789: dup
    //   790: invokespecial 341	java/lang/StringBuffer:<init>	()V
    //   793: astore_0
    //   794: aload_0
    //   795: ldc_w 343
    //   798: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   801: ldc_w 348
    //   804: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   807: ldc 229
    //   809: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   812: ldc_w 343
    //   815: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   818: pop
    //   819: aload_0
    //   820: ldc_w 350
    //   823: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   826: ldc_w 352
    //   829: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   832: ldc_w 354
    //   835: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   838: aload 7
    //   840: invokevirtual 111	java/io/File:getName	()Ljava/lang/String;
    //   843: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   846: ldc_w 356
    //   849: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   852: pop
    //   853: aload_0
    //   854: new 45	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 358
    //   864: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 360
    //   870: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w 362
    //   876: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   885: pop
    //   886: aload_1
    //   887: aload_0
    //   888: invokevirtual 363	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   891: invokevirtual 366	java/lang/String:getBytes	()[B
    //   894: invokevirtual 372	java/io/OutputStream:write	([B)V
    //   897: new 374	java/io/BufferedInputStream
    //   900: dup
    //   901: new 374	java/io/BufferedInputStream
    //   904: dup
    //   905: new 32	java/io/FileInputStream
    //   908: dup
    //   909: aload 7
    //   911: invokespecial 377	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   914: invokespecial 380	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   917: invokespecial 380	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   920: astore_0
    //   921: sipush 3072
    //   924: newarray byte
    //   926: astore 4
    //   928: aload_0
    //   929: aload 4
    //   931: invokevirtual 381	java/io/BufferedInputStream:read	([B)I
    //   934: istore_2
    //   935: iload_2
    //   936: iconst_m1
    //   937: if_icmpeq +94 -> 1031
    //   940: aload_1
    //   941: aload 4
    //   943: iconst_0
    //   944: iload_2
    //   945: invokevirtual 383	java/io/OutputStream:write	([BII)V
    //   948: goto -20 -> 928
    //   951: astore 4
    //   953: ldc 98
    //   955: iconst_1
    //   956: new 45	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 385
    //   966: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload 7
    //   971: invokevirtual 389	java/io/File:length	()J
    //   974: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   977: ldc_w 394
    //   980: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 7
    //   985: invokevirtual 397	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   988: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: aload_1
    //   998: invokevirtual 400	java/io/OutputStream:flush	()V
    //   1001: aload_1
    //   1002: invokevirtual 401	java/io/OutputStream:close	()V
    //   1005: aload_3
    //   1006: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1009: aload 6
    //   1011: astore 4
    //   1013: aload_0
    //   1014: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   1017: iconst_0
    //   1018: ifeq +11 -> 1029
    //   1021: new 404	java/lang/NullPointerException
    //   1024: dup
    //   1025: invokespecial 405	java/lang/NullPointerException:<init>	()V
    //   1028: athrow
    //   1029: aconst_null
    //   1030: areturn
    //   1031: aload_0
    //   1032: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   1035: aload_1
    //   1036: new 45	java/lang/StringBuilder
    //   1039: dup
    //   1040: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1043: ldc_w 407
    //   1046: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: ldc 229
    //   1051: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 409
    //   1057: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokevirtual 366	java/lang/String:getBytes	()[B
    //   1066: invokevirtual 372	java/io/OutputStream:write	([B)V
    //   1069: aload_1
    //   1070: invokevirtual 400	java/io/OutputStream:flush	()V
    //   1073: aload_1
    //   1074: invokevirtual 401	java/io/OutputStream:close	()V
    //   1077: new 340	java/lang/StringBuffer
    //   1080: dup
    //   1081: invokespecial 341	java/lang/StringBuffer:<init>	()V
    //   1084: astore_0
    //   1085: aload_3
    //   1086: invokevirtual 413	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1089: istore_2
    //   1090: iload_2
    //   1091: sipush 200
    //   1094: if_icmpeq +35 -> 1129
    //   1097: ldc 98
    //   1099: iconst_1
    //   1100: new 45	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1107: ldc_w 415
    //   1110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: iload_2
    //   1114: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1117: ldc_w 420
    //   1120: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1126: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1129: new 425	java/io/BufferedReader
    //   1132: dup
    //   1133: new 427	java/io/InputStreamReader
    //   1136: dup
    //   1137: aload_3
    //   1138: invokevirtual 431	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1141: invokespecial 432	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1144: invokespecial 435	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1147: astore_1
    //   1148: aload_1
    //   1149: invokevirtual 438	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1152: astore 4
    //   1154: aload 4
    //   1156: ifnull +26 -> 1182
    //   1159: aload_0
    //   1160: aload 4
    //   1162: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1165: ldc_w 440
    //   1168: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1171: pop
    //   1172: goto -24 -> 1148
    //   1175: astore_1
    //   1176: aload_0
    //   1177: invokevirtual 402	java/io/BufferedInputStream:close	()V
    //   1180: aload_1
    //   1181: athrow
    //   1182: aload_0
    //   1183: invokevirtual 363	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1186: astore_0
    //   1187: aload_1
    //   1188: invokevirtual 441	java/io/BufferedReader:close	()V
    //   1191: aload_3
    //   1192: ifnull +32 -> 1224
    //   1195: aload_3
    //   1196: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1199: aload_0
    //   1200: areturn
    //   1201: astore_0
    //   1202: goto -440 -> 762
    //   1205: astore_3
    //   1206: aconst_null
    //   1207: astore_0
    //   1208: aload 5
    //   1210: astore_1
    //   1211: goto -638 -> 573
    //   1214: astore 4
    //   1216: aload_3
    //   1217: astore_1
    //   1218: aload 4
    //   1220: astore_3
    //   1221: goto -648 -> 573
    //   1224: aload_0
    //   1225: areturn
    //   1226: aconst_null
    //   1227: astore_0
    //   1228: goto -763 -> 465
    //   1231: aconst_null
    //   1232: astore 4
    //   1234: goto -787 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1237	0	paramString1	java.lang.String
    //   0	1237	1	paramString2	java.lang.String
    //   934	180	2	i	int
    //   29	1167	3	localObject1	Object
    //   1205	12	3	localException1	java.lang.Exception
    //   1220	1	3	localObject2	Object
    //   122	344	4	localObject3	Object
    //   564	7	4	localException2	java.lang.Exception
    //   574	368	4	localObject4	Object
    //   951	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1011	150	4	localObject5	Object
    //   1214	5	4	localException3	java.lang.Exception
    //   1232	1	4	localObject6	Object
    //   4	1205	5	localObject7	Object
    //   1	1009	6	localObject8	Object
    //   48	936	7	localFile	java.io.File
    //   118	379	8	str1	java.lang.String
    //   141	600	9	localObject9	Object
    //   424	276	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   209	447	564	java/lang/Exception
    //   452	465	564	java/lang/Exception
    //   465	486	564	java/lang/Exception
    //   490	507	564	java/lang/Exception
    //   507	520	564	java/lang/Exception
    //   520	561	564	java/lang/Exception
    //   661	711	564	java/lang/Exception
    //   715	740	564	java/lang/Exception
    //   740	755	564	java/lang/Exception
    //   774	928	564	java/lang/Exception
    //   1031	1090	564	java/lang/Exception
    //   1097	1129	564	java/lang/Exception
    //   1129	1148	564	java/lang/Exception
    //   1148	1154	564	java/lang/Exception
    //   1159	1172	564	java/lang/Exception
    //   1176	1182	564	java/lang/Exception
    //   1182	1187	564	java/lang/Exception
    //   63	114	618	java/lang/Exception
    //   209	447	758	finally
    //   452	465	758	finally
    //   465	486	758	finally
    //   490	507	758	finally
    //   507	520	758	finally
    //   520	561	758	finally
    //   661	711	758	finally
    //   715	740	758	finally
    //   740	755	758	finally
    //   774	928	758	finally
    //   1031	1090	758	finally
    //   1097	1129	758	finally
    //   1129	1148	758	finally
    //   1148	1154	758	finally
    //   1159	1172	758	finally
    //   1176	1182	758	finally
    //   1182	1187	758	finally
    //   1187	1191	758	finally
    //   928	935	951	java/lang/OutOfMemoryError
    //   940	948	951	java/lang/OutOfMemoryError
    //   928	935	1175	finally
    //   940	948	1175	finally
    //   953	1009	1175	finally
    //   124	132	1201	finally
    //   136	143	1201	finally
    //   147	162	1201	finally
    //   166	180	1201	finally
    //   184	189	1201	finally
    //   193	209	1201	finally
    //   576	606	1201	finally
    //   1013	1017	1201	finally
    //   124	132	1205	java/lang/Exception
    //   136	143	1205	java/lang/Exception
    //   147	162	1205	java/lang/Exception
    //   166	180	1205	java/lang/Exception
    //   184	189	1205	java/lang/Exception
    //   193	209	1205	java/lang/Exception
    //   1013	1017	1205	java/lang/Exception
    //   1187	1191	1214	java/lang/Exception
  }
  
  /* Error */
  public static final java.lang.String a(org.json.JSONObject paramJSONObject, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +16 -> 29
    //   16: ldc 98
    //   18: iconst_1
    //   19: ldc_w 444
    //   22: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: new 45	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 102
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 446
    //   52: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 6
    //   63: aload_3
    //   64: astore 4
    //   66: new 124	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   69: dup
    //   70: invokespecial 125	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   73: astore 7
    //   75: aload_3
    //   76: astore 4
    //   78: ldc 127
    //   80: invokestatic 132	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   83: astore 8
    //   85: aload_3
    //   86: astore 4
    //   88: aload 8
    //   90: aconst_null
    //   91: iconst_1
    //   92: anewarray 134	javax/net/ssl/TrustManager
    //   95: dup
    //   96: iconst_0
    //   97: aload 7
    //   99: aastore
    //   100: aconst_null
    //   101: invokevirtual 138	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   104: aload_3
    //   105: astore 4
    //   107: new 140	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   110: dup
    //   111: aload 8
    //   113: invokevirtual 144	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   116: invokespecial 147	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   119: astore 7
    //   121: aload_3
    //   122: astore 4
    //   124: aload 7
    //   126: invokestatic 152	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   129: aload_3
    //   130: astore 4
    //   132: new 154	java/net/URL
    //   135: dup
    //   136: aload 6
    //   138: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   141: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   144: checkcast 149	javax/net/ssl/HttpsURLConnection
    //   147: astore_3
    //   148: aload_3
    //   149: aload 7
    //   151: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   154: aload_3
    //   155: sipush 5000
    //   158: invokevirtual 166	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   161: aload_3
    //   162: sipush 30000
    //   165: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   168: aload_3
    //   169: iconst_1
    //   170: invokevirtual 173	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   173: aload_3
    //   174: iconst_1
    //   175: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   178: aload_3
    //   179: iconst_0
    //   180: invokevirtual 179	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   183: aload_3
    //   184: ldc 181
    //   186: invokevirtual 184	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   189: aload_3
    //   190: ldc 186
    //   192: ldc 188
    //   194: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_3
    //   198: ldc 194
    //   200: new 45	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 196
    //   206: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: ldc 199
    //   211: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 205	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   217: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 199
    //   222: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: getstatic 210	android/os/Build:DEVICE	Ljava/lang/String;
    //   228: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc 199
    //   233: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: getstatic 213	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   239: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 199
    //   244: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 215
    //   249: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 199
    //   254: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 217
    //   259: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 219
    //   264: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_3
    //   274: ldc 225
    //   276: ldc_w 448
    //   279: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_3
    //   283: ldc 221
    //   285: ldc 223
    //   287: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_3
    //   291: ldc_w 450
    //   294: ldc 113
    //   296: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: new 231	java/util/HashMap
    //   302: dup
    //   303: invokespecial 232	java/util/HashMap:<init>	()V
    //   306: astore 5
    //   308: aload 5
    //   310: ldc 186
    //   312: ldc 234
    //   314: invokeinterface 240 3 0
    //   319: pop
    //   320: aload 5
    //   322: ldc 242
    //   324: aload 6
    //   326: invokeinterface 240 3 0
    //   331: pop
    //   332: invokestatic 248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   335: invokevirtual 252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   338: iconst_2
    //   339: invokevirtual 258	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   342: checkcast 260	mqq/manager/TicketManager
    //   345: astore 4
    //   347: aload 4
    //   349: aload_1
    //   350: invokeinterface 263 2 0
    //   355: astore 7
    //   357: aload 6
    //   359: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   362: ifne +431 -> 793
    //   365: aload 4
    //   367: aload_1
    //   368: ldc_w 265
    //   371: invokeinterface 268 3 0
    //   376: astore 4
    //   378: aload 4
    //   380: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   383: ifeq +150 -> 533
    //   386: ldc 98
    //   388: iconst_1
    //   389: ldc_w 452
    //   392: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: invokestatic 275	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   398: astore_1
    //   399: aload_1
    //   400: ifnull +20 -> 420
    //   403: aload 5
    //   405: ldc_w 277
    //   408: aload_1
    //   409: aload 6
    //   411: invokevirtual 280	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   414: invokeinterface 240 3 0
    //   419: pop
    //   420: aload 5
    //   422: invokeinterface 284 1 0
    //   427: invokeinterface 290 1 0
    //   432: astore_1
    //   433: aload_1
    //   434: invokeinterface 295 1 0
    //   439: ifeq +161 -> 600
    //   442: aload_1
    //   443: invokeinterface 299 1 0
    //   448: checkcast 301	java/util/Map$Entry
    //   451: astore 4
    //   453: aload_3
    //   454: aload 4
    //   456: invokeinterface 304 1 0
    //   461: checkcast 78	java/lang/String
    //   464: aload 4
    //   466: invokeinterface 307 1 0
    //   471: checkcast 78	java/lang/String
    //   474: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: goto -44 -> 433
    //   480: astore 4
    //   482: aconst_null
    //   483: astore_0
    //   484: aload_3
    //   485: astore_1
    //   486: aload 4
    //   488: astore_3
    //   489: aload_1
    //   490: astore 4
    //   492: ldc 98
    //   494: iconst_1
    //   495: new 45	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 454
    //   505: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_3
    //   509: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   512: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_0
    //   522: astore_3
    //   523: aload_1
    //   524: ifnull -497 -> 27
    //   527: aload_1
    //   528: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   531: aload_0
    //   532: areturn
    //   533: aload 5
    //   535: ldc_w 277
    //   538: new 45	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   545: ldc_w 323
    //   548: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 4
    //   553: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 325
    //   559: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc_w 327
    //   569: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 7
    //   574: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokeinterface 240 3 0
    //   585: pop
    //   586: goto -166 -> 420
    //   589: astore_0
    //   590: aload_3
    //   591: ifnull +7 -> 598
    //   594: aload_3
    //   595: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   598: aload_0
    //   599: athrow
    //   600: new 331	java/io/DataOutputStream
    //   603: dup
    //   604: aload_3
    //   605: invokevirtual 335	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   608: invokespecial 338	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   611: astore_1
    //   612: aload_1
    //   613: aload_0
    //   614: invokevirtual 457	org/json/JSONObject:toString	()Ljava/lang/String;
    //   617: ldc 113
    //   619: invokevirtual 460	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   622: invokevirtual 372	java/io/OutputStream:write	([B)V
    //   625: aload_1
    //   626: invokevirtual 400	java/io/OutputStream:flush	()V
    //   629: aload_1
    //   630: invokevirtual 401	java/io/OutputStream:close	()V
    //   633: new 340	java/lang/StringBuffer
    //   636: dup
    //   637: invokespecial 341	java/lang/StringBuffer:<init>	()V
    //   640: astore_0
    //   641: aload_3
    //   642: invokevirtual 413	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   645: istore_2
    //   646: iload_2
    //   647: sipush 200
    //   650: if_icmpeq +35 -> 685
    //   653: ldc 98
    //   655: iconst_1
    //   656: new 45	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 462
    //   666: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: iload_2
    //   670: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   673: ldc_w 420
    //   676: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: new 425	java/io/BufferedReader
    //   688: dup
    //   689: new 427	java/io/InputStreamReader
    //   692: dup
    //   693: aload_3
    //   694: invokevirtual 431	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   697: invokespecial 432	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   700: invokespecial 435	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   703: astore_1
    //   704: aload_1
    //   705: invokevirtual 438	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   708: astore 4
    //   710: aload 4
    //   712: ifnull +34 -> 746
    //   715: aload_0
    //   716: aload 4
    //   718: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   721: ldc_w 440
    //   724: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   727: pop
    //   728: goto -24 -> 704
    //   731: astore_0
    //   732: aload_1
    //   733: invokevirtual 401	java/io/OutputStream:close	()V
    //   736: aload_3
    //   737: ifnull +7 -> 744
    //   740: aload_3
    //   741: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   744: aconst_null
    //   745: areturn
    //   746: aload_0
    //   747: invokevirtual 363	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   750: astore_0
    //   751: aload_1
    //   752: invokevirtual 441	java/io/BufferedReader:close	()V
    //   755: aload_3
    //   756: ifnull +35 -> 791
    //   759: aload_3
    //   760: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   763: aload_0
    //   764: areturn
    //   765: astore_0
    //   766: aload 4
    //   768: astore_3
    //   769: goto -179 -> 590
    //   772: astore_3
    //   773: aconst_null
    //   774: astore_0
    //   775: aload 5
    //   777: astore_1
    //   778: goto -289 -> 489
    //   781: astore 4
    //   783: aload_3
    //   784: astore_1
    //   785: aload 4
    //   787: astore_3
    //   788: goto -299 -> 489
    //   791: aload_0
    //   792: areturn
    //   793: aconst_null
    //   794: astore 4
    //   796: goto -418 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	paramJSONObject	org.json.JSONObject
    //   0	799	1	paramString	java.lang.String
    //   645	25	2	i	int
    //   1	768	3	localObject1	Object
    //   772	12	3	localException1	java.lang.Exception
    //   787	1	3	localObject2	Object
    //   36	429	4	localObject3	Object
    //   480	7	4	localException2	java.lang.Exception
    //   490	277	4	str1	java.lang.String
    //   781	5	4	localException3	java.lang.Exception
    //   794	1	4	localObject4	Object
    //   3	773	5	localHashMap	java.util.HashMap
    //   61	349	6	str2	java.lang.String
    //   73	500	7	localObject5	Object
    //   83	29	8	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   148	378	480	java/lang/Exception
    //   378	399	480	java/lang/Exception
    //   403	420	480	java/lang/Exception
    //   420	433	480	java/lang/Exception
    //   433	477	480	java/lang/Exception
    //   533	586	480	java/lang/Exception
    //   600	612	480	java/lang/Exception
    //   633	646	480	java/lang/Exception
    //   653	685	480	java/lang/Exception
    //   685	704	480	java/lang/Exception
    //   704	710	480	java/lang/Exception
    //   715	728	480	java/lang/Exception
    //   732	736	480	java/lang/Exception
    //   746	751	480	java/lang/Exception
    //   148	378	589	finally
    //   378	399	589	finally
    //   403	420	589	finally
    //   420	433	589	finally
    //   433	477	589	finally
    //   533	586	589	finally
    //   600	612	589	finally
    //   612	633	589	finally
    //   633	646	589	finally
    //   653	685	589	finally
    //   685	704	589	finally
    //   704	710	589	finally
    //   715	728	589	finally
    //   732	736	589	finally
    //   746	751	589	finally
    //   751	755	589	finally
    //   612	633	731	java/lang/Exception
    //   66	75	765	finally
    //   78	85	765	finally
    //   88	104	765	finally
    //   107	121	765	finally
    //   124	129	765	finally
    //   132	148	765	finally
    //   492	521	765	finally
    //   66	75	772	java/lang/Exception
    //   78	85	772	java/lang/Exception
    //   88	104	772	java/lang/Exception
    //   107	121	772	java/lang/Exception
    //   124	129	772	java/lang/Exception
    //   132	148	772	java/lang/Exception
    //   751	755	781	java/lang/Exception
  }
  
  /* Error */
  public static java.lang.String a(org.json.JSONObject paramJSONObject, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_2
    //   7: invokevirtual 464	java/lang/String:toString	()Ljava/lang/String;
    //   10: astore 8
    //   12: aload 7
    //   14: astore 5
    //   16: new 124	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   19: dup
    //   20: invokespecial 125	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   23: astore_2
    //   24: aload 7
    //   26: astore 5
    //   28: ldc 127
    //   30: invokestatic 132	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   33: astore 9
    //   35: aload 7
    //   37: astore 5
    //   39: aload 9
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 134	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 138	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: aload 7
    //   56: astore 5
    //   58: new 140	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   61: dup
    //   62: aload 9
    //   64: invokevirtual 144	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 147	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: astore 9
    //   72: aload 7
    //   74: astore 5
    //   76: aload 9
    //   78: invokestatic 152	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 7
    //   83: astore 5
    //   85: new 154	java/net/URL
    //   88: dup
    //   89: aload 8
    //   91: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 149	javax/net/ssl/HttpsURLConnection
    //   100: astore_2
    //   101: aload_2
    //   102: aload 9
    //   104: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload_2
    //   108: sipush 5000
    //   111: invokevirtual 166	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   114: aload_2
    //   115: sipush 30000
    //   118: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   126: aload_2
    //   127: iconst_0
    //   128: invokevirtual 179	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   131: aload_2
    //   132: ldc 181
    //   134: invokevirtual 184	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   137: aload_2
    //   138: ldc 186
    //   140: ldc 188
    //   142: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_2
    //   146: ldc 194
    //   148: new 45	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 196
    //   154: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: ldc 199
    //   159: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: getstatic 205	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   165: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 199
    //   170: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 210	android/os/Build:DEVICE	Ljava/lang/String;
    //   176: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 199
    //   181: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: getstatic 213	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   187: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 199
    //   192: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 215
    //   197: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 199
    //   202: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 217
    //   207: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc 219
    //   212: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_2
    //   222: ldc 225
    //   224: ldc_w 448
    //   227: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_2
    //   231: ldc 221
    //   233: ldc 223
    //   235: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_2
    //   239: ldc_w 450
    //   242: ldc 113
    //   244: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: new 231	java/util/HashMap
    //   250: dup
    //   251: invokespecial 232	java/util/HashMap:<init>	()V
    //   254: astore 5
    //   256: aload 5
    //   258: ldc 186
    //   260: ldc 234
    //   262: invokeinterface 240 3 0
    //   267: pop
    //   268: aload 5
    //   270: ldc 242
    //   272: aload 8
    //   274: invokeinterface 240 3 0
    //   279: pop
    //   280: invokestatic 248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   283: invokevirtual 252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   286: iconst_2
    //   287: invokevirtual 258	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   290: checkcast 260	mqq/manager/TicketManager
    //   293: astore 7
    //   295: aload 7
    //   297: aload_1
    //   298: invokeinterface 263 2 0
    //   303: astore 6
    //   305: aload 8
    //   307: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   310: ifne +417 -> 727
    //   313: aload 7
    //   315: aload_1
    //   316: aload_3
    //   317: invokeinterface 268 3 0
    //   322: astore_3
    //   323: aload_3
    //   324: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifeq +143 -> 470
    //   330: ldc 98
    //   332: iconst_1
    //   333: ldc_w 452
    //   336: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: invokestatic 275	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   342: astore_1
    //   343: aload_1
    //   344: ifnull +20 -> 364
    //   347: aload 5
    //   349: ldc_w 277
    //   352: aload_1
    //   353: aload 8
    //   355: invokevirtual 280	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   358: invokeinterface 240 3 0
    //   363: pop
    //   364: aload 5
    //   366: invokeinterface 284 1 0
    //   371: invokeinterface 290 1 0
    //   376: astore_1
    //   377: aload_1
    //   378: invokeinterface 295 1 0
    //   383: ifeq +153 -> 536
    //   386: aload_1
    //   387: invokeinterface 299 1 0
    //   392: checkcast 301	java/util/Map$Entry
    //   395: astore_3
    //   396: aload_2
    //   397: aload_3
    //   398: invokeinterface 304 1 0
    //   403: checkcast 78	java/lang/String
    //   406: aload_3
    //   407: invokeinterface 307 1 0
    //   412: checkcast 78	java/lang/String
    //   415: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: goto -41 -> 377
    //   421: astore_3
    //   422: aconst_null
    //   423: astore_1
    //   424: aload_2
    //   425: astore_0
    //   426: aload_3
    //   427: astore_2
    //   428: aload_0
    //   429: astore 5
    //   431: ldc 98
    //   433: iconst_1
    //   434: new 45	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 466
    //   444: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_2
    //   448: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   451: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload_0
    //   461: ifnull +7 -> 468
    //   464: aload_0
    //   465: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   468: aload_1
    //   469: areturn
    //   470: aload 5
    //   472: ldc_w 277
    //   475: new 45	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 323
    //   485: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_3
    //   489: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 325
    //   495: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 327
    //   505: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 6
    //   510: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokeinterface 240 3 0
    //   521: pop
    //   522: goto -158 -> 364
    //   525: astore_0
    //   526: aload_2
    //   527: ifnull +7 -> 534
    //   530: aload_2
    //   531: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   534: aload_0
    //   535: athrow
    //   536: new 331	java/io/DataOutputStream
    //   539: dup
    //   540: aload_2
    //   541: invokevirtual 335	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   544: invokespecial 338	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   547: astore_1
    //   548: aload_1
    //   549: aload_0
    //   550: invokevirtual 457	org/json/JSONObject:toString	()Ljava/lang/String;
    //   553: ldc 113
    //   555: invokevirtual 460	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   558: invokevirtual 372	java/io/OutputStream:write	([B)V
    //   561: aload_1
    //   562: invokevirtual 400	java/io/OutputStream:flush	()V
    //   565: aload_1
    //   566: invokevirtual 401	java/io/OutputStream:close	()V
    //   569: new 340	java/lang/StringBuffer
    //   572: dup
    //   573: invokespecial 341	java/lang/StringBuffer:<init>	()V
    //   576: astore_1
    //   577: aload_2
    //   578: invokevirtual 413	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   581: istore 4
    //   583: iload 4
    //   585: sipush 200
    //   588: if_icmpeq +36 -> 624
    //   591: ldc 98
    //   593: iconst_1
    //   594: new 45	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 468
    //   604: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload 4
    //   609: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: ldc_w 420
    //   615: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: new 425	java/io/BufferedReader
    //   627: dup
    //   628: new 427	java/io/InputStreamReader
    //   631: dup
    //   632: aload_2
    //   633: invokevirtual 431	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   636: invokespecial 432	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   639: invokespecial 435	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   642: astore_0
    //   643: aload_0
    //   644: invokevirtual 438	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   647: astore_3
    //   648: aload_3
    //   649: ifnull +33 -> 682
    //   652: aload_1
    //   653: aload_3
    //   654: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   657: ldc_w 440
    //   660: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   663: pop
    //   664: goto -21 -> 643
    //   667: astore_0
    //   668: aload_1
    //   669: invokevirtual 401	java/io/OutputStream:close	()V
    //   672: aload_2
    //   673: ifnull +7 -> 680
    //   676: aload_2
    //   677: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   680: aconst_null
    //   681: areturn
    //   682: aload_1
    //   683: invokevirtual 363	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   686: astore_1
    //   687: aload_0
    //   688: invokevirtual 441	java/io/BufferedReader:close	()V
    //   691: aload_2
    //   692: ifnull +33 -> 725
    //   695: aload_2
    //   696: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   699: aload_1
    //   700: areturn
    //   701: astore_0
    //   702: aload 5
    //   704: astore_2
    //   705: goto -179 -> 526
    //   708: astore_2
    //   709: aconst_null
    //   710: astore_1
    //   711: aload 6
    //   713: astore_0
    //   714: goto -286 -> 428
    //   717: astore_3
    //   718: aload_2
    //   719: astore_0
    //   720: aload_3
    //   721: astore_2
    //   722: goto -294 -> 428
    //   725: aload_1
    //   726: areturn
    //   727: aconst_null
    //   728: astore_3
    //   729: goto -406 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	paramJSONObject	org.json.JSONObject
    //   0	732	1	paramString1	java.lang.String
    //   0	732	2	paramString2	java.lang.String
    //   0	732	3	paramString3	java.lang.String
    //   581	27	4	i	int
    //   14	689	5	localObject1	Object
    //   4	708	6	str1	java.lang.String
    //   1	313	7	localTicketManager	mqq.manager.TicketManager
    //   10	344	8	str2	java.lang.String
    //   33	70	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	323	421	java/lang/Exception
    //   323	343	421	java/lang/Exception
    //   347	364	421	java/lang/Exception
    //   364	377	421	java/lang/Exception
    //   377	418	421	java/lang/Exception
    //   470	522	421	java/lang/Exception
    //   536	548	421	java/lang/Exception
    //   569	583	421	java/lang/Exception
    //   591	624	421	java/lang/Exception
    //   624	643	421	java/lang/Exception
    //   643	648	421	java/lang/Exception
    //   652	664	421	java/lang/Exception
    //   668	672	421	java/lang/Exception
    //   682	687	421	java/lang/Exception
    //   101	323	525	finally
    //   323	343	525	finally
    //   347	364	525	finally
    //   364	377	525	finally
    //   377	418	525	finally
    //   470	522	525	finally
    //   536	548	525	finally
    //   548	569	525	finally
    //   569	583	525	finally
    //   591	624	525	finally
    //   624	643	525	finally
    //   643	648	525	finally
    //   652	664	525	finally
    //   668	672	525	finally
    //   682	687	525	finally
    //   687	691	525	finally
    //   548	569	667	java/lang/Exception
    //   16	24	701	finally
    //   28	35	701	finally
    //   39	54	701	finally
    //   58	72	701	finally
    //   76	81	701	finally
    //   85	101	701	finally
    //   431	460	701	finally
    //   16	24	708	java/lang/Exception
    //   28	35	708	java/lang/Exception
    //   39	54	708	java/lang/Exception
    //   58	72	708	java/lang/Exception
    //   76	81	708	java/lang/Exception
    //   85	101	708	java/lang/Exception
    //   687	691	717	java/lang/Exception
  }
  
  /* Error */
  public static final java.lang.String b(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +16 -> 26
    //   13: ldc 98
    //   15: iconst_1
    //   16: ldc_w 471
    //   19: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_3
    //   25: areturn
    //   26: new 45	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 102
    //   37: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: new 45	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 473
    //   54: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: aload 4
    //   76: astore_3
    //   77: new 124	com/tencent/mobileqq/teamwork/CustomX509TrustManager
    //   80: dup
    //   81: invokespecial 125	com/tencent/mobileqq/teamwork/CustomX509TrustManager:<init>	()V
    //   84: astore_0
    //   85: aload 4
    //   87: astore_3
    //   88: ldc 127
    //   90: invokestatic 132	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   93: astore 7
    //   95: aload 4
    //   97: astore_3
    //   98: aload 7
    //   100: aconst_null
    //   101: iconst_1
    //   102: anewarray 134	javax/net/ssl/TrustManager
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: aastore
    //   109: aconst_null
    //   110: invokevirtual 138	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   113: aload 4
    //   115: astore_3
    //   116: new 140	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory
    //   119: dup
    //   120: aload 7
    //   122: invokevirtual 144	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   125: invokespecial 147	com/tencent/mobileqq/teamwork/NoSSLv3SocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   128: astore 7
    //   130: aload 4
    //   132: astore_3
    //   133: aload 7
    //   135: invokestatic 152	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   138: aload 4
    //   140: astore_3
    //   141: new 154	java/net/URL
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   150: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   153: checkcast 149	javax/net/ssl/HttpsURLConnection
    //   156: astore_0
    //   157: aload_0
    //   158: aload 7
    //   160: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   163: aload_0
    //   164: sipush 5000
    //   167: invokevirtual 166	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   170: aload_0
    //   171: sipush 30000
    //   174: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   177: aload_0
    //   178: iconst_1
    //   179: invokevirtual 173	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   182: aload_0
    //   183: iconst_1
    //   184: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   187: aload_0
    //   188: iconst_0
    //   189: invokevirtual 179	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   192: aload_0
    //   193: ldc_w 475
    //   196: invokevirtual 184	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: ldc 186
    //   202: ldc 188
    //   204: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_0
    //   208: ldc 194
    //   210: new 45	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 196
    //   216: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: ldc 199
    //   221: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 205	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   227: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 199
    //   232: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 210	android/os/Build:DEVICE	Ljava/lang/String;
    //   238: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 199
    //   243: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 213	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   249: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 199
    //   254: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 215
    //   259: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 199
    //   264: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 217
    //   269: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 219
    //   274: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: ldc 225
    //   286: ldc_w 448
    //   289: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_0
    //   293: ldc 221
    //   295: ldc 223
    //   297: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload_0
    //   301: ldc_w 450
    //   304: ldc 113
    //   306: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: new 231	java/util/HashMap
    //   312: dup
    //   313: invokespecial 232	java/util/HashMap:<init>	()V
    //   316: astore 4
    //   318: aload 4
    //   320: ldc 186
    //   322: ldc 234
    //   324: invokeinterface 240 3 0
    //   329: pop
    //   330: aload 4
    //   332: ldc 242
    //   334: aload 6
    //   336: invokeinterface 240 3 0
    //   341: pop
    //   342: invokestatic 248	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   345: invokevirtual 252	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   348: iconst_2
    //   349: invokevirtual 258	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   352: checkcast 260	mqq/manager/TicketManager
    //   355: astore_3
    //   356: aload_3
    //   357: aload_1
    //   358: invokeinterface 263 2 0
    //   363: astore 5
    //   365: aload 6
    //   367: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifne +375 -> 745
    //   373: aload_3
    //   374: aload_1
    //   375: ldc_w 265
    //   378: invokeinterface 268 3 0
    //   383: astore_3
    //   384: aload_3
    //   385: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifeq +147 -> 535
    //   391: ldc 98
    //   393: iconst_1
    //   394: ldc_w 452
    //   397: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: invokestatic 275	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   403: astore_1
    //   404: aload_1
    //   405: ifnull +20 -> 425
    //   408: aload 4
    //   410: ldc_w 277
    //   413: aload_1
    //   414: aload 6
    //   416: invokevirtual 280	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokeinterface 240 3 0
    //   424: pop
    //   425: aload 4
    //   427: invokeinterface 284 1 0
    //   432: invokeinterface 290 1 0
    //   437: astore_1
    //   438: aload_1
    //   439: invokeinterface 295 1 0
    //   444: ifeq +157 -> 601
    //   447: aload_1
    //   448: invokeinterface 299 1 0
    //   453: checkcast 301	java/util/Map$Entry
    //   456: astore_3
    //   457: aload_0
    //   458: aload_3
    //   459: invokeinterface 304 1 0
    //   464: checkcast 78	java/lang/String
    //   467: aload_3
    //   468: invokeinterface 307 1 0
    //   473: checkcast 78	java/lang/String
    //   476: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: goto -41 -> 438
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_3
    //   486: aload_0
    //   487: astore_1
    //   488: aload_3
    //   489: astore_0
    //   490: aload_1
    //   491: astore_3
    //   492: ldc_w 477
    //   495: iconst_1
    //   496: new 45	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 454
    //   506: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 4
    //   511: invokevirtual 56	java/lang/Exception:toString	()Ljava/lang/String;
    //   514: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 314	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: astore_3
    //   525: aload_1
    //   526: ifnull -502 -> 24
    //   529: aload_1
    //   530: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   533: aload_0
    //   534: areturn
    //   535: aload 4
    //   537: ldc_w 277
    //   540: new 45	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 323
    //   550: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload_3
    //   554: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 325
    //   560: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: ldc_w 327
    //   570: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 5
    //   575: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokeinterface 240 3 0
    //   586: pop
    //   587: goto -162 -> 425
    //   590: astore_1
    //   591: aload_0
    //   592: ifnull +7 -> 599
    //   595: aload_0
    //   596: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   599: aload_1
    //   600: athrow
    //   601: new 340	java/lang/StringBuffer
    //   604: dup
    //   605: invokespecial 341	java/lang/StringBuffer:<init>	()V
    //   608: astore_3
    //   609: aload_0
    //   610: invokevirtual 413	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   613: istore_2
    //   614: iload_2
    //   615: sipush 200
    //   618: if_icmpeq +35 -> 653
    //   621: ldc 98
    //   623: iconst_1
    //   624: new 45	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 479
    //   634: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload_2
    //   638: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc_w 420
    //   644: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: new 425	java/io/BufferedReader
    //   656: dup
    //   657: new 427	java/io/InputStreamReader
    //   660: dup
    //   661: aload_0
    //   662: invokevirtual 431	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   665: invokespecial 432	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   668: invokespecial 435	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   671: astore_1
    //   672: aload_1
    //   673: invokevirtual 438	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   676: astore 4
    //   678: aload 4
    //   680: ifnull +19 -> 699
    //   683: aload_3
    //   684: aload 4
    //   686: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   689: ldc_w 440
    //   692: invokevirtual 346	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   695: pop
    //   696: goto -24 -> 672
    //   699: aload_3
    //   700: invokevirtual 363	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   703: astore_3
    //   704: aload_1
    //   705: invokevirtual 441	java/io/BufferedReader:close	()V
    //   708: aload_0
    //   709: ifnull +34 -> 743
    //   712: aload_0
    //   713: invokevirtual 317	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   716: aload_3
    //   717: areturn
    //   718: astore_1
    //   719: aload_3
    //   720: astore_0
    //   721: goto -130 -> 591
    //   724: astore 4
    //   726: aconst_null
    //   727: astore_0
    //   728: aload 5
    //   730: astore_1
    //   731: goto -241 -> 490
    //   734: astore 4
    //   736: aload_0
    //   737: astore_1
    //   738: aload_3
    //   739: astore_0
    //   740: goto -250 -> 490
    //   743: aload_3
    //   744: areturn
    //   745: aconst_null
    //   746: astore_3
    //   747: goto -363 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	paramString1	java.lang.String
    //   0	750	1	paramString2	java.lang.String
    //   613	25	2	i	int
    //   23	724	3	localObject1	Object
    //   1	425	4	localHashMap	java.util.HashMap
    //   482	54	4	localException1	java.lang.Exception
    //   676	9	4	str1	java.lang.String
    //   724	1	4	localException2	java.lang.Exception
    //   734	1	4	localException3	java.lang.Exception
    //   4	725	5	str2	java.lang.String
    //   72	343	6	str3	java.lang.String
    //   93	66	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	384	482	java/lang/Exception
    //   384	404	482	java/lang/Exception
    //   408	425	482	java/lang/Exception
    //   425	438	482	java/lang/Exception
    //   438	479	482	java/lang/Exception
    //   535	587	482	java/lang/Exception
    //   601	614	482	java/lang/Exception
    //   621	653	482	java/lang/Exception
    //   653	672	482	java/lang/Exception
    //   672	678	482	java/lang/Exception
    //   683	696	482	java/lang/Exception
    //   699	704	482	java/lang/Exception
    //   157	384	590	finally
    //   384	404	590	finally
    //   408	425	590	finally
    //   425	438	590	finally
    //   438	479	590	finally
    //   535	587	590	finally
    //   601	614	590	finally
    //   621	653	590	finally
    //   653	672	590	finally
    //   672	678	590	finally
    //   683	696	590	finally
    //   699	704	590	finally
    //   704	708	590	finally
    //   77	85	718	finally
    //   88	95	718	finally
    //   98	113	718	finally
    //   116	130	718	finally
    //   133	138	718	finally
    //   141	157	718	finally
    //   492	523	718	finally
    //   77	85	724	java/lang/Exception
    //   88	95	724	java/lang/Exception
    //   98	113	724	java/lang/Exception
    //   116	130	724	java/lang/Exception
    //   133	138	724	java/lang/Exception
    //   141	157	724	java/lang/Exception
    //   704	708	734	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHttpUtils
 * JD-Core Version:    0.7.0.1
 */