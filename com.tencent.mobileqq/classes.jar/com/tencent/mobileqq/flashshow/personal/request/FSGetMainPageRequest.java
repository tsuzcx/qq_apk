package com.tencent.mobileqq.flashshow.personal.request;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

public class FSGetMainPageRequest
  extends FSBaseRequest
{
  private final FeedCloudRead.StGetMainPageReq mRequest;
  
  private FSGetMainPageRequest(FeedCloudRead.StGetMainPageReq paramStGetMainPageReq)
  {
    this.mRequest = paramStGetMainPageReq;
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
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetMainPage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public void setAttachInfo(String paramString)
  {
    this.mRequest.feedAttchInfo.set(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest
 * JD-Core Version:    0.7.0.1
 */