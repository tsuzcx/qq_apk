package com.tencent.mobileqq.flashshow.widgets.comment;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.CommentEditText.OnInputBackListener;
import java.lang.ref.WeakReference;

class FSBaseInputPopupWindow$1
  implements CommentEditText.OnInputBackListener
{
  FSBaseInputPopupWindow$1(FSBaseInputPopupWindow paramFSBaseInputPopupWindow) {}
  
  public void a(View paramView)
  {
    if ((this.a.isShowing()) && ((FSBaseInputPopupWindow.a(this.a).get() instanceof Activity))) {
      ((Activity)FSBaseInputPopupWindow.b(this.a).get()).runOnUiThread(new FSBaseInputPopupWindow.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */