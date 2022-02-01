package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.XWalkV8;

public class i
  implements IJsRuntime
{
  XWalkV8 a;
  private HandlerThread b = new HandlerThread("j2v8");
  private Handler c;
  
  public i()
  {
    this.b.start();
    this.c = new Handler(this.b.getLooper());
  }
  
  public void a(int paramInt)
  {
    this.c.post(new i.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */