package com.tencent.mobileqq.troop.data;

public class TroopBarShortVideoUploadUtil
{
  public static int a(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  /* Error */
  public static long a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, long paramLong1, java.io.RandomAccessFile paramRandomAccessFile, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 31	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadReqBody
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: lload_3
    //   12: lload 6
    //   14: iload 8
    //   16: i2l
    //   17: lconst_0
    //   18: lconst_0
    //   19: invokespecial 34	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadReqBody:<init>	([B[BJJJJJ)V
    //   22: astore_1
    //   23: new 36	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader
    //   26: dup
    //   27: iload 8
    //   29: sipush 348
    //   32: iadd
    //   33: i2l
    //   34: invokespecial 39	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader:<init>	(J)V
    //   37: astore 12
    //   39: iload 8
    //   41: sipush 364
    //   44: iadd
    //   45: invokestatic 45	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   48: astore_0
    //   49: aload 12
    //   51: aload_0
    //   52: invokevirtual 48	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader:a	(Ljava/nio/ByteBuffer;)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 49	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadReqBody:a	(Ljava/nio/ByteBuffer;)V
    //   60: aload 5
    //   62: lload 6
    //   64: invokevirtual 54	java/io/RandomAccessFile:seek	(J)V
    //   67: iload 8
    //   69: newarray byte
    //   71: astore_1
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 58	java/io/RandomAccessFile:read	([B)I
    //   78: pop
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 62	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   84: pop
    //   85: new 64	java/net/URL
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 67	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 71	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 73	java/net/HttpURLConnection
    //   99: astore 5
    //   101: aload 5
    //   103: ldc 75
    //   105: invokevirtual 78	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 5
    //   110: iconst_1
    //   111: invokevirtual 82	java/net/HttpURLConnection:setDoInput	(Z)V
    //   114: aload 5
    //   116: iconst_1
    //   117: invokevirtual 85	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   120: aload 5
    //   122: invokevirtual 89	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   125: astore_2
    //   126: aload_2
    //   127: aload_0
    //   128: invokevirtual 93	java/nio/ByteBuffer:array	()[B
    //   131: invokevirtual 99	java/io/OutputStream:write	([B)V
    //   134: aload_2
    //   135: invokevirtual 102	java/io/OutputStream:flush	()V
    //   138: aload 5
    //   140: invokevirtual 105	java/net/HttpURLConnection:connect	()V
    //   143: aload 5
    //   145: invokevirtual 109	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   148: astore_1
    //   149: new 111	java/io/ByteArrayOutputStream
    //   152: dup
    //   153: invokespecial 112	java/io/ByteArrayOutputStream:<init>	()V
    //   156: astore 13
    //   158: bipush 25
    //   160: newarray byte
    //   162: astore_0
    //   163: aload_1
    //   164: aload_0
    //   165: invokevirtual 115	java/io/InputStream:read	([B)I
    //   168: istore 9
    //   170: iload 9
    //   172: iconst_m1
    //   173: if_icmpeq +15 -> 188
    //   176: aload 13
    //   178: aload_0
    //   179: iconst_0
    //   180: iload 9
    //   182: invokevirtual 118	java/io/ByteArrayOutputStream:write	([BII)V
    //   185: goto -22 -> 163
    //   188: aload 13
    //   190: invokevirtual 121	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: invokestatic 124	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   196: astore 12
    //   198: new 36	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader
    //   201: dup
    //   202: aload 12
    //   204: invokespecial 126	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader:<init>	(Ljava/nio/ByteBuffer;)V
    //   207: astore_0
    //   208: new 128	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody
    //   211: dup
    //   212: aload 12
    //   214: invokespecial 129	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody:<init>	(Ljava/nio/ByteBuffer;)V
    //   217: astore 12
    //   219: aload_0
    //   220: getfield 133	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadHeader:b	J
    //   223: lconst_0
    //   224: lcmp
    //   225: ifne +24 -> 249
    //   228: aload 12
    //   230: getfield 136	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody:a	I
    //   233: iconst_1
    //   234: if_icmpne +6 -> 240
    //   237: goto +16 -> 253
    //   240: aload 12
    //   242: getfield 137	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody:b	J
    //   245: lstore_3
    //   246: goto +7 -> 253
    //   249: ldc2_w 138
    //   252: lstore_3
    //   253: aload_2
    //   254: ifnull +11 -> 265
    //   257: aload_2
    //   258: invokevirtual 102	java/io/OutputStream:flush	()V
    //   261: aload_2
    //   262: invokevirtual 142	java/io/OutputStream:close	()V
    //   265: aload 13
    //   267: invokevirtual 143	java/io/ByteArrayOutputStream:flush	()V
    //   270: aload 13
    //   272: invokevirtual 144	java/io/ByteArrayOutputStream:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 145	java/io/InputStream:close	()V
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   293: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +66 -> 362
    //   299: new 156	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   306: astore_0
    //   307: aload_0
    //   308: ldc 159
    //   310: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_0
    //   315: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   318: lload 10
    //   320: lsub
    //   321: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_0
    //   326: ldc 168
    //   328: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_0
    //   333: lload_3
    //   334: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_0
    //   339: ldc 170
    //   341: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: iload 8
    //   348: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 175
    //   354: iconst_2
    //   355: aload_0
    //   356: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: lload_3
    //   363: lreturn
    //   364: astore_0
    //   365: aload_2
    //   366: astore 12
    //   368: aload 13
    //   370: astore_2
    //   371: goto +33 -> 404
    //   374: astore_0
    //   375: goto +6 -> 381
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_1
    //   381: aload_2
    //   382: astore 12
    //   384: aconst_null
    //   385: astore_2
    //   386: goto +18 -> 404
    //   389: astore_0
    //   390: goto +7 -> 397
    //   393: astore_0
    //   394: aconst_null
    //   395: astore 5
    //   397: aconst_null
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_2
    //   401: aconst_null
    //   402: astore 12
    //   404: aload 12
    //   406: ifnull +13 -> 419
    //   409: aload 12
    //   411: invokevirtual 102	java/io/OutputStream:flush	()V
    //   414: aload 12
    //   416: invokevirtual 142	java/io/OutputStream:close	()V
    //   419: aload_2
    //   420: ifnull +11 -> 431
    //   423: aload_2
    //   424: invokevirtual 143	java/io/ByteArrayOutputStream:flush	()V
    //   427: aload_2
    //   428: invokevirtual 144	java/io/ByteArrayOutputStream:close	()V
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 145	java/io/InputStream:close	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   449: goto +5 -> 454
    //   452: aload_0
    //   453: athrow
    //   454: goto -2 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramArrayOfByte1	byte[]
    //   0	457	1	paramArrayOfByte2	byte[]
    //   0	457	2	paramString	String
    //   0	457	3	paramLong1	long
    //   0	457	5	paramRandomAccessFile	java.io.RandomAccessFile
    //   0	457	6	paramLong2	long
    //   0	457	8	paramInt	int
    //   168	13	9	i	int
    //   3	316	10	l	long
    //   37	378	12	localObject	Object
    //   156	213	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   158	163	364	finally
    //   163	170	364	finally
    //   176	185	364	finally
    //   188	237	364	finally
    //   240	246	364	finally
    //   149	158	374	finally
    //   126	149	378	finally
    //   101	126	389	finally
    //   5	101	393	finally
  }
  
  /* Error */
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(android.os.Bundle paramBundle, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: ldc 190
    //   8: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 10
    //   13: aload_0
    //   14: ldc 198
    //   16: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 11
    //   21: aload_0
    //   22: ldc 200
    //   24: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 12
    //   29: aload_0
    //   30: ldc 202
    //   32: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 9
    //   37: aload_0
    //   38: ldc 204
    //   40: invokevirtual 196	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 8
    //   45: aload_0
    //   46: ldc 206
    //   48: iconst_1
    //   49: invokevirtual 210	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   52: istore_3
    //   53: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +97 -> 153
    //   59: new 156	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   66: astore_0
    //   67: aload_0
    //   68: ldc 212
    //   70: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: aload 10
    //   77: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: ldc 214
    //   84: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: aload 11
    //   91: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_0
    //   96: ldc 216
    //   98: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: aload 12
    //   105: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: ldc 218
    //   112: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: aload 9
    //   119: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_0
    //   124: ldc 220
    //   126: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: aload 9
    //   133: invokestatic 226	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   136: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: ldc 175
    //   142: iconst_2
    //   143: aload_0
    //   144: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: goto +3 -> 153
    //   153: aload 9
    //   155: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +863 -> 1021
    //   161: aload 9
    //   163: invokestatic 236	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   166: ifne +6 -> 172
    //   169: goto +852 -> 1021
    //   172: new 238	org/apache/http/client/methods/HttpPost
    //   175: dup
    //   176: ldc 240
    //   178: invokespecial 241	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   181: astore 13
    //   183: aload 13
    //   185: ldc 243
    //   187: ldc 245
    //   189: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 13
    //   194: ldc 251
    //   196: ldc 253
    //   198: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 13
    //   203: ldc 255
    //   205: ldc_w 257
    //   208: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 13
    //   213: ldc_w 259
    //   216: ldc_w 261
    //   219: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 13
    //   224: ldc_w 263
    //   227: ldc_w 265
    //   230: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: new 156	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   240: astore_0
    //   241: aload_0
    //   242: ldc_w 267
    //   245: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_0
    //   250: aload_2
    //   251: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_0
    //   256: ldc_w 269
    //   259: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: ldc_w 271
    //   273: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_0
    //   278: aload_1
    //   279: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 13
    //   285: ldc_w 273
    //   288: aload_0
    //   289: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 13
    //   297: ldc_w 275
    //   300: ldc_w 277
    //   303: invokevirtual 249	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: new 279	java/util/ArrayList
    //   309: dup
    //   310: invokespecial 280	java/util/ArrayList:<init>	()V
    //   313: astore_1
    //   314: iload_3
    //   315: iconst_1
    //   316: if_icmpne +10 -> 326
    //   319: ldc_w 282
    //   322: astore_0
    //   323: goto +7 -> 330
    //   326: ldc_w 284
    //   329: astore_0
    //   330: aload_1
    //   331: new 286	org/apache/http/message/BasicNameValuePair
    //   334: dup
    //   335: ldc_w 288
    //   338: aload_0
    //   339: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: invokeinterface 296 2 0
    //   347: pop
    //   348: aload_1
    //   349: new 286	org/apache/http/message/BasicNameValuePair
    //   352: dup
    //   353: ldc 190
    //   355: aload 10
    //   357: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: invokeinterface 296 2 0
    //   365: pop
    //   366: aload_1
    //   367: new 286	org/apache/http/message/BasicNameValuePair
    //   370: dup
    //   371: ldc 198
    //   373: aload 11
    //   375: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: invokeinterface 296 2 0
    //   383: pop
    //   384: aload_1
    //   385: new 286	org/apache/http/message/BasicNameValuePair
    //   388: dup
    //   389: ldc 200
    //   391: aload 12
    //   393: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: invokeinterface 296 2 0
    //   401: pop
    //   402: aload_1
    //   403: new 286	org/apache/http/message/BasicNameValuePair
    //   406: dup
    //   407: ldc_w 298
    //   410: aload 9
    //   412: invokestatic 226	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   415: invokestatic 302	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   418: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: invokeinterface 296 2 0
    //   426: pop
    //   427: aload_1
    //   428: new 286	org/apache/http/message/BasicNameValuePair
    //   431: dup
    //   432: ldc_w 304
    //   435: aload 9
    //   437: invokestatic 309	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   440: invokestatic 315	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   443: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: invokeinterface 296 2 0
    //   451: pop
    //   452: aload_1
    //   453: new 286	org/apache/http/message/BasicNameValuePair
    //   456: dup
    //   457: ldc_w 317
    //   460: aload 9
    //   462: invokestatic 320	com/tencent/mobileqq/filemanager/util/FileManagerUtil:g	(Ljava/lang/String;)[B
    //   465: invokestatic 315	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   468: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: invokeinterface 296 2 0
    //   476: pop
    //   477: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +40 -> 520
    //   483: new 156	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   490: astore_0
    //   491: aload_0
    //   492: ldc_w 322
    //   495: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload_0
    //   500: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   503: lload 6
    //   505: lsub
    //   506: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 175
    //   512: iconst_2
    //   513: aload_0
    //   514: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_1
    //   521: new 286	org/apache/http/message/BasicNameValuePair
    //   524: dup
    //   525: ldc_w 324
    //   528: ldc_w 326
    //   531: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: invokeinterface 296 2 0
    //   539: pop
    //   540: aload_1
    //   541: new 286	org/apache/http/message/BasicNameValuePair
    //   544: dup
    //   545: ldc_w 328
    //   548: aload_2
    //   549: invokestatic 330	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   552: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   555: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: invokeinterface 296 2 0
    //   563: pop
    //   564: aload_1
    //   565: new 286	org/apache/http/message/BasicNameValuePair
    //   568: dup
    //   569: ldc_w 335
    //   572: ldc_w 337
    //   575: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: invokeinterface 296 2 0
    //   583: pop
    //   584: aload 8
    //   586: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   589: ifne +41 -> 630
    //   592: aload_1
    //   593: new 286	org/apache/http/message/BasicNameValuePair
    //   596: dup
    //   597: ldc 204
    //   599: aload 8
    //   601: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: invokeinterface 296 2 0
    //   609: pop
    //   610: aload_1
    //   611: new 286	org/apache/http/message/BasicNameValuePair
    //   614: dup
    //   615: ldc_w 339
    //   618: ldc_w 341
    //   621: invokespecial 290	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: invokeinterface 296 2 0
    //   629: pop
    //   630: aload 13
    //   632: new 343	org/apache/http/client/entity/UrlEncodedFormEntity
    //   635: dup
    //   636: aload_1
    //   637: ldc_w 345
    //   640: invokespecial 348	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   643: invokevirtual 352	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   646: new 354	org/apache/http/impl/client/DefaultHttpClient
    //   649: dup
    //   650: invokespecial 355	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   653: aload 13
    //   655: invokevirtual 359	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   658: astore_0
    //   659: aload_0
    //   660: invokeinterface 365 1 0
    //   665: invokeinterface 370 1 0
    //   670: sipush 200
    //   673: if_icmpne +231 -> 904
    //   676: aload_0
    //   677: ldc_w 372
    //   680: invokeinterface 376 2 0
    //   685: astore_1
    //   686: aload_1
    //   687: arraylength
    //   688: istore 5
    //   690: iconst_0
    //   691: istore_3
    //   692: iconst_0
    //   693: istore 4
    //   695: iload_3
    //   696: iload 5
    //   698: if_icmpge +26 -> 724
    //   701: aload_1
    //   702: iload_3
    //   703: aaload
    //   704: invokeinterface 381 1 0
    //   709: ldc_w 383
    //   712: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +361 -> 1076
    //   718: iconst_1
    //   719: istore 4
    //   721: goto +355 -> 1076
    //   724: aload_0
    //   725: invokeinterface 390 1 0
    //   730: astore_0
    //   731: iload 4
    //   733: ifeq +30 -> 763
    //   736: new 392	java/util/zip/GZIPInputStream
    //   739: dup
    //   740: aload_0
    //   741: invokeinterface 397 1 0
    //   746: invokespecial 400	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   749: astore_0
    //   750: aload_0
    //   751: astore_2
    //   752: aload_0
    //   753: astore_1
    //   754: aload_0
    //   755: invokestatic 405	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   758: astore 8
    //   760: goto +11 -> 771
    //   763: aload_0
    //   764: invokestatic 410	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   767: astore 8
    //   769: aconst_null
    //   770: astore_0
    //   771: aload_0
    //   772: astore_2
    //   773: aload_0
    //   774: astore_1
    //   775: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   778: ifeq +56 -> 834
    //   781: aload_0
    //   782: astore_2
    //   783: aload_0
    //   784: astore_1
    //   785: new 156	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   792: astore 9
    //   794: aload_0
    //   795: astore_2
    //   796: aload_0
    //   797: astore_1
    //   798: aload 9
    //   800: ldc_w 412
    //   803: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload_0
    //   808: astore_2
    //   809: aload_0
    //   810: astore_1
    //   811: aload 9
    //   813: aload 8
    //   815: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload_0
    //   820: astore_2
    //   821: aload_0
    //   822: astore_1
    //   823: ldc 175
    //   825: iconst_2
    //   826: aload 9
    //   828: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_0
    //   835: astore_2
    //   836: aload_0
    //   837: astore_1
    //   838: new 414	org/json/JSONObject
    //   841: dup
    //   842: aload 8
    //   844: invokespecial 415	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   847: astore 9
    //   849: aload_0
    //   850: astore_2
    //   851: aload_0
    //   852: astore 8
    //   854: aload_0
    //   855: astore_1
    //   856: aload 9
    //   858: ldc_w 417
    //   861: iconst_m1
    //   862: invokevirtual 420	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   865: ifne +42 -> 907
    //   868: aload_0
    //   869: astore_2
    //   870: aload_0
    //   871: astore_1
    //   872: new 422	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp
    //   875: dup
    //   876: aload 9
    //   878: ldc_w 424
    //   881: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   884: invokespecial 431	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:<init>	(Lorg/json/JSONObject;)V
    //   887: astore 8
    //   889: aload 8
    //   891: astore_1
    //   892: aload_0
    //   893: astore 8
    //   895: aload_1
    //   896: astore_0
    //   897: goto +12 -> 909
    //   900: astore_0
    //   901: goto +34 -> 935
    //   904: aconst_null
    //   905: astore 8
    //   907: aconst_null
    //   908: astore_0
    //   909: aload_0
    //   910: astore_1
    //   911: aload 8
    //   913: ifnull +52 -> 965
    //   916: aload 8
    //   918: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   921: aload_0
    //   922: astore_1
    //   923: goto +42 -> 965
    //   926: astore_0
    //   927: aconst_null
    //   928: astore_1
    //   929: goto +82 -> 1011
    //   932: astore_0
    //   933: aconst_null
    //   934: astore_2
    //   935: aload_2
    //   936: astore_1
    //   937: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq +15 -> 955
    //   943: aload_2
    //   944: astore_1
    //   945: ldc 175
    //   947: iconst_2
    //   948: aload_0
    //   949: invokestatic 436	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   952: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aload_2
    //   956: ifnull +7 -> 963
    //   959: aload_2
    //   960: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   963: aconst_null
    //   964: astore_1
    //   965: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: ifeq +40 -> 1008
    //   971: new 156	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   978: astore_0
    //   979: aload_0
    //   980: ldc_w 438
    //   983: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload_0
    //   988: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   991: lload 6
    //   993: lsub
    //   994: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: ldc 175
    //   1000: iconst_2
    //   1001: aload_0
    //   1002: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: aload_1
    //   1009: areturn
    //   1010: astore_0
    //   1011: aload_1
    //   1012: ifnull +7 -> 1019
    //   1015: aload_1
    //   1016: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   1019: aload_0
    //   1020: athrow
    //   1021: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1024: ifeq +36 -> 1060
    //   1027: new 156	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1034: astore_0
    //   1035: aload_0
    //   1036: ldc_w 440
    //   1039: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload_0
    //   1044: aload 9
    //   1046: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: ldc 175
    //   1052: iconst_2
    //   1053: aload_0
    //   1054: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: aconst_null
    //   1061: areturn
    //   1062: astore_1
    //   1063: aload_0
    //   1064: astore_1
    //   1065: goto -100 -> 965
    //   1068: astore_0
    //   1069: goto -106 -> 963
    //   1072: astore_1
    //   1073: goto -54 -> 1019
    //   1076: iload_3
    //   1077: iconst_1
    //   1078: iadd
    //   1079: istore_3
    //   1080: goto -385 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1083	0	paramBundle	android.os.Bundle
    //   0	1083	1	paramString1	String
    //   0	1083	2	paramString2	String
    //   52	1028	3	i	int
    //   693	39	4	j	int
    //   688	11	5	k	int
    //   3	989	6	l	long
    //   43	874	8	localObject1	Object
    //   35	1010	9	localObject2	Object
    //   11	345	10	str1	String
    //   19	355	11	str2	String
    //   27	365	12	str3	String
    //   181	473	13	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   754	760	900	java/lang/Exception
    //   775	781	900	java/lang/Exception
    //   785	794	900	java/lang/Exception
    //   798	807	900	java/lang/Exception
    //   811	819	900	java/lang/Exception
    //   823	834	900	java/lang/Exception
    //   838	849	900	java/lang/Exception
    //   856	868	900	java/lang/Exception
    //   872	889	900	java/lang/Exception
    //   630	690	926	finally
    //   701	718	926	finally
    //   724	731	926	finally
    //   736	750	926	finally
    //   763	769	926	finally
    //   630	690	932	java/lang/Exception
    //   701	718	932	java/lang/Exception
    //   724	731	932	java/lang/Exception
    //   736	750	932	java/lang/Exception
    //   763	769	932	java/lang/Exception
    //   754	760	1010	finally
    //   775	781	1010	finally
    //   785	794	1010	finally
    //   798	807	1010	finally
    //   811	819	1010	finally
    //   823	834	1010	finally
    //   838	849	1010	finally
    //   856	868	1010	finally
    //   872	889	1010	finally
    //   937	943	1010	finally
    //   945	955	1010	finally
    //   916	921	1062	java/io/IOException
    //   959	963	1068	java/io/IOException
    //   1015	1019	1072	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil
 * JD-Core Version:    0.7.0.1
 */