package com.tencent.mobileqq.extendfriend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;

final class ExtendFriendManager$13
  implements DialogInterface.OnKeyListener
{
  ExtendFriendManager$13(BaseActivity paramBaseActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface.dismiss();
      this.a.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.13
 * JD-Core Version:    0.7.0.1
 */