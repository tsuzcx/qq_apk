package com.tencent.qqmini.sdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.auth.AuthState;

class PermissionSettingFragment$4
  implements DialogInterface.OnClickListener
{
  PermissionSettingFragment$4(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PermissionSettingFragment.access$300(this.this$0).changeChecked(this.val$scopeName, this.val$isChecked);
    this.this$0.authState.setAuthState(this.val$scopeName, this.val$isChecked);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PermissionSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */