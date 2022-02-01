package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;

public class HwResponse
{
  public int buzRetCode = 0;
  public long cacheCost;
  public String cmd = null;
  public int errCode = 0;
  public String errDesc = null;
  public long htCost;
  public int hwSeq = -1;
  public boolean isFinish = false;
  public boolean isIpv6;
  public int mBuCmdId = -1;
  public byte[] mBuExtendinfo;
  public byte[] mRespData;
  public int mTransId = -1;
  public boolean needReUpload = false;
  public int range;
  public long recvTime;
  public long reqCost;
  public int respLength = 0;
  public int retCode = 0;
  public CSDataHighwayHead.SegHead segmentResp = null;
  public boolean shouldRetry = false;
  public long switchCost;
  
  public String dumpRespInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder(" REQTRACE_RSP");
    localStringBuilder.append(" B_ID:");
    localStringBuilder.append(this.mBuCmdId);
    localStringBuilder.append(" T_ID:");
    localStringBuilder.append(this.mTransId);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(this.hwSeq);
    localStringBuilder.append(" Cmd:");
    localStringBuilder.append(this.cmd);
    localStringBuilder.append(" Err_C:");
    localStringBuilder.append(this.errCode);
    localStringBuilder.append(" Err_B:");
    localStringBuilder.append(this.buzRetCode);
    localStringBuilder.append(" Err_H:");
    localStringBuilder.append(this.retCode);
    localStringBuilder.append(" COST_Switch:");
    localStringBuilder.append(this.switchCost);
    localStringBuilder.append("ms");
    localStringBuilder.append(" COST_REQ:");
    localStringBuilder.append(this.reqCost);
    localStringBuilder.append("ms");
    localStringBuilder.append(" COST_HT:");
    localStringBuilder.append(this.htCost);
    localStringBuilder.append("ms");
    localStringBuilder.append(" COST_CACHE:");
    localStringBuilder.append(this.cacheCost);
    localStringBuilder.append("ms");
    localStringBuilder.append(" FIN:");
    localStringBuilder.append(this.isFinish);
    localStringBuilder.append(" Retry:");
    localStringBuilder.append(this.shouldRetry);
    localStringBuilder.append(" RespLen:");
    localStringBuilder.append(this.respLength);
    localStringBuilder.append(" isIpv6:");
    localStringBuilder.append(this.isIpv6);
    return localStringBuilder.toString();
  }
  
  public void setErrorCode(int paramInt1, int paramInt2, String paramString)
  {
    this.errCode = paramInt1;
    this.retCode = paramInt2;
    this.errDesc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.HwResponse
 * JD-Core Version:    0.7.0.1
 */