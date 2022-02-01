package com.tencent.mobileqq.kandian.biz.comment.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;

public class AddCommentLinkEvent
  extends SimpleBaseEvent
{
  private static final long serialVersionUID = -364985398734531148L;
  public final BaseCommentData.CommentLinkData linkData;
  
  public AddCommentLinkEvent(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    this.linkData = paramCommentLinkData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.event.AddCommentLinkEvent
 * JD-Core Version:    0.7.0.1
 */