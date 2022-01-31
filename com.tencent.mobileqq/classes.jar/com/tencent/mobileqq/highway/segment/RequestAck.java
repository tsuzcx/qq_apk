package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class RequestAck
  extends HwRequest
{
  public static final int mContinuErrorLimit = 1;
  public int cacheIp_send;
  IRequestCallback cb;
  byte[] extendInfo;
  CSDataHighwayHead.LoginSigHead loginSigHead;
  byte[] md5;
  
  public RequestAck(String paramString, int paramInt1, byte[] paramArrayOfByte1, long paramLong, IRequestCallback paramIRequestCallback, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2)
  {
    super(paramString, "PicUp.DataUp", paramInt1, paramArrayOfByte1, 0, paramLong);
    this.cb = paramIRequestCallback;
    this.extendInfo = paramArrayOfByte2;
    this.md5 = paramArrayOfByte3;
    this.cacheIp_send = paramInt2;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_ACK] Info: ");
    localStringBuilder.append(super.dumpBaseInfo());
    localStringBuilder.append(" extendInfo: ");
    localStringBuilder.append(this.extendInfo);
    return localStringBuilder.toString();
  }
  
  public byte[] getExtendInfo()
  {
    return this.extendInfo;
  }
  
  public CSDataHighwayHead.LoginSigHead getLoginSigHead()
  {
    return this.loginSigHead;
  }
  
  public int getPriority()
  {
    return 1;
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    if (this.md5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.md5));
    }
    if (this.cacheIp_send != 0)
    {
      localSegHead.uint32_cache_addr.set(this.cacheIp_send);
      BdhLogUtil.LogEvent("R", "RequestAck getSegmentHead : cache_addr send to server is : " + this.cacheIp_send + " ( " + intToIP(this.cacheIp_send) + " ) Seq:" + getHwSeq());
    }
    return localSegHead;
  }
  
  public void onCancle() {}
  
  public void onError(int paramInt)
  {
    this.cb.onFailed(paramInt);
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    this.cb.onResponse(paramHwResponse);
  }
  
  public void onRetry(int paramInt) {}
  
  public void onSendBegin() {}
  
  public void onSendEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestAck
 * JD-Core Version:    0.7.0.1
 */