package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

final class f
  implements Runnable
{
  f(e parame, String paramString) {}
  
  public final void run()
  {
    if (e.a(this.b) == null) {
      return;
    }
    if ((!TextUtils.isEmpty(this.a)) && (z.a(e.a(this.b), e.a(this.b).getPackageName(), this.a))) {
      this.b.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.f
 * JD-Core Version:    0.7.0.1
 */