package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspBody;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Arrays;

public class RequestInfoQuery
  extends HwRequest
{
  public Transaction mTrans;
  public byte[] sentBitmap;
  
  public RequestInfoQuery(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte1, Transaction paramTransaction, long paramLong, byte[] paramArrayOfByte2)
  {
    super(paramString1, paramString2, paramInt, paramArrayOfByte1, paramTransaction.getTransationId(), paramLong);
    this.sentBitmap = paramArrayOfByte2;
    this.mTrans = paramTransaction;
    this.isOpenUpEnable = paramTransaction.isOpenUpEnable;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_INFOQUERY] Info: ");
    localStringBuilder.append(super.dumpBaseInfo());
    return localStringBuilder.toString();
  }
  
  public byte[] getExtendInfo()
  {
    return this.mTrans.extendInfo;
  }
  
  public CSDataHighwayHead.LoginSigHead getLoginSigHead()
  {
    return this.mTrans.loginSigHead;
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
    if (this.mTrans.MD5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mTrans.MD5));
    }
    localSegHead.uint64_filesize.set(this.mTrans.totalLength);
    if (this.mTrans.cacheIp != 0)
    {
      localSegHead.uint32_cache_addr.set(this.mTrans.cacheIp);
      BdhLogUtil.LogEvent("R", "RequestInfoQuery getSegmentHead : cache_addr send to server is : " + this.mTrans.cacheIp + " ( " + intToIP(this.mTrans.cacheIp) + " ) Seq:" + getHwSeq());
    }
    return localSegHead;
  }
  
  public void onCancle()
  {
    this.mTrans.TRACKER.logStep("CANCL", " Query Seq:" + getHwSeq());
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
  
  public void onError(int paramInt)
  {
    this.mTrans.onQuertHoleError(this.sentBitmap);
    this.mTrans.TRACKER.logStep("SND_E", " Query Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse, HwRequest paramHwRequest)
  {
    boolean bool;
    Object localObject;
    if ((paramHwResponse.segmentResp.has()) && (paramHwResponse.segmentResp.uint32_flag.has()))
    {
      if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) == 1)
      {
        bool = true;
        paramHwResponse.isFinish = bool;
      }
    }
    else
    {
      this.mTrans.TRACKER.logStep("RESPN", " Query Seq:" + getHwSeq() + " RetCode:" + paramHwResponse.retCode + " isFinish:" + paramHwResponse.isFinish);
      BdhLogUtil.LogEvent("R", "QueryDebug Query HandleResponse : retResp.hwRetCode:" + paramHwResponse.retCode + " : TransId:" + this.mTrans.getTransationId() + " CopyBitmap:" + Arrays.toString(this.sentBitmap) + " CurrentBitmap:" + Arrays.toString(this.mTrans.bitmap));
      if (this.endpoint != null)
      {
        this.mTrans.mTransReport.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
        this.mTrans.mTransReport.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
        TransReport localTransReport = this.mTrans.mTransReport;
        if (this.protoType != 1) {
          break label362;
        }
        localObject = "TCP";
        label253:
        localTransReport.protoType = ((String)localObject);
        this.mTrans.mTransReport.ipIndex = this.endpoint.ipIndex;
        this.mTrans.mTransReport.isIpv6 = paramHwResponse.isIpv6;
        paramRequestWorker = ConfigManager.getInstance(paramRequestWorker.engine.getAppContext(), paramRequestWorker.engine);
        this.mTrans.mTransReport.netIpType = paramRequestWorker.mCurnetIptype;
      }
      if (paramHwResponse.retCode != 0) {
        break label434;
      }
      if (!paramHwResponse.isFinish) {
        break label370;
      }
      this.mTrans.onTransSuccess(null, paramHwResponse.mBuExtendinfo);
    }
    for (;;)
    {
      checkCacheIp(paramHwResponse, this.mTrans);
      return;
      bool = false;
      break;
      label362:
      localObject = "HTTP";
      break label253;
      label370:
      localObject = paramHwResponse.mRespData;
      paramRequestWorker = new CSDataHighwayHead.RspBody();
      try
      {
        paramRequestWorker.mergeFrom((byte[])localObject);
        this.mTrans.onQueryHoleResp((CSDataHighwayHead.QueryHoleRsp)paramRequestWorker.msg_query_hole_rsp.get(), this.sentBitmap, false, paramHwResponse, (RequestInfoQuery)paramHwRequest);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          BdhLogUtil.LogEvent("R", "HandleResp ParseError.");
        }
      }
    }
    label434:
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
  
  public void onRetry(int paramInt)
  {
    this.mTrans.TRACKER.logStep("SND_R", " Query Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onSendBegin()
  {
    this.mTrans.TRACKER.logStep("SND_S", " Query Seq:" + getHwSeq());
  }
  
  public void onSendEnd()
  {
    this.mTrans.TRACKER.logStep("SND_F", " Query Seq:" + getHwSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestInfoQuery
 * JD-Core Version:    0.7.0.1
 */