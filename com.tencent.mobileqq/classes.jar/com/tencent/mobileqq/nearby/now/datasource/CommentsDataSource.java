package com.tencent.mobileqq.nearby.now.datasource;

import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

public abstract interface CommentsDataSource
{
  public abstract void a(int paramInt, CommentsDataSource.LoadCommentsCallback paramLoadCommentsCallback);
  
  public abstract void a(Comments.Comment paramComment, CommentsDataSource.DeleteCommentCallback paramDeleteCommentCallback);
  
  public abstract void a(Comments.Comment paramComment, CommentsDataSource.PublishCommentCallback paramPublishCommentCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource
 * JD-Core Version:    0.7.0.1
 */