package com.tencent.mobileqq.swipe;

import com.tencent.qphone.base.util.QLog;

class SwipeBackLayout$1
  implements Runnable
{
  SwipeBackLayout$1(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFling:");
      localStringBuilder.append(this.this$0.isFling);
      QLog.d("SwipeBackLayout", 2, localStringBuilder.toString());
    }
    if (!this.this$0.isFling) {
      this.this$0.scrollOrigin();
    }
    if (SwipeBackLayout.access$100(this.this$0) != null) {
      SwipeBackLayout.access$100(this.this$0).onSwipe(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.SwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */