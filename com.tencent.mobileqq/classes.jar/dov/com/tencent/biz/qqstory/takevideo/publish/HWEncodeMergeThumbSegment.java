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
    //   100: ifnonnull +126 -> 226
    //   103: aload 9
    //   105: ifnonnull +121 -> 226
    //   108: aload 11
    //   110: ifnonnull +116 -> 226
    //   113: aload 8
    //   115: ifnonnull +111 -> 226
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
    //   148: ifeq +52 -> 200
    //   151: aload_2
    //   152: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 7
    //   157: putfield 95	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   160: iconst_1
    //   161: istore_3
    //   162: iload_3
    //   163: ifeq +687 -> 850
    //   166: new 86	java/io/File
    //   169: dup
    //   170: aload_2
    //   171: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   174: getfield 95	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   177: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: new 86	java/io/File
    //   183: dup
    //   184: getstatic 98	dov/com/tencent/biz/qqstory/takevideo/QQStoryTakeVideoCloseAnimationActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: invokestatic 92	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   193: pop
    //   194: aload_0
    //   195: aload_2
    //   196: invokespecial 102	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   199: return
    //   200: ldc 77
    //   202: ldc 104
    //   204: iconst_2
    //   205: anewarray 106	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload 12
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload 7
    //   217: aastore
    //   218: invokestatic 110	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_3
    //   223: goto -61 -> 162
    //   226: aconst_null
    //   227: astore 5
    //   229: aconst_null
    //   230: astore 6
    //   232: new 112	java/io/BufferedInputStream
    //   235: dup
    //   236: new 114	java/io/FileInputStream
    //   239: dup
    //   240: aload 12
    //   242: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   245: invokespecial 118	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   248: astore_1
    //   249: aload_1
    //   250: astore 5
    //   252: aload_1
    //   253: invokestatic 124	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   256: astore 6
    //   258: aload_1
    //   259: ifnull +640 -> 899
    //   262: aload_1
    //   263: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   266: aload 6
    //   268: astore_1
    //   269: aload_1
    //   270: ifnonnull +149 -> 419
    //   273: aload_0
    //   274: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   277: dup
    //   278: iconst_m1
    //   279: ldc 129
    //   281: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   284: invokespecial 43	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   287: return
    //   288: astore_1
    //   289: ldc 77
    //   291: ldc 131
    //   293: aload_1
    //   294: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: aload 6
    //   299: astore_1
    //   300: goto -31 -> 269
    //   303: astore 6
    //   305: aconst_null
    //   306: astore_1
    //   307: aload_1
    //   308: astore 5
    //   310: ldc 77
    //   312: ldc 136
    //   314: aload 6
    //   316: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_1
    //   320: ifnull +574 -> 894
    //   323: aload_1
    //   324: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -60 -> 269
    //   332: astore_1
    //   333: ldc 77
    //   335: ldc 131
    //   337: aload_1
    //   338: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: aconst_null
    //   342: astore_1
    //   343: goto -74 -> 269
    //   346: astore 5
    //   348: aload 6
    //   350: astore_1
    //   351: aload 5
    //   353: astore 6
    //   355: aload_1
    //   356: astore 5
    //   358: ldc 77
    //   360: ldc 138
    //   362: aload 6
    //   364: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_1
    //   368: ifnull +526 -> 894
    //   371: aload_1
    //   372: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   375: aconst_null
    //   376: astore_1
    //   377: goto -108 -> 269
    //   380: astore_1
    //   381: ldc 77
    //   383: ldc 131
    //   385: aload_1
    //   386: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -122 -> 269
    //   394: astore_1
    //   395: aload 5
    //   397: ifnull +8 -> 405
    //   400: aload 5
    //   402: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   405: aload_1
    //   406: athrow
    //   407: astore_2
    //   408: ldc 77
    //   410: ldc 131
    //   412: aload_2
    //   413: invokestatic 134	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -11 -> 405
    //   419: aconst_null
    //   420: astore 6
    //   422: aload 6
    //   424: astore 5
    //   426: aload 11
    //   428: ifnull +10 -> 438
    //   431: aload 11
    //   433: invokestatic 143	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   436: astore 5
    //   438: aload 5
    //   440: astore 6
    //   442: aload 5
    //   444: ifnonnull +461 -> 905
    //   447: aload 5
    //   449: astore 6
    //   451: aload 10
    //   453: ifnull +452 -> 905
    //   456: aload 10
    //   458: aconst_null
    //   459: invokestatic 146	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)Landroid/graphics/Bitmap;
    //   462: astore 6
    //   464: aload 6
    //   466: astore 5
    //   468: ldc 77
    //   470: ldc 148
    //   472: iconst_1
    //   473: anewarray 106	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload 10
    //   480: aastore
    //   481: invokestatic 110	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 6
    //   486: astore 5
    //   488: aload 5
    //   490: ifnonnull +230 -> 720
    //   493: aload 9
    //   495: ifnull +225 -> 720
    //   498: aload 9
    //   500: invokestatic 151	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   503: astore 6
    //   505: aload 6
    //   507: ifnull +220 -> 727
    //   510: aload_1
    //   511: aload 6
    //   513: invokestatic 154	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   516: astore 5
    //   518: aload 6
    //   520: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   523: aload_1
    //   524: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   527: aload 5
    //   529: astore_1
    //   530: aload_1
    //   531: astore 5
    //   533: aload_1
    //   534: ifnull +51 -> 585
    //   537: aload_1
    //   538: astore 5
    //   540: aload 8
    //   542: ifnull +43 -> 585
    //   545: aload 8
    //   547: invokestatic 151	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   550: astore 6
    //   552: aload 6
    //   554: ifnull +337 -> 891
    //   557: aload_1
    //   558: aload 6
    //   560: invokestatic 154	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   563: astore 5
    //   565: aload 5
    //   567: ifnull +324 -> 891
    //   570: aload_1
    //   571: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   574: aload 6
    //   576: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   579: aload 5
    //   581: astore_1
    //   582: aload_1
    //   583: astore 5
    //   585: aload 5
    //   587: ifnonnull +186 -> 773
    //   590: iconst_0
    //   591: istore_3
    //   592: goto -430 -> 162
    //   595: astore 5
    //   597: ldc 77
    //   599: new 161	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   606: ldc 164
    //   608: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 9
    //   613: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc 170
    //   618: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: aload 5
    //   626: invokestatic 177	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   629: aload 6
    //   631: astore 5
    //   633: goto -195 -> 438
    //   636: astore 5
    //   638: aconst_null
    //   639: astore_1
    //   640: ldc 77
    //   642: new 161	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   649: ldc 179
    //   651: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 5
    //   656: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 186	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: goto -135 -> 530
    //   668: astore 6
    //   670: ldc 77
    //   672: ldc 188
    //   674: aload 6
    //   676: invokestatic 177	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   679: aload 5
    //   681: astore 6
    //   683: goto +222 -> 905
    //   686: astore 6
    //   688: ldc 77
    //   690: new 161	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   697: ldc 164
    //   699: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 9
    //   704: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc 170
    //   709: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: aload 6
    //   717: invokestatic 177	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   720: aload 5
    //   722: astore 6
    //   724: goto -219 -> 505
    //   727: aload_1
    //   728: astore 5
    //   730: goto -203 -> 527
    //   733: astore 5
    //   735: ldc 77
    //   737: new 161	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   744: ldc 164
    //   746: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 8
    //   751: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: ldc 170
    //   756: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: aload 5
    //   764: invokestatic 177	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   767: aload_1
    //   768: astore 5
    //   770: goto -185 -> 585
    //   773: getstatic 192	com/tencent/biz/qqstory/app/QQStoryConstant:c	Ljava/lang/String;
    //   776: invokestatic 195	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   779: pop
    //   780: aload 5
    //   782: aload 7
    //   784: invokestatic 198	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   787: istore 4
    //   789: aload 5
    //   791: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   794: iload 4
    //   796: ifeq +42 -> 838
    //   799: aload_2
    //   800: getfield 59	dov/com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   803: aload 7
    //   805: putfield 95	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   808: ldc 77
    //   810: new 161	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   817: ldc 200
    //   819: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 7
    //   824: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokestatic 202	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: iconst_1
    //   834: istore_3
    //   835: goto -673 -> 162
    //   838: iconst_0
    //   839: istore_3
    //   840: ldc 77
    //   842: ldc 204
    //   844: invokestatic 206	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: goto -685 -> 162
    //   850: aload_0
    //   851: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   854: dup
    //   855: iconst_m1
    //   856: ldc 129
    //   858: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   861: invokespecial 43	dov/com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   864: return
    //   865: astore 6
    //   867: aload 5
    //   869: astore_1
    //   870: aload 6
    //   872: astore 5
    //   874: goto -234 -> 640
    //   877: astore_1
    //   878: goto -483 -> 395
    //   881: astore 6
    //   883: goto -528 -> 355
    //   886: astore 6
    //   888: goto -581 -> 307
    //   891: goto -309 -> 582
    //   894: aconst_null
    //   895: astore_1
    //   896: goto -627 -> 269
    //   899: aload 6
    //   901: astore_1
    //   902: goto -633 -> 269
    //   905: aload 6
    //   907: astore 5
    //   909: goto -421 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	912	0	this	HWEncodeMergeThumbSegment
    //   0	912	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	912	2	paramGenerateContext	GenerateContext
    //   161	679	3	i	int
    //   787	8	4	bool	boolean
    //   227	82	5	localJobContext1	com.tribe.async.async.JobContext
    //   346	6	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   356	230	5	localObject1	java.lang.Object
    //   595	30	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   631	1	5	localObject2	java.lang.Object
    //   636	85	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   728	1	5	localJobContext2	com.tribe.async.async.JobContext
    //   733	30	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   768	140	5	localObject3	java.lang.Object
    //   230	68	6	localBitmap	android.graphics.Bitmap
    //   303	46	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   353	277	6	localObject4	java.lang.Object
    //   668	7	6	localIOException	java.io.IOException
    //   681	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   686	30	6	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   722	1	6	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   865	6	6	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   881	1	6	localOutOfMemoryError9	java.lang.OutOfMemoryError
    //   886	20	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   35	788	7	localObject5	java.lang.Object
    //   96	654	8	str1	String
    //   72	631	9	str2	String
    //   63	416	10	str3	String
    //   84	348	11	str4	String
    //   4	237	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   262	266	288	java/io/IOException
    //   232	249	303	java/io/FileNotFoundException
    //   323	327	332	java/io/IOException
    //   232	249	346	java/lang/OutOfMemoryError
    //   371	375	380	java/io/IOException
    //   232	249	394	finally
    //   358	367	394	finally
    //   400	405	407	java/io/IOException
    //   431	438	595	java/lang/OutOfMemoryError
    //   456	464	636	java/lang/OutOfMemoryError
    //   468	484	636	java/lang/OutOfMemoryError
    //   510	518	636	java/lang/OutOfMemoryError
    //   597	629	636	java/lang/OutOfMemoryError
    //   670	679	636	java/lang/OutOfMemoryError
    //   688	720	636	java/lang/OutOfMemoryError
    //   456	464	668	java/io/IOException
    //   468	484	668	java/io/IOException
    //   498	505	686	java/lang/OutOfMemoryError
    //   545	552	733	java/lang/OutOfMemoryError
    //   557	565	733	java/lang/OutOfMemoryError
    //   570	579	733	java/lang/OutOfMemoryError
    //   518	527	865	java/lang/OutOfMemoryError
    //   252	258	877	finally
    //   310	319	877	finally
    //   252	258	881	java/lang/OutOfMemoryError
    //   252	258	886	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */