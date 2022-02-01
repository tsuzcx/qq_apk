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
    //   0: aload_0
    //   1: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   4: invokestatic 23	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;)Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   15: astore_1
    //   16: iconst_0
    //   17: istore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: iconst_0
    //   23: istore 6
    //   25: aload_1
    //   26: iconst_0
    //   27: invokestatic 26	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Z)Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 32	android/content/Intent:getAction	()Ljava/lang/String;
    //   35: astore_1
    //   36: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +22 -> 61
    //   42: ldc 40
    //   44: iconst_2
    //   45: ldc 42
    //   47: iconst_1
    //   48: anewarray 44	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: invokestatic 50	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: ldc 56
    //   63: aload_1
    //   64: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +447 -> 514
    //   70: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +17 -> 90
    //   76: ldc 40
    //   78: iconst_2
    //   79: iconst_1
    //   80: anewarray 44	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_2
    //   86: aastore
    //   87: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: ldc 65
    //   93: invokevirtual 69	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   96: checkcast 71	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   99: astore 12
    //   101: aconst_null
    //   102: astore 11
    //   104: aload 12
    //   106: ifnonnull +20 -> 126
    //   109: aload_0
    //   110: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   113: astore_1
    //   114: aload_1
    //   115: aload_1
    //   116: invokestatic 74	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;)I
    //   119: ldc 76
    //   121: aconst_null
    //   122: invokestatic 79	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   125: return
    //   126: iload 5
    //   128: istore_3
    //   129: getstatic 85	android/os/Build$VERSION:SDK_INT	I
    //   132: bipush 15
    //   134: if_icmple +202 -> 336
    //   137: new 87	java/io/FileInputStream
    //   140: dup
    //   141: aload 12
    //   143: getfield 91	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   146: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   149: astore 10
    //   151: new 96	android/media/MediaExtractor
    //   154: dup
    //   155: invokespecial 97	android/media/MediaExtractor:<init>	()V
    //   158: astore_1
    //   159: aload_1
    //   160: aload 10
    //   162: invokevirtual 101	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   165: invokevirtual 105	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   168: aload_1
    //   169: invokestatic 108	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Landroid/media/MediaExtractor;)I
    //   172: istore 7
    //   174: iload 6
    //   176: istore_3
    //   177: iload 7
    //   179: iconst_m1
    //   180: if_icmple +32 -> 212
    //   183: aload_1
    //   184: iload 7
    //   186: invokevirtual 112	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   189: astore 9
    //   191: iload 6
    //   193: istore_3
    //   194: aload 9
    //   196: ldc 114
    //   198: invokevirtual 120	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   201: ifeq +11 -> 212
    //   204: aload 9
    //   206: ldc 114
    //   208: invokevirtual 124	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   211: istore_3
    //   212: aload 10
    //   214: invokevirtual 127	java/io/FileInputStream:close	()V
    //   217: aload_1
    //   218: invokevirtual 130	android/media/MediaExtractor:release	()V
    //   221: goto +115 -> 336
    //   224: astore_2
    //   225: aload 10
    //   227: astore 9
    //   229: goto +84 -> 313
    //   232: astore 9
    //   234: goto +17 -> 251
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_1
    //   240: aload 10
    //   242: astore 9
    //   244: goto +69 -> 313
    //   247: astore 9
    //   249: aconst_null
    //   250: astore_1
    //   251: goto +21 -> 272
    //   254: astore_2
    //   255: aconst_null
    //   256: astore 9
    //   258: aload 9
    //   260: astore_1
    //   261: goto +52 -> 313
    //   264: astore 9
    //   266: aconst_null
    //   267: astore_1
    //   268: aload 11
    //   270: astore 10
    //   272: ldc 40
    //   274: iconst_1
    //   275: ldc 132
    //   277: aload 9
    //   279: invokestatic 136	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 10
    //   284: ifnull +11 -> 295
    //   287: aload 10
    //   289: invokevirtual 127	java/io/FileInputStream:close	()V
    //   292: goto +3 -> 295
    //   295: iload 5
    //   297: istore_3
    //   298: aload_1
    //   299: ifnull +37 -> 336
    //   302: iload 4
    //   304: istore_3
    //   305: goto -88 -> 217
    //   308: astore_2
    //   309: aload 10
    //   311: astore 9
    //   313: aload 9
    //   315: ifnull +11 -> 326
    //   318: aload 9
    //   320: invokevirtual 127	java/io/FileInputStream:close	()V
    //   323: goto +3 -> 326
    //   326: aload_1
    //   327: ifnull +7 -> 334
    //   330: aload_1
    //   331: invokevirtual 130	android/media/MediaExtractor:release	()V
    //   334: aload_2
    //   335: athrow
    //   336: new 138	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   343: astore_1
    //   344: aload_1
    //   345: ldc 141
    //   347: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_1
    //   352: iload_3
    //   353: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: ldc 40
    //   359: iconst_2
    //   360: aload_1
    //   361: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 154	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: iload_3
    //   368: bipush 90
    //   370: if_icmpeq +10 -> 380
    //   373: iload_3
    //   374: sipush 270
    //   377: if_icmpne +25 -> 402
    //   380: aload 12
    //   382: getfield 157	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   385: istore_3
    //   386: aload 12
    //   388: aload 12
    //   390: getfield 160	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   393: putfield 157	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   396: aload 12
    //   398: iload_3
    //   399: putfield 160	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   402: ldc 162
    //   404: aload_2
    //   405: ldc 164
    //   407: invokevirtual 168	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: istore 8
    //   415: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +35 -> 453
    //   421: new 138	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   428: astore_1
    //   429: aload_1
    //   430: ldc 170
    //   432: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: iload 8
    //   439: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 40
    //   445: iconst_2
    //   446: aload_1
    //   447: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 8
    //   455: ifeq +14 -> 469
    //   458: aload_0
    //   459: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   462: aload 12
    //   464: iconst_1
    //   465: invokestatic 176	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   468: return
    //   469: aload 12
    //   471: getfield 91	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   474: astore_1
    //   475: aload_0
    //   476: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   479: invokestatic 179	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   482: ldc 181
    //   484: invokeinterface 187 2 0
    //   489: checkcast 181	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   492: aload_1
    //   493: invokeinterface 190 2 0
    //   498: astore_1
    //   499: aload_0
    //   500: getfield 10	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl$3:a	Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;
    //   503: aload_1
    //   504: aload 12
    //   506: getfield 194	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   509: aload 12
    //   511: invokestatic 197	com/tencent/qqmini/proxyimpl/VideoJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/VideoJsProxyImpl;Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   514: return
    //   515: astore 9
    //   517: goto -300 -> 217
    //   520: astore 9
    //   522: goto -227 -> 295
    //   525: astore 9
    //   527: goto -201 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	3
    //   0	530	1	paramContext	android.content.Context
    //   0	530	2	paramIntent	android.content.Intent
    //   128	271	3	i	int
    //   17	286	4	j	int
    //   20	276	5	k	int
    //   23	169	6	m	int
    //   172	13	7	n	int
    //   413	41	8	bool	boolean
    //   189	39	9	localObject1	java.lang.Object
    //   232	1	9	localIOException1	java.io.IOException
    //   242	1	9	localObject2	java.lang.Object
    //   247	1	9	localIOException2	java.io.IOException
    //   256	3	9	localObject3	java.lang.Object
    //   264	14	9	localIOException3	java.io.IOException
    //   311	8	9	localObject4	java.lang.Object
    //   515	1	9	localIOException4	java.io.IOException
    //   520	1	9	localIOException5	java.io.IOException
    //   525	1	9	localIOException6	java.io.IOException
    //   149	161	10	localObject5	java.lang.Object
    //   102	167	11	localObject6	java.lang.Object
    //   99	411	12	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   159	174	224	finally
    //   183	191	224	finally
    //   194	212	224	finally
    //   159	174	232	java/io/IOException
    //   183	191	232	java/io/IOException
    //   194	212	232	java/io/IOException
    //   151	159	237	finally
    //   151	159	247	java/io/IOException
    //   137	151	254	finally
    //   137	151	264	java/io/IOException
    //   272	282	308	finally
    //   212	217	515	java/io/IOException
    //   287	292	520	java/io/IOException
    //   318	323	525	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */