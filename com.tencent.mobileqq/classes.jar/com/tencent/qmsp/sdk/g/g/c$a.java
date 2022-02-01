package com.tencent.qmsp.sdk.g.g;

import com.tencent.qmsp.sdk.base.IVendorCallback;

class c$a
  implements Runnable
{
  c$a(c paramc) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      if (c.a(this.a) != null)
      {
        c.a(this.a).onResult(b.a(), b.a(c.b(this.a)), b.b(c.b(this.a)));
        return;
      }
    }
    catch (Exception localException)
    {
      if (c.a(this.a) != null) {
        c.a(this.a).onResult(false, null, null);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.c.a
 * JD-Core Version:    0.7.0.1
 */