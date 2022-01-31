package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class SignatureTemplateConfig
{
  /* Error */
  public static SignatureTemplateInfo a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, int paramInt)
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 26	com/tencent/mobileqq/app/AppConstants:by	Ljava/lang/String;
    //   10: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: iload_1
    //   14: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: getstatic 38	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 40
    //   25: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_0
    //   34: ldc2_w 45
    //   37: new 19	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   44: ldc 48
    //   46: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 50
    //   55: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: aload 4
    //   63: iconst_1
    //   64: aconst_null
    //   65: invokestatic 55	com/tencent/mobileqq/vas/VasQuickUpdateManager:a	(Lmqq/app/AppRuntime;JLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)Ljava/io/File;
    //   68: astore_0
    //   69: aload_0
    //   70: iconst_m1
    //   71: invokestatic 60	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;I)Ljava/lang/String;
    //   74: astore_0
    //   75: aload_0
    //   76: ifnonnull +25 -> 101
    //   79: ldc 62
    //   81: iconst_1
    //   82: ldc 64
    //   84: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: ldc 62
    //   92: iconst_1
    //   93: ldc 72
    //   95: aload_0
    //   96: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aconst_null
    //   100: areturn
    //   101: new 77	org/json/JSONObject
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: astore 4
    //   111: aload 4
    //   113: ldc 82
    //   115: invokevirtual 86	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull -33 -> 87
    //   123: aload_0
    //   124: invokevirtual 92	org/json/JSONArray:length	()I
    //   127: iconst_1
    //   128: if_icmpne -41 -> 87
    //   131: aload_0
    //   132: iconst_0
    //   133: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   136: astore 5
    //   138: new 98	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   141: dup
    //   142: iload_1
    //   143: invokestatic 103	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   146: invokespecial 104	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   149: astore_0
    //   150: aload 5
    //   152: ldc 106
    //   154: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   157: iconst_1
    //   158: if_icmpne +13 -> 171
    //   161: new 98	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   164: dup
    //   165: ldc 112
    //   167: invokespecial 104	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   170: areturn
    //   171: aload_0
    //   172: aload 5
    //   174: ldc 114
    //   176: ldc 116
    //   178: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield 123	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 123	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   188: ldc 125
    //   190: invokevirtual 130	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   193: ifle +13 -> 206
    //   196: new 98	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   199: dup
    //   200: ldc 112
    //   202: invokespecial 104	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   205: areturn
    //   206: aload_0
    //   207: aload 5
    //   209: ldc 132
    //   211: ldc 134
    //   213: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: putfield 137	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   219: aload_0
    //   220: aload 5
    //   222: ldc 139
    //   224: iconst_m1
    //   225: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   228: putfield 145	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   231: aload_0
    //   232: aload 5
    //   234: ldc 147
    //   236: iconst_1
    //   237: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   240: putfield 149	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_Int	I
    //   243: aload_0
    //   244: aload 5
    //   246: ldc 151
    //   248: aconst_null
    //   249: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   252: putfield 154	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   255: aload_0
    //   256: aload 5
    //   258: ldc 156
    //   260: iconst_0
    //   261: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   264: putfield 158	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_Int	I
    //   267: aload_0
    //   268: aload 5
    //   270: ldc 106
    //   272: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   275: putfield 161	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_Int	I
    //   278: aload_0
    //   279: aload 5
    //   281: ldc 163
    //   283: ldc 165
    //   285: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: putfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   291: aload_0
    //   292: getfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   298: pop
    //   299: aload_0
    //   300: aload 5
    //   302: ldc 174
    //   304: ldc 165
    //   306: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   309: putfield 177	com/tencent/mobileqq/vas/SignatureTemplateInfo:n	Ljava/lang/String;
    //   312: aload_0
    //   313: aload 5
    //   315: ldc 179
    //   317: ldc 165
    //   319: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   322: putfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   325: aload_0
    //   326: getfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   329: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   332: pop
    //   333: aload_0
    //   334: aload 5
    //   336: ldc 184
    //   338: ldc 165
    //   340: invokevirtual 120	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: putfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   350: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   353: pop
    //   354: aload_0
    //   355: aload 5
    //   357: ldc 189
    //   359: iconst_1
    //   360: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   363: putfield 191	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_Int	I
    //   366: aload_0
    //   367: aload 5
    //   369: ldc 193
    //   371: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: putfield 199	com/tencent/mobileqq/vas/SignatureTemplateInfo:q	Ljava/lang/String;
    //   377: aload_0
    //   378: aload 5
    //   380: ldc 201
    //   382: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   385: putfield 204	com/tencent/mobileqq/vas/SignatureTemplateInfo:r	Ljava/lang/String;
    //   388: aload_0
    //   389: aload 5
    //   391: ldc 206
    //   393: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: putfield 209	com/tencent/mobileqq/vas/SignatureTemplateInfo:s	Ljava/lang/String;
    //   399: aload_0
    //   400: aload 5
    //   402: ldc 211
    //   404: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   407: putfield 213	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   410: aload_0
    //   411: aload 5
    //   413: ldc 215
    //   415: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   418: putfield 218	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	Ljava/lang/String;
    //   421: aload_0
    //   422: aload 5
    //   424: ldc 220
    //   426: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: putfield 223	com/tencent/mobileqq/vas/SignatureTemplateInfo:h	Ljava/lang/String;
    //   432: aload_0
    //   433: aload 5
    //   435: ldc 225
    //   437: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: putfield 228	com/tencent/mobileqq/vas/SignatureTemplateInfo:i	Ljava/lang/String;
    //   443: aload_0
    //   444: aload 5
    //   446: ldc 230
    //   448: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: putfield 233	com/tencent/mobileqq/vas/SignatureTemplateInfo:j	Ljava/lang/String;
    //   454: aload_0
    //   455: aload 5
    //   457: ldc 235
    //   459: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: putfield 238	com/tencent/mobileqq/vas/SignatureTemplateInfo:k	Ljava/lang/String;
    //   465: aload_0
    //   466: aload 5
    //   468: ldc 240
    //   470: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   473: putfield 243	com/tencent/mobileqq/vas/SignatureTemplateInfo:l	Ljava/lang/String;
    //   476: aload_0
    //   477: aload 5
    //   479: ldc 245
    //   481: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: putfield 248	com/tencent/mobileqq/vas/SignatureTemplateInfo:m	Ljava/lang/String;
    //   487: aload 4
    //   489: ldc 250
    //   491: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   494: ifeq +341 -> 835
    //   497: aload 4
    //   499: ldc 250
    //   501: invokevirtual 257	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   504: astore 5
    //   506: iconst_0
    //   507: istore_2
    //   508: iload_2
    //   509: aload 5
    //   511: invokevirtual 92	org/json/JSONArray:length	()I
    //   514: if_icmpge +321 -> 835
    //   517: aload 5
    //   519: iload_2
    //   520: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   523: astore 6
    //   525: aload 6
    //   527: ldc_w 259
    //   530: iconst_m1
    //   531: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   534: istore_1
    //   535: iload_1
    //   536: ifeq +14 -> 550
    //   539: iload_1
    //   540: iconst_1
    //   541: if_icmple +413 -> 954
    //   544: iload_1
    //   545: bipush 6
    //   547: if_icmpge +407 -> 954
    //   550: aload_0
    //   551: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   554: astore 7
    //   556: iload_1
    //   557: ifne +404 -> 961
    //   560: iload_1
    //   561: istore_3
    //   562: aload 7
    //   564: iload_3
    //   565: aaload
    //   566: iload_1
    //   567: putfield 265	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Int	I
    //   570: aload_0
    //   571: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   574: astore 7
    //   576: iload_1
    //   577: ifne +391 -> 968
    //   580: iload_1
    //   581: istore_3
    //   582: aload 7
    //   584: iload_3
    //   585: aaload
    //   586: aload 6
    //   588: ldc_w 267
    //   591: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   594: putfield 269	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   597: aload_0
    //   598: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   601: astore 7
    //   603: iload_1
    //   604: ifne +371 -> 975
    //   607: iload_1
    //   608: istore_3
    //   609: aload 7
    //   611: iload_3
    //   612: aaload
    //   613: aload 6
    //   615: ldc_w 271
    //   618: dconst_0
    //   619: invokevirtual 275	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   622: d2f
    //   623: putfield 278	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Float	F
    //   626: aload_0
    //   627: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   630: astore 7
    //   632: iload_1
    //   633: ifne +349 -> 982
    //   636: iload_1
    //   637: istore_3
    //   638: aload 7
    //   640: iload_3
    //   641: aaload
    //   642: aload 6
    //   644: ldc_w 280
    //   647: dconst_0
    //   648: invokevirtual 275	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   651: d2f
    //   652: putfield 282	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Float	F
    //   655: aload_0
    //   656: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   659: astore 7
    //   661: iload_1
    //   662: ifne +327 -> 989
    //   665: iload_1
    //   666: istore_3
    //   667: aload 7
    //   669: iload_3
    //   670: aaload
    //   671: aload 6
    //   673: ldc_w 284
    //   676: dconst_0
    //   677: invokevirtual 275	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   680: d2f
    //   681: putfield 286	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Float	F
    //   684: aload_0
    //   685: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   688: astore 7
    //   690: iload_1
    //   691: ifne +305 -> 996
    //   694: iload_1
    //   695: istore_3
    //   696: aload 7
    //   698: iload_3
    //   699: aaload
    //   700: aload 6
    //   702: ldc_w 288
    //   705: dconst_0
    //   706: invokevirtual 275	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   709: d2f
    //   710: putfield 290	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:d	F
    //   713: aload_0
    //   714: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   717: astore 7
    //   719: iload_1
    //   720: ifne +283 -> 1003
    //   723: iload_1
    //   724: istore_3
    //   725: aload 7
    //   727: iload_3
    //   728: aaload
    //   729: aload 6
    //   731: ldc_w 292
    //   734: iconst_0
    //   735: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   738: putfield 293	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   741: aload_0
    //   742: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   745: astore 7
    //   747: iload_1
    //   748: ifne +262 -> 1010
    //   751: aload 7
    //   753: iload_1
    //   754: aaload
    //   755: aload 6
    //   757: ldc_w 295
    //   760: iconst_0
    //   761: invokevirtual 142	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   764: putfield 296	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   767: goto +187 -> 954
    //   770: astore 6
    //   772: aload_0
    //   773: ldc 165
    //   775: putfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   778: goto -479 -> 299
    //   781: astore_0
    //   782: ldc 62
    //   784: iconst_1
    //   785: new 19	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 298
    //   795: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: invokevirtual 301	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   802: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: aconst_null
    //   812: areturn
    //   813: astore 6
    //   815: aload_0
    //   816: ldc 165
    //   818: putfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   821: goto -488 -> 333
    //   824: astore 6
    //   826: aload_0
    //   827: ldc 165
    //   829: putfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   832: goto -478 -> 354
    //   835: aload 4
    //   837: ldc_w 303
    //   840: invokevirtual 86	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   843: astore 4
    //   845: aload 4
    //   847: ifnull +105 -> 952
    //   850: aload 4
    //   852: invokevirtual 92	org/json/JSONArray:length	()I
    //   855: ifle +97 -> 952
    //   858: aload 4
    //   860: iconst_0
    //   861: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   864: astore 4
    //   866: aload_0
    //   867: invokevirtual 307	java/lang/Object:getClass	()Ljava/lang/Class;
    //   870: pop
    //   871: new 309	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem
    //   874: dup
    //   875: aload_0
    //   876: invokespecial 312	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:<init>	(Lcom/tencent/mobileqq/vas/SignatureTemplateInfo;)V
    //   879: astore 5
    //   881: aload 5
    //   883: aload 4
    //   885: ldc_w 314
    //   888: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   891: putfield 315	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   894: aload 5
    //   896: aload 4
    //   898: ldc_w 317
    //   901: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   904: putfield 318	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   907: aload 5
    //   909: aload 4
    //   911: ldc_w 320
    //   914: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   917: putfield 321	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_Int	I
    //   920: aload 5
    //   922: aload 4
    //   924: ldc_w 323
    //   927: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   930: putfield 324	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_Int	I
    //   933: aload 5
    //   935: aload 4
    //   937: ldc_w 326
    //   940: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   943: putfield 327	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   946: aload_0
    //   947: aload 5
    //   949: putfield 330	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem;
    //   952: aload_0
    //   953: areturn
    //   954: iload_2
    //   955: iconst_1
    //   956: iadd
    //   957: istore_2
    //   958: goto -450 -> 508
    //   961: iload_1
    //   962: iconst_1
    //   963: isub
    //   964: istore_3
    //   965: goto -403 -> 562
    //   968: iload_1
    //   969: iconst_1
    //   970: isub
    //   971: istore_3
    //   972: goto -390 -> 582
    //   975: iload_1
    //   976: iconst_1
    //   977: isub
    //   978: istore_3
    //   979: goto -370 -> 609
    //   982: iload_1
    //   983: iconst_1
    //   984: isub
    //   985: istore_3
    //   986: goto -348 -> 638
    //   989: iload_1
    //   990: iconst_1
    //   991: isub
    //   992: istore_3
    //   993: goto -326 -> 667
    //   996: iload_1
    //   997: iconst_1
    //   998: isub
    //   999: istore_3
    //   1000: goto -304 -> 696
    //   1003: iload_1
    //   1004: iconst_1
    //   1005: isub
    //   1006: istore_3
    //   1007: goto -282 -> 725
    //   1010: iload_1
    //   1011: iconst_1
    //   1012: isub
    //   1013: istore_1
    //   1014: goto -263 -> 751
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1017	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1017	1	paramInt	int
    //   507	451	2	i	int
    //   561	446	3	j	int
    //   31	905	4	localObject1	Object
    //   136	812	5	localObject2	Object
    //   523	233	6	localJSONObject	org.json.JSONObject
    //   770	1	6	localException1	java.lang.Exception
    //   813	1	6	localException2	java.lang.Exception
    //   824	1	6	localException3	java.lang.Exception
    //   554	198	7	arrayOfDynamicItem	SignatureTemplateInfo.DynamicItem[]
    // Exception table:
    //   from	to	target	type
    //   69	75	89	java/lang/OutOfMemoryError
    //   291	299	770	java/lang/Exception
    //   101	119	781	java/lang/Throwable
    //   123	171	781	java/lang/Throwable
    //   171	206	781	java/lang/Throwable
    //   206	291	781	java/lang/Throwable
    //   291	299	781	java/lang/Throwable
    //   299	325	781	java/lang/Throwable
    //   325	333	781	java/lang/Throwable
    //   333	346	781	java/lang/Throwable
    //   346	354	781	java/lang/Throwable
    //   354	506	781	java/lang/Throwable
    //   508	535	781	java/lang/Throwable
    //   550	556	781	java/lang/Throwable
    //   562	576	781	java/lang/Throwable
    //   582	603	781	java/lang/Throwable
    //   609	632	781	java/lang/Throwable
    //   638	661	781	java/lang/Throwable
    //   667	690	781	java/lang/Throwable
    //   696	719	781	java/lang/Throwable
    //   725	747	781	java/lang/Throwable
    //   751	767	781	java/lang/Throwable
    //   772	778	781	java/lang/Throwable
    //   815	821	781	java/lang/Throwable
    //   826	832	781	java/lang/Throwable
    //   835	845	781	java/lang/Throwable
    //   850	952	781	java/lang/Throwable
    //   325	333	813	java/lang/Exception
    //   346	354	824	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.by);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SignatureTemplateConfig.SignatureTemplateType[] a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 340	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 341	java/util/LinkedHashMap:<init>	()V
    //   7: astore 7
    //   9: new 35	java/io/File
    //   12: dup
    //   13: getstatic 344	com/tencent/mobileqq/app/SignatureManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: iconst_m1
    //   22: invokestatic 60	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;I)Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +24 -> 51
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +1560 -> 1596
    //   39: ldc 62
    //   41: iconst_2
    //   42: ldc 72
    //   44: aload_0
    //   45: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto +1548 -> 1596
    //   51: new 77	org/json/JSONObject
    //   54: dup
    //   55: aload_0
    //   56: aload_0
    //   57: ldc_w 351
    //   60: invokevirtual 354	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   63: aload_0
    //   64: invokevirtual 355	java/lang/String:length	()I
    //   67: invokevirtual 359	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   70: checkcast 127	java/lang/String
    //   73: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   76: ldc 82
    //   78: invokevirtual 362	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore_0
    //   82: aload_0
    //   83: ldc_w 364
    //   86: invokevirtual 257	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   89: astore 8
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: aload 8
    //   96: invokevirtual 92	org/json/JSONArray:length	()I
    //   99: if_icmpge +71 -> 170
    //   102: aload 8
    //   104: iload_3
    //   105: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 9
    //   110: new 366	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   113: dup
    //   114: invokespecial 367	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:<init>	()V
    //   117: astore 10
    //   119: aload 10
    //   121: aload 9
    //   123: ldc_w 369
    //   126: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: putfield 373	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   132: aload 10
    //   134: aload 9
    //   136: ldc_w 375
    //   139: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 379	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: aload 7
    //   147: aload 10
    //   149: getfield 373	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   152: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aload 10
    //   157: invokeinterface 389 3 0
    //   162: pop
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_3
    //   167: goto -74 -> 93
    //   170: aload_0
    //   171: ldc_w 391
    //   174: invokevirtual 362	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   177: astore 8
    //   179: aload 8
    //   181: invokevirtual 395	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   184: astore 9
    //   186: aload 9
    //   188: invokeinterface 400 1 0
    //   193: ifeq +1314 -> 1507
    //   196: aload 8
    //   198: aload 9
    //   200: invokeinterface 404 1 0
    //   205: checkcast 127	java/lang/String
    //   208: invokevirtual 257	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   211: astore 10
    //   213: iconst_0
    //   214: istore 4
    //   216: iload 4
    //   218: aload 10
    //   220: invokevirtual 92	org/json/JSONArray:length	()I
    //   223: if_icmpge -37 -> 186
    //   226: aload 10
    //   228: iload 4
    //   230: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 12
    //   235: new 98	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   238: dup
    //   239: aload 12
    //   241: ldc_w 406
    //   244: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokespecial 104	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   250: astore 11
    //   252: aload 12
    //   254: ldc 82
    //   256: invokevirtual 257	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   259: astore 13
    //   261: iconst_0
    //   262: istore_3
    //   263: iload_3
    //   264: aload 13
    //   266: invokevirtual 92	org/json/JSONArray:length	()I
    //   269: if_icmpge +699 -> 968
    //   272: aload 13
    //   274: iload_3
    //   275: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   278: astore 14
    //   280: aload 14
    //   282: ldc 106
    //   284: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   287: iconst_1
    //   288: if_icmpne +6 -> 294
    //   291: goto +1307 -> 1598
    //   294: aload 11
    //   296: aload 14
    //   298: ldc 114
    //   300: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: putfield 123	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   306: aload 11
    //   308: getfield 123	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   311: ldc 125
    //   313: invokevirtual 130	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   316: ifgt +1282 -> 1598
    //   319: aload 14
    //   321: ldc 132
    //   323: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   326: ifeq +603 -> 929
    //   329: aload 14
    //   331: ldc 132
    //   333: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   336: astore_0
    //   337: aload 11
    //   339: aload_0
    //   340: putfield 137	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   343: aload 14
    //   345: ldc 139
    //   347: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   350: ifeq +1255 -> 1605
    //   353: aload 14
    //   355: ldc 139
    //   357: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   360: istore 5
    //   362: aload 11
    //   364: iload 5
    //   366: putfield 145	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   369: aload 14
    //   371: ldc 147
    //   373: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   376: ifeq +1235 -> 1611
    //   379: aload 14
    //   381: ldc 147
    //   383: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   386: istore 5
    //   388: aload 11
    //   390: iload 5
    //   392: putfield 149	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_Int	I
    //   395: aload 14
    //   397: ldc 151
    //   399: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   402: ifeq +1215 -> 1617
    //   405: aload 14
    //   407: ldc 151
    //   409: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: astore_0
    //   413: aload 11
    //   415: aload_0
    //   416: putfield 154	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   419: aload 14
    //   421: ldc 156
    //   423: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   426: ifeq +1196 -> 1622
    //   429: aload 14
    //   431: ldc 156
    //   433: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   436: istore 5
    //   438: aload 11
    //   440: iload 5
    //   442: putfield 158	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_Int	I
    //   445: aload 11
    //   447: aload 14
    //   449: ldc 106
    //   451: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   454: putfield 161	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_Int	I
    //   457: aload 14
    //   459: ldc 163
    //   461: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   464: ifeq +1164 -> 1628
    //   467: aload 14
    //   469: ldc 163
    //   471: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: astore_0
    //   475: aload 11
    //   477: aload_0
    //   478: putfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   481: aload 11
    //   483: getfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   486: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   489: pop
    //   490: aload 14
    //   492: ldc 174
    //   494: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   497: ifeq +1137 -> 1634
    //   500: aload 14
    //   502: ldc 174
    //   504: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   507: astore_0
    //   508: aload 11
    //   510: aload_0
    //   511: putfield 177	com/tencent/mobileqq/vas/SignatureTemplateInfo:n	Ljava/lang/String;
    //   514: aload 14
    //   516: ldc 179
    //   518: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   521: ifeq +1119 -> 1640
    //   524: aload 14
    //   526: ldc 179
    //   528: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: astore_0
    //   532: aload 11
    //   534: aload_0
    //   535: putfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   538: aload 11
    //   540: getfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   543: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   546: pop
    //   547: aload 14
    //   549: ldc 184
    //   551: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   554: ifeq +1092 -> 1646
    //   557: aload 14
    //   559: ldc 184
    //   561: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   564: astore_0
    //   565: aload 11
    //   567: aload_0
    //   568: putfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   571: aload 11
    //   573: getfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   576: invokestatic 172	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   579: pop
    //   580: aload 14
    //   582: ldc 189
    //   584: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   587: ifeq +1065 -> 1652
    //   590: aload 14
    //   592: ldc 189
    //   594: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   597: istore 5
    //   599: aload 11
    //   601: iload 5
    //   603: putfield 191	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_Int	I
    //   606: aload 14
    //   608: ldc 193
    //   610: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   613: ifeq +1045 -> 1658
    //   616: aload 14
    //   618: ldc 193
    //   620: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   623: astore_0
    //   624: aload 11
    //   626: aload_0
    //   627: putfield 199	com/tencent/mobileqq/vas/SignatureTemplateInfo:q	Ljava/lang/String;
    //   630: aload 14
    //   632: ldc 201
    //   634: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   637: ifeq +1027 -> 1664
    //   640: aload 14
    //   642: ldc 201
    //   644: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   647: astore_0
    //   648: aload 11
    //   650: aload_0
    //   651: putfield 204	com/tencent/mobileqq/vas/SignatureTemplateInfo:r	Ljava/lang/String;
    //   654: aload 14
    //   656: ldc 206
    //   658: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   661: ifeq +1009 -> 1670
    //   664: aload 14
    //   666: ldc 206
    //   668: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: astore_0
    //   672: aload 11
    //   674: aload_0
    //   675: putfield 209	com/tencent/mobileqq/vas/SignatureTemplateInfo:s	Ljava/lang/String;
    //   678: aload 14
    //   680: ldc 211
    //   682: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   685: ifeq +15 -> 700
    //   688: aload 11
    //   690: aload 14
    //   692: ldc 211
    //   694: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: putfield 213	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   700: aload 14
    //   702: ldc 215
    //   704: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   707: ifeq +15 -> 722
    //   710: aload 11
    //   712: aload 14
    //   714: ldc 215
    //   716: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   719: putfield 218	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	Ljava/lang/String;
    //   722: aload 14
    //   724: ldc 220
    //   726: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   729: ifeq +15 -> 744
    //   732: aload 11
    //   734: aload 14
    //   736: ldc 220
    //   738: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   741: putfield 223	com/tencent/mobileqq/vas/SignatureTemplateInfo:h	Ljava/lang/String;
    //   744: aload 14
    //   746: ldc 225
    //   748: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   751: ifeq +15 -> 766
    //   754: aload 11
    //   756: aload 14
    //   758: ldc 225
    //   760: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   763: putfield 228	com/tencent/mobileqq/vas/SignatureTemplateInfo:i	Ljava/lang/String;
    //   766: aload 14
    //   768: ldc 230
    //   770: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   773: ifeq +15 -> 788
    //   776: aload 11
    //   778: aload 14
    //   780: ldc 230
    //   782: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   785: putfield 233	com/tencent/mobileqq/vas/SignatureTemplateInfo:j	Ljava/lang/String;
    //   788: aload 14
    //   790: ldc 235
    //   792: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   795: ifeq +15 -> 810
    //   798: aload 11
    //   800: aload 14
    //   802: ldc 235
    //   804: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   807: putfield 238	com/tencent/mobileqq/vas/SignatureTemplateInfo:k	Ljava/lang/String;
    //   810: aload 14
    //   812: ldc 240
    //   814: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   817: ifeq +15 -> 832
    //   820: aload 11
    //   822: aload 14
    //   824: ldc 240
    //   826: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   829: putfield 243	com/tencent/mobileqq/vas/SignatureTemplateInfo:l	Ljava/lang/String;
    //   832: aload 14
    //   834: ldc 245
    //   836: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   839: ifeq +759 -> 1598
    //   842: aload 11
    //   844: aload 14
    //   846: ldc 245
    //   848: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   851: putfield 248	com/tencent/mobileqq/vas/SignatureTemplateInfo:m	Ljava/lang/String;
    //   854: goto +744 -> 1598
    //   857: astore_0
    //   858: new 35	java/io/File
    //   861: dup
    //   862: getstatic 344	com/tencent/mobileqq/app/SignatureManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   865: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   868: astore 7
    //   870: aload 7
    //   872: invokevirtual 409	java/io/File:exists	()Z
    //   875: ifeq +17 -> 892
    //   878: aload 7
    //   880: invokevirtual 412	java/io/File:isFile	()Z
    //   883: ifeq +9 -> 892
    //   886: aload 7
    //   888: invokevirtual 415	java/io/File:delete	()Z
    //   891: pop
    //   892: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +32 -> 927
    //   898: ldc 62
    //   900: iconst_2
    //   901: new 19	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   908: ldc_w 417
    //   911: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload_0
    //   915: invokevirtual 418	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   918: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: aconst_null
    //   928: areturn
    //   929: ldc 134
    //   931: astore_0
    //   932: goto -595 -> 337
    //   935: astore_0
    //   936: aload 11
    //   938: ldc 165
    //   940: putfield 167	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   943: goto -453 -> 490
    //   946: astore_0
    //   947: aload 11
    //   949: ldc 165
    //   951: putfield 182	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   954: goto -407 -> 547
    //   957: astore_0
    //   958: aload 11
    //   960: ldc 165
    //   962: putfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   965: goto -385 -> 580
    //   968: aload 12
    //   970: ldc 250
    //   972: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   975: ifeq +386 -> 1361
    //   978: aload 12
    //   980: ldc 250
    //   982: invokevirtual 257	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   985: astore 13
    //   987: iconst_0
    //   988: istore 5
    //   990: iload 5
    //   992: aload 13
    //   994: invokevirtual 92	org/json/JSONArray:length	()I
    //   997: if_icmpge +364 -> 1361
    //   1000: aload 13
    //   1002: iload 5
    //   1004: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1007: astore 14
    //   1009: aload 14
    //   1011: ldc_w 259
    //   1014: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1017: ifeq +686 -> 1703
    //   1020: aload 14
    //   1022: ldc_w 259
    //   1025: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1028: istore_3
    //   1029: goto +647 -> 1676
    //   1032: aload 11
    //   1034: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1037: astore_0
    //   1038: iload_3
    //   1039: ifne +669 -> 1708
    //   1042: iload_3
    //   1043: istore 6
    //   1045: aload_0
    //   1046: iload 6
    //   1048: aaload
    //   1049: iload_3
    //   1050: putfield 265	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Int	I
    //   1053: aload 11
    //   1055: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1058: astore_0
    //   1059: iload_3
    //   1060: ifne +656 -> 1716
    //   1063: iload_3
    //   1064: istore 6
    //   1066: aload_0
    //   1067: iload 6
    //   1069: aaload
    //   1070: astore 15
    //   1072: aload 14
    //   1074: ldc_w 267
    //   1077: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1080: ifeq +644 -> 1724
    //   1083: aload 14
    //   1085: ldc_w 267
    //   1088: invokevirtual 378	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1091: astore_0
    //   1092: aload 15
    //   1094: aload_0
    //   1095: putfield 269	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1098: aload 11
    //   1100: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1103: astore_0
    //   1104: iload_3
    //   1105: ifne +625 -> 1730
    //   1108: iload_3
    //   1109: istore 6
    //   1111: aload_0
    //   1112: iload 6
    //   1114: aaload
    //   1115: astore_0
    //   1116: aload 14
    //   1118: ldc_w 271
    //   1121: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1124: ifeq +614 -> 1738
    //   1127: aload 14
    //   1129: ldc_w 271
    //   1132: invokevirtual 424	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1135: dstore_1
    //   1136: aload_0
    //   1137: dload_1
    //   1138: d2f
    //   1139: putfield 278	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Float	F
    //   1142: aload 11
    //   1144: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1147: astore_0
    //   1148: iload_3
    //   1149: ifne +594 -> 1743
    //   1152: iload_3
    //   1153: istore 6
    //   1155: aload_0
    //   1156: iload 6
    //   1158: aaload
    //   1159: astore_0
    //   1160: aload 14
    //   1162: ldc_w 280
    //   1165: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1168: ifeq +583 -> 1751
    //   1171: aload 14
    //   1173: ldc_w 280
    //   1176: invokevirtual 424	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1179: dstore_1
    //   1180: aload_0
    //   1181: dload_1
    //   1182: d2f
    //   1183: putfield 282	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Float	F
    //   1186: aload 11
    //   1188: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1191: astore_0
    //   1192: iload_3
    //   1193: ifne +563 -> 1756
    //   1196: iload_3
    //   1197: istore 6
    //   1199: aload_0
    //   1200: iload 6
    //   1202: aaload
    //   1203: astore_0
    //   1204: aload 14
    //   1206: ldc_w 284
    //   1209: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1212: ifeq +552 -> 1764
    //   1215: aload 14
    //   1217: ldc_w 284
    //   1220: invokevirtual 424	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1223: dstore_1
    //   1224: aload_0
    //   1225: dload_1
    //   1226: d2f
    //   1227: putfield 286	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Float	F
    //   1230: aload 11
    //   1232: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1235: astore_0
    //   1236: iload_3
    //   1237: ifne +532 -> 1769
    //   1240: iload_3
    //   1241: istore 6
    //   1243: aload_0
    //   1244: iload 6
    //   1246: aaload
    //   1247: astore_0
    //   1248: aload 14
    //   1250: ldc_w 288
    //   1253: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1256: ifeq +521 -> 1777
    //   1259: aload 14
    //   1261: ldc_w 288
    //   1264: invokevirtual 424	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1267: dstore_1
    //   1268: aload_0
    //   1269: dload_1
    //   1270: d2f
    //   1271: putfield 290	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:d	F
    //   1274: aload 11
    //   1276: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1279: astore_0
    //   1280: iload_3
    //   1281: ifne +501 -> 1782
    //   1284: iload_3
    //   1285: istore 6
    //   1287: aload_0
    //   1288: iload 6
    //   1290: aaload
    //   1291: astore_0
    //   1292: aload 14
    //   1294: ldc_w 292
    //   1297: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1300: ifeq +490 -> 1790
    //   1303: aload 14
    //   1305: ldc_w 292
    //   1308: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1311: istore 6
    //   1313: aload_0
    //   1314: iload 6
    //   1316: putfield 293	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   1319: aload 11
    //   1321: getfield 262	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1324: astore_0
    //   1325: iload_3
    //   1326: ifne +470 -> 1796
    //   1329: aload_0
    //   1330: iload_3
    //   1331: aaload
    //   1332: astore_0
    //   1333: aload 14
    //   1335: ldc_w 295
    //   1338: invokevirtual 254	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1341: ifeq +462 -> 1803
    //   1344: aload 14
    //   1346: ldc_w 295
    //   1349: invokevirtual 372	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1352: istore_3
    //   1353: aload_0
    //   1354: iload_3
    //   1355: putfield 296	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   1358: goto +336 -> 1694
    //   1361: aload 12
    //   1363: ldc_w 303
    //   1366: invokevirtual 86	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1369: astore_0
    //   1370: aload_0
    //   1371: ifnull +100 -> 1471
    //   1374: aload_0
    //   1375: invokevirtual 92	org/json/JSONArray:length	()I
    //   1378: ifle +93 -> 1471
    //   1381: aload_0
    //   1382: iconst_0
    //   1383: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1386: astore_0
    //   1387: aload 11
    //   1389: invokevirtual 307	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1392: pop
    //   1393: new 309	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem
    //   1396: dup
    //   1397: aload 11
    //   1399: invokespecial 312	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:<init>	(Lcom/tencent/mobileqq/vas/SignatureTemplateInfo;)V
    //   1402: astore 12
    //   1404: aload 12
    //   1406: aload_0
    //   1407: ldc_w 314
    //   1410: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1413: putfield 315	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1416: aload 12
    //   1418: aload_0
    //   1419: ldc_w 317
    //   1422: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1425: putfield 318	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1428: aload 12
    //   1430: aload_0
    //   1431: ldc_w 320
    //   1434: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1437: putfield 321	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_a_of_type_Int	I
    //   1440: aload 12
    //   1442: aload_0
    //   1443: ldc_w 323
    //   1446: invokevirtual 110	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1449: putfield 324	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_b_of_type_Int	I
    //   1452: aload 12
    //   1454: aload_0
    //   1455: ldc_w 326
    //   1458: invokevirtual 196	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1461: putfield 327	com/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1464: aload 11
    //   1466: aload 12
    //   1468: putfield 330	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem	Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$ImageItem;
    //   1471: aload 7
    //   1473: aload 11
    //   1475: getfield 145	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   1478: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1481: invokeinterface 428 2 0
    //   1486: checkcast 366	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1489: astore_0
    //   1490: aload_0
    //   1491: ifnull +317 -> 1808
    //   1494: aload_0
    //   1495: getfield 431	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1498: aload 11
    //   1500: invokevirtual 437	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1503: pop
    //   1504: goto +304 -> 1808
    //   1507: aload 7
    //   1509: invokeinterface 441 1 0
    //   1514: invokeinterface 446 1 0
    //   1519: astore_0
    //   1520: aload_0
    //   1521: invokeinterface 400 1 0
    //   1526: ifeq +38 -> 1564
    //   1529: aload_0
    //   1530: invokeinterface 404 1 0
    //   1535: checkcast 448	java/util/Map$Entry
    //   1538: invokeinterface 451 1 0
    //   1543: checkcast 366	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1546: getfield 431	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1549: invokevirtual 454	java/util/ArrayList:size	()I
    //   1552: ifne -32 -> 1520
    //   1555: aload_0
    //   1556: invokeinterface 457 1 0
    //   1561: goto -41 -> 1520
    //   1564: aload 7
    //   1566: invokeinterface 461 1 0
    //   1571: invokeinterface 464 1 0
    //   1576: anewarray 366	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1579: astore_0
    //   1580: aload 7
    //   1582: invokeinterface 461 1 0
    //   1587: aload_0
    //   1588: invokeinterface 468 2 0
    //   1593: pop
    //   1594: aload_0
    //   1595: areturn
    //   1596: aconst_null
    //   1597: areturn
    //   1598: iload_3
    //   1599: iconst_1
    //   1600: iadd
    //   1601: istore_3
    //   1602: goto -1339 -> 263
    //   1605: iconst_m1
    //   1606: istore 5
    //   1608: goto -1246 -> 362
    //   1611: iconst_1
    //   1612: istore 5
    //   1614: goto -1226 -> 388
    //   1617: aconst_null
    //   1618: astore_0
    //   1619: goto -1206 -> 413
    //   1622: iconst_0
    //   1623: istore 5
    //   1625: goto -1187 -> 438
    //   1628: ldc 165
    //   1630: astore_0
    //   1631: goto -1156 -> 475
    //   1634: ldc 165
    //   1636: astore_0
    //   1637: goto -1129 -> 508
    //   1640: ldc 165
    //   1642: astore_0
    //   1643: goto -1111 -> 532
    //   1646: ldc 165
    //   1648: astore_0
    //   1649: goto -1084 -> 565
    //   1652: iconst_1
    //   1653: istore 5
    //   1655: goto -1056 -> 599
    //   1658: ldc 165
    //   1660: astore_0
    //   1661: goto -1037 -> 624
    //   1664: ldc 165
    //   1666: astore_0
    //   1667: goto -1019 -> 648
    //   1670: ldc 165
    //   1672: astore_0
    //   1673: goto -1001 -> 672
    //   1676: iload_3
    //   1677: ifeq -645 -> 1032
    //   1680: iload_3
    //   1681: iconst_1
    //   1682: if_icmple +12 -> 1694
    //   1685: iload_3
    //   1686: bipush 6
    //   1688: if_icmpge +6 -> 1694
    //   1691: goto -659 -> 1032
    //   1694: iload 5
    //   1696: iconst_1
    //   1697: iadd
    //   1698: istore 5
    //   1700: goto -710 -> 990
    //   1703: iconst_m1
    //   1704: istore_3
    //   1705: goto -29 -> 1676
    //   1708: iload_3
    //   1709: iconst_1
    //   1710: isub
    //   1711: istore 6
    //   1713: goto -668 -> 1045
    //   1716: iload_3
    //   1717: iconst_1
    //   1718: isub
    //   1719: istore 6
    //   1721: goto -655 -> 1066
    //   1724: ldc 165
    //   1726: astore_0
    //   1727: goto -635 -> 1092
    //   1730: iload_3
    //   1731: iconst_1
    //   1732: isub
    //   1733: istore 6
    //   1735: goto -624 -> 1111
    //   1738: dconst_0
    //   1739: dstore_1
    //   1740: goto -604 -> 1136
    //   1743: iload_3
    //   1744: iconst_1
    //   1745: isub
    //   1746: istore 6
    //   1748: goto -593 -> 1155
    //   1751: dconst_0
    //   1752: dstore_1
    //   1753: goto -573 -> 1180
    //   1756: iload_3
    //   1757: iconst_1
    //   1758: isub
    //   1759: istore 6
    //   1761: goto -562 -> 1199
    //   1764: dconst_0
    //   1765: dstore_1
    //   1766: goto -542 -> 1224
    //   1769: iload_3
    //   1770: iconst_1
    //   1771: isub
    //   1772: istore 6
    //   1774: goto -531 -> 1243
    //   1777: dconst_0
    //   1778: dstore_1
    //   1779: goto -511 -> 1268
    //   1782: iload_3
    //   1783: iconst_1
    //   1784: isub
    //   1785: istore 6
    //   1787: goto -500 -> 1287
    //   1790: iconst_0
    //   1791: istore 6
    //   1793: goto -480 -> 1313
    //   1796: iload_3
    //   1797: iconst_1
    //   1798: isub
    //   1799: istore_3
    //   1800: goto -471 -> 1329
    //   1803: iconst_0
    //   1804: istore_3
    //   1805: goto -452 -> 1353
    //   1808: iload 4
    //   1810: iconst_1
    //   1811: iadd
    //   1812: istore 4
    //   1814: goto -1598 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1817	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1135	644	1	d	double
    //   92	1713	3	i	int
    //   214	1599	4	j	int
    //   360	1339	5	k	int
    //   1043	749	6	m	int
    //   7	1574	7	localObject1	Object
    //   89	108	8	localObject2	Object
    //   108	91	9	localObject3	Object
    //   117	110	10	localObject4	Object
    //   250	1249	11	localSignatureTemplateInfo	SignatureTemplateInfo
    //   233	1234	12	localObject5	Object
    //   259	742	13	localJSONArray	org.json.JSONArray
    //   278	1067	14	localJSONObject	org.json.JSONObject
    //   1070	23	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	32	java/lang/OutOfMemoryError
    //   0	20	857	java/lang/Exception
    //   20	26	857	java/lang/Exception
    //   33	48	857	java/lang/Exception
    //   51	91	857	java/lang/Exception
    //   93	163	857	java/lang/Exception
    //   170	186	857	java/lang/Exception
    //   186	213	857	java/lang/Exception
    //   216	261	857	java/lang/Exception
    //   263	291	857	java/lang/Exception
    //   294	337	857	java/lang/Exception
    //   337	362	857	java/lang/Exception
    //   362	388	857	java/lang/Exception
    //   388	413	857	java/lang/Exception
    //   413	438	857	java/lang/Exception
    //   438	475	857	java/lang/Exception
    //   475	481	857	java/lang/Exception
    //   490	508	857	java/lang/Exception
    //   508	532	857	java/lang/Exception
    //   532	538	857	java/lang/Exception
    //   547	565	857	java/lang/Exception
    //   565	571	857	java/lang/Exception
    //   580	599	857	java/lang/Exception
    //   599	624	857	java/lang/Exception
    //   624	648	857	java/lang/Exception
    //   648	672	857	java/lang/Exception
    //   672	700	857	java/lang/Exception
    //   700	722	857	java/lang/Exception
    //   722	744	857	java/lang/Exception
    //   744	766	857	java/lang/Exception
    //   766	788	857	java/lang/Exception
    //   788	810	857	java/lang/Exception
    //   810	832	857	java/lang/Exception
    //   832	854	857	java/lang/Exception
    //   936	943	857	java/lang/Exception
    //   947	954	857	java/lang/Exception
    //   958	965	857	java/lang/Exception
    //   968	987	857	java/lang/Exception
    //   990	1029	857	java/lang/Exception
    //   1032	1038	857	java/lang/Exception
    //   1045	1059	857	java/lang/Exception
    //   1072	1092	857	java/lang/Exception
    //   1092	1104	857	java/lang/Exception
    //   1116	1136	857	java/lang/Exception
    //   1136	1148	857	java/lang/Exception
    //   1160	1180	857	java/lang/Exception
    //   1180	1192	857	java/lang/Exception
    //   1204	1224	857	java/lang/Exception
    //   1224	1236	857	java/lang/Exception
    //   1248	1268	857	java/lang/Exception
    //   1268	1280	857	java/lang/Exception
    //   1292	1313	857	java/lang/Exception
    //   1313	1325	857	java/lang/Exception
    //   1333	1353	857	java/lang/Exception
    //   1353	1358	857	java/lang/Exception
    //   1361	1370	857	java/lang/Exception
    //   1374	1471	857	java/lang/Exception
    //   1471	1490	857	java/lang/Exception
    //   1494	1504	857	java/lang/Exception
    //   1507	1520	857	java/lang/Exception
    //   1520	1561	857	java/lang/Exception
    //   1564	1594	857	java/lang/Exception
    //   481	490	935	java/lang/Exception
    //   538	547	946	java/lang/Exception
    //   571	580	957	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SignatureTemplateConfig
 * JD-Core Version:    0.7.0.1
 */