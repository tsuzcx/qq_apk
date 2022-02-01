package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CommentsAdapter$2
  implements View.OnClickListener
{
  CommentsAdapter$2(CommentsAdapter paramCommentsAdapter) {}
  
  public void onClick(View paramView)
  {
    CommentsAdapter.a(this.a).a.clear();
    CommentsAdapter.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter.2
 * JD-Core Version:    0.7.0.1
 */