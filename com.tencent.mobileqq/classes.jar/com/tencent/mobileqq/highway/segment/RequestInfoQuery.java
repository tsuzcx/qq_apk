package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
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
    writeCacheIp(localSegHead, this.mTrans);
    return localSegHead;
  }
  
  public void onCancle()
  {
    Tracker localTracker = this.mTrans.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Query Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("CANCL", localStringBuilder.toString());
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
  
  public void onError(int paramInt)
  {
    this.mTrans.onQuertHoleError(this.sentBitmap);
    Tracker localTracker = this.mTrans.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Query Seq:");
    localStringBuilder.append(getHwSeq());
    localStringBuilder.append(" Code:");
    localStringBuilder.append(paramInt);
    localTracker.logStep("SND_E", localStringBuilder.toString());
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse, HwRequest paramHwRequest)
  {
    if ((paramHwResponse.segmentResp.has()) && (paramHwResponse.segmentResp.uint32_flag.has()))
    {
      boolean bool;
      if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramHwResponse.isFinish = bool;
    }
    Object localObject1 = this.mTrans.TRACKER;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" Query Seq:");
    ((StringBuilder)localObject2).append(getHwSeq());
    ((StringBuilder)localObject2).append(" RetCode:");
    ((StringBuilder)localObject2).append(paramHwResponse.retCode);
    ((StringBuilder)localObject2).append(" isFinish:");
    ((StringBuilder)localObject2).append(paramHwResponse.isFinish);
    ((Tracker)localObject1).logStep("RESPN", ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QueryDebug Query HandleResponse : retResp.hwRetCode:");
    ((StringBuilder)localObject1).append(paramHwResponse.retCode);
    ((StringBuilder)localObject1).append(" : TransId:");
    ((StringBuilder)localObject1).append(this.mTrans.getTransationId());
    ((StringBuilder)localObject1).append(" CopyBitmap:");
    ((StringBuilder)localObject1).append(Arrays.toString(this.sentBitmap));
    ((StringBuilder)localObject1).append(" CurrentBitmap:");
    ((StringBuilder)localObject1).append(Arrays.toString(this.mTrans.bitmap));
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
    if (this.endpoint != null)
    {
      this.mTrans.mTransReport.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
      this.mTrans.mTransReport.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
      localObject2 = this.mTrans.mTransReport;
      if (this.protoType == 1) {
        localObject1 = "TCP";
      } else {
        localObject1 = "HTTP";
      }
      ((TransReport)localObject2).protoType = ((String)localObject1);
      this.mTrans.mTransReport.ipIndex = this.endpoint.ipIndex;
      this.mTrans.mTransReport.isIpv6 = paramHwResponse.isIpv6;
      this.mTrans.mTransReport.mHasIpv6List = paramRequestWorker.engine.mConnManager.mHasIpv6List;
      this.mTrans.mTransReport.mIPv6Fast = paramRequestWorker.engine.mConnManager.isIpv6Fast();
    }
    if (paramHwResponse.retCode == 0) {
      if (paramHwResponse.isFinish)
      {
        this.mTrans.onTransSuccess(null, paramHwResponse.mBuExtendinfo);
      }
      else
      {
        localObject1 = paramHwResponse.mRespData;
        paramRequestWorker = new CSDataHighwayHead.RspBody();
      }
    }
    try
    {
      paramRequestWorker.mergeFrom((byte[])localObject1);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label452:
      break label452;
    }
    BdhLogUtil.LogEvent("R", "HandleResp ParseError.");
    this.mTrans.onQueryHoleResp((CSDataHighwayHead.QueryHoleRsp)paramRequestWorker.msg_query_hole_rsp.get(), this.sentBitmap, false, paramHwResponse, (RequestInfoQuery)paramHwRequest);
    checkCacheIp(paramHwResponse, this.mTrans);
    return;
    this.mTrans.onQuertHoleError(this.sentBitmap);
  }
  
  public void onRetry(int paramInt)
  {
    Tracker localTracker = this.mTrans.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Query Seq:");
    localStringBuilder.append(getHwSeq());
    localStringBuilder.append(" Code:");
    localStringBuilder.append(paramInt);
    localTracker.logStep("SND_R", localStringBuilder.toString());
  }
  
  public void onSendBegin()
  {
    Tracker localTracker = this.mTrans.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Query Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("SND_S", localStringBuilder.toString());
  }
  
  public void onSendEnd()
  {
    Tracker localTracker = this.mTrans.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Query Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("SND_F", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestInfoQuery
 * JD-Core Version:    0.7.0.1
 */