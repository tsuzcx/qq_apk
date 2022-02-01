package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import anzj;

final class ShortcutUtils$4
  implements Runnable
{
  ShortcutUtils$4(Activity paramActivity) {}
  
  public void run()
  {
    if (ShortcutUtils.PermissionDialog.canShowDialog()) {
      ShortcutUtils.PermissionDialog.createPermissionDialog(this.val$activity, anzj.a(2131712886), anzj.a(2131712892), anzj.a(2131712873), new ShortcutUtils.4.1(this), new ShortcutUtils.4.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.4
 * JD-Core Version:    0.7.0.1
 */