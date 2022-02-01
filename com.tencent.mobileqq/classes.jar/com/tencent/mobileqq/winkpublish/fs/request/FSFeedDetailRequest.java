package com.tencent.mobileqq.winkpublish.fs.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.winkpublish.fs.request.base.FSBaseRequest;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

public class FSFeedDetailRequest
  extends FSBaseRequest
{
  private final FeedCloudRead.StGetFeedDetailReq mRequest = new FeedCloudRead.StGetFeedDetailReq();
  
  public FSFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramLong, paramBoolean, 0, null);
  }
  
  public FSFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    this.mRequest.feedId.set(paramString1);
    this.mRequest.userId.set(paramString2);
    this.mRequest.createTime.set(paramLong);
    this.mRequest.useUGCStore.set(paramBoolean);
    this.mRequest.from.set(paramInt);
    if (paramStFeed != null)
    {
      paramString1 = QCircleHostUtil.getSimpleFeed(paramStFeed);
      if (paramString1 != null)
      {
        paramString1.busiTranparent.set(paramStFeed.busiTranparent.get());
        this.mRequest.entryFeed.set(paramString1);
      }
    }
  }
  
  public FeedCloudRead.StGetFeedDetailRsp decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedDetailRsp localStGetFeedDetailRsp = new FeedCloudRead.StGetFeedDetailRsp();
    try
    {
      localStGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedDetailRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetFeedDetail";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fs.request.FSFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */