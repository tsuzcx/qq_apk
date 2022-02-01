package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;

public class QIPCApiResult
{
  public static final int CODE_CONNECTION_INVALID = -2;
  public static final int CODE_CONNECT_FAILED = -105;
  public static final int CODE_ERR = -102;
  public static final int CODE_HAS_EXCEPTION = -101;
  public static final int CODE_NO_CONNECT = -1;
  public static final int CODE_NO_ERR = 0;
  public static final int CODE_UNKOWN = -100;
  public int code;
  public Bundle data;
  private Throwable e;
  
  public static QIPCApiResult createExceptionResult(Throwable paramThrowable)
  {
    QIPCApiResult localQIPCApiResult = new QIPCApiResult();
    localQIPCApiResult.code = -101;
    localQIPCApiResult.e = paramThrowable;
    return localQIPCApiResult;
  }
  
  public static QIPCApiResult createSuccessResult(Bundle paramBundle)
  {
    QIPCApiResult localQIPCApiResult = new QIPCApiResult();
    localQIPCApiResult.code = 0;
    localQIPCApiResult.data = paramBundle;
    return localQIPCApiResult;
  }
  
  public boolean isSuccess()
  {
    return this.code == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.QIPCApiResult
 * JD-Core Version:    0.7.0.1
 */