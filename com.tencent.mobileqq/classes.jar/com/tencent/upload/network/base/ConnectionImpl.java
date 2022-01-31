package com.tencent.upload.network.base;

import com.tencent.upload.uinterface.IUploadEnv;
import java.lang.ref.WeakReference;

public class ConnectionImpl
{
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
  private static final String TAG = "ConnectionImpl";
  private static volatile boolean sIsLibraryPrepared;
  private a mCallback = null;
  private final String mId;
  private b mMsgCallback = null;
  private int mNativeContext;
  
  static
  {
    boolean bool3 = false;
    sIsLibraryPrepared = false;
    try
    {
      boolean bool2 = com.tencent.upload.common.a.e().loadLibrary("networkbase");
      boolean bool4 = com.tencent.upload.common.a.e().loadLibrary("uploadnetwork");
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = com.tencent.upload.common.a.e().loadLibrary("networkbase");
        }
      }
      native_init();
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (bool4) {
          bool2 = true;
        }
      }
      sIsLibraryPrepared = bool2;
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.upload.common.b.e("ConnectionImpl", localThrowable.toString());
    }
  }
  
  public ConnectionImpl(int paramInt, String paramString)
  {
    this.mId = paramString;
    native_setup(new WeakReference(this), 1, paramInt);
    com.tencent.upload.common.b.b("ConnectionImpl", "ConnectionImpl constructor : id = " + this.mId);
  }
  
  private static final String getActionNameById(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown msg";
    case 0: 
      return "onStart";
    case 1: 
      return "onConnect";
    case 2: 
      return "onDisconnect";
    case 3: 
      return "onError";
    case 4: 
      return "onTimeout";
    case 5: 
      return "onRecv";
    case 6: 
      return "sendBegin";
    case 7: 
      return "sendEnd";
    }
    return "msgProc";
  }
  
  public static final boolean isLibraryPrepared()
  {
    return sIsLibraryPrepared;
  }
  
  private final native void native_finalize();
  
  private static final native void native_init();
  
  private final native void native_setup(Object paramObject, int paramInt1, int paramInt2);
  
  private void onConnect(boolean paramBoolean, int paramInt, String paramString)
  {
    if (this.mCallback != null) {
      this.mCallback.a(this.mCallback, paramBoolean, paramInt, paramString);
    }
  }
  
  private void onDisconnect()
  {
    if (this.mCallback != null) {
      this.mCallback.b(this.mCallback);
    }
  }
  
  private void onError(int paramInt)
  {
    if (this.mCallback != null) {
      this.mCallback.a(this.mCallback, paramInt);
    }
  }
  
  private void onMsgProc(int paramInt1, Object paramObject, int paramInt2)
  {
    if (this.mMsgCallback != null) {
      this.mMsgCallback.a(this.mMsgCallback, paramInt1, paramObject, paramInt2);
    }
  }
  
  private void onRecv(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null) {
      this.mCallback.a(this.mCallback, paramArrayOfByte);
    }
  }
  
  private void onSendBegin(int paramInt)
  {
    if (this.mCallback != null) {
      this.mCallback.b(this.mCallback, paramInt);
    }
  }
  
  private void onSendEnd(int paramInt)
  {
    if (this.mCallback != null) {
      this.mCallback.c(this.mCallback, paramInt);
    }
  }
  
  private void onStart()
  {
    if (this.mCallback != null) {
      this.mCallback.a(this.mCallback);
    }
  }
  
  private void onTimeOut(int paramInt1, int paramInt2)
  {
    if (this.mCallback != null) {
      this.mCallback.a(this.mCallback, paramInt1, paramInt2);
    }
  }
  
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (!(paramObject1 instanceof WeakReference))
    {
      com.tencent.upload.common.b.d("ConnectionImpl", "fromNative: !(ConnectionImpl_ref instanceof WeakReference<?>)");
      return;
    }
    paramObject1 = ((WeakReference)paramObject1).get();
    if (!(paramObject1 instanceof ConnectionImpl))
    {
      com.tencent.upload.common.b.d("ConnectionImpl", "fromNative: !(ref instanceof ConnectionImpl)");
      return;
    }
    paramObject1 = (ConnectionImpl)paramObject1;
    String str = paramObject1.getHashCode();
    com.tencent.upload.common.b.b("ConnectionImpl", str + " fromNative:" + getActionNameById(paramInt1));
    switch (paramInt1)
    {
    default: 
      com.tencent.upload.common.b.e("ConnectionImpl", str + " Unknown message type " + paramInt1);
      return;
    case 0: 
      paramObject1.onStart();
      return;
    case 1: 
      if (paramInt2 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject1.onConnect(bool, paramInt3, (String)paramObject2);
        return;
      }
    case 2: 
      paramObject1.onDisconnect();
      return;
    case 3: 
      paramObject1.onError(paramInt2);
      return;
    case 4: 
      paramObject1.onTimeOut(paramInt2, paramInt3);
      return;
    case 6: 
      paramObject1.onSendBegin(paramInt2);
      return;
    case 7: 
      paramObject1.onSendEnd(paramInt2);
      return;
    case 8: 
      paramObject1.onMsgProc(paramInt2, paramObject2, paramInt3);
      return;
    }
    paramObject1.onRecv((byte[])paramObject2);
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    com.tencent.upload.common.b.b("jni", paramString);
  }
  
  public native boolean PostMessage(int paramInt1, Object paramObject, int paramInt2);
  
  public native boolean SendData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean connect(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean disconnect();
  
  protected void finalize()
  {
    com.tencent.upload.common.b.d("ConnectionImpl", this.mId + " finalize");
    try
    {
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
  
  public void setCallback(a parama)
  {
    this.mCallback = parama;
  }
  
  public void setMsgCallback(b paramb)
  {
    this.mMsgCallback = paramb;
  }
  
  public native boolean start();
  
  public native boolean stop();
  
  public native void wakeUp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.base.ConnectionImpl
 * JD-Core Version:    0.7.0.1
 */