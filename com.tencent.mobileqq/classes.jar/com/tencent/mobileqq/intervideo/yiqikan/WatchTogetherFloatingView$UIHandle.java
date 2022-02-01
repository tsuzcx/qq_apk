package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class WatchTogetherFloatingView$UIHandle
  extends Handler
{
  WeakReference<WatchTogetherFloatingView> a;
  
  public WatchTogetherFloatingView$UIHandle(WatchTogetherFloatingView paramWatchTogetherFloatingView)
  {
    this.a = new WeakReference(paramWatchTogetherFloatingView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        removeMessages(2);
        return;
      }
    }
    try
    {
      ((WatchTogetherFloatingView)this.a.get()).a();
      return;
    }
    catch (NullPointerException paramMessage)
    {
      label41:
      break label41;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("WatchTogetherFloatingView", 2, "MESSAGE_WAIT_LOADING END, but View missing");
      return;
      sendEmptyMessageDelayed(2, 20000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView.UIHandle
 * JD-Core Version:    0.7.0.1
 */