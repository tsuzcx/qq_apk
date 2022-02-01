package com.tencent.mobileqq.colornote.swipeback;

import com.tencent.qphone.base.util.QLog;

class SwipeBackLayout$1
  implements Runnable
{
  SwipeBackLayout$1(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwipeBackLayout", 2, "isFling:" + this.this$0.c);
    }
    if (!this.this$0.c) {
      this.this$0.g();
    }
    if (SwipeBackLayout.a(this.this$0) != null) {
      SwipeBackLayout.a(this.this$0).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */