package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class RequestDataTrans
  extends HwRequest
{
  public DataTransInfo mInfo;
  
  public RequestDataTrans(String paramString1, String paramString2, int paramInt1, DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    super(paramString1, paramString2, paramInt1, paramArrayOfByte, paramInt2, paramLong);
    this.mInfo = paramDataTransInfo;
    this.isOpenUpEnable = paramDataTransInfo.parent.isOpenUpEnable;
  }
  
  public String dumpBaseInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("DUMP_REQ [TYPE_DATA] Info: ");
    localStringBuilder.append(super.dumpBaseInfo());
    localStringBuilder.append("\tFsize:");
    localStringBuilder.append(this.mInfo.fileSize);
    localStringBuilder.append("\tOffset:");
    localStringBuilder.append(this.mInfo.offset);
    localStringBuilder.append("\tBitS:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append("\tBitE:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append("\tLen:");
    localStringBuilder.append(this.mInfo.length);
    localStringBuilder.append("\tMD5:");
    localStringBuilder.append(this.mInfo.md5Str);
    return localStringBuilder.toString();
  }
  
  public byte[] getExtendInfo()
  {
    return this.mInfo.parent.extendInfo;
  }
  
  public CSDataHighwayHead.LoginSigHead getLoginSigHead()
  {
    return this.mInfo.parent.loginSigHead;
  }
  
  public byte[] getRequestBody()
  {
    return this.mInfo.getData();
  }
  
  public CSDataHighwayHead.SegHead getSegmentHead()
  {
    CSDataHighwayHead.SegHead localSegHead = new CSDataHighwayHead.SegHead();
    localSegHead.uint32_datalength.set(this.mInfo.length);
    localSegHead.uint64_dataoffset.set(this.mInfo.offset);
    localSegHead.uint64_filesize.set(this.mInfo.fileSize);
    if ((this.ticket != null) && (getTicket().length > 0)) {
      localSegHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
    }
    if (this.mInfo.md5 != null) {
      localSegHead.bytes_md5.set(ByteStringMicro.copyFrom(this.mInfo.md5));
    }
    if (this.mInfo.parent.MD5 != null) {
      localSegHead.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mInfo.parent.MD5));
    }
    writeCacheIp(localSegHead, this.mInfo.parent);
    return localSegHead;
  }
  
  public boolean hasRequestBody()
  {
    return true;
  }
  
  public void onCancle()
  {
    Tracker localTracker = this.mInfo.parent.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Data Start:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append(" End:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("CANCL", localStringBuilder.toString());
    this.mInfo.handleCancle();
  }
  
  public void onError(int paramInt)
  {
    Tracker localTracker = this.mInfo.parent.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Data Start:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append(" End:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(getHwSeq());
    localStringBuilder.append(" Code:");
    localStringBuilder.append(paramInt);
    localTracker.logStep("SND_E", localStringBuilder.toString());
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    Object localObject1 = this.mInfo.parent.TRACKER;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" Data Resp Start:");
    ((StringBuilder)localObject2).append(this.mInfo.bitmapS);
    ((StringBuilder)localObject2).append(" End:");
    ((StringBuilder)localObject2).append(this.mInfo.bitmapE);
    ((StringBuilder)localObject2).append(" Seq:");
    ((StringBuilder)localObject2).append(getHwSeq());
    ((StringBuilder)localObject2).append(" Code:");
    ((StringBuilder)localObject2).append(paramHwResponse.retCode);
    ((Tracker)localObject1).logStep("RESPN", ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" Data Resp Start:");
    ((StringBuilder)localObject1).append(this.mInfo.bitmapS);
    ((StringBuilder)localObject1).append(" End:");
    ((StringBuilder)localObject1).append(this.mInfo.bitmapE);
    ((StringBuilder)localObject1).append(" Seq:");
    ((StringBuilder)localObject1).append(getHwSeq());
    ((StringBuilder)localObject1).append(" Code:");
    ((StringBuilder)localObject1).append(paramHwResponse.retCode);
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject1).toString());
    Transaction localTransaction = paramRequestWorker.engine.mTransWorker.getTransactionById(this.transId);
    if (localTransaction != null)
    {
      this.mInfo.timeCost_req = paramHwResponse.reqCost;
      this.mInfo.timeCost_hw = paramHwResponse.htCost;
      this.mInfo.timeCost_cache = paramHwResponse.cacheCost;
      this.mInfo.retryTimes = this.retryCount;
      localObject1 = this.endpoint;
      localObject2 = "TCP";
      boolean bool = true;
      if (localObject1 != null)
      {
        localTransaction.mTransReport.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
        localTransaction.mTransReport.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
        TransReport localTransReport = localTransaction.mTransReport;
        if (this.protoType == 1) {
          localObject1 = "TCP";
        } else {
          localObject1 = "HTTP";
        }
        localTransReport.protoType = ((String)localObject1);
        localTransaction.mTransReport.ipIndex = this.endpoint.ipIndex;
        localTransaction.mTransReport.isIpv6 = paramHwResponse.isIpv6;
        localTransaction.mTransReport.mHasIpv6List = paramRequestWorker.engine.mConnManager.mHasIpv6List;
        localTransaction.mTransReport.mIPv6Fast = paramRequestWorker.engine.mConnManager.isIpv6Fast();
      }
      if (paramHwResponse.retCode == 0)
      {
        if (paramHwResponse.segmentResp.uint32_flag.has())
        {
          if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) != 1) {
            bool = false;
          }
          paramHwResponse.isFinish = bool;
        }
        checkCacheIp(paramHwResponse, this.mInfo.parent);
        if (this.mInfo.bitmapS == 0) {
          localTransaction.mTransReport.firstRange = paramHwResponse.range;
        }
        if (paramHwResponse.needReUpload)
        {
          if (!localTransaction.reUploadTransaction)
          {
            localTransaction.onTransReUpload(getHwSeq());
            return;
          }
          paramRequestWorker = new StringBuilder();
          paramRequestWorker.append("B_ID:");
          paramRequestWorker.append(localTransaction.mBuzCmdId);
          paramRequestWorker.append("\tT_ID:");
          paramRequestWorker.append(localTransaction.getTransationId());
          paramRequestWorker.append(" ReUpload twice,transaction fail");
          BdhLogUtil.LogEvent("T", paramRequestWorker.toString());
          localTransaction.TRACKER.logStep("REUPLOAD", "ReUpload twice");
          localTransaction.onTransFailed(9304, "ReUpload twice", paramHwResponse.retCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
          return;
        }
        if ((paramHwResponse.range > localTransaction.transferedSizeBDH) && (getHwSeq() > localTransaction.reUploadHwSeq)) {
          if (paramHwResponse.range > localTransaction.totalLength)
          {
            paramRequestWorker = new StringBuilder();
            paramRequestWorker.append("B_ID:");
            paramRequestWorker.append(localTransaction.mBuzCmdId);
            paramRequestWorker.append("\tT_ID:");
            paramRequestWorker.append(localTransaction.getTransationId());
            paramRequestWorker.append(" ReturnServerRangeError");
            BdhLogUtil.LogEvent("T", paramRequestWorker.toString());
            localTransaction.transferedSizeBDH = 0;
          }
          else
          {
            localTransaction.transferedSizeBDH = paramHwResponse.range;
          }
        }
        if (paramHwResponse.isFinish)
        {
          localTransaction.onTransSuccess(this.mInfo, paramHwResponse.mBuExtendinfo);
          return;
        }
        localTransaction.onTransProgress(this, paramHwResponse);
        return;
      }
      paramRequestWorker = new StringBuilder();
      paramRequestWorker.append("HandleResp : RespError :");
      paramRequestWorker.append(dumpBaseInfo());
      BdhLogUtil.LogEvent("R", paramRequestWorker.toString());
      localObject1 = localTransaction.mTransReport;
      if (this.protoType == 1) {
        paramRequestWorker = (RequestWorker)localObject2;
      } else {
        paramRequestWorker = "HTTP";
      }
      ((TransReport)localObject1).protoType = paramRequestWorker;
      localTransaction.onTransFailed(0, "BadResponse", paramHwResponse.retCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
    }
  }
  
  public void onRetry(int paramInt)
  {
    this.mInfo.parent.mTransReport.mRetryCode = paramInt;
    Tracker localTracker = this.mInfo.parent.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Data Start:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append(" End:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(getHwSeq());
    localStringBuilder.append(" Code:");
    localStringBuilder.append(paramInt);
    localTracker.logStep("SND_R", localStringBuilder.toString());
  }
  
  public void onSendBegin()
  {
    Tracker localTracker = this.mInfo.parent.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Data Start:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append(" End:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("SND_S", localStringBuilder.toString());
  }
  
  public void onSendEnd()
  {
    Tracker localTracker = this.mInfo.parent.TRACKER;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" Data Start:");
    localStringBuilder.append(this.mInfo.bitmapS);
    localStringBuilder.append(" End:");
    localStringBuilder.append(this.mInfo.bitmapE);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(getHwSeq());
    localTracker.logStep("SND_F", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestDataTrans
 * JD-Core Version:    0.7.0.1
 */