package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.NetworkEngine;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.UploadResponse.DecodeResult;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.UploadLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UploadSession
  implements IConnectionCallback, IUploadSession
{
  private static final int MAX_RECV_ERROR_CNT = 3;
  private static final String TAG = "UploadSession";
  private ConcurrentLinkedQueue<IActionRequest> mActionRequests = new ConcurrentLinkedQueue();
  private String mClientIp;
  private String mConnectedIp;
  private NetworkEngine mConnection;
  private Const.FileType mFileType;
  private Handler mHandler;
  private final String mId = String.valueOf(hashCode());
  private volatile boolean mIsBusy;
  private volatile long mLastActiveTime;
  private ByteBuffer mReceivedBuffer = ByteBuffer.allocate(128);
  private int mRecvErrorCnt = 0;
  private SparseArray<IActionRequest> mSendingMap = new SparseArray();
  private volatile IUploadSession.SessionState mSessionState;
  private SparseArray<UploadSession.RequestWrapper> mTimeoutMap = new SparseArray();
  private UploadRoute mUploadRoute;
  private final WeakReference<IUploadSessionCallback> mUploadSessionCallback;
  
  public UploadSession(Looper paramLooper, IUploadSessionCallback paramIUploadSessionCallback, Const.FileType paramFileType)
  {
    this.mUploadSessionCallback = new WeakReference(paramIUploadSessionCallback);
    this.mSessionState = IUploadSession.SessionState.NO_CONNECT;
    this.mHandler = new Handler(paramLooper);
    this.mFileType = paramFileType;
    recordLastActiveTime();
  }
  
  private void doCleanup(int paramInt)
  {
    int i = 0;
    UploadLog.d("UploadSession", "do Cleanup Session. sid=" + this.mId);
    this.mReceivedBuffer.clear();
    Const.UploadRetCode localUploadRetCode = Const.getRetCode(paramInt);
    UploadLog.d("UploadSession", "mActionRequests.size()=" + this.mActionRequests.size() + "mSendingMap.size()=" + this.mSendingMap.size() + "mTimeoutMap.size()=" + this.mTimeoutMap.size());
    Object localObject = this.mActionRequests.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IActionRequest localIActionRequest = (IActionRequest)((Iterator)localObject).next();
      if ((localIActionRequest != null) && (localIActionRequest.getListener() != null)) {
        localIActionRequest.getListener().onRequestError(localIActionRequest, localUploadRetCode, this);
      }
    }
    this.mActionRequests.clear();
    paramInt = 0;
    if (paramInt < this.mSendingMap.size())
    {
      int j = this.mSendingMap.keyAt(paramInt);
      localObject = (UploadSession.RequestWrapper)this.mTimeoutMap.get(j);
      if ((localObject != null) && (((UploadSession.RequestWrapper)localObject).request != null)) {}
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = (IActionRequest)this.mSendingMap.get(j);
        if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
          ((IActionRequest)localObject).getListener().onRequestError((IActionRequest)localObject, localUploadRetCode, this);
        }
      }
    }
    this.mSendingMap.clear();
    paramInt = i;
    if (paramInt < this.mTimeoutMap.size())
    {
      i = this.mTimeoutMap.keyAt(paramInt);
      localObject = (UploadSession.RequestWrapper)this.mTimeoutMap.get(i);
      if (localObject != null) {}
      for (localObject = ((UploadSession.RequestWrapper)localObject).request;; localObject = null)
      {
        if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
          ((IActionRequest)localObject).getListener().onRequestError((IActionRequest)localObject, localUploadRetCode, this);
        }
        paramInt += 1;
        break;
      }
    }
    doClearAllTimeout();
  }
  
  private void doClearAllTimeout()
  {
    int i = 0;
    if (i < this.mTimeoutMap.size())
    {
      int j = this.mTimeoutMap.keyAt(i);
      UploadSession.RequestWrapper localRequestWrapper = (UploadSession.RequestWrapper)this.mTimeoutMap.get(j);
      if (localRequestWrapper == null) {}
      for (;;)
      {
        i += 1;
        break;
        this.mHandler.removeCallbacks(localRequestWrapper.runnable);
        localRequestWrapper.runnable = null;
      }
    }
    this.mTimeoutMap.clear();
  }
  
  private void doDeleteTimeout(UploadResponse paramUploadResponse)
  {
    if (paramUploadResponse == null) {}
    int i;
    UploadSession.RequestWrapper localRequestWrapper;
    do
    {
      return;
      i = paramUploadResponse.getRequestSequence();
      paramUploadResponse = this.mTimeoutMap;
      localRequestWrapper = (UploadSession.RequestWrapper)paramUploadResponse.get(i);
    } while (localRequestWrapper == null);
    this.mHandler.removeCallbacks(localRequestWrapper.runnable);
    paramUploadResponse.delete(i);
  }
  
  private byte[] doDivideReceivedBuffer()
  {
    if (this.mReceivedBuffer.position() == 0) {
      return null;
    }
    if (this.mReceivedBuffer.position() < 4)
    {
      UploadLog.w("UploadSession", "doDivideReceivedBuffer: size < 4 sid=" + this.mId);
      return new byte[0];
    }
    int i = PDUtil.decodePDU(this.mReceivedBuffer.array());
    if ((i > UploadConfiguration.getMaxSessionPacketSize()) || (i < 25))
    {
      UploadLog.w("UploadSession", " doDivideReceivedBuffer size > max, size:" + i + " sid=" + this.mId);
      return new byte[0];
    }
    if (i > this.mReceivedBuffer.position())
    {
      UploadLog.w("UploadSession", "doDivideReceivedBuffer sid=" + this.mId + " size:" + i + " mReceivedBuffer position:" + this.mReceivedBuffer.position());
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.mReceivedBuffer.flip();
    this.mReceivedBuffer.get(arrayOfByte);
    this.mReceivedBuffer.compact();
    return arrayOfByte;
  }
  
  private void doError(IConnectionCallback paramIConnectionCallback, int paramInt, String paramString)
  {
    if (paramIConnectionCallback != this) {}
    do
    {
      return;
      UploadLog.e("UploadSession", "Session Error. sid=" + this.mId + " errorCode=" + paramInt + " msg=" + paramString + " currState=" + this.mSessionState.toString());
      paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    } while ((paramIConnectionCallback == null) || (paramInt == 0));
    setSessionState(IUploadSession.SessionState.NO_CONNECT);
    doCleanup(paramInt);
    paramIConnectionCallback.onSessionError(this, paramInt, paramString);
  }
  
  private void doHandleResponse(UploadSession.RequestWrapper paramRequestWrapper, UploadResponse paramUploadResponse)
  {
    if (paramRequestWrapper != null) {}
    for (paramRequestWrapper = paramRequestWrapper.request;; paramRequestWrapper = null)
    {
      if ((this.mSessionState == IUploadSession.SessionState.ESTABLISHED) && (paramRequestWrapper != null) && (paramRequestWrapper.getListener() != null))
      {
        if (paramUploadResponse != null) {
          paramUploadResponse.setSid(this.mId);
        }
        paramRequestWrapper.getListener().onResponse(paramRequestWrapper, paramUploadResponse);
      }
      return;
    }
  }
  
  private void doReceiveBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i = this.mReceivedBuffer.position() + paramArrayOfByte.length;
    if (this.mReceivedBuffer.capacity() < i)
    {
      UploadLog.d("UploadSession", "doReceiveBuffer mReceivedBuffer.capacity() size < " + i);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      this.mReceivedBuffer.flip();
      localByteBuffer.put(this.mReceivedBuffer);
      this.mReceivedBuffer = localByteBuffer;
    }
    this.mReceivedBuffer.put(paramArrayOfByte);
  }
  
  private void doRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte)
  {
    recordLastActiveTime();
    doReceiveBuffer(paramArrayOfByte);
    paramIConnectionCallback = UploadResponse.DecodeResult.SUCCEED;
    Object localObject;
    label308:
    for (;;)
    {
      paramArrayOfByte = doDivideReceivedBuffer();
      int i;
      if (paramArrayOfByte == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label311;
        }
        if (this.mSessionState == IUploadSession.SessionState.ESTABLISHED)
        {
          localObject = (IUploadSessionCallback)this.mUploadSessionCallback.get();
          if (localObject != null)
          {
            paramArrayOfByte = paramIConnectionCallback;
            if (paramIConnectionCallback.getCode() == 0)
            {
              this.mRecvErrorCnt += 1;
              paramArrayOfByte = UploadResponse.DecodeResult.DECODE_BUF_EMPTY_ERROR;
            }
            UploadLog.e("UploadSession", this.mId + " doRecv sRecvErrorCnt " + this.mRecvErrorCnt + " ret:" + paramArrayOfByte + " needCallBack:" + true);
            this.mRecvErrorCnt = 0;
            setSessionState(IUploadSession.SessionState.NO_CONNECT);
            doCleanup(paramArrayOfByte.getCode());
            ((IUploadSessionCallback)localObject).onSessionError(this, paramArrayOfByte.getCode(), paramArrayOfByte.getMsg());
          }
        }
        return;
        if (paramArrayOfByte.length == 0) {
          i = 1;
        } else {
          localObject = new UploadResponse();
        }
        try
        {
          paramArrayOfByte = ((UploadResponse)localObject).decode(paramArrayOfByte);
          paramIConnectionCallback = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            UploadLog.e("UploadSession", this.mId + "decode error ", paramArrayOfByte);
          }
          paramArrayOfByte = (UploadSession.RequestWrapper)this.mTimeoutMap.get(((UploadResponse)localObject).getRequestSequence());
          if (paramArrayOfByte == null) {
            break label308;
          }
          doDeleteTimeout((UploadResponse)localObject);
          doHandleResponse(paramArrayOfByte, (UploadResponse)localObject);
        }
        if (paramIConnectionCallback.getCode() == 0) {
          break;
        }
        UploadLog.e("UploadSession", this.mId + " doRecv decode error " + paramIConnectionCallback);
        i = 1;
      }
    }
    label311:
    this.mRecvErrorCnt = 0;
  }
  
  private void doSendFirstRequest()
  {
    if (this.mActionRequests.isEmpty()) {}
    for (;;)
    {
      return;
      try
      {
        IActionRequest localIActionRequest = (IActionRequest)this.mActionRequests.remove();
        if (localIActionRequest == null) {
          continue;
        }
        UploadLog.d("[transfer] UploadSession", "Send Request Begin. sid=" + this.mId + " " + localIActionRequest.toString() + " sending:" + this.mSendingMap.size() + " waiting:" + this.mActionRequests.size());
        this.mSendingMap.put(localIActionRequest.getRequestId(), localIActionRequest);
        doSendRequest(localIActionRequest);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          UploadLog.e("UploadSession", "get send request exception.", localException);
          Object localObject = null;
        }
      }
    }
  }
  
  private void doSendRequest(IActionRequest paramIActionRequest)
  {
    NetworkEngine localNetworkEngine = this.mConnection;
    if (localNetworkEngine == null)
    {
      UploadLog.e("UploadSession", "Session has no connection! actionId=" + paramIActionRequest.getTaskId() + " reqId=" + paramIActionRequest.getRequestId() + " sid=" + this.mId);
      doError(this, Const.UploadRetCode.SESSION_WITHOUT_CONN.getCode(), Const.UploadRetCode.SESSION_WITHOUT_CONN.getDesc());
    }
    byte[] arrayOfByte;
    for (;;)
    {
      return;
      try
      {
        arrayOfByte = paramIActionRequest.encode();
        if (arrayOfByte == null)
        {
          UploadLog.e("UploadSession", "decode request failed. actionId=" + paramIActionRequest.getTaskId() + " reqId=" + paramIActionRequest.getRequestId() + " cmd=" + paramIActionRequest.getCmdId() + " sid=" + this.mId);
          this.mSendingMap.delete(paramIActionRequest.getRequestId());
          if (paramIActionRequest.getListener() == null) {
            continue;
          }
          paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.DATA_ENCODE_ERROR, this);
        }
      }
      catch (IOException localIOException)
      {
        if (paramIActionRequest.getListener() != null) {
          paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.IO_EXCEPTION, this);
        }
        UploadLog.e("UploadSession", "", localIOException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (paramIActionRequest.getListener() != null) {
          paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.OOM, this);
        }
        UploadLog.e("UploadSession", "", localOutOfMemoryError);
        return;
      }
    }
    int i = getSendTimeout(arrayOfByte.length);
    if (!localOutOfMemoryError.sendAsync(arrayOfByte, paramIActionRequest.getRequestId(), i, i))
    {
      UploadLog.e("UploadSession", "NetworkEngine SendAsync failed. sid=" + this.mId);
      this.mSendingMap.delete(paramIActionRequest.getRequestId());
      doError(this, Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getCode(), Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getDesc());
      return;
    }
    localOutOfMemoryError.wakeUp();
  }
  
  private void doStartTimeout(IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest == null) {
      return;
    }
    int i = paramIActionRequest.getRequestId();
    if ((UploadSession.RequestWrapper)this.mTimeoutMap.get(i) != null)
    {
      UploadLog.w("UploadSession", "timeout runnable has been started. reqId=" + i + " sid=" + this.mId);
      return;
    }
    UploadSession.RequestWrapper localRequestWrapper = new UploadSession.RequestWrapper(paramIActionRequest);
    int j = getResponseTimeout(paramIActionRequest);
    paramIActionRequest = new UploadSession.9(this, j, i, paramIActionRequest);
    this.mHandler.removeCallbacks(localRequestWrapper.runnable);
    localRequestWrapper.runnable = paramIActionRequest;
    this.mTimeoutMap.put(i, localRequestWrapper);
    this.mHandler.postDelayed(paramIActionRequest, j);
  }
  
  private static final int getResponseTimeout(IActionRequest paramIActionRequest)
  {
    int j = UploadConfiguration.getDataTimeout();
    int i = j;
    if (is2G()) {
      i = j * 2;
    }
    return i;
  }
  
  public static final int getSendTimeout(int paramInt)
  {
    int i = UploadConfiguration.getDataTimeout();
    paramInt = i;
    if (is2G()) {
      paramInt = i * 2;
    }
    return paramInt;
  }
  
  private static boolean is2G()
  {
    return UploadConfiguration.getCurrentNetworkCategory() == 3;
  }
  
  /* Error */
  private void setSessionState(IUploadSession.SessionState paramSessionState)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/tencent/upload/network/session/UploadSession:mSessionState	Lcom/tencent/upload/network/session/IUploadSession$SessionState;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_1
    //   9: if_acmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: ldc 15
    //   17: new 170	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 532
    //   27: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: getfield 65	com/tencent/upload/network/session/UploadSession:mId	Ljava/lang/String;
    //   34: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 427
    //   40: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 99	com/tencent/upload/network/session/UploadSession:mSessionState	Lcom/tencent/upload/network/session/IUploadSession$SessionState;
    //   47: invokevirtual 327	com/tencent/upload/network/session/IUploadSession$SessionState:toString	()Ljava/lang/String;
    //   50: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 534
    //   56: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 327	com/tencent/upload/network/session/IUploadSession$SessionState:toString	()Ljava/lang/String;
    //   63: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 187	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 99	com/tencent/upload/network/session/UploadSession:mSessionState	Lcom/tencent/upload/network/session/IUploadSession$SessionState;
    //   77: goto -65 -> 12
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	UploadSession
    //   0	85	1	paramSessionState	IUploadSession.SessionState
    //   6	2	2	localSessionState	IUploadSession.SessionState
    // Exception table:
    //   from	to	target	type
    //   2	7	80	finally
    //   15	77	80	finally
  }
  
  public void cancel(int paramInt)
  {
    int j = 0;
    Object localObject1 = this.mActionRequests.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IActionRequest)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((IActionRequest)localObject2).getTaskId() == paramInt))
      {
        ((Iterator)localObject1).remove();
        UploadLog.d("UploadSession", this.mId + " cancel: mActionRequests remove: actSeq:" + paramInt + " request:" + ((IActionRequest)localObject2).getRequestId());
      }
    }
    localObject1 = new LinkedList();
    int k = this.mSendingMap.size();
    int i = 0;
    if (i < k)
    {
      localObject2 = (IActionRequest)this.mSendingMap.valueAt(i);
      if ((localObject2 == null) || (((IActionRequest)localObject2).getTaskId() != paramInt)) {}
      for (;;)
      {
        i += 1;
        break;
        int m = this.mSendingMap.keyAt(i);
        ((LinkedList)localObject1).add(Integer.valueOf(m));
        UploadLog.d("UploadSession", this.mId + " cancel: mSendingMap remove: sendSeq:" + m + " actSeq:" + ((IActionRequest)localObject2).getTaskId() + " reqSeq:" + ((IActionRequest)localObject2).getRequestId());
      }
    }
    while (((LinkedList)localObject1).size() > 0) {
      this.mSendingMap.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
    k = this.mTimeoutMap.size();
    i = j;
    if (i < k)
    {
      localObject2 = (UploadSession.RequestWrapper)this.mTimeoutMap.valueAt(i);
      if ((localObject2 == null) || (((UploadSession.RequestWrapper)localObject2).request.getTaskId() != paramInt)) {}
      for (;;)
      {
        i += 1;
        break;
        j = this.mTimeoutMap.keyAt(i);
        ((LinkedList)localObject1).add(Integer.valueOf(j));
        UploadLog.d("UploadSession", this.mId + " cancel: mTimeoutMap remove runnable reqSeq:" + j + " actSeq:" + ((UploadSession.RequestWrapper)localObject2).request.getTaskId());
        this.mHandler.removeCallbacks(((UploadSession.RequestWrapper)localObject2).runnable);
        ((UploadSession.RequestWrapper)localObject2).runnable = null;
      }
    }
    while (((LinkedList)localObject1).size() > 0) {
      this.mTimeoutMap.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
  }
  
  public void close()
  {
    if (this.mConnection == null) {
      return;
    }
    UploadLog.w("[connect] UploadSession", "Close Session. sid=" + this.mId);
    if (this.mConnection != null)
    {
      this.mConnection.stop();
      this.mConnection = null;
    }
    IUploadSessionCallback localIUploadSessionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    if (localIUploadSessionCallback != null) {
      localIUploadSessionCallback.onSessionClosed(this);
    }
    setSessionState(IUploadSession.SessionState.NO_CONNECT);
    this.mReceivedBuffer.clear();
    this.mActionRequests.clear();
    this.mSendingMap.clear();
    doClearAllTimeout();
  }
  
  public String getConnectedIp()
  {
    return this.mConnectedIp;
  }
  
  public IUploadSession.SessionState getState()
  {
    return this.mSessionState;
  }
  
  public Const.FileType getType()
  {
    return this.mFileType;
  }
  
  public UploadRoute getUploadRoute()
  {
    return this.mUploadRoute;
  }
  
  public boolean isExpired()
  {
    if (System.currentTimeMillis() - this.mLastActiveTime > 60000L) {}
    for (boolean bool = true;; bool = false)
    {
      UploadLog.i("UploadSession", "session isExpired:" + bool);
      return bool;
    }
  }
  
  public boolean isIdle()
  {
    if ((!this.mIsBusy) && (this.mActionRequests.size() == 0) && (this.mSendingMap.size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      UploadLog.d("UploadSession", "isIdle --- " + bool);
      return bool;
    }
  }
  
  public void onConnect(IConnectionCallback paramIConnectionCallback, boolean paramBoolean, int paramInt, String paramString)
  {
    this.mHandler.post(new UploadSession.2(this, paramIConnectionCallback, paramBoolean, paramInt, paramString));
  }
  
  public void onDisconnect(IConnectionCallback paramIConnectionCallback)
  {
    this.mHandler.post(new UploadSession.3(this, paramIConnectionCallback));
  }
  
  public void onError(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    this.mHandler.post(new UploadSession.4(this, paramInt, paramIConnectionCallback));
  }
  
  public void onRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte)
  {
    this.mHandler.post(new UploadSession.6(this, paramIConnectionCallback, paramArrayOfByte));
  }
  
  public void onSendBegin(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    this.mHandler.post(new UploadSession.7(this, paramInt));
  }
  
  public void onSendEnd(IConnectionCallback paramIConnectionCallback, int paramInt)
  {
    this.mHandler.post(new UploadSession.8(this, paramInt));
  }
  
  public void onSendTimeOut(IConnectionCallback paramIConnectionCallback, int paramInt1, int paramInt2)
  {
    this.mHandler.post(new UploadSession.5(this, paramIConnectionCallback, paramInt1, paramInt2));
  }
  
  public void onStart(IConnectionCallback paramIConnectionCallback)
  {
    if (paramIConnectionCallback != this) {
      return;
    }
    UploadLog.d("UploadSession", "Session onStart. sid=" + this.mId);
  }
  
  public boolean open(UploadRoute paramUploadRoute)
  {
    return open(paramUploadRoute, UploadConfiguration.getConnectionTimeout());
  }
  
  public boolean open(UploadRoute paramUploadRoute, int paramInt)
  {
    if (paramUploadRoute == null)
    {
      UploadLog.w("[connect] UploadSession", "open route == null");
      return false;
    }
    if (paramInt <= 0) {
      paramInt = UploadConfiguration.getConnectionTimeout();
    }
    for (;;)
    {
      if (this.mConnection != null)
      {
        this.mConnection.stop();
        this.mConnection = null;
      }
      if (this.mUploadRoute != null) {
        this.mUploadRoute = null;
      }
      this.mConnection = new NetworkEngine(this, this.mId);
      if (this.mConnection == null)
      {
        UploadLog.w("[connect] UploadSession", "Open NetworkEngine Failed! sid=" + this.mId + " state:" + this.mSessionState.toString());
        return false;
      }
      if (!this.mConnection.start())
      {
        UploadLog.w("[connect] UploadSession", "NetworkEngine Start Failed! sid=" + this.mId + " state:" + this.mSessionState.toString());
        return false;
      }
      boolean bool = this.mConnection.connectAsync(paramUploadRoute.getIp(), paramUploadRoute.getPort(), null, 0, paramInt);
      if (bool)
      {
        this.mUploadRoute = paramUploadRoute;
        setSessionState(IUploadSession.SessionState.CONNECTING);
      }
      UploadLog.d("[connect] UploadSession", "connectAsync success, sid=" + this.mId + " state:" + this.mSessionState.toString());
      return bool;
    }
  }
  
  public void recordLastActiveTime()
  {
    this.mLastActiveTime = System.currentTimeMillis();
  }
  
  public boolean send(IActionRequest paramIActionRequest, IUploadSession.RequestListener paramRequestListener)
  {
    if (this.mSessionState != IUploadSession.SessionState.ESTABLISHED)
    {
      UploadLog.e("UploadSession", "Can't send request, state is illegel. CurrState=" + this.mSessionState.toString() + " sid=" + this.mId);
      if ((paramIActionRequest != null) && (paramIActionRequest.getListener() != null)) {
        paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.SESSION_STATE_ERROR, this);
      }
      return false;
    }
    if (paramIActionRequest == null)
    {
      UploadLog.e("UploadSession", "Can't send request, request is illegel. sid=" + this.mId);
      return false;
    }
    paramIActionRequest.setListener(paramRequestListener);
    this.mActionRequests.add(paramIActionRequest);
    this.mHandler.post(new UploadSession.1(this));
    return true;
  }
  
  public void setBusy(boolean paramBoolean)
  {
    try
    {
      this.mIsBusy = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession
 * JD-Core Version:    0.7.0.1
 */