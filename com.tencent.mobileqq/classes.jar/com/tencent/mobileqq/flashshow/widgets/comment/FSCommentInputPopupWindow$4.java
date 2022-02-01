package com.tencent.mobileqq.flashshow.widgets.comment;

import android.widget.ImageButton;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.CommentEditText;

class FSCommentInputPopupWindow$4
  implements Runnable
{
  FSCommentInputPopupWindow$4(FSCommentInputPopupWindow paramFSCommentInputPopupWindow) {}
  
  public void run()
  {
    FSCommentInputPopupWindow.b(this.this$0).setVisibility(8);
    FSCommentInputPopupWindow.c(this.this$0).setVisibility(0);
    FSCommentInputPopupWindow.a(this.this$0, true);
    this.this$0.c.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */