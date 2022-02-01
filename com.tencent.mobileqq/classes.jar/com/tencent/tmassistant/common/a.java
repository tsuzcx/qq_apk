package com.tencent.tmassistant.common;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;

class a
  implements Runnable
{
  a(PackageInstallReceiver paramPackageInstallReceiver, String paramString) {}
  
  public void run()
  {
    if (s.b()) {}
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      ab.c("DLSDK_PackageInstallReceiver", "halleytest installReport packageName = " + this.a, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.a
 * JD-Core Version:    0.7.0.1
 */