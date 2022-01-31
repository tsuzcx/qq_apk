package com.tencent.qqmini.sdk.core.auth.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.core.auth.AuthState;

class PermissionSettingFragment$3
  implements DialogInterface.OnClickListener
{
  PermissionSettingFragment$3(PermissionSettingFragment paramPermissionSettingFragment, String paramString, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PermissionSettingFragment.access$300(this.this$0).changeChecked(this.val$scopeName, this.val$isChecked);
    this.this$0.authState.setAuthState(this.val$scopeName, this.val$isChecked);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */