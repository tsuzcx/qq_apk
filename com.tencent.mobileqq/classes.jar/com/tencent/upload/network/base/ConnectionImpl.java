package com.tencent.upload.network.base;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;

public class ConnectionImpl
{
  private static final String DEF_SO_VERSION = "v1.3";
  private static final int MSG_ID_ON_CONNECT = 1;
  private static final int MSG_ID_ON_DISCONNECT = 2;
  private static final int MSG_ID_ON_ERROR = 3;
  private static final int MSG_ID_ON_MSGPROC = 8;
  private static final int MSG_ID_ON_RECV = 5;
  private static final int MSG_ID_ON_SENDBEGIN = 6;
  private static final int MSG_ID_ON_SENDEND = 7;
  private static final int MSG_ID_ON_START = 0;
  private static final int MSG_ID_ON_TIMEOUT = 4;
  private static final int PROTOCOL_TYPE_HTTP = 2;
  private static final int PROTOCOL_TYPE_TCP = 1;
  private static final String SO_LIB_C_SHARED = "c++_shared";
  private static final String SO_LIB_NETBASE = "networkbase";
  private static final String SO_LIB_UPLOAD = "uploadnetwork";
  private static final String TAG = "ConnectionImpl";
  private static volatile boolean sIsLibraryPrepared = false;
  private IConnectionCallback mCallback = null;
  private final String mId;
  private IMsgCallback mMsgCallback = null;
  private long mNativeContext;
  
  static
  {
    for (;;)
    {
      boolean bool2;
      boolean bool4;
      boolean bool1;
      try
      {
        IUploadSoLoader localIUploadSoLoader = UploadGlobalConfig.getUploadSoLoader();
        if (localIUploadSoLoader == null) {
          break label286;
        }
        bool3 = localIUploadSoLoader.loadLibrary("c++_shared");
        if (localIUploadSoLoader.getSoVersion() == null) {
          break label287;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(localIUploadSoLoader.getSoVersion());
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("networkbase");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uploadnetwork");
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        bool2 = localIUploadSoLoader.loadLibrary((String)localObject2);
        bool4 = localIUploadSoLoader.loadLibrary((String)localObject1);
        bool1 = bool2;
        if (bool2) {
          break label294;
        }
        bool1 = bool2;
        if (!bool4) {
          break label294;
        }
        bool1 = localIUploadSoLoader.loadLibrary((String)localObject2);
      }
      catch (Throwable localThrowable)
      {
        boolean bool3;
        Object localObject1;
        UploadLog.e("ConnectionImpl", localThrowable.toString());
      }
      sIsLibraryPrepared = bool2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sIsLibraryPrepared = ");
      ((StringBuilder)localObject1).append(sIsLibraryPrepared);
      ((StringBuilder)localObject1).append(" isSharedLoaded = ");
      ((StringBuilder)localObject1).append(bool3);
      ((StringBuilder)localObject1).append(" isLib1Loaded = ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" isLib2Loaded = ");
      ((StringBuilder)localObject1).append(bool4);
      UploadLog.w("ConnectionImpl", ((StringBuilder)localObject1).toString());
      if (sIsLibraryPrepared)
      {
        native_init();
        return;
      }
      label286:
      return;
      label287:
      String str = "_v1.3";
      continue;
      label294:
      if ((bool1) && (bool4)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
  }
  
  public ConnectionImpl(int paramInt, String paramString)
  {
    this.mId = paramString;
    native_setup2(new WeakReference(this), 1, paramInt, Integer.parseInt(this.mId));
    paramString = new StringBuilder();
    paramString.append("ConnectionImpl constructor : id = ");
    paramString.append(this.mId);
    UploadLog.d("ConnectionImpl", paramString.toString());
  }
  
  private static final String getActionNameById(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown msg";
    case 8: 
      return "msgProc";
    case 7: 
      return "sendEnd";
    case 6: 
      return "sendBegin";
    case 5: 
      return "onRecv";
    case 4: 
      return "onTimeout";
    case 3: 
      return "onError";
    case 2: 
      return "onDisconnect";
    case 1: 
      return "onConnect";
    }
    return "onStart";
  }
  
  public static native int getIpStack();
  
  public static final boolean isLibraryPrepared()
  {
    return sIsLibraryPrepared;
  }
  
  private final native void native_finalize();
  
  private static final native void native_init();
  
  private final native void native_setup(Object paramObject, int paramInt1, int paramInt2);
  
  private final native void native_setup2(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
  
  private void onConnect(boolean paramBoolean, int paramInt, String paramString)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onConnect(localIConnectionCallback, paramBoolean, paramInt, paramString);
    }
  }
  
  private void onDisconnect()
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onDisconnect(localIConnectionCallback);
    }
  }
  
  private void onError(int paramInt)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onError(localIConnectionCallback, paramInt);
    }
  }
  
  private void onMsgProc(int paramInt1, Object paramObject, int paramInt2)
  {
    IMsgCallback localIMsgCallback = this.mMsgCallback;
    if (localIMsgCallback != null) {
      localIMsgCallback.onMsgCallback(localIMsgCallback, paramInt1, paramObject, paramInt2);
    }
  }
  
  private void onRecv(byte[] paramArrayOfByte)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onRecv(localIConnectionCallback, paramArrayOfByte);
    }
  }
  
  private void onSendBegin(int paramInt)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onSendBegin(localIConnectionCallback, paramInt);
    }
  }
  
  private void onSendEnd(int paramInt)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onSendEnd(localIConnectionCallback, paramInt);
    }
  }
  
  private void onStart()
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onStart(localIConnectionCallback);
    }
  }
  
  private void onTimeOut(int paramInt1, int paramInt2)
  {
    IConnectionCallback localIConnectionCallback = this.mCallback;
    if (localIConnectionCallback != null) {
      localIConnectionCallback.onSendTimeOut(localIConnectionCallback, paramInt1, paramInt2);
    }
  }
  
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (!(paramObject1 instanceof WeakReference))
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("fromNative: !(ConnectionImpl_ref instanceof WeakReference<?>) what:");
      paramObject1.append(getActionNameById(paramInt1));
      paramObject1.append(" arg1:");
      paramObject1.append(paramInt2);
      paramObject1.append(" arg2:");
      paramObject1.append(paramInt3);
      UploadLog.w("ConnectionImpl", paramObject1.toString());
      return;
    }
    paramObject1 = ((WeakReference)paramObject1).get();
    if (!(paramObject1 instanceof ConnectionImpl))
    {
      paramObject2 = new StringBuilder();
      paramObject2.append("fromNative: !(ref instanceof ConnectionImpl) what:");
      paramObject2.append(getActionNameById(paramInt1));
      paramObject2.append(" arg1:");
      paramObject2.append(paramInt2);
      paramObject2.append(" arg2:");
      paramObject2.append(paramInt3);
      paramObject2.append("ref:");
      paramObject2.append(paramObject1);
      UploadLog.w("ConnectionImpl", paramObject2.toString());
      return;
    }
    ConnectionImpl localConnectionImpl = (ConnectionImpl)paramObject1;
    paramObject1 = localConnectionImpl.getHashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject1);
    localStringBuilder.append(" fromNative:");
    localStringBuilder.append(getActionNameById(paramInt1));
    UploadLog.d("ConnectionImpl", localStringBuilder.toString());
    switch (paramInt1)
    {
    default: 
      paramObject2 = new StringBuilder();
      paramObject2.append(paramObject1);
      paramObject2.append(" Unknown message type ");
      paramObject2.append(paramInt1);
      UploadLog.e("ConnectionImpl", paramObject2.toString());
      return;
    case 8: 
      localConnectionImpl.onMsgProc(paramInt2, paramObject2, paramInt3);
      return;
    case 7: 
      localConnectionImpl.onSendEnd(paramInt2);
      return;
    case 6: 
      localConnectionImpl.onSendBegin(paramInt2);
      return;
    case 5: 
      localConnectionImpl.onRecv((byte[])paramObject2);
      return;
    case 4: 
      localConnectionImpl.onTimeOut(paramInt2, paramInt3);
      return;
    case 3: 
      localConnectionImpl.onError(paramInt2);
      return;
    case 2: 
      localConnectionImpl.onDisconnect();
      return;
    case 1: 
      boolean bool;
      if (paramInt2 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localConnectionImpl.onConnect(bool, paramInt3, (String)paramObject2);
      return;
    }
    localConnectionImpl.onStart();
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    UploadLog.d("jni", paramString);
  }
  
  public native boolean PostMessage(int paramInt1, Object paramObject, int paramInt2);
  
  public native boolean SendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean connect(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean disconnect();
  
  protected void finalize()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" finalize");
    UploadLog.w("ConnectionImpl", localStringBuilder.toString());
    try
    {
      disconnect();
      super.finalize();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final String getHashCode()
  {
    return this.mId;
  }
  
  public native boolean isRunning();
  
  public native boolean isSendDone(int paramInt);
  
  public native void removeAllSendData();
  
  public native void removeSendData(int paramInt);
  
  public void setCallback(IConnectionCallback paramIConnectionCallback)
  {
    this.mCallback = paramIConnectionCallback;
  }
  
  public void setMsgCallback(IMsgCallback paramIMsgCallback)
  {
    this.mMsgCallback = paramIMsgCallback;
  }
  
  public native boolean start();
  
  public native boolean stop();
  
  public native void wakeUp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.base.ConnectionImpl
 * JD-Core Version:    0.7.0.1
 */