package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadinjoyCommentListBaseAdapter$2
  implements ActionSheet.OnButtonClickListener
{
  ReadinjoyCommentListBaseAdapter$2(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = this.c.f();
      if (paramView != null) {
        paramView.a(this.a, this.c.s);
      }
      this.c.notifyDataSetChanged();
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter.2
 * JD-Core Version:    0.7.0.1
 */