package com.tencent.qmsp.sdk.g.b;

import android.text.TextUtils;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.f;

class c$a
  implements Runnable
{
  c$a(c paramc) {}
  
  public void run()
  {
    try
    {
      a.a locala = a.a(c.a(this.a));
      c.a(this.a, locala.a());
      locala.b();
      if (!TextUtils.isEmpty(c.b(this.a))) {
        c.a(this.a, true);
      }
      if (c.d(this.a) != null)
      {
        c.d(this.a).onResult(c.c(this.a), c.b(this.a, f.a(c.a(this.a))), c.b(this.a));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (TextUtils.isEmpty(c.b(this.a))) {
        c.a(this.a, false);
      }
      if (c.d(this.a) != null)
      {
        IVendorCallback localIVendorCallback = c.d(this.a);
        boolean bool = c.c(this.a);
        c localc = this.a;
        localIVendorCallback.onResult(bool, c.b(localc, f.a(c.a(localc))), c.b(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.c.a
 * JD-Core Version:    0.7.0.1
 */