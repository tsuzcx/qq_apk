package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;

class AuthorityControlFragment$3
  implements DialogInterface.OnCancelListener
{
  AuthorityControlFragment$3(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.getActivity();
    if (paramDialogInterface != null) {
      paramDialogInterface.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.3
 * JD-Core Version:    0.7.0.1
 */