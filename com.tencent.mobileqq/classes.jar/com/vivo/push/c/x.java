package com.vivo.push.c;

import com.vivo.push.b.r;
import com.vivo.push.sdk.PushMessageCallback;

final class x
  implements Runnable
{
  x(w paramw, r paramr) {}
  
  public final void run()
  {
    this.b.b.onPublish(w.a(this.b), this.a.h(), this.a.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.x
 * JD-Core Version:    0.7.0.1
 */