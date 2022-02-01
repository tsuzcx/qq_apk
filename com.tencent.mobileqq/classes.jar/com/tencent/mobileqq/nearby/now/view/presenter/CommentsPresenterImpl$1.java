package com.tencent.mobileqq.nearby.now.view.presenter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.LoadCommentsCallback;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.view.CommentsView;

class CommentsPresenterImpl$1
  implements CommentsDataSource.LoadCommentsCallback
{
  CommentsPresenterImpl$1(CommentsPresenterImpl paramCommentsPresenterImpl) {}
  
  public void a()
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      CommentsPresenterImpl.a(this.a).a(BaseApplicationImpl.getApplication().getString(2131696361));
      CommentsPresenterImpl.a(this.a).b();
      CommentsPresenterImpl.a(this.a).c();
    }
  }
  
  public void a(Comments paramComments)
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      CommentsPresenterImpl.a(this.a);
      CommentsPresenterImpl.a(this.a).a(paramComments);
      CommentsPresenterImpl.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl.1
 * JD-Core Version:    0.7.0.1
 */