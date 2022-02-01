package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReadInjoyXRecyclerView$1
  extends Handler
{
  ReadInjoyXRecyclerView$1(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == ReadInjoyXRecyclerView.b) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */