package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;

public class HwResponse
{
  public int buzRetCode;
  public long cacheCost;
  public String cmd;
  public int errCode;
  public String errDesc;
  public long htCost;
  public int hwSeq = -1;
  public boolean isFinish;
  public boolean isIpv6;
  public int mBuCmdId = -1;
  public byte[] mBuExtendinfo;
  public byte[] mRespData;
  public int mTransId = -1;
  public boolean needReUpload;
  public int range;
  public long recvTime;
  public long reqCost;
  public int respLength;
  public int retCode;
  public CSDataHighwayHead.SegHead segmentResp;
  public boolean shouldRetry;
  public long switchCost;
  
  public String dumpRespInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder(" REQTRACE_RSP");
    localStringBuilder.append(" B_ID:").append(this.mBuCmdId).append(" T_ID:").append(this.mTransId).append(" Seq:").append(this.hwSeq).append(" Cmd:").append(this.cmd).append(" Err_C:").append(this.errCode).append(" Err_B:").append(this.buzRetCode).append(" Err_H:").append(this.retCode).append(" COST_Switch:").append(this.switchCost).append("ms").append(" COST_REQ:").append(this.reqCost).append("ms").append(" COST_HT:").append(this.htCost).append("ms").append(" COST_CACHE:").append(this.cacheCost).append("ms").append(" FIN:").append(this.isFinish).append(" Retry:").append(this.shouldRetry).append(" RespLen:").append(this.respLength).append(" isIpv6:").append(this.isIpv6);
    return localStringBuilder.toString();
  }
  
  public void setErrorCode(int paramInt1, int paramInt2, String paramString)
  {
    this.errCode = paramInt1;
    this.retCode = paramInt2;
    this.errDesc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.HwResponse
 * JD-Core Version:    0.7.0.1
 */