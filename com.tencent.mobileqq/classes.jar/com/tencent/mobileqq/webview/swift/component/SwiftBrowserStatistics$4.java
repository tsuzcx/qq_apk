package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import beep;

public class SwiftBrowserStatistics$4
  implements Runnable
{
  public SwiftBrowserStatistics$4(beep parambeep, String paramString1, Context paramContext, long paramLong, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 40	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +124 -> 135
    //   14: aload 4
    //   16: invokevirtual 44	android/net/Uri:getHost	()Ljava/lang/String;
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +13 -> 39
    //   29: aload 5
    //   31: ldc 52
    //   33: invokevirtual 58	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifne +33 -> 69
    //   39: aload_0
    //   40: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   43: getfield 63	beep:a	Lbeer;
    //   46: getfield 68	beer:jdField_a_of_type_Int	I
    //   49: bipush 11
    //   51: if_icmpge +18 -> 69
    //   54: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +678 -> 735
    //   60: ldc 76
    //   62: iconst_2
    //   63: ldc 78
    //   65: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: return
    //   69: aload 4
    //   71: ldc 84
    //   73: invokevirtual 88	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 5
    //   78: aload 5
    //   80: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +20 -> 103
    //   86: aload_0
    //   87: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   90: getfield 63	beep:a	Lbeer;
    //   93: aload 5
    //   95: ldc 90
    //   97: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: putfield 96	beer:jdField_a_of_type_Boolean	Z
    //   103: aload 4
    //   105: ldc 98
    //   107: invokevirtual 88	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 4
    //   112: aload 4
    //   114: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +18 -> 135
    //   120: aload_0
    //   121: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   124: getfield 63	beep:a	Lbeer;
    //   127: aload 4
    //   129: invokestatic 104	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   132: putfield 106	beer:b	I
    //   135: aload_0
    //   136: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: ldc 108
    //   141: invokevirtual 111	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   144: istore_1
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpeq +559 -> 706
    //   150: aload_0
    //   151: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_0
    //   155: iload_1
    //   156: invokevirtual 115	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: astore 4
    //   161: bipush 10
    //   163: istore_1
    //   164: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   167: invokevirtual 122	java/util/HashMap:isEmpty	()Z
    //   170: ifeq +55 -> 225
    //   173: aload_0
    //   174: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   177: aload_0
    //   178: getfield 21	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   181: aload_0
    //   182: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   185: getfield 63	beep:a	Lbeer;
    //   188: invokevirtual 125	beep:a	(Landroid/content/Context;Lbeer;)V
    //   191: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   194: invokevirtual 122	java/util/HashMap:isEmpty	()Z
    //   197: ifne +14 -> 211
    //   200: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   203: ldc 127
    //   205: invokevirtual 131	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   208: ifne +17 -> 225
    //   211: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   214: ldc 127
    //   216: bipush 10
    //   218: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: invokevirtual 139	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   228: ldc 127
    //   230: invokevirtual 131	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   233: ifeq +18 -> 251
    //   236: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc 127
    //   241: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 100	java/lang/Integer
    //   247: invokevirtual 147	java/lang/Integer:intValue	()I
    //   250: istore_1
    //   251: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   254: aload 4
    //   256: invokevirtual 131	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   259: ifeq +471 -> 730
    //   262: getstatic 118	beer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   265: aload 4
    //   267: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast 100	java/lang/Integer
    //   273: invokevirtual 147	java/lang/Integer:intValue	()I
    //   276: istore_2
    //   277: iconst_0
    //   278: istore_3
    //   279: invokestatic 153	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   282: invokevirtual 157	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   285: astore 6
    //   287: iload_3
    //   288: istore_1
    //   289: aload 6
    //   291: ifnull +445 -> 736
    //   294: iload_3
    //   295: istore_1
    //   296: aload 6
    //   298: invokevirtual 163	mqq/app/AppRuntime:getLongAccountUin	()J
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq +433 -> 736
    //   306: aload 6
    //   308: invokevirtual 163	mqq/app/AppRuntime:getLongAccountUin	()J
    //   311: iload_2
    //   312: i2l
    //   313: lrem
    //   314: aload_0
    //   315: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   318: getfield 63	beep:a	Lbeer;
    //   321: getfield 166	beer:c	I
    //   324: i2l
    //   325: lcmp
    //   326: ifne +389 -> 715
    //   329: iconst_1
    //   330: istore_1
    //   331: goto +405 -> 736
    //   334: iload_1
    //   335: ifeq +400 -> 735
    //   338: aload 4
    //   340: astore 5
    //   342: aload_0
    //   343: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   346: getfield 63	beep:a	Lbeer;
    //   349: getfield 106	beer:b	I
    //   352: iconst_m1
    //   353: if_icmpeq +38 -> 391
    //   356: new 168	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   363: aload 4
    //   365: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 175
    //   370: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   377: getfield 63	beep:a	Lbeer;
    //   380: getfield 106	beer:b	I
    //   383: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: astore 5
    //   391: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +129 -> 523
    //   397: ldc 76
    //   399: iconst_2
    //   400: new 168	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   407: ldc 183
    //   409: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   416: getfield 63	beep:a	Lbeer;
    //   419: getfield 68	beer:jdField_a_of_type_Int	I
    //   422: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc 185
    //   427: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_0
    //   431: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   434: getfield 63	beep:a	Lbeer;
    //   437: getfield 96	beer:jdField_a_of_type_Boolean	Z
    //   440: invokevirtual 188	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: ldc 190
    //   445: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   452: getfield 63	beep:a	Lbeer;
    //   455: getfield 106	beer:b	I
    //   458: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: ldc 192
    //   463: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   470: getfield 63	beep:a	Lbeer;
    //   473: getfield 193	beer:jdField_a_of_type_Long	J
    //   476: aload_0
    //   477: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   480: getfield 195	beep:b	J
    //   483: lsub
    //   484: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc 200
    //   489: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_Long	J
    //   496: aload_0
    //   497: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   500: getfield 195	beep:b	J
    //   503: lsub
    //   504: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   507: ldc 202
    //   509: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 5
    //   514: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   527: aload_0
    //   528: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   531: getfield 63	beep:a	Lbeer;
    //   534: getfield 96	beer:jdField_a_of_type_Boolean	Z
    //   537: aload 6
    //   539: invokevirtual 205	beep:a	(ZLmqq/app/AppRuntime;)Ljava/lang/String;
    //   542: astore 6
    //   544: new 207	org/json/JSONObject
    //   547: dup
    //   548: invokespecial 208	org/json/JSONObject:<init>	()V
    //   551: astore 4
    //   553: new 207	org/json/JSONObject
    //   556: dup
    //   557: invokespecial 208	org/json/JSONObject:<init>	()V
    //   560: astore 7
    //   562: aload 7
    //   564: ldc 210
    //   566: aload 6
    //   568: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload 4
    //   574: ldc 215
    //   576: aload 7
    //   578: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: aload 4
    //   584: invokevirtual 216	org/json/JSONObject:toString	()Ljava/lang/String;
    //   587: astore 4
    //   589: aload_0
    //   590: getfield 25	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:b	Ljava/lang/String;
    //   593: astore 6
    //   595: aload_0
    //   596: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   599: getfield 63	beep:a	Lbeer;
    //   602: getfield 96	beer:jdField_a_of_type_Boolean	Z
    //   605: ifeq +115 -> 720
    //   608: iconst_1
    //   609: istore_1
    //   610: aconst_null
    //   611: ldc 218
    //   613: ldc 220
    //   615: ldc 222
    //   617: aload 4
    //   619: aload 6
    //   621: iload_1
    //   622: iconst_1
    //   623: aload_0
    //   624: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   627: getfield 63	beep:a	Lbeer;
    //   630: getfield 68	beer:jdField_a_of_type_Int	I
    //   633: aload 5
    //   635: getstatic 227	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   642: getfield 63	beep:a	Lbeer;
    //   645: getfield 193	beer:jdField_a_of_type_Long	J
    //   648: aload_0
    //   649: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   652: getfield 195	beep:b	J
    //   655: lsub
    //   656: invokestatic 230	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   659: aload_0
    //   660: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_Long	J
    //   663: aload_0
    //   664: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   667: getfield 195	beep:b	J
    //   670: lsub
    //   671: invokestatic 230	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   674: invokestatic 235	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload_0
    //   678: getfield 17	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Lbeep;
    //   681: getfield 63	beep:a	Lbeer;
    //   684: iconst_m1
    //   685: putfield 106	beer:b	I
    //   688: iconst_m1
    //   689: putstatic 237	beer:d	I
    //   692: return
    //   693: astore 4
    //   695: ldc 76
    //   697: iconst_1
    //   698: ldc 239
    //   700: aload 4
    //   702: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   705: return
    //   706: aload_0
    //   707: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   710: astore 4
    //   712: goto -551 -> 161
    //   715: iconst_0
    //   716: istore_1
    //   717: goto +19 -> 736
    //   720: iconst_0
    //   721: istore_1
    //   722: goto -112 -> 610
    //   725: astore 6
    //   727: goto -145 -> 582
    //   730: iload_1
    //   731: istore_2
    //   732: goto -455 -> 277
    //   735: return
    //   736: iload_2
    //   737: iconst_1
    //   738: if_icmpne -404 -> 334
    //   741: iconst_1
    //   742: istore_1
    //   743: goto -409 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	4
    //   144	599	1	i	int
    //   276	463	2	j	int
    //   278	17	3	k	int
    //   7	611	4	localObject1	Object
    //   693	8	4	localThrowable	java.lang.Throwable
    //   710	1	4	str	String
    //   19	615	5	localObject2	Object
    //   285	335	6	localObject3	Object
    //   725	1	6	localJSONException	org.json.JSONException
    //   560	17	7	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	693	java/lang/Throwable
    //   14	39	693	java/lang/Throwable
    //   39	68	693	java/lang/Throwable
    //   69	103	693	java/lang/Throwable
    //   103	135	693	java/lang/Throwable
    //   135	145	693	java/lang/Throwable
    //   150	161	693	java/lang/Throwable
    //   164	211	693	java/lang/Throwable
    //   211	225	693	java/lang/Throwable
    //   225	251	693	java/lang/Throwable
    //   251	277	693	java/lang/Throwable
    //   279	287	693	java/lang/Throwable
    //   296	329	693	java/lang/Throwable
    //   342	391	693	java/lang/Throwable
    //   391	523	693	java/lang/Throwable
    //   523	562	693	java/lang/Throwable
    //   562	582	693	java/lang/Throwable
    //   582	608	693	java/lang/Throwable
    //   610	692	693	java/lang/Throwable
    //   706	712	693	java/lang/Throwable
    //   562	582	725	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.4
 * JD-Core Version:    0.7.0.1
 */