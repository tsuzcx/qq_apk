package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import android.content.Intent;
import bgxd;

public class SwiftBrowserStatistics$4
  implements Runnable
{
  public SwiftBrowserStatistics$4(bgxd parambgxd, String paramString1, Intent paramIntent, Context paramContext, long paramLong, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 43	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +157 -> 168
    //   14: aload 4
    //   16: invokevirtual 47	android/net/Uri:getHost	()Ljava/lang/String;
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +13 -> 39
    //   29: aload 5
    //   31: ldc 55
    //   33: invokevirtual 61	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifne +33 -> 69
    //   39: aload_0
    //   40: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   43: getfield 66	bgxd:a	Lbgxf;
    //   46: getfield 71	bgxf:jdField_a_of_type_Int	I
    //   49: bipush 11
    //   51: if_icmpge +18 -> 69
    //   54: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +869 -> 926
    //   60: ldc 79
    //   62: iconst_2
    //   63: ldc 81
    //   65: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: return
    //   69: aload 4
    //   71: ldc 87
    //   73: invokevirtual 91	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 5
    //   78: aload 5
    //   80: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +20 -> 103
    //   86: aload_0
    //   87: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   90: getfield 66	bgxd:a	Lbgxf;
    //   93: aload 5
    //   95: ldc 93
    //   97: invokevirtual 96	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: putfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   103: aload_0
    //   104: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   107: getfield 66	bgxd:a	Lbgxf;
    //   110: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   113: ifne +23 -> 136
    //   116: aload_0
    //   117: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   120: getfield 66	bgxd:a	Lbgxf;
    //   123: aload_0
    //   124: getfield 22	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   127: ldc 101
    //   129: iconst_0
    //   130: invokevirtual 107	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   133: putfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   136: aload 4
    //   138: ldc 109
    //   140: invokevirtual 91	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 4
    //   145: aload 4
    //   147: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +18 -> 168
    //   153: aload_0
    //   154: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   157: getfield 66	bgxd:a	Lbgxf;
    //   160: aload 4
    //   162: invokestatic 115	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 117	bgxf:b	I
    //   168: aload_0
    //   169: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: ldc 119
    //   174: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   177: istore_1
    //   178: iload_1
    //   179: iconst_m1
    //   180: if_icmpeq +702 -> 882
    //   183: aload_0
    //   184: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: iconst_0
    //   188: iload_1
    //   189: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   192: astore 4
    //   194: bipush 10
    //   196: istore_1
    //   197: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   200: invokevirtual 133	java/util/HashMap:isEmpty	()Z
    //   203: ifeq +55 -> 258
    //   206: aload_0
    //   207: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   210: aload_0
    //   211: getfield 24	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   214: aload_0
    //   215: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   218: getfield 66	bgxd:a	Lbgxf;
    //   221: invokevirtual 136	bgxd:a	(Landroid/content/Context;Lbgxf;)V
    //   224: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   227: invokevirtual 133	java/util/HashMap:isEmpty	()Z
    //   230: ifne +14 -> 244
    //   233: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   236: ldc 138
    //   238: invokevirtual 142	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   241: ifne +17 -> 258
    //   244: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   247: ldc 138
    //   249: bipush 10
    //   251: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   261: ldc 138
    //   263: invokevirtual 142	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   266: ifeq +18 -> 284
    //   269: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   272: ldc 138
    //   274: invokevirtual 154	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: checkcast 111	java/lang/Integer
    //   280: invokevirtual 158	java/lang/Integer:intValue	()I
    //   283: istore_1
    //   284: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   287: aload 4
    //   289: invokevirtual 142	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   292: ifeq +629 -> 921
    //   295: getstatic 129	bgxf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   298: aload 4
    //   300: invokevirtual 154	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 111	java/lang/Integer
    //   306: invokevirtual 158	java/lang/Integer:intValue	()I
    //   309: istore_2
    //   310: iconst_0
    //   311: istore_3
    //   312: invokestatic 164	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   315: invokevirtual 168	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   318: astore 6
    //   320: iload_3
    //   321: istore_1
    //   322: aload 6
    //   324: ifnull +603 -> 927
    //   327: iload_3
    //   328: istore_1
    //   329: aload 6
    //   331: invokevirtual 174	mqq/app/AppRuntime:getLongAccountUin	()J
    //   334: lconst_0
    //   335: lcmp
    //   336: ifeq +591 -> 927
    //   339: aload 6
    //   341: invokevirtual 174	mqq/app/AppRuntime:getLongAccountUin	()J
    //   344: iload_2
    //   345: i2l
    //   346: lrem
    //   347: aload_0
    //   348: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   351: getfield 66	bgxd:a	Lbgxf;
    //   354: getfield 177	bgxf:c	I
    //   357: i2l
    //   358: lcmp
    //   359: ifne +532 -> 891
    //   362: iconst_1
    //   363: istore_1
    //   364: goto +563 -> 927
    //   367: aload 4
    //   369: invokestatic 181	com/tencent/gamecenter/activities/GameCenterActivity:a	(Ljava/lang/String;)Z
    //   372: ifeq +539 -> 911
    //   375: iconst_1
    //   376: istore_1
    //   377: goto +560 -> 937
    //   380: aload 4
    //   382: astore 5
    //   384: aload_0
    //   385: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   388: getfield 66	bgxd:a	Lbgxf;
    //   391: getfield 117	bgxf:b	I
    //   394: iconst_m1
    //   395: if_icmpeq +38 -> 433
    //   398: new 183	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   405: aload 4
    //   407: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 190
    //   412: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   419: getfield 66	bgxd:a	Lbgxf;
    //   422: getfield 117	bgxf:b	I
    //   425: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore 5
    //   433: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +129 -> 565
    //   439: ldc 79
    //   441: iconst_2
    //   442: new 183	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   449: ldc 198
    //   451: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   458: getfield 66	bgxd:a	Lbgxf;
    //   461: getfield 71	bgxf:jdField_a_of_type_Int	I
    //   464: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc 200
    //   469: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   476: getfield 66	bgxd:a	Lbgxf;
    //   479: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   482: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   485: ldc 205
    //   487: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   494: getfield 66	bgxd:a	Lbgxf;
    //   497: getfield 117	bgxf:b	I
    //   500: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc 207
    //   505: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_0
    //   509: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   512: getfield 66	bgxd:a	Lbgxf;
    //   515: getfield 208	bgxf:jdField_a_of_type_Long	J
    //   518: aload_0
    //   519: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   522: getfield 210	bgxd:b	J
    //   525: lsub
    //   526: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   529: ldc 215
    //   531: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_0
    //   535: getfield 26	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_Long	J
    //   538: aload_0
    //   539: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   542: getfield 210	bgxd:b	J
    //   545: lsub
    //   546: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   549: ldc 217
    //   551: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 5
    //   556: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_0
    //   566: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   569: aload_0
    //   570: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   573: getfield 66	bgxd:a	Lbgxf;
    //   576: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   579: aload 6
    //   581: invokevirtual 220	bgxd:a	(ZLmqq/app/AppRuntime;)Ljava/lang/String;
    //   584: astore 6
    //   586: new 222	org/json/JSONObject
    //   589: dup
    //   590: invokespecial 223	org/json/JSONObject:<init>	()V
    //   593: astore 4
    //   595: new 222	org/json/JSONObject
    //   598: dup
    //   599: invokespecial 223	org/json/JSONObject:<init>	()V
    //   602: astore 7
    //   604: aload 7
    //   606: ldc 225
    //   608: aload 6
    //   610: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   613: pop
    //   614: aload 4
    //   616: ldc 230
    //   618: aload 7
    //   620: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   623: pop
    //   624: iload_2
    //   625: ifeq +98 -> 723
    //   628: aload 4
    //   630: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   633: astore 6
    //   635: aload_0
    //   636: getfield 28	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:b	Ljava/lang/String;
    //   639: astore 7
    //   641: aload_0
    //   642: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   645: getfield 66	bgxd:a	Lbgxf;
    //   648: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   651: ifeq +245 -> 896
    //   654: iconst_1
    //   655: istore_2
    //   656: aconst_null
    //   657: ldc 233
    //   659: ldc 235
    //   661: ldc 237
    //   663: aload 6
    //   665: aload 7
    //   667: iload_2
    //   668: iconst_1
    //   669: aload_0
    //   670: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   673: getfield 66	bgxd:a	Lbgxf;
    //   676: getfield 71	bgxf:jdField_a_of_type_Int	I
    //   679: aload 5
    //   681: getstatic 242	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   684: aload_0
    //   685: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   688: getfield 66	bgxd:a	Lbgxf;
    //   691: getfield 208	bgxf:jdField_a_of_type_Long	J
    //   694: aload_0
    //   695: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   698: getfield 210	bgxd:b	J
    //   701: lsub
    //   702: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   705: aload_0
    //   706: getfield 26	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_Long	J
    //   709: aload_0
    //   710: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   713: getfield 210	bgxd:b	J
    //   716: lsub
    //   717: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   720: invokestatic 250	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   723: iload_1
    //   724: ifeq +128 -> 852
    //   727: aload_0
    //   728: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   731: aload_0
    //   732: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   735: getfield 66	bgxd:a	Lbgxf;
    //   738: getfield 71	bgxf:jdField_a_of_type_Int	I
    //   741: iconst_1
    //   742: aload_0
    //   743: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   746: getfield 66	bgxd:a	Lbgxf;
    //   749: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   752: invokestatic 253	com/tencent/gamecenter/activities/GameCenterActivity:a	(Ljava/lang/String;IZZ)V
    //   755: aload 4
    //   757: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   760: astore 4
    //   762: aload_0
    //   763: getfield 28	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:b	Ljava/lang/String;
    //   766: astore 5
    //   768: aload_0
    //   769: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   772: getfield 66	bgxd:a	Lbgxf;
    //   775: getfield 99	bgxf:jdField_a_of_type_Boolean	Z
    //   778: ifeq +123 -> 901
    //   781: iconst_1
    //   782: istore_1
    //   783: aconst_null
    //   784: ldc 233
    //   786: ldc 255
    //   788: ldc 237
    //   790: aload 4
    //   792: aload 5
    //   794: iload_1
    //   795: iconst_1
    //   796: aload_0
    //   797: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   800: getfield 66	bgxd:a	Lbgxf;
    //   803: getfield 71	bgxf:jdField_a_of_type_Int	I
    //   806: aload_0
    //   807: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   810: getstatic 242	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   813: aload_0
    //   814: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   817: getfield 66	bgxd:a	Lbgxf;
    //   820: getfield 208	bgxf:jdField_a_of_type_Long	J
    //   823: aload_0
    //   824: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   827: getfield 210	bgxd:b	J
    //   830: lsub
    //   831: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   834: aload_0
    //   835: getfield 26	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_Long	J
    //   838: aload_0
    //   839: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   842: getfield 210	bgxd:b	J
    //   845: lsub
    //   846: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   849: invokestatic 250	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   852: aload_0
    //   853: getfield 18	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbgxd;
    //   856: getfield 66	bgxd:a	Lbgxf;
    //   859: iconst_m1
    //   860: putfield 117	bgxf:b	I
    //   863: iconst_m1
    //   864: putstatic 257	bgxf:d	I
    //   867: return
    //   868: astore 4
    //   870: ldc 79
    //   872: iconst_1
    //   873: ldc_w 259
    //   876: aload 4
    //   878: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   881: return
    //   882: aload_0
    //   883: getfield 20	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   886: astore 4
    //   888: goto -694 -> 194
    //   891: iconst_0
    //   892: istore_1
    //   893: goto +34 -> 927
    //   896: iconst_0
    //   897: istore_2
    //   898: goto -242 -> 656
    //   901: iconst_0
    //   902: istore_1
    //   903: goto -120 -> 783
    //   906: astore 6
    //   908: goto -284 -> 624
    //   911: iconst_0
    //   912: istore_1
    //   913: goto +24 -> 937
    //   916: iload_1
    //   917: istore_2
    //   918: goto -551 -> 367
    //   921: iload_1
    //   922: istore_2
    //   923: goto -613 -> 310
    //   926: return
    //   927: iload_2
    //   928: iconst_1
    //   929: if_icmpne -13 -> 916
    //   932: iconst_1
    //   933: istore_2
    //   934: goto -567 -> 367
    //   937: iload_2
    //   938: ifne -558 -> 380
    //   941: iload_1
    //   942: ifeq -16 -> 926
    //   945: goto -565 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	4
    //   177	765	1	i	int
    //   309	629	2	j	int
    //   311	17	3	k	int
    //   7	784	4	localObject1	Object
    //   868	9	4	localThrowable	java.lang.Throwable
    //   886	1	4	str	String
    //   19	774	5	localObject2	Object
    //   318	346	6	localObject3	Object
    //   906	1	6	localJSONException	org.json.JSONException
    //   602	64	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	868	java/lang/Throwable
    //   14	39	868	java/lang/Throwable
    //   39	68	868	java/lang/Throwable
    //   69	103	868	java/lang/Throwable
    //   103	136	868	java/lang/Throwable
    //   136	168	868	java/lang/Throwable
    //   168	178	868	java/lang/Throwable
    //   183	194	868	java/lang/Throwable
    //   197	244	868	java/lang/Throwable
    //   244	258	868	java/lang/Throwable
    //   258	284	868	java/lang/Throwable
    //   284	310	868	java/lang/Throwable
    //   312	320	868	java/lang/Throwable
    //   329	362	868	java/lang/Throwable
    //   367	375	868	java/lang/Throwable
    //   384	433	868	java/lang/Throwable
    //   433	565	868	java/lang/Throwable
    //   565	604	868	java/lang/Throwable
    //   604	624	868	java/lang/Throwable
    //   628	654	868	java/lang/Throwable
    //   656	723	868	java/lang/Throwable
    //   727	781	868	java/lang/Throwable
    //   783	852	868	java/lang/Throwable
    //   852	867	868	java/lang/Throwable
    //   882	888	868	java/lang/Throwable
    //   604	624	906	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.4
 * JD-Core Version:    0.7.0.1
 */