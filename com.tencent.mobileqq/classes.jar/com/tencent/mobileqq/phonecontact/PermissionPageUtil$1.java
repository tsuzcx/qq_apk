package com.tencent.mobileqq.phonecontact;

import android.os.Build;
import aumh;

public class PermissionPageUtil$1
  implements Runnable
{
  public PermissionPageUtil$1(aumh paramaumh) {}
  
  public void run()
  {
    String str = null;
    if ("Xiaomi".equals(Build.MANUFACTURER)) {
      str = aumh.a();
    }
    aumh.a(String.format("PermissionPageUtil init [%s, %s]", new Object[] { Build.MANUFACTURER, str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.PermissionPageUtil.1
 * JD-Core Version:    0.7.0.1
 */