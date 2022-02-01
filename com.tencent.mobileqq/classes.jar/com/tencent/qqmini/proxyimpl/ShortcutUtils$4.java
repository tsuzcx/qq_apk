package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;

final class ShortcutUtils$4
  implements Runnable
{
  ShortcutUtils$4(Activity paramActivity) {}
  
  public void run()
  {
    if (ShortcutUtils.PermissionDialog.a()) {
      ShortcutUtils.PermissionDialog.a(this.a, HardCodeUtil.a(2131911425), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131911412), new ShortcutUtils.4.1(this), new ShortcutUtils.4.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.4
 * JD-Core Version:    0.7.0.1
 */