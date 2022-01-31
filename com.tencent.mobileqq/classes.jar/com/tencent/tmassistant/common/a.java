package com.tencent.tmassistant.common;

import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;

class a
  implements Runnable
{
  a(PackageInstallReceiver paramPackageInstallReceiver, String paramString) {}
  
  public void run()
  {
    if (t.b()) {}
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      ac.c("DLSDK_PackageInstallReceiver", "halleytest installReport packageName = " + this.a, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.common.a
 * JD-Core Version:    0.7.0.1
 */