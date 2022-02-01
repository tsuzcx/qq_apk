package oicq.wlogin_sdk.tools;

public class c
{
  /* Error */
  public static int a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 7
    //   12: new 10	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 14	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 18	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 20	javax/net/ssl/HttpsURLConnection
    //   26: astore 6
    //   28: aload 7
    //   30: astore 5
    //   32: aload 8
    //   34: astore_0
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: sipush 5000
    //   44: invokevirtual 24	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   47: aload 7
    //   49: astore 5
    //   51: aload 8
    //   53: astore_0
    //   54: aload 6
    //   56: astore 4
    //   58: aload 6
    //   60: sipush 5000
    //   63: invokevirtual 27	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   66: aload 7
    //   68: astore 5
    //   70: aload 8
    //   72: astore_0
    //   73: aload 6
    //   75: astore 4
    //   77: aload 6
    //   79: iconst_1
    //   80: invokevirtual 31	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   83: aload 7
    //   85: astore 5
    //   87: aload 8
    //   89: astore_0
    //   90: aload 6
    //   92: astore 4
    //   94: aload 6
    //   96: ldc 33
    //   98: invokevirtual 36	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload 7
    //   103: astore 5
    //   105: aload 8
    //   107: astore_0
    //   108: aload 6
    //   110: astore 4
    //   112: aload 6
    //   114: iconst_0
    //   115: invokevirtual 39	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   118: aload 7
    //   120: astore 5
    //   122: aload 8
    //   124: astore_0
    //   125: aload 6
    //   127: astore 4
    //   129: aload 6
    //   131: ldc 41
    //   133: ldc 43
    //   135: invokevirtual 47	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 7
    //   140: astore 5
    //   142: aload 8
    //   144: astore_0
    //   145: aload 6
    //   147: astore 4
    //   149: aload 6
    //   151: ldc 49
    //   153: ldc 51
    //   155: invokevirtual 47	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 7
    //   160: astore 5
    //   162: aload 8
    //   164: astore_0
    //   165: aload 6
    //   167: astore 4
    //   169: aload 6
    //   171: invokevirtual 55	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   174: astore 7
    //   176: aload 7
    //   178: astore 5
    //   180: aload 7
    //   182: astore_0
    //   183: aload 6
    //   185: astore 4
    //   187: aload 7
    //   189: aload_1
    //   190: invokevirtual 61	java/lang/String:getBytes	()[B
    //   193: invokevirtual 67	java/io/OutputStream:write	([B)V
    //   196: aload 7
    //   198: astore 5
    //   200: aload 7
    //   202: astore_0
    //   203: aload 6
    //   205: astore 4
    //   207: aload 7
    //   209: invokevirtual 71	java/io/OutputStream:flush	()V
    //   212: aload 7
    //   214: astore 5
    //   216: aload 7
    //   218: astore_0
    //   219: aload 6
    //   221: astore 4
    //   223: aload 6
    //   225: invokevirtual 74	javax/net/ssl/HttpsURLConnection:connect	()V
    //   228: aload 7
    //   230: astore 5
    //   232: aload 7
    //   234: astore_0
    //   235: aload 6
    //   237: astore 4
    //   239: aload 6
    //   241: invokevirtual 78	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   244: istore_3
    //   245: aload 7
    //   247: ifnull +18 -> 265
    //   250: aload 7
    //   252: invokevirtual 81	java/io/OutputStream:close	()V
    //   255: goto +10 -> 265
    //   258: astore_0
    //   259: aload_0
    //   260: ldc 83
    //   262: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   265: iload_3
    //   266: istore_2
    //   267: aload 6
    //   269: ifnull +106 -> 375
    //   272: aload 6
    //   274: invokevirtual 92	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   277: iload_3
    //   278: istore_2
    //   279: goto +96 -> 375
    //   282: astore_0
    //   283: aload_0
    //   284: ldc 83
    //   286: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   289: iload_3
    //   290: istore_2
    //   291: goto +84 -> 375
    //   294: astore_0
    //   295: aload 6
    //   297: astore_1
    //   298: aload_0
    //   299: astore 6
    //   301: goto +21 -> 322
    //   304: astore_1
    //   305: aconst_null
    //   306: astore 5
    //   308: aload 4
    //   310: astore_0
    //   311: aload 5
    //   313: astore 4
    //   315: goto +100 -> 415
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_1
    //   322: aload 5
    //   324: astore_0
    //   325: aload_1
    //   326: astore 4
    //   328: aload 6
    //   330: ldc 83
    //   332: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   335: aload 5
    //   337: ifnull +18 -> 355
    //   340: aload 5
    //   342: invokevirtual 81	java/io/OutputStream:close	()V
    //   345: goto +10 -> 355
    //   348: astore_0
    //   349: aload_0
    //   350: ldc 83
    //   352: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   355: aload_1
    //   356: ifnull +17 -> 373
    //   359: aload_1
    //   360: invokevirtual 92	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   363: goto +10 -> 373
    //   366: astore_0
    //   367: aload_0
    //   368: ldc 83
    //   370: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   373: iconst_m1
    //   374: istore_2
    //   375: iload_2
    //   376: sipush 200
    //   379: if_icmpeq +33 -> 412
    //   382: new 94	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   389: astore_0
    //   390: aload_0
    //   391: ldc 98
    //   393: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_0
    //   398: iload_2
    //   399: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_0
    //   404: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: ldc 83
    //   409: invokestatic 112	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: iload_2
    //   413: ireturn
    //   414: astore_1
    //   415: aload_0
    //   416: ifnull +17 -> 433
    //   419: aload_0
    //   420: invokevirtual 81	java/io/OutputStream:close	()V
    //   423: goto +10 -> 433
    //   426: astore_0
    //   427: aload_0
    //   428: ldc 83
    //   430: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   433: aload 4
    //   435: ifnull +18 -> 453
    //   438: aload 4
    //   440: invokevirtual 92	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   443: goto +10 -> 453
    //   446: astore_0
    //   447: aload_0
    //   448: ldc 83
    //   450: invokestatic 89	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   453: aload_1
    //   454: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramString1	java.lang.String
    //   0	455	1	paramString2	java.lang.String
    //   266	147	2	i	int
    //   244	46	3	j	int
    //   7	432	4	localObject1	Object
    //   1	340	5	localObject2	Object
    //   26	274	6	localObject3	Object
    //   318	11	6	localException	java.lang.Exception
    //   10	241	7	localOutputStream	java.io.OutputStream
    //   4	159	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   250	255	258	java/lang/Exception
    //   272	277	282	java/lang/Exception
    //   39	47	294	java/lang/Exception
    //   58	66	294	java/lang/Exception
    //   77	83	294	java/lang/Exception
    //   94	101	294	java/lang/Exception
    //   112	118	294	java/lang/Exception
    //   129	138	294	java/lang/Exception
    //   149	158	294	java/lang/Exception
    //   169	176	294	java/lang/Exception
    //   187	196	294	java/lang/Exception
    //   207	212	294	java/lang/Exception
    //   223	228	294	java/lang/Exception
    //   239	245	294	java/lang/Exception
    //   12	28	304	finally
    //   12	28	318	java/lang/Exception
    //   340	345	348	java/lang/Exception
    //   359	363	366	java/lang/Exception
    //   39	47	414	finally
    //   58	66	414	finally
    //   77	83	414	finally
    //   94	101	414	finally
    //   112	118	414	finally
    //   129	138	414	finally
    //   149	158	414	finally
    //   169	176	414	finally
    //   187	196	414	finally
    //   207	212	414	finally
    //   223	228	414	finally
    //   239	245	414	finally
    //   328	335	414	finally
    //   419	423	426	java/lang/Exception
    //   438	443	446	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.c
 * JD-Core Version:    0.7.0.1
 */