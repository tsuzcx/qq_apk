package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.c.a;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class ac$c
  extends Thread
{
  long a = 0L;
  
  ac$c(ac paramac) {}
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if ((i.a().d()) && (this.b.b.b()) && (this.b.D.quicksender != null) && (this.b.D.getDeepSleepDetector() != null))
    {
      if (this.b.D.quicksender.b(2000L))
      {
        a(paramToServiceMsg, 1);
        return;
      }
      if (this.b.D.getDeepSleepDetector().b()) {
        a(paramToServiceMsg, 2);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("sendQuiHeartbeatWhenWakeFromDs, isConned = ");
      paramToServiceMsg.append(this.b.b.b());
      paramToServiceMsg.append(", than return.");
      QLog.d("MSF.C.NetConnTag", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (!paramToServiceMsg.isSupportRetry())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendQuiHeartbeatWhenWakeFromDs#setRetry, goCase = ");
        localStringBuilder.append(paramInt);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
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
  
  private void a(String paramString, long paramLong, Throwable paramThrowable)
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      String str = paramThrowable.getClass().getSimpleName();
      paramThrowable = paramThrowable.getMessage();
      HashMap localHashMap = new HashMap();
      localHashMap.put("account_uin", paramString);
      localHashMap.put("sso_seq", String.valueOf(paramLong));
      localHashMap.put("throwable_bean", str);
      localHashMap.put("throwable_msg", paramThrowable);
      MsfService.getCore().getStatReporter().a("msf_send_data_throwable", false, 0L, 0L, localHashMap, true, false);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 180
    //   2: astore 14
    //   4: ldc 182
    //   6: astore 15
    //   8: aload_0
    //   9: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   12: getfield 186	com/tencent/mobileqq/msf/core/ac:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   15: invokevirtual 192	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
    //   18: checkcast 94	com/tencent/qphone/base/remote/ToServiceMsg
    //   21: astore 21
    //   23: aload_0
    //   24: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   27: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   30: ifnull +33 -> 63
    //   33: aload_0
    //   34: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   37: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   40: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   43: ifnull +20 -> 63
    //   46: aload_0
    //   47: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   50: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   53: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   56: iconst_1
    //   57: invokeinterface 202 2 0
    //   62: pop
    //   63: aload 21
    //   65: ifnull +3644 -> 3709
    //   68: aload 21
    //   70: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   73: astore 18
    //   75: aload 18
    //   77: ldc 207
    //   79: invokevirtual 211	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpeq +3570 -> 3655
    //   88: new 71	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   95: astore 16
    //   97: aload 16
    //   99: aload 18
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: aload 18
    //   106: invokevirtual 214	java/lang/String:length	()I
    //   109: invokevirtual 218	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 16
    //   118: ldc 220
    //   120: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 16
    //   126: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 19
    //   131: aload 18
    //   133: iconst_0
    //   134: iload_3
    //   135: invokevirtual 218	java/lang/String:substring	(II)Ljava/lang/String;
    //   138: astore 18
    //   140: goto +3 -> 143
    //   143: aload 21
    //   145: ldc 222
    //   147: lconst_0
    //   148: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: invokevirtual 231	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast 224	java/lang/Long
    //   157: invokevirtual 235	java/lang/Long:longValue	()J
    //   160: lstore 6
    //   162: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   165: lstore 8
    //   167: aload_0
    //   168: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   171: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   174: getfield 244	com/tencent/mobileqq/msf/core/MsfCore:configManager	Lcom/tencent/mobileqq/msf/core/a/a;
    //   177: aload 21
    //   179: lload 8
    //   181: invokevirtual 249	com/tencent/mobileqq/msf/core/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;J)V
    //   184: aload 21
    //   186: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   189: astore 16
    //   191: aload 16
    //   193: ifnull +926 -> 1119
    //   196: invokestatic 258	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   199: istore_1
    //   200: iload_1
    //   201: ifne +81 -> 282
    //   204: aload_0
    //   205: getfield 17	com/tencent/mobileqq/msf/core/ac$c:a	J
    //   208: lconst_0
    //   209: lcmp
    //   210: ifeq +17 -> 227
    //   213: lload 8
    //   215: aload_0
    //   216: getfield 17	com/tencent/mobileqq/msf/core/ac$c:a	J
    //   219: lsub
    //   220: ldc2_w 259
    //   223: lcmp
    //   224: ifle +58 -> 282
    //   227: aload_0
    //   228: lload 8
    //   230: putfield 17	com/tencent/mobileqq/msf/core/ac$c:a	J
    //   233: invokestatic 266	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   236: iconst_1
    //   237: invokestatic 272	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
    //   240: goto +42 -> 282
    //   243: astore 16
    //   245: new 71	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   252: astore 17
    //   254: aload 17
    //   256: ldc_w 274
    //   259: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 17
    //   265: aload 16
    //   267: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 85
    //   273: iconst_1
    //   274: aload 17
    //   276: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: getstatic 281	com/tencent/mobileqq/msf/core/ac:M	I
    //   285: istore_3
    //   286: iload_1
    //   287: iload_3
    //   288: if_icmpeq +19 -> 307
    //   291: iload_1
    //   292: putstatic 281	com/tencent/mobileqq/msf/core/ac:M	I
    //   295: invokestatic 284	com/tencent/mobileqq/msf/core/ac:j	()V
    //   298: ldc 85
    //   300: iconst_1
    //   301: ldc_w 286
    //   304: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iconst_0
    //   308: invokestatic 290	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   311: i2b
    //   312: istore_3
    //   313: getstatic 294	com/tencent/mobileqq/msf/core/ac:P	Z
    //   316: ifeq +3351 -> 3667
    //   319: iload_3
    //   320: iconst_4
    //   321: ior
    //   322: istore_3
    //   323: goto +3338 -> 3661
    //   326: getstatic 300	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   329: aload 21
    //   331: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   334: invokevirtual 309	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   337: istore 12
    //   339: iload 12
    //   341: ifeq +96 -> 437
    //   344: aload_0
    //   345: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   348: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   351: invokevirtual 313	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   354: aload 21
    //   356: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   359: invokevirtual 319	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
    //   362: getstatic 300	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   365: aload 21
    //   367: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   370: invokevirtual 323	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: new 71	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   381: astore 16
    //   383: aload 16
    //   385: ldc_w 325
    //   388: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 16
    //   394: aload 21
    //   396: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   399: invokestatic 331	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   402: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 16
    //   408: ldc_w 333
    //   411: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 16
    //   417: aload 21
    //   419: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   422: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: ldc 85
    //   428: iconst_1
    //   429: aload 16
    //   431: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload_0
    //   438: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   441: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   444: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   447: istore 12
    //   449: iload 12
    //   451: ifne +15 -> 466
    //   454: invokestatic 284	com/tencent/mobileqq/msf/core/ac:j	()V
    //   457: ldc 85
    //   459: iconst_1
    //   460: ldc_w 335
    //   463: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: aload_0
    //   467: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   470: invokestatic 339	com/tencent/mobileqq/msf/core/ac:e	(Lcom/tencent/mobileqq/msf/core/ac;)Ljava/util/HashSet;
    //   473: aload 21
    //   475: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   478: invokevirtual 344	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   481: istore 12
    //   483: iload 12
    //   485: ifeq +12 -> 497
    //   488: aload 21
    //   490: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   493: iconst_0
    //   494: invokestatic 347	com/tencent/mobileqq/msf/core/ac:a	(Ljava/lang/String;Z)V
    //   497: aload_0
    //   498: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   501: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   504: invokevirtual 351	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   507: invokevirtual 356	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   510: astore 16
    //   512: aload 16
    //   514: ifnull +23 -> 537
    //   517: aload_0
    //   518: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   521: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   524: invokevirtual 351	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   527: invokevirtual 356	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
    //   530: invokevirtual 360	com/tencent/mobileqq/msf/core/d:d	()I
    //   533: istore_3
    //   534: goto +5 -> 539
    //   537: iconst_1
    //   538: istore_3
    //   539: aload 21
    //   541: iload_3
    //   542: invokestatic 363	com/tencent/mobileqq/msf/core/ac:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   545: astore 20
    //   547: aload 21
    //   549: iload_3
    //   550: invokestatic 365	com/tencent/mobileqq/msf/core/ac:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   553: astore 22
    //   555: aload 21
    //   557: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   560: ifnonnull +3115 -> 3675
    //   563: new 149	java/util/HashMap
    //   566: dup
    //   567: invokespecial 150	java/util/HashMap:<init>	()V
    //   570: astore 16
    //   572: aload 14
    //   574: astore 17
    //   576: aload 16
    //   578: ldc_w 367
    //   581: aload 21
    //   583: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   586: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   589: pop
    //   590: aload 14
    //   592: astore 17
    //   594: aload_0
    //   595: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   598: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   601: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   604: ifnull +33 -> 637
    //   607: aload 14
    //   609: astore 17
    //   611: aload_0
    //   612: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   615: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   618: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   621: ldc_w 370
    //   624: iconst_0
    //   625: lconst_0
    //   626: lconst_0
    //   627: aload 16
    //   629: iconst_0
    //   630: iconst_0
    //   631: invokevirtual 175	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   634: goto +3 -> 637
    //   637: aload 14
    //   639: astore 17
    //   641: invokestatic 373	com/tencent/mobileqq/msf/core/ac:u	()Z
    //   644: ifne +93 -> 737
    //   647: aload 14
    //   649: astore 17
    //   651: invokestatic 378	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   654: sipush 780
    //   657: if_icmpeq +46 -> 703
    //   660: aload 14
    //   662: astore 17
    //   664: aload_0
    //   665: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   668: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   671: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   674: ifnull +29 -> 703
    //   677: aload 14
    //   679: astore 17
    //   681: aload_0
    //   682: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   685: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   688: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   691: ldc_w 380
    //   694: iconst_0
    //   695: lconst_0
    //   696: lconst_0
    //   697: aconst_null
    //   698: iconst_0
    //   699: iconst_0
    //   700: invokevirtual 175	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   703: aload 14
    //   705: astore 17
    //   707: iconst_1
    //   708: invokestatic 383	com/tencent/mobileqq/msf/core/ac:a	(Z)Z
    //   711: pop
    //   712: goto +25 -> 737
    //   715: astore 16
    //   717: goto +5 -> 722
    //   720: astore 16
    //   722: aload 14
    //   724: astore 17
    //   726: ldc 85
    //   728: iconst_1
    //   729: ldc_w 385
    //   732: aload 16
    //   734: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   737: aload 14
    //   739: astore 17
    //   741: sipush 591
    //   744: invokestatic 378	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   747: if_icmpne +69 -> 816
    //   750: aload 14
    //   752: astore 17
    //   754: aload 21
    //   756: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   759: invokestatic 392	com/tencent/mobileqq/msf/core/o:d	()Ljava/lang/String;
    //   762: invokestatic 394	com/tencent/mobileqq/msf/core/o:f	()Ljava/lang/String;
    //   765: invokestatic 396	com/tencent/mobileqq/msf/core/o:g	()Ljava/lang/String;
    //   768: ldc_w 398
    //   771: aload 18
    //   773: aload_0
    //   774: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   777: invokevirtual 400	com/tencent/mobileqq/msf/core/ac:e	()[B
    //   780: aload 21
    //   782: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   785: aload_0
    //   786: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   789: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   792: invokevirtual 406	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   795: aload 21
    //   797: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   800: iconst_0
    //   801: iload_1
    //   802: aload 21
    //   804: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   807: iconst_0
    //   808: invokestatic 410	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   811: astore 16
    //   813: goto +170 -> 983
    //   816: aload 14
    //   818: astore 17
    //   820: sipush 595
    //   823: invokestatic 378	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   826: if_icmpeq +90 -> 916
    //   829: aload 14
    //   831: astore 17
    //   833: sipush 600
    //   836: invokestatic 378	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   839: if_icmpne +6 -> 845
    //   842: goto +74 -> 916
    //   845: aload 14
    //   847: astore 17
    //   849: aload 21
    //   851: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   854: invokestatic 392	com/tencent/mobileqq/msf/core/o:d	()Ljava/lang/String;
    //   857: invokestatic 394	com/tencent/mobileqq/msf/core/o:f	()Ljava/lang/String;
    //   860: invokestatic 396	com/tencent/mobileqq/msf/core/o:g	()Ljava/lang/String;
    //   863: ldc_w 398
    //   866: aload 18
    //   868: aload_0
    //   869: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   872: invokevirtual 400	com/tencent/mobileqq/msf/core/ac:e	()[B
    //   875: aload 21
    //   877: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   880: aload_0
    //   881: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   884: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   887: invokevirtual 406	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   890: aload 21
    //   892: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   895: iconst_0
    //   896: iload_1
    //   897: iload_2
    //   898: aload 20
    //   900: aload 22
    //   902: aload 21
    //   904: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   907: iconst_0
    //   908: invokestatic 413	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[B[BZ)[B
    //   911: astore 16
    //   913: goto +70 -> 983
    //   916: aload 14
    //   918: astore 17
    //   920: aload 21
    //   922: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   925: invokestatic 392	com/tencent/mobileqq/msf/core/o:d	()Ljava/lang/String;
    //   928: invokestatic 394	com/tencent/mobileqq/msf/core/o:f	()Ljava/lang/String;
    //   931: invokestatic 396	com/tencent/mobileqq/msf/core/o:g	()Ljava/lang/String;
    //   934: ldc_w 398
    //   937: aload 18
    //   939: aload_0
    //   940: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   943: invokevirtual 400	com/tencent/mobileqq/msf/core/ac:e	()[B
    //   946: aload 21
    //   948: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   951: aload_0
    //   952: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   955: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   958: invokevirtual 406	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   961: aload 21
    //   963: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   966: iconst_0
    //   967: iload_1
    //   968: aload 20
    //   970: aload 22
    //   972: aload 21
    //   974: invokevirtual 253	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   977: iconst_0
    //   978: invokestatic 416	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[B[BZ)[B
    //   981: astore 16
    //   983: aload 16
    //   985: ifnull +25 -> 1010
    //   988: aload 14
    //   990: astore 17
    //   992: aload 21
    //   994: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   997: ldc_w 422
    //   1000: aload 16
    //   1002: arraylength
    //   1003: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1006: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1009: pop
    //   1010: aload 14
    //   1012: astore 17
    //   1014: new 71	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1021: astore 20
    //   1023: aload 14
    //   1025: astore 17
    //   1027: aload 20
    //   1029: ldc_w 429
    //   1032: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 14
    //   1038: astore 17
    //   1040: aload 20
    //   1042: aload 21
    //   1044: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1047: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 14
    //   1053: astore 17
    //   1055: ldc 85
    //   1057: iconst_1
    //   1058: aload 20
    //   1060: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: aload 21
    //   1068: ifnull +39 -> 1107
    //   1071: aload 14
    //   1073: astore 17
    //   1075: aload 21
    //   1077: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1080: ifne +27 -> 1107
    //   1083: aload 14
    //   1085: astore 17
    //   1087: getstatic 432	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1090: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   1093: iconst_1
    //   1094: aload 21
    //   1096: aconst_null
    //   1097: invokevirtual 435	com/tencent/mobileqq/msf/core/c/j:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1100: aload 16
    //   1102: astore 20
    //   1104: goto +20 -> 1124
    //   1107: aload 16
    //   1109: astore 20
    //   1111: goto +13 -> 1124
    //   1114: astore 16
    //   1116: goto +1787 -> 2903
    //   1119: iconst_0
    //   1120: newarray byte
    //   1122: astore 20
    //   1124: aload 20
    //   1126: ifnonnull +128 -> 1254
    //   1129: aload 14
    //   1131: astore 17
    //   1133: new 71	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1140: astore 16
    //   1142: aload 14
    //   1144: astore 17
    //   1146: aload 16
    //   1148: ldc_w 437
    //   1151: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload 14
    //   1157: astore 17
    //   1159: aload 16
    //   1161: aload 21
    //   1163: invokevirtual 440	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
    //   1166: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: pop
    //   1170: aload 14
    //   1172: astore 17
    //   1174: ldc 85
    //   1176: iconst_1
    //   1177: aload 16
    //   1179: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: invokestatic 443	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: aload 14
    //   1187: astore 17
    //   1189: aload_0
    //   1190: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1193: aload 21
    //   1195: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1198: invokevirtual 124	com/tencent/mobileqq/msf/core/ac:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   1201: pop
    //   1202: aload_0
    //   1203: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1206: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1209: ifnull +33 -> 1242
    //   1212: aload_0
    //   1213: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1216: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1219: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1222: ifnull +20 -> 1242
    //   1225: aload_0
    //   1226: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1229: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1232: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1235: iconst_1
    //   1236: invokeinterface 446 2 0
    //   1241: pop
    //   1242: goto -1234 -> 8
    //   1245: astore 16
    //   1247: aload 17
    //   1249: astore 14
    //   1251: goto -135 -> 1116
    //   1254: aload 14
    //   1256: astore 16
    //   1258: aload 21
    //   1260: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   1263: ldc_w 448
    //   1266: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1269: istore 12
    //   1271: iload 12
    //   1273: ifne +71 -> 1344
    //   1276: aload 14
    //   1278: astore 17
    //   1280: aload 21
    //   1282: ldc_w 453
    //   1285: iconst_0
    //   1286: invokestatic 458	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1289: invokevirtual 231	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1292: checkcast 455	java/lang/Boolean
    //   1295: invokevirtual 461	java/lang/Boolean:booleanValue	()Z
    //   1298: ifne +46 -> 1344
    //   1301: aload 14
    //   1303: astore 17
    //   1305: aload 21
    //   1307: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1310: iconst_m1
    //   1311: if_icmpeq +33 -> 1344
    //   1314: aload 14
    //   1316: astore 17
    //   1318: aload 21
    //   1320: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1323: bipush 100
    //   1325: if_icmpeq +19 -> 1344
    //   1328: aload 14
    //   1330: astore 17
    //   1332: aload_0
    //   1333: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1336: aload 21
    //   1338: invokestatic 464	com/tencent/mobileqq/msf/core/ac:b	(Lcom/tencent/mobileqq/msf/core/ac;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1341: goto +3 -> 1344
    //   1344: iconst_0
    //   1345: istore 12
    //   1347: iload 12
    //   1349: ifne +1536 -> 2885
    //   1352: aload 14
    //   1354: astore 16
    //   1356: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   1359: lstore 8
    //   1361: aload 14
    //   1363: astore 16
    //   1365: aload 21
    //   1367: invokevirtual 467	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   1370: lstore 10
    //   1372: lload 8
    //   1374: lload 6
    //   1376: lsub
    //   1377: lload 10
    //   1379: lcmp
    //   1380: ifle +69 -> 1449
    //   1383: aload 14
    //   1385: astore 17
    //   1387: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1390: ifeq +1495 -> 2885
    //   1393: aload 14
    //   1395: astore 17
    //   1397: new 71	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1404: astore 16
    //   1406: aload 14
    //   1408: astore 17
    //   1410: aload 16
    //   1412: aload 21
    //   1414: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 14
    //   1420: astore 17
    //   1422: aload 16
    //   1424: ldc_w 469
    //   1427: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 14
    //   1433: astore 17
    //   1435: ldc 85
    //   1437: iconst_2
    //   1438: aload 16
    //   1440: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: goto +1439 -> 2885
    //   1449: aload 14
    //   1451: astore 16
    //   1453: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1456: lstore 10
    //   1458: lload 10
    //   1460: lconst_0
    //   1461: lcmp
    //   1462: ifeq +189 -> 1651
    //   1465: aload 14
    //   1467: astore 17
    //   1469: lload 8
    //   1471: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1474: lsub
    //   1475: invokestatic 475	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1478: i2l
    //   1479: lcmp
    //   1480: ifle +171 -> 1651
    //   1483: aload 14
    //   1485: astore 17
    //   1487: aload_0
    //   1488: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1491: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1494: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1497: ifeq +154 -> 1651
    //   1500: aload 14
    //   1502: astore 17
    //   1504: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1507: aload_0
    //   1508: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1511: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1514: invokevirtual 351	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1517: invokevirtual 477	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1520: lcmp
    //   1521: iflt +122 -> 1643
    //   1524: aload 14
    //   1526: astore 17
    //   1528: lconst_0
    //   1529: putstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1532: aload 14
    //   1534: astore 17
    //   1536: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1539: ifeq +87 -> 1626
    //   1542: aload 14
    //   1544: astore 17
    //   1546: new 71	java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1553: astore 16
    //   1555: aload 14
    //   1557: astore 17
    //   1559: aload 16
    //   1561: ldc_w 479
    //   1564: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload 14
    //   1570: astore 17
    //   1572: aload 16
    //   1574: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   1577: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1580: lsub
    //   1581: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload 14
    //   1587: astore 17
    //   1589: aload 16
    //   1591: ldc_w 484
    //   1594: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: pop
    //   1598: aload 14
    //   1600: astore 17
    //   1602: aload 16
    //   1604: invokestatic 475	com/tencent/mobileqq/msf/core/a/a:R	()I
    //   1607: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1610: pop
    //   1611: aload 14
    //   1613: astore 17
    //   1615: ldc 85
    //   1617: iconst_2
    //   1618: aload 16
    //   1620: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1623: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1626: aload 14
    //   1628: astore 17
    //   1630: aload_0
    //   1631: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1634: getstatic 489	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
    //   1637: invokevirtual 492	com/tencent/mobileqq/msf/core/ac:a	(Lcom/tencent/qphone/base/a;)V
    //   1640: goto +11 -> 1651
    //   1643: aload 14
    //   1645: astore 17
    //   1647: lconst_0
    //   1648: putstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1651: aload 14
    //   1653: astore 16
    //   1655: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1658: lstore 10
    //   1660: lload 10
    //   1662: lconst_0
    //   1663: lcmp
    //   1664: ifeq +113 -> 1777
    //   1667: aload 14
    //   1669: astore 17
    //   1671: lload 8
    //   1673: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1676: lsub
    //   1677: ldc2_w 493
    //   1680: lcmp
    //   1681: ifle +96 -> 1777
    //   1684: aload 14
    //   1686: astore 17
    //   1688: aload_0
    //   1689: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1692: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1695: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1698: ifeq +79 -> 1777
    //   1701: aload 14
    //   1703: astore 17
    //   1705: getstatic 472	com/tencent/mobileqq/msf/core/ac:U	J
    //   1708: aload_0
    //   1709: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1712: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1715: invokevirtual 351	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1718: invokevirtual 477	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1721: lcmp
    //   1722: iflt +55 -> 1777
    //   1725: aload 14
    //   1727: astore 17
    //   1729: aload_0
    //   1730: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1733: getfield 498	com/tencent/mobileqq/msf/core/ac:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1736: invokevirtual 503	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1739: ifne +38 -> 1777
    //   1742: aload 14
    //   1744: astore 17
    //   1746: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1749: ifeq +16 -> 1765
    //   1752: aload 14
    //   1754: astore 17
    //   1756: ldc 85
    //   1758: iconst_2
    //   1759: ldc_w 505
    //   1762: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1765: aload 14
    //   1767: astore 17
    //   1769: aload_0
    //   1770: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1773: iconst_0
    //   1774: invokestatic 508	com/tencent/mobileqq/msf/core/ac:b	(Lcom/tencent/mobileqq/msf/core/ac;Z)V
    //   1777: aload 14
    //   1779: astore 16
    //   1781: aload_0
    //   1782: aload 21
    //   1784: invokespecial 510	com/tencent/mobileqq/msf/core/ac$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   1787: aload 21
    //   1789: ldc_w 512
    //   1792: invokestatic 517	android/os/SystemClock:elapsedRealtime	()J
    //   1795: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1798: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1801: pop
    //   1802: aload 21
    //   1804: ldc_w 522
    //   1807: lconst_0
    //   1808: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1811: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1814: pop
    //   1815: aload 21
    //   1817: ldc_w 524
    //   1820: getstatic 528	com/tencent/mobileqq/msf/core/ac:E	Ljava/lang/String;
    //   1823: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1826: pop
    //   1827: aload 21
    //   1829: ldc_w 530
    //   1832: getstatic 533	com/tencent/mobileqq/msf/core/ac:F	Ljava/lang/String;
    //   1835: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1838: pop
    //   1839: aload 21
    //   1841: ldc_w 535
    //   1844: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   1847: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1850: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1853: pop
    //   1854: aload 21
    //   1856: ldc_w 537
    //   1859: aload_0
    //   1860: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1863: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1866: invokevirtual 351	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   1869: invokevirtual 477	com/tencent/mobileqq/msf/core/net/m:e	()J
    //   1872: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1875: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1878: pop
    //   1879: aload 21
    //   1881: ldc_w 539
    //   1884: invokestatic 542	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   1887: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1890: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1893: pop
    //   1894: aload 21
    //   1896: ldc_w 544
    //   1899: aload_0
    //   1900: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1903: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1906: invokevirtual 37	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   1909: invokestatic 458	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1912: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1915: pop
    //   1916: aload_0
    //   1917: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1920: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   1923: invokestatic 547	com/tencent/mobileqq/msf/core/ac:a	(Lcom/tencent/mobileqq/msf/core/ac;J)J
    //   1926: pop2
    //   1927: aload_0
    //   1928: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1931: invokestatic 550	com/tencent/mobileqq/msf/core/ac:f	(Lcom/tencent/mobileqq/msf/core/ac;)Z
    //   1934: istore 13
    //   1936: iload 13
    //   1938: ifeq +66 -> 2004
    //   1941: aload_0
    //   1942: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1945: invokestatic 517	android/os/SystemClock:elapsedRealtime	()J
    //   1948: invokestatic 552	com/tencent/mobileqq/msf/core/ac:b	(Lcom/tencent/mobileqq/msf/core/ac;J)J
    //   1951: pop2
    //   1952: aload_0
    //   1953: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1956: iconst_0
    //   1957: invokestatic 555	com/tencent/mobileqq/msf/core/ac:c	(Lcom/tencent/mobileqq/msf/core/ac;Z)Z
    //   1960: pop
    //   1961: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1964: ifeq +40 -> 2004
    //   1967: ldc 85
    //   1969: iconst_2
    //   1970: iconst_2
    //   1971: anewarray 133	java/lang/Object
    //   1974: dup
    //   1975: iconst_0
    //   1976: ldc_w 557
    //   1979: aastore
    //   1980: dup
    //   1981: iconst_1
    //   1982: aload_0
    //   1983: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   1986: invokestatic 560	com/tencent/mobileqq/msf/core/ac:g	(Lcom/tencent/mobileqq/msf/core/ac;)J
    //   1989: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1992: aastore
    //   1993: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1996: goto +8 -> 2004
    //   1999: astore 16
    //   2001: goto +99 -> 2100
    //   2004: aload_0
    //   2005: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2008: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2011: astore 16
    //   2013: aload 21
    //   2015: invokevirtual 403	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   2018: istore_3
    //   2019: aload 21
    //   2021: invokevirtual 566	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   2024: istore 4
    //   2026: aload 21
    //   2028: invokevirtual 570	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2031: astore 17
    //   2033: aload 21
    //   2035: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2038: astore 22
    //   2040: aload 21
    //   2042: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2045: istore 5
    //   2047: aload 16
    //   2049: iload_3
    //   2050: iload 4
    //   2052: aload 18
    //   2054: aload 19
    //   2056: aload 17
    //   2058: aload 22
    //   2060: iload 5
    //   2062: aload 20
    //   2064: aload 21
    //   2066: invokevirtual 573	com/tencent/mobileqq/msf/core/net/n:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2069: istore 13
    //   2071: iload 13
    //   2073: istore 12
    //   2075: aload_0
    //   2076: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2079: invokestatic 576	android/os/SystemClock:uptimeMillis	()J
    //   2082: invokestatic 578	com/tencent/mobileqq/msf/core/ac:c	(Lcom/tencent/mobileqq/msf/core/ac;J)J
    //   2085: pop2
    //   2086: iload 13
    //   2088: istore 12
    //   2090: goto +66 -> 2156
    //   2093: astore 16
    //   2095: goto +5 -> 2100
    //   2098: astore 16
    //   2100: new 71	java/lang/StringBuilder
    //   2103: dup
    //   2104: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2107: astore 17
    //   2109: aload 17
    //   2111: ldc_w 580
    //   2114: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: pop
    //   2118: aload 17
    //   2120: aload 16
    //   2122: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2125: pop
    //   2126: ldc 85
    //   2128: iconst_1
    //   2129: aload 17
    //   2131: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2134: aload 16
    //   2136: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2139: aload_0
    //   2140: aload 21
    //   2142: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2145: aload 21
    //   2147: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2150: i2l
    //   2151: aload 16
    //   2153: invokespecial 582	com/tencent/mobileqq/msf/core/ac$c:a	(Ljava/lang/String;JLjava/lang/Throwable;)V
    //   2156: aload 14
    //   2158: astore 16
    //   2160: iload 12
    //   2162: ifne +167 -> 2329
    //   2165: aload 21
    //   2167: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2170: ldc_w 512
    //   2173: invokevirtual 583	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2176: pop
    //   2177: aload 21
    //   2179: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2182: ldc_w 522
    //   2185: invokevirtual 583	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2188: pop
    //   2189: aload 21
    //   2191: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2194: ldc_w 524
    //   2197: invokevirtual 583	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2200: pop
    //   2201: aload 21
    //   2203: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2206: ldc_w 530
    //   2209: invokevirtual 583	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2212: pop
    //   2213: aload 21
    //   2215: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2218: ldc_w 585
    //   2221: iconst_1
    //   2222: invokestatic 458	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2225: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2228: pop
    //   2229: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2232: ifeq +44 -> 2276
    //   2235: new 71	java/lang/StringBuilder
    //   2238: dup
    //   2239: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2242: astore 14
    //   2244: aload 14
    //   2246: invokestatic 589	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2249: invokevirtual 592	java/lang/Thread:getName	()Ljava/lang/String;
    //   2252: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: pop
    //   2256: aload 14
    //   2258: ldc_w 594
    //   2261: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: pop
    //   2265: ldc 85
    //   2267: iconst_2
    //   2268: aload 14
    //   2270: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2273: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2276: aload_0
    //   2277: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2280: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2283: getstatic 596	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
    //   2286: invokevirtual 597	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   2289: getstatic 602	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
    //   2292: invokestatic 606	java/lang/Thread:sleep	(J)V
    //   2295: goto +573 -> 2868
    //   2298: astore 14
    //   2300: ldc 85
    //   2302: iconst_1
    //   2303: aload 14
    //   2305: invokevirtual 607	java/lang/Exception:toString	()Ljava/lang/String;
    //   2308: aload 14
    //   2310: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2313: goto -18 -> 2295
    //   2316: astore 17
    //   2318: aload 16
    //   2320: astore 14
    //   2322: aload 17
    //   2324: astore 16
    //   2326: goto +577 -> 2903
    //   2329: aload 21
    //   2331: ldc_w 522
    //   2334: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   2337: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2340: invokevirtual 520	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2343: pop
    //   2344: aload 16
    //   2346: astore 14
    //   2348: aload 14
    //   2350: aload 18
    //   2352: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2355: istore 13
    //   2357: iload 13
    //   2359: ifeq +1319 -> 3678
    //   2362: aload 21
    //   2364: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2367: ldc_w 609
    //   2370: invokevirtual 611	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2373: checkcast 424	java/lang/Integer
    //   2376: invokevirtual 614	java/lang/Integer:intValue	()I
    //   2379: istore_3
    //   2380: aload 21
    //   2382: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2385: ldc_w 616
    //   2388: invokevirtual 611	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2391: checkcast 424	java/lang/Integer
    //   2394: invokevirtual 614	java/lang/Integer:intValue	()I
    //   2397: istore 5
    //   2399: iload_3
    //   2400: istore 4
    //   2402: iload 5
    //   2404: istore_3
    //   2405: goto +25 -> 2430
    //   2408: astore 17
    //   2410: goto +7 -> 2417
    //   2413: astore 17
    //   2415: iconst_0
    //   2416: istore_3
    //   2417: aload 17
    //   2419: invokevirtual 619	java/lang/Exception:printStackTrace	()V
    //   2422: iload_3
    //   2423: istore 4
    //   2425: iconst_0
    //   2426: istore_3
    //   2427: goto +3 -> 2430
    //   2430: aload 14
    //   2432: aload 18
    //   2434: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2437: ifne +1249 -> 3686
    //   2440: aload 21
    //   2442: invokevirtual 622	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
    //   2445: ifne +1241 -> 3686
    //   2448: iconst_1
    //   2449: istore_3
    //   2450: goto +3 -> 2453
    //   2453: aload 18
    //   2455: aload 21
    //   2457: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2460: aload 20
    //   2462: arraylength
    //   2463: i2l
    //   2464: iload 4
    //   2466: iload_3
    //   2467: invokestatic 627	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
    //   2470: aload 21
    //   2472: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2475: ifnull +295 -> 2770
    //   2478: aload 21
    //   2480: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2483: invokevirtual 214	java/lang/String:length	()I
    //   2486: iconst_4
    //   2487: if_icmple +283 -> 2770
    //   2490: aload 21
    //   2492: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2495: ldc_w 629
    //   2498: invokevirtual 633	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2501: ifne +269 -> 2770
    //   2504: aload 21
    //   2506: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2509: ldc_w 635
    //   2512: invokevirtual 633	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2515: ifne +255 -> 2770
    //   2518: aload 21
    //   2520: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2523: ldc_w 637
    //   2526: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2529: ifne +241 -> 2770
    //   2532: aload 21
    //   2534: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2537: ldc_w 639
    //   2540: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2543: ifne +227 -> 2770
    //   2546: aload 21
    //   2548: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2551: ldc_w 641
    //   2554: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2557: ifne +213 -> 2770
    //   2560: aload 21
    //   2562: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2565: ldc_w 643
    //   2568: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2571: ifne +199 -> 2770
    //   2574: aload 21
    //   2576: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2579: ldc_w 645
    //   2582: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2585: ifne +185 -> 2770
    //   2588: aload 21
    //   2590: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2593: ldc_w 647
    //   2596: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2599: ifne +171 -> 2770
    //   2602: aload 21
    //   2604: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2607: ldc_w 649
    //   2610: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2613: ifne +157 -> 2770
    //   2616: aload 21
    //   2618: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2621: ldc_w 651
    //   2624: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2627: ifne +143 -> 2770
    //   2630: getstatic 655	com/tencent/mobileqq/msf/core/ac:af	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   2633: aload 21
    //   2635: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2638: invokevirtual 658	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
    //   2641: ifne +129 -> 2770
    //   2644: getstatic 661	com/tencent/mobileqq/msf/core/ac:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2647: aload 21
    //   2649: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2652: invokevirtual 662	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2655: ifnonnull +26 -> 2681
    //   2658: new 664	java/util/concurrent/ConcurrentLinkedQueue
    //   2661: dup
    //   2662: invokespecial 665	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
    //   2665: astore 17
    //   2667: getstatic 661	com/tencent/mobileqq/msf/core/ac:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2670: aload 21
    //   2672: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2675: aload 17
    //   2677: invokevirtual 666	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2680: pop
    //   2681: getstatic 661	com/tencent/mobileqq/msf/core/ac:t	Ljava/util/concurrent/ConcurrentHashMap;
    //   2684: aload 21
    //   2686: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2689: invokevirtual 662	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2692: checkcast 664	java/util/concurrent/ConcurrentLinkedQueue
    //   2695: aload 21
    //   2697: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2700: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2703: invokevirtual 669	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
    //   2706: pop
    //   2707: new 71	java/lang/StringBuilder
    //   2710: dup
    //   2711: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2714: astore 17
    //   2716: aload 17
    //   2718: ldc_w 671
    //   2721: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2724: pop
    //   2725: aload 17
    //   2727: aload 21
    //   2729: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2732: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2735: pop
    //   2736: aload 17
    //   2738: ldc_w 673
    //   2741: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: pop
    //   2745: aload 17
    //   2747: aload 21
    //   2749: invokevirtual 303	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   2752: invokestatic 331	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2755: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2758: pop
    //   2759: ldc 85
    //   2761: iconst_1
    //   2762: aload 17
    //   2764: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2767: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2770: aload 21
    //   2772: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   2775: ldc_w 675
    //   2778: invokevirtual 633	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2781: ifeq +9 -> 2790
    //   2784: invokestatic 517	android/os/SystemClock:elapsedRealtime	()J
    //   2787: putstatic 677	com/tencent/mobileqq/msf/core/ac:J	J
    //   2790: aload_0
    //   2791: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2794: getfield 680	com/tencent/mobileqq/msf/core/ac:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2797: invokevirtual 503	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2800: ifeq -505 -> 2295
    //   2803: aload_0
    //   2804: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2807: getfield 683	com/tencent/mobileqq/msf/core/ac:aa	I
    //   2810: iconst_m1
    //   2811: if_icmpne +57 -> 2868
    //   2814: aload_0
    //   2815: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2818: aload 21
    //   2820: invokevirtual 120	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2823: putfield 683	com/tencent/mobileqq/msf/core/ac:aa	I
    //   2826: new 71	java/lang/StringBuilder
    //   2829: dup
    //   2830: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2833: astore 17
    //   2835: aload 17
    //   2837: ldc_w 685
    //   2840: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: pop
    //   2844: aload 17
    //   2846: aload_0
    //   2847: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2850: getfield 683	com/tencent/mobileqq/msf/core/ac:aa	I
    //   2853: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2856: pop
    //   2857: ldc 85
    //   2859: iconst_1
    //   2860: aload 17
    //   2862: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2865: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2868: aload 16
    //   2870: astore 14
    //   2872: goto -1525 -> 1347
    //   2875: astore 16
    //   2877: goto +26 -> 2903
    //   2880: astore 16
    //   2882: goto +21 -> 2903
    //   2885: goto +82 -> 2967
    //   2888: astore 17
    //   2890: aload 16
    //   2892: astore 14
    //   2894: goto +5 -> 2899
    //   2897: astore 17
    //   2899: aload 17
    //   2901: astore 16
    //   2903: aload 14
    //   2905: astore 17
    //   2907: ldc 85
    //   2909: iconst_1
    //   2910: aload 16
    //   2912: invokevirtual 686	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2915: aload 16
    //   2917: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2920: aload 14
    //   2922: astore 17
    //   2924: aload_0
    //   2925: aload 21
    //   2927: ldc_w 688
    //   2930: aload 16
    //   2932: invokevirtual 686	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2935: invokespecial 690	com/tencent/mobileqq/msf/core/ac$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2938: aload 14
    //   2940: astore 17
    //   2942: aload_0
    //   2943: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2946: getfield 186	com/tencent/mobileqq/msf/core/ac:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   2949: aload 21
    //   2951: invokevirtual 692	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
    //   2954: pop
    //   2955: aload 14
    //   2957: astore 17
    //   2959: aload_0
    //   2960: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   2963: invokestatic 695	com/tencent/mobileqq/msf/core/ac:h	(Lcom/tencent/mobileqq/msf/core/ac;)J
    //   2966: pop2
    //   2967: aload 15
    //   2969: astore 16
    //   2971: iconst_0
    //   2972: istore 12
    //   2974: aload 14
    //   2976: astore 17
    //   2978: aload 21
    //   2980: invokevirtual 570	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2983: astore 18
    //   2985: aload 14
    //   2987: astore 17
    //   2989: getstatic 701	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2992: astore 19
    //   2994: aload 18
    //   2996: aload 19
    //   2998: if_acmpne +691 -> 3689
    //   3001: aload 14
    //   3003: astore 17
    //   3005: aload 21
    //   3007: aload 21
    //   3009: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   3012: invokevirtual 704	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   3015: checkcast 706	com/tencent/qphone/base/remote/FromServiceMsg
    //   3018: astore 20
    //   3020: aload 14
    //   3022: astore 17
    //   3024: new 71	java/lang/StringBuilder
    //   3027: dup
    //   3028: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   3031: astore 18
    //   3033: aload 14
    //   3035: astore 17
    //   3037: aload 18
    //   3039: invokestatic 589	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3042: invokevirtual 592	java/lang/Thread:getName	()Ljava/lang/String;
    //   3045: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3048: pop
    //   3049: aload 14
    //   3051: astore 17
    //   3053: aload 18
    //   3055: ldc_w 708
    //   3058: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: pop
    //   3062: aload 14
    //   3064: astore 17
    //   3066: aload 18
    //   3068: aload 20
    //   3070: invokevirtual 709	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   3073: invokestatic 331	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   3076: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: pop
    //   3080: aload 14
    //   3082: astore 17
    //   3084: ldc 85
    //   3086: iconst_1
    //   3087: aload 18
    //   3089: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3092: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3095: aload 14
    //   3097: astore 17
    //   3099: aload_0
    //   3100: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3103: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3106: invokevirtual 313	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   3109: aload 20
    //   3111: invokevirtual 709	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   3114: invokevirtual 712	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
    //   3117: aload 14
    //   3119: astore 17
    //   3121: aload 20
    //   3123: sipush 2012
    //   3126: aload 20
    //   3128: invokevirtual 715	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   3131: invokevirtual 719	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   3134: aload 14
    //   3136: astore 17
    //   3138: aload 21
    //   3140: invokevirtual 420	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   3143: astore 22
    //   3145: aload 16
    //   3147: astore 19
    //   3149: aload 14
    //   3151: astore 18
    //   3153: aload 19
    //   3155: astore 17
    //   3157: aload 22
    //   3159: aload 19
    //   3161: invokevirtual 720	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   3164: ifeq +26 -> 3190
    //   3167: aload 14
    //   3169: astore 18
    //   3171: aload 19
    //   3173: astore 17
    //   3175: aload 21
    //   3177: aload 19
    //   3179: invokevirtual 704	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   3182: checkcast 455	java/lang/Boolean
    //   3185: invokevirtual 461	java/lang/Boolean:booleanValue	()Z
    //   3188: istore 12
    //   3190: aload 14
    //   3192: astore 18
    //   3194: aload 19
    //   3196: astore 17
    //   3198: aload 20
    //   3200: aload 19
    //   3202: iload 12
    //   3204: invokestatic 458	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3207: invokevirtual 721	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3210: pop
    //   3211: aload 14
    //   3213: astore 18
    //   3215: aload 19
    //   3217: astore 17
    //   3219: ldc_w 723
    //   3222: aload 20
    //   3224: invokestatic 727	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   3227: aload 14
    //   3229: astore 18
    //   3231: aload 19
    //   3233: astore 17
    //   3235: aload_0
    //   3236: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3239: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3242: aconst_null
    //   3243: aload 20
    //   3245: invokevirtual 731	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   3248: aload 14
    //   3250: astore 18
    //   3252: aload 19
    //   3254: astore 17
    //   3256: aload_0
    //   3257: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3260: getfield 33	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   3263: getstatic 733	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
    //   3266: invokevirtual 597	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   3269: aload 14
    //   3271: astore 15
    //   3273: aload 19
    //   3275: astore 14
    //   3277: goto +93 -> 3370
    //   3280: astore 15
    //   3282: goto +5 -> 3287
    //   3285: astore 15
    //   3287: aload 14
    //   3289: astore 18
    //   3291: aload 16
    //   3293: astore 17
    //   3295: new 71	java/lang/StringBuilder
    //   3298: dup
    //   3299: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   3302: astore 19
    //   3304: aload 14
    //   3306: astore 18
    //   3308: aload 16
    //   3310: astore 17
    //   3312: aload 19
    //   3314: ldc_w 735
    //   3317: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3320: pop
    //   3321: aload 14
    //   3323: astore 18
    //   3325: aload 16
    //   3327: astore 17
    //   3329: aload 19
    //   3331: aload 15
    //   3333: invokevirtual 607	java/lang/Exception:toString	()Ljava/lang/String;
    //   3336: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: pop
    //   3340: aload 14
    //   3342: astore 18
    //   3344: aload 16
    //   3346: astore 17
    //   3348: ldc 85
    //   3350: iconst_1
    //   3351: aload 19
    //   3353: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3356: invokestatic 737	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3359: aload 14
    //   3361: astore 15
    //   3363: aload 16
    //   3365: astore 14
    //   3367: goto +3 -> 3370
    //   3370: aload 15
    //   3372: astore 18
    //   3374: aload 14
    //   3376: astore 17
    //   3378: aload_0
    //   3379: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3382: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3385: ifnull +49 -> 3434
    //   3388: aload 15
    //   3390: astore 18
    //   3392: aload 14
    //   3394: astore 17
    //   3396: aload_0
    //   3397: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3400: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3403: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3406: ifnull +28 -> 3434
    //   3409: aload 15
    //   3411: astore 18
    //   3413: aload 14
    //   3415: astore 17
    //   3417: aload_0
    //   3418: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3421: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3424: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3427: iconst_1
    //   3428: invokeinterface 446 2 0
    //   3433: pop
    //   3434: aload 15
    //   3436: astore 18
    //   3438: aload 14
    //   3440: astore 17
    //   3442: ldc2_w 738
    //   3445: invokestatic 606	java/lang/Thread:sleep	(J)V
    //   3448: aload 15
    //   3450: astore 16
    //   3452: aload 14
    //   3454: astore 17
    //   3456: aload_0
    //   3457: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3460: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3463: ifnull +132 -> 3595
    //   3466: aload 15
    //   3468: astore 16
    //   3470: aload 14
    //   3472: astore 17
    //   3474: aload_0
    //   3475: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3478: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3481: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3484: ifnull +111 -> 3595
    //   3487: aload 14
    //   3489: astore 17
    //   3491: goto +83 -> 3574
    //   3494: astore 16
    //   3496: aload 18
    //   3498: astore 14
    //   3500: aload 17
    //   3502: astore 15
    //   3504: goto +10 -> 3514
    //   3507: astore 14
    //   3509: goto +97 -> 3606
    //   3512: astore 16
    //   3514: ldc 85
    //   3516: iconst_1
    //   3517: aload 16
    //   3519: invokevirtual 686	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3522: aload 16
    //   3524: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3527: aload 14
    //   3529: astore 16
    //   3531: aload 15
    //   3533: astore 17
    //   3535: aload_0
    //   3536: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3539: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3542: ifnull +53 -> 3595
    //   3545: aload 14
    //   3547: astore 16
    //   3549: aload 15
    //   3551: astore 17
    //   3553: aload_0
    //   3554: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3557: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3560: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3563: ifnull +32 -> 3595
    //   3566: aload 15
    //   3568: astore 17
    //   3570: aload 14
    //   3572: astore 15
    //   3574: aload_0
    //   3575: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3578: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3581: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3584: iconst_1
    //   3585: invokeinterface 446 2 0
    //   3590: pop
    //   3591: aload 15
    //   3593: astore 16
    //   3595: aload 17
    //   3597: astore 15
    //   3599: aload 16
    //   3601: astore 14
    //   3603: goto -3595 -> 8
    //   3606: aload_0
    //   3607: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3610: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3613: ifnull +33 -> 3646
    //   3616: aload_0
    //   3617: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3620: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3623: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3626: ifnull +20 -> 3646
    //   3629: aload_0
    //   3630: getfield 12	com/tencent/mobileqq/msf/core/ac$c:b	Lcom/tencent/mobileqq/msf/core/ac;
    //   3633: getfield 41	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3636: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   3639: iconst_1
    //   3640: invokeinterface 446 2 0
    //   3645: pop
    //   3646: goto +6 -> 3652
    //   3649: aload 14
    //   3651: athrow
    //   3652: goto -3 -> 3649
    //   3655: aconst_null
    //   3656: astore 19
    //   3658: goto -3515 -> 143
    //   3661: iload_3
    //   3662: i2b
    //   3663: istore_2
    //   3664: goto -3338 -> 326
    //   3667: iload_3
    //   3668: bipush 251
    //   3670: iand
    //   3671: istore_3
    //   3672: goto -11 -> 3661
    //   3675: goto -3038 -> 637
    //   3678: iconst_0
    //   3679: istore_3
    //   3680: iconst_0
    //   3681: istore 4
    //   3683: goto -1253 -> 2430
    //   3686: goto -1233 -> 2453
    //   3689: aload 14
    //   3691: astore 15
    //   3693: aload 16
    //   3695: astore 14
    //   3697: goto -327 -> 3370
    //   3700: astore 16
    //   3702: aload 17
    //   3704: astore 14
    //   3706: goto -192 -> 3514
    //   3709: aload 15
    //   3711: astore 16
    //   3713: aload 14
    //   3715: astore 15
    //   3717: aload 16
    //   3719: astore 14
    //   3721: goto -351 -> 3370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3724	0	this	c
    //   199	769	1	i	int
    //   897	2767	2	b1	byte
    //   82	3598	3	j	int
    //   2024	1658	4	k	int
    //   2045	358	5	m	int
    //   160	1215	6	l1	long
    //   165	1507	8	l2	long
    //   1370	291	10	l3	long
    //   337	2866	12	bool1	boolean
    //   1934	424	13	bool2	boolean
    //   2	2267	14	localObject1	Object
    //   2298	11	14	localException1	java.lang.Exception
    //   2320	1179	14	localObject2	Object
    //   3507	64	14	localObject3	Object
    //   3601	119	14	localObject4	Object
    //   6	3266	15	localObject5	Object
    //   3280	1	15	localException2	java.lang.Exception
    //   3285	47	15	localException3	java.lang.Exception
    //   3361	355	15	localObject6	Object
    //   95	97	16	localObject7	Object
    //   243	23	16	localException4	java.lang.Exception
    //   381	247	16	localObject8	Object
    //   715	1	16	localException5	java.lang.Exception
    //   720	13	16	localException6	java.lang.Exception
    //   811	297	16	arrayOfByte	byte[]
    //   1114	1	16	localThrowable1	Throwable
    //   1140	38	16	localStringBuilder	StringBuilder
    //   1245	1	16	localThrowable2	Throwable
    //   1256	524	16	localObject9	Object
    //   1999	1	16	localThrowable3	Throwable
    //   2011	37	16	localn	n
    //   2093	1	16	localThrowable4	Throwable
    //   2098	54	16	localThrowable5	Throwable
    //   2158	711	16	localObject10	Object
    //   2875	1	16	localThrowable6	Throwable
    //   2880	11	16	localThrowable7	Throwable
    //   2901	568	16	localObject11	Object
    //   3494	1	16	localThrowable8	Throwable
    //   3512	11	16	localThrowable9	Throwable
    //   3529	165	16	localObject12	Object
    //   3700	1	16	localThrowable10	Throwable
    //   3711	7	16	localObject13	Object
    //   252	1878	17	localObject14	Object
    //   2316	7	17	localThrowable11	Throwable
    //   2408	1	17	localException7	java.lang.Exception
    //   2413	5	17	localException8	java.lang.Exception
    //   2665	196	17	localObject15	Object
    //   2888	1	17	localThrowable12	Throwable
    //   2897	3	17	localThrowable13	Throwable
    //   2905	798	17	localObject16	Object
    //   73	3424	18	localObject17	Object
    //   129	3528	19	localObject18	Object
    //   545	2699	20	localObject19	Object
    //   21	3155	21	localToServiceMsg	ToServiceMsg
    //   553	2605	22	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   233	240	243	java/lang/Exception
    //   576	590	715	java/lang/Exception
    //   594	607	715	java/lang/Exception
    //   611	634	715	java/lang/Exception
    //   641	647	715	java/lang/Exception
    //   651	660	715	java/lang/Exception
    //   664	677	715	java/lang/Exception
    //   681	703	715	java/lang/Exception
    //   707	712	715	java/lang/Exception
    //   555	572	720	java/lang/Exception
    //   196	200	1114	java/lang/Throwable
    //   282	286	1114	java/lang/Throwable
    //   307	319	1114	java/lang/Throwable
    //   326	339	1114	java/lang/Throwable
    //   437	449	1114	java/lang/Throwable
    //   466	483	1114	java/lang/Throwable
    //   497	512	1114	java/lang/Throwable
    //   539	555	1114	java/lang/Throwable
    //   555	572	1114	java/lang/Throwable
    //   576	590	1245	java/lang/Throwable
    //   594	607	1245	java/lang/Throwable
    //   611	634	1245	java/lang/Throwable
    //   641	647	1245	java/lang/Throwable
    //   651	660	1245	java/lang/Throwable
    //   664	677	1245	java/lang/Throwable
    //   681	703	1245	java/lang/Throwable
    //   707	712	1245	java/lang/Throwable
    //   726	737	1245	java/lang/Throwable
    //   741	750	1245	java/lang/Throwable
    //   754	813	1245	java/lang/Throwable
    //   820	829	1245	java/lang/Throwable
    //   833	842	1245	java/lang/Throwable
    //   849	913	1245	java/lang/Throwable
    //   920	983	1245	java/lang/Throwable
    //   992	1010	1245	java/lang/Throwable
    //   1014	1023	1245	java/lang/Throwable
    //   1027	1036	1245	java/lang/Throwable
    //   1040	1051	1245	java/lang/Throwable
    //   1055	1066	1245	java/lang/Throwable
    //   1075	1083	1245	java/lang/Throwable
    //   1087	1100	1245	java/lang/Throwable
    //   1133	1142	1245	java/lang/Throwable
    //   1146	1155	1245	java/lang/Throwable
    //   1159	1170	1245	java/lang/Throwable
    //   1174	1185	1245	java/lang/Throwable
    //   1189	1202	1245	java/lang/Throwable
    //   1280	1301	1245	java/lang/Throwable
    //   1305	1314	1245	java/lang/Throwable
    //   1318	1328	1245	java/lang/Throwable
    //   1332	1341	1245	java/lang/Throwable
    //   1387	1393	1245	java/lang/Throwable
    //   1397	1406	1245	java/lang/Throwable
    //   1410	1418	1245	java/lang/Throwable
    //   1422	1431	1245	java/lang/Throwable
    //   1435	1446	1245	java/lang/Throwable
    //   1469	1483	1245	java/lang/Throwable
    //   1487	1500	1245	java/lang/Throwable
    //   1504	1524	1245	java/lang/Throwable
    //   1528	1532	1245	java/lang/Throwable
    //   1536	1542	1245	java/lang/Throwable
    //   1546	1555	1245	java/lang/Throwable
    //   1559	1568	1245	java/lang/Throwable
    //   1572	1585	1245	java/lang/Throwable
    //   1589	1598	1245	java/lang/Throwable
    //   1602	1611	1245	java/lang/Throwable
    //   1615	1626	1245	java/lang/Throwable
    //   1630	1640	1245	java/lang/Throwable
    //   1647	1651	1245	java/lang/Throwable
    //   1671	1684	1245	java/lang/Throwable
    //   1688	1701	1245	java/lang/Throwable
    //   1705	1725	1245	java/lang/Throwable
    //   1729	1742	1245	java/lang/Throwable
    //   1746	1752	1245	java/lang/Throwable
    //   1756	1765	1245	java/lang/Throwable
    //   1769	1777	1245	java/lang/Throwable
    //   1941	1996	1999	java/lang/Throwable
    //   2047	2071	2093	java/lang/Throwable
    //   2075	2086	2093	java/lang/Throwable
    //   1787	1936	2098	java/lang/Throwable
    //   2004	2047	2098	java/lang/Throwable
    //   2289	2295	2298	java/lang/Exception
    //   2165	2276	2316	java/lang/Throwable
    //   2276	2289	2316	java/lang/Throwable
    //   2289	2295	2316	java/lang/Throwable
    //   2300	2313	2316	java/lang/Throwable
    //   2380	2399	2408	java/lang/Exception
    //   2362	2380	2413	java/lang/Exception
    //   2348	2357	2875	java/lang/Throwable
    //   2362	2380	2875	java/lang/Throwable
    //   2380	2399	2875	java/lang/Throwable
    //   2417	2422	2875	java/lang/Throwable
    //   2430	2448	2875	java/lang/Throwable
    //   2453	2681	2875	java/lang/Throwable
    //   2681	2770	2875	java/lang/Throwable
    //   2770	2790	2875	java/lang/Throwable
    //   2790	2868	2875	java/lang/Throwable
    //   2100	2156	2880	java/lang/Throwable
    //   2329	2344	2880	java/lang/Throwable
    //   1258	1271	2888	java/lang/Throwable
    //   1356	1361	2888	java/lang/Throwable
    //   1365	1372	2888	java/lang/Throwable
    //   1453	1458	2888	java/lang/Throwable
    //   1655	1660	2888	java/lang/Throwable
    //   1781	1787	2888	java/lang/Throwable
    //   68	83	2897	java/lang/Throwable
    //   88	140	2897	java/lang/Throwable
    //   143	191	2897	java/lang/Throwable
    //   204	227	2897	java/lang/Throwable
    //   227	233	2897	java/lang/Throwable
    //   233	240	2897	java/lang/Throwable
    //   245	282	2897	java/lang/Throwable
    //   291	307	2897	java/lang/Throwable
    //   344	437	2897	java/lang/Throwable
    //   454	466	2897	java/lang/Throwable
    //   488	497	2897	java/lang/Throwable
    //   517	534	2897	java/lang/Throwable
    //   3157	3167	3280	java/lang/Exception
    //   3175	3190	3280	java/lang/Exception
    //   3198	3211	3280	java/lang/Exception
    //   3219	3227	3280	java/lang/Exception
    //   3235	3248	3280	java/lang/Exception
    //   3256	3269	3280	java/lang/Exception
    //   3005	3020	3285	java/lang/Exception
    //   3024	3033	3285	java/lang/Exception
    //   3037	3049	3285	java/lang/Exception
    //   3053	3062	3285	java/lang/Exception
    //   3066	3080	3285	java/lang/Exception
    //   3084	3095	3285	java/lang/Exception
    //   3099	3117	3285	java/lang/Exception
    //   3121	3134	3285	java/lang/Exception
    //   3138	3145	3285	java/lang/Exception
    //   3157	3167	3494	java/lang/Throwable
    //   3175	3190	3494	java/lang/Throwable
    //   3198	3211	3494	java/lang/Throwable
    //   3219	3227	3494	java/lang/Throwable
    //   3235	3248	3494	java/lang/Throwable
    //   3256	3269	3494	java/lang/Throwable
    //   3295	3304	3494	java/lang/Throwable
    //   3312	3321	3494	java/lang/Throwable
    //   3329	3340	3494	java/lang/Throwable
    //   3348	3359	3494	java/lang/Throwable
    //   3378	3388	3494	java/lang/Throwable
    //   3396	3409	3494	java/lang/Throwable
    //   3417	3434	3494	java/lang/Throwable
    //   3442	3448	3494	java/lang/Throwable
    //   8	63	3507	finally
    //   68	83	3507	finally
    //   88	140	3507	finally
    //   143	191	3507	finally
    //   196	200	3507	finally
    //   204	227	3507	finally
    //   227	233	3507	finally
    //   233	240	3507	finally
    //   245	282	3507	finally
    //   282	286	3507	finally
    //   291	307	3507	finally
    //   307	319	3507	finally
    //   326	339	3507	finally
    //   344	437	3507	finally
    //   437	449	3507	finally
    //   454	466	3507	finally
    //   466	483	3507	finally
    //   488	497	3507	finally
    //   497	512	3507	finally
    //   517	534	3507	finally
    //   539	555	3507	finally
    //   555	572	3507	finally
    //   576	590	3507	finally
    //   594	607	3507	finally
    //   611	634	3507	finally
    //   641	647	3507	finally
    //   651	660	3507	finally
    //   664	677	3507	finally
    //   681	703	3507	finally
    //   707	712	3507	finally
    //   726	737	3507	finally
    //   741	750	3507	finally
    //   754	813	3507	finally
    //   820	829	3507	finally
    //   833	842	3507	finally
    //   849	913	3507	finally
    //   920	983	3507	finally
    //   992	1010	3507	finally
    //   1014	1023	3507	finally
    //   1027	1036	3507	finally
    //   1040	1051	3507	finally
    //   1055	1066	3507	finally
    //   1075	1083	3507	finally
    //   1087	1100	3507	finally
    //   1133	1142	3507	finally
    //   1146	1155	3507	finally
    //   1159	1170	3507	finally
    //   1174	1185	3507	finally
    //   1189	1202	3507	finally
    //   1258	1271	3507	finally
    //   1280	1301	3507	finally
    //   1305	1314	3507	finally
    //   1318	1328	3507	finally
    //   1332	1341	3507	finally
    //   1356	1361	3507	finally
    //   1365	1372	3507	finally
    //   1387	1393	3507	finally
    //   1397	1406	3507	finally
    //   1410	1418	3507	finally
    //   1422	1431	3507	finally
    //   1435	1446	3507	finally
    //   1453	1458	3507	finally
    //   1469	1483	3507	finally
    //   1487	1500	3507	finally
    //   1504	1524	3507	finally
    //   1528	1532	3507	finally
    //   1536	1542	3507	finally
    //   1546	1555	3507	finally
    //   1559	1568	3507	finally
    //   1572	1585	3507	finally
    //   1589	1598	3507	finally
    //   1602	1611	3507	finally
    //   1615	1626	3507	finally
    //   1630	1640	3507	finally
    //   1647	1651	3507	finally
    //   1655	1660	3507	finally
    //   1671	1684	3507	finally
    //   1688	1701	3507	finally
    //   1705	1725	3507	finally
    //   1729	1742	3507	finally
    //   1746	1752	3507	finally
    //   1756	1765	3507	finally
    //   1769	1777	3507	finally
    //   1781	1787	3507	finally
    //   1787	1936	3507	finally
    //   1941	1996	3507	finally
    //   2004	2047	3507	finally
    //   2047	2071	3507	finally
    //   2075	2086	3507	finally
    //   2100	2156	3507	finally
    //   2165	2276	3507	finally
    //   2276	2289	3507	finally
    //   2289	2295	3507	finally
    //   2300	2313	3507	finally
    //   2329	2344	3507	finally
    //   2348	2357	3507	finally
    //   2362	2380	3507	finally
    //   2380	2399	3507	finally
    //   2417	2422	3507	finally
    //   2430	2448	3507	finally
    //   2453	2681	3507	finally
    //   2681	2770	3507	finally
    //   2770	2790	3507	finally
    //   2790	2868	3507	finally
    //   2907	2920	3507	finally
    //   2924	2938	3507	finally
    //   2942	2955	3507	finally
    //   2959	2967	3507	finally
    //   2978	2985	3507	finally
    //   2989	2994	3507	finally
    //   3005	3020	3507	finally
    //   3024	3033	3507	finally
    //   3037	3049	3507	finally
    //   3053	3062	3507	finally
    //   3066	3080	3507	finally
    //   3084	3095	3507	finally
    //   3099	3117	3507	finally
    //   3121	3134	3507	finally
    //   3138	3145	3507	finally
    //   3157	3167	3507	finally
    //   3175	3190	3507	finally
    //   3198	3211	3507	finally
    //   3219	3227	3507	finally
    //   3235	3248	3507	finally
    //   3256	3269	3507	finally
    //   3295	3304	3507	finally
    //   3312	3321	3507	finally
    //   3329	3340	3507	finally
    //   3348	3359	3507	finally
    //   3378	3388	3507	finally
    //   3396	3409	3507	finally
    //   3417	3434	3507	finally
    //   3442	3448	3507	finally
    //   3514	3527	3507	finally
    //   8	63	3512	java/lang/Throwable
    //   2907	2920	3700	java/lang/Throwable
    //   2924	2938	3700	java/lang/Throwable
    //   2942	2955	3700	java/lang/Throwable
    //   2959	2967	3700	java/lang/Throwable
    //   2978	2985	3700	java/lang/Throwable
    //   2989	2994	3700	java/lang/Throwable
    //   3005	3020	3700	java/lang/Throwable
    //   3024	3033	3700	java/lang/Throwable
    //   3037	3049	3700	java/lang/Throwable
    //   3053	3062	3700	java/lang/Throwable
    //   3066	3080	3700	java/lang/Throwable
    //   3084	3095	3700	java/lang/Throwable
    //   3099	3117	3700	java/lang/Throwable
    //   3121	3134	3700	java/lang/Throwable
    //   3138	3145	3700	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac.c
 * JD-Core Version:    0.7.0.1
 */