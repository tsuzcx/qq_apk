package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.app.BaseActivity;

class AuthorityControlFragment$4
  implements DialogInterface.OnCancelListener
{
  AuthorityControlFragment$4(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.getBaseActivity();
    if (paramDialogInterface != null) {
      paramDialogInterface.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.4
 * JD-Core Version:    0.7.0.1
 */