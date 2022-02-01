package com.tencent.timi.game.liveroom.impl.notice;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class TimiNoticeEditFragment$2
  implements Runnable
{
  TimiNoticeEditFragment$2(TimiNoticeEditFragment paramTimiNoticeEditFragment) {}
  
  public void run()
  {
    ((InputMethodManager)TimiNoticeEditFragment.a(this.this$0).getContext().getSystemService("input_method")).showSoftInput(TimiNoticeEditFragment.a(this.this$0), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeEditFragment.2
 * JD-Core Version:    0.7.0.1
 */