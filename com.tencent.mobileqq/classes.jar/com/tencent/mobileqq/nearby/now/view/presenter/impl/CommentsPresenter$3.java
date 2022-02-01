package com.tencent.mobileqq.nearby.now.view.presenter.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.DeleteCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.statistics.ReportController;

class CommentsPresenter$3
  implements CommentsDataSource.DeleteCommentCallback
{
  CommentsPresenter$3(CommentsPresenter paramCommentsPresenter) {}
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (CommentsPresenter.a(this.a) != null)
    {
      if (paramInt == 0)
      {
        CommentsPresenter.a(this.a).removeCommentDirectly(paramComment);
        CommentsPresenter.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131894149));
        ReportController.b(null, "dc02676", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
        return;
      }
      CommentsPresenter.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131894148));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter.3
 * JD-Core Version:    0.7.0.1
 */