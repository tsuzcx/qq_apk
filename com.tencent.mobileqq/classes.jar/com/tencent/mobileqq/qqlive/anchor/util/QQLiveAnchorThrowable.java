package com.tencent.mobileqq.qqlive.anchor.util;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorThrowable
  extends Throwable
{
  public String message;
  public int originCode;
  public String originMsg;
  
  public QQLiveAnchorThrowable(String paramString)
  {
    this.message = paramString;
  }
  
  public QQLiveAnchorThrowable(String paramString1, int paramInt, String paramString2)
  {
    this.message = paramString1;
    this.originCode = paramInt;
    this.originMsg = paramString2;
  }
  
  public static final QQLiveErrorMsg covert(int paramInt, Throwable paramThrowable)
  {
    QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
    localQQLiveErrorMsg.bizModule = 2;
    localQQLiveErrorMsg.bizErrCode = paramInt;
    if ((paramThrowable instanceof QQLiveAnchorThrowable))
    {
      paramThrowable = (QQLiveAnchorThrowable)paramThrowable;
      localQQLiveErrorMsg.bizErrMsg = paramThrowable.message;
      localQQLiveErrorMsg.originErrCode = paramThrowable.originCode;
      localQQLiveErrorMsg.originErrMsg = paramThrowable.originMsg;
      return localQQLiveErrorMsg;
    }
    localQQLiveErrorMsg.bizErrMsg = paramThrowable.getMessage();
    return localQQLiveErrorMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable
 * JD-Core Version:    0.7.0.1
 */