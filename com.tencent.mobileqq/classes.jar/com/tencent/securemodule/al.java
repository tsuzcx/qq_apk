package com.tencent.securemodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.securemodule.ui.TransparentActivity;

public class al
  implements DialogInterface.OnCancelListener
{
  public al(TransparentActivity paramTransparentActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.al
 * JD-Core Version:    0.7.0.1
 */