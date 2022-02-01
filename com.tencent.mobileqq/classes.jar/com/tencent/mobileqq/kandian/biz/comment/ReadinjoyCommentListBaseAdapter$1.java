package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadinjoyCommentListBaseAdapter$1
  implements AbsListView.OnScrollListener
{
  ReadinjoyCommentListBaseAdapter$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.q != null)
    {
      paramInt1 = ReadinjoyCommentListBaseAdapter.a(this.a, paramInt1);
      this.a.q.onScroll(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */