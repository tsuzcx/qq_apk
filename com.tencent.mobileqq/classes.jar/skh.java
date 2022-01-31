import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

public final class skh
  implements Runnable
{
  public skh(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Activity paramActivity, int paramInt, QQProgressDialog paramQQProgressDialog) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_2
    //   5: lconst_1
    //   6: aload_0
    //   7: getfield 20	skh:jdField_a_of_type_Long	J
    //   10: lcmp
    //   11: ifne +613 -> 624
    //   14: invokestatic 48	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   17: ifeq +377 -> 394
    //   20: getstatic 53	com/tencent/mobileqq/app/AppConstants:bm	Ljava/lang/String;
    //   23: astore 4
    //   25: new 55	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   32: aload 4
    //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 62
    //   39: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 4
    //   47: new 68	java/io/File
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 74	java/io/File:exists	()Z
    //   63: ifeq +338 -> 401
    //   66: iconst_1
    //   67: istore_1
    //   68: iload_1
    //   69: ifne +778 -> 847
    //   72: ldc 76
    //   74: astore 5
    //   76: new 78	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder
    //   79: dup
    //   80: ldc 80
    //   82: invokespecial 83	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:<init>	(Ljava/lang/Class;)V
    //   85: bipush 15
    //   87: invokevirtual 86	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:b	(I)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   90: new 55	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   97: ldc 88
    //   99: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 28	skh:c	Ljava/lang/String;
    //   106: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 91	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   115: aload_0
    //   116: getfield 30	skh:d	Ljava/lang/String;
    //   119: invokevirtual 93	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/structmsg/AbsShareMsg$Builder;
    //   122: invokevirtual 96	com/tencent/mobileqq/structmsg/AbsShareMsg$Builder:a	()Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   125: astore 8
    //   127: aload_0
    //   128: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   131: bipush 50
    //   133: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   136: checkcast 104	com/tencent/mobileqq/app/FriendsManager
    //   139: astore 9
    //   141: aload_0
    //   142: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: bipush 52
    //   147: invokevirtual 102	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   150: checkcast 106	com/tencent/mobileqq/app/DiscussionManager
    //   153: astore 10
    //   155: aload 7
    //   157: astore 4
    //   159: aload 9
    //   161: ifnull +55 -> 216
    //   164: aload 10
    //   166: aload_0
    //   167: getfield 24	skh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokevirtual 109	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   173: astore 6
    //   175: aload 7
    //   177: astore 4
    //   179: aload 6
    //   181: ifnull +35 -> 216
    //   184: aload 10
    //   186: aload_0
    //   187: getfield 24	skh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: aload 6
    //   192: getfield 114	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   195: invokevirtual 117	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   198: astore 4
    //   200: aload 4
    //   202: ifnull +547 -> 749
    //   205: aload 4
    //   207: aload_0
    //   208: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: invokestatic 122	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   214: astore 4
    //   216: aload 4
    //   218: astore 6
    //   220: aload 4
    //   222: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifeq +7 -> 232
    //   228: ldc 130
    //   230: astore 6
    //   232: new 132	com/tencent/mobileqq/structmsg/view/StructMsgItemLayoutDefault
    //   235: dup
    //   236: invokespecial 133	com/tencent/mobileqq/structmsg/view/StructMsgItemLayoutDefault:<init>	()V
    //   239: astore 4
    //   241: aload 4
    //   243: iconst_1
    //   244: invokevirtual 138	com/tencent/mobileqq/structmsg/AbsStructMsgItem:b	(I)V
    //   247: aload 4
    //   249: aload_0
    //   250: getfield 32	skh:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   253: ldc 139
    //   255: invokevirtual 145	android/app/Activity:getString	(I)Ljava/lang/String;
    //   258: invokevirtual 147	com/tencent/mobileqq/structmsg/AbsStructMsgItem:a	(Ljava/lang/String;)V
    //   261: iconst_2
    //   262: invokestatic 152	com/tencent/mobileqq/structmsg/StructMsgElementFactory:a	(I)Lcom/tencent/mobileqq/structmsg/AbsStructMsgItem;
    //   265: astore 7
    //   267: aload 7
    //   269: aload 5
    //   271: aload_0
    //   272: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: aload_0
    //   276: getfield 28	skh:c	Ljava/lang/String;
    //   279: aload_0
    //   280: getfield 24	skh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   283: invokestatic 157	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   286: new 55	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   293: ldc 159
    //   295: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 6
    //   300: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: iconst_1
    //   307: invokevirtual 162	com/tencent/mobileqq/structmsg/AbsStructMsgItem:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   310: aload 8
    //   312: aload 4
    //   314: invokevirtual 168	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;)V
    //   317: aload 8
    //   319: aload 7
    //   321: invokevirtual 168	com/tencent/mobileqq/structmsg/AbsShareMsg:addItem	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;)V
    //   324: new 170	android/content/Intent
    //   327: dup
    //   328: invokespecial 171	android/content/Intent:<init>	()V
    //   331: astore 4
    //   333: aload 4
    //   335: ldc 173
    //   337: bipush 253
    //   339: invokevirtual 177	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   342: pop
    //   343: aload 4
    //   345: ldc 179
    //   347: aload 8
    //   349: invokevirtual 183	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   352: invokevirtual 186	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   355: pop
    //   356: aload_0
    //   357: getfield 32	skh:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   360: aload 4
    //   362: aload_0
    //   363: getfield 34	skh:jdField_a_of_type_Int	I
    //   366: invokestatic 191	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   369: aload_0
    //   370: getfield 36	skh:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   373: ifnull +20 -> 393
    //   376: aload_0
    //   377: getfield 36	skh:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   380: invokevirtual 196	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   383: ifeq +10 -> 393
    //   386: aload_0
    //   387: getfield 36	skh:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   390: invokevirtual 199	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   393: return
    //   394: ldc 201
    //   396: astore 4
    //   398: goto -373 -> 25
    //   401: aload 5
    //   403: invokevirtual 204	java/io/File:createNewFile	()Z
    //   406: pop
    //   407: new 206	java/io/BufferedOutputStream
    //   410: dup
    //   411: new 208	java/io/FileOutputStream
    //   414: dup
    //   415: aload 5
    //   417: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   420: sipush 8192
    //   423: invokespecial 214	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   426: astore 6
    //   428: invokestatic 220	com/tencent/mobileqq/utils/ImageUtil:e	()Landroid/graphics/drawable/Drawable;
    //   431: checkcast 222	android/graphics/drawable/BitmapDrawable
    //   434: invokevirtual 226	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   437: getstatic 232	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   440: bipush 100
    //   442: aload 6
    //   444: invokevirtual 238	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   447: istore_3
    //   448: iload_3
    //   449: ifeq +421 -> 870
    //   452: iconst_1
    //   453: istore_2
    //   454: aload 4
    //   456: astore 5
    //   458: aload 5
    //   460: astore 4
    //   462: iload_2
    //   463: istore_1
    //   464: aload 6
    //   466: ifnull -398 -> 68
    //   469: aload 6
    //   471: invokevirtual 243	java/io/OutputStream:close	()V
    //   474: aload 5
    //   476: astore 4
    //   478: iload_2
    //   479: istore_1
    //   480: goto -412 -> 68
    //   483: astore 6
    //   485: aload 5
    //   487: astore 4
    //   489: iload_2
    //   490: istore_1
    //   491: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   494: ifeq -426 -> 68
    //   497: ldc 250
    //   499: iconst_2
    //   500: aload 6
    //   502: invokevirtual 253	java/io/IOException:getMessage	()Ljava/lang/String;
    //   505: aload 6
    //   507: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 5
    //   512: astore 4
    //   514: iload_2
    //   515: istore_1
    //   516: goto -448 -> 68
    //   519: astore 5
    //   521: aconst_null
    //   522: astore 4
    //   524: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +8 -> 535
    //   530: aload 5
    //   532: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   535: aload 4
    //   537: ifnull +325 -> 862
    //   540: aload 4
    //   542: invokevirtual 243	java/io/OutputStream:close	()V
    //   545: aconst_null
    //   546: astore 4
    //   548: iconst_0
    //   549: istore_1
    //   550: goto -482 -> 68
    //   553: astore 4
    //   555: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +16 -> 574
    //   561: ldc 250
    //   563: iconst_2
    //   564: aload 4
    //   566: invokevirtual 253	java/io/IOException:getMessage	()Ljava/lang/String;
    //   569: aload 4
    //   571: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   574: aconst_null
    //   575: astore 4
    //   577: iconst_0
    //   578: istore_1
    //   579: goto -511 -> 68
    //   582: astore 4
    //   584: aconst_null
    //   585: astore 5
    //   587: aload 5
    //   589: ifnull +8 -> 597
    //   592: aload 5
    //   594: invokevirtual 243	java/io/OutputStream:close	()V
    //   597: aload 4
    //   599: athrow
    //   600: astore 5
    //   602: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq -8 -> 597
    //   608: ldc 250
    //   610: iconst_2
    //   611: aload 5
    //   613: invokevirtual 253	java/io/IOException:getMessage	()Ljava/lang/String;
    //   616: aload 5
    //   618: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: goto -24 -> 597
    //   624: new 261	java/util/ArrayList
    //   627: dup
    //   628: invokespecial 262	java/util/ArrayList:<init>	()V
    //   631: astore 4
    //   633: aload 4
    //   635: aload_0
    //   636: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   639: bipush 101
    //   641: aload_0
    //   642: getfield 24	skh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   645: iconst_0
    //   646: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   649: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   652: pop
    //   653: aload 4
    //   655: aload_0
    //   656: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   659: invokevirtual 272	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   662: aload_0
    //   663: getfield 26	skh:b	Ljava/lang/String;
    //   666: ldc_w 274
    //   669: invokestatic 279	cooperation/qzone/QZoneShareManager:a	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   672: astore 4
    //   674: aload 4
    //   676: ifnull +178 -> 854
    //   679: aload 4
    //   681: invokevirtual 283	java/util/ArrayList:size	()I
    //   684: ifle +170 -> 854
    //   687: aload 4
    //   689: iconst_0
    //   690: invokevirtual 287	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   693: checkcast 289	java/lang/String
    //   696: astore 5
    //   698: aload 5
    //   700: astore 4
    //   702: iload_2
    //   703: istore_1
    //   704: aload 5
    //   706: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne -641 -> 68
    //   712: aload 5
    //   714: ldc_w 291
    //   717: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   720: ifne +20 -> 740
    //   723: aload 5
    //   725: astore 4
    //   727: iload_2
    //   728: istore_1
    //   729: aload 5
    //   731: ldc_w 297
    //   734: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   737: ifeq -669 -> 68
    //   740: iconst_1
    //   741: istore_1
    //   742: aload 5
    //   744: astore 4
    //   746: goto -678 -> 68
    //   749: aload 9
    //   751: aload 6
    //   753: getfield 114	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   756: invokevirtual 299	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   759: ifeq +20 -> 779
    //   762: aload_0
    //   763: getfield 22	skh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   766: aload 6
    //   768: getfield 114	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   771: invokestatic 303	com/tencent/mobileqq/utils/ContactUtils:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   774: astore 4
    //   776: goto -560 -> 216
    //   779: aload 9
    //   781: aload 6
    //   783: getfield 114	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   786: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   789: astore 4
    //   791: aload 4
    //   793: ifnull +13 -> 806
    //   796: aload 4
    //   798: getfield 311	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   801: astore 4
    //   803: goto -587 -> 216
    //   806: aload 6
    //   808: getfield 114	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   811: astore 4
    //   813: goto -597 -> 216
    //   816: astore 4
    //   818: aload 6
    //   820: astore 5
    //   822: goto -235 -> 587
    //   825: astore 6
    //   827: aload 4
    //   829: astore 5
    //   831: aload 6
    //   833: astore 4
    //   835: goto -248 -> 587
    //   838: astore 5
    //   840: aload 6
    //   842: astore 4
    //   844: goto -320 -> 524
    //   847: aload 4
    //   849: astore 5
    //   851: goto -775 -> 76
    //   854: aconst_null
    //   855: astore 4
    //   857: iload_2
    //   858: istore_1
    //   859: goto -791 -> 68
    //   862: aconst_null
    //   863: astore 4
    //   865: iconst_0
    //   866: istore_1
    //   867: goto -799 -> 68
    //   870: aconst_null
    //   871: astore 5
    //   873: iconst_0
    //   874: istore_2
    //   875: goto -417 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	878	0	this	skh
    //   67	800	1	i	int
    //   4	871	2	j	int
    //   447	2	3	bool	boolean
    //   23	524	4	localObject1	Object
    //   553	17	4	localIOException1	java.io.IOException
    //   575	1	4	localObject2	Object
    //   582	16	4	localObject3	Object
    //   631	181	4	localObject4	Object
    //   816	12	4	localObject5	Object
    //   833	31	4	localObject6	Object
    //   56	455	5	localObject7	Object
    //   519	12	5	localIOException2	java.io.IOException
    //   585	8	5	localObject8	Object
    //   600	17	5	localIOException3	java.io.IOException
    //   696	134	5	localObject9	Object
    //   838	1	5	localIOException4	java.io.IOException
    //   849	23	5	localObject10	Object
    //   173	297	6	localObject11	Object
    //   483	336	6	localIOException5	java.io.IOException
    //   825	16	6	localObject12	Object
    //   1	319	7	localAbsStructMsgItem	com.tencent.mobileqq.structmsg.AbsStructMsgItem
    //   125	223	8	localAbsShareMsg	com.tencent.mobileqq.structmsg.AbsShareMsg
    //   139	641	9	localFriendsManager	com.tencent.mobileqq.app.FriendsManager
    //   153	32	10	localDiscussionManager	com.tencent.mobileqq.app.DiscussionManager
    // Exception table:
    //   from	to	target	type
    //   469	474	483	java/io/IOException
    //   401	428	519	java/io/IOException
    //   540	545	553	java/io/IOException
    //   401	428	582	finally
    //   592	597	600	java/io/IOException
    //   428	448	816	finally
    //   524	535	825	finally
    //   428	448	838	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     skh
 * JD-Core Version:    0.7.0.1
 */