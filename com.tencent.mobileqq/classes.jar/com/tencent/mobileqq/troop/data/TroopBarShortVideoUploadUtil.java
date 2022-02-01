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
    //   230: getfield 136	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody:jdField_a_of_type_Int	I
    //   233: iconst_1
    //   234: if_icmpne +6 -> 240
    //   237: goto +16 -> 253
    //   240: aload 12
    //   242: getfield 138	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$UploadRspBody:jdField_a_of_type_Long	J
    //   245: lstore_3
    //   246: goto +7 -> 253
    //   249: ldc2_w 139
    //   252: lstore_3
    //   253: aload_2
    //   254: ifnull +11 -> 265
    //   257: aload_2
    //   258: invokevirtual 102	java/io/OutputStream:flush	()V
    //   261: aload_2
    //   262: invokevirtual 143	java/io/OutputStream:close	()V
    //   265: aload 13
    //   267: invokevirtual 144	java/io/ByteArrayOutputStream:flush	()V
    //   270: aload 13
    //   272: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 146	java/io/InputStream:close	()V
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   293: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +66 -> 362
    //   299: new 157	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   306: astore_0
    //   307: aload_0
    //   308: ldc 160
    //   310: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_0
    //   315: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   318: lload 10
    //   320: lsub
    //   321: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_0
    //   326: ldc 169
    //   328: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_0
    //   333: lload_3
    //   334: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_0
    //   339: ldc 171
    //   341: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: iload 8
    //   348: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 176
    //   354: iconst_2
    //   355: aload_0
    //   356: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   416: invokevirtual 143	java/io/OutputStream:close	()V
    //   419: aload_2
    //   420: ifnull +11 -> 431
    //   423: aload_2
    //   424: invokevirtual 144	java/io/ByteArrayOutputStream:flush	()V
    //   427: aload_2
    //   428: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 146	java/io/InputStream:close	()V
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
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
    //   6: ldc 191
    //   8: invokevirtual 197	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 10
    //   13: aload_0
    //   14: ldc 199
    //   16: invokevirtual 197	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 11
    //   21: aload_0
    //   22: ldc 201
    //   24: invokevirtual 197	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 12
    //   29: aload_0
    //   30: ldc 203
    //   32: invokevirtual 197	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 9
    //   37: aload_0
    //   38: ldc 205
    //   40: invokevirtual 197	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 8
    //   45: aload_0
    //   46: ldc 207
    //   48: iconst_1
    //   49: invokevirtual 211	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   52: istore_3
    //   53: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +97 -> 153
    //   59: new 157	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   66: astore_0
    //   67: aload_0
    //   68: ldc 213
    //   70: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: aload 10
    //   77: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: ldc 215
    //   84: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: aload 11
    //   91: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_0
    //   96: ldc 217
    //   98: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: aload 12
    //   105: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: ldc 219
    //   112: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: aload 9
    //   119: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_0
    //   124: ldc 221
    //   126: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: aload 9
    //   133: invokestatic 227	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   136: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: ldc 176
    //   142: iconst_2
    //   143: aload_0
    //   144: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: goto +3 -> 153
    //   153: aload 9
    //   155: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +864 -> 1022
    //   161: aload 9
    //   163: invokestatic 237	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   166: ifne +6 -> 172
    //   169: goto +853 -> 1022
    //   172: new 239	org/apache/http/client/methods/HttpPost
    //   175: dup
    //   176: ldc 241
    //   178: invokespecial 242	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   181: astore 13
    //   183: aload 13
    //   185: ldc 244
    //   187: ldc 246
    //   189: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 13
    //   194: ldc 252
    //   196: ldc 254
    //   198: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 13
    //   203: ldc_w 256
    //   206: ldc_w 258
    //   209: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 13
    //   214: ldc_w 260
    //   217: ldc_w 262
    //   220: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 13
    //   225: ldc_w 264
    //   228: ldc_w 266
    //   231: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: new 157	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   241: astore_0
    //   242: aload_0
    //   243: ldc_w 268
    //   246: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: aload_2
    //   252: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_0
    //   257: ldc_w 270
    //   260: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: aload_1
    //   266: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_0
    //   271: ldc_w 272
    //   274: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 13
    //   286: ldc_w 274
    //   289: aload_0
    //   290: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 13
    //   298: ldc_w 276
    //   301: ldc_w 278
    //   304: invokevirtual 250	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: new 280	java/util/ArrayList
    //   310: dup
    //   311: invokespecial 281	java/util/ArrayList:<init>	()V
    //   314: astore_1
    //   315: iload_3
    //   316: iconst_1
    //   317: if_icmpne +10 -> 327
    //   320: ldc_w 283
    //   323: astore_0
    //   324: goto +7 -> 331
    //   327: ldc_w 285
    //   330: astore_0
    //   331: aload_1
    //   332: new 287	org/apache/http/message/BasicNameValuePair
    //   335: dup
    //   336: ldc_w 289
    //   339: aload_0
    //   340: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: invokeinterface 297 2 0
    //   348: pop
    //   349: aload_1
    //   350: new 287	org/apache/http/message/BasicNameValuePair
    //   353: dup
    //   354: ldc 191
    //   356: aload 10
    //   358: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: invokeinterface 297 2 0
    //   366: pop
    //   367: aload_1
    //   368: new 287	org/apache/http/message/BasicNameValuePair
    //   371: dup
    //   372: ldc 199
    //   374: aload 11
    //   376: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: invokeinterface 297 2 0
    //   384: pop
    //   385: aload_1
    //   386: new 287	org/apache/http/message/BasicNameValuePair
    //   389: dup
    //   390: ldc 201
    //   392: aload 12
    //   394: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: invokeinterface 297 2 0
    //   402: pop
    //   403: aload_1
    //   404: new 287	org/apache/http/message/BasicNameValuePair
    //   407: dup
    //   408: ldc_w 299
    //   411: aload 9
    //   413: invokestatic 227	com/tencent/mobileqq/utils/FileUtils:getFileSizes	(Ljava/lang/String;)J
    //   416: invokestatic 303	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   419: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: invokeinterface 297 2 0
    //   427: pop
    //   428: aload_1
    //   429: new 287	org/apache/http/message/BasicNameValuePair
    //   432: dup
    //   433: ldc_w 305
    //   436: aload 9
    //   438: invokestatic 310	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   441: invokestatic 316	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   444: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: invokeinterface 297 2 0
    //   452: pop
    //   453: aload_1
    //   454: new 287	org/apache/http/message/BasicNameValuePair
    //   457: dup
    //   458: ldc_w 318
    //   461: aload 9
    //   463: invokestatic 320	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)[B
    //   466: invokestatic 316	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   469: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: invokeinterface 297 2 0
    //   477: pop
    //   478: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +40 -> 521
    //   484: new 157	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   491: astore_0
    //   492: aload_0
    //   493: ldc_w 322
    //   496: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   504: lload 6
    //   506: lsub
    //   507: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: ldc 176
    //   513: iconst_2
    //   514: aload_0
    //   515: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_1
    //   522: new 287	org/apache/http/message/BasicNameValuePair
    //   525: dup
    //   526: ldc_w 324
    //   529: ldc_w 326
    //   532: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: invokeinterface 297 2 0
    //   540: pop
    //   541: aload_1
    //   542: new 287	org/apache/http/message/BasicNameValuePair
    //   545: dup
    //   546: ldc_w 328
    //   549: aload_2
    //   550: invokestatic 330	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Ljava/lang/String;)I
    //   553: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   556: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: invokeinterface 297 2 0
    //   564: pop
    //   565: aload_1
    //   566: new 287	org/apache/http/message/BasicNameValuePair
    //   569: dup
    //   570: ldc_w 335
    //   573: ldc_w 337
    //   576: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: invokeinterface 297 2 0
    //   584: pop
    //   585: aload 8
    //   587: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   590: ifne +41 -> 631
    //   593: aload_1
    //   594: new 287	org/apache/http/message/BasicNameValuePair
    //   597: dup
    //   598: ldc 205
    //   600: aload 8
    //   602: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: invokeinterface 297 2 0
    //   610: pop
    //   611: aload_1
    //   612: new 287	org/apache/http/message/BasicNameValuePair
    //   615: dup
    //   616: ldc_w 339
    //   619: ldc_w 341
    //   622: invokespecial 291	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: invokeinterface 297 2 0
    //   630: pop
    //   631: aload 13
    //   633: new 343	org/apache/http/client/entity/UrlEncodedFormEntity
    //   636: dup
    //   637: aload_1
    //   638: ldc_w 345
    //   641: invokespecial 348	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   644: invokevirtual 352	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   647: new 354	org/apache/http/impl/client/DefaultHttpClient
    //   650: dup
    //   651: invokespecial 355	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   654: aload 13
    //   656: invokevirtual 359	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   659: astore_0
    //   660: aload_0
    //   661: invokeinterface 365 1 0
    //   666: invokeinterface 370 1 0
    //   671: sipush 200
    //   674: if_icmpne +231 -> 905
    //   677: aload_0
    //   678: ldc_w 372
    //   681: invokeinterface 376 2 0
    //   686: astore_1
    //   687: aload_1
    //   688: arraylength
    //   689: istore 5
    //   691: iconst_0
    //   692: istore_3
    //   693: iconst_0
    //   694: istore 4
    //   696: iload_3
    //   697: iload 5
    //   699: if_icmpge +26 -> 725
    //   702: aload_1
    //   703: iload_3
    //   704: aaload
    //   705: invokeinterface 381 1 0
    //   710: ldc_w 383
    //   713: invokevirtual 386	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   716: ifeq +361 -> 1077
    //   719: iconst_1
    //   720: istore 4
    //   722: goto +355 -> 1077
    //   725: aload_0
    //   726: invokeinterface 390 1 0
    //   731: astore_0
    //   732: iload 4
    //   734: ifeq +30 -> 764
    //   737: new 392	java/util/zip/GZIPInputStream
    //   740: dup
    //   741: aload_0
    //   742: invokeinterface 397 1 0
    //   747: invokespecial 400	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   750: astore_0
    //   751: aload_0
    //   752: astore_2
    //   753: aload_0
    //   754: astore_1
    //   755: aload_0
    //   756: invokestatic 405	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   759: astore 8
    //   761: goto +11 -> 772
    //   764: aload_0
    //   765: invokestatic 410	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   768: astore 8
    //   770: aconst_null
    //   771: astore_0
    //   772: aload_0
    //   773: astore_2
    //   774: aload_0
    //   775: astore_1
    //   776: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +56 -> 835
    //   782: aload_0
    //   783: astore_2
    //   784: aload_0
    //   785: astore_1
    //   786: new 157	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   793: astore 9
    //   795: aload_0
    //   796: astore_2
    //   797: aload_0
    //   798: astore_1
    //   799: aload 9
    //   801: ldc_w 412
    //   804: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload_0
    //   809: astore_2
    //   810: aload_0
    //   811: astore_1
    //   812: aload 9
    //   814: aload 8
    //   816: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload_0
    //   821: astore_2
    //   822: aload_0
    //   823: astore_1
    //   824: ldc 176
    //   826: iconst_2
    //   827: aload 9
    //   829: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload_0
    //   836: astore_2
    //   837: aload_0
    //   838: astore_1
    //   839: new 414	org/json/JSONObject
    //   842: dup
    //   843: aload 8
    //   845: invokespecial 415	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   848: astore 9
    //   850: aload_0
    //   851: astore_2
    //   852: aload_0
    //   853: astore 8
    //   855: aload_0
    //   856: astore_1
    //   857: aload 9
    //   859: ldc_w 417
    //   862: iconst_m1
    //   863: invokevirtual 420	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   866: ifne +42 -> 908
    //   869: aload_0
    //   870: astore_2
    //   871: aload_0
    //   872: astore_1
    //   873: new 422	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp
    //   876: dup
    //   877: aload 9
    //   879: ldc_w 424
    //   882: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   885: invokespecial 431	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:<init>	(Lorg/json/JSONObject;)V
    //   888: astore 8
    //   890: aload 8
    //   892: astore_1
    //   893: aload_0
    //   894: astore 8
    //   896: aload_1
    //   897: astore_0
    //   898: goto +12 -> 910
    //   901: astore_0
    //   902: goto +34 -> 936
    //   905: aconst_null
    //   906: astore 8
    //   908: aconst_null
    //   909: astore_0
    //   910: aload_0
    //   911: astore_1
    //   912: aload 8
    //   914: ifnull +52 -> 966
    //   917: aload 8
    //   919: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   922: aload_0
    //   923: astore_1
    //   924: goto +42 -> 966
    //   927: astore_0
    //   928: aconst_null
    //   929: astore_1
    //   930: goto +82 -> 1012
    //   933: astore_0
    //   934: aconst_null
    //   935: astore_2
    //   936: aload_2
    //   937: astore_1
    //   938: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   941: ifeq +15 -> 956
    //   944: aload_2
    //   945: astore_1
    //   946: ldc 176
    //   948: iconst_2
    //   949: aload_0
    //   950: invokestatic 436	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   953: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   956: aload_2
    //   957: ifnull +7 -> 964
    //   960: aload_2
    //   961: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   964: aconst_null
    //   965: astore_1
    //   966: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   969: ifeq +40 -> 1009
    //   972: new 157	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   979: astore_0
    //   980: aload_0
    //   981: ldc_w 438
    //   984: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_0
    //   989: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   992: lload 6
    //   994: lsub
    //   995: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: ldc 176
    //   1001: iconst_2
    //   1002: aload_0
    //   1003: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: aload_1
    //   1010: areturn
    //   1011: astore_0
    //   1012: aload_1
    //   1013: ifnull +7 -> 1020
    //   1016: aload_1
    //   1017: invokevirtual 432	java/util/zip/GZIPInputStream:close	()V
    //   1020: aload_0
    //   1021: athrow
    //   1022: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1025: ifeq +36 -> 1061
    //   1028: new 157	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1035: astore_0
    //   1036: aload_0
    //   1037: ldc_w 440
    //   1040: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: aload_0
    //   1045: aload 9
    //   1047: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: ldc 176
    //   1053: iconst_2
    //   1054: aload_0
    //   1055: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokestatic 443	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1061: aconst_null
    //   1062: areturn
    //   1063: astore_1
    //   1064: aload_0
    //   1065: astore_1
    //   1066: goto -100 -> 966
    //   1069: astore_0
    //   1070: goto -106 -> 964
    //   1073: astore_1
    //   1074: goto -54 -> 1020
    //   1077: iload_3
    //   1078: iconst_1
    //   1079: iadd
    //   1080: istore_3
    //   1081: goto -385 -> 696
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1084	0	paramBundle	android.os.Bundle
    //   0	1084	1	paramString1	String
    //   0	1084	2	paramString2	String
    //   52	1029	3	i	int
    //   694	39	4	j	int
    //   689	11	5	k	int
    //   3	990	6	l	long
    //   43	875	8	localObject1	Object
    //   35	1011	9	localObject2	Object
    //   11	346	10	str1	String
    //   19	356	11	str2	String
    //   27	366	12	str3	String
    //   181	474	13	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   755	761	901	java/lang/Exception
    //   776	782	901	java/lang/Exception
    //   786	795	901	java/lang/Exception
    //   799	808	901	java/lang/Exception
    //   812	820	901	java/lang/Exception
    //   824	835	901	java/lang/Exception
    //   839	850	901	java/lang/Exception
    //   857	869	901	java/lang/Exception
    //   873	890	901	java/lang/Exception
    //   631	691	927	finally
    //   702	719	927	finally
    //   725	732	927	finally
    //   737	751	927	finally
    //   764	770	927	finally
    //   631	691	933	java/lang/Exception
    //   702	719	933	java/lang/Exception
    //   725	732	933	java/lang/Exception
    //   737	751	933	java/lang/Exception
    //   764	770	933	java/lang/Exception
    //   755	761	1011	finally
    //   776	782	1011	finally
    //   786	795	1011	finally
    //   799	808	1011	finally
    //   812	820	1011	finally
    //   824	835	1011	finally
    //   839	850	1011	finally
    //   857	869	1011	finally
    //   873	890	1011	finally
    //   938	944	1011	finally
    //   946	956	1011	finally
    //   917	922	1063	java/io/IOException
    //   960	964	1069	java/io/IOException
    //   1016	1020	1073	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil
 * JD-Core Version:    0.7.0.1
 */