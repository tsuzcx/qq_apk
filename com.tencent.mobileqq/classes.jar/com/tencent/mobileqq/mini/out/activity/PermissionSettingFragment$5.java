package com.tencent.mobileqq.mini.out.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;

class PermissionSettingFragment$5
  implements DialogInterface.OnClickListener
{
  PermissionSettingFragment$5(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PermissionSettingFragment.access$300(this.this$0).changeChecked(this.val$scopeName, this.val$isChecked);
    this.this$0.authorizeCenter.setAuthorize(this.val$scopeName, this.val$isChecked, this.val$authorizeResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */