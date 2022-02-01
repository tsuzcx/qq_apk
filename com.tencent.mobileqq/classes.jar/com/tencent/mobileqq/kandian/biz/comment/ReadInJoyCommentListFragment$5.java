package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

class ReadInJoyCommentListFragment$5
  extends ReadInJoyObserver
{
  ReadInJoyCommentListFragment$5(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      paramString = ReadInJoyCommentListFragment.a(this.a).a(paramString, ReadInJoyCommentListFragment.a(this.a));
      if (paramString != null) {
        ReadInJoyCommentListFragment.a(this.a).a(paramString, CommentProteusUtil.a(paramString, 0), 2);
      }
      ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void aE_()
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null) {
      ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.5
 * JD-Core Version:    0.7.0.1
 */