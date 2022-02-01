package com.tencent.mtt.hippy.bridge;

import android.os.Message;

public class NativeCallback$a
  implements Runnable
{
  private final long a;
  private final NativeCallback b;
  private Message c;
  private String d;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.NativeCallback.a
 * JD-Core Version:    0.7.0.1
 */