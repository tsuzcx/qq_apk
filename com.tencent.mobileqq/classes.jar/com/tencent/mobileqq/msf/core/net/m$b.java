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
      QLog.i("SocketReaderNew", 1, "SocketReader(" + this.f + ") onConnOpened");
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
    //   10: ldc 8
    //   12: iconst_1
    //   13: new 49	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   20: ldc 52
    //   22: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: ldc 87
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: ldc 8
    //   45: iconst_1
    //   46: new 49	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   53: ldc 52
    //   55: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   62: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   65: ldc 89
    //   67: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   80: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   83: ifeq +509 -> 592
    //   86: aload_0
    //   87: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   90: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   93: sipush 30000
    //   96: invokevirtual 110	com/tencent/qphone/base/util/MsfSocketInputBuffer:isDataAvailable	(I)Z
    //   99: ifeq +424 -> 523
    //   102: aload_0
    //   103: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   106: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   109: ifnull +33 -> 142
    //   112: aload_0
    //   113: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   116: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   119: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   122: ifnull +20 -> 142
    //   125: aload_0
    //   126: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   129: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   132: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   135: iconst_2
    //   136: invokeinterface 125 2 0
    //   141: pop
    //   142: aload_0
    //   143: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   146: getfield 128	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   149: aload_0
    //   150: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   153: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   156: aload_0
    //   157: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   160: invokestatic 131	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;)I
    //   163: invokeinterface 136 3 0
    //   168: aload_0
    //   169: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   172: invokestatic 140	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/mobileqq/msf/core/net/m;)Ljava/util/concurrent/atomic/AtomicLong;
    //   175: aload_0
    //   176: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   179: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   182: invokevirtual 144	com/tencent/qphone/base/util/MsfSocketInputBuffer:getBufferlen	()I
    //   185: i2l
    //   186: invokevirtual 150	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   189: pop2
    //   190: aload_0
    //   191: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   194: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   197: invokevirtual 153	com/tencent/qphone/base/util/MsfSocketInputBuffer:reset	()V
    //   200: aload_0
    //   201: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   204: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   207: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
    //   210: pop2
    //   211: aload_0
    //   212: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   215: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   218: ifnull -142 -> 76
    //   221: aload_0
    //   222: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   225: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   228: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   231: ifnull -155 -> 76
    //   234: aload_0
    //   235: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   238: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   241: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   244: iconst_2
    //   245: invokeinterface 164 2 0
    //   250: pop
    //   251: goto -175 -> 76
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   259: iconst_0
    //   260: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   263: aload_0
    //   264: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   267: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   270: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   273: invokevirtual 176	com/tencent/mobileqq/msf/core/ac:k	()V
    //   276: aload_0
    //   277: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   280: getstatic 181	com/tencent/qphone/base/a:c	Lcom/tencent/qphone/base/a;
    //   283: invokevirtual 184	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   286: aload_1
    //   287: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   290: aload_0
    //   291: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   294: lconst_0
    //   295: lcmp
    //   296: ifle +521 -> 817
    //   299: aload_0
    //   300: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   303: lconst_0
    //   304: lcmp
    //   305: ifle +512 -> 817
    //   308: aload_0
    //   309: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   312: aload_0
    //   313: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   316: lsub
    //   317: ldc2_w 188
    //   320: lcmp
    //   321: ifge +496 -> 817
    //   324: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   327: aload_0
    //   328: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   331: lsub
    //   332: ldc2_w 188
    //   335: lcmp
    //   336: ifge +481 -> 817
    //   339: aload_0
    //   340: getfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   343: ifne +93 -> 436
    //   346: aload_0
    //   347: iconst_1
    //   348: putfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   351: new 194	java/util/HashMap
    //   354: dup
    //   355: invokespecial 195	java/util/HashMap:<init>	()V
    //   358: astore_2
    //   359: aload_2
    //   360: ldc 197
    //   362: getstatic 200	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   365: invokevirtual 204	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   368: invokevirtual 208	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   371: invokestatic 214	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   374: invokeinterface 220 3 0
    //   379: pop
    //   380: aload_2
    //   381: ldc 222
    //   383: aload_1
    //   384: invokevirtual 225	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   387: invokestatic 214	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   390: invokeinterface 220 3 0
    //   395: pop
    //   396: getstatic 200	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   399: ifnull +37 -> 436
    //   402: getstatic 200	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   405: getfield 229	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   408: ifnull +28 -> 436
    //   411: getstatic 200	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   414: getfield 229	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   417: ldc 231
    //   419: iconst_0
    //   420: aload_0
    //   421: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   424: aload_0
    //   425: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   428: lsub
    //   429: lconst_0
    //   430: aload_2
    //   431: iconst_1
    //   432: iconst_0
    //   433: invokevirtual 236	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   436: aload_0
    //   437: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   440: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   443: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   446: invokevirtual 176	com/tencent/mobileqq/msf/core/ac:k	()V
    //   449: aload_0
    //   450: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   453: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   456: ifnull +33 -> 489
    //   459: aload_0
    //   460: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   463: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   466: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   469: ifnull +20 -> 489
    //   472: aload_0
    //   473: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   476: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   479: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   482: iconst_2
    //   483: invokeinterface 164 2 0
    //   488: pop
    //   489: ldc 8
    //   491: iconst_1
    //   492: new 49	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   499: ldc 52
    //   501: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_0
    //   505: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   508: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: ldc 238
    //   513: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: return
    //   523: aload_0
    //   524: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   527: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   530: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
    //   533: pop2
    //   534: aload_0
    //   535: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   538: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   541: ifne -330 -> 211
    //   544: ldc 8
    //   546: iconst_1
    //   547: ldc 240
    //   549: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload_0
    //   553: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   556: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   559: ifnull +33 -> 592
    //   562: aload_0
    //   563: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   566: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   569: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   572: ifnull +20 -> 592
    //   575: aload_0
    //   576: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   579: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   582: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   585: iconst_2
    //   586: invokeinterface 164 2 0
    //   591: pop
    //   592: aload_0
    //   593: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   596: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   599: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   602: invokevirtual 176	com/tencent/mobileqq/msf/core/ac:k	()V
    //   605: aload_0
    //   606: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   609: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   612: ifnull +33 -> 645
    //   615: aload_0
    //   616: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   619: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   622: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   625: ifnull +20 -> 645
    //   628: aload_0
    //   629: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   632: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   635: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   638: iconst_2
    //   639: invokeinterface 164 2 0
    //   644: pop
    //   645: ldc 8
    //   647: iconst_1
    //   648: new 49	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   655: ldc 52
    //   657: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_0
    //   661: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   664: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   667: ldc 244
    //   669: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload_0
    //   679: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   682: astore_1
    //   683: aload_1
    //   684: monitorenter
    //   685: aload_0
    //   686: getfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   689: ifne +93 -> 782
    //   692: aload_0
    //   693: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   696: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   699: ifnull +33 -> 732
    //   702: aload_0
    //   703: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   706: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   709: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   712: ifnull +20 -> 732
    //   715: aload_0
    //   716: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   719: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   722: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   725: iconst_2
    //   726: invokeinterface 164 2 0
    //   731: pop
    //   732: aload_0
    //   733: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   736: ldc2_w 245
    //   739: invokevirtual 250	java/lang/Object:wait	(J)V
    //   742: aload_0
    //   743: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   746: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   749: ifnull +33 -> 782
    //   752: aload_0
    //   753: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   756: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   759: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   762: ifnull +20 -> 782
    //   765: aload_0
    //   766: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   769: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   772: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   775: iconst_2
    //   776: invokeinterface 125 2 0
    //   781: pop
    //   782: aload_0
    //   783: iconst_0
    //   784: putfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   787: aload_1
    //   788: monitorexit
    //   789: aload_0
    //   790: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   793: iconst_1
    //   794: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   797: goto -754 -> 43
    //   800: astore_1
    //   801: ldc 8
    //   803: iconst_1
    //   804: ldc 252
    //   806: aload_1
    //   807: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: aload_1
    //   811: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   814: goto -325 -> 489
    //   817: aload_0
    //   818: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   821: lconst_0
    //   822: lcmp
    //   823: ifne +66 -> 889
    //   826: aload_0
    //   827: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   830: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   833: aload_0
    //   834: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   837: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   840: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   843: invokevirtual 176	com/tencent/mobileqq/msf/core/ac:k	()V
    //   846: aload_0
    //   847: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   850: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   853: ifnull -208 -> 645
    //   856: aload_0
    //   857: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   860: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   863: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   866: ifnull -221 -> 645
    //   869: aload_0
    //   870: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   873: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   876: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   879: iconst_2
    //   880: invokeinterface 164 2 0
    //   885: pop
    //   886: goto -241 -> 645
    //   889: aload_0
    //   890: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   893: lconst_0
    //   894: lcmp
    //   895: ifne +77 -> 972
    //   898: aload_0
    //   899: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   902: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   905: goto -72 -> 833
    //   908: astore_1
    //   909: aload_1
    //   910: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   913: goto -80 -> 833
    //   916: astore_1
    //   917: aload_0
    //   918: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   921: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   924: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   927: invokevirtual 176	com/tencent/mobileqq/msf/core/ac:k	()V
    //   930: aload_0
    //   931: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   934: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   937: ifnull +33 -> 970
    //   940: aload_0
    //   941: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   944: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   947: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   950: ifnull +20 -> 970
    //   953: aload_0
    //   954: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   957: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   960: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   963: iconst_2
    //   964: invokeinterface 164 2 0
    //   969: pop
    //   970: aload_1
    //   971: athrow
    //   972: aload_0
    //   973: lconst_0
    //   974: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   977: aload_0
    //   978: lconst_0
    //   979: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   982: goto -149 -> 833
    //   985: astore_2
    //   986: aload_1
    //   987: monitorexit
    //   988: aload_2
    //   989: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	b
    //   254	130	1	localThrowable	java.lang.Throwable
    //   800	11	1	localException1	java.lang.Exception
    //   908	2	1	localException2	java.lang.Exception
    //   916	71	1	localObject2	Object
    //   358	73	2	localHashMap	java.util.HashMap
    //   985	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   43	76	254	java/lang/Throwable
    //   76	142	254	java/lang/Throwable
    //   142	211	254	java/lang/Throwable
    //   211	251	254	java/lang/Throwable
    //   523	592	254	java/lang/Throwable
    //   678	685	800	java/lang/Exception
    //   789	797	800	java/lang/Exception
    //   988	990	800	java/lang/Exception
    //   290	436	908	java/lang/Exception
    //   817	833	908	java/lang/Exception
    //   889	905	908	java/lang/Exception
    //   972	982	908	java/lang/Exception
    //   43	76	916	finally
    //   76	142	916	finally
    //   142	211	916	finally
    //   211	251	916	finally
    //   255	290	916	finally
    //   290	436	916	finally
    //   523	592	916	finally
    //   817	833	916	finally
    //   889	905	916	finally
    //   909	913	916	finally
    //   972	982	916	finally
    //   685	732	985	finally
    //   732	782	985	finally
    //   782	789	985	finally
    //   986	988	985	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m.b
 * JD-Core Version:    0.7.0.1
 */