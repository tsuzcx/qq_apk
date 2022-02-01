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
  private int jdField_a_of_type_Int;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ConnManager jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager;
  private HostInfo jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo;
  private IConnectionListener jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener;
  private LiteTcpConnection.ConnWorker jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker;
  private LiteTcpConnection.ReadRunnable jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable;
  private SubTitleProtocoDataCodec jdField_a_of_type_ComTencentMobileqqRichmediaConnSubTitleProtocoDataCodec = new SubTitleProtocoDataCodec();
  private MsfSocketInputBuffer jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = null;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private InetSocketAddress jdField_a_of_type_JavaNetInetSocketAddress = null;
  private Socket jdField_a_of_type_JavaNetSocket;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock(true);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_c_of_type_Int = 0;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  
  public LiteTcpConnection(ConnManager paramConnManager, long paramLong, HostInfo paramHostInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = 0L;
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
    //   0: new 91	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: ldc 94
    //   13: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 14
    //   19: aload_1
    //   20: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 14
    //   29: ldc 105
    //   31: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 14
    //   37: aload_1
    //   38: getfield 106	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   41: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 14
    //   47: ldc 111
    //   49: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 14
    //   55: aload_0
    //   56: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   59: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 116
    //   65: iconst_1
    //   66: aload 14
    //   68: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 129	java/util/concurrent/atomic/AtomicBoolean:get	()Z
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
    //   99: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: invokevirtual 129	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   105: ifeq +26 -> 131
    //   108: aload_0
    //   109: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   112: invokevirtual 129	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   115: ifeq +16 -> 131
    //   118: aload_0
    //   119: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   122: iconst_0
    //   123: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   126: aload_0
    //   127: iconst_2
    //   128: invokespecial 135	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(I)V
    //   131: invokestatic 141	android/os/SystemClock:uptimeMillis	()J
    //   134: lstore 12
    //   136: ldc2_w 142
    //   139: lstore 10
    //   141: aload_0
    //   142: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   145: ldc2_w 144
    //   148: getstatic 151	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   151: invokevirtual 155	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   154: istore 6
    //   156: iload 6
    //   158: ifeq +769 -> 927
    //   161: lload 10
    //   163: lstore 8
    //   165: aload_0
    //   166: new 157	java/net/InetSocketAddress
    //   169: dup
    //   170: aload_1
    //   171: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: aload_1
    //   175: getfield 106	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   178: invokespecial 160	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   181: putfield 47	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetInetSocketAddress	Ljava/net/InetSocketAddress;
    //   184: lload 10
    //   186: lstore 8
    //   188: aload_0
    //   189: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   192: iconst_0
    //   193: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   196: lload 10
    //   198: lstore 8
    //   200: aload_0
    //   201: new 162	java/net/Socket
    //   204: dup
    //   205: invokespecial 163	java/net/Socket:<init>	()V
    //   208: putfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   211: lload 10
    //   213: lstore 8
    //   215: aload_0
    //   216: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   219: iconst_1
    //   220: invokevirtual 168	java/net/Socket:setKeepAlive	(Z)V
    //   223: lload 10
    //   225: lstore 8
    //   227: aload_0
    //   228: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   231: iconst_1
    //   232: invokevirtual 171	java/net/Socket:setTcpNoDelay	(Z)V
    //   235: lload 10
    //   237: lstore 8
    //   239: aload_0
    //   240: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   243: aload_0
    //   244: getfield 69	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Int	I
    //   247: invokevirtual 174	java/net/Socket:setSoTimeout	(I)V
    //   250: lload 10
    //   252: lstore 8
    //   254: aload_0
    //   255: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   258: ldc 175
    //   260: invokevirtual 178	java/net/Socket:setSendBufferSize	(I)V
    //   263: lload 10
    //   265: lstore 8
    //   267: invokestatic 141	android/os/SystemClock:uptimeMillis	()J
    //   270: lstore 10
    //   272: lload 10
    //   274: lstore 8
    //   276: aload_0
    //   277: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   280: aload_0
    //   281: getfield 47	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetInetSocketAddress	Ljava/net/InetSocketAddress;
    //   284: aload_0
    //   285: getfield 51	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_c_of_type_Int	I
    //   288: invokevirtual 182	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   291: lload 10
    //   293: lstore 8
    //   295: aload_0
    //   296: invokestatic 141	android/os/SystemClock:uptimeMillis	()J
    //   299: lload 10
    //   301: lsub
    //   302: putfield 57	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_Long	J
    //   305: lload 10
    //   307: lstore 8
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   314: invokevirtual 186	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   317: putfield 188	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   320: lload 10
    //   322: lstore 8
    //   324: aload_0
    //   325: new 190	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   328: dup
    //   329: aload_0
    //   330: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   333: aload_0
    //   334: getfield 67	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Int	I
    //   337: ldc 192
    //   339: iconst_m1
    //   340: invokespecial 195	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   343: putfield 49	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   346: lload 10
    //   348: lstore 8
    //   350: aload_0
    //   351: new 197	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable
    //   354: dup
    //   355: aload_0
    //   356: invokespecial 200	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection;)V
    //   359: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   362: lload 10
    //   364: lstore 8
    //   366: aload_0
    //   367: ldc 204
    //   369: iconst_0
    //   370: invokestatic 81	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   373: putfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   376: lload 10
    //   378: lstore 8
    //   380: aload_0
    //   381: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   384: invokevirtual 211	android/os/HandlerThread:start	()V
    //   387: lload 10
    //   389: lstore 8
    //   391: aload_0
    //   392: new 213	android/os/Handler
    //   395: dup
    //   396: aload_0
    //   397: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   400: invokevirtual 217	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   403: invokespecial 220	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   406: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   409: lload 10
    //   411: lstore 8
    //   413: aload_0
    //   414: getfield 55	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   417: iconst_1
    //   418: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   421: lload 10
    //   423: lstore 8
    //   425: aload_0
    //   426: getfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   429: aload_0
    //   430: getfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   433: invokevirtual 226	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   436: pop
    //   437: lload 10
    //   439: lstore 8
    //   441: aload_0
    //   442: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   445: iconst_1
    //   446: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   449: new 91	java/lang/StringBuilder
    //   452: dup
    //   453: ldc 228
    //   455: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: astore 14
    //   460: aload_0
    //   461: getfield 73	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   464: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   467: ldc 233
    //   469: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   472: ifeq +63 -> 535
    //   475: aload_0
    //   476: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   479: invokevirtual 243	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   482: astore 15
    //   484: aload 15
    //   486: ifnull +49 -> 535
    //   489: aload 15
    //   491: instanceof 157
    //   494: ifeq +41 -> 535
    //   497: aload 15
    //   499: checkcast 157	java/net/InetSocketAddress
    //   502: invokevirtual 247	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   505: invokevirtual 252	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   508: astore 15
    //   510: aload 14
    //   512: ldc 254
    //   514: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 14
    //   520: aload 15
    //   522: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 14
    //   528: ldc_w 256
    //   531: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: new 91	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   542: astore 15
    //   544: aload 15
    //   546: ldc_w 258
    //   549: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 15
    //   555: aload_1
    //   556: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 15
    //   565: ldc 105
    //   567: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 15
    //   573: aload_1
    //   574: getfield 106	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   577: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 15
    //   583: ldc 111
    //   585: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 15
    //   591: aload_0
    //   592: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   595: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 15
    //   601: ldc_w 260
    //   604: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 15
    //   610: lload 10
    //   612: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 15
    //   618: ldc_w 262
    //   621: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 15
    //   627: aload 14
    //   629: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 15
    //   638: ldc_w 264
    //   641: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload 15
    //   647: aload_0
    //   648: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   651: invokevirtual 268	java/net/Socket:getLocalPort	()I
    //   654: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: ldc 116
    //   660: iconst_1
    //   661: aload 15
    //   663: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload_0
    //   670: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   673: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   676: iconst_1
    //   677: istore 6
    //   679: iload 4
    //   681: istore_2
    //   682: goto +251 -> 933
    //   685: astore 14
    //   687: iconst_1
    //   688: istore 6
    //   690: iload 5
    //   692: istore_2
    //   693: goto +251 -> 944
    //   696: astore 14
    //   698: iconst_1
    //   699: istore 6
    //   701: iload_3
    //   702: istore_2
    //   703: goto +209 -> 912
    //   706: astore 14
    //   708: iconst_1
    //   709: istore 6
    //   711: lload 10
    //   713: lstore 8
    //   715: goto +42 -> 757
    //   718: astore 14
    //   720: iconst_1
    //   721: istore 6
    //   723: goto +20 -> 743
    //   726: astore 14
    //   728: iconst_1
    //   729: istore 6
    //   731: lload 10
    //   733: lstore 8
    //   735: goto +19 -> 754
    //   738: astore 14
    //   740: iconst_0
    //   741: istore 6
    //   743: bipush 14
    //   745: istore_2
    //   746: goto +166 -> 912
    //   749: astore 14
    //   751: iconst_0
    //   752: istore 6
    //   754: bipush 14
    //   756: istore_2
    //   757: aload_0
    //   758: getfield 64	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager	Lcom/tencent/mobileqq/richmedia/conn/ConnManager;
    //   761: invokevirtual 278	com/tencent/mobileqq/richmedia/conn/ConnManager:a	()Z
    //   764: istore 7
    //   766: new 91	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   773: astore 15
    //   775: aload 15
    //   777: ldc_w 280
    //   780: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 15
    //   786: aload_1
    //   787: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   790: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload 15
    //   796: ldc 105
    //   798: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 15
    //   804: aload_1
    //   805: getfield 106	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   808: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 15
    //   814: ldc 111
    //   816: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 15
    //   822: aload_0
    //   823: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   826: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload 15
    //   832: ldc_w 260
    //   835: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 15
    //   841: lload 8
    //   843: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload 15
    //   849: ldc_w 282
    //   852: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload 15
    //   858: iload 7
    //   860: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: ldc 116
    //   866: iconst_1
    //   867: aload 15
    //   869: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: aload 14
    //   874: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: aload_0
    //   878: aload 14
    //   880: iload 7
    //   882: invokespecial 291	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:a	(Ljava/lang/Throwable;Z)I
    //   885: istore_3
    //   886: aload_0
    //   887: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   890: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   893: iload_3
    //   894: istore_2
    //   895: goto +38 -> 933
    //   898: astore 14
    //   900: iload_3
    //   901: istore_2
    //   902: goto +42 -> 944
    //   905: astore 14
    //   907: goto +5 -> 912
    //   910: astore 14
    //   912: aload_0
    //   913: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   916: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   919: aload 14
    //   921: athrow
    //   922: astore 14
    //   924: goto +20 -> 944
    //   927: iconst_0
    //   928: istore 6
    //   930: bipush 14
    //   932: istore_2
    //   933: goto +70 -> 1003
    //   936: astore 14
    //   938: iconst_0
    //   939: istore 6
    //   941: bipush 14
    //   943: istore_2
    //   944: new 91	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   951: astore 15
    //   953: aload 15
    //   955: ldc_w 293
    //   958: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload 15
    //   964: aload_1
    //   965: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   968: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 15
    //   974: ldc 105
    //   976: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 15
    //   982: aload_1
    //   983: getfield 106	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_Int	I
    //   986: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: ldc 116
    //   992: iconst_1
    //   993: aload 15
    //   995: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: aload 14
    //   1000: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1003: invokestatic 141	android/os/SystemClock:uptimeMillis	()J
    //   1006: lstore 8
    //   1008: aload_0
    //   1009: getfield 295	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   1012: ifnull +125 -> 1137
    //   1015: new 91	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1022: astore 14
    //   1024: aload 14
    //   1026: ldc_w 297
    //   1029: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 14
    //   1035: aload_0
    //   1036: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   1039: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 14
    //   1045: ldc_w 299
    //   1048: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: pop
    //   1052: aload 14
    //   1054: iload 6
    //   1056: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 14
    //   1062: ldc_w 301
    //   1065: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload 14
    //   1071: iload_2
    //   1072: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 14
    //   1078: ldc_w 303
    //   1081: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 14
    //   1087: lload 8
    //   1089: lload 12
    //   1091: lsub
    //   1092: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 14
    //   1098: ldc_w 305
    //   1101: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: ldc 116
    //   1107: iconst_1
    //   1108: aload 14
    //   1110: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: aload_0
    //   1117: getfield 295	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   1120: iload 6
    //   1122: aload_0
    //   1123: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   1126: aload_0
    //   1127: aload_0
    //   1128: getfield 73	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo	Lcom/tencent/mobileqq/richmedia/conn/HostInfo;
    //   1131: iload_2
    //   1132: invokeinterface 310 7 0
    //   1137: iload 6
    //   1139: ifeq +12 -> 1151
    //   1142: aload_0
    //   1143: getfield 312	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   1146: invokevirtual 316	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:b	()V
    //   1149: iload_2
    //   1150: ireturn
    //   1151: new 318	java/util/HashMap
    //   1154: dup
    //   1155: invokespecial 319	java/util/HashMap:<init>	()V
    //   1158: astore 14
    //   1160: new 91	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1167: astore 15
    //   1169: aload 15
    //   1171: ldc_w 321
    //   1174: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 15
    //   1180: iload_2
    //   1181: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 14
    //   1187: ldc_w 323
    //   1190: aload 15
    //   1192: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokevirtual 327	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1198: pop
    //   1199: new 91	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1206: astore 15
    //   1208: aload 15
    //   1210: ldc_w 321
    //   1213: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: aload 15
    //   1219: aload_1
    //   1220: getfield 103	com/tencent/mobileqq/richmedia/conn/HostInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1223: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: pop
    //   1227: aload 14
    //   1229: ldc_w 329
    //   1232: aload 15
    //   1234: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1237: invokevirtual 327	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1240: pop
    //   1241: invokestatic 335	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1244: invokestatic 341	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1247: aconst_null
    //   1248: ldc_w 343
    //   1251: iconst_1
    //   1252: lconst_0
    //   1253: lconst_0
    //   1254: aload 14
    //   1256: aconst_null
    //   1257: invokevirtual 347	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1260: aload_0
    //   1261: getfield 312	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   1264: invokevirtual 349	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:a	()V
    //   1267: iload_2
    //   1268: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1269	0	this	LiteTcpConnection
    //   0	1269	1	paramHostInfo	HostInfo
    //   92	1176	2	i	int
    //   84	817	3	j	int
    //   86	594	4	k	int
    //   89	602	5	m	int
    //   81	1057	6	bool1	boolean
    //   764	117	7	bool2	boolean
    //   163	925	8	l1	long
    //   139	593	10	l2	long
    //   134	956	12	l3	long
    //   7	621	14	localStringBuilder	StringBuilder
    //   685	1	14	localInterruptedException1	java.lang.InterruptedException
    //   696	1	14	localObject1	Object
    //   706	1	14	localThrowable1	Throwable
    //   718	1	14	localObject2	Object
    //   726	1	14	localThrowable2	Throwable
    //   738	1	14	localObject3	Object
    //   749	130	14	localThrowable3	Throwable
    //   898	1	14	localInterruptedException2	java.lang.InterruptedException
    //   905	1	14	localObject4	Object
    //   910	10	14	localObject5	Object
    //   922	1	14	localInterruptedException3	java.lang.InterruptedException
    //   936	63	14	localInterruptedException4	java.lang.InterruptedException
    //   1022	233	14	localObject6	Object
    //   482	751	15	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   669	676	685	java/lang/InterruptedException
    //   535	669	696	finally
    //   535	669	706	java/lang/Throwable
    //   449	484	718	finally
    //   489	535	718	finally
    //   449	484	726	java/lang/Throwable
    //   489	535	726	java/lang/Throwable
    //   165	184	738	finally
    //   188	196	738	finally
    //   200	211	738	finally
    //   215	223	738	finally
    //   227	235	738	finally
    //   239	250	738	finally
    //   254	263	738	finally
    //   267	272	738	finally
    //   276	291	738	finally
    //   295	305	738	finally
    //   309	320	738	finally
    //   324	346	738	finally
    //   350	362	738	finally
    //   366	376	738	finally
    //   380	387	738	finally
    //   391	409	738	finally
    //   413	421	738	finally
    //   425	437	738	finally
    //   441	449	738	finally
    //   165	184	749	java/lang/Throwable
    //   188	196	749	java/lang/Throwable
    //   200	211	749	java/lang/Throwable
    //   215	223	749	java/lang/Throwable
    //   227	235	749	java/lang/Throwable
    //   239	250	749	java/lang/Throwable
    //   254	263	749	java/lang/Throwable
    //   267	272	749	java/lang/Throwable
    //   276	291	749	java/lang/Throwable
    //   295	305	749	java/lang/Throwable
    //   309	320	749	java/lang/Throwable
    //   324	346	749	java/lang/Throwable
    //   350	362	749	java/lang/Throwable
    //   366	376	749	java/lang/Throwable
    //   380	387	749	java/lang/Throwable
    //   391	409	749	java/lang/Throwable
    //   413	421	749	java/lang/Throwable
    //   425	437	749	java/lang/Throwable
    //   441	449	749	java/lang/Throwable
    //   886	893	898	java/lang/InterruptedException
    //   820	886	905	finally
    //   757	820	910	finally
    //   912	922	922	java/lang/InterruptedException
    //   141	156	936	java/lang/InterruptedException
  }
  
  private int a(Throwable paramThrowable, boolean paramBoolean)
  {
    paramThrowable = paramThrowable.toString().toLowerCase();
    int i = 7;
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
      i = 14;
    }
    return i;
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: new 91	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 402
    //   14: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 5
    //   20: aload_0
    //   21: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   24: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: ldc_w 404
    //   33: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: iload_1
    //   40: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 116
    //   46: iconst_1
    //   47: aload 5
    //   49: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: getfield 55	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:d	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: astore 5
    //   61: iconst_0
    //   62: istore_3
    //   63: iconst_0
    //   64: istore 4
    //   66: iconst_0
    //   67: istore_2
    //   68: aload 5
    //   70: iconst_0
    //   71: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   74: aload_0
    //   75: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   78: ifnull +171 -> 249
    //   81: aload_0
    //   82: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   85: invokevirtual 129	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   88: ifne +4 -> 92
    //   91: return
    //   92: aload_0
    //   93: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: ldc2_w 144
    //   99: getstatic 151	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   102: invokevirtual 155	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   105: ifeq +130 -> 235
    //   108: aload_0
    //   109: getfield 188	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   112: astore 5
    //   114: aload_0
    //   115: getfield 312	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker;
    //   118: astore 5
    //   120: aload 5
    //   122: ifnull +8 -> 130
    //   125: aload 5
    //   127: invokevirtual 349	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ConnWorker:a	()V
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 49	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 188	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   140: aload_0
    //   141: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   151: invokevirtual 407	java/net/Socket:close	()V
    //   154: aload_0
    //   155: getfield 43	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   158: iconst_0
    //   159: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   162: aload_0
    //   163: aconst_null
    //   164: putfield 165	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaNetSocket	Ljava/net/Socket;
    //   167: aload_0
    //   168: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   171: ifnull +16 -> 187
    //   174: aload_0
    //   175: getfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   178: invokevirtual 410	android/os/HandlerThread:quit	()Z
    //   181: pop
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 206	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 222	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 202	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ReadRunnable	Lcom/tencent/mobileqq/richmedia/conn/LiteTcpConnection$ReadRunnable;
    //   197: aload_0
    //   198: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   201: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
    //   226: getfield 38	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   229: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   232: aload 5
    //   234: athrow
    //   235: aload_0
    //   236: getfield 45	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   239: iconst_1
    //   240: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   243: iload 4
    //   245: istore_2
    //   246: goto +35 -> 281
    //   249: return
    //   250: astore 5
    //   252: ldc 116
    //   254: iconst_1
    //   255: ldc_w 412
    //   258: aload 5
    //   260: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto +18 -> 281
    //   266: astore 5
    //   268: iload_3
    //   269: istore_2
    //   270: ldc 116
    //   272: iconst_1
    //   273: ldc_w 412
    //   276: aload 5
    //   278: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_0
    //   282: getfield 295	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener	Lcom/tencent/mobileqq/richmedia/conn/IConnectionListener;
    //   285: astore 5
    //   287: aload 5
    //   289: ifnull +15 -> 304
    //   292: aload 5
    //   294: aload_0
    //   295: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   298: aload_0
    //   299: invokeinterface 415 4 0
    //   304: new 91	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   311: astore 5
    //   313: aload 5
    //   315: ldc_w 417
    //   318: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 5
    //   324: aload_0
    //   325: getfield 71	com/tencent/mobileqq/richmedia/conn/LiteTcpConnection:jdField_b_of_type_Long	J
    //   328: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 5
    //   334: ldc_w 419
    //   337: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 5
    //   343: iload_2
    //   344: invokevirtual 285	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 116
    //   350: iconst_1
    //   351: aload 5
    //   353: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqRichmediaConnConnManager.a();
      if (arrayOfByte == null)
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      localObject = this.jdField_a_of_type_JavaIoOutputStream;
      if (localObject != null)
      {
        ((OutputStream)localObject).write(arrayOfByte);
        ((OutputStream)localObject).flush();
      }
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    catch (Exception localException2)
    {
      break label82;
    }
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker = new LiteTcpConnection.ConnWorker(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnLiteTcpConnection$ConnWorker.sendEmptyMessage(1);
  }
  
  public void a(IConnectionListener paramIConnectionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaConnIConnectionListener = paramIConnectionListener;
  }
  
  public void b()
  {
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.LiteTcpConnection
 * JD-Core Version:    0.7.0.1
 */