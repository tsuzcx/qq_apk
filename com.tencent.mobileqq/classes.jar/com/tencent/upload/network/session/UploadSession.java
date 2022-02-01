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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("do Cleanup Session. sid=");
    ((StringBuilder)localObject).append(this.mId);
    UploadLog.d("UploadSession", ((StringBuilder)localObject).toString());
    this.mReceivedBuffer.clear();
    Const.UploadRetCode localUploadRetCode = Const.getRetCode(paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mActionRequests.size()=");
    ((StringBuilder)localObject).append(this.mActionRequests.size());
    ((StringBuilder)localObject).append("mSendingMap.size()=");
    ((StringBuilder)localObject).append(this.mSendingMap.size());
    ((StringBuilder)localObject).append("mTimeoutMap.size()=");
    ((StringBuilder)localObject).append(this.mTimeoutMap.size());
    UploadLog.d("UploadSession", ((StringBuilder)localObject).toString());
    localObject = this.mActionRequests.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IActionRequest localIActionRequest = (IActionRequest)((Iterator)localObject).next();
      if ((localIActionRequest != null) && (localIActionRequest.getListener() != null)) {
        localIActionRequest.getListener().onRequestError(localIActionRequest, localUploadRetCode, this);
      }
    }
    this.mActionRequests.clear();
    int i = 0;
    paramInt = 0;
    while (paramInt < this.mSendingMap.size())
    {
      int j = this.mSendingMap.keyAt(paramInt);
      localObject = (UploadSession.RequestWrapper)this.mTimeoutMap.get(j);
      if ((localObject == null) || (((UploadSession.RequestWrapper)localObject).request == null))
      {
        localObject = (IActionRequest)this.mSendingMap.get(j);
        if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
          ((IActionRequest)localObject).getListener().onRequestError((IActionRequest)localObject, localUploadRetCode, this);
        }
      }
      paramInt += 1;
    }
    this.mSendingMap.clear();
    paramInt = i;
    while (paramInt < this.mTimeoutMap.size())
    {
      i = this.mTimeoutMap.keyAt(paramInt);
      localObject = (UploadSession.RequestWrapper)this.mTimeoutMap.get(i);
      if (localObject != null) {
        localObject = ((UploadSession.RequestWrapper)localObject).request;
      } else {
        localObject = null;
      }
      if ((localObject != null) && (((IActionRequest)localObject).getListener() != null)) {
        ((IActionRequest)localObject).getListener().onRequestError((IActionRequest)localObject, localUploadRetCode, this);
      }
      paramInt += 1;
    }
    doClearAllTimeout();
  }
  
  private void doClearAllTimeout()
  {
    int i = 0;
    while (i < this.mTimeoutMap.size())
    {
      int j = this.mTimeoutMap.keyAt(i);
      UploadSession.RequestWrapper localRequestWrapper = (UploadSession.RequestWrapper)this.mTimeoutMap.get(j);
      if (localRequestWrapper != null)
      {
        this.mHandler.removeCallbacks(localRequestWrapper.runnable);
        localRequestWrapper.runnable = null;
      }
      i += 1;
    }
    this.mTimeoutMap.clear();
  }
  
  private void doDeleteTimeout(UploadResponse paramUploadResponse)
  {
    if (paramUploadResponse == null) {
      return;
    }
    int i = paramUploadResponse.getRequestSequence();
    paramUploadResponse = this.mTimeoutMap;
    UploadSession.RequestWrapper localRequestWrapper = (UploadSession.RequestWrapper)paramUploadResponse.get(i);
    if (localRequestWrapper == null) {
      return;
    }
    this.mHandler.removeCallbacks(localRequestWrapper.runnable);
    paramUploadResponse.delete(i);
  }
  
  private byte[] doDivideReceivedBuffer()
  {
    if (this.mReceivedBuffer.position() == 0)
    {
      UploadLog.w("UploadSession", "doDivideReceivedBuffer: mReceivedBuffer.position() == 0");
      return null;
    }
    if (this.mReceivedBuffer.position() < 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDivideReceivedBuffer: size < 4 sid=");
      ((StringBuilder)localObject).append(this.mId);
      UploadLog.w("UploadSession", ((StringBuilder)localObject).toString());
      return new byte[0];
    }
    int i = PDUtil.decodePDU(this.mReceivedBuffer.array());
    if ((i <= UploadConfiguration.getMaxSessionPacketSize()) && (i >= 25))
    {
      if (i > this.mReceivedBuffer.position())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doDivideReceivedBuffer sid=");
        ((StringBuilder)localObject).append(this.mId);
        ((StringBuilder)localObject).append(" size:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" mReceivedBuffer position:");
        ((StringBuilder)localObject).append(this.mReceivedBuffer.position());
        UploadLog.w("UploadSession", ((StringBuilder)localObject).toString());
        return null;
      }
      localObject = new byte[i];
      this.mReceivedBuffer.flip();
      this.mReceivedBuffer.get((byte[])localObject);
      this.mReceivedBuffer.compact();
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" doDivideReceivedBuffer size > max, size:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" sid=");
    ((StringBuilder)localObject).append(this.mId);
    UploadLog.w("UploadSession", ((StringBuilder)localObject).toString());
    return new byte[0];
  }
  
  private void doError(IConnectionCallback paramIConnectionCallback, int paramInt, String paramString)
  {
    if (paramIConnectionCallback != this) {
      return;
    }
    paramIConnectionCallback = new StringBuilder();
    paramIConnectionCallback.append("Session Error. sid=");
    paramIConnectionCallback.append(this.mId);
    paramIConnectionCallback.append(" errorCode=");
    paramIConnectionCallback.append(paramInt);
    paramIConnectionCallback.append(" msg=");
    paramIConnectionCallback.append(paramString);
    paramIConnectionCallback.append(" currState=");
    paramIConnectionCallback.append(this.mSessionState.toString());
    UploadLog.e("UploadSession", paramIConnectionCallback.toString());
    paramIConnectionCallback = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    if ((paramIConnectionCallback != null) && (paramInt != 0))
    {
      setSessionState(IUploadSession.SessionState.NO_CONNECT);
      doCleanup(paramInt);
      paramIConnectionCallback.onSessionError(this, paramInt, paramString);
    }
  }
  
  private void doHandleResponse(UploadSession.RequestWrapper paramRequestWrapper, UploadResponse paramUploadResponse)
  {
    if (paramRequestWrapper != null) {
      paramRequestWrapper = paramRequestWrapper.request;
    } else {
      paramRequestWrapper = null;
    }
    if ((this.mSessionState == IUploadSession.SessionState.ESTABLISHED) && (paramRequestWrapper != null) && (paramRequestWrapper.getListener() != null))
    {
      if (paramUploadResponse != null) {
        paramUploadResponse.setSid(this.mId);
      }
      paramRequestWrapper.getListener().onResponse(paramRequestWrapper, paramUploadResponse);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReceiveBuffer mReceivedBuffer.capacity() size < ");
      ((StringBuilder)localObject).append(i);
      UploadLog.d("UploadSession", ((StringBuilder)localObject).toString());
      localObject = ByteBuffer.allocate(i);
      this.mReceivedBuffer.flip();
      ((ByteBuffer)localObject).put(this.mReceivedBuffer);
      this.mReceivedBuffer = ((ByteBuffer)localObject);
    }
    this.mReceivedBuffer.put(paramArrayOfByte);
  }
  
  private void doRecv(IConnectionCallback paramIConnectionCallback, byte[] paramArrayOfByte)
  {
    recordLastActiveTime();
    doReceiveBuffer(paramArrayOfByte);
    paramIConnectionCallback = UploadResponse.DecodeResult.SUCCEED;
    for (;;)
    {
      paramArrayOfByte = doDivideReceivedBuffer();
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(this.mId);
        paramArrayOfByte.append(" doDivideReceivedBuffer buf == null");
        UploadLog.d("UploadSession", paramArrayOfByte.toString());
      }
      else
      {
        if (paramArrayOfByte.length != 0) {
          break label103;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(this.mId);
        paramArrayOfByte.append(" doDivideReceivedBuffer buf.length == 0");
        UploadLog.d("UploadSession", paramArrayOfByte.toString());
      }
      boolean bool = false;
      break label215;
      label103:
      Object localObject1 = new UploadResponse();
      try
      {
        paramArrayOfByte = ((UploadResponse)localObject1).decode(paramArrayOfByte);
      }
      catch (Exception paramArrayOfByte)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mId);
        ((StringBuilder)localObject2).append("decode error ");
        UploadLog.e("UploadSession", ((StringBuilder)localObject2).toString(), paramArrayOfByte);
        paramArrayOfByte = paramIConnectionCallback;
      }
      if (paramArrayOfByte.getCode() != 0)
      {
        paramIConnectionCallback = new StringBuilder();
        paramIConnectionCallback.append(this.mId);
        paramIConnectionCallback.append(" doRecv decode error ");
        paramIConnectionCallback.append(paramArrayOfByte);
        UploadLog.e("UploadSession", paramIConnectionCallback.toString());
        paramIConnectionCallback = paramArrayOfByte;
        bool = true;
        label215:
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(this.mId);
        paramArrayOfByte.append(" doRecv... hasDivideError:");
        paramArrayOfByte.append(bool);
        UploadLog.d("UploadSession", paramArrayOfByte.toString());
        if (bool)
        {
          if (this.mSessionState == IUploadSession.SessionState.ESTABLISHED)
          {
            localObject1 = (IUploadSessionCallback)this.mUploadSessionCallback.get();
            if (localObject1 != null)
            {
              paramArrayOfByte = paramIConnectionCallback;
              if (paramIConnectionCallback.getCode() == 0)
              {
                this.mRecvErrorCnt += 1;
                paramArrayOfByte = UploadResponse.DecodeResult.DECODE_BUF_EMPTY_ERROR;
              }
              paramIConnectionCallback = new StringBuilder();
              paramIConnectionCallback.append(this.mId);
              paramIConnectionCallback.append(" doRecv sRecvErrorCnt ");
              paramIConnectionCallback.append(this.mRecvErrorCnt);
              paramIConnectionCallback.append(" ret:");
              paramIConnectionCallback.append(paramArrayOfByte);
              paramIConnectionCallback.append(" needCallBack:");
              paramIConnectionCallback.append(true);
              UploadLog.e("UploadSession", paramIConnectionCallback.toString());
              this.mRecvErrorCnt = 0;
              setSessionState(IUploadSession.SessionState.NO_CONNECT);
              doCleanup(paramArrayOfByte.getCode());
              ((IUploadSessionCallback)localObject1).onSessionError(this, paramArrayOfByte.getCode(), paramArrayOfByte.getMsg());
            }
            paramIConnectionCallback = new StringBuilder();
            paramIConnectionCallback.append(this.mId);
            paramIConnectionCallback.append(" doRecv... disconnect...");
            UploadLog.d("UploadSession", paramIConnectionCallback.toString());
            this.mConnection.disconnect();
          }
        }
        else {
          this.mRecvErrorCnt = 0;
        }
        return;
      }
      Object localObject2 = (UploadSession.RequestWrapper)this.mTimeoutMap.get(((UploadResponse)localObject1).getRequestSequence());
      paramIConnectionCallback = paramArrayOfByte;
      if (localObject2 != null)
      {
        doDeleteTimeout((UploadResponse)localObject1);
        doHandleResponse((UploadSession.RequestWrapper)localObject2, (UploadResponse)localObject1);
        paramIConnectionCallback = paramArrayOfByte;
      }
    }
  }
  
  private void doSendFirstRequest()
  {
    if (this.mActionRequests.isEmpty()) {
      return;
    }
    Object localObject = null;
    try
    {
      IActionRequest localIActionRequest = (IActionRequest)this.mActionRequests.remove();
      localObject = localIActionRequest;
    }
    catch (Exception localException)
    {
      UploadLog.e("UploadSession", "get send request exception.", localException);
    }
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Send Request Begin. sid=");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" ");
    localStringBuilder.append(localObject.toString());
    localStringBuilder.append(" sending:");
    localStringBuilder.append(this.mSendingMap.size());
    localStringBuilder.append(" waiting:");
    localStringBuilder.append(this.mActionRequests.size());
    UploadLog.d("[transfer] UploadSession", localStringBuilder.toString());
    this.mSendingMap.put(localObject.getRequestId(), localObject);
    doSendRequest(localObject);
  }
  
  private void doSendRequest(IActionRequest paramIActionRequest)
  {
    Object localObject = this.mConnection;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Session has no connection! actionId=");
      ((StringBuilder)localObject).append(paramIActionRequest.getTaskId());
      ((StringBuilder)localObject).append(" reqId=");
      ((StringBuilder)localObject).append(paramIActionRequest.getRequestId());
      ((StringBuilder)localObject).append(" sid=");
      ((StringBuilder)localObject).append(this.mId);
      UploadLog.e("UploadSession", ((StringBuilder)localObject).toString());
      doError(this, Const.UploadRetCode.SESSION_WITHOUT_CONN.getCode(), Const.UploadRetCode.SESSION_WITHOUT_CONN.getDesc());
      return;
    }
    try
    {
      byte[] arrayOfByte = paramIActionRequest.encode();
      if (arrayOfByte == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decode request failed. actionId=");
        ((StringBuilder)localObject).append(paramIActionRequest.getTaskId());
        ((StringBuilder)localObject).append(" reqId=");
        ((StringBuilder)localObject).append(paramIActionRequest.getRequestId());
        ((StringBuilder)localObject).append(" cmd=");
        ((StringBuilder)localObject).append(paramIActionRequest.getCmdId());
        ((StringBuilder)localObject).append(" sid=");
        ((StringBuilder)localObject).append(this.mId);
        UploadLog.e("UploadSession", ((StringBuilder)localObject).toString());
        this.mSendingMap.delete(paramIActionRequest.getRequestId());
        if (paramIActionRequest.getListener() != null) {
          paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.DATA_ENCODE_ERROR, this);
        }
        return;
      }
      int i = getSendTimeout(arrayOfByte.length);
      if (!((NetworkEngine)localObject).sendAsync(arrayOfByte, paramIActionRequest.getRequestId(), i, i))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NetworkEngine SendAsync failed. sid=");
        ((StringBuilder)localObject).append(this.mId);
        UploadLog.e("UploadSession", ((StringBuilder)localObject).toString());
        this.mSendingMap.delete(paramIActionRequest.getRequestId());
        doError(this, Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getCode(), Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getDesc());
        return;
      }
      ((NetworkEngine)localObject).wakeUp();
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
    catch (IOException localIOException)
    {
      if (paramIActionRequest.getListener() != null) {
        paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.IO_EXCEPTION, this);
      }
      UploadLog.e("UploadSession", "", localIOException);
    }
  }
  
  private void doStartTimeout(IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest == null) {
      return;
    }
    int i = paramIActionRequest.getRequestId();
    if ((UploadSession.RequestWrapper)this.mTimeoutMap.get(i) != null)
    {
      paramIActionRequest = new StringBuilder();
      paramIActionRequest.append("timeout runnable has been started. reqId=");
      paramIActionRequest.append(i);
      paramIActionRequest.append(" sid=");
      paramIActionRequest.append(this.mId);
      UploadLog.w("UploadSession", paramIActionRequest.toString());
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
  
  private void setSessionState(IUploadSession.SessionState paramSessionState)
  {
    try
    {
      Object localObject = this.mSessionState;
      if (localObject == paramSessionState) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update state sid:");
      ((StringBuilder)localObject).append(this.mId);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.mSessionState.toString());
      ((StringBuilder)localObject).append("-->");
      ((StringBuilder)localObject).append(paramSessionState.toString());
      UploadLog.d("UploadSession", ((StringBuilder)localObject).toString());
      this.mSessionState = paramSessionState;
      return;
    }
    finally {}
  }
  
  public void cancel(int paramInt)
  {
    Object localObject1 = this.mActionRequests.iterator();
    Object localObject2;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IActionRequest)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((IActionRequest)localObject2).getTaskId() == paramInt))
      {
        ((Iterator)localObject1).remove();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mId);
        localStringBuilder.append(" cancel: mActionRequests remove: actSeq:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" request:");
        localStringBuilder.append(((IActionRequest)localObject2).getRequestId());
        UploadLog.d("UploadSession", localStringBuilder.toString());
      }
    }
    localObject1 = new LinkedList();
    int k = this.mSendingMap.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localObject2 = (IActionRequest)this.mSendingMap.valueAt(i);
      if ((localObject2 != null) && (((IActionRequest)localObject2).getTaskId() == paramInt))
      {
        int m = this.mSendingMap.keyAt(i);
        ((LinkedList)localObject1).add(Integer.valueOf(m));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mId);
        localStringBuilder.append(" cancel: mSendingMap remove: sendSeq:");
        localStringBuilder.append(m);
        localStringBuilder.append(" actSeq:");
        localStringBuilder.append(((IActionRequest)localObject2).getTaskId());
        localStringBuilder.append(" reqSeq:");
        localStringBuilder.append(((IActionRequest)localObject2).getRequestId());
        UploadLog.d("UploadSession", localStringBuilder.toString());
      }
      i += 1;
    }
    while (((LinkedList)localObject1).size() > 0) {
      this.mSendingMap.remove(((Integer)((LinkedList)localObject1).removeFirst()).intValue());
    }
    k = this.mTimeoutMap.size();
    i = j;
    while (i < k)
    {
      localObject2 = (UploadSession.RequestWrapper)this.mTimeoutMap.valueAt(i);
      if ((localObject2 != null) && (((UploadSession.RequestWrapper)localObject2).request.getTaskId() == paramInt))
      {
        j = this.mTimeoutMap.keyAt(i);
        ((LinkedList)localObject1).add(Integer.valueOf(j));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mId);
        localStringBuilder.append(" cancel: mTimeoutMap remove runnable reqSeq:");
        localStringBuilder.append(j);
        localStringBuilder.append(" actSeq:");
        localStringBuilder.append(((UploadSession.RequestWrapper)localObject2).request.getTaskId());
        UploadLog.d("UploadSession", localStringBuilder.toString());
        this.mHandler.removeCallbacks(((UploadSession.RequestWrapper)localObject2).runnable);
        ((UploadSession.RequestWrapper)localObject2).runnable = null;
      }
      i += 1;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Close Session. sid=");
    ((StringBuilder)localObject).append(this.mId);
    UploadLog.w("[connect] UploadSession", ((StringBuilder)localObject).toString());
    localObject = this.mConnection;
    if (localObject != null)
    {
      ((NetworkEngine)localObject).stop();
      this.mConnection = null;
    }
    localObject = (IUploadSessionCallback)this.mUploadSessionCallback.get();
    if (localObject != null) {
      ((IUploadSessionCallback)localObject).onSessionClosed(this);
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
    boolean bool;
    if (System.currentTimeMillis() - this.mLastActiveTime > 60000L) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("session isExpired:");
    localStringBuilder.append(bool);
    UploadLog.i("UploadSession", localStringBuilder.toString());
    return bool;
  }
  
  public boolean isIdle()
  {
    boolean bool;
    if ((!this.mIsBusy) && (this.mActionRequests.size() == 0) && (this.mSendingMap.size() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isIdle --- ");
    localStringBuilder.append(bool);
    UploadLog.d("UploadSession", localStringBuilder.toString());
    return bool;
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
    paramIConnectionCallback = new StringBuilder();
    paramIConnectionCallback.append("Session onStart. sid=");
    paramIConnectionCallback.append(this.mId);
    UploadLog.d("UploadSession", paramIConnectionCallback.toString());
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
    int i = paramInt;
    if (paramInt <= 0) {
      i = UploadConfiguration.getConnectionTimeout();
    }
    NetworkEngine localNetworkEngine = this.mConnection;
    if (localNetworkEngine != null)
    {
      localNetworkEngine.stop();
      this.mConnection = null;
    }
    if (this.mUploadRoute != null) {
      this.mUploadRoute = null;
    }
    this.mConnection = new NetworkEngine(this, this.mId);
    localNetworkEngine = this.mConnection;
    if (localNetworkEngine == null)
    {
      paramUploadRoute = new StringBuilder();
      paramUploadRoute.append("Open NetworkEngine Failed! sid=");
      paramUploadRoute.append(this.mId);
      paramUploadRoute.append(" state:");
      paramUploadRoute.append(this.mSessionState.toString());
      UploadLog.w("[connect] UploadSession", paramUploadRoute.toString());
      return false;
    }
    if (!localNetworkEngine.start())
    {
      paramUploadRoute = new StringBuilder();
      paramUploadRoute.append("NetworkEngine Start Failed! sid=");
      paramUploadRoute.append(this.mId);
      paramUploadRoute.append(" state:");
      paramUploadRoute.append(this.mSessionState.toString());
      UploadLog.w("[connect] UploadSession", paramUploadRoute.toString());
      return false;
    }
    boolean bool = this.mConnection.connectAsync(paramUploadRoute.getIp(), paramUploadRoute.getPort(), null, 0, i);
    if (bool)
    {
      this.mUploadRoute = paramUploadRoute;
      setSessionState(IUploadSession.SessionState.CONNECTING);
    }
    paramUploadRoute = new StringBuilder();
    paramUploadRoute.append("connectAsync success, sid=");
    paramUploadRoute.append(this.mId);
    paramUploadRoute.append(" state:");
    paramUploadRoute.append(this.mSessionState.toString());
    UploadLog.d("[connect] UploadSession", paramUploadRoute.toString());
    return bool;
  }
  
  public void recordLastActiveTime()
  {
    this.mLastActiveTime = System.currentTimeMillis();
  }
  
  public boolean send(IActionRequest paramIActionRequest, IUploadSession.RequestListener paramRequestListener)
  {
    if (this.mSessionState != IUploadSession.SessionState.ESTABLISHED)
    {
      paramRequestListener = new StringBuilder();
      paramRequestListener.append("Can't send request, state is illegel. CurrState=");
      paramRequestListener.append(this.mSessionState.toString());
      paramRequestListener.append(" sid=");
      paramRequestListener.append(this.mId);
      UploadLog.e("UploadSession", paramRequestListener.toString());
      if ((paramIActionRequest != null) && (paramIActionRequest.getListener() != null)) {
        paramIActionRequest.getListener().onRequestError(paramIActionRequest, Const.UploadRetCode.SESSION_STATE_ERROR, this);
      }
      return false;
    }
    if (paramIActionRequest == null)
    {
      paramIActionRequest = new StringBuilder();
      paramIActionRequest.append("Can't send request, request is illegel. sid=");
      paramIActionRequest.append(this.mId);
      UploadLog.e("UploadSession", paramIActionRequest.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession
 * JD-Core Version:    0.7.0.1
 */