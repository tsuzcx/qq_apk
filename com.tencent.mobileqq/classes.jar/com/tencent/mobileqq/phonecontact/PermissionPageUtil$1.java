package com.tencent.mobileqq.phonecontact;

import android.os.Build;

class PermissionPageUtil$1
  implements Runnable
{
  PermissionPageUtil$1(PermissionPageUtil paramPermissionPageUtil) {}
  
  public void run()
  {
    String str = null;
    if ("Xiaomi".equals(Build.MANUFACTURER)) {
      str = PermissionPageUtil.a();
    }
    PermissionPageUtil.a(String.format("PermissionPageUtil init [%s, %s]", new Object[] { Build.MANUFACTURER, str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.PermissionPageUtil.1
 * JD-Core Version:    0.7.0.1
 */