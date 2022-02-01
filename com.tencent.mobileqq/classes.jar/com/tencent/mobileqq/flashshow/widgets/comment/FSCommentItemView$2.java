package com.tencent.mobileqq.flashshow.widgets.comment;

class FSCommentItemView$2
  implements FSCommentPraiseLayout.OnClickHookListener
{
  FSCommentItemView$2(FSCommentItemView paramFSCommentItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (FSCommentItemView.a(this.a) != null)
    {
      OnCommentElementClickListener localOnCommentElementClickListener = FSCommentItemView.a(this.a);
      FSCommentPraiseLayout localFSCommentPraiseLayout = FSCommentItemView.b(this.a);
      int i;
      if (paramBoolean) {
        i = 14;
      } else {
        i = 15;
      }
      localOnCommentElementClickListener.a(localFSCommentPraiseLayout, i, FSCommentItemView.c(this.a), FSCommentItemView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentItemView.2
 * JD-Core Version:    0.7.0.1
 */