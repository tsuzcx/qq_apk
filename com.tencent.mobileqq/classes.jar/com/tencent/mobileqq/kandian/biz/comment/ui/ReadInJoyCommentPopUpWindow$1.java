package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;

class ReadInJoyCommentPopUpWindow$1
  implements PopupWindow.OnDismissListener
{
  public void onDismiss()
  {
    ReadInJoyCommentPopUpWindow.a(this.a);
    if (ReadInJoyCommentPopUpWindow.b(this.a) != null) {
      ReadInJoyCommentPopUpWindow.b(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentPopUpWindow.1
 * JD-Core Version:    0.7.0.1
 */