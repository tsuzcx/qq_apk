package com.tencent.mobileqq.nearby.now.view.presenter.impl;

import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.PublishCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.qphone.base.util.QLog;

class CommentsPresenter$2
  implements CommentsDataSource.PublishCommentCallback
{
  CommentsPresenter$2(CommentsPresenter paramCommentsPresenter) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (CommentsPresenter.a(this.a) != null)
    {
      CommentsPresenter.a(this.a).addCommentInView(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (CommentsPresenter.a(this.a) != null)
    {
      CommentsPresenter.a(this.a).publishCommentFailed(paramComment, paramInt, paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDataNotAvailable, code=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", tip=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", comment=");
        localStringBuilder.append(paramComment);
        QLog.d("nearby.bindphone", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter.2
 * JD-Core Version:    0.7.0.1
 */