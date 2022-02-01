package com.tencent.mobileqq.flashshow.model.comment;

import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddFeedCommentBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteFeedCommentBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSLoadCommentListBean;
import feedcloud.FeedCloudMeta.StComment;
import java.util.List;

public abstract interface IFSCommentManager
{
  public abstract void a(FSAddCommentReplyBean paramFSAddCommentReplyBean);
  
  public abstract void a(FSAddFeedCommentBean paramFSAddFeedCommentBean);
  
  public abstract void a(FSDeleteCommentReplyBean paramFSDeleteCommentReplyBean);
  
  public abstract void a(FSDeleteFeedCommentBean paramFSDeleteFeedCommentBean);
  
  public abstract void a(FSLoadCommentListBean paramFSLoadCommentListBean);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract boolean a(String paramString);
  
  public abstract List<FeedCloudMeta.StComment> b(String paramString);
  
  public abstract int c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.IFSCommentManager
 * JD-Core Version:    0.7.0.1
 */