package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class MiniGamePayFragment$PayResultRecevicer
  extends ResultReceiver
{
  public MiniGamePayFragment$PayResultRecevicer(MiniGamePayFragment paramMiniGamePayFragment, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  /* Error */
  private void handlePayResult(int paramInt, Bundle paramBundle, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 24
    //   2: astore 13
    //   4: aload_2
    //   5: ldc 26
    //   7: invokevirtual 32	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 14
    //   12: aload_2
    //   13: ldc 34
    //   15: invokevirtual 32	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 15
    //   20: aload 15
    //   22: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +229 -> 254
    //   28: aload 15
    //   30: invokestatic 46	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   33: ifeq +183 -> 216
    //   36: new 48	org/json/JSONObject
    //   39: dup
    //   40: aload 15
    //   42: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 12
    //   47: aload 12
    //   49: ldc 53
    //   51: iconst_m1
    //   52: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   55: istore 6
    //   57: aload 12
    //   59: ldc 59
    //   61: aconst_null
    //   62: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_2
    //   66: aload 12
    //   68: ldc 65
    //   70: aconst_null
    //   71: invokevirtual 63	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 11
    //   76: aload 12
    //   78: ldc 67
    //   80: iconst_m1
    //   81: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   84: istore 5
    //   86: aload 12
    //   88: ldc 69
    //   90: iconst_m1
    //   91: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   94: istore_1
    //   95: aload 12
    //   97: ldc 71
    //   99: iconst_m1
    //   100: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   103: istore 4
    //   105: aload 12
    //   107: ldc 73
    //   109: iconst_0
    //   110: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   113: istore 7
    //   115: iload 6
    //   117: istore 8
    //   119: iload_1
    //   120: istore 6
    //   122: iload 8
    //   124: istore_1
    //   125: goto +148 -> 273
    //   128: astore 12
    //   130: goto +61 -> 191
    //   133: astore 12
    //   135: goto +32 -> 167
    //   138: astore 12
    //   140: iconst_m1
    //   141: istore_1
    //   142: goto +25 -> 167
    //   145: astore 12
    //   147: goto +15 -> 162
    //   150: astore 12
    //   152: goto +7 -> 159
    //   155: astore 12
    //   157: aconst_null
    //   158: astore_2
    //   159: aconst_null
    //   160: astore 11
    //   162: iconst_m1
    //   163: istore_1
    //   164: iconst_m1
    //   165: istore 5
    //   167: iconst_m1
    //   168: istore 4
    //   170: goto +21 -> 191
    //   173: astore 12
    //   175: aconst_null
    //   176: astore_2
    //   177: aconst_null
    //   178: astore 11
    //   180: iconst_m1
    //   181: istore_1
    //   182: iconst_m1
    //   183: istore 5
    //   185: iconst_m1
    //   186: istore 4
    //   188: iconst_m1
    //   189: istore 6
    //   191: ldc 75
    //   193: iconst_1
    //   194: aload 12
    //   196: iconst_0
    //   197: anewarray 77	java/lang/Object
    //   200: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   203: iload 6
    //   205: istore 7
    //   207: iload_1
    //   208: istore 6
    //   210: iload 7
    //   212: istore_1
    //   213: goto +57 -> 270
    //   216: aload 15
    //   218: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   221: istore_1
    //   222: aconst_null
    //   223: astore_2
    //   224: iconst_m1
    //   225: istore 4
    //   227: aconst_null
    //   228: astore 11
    //   230: iconst_m1
    //   231: istore 6
    //   233: iconst_m1
    //   234: istore 5
    //   236: goto +34 -> 270
    //   239: astore_2
    //   240: ldc 75
    //   242: iconst_1
    //   243: aload_2
    //   244: iconst_0
    //   245: anewarray 77	java/lang/Object
    //   248: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   251: goto +3 -> 254
    //   254: aconst_null
    //   255: astore_2
    //   256: iconst_m1
    //   257: istore 4
    //   259: aconst_null
    //   260: astore 11
    //   262: iconst_m1
    //   263: istore 6
    //   265: iconst_m1
    //   266: istore 5
    //   268: iconst_m1
    //   269: istore_1
    //   270: iconst_0
    //   271: istore 7
    //   273: new 91	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   280: astore 12
    //   282: aload 12
    //   284: ldc 96
    //   286: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 12
    //   292: iload_1
    //   293: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 12
    //   299: ldc 105
    //   301: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 12
    //   307: aload 15
    //   309: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 12
    //   315: ldc 107
    //   317: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 12
    //   323: aload 14
    //   325: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 75
    //   331: iconst_1
    //   332: aload 12
    //   334: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: new 48	org/json/JSONObject
    //   343: dup
    //   344: invokespecial 116	org/json/JSONObject:<init>	()V
    //   347: astore 15
    //   349: new 48	org/json/JSONObject
    //   352: dup
    //   353: aload 14
    //   355: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   358: astore 14
    //   360: aload 14
    //   362: ldc 118
    //   364: iconst_m1
    //   365: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   368: istore 9
    //   370: ldc 75
    //   372: astore 12
    //   374: aload 14
    //   376: ldc 120
    //   378: iconst_m1
    //   379: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   382: pop
    //   383: aload 14
    //   385: ldc 122
    //   387: invokevirtual 126	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload 15
    //   393: ldc 118
    //   395: iload 9
    //   397: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload 14
    //   403: ldc 132
    //   405: iconst_m1
    //   406: invokevirtual 57	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   409: istore 8
    //   411: iload 8
    //   413: bipush 8
    //   415: if_icmpne +9 -> 424
    //   418: iconst_2
    //   419: istore 8
    //   421: goto +6 -> 427
    //   424: iconst_3
    //   425: istore 8
    //   427: iload 9
    //   429: ifne +226 -> 655
    //   432: aload_2
    //   433: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   436: istore 10
    //   438: iload 10
    //   440: ifne +71 -> 511
    //   443: aload 11
    //   445: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifne +63 -> 511
    //   451: iload 4
    //   453: iconst_m1
    //   454: if_icmpeq +57 -> 511
    //   457: iload 6
    //   459: iconst_m1
    //   460: if_icmpeq +51 -> 511
    //   463: iload 5
    //   465: iconst_m1
    //   466: if_icmpeq +45 -> 511
    //   469: iload 8
    //   471: iconst_m1
    //   472: if_icmpeq +39 -> 511
    //   475: aload_0
    //   476: getfield 10	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
    //   479: astore 12
    //   481: aload 12
    //   483: aload_2
    //   484: aload 11
    //   486: iload 4
    //   488: iload 5
    //   490: iload 6
    //   492: iload 8
    //   494: aconst_null
    //   495: aload_3
    //   496: iload_1
    //   497: iload 7
    //   499: invokevirtual 138	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:invokeMidasConsume	(Ljava/lang/String;Ljava/lang/String;IIIILNS_COMM/COMM$StCommonExt;Ljava/lang/String;II)V
    //   502: return
    //   503: astore_2
    //   504: ldc 75
    //   506: astore 11
    //   508: goto +144 -> 652
    //   511: iload_1
    //   512: istore 4
    //   514: aload_3
    //   515: aload 14
    //   517: invokestatic 144	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   520: astore_2
    //   521: aload_2
    //   522: ldc 118
    //   524: bipush 252
    //   526: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   529: pop
    //   530: aload_2
    //   531: ifnull +15 -> 546
    //   534: aload_2
    //   535: invokevirtual 145	org/json/JSONObject:toString	()Ljava/lang/String;
    //   538: astore_2
    //   539: goto +10 -> 549
    //   542: astore_2
    //   543: goto -39 -> 504
    //   546: ldc 24
    //   548: astore_2
    //   549: aload_2
    //   550: ifnull +85 -> 635
    //   553: new 91	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   560: astore 11
    //   562: aload 11
    //   564: ldc 147
    //   566: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 11
    //   572: aload_3
    //   573: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 11
    //   579: ldc 149
    //   581: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 11
    //   587: aload_2
    //   588: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 11
    //   594: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: astore 11
    //   599: aload 12
    //   601: iconst_1
    //   602: aload 11
    //   604: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_0
    //   608: getfield 10	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
    //   611: astore 11
    //   613: aload 11
    //   615: aload_3
    //   616: aload_2
    //   617: iload 4
    //   619: invokestatic 153	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:access$000	(Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;Ljava/lang/String;Ljava/lang/String;I)V
    //   622: return
    //   623: astore_2
    //   624: goto +24 -> 648
    //   627: astore_2
    //   628: goto +9 -> 637
    //   631: astore_2
    //   632: goto +5 -> 637
    //   635: return
    //   636: astore_2
    //   637: ldc 75
    //   639: astore 11
    //   641: iload 4
    //   643: istore_1
    //   644: goto +8 -> 652
    //   647: astore_2
    //   648: ldc 75
    //   650: astore 11
    //   652: goto +44 -> 696
    //   655: aload_0
    //   656: getfield 10	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
    //   659: astore 12
    //   661: aload 12
    //   663: aload 11
    //   665: aload_2
    //   666: iload 4
    //   668: aconst_null
    //   669: aload_3
    //   670: iload_1
    //   671: iload 7
    //   673: iload 8
    //   675: invokevirtual 157	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:invokeMidasQuery	(Ljava/lang/String;Ljava/lang/String;ILNS_COMM/COMM$StCommonExt;Ljava/lang/String;III)V
    //   678: return
    //   679: astore_2
    //   680: goto +12 -> 692
    //   683: astore_2
    //   684: goto +4 -> 688
    //   687: astore_2
    //   688: goto +4 -> 692
    //   691: astore_2
    //   692: ldc 75
    //   694: astore 11
    //   696: aload 11
    //   698: iconst_1
    //   699: aload_2
    //   700: iconst_0
    //   701: anewarray 77	java/lang/Object
    //   704: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   707: aload_3
    //   708: aconst_null
    //   709: invokestatic 144	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   712: astore 12
    //   714: aload 12
    //   716: ldc 118
    //   718: bipush 253
    //   720: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   723: pop
    //   724: goto +8 -> 732
    //   727: astore_2
    //   728: aload_2
    //   729: invokevirtual 160	org/json/JSONException:printStackTrace	()V
    //   732: aload 13
    //   734: astore_2
    //   735: aload 12
    //   737: ifnull +9 -> 746
    //   740: aload 12
    //   742: invokevirtual 145	org/json/JSONObject:toString	()Ljava/lang/String;
    //   745: astore_2
    //   746: aload_2
    //   747: ifnull +79 -> 826
    //   750: new 91	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   757: astore 12
    //   759: aload 12
    //   761: ldc 147
    //   763: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 12
    //   769: aload_3
    //   770: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 12
    //   776: ldc 149
    //   778: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload 12
    //   784: aload_2
    //   785: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 12
    //   791: ldc 162
    //   793: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 12
    //   799: iload_1
    //   800: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload 11
    //   806: iconst_1
    //   807: aload 12
    //   809: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: aload_0
    //   816: getfield 10	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment$PayResultRecevicer:this$0	Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;
    //   819: aload_3
    //   820: aload_2
    //   821: iload_1
    //   822: invokestatic 153	com/tencent/mobileqq/minigame/ui/MiniGamePayFragment:access$000	(Lcom/tencent/mobileqq/minigame/ui/MiniGamePayFragment;Ljava/lang/String;Ljava/lang/String;I)V
    //   825: return
    //   826: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	827	0	this	PayResultRecevicer
    //   0	827	1	paramInt	int
    //   0	827	2	paramBundle	Bundle
    //   0	827	3	paramString	java.lang.String
    //   103	564	4	i	int
    //   84	405	5	j	int
    //   55	436	6	k	int
    //   113	559	7	m	int
    //   117	557	8	n	int
    //   368	60	9	i1	int
    //   436	3	10	bool	boolean
    //   74	731	11	localObject1	java.lang.Object
    //   45	61	12	localJSONObject	org.json.JSONObject
    //   128	1	12	localJSONException1	org.json.JSONException
    //   133	1	12	localJSONException2	org.json.JSONException
    //   138	1	12	localJSONException3	org.json.JSONException
    //   145	1	12	localJSONException4	org.json.JSONException
    //   150	1	12	localJSONException5	org.json.JSONException
    //   155	1	12	localJSONException6	org.json.JSONException
    //   173	22	12	localJSONException7	org.json.JSONException
    //   280	528	12	localObject2	java.lang.Object
    //   2	731	13	str	java.lang.String
    //   10	506	14	localObject3	java.lang.Object
    //   18	374	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   105	115	128	org/json/JSONException
    //   95	105	133	org/json/JSONException
    //   86	95	138	org/json/JSONException
    //   76	86	145	org/json/JSONException
    //   66	76	150	org/json/JSONException
    //   57	66	155	org/json/JSONException
    //   36	57	173	org/json/JSONException
    //   216	222	239	java/lang/NumberFormatException
    //   443	451	503	java/lang/Throwable
    //   475	481	503	java/lang/Throwable
    //   481	502	542	java/lang/Throwable
    //   534	539	542	java/lang/Throwable
    //   613	622	623	java/lang/Throwable
    //   607	613	627	java/lang/Throwable
    //   599	607	631	java/lang/Throwable
    //   514	530	636	java/lang/Throwable
    //   553	599	636	java/lang/Throwable
    //   432	438	647	java/lang/Throwable
    //   661	678	679	java/lang/Throwable
    //   655	661	683	java/lang/Throwable
    //   374	411	687	java/lang/Throwable
    //   349	370	691	java/lang/Throwable
    //   714	724	727	org/json/JSONException
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveResult resultCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" resultData = ");
    localStringBuilder.append(paramBundle);
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, localStringBuilder.toString());
    if (paramInt != 6) {
      return;
    }
    handlePayResult(paramInt, paramBundle, "requestMidasPayment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment.PayResultRecevicer
 * JD-Core Version:    0.7.0.1
 */