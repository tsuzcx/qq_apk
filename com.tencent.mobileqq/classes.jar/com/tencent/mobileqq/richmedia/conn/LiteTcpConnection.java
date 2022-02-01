package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.HandlerThread;
import badf;
import badg;
import badh;
import badi;
import badj;
import badk;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LiteTcpConnection
  implements badh
{
  private int jdField_a_of_type_Int;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private badf jdField_a_of_type_Badf;
  private badg jdField_a_of_type_Badg;
  private badi jdField_a_of_type_Badi;
  private badj jdField_a_of_type_Badj;
  private badk jdField_a_of_type_Badk = new badk();
  private LiteTcpConnection.ReadRunnable jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable;
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
  
  public LiteTcpConnection(badf parambadf, long paramLong, badg parambadg, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Badf = parambadf;
    this.jdField_b_of_type_Int = 32768;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Badg = parambadg;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("SubTitle-CONN", 0);
  }
  
  /* Error */
  private int a(badg parambadg)
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
    //   16: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 101
    //   24: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 102	badg:jdField_a_of_type_Int	I
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
    //   125: ifeq +945 -> 1070
    //   128: lload 6
    //   130: lstore 4
    //   132: aload_0
    //   133: new 151	java/net/InetSocketAddress
    //   136: dup
    //   137: aload_1
    //   138: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: aload_1
    //   142: getfield 102	badg:jdField_a_of_type_Int	I
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
    //   318: new 197	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable
    //   321: dup
    //   322: aload_0
    //   323: invokespecial 200	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection;)V
    //   326: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
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
    //   397: getfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
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
    //   431: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badg	Lbadg;
    //   434: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   518: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 101
    //   526: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: getfield 102	badg:jdField_a_of_type_Int	I
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
    //   611: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badi	Lbadi;
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
    //   688: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badi	Lbadi;
    //   691: iload 10
    //   693: aload_0
    //   694: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 65	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badg	Lbadg;
    //   702: iload_2
    //   703: invokeinterface 294 7 0
    //   708: iload 10
    //   710: ifeq +195 -> 905
    //   713: aload_0
    //   714: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badj	Lbadj;
    //   717: invokevirtual 300	badj:b	()V
    //   720: iload_2
    //   721: ireturn
    //   722: astore 12
    //   724: bipush 14
    //   726: istore_2
    //   727: iconst_0
    //   728: istore 10
    //   730: aload_0
    //   731: getfield 56	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badf	Lbadf;
    //   734: invokevirtual 304	badf:a	()Z
    //   737: istore 11
    //   739: ldc 85
    //   741: iconst_1
    //   742: new 87	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   749: ldc_w 306
    //   752: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_1
    //   756: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   759: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: ldc 101
    //   764: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_1
    //   768: getfield 102	badg:jdField_a_of_type_Int	I
    //   771: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: ldc 107
    //   776: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_0
    //   780: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   783: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   786: ldc_w 260
    //   789: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: lload 4
    //   794: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   797: ldc_w 308
    //   800: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload 11
    //   805: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   808: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: aload 12
    //   813: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   816: aload_0
    //   817: aload 12
    //   819: iload 11
    //   821: invokespecial 314	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(Ljava/lang/Throwable;Z)I
    //   824: istore_3
    //   825: iload_3
    //   826: istore_2
    //   827: aload_0
    //   828: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   831: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   834: goto -229 -> 605
    //   837: astore 12
    //   839: ldc 85
    //   841: iconst_1
    //   842: new 87	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   849: ldc_w 316
    //   852: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_1
    //   856: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   859: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: ldc 101
    //   864: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload_1
    //   868: getfield 102	badg:jdField_a_of_type_Int	I
    //   871: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: aload 12
    //   879: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   882: goto -277 -> 605
    //   885: astore 12
    //   887: iconst_0
    //   888: istore 10
    //   890: aload_0
    //   891: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   894: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   897: aload 12
    //   899: athrow
    //   900: astore 12
    //   902: goto -63 -> 839
    //   905: new 318	java/util/HashMap
    //   908: dup
    //   909: invokespecial 319	java/util/HashMap:<init>	()V
    //   912: astore 12
    //   914: aload 12
    //   916: ldc_w 321
    //   919: new 87	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   926: ldc_w 323
    //   929: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: iload_2
    //   933: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   936: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokevirtual 327	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   942: pop
    //   943: aload 12
    //   945: ldc_w 329
    //   948: new 87	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   955: ldc_w 323
    //   958: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload_1
    //   962: getfield 99	badg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   965: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokevirtual 327	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   974: pop
    //   975: invokestatic 335	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   978: invokestatic 341	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   981: aconst_null
    //   982: ldc_w 343
    //   985: iconst_1
    //   986: lconst_0
    //   987: lconst_0
    //   988: aload 12
    //   990: aconst_null
    //   991: invokevirtual 347	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   994: aload_0
    //   995: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badj	Lbadj;
    //   998: invokevirtual 349	badj:a	()V
    //   1001: iload_2
    //   1002: ireturn
    //   1003: astore 12
    //   1005: bipush 14
    //   1007: istore_2
    //   1008: iconst_0
    //   1009: istore 10
    //   1011: goto -172 -> 839
    //   1014: astore 12
    //   1016: iconst_0
    //   1017: istore_2
    //   1018: iconst_1
    //   1019: istore 10
    //   1021: goto -182 -> 839
    //   1024: astore 12
    //   1026: goto -136 -> 890
    //   1029: astore 12
    //   1031: iconst_0
    //   1032: istore_2
    //   1033: goto -143 -> 890
    //   1036: astore 12
    //   1038: goto -148 -> 890
    //   1041: astore 12
    //   1043: bipush 14
    //   1045: istore_2
    //   1046: iconst_1
    //   1047: istore 10
    //   1049: lload 6
    //   1051: lstore 4
    //   1053: goto -323 -> 730
    //   1056: astore 12
    //   1058: iconst_1
    //   1059: istore 10
    //   1061: lload 6
    //   1063: lstore 4
    //   1065: iconst_0
    //   1066: istore_2
    //   1067: goto -337 -> 730
    //   1070: iconst_0
    //   1071: istore 10
    //   1073: bipush 14
    //   1075: istore_2
    //   1076: goto -471 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1079	0	this	LiteTcpConnection
    //   0	1079	1	parambadg	badg
    //   97	979	2	i	int
    //   824	2	3	j	int
    //   130	934	4	l1	long
    //   106	956	6	l2	long
    //   101	569	8	l3	long
    //   121	951	10	bool1	boolean
    //   737	83	11	bool2	boolean
    //   428	138	12	localStringBuilder	java.lang.StringBuilder
    //   722	96	12	localThrowable1	Throwable
    //   837	41	12	localInterruptedException1	java.lang.InterruptedException
    //   885	13	12	localObject1	Object
    //   900	1	12	localInterruptedException2	java.lang.InterruptedException
    //   912	77	12	localHashMap	java.util.HashMap
    //   1003	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1014	1	12	localInterruptedException4	java.lang.InterruptedException
    //   1024	1	12	localObject2	Object
    //   1029	1	12	localObject3	Object
    //   1036	1	12	localObject4	Object
    //   1041	1	12	localThrowable2	Throwable
    //   1056	1	12	localThrowable3	Throwable
    //   452	36	13	localObject5	Object
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
    //   827	834	837	java/lang/InterruptedException
    //   132	151	885	finally
    //   155	163	885	finally
    //   167	178	885	finally
    //   182	190	885	finally
    //   194	202	885	finally
    //   206	217	885	finally
    //   221	230	885	finally
    //   234	239	885	finally
    //   243	258	885	finally
    //   262	272	885	finally
    //   276	287	885	finally
    //   291	313	885	finally
    //   317	329	885	finally
    //   333	343	885	finally
    //   347	354	885	finally
    //   358	376	885	finally
    //   380	388	885	finally
    //   392	404	885	finally
    //   408	416	885	finally
    //   890	900	900	java/lang/InterruptedException
    //   108	123	1003	java/lang/InterruptedException
    //   595	602	1014	java/lang/InterruptedException
    //   419	454	1024	finally
    //   459	499	1024	finally
    //   501	595	1029	finally
    //   730	825	1036	finally
    //   419	454	1041	java/lang/Throwable
    //   459	499	1041	java/lang/Throwable
    //   501	595	1056	java/lang/Throwable
  }
  
  private int a(Throwable paramThrowable, boolean paramBoolean)
  {
    paramThrowable = paramThrowable.toString().toLowerCase();
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
    if ((paramThrowable.indexOf("timeoutexception") > -1) || (paramThrowable.indexOf(") after") > -1)) {
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
    return 14;
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
    //   17: ldc_w 402
    //   20: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 404
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
    //   100: getfield 296	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badj	Lbadj;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnull +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 349	badj:a	()V
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
    //   136: invokevirtual 407	java/net/Socket:close	()V
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
    //   163: invokevirtual 410	android/os/HandlerThread:quit	()Z
    //   166: pop
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   172: aload_0
    //   173: aconst_null
    //   174: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   182: aload_0
    //   183: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   186: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   189: iconst_1
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 276	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Badi	Lbadi;
    //   195: astore 5
    //   197: aload 5
    //   199: ifnull +15 -> 214
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   208: aload_0
    //   209: invokeinterface 413 4 0
    //   214: ldc 85
    //   216: iconst_1
    //   217: new 87	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 415
    //   227: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: getfield 63	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   234: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc_w 417
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
    //   273: ldc_w 419
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
    //   303: ldc_w 419
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
  
  private void c()
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
        arrayOfByte = this.jdField_a_of_type_Badf.a();
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
    this.jdField_a_of_type_Badj = new badj(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Badj.sendEmptyMessage(1);
  }
  
  public void a(badi parambadi)
  {
    this.jdField_a_of_type_Badi = parambadi;
  }
  
  public void b()
  {
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection
 * JD-Core Version:    0.7.0.1
 */