package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;

public abstract interface ReadInJoyCommentBubbleObserver
{
  public abstract void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, String paramString, boolean paramBoolean2);
  
  public abstract void a(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver
 * JD-Core Version:    0.7.0.1
 */