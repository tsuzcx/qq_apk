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
  private int continueHeartBreak;
  private TcpProtocolDataCodec dataCodec;
  private AtomicBoolean isConn = new AtomicBoolean(false);
  private boolean isIpv6;
  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private volatile boolean isUrgent;
  private AtomicBoolean isWritting = new AtomicBoolean(false);
  private long lastHeartBreakTime;
  private ReentrantLock lock = new ReentrantLock();
  private TcpConnection.ConnWorker mConnHandler;
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
  private TcpConnection.ReadThread mReadThread;
  private int mReadTimeout;
  public long mRtt;
  private Handler mServletHandler;
  private Socket mSocket;
  private InetSocketAddress serverAddress;
  private AtomicBoolean shouldCloseConn = new AtomicBoolean(false);
  
  static {}
  
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
    //   17: ldc 234
    //   19: iconst_1
    //   20: new 104	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   27: ldc 236
    //   29: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   36: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 238
    //   41: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_1
    //   45: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   58: iconst_0
    //   59: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   62: iload 9
    //   64: istore 4
    //   66: iload 10
    //   68: istore 5
    //   70: aload_0
    //   71: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   74: ifnull +451 -> 525
    //   77: iload 9
    //   79: istore 4
    //   81: iload 10
    //   83: istore 5
    //   85: aload_0
    //   86: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   89: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   92: ifne +4 -> 96
    //   95: return
    //   96: iload 9
    //   98: istore 4
    //   100: iload 10
    //   102: istore 5
    //   104: aload_0
    //   105: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   108: ldc2_w 254
    //   111: getstatic 261	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   114: invokevirtual 265	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   117: ifeq +340 -> 457
    //   120: iload 9
    //   122: istore 4
    //   124: iload 10
    //   126: istore 5
    //   128: aload_0
    //   129: getfield 204	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   132: ifnull +42 -> 174
    //   135: iload 9
    //   137: istore 4
    //   139: iload 10
    //   141: istore 5
    //   143: aload_0
    //   144: getfield 204	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   147: getfield 271	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   150: astore 11
    //   152: aload 11
    //   154: ifnull +20 -> 174
    //   157: iload 9
    //   159: istore 4
    //   161: iload 10
    //   163: istore 5
    //   165: iconst_0
    //   166: aload 11
    //   168: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   171: invokestatic 276	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   174: iload 9
    //   176: istore 4
    //   178: iload 10
    //   180: istore 5
    //   182: aload_0
    //   183: getfield 278	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   186: ifnull +22 -> 208
    //   189: iload 9
    //   191: istore 4
    //   193: iload 10
    //   195: istore 5
    //   197: iconst_0
    //   198: aload_0
    //   199: getfield 278	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   202: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   205: invokestatic 276	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   208: aload_0
    //   209: getfield 196	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   212: astore 11
    //   214: aload 11
    //   216: ifnull +8 -> 224
    //   219: aload 11
    //   221: invokevirtual 283	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 204	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   229: aload_0
    //   230: aconst_null
    //   231: putfield 278	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   234: aload_0
    //   235: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   238: ifnull +10 -> 248
    //   241: aload_0
    //   242: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   245: invokevirtual 288	java/net/Socket:close	()V
    //   248: aload_0
    //   249: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   252: iconst_0
    //   253: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   256: aload_0
    //   257: aconst_null
    //   258: putfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 290	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   266: aload_0
    //   267: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   270: iconst_1
    //   271: putfield 293	com/tencent/mobileqq/highway/conn/ConnReportInfo:finished	Z
    //   274: aload_0
    //   275: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   278: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   281: aload_0
    //   282: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   285: getfield 302	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   288: lsub
    //   289: putfield 305	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeLong	J
    //   292: aload_0
    //   293: getfield 307	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   296: istore_1
    //   297: aload_0
    //   298: getfield 208	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   301: istore_2
    //   302: aload_0
    //   303: iconst_0
    //   304: putfield 307	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowUp	I
    //   307: aload_0
    //   308: iconst_0
    //   309: putfield 208	com/tencent/mobileqq/highway/conn/TcpConnection:mNetFlowDw	I
    //   312: getstatic 309	com/tencent/mobileqq/highway/conn/TcpConnection:IsRunTimeShutDown	Z
    //   315: ifne +26 -> 341
    //   318: new 311	java/lang/Thread
    //   321: dup
    //   322: new 313	com/tencent/mobileqq/highway/conn/TcpConnection$2
    //   325: dup
    //   326: aload_0
    //   327: iload_1
    //   328: iload_2
    //   329: invokespecial 316	com/tencent/mobileqq/highway/conn/TcpConnection$2:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;II)V
    //   332: ldc_w 318
    //   335: invokespecial 321	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   338: invokevirtual 324	java/lang/Thread:start	()V
    //   341: aload_0
    //   342: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   345: invokevirtual 327	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   348: aload_0
    //   349: getfield 329	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   352: astore 11
    //   354: aload 11
    //   356: ifnull +15 -> 371
    //   359: aload 11
    //   361: aload_0
    //   362: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   365: aload_0
    //   366: invokeinterface 335 3 0
    //   371: ldc_w 337
    //   374: new 104	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 339
    //   384: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_0
    //   388: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   391: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: ldc_w 341
    //   397: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload_3
    //   401: invokevirtual 344	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 350	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: return
    //   411: astore 11
    //   413: iload 6
    //   415: istore_3
    //   416: iload_3
    //   417: istore 4
    //   419: iload_3
    //   420: istore 5
    //   422: aload_0
    //   423: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   426: invokevirtual 327	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   429: iload_3
    //   430: istore 4
    //   432: iload_3
    //   433: istore 5
    //   435: aload 11
    //   437: athrow
    //   438: astore 11
    //   440: iload 4
    //   442: istore_3
    //   443: ldc_w 337
    //   446: ldc_w 352
    //   449: aload 11
    //   451: invokestatic 356	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   454: goto -106 -> 348
    //   457: iload 9
    //   459: istore 4
    //   461: iload 10
    //   463: istore 5
    //   465: aload_0
    //   466: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   469: iconst_1
    //   470: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   473: iconst_0
    //   474: istore_3
    //   475: goto -127 -> 348
    //   478: astore 11
    //   480: iload 5
    //   482: istore_3
    //   483: ldc_w 337
    //   486: ldc_w 352
    //   489: aload 11
    //   491: invokestatic 356	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   494: goto -146 -> 348
    //   497: astore 11
    //   499: iload 8
    //   501: istore_3
    //   502: goto -19 -> 483
    //   505: astore 11
    //   507: iload 7
    //   509: istore_3
    //   510: goto -67 -> 443
    //   513: astore 11
    //   515: iconst_1
    //   516: istore_3
    //   517: goto -101 -> 416
    //   520: astore 11
    //   522: goto -274 -> 248
    //   525: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	TcpConnection
    //   0	526	1	paramInt	int
    //   301	28	2	i	int
    //   7	510	3	bool1	boolean
    //   64	396	4	bool2	boolean
    //   68	413	5	bool3	boolean
    //   15	399	6	bool4	boolean
    //   1	507	7	bool5	boolean
    //   4	496	8	bool6	boolean
    //   9	449	9	bool7	boolean
    //   12	450	10	bool8	boolean
    //   150	210	11	localObject1	Object
    //   411	25	11	localObject2	Object
    //   438	12	11	localInterruptedException1	java.lang.InterruptedException
    //   478	12	11	localException1	Exception
    //   497	1	11	localException2	Exception
    //   505	1	11	localInterruptedException2	java.lang.InterruptedException
    //   513	1	11	localObject3	Object
    //   520	1	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   208	214	411	finally
    //   219	224	411	finally
    //   224	234	411	finally
    //   234	248	411	finally
    //   248	266	411	finally
    //   70	77	438	java/lang/InterruptedException
    //   85	95	438	java/lang/InterruptedException
    //   104	120	438	java/lang/InterruptedException
    //   128	135	438	java/lang/InterruptedException
    //   143	152	438	java/lang/InterruptedException
    //   165	174	438	java/lang/InterruptedException
    //   182	189	438	java/lang/InterruptedException
    //   197	208	438	java/lang/InterruptedException
    //   422	429	438	java/lang/InterruptedException
    //   435	438	438	java/lang/InterruptedException
    //   465	473	438	java/lang/InterruptedException
    //   70	77	478	java/lang/Exception
    //   85	95	478	java/lang/Exception
    //   104	120	478	java/lang/Exception
    //   128	135	478	java/lang/Exception
    //   143	152	478	java/lang/Exception
    //   165	174	478	java/lang/Exception
    //   182	189	478	java/lang/Exception
    //   197	208	478	java/lang/Exception
    //   422	429	478	java/lang/Exception
    //   435	438	478	java/lang/Exception
    //   465	473	478	java/lang/Exception
    //   341	348	497	java/lang/Exception
    //   341	348	505	java/lang/InterruptedException
    //   266	341	513	finally
    //   234	248	520	java/lang/Exception
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
    //   0: ldc 234
    //   2: iconst_1
    //   3: new 104	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 513
    //   13: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   20: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 519
    //   26: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: getfield 522	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   33: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 524
    //   39: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   46: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 526
    //   52: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 121	com/tencent/mobileqq/highway/utils/EndPoint:protoType	I
    //   59: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 528
    //   65: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: ifne +13 -> 94
    //   84: aload_0
    //   85: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifeq +26 -> 117
    //   94: aload_0
    //   95: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   98: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   101: ifeq +16 -> 117
    //   104: aload_0
    //   105: getfield 98	com/tencent/mobileqq/highway/conn/TcpConnection:shouldCloseConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   108: iconst_0
    //   109: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   112: aload_0
    //   113: iconst_2
    //   114: invokespecial 220	com/tencent/mobileqq/highway/conn/TcpConnection:closeConn	(I)V
    //   117: bipush 14
    //   119: istore_2
    //   120: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   123: lstore 8
    //   125: ldc2_w 529
    //   128: lstore 6
    //   130: aload_0
    //   131: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   134: ldc2_w 254
    //   137: getstatic 261	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   140: invokevirtual 265	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   143: istore 10
    //   145: iload 10
    //   147: ifeq +1250 -> 1397
    //   150: lload 6
    //   152: lstore 4
    //   154: aload_0
    //   155: new 532	java/net/InetSocketAddress
    //   158: dup
    //   159: aload_1
    //   160: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   163: aload_1
    //   164: getfield 522	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   167: invokespecial 535	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   170: putfield 537	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   173: lload 6
    //   175: lstore 4
    //   177: aload_0
    //   178: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   181: iconst_0
    //   182: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   185: lload 6
    //   187: lstore 4
    //   189: aload_0
    //   190: new 285	java/net/Socket
    //   193: dup
    //   194: invokespecial 538	java/net/Socket:<init>	()V
    //   197: putfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   200: lload 6
    //   202: lstore 4
    //   204: aload_0
    //   205: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   208: iconst_1
    //   209: invokevirtual 541	java/net/Socket:setKeepAlive	(Z)V
    //   212: lload 6
    //   214: lstore 4
    //   216: aload_0
    //   217: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   220: iconst_1
    //   221: invokevirtual 544	java/net/Socket:setTcpNoDelay	(Z)V
    //   224: lload 6
    //   226: lstore 4
    //   228: aload_0
    //   229: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   232: aload_0
    //   233: getfield 132	com/tencent/mobileqq/highway/conn/TcpConnection:mReadTimeout	I
    //   236: invokevirtual 547	java/net/Socket:setSoTimeout	(I)V
    //   239: lload 6
    //   241: lstore 4
    //   243: aload_0
    //   244: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   247: ldc 19
    //   249: invokevirtual 550	java/net/Socket:setSendBufferSize	(I)V
    //   252: lload 6
    //   254: lstore 4
    //   256: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   259: lstore 6
    //   261: lload 6
    //   263: lstore 4
    //   265: aload_0
    //   266: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   269: aload_0
    //   270: getfield 537	com/tencent/mobileqq/highway/conn/TcpConnection:serverAddress	Ljava/net/InetSocketAddress;
    //   273: aload_0
    //   274: getfield 138	com/tencent/mobileqq/highway/conn/TcpConnection:mConnTimeOut	I
    //   277: invokevirtual 554	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   280: lload 6
    //   282: lstore 4
    //   284: aload_0
    //   285: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   288: lload 6
    //   290: lsub
    //   291: putfield 362	com/tencent/mobileqq/highway/conn/TcpConnection:mRtt	J
    //   294: lload 6
    //   296: lstore 4
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   303: invokevirtual 558	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   306: putfield 278	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   309: lload 6
    //   311: lstore 4
    //   313: aload_0
    //   314: new 267	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   317: dup
    //   318: aload_0
    //   319: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   322: aload_0
    //   323: getfield 130	com/tencent/mobileqq/highway/conn/TcpConnection:mReadBufferSize	I
    //   326: ldc_w 560
    //   329: iconst_m1
    //   330: invokespecial 563	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   333: putfield 204	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   336: lload 6
    //   338: lstore 4
    //   340: iconst_1
    //   341: aload_0
    //   342: getfield 204	com/tencent/mobileqq/highway/conn/TcpConnection:mInputBuffer	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   345: getfield 271	com/tencent/qphone/base/util/MsfSocketInputBuffer:instream	Ljava/io/InputStream;
    //   348: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   351: invokestatic 276	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   354: lload 6
    //   356: lstore 4
    //   358: iconst_1
    //   359: aload_0
    //   360: getfield 278	com/tencent/mobileqq/highway/conn/TcpConnection:mOutputStream	Ljava/io/OutputStream;
    //   363: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   366: invokestatic 276	com/tencent/mobileqq/highway/conn/TcpConnection:setExclusiveStream	(ZLjava/lang/String;)V
    //   369: lload 6
    //   371: lstore 4
    //   373: aload_0
    //   374: new 565	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread
    //   377: dup
    //   378: aload_0
    //   379: invokespecial 567	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:<init>	(Lcom/tencent/mobileqq/highway/conn/TcpConnection;)V
    //   382: putfield 290	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   385: lload 6
    //   387: lstore 4
    //   389: aload_0
    //   390: getfield 290	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   393: ldc_w 569
    //   396: invokevirtual 572	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:setName	(Ljava/lang/String;)V
    //   399: lload 6
    //   401: lstore 4
    //   403: aload_0
    //   404: getfield 102	com/tencent/mobileqq/highway/conn/TcpConnection:isRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   407: iconst_1
    //   408: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   411: lload 6
    //   413: lstore 4
    //   415: aload_0
    //   416: getfield 290	com/tencent/mobileqq/highway/conn/TcpConnection:mReadThread	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ReadThread;
    //   419: invokevirtual 573	com/tencent/mobileqq/highway/conn/TcpConnection$ReadThread:start	()V
    //   422: lload 6
    //   424: lstore 4
    //   426: aload_0
    //   427: getfield 96	com/tencent/mobileqq/highway/conn/TcpConnection:isConn	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   430: iconst_1
    //   431: invokevirtual 247	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   434: iconst_1
    //   435: istore 10
    //   437: new 104	java/lang/StringBuilder
    //   440: dup
    //   441: ldc_w 575
    //   444: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   447: astore 12
    //   449: aload_0
    //   450: getfield 136	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   453: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   456: ldc_w 577
    //   459: invokevirtual 583	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifeq +58 -> 520
    //   465: aload_0
    //   466: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   469: invokevirtual 587	java/net/Socket:getRemoteSocketAddress	()Ljava/net/SocketAddress;
    //   472: astore 13
    //   474: aload 13
    //   476: ifnull +44 -> 520
    //   479: aload 13
    //   481: instanceof 532
    //   484: ifeq +36 -> 520
    //   487: aload 13
    //   489: checkcast 532	java/net/InetSocketAddress
    //   492: invokevirtual 591	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   495: invokevirtual 596	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   498: astore 13
    //   500: aload 12
    //   502: ldc_w 598
    //   505: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 13
    //   510: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 600
    //   516: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: iconst_0
    //   521: istore_2
    //   522: ldc_w 337
    //   525: new 104	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 602
    //   535: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   542: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc_w 519
    //   548: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_1
    //   552: getfield 522	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   555: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: ldc_w 524
    //   561: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   568: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: ldc_w 604
    //   574: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: lload 6
    //   579: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   582: ldc_w 606
    //   585: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 12
    //   590: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 608
    //   599: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 249	com/tencent/mobileqq/highway/conn/TcpConnection:mSocket	Ljava/net/Socket;
    //   606: invokevirtual 611	java/net/Socket:getLocalPort	()I
    //   609: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 350	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload_0
    //   619: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   622: invokevirtual 327	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   625: iconst_1
    //   626: istore 10
    //   628: aload_0
    //   629: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   632: iload 10
    //   634: putfield 614	com/tencent/mobileqq/highway/conn/ConnReportInfo:result	Z
    //   637: aload_0
    //   638: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   641: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   644: aload_0
    //   645: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   648: getfield 302	com/tencent/mobileqq/highway/conn/ConnReportInfo:connStartTime	J
    //   651: lsub
    //   652: putfield 617	com/tencent/mobileqq/highway/conn/ConnReportInfo:connElapseTime	J
    //   655: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   658: lstore 4
    //   660: aload_0
    //   661: getfield 329	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   664: ifnull +98 -> 762
    //   667: ldc 234
    //   669: iconst_1
    //   670: new 104	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 619
    //   680: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_0
    //   684: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   687: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: ldc_w 621
    //   693: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: iload 10
    //   698: invokevirtual 344	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   701: ldc_w 623
    //   704: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload_2
    //   708: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: ldc_w 625
    //   714: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: lload 4
    //   719: lload 8
    //   721: lsub
    //   722: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   725: ldc_w 627
    //   728: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: aload_0
    //   738: getfield 329	com/tencent/mobileqq/highway/conn/TcpConnection:connListener	Lcom/tencent/mobileqq/highway/conn/IConnectionListener;
    //   741: iload 10
    //   743: aload_0
    //   744: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   747: aload_0
    //   748: aload_0
    //   749: getfield 136	com/tencent/mobileqq/highway/conn/TcpConnection:mEp	Lcom/tencent/mobileqq/highway/utils/EndPoint;
    //   752: iload_2
    //   753: aload_0
    //   754: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   757: invokeinterface 631 7 0
    //   762: iload 10
    //   764: ifeq +549 -> 1313
    //   767: aload_0
    //   768: getfield 116	com/tencent/mobileqq/highway/conn/TcpConnection:connInfo	Lcom/tencent/mobileqq/highway/conn/ConnReportInfo;
    //   771: invokestatic 299	android/os/SystemClock:uptimeMillis	()J
    //   774: putfield 634	com/tencent/mobileqq/highway/conn/ConnReportInfo:connLifeBegin	J
    //   777: aload_0
    //   778: getfield 196	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
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
    //   797: getfield 128	com/tencent/mobileqq/highway/conn/TcpConnection:connManager	Lcom/tencent/mobileqq/highway/conn/ConnManager;
    //   800: invokevirtual 640	com/tencent/mobileqq/highway/conn/ConnManager:hasNet	()Z
    //   803: istore 11
    //   805: iload_2
    //   806: istore_3
    //   807: ldc_w 337
    //   810: new 104	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 642
    //   820: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   827: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 519
    //   833: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_1
    //   837: getfield 522	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   840: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 524
    //   846: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: getfield 134	com/tencent/mobileqq/highway/conn/TcpConnection:connId	I
    //   853: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 604
    //   859: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: lload 4
    //   864: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   867: ldc_w 644
    //   870: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: iload 11
    //   875: invokevirtual 344	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: aload 12
    //   883: invokestatic 356	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   906: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   909: invokevirtual 327	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   912: goto -284 -> 628
    //   915: astore 12
    //   917: ldc_w 337
    //   920: new 104	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   927: ldc_w 650
    //   930: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_1
    //   934: getfield 517	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   937: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: ldc_w 519
    //   943: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_1
    //   947: getfield 522	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   950: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: aload 12
    //   958: invokestatic 356	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   1299: getfield 89	com/tencent/mobileqq/highway/conn/TcpConnection:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1302: invokevirtual 327	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1305: aload 12
    //   1307: athrow
    //   1308: astore 12
    //   1310: goto -393 -> 917
    //   1313: aload_0
    //   1314: getfield 196	com/tencent/mobileqq/highway/conn/TcpConnection:mConnHandler	Lcom/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker;
    //   1317: invokevirtual 283	com/tencent/mobileqq/highway/conn/TcpConnection$ConnWorker:notifyToQuit	()V
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