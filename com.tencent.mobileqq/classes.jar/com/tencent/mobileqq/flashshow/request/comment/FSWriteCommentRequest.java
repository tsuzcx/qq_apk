package com.tencent.mobileqq.flashshow.request.comment;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentReq;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.ArrayList;
import java.util.List;

public class FSWriteCommentRequest
  extends FSBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  public static final int OPER_TYPE_OWNER_DELETE = 2;
  public FeedCloudWrite.StDoCommentReq req;
  
  public FSWriteCommentRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QLog.w("FSWriteCommentRequest", 1, "stfeed is null");
      return;
    }
    this.req = new FeedCloudWrite.StDoCommentReq();
    this.req.feed.set(FSCommonUtil.a(paramStFeed));
    this.req.comment.set(paramStComment);
    this.req.commentType.set(paramInt);
    this.req.from.set(0);
    if (paramInt == 1) {
      this.req.comment.id.set("");
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (paramBoolean) {
      paramStFeed.value.set("2");
    } else {
      paramStFeed.value.set("1");
    }
    paramStComment = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramStFeed);
    paramStComment.mapInfo.set(localArrayList);
    this.req.extInfo.set(paramStComment);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoCommentRsp localStDoCommentRsp = new FeedCloudWrite.StDoCommentRsp();
    try
    {
      localStDoCommentRsp.mergeFrom(paramArrayOfByte);
      return localStDoCommentRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoCommentRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commwriter.ComWriter.DoComment";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentRequest
 * JD-Core Version:    0.7.0.1
 */