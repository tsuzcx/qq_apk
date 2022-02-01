package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

class MessengerService$IncomingHandler$16
  implements Runnable
{
  MessengerService$IncomingHandler$16(MessengerService.IncomingHandler paramIncomingHandler, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 38	android/os/Bundle
    //   3: dup
    //   4: invokespecial 39	android/os/Bundle:<init>	()V
    //   7: astore 11
    //   9: new 41	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 42	org/json/JSONArray:<init>	()V
    //   16: astore 12
    //   18: new 41	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 19	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 45	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore 13
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: aload 13
    //   36: invokevirtual 49	org/json/JSONArray:length	()I
    //   39: if_icmpge +520 -> 559
    //   42: aload 13
    //   44: iload_1
    //   45: invokevirtual 53	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   48: astore 5
    //   50: aload 5
    //   52: ldc 55
    //   54: invokevirtual 61	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 8
    //   59: aload 5
    //   61: ldc 63
    //   63: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   66: istore_2
    //   67: aload 5
    //   69: ldc 69
    //   71: invokevirtual 61	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 14
    //   76: ldc 71
    //   78: astore 9
    //   80: new 73	java/io/File
    //   83: dup
    //   84: aload_0
    //   85: getfield 21	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: iconst_1
    //   89: aload 8
    //   91: iconst_0
    //   92: invokevirtual 79	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ILjava/lang/String;I)Ljava/lang/String;
    //   95: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 84	java/io/File:exists	()Z
    //   105: ifeq +280 -> 385
    //   108: aload 6
    //   110: invokevirtual 87	java/io/File:length	()J
    //   113: lstore_3
    //   114: lload_3
    //   115: ldc2_w 88
    //   118: lcmp
    //   119: ifge +241 -> 360
    //   122: lload_3
    //   123: l2i
    //   124: newarray byte
    //   126: astore 15
    //   128: aconst_null
    //   129: astore 7
    //   131: aconst_null
    //   132: astore 10
    //   134: aconst_null
    //   135: astore 5
    //   137: new 91	java/io/FileInputStream
    //   140: dup
    //   141: aload 6
    //   143: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: astore 6
    //   148: aload 6
    //   150: aload 15
    //   152: invokevirtual 98	java/io/FileInputStream:read	([B)I
    //   155: pop
    //   156: new 100	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   163: astore 5
    //   165: aload 5
    //   167: ldc 103
    //   169: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 5
    //   175: aload 15
    //   177: iconst_2
    //   178: invokestatic 113	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   181: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 5
    //   187: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 7
    //   192: aload 6
    //   194: invokevirtual 120	java/io/FileInputStream:close	()V
    //   197: goto +10 -> 207
    //   200: astore 5
    //   202: aload 5
    //   204: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   207: goto +200 -> 407
    //   210: astore 5
    //   212: goto +125 -> 337
    //   215: astore 7
    //   217: goto +35 -> 252
    //   220: astore 7
    //   222: goto +80 -> 302
    //   225: astore 6
    //   227: aload 5
    //   229: astore 7
    //   231: aload 6
    //   233: astore 5
    //   235: aload 7
    //   237: astore 6
    //   239: goto +98 -> 337
    //   242: astore 5
    //   244: aload 7
    //   246: astore 6
    //   248: aload 5
    //   250: astore 7
    //   252: aload 6
    //   254: astore 5
    //   256: aload 7
    //   258: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   261: aload 9
    //   263: astore 7
    //   265: aload 6
    //   267: ifnull +140 -> 407
    //   270: aload 6
    //   272: invokevirtual 120	java/io/FileInputStream:close	()V
    //   275: aload 9
    //   277: astore 7
    //   279: goto +128 -> 407
    //   282: astore 5
    //   284: aload 5
    //   286: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   289: aload 9
    //   291: astore 7
    //   293: goto +114 -> 407
    //   296: astore 7
    //   298: aload 10
    //   300: astore 6
    //   302: aload 6
    //   304: astore 5
    //   306: aload 7
    //   308: invokevirtual 124	java/io/FileNotFoundException:printStackTrace	()V
    //   311: aload 9
    //   313: astore 7
    //   315: aload 6
    //   317: ifnull +90 -> 407
    //   320: aload 6
    //   322: invokevirtual 120	java/io/FileInputStream:close	()V
    //   325: aload 9
    //   327: astore 7
    //   329: goto +78 -> 407
    //   332: astore 5
    //   334: goto -50 -> 284
    //   337: aload 6
    //   339: ifnull +18 -> 357
    //   342: aload 6
    //   344: invokevirtual 120	java/io/FileInputStream:close	()V
    //   347: goto +10 -> 357
    //   350: astore 6
    //   352: aload 6
    //   354: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   357: aload 5
    //   359: athrow
    //   360: aload 9
    //   362: astore 7
    //   364: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +40 -> 407
    //   370: ldc 131
    //   372: iconst_2
    //   373: ldc 133
    //   375: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload 9
    //   380: astore 7
    //   382: goto +25 -> 407
    //   385: aload 9
    //   387: astore 7
    //   389: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +15 -> 407
    //   395: ldc 131
    //   397: iconst_2
    //   398: ldc 139
    //   400: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload 9
    //   405: astore 7
    //   407: iload_2
    //   408: ifeq +68 -> 476
    //   411: iload_2
    //   412: iconst_1
    //   413: if_icmpeq +45 -> 458
    //   416: iload_2
    //   417: sipush 3000
    //   420: if_icmpeq +20 -> 440
    //   423: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +173 -> 599
    //   429: ldc 131
    //   431: iconst_2
    //   432: ldc 141
    //   434: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: goto +162 -> 599
    //   440: aload_0
    //   441: getfield 21	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   444: aload 8
    //   446: aload 14
    //   448: iconst_2
    //   449: iconst_0
    //   450: invokestatic 146	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   453: astore 5
    //   455: goto +36 -> 491
    //   458: aload_0
    //   459: getfield 21	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   462: aload 8
    //   464: aload 14
    //   466: iconst_1
    //   467: iconst_0
    //   468: invokestatic 146	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   471: astore 5
    //   473: goto +18 -> 491
    //   476: aload_0
    //   477: getfield 21	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   480: aload 8
    //   482: aload 14
    //   484: iconst_0
    //   485: iconst_0
    //   486: invokestatic 146	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   489: astore 5
    //   491: new 57	org/json/JSONObject
    //   494: dup
    //   495: invokespecial 147	org/json/JSONObject:<init>	()V
    //   498: astore 6
    //   500: aload 6
    //   502: ldc 55
    //   504: aload 8
    //   506: invokevirtual 151	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload 6
    //   512: ldc 153
    //   514: aload 5
    //   516: invokevirtual 151	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 6
    //   522: ldc 155
    //   524: aload 7
    //   526: invokevirtual 151	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   529: pop
    //   530: aload 12
    //   532: aload 6
    //   534: invokevirtual 158	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   537: pop
    //   538: iload_1
    //   539: iconst_1
    //   540: iadd
    //   541: istore_1
    //   542: goto -509 -> 33
    //   545: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +11 -> 559
    //   551: ldc 131
    //   553: iconst_2
    //   554: ldc 160
    //   556: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aload 11
    //   561: ldc 162
    //   563: aload 12
    //   565: invokevirtual 163	org/json/JSONArray:toString	()Ljava/lang/String;
    //   568: invokevirtual 167	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload_0
    //   572: getfield 23	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   575: ldc 169
    //   577: aload 11
    //   579: invokevirtual 173	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   582: aload_0
    //   583: getfield 25	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   586: aload_0
    //   587: getfield 23	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler$16:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   590: invokevirtual 178	com/tencent/mobileqq/emosm/web/MessengerService:a	(Landroid/os/Bundle;)V
    //   593: return
    //   594: astore 5
    //   596: goto -51 -> 545
    //   599: aload 8
    //   601: astore 5
    //   603: goto -112 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	16
    //   32	510	1	i	int
    //   66	355	2	j	int
    //   113	10	3	l	long
    //   48	138	5	localObject1	Object
    //   200	3	5	localIOException1	java.io.IOException
    //   210	18	5	localObject2	Object
    //   233	1	5	localObject3	Object
    //   242	7	5	localIOException2	java.io.IOException
    //   254	1	5	localObject4	Object
    //   282	3	5	localIOException3	java.io.IOException
    //   304	1	5	localObject5	Object
    //   332	26	5	localIOException4	java.io.IOException
    //   453	62	5	str1	String
    //   594	1	5	localJSONException	org.json.JSONException
    //   601	1	5	localObject6	Object
    //   98	95	6	localObject7	Object
    //   225	7	6	localObject8	Object
    //   237	106	6	localObject9	Object
    //   350	3	6	localIOException5	java.io.IOException
    //   498	35	6	localJSONObject	org.json.JSONObject
    //   129	62	7	str2	String
    //   215	1	7	localIOException6	java.io.IOException
    //   220	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   229	63	7	localObject10	Object
    //   296	11	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   313	212	7	str3	String
    //   57	543	8	str4	String
    //   78	326	9	str5	String
    //   132	167	10	localObject11	Object
    //   7	571	11	localBundle	Bundle
    //   16	548	12	localJSONArray1	org.json.JSONArray
    //   29	14	13	localJSONArray2	org.json.JSONArray
    //   74	409	14	str6	String
    //   126	50	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   192	197	200	java/io/IOException
    //   148	192	210	finally
    //   148	192	215	java/io/IOException
    //   148	192	220	java/io/FileNotFoundException
    //   137	148	225	finally
    //   256	261	225	finally
    //   306	311	225	finally
    //   137	148	242	java/io/IOException
    //   270	275	282	java/io/IOException
    //   137	148	296	java/io/FileNotFoundException
    //   320	325	332	java/io/IOException
    //   342	347	350	java/io/IOException
    //   18	31	594	org/json/JSONException
    //   33	76	594	org/json/JSONException
    //   80	114	594	org/json/JSONException
    //   122	128	594	org/json/JSONException
    //   192	197	594	org/json/JSONException
    //   202	207	594	org/json/JSONException
    //   270	275	594	org/json/JSONException
    //   284	289	594	org/json/JSONException
    //   320	325	594	org/json/JSONException
    //   342	347	594	org/json/JSONException
    //   352	357	594	org/json/JSONException
    //   357	360	594	org/json/JSONException
    //   364	378	594	org/json/JSONException
    //   389	403	594	org/json/JSONException
    //   423	437	594	org/json/JSONException
    //   440	455	594	org/json/JSONException
    //   458	473	594	org/json/JSONException
    //   476	491	594	org/json/JSONException
    //   491	538	594	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.16
 * JD-Core Version:    0.7.0.1
 */