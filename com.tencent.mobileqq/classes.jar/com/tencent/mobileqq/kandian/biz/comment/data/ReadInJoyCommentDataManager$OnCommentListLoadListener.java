package com.tencent.mobileqq.kandian.biz.comment.data;

import java.util.List;

public abstract interface ReadInJoyCommentDataManager$OnCommentListLoadListener
{
  public abstract void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3);
  
  public abstract void onCommentStateError(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener
 * JD-Core Version:    0.7.0.1
 */