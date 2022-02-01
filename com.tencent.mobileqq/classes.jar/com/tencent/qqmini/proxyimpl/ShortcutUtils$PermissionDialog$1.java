package com.tencent.qqmini.proxyimpl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class ShortcutUtils$PermissionDialog$1
  implements View.OnClickListener
{
  ShortcutUtils$PermissionDialog$1(ShortcutUtils.PermissionDialog paramPermissionDialog) {}
  
  public void onClick(View paramView)
  {
    ShortcutUtils.PermissionDialog.a(this.a).setChecked(ShortcutUtils.PermissionDialog.a(this.a).isChecked() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.PermissionDialog.1
 * JD-Core Version:    0.7.0.1
 */