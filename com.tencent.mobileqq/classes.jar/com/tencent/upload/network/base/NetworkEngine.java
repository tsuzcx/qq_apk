package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.DomainNameParser;
import com.tencent.upload.network.route.DomainNameParser.ParseResult;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkEngine
  implements IMsgCallback, INetworkEngine
{
  private static final AtomicInteger PARAM_SEQUENCE = new AtomicInteger(0);
  private final String TAG;
  protected final IConnectionCallback mCallback;
  protected String mConnectedIp;
  private final String mId;
  protected final byte[] mLock = new byte[0];
  private ConnectionImpl mNativeConnection;
  protected SparseArray<Object> mParamMap = new SparseArray();
  
  public NetworkEngine(IConnectionCallback paramIConnectionCallback, String paramString)
  {
    this.mId = paramString;
    paramString = new StringBuilder();
    paramString.append("NetworkEngine-");
    paramString.append(this.mId);
    this.TAG = paramString.toString();
    int i = UploadConfiguration.getDoNotFragment();
    this.mCallback = paramIConnectionCallback;
    if (!ConnectionImpl.isLibraryPrepared())
    {
      UploadLog.e(this.TAG, "!isLibraryPrepared");
      return;
    }
    this.mNativeConnection = new ConnectionImpl(i, this.mId);
    this.mNativeConnection.setCallback(this.mCallback);
    this.mNativeConnection.setMsgCallback(this);
  }
  
  private static final int nextParamSequence()
  {
    return PARAM_SEQUENCE.incrementAndGet();
  }
  
  public boolean connectAsync(String arg1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    paramString2 = new NetworkEngine.ConnectParam(???, paramInt1, paramString2, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, paramString2);
      return this.mNativeConnection.PostMessage(0, null, paramInt1);
    }
  }
  
  public boolean disconnect()
  {
    ??? = this.mNativeConnection;
    if (??? == null) {
      return false;
    }
    boolean bool = ((ConnectionImpl)???).disconnect();
    synchronized (this.mLock)
    {
      this.mParamMap.clear();
      return bool;
    }
  }
  
  public final String getConnectedIp()
  {
    return this.mConnectedIp;
  }
  
  public int hashCode()
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      return localIConnectionCallback.hashCode();
    }
    return super.hashCode();
  }
  
  public boolean isRunning()
  {
    ConnectionImpl localConnectionImpl = this.mNativeConnection;
    if (localConnectionImpl == null) {
      return false;
    }
    return localConnectionImpl.isRunning();
  }
  
  public void onMsgCallback(IMsgCallback paramIMsgCallback, int paramInt1, Object arg3, int paramInt2)
  {
    synchronized (this.mLock)
    {
      paramIMsgCallback = this.mParamMap.get(paramInt2);
      this.mParamMap.remove(paramInt2);
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2) {
            return;
          }
          ??? = this.mNativeConnection;
          if ((??? != null) && ((paramIMsgCallback instanceof NetworkEngine.SendParam)))
          {
            paramIMsgCallback = (NetworkEngine.SendParam)paramIMsgCallback;
            ???.SendData(paramIMsgCallback.buf, paramIMsgCallback.sendSequence, paramIMsgCallback.sendTimeout, paramIMsgCallback.recvTimeout);
            return;
          }
          ??? = this.TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" OperationMsg.SEND, obj instanceof ConnectParam:");
          ((StringBuilder)localObject).append(paramIMsgCallback instanceof NetworkEngine.SendParam);
          ((StringBuilder)localObject).append("mNativeConnection != null:");
          if (this.mNativeConnection != null) {
            bool1 = true;
          }
          ((StringBuilder)localObject).append(bool1);
          UploadLog.w(???, ((StringBuilder)localObject).toString());
          return;
        }
        if (this.mNativeConnection != null)
        {
          UploadLog.w(this.TAG, " OperationMsg.DISCONNECT");
          this.mNativeConnection.disconnect();
          return;
        }
        UploadLog.w(this.TAG, " OperationMsg.DISCONNECT, mNativeConnection == null");
        return;
      }
      if ((this.mNativeConnection != null) && ((paramIMsgCallback instanceof NetworkEngine.ConnectParam)))
      {
        ??? = (NetworkEngine.ConnectParam)paramIMsgCallback;
        paramIMsgCallback = ???.ip;
        paramInt1 = UploadConfiguration.getMaxSegmentSize(paramIMsgCallback);
        if ((!StringUtils.isIpv4String(???.ip)) && (!StringUtils.isIpv6String(???.ip)))
        {
          localObject = new DomainNameParser.ParseResult();
          DomainNameParser.parse(???.ip, (DomainNameParser.ParseResult)localObject);
          paramIMsgCallback = ((DomainNameParser.ParseResult)localObject).parsedIp;
          ((DomainNameParser.ParseResult)localObject).parsedIp = null;
          if (paramIMsgCallback == null)
          {
            ??? = this.mCallback;
            if (??? == null) {
              return;
            }
            ???.onConnect(???, false, Const.UploadRetCode.DNS_PARSER_ERROR.getCode(), paramIMsgCallback);
            return;
          }
        }
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" OperationMsg.CONNECT, parsedIp:");
        localStringBuilder.append(paramIMsgCallback);
        localStringBuilder.append(", port:");
        localStringBuilder.append(???.port);
        localStringBuilder.append(", proxyIp:");
        localStringBuilder.append(???.proxyIp);
        localStringBuilder.append(", proxyPort:");
        localStringBuilder.append(???.proxyPort);
        localStringBuilder.append(" timeout:");
        localStringBuilder.append(???.timeout);
        UploadLog.w((String)localObject, localStringBuilder.toString());
        this.mConnectedIp = paramIMsgCallback;
        this.mNativeConnection.connect(paramIMsgCallback, ???.port, ???.proxyIp, ???.proxyPort, ???.timeout, paramInt1);
        return;
      }
      ??? = this.TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" OperationMsg.CONNECT, obj instanceof ConnectParam:");
      ((StringBuilder)localObject).append(paramIMsgCallback instanceof NetworkEngine.ConnectParam);
      ((StringBuilder)localObject).append(" mNativeConnection != null:");
      bool1 = bool2;
      if (this.mNativeConnection != null) {
        bool1 = true;
      }
      ((StringBuilder)localObject).append(bool1);
      UploadLog.w(???, ((StringBuilder)localObject).toString());
      return;
    }
  }
  
  public boolean sendAsync(byte[] arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNativeConnection == null) {
      return false;
    }
    NetworkEngine.SendParam localSendParam = new NetworkEngine.SendParam(???, paramInt1, paramInt2, paramInt3);
    paramInt1 = nextParamSequence();
    synchronized (this.mLock)
    {
      this.mParamMap.put(paramInt1, localSendParam);
      return this.mNativeConnection.PostMessage(2, null, paramInt1);
    }
  }
  
  public boolean start()
  {
    ConnectionImpl localConnectionImpl = this.mNativeConnection;
    if (localConnectionImpl == null) {
      return false;
    }
    if (localConnectionImpl.isRunning())
    {
      UploadLog.w(this.TAG, "start, is running, return false");
      return false;
    }
    return this.mNativeConnection.start();
  }
  
  public boolean stop()
  {
    ??? = this.mNativeConnection;
    if (??? == null) {
      return false;
    }
    ((ConnectionImpl)???).removeAllSendData();
    boolean bool = this.mNativeConnection.stop();
    synchronized (this.mLock)
    {
      this.mParamMap.clear();
      return bool;
    }
  }
  
  public void wakeUp()
  {
    ConnectionImpl localConnectionImpl = this.mNativeConnection;
    if (localConnectionImpl == null) {
      return;
    }
    localConnectionImpl.wakeUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.base.NetworkEngine
 * JD-Core Version:    0.7.0.1
 */