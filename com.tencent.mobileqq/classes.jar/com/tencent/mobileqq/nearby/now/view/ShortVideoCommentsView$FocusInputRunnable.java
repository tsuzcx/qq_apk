package com.tencent.mobileqq.nearby.now.view;

import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ShortVideoCommentsView$FocusInputRunnable
  implements Runnable
{
  long a;
  
  ShortVideoCommentsView$FocusInputRunnable(ShortVideoCommentsView paramShortVideoCommentsView, long paramLong)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    if (System.currentTimeMillis() - this.a > 1000L) {
      return;
    }
    ShortVideoCommentsView.a(this.this$0).setFocusable(true);
    ShortVideoCommentsView.a(this.this$0).setFocusableInTouchMode(true);
    ShortVideoCommentsView.a(this.this$0).requestFocus();
    ThreadManager.getUIHandler().postDelayed(this, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.FocusInputRunnable
 * JD-Core Version:    0.7.0.1
 */