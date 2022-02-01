package com.tencent.securemodule;

import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;

public class z
  implements Runnable
{
  public z(SecureService paramSecureService, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if ("1000010".equals(this.a.getAction()))
      {
        SecureService.b(this.b);
        SecureService.c(this.b);
        SecureService.d(this.b);
        SecureService.e(this.b);
      }
      else if ("1000011".equals(this.a.getAction()))
      {
        SecureService.b(this.b, this.a.getBooleanExtra("key_download_listener", false));
        SecureService.b(this.b, "https://qqwx.qq.com/s?aid=index&p=1&c=107048&vt=1&pf=0");
      }
      if ((!SecureService.f(this.b)) && (SecureService.g(this.b) == 0))
      {
        this.b.stopSelf();
        SecureService.a(this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.b.stopSelf();
      SecureService.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.z
 * JD-Core Version:    0.7.0.1
 */