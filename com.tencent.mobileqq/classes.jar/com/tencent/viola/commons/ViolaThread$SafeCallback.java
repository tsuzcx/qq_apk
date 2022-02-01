package com.tencent.viola.commons;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;

class ViolaThread$SafeCallback
  implements Handler.Callback
{
  static final String TAG = "SafeCallback";
  final Handler.Callback mCallback;
  
  ViolaThread$SafeCallback(Handler.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      if (this.mCallback != null)
      {
        boolean bool = this.mCallback.handleMessage(paramMessage);
        return bool;
      }
    }
    catch (Throwable paramMessage)
    {
      if (!ViolaEnvironment.isDebugable()) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SafeCallback handleMessage throw expection:");
      localStringBuilder.append(paramMessage.getMessage());
      ViolaLogUtils.e("SafeCallback", localStringBuilder.toString());
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.commons.ViolaThread.SafeCallback
 * JD-Core Version:    0.7.0.1
 */