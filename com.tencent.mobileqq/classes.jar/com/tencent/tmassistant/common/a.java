package com.tencent.tmassistant.common;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;

class a
  implements Runnable
{
  a(PackageInstallReceiver paramPackageInstallReceiver, String paramString) {}
  
  public void run()
  {
    if (m.b()) {
      return;
    }
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      r.c("PackageInstallReceiver", "halleytest installReport packageName = " + this.a, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.a
 * JD-Core Version:    0.7.0.1
 */