package com.tencent.mtt.hippy.a;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mtt.hippy.utils.LogUtils;

class e$1
  implements MessageQueue.IdleHandler
{
  e$1(e parame) {}
  
  public boolean queueIdle()
  {
    boolean bool = this.a.requestFocusFromTouch();
    LogUtils.d("requestFocus", "requestFocusFromTouch result:" + bool);
    if (!bool)
    {
      bool = this.a.requestFocus();
      LogUtils.d("requestFocus", "requestFocus result:" + bool);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.e.1
 * JD-Core Version:    0.7.0.1
 */