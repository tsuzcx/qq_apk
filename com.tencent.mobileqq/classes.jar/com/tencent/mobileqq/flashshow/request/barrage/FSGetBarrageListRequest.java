package com.tencent.mobileqq.flashshow.request.barrage;

import com.tencent.mobileqq.flashshow.model.barrage.bean.FSLoadBarrageListBean;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

public class FSGetBarrageListRequest
  extends FSBaseRequest
{
  public FeedCloudRead.StGetCommentListReq mRequest;
  
  public FSGetBarrageListRequest(FSLoadBarrageListBean paramFSLoadBarrageListBean, String paramString, int paramInt)
  {
    if (paramFSLoadBarrageListBean == null)
    {
      QLog.d("FSCommentListRequest", 1, "[FSGetCommentListRequest] bean should not be null.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramFSLoadBarrageListBean.c();
    if (localStFeed == null) {
      paramFSLoadBarrageListBean = "";
    } else {
      paramFSLoadBarrageListBean = localStFeed.likeInfo.id.get();
    }
    this.mRequest = new FeedCloudRead.StGetCommentListReq();
    if (localStFeed != null)
    {
      this.mRequest.userId.set(localStFeed.poster.id.get());
      this.mRequest.feedId.set(localStFeed.id.get());
      this.mRequest.busiTranparent.set(localStFeed.busiTranparent.get());
    }
    if (paramString != null) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
    this.mRequest.listNum.set(paramInt);
    this.mRequest.likeKey.set(paramFSLoadBarrageListBean);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetCommentListRsp localStGetCommentListRsp = new FeedCloudRead.StGetCommentListRsp();
    try
    {
      localStGetCommentListRsp.mergeFrom(paramArrayOfByte);
      return localStGetCommentListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetCommentListRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetHotCommentList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.barrage.FSGetBarrageListRequest
 * JD-Core Version:    0.7.0.1
 */