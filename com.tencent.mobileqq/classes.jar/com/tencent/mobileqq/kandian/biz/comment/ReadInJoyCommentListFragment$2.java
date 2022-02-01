package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoyCommentListFragment$2
  implements AbsListView.OnScrollListener
{
  ReadInJoyCommentListFragment$2(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      if (!ReadInJoyCommentListFragment.a(this.a).a().a().a()) {
        ((ReadInJoyCommentListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      } else {
        ((ReadInJoyCommentListView)paramAbsListView).hideFooterView();
      }
      if ((ReadInJoyCommentListFragment.a(this.a) != null) && (ReadInJoyCommentListFragment.a(this.a).a() != null)) {
        ReadInJoyCommentListFragment.a(this.a).a().a(ReadInJoyCommentListFragment.a(this.a).getFirstVisiblePosition(), ReadInJoyCommentListFragment.a(this.a).getLastVisiblePosition());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.2
 * JD-Core Version:    0.7.0.1
 */