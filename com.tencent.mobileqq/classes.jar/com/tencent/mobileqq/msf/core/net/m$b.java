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
    //   83: ifeq +504 -> 587
    //   86: aload_0
    //   87: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   90: getfield 104	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   93: sipush 30000
    //   96: invokevirtual 110	com/tencent/qphone/base/util/MsfSocketInputBuffer:isDataAvailable	(I)Z
    //   99: ifeq +419 -> 518
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
    //   270: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   273: invokevirtual 176	com/tencent/mobileqq/msf/core/aj:i	()V
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
    //   296: ifle +516 -> 812
    //   299: aload_0
    //   300: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   303: lconst_0
    //   304: lcmp
    //   305: ifle +507 -> 812
    //   308: aload_0
    //   309: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   312: aload_0
    //   313: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   316: lsub
    //   317: ldc2_w 188
    //   320: lcmp
    //   321: ifge +491 -> 812
    //   324: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   327: aload_0
    //   328: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   331: lsub
    //   332: ldc2_w 188
    //   335: lcmp
    //   336: ifge +476 -> 812
    //   339: aload_0
    //   340: getfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   343: ifne +88 -> 431
    //   346: aload_0
    //   347: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   350: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   353: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/b;
    //   356: ifnull +75 -> 431
    //   359: aload_0
    //   360: iconst_1
    //   361: putfield 38	com/tencent/mobileqq/msf/core/net/m$b:g	Z
    //   364: new 198	java/util/Properties
    //   367: dup
    //   368: invokespecial 199	java/util/Properties:<init>	()V
    //   371: astore_2
    //   372: aload_2
    //   373: ldc 201
    //   375: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   378: invokevirtual 208	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   381: invokevirtual 212	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   384: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   387: invokevirtual 222	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   390: pop
    //   391: aload_2
    //   392: ldc 224
    //   394: aload_1
    //   395: invokevirtual 227	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   398: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   401: invokevirtual 222	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   404: pop
    //   405: aload_0
    //   406: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   409: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   412: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/b;
    //   415: ldc 229
    //   417: aload_2
    //   418: aload_0
    //   419: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   422: aload_0
    //   423: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   426: lsub
    //   427: l2i
    //   428: invokevirtual 235	com/tencent/mobileqq/msf/core/c/b:reportTimeKVEvent	(Ljava/lang/String;Ljava/util/Properties;I)V
    //   431: aload_0
    //   432: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   435: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   438: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   441: invokevirtual 176	com/tencent/mobileqq/msf/core/aj:i	()V
    //   444: aload_0
    //   445: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   448: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   451: ifnull +33 -> 484
    //   454: aload_0
    //   455: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   458: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   461: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   464: ifnull +20 -> 484
    //   467: aload_0
    //   468: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   471: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   474: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   477: iconst_2
    //   478: invokeinterface 164 2 0
    //   483: pop
    //   484: ldc 8
    //   486: iconst_1
    //   487: new 49	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   494: ldc 52
    //   496: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   503: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: ldc 237
    //   508: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: return
    //   518: aload_0
    //   519: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   522: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   525: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
    //   528: pop2
    //   529: aload_0
    //   530: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   533: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   536: ifne -325 -> 211
    //   539: ldc 8
    //   541: iconst_1
    //   542: ldc 239
    //   544: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   551: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   554: ifnull +33 -> 587
    //   557: aload_0
    //   558: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   561: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   564: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   567: ifnull +20 -> 587
    //   570: aload_0
    //   571: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   574: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   577: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   580: iconst_2
    //   581: invokeinterface 164 2 0
    //   586: pop
    //   587: aload_0
    //   588: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   591: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   594: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   597: invokevirtual 176	com/tencent/mobileqq/msf/core/aj:i	()V
    //   600: aload_0
    //   601: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   604: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   607: ifnull +33 -> 640
    //   610: aload_0
    //   611: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   614: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   617: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   620: ifnull +20 -> 640
    //   623: aload_0
    //   624: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   627: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   630: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   633: iconst_2
    //   634: invokeinterface 164 2 0
    //   639: pop
    //   640: ldc 8
    //   642: iconst_1
    //   643: new 49	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   650: ldc 52
    //   652: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_0
    //   656: getfield 36	com/tencent/mobileqq/msf/core/net/m$b:f	J
    //   659: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   662: ldc 243
    //   664: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   677: astore_1
    //   678: aload_1
    //   679: monitorenter
    //   680: aload_0
    //   681: getfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   684: ifne +93 -> 777
    //   687: aload_0
    //   688: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   691: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   694: ifnull +33 -> 727
    //   697: aload_0
    //   698: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   701: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   704: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   707: ifnull +20 -> 727
    //   710: aload_0
    //   711: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   714: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   717: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   720: iconst_2
    //   721: invokeinterface 164 2 0
    //   726: pop
    //   727: aload_0
    //   728: getfield 32	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
    //   731: ldc2_w 244
    //   734: invokevirtual 249	java/lang/Object:wait	(J)V
    //   737: aload_0
    //   738: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   741: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   744: ifnull +33 -> 777
    //   747: aload_0
    //   748: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   751: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   754: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   757: ifnull +20 -> 777
    //   760: aload_0
    //   761: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   764: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   767: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   770: iconst_2
    //   771: invokeinterface 125 2 0
    //   776: pop
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 34	com/tencent/mobileqq/msf/core/net/m$b:e	Z
    //   782: aload_1
    //   783: monitorexit
    //   784: aload_0
    //   785: getfield 92	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   788: iconst_1
    //   789: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   792: goto -749 -> 43
    //   795: astore_1
    //   796: ldc 8
    //   798: iconst_1
    //   799: ldc 251
    //   801: aload_1
    //   802: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   805: aload_1
    //   806: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   809: goto -325 -> 484
    //   812: aload_0
    //   813: getfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   816: lconst_0
    //   817: lcmp
    //   818: ifne +66 -> 884
    //   821: aload_0
    //   822: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   825: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   828: aload_0
    //   829: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   832: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   835: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   838: invokevirtual 176	com/tencent/mobileqq/msf/core/aj:i	()V
    //   841: aload_0
    //   842: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   845: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   848: ifnull -208 -> 640
    //   851: aload_0
    //   852: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   855: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   858: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   861: ifnull -221 -> 640
    //   864: aload_0
    //   865: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   868: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   871: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   874: iconst_2
    //   875: invokeinterface 164 2 0
    //   880: pop
    //   881: goto -241 -> 640
    //   884: aload_0
    //   885: getfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   888: lconst_0
    //   889: lcmp
    //   890: ifne +77 -> 967
    //   893: aload_0
    //   894: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
    //   897: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   900: goto -72 -> 828
    //   903: astore_1
    //   904: aload_1
    //   905: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   908: goto -80 -> 828
    //   911: astore_1
    //   912: aload_0
    //   913: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   916: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   919: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   922: invokevirtual 176	com/tencent/mobileqq/msf/core/aj:i	()V
    //   925: aload_0
    //   926: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   929: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   932: ifnull +33 -> 965
    //   935: aload_0
    //   936: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   939: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   942: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   945: ifnull +20 -> 965
    //   948: aload_0
    //   949: getfield 23	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
    //   952: getfield 114	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   955: getfield 120	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   958: iconst_2
    //   959: invokeinterface 164 2 0
    //   964: pop
    //   965: aload_1
    //   966: athrow
    //   967: aload_0
    //   968: lconst_0
    //   969: putfield 42	com/tencent/mobileqq/msf/core/net/m$b:i	J
    //   972: aload_0
    //   973: lconst_0
    //   974: putfield 40	com/tencent/mobileqq/msf/core/net/m$b:h	J
    //   977: goto -149 -> 828
    //   980: astore_2
    //   981: aload_1
    //   982: monitorexit
    //   983: aload_2
    //   984: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	this	b
    //   254	141	1	localThrowable	java.lang.Throwable
    //   795	11	1	localException1	java.lang.Exception
    //   903	2	1	localException2	java.lang.Exception
    //   911	71	1	localObject2	Object
    //   371	47	2	localProperties	java.util.Properties
    //   980	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   43	76	254	java/lang/Throwable
    //   76	142	254	java/lang/Throwable
    //   142	211	254	java/lang/Throwable
    //   211	251	254	java/lang/Throwable
    //   518	587	254	java/lang/Throwable
    //   673	680	795	java/lang/Exception
    //   784	792	795	java/lang/Exception
    //   983	985	795	java/lang/Exception
    //   290	431	903	java/lang/Exception
    //   812	828	903	java/lang/Exception
    //   884	900	903	java/lang/Exception
    //   967	977	903	java/lang/Exception
    //   43	76	911	finally
    //   76	142	911	finally
    //   142	211	911	finally
    //   211	251	911	finally
    //   255	290	911	finally
    //   290	431	911	finally
    //   518	587	911	finally
    //   812	828	911	finally
    //   884	900	911	finally
    //   904	908	911	finally
    //   967	977	911	finally
    //   680	727	980	finally
    //   727	777	980	finally
    //   777	784	980	finally
    //   981	983	980	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m.b
 * JD-Core Version:    0.7.0.1
 */