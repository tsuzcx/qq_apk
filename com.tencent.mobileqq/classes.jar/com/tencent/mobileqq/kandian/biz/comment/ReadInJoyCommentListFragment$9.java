package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;

class ReadInJoyCommentListFragment$9
  implements GuidePopuppWindow.OnGuideDismissListener
{
  ReadInJoyCommentListFragment$9(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener) {}
  
  public void a(int paramInt)
  {
    if (ReadInJoyCommentListFragment.g(this.b) != null) {
      ReadInJoyCommentListFragment.g(this.b).c();
    }
    GuidePopuppWindow.OnGuideDismissListener localOnGuideDismissListener = this.a;
    if (localOnGuideDismissListener != null) {
      localOnGuideDismissListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.9
 * JD-Core Version:    0.7.0.1
 */