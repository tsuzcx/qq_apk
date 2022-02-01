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
    localStringBuilder.append(super.dumpBaseInfo()).append("\tFsize:").append(this.mInfo.fileSize).append("\tOffset:").append(this.mInfo.offset).append("\tBitS:").append(this.mInfo.bitmapS).append("\tBitE:").append(this.mInfo.bitmapE).append("\tLen:").append(this.mInfo.length).append("\tMD5:").append(this.mInfo.md5Str);
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
    if (this.mInfo.parent.cacheIp != 0)
    {
      localSegHead.uint32_cache_addr.set(this.mInfo.parent.cacheIp);
      BdhLogUtil.LogEvent("R", "getSegmentHead : cache_addr send to server is : " + this.mInfo.parent.cacheIp + " ( " + intToIP(this.mInfo.parent.cacheIp) + " ) Seq:" + getHwSeq());
    }
    return localSegHead;
  }
  
  public boolean hasRequestBody()
  {
    return true;
  }
  
  public void onCancle()
  {
    this.mInfo.parent.TRACKER.logStep("CANCL", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
    this.mInfo.handleCancle();
  }
  
  public void onError(int paramInt)
  {
    this.mInfo.parent.TRACKER.logStep("SND_E", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onResponse(RequestWorker paramRequestWorker, HwResponse paramHwResponse)
  {
    this.mInfo.parent.TRACKER.logStep("RESPN", " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramHwResponse.retCode);
    BdhLogUtil.LogEvent("R", " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramHwResponse.retCode);
    Transaction localTransaction = paramRequestWorker.engine.mTransWorker.getTransactionById(this.transId);
    if (localTransaction != null)
    {
      this.mInfo.timeCost_req = paramHwResponse.reqCost;
      this.mInfo.timeCost_hw = paramHwResponse.htCost;
      this.mInfo.timeCost_cache = paramHwResponse.cacheCost;
      this.mInfo.retryTimes = this.retryCount;
      if (this.endpoint != null)
      {
        localTransaction.mTransReport.netType = HwNetworkCenter.getInstance(paramRequestWorker.engine.getAppContext()).getNetType();
        localTransaction.mTransReport.connNum = paramRequestWorker.engine.mConnManager.getCurrentConnNum();
        TransReport localTransReport = localTransaction.mTransReport;
        if (this.protoType != 1) {
          break label451;
        }
        localObject = "TCP";
        localTransReport.protoType = ((String)localObject);
        localTransaction.mTransReport.ipIndex = this.endpoint.ipIndex;
        localTransaction.mTransReport.isIpv6 = paramHwResponse.isIpv6;
        localTransaction.mTransReport.mHasIpv6List = paramRequestWorker.engine.mConnManager.mHasIpv6List;
        localTransaction.mTransReport.mIPv6Fast = paramRequestWorker.engine.mConnManager.isIpv6Fast();
      }
      if (paramHwResponse.retCode != 0) {
        break label689;
      }
      if (paramHwResponse.segmentResp.uint32_flag.has()) {
        if ((paramHwResponse.segmentResp.uint32_flag.get() & 0x1) != 1) {
          break label459;
        }
      }
    }
    label451:
    label459:
    for (boolean bool = true;; bool = false)
    {
      paramHwResponse.isFinish = bool;
      checkCacheIp(paramHwResponse, this.mInfo.parent);
      if (this.mInfo.bitmapS == 0) {
        localTransaction.mTransReport.firstRange = paramHwResponse.range;
      }
      if (!paramHwResponse.needReUpload) {
        break label556;
      }
      if (localTransaction.reUploadTransaction) {
        break label464;
      }
      localTransaction.onTransReUpload(getHwSeq());
      return;
      localObject = "HTTP";
      break;
    }
    label464:
    BdhLogUtil.LogEvent("T", "B_ID:" + localTransaction.mBuzCmdId + "\tT_ID:" + localTransaction.getTransationId() + " ReUpload twice,transaction fail");
    localTransaction.TRACKER.logStep("REUPLOAD", "ReUpload twice");
    localTransaction.onTransFailed(9304, "ReUpload twice", paramHwResponse.retCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
    return;
    label556:
    if ((paramHwResponse.range > localTransaction.transferedSizeBDH) && (getHwSeq() > localTransaction.reUploadHwSeq))
    {
      if (paramHwResponse.range <= localTransaction.totalLength) {
        break label669;
      }
      BdhLogUtil.LogEvent("T", "B_ID:" + localTransaction.mBuzCmdId + "\tT_ID:" + localTransaction.getTransationId() + " ReturnServerRangeError");
    }
    label669:
    for (localTransaction.transferedSizeBDH = 0; paramHwResponse.isFinish; localTransaction.transferedSizeBDH = paramHwResponse.range)
    {
      localTransaction.onTransSuccess(this.mInfo, paramHwResponse.mBuExtendinfo);
      return;
    }
    localTransaction.onTransProgress(this, paramHwResponse);
    return;
    label689:
    BdhLogUtil.LogEvent("R", "HandleResp : RespError :" + dumpBaseInfo());
    Object localObject = localTransaction.mTransReport;
    if (this.protoType == 1) {}
    for (paramRequestWorker = "TCP";; paramRequestWorker = "HTTP")
    {
      ((TransReport)localObject).protoType = paramRequestWorker;
      localTransaction.onTransFailed(0, "BadResponse", paramHwResponse.retCode, paramHwResponse.buzRetCode, this.retryCount, paramHwResponse.mBuExtendinfo);
      return;
    }
  }
  
  public void onRetry(int paramInt)
  {
    this.mInfo.parent.mTransReport.mRetryCode = paramInt;
    this.mInfo.parent.TRACKER.logStep("SND_R", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + paramInt);
  }
  
  public void onSendBegin()
  {
    this.mInfo.parent.TRACKER.logStep("SND_S", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
  }
  
  public void onSendEnd()
  {
    this.mInfo.parent.TRACKER.logStep("SND_F", " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestDataTrans
 * JD-Core Version:    0.7.0.1
 */