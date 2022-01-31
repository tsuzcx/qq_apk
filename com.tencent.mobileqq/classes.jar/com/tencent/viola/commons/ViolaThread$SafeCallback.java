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
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.mCallback != null) {
        bool1 = this.mCallback.handleMessage(paramMessage);
      }
      return bool1;
    }
    catch (Throwable paramMessage)
    {
      do
      {
        bool1 = bool2;
      } while (!ViolaEnvironment.isDebugable());
      ViolaLogUtils.e("SafeCallback", "SafeCallback handleMessage throw expection:" + paramMessage.getMessage());
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.commons.ViolaThread.SafeCallback
 * JD-Core Version:    0.7.0.1
 */