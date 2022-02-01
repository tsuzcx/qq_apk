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
    this.b.D.quicksender.b(false);
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
    //   10: checkcast 97	com/tencent/qphone/base/remote/ToServiceMsg
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
    //   57: ifnull +1031 -> 1088
    //   60: aload 17
    //   62: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   65: astore 14
    //   67: aload 14
    //   69: ldc 156
    //   71: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_m1
    //   77: if_icmpeq +2721 -> 2798
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
    //   168: ifnull +1235 -> 1403
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
    //   246: ifeq +931 -> 1177
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
    //   336: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    //   410: ifnull +776 -> 1186
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
    //   440: iload_3
    //   441: invokestatic 312	com/tencent/mobileqq/msf/core/aj:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   444: astore 16
    //   446: aload 17
    //   448: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   451: ifnonnull +62 -> 513
    //   454: new 314	java/util/HashMap
    //   457: dup
    //   458: invokespecial 315	java/util/HashMap:<init>	()V
    //   461: astore 18
    //   463: aload 18
    //   465: ldc_w 317
    //   468: aload 17
    //   470: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   473: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: aload_0
    //   478: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   481: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   484: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   487: ifnull +26 -> 513
    //   490: aload_0
    //   491: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   494: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   497: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   500: ldc_w 323
    //   503: iconst_0
    //   504: lconst_0
    //   505: lconst_0
    //   506: aload 18
    //   508: iconst_0
    //   509: iconst_0
    //   510: invokevirtual 326	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   513: invokestatic 329	com/tencent/mobileqq/msf/core/aj:s	()Z
    //   516: ifne +52 -> 568
    //   519: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   522: sipush 780
    //   525: if_icmpeq +38 -> 563
    //   528: aload_0
    //   529: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   532: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   535: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   538: ifnull +25 -> 563
    //   541: aload_0
    //   542: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   545: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   548: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   551: ldc_w 336
    //   554: iconst_0
    //   555: lconst_0
    //   556: lconst_0
    //   557: aconst_null
    //   558: iconst_0
    //   559: iconst_0
    //   560: invokevirtual 326	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   563: iconst_1
    //   564: invokestatic 339	com/tencent/mobileqq/msf/core/aj:a	(Z)Z
    //   567: pop
    //   568: sipush 591
    //   571: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   574: if_icmpne +678 -> 1252
    //   577: aload 17
    //   579: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   582: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   585: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   588: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   591: ldc_w 349
    //   594: aload 14
    //   596: aload_0
    //   597: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   600: invokevirtual 351	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   603: aload 17
    //   605: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   608: aload_0
    //   609: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   612: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   615: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   618: aload 17
    //   620: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   623: iconst_0
    //   624: iload_2
    //   625: aload 17
    //   627: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   630: iconst_0
    //   631: invokestatic 361	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   634: astore 13
    //   636: aload 13
    //   638: ifnull +21 -> 659
    //   641: aload 17
    //   643: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   646: ldc_w 367
    //   649: aload 13
    //   651: arraylength
    //   652: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   655: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: ldc 58
    //   661: iconst_1
    //   662: new 60	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 374
    //   672: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload 17
    //   677: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   680: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   683: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload 13
    //   691: astore 16
    //   693: aload 17
    //   695: ifnull +32 -> 727
    //   698: aload 13
    //   700: astore 16
    //   702: aload 17
    //   704: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   707: ifne +20 -> 727
    //   710: getstatic 377	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   713: invokevirtual 112	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   716: iconst_1
    //   717: aload 17
    //   719: aconst_null
    //   720: invokevirtual 380	com/tencent/mobileqq/msf/core/c/k:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   723: aload 13
    //   725: astore 16
    //   727: aload 16
    //   729: ifnonnull +682 -> 1411
    //   732: ldc 58
    //   734: iconst_1
    //   735: new 60	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   742: ldc_w 382
    //   745: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload 17
    //   750: invokevirtual 385	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
    //   753: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 388	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload_0
    //   763: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   766: aload 17
    //   768: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   771: invokevirtual 126	com/tencent/mobileqq/msf/core/aj:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   774: pop
    //   775: aload_0
    //   776: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   779: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   782: ifnull -782 -> 0
    //   785: aload_0
    //   786: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   789: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   792: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   795: ifnull -795 -> 0
    //   798: aload_0
    //   799: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   802: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   805: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   808: iconst_1
    //   809: invokeinterface 391 2 0
    //   814: pop
    //   815: goto -815 -> 0
    //   818: astore 13
    //   820: ldc 58
    //   822: iconst_1
    //   823: new 60	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 393
    //   833: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 13
    //   838: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   841: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: goto -632 -> 215
    //   850: astore 13
    //   852: ldc 58
    //   854: iconst_1
    //   855: aload 13
    //   857: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
    //   860: aload 13
    //   862: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   865: aload_0
    //   866: aload 17
    //   868: ldc_w 402
    //   871: aload 13
    //   873: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
    //   876: invokespecial 404	com/tencent/mobileqq/msf/core/aj$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload_0
    //   880: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   883: getfield 135	com/tencent/mobileqq/msf/core/aj:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   886: aload 17
    //   888: invokevirtual 406	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
    //   891: pop
    //   892: aload_0
    //   893: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   896: invokestatic 409	com/tencent/mobileqq/msf/core/aj:f	(Lcom/tencent/mobileqq/msf/core/aj;)J
    //   899: pop2
    //   900: aload 17
    //   902: invokevirtual 413	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   905: astore 13
    //   907: getstatic 419	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   910: astore 14
    //   912: aload 13
    //   914: aload 14
    //   916: if_acmpne +172 -> 1088
    //   919: aload 17
    //   921: aload 17
    //   923: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   926: invokevirtual 422	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   929: checkcast 424	com/tencent/qphone/base/remote/FromServiceMsg
    //   932: astore 13
    //   934: ldc 58
    //   936: iconst_1
    //   937: new 60	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   944: invokestatic 428	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   947: invokevirtual 431	java/lang/Thread:getName	()Ljava/lang/String;
    //   950: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: ldc_w 433
    //   956: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload 13
    //   961: invokevirtual 434	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   964: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   967: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aload_0
    //   977: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   980: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   983: invokevirtual 260	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   986: aload 13
    //   988: invokevirtual 434	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   991: invokevirtual 437	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
    //   994: aload 13
    //   996: sipush 2012
    //   999: aload 13
    //   1001: invokevirtual 440	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1004: invokevirtual 444	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   1007: iconst_0
    //   1008: istore 11
    //   1010: aload 17
    //   1012: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1015: ldc_w 446
    //   1018: invokevirtual 447	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1021: ifeq +19 -> 1040
    //   1024: aload 17
    //   1026: ldc_w 446
    //   1029: invokevirtual 422	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1032: checkcast 449	java/lang/Boolean
    //   1035: invokevirtual 452	java/lang/Boolean:booleanValue	()Z
    //   1038: istore 11
    //   1040: aload 13
    //   1042: ldc_w 446
    //   1045: iload 11
    //   1047: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1050: invokevirtual 458	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1053: pop
    //   1054: ldc_w 460
    //   1057: aload 13
    //   1059: invokestatic 464	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1062: aload_0
    //   1063: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1066: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1069: aconst_null
    //   1070: aload 13
    //   1072: invokevirtual 468	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1075: aload_0
    //   1076: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1079: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1082: getstatic 473	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
    //   1085: invokevirtual 476	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   1088: aload_0
    //   1089: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1092: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1095: ifnull +33 -> 1128
    //   1098: aload_0
    //   1099: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1102: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1105: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1108: ifnull +20 -> 1128
    //   1111: aload_0
    //   1112: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1115: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1118: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1121: iconst_1
    //   1122: invokeinterface 391 2 0
    //   1127: pop
    //   1128: ldc2_w 477
    //   1131: invokestatic 482	java/lang/Thread:sleep	(J)V
    //   1134: aload_0
    //   1135: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1138: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1141: ifnull -1141 -> 0
    //   1144: aload_0
    //   1145: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1148: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1151: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1154: ifnull -1154 -> 0
    //   1157: aload_0
    //   1158: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1161: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1164: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1167: iconst_1
    //   1168: invokeinterface 391 2 0
    //   1173: pop
    //   1174: goto -1174 -> 0
    //   1177: iload_3
    //   1178: bipush 251
    //   1180: iand
    //   1181: i2b
    //   1182: istore_1
    //   1183: goto -929 -> 254
    //   1186: iconst_1
    //   1187: istore_3
    //   1188: goto -758 -> 430
    //   1191: astore 18
    //   1193: ldc 58
    //   1195: iconst_1
    //   1196: ldc_w 484
    //   1199: aload 18
    //   1201: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1204: goto -636 -> 568
    //   1207: astore 13
    //   1209: aload_0
    //   1210: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1213: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1216: ifnull +33 -> 1249
    //   1219: aload_0
    //   1220: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1223: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1226: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1229: ifnull +20 -> 1249
    //   1232: aload_0
    //   1233: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1236: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1239: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1242: iconst_1
    //   1243: invokeinterface 391 2 0
    //   1248: pop
    //   1249: aload 13
    //   1251: athrow
    //   1252: sipush 595
    //   1255: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1258: if_icmpeq +12 -> 1270
    //   1261: sipush 600
    //   1264: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   1267: if_icmpne +69 -> 1336
    //   1270: aload 17
    //   1272: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1275: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   1278: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   1281: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   1284: ldc_w 349
    //   1287: aload 14
    //   1289: aload_0
    //   1290: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1293: invokevirtual 351	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   1296: aload 17
    //   1298: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1301: aload_0
    //   1302: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1305: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1308: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1311: aload 17
    //   1313: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1316: iconst_0
    //   1317: iload_2
    //   1318: aload 13
    //   1320: aload 16
    //   1322: aload 17
    //   1324: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1327: iconst_0
    //   1328: invokestatic 487	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[B[BZ)[B
    //   1331: astore 13
    //   1333: goto -697 -> 636
    //   1336: aload 17
    //   1338: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1341: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   1344: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   1347: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   1350: ldc_w 349
    //   1353: aload 14
    //   1355: aload_0
    //   1356: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1359: invokevirtual 351	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   1362: aload 17
    //   1364: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1367: aload_0
    //   1368: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1371: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1374: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   1377: aload 17
    //   1379: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1382: iconst_0
    //   1383: iload_2
    //   1384: iload_1
    //   1385: aload 13
    //   1387: aload 16
    //   1389: aload 17
    //   1391: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   1394: iconst_0
    //   1395: invokestatic 490	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[B[BZ)[B
    //   1398: astore 13
    //   1400: goto -764 -> 636
    //   1403: iconst_0
    //   1404: newarray byte
    //   1406: astore 16
    //   1408: goto -681 -> 727
    //   1411: aload 17
    //   1413: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1416: ldc_w 492
    //   1419: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1422: ifne +1382 -> 2804
    //   1425: aload 17
    //   1427: ldc_w 497
    //   1430: iconst_0
    //   1431: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1434: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1437: checkcast 449	java/lang/Boolean
    //   1440: invokevirtual 452	java/lang/Boolean:booleanValue	()Z
    //   1443: ifne +1361 -> 2804
    //   1446: aload 17
    //   1448: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1451: iconst_m1
    //   1452: if_icmpeq +1352 -> 2804
    //   1455: aload 17
    //   1457: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1460: bipush 100
    //   1462: if_icmpeq +1342 -> 2804
    //   1465: aload_0
    //   1466: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1469: aload 17
    //   1471: invokestatic 500	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1474: goto +1330 -> 2804
    //   1477: iload 11
    //   1479: ifne -579 -> 900
    //   1482: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1485: lstore 9
    //   1487: lload 9
    //   1489: lload 7
    //   1491: lsub
    //   1492: aload 17
    //   1494: invokevirtual 503	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   1497: lcmp
    //   1498: ifle +39 -> 1537
    //   1501: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1504: ifeq -604 -> 900
    //   1507: ldc 58
    //   1509: iconst_2
    //   1510: new 60	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1517: aload 17
    //   1519: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1522: ldc_w 505
    //   1525: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1531: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1534: goto -634 -> 900
    //   1537: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1540: lconst_0
    //   1541: lcmp
    //   1542: ifeq +114 -> 1656
    //   1545: lload 9
    //   1547: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1550: lsub
    //   1551: invokestatic 511	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1554: i2l
    //   1555: lcmp
    //   1556: ifle +100 -> 1656
    //   1559: aload_0
    //   1560: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1563: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1566: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1569: ifeq +87 -> 1656
    //   1572: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1575: aload_0
    //   1576: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1579: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1582: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1585: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1588: lcmp
    //   1589: iflt +531 -> 2120
    //   1592: lconst_0
    //   1593: putstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1596: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1599: ifeq +47 -> 1646
    //   1602: ldc 58
    //   1604: iconst_2
    //   1605: new 60	java/lang/StringBuilder
    //   1608: dup
    //   1609: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1612: ldc_w 515
    //   1615: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1621: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1624: lsub
    //   1625: invokevirtual 518	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1628: ldc_w 520
    //   1631: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: invokestatic 511	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1637: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1640: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1643: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1646: aload_0
    //   1647: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1650: getstatic 522	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
    //   1653: invokevirtual 523	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/qphone/base/a;)V
    //   1656: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1659: lconst_0
    //   1660: lcmp
    //   1661: ifeq +85 -> 1746
    //   1664: lload 9
    //   1666: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1669: lsub
    //   1670: ldc2_w 524
    //   1673: lcmp
    //   1674: ifle +72 -> 1746
    //   1677: aload_0
    //   1678: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1681: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1684: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1687: ifeq +59 -> 1746
    //   1690: getstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   1693: aload_0
    //   1694: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1697: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1700: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1703: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1706: lcmp
    //   1707: iflt +39 -> 1746
    //   1710: aload_0
    //   1711: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1714: getfield 529	com/tencent/mobileqq/msf/core/aj:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1717: invokevirtual 534	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1720: ifne +26 -> 1746
    //   1723: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1726: ifeq +12 -> 1738
    //   1729: ldc 58
    //   1731: iconst_2
    //   1732: ldc_w 536
    //   1735: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1738: aload_0
    //   1739: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1742: iconst_0
    //   1743: invokestatic 539	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;Z)V
    //   1746: aload_0
    //   1747: aload 17
    //   1749: invokespecial 541	com/tencent/mobileqq/msf/core/aj$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1752: iload 11
    //   1754: istore 12
    //   1756: aload 17
    //   1758: ldc_w 543
    //   1761: invokestatic 548	android/os/SystemClock:elapsedRealtime	()J
    //   1764: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1767: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1770: pop
    //   1771: iload 11
    //   1773: istore 12
    //   1775: aload 17
    //   1777: ldc_w 551
    //   1780: lconst_0
    //   1781: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1784: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1787: pop
    //   1788: iload 11
    //   1790: istore 12
    //   1792: aload 17
    //   1794: ldc_w 553
    //   1797: getstatic 557	com/tencent/mobileqq/msf/core/aj:E	Ljava/lang/String;
    //   1800: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1803: pop
    //   1804: iload 11
    //   1806: istore 12
    //   1808: aload 17
    //   1810: ldc_w 559
    //   1813: getstatic 562	com/tencent/mobileqq/msf/core/aj:F	Ljava/lang/String;
    //   1816: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1819: pop
    //   1820: iload 11
    //   1822: istore 12
    //   1824: aload 17
    //   1826: ldc_w 564
    //   1829: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1832: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1835: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1838: pop
    //   1839: iload 11
    //   1841: istore 12
    //   1843: aload 17
    //   1845: ldc_w 566
    //   1848: aload_0
    //   1849: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1852: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1855: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1858: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1861: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1864: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1867: pop
    //   1868: iload 11
    //   1870: istore 12
    //   1872: aload 17
    //   1874: ldc_w 568
    //   1877: invokestatic 571	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   1880: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1883: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1886: pop
    //   1887: iload 11
    //   1889: istore 12
    //   1891: aload 17
    //   1893: ldc_w 573
    //   1896: aload_0
    //   1897: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1900: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1903: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1906: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1909: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1912: pop
    //   1913: iload 11
    //   1915: istore 12
    //   1917: aload_0
    //   1918: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1921: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   1924: invokestatic 576	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/mobileqq/msf/core/aj;J)J
    //   1927: pop2
    //   1928: iload 11
    //   1930: istore 12
    //   1932: aload_0
    //   1933: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1936: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1939: aload 17
    //   1941: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1944: aload 17
    //   1946: invokevirtual 579	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   1949: aload 14
    //   1951: aload 15
    //   1953: aload 17
    //   1955: invokevirtual 413	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1958: aload 17
    //   1960: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1963: aload 17
    //   1965: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1968: aload 16
    //   1970: aload 17
    //   1972: invokevirtual 582	com/tencent/mobileqq/msf/core/net/n:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1975: istore 11
    //   1977: iload 11
    //   1979: istore 12
    //   1981: aload_0
    //   1982: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   1985: invokestatic 585	android/os/SystemClock:uptimeMillis	()J
    //   1988: invokestatic 587	com/tencent/mobileqq/msf/core/aj:b	(Lcom/tencent/mobileqq/msf/core/aj;J)J
    //   1991: pop2
    //   1992: iload 11
    //   1994: ifne +189 -> 2183
    //   1997: aload 17
    //   1999: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2002: ldc_w 543
    //   2005: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload 17
    //   2011: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2014: ldc_w 551
    //   2017: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2020: pop
    //   2021: aload 17
    //   2023: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2026: ldc_w 553
    //   2029: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2032: pop
    //   2033: aload 17
    //   2035: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2038: ldc_w 559
    //   2041: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2044: pop
    //   2045: aload 17
    //   2047: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2050: ldc_w 590
    //   2053: iconst_1
    //   2054: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2057: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2060: pop
    //   2061: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2064: ifeq +34 -> 2098
    //   2067: ldc 58
    //   2069: iconst_2
    //   2070: new 60	java/lang/StringBuilder
    //   2073: dup
    //   2074: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2077: invokestatic 428	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2080: invokevirtual 431	java/lang/Thread:getName	()Ljava/lang/String;
    //   2083: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: ldc_w 592
    //   2089: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2095: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2098: aload_0
    //   2099: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2102: getfield 33	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2105: getstatic 594	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
    //   2108: invokevirtual 476	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   2111: getstatic 599	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
    //   2114: invokestatic 482	java/lang/Thread:sleep	(J)V
    //   2117: goto -640 -> 1477
    //   2120: lconst_0
    //   2121: putstatic 508	com/tencent/mobileqq/msf/core/aj:U	J
    //   2124: goto -468 -> 1656
    //   2127: astore 13
    //   2129: ldc 58
    //   2131: iconst_1
    //   2132: new 60	java/lang/StringBuilder
    //   2135: dup
    //   2136: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2139: ldc_w 601
    //   2142: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: aload 13
    //   2147: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2150: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2153: aload 13
    //   2155: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2158: iload 12
    //   2160: istore 11
    //   2162: goto -170 -> 1992
    //   2165: astore 13
    //   2167: ldc 58
    //   2169: iconst_1
    //   2170: aload 13
    //   2172: invokevirtual 602	java/lang/Exception:toString	()Ljava/lang/String;
    //   2175: aload 13
    //   2177: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2180: goto -703 -> 1477
    //   2183: aload 17
    //   2185: ldc_w 551
    //   2188: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   2191: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2194: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2197: pop
    //   2198: iconst_0
    //   2199: istore_3
    //   2200: iconst_0
    //   2201: istore 4
    //   2203: iconst_0
    //   2204: istore 5
    //   2206: ldc_w 604
    //   2209: aload 14
    //   2211: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2214: istore 12
    //   2216: iload 12
    //   2218: ifeq +478 -> 2696
    //   2221: iload 4
    //   2223: istore_3
    //   2224: aload 17
    //   2226: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2229: ldc_w 606
    //   2232: invokevirtual 608	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2235: checkcast 369	java/lang/Integer
    //   2238: invokevirtual 611	java/lang/Integer:intValue	()I
    //   2241: istore 4
    //   2243: iload 4
    //   2245: istore_3
    //   2246: aload 17
    //   2248: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2251: ldc_w 613
    //   2254: invokevirtual 608	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2257: checkcast 369	java/lang/Integer
    //   2260: invokevirtual 611	java/lang/Integer:intValue	()I
    //   2263: istore 6
    //   2265: iload 6
    //   2267: istore_3
    //   2268: iload_3
    //   2269: istore 5
    //   2271: ldc_w 604
    //   2274: aload 14
    //   2276: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2279: ifne +17 -> 2296
    //   2282: iload_3
    //   2283: istore 5
    //   2285: aload 17
    //   2287: invokevirtual 616	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
    //   2290: ifne +6 -> 2296
    //   2293: iconst_1
    //   2294: istore 5
    //   2296: aload 14
    //   2298: aload 17
    //   2300: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2303: aload 16
    //   2305: arraylength
    //   2306: i2l
    //   2307: iload 4
    //   2309: iload 5
    //   2311: invokestatic 621	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
    //   2314: aload 17
    //   2316: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2319: ifnull +279 -> 2598
    //   2322: aload 17
    //   2324: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2327: invokevirtual 165	java/lang/String:length	()I
    //   2330: iconst_4
    //   2331: if_icmple +267 -> 2598
    //   2334: aload 17
    //   2336: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2339: ldc_w 623
    //   2342: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2345: ifne +253 -> 2598
    //   2348: aload 17
    //   2350: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2353: ldc_w 629
    //   2356: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2359: ifne +239 -> 2598
    //   2362: aload 17
    //   2364: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2367: ldc_w 631
    //   2370: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2373: ifne +225 -> 2598
    //   2376: aload 17
    //   2378: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2381: ldc_w 633
    //   2384: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2387: ifne +211 -> 2598
    //   2390: aload 17
    //   2392: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2395: ldc_w 635
    //   2398: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2401: ifne +197 -> 2598
    //   2404: aload 17
    //   2406: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2409: ldc_w 637
    //   2412: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2415: ifne +183 -> 2598
    //   2418: aload 17
    //   2420: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2423: ldc_w 639
    //   2426: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2429: ifne +169 -> 2598
    //   2432: aload 17
    //   2434: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2437: ldc_w 641
    //   2440: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2443: ifne +155 -> 2598
    //   2446: aload 17
    //   2448: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2451: ldc_w 643
    //   2454: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2457: ifne +141 -> 2598
    //   2460: aload 17
    //   2462: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2465: ldc_w 645
    //   2468: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2471: ifne +127 -> 2598
    //   2474: getstatic 649	com/tencent/mobileqq/msf/core/aj:af	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   2477: aload 17
    //   2479: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2482: invokevirtual 652	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
    //   2485: ifne +113 -> 2598
    //   2488: getstatic 655	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2491: aload 17
    //   2493: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2496: invokevirtual 656	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2499: ifnonnull +26 -> 2525
    //   2502: new 658	java/util/concurrent/ConcurrentLinkedQueue
    //   2505: dup
    //   2506: invokespecial 659	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
    //   2509: astore 13
    //   2511: getstatic 655	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2514: aload 17
    //   2516: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2519: aload 13
    //   2521: invokevirtual 660	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2524: pop
    //   2525: getstatic 655	com/tencent/mobileqq/msf/core/aj:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2528: aload 17
    //   2530: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2533: invokevirtual 656	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2536: checkcast 658	java/util/concurrent/ConcurrentLinkedQueue
    //   2539: aload 17
    //   2541: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2544: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2547: invokevirtual 663	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
    //   2550: pop
    //   2551: ldc 58
    //   2553: iconst_1
    //   2554: new 60	java/lang/StringBuilder
    //   2557: dup
    //   2558: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2561: ldc_w 665
    //   2564: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: aload 17
    //   2569: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2572: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2575: ldc_w 667
    //   2578: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: aload 17
    //   2583: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2586: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2589: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2592: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2595: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2598: aload 17
    //   2600: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2603: ldc_w 669
    //   2606: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2609: ifeq +9 -> 2618
    //   2612: invokestatic 548	android/os/SystemClock:elapsedRealtime	()J
    //   2615: putstatic 671	com/tencent/mobileqq/msf/core/aj:J	J
    //   2618: aload_0
    //   2619: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2622: getfield 674	com/tencent/mobileqq/msf/core/aj:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2625: invokevirtual 534	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2628: ifeq +182 -> 2810
    //   2631: aload_0
    //   2632: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2635: getfield 677	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2638: iconst_m1
    //   2639: if_icmpne +171 -> 2810
    //   2642: aload_0
    //   2643: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2646: aload 17
    //   2648: invokevirtual 122	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2651: putfield 677	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2654: ldc 58
    //   2656: iconst_1
    //   2657: new 60	java/lang/StringBuilder
    //   2660: dup
    //   2661: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2664: ldc_w 679
    //   2667: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2670: aload_0
    //   2671: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2674: getfield 677	com/tencent/mobileqq/msf/core/aj:aa	I
    //   2677: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2680: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2683: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2686: goto +124 -> 2810
    //   2689: astore 13
    //   2691: aload 13
    //   2693: invokevirtual 682	java/lang/Exception:printStackTrace	()V
    //   2696: iload_3
    //   2697: istore 4
    //   2699: iload 5
    //   2701: istore_3
    //   2702: goto -434 -> 2268
    //   2705: astore 13
    //   2707: ldc 58
    //   2709: iconst_1
    //   2710: new 60	java/lang/StringBuilder
    //   2713: dup
    //   2714: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2717: ldc_w 684
    //   2720: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2723: aload 13
    //   2725: invokevirtual 602	java/lang/Exception:toString	()Ljava/lang/String;
    //   2728: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2734: invokestatic 686	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2737: goto -1649 -> 1088
    //   2740: astore 13
    //   2742: ldc 58
    //   2744: iconst_1
    //   2745: aload 13
    //   2747: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2750: aload 13
    //   2752: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2755: aload_0
    //   2756: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2759: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2762: ifnull -2762 -> 0
    //   2765: aload_0
    //   2766: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2769: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2772: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2775: ifnull -2775 -> 0
    //   2778: aload_0
    //   2779: getfield 12	com/tencent/mobileqq/msf/core/aj$c:b	Lcom/tencent/mobileqq/msf/core/aj;
    //   2782: getfield 41	com/tencent/mobileqq/msf/core/aj:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2785: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   2788: iconst_1
    //   2789: invokeinterface 391 2 0
    //   2794: pop
    //   2795: goto -2795 -> 0
    //   2798: aconst_null
    //   2799: astore 15
    //   2801: goto -2679 -> 122
    //   2804: iconst_0
    //   2805: istore 11
    //   2807: goto -1330 -> 1477
    //   2810: goto -1333 -> 1477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2813	0	this	c
    //   253	1132	1	b1	byte
    //   174	1210	2	i	int
    //   74	2628	3	j	int
    //   2201	497	4	k	int
    //   2204	496	5	m	int
    //   2263	3	6	n	int
    //   139	1351	7	l1	long
    //   144	1521	9	l2	long
    //   1008	1798	11	bool1	boolean
    //   1754	463	12	bool2	boolean
    //   436	288	13	arrayOfByte1	byte[]
    //   818	19	13	localException1	java.lang.Exception
    //   850	22	13	localThrowable1	java.lang.Throwable
    //   905	166	13	localObject1	java.lang.Object
    //   1207	112	13	arrayOfByte2	byte[]
    //   1331	68	13	arrayOfByte3	byte[]
    //   2127	27	13	localThrowable2	java.lang.Throwable
    //   2165	11	13	localException2	java.lang.Exception
    //   2509	11	13	localConcurrentLinkedQueue	java.util.concurrent.ConcurrentLinkedQueue
    //   2689	3	13	localException3	java.lang.Exception
    //   2705	19	13	localException4	java.lang.Exception
    //   2740	11	13	localThrowable3	java.lang.Throwable
    //   65	2232	14	localObject2	java.lang.Object
    //   111	2689	15	str	String
    //   444	1860	16	arrayOfByte4	byte[]
    //   13	2634	17	localToServiceMsg	ToServiceMsg
    //   461	46	18	localHashMap	java.util.HashMap
    //   1191	9	18	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   208	215	818	java/lang/Exception
    //   60	75	850	java/lang/Throwable
    //   80	122	850	java/lang/Throwable
    //   122	175	850	java/lang/Throwable
    //   179	202	850	java/lang/Throwable
    //   202	208	850	java/lang/Throwable
    //   208	215	850	java/lang/Throwable
    //   215	237	850	java/lang/Throwable
    //   237	249	850	java/lang/Throwable
    //   254	345	850	java/lang/Throwable
    //   345	370	850	java/lang/Throwable
    //   370	397	850	java/lang/Throwable
    //   397	430	850	java/lang/Throwable
    //   430	446	850	java/lang/Throwable
    //   446	513	850	java/lang/Throwable
    //   513	563	850	java/lang/Throwable
    //   563	568	850	java/lang/Throwable
    //   568	636	850	java/lang/Throwable
    //   641	659	850	java/lang/Throwable
    //   659	689	850	java/lang/Throwable
    //   702	723	850	java/lang/Throwable
    //   732	775	850	java/lang/Throwable
    //   820	847	850	java/lang/Throwable
    //   1193	1204	850	java/lang/Throwable
    //   1252	1270	850	java/lang/Throwable
    //   1270	1333	850	java/lang/Throwable
    //   1336	1400	850	java/lang/Throwable
    //   1403	1408	850	java/lang/Throwable
    //   1411	1474	850	java/lang/Throwable
    //   1482	1534	850	java/lang/Throwable
    //   1537	1646	850	java/lang/Throwable
    //   1646	1656	850	java/lang/Throwable
    //   1656	1738	850	java/lang/Throwable
    //   1738	1746	850	java/lang/Throwable
    //   1746	1752	850	java/lang/Throwable
    //   1997	2098	850	java/lang/Throwable
    //   2098	2111	850	java/lang/Throwable
    //   2111	2117	850	java/lang/Throwable
    //   2120	2124	850	java/lang/Throwable
    //   2129	2158	850	java/lang/Throwable
    //   2167	2180	850	java/lang/Throwable
    //   2183	2198	850	java/lang/Throwable
    //   2206	2216	850	java/lang/Throwable
    //   2224	2243	850	java/lang/Throwable
    //   2246	2265	850	java/lang/Throwable
    //   2271	2282	850	java/lang/Throwable
    //   2285	2293	850	java/lang/Throwable
    //   2296	2525	850	java/lang/Throwable
    //   2525	2598	850	java/lang/Throwable
    //   2598	2618	850	java/lang/Throwable
    //   2618	2686	850	java/lang/Throwable
    //   2691	2696	850	java/lang/Throwable
    //   446	513	1191	java/lang/Exception
    //   513	563	1191	java/lang/Exception
    //   563	568	1191	java/lang/Exception
    //   0	55	1207	finally
    //   60	75	1207	finally
    //   80	122	1207	finally
    //   122	175	1207	finally
    //   179	202	1207	finally
    //   202	208	1207	finally
    //   208	215	1207	finally
    //   215	237	1207	finally
    //   237	249	1207	finally
    //   254	345	1207	finally
    //   345	370	1207	finally
    //   370	397	1207	finally
    //   397	430	1207	finally
    //   430	446	1207	finally
    //   446	513	1207	finally
    //   513	563	1207	finally
    //   563	568	1207	finally
    //   568	636	1207	finally
    //   641	659	1207	finally
    //   659	689	1207	finally
    //   702	723	1207	finally
    //   732	775	1207	finally
    //   820	847	1207	finally
    //   852	900	1207	finally
    //   900	912	1207	finally
    //   919	1007	1207	finally
    //   1010	1040	1207	finally
    //   1040	1088	1207	finally
    //   1088	1128	1207	finally
    //   1128	1134	1207	finally
    //   1193	1204	1207	finally
    //   1252	1270	1207	finally
    //   1270	1333	1207	finally
    //   1336	1400	1207	finally
    //   1403	1408	1207	finally
    //   1411	1474	1207	finally
    //   1482	1534	1207	finally
    //   1537	1646	1207	finally
    //   1646	1656	1207	finally
    //   1656	1738	1207	finally
    //   1738	1746	1207	finally
    //   1746	1752	1207	finally
    //   1756	1771	1207	finally
    //   1775	1788	1207	finally
    //   1792	1804	1207	finally
    //   1808	1820	1207	finally
    //   1824	1839	1207	finally
    //   1843	1868	1207	finally
    //   1872	1887	1207	finally
    //   1891	1913	1207	finally
    //   1917	1928	1207	finally
    //   1932	1977	1207	finally
    //   1981	1992	1207	finally
    //   1997	2098	1207	finally
    //   2098	2111	1207	finally
    //   2111	2117	1207	finally
    //   2120	2124	1207	finally
    //   2129	2158	1207	finally
    //   2167	2180	1207	finally
    //   2183	2198	1207	finally
    //   2206	2216	1207	finally
    //   2224	2243	1207	finally
    //   2246	2265	1207	finally
    //   2271	2282	1207	finally
    //   2285	2293	1207	finally
    //   2296	2525	1207	finally
    //   2525	2598	1207	finally
    //   2598	2618	1207	finally
    //   2618	2686	1207	finally
    //   2691	2696	1207	finally
    //   2707	2737	1207	finally
    //   2742	2755	1207	finally
    //   1756	1771	2127	java/lang/Throwable
    //   1775	1788	2127	java/lang/Throwable
    //   1792	1804	2127	java/lang/Throwable
    //   1808	1820	2127	java/lang/Throwable
    //   1824	1839	2127	java/lang/Throwable
    //   1843	1868	2127	java/lang/Throwable
    //   1872	1887	2127	java/lang/Throwable
    //   1891	1913	2127	java/lang/Throwable
    //   1917	1928	2127	java/lang/Throwable
    //   1932	1977	2127	java/lang/Throwable
    //   1981	1992	2127	java/lang/Throwable
    //   2111	2117	2165	java/lang/Exception
    //   2224	2243	2689	java/lang/Exception
    //   2246	2265	2689	java/lang/Exception
    //   919	1007	2705	java/lang/Exception
    //   1010	1040	2705	java/lang/Exception
    //   1040	1088	2705	java/lang/Exception
    //   0	55	2740	java/lang/Throwable
    //   852	900	2740	java/lang/Throwable
    //   900	912	2740	java/lang/Throwable
    //   919	1007	2740	java/lang/Throwable
    //   1010	1040	2740	java/lang/Throwable
    //   1040	1088	2740	java/lang/Throwable
    //   1088	1128	2740	java/lang/Throwable
    //   1128	1134	2740	java/lang/Throwable
    //   2707	2737	2740	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aj.c
 * JD-Core Version:    0.7.0.1
 */