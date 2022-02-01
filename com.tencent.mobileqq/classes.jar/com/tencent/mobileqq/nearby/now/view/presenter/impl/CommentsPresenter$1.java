package com.tencent.mobileqq.nearby.now.view.presenter.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.LoadCommentsCallback;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.view.CommentsView;

class CommentsPresenter$1
  implements CommentsDataSource.LoadCommentsCallback
{
  CommentsPresenter$1(CommentsPresenter paramCommentsPresenter) {}
  
  public void a()
  {
    if (CommentsPresenter.a(this.a) != null)
    {
      CommentsPresenter.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131894152));
      CommentsPresenter.a(this.a).hideLoading();
      CommentsPresenter.a(this.a).showBadNetworkConnection();
    }
  }
  
  public void a(Comments paramComments)
  {
    if (CommentsPresenter.a(this.a) != null)
    {
      CommentsPresenter.b(this.a);
      CommentsPresenter.a(this.a).showDataInView(paramComments);
      CommentsPresenter.a(this.a).hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter.1
 * JD-Core Version:    0.7.0.1
 */