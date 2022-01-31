package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;

class ScrollLayout$1
  extends Handler
{
  ScrollLayout$1(ScrollLayout paramScrollLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int j = Integer.parseInt(paramMessage.obj.toString());
    this.this$0.getChildAt(i);
    this.this$0.changeAlpha(this.this$0.getChildAt(i), false, j);
    if (i > 0) {
      this.this$0.changeAlpha(this.this$0.getChildAt(i - 1), true, j);
    }
    if (i < this.this$0.getChildCount() - 1) {
      this.this$0.changeAlpha(this.this$0.getChildAt(i + 1), true, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ScrollLayout.1
 * JD-Core Version:    0.7.0.1
 */