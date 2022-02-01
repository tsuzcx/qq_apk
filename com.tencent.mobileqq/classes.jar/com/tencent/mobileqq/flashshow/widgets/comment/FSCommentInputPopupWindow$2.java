package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class FSCommentInputPopupWindow$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FSCommentInputPopupWindow$2(FSCommentInputPopupWindow paramFSCommentInputPopupWindow, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = this.a.getMeasuredHeight();
    QLog.d("FSBaseInputPopupWindow", 1, new Object[] { "onGlobalLayout input box height: ", Integer.valueOf(i), " | key board height: ", Integer.valueOf(this.b.e) });
    FSCommentInputPopupWindow localFSCommentInputPopupWindow = this.b;
    FSCommentInputPopupWindow.a(localFSCommentInputPopupWindow, localFSCommentInputPopupWindow.e, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */