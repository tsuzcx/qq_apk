package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

public class QCircleGetMainPageRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetMainPageReq mRequest = new FeedCloudRead.StGetMainPageReq();
  
  public QCircleGetMainPageRequest(String paramString)
  {
    this(paramString, null);
  }
  
  public QCircleGetMainPageRequest(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public QCircleGetMainPageRequest(String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null) {
      this.mRequest.feedAttchInfo.set(paramString2);
    }
    if (paramString1 != null) {
      this.mRequest.userId.set(paramString1);
    }
    this.mRequest.from.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetMainPageRsp localStGetMainPageRsp = new FeedCloudRead.StGetMainPageRsp();
    try
    {
      localStGetMainPageRsp.mergeFrom(paramArrayOfByte);
      return localStGetMainPageRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetMainPageRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleGetMainPageRequest
 * JD-Core Version:    0.7.0.1
 */