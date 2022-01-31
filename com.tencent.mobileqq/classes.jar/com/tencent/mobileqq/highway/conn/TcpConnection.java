package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.config.HwServlet;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TcpConnection
  implements IConnection, IProtocolCodecListener
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
  private int continueHeartBreak;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime;
  private ReentrantLock lock = new ReentrantLock();
  private ConnWorker mConnHandler;
  private HandlerThread mConnThread;
  private int mConnTimeOut;
  private EndPoint mEp;
  private MsfSocketInputBuffer mInputBuffer;
  public int mLastDataSegSize;
  public long mLastDataTransTime;
  private int mNetFlowDw;
  private int mNetFlowUp;
  private OutputStream mOutputStream;
  private int mReadBufferSize;
  private ReadThread mReadThread;
  private int mReadTimeout;
  public long mRtt;
  private Handler mServletHandler;
  private Socket mSocket;
  private InetSocketAddress serverAddress;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  static {}
  
  public TcpConnection(ConnManager paramConnManager, int paramInt1, EndPoint paramEndPoint, int paramInt2, int paramInt3)
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
      return;
    }
  }
  
  private void closeConn(final int paramInt)
  {
    QLog.d("BDH_LOG", 1, "CCloseConn at : ConnId:" + this.connId + " Src:" + paramInt);
    this.isRunning.set(false);
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool1 = bool5;
    boolean bool3 = bool6;
    for (;;)
    {
      try
      {
        if (this.mSocket == null) {
          return;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (!this.isConn.get()) {
          return;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (!this.lock.tryLock(30000L, TimeUnit.MILLISECONDS)) {
          continue;
        }
        bool1 = bool5;
        bool3 = bool6;
        if (this.mInputBuffer != null)
        {
          bool1 = bool5;
          bool3 = bool6;
          localObject1 = this.mInputBuffer.instream;
          if (localObject1 != null)
          {
            bool1 = bool5;
            bool3 = bool6;
            setExclusiveStream(false, localObject1.toString());
          }
        }
        bool1 = bool5;
        bool3 = bool6;
        if (this.mOutputStream != null)
        {
          bool1 = bool5;
          bool3 = bool6;
          setExclusiveStream(false, this.mOutputStream.toString());
        }
        bool2 = bool4;
      }
      catch (InterruptedException localInterruptedException)
      {
        Object localObject1;
        final int i;
        BdhLogUtil.LogException("C", "CloseConn Error.", localInterruptedException);
        continue;
        bool1 = bool5;
        bool3 = bool6;
        this.shouldCloseConn.set(true);
        bool1 = bool2;
        continue;
      }
      catch (Exception localException1)
      {
        label259:
        BdhLogUtil.LogException("C", "CloseConn Error.", localException1);
        bool1 = bool3;
        continue;
      }
      try
      {
        localObject1 = this.mConnHandler;
        if (localObject1 != null)
        {
          bool2 = bool4;
          ((ConnWorker)localObject1).notifyToQuit();
        }
        bool2 = bool4;
        this.mInputBuffer = null;
        bool2 = bool4;
        this.mOutputStream = null;
        bool2 = bool4;
      }
      finally
      {
        bool1 = bool2;
        bool3 = bool2;
        this.lock.unlock();
        bool1 = bool2;
        bool3 = bool2;
      }
    }
    try
    {
      if (this.mSocket != null)
      {
        bool2 = bool4;
        this.mSocket.close();
      }
    }
    catch (Exception localException2)
    {
      break label259;
    }
    bool2 = bool4;
    this.isConn.set(false);
    bool2 = bool4;
    this.mSocket = null;
    bool2 = bool4;
    this.mReadThread = null;
    bool1 = true;
    bool5 = true;
    bool3 = true;
    bool4 = true;
    bool2 = bool1;
    this.connInfo.finished = true;
    bool2 = bool1;
    this.connInfo.connLifeLong = (SystemClock.uptimeMillis() - this.connInfo.connStartTime);
    bool2 = bool1;
    paramInt = this.mNetFlowUp;
    bool2 = bool1;
    i = this.mNetFlowDw;
    bool2 = bool1;
    this.mNetFlowUp = 0;
    bool2 = bool1;
    this.mNetFlowDw = 0;
    bool2 = bool1;
    if (!IsRunTimeShutDown)
    {
      bool2 = bool1;
      new Thread(new Runnable()
      {
        public void run()
        {
          HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, true, paramInt);
          HwServlet.reportTraffic4PicUp(TcpConnection.this.connManager.engine.app, TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, false, i);
        }
      }, "Highway-BDH-reportTraffic").start();
    }
    bool1 = bool5;
    this.lock.unlock();
    bool1 = bool4;
    localObject1 = this.connListener;
    if (localObject1 != null) {
      ((IConnectionListener)localObject1).onDisConnect(this.connId, this);
    }
    BdhLogUtil.LogEvent("C", "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + bool1);
    return;
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
                break label374;
              }
              ((HwRequest)???).reqListener.handleError(-1004, "NullBody");
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
          label374:
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
            this.mNetFlowUp += i;
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
    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        TcpConnection.IsRunTimeShutDown = true;
        QLog.i("TcpConnection", 2, "Runtime ShutDown");
      }
    });
  }
  
  /* Error */
  private int openConn(EndPoint paramEndPoint)
  {
    // Byte code:
    //   0: ldc 241
    //   2: iconst_1
    //   3: new 113	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 514
    //   13: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 520
    //   26: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 523	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 525
    //   39: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 143	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   46: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 527
    //   52: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 130	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 529
    //   65: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 107	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 260	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: ifne +13 -> 94
    //   84: aload_0
    //   85: getfield 105	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 260	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifeq +26 -> 117
    //   94: aload_0
    //   95: getfield 107	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   98: invokevirtual 260	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   101: ifeq +16 -> 117
    //   104: aload_0
    //   105: getfield 107	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   108: iconst_0
    //   109: invokevirtual 254	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   112: aload_0
    //   113: iconst_2
    //   114: invokespecial 227	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   117: iconst_0
    //   118: istore 9
    //   120: iconst_0
    //   121: istore 7
    //   123: iconst_0
    //   124: istore 10
    //   126: iconst_0
    //   127: istore 6
    //   129: bipush 14
    //   131: istore_2
    //   132: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   135: lstore 16
    //   137: ldc2_w 530
    //   140: lstore 14
    //   142: iload_2
    //   143: istore 4
    //   145: aload_0
    //   146: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   149: ldc2_w 261
    //   152: getstatic 268	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   155: invokevirtual 272	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   158: istore 8
    //   160: iload_2
    //   161: istore 4
    //   163: iload 8
    //   165: ifeq +871 -> 1036
    //   168: iload 9
    //   170: istore 6
    //   172: iload_2
    //   173: istore 4
    //   175: lload 14
    //   177: lstore 12
    //   179: iload 10
    //   181: istore 8
    //   183: iload_2
    //   184: istore_3
    //   185: aload_0
    //   186: new 533	java/net/InetSocketAddress
    //   189: dup
    //   190: aload_1
    //   191: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   194: aload_1
    //   195: getfield 523	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   198: invokespecial 536	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   201: putfield 538	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   204: iload 9
    //   206: istore 6
    //   208: iload_2
    //   209: istore 4
    //   211: lload 14
    //   213: lstore 12
    //   215: iload 10
    //   217: istore 8
    //   219: iload_2
    //   220: istore_3
    //   221: aload_0
    //   222: getfield 105	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   225: iconst_0
    //   226: invokevirtual 254	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   229: iload 9
    //   231: istore 6
    //   233: iload_2
    //   234: istore 4
    //   236: lload 14
    //   238: lstore 12
    //   240: iload 10
    //   242: istore 8
    //   244: iload_2
    //   245: istore_3
    //   246: aload_0
    //   247: new 290	java/net/Socket
    //   250: dup
    //   251: invokespecial 539	java/net/Socket:<init>	()V
    //   254: putfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   257: iload 9
    //   259: istore 6
    //   261: iload_2
    //   262: istore 4
    //   264: lload 14
    //   266: lstore 12
    //   268: iload 10
    //   270: istore 8
    //   272: iload_2
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   278: iconst_1
    //   279: invokevirtual 542	java/net/Socket:setKeepAlive	(Z)V
    //   282: iload 9
    //   284: istore 6
    //   286: iload_2
    //   287: istore 4
    //   289: lload 14
    //   291: lstore 12
    //   293: iload 10
    //   295: istore 8
    //   297: iload_2
    //   298: istore_3
    //   299: aload_0
    //   300: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   303: iconst_1
    //   304: invokevirtual 545	java/net/Socket:setTcpNoDelay	(Z)V
    //   307: iload 9
    //   309: istore 6
    //   311: iload_2
    //   312: istore 4
    //   314: lload 14
    //   316: lstore 12
    //   318: iload 10
    //   320: istore 8
    //   322: iload_2
    //   323: istore_3
    //   324: aload_0
    //   325: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   328: aload_0
    //   329: getfield 141	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   332: invokevirtual 548	java/net/Socket:setSoTimeout	(I)V
    //   335: iload 9
    //   337: istore 6
    //   339: iload_2
    //   340: istore 4
    //   342: lload 14
    //   344: lstore 12
    //   346: iload 10
    //   348: istore 8
    //   350: iload_2
    //   351: istore_3
    //   352: aload_0
    //   353: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   356: ldc 29
    //   358: invokevirtual 551	java/net/Socket:setSendBufferSize	(I)V
    //   361: iload 9
    //   363: istore 6
    //   365: iload_2
    //   366: istore 4
    //   368: lload 14
    //   370: lstore 12
    //   372: iload 10
    //   374: istore 8
    //   376: iload_2
    //   377: istore_3
    //   378: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   381: lstore 14
    //   383: iload 9
    //   385: istore 6
    //   387: iload_2
    //   388: istore 4
    //   390: lload 14
    //   392: lstore 12
    //   394: iload 10
    //   396: istore 8
    //   398: iload_2
    //   399: istore_3
    //   400: aload_0
    //   401: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   404: aload_0
    //   405: getfield 538	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   408: aload_0
    //   409: getfield 147	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   412: invokevirtual 555	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   415: iload 9
    //   417: istore 6
    //   419: iload_2
    //   420: istore 4
    //   422: lload 14
    //   424: lstore 12
    //   426: iload 10
    //   428: istore 8
    //   430: iload_2
    //   431: istore_3
    //   432: aload_0
    //   433: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   436: lload 14
    //   438: lsub
    //   439: putfield 365	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   442: iload 9
    //   444: istore 6
    //   446: iload_2
    //   447: istore 4
    //   449: lload 14
    //   451: lstore 12
    //   453: iload 10
    //   455: istore 8
    //   457: iload_2
    //   458: istore_3
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   464: invokevirtual 559	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   467: putfield 285	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   470: iload 9
    //   472: istore 6
    //   474: iload_2
    //   475: istore 4
    //   477: lload 14
    //   479: lstore 12
    //   481: iload 10
    //   483: istore 8
    //   485: iload_2
    //   486: istore_3
    //   487: aload_0
    //   488: new 274	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   491: dup
    //   492: aload_0
    //   493: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   496: aload_0
    //   497: getfield 139	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   500: ldc_w 561
    //   503: iconst_m1
    //   504: invokespecial 564	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   507: putfield 211	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   510: iload 9
    //   512: istore 6
    //   514: iload_2
    //   515: istore 4
    //   517: lload 14
    //   519: lstore 12
    //   521: iload 10
    //   523: istore 8
    //   525: iload_2
    //   526: istore_3
    //   527: iconst_1
    //   528: aload_0
    //   529: getfield 211	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   532: getfield 278	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   535: invokevirtual 279	java/lang/Object:toString	()Ljava/lang/String;
    //   538: invokestatic 283	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   541: iload 9
    //   543: istore 6
    //   545: iload_2
    //   546: istore 4
    //   548: lload 14
    //   550: lstore 12
    //   552: iload 10
    //   554: istore 8
    //   556: iload_2
    //   557: istore_3
    //   558: iconst_1
    //   559: aload_0
    //   560: getfield 285	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   563: invokevirtual 279	java/lang/Object:toString	()Ljava/lang/String;
    //   566: invokestatic 283	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   569: iload 9
    //   571: istore 6
    //   573: iload_2
    //   574: istore 4
    //   576: lload 14
    //   578: lstore 12
    //   580: iload 10
    //   582: istore 8
    //   584: iload_2
    //   585: istore_3
    //   586: aload_0
    //   587: new 17	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   590: dup
    //   591: aload_0
    //   592: invokespecial 566	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   595: putfield 295	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   598: iload 9
    //   600: istore 6
    //   602: iload_2
    //   603: istore 4
    //   605: lload 14
    //   607: lstore 12
    //   609: iload 10
    //   611: istore 8
    //   613: iload_2
    //   614: istore_3
    //   615: aload_0
    //   616: getfield 295	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   619: ldc_w 568
    //   622: invokevirtual 571	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:setName	(Ljava/lang/String;)V
    //   625: iload 9
    //   627: istore 6
    //   629: iload_2
    //   630: istore 4
    //   632: lload 14
    //   634: lstore 12
    //   636: iload 10
    //   638: istore 8
    //   640: iload_2
    //   641: istore_3
    //   642: aload_0
    //   643: getfield 111	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   646: iconst_1
    //   647: invokevirtual 254	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   650: iload 9
    //   652: istore 6
    //   654: iload_2
    //   655: istore 4
    //   657: lload 14
    //   659: lstore 12
    //   661: iload 10
    //   663: istore 8
    //   665: iload_2
    //   666: istore_3
    //   667: aload_0
    //   668: getfield 295	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   671: invokevirtual 572	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   674: iload 9
    //   676: istore 6
    //   678: iload_2
    //   679: istore 4
    //   681: lload 14
    //   683: lstore 12
    //   685: iload 10
    //   687: istore 8
    //   689: iload_2
    //   690: istore_3
    //   691: aload_0
    //   692: getfield 105	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   695: iconst_1
    //   696: invokevirtual 254	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   699: iconst_1
    //   700: istore 7
    //   702: iconst_1
    //   703: istore 10
    //   705: iconst_1
    //   706: istore 11
    //   708: iconst_1
    //   709: istore 9
    //   711: iload 7
    //   713: istore 6
    //   715: iload_2
    //   716: istore 4
    //   718: lload 14
    //   720: lstore 12
    //   722: iload 11
    //   724: istore 8
    //   726: iload_2
    //   727: istore_3
    //   728: new 113	java/lang/StringBuilder
    //   731: dup
    //   732: ldc_w 574
    //   735: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   738: astore 18
    //   740: iload 7
    //   742: istore 6
    //   744: iload_2
    //   745: istore 4
    //   747: lload 14
    //   749: lstore 12
    //   751: iload 11
    //   753: istore 8
    //   755: iload_2
    //   756: istore_3
    //   757: aload_0
    //   758: getfield 145	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   761: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   764: ldc_w 576
    //   767: invokevirtual 582	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   770: ifeq +126 -> 896
    //   773: iload 7
    //   775: istore 6
    //   777: iload_2
    //   778: istore 4
    //   780: lload 14
    //   782: lstore 12
    //   784: iload 11
    //   786: istore 8
    //   788: iload_2
    //   789: istore_3
    //   790: aload_0
    //   791: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   794: invokevirtual 586	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   797: astore 19
    //   799: aload 19
    //   801: ifnull +95 -> 896
    //   804: iload 7
    //   806: istore 6
    //   808: iload_2
    //   809: istore 4
    //   811: lload 14
    //   813: lstore 12
    //   815: iload 11
    //   817: istore 8
    //   819: iload_2
    //   820: istore_3
    //   821: aload 19
    //   823: instanceof 533
    //   826: ifeq +70 -> 896
    //   829: iload 7
    //   831: istore 6
    //   833: iload_2
    //   834: istore 4
    //   836: lload 14
    //   838: lstore 12
    //   840: iload 11
    //   842: istore 8
    //   844: iload_2
    //   845: istore_3
    //   846: aload 19
    //   848: checkcast 533	java/net/InetSocketAddress
    //   851: invokevirtual 590	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   854: invokevirtual 595	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   857: astore 19
    //   859: iload 7
    //   861: istore 6
    //   863: iload_2
    //   864: istore 4
    //   866: lload 14
    //   868: lstore 12
    //   870: iload 11
    //   872: istore 8
    //   874: iload_2
    //   875: istore_3
    //   876: aload 18
    //   878: ldc_w 597
    //   881: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 19
    //   886: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: ldc_w 599
    //   892: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: iconst_0
    //   897: istore 4
    //   899: iconst_0
    //   900: istore 5
    //   902: iconst_0
    //   903: istore_3
    //   904: iconst_0
    //   905: istore_2
    //   906: iload 7
    //   908: istore 6
    //   910: lload 14
    //   912: lstore 12
    //   914: iload 11
    //   916: istore 8
    //   918: ldc_w 340
    //   921: new 113	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 601
    //   931: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_1
    //   935: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   938: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: ldc_w 520
    //   944: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload_1
    //   948: getfield 523	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   951: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: ldc_w 525
    //   957: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload_0
    //   961: getfield 143	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   964: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: ldc_w 603
    //   970: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: lload 14
    //   975: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   978: ldc_w 605
    //   981: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload 18
    //   986: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 607
    //   995: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_0
    //   999: getfield 256	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   1002: invokevirtual 610	java/net/Socket:getLocalPort	()I
    //   1005: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 353	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   1014: iload 10
    //   1016: istore 7
    //   1018: iload 5
    //   1020: istore 4
    //   1022: aload_0
    //   1023: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1026: invokevirtual 330	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1029: iload_2
    //   1030: istore 4
    //   1032: iload 9
    //   1034: istore 6
    //   1036: aload_0
    //   1037: getfield 125	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1040: iload 6
    //   1042: putfield 613	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1045: aload_0
    //   1046: getfield 125	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1049: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   1052: aload_0
    //   1053: getfield 125	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1056: getfield 307	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1059: lsub
    //   1060: putfield 616	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1063: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   1066: lstore 12
    //   1068: aload_0
    //   1069: getfield 332	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1072: ifnull +100 -> 1172
    //   1075: ldc 241
    //   1077: iconst_1
    //   1078: new 113	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 618
    //   1088: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload_0
    //   1092: getfield 143	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1095: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1098: ldc_w 620
    //   1101: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: iload 6
    //   1106: invokevirtual 347	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1109: ldc_w 622
    //   1112: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: iload 4
    //   1117: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 624
    //   1123: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: lload 12
    //   1128: lload 16
    //   1130: lsub
    //   1131: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1134: ldc_w 626
    //   1137: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: aload_0
    //   1147: getfield 332	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1150: iload 6
    //   1152: aload_0
    //   1153: getfield 143	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1156: aload_0
    //   1157: aload_0
    //   1158: getfield 145	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1161: iload 4
    //   1163: aload_0
    //   1164: getfield 125	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1167: invokeinterface 630 7 0
    //   1172: iload 6
    //   1174: ifeq +673 -> 1847
    //   1177: aload_0
    //   1178: getfield 125	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1181: invokestatic 304	android/os/SystemClock:uptimeMillis	()J
    //   1184: putfield 633	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1187: aload_0
    //   1188: getfield 203	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1191: invokevirtual 636	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:wakeupToWrite	()V
    //   1194: iload 4
    //   1196: ireturn
    //   1197: astore 18
    //   1199: iload 6
    //   1201: istore 8
    //   1203: iload 4
    //   1205: istore_3
    //   1206: aload_0
    //   1207: getfield 137	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   1210: invokevirtual 639	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   1213: istore 7
    //   1215: iload 6
    //   1217: istore 8
    //   1219: iload 4
    //   1221: istore_3
    //   1222: ldc_w 340
    //   1225: new 113	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1232: ldc_w 641
    //   1235: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: aload_1
    //   1239: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1242: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: ldc_w 520
    //   1248: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: aload_1
    //   1252: getfield 523	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1255: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: ldc_w 525
    //   1261: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload_0
    //   1265: getfield 143	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1268: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1271: ldc_w 603
    //   1274: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: lload 12
    //   1279: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1282: ldc_w 643
    //   1285: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: iload 7
    //   1290: invokevirtual 347	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: aload 18
    //   1298: invokestatic 359	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1301: iload 6
    //   1303: istore 8
    //   1305: iload 4
    //   1307: istore_3
    //   1308: aload 18
    //   1310: invokevirtual 644	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1313: invokevirtual 647	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1316: astore 19
    //   1318: iload 7
    //   1320: ifne +78 -> 1398
    //   1323: iconst_3
    //   1324: istore_2
    //   1325: iload 6
    //   1327: istore 7
    //   1329: iload_2
    //   1330: istore 4
    //   1332: aload_0
    //   1333: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1336: invokevirtual 330	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1339: iload_2
    //   1340: istore 4
    //   1342: goto -306 -> 1036
    //   1345: astore 18
    //   1347: ldc_w 340
    //   1350: new 113	java/lang/StringBuilder
    //   1353: dup
    //   1354: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1357: ldc_w 649
    //   1360: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload_1
    //   1364: getfield 518	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1367: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: ldc_w 520
    //   1373: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: aload_1
    //   1377: getfield 523	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1380: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: aload 18
    //   1388: invokestatic 359	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1391: iload 7
    //   1393: istore 6
    //   1395: goto -359 -> 1036
    //   1398: iload 6
    //   1400: istore 8
    //   1402: iload 4
    //   1404: istore_3
    //   1405: aload 19
    //   1407: ldc_w 651
    //   1410: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1413: iconst_m1
    //   1414: if_icmple +8 -> 1422
    //   1417: iconst_1
    //   1418: istore_2
    //   1419: goto -94 -> 1325
    //   1422: iload 6
    //   1424: istore 8
    //   1426: iload 4
    //   1428: istore_3
    //   1429: aload 19
    //   1431: ldc_w 657
    //   1434: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1437: iconst_m1
    //   1438: if_icmple +8 -> 1446
    //   1441: iconst_2
    //   1442: istore_2
    //   1443: goto -118 -> 1325
    //   1446: iload 6
    //   1448: istore 8
    //   1450: iload 4
    //   1452: istore_3
    //   1453: aload 19
    //   1455: ldc_w 659
    //   1458: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1461: iconst_m1
    //   1462: if_icmple +8 -> 1470
    //   1465: iconst_3
    //   1466: istore_2
    //   1467: goto -142 -> 1325
    //   1470: iload 6
    //   1472: istore 8
    //   1474: iload 4
    //   1476: istore_3
    //   1477: aload 19
    //   1479: ldc_w 661
    //   1482: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1485: iconst_m1
    //   1486: if_icmple +8 -> 1494
    //   1489: iconst_4
    //   1490: istore_2
    //   1491: goto -166 -> 1325
    //   1494: iload 6
    //   1496: istore 8
    //   1498: iload 4
    //   1500: istore_3
    //   1501: aload 19
    //   1503: ldc_w 663
    //   1506: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1509: iconst_m1
    //   1510: if_icmple +8 -> 1518
    //   1513: iconst_5
    //   1514: istore_2
    //   1515: goto -190 -> 1325
    //   1518: iload 6
    //   1520: istore 8
    //   1522: iload 4
    //   1524: istore_3
    //   1525: aload 19
    //   1527: ldc_w 665
    //   1530: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1533: iconst_m1
    //   1534: if_icmple +9 -> 1543
    //   1537: bipush 6
    //   1539: istore_2
    //   1540: goto -215 -> 1325
    //   1543: iload 6
    //   1545: istore 8
    //   1547: iload 4
    //   1549: istore_3
    //   1550: aload 19
    //   1552: ldc_w 667
    //   1555: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1558: iconst_m1
    //   1559: if_icmpgt +298 -> 1857
    //   1562: iload 6
    //   1564: istore 8
    //   1566: iload 4
    //   1568: istore_3
    //   1569: aload 19
    //   1571: ldc_w 669
    //   1574: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1577: iconst_m1
    //   1578: if_icmple +6 -> 1584
    //   1581: goto +276 -> 1857
    //   1584: iload 6
    //   1586: istore 8
    //   1588: iload 4
    //   1590: istore_3
    //   1591: aload 19
    //   1593: ldc_w 671
    //   1596: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1599: iconst_m1
    //   1600: if_icmple +9 -> 1609
    //   1603: bipush 8
    //   1605: istore_2
    //   1606: goto -281 -> 1325
    //   1609: iload 6
    //   1611: istore 8
    //   1613: iload 4
    //   1615: istore_3
    //   1616: aload 19
    //   1618: ldc_w 673
    //   1621: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1624: iconst_m1
    //   1625: if_icmple +9 -> 1634
    //   1628: bipush 9
    //   1630: istore_2
    //   1631: goto -306 -> 1325
    //   1634: iload 6
    //   1636: istore 8
    //   1638: iload 4
    //   1640: istore_3
    //   1641: aload 19
    //   1643: ldc_w 675
    //   1646: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1649: iconst_m1
    //   1650: if_icmple +9 -> 1659
    //   1653: bipush 10
    //   1655: istore_2
    //   1656: goto -331 -> 1325
    //   1659: iload 6
    //   1661: istore 8
    //   1663: iload 4
    //   1665: istore_3
    //   1666: aload 19
    //   1668: ldc_w 677
    //   1671: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1674: iconst_m1
    //   1675: if_icmple +9 -> 1684
    //   1678: bipush 11
    //   1680: istore_2
    //   1681: goto -356 -> 1325
    //   1684: iload 6
    //   1686: istore 8
    //   1688: iload 4
    //   1690: istore_3
    //   1691: aload 19
    //   1693: ldc_w 679
    //   1696: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1699: iconst_m1
    //   1700: if_icmple +9 -> 1709
    //   1703: bipush 12
    //   1705: istore_2
    //   1706: goto -381 -> 1325
    //   1709: iload 6
    //   1711: istore 8
    //   1713: iload 4
    //   1715: istore_3
    //   1716: aload 19
    //   1718: ldc_w 681
    //   1721: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1724: iconst_m1
    //   1725: if_icmple +9 -> 1734
    //   1728: bipush 7
    //   1730: istore_2
    //   1731: goto -406 -> 1325
    //   1734: iload 6
    //   1736: istore 8
    //   1738: iload 4
    //   1740: istore_3
    //   1741: aload 19
    //   1743: ldc_w 683
    //   1746: invokevirtual 655	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1749: iconst_m1
    //   1750: if_icmple +9 -> 1759
    //   1753: bipush 13
    //   1755: istore_2
    //   1756: goto -431 -> 1325
    //   1759: bipush 14
    //   1761: istore 4
    //   1763: iload 6
    //   1765: istore 8
    //   1767: iload 4
    //   1769: istore_3
    //   1770: aload 18
    //   1772: invokestatic 689	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1775: astore 18
    //   1777: iload 4
    //   1779: istore_2
    //   1780: iload 6
    //   1782: istore 8
    //   1784: iload 4
    //   1786: istore_3
    //   1787: aload 18
    //   1789: invokevirtual 692	java/lang/String:length	()I
    //   1792: sipush 200
    //   1795: if_icmple -470 -> 1325
    //   1798: iload 6
    //   1800: istore 8
    //   1802: iload 4
    //   1804: istore_3
    //   1805: aload 18
    //   1807: iconst_0
    //   1808: sipush 200
    //   1811: invokevirtual 696	java/lang/String:substring	(II)Ljava/lang/String;
    //   1814: pop
    //   1815: iload 4
    //   1817: istore_2
    //   1818: goto -493 -> 1325
    //   1821: astore 18
    //   1823: iload 8
    //   1825: istore 7
    //   1827: iload_3
    //   1828: istore 4
    //   1830: aload_0
    //   1831: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1834: invokevirtual 330	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1837: iload 8
    //   1839: istore 7
    //   1841: iload_3
    //   1842: istore 4
    //   1844: aload 18
    //   1846: athrow
    //   1847: aload_0
    //   1848: getfield 203	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1851: invokevirtual 288	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   1854: iload 4
    //   1856: ireturn
    //   1857: bipush 7
    //   1859: istore_2
    //   1860: goto -535 -> 1325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1863	0	this	TcpConnection
    //   0	1863	1	paramEndPoint	EndPoint
    //   131	1729	2	i	int
    //   184	1658	3	j	int
    //   143	1712	4	k	int
    //   900	119	5	m	int
    //   127	1672	6	bool1	boolean
    //   121	1719	7	bool2	boolean
    //   158	1680	8	bool3	boolean
    //   118	915	9	bool4	boolean
    //   124	891	10	bool5	boolean
    //   706	209	11	bool6	boolean
    //   177	1101	12	l1	long
    //   140	834	14	l2	long
    //   135	994	16	l3	long
    //   738	247	18	localStringBuilder	StringBuilder
    //   1197	112	18	localThrowable	java.lang.Throwable
    //   1345	426	18	localInterruptedException	InterruptedException
    //   1775	31	18	str	String
    //   1821	24	18	localObject1	Object
    //   797	945	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   185	204	1197	java/lang/Throwable
    //   221	229	1197	java/lang/Throwable
    //   246	257	1197	java/lang/Throwable
    //   274	282	1197	java/lang/Throwable
    //   299	307	1197	java/lang/Throwable
    //   324	335	1197	java/lang/Throwable
    //   352	361	1197	java/lang/Throwable
    //   378	383	1197	java/lang/Throwable
    //   400	415	1197	java/lang/Throwable
    //   432	442	1197	java/lang/Throwable
    //   459	470	1197	java/lang/Throwable
    //   487	510	1197	java/lang/Throwable
    //   527	541	1197	java/lang/Throwable
    //   558	569	1197	java/lang/Throwable
    //   586	598	1197	java/lang/Throwable
    //   615	625	1197	java/lang/Throwable
    //   642	650	1197	java/lang/Throwable
    //   667	674	1197	java/lang/Throwable
    //   691	699	1197	java/lang/Throwable
    //   728	740	1197	java/lang/Throwable
    //   757	773	1197	java/lang/Throwable
    //   790	799	1197	java/lang/Throwable
    //   821	829	1197	java/lang/Throwable
    //   846	859	1197	java/lang/Throwable
    //   876	896	1197	java/lang/Throwable
    //   918	1014	1197	java/lang/Throwable
    //   145	160	1345	java/lang/InterruptedException
    //   1022	1029	1345	java/lang/InterruptedException
    //   1332	1339	1345	java/lang/InterruptedException
    //   1830	1837	1345	java/lang/InterruptedException
    //   1844	1847	1345	java/lang/InterruptedException
    //   185	204	1821	finally
    //   221	229	1821	finally
    //   246	257	1821	finally
    //   274	282	1821	finally
    //   299	307	1821	finally
    //   324	335	1821	finally
    //   352	361	1821	finally
    //   378	383	1821	finally
    //   400	415	1821	finally
    //   432	442	1821	finally
    //   459	470	1821	finally
    //   487	510	1821	finally
    //   527	541	1821	finally
    //   558	569	1821	finally
    //   586	598	1821	finally
    //   615	625	1821	finally
    //   642	650	1821	finally
    //   667	674	1821	finally
    //   691	699	1821	finally
    //   728	740	1821	finally
    //   757	773	1821	finally
    //   790	799	1821	finally
    //   821	829	1821	finally
    //   846	859	1821	finally
    //   876	896	1821	finally
    //   918	1014	1821	finally
    //   1206	1215	1821	finally
    //   1222	1301	1821	finally
    //   1308	1318	1821	finally
    //   1405	1417	1821	finally
    //   1429	1441	1821	finally
    //   1453	1465	1821	finally
    //   1477	1489	1821	finally
    //   1501	1513	1821	finally
    //   1525	1537	1821	finally
    //   1550	1562	1821	finally
    //   1569	1581	1821	finally
    //   1591	1603	1821	finally
    //   1616	1628	1821	finally
    //   1641	1653	1821	finally
    //   1666	1678	1821	finally
    //   1691	1703	1821	finally
    //   1716	1728	1821	finally
    //   1741	1753	1821	finally
    //   1770	1777	1821	finally
    //   1787	1798	1821	finally
    //   1805	1815	1821	finally
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
  
  public void connect()
  {
    BdhLogUtil.LogEvent("C", "Connect : About to send conn request.");
    this.mConnThread.start();
    this.mConnHandler = new ConnWorker(this.mConnThread.getLooper());
    this.mConnHandler.sendEmptyMessage(1);
    this.connInfo.connStartTime = SystemClock.uptimeMillis();
    this.connInfo.serverIp = this.mEp.host;
    this.connInfo.port = this.mEp.port;
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
  
  public boolean isWritable()
  {
    return (this.isRunning.get()) && (!this.isWritting.get());
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    QLog.d("BDH_LOG", 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + paramInt);
    if (this.connListener != null) {
      this.connListener.onRecvInvalidData(this.mEp);
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
    ConnWorker localConnWorker = this.mConnHandler;
    if ((this.isRunning.get()) && (localConnWorker != null)) {
      localConnWorker.wakeupToWrite();
    }
  }
  
  class ConnWorker
    extends Handler
  {
    public static final int CONN = 1;
    public static final int QUIT = 3;
    public static final int SEND = 2;
    
    public ConnWorker(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1) {
        TcpConnection.this.openConn(TcpConnection.this.mEp);
      }
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          TcpConnection.this.doSendData();
          return;
        }
      } while (paramMessage.what != 3);
      TcpConnection.this.mConnThread.quit();
      TcpConnection.access$1102(TcpConnection.this, null);
      TcpConnection.access$1202(TcpConnection.this, null);
    }
    
    public void notifyToQuit()
    {
      if (TcpConnection.this.mConnHandler != null) {
        TcpConnection.this.mConnHandler.sendEmptyMessage(3);
      }
    }
    
    public void wakeupToWrite()
    {
      ConnWorker localConnWorker = TcpConnection.this.mConnHandler;
      if (localConnWorker != null) {
        localConnWorker.sendEmptyMessage(2);
      }
    }
  }
  
  class ReadThread
    extends Thread
  {
    ReadThread() {}
    
    public void run()
    {
      while (TcpConnection.this.isRunning.get()) {
        try
        {
          ??? = TcpConnection.this.mInputBuffer;
          if (??? == null) {
            return;
          }
          while (!((MsfSocketInputBuffer)???).isDataAvailable(30000)) {
            if (!TcpConnection.this.isRunning.get()) {
              return;
            }
          }
          if (TcpConnection.this.isRunning.get())
          {
            int i = ((MsfSocketInputBuffer)???).getBufferlen();
            ConnReportInfo localConnReportInfo = TcpConnection.this.connInfo;
            localConnReportInfo.receiveDataLen += i;
            TcpConnection.this.connManager.increaseDataFlowDw(i);
            TcpConnection.access$402(TcpConnection.this, TcpConnection.this.mNetFlowDw + i);
            TcpConnection.this.dataCodec.onRecvData((MsfSocketInputBuffer)???);
            ((MsfSocketInputBuffer)???).reset();
          }
        }
        catch (Exception localException)
        {
          BdhLogUtil.LogException("C", "ReadThread Error.", localException);
          synchronized (TcpConnection.this.closeDebug)
          {
            TcpConnection.this.closeDebug.append("By ReadThread : " + localException.getMessage() + ";");
            TcpConnection.this.closeConn(1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection
 * JD-Core Version:    0.7.0.1
 */