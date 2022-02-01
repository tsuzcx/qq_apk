package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$RespCommon
{
  public int errCode;
  public String errStr;
  public int failCount;
  public boolean isAllowRetry = true;
  public boolean isSendByQuickHttp = false;
  public RichProto.RichProtoReq originReq;
  public String reason;
  public int result = -1;
  public int successCount;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.result);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.errCode);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.errStr);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.successCount);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.failCount);
    localStringBuilder.append(" isSendByQuickHttp");
    localStringBuilder.append(this.isSendByQuickHttp);
    localStringBuilder.append(" isAllowRetry");
    localStringBuilder.append(this.isAllowRetry);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
 * JD-Core Version:    0.7.0.1
 */