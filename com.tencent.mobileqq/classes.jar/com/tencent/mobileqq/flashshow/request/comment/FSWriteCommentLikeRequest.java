package com.tencent.mobileqq.flashshow.request.comment;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoLikeReq;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FSWriteCommentLikeRequest
  extends FSBaseRequest
{
  private boolean mIsPraise = false;
  private boolean mIsReward = false;
  private FeedCloudWrite.StDoLikeReq mReq;
  private FeedCloudMeta.StFeed mStFeed;
  
  public FSWriteCommentLikeRequest(FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder paramFSWriteLikeCommentRequestBuilder)
  {
    Object localObject = paramFSWriteLikeCommentRequestBuilder.b();
    if (localObject == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    int i = FSWriteCommentLikeRequest.FSWriteLikeCommentRequestBuilder.a(paramFSWriteLikeCommentRequestBuilder);
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(FSCommonUtil.a((FeedCloudMeta.StFeed)localObject));
    this.mReq.likeType.set(i);
    localObject = paramFSWriteLikeCommentRequestBuilder.c();
    if (localObject != null)
    {
      ((FeedCloudMeta.StLike)localObject).vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { FSCommonUtil.b() }));
      ((FeedCloudMeta.StLike)localObject).postUser.set(FSCommonUtil.b());
      this.mReq.like.set((MessageMicro)localObject);
    }
    localObject = paramFSWriteLikeCommentRequestBuilder.d();
    if (localObject != null) {
      this.mReq.comment.set((MessageMicro)localObject);
    }
    localObject = paramFSWriteLikeCommentRequestBuilder.e();
    if (localObject != null) {
      this.mReq.reply.set((MessageMicro)localObject);
    }
    boolean bool = paramFSWriteLikeCommentRequestBuilder.f();
    paramFSWriteLikeCommentRequestBuilder = new FeedCloudCommon.Entry();
    paramFSWriteLikeCommentRequestBuilder.key.set("ext_source");
    if (bool) {
      paramFSWriteLikeCommentRequestBuilder.value.set("2");
    } else {
      paramFSWriteLikeCommentRequestBuilder.value.set("1");
    }
    localObject = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFSWriteLikeCommentRequestBuilder);
    ((FeedCloudCommon.StCommonExt)localObject).mapInfo.set(localArrayList);
    this.mReq.extInfo.set((MessageMicro)localObject);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoLikeRsp localStDoLikeRsp = new FeedCloudWrite.StDoLikeRsp();
    try
    {
      localStDoLikeRsp.mergeFrom(paramArrayOfByte);
      return localStDoLikeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoLikeRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commwriter.ComWriter.DoLike";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public FeedCloudMeta.StFeed getStFeed()
  {
    return this.mStFeed;
  }
  
  public boolean isPraise()
  {
    return this.mIsPraise;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentLikeRequest
 * JD-Core Version:    0.7.0.1
 */