package com.tencent.mobileqq.transfile.quic.internal;

public class QuicNative
{
  private QuicNative.QuicCallback callback;
  private boolean cleared;
  private int handleId;
  private byte[] srvMessage;
  
  private native void clear(int paramInt);
  
  @Deprecated
  private native void connect(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean, int paramInt3, byte[] paramArrayOfByte);
  
  private native void connectSupportGlobal0Rtt(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean1, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString3);
  
  private native void connectSupportIpv6(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean1, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean2);
  
  private native byte[] getSrvMessage(int paramInt);
  
  private native String getState(int paramInt);
  
  public static native void init();
  
  private void onClose(int paramInt, String paramString)
  {
    if (this.callback != null) {
      this.callback.onClose(this.handleId, paramInt, paramString);
    }
  }
  
  private void onCompleted()
  {
    if (this.callback != null) {
      this.callback.onCompleted(this.handleId);
    }
  }
  
  private void onConnect(int paramInt)
  {
    if (this.callback != null) {
      this.callback.onConnect(this.handleId, paramInt);
    }
  }
  
  private void onDataReceive(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.callback != null) {
      this.callback.onDataReceive(this.handleId, paramArrayOfByte, paramInt);
    }
  }
  
  private native void sendRequest(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean, int paramInt3);
  
  public static native void setDebugLog(boolean paramBoolean);
  
  private native void setTransCompleted(int paramInt, boolean paramBoolean);
  
  public void clear()
  {
    if (this.cleared) {
      return;
    }
    this.cleared = true;
    clear(this.handleId);
  }
  
  public byte[] getSrvMessage()
  {
    return this.srvMessage;
  }
  
  public String getState()
  {
    this.srvMessage = null;
    if (this.cleared) {
      return "";
    }
    String str = getState(this.handleId);
    this.srvMessage = getSrvMessage(this.handleId);
    return str;
  }
  
  public void sendRequest(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.cleared) {
      return;
    }
    sendRequest(this.handleId, paramArrayOfByte, paramInt1, paramBoolean, paramInt2);
  }
  
  void setCallback(QuicNative.QuicCallback paramQuicCallback)
  {
    this.callback = paramQuicCallback;
  }
  
  public void setTransCompleted(boolean paramBoolean)
  {
    setTransCompleted(this.handleId, paramBoolean);
  }
  
  public void startConnect(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean1, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    startConnect(paramInt1, paramString1, paramString2, paramInt2, paramBoolean1, paramInt3, paramArrayOfByte, paramBoolean2, "sns.cdn.qq.com");
  }
  
  public void startConnect(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean1, int paramInt3, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString3)
  {
    if (this.cleared) {
      return;
    }
    this.handleId = paramInt1;
    if ("sns.cdn.qq.com".equals(paramString3))
    {
      connectSupportIpv6(this.handleId, paramString1, paramString2, paramInt2, paramBoolean1, paramInt3, paramArrayOfByte, paramBoolean2);
      return;
    }
    connectSupportGlobal0Rtt(this.handleId, paramString1, paramString2, paramInt2, paramBoolean1, paramInt3, paramArrayOfByte, paramBoolean2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicNative
 * JD-Core Version:    0.7.0.1
 */