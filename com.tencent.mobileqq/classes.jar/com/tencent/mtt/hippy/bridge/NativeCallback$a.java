package com.tencent.mtt.hippy.bridge;

import android.os.Message;

public class NativeCallback$a
  implements Runnable
{
  private long a;
  private NativeCallback b;
  private Message c = null;
  private String d = null;
  
  public NativeCallback$a(NativeCallback paramNativeCallback, long paramLong, Message paramMessage, String paramString)
  {
    this.a = paramLong;
    this.b = paramNativeCallback;
    this.c = paramMessage;
    this.d = paramString;
  }
  
  public void run()
  {
    this.b.Call(this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.NativeCallback.a
 * JD-Core Version:    0.7.0.1
 */