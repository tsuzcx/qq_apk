package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.segment.RequestHeartBreak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TcpConnection
  implements IProtocolCodecListener, IConnection
{
  public static final int DEDAULT_CONN_TIMEOUT_xG = 20000;
  public static final int DEFAULT_CONN_TIMEOUT_Wi = 10000;
  public static final int DEFAULT_READ_BUF_SIZE = 32768;
  public static final int DEFAULT_READ_TIMEOUT = 30000;
  public static final int DEFAULT_SEND_BUF_SIZE = 524288;
  public static final int HEARTBREAK_DELTA = 20000;
  public static volatile boolean IsRunTimeShutDown = false;
  private static final int MAX_CONTINUE_HREAT = 2;
  private StringBuilder closeDebug = new StringBuilder("ConnTag:");
  private int connId;
  private ConnReportInfo connInfo = new ConnReportInfo();
  private IConnectionListener connListener;
  private ConnManager connManager;
  private int continueHeartBreak = 0;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private boolean isIpv6;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent = false;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime = 0L;
  private ReentrantLock lock = new ReentrantLock();
  private TcpConnection.ConnWorker mConnHandler;
  private HandlerThread mConnThread;
  private int mConnTimeOut = 0;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer = null;
  public int mLastDataSegSize = 0;
  public long mLastDataTransTime = 0L;
  private int mNetFlowDw = 0;
  private int mNetFlowUp = 0;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private TcpConnection.ReadThread mReadThread;
  private int mReadTimeout;
  public long mRtt = 0L;
  private Handler mServletHandler = null;
  private Socket mSocket;
  private InetSocketAddress serverAddress = null;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  static
  {
    initRuntimShutDownHook();
  }
  
  public TcpConnection(ConnManager paramConnManager, int paramInt1, EndPoint paramEndPoint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramEndPoint.protoType == 2) {}
    for (this.dataCodec = new HttpProtocolDataCodec();; this.dataCodec = new TcpProtocolDataCodec())
    {
      this.connManager = paramConnManager;
      this.mReadBufferSize = 32768;
      this.mReadTimeout = paramInt3;
      this.connId = paramInt1;
      this.mEp = paramEndPoint;
      this.mConnTimeOut = paramInt2;
      this.mConnThread = new HandlerThread("Highway-BDH-CONN" + paramInt1);
      this.dataCodec.setProtocolCodecListener(this);
      this.mServletHandler = new Handler(Looper.getMainLooper());
      this.isIpv6 = paramBoolean;
      return;
    }
  }
  
  /* Error */
  private void closeConn(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 9
    //   11: iconst_0
    //   12: istore 10
    //   14: iconst_0
    //   15: istore 6
    //   17: ldc 252
    //   19: iconst_1
    //   20: new 112	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   27: ldc 254
    //   29: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   36: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 256
    //   42: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_1
    //   46: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: getfield 110	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   63: iload 9
    //   65: istore 4
    //   67: iload 10
    //   69: istore 5
    //   71: aload_0
    //   72: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   75: ifnull +451 -> 526
    //   78: iload 9
    //   80: istore 4
    //   82: iload 10
    //   84: istore 5
    //   86: aload_0
    //   87: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   90: invokevirtual 271	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   93: ifne +4 -> 97
    //   96: return
    //   97: iload 9
    //   99: istore 4
    //   101: iload 10
    //   103: istore 5
    //   105: aload_0
    //   106: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   109: ldc2_w 272
    //   112: getstatic 279	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   115: invokevirtual 283	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   118: ifeq +340 -> 458
    //   121: iload 9
    //   123: istore 4
    //   125: iload 10
    //   127: istore 5
    //   129: aload_0
    //   130: getfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   133: ifnull +42 -> 175
    //   136: iload 9
    //   138: istore 4
    //   140: iload 10
    //   142: istore 5
    //   144: aload_0
    //   145: getfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   148: getfield 289	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   151: astore 11
    //   153: aload 11
    //   155: ifnull +20 -> 175
    //   158: iload 9
    //   160: istore 4
    //   162: iload 10
    //   164: istore 5
    //   166: iconst_0
    //   167: aload 11
    //   169: invokevirtual 290	java/lang/Object:toString	()Ljava/lang/String;
    //   172: invokestatic 294	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   175: iload 9
    //   177: istore 4
    //   179: iload 10
    //   181: istore 5
    //   183: aload_0
    //   184: getfield 296	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   187: ifnull +22 -> 209
    //   190: iload 9
    //   192: istore 4
    //   194: iload 10
    //   196: istore 5
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield 296	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   203: invokevirtual 290	java/lang/Object:toString	()Ljava/lang/String;
    //   206: invokestatic 294	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 218	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   213: astore 11
    //   215: aload 11
    //   217: ifnull +8 -> 225
    //   220: aload 11
    //   222: invokevirtual 301	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   230: aload_0
    //   231: aconst_null
    //   232: putfield 296	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   235: aload_0
    //   236: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   239: ifnull +10 -> 249
    //   242: aload_0
    //   243: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   246: invokevirtual 306	java/net/Socket:close	()V
    //   249: aload_0
    //   250: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   253: iconst_0
    //   254: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   257: aload_0
    //   258: aconst_null
    //   259: putfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 308	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   267: aload_0
    //   268: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   271: iconst_1
    //   272: putfield 311	com/tencent/mobileqq/highway/conn/ConnReportInfo:finished	Z
    //   275: aload_0
    //   276: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   279: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   282: aload_0
    //   283: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   286: getfield 320	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   289: lsub
    //   290: putfield 323	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeLong	J
    //   293: aload_0
    //   294: getfield 129	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   297: istore_1
    //   298: aload_0
    //   299: getfield 131	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   302: istore_2
    //   303: aload_0
    //   304: iconst_0
    //   305: putfield 129	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 131	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   313: getstatic 78	com/tencent/mobileqq/highway/conn/TcpConnection:IsRunTimeShutDown	Z
    //   316: ifne +26 -> 342
    //   319: new 325	java/lang/Thread
    //   322: dup
    //   323: new 327	com/tencent/mobileqq/highway/conn/TcpConnection$2
    //   326: dup
    //   327: aload_0
    //   328: iload_1
    //   329: iload_2
    //   330: invokespecial 330	com/tencent/mobileqq/highway/conn/TcpConnection$2:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;II)V
    //   333: ldc_w 332
    //   336: invokespecial 335	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   339: invokevirtual 338	java/lang/Thread:start	()V
    //   342: aload_0
    //   343: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   346: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   349: aload_0
    //   350: getfield 343	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   353: astore 11
    //   355: aload 11
    //   357: ifnull +15 -> 372
    //   360: aload 11
    //   362: aload_0
    //   363: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   366: aload_0
    //   367: invokeinterface 349 3 0
    //   372: ldc_w 351
    //   375: new 112	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 353
    //   385: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_0
    //   389: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   392: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 355
    //   398: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iload_3
    //   402: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 364	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: return
    //   412: astore 11
    //   414: iload 6
    //   416: istore_3
    //   417: iload_3
    //   418: istore 4
    //   420: iload_3
    //   421: istore 5
    //   423: aload_0
    //   424: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   427: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   430: iload_3
    //   431: istore 4
    //   433: iload_3
    //   434: istore 5
    //   436: aload 11
    //   438: athrow
    //   439: astore 11
    //   441: iload 4
    //   443: istore_3
    //   444: ldc_w 351
    //   447: ldc_w 366
    //   450: aload 11
    //   452: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   455: goto -106 -> 349
    //   458: iload 9
    //   460: istore 4
    //   462: iload 10
    //   464: istore 5
    //   466: aload_0
    //   467: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   470: iconst_1
    //   471: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -127 -> 349
    //   479: astore 11
    //   481: iload 5
    //   483: istore_3
    //   484: ldc_w 351
    //   487: ldc_w 366
    //   490: aload 11
    //   492: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   495: goto -146 -> 349
    //   498: astore 11
    //   500: iload 8
    //   502: istore_3
    //   503: goto -19 -> 484
    //   506: astore 11
    //   508: iload 7
    //   510: istore_3
    //   511: goto -67 -> 444
    //   514: astore 11
    //   516: iconst_1
    //   517: istore_3
    //   518: goto -101 -> 417
    //   521: astore 11
    //   523: goto -274 -> 249
    //   526: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	TcpConnection
    //   0	527	1	paramInt	int
    //   302	28	2	i	int
    //   7	511	3	bool1	boolean
    //   65	396	4	bool2	boolean
    //   69	413	5	bool3	boolean
    //   15	400	6	bool4	boolean
    //   1	508	7	bool5	boolean
    //   4	497	8	bool6	boolean
    //   9	450	9	bool7	boolean
    //   12	451	10	bool8	boolean
    //   151	210	11	localObject1	Object
    //   412	25	11	localObject2	Object
    //   439	12	11	localInterruptedException1	java.lang.InterruptedException
    //   479	12	11	localException1	Exception
    //   498	1	11	localException2	Exception
    //   506	1	11	localInterruptedException2	java.lang.InterruptedException
    //   514	1	11	localObject3	Object
    //   521	1	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   209	215	412	finally
    //   220	225	412	finally
    //   225	235	412	finally
    //   235	249	412	finally
    //   249	267	412	finally
    //   71	78	439	java/lang/InterruptedException
    //   86	96	439	java/lang/InterruptedException
    //   105	121	439	java/lang/InterruptedException
    //   129	136	439	java/lang/InterruptedException
    //   144	153	439	java/lang/InterruptedException
    //   166	175	439	java/lang/InterruptedException
    //   183	190	439	java/lang/InterruptedException
    //   198	209	439	java/lang/InterruptedException
    //   423	430	439	java/lang/InterruptedException
    //   436	439	439	java/lang/InterruptedException
    //   466	474	439	java/lang/InterruptedException
    //   71	78	479	java/lang/Exception
    //   86	96	479	java/lang/Exception
    //   105	121	479	java/lang/Exception
    //   129	136	479	java/lang/Exception
    //   144	153	479	java/lang/Exception
    //   166	175	479	java/lang/Exception
    //   183	190	479	java/lang/Exception
    //   198	209	479	java/lang/Exception
    //   423	430	479	java/lang/Exception
    //   436	439	479	java/lang/Exception
    //   466	474	479	java/lang/Exception
    //   342	349	498	java/lang/Exception
    //   342	349	506	java/lang/InterruptedException
    //   267	342	514	finally
    //   235	249	521	java/lang/Exception
  }
  
  private void doSendData()
  {
    for (;;)
    {
      if ((!this.isRunning.get()) || (this.isWritting.get())) {
        label20:
        return;
      }
      try
      {
        ??? = this.connManager.pullNextRequest(this, this.isUrgent, this.mLastDataTransTime, this.mRtt, this.mLastDataSegSize);
        if (??? == null)
        {
          this.isWritting.set(false);
          if (SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) {
            break label20;
          }
          this.lastHeartBreakTime = SystemClock.uptimeMillis();
          ??? = this.connManager;
          i = this.connId;
          if (this.continueHeartBreak == 0)
          {
            bool = true;
            label102:
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        int i;
        boolean bool;
        BdhLogUtil.LogException("C", "SendThread Error.", localException2);
        synchronized (this.closeDebug)
        {
          this.closeDebug.append("By SendWorker :" + localException2.getMessage() + ";");
          closeConn(2);
          continue;
          bool = false;
          break label102;
          BdhLogUtil.LogEvent("R", "req sending: reqId = " + ((HwRequest)???).getHwSeq() + " req.timeOutCount = " + ((HwRequest)???).timeOutCount + " req.timeOut = " + ((HwRequest)???).timeOut);
          this.isWritting.set(true);
          ((HwRequest)???).endpoint = this.mEp;
          if ((??? instanceof RequestHeartBreak))
          {
            if (this.continueHeartBreak > 2)
            {
              this.connInfo.killSelf = true;
              closeConn(4);
              return;
            }
            this.continueHeartBreak += 1;
          }
          for (;;)
          {
            try
            {
              arrayOfByte = ((HwRequest)???).getRequestBody();
              if ((arrayOfByte != null) || (!((HwRequest)???).hasRequestBody())) {
                break label375;
              }
              ((HwRequest)???).reqListener.handleError(-1004, "NullBody", this);
              this.isWritting.set(false);
            }
            catch (Exception localException1)
            {
              this.isWritting.set(false);
            }
            break;
            this.continueHeartBreak = 0;
            this.lastHeartBreakTime = 0L;
          }
          label375:
          byte[] arrayOfByte = this.dataCodec.encodeC2SData(this.mEp, localException1, arrayOfByte);
          if (arrayOfByte == null)
          {
            this.isWritting.set(false);
            continue;
          }
          if (localException1.retryCount == 0)
          {
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentRequestCount += 1;
            localObject3 = this.connInfo;
            ((ConnReportInfo)localObject3).sentDataLen += arrayOfByte.length;
            localException1.sendTime = SystemClock.uptimeMillis();
            long l1 = SystemClock.uptimeMillis();
            localObject3 = this.mOutputStream;
            if (localObject3 != null)
            {
              ((OutputStream)localObject3).write(arrayOfByte);
              ((OutputStream)localObject3).flush();
            }
            i = arrayOfByte.length;
            this.connManager.increaseDataFlowUp(i);
            long l2 = SystemClock.uptimeMillis();
            this.mNetFlowUp = (i + this.mNetFlowUp);
            localException1.reqListener.handleSendEnd(this.connId, getProtoType());
            BdhLogUtil.LogEvent("R", "SendRequest End. CostTrace  reqId: " + localException1.getHwSeq() + " SendComsume:" + localException1.sendComsume + " WriteComsume:" + (l2 - l1) + " ConnID:" + this.connId + " ReqInfo:" + localException1.dumpBaseInfo() + " ContinueHeartBreak:" + this.continueHeartBreak);
            this.isWritting.set(false);
            continue;
          }
          Object localObject3 = this.connInfo;
          ((ConnReportInfo)localObject3).sentRetryCount += 1;
        }
      }
    }
  }
  
  private static void initRuntimShutDownHook()
  {
    Runtime.getRuntime().addShutdownHook(new TcpConnection.1());
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc 252
    //   2: iconst_1
    //   3: new 112	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 515
    //   13: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 521
    //   26: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 526
    //   39: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   46: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 528
    //   52: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 147	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 530
    //   65: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 271	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: ifne +13 -> 94
    //   84: aload_0
    //   85: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 271	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifeq +26 -> 117
    //   94: aload_0
    //   95: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   98: invokevirtual 271	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   101: ifeq +16 -> 117
    //   104: aload_0
    //   105: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   108: iconst_0
    //   109: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   112: aload_0
    //   113: iconst_2
    //   114: invokespecial 238	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   117: bipush 14
    //   119: istore_2
    //   120: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   123: lstore 8
    //   125: ldc2_w 531
    //   128: lstore 6
    //   130: aload_0
    //   131: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   134: ldc2_w 272
    //   137: getstatic 279	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   140: invokevirtual 283	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   143: istore 10
    //   145: iload 10
    //   147: ifeq +1250 -> 1397
    //   150: lload 6
    //   152: lstore 4
    //   154: aload_0
    //   155: new 534	java/net/InetSocketAddress
    //   158: dup
    //   159: aload_1
    //   160: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   163: aload_1
    //   164: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   167: invokespecial 537	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   170: putfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   173: lload 6
    //   175: lstore 4
    //   177: aload_0
    //   178: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   181: iconst_0
    //   182: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   185: lload 6
    //   187: lstore 4
    //   189: aload_0
    //   190: new 303	java/net/Socket
    //   193: dup
    //   194: invokespecial 538	java/net/Socket:<init>	()V
    //   197: putfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   200: lload 6
    //   202: lstore 4
    //   204: aload_0
    //   205: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   208: iconst_1
    //   209: invokevirtual 541	java/net/Socket:setKeepAlive	(Z)V
    //   212: lload 6
    //   214: lstore 4
    //   216: aload_0
    //   217: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   220: iconst_1
    //   221: invokevirtual 544	java/net/Socket:setTcpNoDelay	(Z)V
    //   224: lload 6
    //   226: lstore 4
    //   228: aload_0
    //   229: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   232: aload_0
    //   233: getfield 158	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   236: invokevirtual 547	java/net/Socket:setSoTimeout	(I)V
    //   239: lload 6
    //   241: lstore 4
    //   243: aload_0
    //   244: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   247: ldc 19
    //   249: invokevirtual 550	java/net/Socket:setSendBufferSize	(I)V
    //   252: lload 6
    //   254: lstore 4
    //   256: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   259: lstore 6
    //   261: lload 6
    //   263: lstore 4
    //   265: aload_0
    //   266: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   269: aload_0
    //   270: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   273: aload_0
    //   274: getfield 106	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   277: invokevirtual 554	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   280: lload 6
    //   282: lstore 4
    //   284: aload_0
    //   285: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   288: lload 6
    //   290: lsub
    //   291: putfield 137	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   294: lload 6
    //   296: lstore 4
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   303: invokevirtual 558	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   306: putfield 296	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   309: lload 6
    //   311: lstore 4
    //   313: aload_0
    //   314: new 285	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   317: dup
    //   318: aload_0
    //   319: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   322: aload_0
    //   323: getfield 156	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   326: ldc_w 560
    //   329: iconst_m1
    //   330: invokespecial 563	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   333: putfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   336: lload 6
    //   338: lstore 4
    //   340: iconst_1
    //   341: aload_0
    //   342: getfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   345: getfield 289	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   348: invokevirtual 290	java/lang/Object:toString	()Ljava/lang/String;
    //   351: invokestatic 294	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   354: lload 6
    //   356: lstore 4
    //   358: iconst_1
    //   359: aload_0
    //   360: getfield 296	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   363: invokevirtual 290	java/lang/Object:toString	()Ljava/lang/String;
    //   366: invokestatic 294	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   369: lload 6
    //   371: lstore 4
    //   373: aload_0
    //   374: new 565	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   377: dup
    //   378: aload_0
    //   379: invokespecial 567	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   382: putfield 308	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   385: lload 6
    //   387: lstore 4
    //   389: aload_0
    //   390: getfield 308	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   393: ldc_w 569
    //   396: invokevirtual 572	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:setName	(Ljava/lang/String;)V
    //   399: lload 6
    //   401: lstore 4
    //   403: aload_0
    //   404: getfield 110	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   407: iconst_1
    //   408: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   411: lload 6
    //   413: lstore 4
    //   415: aload_0
    //   416: getfield 308	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   419: invokevirtual 573	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   422: lload 6
    //   424: lstore 4
    //   426: aload_0
    //   427: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   430: iconst_1
    //   431: invokevirtual 265	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   434: iconst_1
    //   435: istore 10
    //   437: new 112	java/lang/StringBuilder
    //   440: dup
    //   441: ldc_w 575
    //   444: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   447: astore 12
    //   449: aload_0
    //   450: getfield 162	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   453: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   456: ldc_w 577
    //   459: invokevirtual 583	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifeq +58 -> 520
    //   465: aload_0
    //   466: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   469: invokevirtual 587	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   472: astore 13
    //   474: aload 13
    //   476: ifnull +44 -> 520
    //   479: aload 13
    //   481: instanceof 534
    //   484: ifeq +36 -> 520
    //   487: aload 13
    //   489: checkcast 534	java/net/InetSocketAddress
    //   492: invokevirtual 591	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   495: invokevirtual 596	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   498: astore 13
    //   500: aload 12
    //   502: ldc_w 598
    //   505: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 13
    //   510: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 600
    //   516: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: iconst_0
    //   521: istore_2
    //   522: ldc_w 351
    //   525: new 112	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 602
    //   535: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   542: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc_w 521
    //   548: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_1
    //   552: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   555: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: ldc_w 526
    //   561: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   568: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: ldc_w 604
    //   574: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: lload 6
    //   579: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   582: ldc_w 606
    //   585: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 12
    //   590: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 608
    //   599: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 267	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   606: invokevirtual 611	java/net/Socket:getLocalPort	()I
    //   609: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 364	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload_0
    //   619: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   622: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   625: iconst_1
    //   626: istore 10
    //   628: aload_0
    //   629: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   632: iload 10
    //   634: putfield 614	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   637: aload_0
    //   638: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   641: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   644: aload_0
    //   645: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   648: getfield 320	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   651: lsub
    //   652: putfield 617	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   655: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   658: lstore 4
    //   660: aload_0
    //   661: getfield 343	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   664: ifnull +98 -> 762
    //   667: ldc 252
    //   669: iconst_1
    //   670: new 112	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 619
    //   680: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_0
    //   684: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   687: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: ldc_w 621
    //   693: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: iload 10
    //   698: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   701: ldc_w 623
    //   704: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload_2
    //   708: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: ldc_w 625
    //   714: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: lload 4
    //   719: lload 8
    //   721: lsub
    //   722: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   725: ldc_w 627
    //   728: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: aload_0
    //   738: getfield 343	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   741: iload 10
    //   743: aload_0
    //   744: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   747: aload_0
    //   748: aload_0
    //   749: getfield 162	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   752: iload_2
    //   753: aload_0
    //   754: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   757: invokeinterface 631 7 0
    //   762: iload 10
    //   764: ifeq +549 -> 1313
    //   767: aload_0
    //   768: getfield 142	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   771: invokestatic 317	android/os/SystemClock:uptimeMillis	()J
    //   774: putfield 634	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   777: aload_0
    //   778: getfield 218	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   781: invokevirtual 637	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:wakeupToWrite	()V
    //   784: iload_2
    //   785: ireturn
    //   786: astore 12
    //   788: bipush 14
    //   790: istore_2
    //   791: iconst_0
    //   792: istore 10
    //   794: iload_2
    //   795: istore_3
    //   796: aload_0
    //   797: getfield 154	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   800: invokevirtual 640	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   803: istore 11
    //   805: iload_2
    //   806: istore_3
    //   807: ldc_w 351
    //   810: new 112	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 642
    //   820: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   827: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 521
    //   833: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_1
    //   837: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   840: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 526
    //   846: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: getfield 160	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   853: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 604
    //   859: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: lload 4
    //   864: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   867: ldc_w 644
    //   870: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: iload 11
    //   875: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: aload 12
    //   883: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   886: iload_2
    //   887: istore_3
    //   888: aload 12
    //   890: invokevirtual 645	java/lang/Throwable:toString	()Ljava/lang/String;
    //   893: invokevirtual 648	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   896: astore 13
    //   898: iload 11
    //   900: ifne +64 -> 964
    //   903: iconst_3
    //   904: istore_2
    //   905: aload_0
    //   906: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   909: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   912: goto -284 -> 628
    //   915: astore 12
    //   917: ldc_w 351
    //   920: new 112	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   927: ldc_w 650
    //   930: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_1
    //   934: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   937: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: ldc_w 521
    //   943: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_1
    //   947: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   950: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: aload 12
    //   958: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   961: goto -333 -> 628
    //   964: iload_2
    //   965: istore_3
    //   966: aload 13
    //   968: ldc_w 652
    //   971: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   974: iconst_m1
    //   975: if_icmple +8 -> 983
    //   978: iconst_1
    //   979: istore_2
    //   980: goto -75 -> 905
    //   983: iload_2
    //   984: istore_3
    //   985: aload 13
    //   987: ldc_w 658
    //   990: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   993: iconst_m1
    //   994: if_icmple +8 -> 1002
    //   997: iconst_2
    //   998: istore_2
    //   999: goto -94 -> 905
    //   1002: iload_2
    //   1003: istore_3
    //   1004: aload 13
    //   1006: ldc_w 660
    //   1009: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1012: iconst_m1
    //   1013: if_icmple +8 -> 1021
    //   1016: iconst_3
    //   1017: istore_2
    //   1018: goto -113 -> 905
    //   1021: iload_2
    //   1022: istore_3
    //   1023: aload 13
    //   1025: ldc_w 662
    //   1028: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1031: iconst_m1
    //   1032: if_icmple +8 -> 1040
    //   1035: iconst_4
    //   1036: istore_2
    //   1037: goto -132 -> 905
    //   1040: iload_2
    //   1041: istore_3
    //   1042: aload 13
    //   1044: ldc_w 664
    //   1047: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1050: iconst_m1
    //   1051: if_icmple +8 -> 1059
    //   1054: iconst_5
    //   1055: istore_2
    //   1056: goto -151 -> 905
    //   1059: iload_2
    //   1060: istore_3
    //   1061: aload 13
    //   1063: ldc_w 666
    //   1066: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1069: iconst_m1
    //   1070: if_icmple +9 -> 1079
    //   1073: bipush 6
    //   1075: istore_2
    //   1076: goto -171 -> 905
    //   1079: iload_2
    //   1080: istore_3
    //   1081: aload 13
    //   1083: ldc_w 668
    //   1086: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1089: iconst_m1
    //   1090: if_icmpgt +316 -> 1406
    //   1093: iload_2
    //   1094: istore_3
    //   1095: aload 13
    //   1097: ldc_w 670
    //   1100: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1103: iconst_m1
    //   1104: if_icmple +6 -> 1110
    //   1107: goto +299 -> 1406
    //   1110: iload_2
    //   1111: istore_3
    //   1112: aload 13
    //   1114: ldc_w 672
    //   1117: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1120: iconst_m1
    //   1121: if_icmple +9 -> 1130
    //   1124: bipush 8
    //   1126: istore_2
    //   1127: goto -222 -> 905
    //   1130: iload_2
    //   1131: istore_3
    //   1132: aload 13
    //   1134: ldc_w 674
    //   1137: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1140: iconst_m1
    //   1141: if_icmple +9 -> 1150
    //   1144: bipush 9
    //   1146: istore_2
    //   1147: goto -242 -> 905
    //   1150: iload_2
    //   1151: istore_3
    //   1152: aload 13
    //   1154: ldc_w 676
    //   1157: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1160: iconst_m1
    //   1161: if_icmple +9 -> 1170
    //   1164: bipush 10
    //   1166: istore_2
    //   1167: goto -262 -> 905
    //   1170: iload_2
    //   1171: istore_3
    //   1172: aload 13
    //   1174: ldc_w 678
    //   1177: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1180: iconst_m1
    //   1181: if_icmple +9 -> 1190
    //   1184: bipush 11
    //   1186: istore_2
    //   1187: goto -282 -> 905
    //   1190: iload_2
    //   1191: istore_3
    //   1192: aload 13
    //   1194: ldc_w 680
    //   1197: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1200: iconst_m1
    //   1201: if_icmple +9 -> 1210
    //   1204: bipush 12
    //   1206: istore_2
    //   1207: goto -302 -> 905
    //   1210: iload_2
    //   1211: istore_3
    //   1212: aload 13
    //   1214: ldc_w 682
    //   1217: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1220: iconst_m1
    //   1221: if_icmple +9 -> 1230
    //   1224: bipush 7
    //   1226: istore_2
    //   1227: goto -322 -> 905
    //   1230: iload_2
    //   1231: istore_3
    //   1232: aload 13
    //   1234: ldc_w 684
    //   1237: invokevirtual 656	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1240: iconst_m1
    //   1241: if_icmple +9 -> 1250
    //   1244: bipush 13
    //   1246: istore_2
    //   1247: goto -342 -> 905
    //   1250: bipush 14
    //   1252: istore_2
    //   1253: iload_2
    //   1254: istore_3
    //   1255: aload 12
    //   1257: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1260: astore 12
    //   1262: iload_2
    //   1263: istore_3
    //   1264: aload 12
    //   1266: invokevirtual 693	java/lang/String:length	()I
    //   1269: sipush 200
    //   1272: if_icmple +119 -> 1391
    //   1275: iload_2
    //   1276: istore_3
    //   1277: aload 12
    //   1279: iconst_0
    //   1280: sipush 200
    //   1283: invokevirtual 697	java/lang/String:substring	(II)Ljava/lang/String;
    //   1286: pop
    //   1287: bipush 14
    //   1289: istore_2
    //   1290: goto -385 -> 905
    //   1293: astore 12
    //   1295: iconst_0
    //   1296: istore 10
    //   1298: aload_0
    //   1299: getfield 91	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1302: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1305: aload 12
    //   1307: athrow
    //   1308: astore 12
    //   1310: goto -393 -> 917
    //   1313: aload_0
    //   1314: getfield 218	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1317: invokevirtual 301	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   1320: iload_2
    //   1321: ireturn
    //   1322: astore 12
    //   1324: bipush 14
    //   1326: istore_2
    //   1327: iconst_0
    //   1328: istore 10
    //   1330: goto -413 -> 917
    //   1333: astore 12
    //   1335: iconst_0
    //   1336: istore_2
    //   1337: iconst_1
    //   1338: istore 10
    //   1340: goto -423 -> 917
    //   1343: astore 12
    //   1345: goto -47 -> 1298
    //   1348: astore 12
    //   1350: iconst_0
    //   1351: istore_2
    //   1352: goto -54 -> 1298
    //   1355: astore 12
    //   1357: iload_3
    //   1358: istore_2
    //   1359: goto -61 -> 1298
    //   1362: astore 12
    //   1364: bipush 14
    //   1366: istore_2
    //   1367: iconst_1
    //   1368: istore 10
    //   1370: lload 6
    //   1372: lstore 4
    //   1374: goto -580 -> 794
    //   1377: astore 12
    //   1379: iconst_1
    //   1380: istore 10
    //   1382: lload 6
    //   1384: lstore 4
    //   1386: iconst_0
    //   1387: istore_2
    //   1388: goto -594 -> 794
    //   1391: bipush 14
    //   1393: istore_2
    //   1394: goto -489 -> 905
    //   1397: iconst_0
    //   1398: istore 10
    //   1400: bipush 14
    //   1402: istore_2
    //   1403: goto -775 -> 628
    //   1406: bipush 7
    //   1408: istore_2
    //   1409: goto -504 -> 905
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1412	0	this	TcpConnection
    //   0	1412	1	paramEndPoint	EndPoint
    //   119	1290	2	i	int
    //   795	563	3	j	int
    //   152	1233	4	l1	long
    //   128	1255	6	l2	long
    //   123	597	8	l3	long
    //   143	1256	10	bool1	boolean
    //   803	96	11	bool2	boolean
    //   447	142	12	localStringBuilder	StringBuilder
    //   786	103	12	localThrowable1	java.lang.Throwable
    //   915	341	12	localInterruptedException1	java.lang.InterruptedException
    //   1260	18	12	str	String
    //   1293	13	12	localObject1	Object
    //   1308	1	12	localInterruptedException2	java.lang.InterruptedException
    //   1322	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1333	1	12	localInterruptedException4	java.lang.InterruptedException
    //   1343	1	12	localObject2	Object
    //   1348	1	12	localObject3	Object
    //   1355	1	12	localObject4	Object
    //   1362	1	12	localThrowable2	java.lang.Throwable
    //   1377	1	12	localThrowable3	java.lang.Throwable
    //   472	761	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   154	173	786	java/lang/Throwable
    //   177	185	786	java/lang/Throwable
    //   189	200	786	java/lang/Throwable
    //   204	212	786	java/lang/Throwable
    //   216	224	786	java/lang/Throwable
    //   228	239	786	java/lang/Throwable
    //   243	252	786	java/lang/Throwable
    //   256	261	786	java/lang/Throwable
    //   265	280	786	java/lang/Throwable
    //   284	294	786	java/lang/Throwable
    //   298	309	786	java/lang/Throwable
    //   313	336	786	java/lang/Throwable
    //   340	354	786	java/lang/Throwable
    //   358	369	786	java/lang/Throwable
    //   373	385	786	java/lang/Throwable
    //   389	399	786	java/lang/Throwable
    //   403	411	786	java/lang/Throwable
    //   415	422	786	java/lang/Throwable
    //   426	434	786	java/lang/Throwable
    //   905	912	915	java/lang/InterruptedException
    //   154	173	1293	finally
    //   177	185	1293	finally
    //   189	200	1293	finally
    //   204	212	1293	finally
    //   216	224	1293	finally
    //   228	239	1293	finally
    //   243	252	1293	finally
    //   256	261	1293	finally
    //   265	280	1293	finally
    //   284	294	1293	finally
    //   298	309	1293	finally
    //   313	336	1293	finally
    //   340	354	1293	finally
    //   358	369	1293	finally
    //   373	385	1293	finally
    //   389	399	1293	finally
    //   403	411	1293	finally
    //   415	422	1293	finally
    //   426	434	1293	finally
    //   1298	1308	1308	java/lang/InterruptedException
    //   130	145	1322	java/lang/InterruptedException
    //   618	625	1333	java/lang/InterruptedException
    //   437	474	1343	finally
    //   479	520	1343	finally
    //   522	618	1348	finally
    //   796	805	1355	finally
    //   807	886	1355	finally
    //   888	898	1355	finally
    //   966	978	1355	finally
    //   985	997	1355	finally
    //   1004	1016	1355	finally
    //   1023	1035	1355	finally
    //   1042	1054	1355	finally
    //   1061	1073	1355	finally
    //   1081	1093	1355	finally
    //   1095	1107	1355	finally
    //   1112	1124	1355	finally
    //   1132	1144	1355	finally
    //   1152	1164	1355	finally
    //   1172	1184	1355	finally
    //   1192	1204	1355	finally
    //   1212	1224	1355	finally
    //   1232	1244	1355	finally
    //   1255	1262	1355	finally
    //   1264	1275	1355	finally
    //   1277	1287	1355	finally
    //   437	474	1362	java/lang/Throwable
    //   479	520	1362	java/lang/Throwable
    //   522	618	1377	java/lang/Throwable
  }
  
  public static void setExclusiveStream(boolean paramBoolean, String paramString)
  {
    synchronized (BaseApplication.exclusiveStreamList)
    {
      ArrayList localArrayList2 = BaseApplication.exclusiveStreamList;
      if (paramBoolean)
      {
        localArrayList2.add(paramString);
        return;
      }
      localArrayList2.remove(paramString);
    }
  }
  
  public boolean connect()
  {
    BdhLogUtil.LogEvent("C", "Connect : About to send conn request.");
    this.mConnThread.start();
    this.mConnHandler = new TcpConnection.ConnWorker(this, this.mConnThread.getLooper());
    this.mConnHandler.sendEmptyMessage(1);
    this.connInfo.connStartTime = SystemClock.uptimeMillis();
    this.connInfo.serverIp = this.mEp.host;
    this.connInfo.port = this.mEp.port;
    return true;
  }
  
  public void disConnect()
  {
    synchronized (this.closeDebug)
    {
      this.closeDebug.append("By : disConnect;");
      closeConn(3);
      return;
    }
  }
  
  public int getConnId()
  {
    return this.connId;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mEp;
  }
  
  public int getProtoType()
  {
    return 1;
  }
  
  public boolean isIpv6()
  {
    return this.isIpv6;
  }
  
  public boolean isWritable()
  {
    return (this.isRunning.get()) && (!this.isWritting.get());
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    QLog.d("BDH_LOG", 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + paramInt);
    if (this.connListener != null) {
      this.connListener.onRecvInvalidData(this.mEp, this);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.connInfo.recvRespCount = paramList.size();
    this.connManager.onDecodeSucessfully(paramList);
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    HwResponse localHwResponse = new HwResponse();
    localHwResponse.hwSeq = paramHwRequest.getHwSeq();
    localHwResponse.cmd = paramHwRequest.hwCmd;
    localHwResponse.errCode = paramInt;
    localHwResponse.recvTime = SystemClock.uptimeMillis();
    localHwResponse.shouldRetry = false;
    this.connManager.onDecodeSucessfully(localArrayList);
  }
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.connListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean)
  {
    this.isUrgent = paramBoolean;
    wakeupChannel();
  }
  
  public void wakeupChannel()
  {
    TcpConnection.ConnWorker localConnWorker = this.mConnHandler;
    if ((this.isRunning.get()) && (localConnWorker != null)) {
      localConnWorker.wakeupToWrite();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection
 * JD-Core Version:    0.7.0.1
 */