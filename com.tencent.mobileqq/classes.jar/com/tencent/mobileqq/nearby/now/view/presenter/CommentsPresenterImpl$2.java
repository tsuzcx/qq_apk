package com.tencent.mobileqq.nearby.now.view.presenter;

import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.PublishCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.qphone.base.util.QLog;

class CommentsPresenterImpl$2
  implements CommentsDataSource.PublishCommentCallback
{
  CommentsPresenterImpl$2(CommentsPresenterImpl paramCommentsPresenterImpl) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      CommentsPresenterImpl.a(this.a).a(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      CommentsPresenterImpl.a(this.a).a(paramComment, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onDataNotAvailable, code=" + paramInt + ", tip=" + paramString + ", comment=" + paramComment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl.2
 * JD-Core Version:    0.7.0.1
 */