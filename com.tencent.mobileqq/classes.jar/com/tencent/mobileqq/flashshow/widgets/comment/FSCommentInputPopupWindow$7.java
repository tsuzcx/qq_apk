package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;

class FSCommentInputPopupWindow$7
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  FSCommentInputPopupWindow$7(FSCommentInputPopupWindow paramFSCommentInputPopupWindow) {}
  
  public void a()
  {
    QLog.d("FSBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (FSCommentInputPopupWindow.g(this.a))
    {
      FSCommentInputPopupWindow.b(this.a, false);
      if (FSCommentInputPopupWindow.h(this.a) != null) {
        FSCommentInputPopupWindow.h(this.a).setVisibility(0);
      }
      if (FSCommentInputPopupWindow.i(this.a) != null) {
        FSCommentInputPopupWindow.i(this.a).setVisibility(0);
      }
    }
    else if (!this.a.m)
    {
      this.a.dismiss();
    }
    this.a.h = false;
  }
  
  public void a(int paramInt)
  {
    QLog.d("FSBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (this.a.e != paramInt)
    {
      FSCommentInputPopupWindow localFSCommentInputPopupWindow = this.a;
      localFSCommentInputPopupWindow.e = paramInt;
      FSCommentInputPopupWindow.f(localFSCommentInputPopupWindow);
      this.a.b.putInt("GroupSoftKeyboardHeight", paramInt);
      this.a.b.commit();
    }
    this.a.f();
    this.a.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */