package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetC2CFeedReq;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;

public class QCircleStGetC2CFeedRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetC2CFeedReq mReq = new FeedCloudRead.StGetC2CFeedReq();
  
  public QCircleStGetC2CFeedRequest(String paramString)
  {
    this.mReq.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetC2CFeedRsp localStGetC2CFeedRsp = new FeedCloudRead.StGetC2CFeedRsp();
    try
    {
      localStGetC2CFeedRsp.mergeFrom(paramArrayOfByte);
      return localStGetC2CFeedRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetC2CFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetC2CFeed";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleStGetC2CFeedRequest
 * JD-Core Version:    0.7.0.1
 */