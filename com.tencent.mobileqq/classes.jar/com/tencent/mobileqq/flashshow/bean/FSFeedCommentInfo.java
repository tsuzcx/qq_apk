package com.tencent.mobileqq.flashshow.bean;

import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

public class FSFeedCommentInfo
{
  public FeedCloudMeta.StFeed a;
  public FeedCloudMeta.StComment b;
  public FeedCloudMeta.StReply c;
  public FSReportBean d;
  
  public FSFeedCommentInfo(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.a = paramStFeed;
    this.b = paramStComment;
    this.c = paramStReply;
  }
  
  public void a(FSReportBean paramFSReportBean)
  {
    this.d = paramFSReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo
 * JD-Core Version:    0.7.0.1
 */