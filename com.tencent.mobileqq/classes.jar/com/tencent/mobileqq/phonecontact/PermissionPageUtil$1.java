package com.tencent.mobileqq.phonecontact;

import android.os.Build;
import awdq;

public class PermissionPageUtil$1
  implements Runnable
{
  public PermissionPageUtil$1(awdq paramawdq) {}
  
  public void run()
  {
    String str = null;
    if ("Xiaomi".equals(Build.MANUFACTURER)) {
      str = awdq.a();
    }
    awdq.a(String.format("PermissionPageUtil init [%s, %s]", new Object[] { Build.MANUFACTURER, str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.PermissionPageUtil.1
 * JD-Core Version:    0.7.0.1
 */