package com.tencent.mobileqq.mini.out.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;

class PermissionSettingFragment$4
  implements DialogInterface.OnClickListener
{
  PermissionSettingFragment$4(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PermissionSettingFragment.access$300(this.this$0).changeChecked(this.val$scopeName, this.val$isChecked);
    this.this$0.authorizeCenter.setAuthorize(this.val$scopeName, this.val$isChecked, this.val$authorizeResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */