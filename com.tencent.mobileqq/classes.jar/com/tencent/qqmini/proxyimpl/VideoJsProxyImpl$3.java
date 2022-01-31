package com.tencent.qqmini.proxyimpl;

import android.content.BroadcastReceiver;

class VideoJsProxyImpl$3
  extends BroadcastReceiver
{
  VideoJsProxyImpl$3(VideoJsProxyImpl paramVideoJsProxyImpl) {}
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 6
    //   8: aload_0
    //   9: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   12: invokestatic 24	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$400	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;)Z
    //   15: ifne +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   23: iconst_0
    //   24: invokestatic 28	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$402	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Z)Z
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 34	android/content/Intent:getAction	()Ljava/lang/String;
    //   32: astore 8
    //   34: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +23 -> 60
    //   40: ldc 42
    //   42: iconst_2
    //   43: ldc 44
    //   45: iconst_1
    //   46: anewarray 46	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload 8
    //   53: aastore
    //   54: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 58
    //   62: aload 8
    //   64: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq -49 -> 18
    //   70: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +17 -> 90
    //   76: ldc 42
    //   78: iconst_2
    //   79: iconst_1
    //   80: anewarray 46	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_2
    //   86: aastore
    //   87: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: ldc 67
    //   93: invokevirtual 71	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   96: checkcast 73	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   99: astore 11
    //   101: aload 11
    //   103: ifnonnull +21 -> 124
    //   106: aload_0
    //   107: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   110: aload_0
    //   111: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   114: invokestatic 77	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$500	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;)I
    //   117: ldc 79
    //   119: aconst_null
    //   120: invokestatic 83	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$600	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   123: return
    //   124: iload 5
    //   126: istore 4
    //   128: getstatic 89	android/os/Build$VERSION:SDK_INT	I
    //   131: bipush 15
    //   133: if_icmple +105 -> 238
    //   136: new 91	java/io/FileInputStream
    //   139: dup
    //   140: aload 11
    //   142: getfield 95	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   145: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   148: astore 8
    //   150: new 100	android/media/MediaExtractor
    //   153: dup
    //   154: invokespecial 101	android/media/MediaExtractor:<init>	()V
    //   157: astore 9
    //   159: aload 9
    //   161: aload 8
    //   163: invokevirtual 105	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   166: invokevirtual 109	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   169: aload 9
    //   171: invokestatic 113	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   174: istore 4
    //   176: iload 6
    //   178: istore_3
    //   179: iload 4
    //   181: iconst_m1
    //   182: if_icmple +30 -> 212
    //   185: aload 9
    //   187: iload 4
    //   189: invokevirtual 117	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   192: astore_1
    //   193: iload 6
    //   195: istore_3
    //   196: aload_1
    //   197: ldc 119
    //   199: invokevirtual 125	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   202: ifeq +10 -> 212
    //   205: aload_1
    //   206: ldc 119
    //   208: invokevirtual 129	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   211: istore_3
    //   212: aload 8
    //   214: ifnull +8 -> 222
    //   217: aload 8
    //   219: invokevirtual 132	java/io/FileInputStream:close	()V
    //   222: iload_3
    //   223: istore 4
    //   225: aload 9
    //   227: ifnull +11 -> 238
    //   230: aload 9
    //   232: invokevirtual 135	android/media/MediaExtractor:release	()V
    //   235: iload_3
    //   236: istore 4
    //   238: ldc 42
    //   240: iconst_2
    //   241: new 137	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   248: ldc 140
    //   250: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: iload 4
    //   266: bipush 90
    //   268: if_icmpeq +11 -> 279
    //   271: iload 4
    //   273: sipush 270
    //   276: if_icmpne +25 -> 301
    //   279: aload 11
    //   281: getfield 156	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   284: istore_3
    //   285: aload 11
    //   287: aload 11
    //   289: getfield 159	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   292: putfield 156	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   295: aload 11
    //   297: iload_3
    //   298: putfield 159	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   301: ldc 161
    //   303: aload_2
    //   304: ldc 163
    //   306: invokevirtual 167	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: istore 7
    //   314: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +29 -> 346
    //   320: ldc 42
    //   322: iconst_2
    //   323: new 137	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   330: ldc 169
    //   332: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 7
    //   337: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   340: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: iload 7
    //   348: ifeq +84 -> 432
    //   351: aload_0
    //   352: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   355: aload 11
    //   357: iconst_1
    //   358: invokestatic 176	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$700	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   361: return
    //   362: astore 9
    //   364: aconst_null
    //   365: astore 8
    //   367: ldc 42
    //   369: iconst_1
    //   370: ldc 178
    //   372: aload 9
    //   374: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: aload 8
    //   379: ifnull +8 -> 387
    //   382: aload 8
    //   384: invokevirtual 132	java/io/FileInputStream:close	()V
    //   387: iload 5
    //   389: istore 4
    //   391: aload_1
    //   392: ifnull -154 -> 238
    //   395: aload_1
    //   396: invokevirtual 135	android/media/MediaExtractor:release	()V
    //   399: iload 5
    //   401: istore 4
    //   403: goto -165 -> 238
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 8
    //   410: aconst_null
    //   411: astore_2
    //   412: aload 8
    //   414: ifnull +8 -> 422
    //   417: aload 8
    //   419: invokevirtual 132	java/io/FileInputStream:close	()V
    //   422: aload_2
    //   423: ifnull +7 -> 430
    //   426: aload_2
    //   427: invokevirtual 135	android/media/MediaExtractor:release	()V
    //   430: aload_1
    //   431: athrow
    //   432: aload 11
    //   434: getfield 95	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   437: astore_1
    //   438: invokestatic 188	bgjm:a	()Lbgjm;
    //   441: aload_1
    //   442: invokevirtual 191	bgjm:e	(Ljava/lang/String;)Ljava/lang/String;
    //   445: astore_1
    //   446: aload_0
    //   447: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:this$0	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   450: aload_1
    //   451: aload 11
    //   453: getfield 195	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   456: aload 11
    //   458: invokestatic 199	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:access$800	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   461: return
    //   462: astore_1
    //   463: goto -241 -> 222
    //   466: astore 8
    //   468: goto -81 -> 387
    //   471: astore 8
    //   473: goto -51 -> 422
    //   476: astore_1
    //   477: aconst_null
    //   478: astore_2
    //   479: goto -67 -> 412
    //   482: astore_1
    //   483: aload 9
    //   485: astore_2
    //   486: goto -74 -> 412
    //   489: astore 9
    //   491: aload_1
    //   492: astore_2
    //   493: aload 9
    //   495: astore_1
    //   496: goto -84 -> 412
    //   499: astore 9
    //   501: goto -134 -> 367
    //   504: astore 10
    //   506: aload 9
    //   508: astore_1
    //   509: aload 10
    //   511: astore 9
    //   513: goto -146 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	3
    //   0	516	1	paramContext	android.content.Context
    //   0	516	2	paramIntent	android.content.Intent
    //   178	120	3	i	int
    //   126	276	4	j	int
    //   3	397	5	k	int
    //   6	188	6	m	int
    //   312	35	7	bool	boolean
    //   32	386	8	localObject1	java.lang.Object
    //   466	1	8	localIOException1	java.io.IOException
    //   471	1	8	localIOException2	java.io.IOException
    //   157	74	9	localMediaExtractor	android.media.MediaExtractor
    //   362	122	9	localIOException3	java.io.IOException
    //   489	5	9	localObject2	java.lang.Object
    //   499	8	9	localIOException4	java.io.IOException
    //   511	1	9	localObject3	java.lang.Object
    //   504	6	10	localIOException5	java.io.IOException
    //   99	358	11	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   136	150	362	java/io/IOException
    //   136	150	406	finally
    //   217	222	462	java/io/IOException
    //   382	387	466	java/io/IOException
    //   417	422	471	java/io/IOException
    //   150	159	476	finally
    //   159	176	482	finally
    //   185	193	482	finally
    //   196	212	482	finally
    //   367	377	489	finally
    //   150	159	499	java/io/IOException
    //   159	176	504	java/io/IOException
    //   185	193	504	java/io/IOException
    //   196	212	504	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */