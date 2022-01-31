package com.tencent.mobileqq.richmedia.conn;

import ahrx;
import ahry;
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
  private int jdField_a_of_type_Int;
  public long a;
  private ahrx jdField_a_of_type_Ahrx;
  private ahry jdField_a_of_type_Ahry;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ConnManager jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager;
  private HostInfo jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
  private IConnectionListener jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener;
  private SubTitleProtocoDataCodec jdField_a_of_type_ComTencentMobileqqRichmediaConnSubTitleProtocoDataCodec = new SubTitleProtocoDataCodec();
  private MsfSocketInputBuffer jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private InetSocketAddress jdField_a_of_type_JavaNetInetSocketAddress;
  private Socket jdField_a_of_type_JavaNetSocket;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock(true);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_c_of_type_Int;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  
  public LiteTcpConnection(ConnManager paramConnManager, long paramLong, HostInfo paramHostInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager = paramConnManager;
    this.jdField_b_of_type_Int = 32768;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo = paramHostInfo;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("SubTitle-CONN", 0);
  }
  
  /* Error */
  private int a(HostInfo paramHostInfo)
  {
    // Byte code:
    //   0: ldc 85
    //   2: iconst_1
    //   3: new 87	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   10: ldc 90
    //   12: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 101
    //   24: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 102	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   31: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc 107
    //   36: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   43: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: invokevirtual 123	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   59: ifne +13 -> 72
    //   62: aload_0
    //   63: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   66: invokevirtual 123	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   69: ifeq +26 -> 95
    //   72: aload_0
    //   73: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: invokevirtual 123	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   79: ifeq +16 -> 95
    //   82: aload_0
    //   83: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   86: iconst_0
    //   87: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   90: aload_0
    //   91: iconst_2
    //   92: invokespecial 129	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(I)V
    //   95: bipush 14
    //   97: istore_2
    //   98: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   101: lstore 8
    //   103: ldc2_w 136
    //   106: lstore 6
    //   108: aload_0
    //   109: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: ldc2_w 138
    //   115: getstatic 145	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   118: invokevirtual 149	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   121: istore 10
    //   123: iload 10
    //   125: ifeq +1294 -> 1419
    //   128: lload 6
    //   130: lstore 4
    //   132: aload_0
    //   133: new 151	java/net/InetSocketAddress
    //   136: dup
    //   137: aload_1
    //   138: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: aload_1
    //   142: getfield 102	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   145: invokespecial 154	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   148: putfield 156	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetInetSocketAddress	Ljava/net/InetSocketAddress;
    //   151: lload 6
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   159: iconst_0
    //   160: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   163: lload 6
    //   165: lstore 4
    //   167: aload_0
    //   168: new 158	java/net/Socket
    //   171: dup
    //   172: invokespecial 159	java/net/Socket:<init>	()V
    //   175: putfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   178: lload 6
    //   180: lstore 4
    //   182: aload_0
    //   183: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   186: iconst_1
    //   187: invokevirtual 164	java/net/Socket:setKeepAlive	(Z)V
    //   190: lload 6
    //   192: lstore 4
    //   194: aload_0
    //   195: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   198: iconst_1
    //   199: invokevirtual 167	java/net/Socket:setTcpNoDelay	(Z)V
    //   202: lload 6
    //   204: lstore 4
    //   206: aload_0
    //   207: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   210: aload_0
    //   211: getfield 61	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Int	I
    //   214: invokevirtual 170	java/net/Socket:setSoTimeout	(I)V
    //   217: lload 6
    //   219: lstore 4
    //   221: aload_0
    //   222: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   225: ldc 171
    //   227: invokevirtual 174	java/net/Socket:setSendBufferSize	(I)V
    //   230: lload 6
    //   232: lstore 4
    //   234: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   237: lstore 6
    //   239: lload 6
    //   241: lstore 4
    //   243: aload_0
    //   244: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   247: aload_0
    //   248: getfield 156	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetInetSocketAddress	Ljava/net/InetSocketAddress;
    //   251: aload_0
    //   252: getfield 67	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_c_of_type_Int	I
    //   255: invokevirtual 178	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   258: lload 6
    //   260: lstore 4
    //   262: aload_0
    //   263: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   266: lload 6
    //   268: lsub
    //   269: putfield 180	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Long	J
    //   272: lload 6
    //   274: lstore 4
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   281: invokevirtual 184	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   284: putfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   287: lload 6
    //   289: lstore 4
    //   291: aload_0
    //   292: new 188	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   295: dup
    //   296: aload_0
    //   297: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   300: aload_0
    //   301: getfield 59	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Int	I
    //   304: ldc 190
    //   306: iconst_m1
    //   307: invokespecial 193	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   310: putfield 195	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   313: lload 6
    //   315: lstore 4
    //   317: aload_0
    //   318: new 197	ahry
    //   321: dup
    //   322: aload_0
    //   323: invokespecial 200	ahry:<init>	(Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection;)V
    //   326: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahry	Lahry;
    //   329: lload 6
    //   331: lstore 4
    //   333: aload_0
    //   334: ldc 204
    //   336: iconst_0
    //   337: invokestatic 75	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   340: putfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   343: lload 6
    //   345: lstore 4
    //   347: aload_0
    //   348: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   351: invokevirtual 211	android/os/HandlerThread:start	()V
    //   354: lload 6
    //   356: lstore 4
    //   358: aload_0
    //   359: new 213	android/os/Handler
    //   362: dup
    //   363: aload_0
    //   364: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   367: invokevirtual 217	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   370: invokespecial 220	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   373: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   376: lload 6
    //   378: lstore 4
    //   380: aload_0
    //   381: getfield 49	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   384: iconst_1
    //   385: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   388: lload 6
    //   390: lstore 4
    //   392: aload_0
    //   393: getfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   396: aload_0
    //   397: getfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahry	Lahry;
    //   400: invokevirtual 226	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   403: pop
    //   404: lload 6
    //   406: lstore 4
    //   408: aload_0
    //   409: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   412: iconst_1
    //   413: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   416: iconst_1
    //   417: istore 10
    //   419: new 87	java/lang/StringBuilder
    //   422: dup
    //   423: ldc 228
    //   425: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: astore 12
    //   430: aload_0
    //   431: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   434: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   437: ldc 233
    //   439: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   442: ifeq +57 -> 499
    //   445: aload_0
    //   446: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   449: invokevirtual 243	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   452: astore 13
    //   454: aload 13
    //   456: ifnull +43 -> 499
    //   459: aload 13
    //   461: instanceof 151
    //   464: ifeq +35 -> 499
    //   467: aload 13
    //   469: checkcast 151	java/net/InetSocketAddress
    //   472: invokevirtual 247	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   475: invokevirtual 252	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   478: astore 13
    //   480: aload 12
    //   482: ldc 254
    //   484: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 13
    //   489: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 256
    //   495: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: iconst_0
    //   500: istore_2
    //   501: ldc 85
    //   503: iconst_1
    //   504: new 87	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 258
    //   514: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_1
    //   518: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 101
    //   526: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: getfield 102	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   533: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc 107
    //   538: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_0
    //   542: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   545: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: ldc_w 260
    //   551: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: lload 6
    //   556: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   559: ldc_w 262
    //   562: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 12
    //   567: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc_w 264
    //   576: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_0
    //   580: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   583: invokevirtual 268	java/net/Socket:getLocalPort	()I
    //   586: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   599: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   602: iconst_1
    //   603: istore 10
    //   605: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   608: lstore 4
    //   610: aload_0
    //   611: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   614: ifnull +94 -> 708
    //   617: ldc 85
    //   619: iconst_1
    //   620: new 87	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 278
    //   630: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload_0
    //   634: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   637: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: ldc_w 280
    //   643: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload 10
    //   648: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   651: ldc_w 285
    //   654: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: iload_2
    //   658: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: ldc_w 287
    //   664: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: lload 4
    //   669: lload 8
    //   671: lsub
    //   672: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 289
    //   678: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: aload_0
    //   688: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   691: iload 10
    //   693: aload_0
    //   694: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   702: iload_2
    //   703: invokeinterface 294 7 0
    //   708: iload 10
    //   710: ifeq +536 -> 1246
    //   713: aload_0
    //   714: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahrx	Lahrx;
    //   717: invokevirtual 300	ahrx:b	()V
    //   720: iload_2
    //   721: ireturn
    //   722: astore 12
    //   724: bipush 14
    //   726: istore_2
    //   727: iconst_0
    //   728: istore 10
    //   730: iload_2
    //   731: istore_3
    //   732: aload_0
    //   733: getfield 56	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager	Lcom/tencent/mobileqq/richmedia/conn/ConnManager;
    //   736: invokevirtual 304	com/tencent/mobileqq/richmedia/conn/ConnManager:a	()Z
    //   739: istore 11
    //   741: iload_2
    //   742: istore_3
    //   743: ldc 85
    //   745: iconst_1
    //   746: new 87	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 306
    //   756: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_1
    //   760: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   763: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: ldc 101
    //   768: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_1
    //   772: getfield 102	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   775: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: ldc 107
    //   780: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_0
    //   784: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   787: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: ldc_w 260
    //   793: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: lload 4
    //   798: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   801: ldc_w 308
    //   804: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: iload 11
    //   809: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   812: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: aload 12
    //   817: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   820: iload_2
    //   821: istore_3
    //   822: aload 12
    //   824: invokevirtual 312	java/lang/Throwable:toString	()Ljava/lang/String;
    //   827: invokevirtual 315	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   830: astore 13
    //   832: iload 11
    //   834: ifne +63 -> 897
    //   837: iconst_3
    //   838: istore_2
    //   839: aload_0
    //   840: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   843: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   846: goto -241 -> 605
    //   849: astore 12
    //   851: ldc 85
    //   853: iconst_1
    //   854: new 87	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 317
    //   864: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload_1
    //   868: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   871: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc 101
    //   876: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: getfield 102	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   883: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   886: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: aload 12
    //   891: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   894: goto -289 -> 605
    //   897: iload_2
    //   898: istore_3
    //   899: aload 13
    //   901: ldc_w 319
    //   904: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   907: iconst_m1
    //   908: if_icmple +8 -> 916
    //   911: iconst_1
    //   912: istore_2
    //   913: goto -74 -> 839
    //   916: iload_2
    //   917: istore_3
    //   918: aload 13
    //   920: ldc_w 325
    //   923: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   926: iconst_m1
    //   927: if_icmple +8 -> 935
    //   930: iconst_2
    //   931: istore_2
    //   932: goto -93 -> 839
    //   935: iload_2
    //   936: istore_3
    //   937: aload 13
    //   939: ldc_w 327
    //   942: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   945: iconst_m1
    //   946: if_icmple +8 -> 954
    //   949: iconst_3
    //   950: istore_2
    //   951: goto -112 -> 839
    //   954: iload_2
    //   955: istore_3
    //   956: aload 13
    //   958: ldc_w 329
    //   961: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   964: iconst_m1
    //   965: if_icmple +8 -> 973
    //   968: iconst_4
    //   969: istore_2
    //   970: goto -131 -> 839
    //   973: iload_2
    //   974: istore_3
    //   975: aload 13
    //   977: ldc_w 331
    //   980: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   983: iconst_m1
    //   984: if_icmple +8 -> 992
    //   987: iconst_5
    //   988: istore_2
    //   989: goto -150 -> 839
    //   992: iload_2
    //   993: istore_3
    //   994: aload 13
    //   996: ldc_w 333
    //   999: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1002: iconst_m1
    //   1003: if_icmple +9 -> 1012
    //   1006: bipush 6
    //   1008: istore_2
    //   1009: goto -170 -> 839
    //   1012: iload_2
    //   1013: istore_3
    //   1014: aload 13
    //   1016: ldc_w 335
    //   1019: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1022: iconst_m1
    //   1023: if_icmpgt +405 -> 1428
    //   1026: iload_2
    //   1027: istore_3
    //   1028: aload 13
    //   1030: ldc_w 337
    //   1033: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1036: iconst_m1
    //   1037: if_icmple +6 -> 1043
    //   1040: goto +388 -> 1428
    //   1043: iload_2
    //   1044: istore_3
    //   1045: aload 13
    //   1047: ldc_w 339
    //   1050: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1053: iconst_m1
    //   1054: if_icmple +9 -> 1063
    //   1057: bipush 8
    //   1059: istore_2
    //   1060: goto -221 -> 839
    //   1063: iload_2
    //   1064: istore_3
    //   1065: aload 13
    //   1067: ldc_w 341
    //   1070: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1073: iconst_m1
    //   1074: if_icmple +9 -> 1083
    //   1077: bipush 9
    //   1079: istore_2
    //   1080: goto -241 -> 839
    //   1083: iload_2
    //   1084: istore_3
    //   1085: aload 13
    //   1087: ldc_w 343
    //   1090: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1093: iconst_m1
    //   1094: if_icmple +9 -> 1103
    //   1097: bipush 10
    //   1099: istore_2
    //   1100: goto -261 -> 839
    //   1103: iload_2
    //   1104: istore_3
    //   1105: aload 13
    //   1107: ldc_w 345
    //   1110: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1113: iconst_m1
    //   1114: if_icmple +9 -> 1123
    //   1117: bipush 11
    //   1119: istore_2
    //   1120: goto -281 -> 839
    //   1123: iload_2
    //   1124: istore_3
    //   1125: aload 13
    //   1127: ldc_w 347
    //   1130: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1133: iconst_m1
    //   1134: if_icmple +9 -> 1143
    //   1137: bipush 12
    //   1139: istore_2
    //   1140: goto -301 -> 839
    //   1143: iload_2
    //   1144: istore_3
    //   1145: aload 13
    //   1147: ldc_w 349
    //   1150: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1153: iconst_m1
    //   1154: if_icmple +9 -> 1163
    //   1157: bipush 7
    //   1159: istore_2
    //   1160: goto -321 -> 839
    //   1163: iload_2
    //   1164: istore_3
    //   1165: aload 13
    //   1167: ldc_w 351
    //   1170: invokevirtual 323	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1173: iconst_m1
    //   1174: if_icmple +9 -> 1183
    //   1177: bipush 13
    //   1179: istore_2
    //   1180: goto -341 -> 839
    //   1183: bipush 14
    //   1185: istore_2
    //   1186: iload_2
    //   1187: istore_3
    //   1188: aload 12
    //   1190: invokestatic 357	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1193: astore 12
    //   1195: iload_2
    //   1196: istore_3
    //   1197: aload 12
    //   1199: invokevirtual 360	java/lang/String:length	()I
    //   1202: sipush 200
    //   1205: if_icmple +208 -> 1413
    //   1208: iload_2
    //   1209: istore_3
    //   1210: aload 12
    //   1212: iconst_0
    //   1213: sipush 200
    //   1216: invokevirtual 364	java/lang/String:substring	(II)Ljava/lang/String;
    //   1219: pop
    //   1220: bipush 14
    //   1222: istore_2
    //   1223: goto -384 -> 839
    //   1226: astore 12
    //   1228: iconst_0
    //   1229: istore 10
    //   1231: aload_0
    //   1232: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1235: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1238: aload 12
    //   1240: athrow
    //   1241: astore 12
    //   1243: goto -392 -> 851
    //   1246: new 366	java/util/HashMap
    //   1249: dup
    //   1250: invokespecial 367	java/util/HashMap:<init>	()V
    //   1253: astore 12
    //   1255: aload 12
    //   1257: ldc_w 369
    //   1260: new 87	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1267: ldc_w 371
    //   1270: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: iload_2
    //   1274: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokevirtual 375	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1283: pop
    //   1284: aload 12
    //   1286: ldc_w 377
    //   1289: new 87	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 371
    //   1299: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload_1
    //   1303: getfield 99	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1306: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1312: invokevirtual 375	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1315: pop
    //   1316: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1319: invokestatic 388	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1322: aconst_null
    //   1323: ldc_w 390
    //   1326: iconst_1
    //   1327: lconst_0
    //   1328: lconst_0
    //   1329: aload 12
    //   1331: aconst_null
    //   1332: invokevirtual 393	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1335: aload_0
    //   1336: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahrx	Lahrx;
    //   1339: invokevirtual 395	ahrx:a	()V
    //   1342: iload_2
    //   1343: ireturn
    //   1344: astore 12
    //   1346: bipush 14
    //   1348: istore_2
    //   1349: iconst_0
    //   1350: istore 10
    //   1352: goto -501 -> 851
    //   1355: astore 12
    //   1357: iconst_0
    //   1358: istore_2
    //   1359: iconst_1
    //   1360: istore 10
    //   1362: goto -511 -> 851
    //   1365: astore 12
    //   1367: goto -136 -> 1231
    //   1370: astore 12
    //   1372: iconst_0
    //   1373: istore_2
    //   1374: goto -143 -> 1231
    //   1377: astore 12
    //   1379: iload_3
    //   1380: istore_2
    //   1381: goto -150 -> 1231
    //   1384: astore 12
    //   1386: bipush 14
    //   1388: istore_2
    //   1389: iconst_1
    //   1390: istore 10
    //   1392: lload 6
    //   1394: lstore 4
    //   1396: goto -666 -> 730
    //   1399: astore 12
    //   1401: iconst_1
    //   1402: istore 10
    //   1404: lload 6
    //   1406: lstore 4
    //   1408: iconst_0
    //   1409: istore_2
    //   1410: goto -680 -> 730
    //   1413: bipush 14
    //   1415: istore_2
    //   1416: goto -577 -> 839
    //   1419: iconst_0
    //   1420: istore 10
    //   1422: bipush 14
    //   1424: istore_2
    //   1425: goto -820 -> 605
    //   1428: bipush 7
    //   1430: istore_2
    //   1431: goto -592 -> 839
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1434	0	this	LiteTcpConnection
    //   0	1434	1	paramHostInfo	HostInfo
    //   97	1334	2	i	int
    //   731	649	3	j	int
    //   130	1277	4	l1	long
    //   106	1299	6	l2	long
    //   101	569	8	l3	long
    //   121	1300	10	bool1	boolean
    //   739	94	11	bool2	boolean
    //   428	138	12	localStringBuilder	java.lang.StringBuilder
    //   722	101	12	localThrowable1	java.lang.Throwable
    //   849	340	12	localInterruptedException1	java.lang.InterruptedException
    //   1193	18	12	str	java.lang.String
    //   1226	13	12	localObject1	Object
    //   1241	1	12	localInterruptedException2	java.lang.InterruptedException
    //   1253	77	12	localHashMap	java.util.HashMap
    //   1344	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1355	1	12	localInterruptedException4	java.lang.InterruptedException
    //   1365	1	12	localObject2	Object
    //   1370	1	12	localObject3	Object
    //   1377	1	12	localObject4	Object
    //   1384	1	12	localThrowable2	java.lang.Throwable
    //   1399	1	12	localThrowable3	java.lang.Throwable
    //   452	714	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   132	151	722	java/lang/Throwable
    //   155	163	722	java/lang/Throwable
    //   167	178	722	java/lang/Throwable
    //   182	190	722	java/lang/Throwable
    //   194	202	722	java/lang/Throwable
    //   206	217	722	java/lang/Throwable
    //   221	230	722	java/lang/Throwable
    //   234	239	722	java/lang/Throwable
    //   243	258	722	java/lang/Throwable
    //   262	272	722	java/lang/Throwable
    //   276	287	722	java/lang/Throwable
    //   291	313	722	java/lang/Throwable
    //   317	329	722	java/lang/Throwable
    //   333	343	722	java/lang/Throwable
    //   347	354	722	java/lang/Throwable
    //   358	376	722	java/lang/Throwable
    //   380	388	722	java/lang/Throwable
    //   392	404	722	java/lang/Throwable
    //   408	416	722	java/lang/Throwable
    //   839	846	849	java/lang/InterruptedException
    //   132	151	1226	finally
    //   155	163	1226	finally
    //   167	178	1226	finally
    //   182	190	1226	finally
    //   194	202	1226	finally
    //   206	217	1226	finally
    //   221	230	1226	finally
    //   234	239	1226	finally
    //   243	258	1226	finally
    //   262	272	1226	finally
    //   276	287	1226	finally
    //   291	313	1226	finally
    //   317	329	1226	finally
    //   333	343	1226	finally
    //   347	354	1226	finally
    //   358	376	1226	finally
    //   380	388	1226	finally
    //   392	404	1226	finally
    //   408	416	1226	finally
    //   1231	1241	1241	java/lang/InterruptedException
    //   108	123	1344	java/lang/InterruptedException
    //   595	602	1355	java/lang/InterruptedException
    //   419	454	1365	finally
    //   459	499	1365	finally
    //   501	595	1370	finally
    //   732	741	1377	finally
    //   743	820	1377	finally
    //   822	832	1377	finally
    //   899	911	1377	finally
    //   918	930	1377	finally
    //   937	949	1377	finally
    //   956	968	1377	finally
    //   975	987	1377	finally
    //   994	1006	1377	finally
    //   1014	1026	1377	finally
    //   1028	1040	1377	finally
    //   1045	1057	1377	finally
    //   1065	1077	1377	finally
    //   1085	1097	1377	finally
    //   1105	1117	1377	finally
    //   1125	1137	1377	finally
    //   1145	1157	1377	finally
    //   1165	1177	1377	finally
    //   1188	1195	1377	finally
    //   1197	1208	1377	finally
    //   1210	1220	1377	finally
    //   419	454	1384	java/lang/Throwable
    //   459	499	1384	java/lang/Throwable
    //   501	595	1399	java/lang/Throwable
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: ldc 85
    //   9: iconst_1
    //   10: new 87	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 410
    //   20: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 412
    //   33: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_1
    //   37: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 49	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: iconst_0
    //   51: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   54: aload_0
    //   55: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   58: ifnull +275 -> 333
    //   61: aload_0
    //   62: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   65: invokevirtual 123	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   68: ifne +4 -> 72
    //   71: return
    //   72: aload_0
    //   73: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: ldc2_w 138
    //   79: getstatic 145	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   82: invokevirtual 149	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   85: ifeq +199 -> 284
    //   88: aload_0
    //   89: getfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +3 -> 99
    //   99: aload_0
    //   100: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahrx	Lahrx;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnull +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 395	ahrx:a	()V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 195	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 186	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   125: aload_0
    //   126: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   129: ifnull +10 -> 139
    //   132: aload_0
    //   133: getfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   136: invokevirtual 415	java/net/Socket:close	()V
    //   139: aload_0
    //   140: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   143: iconst_0
    //   144: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 161	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   152: aload_0
    //   153: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   156: ifnull +16 -> 172
    //   159: aload_0
    //   160: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   163: invokevirtual 418	android/os/HandlerThread:quit	()Z
    //   166: pop
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   172: aload_0
    //   173: aconst_null
    //   174: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Ahry	Lahry;
    //   182: aload_0
    //   183: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   186: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   189: iconst_1
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   195: astore 5
    //   197: aload 5
    //   199: ifnull +15 -> 214
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   208: aload_0
    //   209: invokeinterface 421 4 0
    //   214: ldc 85
    //   216: iconst_1
    //   217: new 87	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 423
    //   227: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   234: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc_w 425
    //   240: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_2
    //   244: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: astore 5
    //   256: aload_0
    //   257: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: aload 5
    //   265: athrow
    //   266: astore 5
    //   268: iload_3
    //   269: istore_2
    //   270: ldc 85
    //   272: iconst_1
    //   273: ldc_w 427
    //   276: aload 5
    //   278: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: goto -90 -> 191
    //   284: aload_0
    //   285: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   288: iconst_1
    //   289: invokevirtual 126	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   292: goto -101 -> 191
    //   295: astore 5
    //   297: iload 4
    //   299: istore_2
    //   300: ldc 85
    //   302: iconst_1
    //   303: ldc_w 427
    //   306: aload 5
    //   308: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -120 -> 191
    //   314: astore 5
    //   316: iconst_1
    //   317: istore_2
    //   318: goto -18 -> 300
    //   321: astore 5
    //   323: iconst_1
    //   324: istore_2
    //   325: goto -55 -> 270
    //   328: astore 5
    //   330: goto -191 -> 139
    //   333: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	LiteTcpConnection
    //   0	334	1	paramInt	int
    //   6	319	2	bool1	boolean
    //   1	268	3	bool2	boolean
    //   3	295	4	bool3	boolean
    //   92	111	5	localObject1	Object
    //   254	10	5	localObject2	Object
    //   266	11	5	localInterruptedException1	java.lang.InterruptedException
    //   295	12	5	localException1	Exception
    //   314	1	5	localException2	Exception
    //   321	1	5	localInterruptedException2	java.lang.InterruptedException
    //   328	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   99	105	254	finally
    //   110	115	254	finally
    //   115	125	254	finally
    //   125	139	254	finally
    //   139	172	254	finally
    //   172	182	254	finally
    //   54	71	266	java/lang/InterruptedException
    //   72	94	266	java/lang/InterruptedException
    //   256	266	266	java/lang/InterruptedException
    //   284	292	266	java/lang/InterruptedException
    //   54	71	295	java/lang/Exception
    //   72	94	295	java/lang/Exception
    //   256	266	295	java/lang/Exception
    //   284	292	295	java/lang/Exception
    //   182	189	314	java/lang/Exception
    //   182	189	321	java/lang/InterruptedException
    //   125	139	328	java/lang/Exception
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "do send data break ");
      }
      return;
    }
    try
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      byte[] arrayOfByte;
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager.a();
        if (arrayOfByte != null) {
          break label113;
        }
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      catch (Exception localException2)
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      localException1 = localException1;
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "By SendWorker :" + localException1.getMessage() + ";");
      }
      a(2);
      return;
    }
    label113:
    OutputStream localOutputStream;
    if (localOutputStream != null)
    {
      localOutputStream.write(localException2);
      localOutputStream.flush();
    }
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Ahrx = new ahrx(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Ahrx.sendEmptyMessage(1);
  }
  
  public void a(IConnectionListener paramIConnectionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener = paramIConnectionListener;
  }
  
  public void b()
  {
    a(3);
  }
  
  public void c()
  {
    ahrx localahrx = this.jdField_a_of_type_Ahrx;
    if ((this.d.get()) && (localahrx != null)) {
      localahrx.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection
 * JD-Core Version:    0.7.0.1
 */