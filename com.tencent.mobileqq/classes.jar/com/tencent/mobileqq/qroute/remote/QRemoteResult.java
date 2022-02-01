package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;

public class QRemoteResult
{
  public static final int CODE_CONNECTION_INVALID = -2;
  public static final int CODE_CONNECT_FAILED = -105;
  public static final int CODE_ERR = -102;
  public static final int CODE_HAS_EXCEPTION = -101;
  public static final int CODE_NO_CONNECT = -1;
  public static final int CODE_NO_ERR = 0;
  public static final int CODE_UNKNOWN = -100;
  public int code = -100;
  public Bundle data;
  public Throwable throwable;
  
  public QRemoteResult() {}
  
  public QRemoteResult(int paramInt, Bundle paramBundle)
  {
    this.code = paramInt;
    this.data = paramBundle;
  }
  
  public QRemoteResult(int paramInt, Bundle paramBundle, Throwable paramThrowable)
  {
    this.code = paramInt;
    this.data = paramBundle;
    this.throwable = paramThrowable;
  }
  
  public QRemoteResult(int paramInt, Throwable paramThrowable)
  {
    this.code = paramInt;
    this.throwable = paramThrowable;
  }
  
  public QRemoteResult(Throwable paramThrowable)
  {
    this.code = -101;
    this.throwable = paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.QRemoteResult
 * JD-Core Version:    0.7.0.1
 */