package com.tencent.tkd.topicsdk.videoprocess.mediacodec.merge;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/mediacodec/merge/VideoTrimmer;", "", "()V", "stopMux", "", "stop", "", "trimVideo", "srcPath", "", "dstPath", "startMs", "", "endMs", "useAudio", "useVideo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoTrimmer
{
  private boolean a;
  
  public final void a()
  {
    this.a = true;
  }
  
  /* Error */
  @androidx.annotation.RequiresApi(18)
  public final boolean a(@org.jetbrains.annotations.NotNull java.lang.String paramString1, @org.jetbrains.annotations.NotNull java.lang.String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 46
    //   3: invokestatic 52	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 53
    //   9: invokestatic 52	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 55	android/media/MediaExtractor
    //   15: dup
    //   16: invokespecial 56	android/media/MediaExtractor:<init>	()V
    //   19: astore 12
    //   21: aload 12
    //   23: aload_1
    //   24: invokevirtual 60	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   27: aload 12
    //   29: invokevirtual 64	android/media/MediaExtractor:getTrackCount	()I
    //   32: istore 11
    //   34: new 66	android/media/MediaMuxer
    //   37: dup
    //   38: aload_2
    //   39: iconst_0
    //   40: invokespecial 69	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   43: astore_2
    //   44: new 71	java/util/HashMap
    //   47: dup
    //   48: iload 11
    //   50: invokespecial 74	java/util/HashMap:<init>	(I)V
    //   53: astore 13
    //   55: iconst_0
    //   56: istore 8
    //   58: iconst_m1
    //   59: istore 7
    //   61: iload 8
    //   63: iload 11
    //   65: if_icmpge +223 -> 288
    //   68: new 76	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   75: astore 14
    //   77: aload 14
    //   79: ldc 79
    //   81: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 14
    //   87: iload 8
    //   89: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 14
    //   95: ldc 88
    //   97: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 14
    //   103: iload 11
    //   105: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc 90
    //   111: aload 14
    //   113: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload 12
    //   121: iload 8
    //   123: invokevirtual 104	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   126: astore 14
    //   128: aload 14
    //   130: ldc 106
    //   132: invokevirtual 112	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 15
    //   137: aload 15
    //   139: ldc 106
    //   141: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   144: aload 15
    //   146: ldc 117
    //   148: iconst_0
    //   149: iconst_2
    //   150: aconst_null
    //   151: invokestatic 123	kotlin/text/StringsKt:startsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   154: ifeq +14 -> 168
    //   157: iload 5
    //   159: ifeq +9 -> 168
    //   162: iconst_1
    //   163: istore 10
    //   165: goto +27 -> 192
    //   168: aload 15
    //   170: ldc 125
    //   172: iconst_0
    //   173: iconst_2
    //   174: aconst_null
    //   175: invokestatic 123	kotlin/text/StringsKt:startsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   178: ifeq +11 -> 189
    //   181: iload 6
    //   183: ifeq +6 -> 189
    //   186: goto -24 -> 162
    //   189: iconst_0
    //   190: istore 10
    //   192: iload 7
    //   194: istore 9
    //   196: iload 10
    //   198: ifeq +77 -> 275
    //   201: aload 12
    //   203: iload 8
    //   205: invokevirtual 128	android/media/MediaExtractor:selectTrack	(I)V
    //   208: aload_2
    //   209: aload 14
    //   211: invokevirtual 132	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   214: istore 9
    //   216: aload 13
    //   218: checkcast 134	java/util/Map
    //   221: iload 8
    //   223: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: iload 9
    //   228: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: invokeinterface 144 3 0
    //   236: pop
    //   237: iload 7
    //   239: istore 9
    //   241: aload 14
    //   243: ldc 146
    //   245: invokevirtual 150	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   248: ifeq +27 -> 275
    //   251: aload 14
    //   253: ldc 146
    //   255: invokevirtual 154	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   258: istore 10
    //   260: iload 7
    //   262: istore 9
    //   264: iload 10
    //   266: iload 7
    //   268: if_icmple +7 -> 275
    //   271: iload 10
    //   273: istore 9
    //   275: iload 8
    //   277: iconst_1
    //   278: iadd
    //   279: istore 8
    //   281: iload 9
    //   283: istore 7
    //   285: goto -224 -> 61
    //   288: iload 7
    //   290: istore 8
    //   292: iload 7
    //   294: ifge +8 -> 302
    //   297: sipush 8192
    //   300: istore 8
    //   302: new 156	android/media/MediaMetadataRetriever
    //   305: dup
    //   306: invokespecial 157	android/media/MediaMetadataRetriever:<init>	()V
    //   309: aload_1
    //   310: invokestatic 162	com/tencent/tkd/topicsdk/common/MmrExtensionsKt:a	(Landroid/media/MediaMetadataRetriever;Ljava/lang/String;)Landroid/media/MediaMetadataRetriever;
    //   313: astore_1
    //   314: aload_1
    //   315: ifnull +33 -> 348
    //   318: aload_1
    //   319: bipush 24
    //   321: invokevirtual 166	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   324: astore_1
    //   325: aload_1
    //   326: ldc 168
    //   328: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   331: aload_1
    //   332: invokestatic 171	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   335: istore 7
    //   337: iload 7
    //   339: iflt +9 -> 348
    //   342: aload_2
    //   343: iload 7
    //   345: invokevirtual 174	android/media/MediaMuxer:setOrientationHint	(I)V
    //   348: iload_3
    //   349: ifle +16 -> 365
    //   352: aload 12
    //   354: iload_3
    //   355: i2l
    //   356: sipush 1000
    //   359: i2l
    //   360: lmul
    //   361: iconst_2
    //   362: invokevirtual 178	android/media/MediaExtractor:seekTo	(JI)V
    //   365: iload 8
    //   367: invokestatic 184	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   370: astore_1
    //   371: aload_1
    //   372: ldc 186
    //   374: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   377: new 188	android/media/MediaCodec$BufferInfo
    //   380: dup
    //   381: invokespecial 189	android/media/MediaCodec$BufferInfo:<init>	()V
    //   384: astore 14
    //   386: aload_2
    //   387: invokevirtual 192	android/media/MediaMuxer:start	()V
    //   390: aload_0
    //   391: getfield 36	com/tencent/tkd/topicsdk/videoprocess/mediacodec/merge/VideoTrimmer:a	Z
    //   394: ifne +150 -> 544
    //   397: aload 14
    //   399: iconst_0
    //   400: putfield 196	android/media/MediaCodec$BufferInfo:offset	I
    //   403: aload 14
    //   405: aload 12
    //   407: aload_1
    //   408: iconst_0
    //   409: invokevirtual 200	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   412: putfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   415: aload 14
    //   417: getfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   420: ifge +19 -> 439
    //   423: ldc 90
    //   425: ldc 205
    //   427: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 14
    //   432: iconst_0
    //   433: putfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   436: goto +108 -> 544
    //   439: aload 14
    //   441: aload 12
    //   443: invokevirtual 209	android/media/MediaExtractor:getSampleTime	()J
    //   446: putfield 213	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   449: iload 4
    //   451: ifle +29 -> 480
    //   454: aload 14
    //   456: getfield 213	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   459: iload 4
    //   461: sipush 1000
    //   464: imul
    //   465: i2l
    //   466: lcmp
    //   467: ifle +13 -> 480
    //   470: ldc 90
    //   472: ldc 215
    //   474: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: goto +67 -> 544
    //   480: aload 14
    //   482: aload 12
    //   484: invokevirtual 218	android/media/MediaExtractor:getSampleFlags	()I
    //   487: putfield 221	android/media/MediaCodec$BufferInfo:flags	I
    //   490: aload 13
    //   492: aload 12
    //   494: invokevirtual 224	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   497: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: invokevirtual 228	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   503: astore 15
    //   505: aload 15
    //   507: ifnonnull +6 -> 513
    //   510: invokestatic 231	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   513: aload 15
    //   515: ldc 233
    //   517: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   520: aload_2
    //   521: aload 15
    //   523: checkcast 235	java/lang/Number
    //   526: invokevirtual 238	java/lang/Number:intValue	()I
    //   529: aload_1
    //   530: aload 14
    //   532: invokevirtual 242	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   535: aload 12
    //   537: invokevirtual 246	android/media/MediaExtractor:advance	()Z
    //   540: pop
    //   541: goto -151 -> 390
    //   544: aload_2
    //   545: invokevirtual 248	android/media/MediaMuxer:stop	()V
    //   548: aload_2
    //   549: invokevirtual 251	android/media/MediaMuxer:release	()V
    //   552: goto +34 -> 586
    //   555: astore_1
    //   556: new 76	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   563: astore_2
    //   564: aload_2
    //   565: ldc 253
    //   567: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_2
    //   572: aload_1
    //   573: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc 90
    //   579: aload_2
    //   580: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 259	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: iconst_1
    //   587: ireturn
    //   588: astore_1
    //   589: goto +8 -> 597
    //   592: astore_1
    //   593: goto +8 -> 601
    //   596: astore_1
    //   597: goto +79 -> 676
    //   600: astore_1
    //   601: new 76	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   608: astore 12
    //   610: aload 12
    //   612: ldc_w 261
    //   615: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 12
    //   621: aload_1
    //   622: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: ldc 90
    //   628: aload 12
    //   630: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 259	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload_2
    //   637: invokevirtual 251	android/media/MediaMuxer:release	()V
    //   640: iconst_0
    //   641: ireturn
    //   642: astore_1
    //   643: new 76	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   650: astore_2
    //   651: aload_2
    //   652: ldc 253
    //   654: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_2
    //   659: aload_1
    //   660: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: ldc 90
    //   666: aload_2
    //   667: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 259	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: goto -33 -> 640
    //   676: aload_2
    //   677: invokevirtual 251	android/media/MediaMuxer:release	()V
    //   680: goto +38 -> 718
    //   683: astore_2
    //   684: new 76	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   691: astore 12
    //   693: aload 12
    //   695: ldc 253
    //   697: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 12
    //   703: aload_2
    //   704: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: ldc 90
    //   710: aload 12
    //   712: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 259	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: goto +5 -> 723
    //   721: aload_1
    //   722: athrow
    //   723: goto -2 -> 721
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	VideoTrimmer
    //   0	726	1	paramString1	java.lang.String
    //   0	726	2	paramString2	java.lang.String
    //   0	726	3	paramInt1	int
    //   0	726	4	paramInt2	int
    //   0	726	5	paramBoolean1	boolean
    //   0	726	6	paramBoolean2	boolean
    //   59	285	7	i	int
    //   56	310	8	j	int
    //   194	88	9	k	int
    //   163	109	10	m	int
    //   32	72	11	n	int
    //   19	692	12	localObject1	Object
    //   53	438	13	localHashMap	java.util.HashMap
    //   75	456	14	localObject2	Object
    //   135	387	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   548	552	555	java/lang/IllegalStateException
    //   390	436	588	finally
    //   439	449	588	finally
    //   454	477	588	finally
    //   480	505	588	finally
    //   510	513	588	finally
    //   513	541	588	finally
    //   544	548	588	finally
    //   601	636	588	finally
    //   390	436	592	java/lang/Exception
    //   439	449	592	java/lang/Exception
    //   454	477	592	java/lang/Exception
    //   480	505	592	java/lang/Exception
    //   510	513	592	java/lang/Exception
    //   513	541	592	java/lang/Exception
    //   544	548	592	java/lang/Exception
    //   386	390	596	finally
    //   386	390	600	java/lang/Exception
    //   636	640	642	java/lang/IllegalStateException
    //   676	680	683	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.merge.VideoTrimmer
 * JD-Core Version:    0.7.0.1
 */