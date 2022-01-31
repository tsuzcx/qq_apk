package dov.com.tencent.biz.qqstory.takevideo.publish;

public class HWEncodeMergeThumbSegment
  extends MeasureJobSegment
{
  private final String a;
  
  public HWEncodeMergeThumbSegment()
  {
    this(null);
  }
  
  public HWEncodeMergeThumbSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 26	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore 12
    //   6: aload 12
    //   8: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +18 -> 29
    //   14: aload_0
    //   15: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   18: dup
    //   19: iconst_m1
    //   20: ldc 36
    //   22: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   25: invokespecial 43	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   28: return
    //   29: aload_0
    //   30: getfield 16	dov/com/tencent/biz/qqstory/takevideo/publish/HWEncodeMergeThumbSegment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore 7
    //   37: aload_1
    //   38: ifnonnull +18 -> 56
    //   41: aload_2
    //   42: getfield 46	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   45: aload_2
    //   46: getfield 49	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   49: ldc 51
    //   51: invokestatic 56	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 7
    //   56: aload_2
    //   57: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   60: getfield 64	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   63: astore 10
    //   65: aload_2
    //   66: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   69: getfield 67	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   72: astore 9
    //   74: aload_2
    //   75: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   78: ldc 69
    //   80: aconst_null
    //   81: invokevirtual 73	com/tencent/biz/qqstory/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_2
    //   87: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   90: ldc 75
    //   92: aconst_null
    //   93: invokevirtual 73	com/tencent/biz/qqstory/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 8
    //   98: aload 10
    //   100: ifnonnull +98 -> 198
    //   103: aload 9
    //   105: ifnonnull +93 -> 198
    //   108: aload 11
    //   110: ifnonnull +88 -> 198
    //   113: aload 8
    //   115: ifnonnull +83 -> 198
    //   118: ldc 77
    //   120: ldc 79
    //   122: aload 7
    //   124: invokestatic 84	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   127: new 86	java/io/File
    //   130: dup
    //   131: aload 12
    //   133: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: new 86	java/io/File
    //   139: dup
    //   140: aload 7
    //   142: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: invokestatic 92	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   148: ifeq +24 -> 172
    //   151: aload_2
    //   152: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 7
    //   157: putfield 95	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   160: iconst_1
    //   161: istore_3
    //   162: iload_3
    //   163: ifeq +659 -> 822
    //   166: aload_0
    //   167: aload_2
    //   168: invokespecial 99	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   171: return
    //   172: ldc 77
    //   174: ldc 101
    //   176: iconst_2
    //   177: anewarray 103	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload 12
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 7
    //   189: aastore
    //   190: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: iconst_0
    //   194: istore_3
    //   195: goto -33 -> 162
    //   198: aconst_null
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 6
    //   204: new 109	java/io/BufferedInputStream
    //   207: dup
    //   208: new 111	java/io/FileInputStream
    //   211: dup
    //   212: aload 12
    //   214: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   220: astore_1
    //   221: aload_1
    //   222: astore 5
    //   224: aload_1
    //   225: invokestatic 121	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   228: astore 6
    //   230: aload_1
    //   231: ifnull +640 -> 871
    //   234: aload_1
    //   235: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   238: aload 6
    //   240: astore_1
    //   241: aload_1
    //   242: ifnonnull +149 -> 391
    //   245: aload_0
    //   246: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   249: dup
    //   250: iconst_m1
    //   251: ldc 126
    //   253: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   256: invokespecial 43	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   259: return
    //   260: astore_1
    //   261: ldc 77
    //   263: ldc 128
    //   265: aload_1
    //   266: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload 6
    //   271: astore_1
    //   272: goto -31 -> 241
    //   275: astore 6
    //   277: aconst_null
    //   278: astore_1
    //   279: aload_1
    //   280: astore 5
    //   282: ldc 77
    //   284: ldc 133
    //   286: aload 6
    //   288: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload_1
    //   292: ifnull +574 -> 866
    //   295: aload_1
    //   296: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -60 -> 241
    //   304: astore_1
    //   305: ldc 77
    //   307: ldc 128
    //   309: aload_1
    //   310: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   313: aconst_null
    //   314: astore_1
    //   315: goto -74 -> 241
    //   318: astore 5
    //   320: aload 6
    //   322: astore_1
    //   323: aload 5
    //   325: astore 6
    //   327: aload_1
    //   328: astore 5
    //   330: ldc 77
    //   332: ldc 135
    //   334: aload 6
    //   336: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload_1
    //   340: ifnull +526 -> 866
    //   343: aload_1
    //   344: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   347: aconst_null
    //   348: astore_1
    //   349: goto -108 -> 241
    //   352: astore_1
    //   353: ldc 77
    //   355: ldc 128
    //   357: aload_1
    //   358: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   361: aconst_null
    //   362: astore_1
    //   363: goto -122 -> 241
    //   366: astore_1
    //   367: aload 5
    //   369: ifnull +8 -> 377
    //   372: aload 5
    //   374: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   377: aload_1
    //   378: athrow
    //   379: astore_2
    //   380: ldc 77
    //   382: ldc 128
    //   384: aload_2
    //   385: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   388: goto -11 -> 377
    //   391: aconst_null
    //   392: astore 6
    //   394: aload 6
    //   396: astore 5
    //   398: aload 11
    //   400: ifnull +10 -> 410
    //   403: aload 11
    //   405: invokestatic 140	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   408: astore 5
    //   410: aload 5
    //   412: astore 6
    //   414: aload 5
    //   416: ifnonnull +461 -> 877
    //   419: aload 5
    //   421: astore 6
    //   423: aload 10
    //   425: ifnull +452 -> 877
    //   428: aload 10
    //   430: aconst_null
    //   431: invokestatic 143	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)Landroid/graphics/Bitmap;
    //   434: astore 6
    //   436: aload 6
    //   438: astore 5
    //   440: ldc 77
    //   442: ldc 145
    //   444: iconst_1
    //   445: anewarray 103	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: aload 10
    //   452: aastore
    //   453: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: aload 6
    //   458: astore 5
    //   460: aload 5
    //   462: ifnonnull +230 -> 692
    //   465: aload 9
    //   467: ifnull +225 -> 692
    //   470: aload 9
    //   472: invokestatic 148	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   475: astore 6
    //   477: aload 6
    //   479: ifnull +220 -> 699
    //   482: aload_1
    //   483: aload 6
    //   485: invokestatic 151	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   488: astore 5
    //   490: aload 6
    //   492: invokevirtual 156	android/graphics/Bitmap:recycle	()V
    //   495: aload_1
    //   496: invokevirtual 156	android/graphics/Bitmap:recycle	()V
    //   499: aload 5
    //   501: astore_1
    //   502: aload_1
    //   503: astore 5
    //   505: aload_1
    //   506: ifnull +51 -> 557
    //   509: aload_1
    //   510: astore 5
    //   512: aload 8
    //   514: ifnull +43 -> 557
    //   517: aload 8
    //   519: invokestatic 148	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   522: astore 6
    //   524: aload 6
    //   526: ifnull +337 -> 863
    //   529: aload_1
    //   530: aload 6
    //   532: invokestatic 151	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   535: astore 5
    //   537: aload 5
    //   539: ifnull +324 -> 863
    //   542: aload_1
    //   543: invokevirtual 156	android/graphics/Bitmap:recycle	()V
    //   546: aload 6
    //   548: invokevirtual 156	android/graphics/Bitmap:recycle	()V
    //   551: aload 5
    //   553: astore_1
    //   554: aload_1
    //   555: astore 5
    //   557: aload 5
    //   559: ifnonnull +186 -> 745
    //   562: iconst_0
    //   563: istore_3
    //   564: goto -402 -> 162
    //   567: astore 5
    //   569: ldc 77
    //   571: new 158	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   578: ldc 161
    //   580: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 9
    //   585: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc 167
    //   590: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: aload 5
    //   598: invokestatic 174	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   601: aload 6
    //   603: astore 5
    //   605: goto -195 -> 410
    //   608: astore 5
    //   610: aconst_null
    //   611: astore_1
    //   612: ldc 77
    //   614: new 158	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   621: ldc 176
    //   623: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload 5
    //   628: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 183	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: goto -135 -> 502
    //   640: astore 6
    //   642: ldc 77
    //   644: ldc 185
    //   646: aload 6
    //   648: invokestatic 174	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   651: aload 5
    //   653: astore 6
    //   655: goto +222 -> 877
    //   658: astore 6
    //   660: ldc 77
    //   662: new 158	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   669: ldc 161
    //   671: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 9
    //   676: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc 167
    //   681: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: aload 6
    //   689: invokestatic 174	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   692: aload 5
    //   694: astore 6
    //   696: goto -219 -> 477
    //   699: aload_1
    //   700: astore 5
    //   702: goto -203 -> 499
    //   705: astore 5
    //   707: ldc 77
    //   709: new 158	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   716: ldc 161
    //   718: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 8
    //   723: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc 167
    //   728: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: aload 5
    //   736: invokestatic 174	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   739: aload_1
    //   740: astore 5
    //   742: goto -185 -> 557
    //   745: getstatic 189	com/tencent/biz/qqstory/app/QQStoryConstant:c	Ljava/lang/String;
    //   748: invokestatic 192	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   751: pop
    //   752: aload 5
    //   754: aload 7
    //   756: invokestatic 195	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   759: istore 4
    //   761: aload 5
    //   763: invokevirtual 156	android/graphics/Bitmap:recycle	()V
    //   766: iload 4
    //   768: ifeq +42 -> 810
    //   771: aload_2
    //   772: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   775: aload 7
    //   777: putfield 95	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   780: ldc 77
    //   782: new 158	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   789: ldc 197
    //   791: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload 7
    //   796: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 199	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: iconst_1
    //   806: istore_3
    //   807: goto -645 -> 162
    //   810: iconst_0
    //   811: istore_3
    //   812: ldc 77
    //   814: ldc 201
    //   816: invokestatic 203	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: goto -657 -> 162
    //   822: aload_0
    //   823: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   826: dup
    //   827: iconst_m1
    //   828: ldc 126
    //   830: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   833: invokespecial 43	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   836: return
    //   837: astore 6
    //   839: aload 5
    //   841: astore_1
    //   842: aload 6
    //   844: astore 5
    //   846: goto -234 -> 612
    //   849: astore_1
    //   850: goto -483 -> 367
    //   853: astore 6
    //   855: goto -528 -> 327
    //   858: astore 6
    //   860: goto -581 -> 279
    //   863: goto -309 -> 554
    //   866: aconst_null
    //   867: astore_1
    //   868: goto -627 -> 241
    //   871: aload 6
    //   873: astore_1
    //   874: goto -633 -> 241
    //   877: aload 6
    //   879: astore 5
    //   881: goto -421 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	884	0	this	HWEncodeMergeThumbSegment
    //   0	884	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	884	2	paramGenerateContext	GenerateContext
    //   161	651	3	i	int
    //   759	8	4	bool	boolean
    //   199	82	5	localJobContext1	com.tribe.async.async.JobContext
    //   318	6	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   328	230	5	localObject1	java.lang.Object
    //   567	30	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   603	1	5	localObject2	java.lang.Object
    //   608	85	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   700	1	5	localJobContext2	com.tribe.async.async.JobContext
    //   705	30	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   740	140	5	localObject3	java.lang.Object
    //   202	68	6	localBitmap	android.graphics.Bitmap
    //   275	46	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   325	277	6	localObject4	java.lang.Object
    //   640	7	6	localIOException	java.io.IOException
    //   653	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   658	30	6	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   694	1	6	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   837	6	6	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   853	1	6	localOutOfMemoryError9	java.lang.OutOfMemoryError
    //   858	20	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   35	760	7	localObject5	java.lang.Object
    //   96	626	8	str1	String
    //   72	603	9	str2	String
    //   63	388	10	str3	String
    //   84	320	11	str4	String
    //   4	209	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   234	238	260	java/io/IOException
    //   204	221	275	java/io/FileNotFoundException
    //   295	299	304	java/io/IOException
    //   204	221	318	java/lang/OutOfMemoryError
    //   343	347	352	java/io/IOException
    //   204	221	366	finally
    //   330	339	366	finally
    //   372	377	379	java/io/IOException
    //   403	410	567	java/lang/OutOfMemoryError
    //   428	436	608	java/lang/OutOfMemoryError
    //   440	456	608	java/lang/OutOfMemoryError
    //   482	490	608	java/lang/OutOfMemoryError
    //   569	601	608	java/lang/OutOfMemoryError
    //   642	651	608	java/lang/OutOfMemoryError
    //   660	692	608	java/lang/OutOfMemoryError
    //   428	436	640	java/io/IOException
    //   440	456	640	java/io/IOException
    //   470	477	658	java/lang/OutOfMemoryError
    //   517	524	705	java/lang/OutOfMemoryError
    //   529	537	705	java/lang/OutOfMemoryError
    //   542	551	705	java/lang/OutOfMemoryError
    //   490	499	837	java/lang/OutOfMemoryError
    //   224	230	849	finally
    //   282	291	849	finally
    //   224	230	853	java/lang/OutOfMemoryError
    //   224	230	858	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */