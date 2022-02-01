package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

class ReadInJoyCommentListFragment$5
  extends ReadInJoyObserver
{
  ReadInJoyCommentListFragment$5(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(long paramLong, int paramInt)
  {
    if (ReadInJoyCommentListFragment.g(this.a) != null)
    {
      ReadInJoyCommentListFragment.g(this.a).a(paramLong);
      ReadInJoyCommentListFragment.g(this.a).notifyDataSetChanged();
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (ReadInJoyCommentListFragment.g(this.a) != null)
    {
      CommentViewItem localCommentViewItem = ReadInJoyCommentListFragment.g(this.a).a(paramString, ReadInJoyCommentListFragment.i(this.a));
      if (localCommentViewItem != null)
      {
        paramString = ReadinjoyCommentListBaseAdapter.b(ReadinjoyCommentListBaseAdapter.a(paramString));
        ReadInJoyCommentListFragment.g(this.a).a(localCommentViewItem, CommentProteusUtil.a(localCommentViewItem, paramString), 2);
      }
      ReadInJoyCommentListFragment.g(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.5
 * JD-Core Version:    0.7.0.1
 */