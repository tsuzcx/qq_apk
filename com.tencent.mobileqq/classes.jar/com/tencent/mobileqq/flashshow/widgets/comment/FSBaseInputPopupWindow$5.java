package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

class FSBaseInputPopupWindow$5
  implements Runnable
{
  FSBaseInputPopupWindow$5(FSBaseInputPopupWindow paramFSBaseInputPopupWindow, View paramView) {}
  
  public void run()
  {
    FSBaseInputPopupWindow.c(this.this$0).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */