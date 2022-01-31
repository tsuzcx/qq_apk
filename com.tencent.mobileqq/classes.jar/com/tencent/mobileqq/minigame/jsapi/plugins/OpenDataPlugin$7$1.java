package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$7$1
  implements DialogInterface.OnClickListener
{
  OpenDataPlugin$7$1(OpenDataPlugin.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataPlugin", "NegativeButton onClick error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("NegativeButton onClick error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */