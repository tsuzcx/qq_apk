package com.tencent.mobileqq.nearby.now.view.presenter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource.DeleteCommentCallback;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.CommentsView;
import com.tencent.mobileqq.statistics.ReportController;

class CommentsPresenterImpl$3
  implements CommentsDataSource.DeleteCommentCallback
{
  CommentsPresenterImpl$3(CommentsPresenterImpl paramCommentsPresenterImpl) {}
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (CommentsPresenterImpl.a(this.a) != null)
    {
      if (paramInt == 0)
      {
        CommentsPresenterImpl.a(this.a).b(paramComment);
        CommentsPresenterImpl.a(this.a).a(BaseApplicationImpl.getApplication().getString(2131696358));
        ReportController.b(null, "dc02676", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    CommentsPresenterImpl.a(this.a).a(BaseApplicationImpl.getApplication().getString(2131696357));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl.3
 * JD-Core Version:    0.7.0.1
 */