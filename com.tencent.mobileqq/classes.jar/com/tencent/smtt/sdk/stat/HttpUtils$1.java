package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;

final class HttpUtils$1
  extends Thread
{
  HttpUtils$1(String paramString, Context paramContext, ThirdAppInfoNew paramThirdAppInfoNew)
  {
    super(paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 14	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
    //   8: getfield 38	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   11: invokestatic 44	com/tencent/smtt/utils/AppUtil:saveGuid	(Landroid/content/Context;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 14	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
    //   18: invokestatic 48	com/tencent/smtt/utils/AppUtil:getDeviceCpuabi	()Ljava/lang/String;
    //   21: putfield 51	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   24: getstatic 57	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 8
    //   29: if_icmpge +4 -> 33
    //   32: return
    //   33: getstatic 63	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
    //   36: ifnonnull +13 -> 49
    //   39: ldc 65
    //   41: ldc 67
    //   43: invokevirtual 73	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   46: putstatic 63	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
    //   49: getstatic 63	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
    //   52: ifnonnull +26 -> 78
    //   55: ldc 75
    //   57: ldc 77
    //   59: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: return
    //   63: astore_2
    //   64: aconst_null
    //   65: putstatic 63	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
    //   68: ldc 75
    //   70: ldc 85
    //   72: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: goto -26 -> 49
    //   78: aload_0
    //   79: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   82: invokestatic 91	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   85: getfield 95	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   88: ldc 97
    //   90: ldc 99
    //   92: invokeinterface 105 3 0
    //   97: astore_2
    //   98: aload_2
    //   99: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +623 -> 725
    //   105: aload_2
    //   106: iconst_0
    //   107: aload_2
    //   108: ldc 113
    //   110: invokevirtual 117	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   113: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_2
    //   118: aload_2
    //   119: ldc 113
    //   121: invokevirtual 117	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   124: iconst_1
    //   125: iadd
    //   126: aload_2
    //   127: invokevirtual 125	java/lang/String:length	()I
    //   130: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_3
    //   135: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +28 -> 166
    //   141: aload_3
    //   142: invokevirtual 125	java/lang/String:length	()I
    //   145: bipush 96
    //   147: if_icmpne +19 -> 166
    //   150: aload_2
    //   151: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +12 -> 166
    //   157: aload_2
    //   158: invokevirtual 125	java/lang/String:length	()I
    //   161: bipush 24
    //   163: if_icmpeq +132 -> 295
    //   166: iconst_1
    //   167: istore_1
    //   168: invokestatic 130	com/tencent/smtt/utils/TbsCommonConfig:getInstance	()Lcom/tencent/smtt/utils/TbsCommonConfig;
    //   171: astore 4
    //   173: iload_1
    //   174: ifeq +126 -> 300
    //   177: new 132	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   184: aload 4
    //   186: invokevirtual 137	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrl	()Ljava/lang/String;
    //   189: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokestatic 146	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   195: invokevirtual 149	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   198: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore_3
    //   205: new 154	java/net/URL
    //   208: dup
    //   209: aload_3
    //   210: invokespecial 155	java/net/URL:<init>	(Ljava/lang/String;)V
    //   213: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   216: checkcast 161	java/net/HttpURLConnection
    //   219: astore 5
    //   221: aload 5
    //   223: ldc 163
    //   225: invokevirtual 166	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   228: aload 5
    //   230: iconst_1
    //   231: invokevirtual 170	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   234: aload 5
    //   236: iconst_1
    //   237: invokevirtual 173	java/net/HttpURLConnection:setDoInput	(Z)V
    //   240: aload 5
    //   242: iconst_0
    //   243: invokevirtual 176	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   246: aload 5
    //   248: sipush 20000
    //   251: invokevirtual 180	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   254: getstatic 57	android/os/Build$VERSION:SDK_INT	I
    //   257: bipush 13
    //   259: if_icmple +12 -> 271
    //   262: aload 5
    //   264: ldc 182
    //   266: ldc 184
    //   268: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 14	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
    //   275: aload_0
    //   276: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   279: invokestatic 191	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
    //   282: astore_3
    //   283: aload_3
    //   284: ifnonnull +130 -> 414
    //   287: ldc 75
    //   289: ldc 193
    //   291: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: return
    //   295: iconst_0
    //   296: istore_1
    //   297: goto -129 -> 168
    //   300: new 132	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   307: aload 4
    //   309: invokevirtual 196	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrlWithToken	()Ljava/lang/String;
    //   312: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore_3
    //   323: goto -118 -> 205
    //   326: astore_2
    //   327: ldc 75
    //   329: new 132	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   336: ldc 198
    //   338: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: return
    //   352: astore_2
    //   353: ldc 75
    //   355: new 132	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   362: ldc 203
    //   364: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_2
    //   368: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: return
    //   378: astore_2
    //   379: ldc 75
    //   381: new 132	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   388: ldc 205
    //   390: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: return
    //   404: astore_3
    //   405: aload_3
    //   406: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   409: aconst_null
    //   410: astore_3
    //   411: goto -128 -> 283
    //   414: aload_3
    //   415: invokevirtual 211	org/json/JSONObject:toString	()Ljava/lang/String;
    //   418: ldc 67
    //   420: invokevirtual 73	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   423: astore 4
    //   425: iload_1
    //   426: ifeq +198 -> 624
    //   429: invokestatic 146	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   432: aload 4
    //   434: invokevirtual 215	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   437: astore 4
    //   439: aload 5
    //   441: ldc 217
    //   443: ldc 219
    //   445: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload 5
    //   450: ldc 221
    //   452: aload 4
    //   454: arraylength
    //   455: invokestatic 225	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   458: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload 5
    //   463: invokevirtual 229	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   466: astore 6
    //   468: aload 6
    //   470: aload 4
    //   472: invokevirtual 235	java/io/OutputStream:write	([B)V
    //   475: aload 6
    //   477: invokevirtual 238	java/io/OutputStream:flush	()V
    //   480: aload 5
    //   482: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   485: sipush 200
    //   488: if_icmpne +147 -> 635
    //   491: ldc 75
    //   493: ldc 243
    //   495: invokestatic 246	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: ldc 75
    //   500: new 132	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   507: ldc 248
    //   509: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_3
    //   513: ldc 250
    //   515: invokevirtual 253	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 246	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload 5
    //   529: aload_2
    //   530: iload_1
    //   531: invokestatic 257	com/tencent/smtt/sdk/stat/HttpUtils:access$100	(Ljava/net/HttpURLConnection;Ljava/lang/String;Z)Ljava/lang/String;
    //   534: astore_2
    //   535: aload_0
    //   536: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   539: aload_2
    //   540: invokestatic 260	com/tencent/smtt/sdk/stat/HttpUtils:access$200	(Landroid/content/Context;Ljava/lang/String;)V
    //   543: new 262	com/tencent/smtt/sdk/TbsDownloadUpload
    //   546: dup
    //   547: aload_0
    //   548: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   551: invokespecial 265	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   554: invokevirtual 268	com/tencent/smtt/sdk/TbsDownloadUpload:clearUploadCode	()V
    //   557: return
    //   558: astore_2
    //   559: ldc 75
    //   561: new 132	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 270
    //   571: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_2
    //   575: invokevirtual 273	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   578: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aload_0
    //   588: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   591: invokestatic 278	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   594: invokevirtual 282	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   597: astore_3
    //   598: aload_3
    //   599: bipush 126
    //   601: invokevirtual 287	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   604: aload_3
    //   605: aload_2
    //   606: invokevirtual 291	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/Throwable;)V
    //   609: aload_0
    //   610: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   613: invokestatic 278	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   616: getstatic 297	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   619: aload_3
    //   620: invokevirtual 301	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   623: return
    //   624: aload 4
    //   626: aload_2
    //   627: invokestatic 304	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([BLjava/lang/String;)[B
    //   630: astore 4
    //   632: goto -193 -> 439
    //   635: ldc 75
    //   637: new 132	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 306
    //   647: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 5
    //   652: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   655: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 83	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: aload_0
    //   665: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   668: invokestatic 278	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   671: invokevirtual 282	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   674: astore_2
    //   675: aload_2
    //   676: bipush 126
    //   678: invokevirtual 287	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   681: aload_2
    //   682: new 132	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   689: ldc 99
    //   691: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 5
    //   696: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   699: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokevirtual 311	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   708: aload_0
    //   709: getfield 12	com/tencent/smtt/sdk/stat/HttpUtils$1:val$ctx	Landroid/content/Context;
    //   712: invokestatic 278	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   715: getstatic 297	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   718: aload_2
    //   719: invokevirtual 301	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   722: return
    //   723: astore_2
    //   724: return
    //   725: ldc 99
    //   727: astore_3
    //   728: ldc 99
    //   730: astore_2
    //   731: goto -597 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	734	0	this	1
    //   167	364	1	bool	boolean
    //   63	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   97	61	2	str1	String
    //   326	16	2	localIOException	java.io.IOException
    //   352	16	2	localAssertionError	java.lang.AssertionError
    //   378	152	2	localNoClassDefFoundError	java.lang.NoClassDefFoundError
    //   534	6	2	str2	String
    //   558	69	2	localThrowable1	java.lang.Throwable
    //   674	45	2	localTbsLogInfo	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
    //   723	1	2	localThrowable2	java.lang.Throwable
    //   730	1	2	str3	String
    //   116	207	3	localObject1	java.lang.Object
    //   404	2	3	localException	java.lang.Exception
    //   410	318	3	localObject2	java.lang.Object
    //   171	460	4	localObject3	java.lang.Object
    //   219	476	5	localHttpURLConnection	java.net.HttpURLConnection
    //   466	10	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   39	49	63	java/io/UnsupportedEncodingException
    //   168	173	326	java/io/IOException
    //   177	205	326	java/io/IOException
    //   205	228	326	java/io/IOException
    //   300	323	326	java/io/IOException
    //   168	173	352	java/lang/AssertionError
    //   177	205	352	java/lang/AssertionError
    //   205	228	352	java/lang/AssertionError
    //   300	323	352	java/lang/AssertionError
    //   168	173	378	java/lang/NoClassDefFoundError
    //   177	205	378	java/lang/NoClassDefFoundError
    //   205	228	378	java/lang/NoClassDefFoundError
    //   300	323	378	java/lang/NoClassDefFoundError
    //   271	283	404	java/lang/Exception
    //   461	557	558	java/lang/Throwable
    //   635	722	558	java/lang/Throwable
    //   414	425	723	java/lang/Throwable
    //   429	439	723	java/lang/Throwable
    //   624	632	723	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils.1
 * JD-Core Version:    0.7.0.1
 */