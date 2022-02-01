package com.tencent.mobileqq.extendfriend.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

class ExtendFriendFragment$11
  implements DialogInterface.OnKeyListener
{
  ExtendFriendFragment$11(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface.dismiss();
      ExtendFriendFragment.a(this.a).finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.11
 * JD-Core Version:    0.7.0.1
 */