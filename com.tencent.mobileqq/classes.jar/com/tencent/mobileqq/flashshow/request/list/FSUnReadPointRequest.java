package com.tencent.mobileqq.flashshow.request.list;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StClearRedPointReq;
import feedcloud.FeedCloudRead.StClearRedPointRsp;

public class FSUnReadPointRequest
  extends FSBaseRequest
{
  public FeedCloudRead.StClearRedPointReq mRequest = new FeedCloudRead.StClearRedPointReq();
  
  public FSUnReadPointRequest(String paramString, int paramInt)
  {
    this.mRequest.userID.set(FSTransUtils.a());
    this.mRequest.toUID.set(paramString);
    this.mRequest.pageType.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StClearRedPointRsp localStClearRedPointRsp = new FeedCloudRead.StClearRedPointRsp();
    try
    {
      localStClearRedPointRsp.mergeFrom(paramArrayOfByte);
      return localStClearRedPointRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStClearRedPointRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearRedPoint";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.list.FSUnReadPointRequest
 * JD-Core Version:    0.7.0.1
 */