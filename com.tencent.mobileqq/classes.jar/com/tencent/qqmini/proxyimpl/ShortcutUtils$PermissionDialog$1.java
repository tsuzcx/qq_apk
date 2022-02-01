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
    paramView = ShortcutUtils.PermissionDialog.a(this.a);
    if (!ShortcutUtils.PermissionDialog.a(this.a).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.PermissionDialog.1
 * JD-Core Version:    0.7.0.1
 */