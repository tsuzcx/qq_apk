package com.tencent.securemodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.securemodule.ui.TransparentActivity;

public class ao
  implements DialogInterface.OnCancelListener
{
  public ao(TransparentActivity paramTransparentActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.ao
 * JD-Core Version:    0.7.0.1
 */