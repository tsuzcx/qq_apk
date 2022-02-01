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
    //   55: iconst_m1
    //   56: istore 7
    //   58: iconst_0
    //   59: istore 9
    //   61: iload 9
    //   63: iload 11
    //   65: if_icmpge +218 -> 283
    //   68: ldc 76
    //   70: new 78	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   77: ldc 81
    //   79: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload 9
    //   84: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: ldc 90
    //   89: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 11
    //   94: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 12
    //   105: iload 9
    //   107: invokevirtual 104	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   110: astore 14
    //   112: aload 14
    //   114: ldc 106
    //   116: invokevirtual 112	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 15
    //   121: iconst_0
    //   122: istore 10
    //   124: aload 15
    //   126: ldc 106
    //   128: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   131: aload 15
    //   133: ldc 117
    //   135: iconst_0
    //   136: iconst_2
    //   137: aconst_null
    //   138: invokestatic 123	kotlin/text/StringsKt:startsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   141: ifeq +107 -> 248
    //   144: iload 5
    //   146: ifeq +102 -> 248
    //   149: iconst_1
    //   150: istore 8
    //   152: iload 7
    //   154: istore 10
    //   156: iload 8
    //   158: ifeq +77 -> 235
    //   161: aload 12
    //   163: iload 9
    //   165: invokevirtual 126	android/media/MediaExtractor:selectTrack	(I)V
    //   168: aload_2
    //   169: aload 14
    //   171: invokevirtual 130	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   174: istore 8
    //   176: aload 13
    //   178: checkcast 132	java/util/Map
    //   181: iload 9
    //   183: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: iload 8
    //   188: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokeinterface 142 3 0
    //   196: pop
    //   197: iload 7
    //   199: istore 10
    //   201: aload 14
    //   203: ldc 144
    //   205: invokevirtual 148	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   208: ifeq +27 -> 235
    //   211: aload 14
    //   213: ldc 144
    //   215: invokevirtual 152	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   218: istore 8
    //   220: iload 8
    //   222: iload 7
    //   224: if_icmple +56 -> 280
    //   227: iload 8
    //   229: istore 7
    //   231: iload 7
    //   233: istore 10
    //   235: iload 9
    //   237: iconst_1
    //   238: iadd
    //   239: istore 9
    //   241: iload 10
    //   243: istore 7
    //   245: goto -184 -> 61
    //   248: iload 10
    //   250: istore 8
    //   252: aload 15
    //   254: ldc 154
    //   256: iconst_0
    //   257: iconst_2
    //   258: aconst_null
    //   259: invokestatic 123	kotlin/text/StringsKt:startsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   262: ifeq -110 -> 152
    //   265: iload 10
    //   267: istore 8
    //   269: iload 6
    //   271: ifeq -119 -> 152
    //   274: iconst_1
    //   275: istore 8
    //   277: goto -125 -> 152
    //   280: goto -49 -> 231
    //   283: iload 7
    //   285: istore 8
    //   287: iload 7
    //   289: ifge +8 -> 297
    //   292: sipush 8192
    //   295: istore 8
    //   297: new 156	android/media/MediaMetadataRetriever
    //   300: dup
    //   301: invokespecial 157	android/media/MediaMetadataRetriever:<init>	()V
    //   304: aload_1
    //   305: invokestatic 162	com/tencent/tkd/topicsdk/common/MmrExtensionsKt:a	(Landroid/media/MediaMetadataRetriever;Ljava/lang/String;)Landroid/media/MediaMetadataRetriever;
    //   308: astore_1
    //   309: aload_1
    //   310: ifnull +131 -> 441
    //   313: aload_1
    //   314: bipush 24
    //   316: invokevirtual 166	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: ldc 168
    //   323: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   326: aload_1
    //   327: invokestatic 171	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   330: istore 7
    //   332: iload 7
    //   334: iflt +9 -> 343
    //   337: aload_2
    //   338: iload 7
    //   340: invokevirtual 174	android/media/MediaMuxer:setOrientationHint	(I)V
    //   343: iload_3
    //   344: ifle +16 -> 360
    //   347: aload 12
    //   349: iload_3
    //   350: i2l
    //   351: sipush 1000
    //   354: i2l
    //   355: lmul
    //   356: iconst_2
    //   357: invokevirtual 178	android/media/MediaExtractor:seekTo	(JI)V
    //   360: iload 8
    //   362: invokestatic 184	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   365: astore_1
    //   366: aload_1
    //   367: ldc 186
    //   369: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   372: new 188	android/media/MediaCodec$BufferInfo
    //   375: dup
    //   376: invokespecial 189	android/media/MediaCodec$BufferInfo:<init>	()V
    //   379: astore 14
    //   381: aload_2
    //   382: invokevirtual 192	android/media/MediaMuxer:start	()V
    //   385: aload_0
    //   386: getfield 36	com/tencent/tkd/topicsdk/videoprocess/mediacodec/merge/VideoTrimmer:a	Z
    //   389: ifne +42 -> 431
    //   392: aload 14
    //   394: iconst_0
    //   395: putfield 196	android/media/MediaCodec$BufferInfo:offset	I
    //   398: aload 14
    //   400: aload 12
    //   402: aload_1
    //   403: iconst_0
    //   404: invokevirtual 200	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   407: putfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   410: aload 14
    //   412: getfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   415: ifge +29 -> 444
    //   418: ldc 76
    //   420: ldc 205
    //   422: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 14
    //   427: iconst_0
    //   428: putfield 203	android/media/MediaCodec$BufferInfo:size	I
    //   431: aload_2
    //   432: invokevirtual 207	android/media/MediaMuxer:stop	()V
    //   435: aload_2
    //   436: invokevirtual 210	android/media/MediaMuxer:release	()V
    //   439: iconst_1
    //   440: ireturn
    //   441: goto -98 -> 343
    //   444: aload 14
    //   446: aload 12
    //   448: invokevirtual 214	android/media/MediaExtractor:getSampleTime	()J
    //   451: putfield 218	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   454: iload 4
    //   456: ifle +87 -> 543
    //   459: aload 14
    //   461: getfield 218	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   464: iload 4
    //   466: sipush 1000
    //   469: imul
    //   470: i2l
    //   471: lcmp
    //   472: ifle +71 -> 543
    //   475: ldc 76
    //   477: ldc 220
    //   479: invokestatic 100	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -51 -> 431
    //   485: astore_1
    //   486: ldc 76
    //   488: new 78	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   495: ldc 222
    //   497: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_1
    //   501: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 228	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_2
    //   511: invokevirtual 210	android/media/MediaMuxer:release	()V
    //   514: iconst_0
    //   515: ireturn
    //   516: astore_1
    //   517: ldc 76
    //   519: new 78	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   526: ldc 230
    //   528: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 228	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: iconst_0
    //   542: ireturn
    //   543: aload 14
    //   545: aload 12
    //   547: invokevirtual 233	android/media/MediaExtractor:getSampleFlags	()I
    //   550: putfield 236	android/media/MediaCodec$BufferInfo:flags	I
    //   553: aload 13
    //   555: aload 12
    //   557: invokevirtual 239	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   560: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: invokevirtual 243	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   566: astore 15
    //   568: aload 15
    //   570: ifnonnull +6 -> 576
    //   573: invokestatic 246	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   576: aload 15
    //   578: ldc 248
    //   580: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   583: aload_2
    //   584: aload 15
    //   586: checkcast 250	java/lang/Number
    //   589: invokevirtual 253	java/lang/Number:intValue	()I
    //   592: aload_1
    //   593: aload 14
    //   595: invokevirtual 257	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   598: aload 12
    //   600: invokevirtual 261	android/media/MediaExtractor:advance	()Z
    //   603: pop
    //   604: goto -219 -> 385
    //   607: astore_1
    //   608: aload_2
    //   609: invokevirtual 210	android/media/MediaMuxer:release	()V
    //   612: aload_1
    //   613: athrow
    //   614: astore_1
    //   615: ldc 76
    //   617: new 78	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   624: ldc 230
    //   626: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload_1
    //   630: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 228	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: goto -200 -> 439
    //   642: astore_2
    //   643: ldc 76
    //   645: new 78	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   652: ldc 230
    //   654: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_2
    //   658: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 228	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: goto -55 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	VideoTrimmer
    //   0	670	1	paramString1	java.lang.String
    //   0	670	2	paramString2	java.lang.String
    //   0	670	3	paramInt1	int
    //   0	670	4	paramInt2	int
    //   0	670	5	paramBoolean1	boolean
    //   0	670	6	paramBoolean2	boolean
    //   56	283	7	i	int
    //   150	211	8	j	int
    //   59	181	9	k	int
    //   122	144	10	m	int
    //   32	61	11	n	int
    //   19	580	12	localMediaExtractor	android.media.MediaExtractor
    //   53	501	13	localHashMap	java.util.HashMap
    //   110	484	14	localObject1	Object
    //   119	466	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   381	385	485	java/lang/Exception
    //   385	431	485	java/lang/Exception
    //   431	435	485	java/lang/Exception
    //   444	454	485	java/lang/Exception
    //   459	482	485	java/lang/Exception
    //   543	568	485	java/lang/Exception
    //   573	576	485	java/lang/Exception
    //   576	604	485	java/lang/Exception
    //   510	514	516	java/lang/IllegalStateException
    //   381	385	607	finally
    //   385	431	607	finally
    //   431	435	607	finally
    //   444	454	607	finally
    //   459	482	607	finally
    //   486	510	607	finally
    //   543	568	607	finally
    //   573	576	607	finally
    //   576	604	607	finally
    //   435	439	614	java/lang/IllegalStateException
    //   608	612	642	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.merge.VideoTrimmer
 * JD-Core Version:    0.7.0.1
 */