package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoySecondCommentListFragment$2
  implements AbsListView.OnScrollListener
{
  ReadInJoySecondCommentListFragment$2(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    if ((ReadInJoySecondCommentListFragment.a(this.a) != null) && (ReadInJoySecondCommentListFragment.a(this.a).q() != null)) {
      ReadInJoySecondCommentListFragment.a(this.a).q().a(ReadInJoySecondCommentListFragment.b(this.a).getFirstVisiblePosition(), ReadInJoySecondCommentListFragment.b(this.a).getLastVisiblePosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment.2
 * JD-Core Version:    0.7.0.1
 */