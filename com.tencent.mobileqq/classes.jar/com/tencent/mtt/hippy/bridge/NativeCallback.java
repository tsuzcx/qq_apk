package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.utils.LogUtils;

public abstract class NativeCallback
{
  private String mAction = null;
  private Handler mHandler;
  private Message mMsg = null;
  
  public NativeCallback(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public NativeCallback(Handler paramHandler, Message paramMessage, String paramString)
  {
    this.mHandler = paramHandler;
    this.mMsg = paramMessage;
    this.mAction = paramString;
  }
  
  public abstract void Call(long paramLong, Message paramMessage, String paramString);
  
  public void Callback(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("");
    LogUtils.e("Callback OK", ((StringBuilder)localObject).toString());
    if (this.mHandler != null)
    {
      localObject = new NativeCallback.a(this, paramLong, this.mMsg, this.mAction);
      this.mHandler.post((Runnable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.NativeCallback
 * JD-Core Version:    0.7.0.1
 */