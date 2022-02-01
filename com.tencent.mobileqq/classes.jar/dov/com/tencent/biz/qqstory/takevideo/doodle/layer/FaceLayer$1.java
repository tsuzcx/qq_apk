package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import bphm;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceLayer$1
  implements Runnable
{
  public FaceLayer$1(bphm parambphm, ArrayList paramArrayList, JSONArray paramJSONArray, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 39	java/util/ArrayList:size	()I
    //   10: if_icmpge +944 -> 954
    //   13: aload_0
    //   14: getfield 18	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_1
    //   18: invokevirtual 43	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 45	dov/com/qq/im/capture/paster/PasterParcelData
    //   24: astore 10
    //   26: aload 10
    //   28: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   31: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +10 -> 44
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -39 -> 2
    //   44: aload 10
    //   46: getfield 59	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   49: iconst_1
    //   50: if_icmpne +296 -> 346
    //   53: getstatic 65	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   56: invokevirtual 69	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   59: aload 10
    //   61: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   64: ldc 71
    //   66: getstatic 76	bdzx:a	Landroid/graphics/drawable/Drawable;
    //   69: iconst_1
    //   70: newarray int
    //   72: dup
    //   73: iconst_0
    //   74: bipush 13
    //   76: iastore
    //   77: ldc 71
    //   79: aconst_null
    //   80: invokestatic 82	com/tencent/mobileqq/vas/VasApngUtil:getApngDrawable	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   83: astore 7
    //   85: aload 7
    //   87: ifnull +906 -> 993
    //   90: aload 7
    //   92: invokevirtual 87	com/tencent/image/URLDrawable:getStatus	()I
    //   95: iconst_1
    //   96: if_icmpeq +8 -> 104
    //   99: aload 7
    //   101: invokevirtual 90	com/tencent/image/URLDrawable:restartDownload	()V
    //   104: aload 7
    //   106: aload_0
    //   107: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbphm;
    //   110: invokestatic 95	bphm:a	(Lbphm;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   113: invokevirtual 101	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   116: aload 7
    //   118: ifnull -81 -> 37
    //   121: aload 10
    //   123: getfield 104	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   126: getfield 110	android/graphics/RectF:left	F
    //   129: f2i
    //   130: istore_2
    //   131: aload 10
    //   133: getfield 104	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   136: getfield 113	android/graphics/RectF:right	F
    //   139: f2i
    //   140: istore_3
    //   141: aload 7
    //   143: iload_2
    //   144: aload 10
    //   146: getfield 104	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   149: getfield 116	android/graphics/RectF:top	F
    //   152: f2i
    //   153: iload_3
    //   154: aload 10
    //   156: getfield 104	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   159: getfield 119	android/graphics/RectF:bottom	F
    //   162: f2i
    //   163: invokevirtual 123	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   166: aload 10
    //   168: getfield 126	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +387 -> 561
    //   177: getstatic 128	bphm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: ldc 130
    //   182: invokestatic 136	yqp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: new 138	bphu
    //   188: dup
    //   189: aload 10
    //   191: getfield 141	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   194: getfield 146	android/graphics/PointF:x	F
    //   197: aload 10
    //   199: getfield 141	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   202: getfield 149	android/graphics/PointF:y	F
    //   205: aload 10
    //   207: getfield 151	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   210: aload 10
    //   212: getfield 153	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   215: aload 10
    //   217: getfield 155	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   220: aload 10
    //   222: getfield 157	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   225: aload 10
    //   227: getfield 160	dov/com/qq/im/capture/paster/PasterParcelData:e	F
    //   230: f2i
    //   231: aload 10
    //   233: getfield 162	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   236: f2i
    //   237: invokespecial 165	bphu:<init>	(FFFFFFII)V
    //   240: astore 8
    //   242: new 167	bphq
    //   245: dup
    //   246: aload_0
    //   247: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbphm;
    //   250: aload 7
    //   252: aload 8
    //   254: aload 10
    //   256: getfield 168	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   259: aload 10
    //   261: getfield 170	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   264: aload 10
    //   266: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   269: aload 10
    //   271: getfield 59	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   274: invokespecial 173	bphq:<init>	(Lbphm;Landroid/graphics/drawable/Drawable;Lbphu;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   277: astore 7
    //   279: aload 7
    //   281: getfield 176	bphq:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper	Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;
    //   284: aload 10
    //   286: getfield 177	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper	Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;
    //   289: invokevirtual 183	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:set	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   292: aload 7
    //   294: iconst_0
    //   295: putfield 185	bphq:e	I
    //   298: aload 7
    //   300: iconst_1
    //   301: putfield 187	bphq:jdField_f_of_type_Int	I
    //   304: aload_0
    //   305: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   308: ifnonnull +408 -> 716
    //   311: aload_0
    //   312: getfield 22	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_Boolean	Z
    //   315: ifne +395 -> 710
    //   318: iconst_1
    //   319: istore 4
    //   321: aload 7
    //   323: iload 4
    //   325: invokevirtual 190	bphq:c	(Z)V
    //   328: aload_0
    //   329: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbphm;
    //   332: getfield 193	bphm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   335: aload 7
    //   337: invokeinterface 199 2 0
    //   342: pop
    //   343: goto -306 -> 37
    //   346: aconst_null
    //   347: astore 8
    //   349: aconst_null
    //   350: astore 9
    //   352: new 201	java/io/BufferedInputStream
    //   355: dup
    //   356: new 203	java/io/FileInputStream
    //   359: dup
    //   360: aload 10
    //   362: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   365: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   368: invokespecial 209	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   371: astore 7
    //   373: aload 7
    //   375: astore 8
    //   377: new 211	android/graphics/drawable/BitmapDrawable
    //   380: dup
    //   381: aconst_null
    //   382: aload 7
    //   384: aconst_null
    //   385: aconst_null
    //   386: invokestatic 217	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   389: invokespecial 220	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   392: astore 9
    //   394: aload 7
    //   396: ifnull +590 -> 986
    //   399: aload 7
    //   401: invokevirtual 223	java/io/BufferedInputStream:close	()V
    //   404: aload 9
    //   406: astore 7
    //   408: goto -292 -> 116
    //   411: astore 7
    //   413: aload 7
    //   415: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   418: goto -14 -> 404
    //   421: astore 7
    //   423: aload 7
    //   425: athrow
    //   426: astore 9
    //   428: aconst_null
    //   429: astore 7
    //   431: aload 7
    //   433: astore 8
    //   435: getstatic 128	bphm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   438: ldc 228
    //   440: aload 9
    //   442: invokestatic 231	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload 7
    //   447: ifnull +533 -> 980
    //   450: aload 7
    //   452: invokevirtual 223	java/io/BufferedInputStream:close	()V
    //   455: aconst_null
    //   456: astore 7
    //   458: goto -342 -> 116
    //   461: astore 7
    //   463: aload 7
    //   465: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   468: goto -13 -> 455
    //   471: astore 7
    //   473: aload 7
    //   475: athrow
    //   476: astore 8
    //   478: aload 9
    //   480: astore 7
    //   482: aload 8
    //   484: astore 9
    //   486: aload 7
    //   488: astore 8
    //   490: getstatic 128	bphm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   493: ldc 228
    //   495: aload 9
    //   497: invokestatic 231	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   500: aload 7
    //   502: ifnull +478 -> 980
    //   505: aload 7
    //   507: invokevirtual 223	java/io/BufferedInputStream:close	()V
    //   510: aconst_null
    //   511: astore 7
    //   513: goto -397 -> 116
    //   516: astore 7
    //   518: aload 7
    //   520: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   523: goto -13 -> 510
    //   526: astore 7
    //   528: aload 7
    //   530: athrow
    //   531: astore 7
    //   533: aload 8
    //   535: ifnull +8 -> 543
    //   538: aload 8
    //   540: invokevirtual 223	java/io/BufferedInputStream:close	()V
    //   543: aload 7
    //   545: athrow
    //   546: astore 8
    //   548: aload 8
    //   550: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   553: goto -10 -> 543
    //   556: astore 7
    //   558: aload 7
    //   560: athrow
    //   561: getstatic 128	bphm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   564: new 233	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   571: ldc 236
    //   573: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 10
    //   578: getfield 126	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   581: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 136	yqp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: new 138	bphu
    //   593: dup
    //   594: aload 10
    //   596: getfield 141	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   599: getfield 146	android/graphics/PointF:x	F
    //   602: aload 10
    //   604: getfield 141	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   607: getfield 149	android/graphics/PointF:y	F
    //   610: aload 10
    //   612: getfield 151	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   615: aload 10
    //   617: getfield 153	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   620: aload 10
    //   622: getfield 155	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   625: aload 10
    //   627: getfield 157	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   630: aload 10
    //   632: getfield 160	dov/com/qq/im/capture/paster/PasterParcelData:e	F
    //   635: f2i
    //   636: aload 10
    //   638: getfield 162	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   641: f2i
    //   642: aload 10
    //   644: getfield 126	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   647: aload 10
    //   649: getfield 247	dov/com/qq/im/capture/paster/PasterParcelData:g	I
    //   652: aload 10
    //   654: getfield 248	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Int	I
    //   657: invokespecial 251	bphu:<init>	(FFFFFFIILjava/lang/String;II)V
    //   660: astore 8
    //   662: new 253	bphn
    //   665: dup
    //   666: aload_0
    //   667: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbphm;
    //   670: aload 7
    //   672: aload 8
    //   674: aload 10
    //   676: getfield 168	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   679: aload 10
    //   681: getfield 170	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   684: aload 10
    //   686: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   689: aload 10
    //   691: getfield 59	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   694: invokespecial 254	bphn:<init>	(Lbphm;Landroid/graphics/drawable/Drawable;Lbphu;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   697: astore 7
    //   699: aload 7
    //   701: checkcast 253	bphn
    //   704: invokevirtual 256	bphn:a	()V
    //   707: goto -428 -> 279
    //   710: iconst_0
    //   711: istore 4
    //   713: goto -392 -> 321
    //   716: aload_0
    //   717: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   720: iload_1
    //   721: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   724: astore 8
    //   726: aload 7
    //   728: aload 8
    //   730: ldc_w 264
    //   733: invokevirtual 270	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   736: invokevirtual 190	bphq:c	(Z)V
    //   739: aload 8
    //   741: ldc_w 272
    //   744: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   747: ifeq -419 -> 328
    //   750: aload 7
    //   752: aload 8
    //   754: ldc_w 272
    //   757: invokevirtual 278	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   760: putfield 280	bphq:g	Z
    //   763: aload 7
    //   765: aload 8
    //   767: ldc_w 282
    //   770: invokevirtual 278	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   773: putfield 285	bphq:h	Z
    //   776: aload 7
    //   778: aload 8
    //   780: ldc_w 287
    //   783: invokevirtual 291	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   786: d2f
    //   787: putfield 294	bphq:j	F
    //   790: aload 7
    //   792: aload 8
    //   794: ldc_w 296
    //   797: invokevirtual 291	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   800: d2f
    //   801: putfield 299	bphq:k	F
    //   804: aload 7
    //   806: aload 8
    //   808: ldc_w 301
    //   811: invokevirtual 291	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   814: d2f
    //   815: putfield 304	bphq:l	F
    //   818: aload 7
    //   820: aload 8
    //   822: ldc_w 306
    //   825: invokevirtual 291	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   828: d2f
    //   829: putfield 309	bphq:m	F
    //   832: aload 7
    //   834: aload 8
    //   836: ldc_w 282
    //   839: invokevirtual 278	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   842: putfield 285	bphq:h	Z
    //   845: aload 7
    //   847: aload 8
    //   849: ldc_w 287
    //   852: invokevirtual 291	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   855: d2f
    //   856: putfield 294	bphq:j	F
    //   859: aload 7
    //   861: aload 8
    //   863: ldc_w 311
    //   866: invokevirtual 315	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   869: putfield 318	bphq:i	I
    //   872: aload 8
    //   874: ldc_w 320
    //   877: invokevirtual 324	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   880: astore 8
    //   882: lconst_0
    //   883: lstore 5
    //   885: iconst_0
    //   886: istore_2
    //   887: iload_2
    //   888: aload 8
    //   890: invokevirtual 327	org/json/JSONArray:length	()I
    //   893: if_icmpge -565 -> 328
    //   896: iload_2
    //   897: iconst_2
    //   898: irem
    //   899: ifne +14 -> 913
    //   902: aload 8
    //   904: iload_2
    //   905: invokevirtual 331	org/json/JSONArray:getLong	(I)J
    //   908: lstore 5
    //   910: goto +89 -> 999
    //   913: new 333	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo
    //   916: dup
    //   917: aload 8
    //   919: iload_2
    //   920: invokevirtual 262	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   923: invokespecial 336	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo:<init>	(Lorg/json/JSONObject;)V
    //   926: astore 9
    //   928: aload 7
    //   930: getfield 339	bphq:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   933: lload 5
    //   935: invokestatic 345	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   938: aload 9
    //   940: invokeinterface 351 3 0
    //   945: pop
    //   946: goto +53 -> 999
    //   949: astore 8
    //   951: goto -623 -> 328
    //   954: aload_0
    //   955: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbphm;
    //   958: invokestatic 353	bphm:b	(Lbphm;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   961: invokevirtual 358	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:postInvalidate	()V
    //   964: return
    //   965: astore 7
    //   967: goto -434 -> 533
    //   970: astore 9
    //   972: goto -486 -> 486
    //   975: astore 9
    //   977: goto -546 -> 431
    //   980: aconst_null
    //   981: astore 7
    //   983: goto -867 -> 116
    //   986: aload 9
    //   988: astore 7
    //   990: goto -874 -> 116
    //   993: aconst_null
    //   994: astore 7
    //   996: goto -880 -> 116
    //   999: iload_2
    //   1000: iconst_1
    //   1001: iadd
    //   1002: istore_2
    //   1003: goto -116 -> 887
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	1
    //   1	720	1	i	int
    //   130	873	2	j	int
    //   140	14	3	k	int
    //   319	393	4	bool	boolean
    //   883	51	5	l	long
    //   83	324	7	localObject1	Object
    //   411	3	7	localIOException1	java.io.IOException
    //   421	3	7	localObject2	Object
    //   429	28	7	localObject3	Object
    //   461	3	7	localIOException2	java.io.IOException
    //   471	3	7	localObject4	Object
    //   480	32	7	localObject5	Object
    //   516	3	7	localIOException3	java.io.IOException
    //   526	3	7	localObject6	Object
    //   531	13	7	localObject7	Object
    //   556	115	7	localDrawable	android.graphics.drawable.Drawable
    //   697	232	7	localbphn	bphn
    //   965	1	7	localObject8	Object
    //   981	14	7	localObject9	Object
    //   240	194	8	localObject10	Object
    //   476	7	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   488	51	8	localObject11	Object
    //   546	3	8	localIOException4	java.io.IOException
    //   660	258	8	localObject12	Object
    //   949	1	8	localException	java.lang.Exception
    //   350	55	9	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    //   426	53	9	localIOException5	java.io.IOException
    //   484	455	9	localObject13	Object
    //   970	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   975	12	9	localIOException6	java.io.IOException
    //   24	666	10	localPasterParcelData	dov.com.qq.im.capture.paster.PasterParcelData
    // Exception table:
    //   from	to	target	type
    //   399	404	411	java/io/IOException
    //   399	404	421	finally
    //   413	418	421	finally
    //   352	373	426	java/io/IOException
    //   450	455	461	java/io/IOException
    //   450	455	471	finally
    //   463	468	471	finally
    //   352	373	476	java/lang/OutOfMemoryError
    //   505	510	516	java/io/IOException
    //   505	510	526	finally
    //   518	523	526	finally
    //   352	373	531	finally
    //   490	500	531	finally
    //   538	543	546	java/io/IOException
    //   538	543	556	finally
    //   548	553	556	finally
    //   716	882	949	java/lang/Exception
    //   887	896	949	java/lang/Exception
    //   902	910	949	java/lang/Exception
    //   913	946	949	java/lang/Exception
    //   377	394	965	finally
    //   435	445	965	finally
    //   377	394	970	java/lang/OutOfMemoryError
    //   377	394	975	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1
 * JD-Core Version:    0.7.0.1
 */