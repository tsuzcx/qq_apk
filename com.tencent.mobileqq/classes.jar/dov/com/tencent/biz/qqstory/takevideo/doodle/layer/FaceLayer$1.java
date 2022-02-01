package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import bnfz;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceLayer$1
  implements Runnable
{
  public FaceLayer$1(bnfz parambnfz, ArrayList paramArrayList, JSONArray paramJSONArray, boolean paramBoolean) {}
  
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
    //   10: if_icmpge +930 -> 940
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
    //   50: if_icmpne +283 -> 333
    //   53: getstatic 65	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   56: invokevirtual 69	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   59: aload 10
    //   61: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   64: ldc 71
    //   66: getstatic 77	com/tencent/mobileqq/transfile/URLDrawableHelper:TRANSPARENT	Landroid/graphics/drawable/Drawable;
    //   69: iconst_1
    //   70: newarray int
    //   72: dup
    //   73: iconst_0
    //   74: bipush 13
    //   76: iastore
    //   77: ldc 71
    //   79: aconst_null
    //   80: invokestatic 83	com/tencent/mobileqq/vas/VasApngUtil:getApngDrawable	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   83: astore 7
    //   85: aload 7
    //   87: ifnull +892 -> 979
    //   90: aload 7
    //   92: invokevirtual 88	com/tencent/image/URLDrawable:getStatus	()I
    //   95: iconst_1
    //   96: if_icmpeq +8 -> 104
    //   99: aload 7
    //   101: invokevirtual 91	com/tencent/image/URLDrawable:restartDownload	()V
    //   104: aload 7
    //   106: aload_0
    //   107: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbnfz;
    //   110: invokestatic 96	bnfz:a	(Lbnfz;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   113: invokevirtual 102	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   116: aload 7
    //   118: ifnull -81 -> 37
    //   121: aload 10
    //   123: getfield 105	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   126: getfield 111	android/graphics/RectF:left	F
    //   129: f2i
    //   130: istore_2
    //   131: aload 10
    //   133: getfield 105	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   136: getfield 114	android/graphics/RectF:right	F
    //   139: f2i
    //   140: istore_3
    //   141: aload 7
    //   143: iload_2
    //   144: aload 10
    //   146: getfield 105	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   149: getfield 117	android/graphics/RectF:top	F
    //   152: f2i
    //   153: iload_3
    //   154: aload 10
    //   156: getfield 105	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsRectF	Landroid/graphics/RectF;
    //   159: getfield 120	android/graphics/RectF:bottom	F
    //   162: f2i
    //   163: invokevirtual 124	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   166: aload 10
    //   168: getfield 127	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +374 -> 548
    //   177: getstatic 129	bnfz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: ldc 131
    //   182: invokestatic 137	xvv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: new 139	bngh
    //   188: dup
    //   189: aload 10
    //   191: getfield 142	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   194: getfield 147	android/graphics/PointF:x	F
    //   197: aload 10
    //   199: getfield 142	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   202: getfield 150	android/graphics/PointF:y	F
    //   205: aload 10
    //   207: getfield 152	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   210: aload 10
    //   212: getfield 154	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   215: aload 10
    //   217: getfield 156	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   220: aload 10
    //   222: getfield 158	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   225: aload 10
    //   227: getfield 161	dov/com/qq/im/capture/paster/PasterParcelData:e	F
    //   230: f2i
    //   231: aload 10
    //   233: getfield 163	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   236: f2i
    //   237: invokespecial 166	bngh:<init>	(FFFFFFII)V
    //   240: astore 8
    //   242: new 168	bngd
    //   245: dup
    //   246: aload_0
    //   247: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbnfz;
    //   250: aload 7
    //   252: aload 8
    //   254: aload 10
    //   256: getfield 169	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   259: aload 10
    //   261: getfield 171	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   264: aload 10
    //   266: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   269: aload 10
    //   271: getfield 59	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   274: invokespecial 174	bngd:<init>	(Lbnfz;Landroid/graphics/drawable/Drawable;Lbngh;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   277: astore 7
    //   279: aload 7
    //   281: iconst_0
    //   282: putfield 176	bngd:e	I
    //   285: aload 7
    //   287: iconst_1
    //   288: putfield 178	bngd:jdField_f_of_type_Int	I
    //   291: aload_0
    //   292: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   295: ifnonnull +408 -> 703
    //   298: aload_0
    //   299: getfield 22	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_Boolean	Z
    //   302: ifne +395 -> 697
    //   305: iconst_1
    //   306: istore 4
    //   308: aload 7
    //   310: iload 4
    //   312: invokevirtual 181	bngd:c	(Z)V
    //   315: aload_0
    //   316: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbnfz;
    //   319: getfield 184	bnfz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   322: aload 7
    //   324: invokeinterface 190 2 0
    //   329: pop
    //   330: goto -293 -> 37
    //   333: aconst_null
    //   334: astore 8
    //   336: aconst_null
    //   337: astore 9
    //   339: new 192	java/io/BufferedInputStream
    //   342: dup
    //   343: new 194	java/io/FileInputStream
    //   346: dup
    //   347: aload 10
    //   349: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokespecial 197	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   355: invokespecial 200	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   358: astore 7
    //   360: aload 7
    //   362: astore 8
    //   364: new 202	android/graphics/drawable/BitmapDrawable
    //   367: dup
    //   368: aconst_null
    //   369: aload 7
    //   371: aconst_null
    //   372: aconst_null
    //   373: invokestatic 208	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   376: invokespecial 211	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   379: astore 9
    //   381: aload 7
    //   383: ifnull +589 -> 972
    //   386: aload 7
    //   388: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   391: aload 9
    //   393: astore 7
    //   395: goto -279 -> 116
    //   398: astore 7
    //   400: aload 7
    //   402: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   405: goto -14 -> 391
    //   408: astore 7
    //   410: aload 7
    //   412: athrow
    //   413: astore 9
    //   415: aconst_null
    //   416: astore 7
    //   418: aload 7
    //   420: astore 8
    //   422: getstatic 129	bnfz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   425: ldc 219
    //   427: aload 9
    //   429: invokestatic 222	xvv:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: aload 7
    //   434: ifnull +532 -> 966
    //   437: aload 7
    //   439: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   442: aconst_null
    //   443: astore 7
    //   445: goto -329 -> 116
    //   448: astore 7
    //   450: aload 7
    //   452: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   455: goto -13 -> 442
    //   458: astore 7
    //   460: aload 7
    //   462: athrow
    //   463: astore 8
    //   465: aload 9
    //   467: astore 7
    //   469: aload 8
    //   471: astore 9
    //   473: aload 7
    //   475: astore 8
    //   477: getstatic 129	bnfz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   480: ldc 219
    //   482: aload 9
    //   484: invokestatic 222	xvv:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   487: aload 7
    //   489: ifnull +477 -> 966
    //   492: aload 7
    //   494: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   497: aconst_null
    //   498: astore 7
    //   500: goto -384 -> 116
    //   503: astore 7
    //   505: aload 7
    //   507: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   510: goto -13 -> 497
    //   513: astore 7
    //   515: aload 7
    //   517: athrow
    //   518: astore 7
    //   520: aload 8
    //   522: ifnull +8 -> 530
    //   525: aload 8
    //   527: invokevirtual 214	java/io/BufferedInputStream:close	()V
    //   530: aload 7
    //   532: athrow
    //   533: astore 8
    //   535: aload 8
    //   537: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   540: goto -10 -> 530
    //   543: astore 7
    //   545: aload 7
    //   547: athrow
    //   548: getstatic 129	bnfz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   551: new 224	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   558: ldc 227
    //   560: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 10
    //   565: getfield 127	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   568: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 137	xvv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: new 139	bngh
    //   580: dup
    //   581: aload 10
    //   583: getfield 142	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   586: getfield 147	android/graphics/PointF:x	F
    //   589: aload 10
    //   591: getfield 142	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_AndroidGraphicsPointF	Landroid/graphics/PointF;
    //   594: getfield 150	android/graphics/PointF:y	F
    //   597: aload 10
    //   599: getfield 152	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_Float	F
    //   602: aload 10
    //   604: getfield 154	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_Float	F
    //   607: aload 10
    //   609: getfield 156	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_Float	F
    //   612: aload 10
    //   614: getfield 158	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Float	F
    //   617: aload 10
    //   619: getfield 161	dov/com/qq/im/capture/paster/PasterParcelData:e	F
    //   622: f2i
    //   623: aload 10
    //   625: getfield 163	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Float	F
    //   628: f2i
    //   629: aload 10
    //   631: getfield 127	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   634: aload 10
    //   636: getfield 238	dov/com/qq/im/capture/paster/PasterParcelData:g	I
    //   639: aload 10
    //   641: getfield 239	dov/com/qq/im/capture/paster/PasterParcelData:jdField_f_of_type_Int	I
    //   644: invokespecial 242	bngh:<init>	(FFFFFFIILjava/lang/String;II)V
    //   647: astore 8
    //   649: new 244	bnga
    //   652: dup
    //   653: aload_0
    //   654: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbnfz;
    //   657: aload 7
    //   659: aload 8
    //   661: aload 10
    //   663: getfield 169	dov/com/qq/im/capture/paster/PasterParcelData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   666: aload 10
    //   668: getfield 171	dov/com/qq/im/capture/paster/PasterParcelData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   671: aload 10
    //   673: getfield 49	dov/com/qq/im/capture/paster/PasterParcelData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   676: aload 10
    //   678: getfield 59	dov/com/qq/im/capture/paster/PasterParcelData:jdField_d_of_type_Int	I
    //   681: invokespecial 245	bnga:<init>	(Lbnfz;Landroid/graphics/drawable/Drawable;Lbngh;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   684: astore 7
    //   686: aload 7
    //   688: checkcast 244	bnga
    //   691: invokevirtual 247	bnga:a	()V
    //   694: goto -415 -> 279
    //   697: iconst_0
    //   698: istore 4
    //   700: goto -392 -> 308
    //   703: aload_0
    //   704: getfield 20	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   707: iload_1
    //   708: invokevirtual 253	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   711: astore 8
    //   713: aload 7
    //   715: aload 8
    //   717: ldc 255
    //   719: invokevirtual 261	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   722: invokevirtual 181	bngd:c	(Z)V
    //   725: aload 8
    //   727: ldc_w 263
    //   730: invokevirtual 266	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   733: ifeq -418 -> 315
    //   736: aload 7
    //   738: aload 8
    //   740: ldc_w 263
    //   743: invokevirtual 269	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   746: putfield 271	bngd:g	Z
    //   749: aload 7
    //   751: aload 8
    //   753: ldc_w 273
    //   756: invokevirtual 269	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   759: putfield 276	bngd:h	Z
    //   762: aload 7
    //   764: aload 8
    //   766: ldc_w 278
    //   769: invokevirtual 282	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   772: d2f
    //   773: putfield 285	bngd:j	F
    //   776: aload 7
    //   778: aload 8
    //   780: ldc_w 287
    //   783: invokevirtual 282	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   786: d2f
    //   787: putfield 290	bngd:k	F
    //   790: aload 7
    //   792: aload 8
    //   794: ldc_w 292
    //   797: invokevirtual 282	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   800: d2f
    //   801: putfield 295	bngd:l	F
    //   804: aload 7
    //   806: aload 8
    //   808: ldc_w 297
    //   811: invokevirtual 282	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   814: d2f
    //   815: putfield 300	bngd:m	F
    //   818: aload 7
    //   820: aload 8
    //   822: ldc_w 273
    //   825: invokevirtual 269	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   828: putfield 276	bngd:h	Z
    //   831: aload 7
    //   833: aload 8
    //   835: ldc_w 278
    //   838: invokevirtual 282	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   841: d2f
    //   842: putfield 285	bngd:j	F
    //   845: aload 7
    //   847: aload 8
    //   849: ldc_w 302
    //   852: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   855: putfield 309	bngd:i	I
    //   858: aload 8
    //   860: ldc_w 311
    //   863: invokevirtual 315	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   866: astore 8
    //   868: lconst_0
    //   869: lstore 5
    //   871: iconst_0
    //   872: istore_2
    //   873: iload_2
    //   874: aload 8
    //   876: invokevirtual 318	org/json/JSONArray:length	()I
    //   879: if_icmpge -564 -> 315
    //   882: iload_2
    //   883: iconst_2
    //   884: irem
    //   885: ifne +14 -> 899
    //   888: aload 8
    //   890: iload_2
    //   891: invokevirtual 322	org/json/JSONArray:getLong	(I)J
    //   894: lstore 5
    //   896: goto +89 -> 985
    //   899: new 324	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo
    //   902: dup
    //   903: aload 8
    //   905: iload_2
    //   906: invokevirtual 253	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   909: invokespecial 327	com/tencent/mobileqq/richmedia/capture/data/TrackerStickerParam$MotionInfo:<init>	(Lorg/json/JSONObject;)V
    //   912: astore 9
    //   914: aload 7
    //   916: getfield 330	bngd:a	Ljava/util/Map;
    //   919: lload 5
    //   921: invokestatic 336	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   924: aload 9
    //   926: invokeinterface 342 3 0
    //   931: pop
    //   932: goto +53 -> 985
    //   935: astore 8
    //   937: goto -622 -> 315
    //   940: aload_0
    //   941: getfield 16	dov/com/tencent/biz/qqstory/takevideo/doodle/layer/FaceLayer$1:this$0	Lbnfz;
    //   944: invokestatic 344	bnfz:b	(Lbnfz;)Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   947: invokevirtual 349	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:postInvalidate	()V
    //   950: return
    //   951: astore 7
    //   953: goto -433 -> 520
    //   956: astore 9
    //   958: goto -485 -> 473
    //   961: astore 9
    //   963: goto -545 -> 418
    //   966: aconst_null
    //   967: astore 7
    //   969: goto -853 -> 116
    //   972: aload 9
    //   974: astore 7
    //   976: goto -860 -> 116
    //   979: aconst_null
    //   980: astore 7
    //   982: goto -866 -> 116
    //   985: iload_2
    //   986: iconst_1
    //   987: iadd
    //   988: istore_2
    //   989: goto -116 -> 873
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	992	0	this	1
    //   1	707	1	i	int
    //   130	859	2	j	int
    //   140	14	3	k	int
    //   306	393	4	bool	boolean
    //   869	51	5	l	long
    //   83	311	7	localObject1	Object
    //   398	3	7	localIOException1	java.io.IOException
    //   408	3	7	localObject2	Object
    //   416	28	7	localObject3	Object
    //   448	3	7	localIOException2	java.io.IOException
    //   458	3	7	localObject4	Object
    //   467	32	7	localObject5	Object
    //   503	3	7	localIOException3	java.io.IOException
    //   513	3	7	localObject6	Object
    //   518	13	7	localObject7	Object
    //   543	115	7	localDrawable	android.graphics.drawable.Drawable
    //   684	231	7	localbnga	bnga
    //   951	1	7	localObject8	Object
    //   967	14	7	localObject9	Object
    //   240	181	8	localObject10	Object
    //   463	7	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   475	51	8	localObject11	Object
    //   533	3	8	localIOException4	java.io.IOException
    //   647	257	8	localObject12	Object
    //   935	1	8	localException	java.lang.Exception
    //   337	55	9	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    //   413	53	9	localIOException5	java.io.IOException
    //   471	454	9	localObject13	Object
    //   956	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   961	12	9	localIOException6	java.io.IOException
    //   24	653	10	localPasterParcelData	dov.com.qq.im.capture.paster.PasterParcelData
    // Exception table:
    //   from	to	target	type
    //   386	391	398	java/io/IOException
    //   386	391	408	finally
    //   400	405	408	finally
    //   339	360	413	java/io/IOException
    //   437	442	448	java/io/IOException
    //   437	442	458	finally
    //   450	455	458	finally
    //   339	360	463	java/lang/OutOfMemoryError
    //   492	497	503	java/io/IOException
    //   492	497	513	finally
    //   505	510	513	finally
    //   339	360	518	finally
    //   477	487	518	finally
    //   525	530	533	java/io/IOException
    //   525	530	543	finally
    //   535	540	543	finally
    //   703	868	935	java/lang/Exception
    //   873	882	935	java/lang/Exception
    //   888	896	935	java/lang/Exception
    //   899	932	935	java/lang/Exception
    //   364	381	951	finally
    //   422	432	951	finally
    //   364	381	956	java/lang/OutOfMemoryError
    //   364	381	961	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.1
 * JD-Core Version:    0.7.0.1
 */