package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.remote.ToServiceMsg;

class ag$c
  extends Thread
{
  long a = 0L;
  
  ag$c(ag paramag) {}
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
  {
    this.b.c(paramToServiceMsg.getRequestSsoSeq());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   4: getfield 40	com/tencent/mobileqq/msf/core/ag:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   7: invokevirtual 46	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
    //   10: checkcast 21	com/tencent/qphone/base/remote/ToServiceMsg
    //   13: astore 17
    //   15: aload_0
    //   16: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   19: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   22: ifnull +33 -> 55
    //   25: aload_0
    //   26: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   29: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   32: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   35: ifnull +20 -> 55
    //   38: aload_0
    //   39: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   42: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   45: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   48: iconst_1
    //   49: invokeinterface 62 2 0
    //   54: pop
    //   55: aload 17
    //   57: ifnull +1020 -> 1077
    //   60: aload 17
    //   62: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   65: astore 14
    //   67: aload 14
    //   69: ldc 68
    //   71: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_m1
    //   77: if_icmpeq +2700 -> 2777
    //   80: new 76	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   87: aload 14
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: aload 14
    //   94: invokevirtual 80	java/lang/String:length	()I
    //   97: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 90
    //   105: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 15
    //   113: aload 14
    //   115: iconst_0
    //   116: iload_3
    //   117: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
    //   120: astore 14
    //   122: aload 17
    //   124: ldc 95
    //   126: lconst_0
    //   127: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 105	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 97	java/lang/Long
    //   136: invokevirtual 109	java/lang/Long:longValue	()J
    //   139: lstore 7
    //   141: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   144: lstore 9
    //   146: aload_0
    //   147: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   150: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   153: getfield 118	com/tencent/mobileqq/msf/core/MsfCore:configManager	Lcom/tencent/mobileqq/msf/core/a/a;
    //   156: aload 17
    //   158: lload 9
    //   160: invokevirtual 123	com/tencent/mobileqq/msf/core/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;J)V
    //   163: aload 17
    //   165: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   168: ifnull +1220 -> 1388
    //   171: invokestatic 132	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   174: istore_2
    //   175: iload_2
    //   176: ifne +39 -> 215
    //   179: aload_0
    //   180: getfield 17	com/tencent/mobileqq/msf/core/ag$c:a	J
    //   183: lconst_0
    //   184: lcmp
    //   185: ifeq +17 -> 202
    //   188: lload 9
    //   190: aload_0
    //   191: getfield 17	com/tencent/mobileqq/msf/core/ag$c:a	J
    //   194: lsub
    //   195: ldc2_w 133
    //   198: lcmp
    //   199: ifle +16 -> 215
    //   202: aload_0
    //   203: lload 9
    //   205: putfield 17	com/tencent/mobileqq/msf/core/ag$c:a	J
    //   208: invokestatic 140	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   211: iconst_1
    //   212: invokestatic 146	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
    //   215: iload_2
    //   216: getstatic 150	com/tencent/mobileqq/msf/core/ag:M	I
    //   219: if_icmpeq +18 -> 237
    //   222: iload_2
    //   223: putstatic 150	com/tencent/mobileqq/msf/core/ag:M	I
    //   226: invokestatic 153	com/tencent/mobileqq/msf/core/ag:h	()V
    //   229: ldc 155
    //   231: iconst_1
    //   232: ldc 157
    //   234: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iconst_0
    //   238: invokestatic 167	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   241: i2b
    //   242: istore_3
    //   243: getstatic 171	com/tencent/mobileqq/msf/core/ag:P	Z
    //   246: ifeq +920 -> 1166
    //   249: iload_3
    //   250: iconst_4
    //   251: ior
    //   252: i2b
    //   253: istore_1
    //   254: getstatic 177	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   257: aload 17
    //   259: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   262: invokevirtual 186	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   265: ifeq +78 -> 343
    //   268: aload_0
    //   269: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   272: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   275: invokevirtual 190	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   278: aload 17
    //   280: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   283: invokevirtual 196	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
    //   286: getstatic 177	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   289: aload 17
    //   291: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   294: invokevirtual 200	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: ldc 155
    //   300: iconst_1
    //   301: new 76	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   308: ldc 202
    //   310: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 17
    //   315: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   318: invokestatic 208	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   321: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 210
    //   326: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 17
    //   331: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   334: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_0
    //   344: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   347: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   350: invokevirtual 221	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   353: ifne +14 -> 367
    //   356: invokestatic 153	com/tencent/mobileqq/msf/core/ag:h	()V
    //   359: ldc 155
    //   361: iconst_1
    //   362: ldc 223
    //   364: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   371: invokestatic 227	com/tencent/mobileqq/msf/core/ag:e	(Lcom/tencent/mobileqq/msf/core/ag;)Ljava/util/HashSet;
    //   374: aload 17
    //   376: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   379: invokevirtual 232	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   382: ifeq +12 -> 394
    //   385: aload 17
    //   387: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   390: iconst_0
    //   391: invokestatic 235	com/tencent/mobileqq/msf/core/ag:a	(Ljava/lang/String;Z)V
    //   394: aload_0
    //   395: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   398: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   401: invokevirtual 239	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   404: invokevirtual 244	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   407: ifnull +768 -> 1175
    //   410: aload_0
    //   411: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   414: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   417: invokevirtual 239	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   420: invokevirtual 244	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   423: invokevirtual 248	com/tencent/mobileqq/msf/core/d:d	()I
    //   426: istore_3
    //   427: aload 17
    //   429: iload_3
    //   430: invokestatic 251	com/tencent/mobileqq/msf/core/ag:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   433: astore 13
    //   435: aload 17
    //   437: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   440: ifnonnull +62 -> 502
    //   443: new 253	java/util/HashMap
    //   446: dup
    //   447: invokespecial 254	java/util/HashMap:<init>	()V
    //   450: astore 16
    //   452: aload 16
    //   454: ldc_w 256
    //   457: aload 17
    //   459: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   462: invokevirtual 260	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload_0
    //   467: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   470: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   473: invokevirtual 264	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   476: ifnull +26 -> 502
    //   479: aload_0
    //   480: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   483: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   486: invokevirtual 264	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   489: ldc_w 266
    //   492: iconst_0
    //   493: lconst_0
    //   494: lconst_0
    //   495: aload 16
    //   497: iconst_0
    //   498: iconst_0
    //   499: invokevirtual 271	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   502: invokestatic 274	com/tencent/mobileqq/msf/core/ag:r	()Z
    //   505: ifne +52 -> 557
    //   508: invokestatic 279	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   511: sipush 780
    //   514: if_icmpeq +38 -> 552
    //   517: aload_0
    //   518: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   521: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   524: invokevirtual 264	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   527: ifnull +25 -> 552
    //   530: aload_0
    //   531: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   534: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   537: invokevirtual 264	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   540: ldc_w 281
    //   543: iconst_0
    //   544: lconst_0
    //   545: lconst_0
    //   546: aconst_null
    //   547: iconst_0
    //   548: iconst_0
    //   549: invokevirtual 271	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   552: iconst_1
    //   553: invokestatic 284	com/tencent/mobileqq/msf/core/ag:a	(Z)Z
    //   556: pop
    //   557: sipush 591
    //   560: invokestatic 279	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   563: if_icmpne +678 -> 1241
    //   566: aload 17
    //   568: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   571: invokestatic 288	com/tencent/mobileqq/msf/core/t:d	()Ljava/lang/String;
    //   574: invokestatic 290	com/tencent/mobileqq/msf/core/t:f	()Ljava/lang/String;
    //   577: invokestatic 292	com/tencent/mobileqq/msf/core/t:g	()Ljava/lang/String;
    //   580: ldc_w 294
    //   583: aload 14
    //   585: aload_0
    //   586: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   589: invokevirtual 296	com/tencent/mobileqq/msf/core/ag:e	()[B
    //   592: aload 17
    //   594: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   597: aload_0
    //   598: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   601: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   604: invokevirtual 302	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   607: aload 17
    //   609: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   612: iconst_0
    //   613: iload_2
    //   614: aload 17
    //   616: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   619: iconst_0
    //   620: invokestatic 306	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   623: astore 13
    //   625: aload 13
    //   627: ifnull +21 -> 648
    //   630: aload 17
    //   632: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   635: ldc_w 312
    //   638: aload 13
    //   640: arraylength
    //   641: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokevirtual 260	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   647: pop
    //   648: ldc 155
    //   650: iconst_1
    //   651: new 76	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 319
    //   661: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 17
    //   666: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   669: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload 13
    //   680: astore 16
    //   682: aload 17
    //   684: ifnull +32 -> 716
    //   687: aload 13
    //   689: astore 16
    //   691: aload 17
    //   693: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   696: ifne +20 -> 716
    //   699: getstatic 322	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   702: invokevirtual 264	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   705: iconst_1
    //   706: aload 17
    //   708: aconst_null
    //   709: invokevirtual 325	com/tencent/mobileqq/msf/core/c/k:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   712: aload 13
    //   714: astore 16
    //   716: aload 16
    //   718: ifnonnull +678 -> 1396
    //   721: ldc 155
    //   723: iconst_1
    //   724: new 76	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 327
    //   734: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: aload 17
    //   739: invokevirtual 330	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
    //   742: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 333	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aload_0
    //   752: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   755: aload 17
    //   757: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   760: invokevirtual 31	com/tencent/mobileqq/msf/core/ag:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   763: pop
    //   764: aload_0
    //   765: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   768: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   771: ifnull -771 -> 0
    //   774: aload_0
    //   775: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   778: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   781: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   784: ifnull -784 -> 0
    //   787: aload_0
    //   788: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   791: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   794: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   797: iconst_1
    //   798: invokeinterface 336 2 0
    //   803: pop
    //   804: goto -804 -> 0
    //   807: astore 13
    //   809: ldc 155
    //   811: iconst_1
    //   812: new 76	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   819: ldc_w 338
    //   822: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload 13
    //   827: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: goto -621 -> 215
    //   839: astore 13
    //   841: ldc 155
    //   843: iconst_1
    //   844: aload 13
    //   846: invokevirtual 342	java/lang/Throwable:toString	()Ljava/lang/String;
    //   849: aload 13
    //   851: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   854: aload_0
    //   855: aload 17
    //   857: ldc_w 347
    //   860: aload 13
    //   862: invokevirtual 342	java/lang/Throwable:toString	()Ljava/lang/String;
    //   865: invokespecial 349	com/tencent/mobileqq/msf/core/ag$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload_0
    //   869: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   872: getfield 40	com/tencent/mobileqq/msf/core/ag:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   875: aload 17
    //   877: invokevirtual 351	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
    //   880: pop
    //   881: aload_0
    //   882: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   885: invokestatic 354	com/tencent/mobileqq/msf/core/ag:f	(Lcom/tencent/mobileqq/msf/core/ag;)J
    //   888: pop2
    //   889: aload 17
    //   891: invokevirtual 358	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   894: astore 13
    //   896: getstatic 364	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   899: astore 14
    //   901: aload 13
    //   903: aload 14
    //   905: if_acmpne +172 -> 1077
    //   908: aload 17
    //   910: aload 17
    //   912: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   915: invokevirtual 367	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   918: checkcast 369	com/tencent/qphone/base/remote/FromServiceMsg
    //   921: astore 13
    //   923: ldc 155
    //   925: iconst_1
    //   926: new 76	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   933: invokestatic 373	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   936: invokevirtual 376	java/lang/Thread:getName	()Ljava/lang/String;
    //   939: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 378
    //   945: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 13
    //   950: invokevirtual 379	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   953: invokestatic 208	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   956: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: aload_0
    //   966: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   969: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   972: invokevirtual 190	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   975: aload 13
    //   977: invokevirtual 379	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   980: invokevirtual 382	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
    //   983: aload 13
    //   985: sipush 2012
    //   988: aload 13
    //   990: invokevirtual 385	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   993: invokevirtual 389	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   996: iconst_0
    //   997: istore 11
    //   999: aload 17
    //   1001: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1004: ldc_w 391
    //   1007: invokevirtual 392	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1010: ifeq +19 -> 1029
    //   1013: aload 17
    //   1015: ldc_w 391
    //   1018: invokevirtual 367	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1021: checkcast 394	java/lang/Boolean
    //   1024: invokevirtual 397	java/lang/Boolean:booleanValue	()Z
    //   1027: istore 11
    //   1029: aload 13
    //   1031: ldc_w 391
    //   1034: iload 11
    //   1036: invokestatic 400	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1039: invokevirtual 403	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1042: pop
    //   1043: ldc_w 405
    //   1046: aload 13
    //   1048: invokestatic 409	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1051: aload_0
    //   1052: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1055: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1058: aconst_null
    //   1059: aload 13
    //   1061: invokevirtual 413	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1064: aload_0
    //   1065: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1068: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1071: getstatic 418	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
    //   1074: invokevirtual 421	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   1077: aload_0
    //   1078: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1081: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1084: ifnull +33 -> 1117
    //   1087: aload_0
    //   1088: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1091: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1094: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1097: ifnull +20 -> 1117
    //   1100: aload_0
    //   1101: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1104: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1107: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1110: iconst_1
    //   1111: invokeinterface 336 2 0
    //   1116: pop
    //   1117: ldc2_w 422
    //   1120: invokestatic 427	java/lang/Thread:sleep	(J)V
    //   1123: aload_0
    //   1124: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1127: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1130: ifnull -1130 -> 0
    //   1133: aload_0
    //   1134: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1137: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1140: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1143: ifnull -1143 -> 0
    //   1146: aload_0
    //   1147: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1150: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1153: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1156: iconst_1
    //   1157: invokeinterface 336 2 0
    //   1162: pop
    //   1163: goto -1163 -> 0
    //   1166: iload_3
    //   1167: bipush 251
    //   1169: iand
    //   1170: i2b
    //   1171: istore_1
    //   1172: goto -918 -> 254
    //   1175: iconst_1
    //   1176: istore_3
    //   1177: goto -750 -> 427
    //   1180: astore 16
    //   1182: ldc 155
    //   1184: iconst_1
    //   1185: ldc_w 429
    //   1188: aload 16
    //   1190: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1193: goto -636 -> 557
    //   1196: astore 13
    //   1198: aload_0
    //   1199: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1202: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1205: ifnull +33 -> 1238
    //   1208: aload_0
    //   1209: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1212: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1215: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1218: ifnull +20 -> 1238
    //   1221: aload_0
    //   1222: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1225: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1228: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1231: iconst_1
    //   1232: invokeinterface 336 2 0
    //   1237: pop
    //   1238: aload 13
    //   1240: athrow
    //   1241: sipush 595
    //   1244: invokestatic 279	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1247: if_icmpeq +12 -> 1259
    //   1250: sipush 600
    //   1253: invokestatic 279	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1256: if_icmpne +67 -> 1323
    //   1259: aload 17
    //   1261: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1264: invokestatic 288	com/tencent/mobileqq/msf/core/t:d	()Ljava/lang/String;
    //   1267: invokestatic 290	com/tencent/mobileqq/msf/core/t:f	()Ljava/lang/String;
    //   1270: invokestatic 292	com/tencent/mobileqq/msf/core/t:g	()Ljava/lang/String;
    //   1273: ldc_w 294
    //   1276: aload 14
    //   1278: aload_0
    //   1279: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1282: invokevirtual 296	com/tencent/mobileqq/msf/core/ag:e	()[B
    //   1285: aload 17
    //   1287: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1290: aload_0
    //   1291: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1294: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1297: invokevirtual 302	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1300: aload 17
    //   1302: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1305: iconst_0
    //   1306: iload_2
    //   1307: aload 13
    //   1309: aload 17
    //   1311: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1314: iconst_0
    //   1315: invokestatic 432	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[BZ)[B
    //   1318: astore 13
    //   1320: goto -695 -> 625
    //   1323: aload 17
    //   1325: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1328: invokestatic 288	com/tencent/mobileqq/msf/core/t:d	()Ljava/lang/String;
    //   1331: invokestatic 290	com/tencent/mobileqq/msf/core/t:f	()Ljava/lang/String;
    //   1334: invokestatic 292	com/tencent/mobileqq/msf/core/t:g	()Ljava/lang/String;
    //   1337: ldc_w 294
    //   1340: aload 14
    //   1342: aload_0
    //   1343: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1346: invokevirtual 296	com/tencent/mobileqq/msf/core/ag:e	()[B
    //   1349: aload 17
    //   1351: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1354: aload_0
    //   1355: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1358: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1361: invokevirtual 302	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1364: aload 17
    //   1366: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1369: iconst_0
    //   1370: iload_2
    //   1371: iload_1
    //   1372: aload 13
    //   1374: aload 17
    //   1376: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1379: iconst_0
    //   1380: invokestatic 435	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[BZ)[B
    //   1383: astore 13
    //   1385: goto -760 -> 625
    //   1388: iconst_0
    //   1389: newarray byte
    //   1391: astore 16
    //   1393: goto -677 -> 716
    //   1396: aload 17
    //   1398: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1401: ldc_w 437
    //   1404: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1407: ifne +1376 -> 2783
    //   1410: aload 17
    //   1412: ldc_w 442
    //   1415: iconst_0
    //   1416: invokestatic 400	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1419: invokevirtual 105	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1422: checkcast 394	java/lang/Boolean
    //   1425: invokevirtual 397	java/lang/Boolean:booleanValue	()Z
    //   1428: ifne +1355 -> 2783
    //   1431: aload 17
    //   1433: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1436: iconst_m1
    //   1437: if_icmpeq +1346 -> 2783
    //   1440: aload 17
    //   1442: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1445: bipush 100
    //   1447: if_icmpeq +1336 -> 2783
    //   1450: aload_0
    //   1451: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1454: aload 17
    //   1456: invokestatic 445	com/tencent/mobileqq/msf/core/ag:b	(Lcom/tencent/mobileqq/msf/core/ag;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1459: goto +1324 -> 2783
    //   1462: iload 11
    //   1464: ifne -575 -> 889
    //   1467: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   1470: lstore 9
    //   1472: lload 9
    //   1474: lload 7
    //   1476: lsub
    //   1477: aload 17
    //   1479: invokevirtual 448	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   1482: lcmp
    //   1483: ifle +39 -> 1522
    //   1486: invokestatic 451	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: ifeq -600 -> 889
    //   1492: ldc 155
    //   1494: iconst_2
    //   1495: new 76	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1502: aload 17
    //   1504: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1507: ldc_w 453
    //   1510: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1519: goto -630 -> 889
    //   1522: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1525: lconst_0
    //   1526: lcmp
    //   1527: ifeq +114 -> 1641
    //   1530: lload 9
    //   1532: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1535: lsub
    //   1536: invokestatic 459	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1539: i2l
    //   1540: lcmp
    //   1541: ifle +100 -> 1641
    //   1544: aload_0
    //   1545: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1548: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1551: invokevirtual 221	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1554: ifeq +87 -> 1641
    //   1557: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1560: aload_0
    //   1561: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1564: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1567: invokevirtual 239	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1570: invokevirtual 461	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1573: lcmp
    //   1574: iflt +525 -> 2099
    //   1577: lconst_0
    //   1578: putstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1581: invokestatic 451	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1584: ifeq +47 -> 1631
    //   1587: ldc 155
    //   1589: iconst_2
    //   1590: new 76	java/lang/StringBuilder
    //   1593: dup
    //   1594: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1597: ldc_w 463
    //   1600: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   1606: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1609: lsub
    //   1610: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1613: ldc_w 468
    //   1616: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: invokestatic 459	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1622: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1631: aload_0
    //   1632: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1635: getstatic 470	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
    //   1638: invokevirtual 471	com/tencent/mobileqq/msf/core/ag:a	(Lcom/tencent/qphone/base/a;)V
    //   1641: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1644: lconst_0
    //   1645: lcmp
    //   1646: ifeq +85 -> 1731
    //   1649: lload 9
    //   1651: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1654: lsub
    //   1655: ldc2_w 472
    //   1658: lcmp
    //   1659: ifle +72 -> 1731
    //   1662: aload_0
    //   1663: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1666: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1669: invokevirtual 221	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1672: ifeq +59 -> 1731
    //   1675: getstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   1678: aload_0
    //   1679: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1682: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1685: invokevirtual 239	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1688: invokevirtual 461	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1691: lcmp
    //   1692: iflt +39 -> 1731
    //   1695: aload_0
    //   1696: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1699: getfield 477	com/tencent/mobileqq/msf/core/ag:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1702: invokevirtual 482	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1705: ifne +26 -> 1731
    //   1708: invokestatic 451	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1711: ifeq +12 -> 1723
    //   1714: ldc 155
    //   1716: iconst_2
    //   1717: ldc_w 484
    //   1720: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1723: aload_0
    //   1724: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1727: iconst_0
    //   1728: invokestatic 487	com/tencent/mobileqq/msf/core/ag:b	(Lcom/tencent/mobileqq/msf/core/ag;Z)V
    //   1731: iload 11
    //   1733: istore 12
    //   1735: aload 17
    //   1737: ldc_w 489
    //   1740: invokestatic 494	android/os/SystemClock:elapsedRealtime	()J
    //   1743: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1746: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1749: pop
    //   1750: iload 11
    //   1752: istore 12
    //   1754: aload 17
    //   1756: ldc_w 497
    //   1759: lconst_0
    //   1760: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1763: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1766: pop
    //   1767: iload 11
    //   1769: istore 12
    //   1771: aload 17
    //   1773: ldc_w 499
    //   1776: getstatic 503	com/tencent/mobileqq/msf/core/ag:E	Ljava/lang/String;
    //   1779: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1782: pop
    //   1783: iload 11
    //   1785: istore 12
    //   1787: aload 17
    //   1789: ldc_w 505
    //   1792: getstatic 508	com/tencent/mobileqq/msf/core/ag:F	Ljava/lang/String;
    //   1795: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1798: pop
    //   1799: iload 11
    //   1801: istore 12
    //   1803: aload 17
    //   1805: ldc_w 510
    //   1808: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   1811: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1814: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1817: pop
    //   1818: iload 11
    //   1820: istore 12
    //   1822: aload 17
    //   1824: ldc_w 512
    //   1827: aload_0
    //   1828: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1831: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1834: invokevirtual 239	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1837: invokevirtual 461	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1840: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1843: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1846: pop
    //   1847: iload 11
    //   1849: istore 12
    //   1851: aload 17
    //   1853: ldc_w 514
    //   1856: invokestatic 517	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   1859: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1862: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1865: pop
    //   1866: iload 11
    //   1868: istore 12
    //   1870: aload 17
    //   1872: ldc_w 519
    //   1875: aload_0
    //   1876: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1879: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1882: invokevirtual 221	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1885: invokestatic 400	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1888: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1891: pop
    //   1892: iload 11
    //   1894: istore 12
    //   1896: aload_0
    //   1897: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1900: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   1903: invokestatic 522	com/tencent/mobileqq/msf/core/ag:a	(Lcom/tencent/mobileqq/msf/core/ag;J)J
    //   1906: pop2
    //   1907: iload 11
    //   1909: istore 12
    //   1911: aload_0
    //   1912: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1915: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1918: aload 17
    //   1920: invokevirtual 299	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1923: aload 17
    //   1925: invokevirtual 525	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   1928: aload 14
    //   1930: aload 15
    //   1932: aload 17
    //   1934: invokevirtual 358	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1937: aload 17
    //   1939: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1942: aload 17
    //   1944: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1947: aload 16
    //   1949: aload 17
    //   1951: invokevirtual 528	com/tencent/mobileqq/msf/core/net/n:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1954: istore 11
    //   1956: iload 11
    //   1958: istore 12
    //   1960: aload_0
    //   1961: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   1964: invokestatic 531	android/os/SystemClock:uptimeMillis	()J
    //   1967: invokestatic 533	com/tencent/mobileqq/msf/core/ag:b	(Lcom/tencent/mobileqq/msf/core/ag;J)J
    //   1970: pop2
    //   1971: iload 11
    //   1973: ifne +189 -> 2162
    //   1976: aload 17
    //   1978: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1981: ldc_w 489
    //   1984: invokevirtual 534	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1987: pop
    //   1988: aload 17
    //   1990: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1993: ldc_w 497
    //   1996: invokevirtual 534	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1999: pop
    //   2000: aload 17
    //   2002: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2005: ldc_w 499
    //   2008: invokevirtual 534	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2011: pop
    //   2012: aload 17
    //   2014: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2017: ldc_w 505
    //   2020: invokevirtual 534	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2023: pop
    //   2024: aload 17
    //   2026: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2029: ldc_w 536
    //   2032: iconst_1
    //   2033: invokestatic 400	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2036: invokevirtual 260	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2039: pop
    //   2040: invokestatic 451	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2043: ifeq +34 -> 2077
    //   2046: ldc 155
    //   2048: iconst_2
    //   2049: new 76	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2056: invokestatic 373	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2059: invokevirtual 376	java/lang/Thread:getName	()Ljava/lang/String;
    //   2062: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: ldc_w 538
    //   2068: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2074: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2077: aload_0
    //   2078: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2081: getfield 216	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2084: getstatic 540	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
    //   2087: invokevirtual 421	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   2090: getstatic 545	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
    //   2093: invokestatic 427	java/lang/Thread:sleep	(J)V
    //   2096: goto -634 -> 1462
    //   2099: lconst_0
    //   2100: putstatic 456	com/tencent/mobileqq/msf/core/ag:U	J
    //   2103: goto -462 -> 1641
    //   2106: astore 13
    //   2108: ldc 155
    //   2110: iconst_1
    //   2111: new 76	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2118: ldc_w 547
    //   2121: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: aload 13
    //   2126: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2129: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2132: aload 13
    //   2134: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2137: iload 12
    //   2139: istore 11
    //   2141: goto -170 -> 1971
    //   2144: astore 13
    //   2146: ldc 155
    //   2148: iconst_1
    //   2149: aload 13
    //   2151: invokevirtual 548	java/lang/Exception:toString	()Ljava/lang/String;
    //   2154: aload 13
    //   2156: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2159: goto -697 -> 1462
    //   2162: aload 17
    //   2164: ldc_w 497
    //   2167: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   2170: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2173: invokevirtual 495	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2176: pop
    //   2177: iconst_0
    //   2178: istore_3
    //   2179: iconst_0
    //   2180: istore 4
    //   2182: iconst_0
    //   2183: istore 5
    //   2185: ldc_w 550
    //   2188: aload 14
    //   2190: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2193: istore 12
    //   2195: iload 12
    //   2197: ifeq +478 -> 2675
    //   2200: iload 4
    //   2202: istore_3
    //   2203: aload 17
    //   2205: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2208: ldc_w 552
    //   2211: invokevirtual 554	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2214: checkcast 314	java/lang/Integer
    //   2217: invokevirtual 557	java/lang/Integer:intValue	()I
    //   2220: istore 4
    //   2222: iload 4
    //   2224: istore_3
    //   2225: aload 17
    //   2227: invokevirtual 310	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2230: ldc_w 559
    //   2233: invokevirtual 554	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2236: checkcast 314	java/lang/Integer
    //   2239: invokevirtual 557	java/lang/Integer:intValue	()I
    //   2242: istore 6
    //   2244: iload 6
    //   2246: istore_3
    //   2247: iload_3
    //   2248: istore 5
    //   2250: ldc_w 550
    //   2253: aload 14
    //   2255: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2258: ifne +17 -> 2275
    //   2261: iload_3
    //   2262: istore 5
    //   2264: aload 17
    //   2266: invokevirtual 562	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
    //   2269: ifne +6 -> 2275
    //   2272: iconst_1
    //   2273: istore 5
    //   2275: aload 14
    //   2277: aload 17
    //   2279: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2282: aload 16
    //   2284: arraylength
    //   2285: i2l
    //   2286: iload 4
    //   2288: iload 5
    //   2290: invokestatic 567	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
    //   2293: aload 17
    //   2295: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2298: ifnull +279 -> 2577
    //   2301: aload 17
    //   2303: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2306: invokevirtual 80	java/lang/String:length	()I
    //   2309: iconst_4
    //   2310: if_icmple +267 -> 2577
    //   2313: aload 17
    //   2315: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2318: ldc_w 569
    //   2321: invokevirtual 573	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2324: ifne +253 -> 2577
    //   2327: aload 17
    //   2329: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2332: ldc_w 575
    //   2335: invokevirtual 573	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2338: ifne +239 -> 2577
    //   2341: aload 17
    //   2343: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2346: ldc_w 577
    //   2349: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2352: ifne +225 -> 2577
    //   2355: aload 17
    //   2357: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2360: ldc_w 579
    //   2363: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2366: ifne +211 -> 2577
    //   2369: aload 17
    //   2371: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2374: ldc_w 581
    //   2377: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2380: ifne +197 -> 2577
    //   2383: aload 17
    //   2385: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2388: ldc_w 583
    //   2391: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2394: ifne +183 -> 2577
    //   2397: aload 17
    //   2399: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2402: ldc_w 585
    //   2405: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2408: ifne +169 -> 2577
    //   2411: aload 17
    //   2413: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2416: ldc_w 587
    //   2419: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2422: ifne +155 -> 2577
    //   2425: aload 17
    //   2427: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2430: ldc_w 589
    //   2433: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2436: ifne +141 -> 2577
    //   2439: aload 17
    //   2441: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2444: ldc_w 591
    //   2447: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2450: ifne +127 -> 2577
    //   2453: getstatic 595	com/tencent/mobileqq/msf/core/ag:af	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   2456: aload 17
    //   2458: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2461: invokevirtual 598	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
    //   2464: ifne +113 -> 2577
    //   2467: getstatic 601	com/tencent/mobileqq/msf/core/ag:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2470: aload 17
    //   2472: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2475: invokevirtual 602	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2478: ifnonnull +26 -> 2504
    //   2481: new 604	java/util/concurrent/ConcurrentLinkedQueue
    //   2484: dup
    //   2485: invokespecial 605	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
    //   2488: astore 13
    //   2490: getstatic 601	com/tencent/mobileqq/msf/core/ag:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2493: aload 17
    //   2495: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2498: aload 13
    //   2500: invokevirtual 606	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2503: pop
    //   2504: getstatic 601	com/tencent/mobileqq/msf/core/ag:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2507: aload 17
    //   2509: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2512: invokevirtual 602	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2515: checkcast 604	java/util/concurrent/ConcurrentLinkedQueue
    //   2518: aload 17
    //   2520: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2523: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2526: invokevirtual 609	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
    //   2529: pop
    //   2530: ldc 155
    //   2532: iconst_1
    //   2533: new 76	java/lang/StringBuilder
    //   2536: dup
    //   2537: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2540: ldc_w 611
    //   2543: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: aload 17
    //   2548: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2551: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2554: ldc_w 613
    //   2557: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2560: aload 17
    //   2562: invokevirtual 180	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2565: invokestatic 208	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2568: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2574: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2577: aload 17
    //   2579: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2582: ldc_w 615
    //   2585: invokevirtual 573	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2588: ifeq +9 -> 2597
    //   2591: invokestatic 494	android/os/SystemClock:elapsedRealtime	()J
    //   2594: putstatic 617	com/tencent/mobileqq/msf/core/ag:J	J
    //   2597: aload_0
    //   2598: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2601: getfield 620	com/tencent/mobileqq/msf/core/ag:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2604: invokevirtual 482	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2607: ifeq +182 -> 2789
    //   2610: aload_0
    //   2611: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2614: getfield 623	com/tencent/mobileqq/msf/core/ag:aa	I
    //   2617: iconst_m1
    //   2618: if_icmpne +171 -> 2789
    //   2621: aload_0
    //   2622: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2625: aload 17
    //   2627: invokevirtual 25	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2630: putfield 623	com/tencent/mobileqq/msf/core/ag:aa	I
    //   2633: ldc 155
    //   2635: iconst_1
    //   2636: new 76	java/lang/StringBuilder
    //   2639: dup
    //   2640: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2643: ldc_w 625
    //   2646: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: aload_0
    //   2650: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2653: getfield 623	com/tencent/mobileqq/msf/core/ag:aa	I
    //   2656: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2659: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2662: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2665: goto +124 -> 2789
    //   2668: astore 13
    //   2670: aload 13
    //   2672: invokevirtual 628	java/lang/Exception:printStackTrace	()V
    //   2675: iload_3
    //   2676: istore 4
    //   2678: iload 5
    //   2680: istore_3
    //   2681: goto -434 -> 2247
    //   2684: astore 13
    //   2686: ldc 155
    //   2688: iconst_1
    //   2689: new 76	java/lang/StringBuilder
    //   2692: dup
    //   2693: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2696: ldc_w 630
    //   2699: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2702: aload 13
    //   2704: invokevirtual 548	java/lang/Exception:toString	()Ljava/lang/String;
    //   2707: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2713: invokestatic 632	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2716: goto -1639 -> 1077
    //   2719: astore 13
    //   2721: ldc 155
    //   2723: iconst_1
    //   2724: aload 13
    //   2726: invokevirtual 342	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2729: aload 13
    //   2731: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2734: aload_0
    //   2735: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2738: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2741: ifnull -2741 -> 0
    //   2744: aload_0
    //   2745: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2748: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2751: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2754: ifnull -2754 -> 0
    //   2757: aload_0
    //   2758: getfield 12	com/tencent/mobileqq/msf/core/ag$c:b	Lcom/tencent/mobileqq/msf/core/ag;
    //   2761: getfield 50	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2764: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2767: iconst_1
    //   2768: invokeinterface 336 2 0
    //   2773: pop
    //   2774: goto -2774 -> 0
    //   2777: aconst_null
    //   2778: astore 15
    //   2780: goto -2658 -> 122
    //   2783: iconst_0
    //   2784: istore 11
    //   2786: goto -1324 -> 1462
    //   2789: goto -1327 -> 1462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2792	0	this	c
    //   253	1119	1	b1	byte
    //   174	1197	2	i	int
    //   74	2607	3	j	int
    //   2180	497	4	k	int
    //   2183	496	5	m	int
    //   2242	3	6	n	int
    //   139	1336	7	l1	long
    //   144	1506	9	l2	long
    //   997	1788	11	bool1	boolean
    //   1733	463	12	bool2	boolean
    //   433	280	13	arrayOfByte1	byte[]
    //   807	19	13	localException1	java.lang.Exception
    //   839	22	13	localThrowable1	java.lang.Throwable
    //   894	166	13	localObject1	java.lang.Object
    //   1196	112	13	arrayOfByte2	byte[]
    //   1318	66	13	arrayOfByte3	byte[]
    //   2106	27	13	localThrowable2	java.lang.Throwable
    //   2144	11	13	localException2	java.lang.Exception
    //   2488	11	13	localConcurrentLinkedQueue	java.util.concurrent.ConcurrentLinkedQueue
    //   2668	3	13	localException3	java.lang.Exception
    //   2684	19	13	localException4	java.lang.Exception
    //   2719	11	13	localThrowable3	java.lang.Throwable
    //   65	2211	14	localObject2	java.lang.Object
    //   111	2668	15	str	String
    //   450	267	16	localObject3	java.lang.Object
    //   1180	9	16	localException5	java.lang.Exception
    //   1391	892	16	arrayOfByte4	byte[]
    //   13	2613	17	localToServiceMsg	ToServiceMsg
    // Exception table:
    //   from	to	target	type
    //   208	215	807	java/lang/Exception
    //   60	75	839	java/lang/Throwable
    //   80	122	839	java/lang/Throwable
    //   122	175	839	java/lang/Throwable
    //   179	202	839	java/lang/Throwable
    //   202	208	839	java/lang/Throwable
    //   208	215	839	java/lang/Throwable
    //   215	237	839	java/lang/Throwable
    //   237	249	839	java/lang/Throwable
    //   254	343	839	java/lang/Throwable
    //   343	367	839	java/lang/Throwable
    //   367	394	839	java/lang/Throwable
    //   394	427	839	java/lang/Throwable
    //   427	435	839	java/lang/Throwable
    //   435	502	839	java/lang/Throwable
    //   502	552	839	java/lang/Throwable
    //   552	557	839	java/lang/Throwable
    //   557	625	839	java/lang/Throwable
    //   630	648	839	java/lang/Throwable
    //   648	678	839	java/lang/Throwable
    //   691	712	839	java/lang/Throwable
    //   721	764	839	java/lang/Throwable
    //   809	836	839	java/lang/Throwable
    //   1182	1193	839	java/lang/Throwable
    //   1241	1259	839	java/lang/Throwable
    //   1259	1320	839	java/lang/Throwable
    //   1323	1385	839	java/lang/Throwable
    //   1388	1393	839	java/lang/Throwable
    //   1396	1459	839	java/lang/Throwable
    //   1467	1519	839	java/lang/Throwable
    //   1522	1631	839	java/lang/Throwable
    //   1631	1641	839	java/lang/Throwable
    //   1641	1723	839	java/lang/Throwable
    //   1723	1731	839	java/lang/Throwable
    //   1976	2077	839	java/lang/Throwable
    //   2077	2090	839	java/lang/Throwable
    //   2090	2096	839	java/lang/Throwable
    //   2099	2103	839	java/lang/Throwable
    //   2108	2137	839	java/lang/Throwable
    //   2146	2159	839	java/lang/Throwable
    //   2162	2177	839	java/lang/Throwable
    //   2185	2195	839	java/lang/Throwable
    //   2203	2222	839	java/lang/Throwable
    //   2225	2244	839	java/lang/Throwable
    //   2250	2261	839	java/lang/Throwable
    //   2264	2272	839	java/lang/Throwable
    //   2275	2504	839	java/lang/Throwable
    //   2504	2577	839	java/lang/Throwable
    //   2577	2597	839	java/lang/Throwable
    //   2597	2665	839	java/lang/Throwable
    //   2670	2675	839	java/lang/Throwable
    //   435	502	1180	java/lang/Exception
    //   502	552	1180	java/lang/Exception
    //   552	557	1180	java/lang/Exception
    //   0	55	1196	finally
    //   60	75	1196	finally
    //   80	122	1196	finally
    //   122	175	1196	finally
    //   179	202	1196	finally
    //   202	208	1196	finally
    //   208	215	1196	finally
    //   215	237	1196	finally
    //   237	249	1196	finally
    //   254	343	1196	finally
    //   343	367	1196	finally
    //   367	394	1196	finally
    //   394	427	1196	finally
    //   427	435	1196	finally
    //   435	502	1196	finally
    //   502	552	1196	finally
    //   552	557	1196	finally
    //   557	625	1196	finally
    //   630	648	1196	finally
    //   648	678	1196	finally
    //   691	712	1196	finally
    //   721	764	1196	finally
    //   809	836	1196	finally
    //   841	889	1196	finally
    //   889	901	1196	finally
    //   908	996	1196	finally
    //   999	1029	1196	finally
    //   1029	1077	1196	finally
    //   1077	1117	1196	finally
    //   1117	1123	1196	finally
    //   1182	1193	1196	finally
    //   1241	1259	1196	finally
    //   1259	1320	1196	finally
    //   1323	1385	1196	finally
    //   1388	1393	1196	finally
    //   1396	1459	1196	finally
    //   1467	1519	1196	finally
    //   1522	1631	1196	finally
    //   1631	1641	1196	finally
    //   1641	1723	1196	finally
    //   1723	1731	1196	finally
    //   1735	1750	1196	finally
    //   1754	1767	1196	finally
    //   1771	1783	1196	finally
    //   1787	1799	1196	finally
    //   1803	1818	1196	finally
    //   1822	1847	1196	finally
    //   1851	1866	1196	finally
    //   1870	1892	1196	finally
    //   1896	1907	1196	finally
    //   1911	1956	1196	finally
    //   1960	1971	1196	finally
    //   1976	2077	1196	finally
    //   2077	2090	1196	finally
    //   2090	2096	1196	finally
    //   2099	2103	1196	finally
    //   2108	2137	1196	finally
    //   2146	2159	1196	finally
    //   2162	2177	1196	finally
    //   2185	2195	1196	finally
    //   2203	2222	1196	finally
    //   2225	2244	1196	finally
    //   2250	2261	1196	finally
    //   2264	2272	1196	finally
    //   2275	2504	1196	finally
    //   2504	2577	1196	finally
    //   2577	2597	1196	finally
    //   2597	2665	1196	finally
    //   2670	2675	1196	finally
    //   2686	2716	1196	finally
    //   2721	2734	1196	finally
    //   1735	1750	2106	java/lang/Throwable
    //   1754	1767	2106	java/lang/Throwable
    //   1771	1783	2106	java/lang/Throwable
    //   1787	1799	2106	java/lang/Throwable
    //   1803	1818	2106	java/lang/Throwable
    //   1822	1847	2106	java/lang/Throwable
    //   1851	1866	2106	java/lang/Throwable
    //   1870	1892	2106	java/lang/Throwable
    //   1896	1907	2106	java/lang/Throwable
    //   1911	1956	2106	java/lang/Throwable
    //   1960	1971	2106	java/lang/Throwable
    //   2090	2096	2144	java/lang/Exception
    //   2203	2222	2668	java/lang/Exception
    //   2225	2244	2668	java/lang/Exception
    //   908	996	2684	java/lang/Exception
    //   999	1029	2684	java/lang/Exception
    //   1029	1077	2684	java/lang/Exception
    //   0	55	2719	java/lang/Throwable
    //   841	889	2719	java/lang/Throwable
    //   889	901	2719	java/lang/Throwable
    //   908	996	2719	java/lang/Throwable
    //   999	1029	2719	java/lang/Throwable
    //   1029	1077	2719	java/lang/Throwable
    //   1077	1117	2719	java/lang/Throwable
    //   1117	1123	2719	java/lang/Throwable
    //   2686	2716	2719	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag.c
 * JD-Core Version:    0.7.0.1
 */