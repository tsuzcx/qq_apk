package com.tencent.qqmini.proxyimpl;

import ajyc;
import android.app.Activity;

final class ShortcutUtils$4
  implements Runnable
{
  ShortcutUtils$4(Activity paramActivity) {}
  
  public void run()
  {
    if (ShortcutUtils.PermissionDialog.canShowDialog()) {
      ShortcutUtils.PermissionDialog.createPermissionDialog(this.val$activity, ajyc.a(2131714012), ajyc.a(2131714018), ajyc.a(2131713999), new ShortcutUtils.4.1(this), new ShortcutUtils.4.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.4
 * JD-Core Version:    0.7.0.1
 */