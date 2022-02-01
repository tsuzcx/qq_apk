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
    LogUtils.e("Callback OK", paramLong + "");
    if (this.mHandler != null)
    {
      NativeCallback.a locala = new NativeCallback.a(this, paramLong, this.mMsg, this.mAction);
      this.mHandler.post(locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.NativeCallback
 * JD-Core Version:    0.7.0.1
 */