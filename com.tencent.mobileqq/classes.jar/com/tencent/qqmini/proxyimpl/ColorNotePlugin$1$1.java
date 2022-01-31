package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import aobw;
import com.tencent.qqmini.sdk.log.QMLog;

class ColorNotePlugin$1$1
  implements DialogInterface.OnClickListener
{
  ColorNotePlugin$1$1(ColorNotePlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      this.this$1.val$finalColorNoteController.e();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QMLog.e("ColorNotePlugin", "show modalView error." + paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1.1
 * JD-Core Version:    0.7.0.1
 */