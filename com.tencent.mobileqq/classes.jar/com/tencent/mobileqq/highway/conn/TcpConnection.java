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
  
  static {}
  
  public TcpConnection(ConnManager paramConnManager, int paramInt1, EndPoint paramEndPoint, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramEndPoint.protoType == 2) {
      this.dataCodec = new HttpProtocolDataCodec();
    } else {
      this.dataCodec = new TcpProtocolDataCodec();
    }
    this.connManager = paramConnManager;
    this.mReadBufferSize = 32768;
    this.mReadTimeout = paramInt3;
    this.connId = paramInt1;
    this.mEp = paramEndPoint;
    this.mConnTimeOut = paramInt2;
    paramConnManager = new StringBuilder();
    paramConnManager.append("Highway-BDH-CONN");
    paramConnManager.append(paramInt1);
    this.mConnThread = new HandlerThread(paramConnManager.toString());
    this.dataCodec.setProtocolCodecListener(this);
    this.mServletHandler = new Handler(Looper.getMainLooper());
    this.isIpv6 = paramBoolean;
  }
  
  /* Error */
  private void closeConn(int paramInt)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 250
    //   13: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: aload_0
    //   20: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   23: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: ldc 252
    //   31: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: iload_1
    //   38: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 7
    //   44: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 7
    //   49: iconst_1
    //   50: istore 6
    //   52: iconst_1
    //   53: istore 5
    //   55: iconst_1
    //   56: istore_3
    //   57: iconst_1
    //   58: istore 4
    //   60: ldc 254
    //   62: iconst_1
    //   63: aload 7
    //   65: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: getfield 108	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   72: iconst_0
    //   73: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   76: aload_0
    //   77: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   80: ifnull +276 -> 356
    //   83: aload_0
    //   84: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   87: invokevirtual 269	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   90: ifne +4 -> 94
    //   93: return
    //   94: aload_0
    //   95: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: ldc2_w 270
    //   101: getstatic 277	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   104: invokevirtual 281	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   107: ifeq +236 -> 343
    //   110: aload_0
    //   111: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   114: ifnull +26 -> 140
    //   117: aload_0
    //   118: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   121: getfield 287	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   124: astore 7
    //   126: aload 7
    //   128: ifnull +12 -> 140
    //   131: iconst_0
    //   132: aload 7
    //   134: invokevirtual 288	java/lang/Object:toString	()Ljava/lang/String;
    //   137: invokestatic 292	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   140: aload_0
    //   141: getfield 294	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   144: ifnull +14 -> 158
    //   147: iconst_0
    //   148: aload_0
    //   149: getfield 294	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   152: invokevirtual 288	java/lang/Object:toString	()Ljava/lang/String;
    //   155: invokestatic 292	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 216	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   162: astore 7
    //   164: aload 7
    //   166: ifnull +8 -> 174
    //   169: aload 7
    //   171: invokevirtual 299	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 294	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   184: aload_0
    //   185: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   188: ifnull +10 -> 198
    //   191: aload_0
    //   192: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   195: invokevirtual 304	java/net/Socket:close	()V
    //   198: aload_0
    //   199: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   202: iconst_0
    //   203: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 306	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   216: aload_0
    //   217: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   220: iconst_1
    //   221: putfield 309	com/tencent/mobileqq/highway/conn/ConnReportInfo:finished	Z
    //   224: aload_0
    //   225: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   228: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   231: aload_0
    //   232: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   235: getfield 318	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   238: lsub
    //   239: putfield 321	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeLong	J
    //   242: aload_0
    //   243: getfield 127	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   246: istore_1
    //   247: aload_0
    //   248: getfield 129	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   251: istore_2
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 127	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 129	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   262: getstatic 323	com/tencent/mobileqq/highway/conn/TcpConnection:IsRunTimeShutDown	Z
    //   265: ifne +26 -> 291
    //   268: new 325	java/lang/Thread
    //   271: dup
    //   272: new 327	com/tencent/mobileqq/highway/conn/TcpConnection$2
    //   275: dup
    //   276: aload_0
    //   277: iload_1
    //   278: iload_2
    //   279: invokespecial 330	com/tencent/mobileqq/highway/conn/TcpConnection$2:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;II)V
    //   282: ldc_w 332
    //   285: invokespecial 335	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   288: invokevirtual 338	java/lang/Thread:start	()V
    //   291: iload 6
    //   293: istore 4
    //   295: aload_0
    //   296: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   299: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   302: goto +88 -> 390
    //   305: iload_3
    //   306: istore 4
    //   308: iload_3
    //   309: istore 5
    //   311: aload_0
    //   312: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   315: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   318: iload_3
    //   319: istore 4
    //   321: iload_3
    //   322: istore 5
    //   324: aload 7
    //   326: athrow
    //   327: astore 7
    //   329: iload 4
    //   331: istore_3
    //   332: goto +29 -> 361
    //   335: astore 7
    //   337: iload 5
    //   339: istore_3
    //   340: goto +39 -> 379
    //   343: aload_0
    //   344: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   347: iconst_1
    //   348: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   351: iconst_0
    //   352: istore_3
    //   353: goto +37 -> 390
    //   356: return
    //   357: astore 7
    //   359: iconst_0
    //   360: istore_3
    //   361: ldc_w 343
    //   364: ldc_w 345
    //   367: aload 7
    //   369: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto +18 -> 390
    //   375: astore 7
    //   377: iconst_0
    //   378: istore_3
    //   379: ldc_w 343
    //   382: ldc_w 345
    //   385: aload 7
    //   387: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   390: aload_0
    //   391: getfield 353	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   394: astore 7
    //   396: aload 7
    //   398: ifnull +15 -> 413
    //   401: aload 7
    //   403: aload_0
    //   404: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   407: aload_0
    //   408: invokeinterface 359 3 0
    //   413: new 110	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   420: astore 7
    //   422: aload 7
    //   424: ldc_w 361
    //   427: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 7
    //   433: aload_0
    //   434: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   437: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 7
    //   443: ldc_w 363
    //   446: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 7
    //   452: iload_3
    //   453: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc_w 343
    //   460: aload 7
    //   462: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: return
    //   469: astore 7
    //   471: goto -273 -> 198
    //   474: astore 7
    //   476: iload 4
    //   478: istore_3
    //   479: goto -174 -> 305
    //   482: astore 7
    //   484: iconst_0
    //   485: istore_3
    //   486: goto -181 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	TcpConnection
    //   0	489	1	paramInt	int
    //   251	28	2	i	int
    //   56	430	3	bool1	boolean
    //   58	419	4	bool2	boolean
    //   53	285	5	bool3	boolean
    //   50	242	6	bool4	boolean
    //   7	318	7	localObject1	Object
    //   327	1	7	localException1	Exception
    //   335	1	7	localInterruptedException1	java.lang.InterruptedException
    //   357	11	7	localException2	Exception
    //   375	11	7	localInterruptedException2	java.lang.InterruptedException
    //   394	67	7	localObject2	Object
    //   469	1	7	localException3	Exception
    //   474	1	7	localObject3	Object
    //   482	1	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   295	302	327	java/lang/Exception
    //   311	318	327	java/lang/Exception
    //   324	327	327	java/lang/Exception
    //   295	302	335	java/lang/InterruptedException
    //   311	318	335	java/lang/InterruptedException
    //   324	327	335	java/lang/InterruptedException
    //   76	93	357	java/lang/Exception
    //   94	126	357	java/lang/Exception
    //   131	140	357	java/lang/Exception
    //   140	158	357	java/lang/Exception
    //   343	351	357	java/lang/Exception
    //   76	93	375	java/lang/InterruptedException
    //   94	126	375	java/lang/InterruptedException
    //   131	140	375	java/lang/InterruptedException
    //   140	158	375	java/lang/InterruptedException
    //   343	351	375	java/lang/InterruptedException
    //   184	198	469	java/lang/Exception
    //   216	291	474	finally
    //   158	164	482	finally
    //   169	174	482	finally
    //   174	184	482	finally
    //   184	198	482	finally
    //   198	216	482	finally
  }
  
  private void doSendData()
  {
    if (this.isRunning.get()) {
      if (this.isWritting.get()) {
        return;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          ??? = this.connManager.pullNextRequest(this, this.isUrgent, this.mLastDataTransTime, this.mRtt, this.mLastDataSegSize);
          bool = true;
          if (??? == null)
          {
            this.isWritting.set(false);
            if (SystemClock.uptimeMillis() - this.lastHeartBreakTime <= 60000L) {
              return;
            }
            this.lastHeartBreakTime = SystemClock.uptimeMillis();
            ??? = this.connManager;
            i = this.connId;
            if (this.continueHeartBreak != 0) {
              break label754;
            }
            ((ConnManager)???).onConnectionIdle(i, bool);
            return;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("req sending: reqId = ");
          ((StringBuilder)localObject2).append(((HwRequest)???).getHwSeq());
          ((StringBuilder)localObject2).append(" req.timeOutCount = ");
          ((StringBuilder)localObject2).append(((HwRequest)???).timeOutCount);
          ((StringBuilder)localObject2).append(" req.timeOut = ");
          ((StringBuilder)localObject2).append(((HwRequest)???).timeOut);
          BdhLogUtil.LogEvent("R", ((StringBuilder)localObject2).toString());
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
          else
          {
            this.continueHeartBreak = 0;
            this.lastHeartBreakTime = 0L;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            Object localObject2;
            Object localObject4;
            long l1;
            long l2;
            BdhLogUtil.LogException("C", "SendThread Error.", localException2);
            synchronized (this.closeDebug)
            {
              localObject4 = this.closeDebug;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("By SendWorker :");
              localStringBuilder.append(localException2.getMessage());
              localStringBuilder.append(";");
              ((StringBuilder)localObject4).append(localStringBuilder.toString());
              closeConn(2);
            }
          }
        }
        try
        {
          localObject2 = ((HwRequest)???).getRequestBody();
          if ((localObject2 == null) && (((HwRequest)???).hasRequestBody()))
          {
            ((HwRequest)???).reqListener.handleError(-1004, "NullBody", this);
            this.isWritting.set(false);
            break;
          }
          localObject2 = this.dataCodec.encodeC2SData(this.mEp, (HwRequest)???, (byte[])localObject2);
          if (localObject2 == null)
          {
            this.isWritting.set(false);
            break;
          }
          if (((HwRequest)???).retryCount == 0)
          {
            localObject4 = this.connInfo;
            ((ConnReportInfo)localObject4).sentRequestCount += 1;
          }
          else
          {
            localObject4 = this.connInfo;
            ((ConnReportInfo)localObject4).sentRetryCount += 1;
          }
          localObject4 = this.connInfo;
          ((ConnReportInfo)localObject4).sentDataLen += localObject2.length;
          ((HwRequest)???).sendTime = SystemClock.uptimeMillis();
          l1 = SystemClock.uptimeMillis();
          localObject4 = this.mOutputStream;
          if (localObject4 != null)
          {
            ((OutputStream)localObject4).write((byte[])localObject2);
            ((OutputStream)localObject4).flush();
          }
          i = localObject2.length;
          this.connManager.increaseDataFlowUp(i);
          l2 = SystemClock.uptimeMillis();
          this.mNetFlowUp += i;
          ((HwRequest)???).reqListener.handleSendEnd(this.connId, getProtoType());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("SendRequest End. CostTrace  reqId: ");
          ((StringBuilder)localObject2).append(((HwRequest)???).getHwSeq());
          ((StringBuilder)localObject2).append(" SendComsume:");
          ((StringBuilder)localObject2).append(((HwRequest)???).sendComsume);
          ((StringBuilder)localObject2).append(" WriteComsume:");
          ((StringBuilder)localObject2).append(l2 - l1);
          ((StringBuilder)localObject2).append(" ConnID:");
          ((StringBuilder)localObject2).append(this.connId);
          ((StringBuilder)localObject2).append(" ReqInfo:");
          ((StringBuilder)localObject2).append(((HwRequest)???).dumpBaseInfo());
          ((StringBuilder)localObject2).append(" ContinueHeartBreak:");
          ((StringBuilder)localObject2).append(this.continueHeartBreak);
          BdhLogUtil.LogEvent("R", ((StringBuilder)localObject2).toString());
          this.isWritting.set(false);
        }
        catch (Exception localException1) {}
      }
      this.isWritting.set(false);
      break;
      return;
      label754:
      boolean bool = false;
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
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: ldc_w 515
    //   14: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 10
    //   20: aload_1
    //   21: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   24: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 10
    //   30: ldc_w 521
    //   33: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 10
    //   39: aload_1
    //   40: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   43: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 10
    //   49: ldc_w 526
    //   52: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 10
    //   58: aload_0
    //   59: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   62: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 10
    //   68: ldc_w 528
    //   71: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 10
    //   77: aload_1
    //   78: getfield 145	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   81: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 10
    //   87: ldc_w 530
    //   90: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 254
    //   96: iconst_1
    //   97: aload 10
    //   99: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_0
    //   106: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   109: invokevirtual 269	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   112: ifne +13 -> 125
    //   115: aload_0
    //   116: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: invokevirtual 269	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   122: ifeq +26 -> 148
    //   125: aload_0
    //   126: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   129: invokevirtual 269	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   132: ifeq +16 -> 148
    //   135: aload_0
    //   136: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   139: iconst_0
    //   140: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   143: aload_0
    //   144: iconst_2
    //   145: invokespecial 236	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   148: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   151: lstore 6
    //   153: aload_0
    //   154: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   157: ldc2_w 270
    //   160: getstatic 277	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   163: invokevirtual 281	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   166: istore 8
    //   168: iload 8
    //   170: ifeq +1004 -> 1174
    //   173: aload_0
    //   174: new 532	java/net/InetSocketAddress
    //   177: dup
    //   178: aload_1
    //   179: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   182: aload_1
    //   183: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   186: invokespecial 535	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   189: putfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   192: aload_0
    //   193: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   196: iconst_0
    //   197: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   200: aload_0
    //   201: new 301	java/net/Socket
    //   204: dup
    //   205: invokespecial 536	java/net/Socket:<init>	()V
    //   208: putfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   211: aload_0
    //   212: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   215: iconst_1
    //   216: invokevirtual 539	java/net/Socket:setKeepAlive	(Z)V
    //   219: aload_0
    //   220: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   223: iconst_1
    //   224: invokevirtual 542	java/net/Socket:setTcpNoDelay	(Z)V
    //   227: aload_0
    //   228: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   231: aload_0
    //   232: getfield 159	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   235: invokevirtual 545	java/net/Socket:setSoTimeout	(I)V
    //   238: aload_0
    //   239: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   242: ldc 19
    //   244: invokevirtual 548	java/net/Socket:setSendBufferSize	(I)V
    //   247: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   250: lstore 4
    //   252: aload_0
    //   253: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   256: aload_0
    //   257: getfield 100	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   260: aload_0
    //   261: getfield 104	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   264: invokevirtual 552	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   267: aload_0
    //   268: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   271: lload 4
    //   273: lsub
    //   274: putfield 135	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   282: invokevirtual 556	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   285: putfield 294	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   288: aload_0
    //   289: new 283	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   292: dup
    //   293: aload_0
    //   294: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   297: aload_0
    //   298: getfield 157	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   301: ldc_w 558
    //   304: iconst_m1
    //   305: invokespecial 561	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   308: putfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   311: iconst_1
    //   312: aload_0
    //   313: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   316: getfield 287	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   319: invokevirtual 288	java/lang/Object:toString	()Ljava/lang/String;
    //   322: invokestatic 292	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   325: iconst_1
    //   326: aload_0
    //   327: getfield 294	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   330: invokevirtual 288	java/lang/Object:toString	()Ljava/lang/String;
    //   333: invokestatic 292	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   336: aload_0
    //   337: new 563	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   340: dup
    //   341: aload_0
    //   342: invokespecial 565	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   345: putfield 306	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   348: aload_0
    //   349: getfield 306	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   352: ldc_w 567
    //   355: invokevirtual 570	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:setName	(Ljava/lang/String;)V
    //   358: aload_0
    //   359: getfield 108	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   362: iconst_1
    //   363: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   366: aload_0
    //   367: getfield 306	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   370: invokevirtual 571	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   373: aload_0
    //   374: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   377: iconst_1
    //   378: invokevirtual 263	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   381: new 110	java/lang/StringBuilder
    //   384: dup
    //   385: ldc_w 573
    //   388: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: astore 10
    //   393: aload_0
    //   394: getfield 163	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   397: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   400: ldc_w 575
    //   403: invokevirtual 581	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   406: ifeq +64 -> 470
    //   409: aload_0
    //   410: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   413: invokevirtual 585	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   416: astore 11
    //   418: aload 11
    //   420: ifnull +50 -> 470
    //   423: aload 11
    //   425: instanceof 532
    //   428: ifeq +42 -> 470
    //   431: aload 11
    //   433: checkcast 532	java/net/InetSocketAddress
    //   436: invokevirtual 589	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   439: invokevirtual 594	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   442: astore 11
    //   444: aload 10
    //   446: ldc_w 596
    //   449: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 10
    //   455: aload 11
    //   457: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 10
    //   463: ldc_w 598
    //   466: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: new 110	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   477: astore 11
    //   479: aload 11
    //   481: ldc_w 600
    //   484: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 11
    //   490: aload_1
    //   491: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   494: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 11
    //   500: ldc_w 521
    //   503: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 11
    //   509: aload_1
    //   510: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   513: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 11
    //   519: ldc_w 526
    //   522: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 11
    //   528: aload_0
    //   529: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   532: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 11
    //   538: ldc_w 602
    //   541: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 11
    //   547: lload 4
    //   549: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 11
    //   555: ldc_w 604
    //   558: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 11
    //   564: aload 10
    //   566: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 11
    //   575: ldc_w 606
    //   578: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 11
    //   584: aload_0
    //   585: getfield 265	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   588: invokevirtual 609	java/net/Socket:getLocalPort	()I
    //   591: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: ldc_w 343
    //   598: aload 11
    //   600: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 370	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload_0
    //   607: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   610: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   613: iconst_1
    //   614: istore 8
    //   616: iconst_0
    //   617: istore_2
    //   618: goto +562 -> 1180
    //   621: astore 10
    //   623: iconst_1
    //   624: istore 8
    //   626: iconst_0
    //   627: istore_2
    //   628: goto +563 -> 1191
    //   631: astore 10
    //   633: iconst_1
    //   634: istore 8
    //   636: iconst_0
    //   637: istore_2
    //   638: goto +521 -> 1159
    //   641: astore 10
    //   643: iconst_1
    //   644: istore 8
    //   646: iconst_0
    //   647: istore_2
    //   648: goto +54 -> 702
    //   651: astore 10
    //   653: iconst_1
    //   654: istore 8
    //   656: goto +27 -> 683
    //   659: astore 10
    //   661: iconst_1
    //   662: istore 8
    //   664: goto +8 -> 672
    //   667: astore 10
    //   669: iconst_0
    //   670: istore 8
    //   672: bipush 14
    //   674: istore_2
    //   675: goto +27 -> 702
    //   678: astore 10
    //   680: iconst_0
    //   681: istore 8
    //   683: bipush 14
    //   685: istore_2
    //   686: goto +473 -> 1159
    //   689: astore 10
    //   691: iconst_0
    //   692: istore 8
    //   694: bipush 14
    //   696: istore_2
    //   697: ldc2_w 610
    //   700: lstore 4
    //   702: aload_0
    //   703: getfield 155	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   706: invokevirtual 614	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   709: istore 9
    //   711: new 110	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   718: astore 11
    //   720: aload 11
    //   722: ldc_w 616
    //   725: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 11
    //   731: aload_1
    //   732: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   735: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 11
    //   741: ldc_w 521
    //   744: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 11
    //   750: aload_1
    //   751: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   754: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload 11
    //   760: ldc_w 526
    //   763: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 11
    //   769: aload_0
    //   770: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   773: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload 11
    //   779: ldc_w 602
    //   782: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 11
    //   788: lload 4
    //   790: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload 11
    //   796: ldc_w 618
    //   799: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 11
    //   805: iload 9
    //   807: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: ldc_w 343
    //   814: aload 11
    //   816: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: aload 10
    //   821: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   824: aload 10
    //   826: invokevirtual 619	java/lang/Throwable:toString	()Ljava/lang/String;
    //   829: invokevirtual 622	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   832: astore 11
    //   834: iload 9
    //   836: ifne +6 -> 842
    //   839: goto +598 -> 1437
    //   842: aload 11
    //   844: ldc_w 624
    //   847: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   850: iconst_m1
    //   851: if_icmple +8 -> 859
    //   854: iconst_1
    //   855: istore_2
    //   856: goto +281 -> 1137
    //   859: aload 11
    //   861: ldc_w 630
    //   864: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   867: iconst_m1
    //   868: if_icmple +8 -> 876
    //   871: iconst_2
    //   872: istore_2
    //   873: goto +264 -> 1137
    //   876: aload 11
    //   878: ldc_w 632
    //   881: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   884: iconst_m1
    //   885: if_icmple +6 -> 891
    //   888: goto +549 -> 1437
    //   891: aload 11
    //   893: ldc_w 634
    //   896: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   899: iconst_m1
    //   900: if_icmple +8 -> 908
    //   903: iconst_4
    //   904: istore_2
    //   905: goto +232 -> 1137
    //   908: aload 11
    //   910: ldc_w 636
    //   913: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   916: iconst_m1
    //   917: if_icmple +8 -> 925
    //   920: iconst_5
    //   921: istore_2
    //   922: goto +215 -> 1137
    //   925: aload 11
    //   927: ldc_w 638
    //   930: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   933: iconst_m1
    //   934: if_icmple +9 -> 943
    //   937: bipush 6
    //   939: istore_2
    //   940: goto +197 -> 1137
    //   943: aload 11
    //   945: ldc_w 640
    //   948: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   951: iconst_m1
    //   952: if_icmpgt +182 -> 1134
    //   955: aload 11
    //   957: ldc_w 642
    //   960: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   963: iconst_m1
    //   964: if_icmple +6 -> 970
    //   967: goto +167 -> 1134
    //   970: aload 11
    //   972: ldc_w 644
    //   975: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   978: iconst_m1
    //   979: if_icmple +9 -> 988
    //   982: bipush 8
    //   984: istore_2
    //   985: goto +152 -> 1137
    //   988: aload 11
    //   990: ldc_w 646
    //   993: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   996: iconst_m1
    //   997: if_icmple +9 -> 1006
    //   1000: bipush 9
    //   1002: istore_2
    //   1003: goto +134 -> 1137
    //   1006: aload 11
    //   1008: ldc_w 648
    //   1011: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1014: iconst_m1
    //   1015: if_icmple +9 -> 1024
    //   1018: bipush 10
    //   1020: istore_2
    //   1021: goto +116 -> 1137
    //   1024: aload 11
    //   1026: ldc_w 650
    //   1029: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1032: iconst_m1
    //   1033: if_icmple +9 -> 1042
    //   1036: bipush 11
    //   1038: istore_2
    //   1039: goto +98 -> 1137
    //   1042: aload 11
    //   1044: ldc_w 652
    //   1047: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1050: iconst_m1
    //   1051: if_icmple +9 -> 1060
    //   1054: bipush 12
    //   1056: istore_2
    //   1057: goto +80 -> 1137
    //   1060: aload 11
    //   1062: ldc_w 654
    //   1065: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1068: iconst_m1
    //   1069: if_icmple +6 -> 1075
    //   1072: goto +62 -> 1134
    //   1075: aload 11
    //   1077: ldc_w 656
    //   1080: invokevirtual 628	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1083: istore_3
    //   1084: iload_3
    //   1085: iconst_m1
    //   1086: if_icmple +9 -> 1095
    //   1089: bipush 13
    //   1091: istore_2
    //   1092: goto +45 -> 1137
    //   1095: aload 10
    //   1097: invokestatic 662	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1100: astore 10
    //   1102: aload 10
    //   1104: invokevirtual 665	java/lang/String:length	()I
    //   1107: sipush 200
    //   1110: if_icmple +13 -> 1123
    //   1113: aload 10
    //   1115: iconst_0
    //   1116: sipush 200
    //   1119: invokevirtual 669	java/lang/String:substring	(II)Ljava/lang/String;
    //   1122: pop
    //   1123: bipush 14
    //   1125: istore_2
    //   1126: goto +11 -> 1137
    //   1129: astore 10
    //   1131: goto -448 -> 683
    //   1134: bipush 7
    //   1136: istore_2
    //   1137: aload_0
    //   1138: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1141: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1144: goto +36 -> 1180
    //   1147: astore 10
    //   1149: goto +42 -> 1191
    //   1152: astore 10
    //   1154: goto +5 -> 1159
    //   1157: astore 10
    //   1159: aload_0
    //   1160: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1163: invokevirtual 341	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1166: aload 10
    //   1168: athrow
    //   1169: astore 10
    //   1171: goto +20 -> 1191
    //   1174: iconst_0
    //   1175: istore 8
    //   1177: bipush 14
    //   1179: istore_2
    //   1180: goto +71 -> 1251
    //   1183: astore 10
    //   1185: iconst_0
    //   1186: istore 8
    //   1188: bipush 14
    //   1190: istore_2
    //   1191: new 110	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1198: astore 11
    //   1200: aload 11
    //   1202: ldc_w 671
    //   1205: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload 11
    //   1211: aload_1
    //   1212: getfield 519	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   1215: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload 11
    //   1221: ldc_w 521
    //   1224: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: aload 11
    //   1230: aload_1
    //   1231: getfield 524	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   1234: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: ldc_w 343
    //   1241: aload 11
    //   1243: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: aload 10
    //   1248: invokestatic 351	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1251: aload_0
    //   1252: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1255: astore_1
    //   1256: aload_1
    //   1257: iload 8
    //   1259: putfield 674	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   1262: aload_1
    //   1263: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   1266: aload_0
    //   1267: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1270: getfield 318	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   1273: lsub
    //   1274: putfield 677	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   1277: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   1280: lstore 4
    //   1282: aload_0
    //   1283: getfield 353	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1286: ifnull +118 -> 1404
    //   1289: new 110	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   1296: astore_1
    //   1297: aload_1
    //   1298: ldc_w 679
    //   1301: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_1
    //   1306: aload_0
    //   1307: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1310: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload_1
    //   1315: ldc_w 681
    //   1318: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: aload_1
    //   1323: iload 8
    //   1325: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1328: pop
    //   1329: aload_1
    //   1330: ldc_w 683
    //   1333: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload_1
    //   1338: iload_2
    //   1339: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload_1
    //   1344: ldc_w 685
    //   1347: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_1
    //   1352: lload 4
    //   1354: lload 6
    //   1356: lsub
    //   1357: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: ldc_w 687
    //   1365: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: ldc 254
    //   1371: iconst_1
    //   1372: aload_1
    //   1373: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1376: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1379: aload_0
    //   1380: getfield 353	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   1383: iload 8
    //   1385: aload_0
    //   1386: getfield 161	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   1389: aload_0
    //   1390: aload_0
    //   1391: getfield 163	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   1394: iload_2
    //   1395: aload_0
    //   1396: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1399: invokeinterface 691 7 0
    //   1404: iload 8
    //   1406: ifeq +22 -> 1428
    //   1409: aload_0
    //   1410: getfield 140	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   1413: invokestatic 315	android/os/SystemClock:uptimeMillis	()J
    //   1416: putfield 694	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   1419: aload_0
    //   1420: getfield 216	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1423: invokevirtual 697	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:wakeupToWrite	()V
    //   1426: iload_2
    //   1427: ireturn
    //   1428: aload_0
    //   1429: getfield 216	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1432: invokevirtual 299	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   1435: iload_2
    //   1436: ireturn
    //   1437: iconst_3
    //   1438: istore_2
    //   1439: goto -302 -> 1137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1442	0	this	TcpConnection
    //   0	1442	1	paramEndPoint	EndPoint
    //   617	822	2	i	int
    //   1083	4	3	j	int
    //   250	1103	4	l1	long
    //   151	1204	6	l2	long
    //   166	1239	8	bool1	boolean
    //   709	126	9	bool2	boolean
    //   7	558	10	localStringBuilder	StringBuilder
    //   621	1	10	localInterruptedException1	java.lang.InterruptedException
    //   631	1	10	localObject1	Object
    //   641	1	10	localThrowable1	java.lang.Throwable
    //   651	1	10	localObject2	Object
    //   659	1	10	localThrowable2	java.lang.Throwable
    //   667	1	10	localThrowable3	java.lang.Throwable
    //   678	1	10	localObject3	Object
    //   689	407	10	localThrowable4	java.lang.Throwable
    //   1100	14	10	str	String
    //   1129	1	10	localObject4	Object
    //   1147	1	10	localInterruptedException2	java.lang.InterruptedException
    //   1152	1	10	localObject5	Object
    //   1157	10	10	localObject6	Object
    //   1169	1	10	localInterruptedException3	java.lang.InterruptedException
    //   1183	64	10	localInterruptedException4	java.lang.InterruptedException
    //   416	826	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   606	613	621	java/lang/InterruptedException
    //   470	606	631	finally
    //   470	606	641	java/lang/Throwable
    //   381	418	651	finally
    //   423	470	651	finally
    //   381	418	659	java/lang/Throwable
    //   423	470	659	java/lang/Throwable
    //   252	381	667	java/lang/Throwable
    //   173	252	678	finally
    //   252	381	678	finally
    //   173	252	689	java/lang/Throwable
    //   1095	1123	1129	finally
    //   1137	1144	1147	java/lang/InterruptedException
    //   720	834	1152	finally
    //   842	854	1152	finally
    //   859	871	1152	finally
    //   876	888	1152	finally
    //   891	903	1152	finally
    //   908	920	1152	finally
    //   925	937	1152	finally
    //   943	967	1152	finally
    //   970	982	1152	finally
    //   988	1000	1152	finally
    //   1006	1018	1152	finally
    //   1024	1036	1152	finally
    //   1042	1054	1152	finally
    //   1060	1072	1152	finally
    //   1075	1084	1152	finally
    //   702	720	1157	finally
    //   1159	1169	1169	java/lang/InterruptedException
    //   153	168	1183	java/lang/InterruptedException
  }
  
  public static void setExclusiveStream(boolean paramBoolean, String paramString)
  {
    synchronized (BaseApplication.exclusiveStreamList)
    {
      ArrayList localArrayList2 = BaseApplication.exclusiveStreamList;
      if (paramBoolean) {
        localArrayList2.add(paramString);
      } else {
        localArrayList2.remove(paramString);
      }
      return;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("C.  ConnId:");
    ((StringBuilder)localObject).append(this.connId);
    ((StringBuilder)localObject).append(" Host:");
    ((StringBuilder)localObject).append(this.mEp.host);
    ((StringBuilder)localObject).append(" Port:");
    ((StringBuilder)localObject).append(this.mEp.port);
    ((StringBuilder)localObject).append(" OnDecodeInvalidData : code : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("BDH_LOG", 1, ((StringBuilder)localObject).toString());
    localObject = this.connListener;
    if (localObject != null) {
      ((IConnectionListener)localObject).onRecvInvalidData(this.mEp, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.TcpConnection
 * JD-Core Version:    0.7.0.1
 */