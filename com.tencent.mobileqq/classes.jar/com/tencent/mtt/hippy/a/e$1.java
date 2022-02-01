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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFocusFromTouch result:");
    localStringBuilder.append(bool);
    LogUtils.d("requestFocus", localStringBuilder.toString());
    if (!bool)
    {
      bool = this.a.requestFocus();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestFocus result:");
      localStringBuilder.append(bool);
      LogUtils.d("requestFocus", localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.e.1
 * JD-Core Version:    0.7.0.1
 */