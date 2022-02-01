package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tribe.async.async.JobSegment;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment
  extends JobSegment<VideoInfo, VideoInfo>
{
  private WeakReference<XMediaEditor> a;
  private int b;
  private boolean c;
  
  public VideoInfo$GenerateVideoPosterSegment(XMediaEditor paramXMediaEditor, int paramInt)
  {
    this.a = new WeakReference(paramXMediaEditor);
    this.b = paramInt;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, VideoInfo paramVideoInfo)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 43
    //   8: iconst_2
    //   9: iconst_2
    //   10: anewarray 45	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 47
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_2
    //   21: getfield 52	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:o	I
    //   24: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   31: invokestatic 68	com/tencent/mobileqq/troop/homework/xmediaeditor/model/ImageInfo:h	()Ljava/lang/String;
    //   34: astore 10
    //   36: new 70	android/media/MediaMetadataRetriever
    //   39: dup
    //   40: invokespecial 71	android/media/MediaMetadataRetriever:<init>	()V
    //   43: astore 9
    //   45: aconst_null
    //   46: astore 7
    //   48: aconst_null
    //   49: astore 8
    //   51: aconst_null
    //   52: astore 6
    //   54: aload 6
    //   56: astore_3
    //   57: aload 7
    //   59: astore 4
    //   61: aload 8
    //   63: astore 5
    //   65: aload 9
    //   67: aload_2
    //   68: getfield 75	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:r	Ljava/lang/String;
    //   71: invokevirtual 79	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload 6
    //   76: astore_3
    //   77: aload 7
    //   79: astore 4
    //   81: aload 8
    //   83: astore 5
    //   85: aload 9
    //   87: ldc2_w 80
    //   90: invokevirtual 85	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   93: astore 11
    //   95: aload 11
    //   97: ifnonnull +33 -> 130
    //   100: aload 6
    //   102: astore_3
    //   103: aload 7
    //   105: astore 4
    //   107: aload 8
    //   109: astore 5
    //   111: aload_0
    //   112: new 87	java/lang/Error
    //   115: dup
    //   116: ldc 89
    //   118: invokespecial 91	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 95	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:notifyError	(Ljava/lang/Error;)V
    //   124: aload 9
    //   126: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   129: return
    //   130: aload 6
    //   132: astore_3
    //   133: aload 7
    //   135: astore 4
    //   137: aload 8
    //   139: astore 5
    //   141: aload_0
    //   142: getfield 26	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:b	I
    //   145: sipush 200
    //   148: sipush 300
    //   151: aload_2
    //   152: getfield 101	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:f	I
    //   155: aload_2
    //   156: getfield 104	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:j	I
    //   159: invokestatic 109	com/tencent/mobileqq/troop/homework/xmediaeditor/ui/ImageItem:a	(IIIII)[I
    //   162: astore 12
    //   164: aload 6
    //   166: astore_3
    //   167: aload 7
    //   169: astore 4
    //   171: aload 8
    //   173: astore 5
    //   175: aload 11
    //   177: aload 12
    //   179: iconst_0
    //   180: iaload
    //   181: aload 12
    //   183: iconst_1
    //   184: iaload
    //   185: invokestatic 115	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   188: astore 6
    //   190: aload 6
    //   192: ifnonnull +43 -> 235
    //   195: aload 6
    //   197: astore_3
    //   198: aload 6
    //   200: astore 4
    //   202: aload 6
    //   204: astore 5
    //   206: aload_0
    //   207: new 87	java/lang/Error
    //   210: dup
    //   211: ldc 89
    //   213: invokespecial 91	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   216: invokevirtual 95	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:notifyError	(Ljava/lang/Error;)V
    //   219: aload 9
    //   221: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   224: aload 6
    //   226: ifnull +8 -> 234
    //   229: aload 6
    //   231: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   234: return
    //   235: aload 6
    //   237: astore_3
    //   238: aload 6
    //   240: astore 4
    //   242: aload 6
    //   244: astore 5
    //   246: new 122	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   253: astore 7
    //   255: aload 6
    //   257: astore_3
    //   258: aload 6
    //   260: astore 4
    //   262: aload 6
    //   264: astore 5
    //   266: aload 7
    //   268: aload 10
    //   270: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: astore_3
    //   277: aload 6
    //   279: astore 4
    //   281: aload 6
    //   283: astore 5
    //   285: aload 7
    //   287: ldc 129
    //   289: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 6
    //   295: astore_3
    //   296: aload 6
    //   298: astore 4
    //   300: aload 6
    //   302: astore 5
    //   304: aload 7
    //   306: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   309: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 6
    //   315: astore_3
    //   316: aload 6
    //   318: astore 4
    //   320: aload 6
    //   322: astore 5
    //   324: aload 7
    //   326: ldc 140
    //   328: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 6
    //   334: astore_3
    //   335: aload 6
    //   337: astore 4
    //   339: aload 6
    //   341: astore 5
    //   343: aload 7
    //   345: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 149	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   351: astore 7
    //   353: aload 6
    //   355: astore_3
    //   356: aload 6
    //   358: astore 4
    //   360: aload 6
    //   362: astore 5
    //   364: aload 6
    //   366: new 151	java/io/File
    //   369: dup
    //   370: aload 7
    //   372: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   375: invokestatic 157	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   378: aload 6
    //   380: astore_3
    //   381: aload 6
    //   383: astore 4
    //   385: aload 6
    //   387: astore 5
    //   389: aload_2
    //   390: aload 7
    //   392: putfield 159	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:c	Ljava/lang/String;
    //   395: aload 6
    //   397: astore_3
    //   398: aload 6
    //   400: astore 4
    //   402: aload 6
    //   404: astore 5
    //   406: invokestatic 165	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   409: new 167	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment$1
    //   412: dup
    //   413: aload_0
    //   414: aload_2
    //   415: aload 7
    //   417: invokespecial 170	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment$1:<init>	(Lcom/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment;Lcom/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo;Ljava/lang/String;)V
    //   420: invokevirtual 176	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   423: pop
    //   424: aload 6
    //   426: astore_3
    //   427: aload 6
    //   429: astore 4
    //   431: aload 6
    //   433: astore 5
    //   435: aload_0
    //   436: invokevirtual 179	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:isCanceled	()Z
    //   439: ifne +72 -> 511
    //   442: aload 6
    //   444: astore_3
    //   445: aload 6
    //   447: astore 4
    //   449: aload 6
    //   451: astore 5
    //   453: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +39 -> 495
    //   459: aload 6
    //   461: astore_3
    //   462: aload 6
    //   464: astore 4
    //   466: aload 6
    //   468: astore 5
    //   470: ldc 43
    //   472: iconst_2
    //   473: iconst_2
    //   474: anewarray 45	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: ldc 181
    //   481: aastore
    //   482: dup
    //   483: iconst_1
    //   484: aload_2
    //   485: getfield 52	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo:o	I
    //   488: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aastore
    //   492: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   495: aload 6
    //   497: astore_3
    //   498: aload 6
    //   500: astore 4
    //   502: aload 6
    //   504: astore 5
    //   506: aload_0
    //   507: aload_2
    //   508: invokevirtual 184	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:notifyResult	(Ljava/lang/Object;)V
    //   511: aload 9
    //   513: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   516: aload 6
    //   518: ifnull +179 -> 697
    //   521: aload 6
    //   523: astore 4
    //   525: aload 4
    //   527: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   530: return
    //   531: astore_1
    //   532: goto +166 -> 698
    //   535: aload 5
    //   537: astore_3
    //   538: ldc 43
    //   540: iconst_1
    //   541: ldc 186
    //   543: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload 5
    //   548: astore_3
    //   549: invokestatic 195	com/tencent/image/URLDrawable:clearMemoryCache	()V
    //   552: aload 5
    //   554: astore_3
    //   555: invokestatic 198	java/lang/System:gc	()V
    //   558: aload 5
    //   560: astore_3
    //   561: aload_0
    //   562: getfield 200	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:c	Z
    //   565: ifne +23 -> 588
    //   568: aload 5
    //   570: astore_3
    //   571: aload_0
    //   572: iconst_1
    //   573: putfield 200	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:c	Z
    //   576: aload 5
    //   578: astore_3
    //   579: aload_0
    //   580: aload_1
    //   581: aload_2
    //   582: invokevirtual 202	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:a	(Lcom/tribe/async/async/JobContext;Lcom/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo;)V
    //   585: goto +19 -> 604
    //   588: aload 5
    //   590: astore_3
    //   591: aload_0
    //   592: new 87	java/lang/Error
    //   595: dup
    //   596: ldc 204
    //   598: invokespecial 91	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   601: invokevirtual 95	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:notifyError	(Ljava/lang/Error;)V
    //   604: aload 9
    //   606: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   609: aload 5
    //   611: ifnull +86 -> 697
    //   614: aload 5
    //   616: astore 4
    //   618: goto -93 -> 525
    //   621: astore_1
    //   622: aload 4
    //   624: astore_3
    //   625: new 122	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   632: astore_2
    //   633: aload 4
    //   635: astore_3
    //   636: aload_2
    //   637: ldc 206
    //   639: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 4
    //   645: astore_3
    //   646: aload_2
    //   647: aload_1
    //   648: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   651: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 4
    //   657: astore_3
    //   658: ldc 43
    //   660: iconst_1
    //   661: aload_2
    //   662: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload 4
    //   670: astore_3
    //   671: aload_0
    //   672: new 87	java/lang/Error
    //   675: dup
    //   676: ldc 89
    //   678: invokespecial 91	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   681: invokevirtual 95	com/tencent/mobileqq/troop/homework/xmediaeditor/model/VideoInfo$GenerateVideoPosterSegment:notifyError	(Ljava/lang/Error;)V
    //   684: aload 9
    //   686: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   689: aload 4
    //   691: ifnull +6 -> 697
    //   694: goto -169 -> 525
    //   697: return
    //   698: aload 9
    //   700: invokevirtual 98	android/media/MediaMetadataRetriever:release	()V
    //   703: aload_3
    //   704: ifnull +7 -> 711
    //   707: aload_3
    //   708: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   711: goto +5 -> 716
    //   714: aload_1
    //   715: athrow
    //   716: goto -2 -> 714
    //   719: astore_3
    //   720: goto -185 -> 535
    //   723: astore_1
    //   724: return
    //   725: astore_1
    //   726: return
    //   727: astore_1
    //   728: return
    //   729: astore_2
    //   730: goto -19 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	GenerateVideoPosterSegment
    //   0	733	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	733	2	paramVideoInfo	VideoInfo
    //   56	652	3	localObject1	java.lang.Object
    //   719	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   59	631	4	localObject2	java.lang.Object
    //   63	552	5	localObject3	java.lang.Object
    //   52	470	6	localBitmap1	android.graphics.Bitmap
    //   46	370	7	localObject4	java.lang.Object
    //   49	123	8	localObject5	java.lang.Object
    //   43	656	9	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   34	235	10	str	java.lang.String
    //   93	83	11	localBitmap2	android.graphics.Bitmap
    //   162	20	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   65	74	531	finally
    //   85	95	531	finally
    //   111	124	531	finally
    //   141	164	531	finally
    //   175	190	531	finally
    //   206	219	531	finally
    //   246	255	531	finally
    //   266	274	531	finally
    //   285	293	531	finally
    //   304	313	531	finally
    //   324	332	531	finally
    //   343	353	531	finally
    //   364	378	531	finally
    //   389	395	531	finally
    //   406	424	531	finally
    //   435	442	531	finally
    //   453	459	531	finally
    //   470	495	531	finally
    //   506	511	531	finally
    //   538	546	531	finally
    //   549	552	531	finally
    //   555	558	531	finally
    //   561	568	531	finally
    //   571	576	531	finally
    //   579	585	531	finally
    //   591	604	531	finally
    //   625	633	531	finally
    //   636	643	531	finally
    //   646	655	531	finally
    //   658	668	531	finally
    //   671	684	531	finally
    //   65	74	621	java/lang/Exception
    //   85	95	621	java/lang/Exception
    //   111	124	621	java/lang/Exception
    //   141	164	621	java/lang/Exception
    //   175	190	621	java/lang/Exception
    //   206	219	621	java/lang/Exception
    //   246	255	621	java/lang/Exception
    //   266	274	621	java/lang/Exception
    //   285	293	621	java/lang/Exception
    //   304	313	621	java/lang/Exception
    //   324	332	621	java/lang/Exception
    //   343	353	621	java/lang/Exception
    //   364	378	621	java/lang/Exception
    //   389	395	621	java/lang/Exception
    //   406	424	621	java/lang/Exception
    //   435	442	621	java/lang/Exception
    //   453	459	621	java/lang/Exception
    //   470	495	621	java/lang/Exception
    //   506	511	621	java/lang/Exception
    //   65	74	719	java/lang/OutOfMemoryError
    //   85	95	719	java/lang/OutOfMemoryError
    //   111	124	719	java/lang/OutOfMemoryError
    //   141	164	719	java/lang/OutOfMemoryError
    //   175	190	719	java/lang/OutOfMemoryError
    //   206	219	719	java/lang/OutOfMemoryError
    //   246	255	719	java/lang/OutOfMemoryError
    //   266	274	719	java/lang/OutOfMemoryError
    //   285	293	719	java/lang/OutOfMemoryError
    //   304	313	719	java/lang/OutOfMemoryError
    //   324	332	719	java/lang/OutOfMemoryError
    //   343	353	719	java/lang/OutOfMemoryError
    //   364	378	719	java/lang/OutOfMemoryError
    //   389	395	719	java/lang/OutOfMemoryError
    //   406	424	719	java/lang/OutOfMemoryError
    //   435	442	719	java/lang/OutOfMemoryError
    //   453	459	719	java/lang/OutOfMemoryError
    //   470	495	719	java/lang/OutOfMemoryError
    //   506	511	719	java/lang/OutOfMemoryError
    //   124	129	723	java/lang/RuntimeException
    //   219	224	725	java/lang/RuntimeException
    //   229	234	725	java/lang/RuntimeException
    //   511	516	727	java/lang/RuntimeException
    //   525	530	727	java/lang/RuntimeException
    //   604	609	727	java/lang/RuntimeException
    //   684	689	727	java/lang/RuntimeException
    //   698	703	729	java/lang/RuntimeException
    //   707	711	729	java/lang/RuntimeException
  }
  
  protected void onCancel()
  {
    notifyError(new Error("c_2000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment
 * JD-Core Version:    0.7.0.1
 */