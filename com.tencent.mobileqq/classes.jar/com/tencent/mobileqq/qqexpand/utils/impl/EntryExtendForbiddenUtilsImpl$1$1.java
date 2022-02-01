package com.tencent.mobileqq.qqexpand.utils.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class EntryExtendForbiddenUtilsImpl$1$1
  implements DialogInterface.OnKeyListener
{
  EntryExtendForbiddenUtilsImpl$1$1(EntryExtendForbiddenUtilsImpl.1 param1) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.this$0.qqDialog.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl.1.1
 * JD-Core Version:    0.7.0.1
 */