package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.c.a;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class aj$c
  extends Thread
{
  long a = 0L;
  
  aj$c(aj paramaj) {}
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if ((!q.a().d()) || (!this.b.b.b()) || (this.b.D.quicksender == null) || (this.b.D.getDeepSleepDetector() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "sendQuiHeartbeatWhenWakeFromDs, isConned = " + this.b.b.b() + ", than return.");
      }
    }
    do
    {
      return;
      if (this.b.D.quicksender.b(2000L))
      {
        a(paramToServiceMsg, 1);
        return;
      }
    } while (!this.b.D.getDeepSleepDetector().b());
    a(paramToServiceMsg, 2);
    this.b.D.quicksender.d();
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (!paramToServiceMsg.isSupportRetry())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "sendQuiHeartbeatWhenWakeFromDs#setRetry, goCase = " + paramInt);
      }
      paramToServiceMsg.setIsSupportRetry(true);
      if (this.b.D.getStatReporter() != null) {
        this.b.D.getStatReporter().m();
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
  {
    this.b.c(paramToServiceMsg.getRequestSsoSeq());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   4: getfield 135	com/tencent/mobileqq/msf/core/aj:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   7: invokevirtual 141	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
    //   10: checkcast 96	com/tencent/qphone/base/remote/ToServiceMsg
    //   13: astore 17
    //   15: aload_0
    //   16: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   19: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   22: ifnull +33 -> 55
    //   25: aload_0
    //   26: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   29: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   32: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   35: ifnull +20 -> 55
    //   38: aload_0
    //   39: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   42: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   45: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   48: iconst_1
    //   49: invokeinterface 151 2 0
    //   54: pop
    //   55: aload 17
    //   57: ifnull +1023 -> 1080
    //   60: aload 17
    //   62: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   65: astore 14
    //   67: aload 14
    //   69: ldc 156
    //   71: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_m1
    //   77: if_icmpeq +2709 -> 2786
    //   80: new 60	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   87: aload 14
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: aload 14
    //   94: invokevirtual 165	java/lang/String:length	()I
    //   97: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 171
    //   105: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 15
    //   113: aload 14
    //   115: iconst_0
    //   116: iload_3
    //   117: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
    //   120: astore 14
    //   122: aload 17
    //   124: ldc 173
    //   126: lconst_0
    //   127: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 175	java/lang/Long
    //   136: invokevirtual 187	java/lang/Long:longValue	()J
    //   139: lstore 7
    //   141: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   144: lstore 9
    //   146: aload_0
    //   147: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   150: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   153: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:configManager	Lcom/tencent/mobileqq/msf/core/a/a;
    //   156: aload 17
    //   158: lload 9
    //   160: invokevirtual 201	com/tencent/mobileqq/msf/core/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;J)V
    //   163: aload 17
    //   165: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   168: ifnull +1223 -> 1391
    //   171: invokestatic 210	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   174: istore_2
    //   175: iload_2
    //   176: ifne +39 -> 215
    //   179: aload_0
    //   180: getfield 17	com/tencent/mobileqq/msf/core/aj$c:a	J
    //   183: lconst_0
    //   184: lcmp
    //   185: ifeq +17 -> 202
    //   188: lload 9
    //   190: aload_0
    //   191: getfield 17	com/tencent/mobileqq/msf/core/aj$c:a	J
    //   194: lsub
    //   195: ldc2_w 211
    //   198: lcmp
    //   199: ifle +16 -> 215
    //   202: aload_0
    //   203: lload 9
    //   205: putfield 17	com/tencent/mobileqq/msf/core/aj$c:a	J
    //   208: invokestatic 218	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   211: iconst_1
    //   212: invokestatic 224	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
    //   215: iload_2
    //   216: getstatic 228	com/tencent/mobileqq/msf/core/aj:M	I
    //   219: if_icmpeq +18 -> 237
    //   222: iload_2
    //   223: putstatic 228	com/tencent/mobileqq/msf/core/aj:M	I
    //   226: invokestatic 231	com/tencent/mobileqq/msf/core/aj:h	()V
    //   229: ldc 58
    //   231: iconst_1
    //   232: ldc 233
    //   234: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iconst_0
    //   238: invokestatic 237	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   241: i2b
    //   242: istore_3
    //   243: getstatic 241	com/tencent/mobileqq/msf/core/aj:P	Z
    //   246: ifeq +923 -> 1169
    //   249: iload_3
    //   250: iconst_4
    //   251: ior
    //   252: i2b
    //   253: istore_1
    //   254: getstatic 247	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   257: aload 17
    //   259: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   262: invokevirtual 256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   265: ifeq +80 -> 345
    //   268: aload_0
    //   269: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   272: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   275: invokevirtual 260	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   278: aload 17
    //   280: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   283: invokevirtual 266	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
    //   286: getstatic 247	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   289: aload 17
    //   291: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   294: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: ldc 58
    //   300: iconst_1
    //   301: new 60	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 272
    //   311: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 17
    //   316: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   319: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 280
    //   328: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 17
    //   333: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   336: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_0
    //   346: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   349: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   352: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   355: ifne +15 -> 370
    //   358: invokestatic 231	com/tencent/mobileqq/msf/core/aj:h	()V
    //   361: ldc 58
    //   363: iconst_1
    //   364: ldc_w 282
    //   367: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   374: invokestatic 286	com/tencent/mobileqq/msf/core/aj:e	(Lcom/tencent/mobileqq/msf/core/aj;)Ljava/util/HashSet;
    //   377: aload 17
    //   379: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   382: invokevirtual 291	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   385: ifeq +12 -> 397
    //   388: aload 17
    //   390: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   393: iconst_0
    //   394: invokestatic 294	com/tencent/mobileqq/msf/core/aj:a	(Ljava/lang/String;Z)V
    //   397: aload_0
    //   398: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   401: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   404: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   407: invokevirtual 303	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   410: ifnull +768 -> 1178
    //   413: aload_0
    //   414: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   417: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   420: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   423: invokevirtual 303	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   426: invokevirtual 307	com/tencent/mobileqq/msf/core/d:d	()I
    //   429: istore_3
    //   430: aload 17
    //   432: iload_3
    //   433: invokestatic 310	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   436: astore 13
    //   438: aload 17
    //   440: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   443: ifnonnull +62 -> 505
    //   446: new 312	java/util/HashMap
    //   449: dup
    //   450: invokespecial 313	java/util/HashMap:<init>	()V
    //   453: astore 16
    //   455: aload 16
    //   457: ldc_w 315
    //   460: aload 17
    //   462: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   465: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: aload_0
    //   470: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   473: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   476: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   479: ifnull +26 -> 505
    //   482: aload_0
    //   483: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   486: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   489: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   492: ldc_w 321
    //   495: iconst_0
    //   496: lconst_0
    //   497: lconst_0
    //   498: aload 16
    //   500: iconst_0
    //   501: iconst_0
    //   502: invokevirtual 324	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   505: invokestatic 327	com/tencent/mobileqq/msf/core/aj:r	()Z
    //   508: ifne +52 -> 560
    //   511: invokestatic 332	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   514: sipush 780
    //   517: if_icmpeq +38 -> 555
    //   520: aload_0
    //   521: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   524: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   527: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   530: ifnull +25 -> 555
    //   533: aload_0
    //   534: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   537: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   540: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   543: ldc_w 334
    //   546: iconst_0
    //   547: lconst_0
    //   548: lconst_0
    //   549: aconst_null
    //   550: iconst_0
    //   551: iconst_0
    //   552: invokevirtual 324	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   555: iconst_1
    //   556: invokestatic 337	com/tencent/mobileqq/msf/core/aj:a	(Z)Z
    //   559: pop
    //   560: sipush 591
    //   563: invokestatic 332	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   566: if_icmpne +678 -> 1244
    //   569: aload 17
    //   571: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   574: invokestatic 341	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   577: invokestatic 343	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   580: invokestatic 345	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   583: ldc_w 347
    //   586: aload 14
    //   588: aload_0
    //   589: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   592: invokevirtual 349	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   595: aload 17
    //   597: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   600: aload_0
    //   601: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   604: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   607: invokevirtual 355	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   610: aload 17
    //   612: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   615: iconst_0
    //   616: iload_2
    //   617: aload 17
    //   619: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   622: iconst_0
    //   623: invokestatic 359	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   626: astore 13
    //   628: aload 13
    //   630: ifnull +21 -> 651
    //   633: aload 17
    //   635: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   638: ldc_w 365
    //   641: aload 13
    //   643: arraylength
    //   644: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: pop
    //   651: ldc 58
    //   653: iconst_1
    //   654: new 60	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 372
    //   664: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 17
    //   669: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   672: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aload 13
    //   683: astore 16
    //   685: aload 17
    //   687: ifnull +32 -> 719
    //   690: aload 13
    //   692: astore 16
    //   694: aload 17
    //   696: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   699: ifne +20 -> 719
    //   702: getstatic 375	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   705: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   708: iconst_1
    //   709: aload 17
    //   711: aconst_null
    //   712: invokevirtual 378	com/tencent/mobileqq/msf/core/c/k:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   715: aload 13
    //   717: astore 16
    //   719: aload 16
    //   721: ifnonnull +678 -> 1399
    //   724: ldc 58
    //   726: iconst_1
    //   727: new 60	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 380
    //   737: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 17
    //   742: invokevirtual 383	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
    //   745: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 386	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload_0
    //   755: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   758: aload 17
    //   760: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   763: invokevirtual 126	com/tencent/mobileqq/msf/core/aj:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   766: pop
    //   767: aload_0
    //   768: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   771: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   774: ifnull -774 -> 0
    //   777: aload_0
    //   778: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   781: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   784: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   787: ifnull -787 -> 0
    //   790: aload_0
    //   791: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   794: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   797: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   800: iconst_1
    //   801: invokeinterface 389 2 0
    //   806: pop
    //   807: goto -807 -> 0
    //   810: astore 13
    //   812: ldc 58
    //   814: iconst_1
    //   815: new 60	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   822: ldc_w 391
    //   825: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 13
    //   830: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   833: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: goto -624 -> 215
    //   842: astore 13
    //   844: ldc 58
    //   846: iconst_1
    //   847: aload 13
    //   849: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   852: aload 13
    //   854: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   857: aload_0
    //   858: aload 17
    //   860: ldc_w 400
    //   863: aload 13
    //   865: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   868: invokespecial 402	com/tencent/mobileqq/msf/core/aj$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   871: aload_0
    //   872: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   875: getfield 135	com/tencent/mobileqq/msf/core/aj:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   878: aload 17
    //   880: invokevirtual 404	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
    //   883: pop
    //   884: aload_0
    //   885: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   888: invokestatic 407	com/tencent/mobileqq/msf/core/aj:f	(Lcom/tencent/mobileqq/msf/core/aj;)J
    //   891: pop2
    //   892: aload 17
    //   894: invokevirtual 411	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   897: astore 13
    //   899: getstatic 417	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   902: astore 14
    //   904: aload 13
    //   906: aload 14
    //   908: if_acmpne +172 -> 1080
    //   911: aload 17
    //   913: aload 17
    //   915: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   918: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   921: checkcast 422	com/tencent/qphone/base/remote/FromServiceMsg
    //   924: astore 13
    //   926: ldc 58
    //   928: iconst_1
    //   929: new 60	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   936: invokestatic 426	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   939: invokevirtual 429	java/lang/Thread:getName	()Ljava/lang/String;
    //   942: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: ldc_w 431
    //   948: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload 13
    //   953: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   956: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   959: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: aload_0
    //   969: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   972: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   975: invokevirtual 260	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   978: aload 13
    //   980: invokevirtual 432	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   983: invokevirtual 435	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
    //   986: aload 13
    //   988: sipush 2012
    //   991: aload 13
    //   993: invokevirtual 438	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   996: invokevirtual 442	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   999: iconst_0
    //   1000: istore 11
    //   1002: aload 17
    //   1004: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1007: ldc_w 444
    //   1010: invokevirtual 445	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1013: ifeq +19 -> 1032
    //   1016: aload 17
    //   1018: ldc_w 444
    //   1021: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1024: checkcast 447	java/lang/Boolean
    //   1027: invokevirtual 450	java/lang/Boolean:booleanValue	()Z
    //   1030: istore 11
    //   1032: aload 13
    //   1034: ldc_w 444
    //   1037: iload 11
    //   1039: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1042: invokevirtual 456	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: pop
    //   1046: ldc_w 458
    //   1049: aload 13
    //   1051: invokestatic 462	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1054: aload_0
    //   1055: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1058: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1061: aconst_null
    //   1062: aload 13
    //   1064: invokevirtual 466	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1067: aload_0
    //   1068: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1071: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1074: getstatic 471	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
    //   1077: invokevirtual 474	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   1080: aload_0
    //   1081: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1084: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1087: ifnull +33 -> 1120
    //   1090: aload_0
    //   1091: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1094: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1097: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1100: ifnull +20 -> 1120
    //   1103: aload_0
    //   1104: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1107: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1110: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1113: iconst_1
    //   1114: invokeinterface 389 2 0
    //   1119: pop
    //   1120: ldc2_w 475
    //   1123: invokestatic 480	java/lang/Thread:sleep	(J)V
    //   1126: aload_0
    //   1127: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1130: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1133: ifnull -1133 -> 0
    //   1136: aload_0
    //   1137: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1140: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1143: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1146: ifnull -1146 -> 0
    //   1149: aload_0
    //   1150: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1153: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1156: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1159: iconst_1
    //   1160: invokeinterface 389 2 0
    //   1165: pop
    //   1166: goto -1166 -> 0
    //   1169: iload_3
    //   1170: bipush 251
    //   1172: iand
    //   1173: i2b
    //   1174: istore_1
    //   1175: goto -921 -> 254
    //   1178: iconst_1
    //   1179: istore_3
    //   1180: goto -750 -> 430
    //   1183: astore 16
    //   1185: ldc 58
    //   1187: iconst_1
    //   1188: ldc_w 482
    //   1191: aload 16
    //   1193: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1196: goto -636 -> 560
    //   1199: astore 13
    //   1201: aload_0
    //   1202: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1205: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1208: ifnull +33 -> 1241
    //   1211: aload_0
    //   1212: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1215: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1218: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1221: ifnull +20 -> 1241
    //   1224: aload_0
    //   1225: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1228: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1231: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1234: iconst_1
    //   1235: invokeinterface 389 2 0
    //   1240: pop
    //   1241: aload 13
    //   1243: athrow
    //   1244: sipush 595
    //   1247: invokestatic 332	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1250: if_icmpeq +12 -> 1262
    //   1253: sipush 600
    //   1256: invokestatic 332	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1259: if_icmpne +67 -> 1326
    //   1262: aload 17
    //   1264: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1267: invokestatic 341	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   1270: invokestatic 343	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   1273: invokestatic 345	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   1276: ldc_w 347
    //   1279: aload 14
    //   1281: aload_0
    //   1282: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1285: invokevirtual 349	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   1288: aload 17
    //   1290: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1293: aload_0
    //   1294: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1297: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1300: invokevirtual 355	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1303: aload 17
    //   1305: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1308: iconst_0
    //   1309: iload_2
    //   1310: aload 13
    //   1312: aload 17
    //   1314: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1317: iconst_0
    //   1318: invokestatic 485	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[BZ)[B
    //   1321: astore 13
    //   1323: goto -695 -> 628
    //   1326: aload 17
    //   1328: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1331: invokestatic 341	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   1334: invokestatic 343	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   1337: invokestatic 345	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   1340: ldc_w 347
    //   1343: aload 14
    //   1345: aload_0
    //   1346: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1349: invokevirtual 349	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   1352: aload 17
    //   1354: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1357: aload_0
    //   1358: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1361: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1364: invokevirtual 355	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1367: aload 17
    //   1369: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1372: iconst_0
    //   1373: iload_2
    //   1374: iload_1
    //   1375: aload 13
    //   1377: aload 17
    //   1379: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1382: iconst_0
    //   1383: invokestatic 488	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[BZ)[B
    //   1386: astore 13
    //   1388: goto -760 -> 628
    //   1391: iconst_0
    //   1392: newarray byte
    //   1394: astore 16
    //   1396: goto -677 -> 719
    //   1399: aload 17
    //   1401: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1404: ldc_w 490
    //   1407: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1410: ifne +1382 -> 2792
    //   1413: aload 17
    //   1415: ldc_w 495
    //   1418: iconst_0
    //   1419: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1422: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1425: checkcast 447	java/lang/Boolean
    //   1428: invokevirtual 450	java/lang/Boolean:booleanValue	()Z
    //   1431: ifne +1361 -> 2792
    //   1434: aload 17
    //   1436: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1439: iconst_m1
    //   1440: if_icmpeq +1352 -> 2792
    //   1443: aload 17
    //   1445: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1448: bipush 100
    //   1450: if_icmpeq +1342 -> 2792
    //   1453: aload_0
    //   1454: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1457: aload 17
    //   1459: invokestatic 498	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1462: goto +1330 -> 2792
    //   1465: iload 11
    //   1467: ifne -575 -> 892
    //   1470: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1473: lstore 9
    //   1475: lload 9
    //   1477: lload 7
    //   1479: lsub
    //   1480: aload 17
    //   1482: invokevirtual 501	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   1485: lcmp
    //   1486: ifle +39 -> 1525
    //   1489: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1492: ifeq -600 -> 892
    //   1495: ldc 58
    //   1497: iconst_2
    //   1498: new 60	java/lang/StringBuilder
    //   1501: dup
    //   1502: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1505: aload 17
    //   1507: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1510: ldc_w 503
    //   1513: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1519: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1522: goto -630 -> 892
    //   1525: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1528: lconst_0
    //   1529: lcmp
    //   1530: ifeq +114 -> 1644
    //   1533: lload 9
    //   1535: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1538: lsub
    //   1539: invokestatic 509	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1542: i2l
    //   1543: lcmp
    //   1544: ifle +100 -> 1644
    //   1547: aload_0
    //   1548: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1551: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1554: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1557: ifeq +87 -> 1644
    //   1560: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1563: aload_0
    //   1564: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1567: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1570: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1573: invokevirtual 511	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1576: lcmp
    //   1577: iflt +531 -> 2108
    //   1580: lconst_0
    //   1581: putstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1584: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1587: ifeq +47 -> 1634
    //   1590: ldc 58
    //   1592: iconst_2
    //   1593: new 60	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1600: ldc_w 513
    //   1603: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1609: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1612: lsub
    //   1613: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: ldc_w 518
    //   1619: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: invokestatic 509	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1625: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1628: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1634: aload_0
    //   1635: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1638: getstatic 520	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
    //   1641: invokevirtual 521	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/qphone/base/a;)V
    //   1644: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1647: lconst_0
    //   1648: lcmp
    //   1649: ifeq +85 -> 1734
    //   1652: lload 9
    //   1654: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1657: lsub
    //   1658: ldc2_w 522
    //   1661: lcmp
    //   1662: ifle +72 -> 1734
    //   1665: aload_0
    //   1666: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1669: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1672: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1675: ifeq +59 -> 1734
    //   1678: getstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   1681: aload_0
    //   1682: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1685: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1688: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1691: invokevirtual 511	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1694: lcmp
    //   1695: iflt +39 -> 1734
    //   1698: aload_0
    //   1699: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1702: getfield 527	com/tencent/mobileqq/msf/core/aj:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1705: invokevirtual 532	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1708: ifne +26 -> 1734
    //   1711: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1714: ifeq +12 -> 1726
    //   1717: ldc 58
    //   1719: iconst_2
    //   1720: ldc_w 534
    //   1723: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1726: aload_0
    //   1727: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1730: iconst_0
    //   1731: invokestatic 537	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;Z)V
    //   1734: aload_0
    //   1735: aload 17
    //   1737: invokespecial 539	com/tencent/mobileqq/msf/core/aj$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1740: iload 11
    //   1742: istore 12
    //   1744: aload 17
    //   1746: ldc_w 541
    //   1749: invokestatic 546	android/os/SystemClock:elapsedRealtime	()J
    //   1752: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1755: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: pop
    //   1759: iload 11
    //   1761: istore 12
    //   1763: aload 17
    //   1765: ldc_w 549
    //   1768: lconst_0
    //   1769: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1772: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1775: pop
    //   1776: iload 11
    //   1778: istore 12
    //   1780: aload 17
    //   1782: ldc_w 551
    //   1785: getstatic 555	com/tencent/mobileqq/msf/core/aj:E	Ljava/lang/String;
    //   1788: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1791: pop
    //   1792: iload 11
    //   1794: istore 12
    //   1796: aload 17
    //   1798: ldc_w 557
    //   1801: getstatic 560	com/tencent/mobileqq/msf/core/aj:F	Ljava/lang/String;
    //   1804: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1807: pop
    //   1808: iload 11
    //   1810: istore 12
    //   1812: aload 17
    //   1814: ldc_w 562
    //   1817: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1820: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1823: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1826: pop
    //   1827: iload 11
    //   1829: istore 12
    //   1831: aload 17
    //   1833: ldc_w 564
    //   1836: aload_0
    //   1837: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1840: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1843: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1846: invokevirtual 511	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1849: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1852: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1855: pop
    //   1856: iload 11
    //   1858: istore 12
    //   1860: aload 17
    //   1862: ldc_w 566
    //   1865: invokestatic 569	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   1868: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1871: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1874: pop
    //   1875: iload 11
    //   1877: istore 12
    //   1879: aload 17
    //   1881: ldc_w 571
    //   1884: aload_0
    //   1885: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1888: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1891: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1894: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1897: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1900: pop
    //   1901: iload 11
    //   1903: istore 12
    //   1905: aload_0
    //   1906: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1909: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1912: invokestatic 574	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/mobileqq/msf/core/aj;J)J
    //   1915: pop2
    //   1916: iload 11
    //   1918: istore 12
    //   1920: aload_0
    //   1921: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1924: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1927: aload 17
    //   1929: invokevirtual 352	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1932: aload 17
    //   1934: invokevirtual 577	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   1937: aload 14
    //   1939: aload 15
    //   1941: aload 17
    //   1943: invokevirtual 411	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1946: aload 17
    //   1948: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1951: aload 17
    //   1953: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1956: aload 16
    //   1958: aload 17
    //   1960: invokevirtual 580	com/tencent/mobileqq/msf/core/net/n:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1963: istore 11
    //   1965: iload 11
    //   1967: istore 12
    //   1969: aload_0
    //   1970: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1973: invokestatic 583	android/os/SystemClock:uptimeMillis	()J
    //   1976: invokestatic 585	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;J)J
    //   1979: pop2
    //   1980: iload 11
    //   1982: ifne +189 -> 2171
    //   1985: aload 17
    //   1987: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1990: ldc_w 541
    //   1993: invokevirtual 586	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1996: pop
    //   1997: aload 17
    //   1999: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2002: ldc_w 549
    //   2005: invokevirtual 586	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload 17
    //   2011: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2014: ldc_w 551
    //   2017: invokevirtual 586	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2020: pop
    //   2021: aload 17
    //   2023: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2026: ldc_w 557
    //   2029: invokevirtual 586	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2032: pop
    //   2033: aload 17
    //   2035: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2038: ldc_w 588
    //   2041: iconst_1
    //   2042: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2045: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2048: pop
    //   2049: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2052: ifeq +34 -> 2086
    //   2055: ldc 58
    //   2057: iconst_2
    //   2058: new 60	java/lang/StringBuilder
    //   2061: dup
    //   2062: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2065: invokestatic 426	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2068: invokevirtual 429	java/lang/Thread:getName	()Ljava/lang/String;
    //   2071: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2074: ldc_w 590
    //   2077: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2080: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2083: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2086: aload_0
    //   2087: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2090: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2093: getstatic 592	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
    //   2096: invokevirtual 474	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   2099: getstatic 597	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
    //   2102: invokestatic 480	java/lang/Thread:sleep	(J)V
    //   2105: goto -640 -> 1465
    //   2108: lconst_0
    //   2109: putstatic 506	com/tencent/mobileqq/msf/core/aj:U	J
    //   2112: goto -468 -> 1644
    //   2115: astore 13
    //   2117: ldc 58
    //   2119: iconst_1
    //   2120: new 60	java/lang/StringBuilder
    //   2123: dup
    //   2124: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2127: ldc_w 599
    //   2130: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: aload 13
    //   2135: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2138: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2141: aload 13
    //   2143: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2146: iload 12
    //   2148: istore 11
    //   2150: goto -170 -> 1980
    //   2153: astore 13
    //   2155: ldc 58
    //   2157: iconst_1
    //   2158: aload 13
    //   2160: invokevirtual 600	java/lang/Exception:toString	()Ljava/lang/String;
    //   2163: aload 13
    //   2165: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2168: goto -703 -> 1465
    //   2171: aload 17
    //   2173: ldc_w 549
    //   2176: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   2179: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2182: invokevirtual 547	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2185: pop
    //   2186: iconst_0
    //   2187: istore_3
    //   2188: iconst_0
    //   2189: istore 4
    //   2191: iconst_0
    //   2192: istore 5
    //   2194: ldc_w 602
    //   2197: aload 14
    //   2199: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2202: istore 12
    //   2204: iload 12
    //   2206: ifeq +478 -> 2684
    //   2209: iload 4
    //   2211: istore_3
    //   2212: aload 17
    //   2214: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2217: ldc_w 604
    //   2220: invokevirtual 606	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2223: checkcast 367	java/lang/Integer
    //   2226: invokevirtual 609	java/lang/Integer:intValue	()I
    //   2229: istore 4
    //   2231: iload 4
    //   2233: istore_3
    //   2234: aload 17
    //   2236: invokevirtual 363	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2239: ldc_w 611
    //   2242: invokevirtual 606	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2245: checkcast 367	java/lang/Integer
    //   2248: invokevirtual 609	java/lang/Integer:intValue	()I
    //   2251: istore 6
    //   2253: iload 6
    //   2255: istore_3
    //   2256: iload_3
    //   2257: istore 5
    //   2259: ldc_w 602
    //   2262: aload 14
    //   2264: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2267: ifne +17 -> 2284
    //   2270: iload_3
    //   2271: istore 5
    //   2273: aload 17
    //   2275: invokevirtual 614	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
    //   2278: ifne +6 -> 2284
    //   2281: iconst_1
    //   2282: istore 5
    //   2284: aload 14
    //   2286: aload 17
    //   2288: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2291: aload 16
    //   2293: arraylength
    //   2294: i2l
    //   2295: iload 4
    //   2297: iload 5
    //   2299: invokestatic 619	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
    //   2302: aload 17
    //   2304: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2307: ifnull +279 -> 2586
    //   2310: aload 17
    //   2312: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2315: invokevirtual 165	java/lang/String:length	()I
    //   2318: iconst_4
    //   2319: if_icmple +267 -> 2586
    //   2322: aload 17
    //   2324: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2327: ldc_w 621
    //   2330: invokevirtual 625	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2333: ifne +253 -> 2586
    //   2336: aload 17
    //   2338: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2341: ldc_w 627
    //   2344: invokevirtual 625	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2347: ifne +239 -> 2586
    //   2350: aload 17
    //   2352: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2355: ldc_w 629
    //   2358: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2361: ifne +225 -> 2586
    //   2364: aload 17
    //   2366: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2369: ldc_w 631
    //   2372: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2375: ifne +211 -> 2586
    //   2378: aload 17
    //   2380: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2383: ldc_w 633
    //   2386: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2389: ifne +197 -> 2586
    //   2392: aload 17
    //   2394: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2397: ldc_w 635
    //   2400: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2403: ifne +183 -> 2586
    //   2406: aload 17
    //   2408: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2411: ldc_w 637
    //   2414: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2417: ifne +169 -> 2586
    //   2420: aload 17
    //   2422: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2425: ldc_w 639
    //   2428: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2431: ifne +155 -> 2586
    //   2434: aload 17
    //   2436: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2439: ldc_w 641
    //   2442: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2445: ifne +141 -> 2586
    //   2448: aload 17
    //   2450: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2453: ldc_w 643
    //   2456: invokevirtual 493	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2459: ifne +127 -> 2586
    //   2462: getstatic 647	com/tencent/mobileqq/msf/core/aj:af	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   2465: aload 17
    //   2467: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2470: invokevirtual 650	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
    //   2473: ifne +113 -> 2586
    //   2476: getstatic 653	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2479: aload 17
    //   2481: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2484: invokevirtual 654	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2487: ifnonnull +26 -> 2513
    //   2490: new 656	java/util/concurrent/ConcurrentLinkedQueue
    //   2493: dup
    //   2494: invokespecial 657	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
    //   2497: astore 13
    //   2499: getstatic 653	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2502: aload 17
    //   2504: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2507: aload 13
    //   2509: invokevirtual 658	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2512: pop
    //   2513: getstatic 653	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2516: aload 17
    //   2518: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2521: invokevirtual 654	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2524: checkcast 656	java/util/concurrent/ConcurrentLinkedQueue
    //   2527: aload 17
    //   2529: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2532: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2535: invokevirtual 661	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
    //   2538: pop
    //   2539: ldc 58
    //   2541: iconst_1
    //   2542: new 60	java/lang/StringBuilder
    //   2545: dup
    //   2546: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2549: ldc_w 663
    //   2552: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: aload 17
    //   2557: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2560: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2563: ldc_w 665
    //   2566: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: aload 17
    //   2571: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2574: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2577: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2583: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2586: aload 17
    //   2588: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2591: ldc_w 667
    //   2594: invokevirtual 625	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2597: ifeq +9 -> 2606
    //   2600: invokestatic 546	android/os/SystemClock:elapsedRealtime	()J
    //   2603: putstatic 669	com/tencent/mobileqq/msf/core/aj:J	J
    //   2606: aload_0
    //   2607: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2610: getfield 672	com/tencent/mobileqq/msf/core/aj:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2613: invokevirtual 532	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2616: ifeq +182 -> 2798
    //   2619: aload_0
    //   2620: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2623: getfield 675	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2626: iconst_m1
    //   2627: if_icmpne +171 -> 2798
    //   2630: aload_0
    //   2631: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2634: aload 17
    //   2636: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2639: putfield 675	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2642: ldc 58
    //   2644: iconst_1
    //   2645: new 60	java/lang/StringBuilder
    //   2648: dup
    //   2649: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2652: ldc_w 677
    //   2655: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: aload_0
    //   2659: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2662: getfield 675	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2665: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2668: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2671: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2674: goto +124 -> 2798
    //   2677: astore 13
    //   2679: aload 13
    //   2681: invokevirtual 680	java/lang/Exception:printStackTrace	()V
    //   2684: iload_3
    //   2685: istore 4
    //   2687: iload 5
    //   2689: istore_3
    //   2690: goto -434 -> 2256
    //   2693: astore 13
    //   2695: ldc 58
    //   2697: iconst_1
    //   2698: new 60	java/lang/StringBuilder
    //   2701: dup
    //   2702: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2705: ldc_w 682
    //   2708: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2711: aload 13
    //   2713: invokevirtual 600	java/lang/Exception:toString	()Ljava/lang/String;
    //   2716: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2719: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2722: invokestatic 684	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2725: goto -1645 -> 1080
    //   2728: astore 13
    //   2730: ldc 58
    //   2732: iconst_1
    //   2733: aload 13
    //   2735: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2738: aload 13
    //   2740: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2743: aload_0
    //   2744: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2747: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2750: ifnull -2750 -> 0
    //   2753: aload_0
    //   2754: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2757: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2760: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2763: ifnull -2763 -> 0
    //   2766: aload_0
    //   2767: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2770: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2773: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2776: iconst_1
    //   2777: invokeinterface 389 2 0
    //   2782: pop
    //   2783: goto -2783 -> 0
    //   2786: aconst_null
    //   2787: astore 15
    //   2789: goto -2667 -> 122
    //   2792: iconst_0
    //   2793: istore 11
    //   2795: goto -1330 -> 1465
    //   2798: goto -1333 -> 1465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2801	0	this	c
    //   253	1122	1	b1	byte
    //   174	1200	2	i	int
    //   74	2616	3	j	int
    //   2189	497	4	k	int
    //   2192	496	5	m	int
    //   2251	3	6	n	int
    //   139	1339	7	l1	long
    //   144	1509	9	l2	long
    //   1000	1794	11	bool1	boolean
    //   1742	463	12	bool2	boolean
    //   436	280	13	arrayOfByte1	byte[]
    //   810	19	13	localException1	java.lang.Exception
    //   842	22	13	localThrowable1	java.lang.Throwable
    //   897	166	13	localObject1	java.lang.Object
    //   1199	112	13	arrayOfByte2	byte[]
    //   1321	66	13	arrayOfByte3	byte[]
    //   2115	27	13	localThrowable2	java.lang.Throwable
    //   2153	11	13	localException2	java.lang.Exception
    //   2497	11	13	localConcurrentLinkedQueue	java.util.concurrent.ConcurrentLinkedQueue
    //   2677	3	13	localException3	java.lang.Exception
    //   2693	19	13	localException4	java.lang.Exception
    //   2728	11	13	localThrowable3	java.lang.Throwable
    //   65	2220	14	localObject2	java.lang.Object
    //   111	2677	15	str	String
    //   453	267	16	localObject3	java.lang.Object
    //   1183	9	16	localException5	java.lang.Exception
    //   1394	898	16	arrayOfByte4	byte[]
    //   13	2622	17	localToServiceMsg	ToServiceMsg
    // Exception table:
    //   from	to	target	type
    //   208	215	810	java/lang/Exception
    //   60	75	842	java/lang/Throwable
    //   80	122	842	java/lang/Throwable
    //   122	175	842	java/lang/Throwable
    //   179	202	842	java/lang/Throwable
    //   202	208	842	java/lang/Throwable
    //   208	215	842	java/lang/Throwable
    //   215	237	842	java/lang/Throwable
    //   237	249	842	java/lang/Throwable
    //   254	345	842	java/lang/Throwable
    //   345	370	842	java/lang/Throwable
    //   370	397	842	java/lang/Throwable
    //   397	430	842	java/lang/Throwable
    //   430	438	842	java/lang/Throwable
    //   438	505	842	java/lang/Throwable
    //   505	555	842	java/lang/Throwable
    //   555	560	842	java/lang/Throwable
    //   560	628	842	java/lang/Throwable
    //   633	651	842	java/lang/Throwable
    //   651	681	842	java/lang/Throwable
    //   694	715	842	java/lang/Throwable
    //   724	767	842	java/lang/Throwable
    //   812	839	842	java/lang/Throwable
    //   1185	1196	842	java/lang/Throwable
    //   1244	1262	842	java/lang/Throwable
    //   1262	1323	842	java/lang/Throwable
    //   1326	1388	842	java/lang/Throwable
    //   1391	1396	842	java/lang/Throwable
    //   1399	1462	842	java/lang/Throwable
    //   1470	1522	842	java/lang/Throwable
    //   1525	1634	842	java/lang/Throwable
    //   1634	1644	842	java/lang/Throwable
    //   1644	1726	842	java/lang/Throwable
    //   1726	1734	842	java/lang/Throwable
    //   1734	1740	842	java/lang/Throwable
    //   1985	2086	842	java/lang/Throwable
    //   2086	2099	842	java/lang/Throwable
    //   2099	2105	842	java/lang/Throwable
    //   2108	2112	842	java/lang/Throwable
    //   2117	2146	842	java/lang/Throwable
    //   2155	2168	842	java/lang/Throwable
    //   2171	2186	842	java/lang/Throwable
    //   2194	2204	842	java/lang/Throwable
    //   2212	2231	842	java/lang/Throwable
    //   2234	2253	842	java/lang/Throwable
    //   2259	2270	842	java/lang/Throwable
    //   2273	2281	842	java/lang/Throwable
    //   2284	2513	842	java/lang/Throwable
    //   2513	2586	842	java/lang/Throwable
    //   2586	2606	842	java/lang/Throwable
    //   2606	2674	842	java/lang/Throwable
    //   2679	2684	842	java/lang/Throwable
    //   438	505	1183	java/lang/Exception
    //   505	555	1183	java/lang/Exception
    //   555	560	1183	java/lang/Exception
    //   0	55	1199	finally
    //   60	75	1199	finally
    //   80	122	1199	finally
    //   122	175	1199	finally
    //   179	202	1199	finally
    //   202	208	1199	finally
    //   208	215	1199	finally
    //   215	237	1199	finally
    //   237	249	1199	finally
    //   254	345	1199	finally
    //   345	370	1199	finally
    //   370	397	1199	finally
    //   397	430	1199	finally
    //   430	438	1199	finally
    //   438	505	1199	finally
    //   505	555	1199	finally
    //   555	560	1199	finally
    //   560	628	1199	finally
    //   633	651	1199	finally
    //   651	681	1199	finally
    //   694	715	1199	finally
    //   724	767	1199	finally
    //   812	839	1199	finally
    //   844	892	1199	finally
    //   892	904	1199	finally
    //   911	999	1199	finally
    //   1002	1032	1199	finally
    //   1032	1080	1199	finally
    //   1080	1120	1199	finally
    //   1120	1126	1199	finally
    //   1185	1196	1199	finally
    //   1244	1262	1199	finally
    //   1262	1323	1199	finally
    //   1326	1388	1199	finally
    //   1391	1396	1199	finally
    //   1399	1462	1199	finally
    //   1470	1522	1199	finally
    //   1525	1634	1199	finally
    //   1634	1644	1199	finally
    //   1644	1726	1199	finally
    //   1726	1734	1199	finally
    //   1734	1740	1199	finally
    //   1744	1759	1199	finally
    //   1763	1776	1199	finally
    //   1780	1792	1199	finally
    //   1796	1808	1199	finally
    //   1812	1827	1199	finally
    //   1831	1856	1199	finally
    //   1860	1875	1199	finally
    //   1879	1901	1199	finally
    //   1905	1916	1199	finally
    //   1920	1965	1199	finally
    //   1969	1980	1199	finally
    //   1985	2086	1199	finally
    //   2086	2099	1199	finally
    //   2099	2105	1199	finally
    //   2108	2112	1199	finally
    //   2117	2146	1199	finally
    //   2155	2168	1199	finally
    //   2171	2186	1199	finally
    //   2194	2204	1199	finally
    //   2212	2231	1199	finally
    //   2234	2253	1199	finally
    //   2259	2270	1199	finally
    //   2273	2281	1199	finally
    //   2284	2513	1199	finally
    //   2513	2586	1199	finally
    //   2586	2606	1199	finally
    //   2606	2674	1199	finally
    //   2679	2684	1199	finally
    //   2695	2725	1199	finally
    //   2730	2743	1199	finally
    //   1744	1759	2115	java/lang/Throwable
    //   1763	1776	2115	java/lang/Throwable
    //   1780	1792	2115	java/lang/Throwable
    //   1796	1808	2115	java/lang/Throwable
    //   1812	1827	2115	java/lang/Throwable
    //   1831	1856	2115	java/lang/Throwable
    //   1860	1875	2115	java/lang/Throwable
    //   1879	1901	2115	java/lang/Throwable
    //   1905	1916	2115	java/lang/Throwable
    //   1920	1965	2115	java/lang/Throwable
    //   1969	1980	2115	java/lang/Throwable
    //   2099	2105	2153	java/lang/Exception
    //   2212	2231	2677	java/lang/Exception
    //   2234	2253	2677	java/lang/Exception
    //   911	999	2693	java/lang/Exception
    //   1002	1032	2693	java/lang/Exception
    //   1032	1080	2693	java/lang/Exception
    //   0	55	2728	java/lang/Throwable
    //   844	892	2728	java/lang/Throwable
    //   892	904	2728	java/lang/Throwable
    //   911	999	2728	java/lang/Throwable
    //   1002	1032	2728	java/lang/Throwable
    //   1032	1080	2728	java/lang/Throwable
    //   1080	1120	2728	java/lang/Throwable
    //   1120	1126	2728	java/lang/Throwable
    //   2695	2725	2728	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aj.c
 * JD-Core Version:    0.7.0.1
 */