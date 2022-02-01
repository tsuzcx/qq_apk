package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class HwRequest
{
  public static final int REQ_2SEND = 2;
  public static final int REQ_FINISHED = 4;
  public static final int REQ_INITED = 1;
  public static final int REQ_SENDING = 3;
  public static final int buzTryCountLimit = 3;
  public static final int fixTryCountLimit = 5;
  public static final int mContinuErrorLimit = 10;
  public static final int mContinueConnClosedLimit = 3;
  public static final long mExcuteTimeLimit = 600000L;
  public String account;
  public int appid = 4660;
  public int bodyLength = 0;
  public int buzRetryCount;
  public int continueConnClose = 0;
  public int continueErrCount = 0;
  public int dataFlag = 4096;
  public EndPoint endpoint = null;
  public int headLength = 0;
  public String hwCmd = null;
  private int hwSeq = -1;
  public AtomicBoolean isCancel = new AtomicBoolean(false);
  public boolean isOpenUpEnable = false;
  public long lastSendStartTime;
  public String lastUseAddress = null;
  public int localeId;
  public int mBuCmdId = -1;
  public int protoType = 1;
  public IRequestListener reqListener;
  public int retryCount;
  public long sendComsume;
  public int sendConnId;
  public long sendTime;
  public AtomicInteger status = new AtomicInteger(1);
  protected byte[] ticket;
  public long timeComsume;
  public long timeOut;
  public int timeOutCount;
  public int transId;
  
  public HwRequest(String paramString1, String paramString2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    this.account = paramString1;
    this.hwCmd = paramString2;
    this.ticket = paramArrayOfByte;
    this.transId = paramInt2;
    this.mBuCmdId = paramInt1;
    this.hwSeq = RequestWorker.getNextSeq();
    this.appid = HwEngine.appId;
    this.localeId = HwEngine.localeId;
    if (paramLong == -1L)
    {
      this.timeOut = 30000L;
      return;
    }
    this.timeOut = paramLong;
  }
  
  public static String intToIP(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".").append(paramInt >>> 8 & 0xFF).append(".").append(paramInt >>> 16 & 0xFF).append(".").append(paramInt >>> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  protected void checkCacheIp(HwResponse paramHwResponse, Transaction paramTransaction)
  {
    int i = 1;
    if (paramHwResponse.segmentResp.uint32_cache_addr.has())
    {
      int j = paramHwResponse.segmentResp.uint32_cache_addr.get();
      if (j == 0) {
        break label235;
      }
      BdhLogUtil.LogEvent("R", getClass().getSimpleName() + "  HandleResp : cache_addr res from server is : " + j + " ( " + intToIP(j) + " ) Seq:" + getHwSeq());
      if (paramTransaction.cacheIp == 0) {
        paramTransaction.cacheIp = j;
      }
      if ((paramTransaction.cacheIp != 0) && (paramTransaction.cacheIp != j))
      {
        BdhLogUtil.LogEvent("R", getClass().getSimpleName() + " HandleResp : cache ip Diff ! Seq:" + getHwSeq());
        paramTransaction.mTransReport.bCacheDiff = true;
      }
      if (paramHwResponse.segmentResp.uint32_update_cacheip.has())
      {
        if (paramHwResponse.segmentResp.uint32_update_cacheip.get() == 0) {
          i = 0;
        }
        if (i != 0)
        {
          paramTransaction.cacheIp = j;
          BdhLogUtil.LogEvent("R", getClass().getSimpleName() + " HandleResp :updateCacheIp");
        }
      }
    }
    return;
    label235:
    BdhLogUtil.LogEvent("R", getClass().getSimpleName() + " HandleResp : cache_addr res from server is 0 ! Seq:" + getHwSeq());
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder(" REQTRACE_REQ ");
    localStringBuilder.append(" B_ID:").append(this.mBuCmdId).append(" T_ID:").append(this.transId).append(" Seq:").append(this.hwSeq).append(" Cmd:").append(this.hwCmd).append(" Uin:").append(this.account).append(" TimeOut:").append(this.timeOut).append(" RetryNum:").append(this.retryCount).append(" Comsume:").append(this.timeComsume).append(" SendCost:").append(this.sendComsume).append(" ContinueErr:").append(this.continueErrCount).append(" Status:").append(this.status.get()).append(" Cancel:").append(this.isCancel.get()).append(" HeadLen:").append(this.headLength).append(" BodyLen:").append(this.bodyLength);
    return localStringBuilder.toString();
  }
  
  public byte[] getExtendInfo()
  {
    return null;
  }
  
  public int getHwSeq()
  {
    return this.hwSeq;
  }
  
  public CSDataHighwayHead.LoginSigHead getLoginSigHead()
  {
    return null;
  }
  
  public int getPriority()
  {
    return 2;
  }
  
  public byte[] getRequestBody()
  {
    return null;
  }
  
  public abstract CSDataHighwayHead.SegHead getSegmentHead();
  
  public byte[] getTicket()
  {
    return this.ticket;
  }
  
  public boolean hasRequestBody()
  {
    return false;
  }
  
  public void onCancle() {}
  
  public void onError(int paramInt) {}
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    onResponse(paramRequestWorker, paramHwResponse, this);
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse, HwRequest paramHwRequest) {}
  
  public void onRetry(int paramInt) {}
  
  public void onSendBegin() {}
  
  public void onSendEnd() {}
  
  public void setHwSeq(int paramInt)
  {
    this.hwSeq = paramInt;
  }
  
  public void updateStaus(int paramInt)
  {
    this.status.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.HwRequest
 * JD-Core Version:    0.7.0.1
 */