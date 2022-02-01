package com.tencent.mobileqq.qqexpand.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ExpandManager$13
  implements DialogInterface.OnKeyListener
{
  ExpandManager$13(ExpandManager paramExpandManager, Activity paramActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.13
 * JD-Core Version:    0.7.0.1
 */