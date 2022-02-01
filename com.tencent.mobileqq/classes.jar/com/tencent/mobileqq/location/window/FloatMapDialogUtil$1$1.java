package com.tencent.mobileqq.location.window;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class FloatMapDialogUtil$1$1
  implements DialogInterface.OnClickListener
{
  FloatMapDialogUtil$1$1(FloatMapDialogUtil.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "");
    paramDialogInterface.quitFloat(3);
    paramDialogInterface.setBadNetOnFloatWindowDialogShown(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapDialogUtil.1.1
 * JD-Core Version:    0.7.0.1
 */