package com.tencent.mobileqq.colornote.swipeback;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class SwipeBackLayout$SwipeLayoutHandler
  extends Handler
{
  private WeakReference<SwipeBackLayout> a;
  
  SwipeBackLayout$SwipeLayoutHandler(SwipeBackLayout paramSwipeBackLayout)
  {
    this.a = new WeakReference(paramSwipeBackLayout);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SwipeBackLayout localSwipeBackLayout = (SwipeBackLayout)this.a.get();
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
      } while (SwipeBackLayout.a(localSwipeBackLayout));
      SwipeBackLayout.a(localSwipeBackLayout, true);
    } while (!(localSwipeBackLayout.a instanceof Activity));
    if (QLog.isColorLevel()) {
      QLog.d("SwipeBackLayout", 2, "SwipeBackLayout finish()");
    }
    localSwipeBackLayout.c = true;
    ((Activity)localSwipeBackLayout.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout.SwipeLayoutHandler
 * JD-Core Version:    0.7.0.1
 */