package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class MiniProgressDialog$2
  implements DialogInterface.OnKeyListener
{
  MiniProgressDialog$2(MiniProgressDialog paramMiniProgressDialog, boolean paramBoolean) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 84) && (paramInt != 4)) {
      return false;
    }
    return this.val$isBlock;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniProgressDialog.2
 * JD-Core Version:    0.7.0.1
 */