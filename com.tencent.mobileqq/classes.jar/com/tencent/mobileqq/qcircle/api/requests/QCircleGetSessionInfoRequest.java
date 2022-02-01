package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetSessionInfoReq;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

public class QCircleGetSessionInfoRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StGetSessionInfoReq mReq;
  
  public QCircleGetSessionInfoRequest(FeedCloudCommon.StCommonExt paramStCommonExt, int paramInt)
  {
    setRetryCount(2);
    this.mReq = new FeedCloudRead.StGetSessionInfoReq();
    if (paramStCommonExt != null) {
      this.mReq.extInfo.set(paramStCommonExt);
    }
    this.mReq.scene.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetSessionInfoRsp localStGetSessionInfoRsp = new FeedCloudRead.StGetSessionInfoRsp();
    try
    {
      localStGetSessionInfoRsp.mergeFrom(paramArrayOfByte);
      return localStGetSessionInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetSessionInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetSessionInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public boolean isNeedRetry(long paramLong)
  {
    QLog.d("VSBaseRequest", 1, new Object[] { "CmdName:", getCmdName(), ",retCode:", Long.valueOf(paramLong), "isNeedRetry:true" });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleGetSessionInfoRequest
 * JD-Core Version:    0.7.0.1
 */