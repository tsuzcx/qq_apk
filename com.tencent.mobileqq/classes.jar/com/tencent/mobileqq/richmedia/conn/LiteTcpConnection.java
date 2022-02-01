package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LiteTcpConnection
  implements IConnection
{
  public long a = 0L;
  private ReentrantLock b = new ReentrantLock(true);
  private AtomicBoolean c = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  private int e;
  private int f;
  private Socket g;
  private OutputStream h;
  private InetSocketAddress i = null;
  private MsfSocketInputBuffer j = null;
  private int k = 0;
  private SubTitleProtocoDataCodec l = new SubTitleProtocoDataCodec();
  private IConnectionListener m;
  private AtomicBoolean n = new AtomicBoolean(false);
  private AtomicBoolean o = new AtomicBoolean(false);
  private ConnManager p;
  private long q;
  private HostInfo r;
  private HandlerThread s;
  private LiteTcpConnection.ConnWorker t;
  private LiteTcpConnection.ReadRunnable u;
  private HandlerThread v;
  private Handler w;
  
  public LiteTcpConnection(ConnManager paramConnManager, long paramLong, HostInfo paramHostInfo, int paramInt1, int paramInt2)
  {
    this.p = paramConnManager;
    this.f = 32768;
    this.e = paramInt2;
    this.q = paramLong;
    this.r = paramHostInfo;
    this.k = paramInt1;
    this.s = ThreadManager.newFreeHandlerThread("SubTitle-CONN", 0);
  }
  
  /* Error */
  private int a(HostInfo paramHostInfo)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: ldc 113
    //   13: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 14
    //   19: aload_1
    //   20: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   23: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 14
    //   29: ldc 124
    //   31: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 14
    //   37: aload_1
    //   38: getfield 126	com/tencent/mobileqq/richmedia/conn/HostInfo:b	I
    //   41: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 14
    //   47: ldc 131
    //   49: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 14
    //   55: aload_0
    //   56: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   59: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 136
    //   65: iconst_1
    //   66: aload 14
    //   68: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 64	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: istore 6
    //   83: iconst_0
    //   84: istore_3
    //   85: iconst_0
    //   86: istore 4
    //   88: iconst_0
    //   89: istore 5
    //   91: iconst_0
    //   92: istore_2
    //   93: iload 6
    //   95: ifne +13 -> 108
    //   98: aload_0
    //   99: getfield 62	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   105: ifeq +26 -> 131
    //   108: aload_0
    //   109: getfield 64	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   112: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   115: ifeq +16 -> 131
    //   118: aload_0
    //   119: getfield 64	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   122: iconst_0
    //   123: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   126: aload_0
    //   127: iconst_2
    //   128: invokespecial 155	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(I)V
    //   131: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   134: lstore 12
    //   136: ldc2_w 162
    //   139: lstore 10
    //   141: aload_0
    //   142: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   145: ldc2_w 164
    //   148: getstatic 171	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   151: invokevirtual 175	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   154: istore 6
    //   156: iload 6
    //   158: ifeq +770 -> 928
    //   161: lload 10
    //   163: lstore 8
    //   165: aload_0
    //   166: new 177	java/net/InetSocketAddress
    //   169: dup
    //   170: aload_1
    //   171: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   174: aload_1
    //   175: getfield 126	com/tencent/mobileqq/richmedia/conn/HostInfo:b	I
    //   178: invokespecial 180	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   181: putfield 66	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:i	Ljava/net/InetSocketAddress;
    //   184: lload 10
    //   186: lstore 8
    //   188: aload_0
    //   189: getfield 62	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   192: iconst_0
    //   193: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   196: lload 10
    //   198: lstore 8
    //   200: aload_0
    //   201: new 182	java/net/Socket
    //   204: dup
    //   205: invokespecial 183	java/net/Socket:<init>	()V
    //   208: putfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   211: lload 10
    //   213: lstore 8
    //   215: aload_0
    //   216: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   219: iconst_1
    //   220: invokevirtual 188	java/net/Socket:setKeepAlive	(Z)V
    //   223: lload 10
    //   225: lstore 8
    //   227: aload_0
    //   228: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   231: iconst_1
    //   232: invokevirtual 191	java/net/Socket:setTcpNoDelay	(Z)V
    //   235: lload 10
    //   237: lstore 8
    //   239: aload_0
    //   240: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   243: aload_0
    //   244: getfield 88	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:e	I
    //   247: invokevirtual 194	java/net/Socket:setSoTimeout	(I)V
    //   250: lload 10
    //   252: lstore 8
    //   254: aload_0
    //   255: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   258: ldc 195
    //   260: invokevirtual 198	java/net/Socket:setSendBufferSize	(I)V
    //   263: lload 10
    //   265: lstore 8
    //   267: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   270: lstore 10
    //   272: lload 10
    //   274: lstore 8
    //   276: aload_0
    //   277: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   280: aload_0
    //   281: getfield 66	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:i	Ljava/net/InetSocketAddress;
    //   284: aload_0
    //   285: getfield 70	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:k	I
    //   288: invokevirtual 202	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   291: lload 10
    //   293: lstore 8
    //   295: aload_0
    //   296: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   299: lload 10
    //   301: lsub
    //   302: putfield 76	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	J
    //   305: lload 10
    //   307: lstore 8
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   314: invokevirtual 206	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   317: putfield 208	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:h	Ljava/io/OutputStream;
    //   320: lload 10
    //   322: lstore 8
    //   324: aload_0
    //   325: new 210	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   328: dup
    //   329: aload_0
    //   330: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   333: aload_0
    //   334: getfield 86	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:f	I
    //   337: ldc 212
    //   339: iconst_m1
    //   340: invokespecial 215	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   343: putfield 68	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:j	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   346: lload 10
    //   348: lstore 8
    //   350: aload_0
    //   351: new 217	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable
    //   354: dup
    //   355: aload_0
    //   356: invokespecial 220	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection;)V
    //   359: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:u	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   362: lload 10
    //   364: lstore 8
    //   366: aload_0
    //   367: ldc 224
    //   369: iconst_0
    //   370: invokestatic 100	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   373: putfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   376: lload 10
    //   378: lstore 8
    //   380: aload_0
    //   381: getfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   384: invokevirtual 231	android/os/HandlerThread:start	()V
    //   387: lload 10
    //   389: lstore 8
    //   391: aload_0
    //   392: new 233	android/os/Handler
    //   395: dup
    //   396: aload_0
    //   397: getfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   400: invokevirtual 237	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   403: invokespecial 240	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   406: putfield 242	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:w	Landroid/os/Handler;
    //   409: lload 10
    //   411: lstore 8
    //   413: aload_0
    //   414: getfield 74	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:o	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   417: iconst_1
    //   418: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   421: lload 10
    //   423: lstore 8
    //   425: aload_0
    //   426: getfield 242	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:w	Landroid/os/Handler;
    //   429: aload_0
    //   430: getfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:u	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   433: invokevirtual 246	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   436: pop
    //   437: lload 10
    //   439: lstore 8
    //   441: aload_0
    //   442: getfield 62	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   445: iconst_1
    //   446: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   449: new 110	java/lang/StringBuilder
    //   452: dup
    //   453: ldc 248
    //   455: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: astore 14
    //   460: aload_0
    //   461: getfield 92	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:r	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   464: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   467: ldc 253
    //   469: invokevirtual 259	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   472: ifeq +64 -> 536
    //   475: aload_0
    //   476: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   479: invokevirtual 263	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   482: astore 15
    //   484: aload 15
    //   486: ifnull +50 -> 536
    //   489: aload 15
    //   491: instanceof 177
    //   494: ifeq +42 -> 536
    //   497: aload 15
    //   499: checkcast 177	java/net/InetSocketAddress
    //   502: invokevirtual 267	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   505: invokevirtual 272	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   508: astore 15
    //   510: aload 14
    //   512: ldc_w 274
    //   515: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 14
    //   521: aload 15
    //   523: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 14
    //   529: ldc_w 276
    //   532: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: new 110	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   543: astore 15
    //   545: aload 15
    //   547: ldc_w 278
    //   550: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 15
    //   556: aload_1
    //   557: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   560: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 15
    //   566: ldc 124
    //   568: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 15
    //   574: aload_1
    //   575: getfield 126	com/tencent/mobileqq/richmedia/conn/HostInfo:b	I
    //   578: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 15
    //   584: ldc 131
    //   586: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 15
    //   592: aload_0
    //   593: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   596: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 15
    //   602: ldc_w 280
    //   605: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 15
    //   611: lload 10
    //   613: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 15
    //   619: ldc_w 282
    //   622: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 15
    //   628: aload 14
    //   630: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 15
    //   639: ldc_w 284
    //   642: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 15
    //   648: aload_0
    //   649: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   652: invokevirtual 288	java/net/Socket:getLocalPort	()I
    //   655: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: ldc 136
    //   661: iconst_1
    //   662: aload 15
    //   664: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: aload_0
    //   671: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   674: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   677: iconst_1
    //   678: istore 6
    //   680: iload 4
    //   682: istore_2
    //   683: goto +251 -> 934
    //   686: astore 14
    //   688: iconst_1
    //   689: istore 6
    //   691: iload 5
    //   693: istore_2
    //   694: goto +251 -> 945
    //   697: astore 14
    //   699: iconst_1
    //   700: istore 6
    //   702: iload_3
    //   703: istore_2
    //   704: goto +209 -> 913
    //   707: astore 14
    //   709: iconst_1
    //   710: istore 6
    //   712: lload 10
    //   714: lstore 8
    //   716: goto +42 -> 758
    //   719: astore 14
    //   721: iconst_1
    //   722: istore 6
    //   724: goto +20 -> 744
    //   727: astore 14
    //   729: iconst_1
    //   730: istore 6
    //   732: lload 10
    //   734: lstore 8
    //   736: goto +19 -> 755
    //   739: astore 14
    //   741: iconst_0
    //   742: istore 6
    //   744: bipush 14
    //   746: istore_2
    //   747: goto +166 -> 913
    //   750: astore 14
    //   752: iconst_0
    //   753: istore 6
    //   755: bipush 14
    //   757: istore_2
    //   758: aload_0
    //   759: getfield 83	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:p	Lcom/tencent/mobileqq/richmedia/conn/ConnManager;
    //   762: invokevirtual 297	com/tencent/mobileqq/richmedia/conn/ConnManager:a	()Z
    //   765: istore 7
    //   767: new 110	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   774: astore 15
    //   776: aload 15
    //   778: ldc_w 299
    //   781: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload 15
    //   787: aload_1
    //   788: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   791: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 15
    //   797: ldc 124
    //   799: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 15
    //   805: aload_1
    //   806: getfield 126	com/tencent/mobileqq/richmedia/conn/HostInfo:b	I
    //   809: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 15
    //   815: ldc 131
    //   817: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 15
    //   823: aload_0
    //   824: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   827: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 15
    //   833: ldc_w 280
    //   836: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload 15
    //   842: lload 8
    //   844: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload 15
    //   850: ldc_w 301
    //   853: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 15
    //   859: iload 7
    //   861: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: ldc 136
    //   867: iconst_1
    //   868: aload 15
    //   870: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: aload 14
    //   875: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   878: aload_0
    //   879: aload 14
    //   881: iload 7
    //   883: invokespecial 310	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(Ljava/lang/Throwable;Z)I
    //   886: istore_3
    //   887: aload_0
    //   888: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   891: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   894: iload_3
    //   895: istore_2
    //   896: goto +38 -> 934
    //   899: astore 14
    //   901: iload_3
    //   902: istore_2
    //   903: goto +42 -> 945
    //   906: astore 14
    //   908: goto +5 -> 913
    //   911: astore 14
    //   913: aload_0
    //   914: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   917: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   920: aload 14
    //   922: athrow
    //   923: astore 14
    //   925: goto +20 -> 945
    //   928: iconst_0
    //   929: istore 6
    //   931: bipush 14
    //   933: istore_2
    //   934: goto +70 -> 1004
    //   937: astore 14
    //   939: iconst_0
    //   940: istore 6
    //   942: bipush 14
    //   944: istore_2
    //   945: new 110	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   952: astore 15
    //   954: aload 15
    //   956: ldc_w 312
    //   959: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload 15
    //   965: aload_1
    //   966: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   969: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload 15
    //   975: ldc 124
    //   977: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload 15
    //   983: aload_1
    //   984: getfield 126	com/tencent/mobileqq/richmedia/conn/HostInfo:b	I
    //   987: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: ldc 136
    //   993: iconst_1
    //   994: aload 15
    //   996: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: aload 14
    //   1001: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1004: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   1007: lstore 8
    //   1009: aload_0
    //   1010: getfield 314	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:m	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   1013: ifnull +125 -> 1138
    //   1016: new 110	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1023: astore 14
    //   1025: aload 14
    //   1027: ldc_w 316
    //   1030: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload 14
    //   1036: aload_0
    //   1037: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   1040: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: aload 14
    //   1046: ldc_w 318
    //   1049: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload 14
    //   1055: iload 6
    //   1057: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload 14
    //   1063: ldc_w 320
    //   1066: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload 14
    //   1072: iload_2
    //   1073: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload 14
    //   1079: ldc_w 322
    //   1082: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload 14
    //   1088: lload 8
    //   1090: lload 12
    //   1092: lsub
    //   1093: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload 14
    //   1099: ldc_w 324
    //   1102: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: ldc 136
    //   1108: iconst_1
    //   1109: aload 14
    //   1111: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1114: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1117: aload_0
    //   1118: getfield 314	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:m	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   1121: iload 6
    //   1123: aload_0
    //   1124: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   1127: aload_0
    //   1128: aload_0
    //   1129: getfield 92	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:r	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   1132: iload_2
    //   1133: invokeinterface 329 7 0
    //   1138: iload 6
    //   1140: ifeq +12 -> 1152
    //   1143: aload_0
    //   1144: getfield 331	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:t	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   1147: invokevirtual 335	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:b	()V
    //   1150: iload_2
    //   1151: ireturn
    //   1152: new 337	java/util/HashMap
    //   1155: dup
    //   1156: invokespecial 338	java/util/HashMap:<init>	()V
    //   1159: astore 14
    //   1161: new 110	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1168: astore 15
    //   1170: aload 15
    //   1172: ldc_w 340
    //   1175: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 15
    //   1181: iload_2
    //   1182: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 14
    //   1188: ldc_w 342
    //   1191: aload 15
    //   1193: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokevirtual 346	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1199: pop
    //   1200: new 110	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   1207: astore 15
    //   1209: aload 15
    //   1211: ldc_w 340
    //   1214: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 15
    //   1220: aload_1
    //   1221: getfield 122	com/tencent/mobileqq/richmedia/conn/HostInfo:a	Ljava/lang/String;
    //   1224: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: aload 14
    //   1230: ldc_w 348
    //   1233: aload 15
    //   1235: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokevirtual 346	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1241: pop
    //   1242: invokestatic 354	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1245: invokestatic 360	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1248: aconst_null
    //   1249: ldc_w 362
    //   1252: iconst_1
    //   1253: lconst_0
    //   1254: lconst_0
    //   1255: aload 14
    //   1257: aconst_null
    //   1258: invokevirtual 366	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1261: aload_0
    //   1262: getfield 331	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:t	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   1265: invokevirtual 368	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:a	()V
    //   1268: iload_2
    //   1269: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1270	0	this	LiteTcpConnection
    //   0	1270	1	paramHostInfo	HostInfo
    //   92	1177	2	i1	int
    //   84	818	3	i2	int
    //   86	595	4	i3	int
    //   89	603	5	i4	int
    //   81	1058	6	bool1	boolean
    //   765	117	7	bool2	boolean
    //   163	926	8	l1	long
    //   139	594	10	l2	long
    //   134	957	12	l3	long
    //   7	622	14	localStringBuilder	StringBuilder
    //   686	1	14	localInterruptedException1	java.lang.InterruptedException
    //   697	1	14	localObject1	Object
    //   707	1	14	localThrowable1	Throwable
    //   719	1	14	localObject2	Object
    //   727	1	14	localThrowable2	Throwable
    //   739	1	14	localObject3	Object
    //   750	130	14	localThrowable3	Throwable
    //   899	1	14	localInterruptedException2	java.lang.InterruptedException
    //   906	1	14	localObject4	Object
    //   911	10	14	localObject5	Object
    //   923	1	14	localInterruptedException3	java.lang.InterruptedException
    //   937	63	14	localInterruptedException4	java.lang.InterruptedException
    //   1023	233	14	localObject6	Object
    //   482	752	15	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   670	677	686	java/lang/InterruptedException
    //   536	670	697	finally
    //   536	670	707	java/lang/Throwable
    //   449	484	719	finally
    //   489	536	719	finally
    //   449	484	727	java/lang/Throwable
    //   489	536	727	java/lang/Throwable
    //   165	184	739	finally
    //   188	196	739	finally
    //   200	211	739	finally
    //   215	223	739	finally
    //   227	235	739	finally
    //   239	250	739	finally
    //   254	263	739	finally
    //   267	272	739	finally
    //   276	291	739	finally
    //   295	305	739	finally
    //   309	320	739	finally
    //   324	346	739	finally
    //   350	362	739	finally
    //   366	376	739	finally
    //   380	387	739	finally
    //   391	409	739	finally
    //   413	421	739	finally
    //   425	437	739	finally
    //   441	449	739	finally
    //   165	184	750	java/lang/Throwable
    //   188	196	750	java/lang/Throwable
    //   200	211	750	java/lang/Throwable
    //   215	223	750	java/lang/Throwable
    //   227	235	750	java/lang/Throwable
    //   239	250	750	java/lang/Throwable
    //   254	263	750	java/lang/Throwable
    //   267	272	750	java/lang/Throwable
    //   276	291	750	java/lang/Throwable
    //   295	305	750	java/lang/Throwable
    //   309	320	750	java/lang/Throwable
    //   324	346	750	java/lang/Throwable
    //   350	362	750	java/lang/Throwable
    //   366	376	750	java/lang/Throwable
    //   380	387	750	java/lang/Throwable
    //   391	409	750	java/lang/Throwable
    //   413	421	750	java/lang/Throwable
    //   425	437	750	java/lang/Throwable
    //   441	449	750	java/lang/Throwable
    //   887	894	899	java/lang/InterruptedException
    //   821	887	906	finally
    //   758	821	911	finally
    //   913	923	923	java/lang/InterruptedException
    //   141	156	937	java/lang/InterruptedException
  }
  
  private int a(Throwable paramThrowable, boolean paramBoolean)
  {
    paramThrowable = paramThrowable.toString().toLowerCase();
    int i1 = 7;
    if (!paramBoolean) {}
    do
    {
      return 3;
      if (paramThrowable.indexOf("illegal") > -1) {
        return 1;
      }
      if (paramThrowable.indexOf("route to host") > -1) {
        return 2;
      }
    } while (paramThrowable.indexOf("unreachable") > -1);
    if (paramThrowable.indexOf("permission") > -1) {
      return 4;
    }
    if (paramThrowable.indexOf("refused") > -1) {
      return 5;
    }
    if (paramThrowable.indexOf("reset") > -1) {
      return 6;
    }
    if (paramThrowable.indexOf("timeoutexception") <= -1)
    {
      if (paramThrowable.indexOf(") after") > -1) {
        return 7;
      }
      if (paramThrowable.indexOf("unknownhost") > -1) {
        return 8;
      }
      if (paramThrowable.indexOf("unresolved") > -1) {
        return 9;
      }
      if (paramThrowable.indexOf("enotsock") > -1) {
        return 10;
      }
      if (paramThrowable.indexOf("enobufs") > -1) {
        return 11;
      }
      if (paramThrowable.indexOf("ebadf") > -1) {
        return 12;
      }
      if (paramThrowable.indexOf("operation") > -1) {
        return 7;
      }
      if (paramThrowable.indexOf("invalid") > -1) {
        return 13;
      }
      i1 = 14;
    }
    return i1;
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 416
    //   14: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 5
    //   20: aload_0
    //   21: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   24: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: ldc_w 418
    //   33: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: iload_1
    //   40: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 136
    //   46: iconst_1
    //   47: aload 5
    //   49: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: getfield 74	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:o	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: astore 5
    //   61: iconst_0
    //   62: istore_3
    //   63: iconst_0
    //   64: istore 4
    //   66: iconst_0
    //   67: istore_2
    //   68: aload 5
    //   70: iconst_0
    //   71: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   74: aload_0
    //   75: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   78: ifnull +171 -> 249
    //   81: aload_0
    //   82: getfield 62	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   85: invokevirtual 149	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   88: ifne +4 -> 92
    //   91: return
    //   92: aload_0
    //   93: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: ldc2_w 164
    //   99: getstatic 171	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   102: invokevirtual 175	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   105: ifeq +130 -> 235
    //   108: aload_0
    //   109: getfield 208	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:h	Ljava/io/OutputStream;
    //   112: astore 5
    //   114: aload_0
    //   115: getfield 331	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:t	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   118: astore 5
    //   120: aload 5
    //   122: ifnull +8 -> 130
    //   125: aload 5
    //   127: invokevirtual 368	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:a	()V
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 68	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:j	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 208	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:h	Ljava/io/OutputStream;
    //   140: aload_0
    //   141: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   151: invokevirtual 421	java/net/Socket:close	()V
    //   154: aload_0
    //   155: getfield 62	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   158: iconst_0
    //   159: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   162: aload_0
    //   163: aconst_null
    //   164: putfield 185	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:g	Ljava/net/Socket;
    //   167: aload_0
    //   168: getfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   171: ifnull +16 -> 187
    //   174: aload_0
    //   175: getfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   178: invokevirtual 424	android/os/HandlerThread:quit	()Z
    //   181: pop
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 226	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:v	Landroid/os/HandlerThread;
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 242	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:w	Landroid/os/Handler;
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:u	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   197: aload_0
    //   198: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   201: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   204: iconst_1
    //   205: istore_2
    //   206: goto +75 -> 281
    //   209: astore 5
    //   211: iconst_1
    //   212: istore_2
    //   213: goto +39 -> 252
    //   216: astore 5
    //   218: iconst_1
    //   219: istore_2
    //   220: goto +50 -> 270
    //   223: astore 5
    //   225: aload_0
    //   226: getfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:b	Ljava/util/concurrent/locks/ReentrantLock;
    //   229: invokevirtual 293	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   232: aload 5
    //   234: athrow
    //   235: aload_0
    //   236: getfield 64	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   239: iconst_1
    //   240: invokevirtual 152	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   243: iload 4
    //   245: istore_2
    //   246: goto +35 -> 281
    //   249: return
    //   250: astore 5
    //   252: ldc 136
    //   254: iconst_1
    //   255: ldc_w 426
    //   258: aload 5
    //   260: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto +18 -> 281
    //   266: astore 5
    //   268: iload_3
    //   269: istore_2
    //   270: ldc 136
    //   272: iconst_1
    //   273: ldc_w 426
    //   276: aload 5
    //   278: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_0
    //   282: getfield 314	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:m	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   285: astore 5
    //   287: aload 5
    //   289: ifnull +15 -> 304
    //   292: aload 5
    //   294: aload_0
    //   295: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   298: aload_0
    //   299: invokeinterface 429 4 0
    //   304: new 110	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   311: astore 5
    //   313: aload 5
    //   315: ldc_w 431
    //   318: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 5
    //   324: aload_0
    //   325: getfield 90	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:q	J
    //   328: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 5
    //   334: ldc_w 433
    //   337: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 5
    //   343: iload_2
    //   344: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 136
    //   350: iconst_1
    //   351: aload 5
    //   353: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: return
    //   360: astore 5
    //   362: goto -208 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	LiteTcpConnection
    //   0	365	1	paramInt	int
    //   67	277	2	bool1	boolean
    //   62	207	3	bool2	boolean
    //   64	180	4	bool3	boolean
    //   7	119	5	localObject1	Object
    //   209	1	5	localException1	Exception
    //   216	1	5	localInterruptedException1	java.lang.InterruptedException
    //   223	10	5	localObject2	Object
    //   250	9	5	localException2	Exception
    //   266	11	5	localInterruptedException2	java.lang.InterruptedException
    //   285	67	5	localObject3	Object
    //   360	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   197	204	209	java/lang/Exception
    //   197	204	216	java/lang/InterruptedException
    //   114	120	223	finally
    //   125	130	223	finally
    //   130	140	223	finally
    //   140	154	223	finally
    //   154	187	223	finally
    //   187	197	223	finally
    //   74	91	250	java/lang/Exception
    //   92	114	250	java/lang/Exception
    //   225	235	250	java/lang/Exception
    //   235	243	250	java/lang/Exception
    //   74	91	266	java/lang/InterruptedException
    //   92	114	266	java/lang/InterruptedException
    //   225	235	266	java/lang/InterruptedException
    //   235	243	266	java/lang/InterruptedException
    //   140	154	360	java/lang/Exception
  }
  
  private void c()
  {
    if (this.n.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "do send data break ");
      }
      return;
    }
    try
    {
      this.n.set(true);
    }
    catch (Exception localException1)
    {
      byte[] arrayOfByte;
      Object localObject;
      label82:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("By SendWorker :");
        ((StringBuilder)localObject).append(localException1.getMessage());
        ((StringBuilder)localObject).append(";");
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, ((StringBuilder)localObject).toString());
      }
      a(2);
      return;
    }
    try
    {
      arrayOfByte = this.p.b();
      if (arrayOfByte == null)
      {
        this.n.set(false);
        return;
      }
      localObject = this.h;
      if (localObject != null)
      {
        ((OutputStream)localObject).write(arrayOfByte);
        ((OutputStream)localObject).flush();
      }
      this.n.set(false);
      return;
    }
    catch (Exception localException2)
    {
      break label82;
    }
    this.n.set(false);
  }
  
  public void a()
  {
    this.s.start();
    this.t = new LiteTcpConnection.ConnWorker(this, this.s.getLooper());
    this.t.sendEmptyMessage(1);
  }
  
  public void a(IConnectionListener paramIConnectionListener)
  {
    this.m = paramIConnectionListener;
  }
  
  public void b()
  {
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection
 * JD-Core Version:    0.7.0.1
 */