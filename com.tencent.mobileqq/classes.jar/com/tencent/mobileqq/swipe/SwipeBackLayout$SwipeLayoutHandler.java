package com.tencent.mobileqq.swipe;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class SwipeBackLayout$SwipeLayoutHandler
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
    if (paramMessage.what != 1)
    {
      super.handleMessage(paramMessage);
      return;
    }
    if (!SwipeBackLayout.access$000(localSwipeBackLayout))
    {
      SwipeBackLayout.access$002(localSwipeBackLayout, true);
      if ((localSwipeBackLayout.mContext instanceof Activity))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwipeBackLayout", 2, "SwipeBackLayout finish()");
        }
        localSwipeBackLayout.isFling = true;
        ((Activity)localSwipeBackLayout.mContext).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.SwipeBackLayout.SwipeLayoutHandler
 * JD-Core Version:    0.7.0.1
 */