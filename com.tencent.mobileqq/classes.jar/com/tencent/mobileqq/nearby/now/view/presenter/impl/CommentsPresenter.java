package com.tencent.mobileqq.nearby.now.view.presenter.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CommentsView;

public class CommentsPresenter
{
  private CommentsView a;
  private CommentsDataSource b;
  private VideoData c;
  private int d = 0;
  
  public CommentsPresenter(CommentsView paramCommentsView, Object paramObject, AppInterface paramAppInterface)
  {
    this.a = paramCommentsView;
    paramCommentsView = (VideoData)paramObject;
    this.b = new CommentsDataSourceImpl(paramCommentsView, (QQAppInterface)paramAppInterface);
    this.c = paramCommentsView;
  }
  
  public void a()
  {
    this.d = 0;
    b();
  }
  
  public void a(Comments.Comment paramComment)
  {
    this.b.a(paramComment, new CommentsPresenter.2(this));
  }
  
  public void b()
  {
    CommentsView localCommentsView = this.a;
    if (localCommentsView != null) {
      localCommentsView.showLoading();
    }
    this.b.a(this.d, new CommentsPresenter.1(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.b.a(paramComment, new CommentsPresenter.3(this));
  }
  
  public void c()
  {
    this.a = null;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter
 * JD-Core Version:    0.7.0.1
 */