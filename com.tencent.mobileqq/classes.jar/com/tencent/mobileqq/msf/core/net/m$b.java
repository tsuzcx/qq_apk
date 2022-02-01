package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;

class m$b
  extends m.a
{
  static final String c = "SocketReaderNew";
  final Object d = new Object();
  boolean e = false;
  long f = 0L;
  boolean g = false;
  long h = 0L;
  long i = 0L;
  
  m$b(m paramm)
  {
    super(paramm);
  }
  
  public void a()
  {
    synchronized (this.d)
    {
      this.d.notifyAll();
      this.e = true;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("SocketReader(");
      ((StringBuilder)???).append(this.f);
      ((StringBuilder)???).append(") onConnOpened");
      QLog.i("SocketReaderNew", 1, ((StringBuilder)???).toString());
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 81	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4: invokevirtual 85	java/lang/Thread:getId	()J
    //   7: putfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   10: new 49	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 52
    //   21: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   30: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_1
    //   35: ldc 87
    //   37: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 8
    //   43: iconst_1
    //   44: aload_1
    //   45: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: new 49	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: ldc 52
    //   62: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   71: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: ldc 89
    //   78: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 8
    //   84: iconst_1
    //   85: aload_1
    //   86: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   96: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   99: ifeq +246 -> 345
    //   102: aload_0
    //   103: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   106: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   109: sipush 30000
    //   112: invokevirtual 110	com/tencent/qphone/base/util/MsfSocketInputBuffer:isDataAvailable	(I)Z
    //   115: ifeq +115 -> 230
    //   118: aload_0
    //   119: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   122: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   125: ifnull +33 -> 158
    //   128: aload_0
    //   129: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   132: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   135: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   138: ifnull +20 -> 158
    //   141: aload_0
    //   142: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   145: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   148: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   151: iconst_2
    //   152: invokeinterface 125 2 0
    //   157: pop
    //   158: aload_0
    //   159: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   162: getfield 128	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   165: aload_0
    //   166: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   169: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   172: aload_0
    //   173: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   176: invokestatic 131	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;)I
    //   179: invokeinterface 136 3 0
    //   184: aload_0
    //   185: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   188: invokestatic 140	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/mobileqq/msf/core/net/m;)Ljava/util/concurrent/atomic/AtomicLong;
    //   191: aload_0
    //   192: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   195: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   198: invokevirtual 144	com/tencent/qphone/base/util/MsfSocketInputBuffer:getBufferlen	()I
    //   201: i2l
    //   202: invokevirtual 150	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   205: pop2
    //   206: aload_0
    //   207: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   210: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   213: invokevirtual 153	com/tencent/qphone/base/util/MsfSocketInputBuffer:reset	()V
    //   216: aload_0
    //   217: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   220: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   223: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
    //   226: pop2
    //   227: goto +75 -> 302
    //   230: aload_0
    //   231: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   234: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   237: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
    //   240: pop2
    //   241: aload_0
    //   242: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   245: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   248: ifne +54 -> 302
    //   251: ldc 8
    //   253: iconst_1
    //   254: ldc 163
    //   256: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_0
    //   260: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   263: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   266: ifnull +79 -> 345
    //   269: aload_0
    //   270: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   273: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   276: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   279: ifnull +66 -> 345
    //   282: aload_0
    //   283: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   286: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   289: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   292: iconst_2
    //   293: invokeinterface 168 2 0
    //   298: pop
    //   299: goto +46 -> 345
    //   302: aload_0
    //   303: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   306: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   309: ifnull -217 -> 92
    //   312: aload_0
    //   313: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   316: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   319: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   322: ifnull -230 -> 92
    //   325: aload_0
    //   326: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   329: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   332: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   335: iconst_2
    //   336: invokeinterface 168 2 0
    //   341: pop
    //   342: goto -250 -> 92
    //   345: aload_0
    //   346: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   349: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   352: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   355: invokevirtual 176	com/tencent/mobileqq/msf/core/ad:k	()V
    //   358: aload_0
    //   359: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   362: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   365: ifnull +373 -> 738
    //   368: aload_0
    //   369: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   372: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   375: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   378: ifnull +360 -> 738
    //   381: aload_0
    //   382: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   385: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   388: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   391: iconst_2
    //   392: invokeinterface 168 2 0
    //   397: pop
    //   398: goto +340 -> 738
    //   401: astore_1
    //   402: goto +561 -> 963
    //   405: astore_1
    //   406: aload_0
    //   407: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   410: iconst_0
    //   411: invokevirtual 180	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   414: aload_0
    //   415: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   418: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   421: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   424: invokevirtual 176	com/tencent/mobileqq/msf/core/ad:k	()V
    //   427: aload_0
    //   428: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   431: getstatic 185	com/tencent/qphone/base/a:c	Lcom/tencent/qphone/base/a;
    //   434: invokevirtual 188	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   437: aload_1
    //   438: invokevirtual 191	java/lang/Throwable:printStackTrace	()V
    //   441: aload_0
    //   442: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   445: lconst_0
    //   446: lcmp
    //   447: ifle +196 -> 643
    //   450: aload_0
    //   451: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   454: lconst_0
    //   455: lcmp
    //   456: ifle +187 -> 643
    //   459: aload_0
    //   460: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   463: aload_0
    //   464: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   467: lsub
    //   468: ldc2_w 192
    //   471: lcmp
    //   472: ifge +171 -> 643
    //   475: invokestatic 196	android/os/SystemClock:elapsedRealtime	()J
    //   478: aload_0
    //   479: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   482: lsub
    //   483: ldc2_w 192
    //   486: lcmp
    //   487: ifge +156 -> 643
    //   490: aload_0
    //   491: getfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   494: ifne +93 -> 587
    //   497: aload_0
    //   498: iconst_1
    //   499: putfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   502: new 198	java/util/HashMap
    //   505: dup
    //   506: invokespecial 199	java/util/HashMap:<init>	()V
    //   509: astore_2
    //   510: aload_2
    //   511: ldc 201
    //   513: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   516: invokevirtual 208	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   519: invokevirtual 212	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   522: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   525: invokeinterface 224 3 0
    //   530: pop
    //   531: aload_2
    //   532: ldc 226
    //   534: aload_1
    //   535: invokevirtual 229	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   538: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   541: invokeinterface 224 3 0
    //   546: pop
    //   547: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   550: ifnull +37 -> 587
    //   553: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   556: getfield 233	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   559: ifnull +28 -> 587
    //   562: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   565: getfield 233	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   568: ldc 235
    //   570: iconst_0
    //   571: aload_0
    //   572: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   575: aload_0
    //   576: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   579: lsub
    //   580: lconst_0
    //   581: aload_2
    //   582: iconst_1
    //   583: iconst_0
    //   584: invokevirtual 240	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   587: aload_0
    //   588: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   591: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   594: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   597: invokevirtual 176	com/tencent/mobileqq/msf/core/ad:k	()V
    //   600: aload_0
    //   601: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   604: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   607: ifnull +313 -> 920
    //   610: aload_0
    //   611: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   614: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   617: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   620: ifnull +300 -> 920
    //   623: aload_0
    //   624: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   627: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   630: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   633: iconst_2
    //   634: invokeinterface 168 2 0
    //   639: pop
    //   640: goto +280 -> 920
    //   643: aload_0
    //   644: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   647: lconst_0
    //   648: lcmp
    //   649: ifne +13 -> 662
    //   652: aload_0
    //   653: invokestatic 196	android/os/SystemClock:elapsedRealtime	()J
    //   656: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   659: goto +40 -> 699
    //   662: aload_0
    //   663: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   666: lconst_0
    //   667: lcmp
    //   668: ifne +13 -> 681
    //   671: aload_0
    //   672: invokestatic 196	android/os/SystemClock:elapsedRealtime	()J
    //   675: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   678: goto +21 -> 699
    //   681: aload_0
    //   682: lconst_0
    //   683: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   686: aload_0
    //   687: lconst_0
    //   688: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   691: goto +8 -> 699
    //   694: astore_1
    //   695: aload_1
    //   696: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   699: aload_0
    //   700: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   703: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   706: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   709: invokevirtual 176	com/tencent/mobileqq/msf/core/ad:k	()V
    //   712: aload_0
    //   713: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   716: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   719: ifnull +19 -> 738
    //   722: aload_0
    //   723: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   726: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   729: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   732: ifnull +6 -> 738
    //   735: goto -354 -> 381
    //   738: new 49	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   745: astore_1
    //   746: aload_1
    //   747: ldc 52
    //   749: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload_1
    //   754: aload_0
    //   755: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   758: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload_1
    //   763: ldc 243
    //   765: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: ldc 8
    //   771: iconst_1
    //   772: aload_1
    //   773: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aload_0
    //   780: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   783: astore_1
    //   784: aload_1
    //   785: monitorenter
    //   786: aload_0
    //   787: getfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   790: ifne +93 -> 883
    //   793: aload_0
    //   794: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   797: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   800: ifnull +33 -> 833
    //   803: aload_0
    //   804: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   807: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   810: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   813: ifnull +20 -> 833
    //   816: aload_0
    //   817: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   820: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   823: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   826: iconst_2
    //   827: invokeinterface 168 2 0
    //   832: pop
    //   833: aload_0
    //   834: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   837: ldc2_w 244
    //   840: invokevirtual 249	java/lang/Object:wait	(J)V
    //   843: aload_0
    //   844: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   847: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   850: ifnull +33 -> 883
    //   853: aload_0
    //   854: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   857: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   860: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   863: ifnull +20 -> 883
    //   866: aload_0
    //   867: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   870: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   873: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   876: iconst_2
    //   877: invokeinterface 125 2 0
    //   882: pop
    //   883: aload_0
    //   884: iconst_0
    //   885: putfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   888: aload_1
    //   889: monitorexit
    //   890: aload_0
    //   891: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   894: iconst_1
    //   895: invokevirtual 180	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   898: goto -847 -> 51
    //   901: astore_2
    //   902: aload_1
    //   903: monitorexit
    //   904: aload_2
    //   905: athrow
    //   906: astore_1
    //   907: ldc 8
    //   909: iconst_1
    //   910: ldc 251
    //   912: aload_1
    //   913: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   916: aload_1
    //   917: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   920: new 49	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   927: astore_1
    //   928: aload_1
    //   929: ldc 52
    //   931: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload_1
    //   936: aload_0
    //   937: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   940: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload_1
    //   945: ldc_w 256
    //   948: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: ldc 8
    //   954: iconst_1
    //   955: aload_1
    //   956: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: return
    //   963: aload_0
    //   964: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   967: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   970: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   973: invokevirtual 176	com/tencent/mobileqq/msf/core/ad:k	()V
    //   976: aload_0
    //   977: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   980: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   983: ifnull +33 -> 1016
    //   986: aload_0
    //   987: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   990: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   993: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   996: ifnull +20 -> 1016
    //   999: aload_0
    //   1000: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   1003: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1006: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   1009: iconst_2
    //   1010: invokeinterface 168 2 0
    //   1015: pop
    //   1016: goto +5 -> 1021
    //   1019: aload_1
    //   1020: athrow
    //   1021: goto -2 -> 1019
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1024	0	this	b
    //   17	69	1	localStringBuilder1	StringBuilder
    //   401	1	1	localObject1	Object
    //   405	130	1	localThrowable	java.lang.Throwable
    //   694	2	1	localException1	java.lang.Exception
    //   745	158	1	localObject2	Object
    //   906	11	1	localException2	java.lang.Exception
    //   927	93	1	localStringBuilder2	StringBuilder
    //   509	73	2	localHashMap	java.util.HashMap
    //   901	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	92	401	finally
    //   92	158	401	finally
    //   158	227	401	finally
    //   230	299	401	finally
    //   302	342	401	finally
    //   406	441	401	finally
    //   441	587	401	finally
    //   643	659	401	finally
    //   662	678	401	finally
    //   681	691	401	finally
    //   695	699	401	finally
    //   51	92	405	java/lang/Throwable
    //   92	158	405	java/lang/Throwable
    //   158	227	405	java/lang/Throwable
    //   230	299	405	java/lang/Throwable
    //   302	342	405	java/lang/Throwable
    //   441	587	694	java/lang/Exception
    //   643	659	694	java/lang/Exception
    //   662	678	694	java/lang/Exception
    //   681	691	694	java/lang/Exception
    //   786	833	901	finally
    //   833	883	901	finally
    //   883	890	901	finally
    //   902	904	901	finally
    //   779	786	906	java/lang/Exception
    //   890	898	906	java/lang/Exception
    //   904	906	906	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m.b
 * JD-Core Version:    0.7.0.1
 */