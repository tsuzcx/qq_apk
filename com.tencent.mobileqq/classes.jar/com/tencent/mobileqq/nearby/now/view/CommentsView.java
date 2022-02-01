package com.tencent.mobileqq.nearby.now.view;

import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

public abstract interface CommentsView
{
  public abstract void addCommentInView(Comments.Comment paramComment);
  
  public abstract void hideInputKeyboard();
  
  public abstract void hideLoading();
  
  public abstract void publishCommentFailed(Comments.Comment paramComment, int paramInt, String paramString);
  
  public abstract void removeCommentDirectly(Comments.Comment paramComment);
  
  public abstract void showBadNetworkConnection();
  
  public abstract void showDataInView(Comments paramComments);
  
  public abstract void showLoading();
  
  public abstract void showToast(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsView
 * JD-Core Version:    0.7.0.1
 */