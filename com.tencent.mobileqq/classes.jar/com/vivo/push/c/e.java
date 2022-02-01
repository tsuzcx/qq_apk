package com.vivo.push.c;

import android.text.TextUtils;
import com.vivo.push.b.i;
import com.vivo.push.sdk.PushMessageCallback;

final class e
  implements Runnable
{
  e(d paramd, String paramString, i parami) {}
  
  public final void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      this.c.b.onReceiveRegId(d.a(this.c), this.a);
    }
    this.c.b.onBind(d.b(this.c), this.b.h(), this.b.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.e
 * JD-Core Version:    0.7.0.1
 */