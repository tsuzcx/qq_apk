package com.tencent.mobileqq.qqlive.data.common;

public class QQLiveErrorMsg
{
  public int bizErrCode;
  public String bizErrMsg;
  public int bizModule = 0;
  public int originErrCode = -1;
  public String originErrMsg;
  
  public QQLiveErrorMsg() {}
  
  public QQLiveErrorMsg(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.bizModule = paramInt1;
    this.bizErrCode = paramInt2;
    this.bizErrMsg = paramString1;
    this.originErrCode = paramInt3;
    this.originErrMsg = paramString2;
  }
  
  public QQLiveErrorMsg(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (paramQQLiveErrorMsg == null) {
      return;
    }
    this.bizModule = paramQQLiveErrorMsg.bizModule;
    this.bizErrCode = paramQQLiveErrorMsg.bizErrCode;
    this.bizErrMsg = paramQQLiveErrorMsg.bizErrMsg;
    this.originErrCode = paramQQLiveErrorMsg.originErrCode;
    this.originErrMsg = paramQQLiveErrorMsg.originErrMsg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveErrorMsg{bizModule=");
    localStringBuilder.append(this.bizModule);
    localStringBuilder.append(", bizErrCode=");
    localStringBuilder.append(this.bizErrCode);
    localStringBuilder.append(", bizErrMsg='");
    localStringBuilder.append(this.bizErrMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", originErrCode=");
    localStringBuilder.append(this.originErrCode);
    localStringBuilder.append(", originErrMsg='");
    localStringBuilder.append(this.originErrMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg
 * JD-Core Version:    0.7.0.1
 */