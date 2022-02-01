package com.tencent.mobileqq.kandian.biz.comment.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ReadInJoyCommentEntrance$2
  implements DialogInterface.OnDismissListener
{
  ReadInJoyCommentEntrance$2(ReadInJoyCommentEntrance paramReadInJoyCommentEntrance, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance.2
 * JD-Core Version:    0.7.0.1
 */